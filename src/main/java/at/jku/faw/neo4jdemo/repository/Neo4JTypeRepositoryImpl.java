package at.jku.faw.neo4jdemo.repository;

import at.jku.faw.neo4jdemo.model.neo4j.Type;
import org.neo4j.ogm.session.Session;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class Neo4JTypeRepositoryImpl extends GenericNeo4JRepositoryImpl<Type> implements Neo4JTypeRepository {
	@Override
	public Type findByName(String name) {
		Session session = getSession();
		Map<String, Object> params = new HashMap<>();
		params.put("name", name);

		return session.queryForObject(Type.class, "MATCH (t:Type{name: $name}) RETURN t", params);
	}



}
