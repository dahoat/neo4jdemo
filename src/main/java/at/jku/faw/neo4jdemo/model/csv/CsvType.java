package at.jku.faw.neo4jdemo.model.csv;

import java.util.Objects;

public class CsvType {
	private int id;
	private String identifier;
	private int generation_id;
	private int damage_class_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public int getGeneration_id() {
		return generation_id;
	}

	public void setGeneration_id(int generation_id) {
		this.generation_id = generation_id;
	}

	public int getDamage_class_id() {
		return damage_class_id;
	}

	public void setDamage_class_id(int damage_class_id) {
		this.damage_class_id = damage_class_id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CsvType csvType = (CsvType) o;
		return id == csvType.id && generation_id == csvType.generation_id && damage_class_id == csvType.damage_class_id && identifier.equals(csvType.identifier);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, identifier, generation_id, damage_class_id);
	}
}
