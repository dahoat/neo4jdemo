package at.jku.faw.neo4jdemo.model.neo4j;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

public class Pokemon {

	@Id
	@GeneratedValue
	private Long id;

	private Integer pokedexId;

	private String name;

	@Relationship(value = "HAS_TYPE")
	private Set<TypeRelation> type;

	@Relationship(value = "EVOLVES_TO", direction = Relationship.Direction.INCOMING)
	private Pokemon evolvesTo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPokedexId() {
		return pokedexId;
	}

	public void setPokedexId(Integer pokedexId) {
		this.pokedexId = pokedexId;
	}


	public Set<TypeRelation> getType() {
		return type;
	}

	public void setType(Set<TypeRelation> type) {
		this.type = type;
	}

	public Pokemon getEvolvesTo() {
		return evolvesTo;
	}

	public void setEvolvesTo(Pokemon evolvesTo) {
		this.evolvesTo = evolvesTo;
	}
}
