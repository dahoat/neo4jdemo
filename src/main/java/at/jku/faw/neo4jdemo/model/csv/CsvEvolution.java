package at.jku.faw.neo4jdemo.model.csv;


import java.util.Objects;

public class CsvEvolution {
	private int id;
	private int evolved_species_id;
	private int evolution_trigger_id;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEvolved_species_id() {
		return evolved_species_id;
	}

	public void setEvolved_species_id(int evolved_species_id) {
		this.evolved_species_id = evolved_species_id;
	}

	public int getEvolution_trigger_id() {
		return evolution_trigger_id;
	}

	public void setEvolution_trigger_id(int evolution_trigger_id) {
		this.evolution_trigger_id = evolution_trigger_id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CsvEvolution that = (CsvEvolution) o;
		return id == that.id && evolved_species_id == that.evolved_species_id && evolution_trigger_id == that.evolution_trigger_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, evolved_species_id, evolution_trigger_id);
	}
}
