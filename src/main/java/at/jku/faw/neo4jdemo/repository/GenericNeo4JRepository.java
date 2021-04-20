package at.jku.faw.neo4jdemo.repository;

public interface GenericNeo4JRepository<T> {
	T save(T type);
}
