package at.jku.faw.neo4jdemo.repository;

import at.jku.faw.neo4jdemo.model.csv.CsvPokemon;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CsvPokemonRepositoryImpl extends GenericCsvRepositoryImpl implements CsvPokemonRepository {

	private final List<CsvPokemon> csvPokemon = new ArrayList<>();

	public CsvPokemonRepositoryImpl() throws IOException {
		csvPokemon.addAll(getCsvEntities("data/pokemon_species.csv", CsvPokemon.class));
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
