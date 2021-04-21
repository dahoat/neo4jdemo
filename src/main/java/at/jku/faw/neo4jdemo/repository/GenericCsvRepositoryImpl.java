package at.jku.faw.neo4jdemo.repository;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public abstract class GenericCsvRepositoryImpl {
	protected <T> List<T> getCsvEntities(Resource csvResource, Class<T> entity) throws IOException {
		try(CSVReader reader = new CSVReader(new BufferedReader(new InputStreamReader(csvResource.getInputStream())))) {

			HeaderColumnNameMappingStrategy<T> ms = new HeaderColumnNameMappingStrategy<>();
			ms.setType(entity);

			CsvToBean<T> cb = new CsvToBeanBuilder<T>(reader)
					.withType(entity)
					.withMappingStrategy(ms)
					.withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
					.build();

			return cb.parse();
		}
	}
}
