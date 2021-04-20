package at.jku.faw.neo4jdemo.service;

import at.jku.faw.neo4jdemo.model.neo4j.Pokemon;

public interface PokemonService {
	Pokemon getPokemonById(int dexId);

	void importAllPokemon();
}
