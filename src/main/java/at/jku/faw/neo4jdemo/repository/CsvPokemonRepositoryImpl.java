package at.jku.faw.neo4jdemo.repository;

import at.jku.faw.neo4jdemo.model.csv.CsvPokemon;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CsvPokemonRepositoryImpl extends GenericCsvRepositoryImpl implements CsvPokemonRepository {

	private final List<CsvPokemon> csvPokemon = new ArrayList<>();

	public CsvPokemonRepositoryImpl(ResourceLoader resourceLoader) throws IOException {
		Resource csvFile = resourceLoader.getResource("classpath:data/pokemon_species.csv");
		csvPokemon.addAll(getCsvEntities(csvFile, CsvPokemon.class));
	}

	@Override
	public CsvPokemon getPokemonById(int dexId) {
		return csvPokemon.stream().filter(p -> p.getId() == dexId).findFirst().orElse(null);
	}

	@Override
	public List<CsvPokemon> getAll() {
		return new ArrayList<>(csvPokemon);
	}
}
