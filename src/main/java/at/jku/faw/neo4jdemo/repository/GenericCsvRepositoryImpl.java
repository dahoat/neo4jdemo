package at.jku.faw.neo4jdemo.repository;

import at.jku.faw.neo4jdemo.model.csv.CsvType;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.CsvToBeanFilter;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public abstract class GenericCsvRepositoryImpl {
	private File getCsvFile(String path) throws FileNotFoundException {
		return ResourceUtils.getFile("classpath:" + path);
	}

	protected <T> List<T> getCsvEntities(String csvFilePath, Class<T> entity) throws IOException {
		try(CSVReader reader = new CSVReader(new BufferedReader(new InputStreamReader(new FileInputStream(getCsvFile(csvFilePath)))))) {

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
