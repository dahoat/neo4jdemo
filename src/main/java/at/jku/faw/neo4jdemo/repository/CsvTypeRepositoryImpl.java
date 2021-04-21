package at.jku.faw.neo4jdemo.repository;

import at.jku.faw.neo4jdemo.model.csv.CsvType;
import at.jku.faw.neo4jdemo.model.csv.CsvTypeMapping;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Repository
public class CsvTypeRepositoryImpl extends GenericCsvRepositoryImpl implements CsvTypeRepository {

	private final Set<CsvTypeMapping> typeMappings = new HashSet<>();
	private final Set<CsvType> types = new HashSet<>();

	public CsvTypeRepositoryImpl(ResourceLoader resourceLoader) throws IOException {
		Resource csvPokemonTypesResource = resourceLoader.getResource("classpath:data/pokemon_types.csv");
		Resource csvTypesResource = resourceLoader.getResource("classpath:data/types.csv");

		this.typeMappings.addAll(getCsvEntities(csvPokemonTypesResource, CsvTypeMapping.class));
		this.types.addAll(getCsvEntities(csvTypesResource, CsvType.class));
	}

	@Override
	public CsvType getType(int id, int slot) {
		CsvTypeMapping mapping = typeMappings.stream().filter(tm -> tm.getPokemon_id() == id && tm.getSlot() == slot).findFirst().orElse(null);
		if(mapping == null) {
			return null;
		}
		return types.stream().filter(t -> t.getId() == mapping.getType_id()).findFirst().orElse(null);
	}
}
