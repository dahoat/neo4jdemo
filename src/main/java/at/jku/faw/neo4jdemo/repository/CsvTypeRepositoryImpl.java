package at.jku.faw.neo4jdemo.repository;

import at.jku.faw.neo4jdemo.model.csv.CsvType;
import at.jku.faw.neo4jdemo.model.csv.CsvTypeMapping;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class CsvTypeRepositoryImpl extends GenericCsvRepositoryImpl implements CsvTypeRepository {

	private final Set<CsvTypeMapping> typeMappings = new HashSet<>();
	private final Set<CsvType> types = new HashSet<>();

	public CsvTypeRepositoryImpl() throws IOException {
		this.typeMappings.addAll(getCsvEntities("data/pokemon_types.csv", CsvTypeMapping.class));
		this.types.addAll(getCsvEntities("data/types.csv", CsvType.class));
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
