package at.jku.faw.neo4jdemo.repository;

import at.jku.faw.neo4jdemo.model.csv.CsvType;

public interface CsvTypeRepository {
	CsvType getType(int id, int slot);
}
