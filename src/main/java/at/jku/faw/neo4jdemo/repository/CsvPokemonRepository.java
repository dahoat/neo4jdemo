package at.jku.faw.neo4jdemo.repository;

import at.jku.faw.neo4jdemo.model.csv.CsvPokemon;

import java.util.List;

public interface CsvPokemonRepository {
	CsvPokemon getPokemonById(int dexId);

	List<CsvPokemon> getAll();
}
