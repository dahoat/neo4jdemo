package at.jku.faw.neo4jdemo.repository;

import at.jku.faw.neo4jdemo.model.neo4j.Pokemon;

public interface Neo4JPokemonRepository extends GenericNeo4JRepository<Pokemon> {
	Pokemon findByDexId(int dexId);
}
