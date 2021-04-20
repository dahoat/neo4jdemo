package at.jku.faw.neo4jdemo.repository;

import at.jku.faw.neo4jdemo.model.neo4j.Type;

public interface Neo4JTypeRepository extends GenericNeo4JRepository<Type> {
	Type findByName(String identifier);

}
