package at.jku.faw.neo4jdemo.model.csv;

import java.util.Objects;

public class CsvTypeMapping {
	int pokemon_id;
	int type_id;
	int slot;

	public int getPokemon_id() {
		return pokemon_id;
	}

	public void setPokemon_id(int pokemon_id) {
		this.pokemon_id = pokemon_id;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CsvTypeMapping csvType = (CsvTypeMapping) o;
		return pokemon_id == csvType.pokemon_id && type_id == csvType.type_id && slot == csvType.slot;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pokemon_id, type_id, slot);
	}
}
