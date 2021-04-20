package at.jku.faw.neo4jdemo.service;

import at.jku.faw.neo4jdemo.model.csv.CsvType;
import at.jku.faw.neo4jdemo.model.neo4j.Type;
import at.jku.faw.neo4jdemo.repository.CsvTypeRepository;
import at.jku.faw.neo4jdemo.repository.Neo4JTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {
	private final CsvTypeRepository csvTypeRepository;
	private final Neo4JTypeRepository neo4JTypeRepository;

	public TypeServiceImpl(CsvTypeRepository csvTypeRepository, Neo4JTypeRepository neo4JTypeRepository) {
		this.csvTypeRepository = csvTypeRepository;
		this.neo4JTypeRepository = neo4JTypeRepository;
	}

	@Override
	public Type getType(int csvId, int slot) {
		CsvType csvType = csvTypeRepository.getType(csvId, slot);
		if (csvType == null) {
			return null;
		}

		Type type = neo4JTypeRepository.findByName(csvType.getIdentifier());

		if(type == null) {
			type = new Type();
			type.setName(csvType.getIdentifier());
			type = neo4JTypeRepository.save(type);
		}

		return type;
	}
}
