package at.jku.faw.neo4jdemo.service;

import at.jku.faw.neo4jdemo.model.neo4j.Type;

public interface TypeService {
	Type getType(int csvId, int slot);
}
