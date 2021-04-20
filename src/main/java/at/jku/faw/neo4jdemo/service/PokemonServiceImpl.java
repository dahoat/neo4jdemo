package at.jku.faw.neo4jdemo.service;

import at.jku.faw.neo4jdemo.model.csv.CsvPokemon;
import at.jku.faw.neo4jdemo.model.neo4j.Legendary;
import at.jku.faw.neo4jdemo.model.neo4j.Pokemon;
import at.jku.faw.neo4jdemo.model.neo4j.Type;
import at.jku.faw.neo4jdemo.model.neo4j.TypeRelation;
import at.jku.faw.neo4jdemo.repository.CsvPokemonRepository;
import at.jku.faw.neo4jdemo.repository.Neo4JPokemonRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PokemonServiceImpl implements PokemonService {
	private final CsvPokemonRepository csvPokemonRepository;
	private final Neo4JPokemonRepository neo4JPokemonRepository;
	private final TypeService typeService;

	public PokemonServiceImpl(CsvPokemonRepository csvPokemonRepository, Neo4JPokemonRepository neo4JPokemonRepository, TypeService typeService) {
		this.csvPokemonRepository = csvPokemonRepository;
		this.neo4JPokemonRepository = neo4JPokemonRepository;
		this.typeService = typeService;
	}

	@Override
	public Pokemon getPokemonById(int dexId) {
		Pokemon pokemon = neo4JPokemonRepository.findByDexId(dexId);
		if(pokemon == null) {
			pokemon = buildPokemonByDexId(dexId);
			pokemon = neo4JPokemonRepository.save(pokemon);
		}
		return pokemon;
	}

	@Override
	public void importAllPokemon() {
		List<CsvPokemon> csvPokemon = csvPokemonRepository.getAll();
		csvPokemon.forEach(p -> getPokemonById(p.getId()));
	}

	private Pokemon buildPokemonByDexId(int dexId) {
		CsvPokemon csvPokemon = csvPokemonRepository.getPokemonById(dexId);
		Pokemon pokemon = new Pokemon();

		if(csvPokemon.isLegendary()) {
			pokemon = new Legendary();
		}

		pokemon.setPokedexId(dexId);
		pokemon.setName(csvPokemon.getIdentifier());

		Set<TypeRelation> typeRelations = new HashSet<>();
		addTypes(typeRelations, pokemon, csvPokemon, 1);
		addTypes(typeRelations, pokemon, csvPokemon, 2);
		pokemon.setType(typeRelations);

		Integer evolvesFromId = csvPokemon.getEvolvesFromId();
		if (evolvesFromId != null) {
			Pokemon evolvedPokemon = getPokemonById(evolvesFromId);
			pokemon.setEvolvesTo(evolvedPokemon);
		}

		return pokemon;
	}

	private void addTypes(Set<TypeRelation> typeRelations, Pokemon pokemon, CsvPokemon csvPokemon, int slot) {
		Type type = typeService.getType(csvPokemon.getId(), slot);

		if(type == null) {
			return;
		}

		TypeRelation typeRelation = new TypeRelation();
		typeRelation.setPokemon(pokemon);
		typeRelation.setType(type);
		typeRelation.setSlot(slot);

		typeRelations.add(typeRelation);
	}
}
