package at.jku.faw.neo4jdemo.model.csv;

import java.util.Objects;

public class CsvPokemon {
	private int id;
	private String identifier;
	private String evolves_from_species_id;
	private int is_legendary;


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



	public int getIs_legendary() {
		return is_legendary;
	}

	public void setIs_legendary(int is_legendary) {
		this.is_legendary = is_legendary;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CsvPokemon pokemon = (CsvPokemon) o;
		return id == pokemon.id && evolves_from_species_id == pokemon.evolves_from_species_id && is_legendary == pokemon.is_legendary && Objects.equals(identifier, pokemon.identifier);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, identifier, evolves_from_species_id, is_legendary);
	}

	public void setEvolves_from_species_id(String evolves_from_species_id) {
		this.evolves_from_species_id = evolves_from_species_id;
	}

	public Integer getEvolvesFromId() {
		if(evolves_from_species_id == null || evolves_from_species_id.equals("")) {
			return null;
		}
		return Integer.valueOf(evolves_from_species_id);
	}

	public boolean isLegendary() {
		return is_legendary == 1;
	}
}
