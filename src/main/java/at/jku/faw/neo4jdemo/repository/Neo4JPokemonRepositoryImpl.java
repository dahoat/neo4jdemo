package at.jku.faw.neo4jdemo.repository;

import at.jku.faw.neo4jdemo.model.neo4j.Pokemon;
import org.neo4j.ogm.session.Session;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class Neo4JPokemonRepositoryImpl extends GenericNeo4JRepositoryImpl<Pokemon> implements Neo4JPokemonRepository {

	@Override
	public Pokemon findByDexId(int dexId) {
		Session session = getSession();
		Map<String, Object> params = new HashMap<>();
		params.put("dexId", dexId);

		return session.queryForObject(Pokemon.class, "MATCH (p:Pokemon{pokedexId: $dexId}) RETURN p", params);
	}
}
