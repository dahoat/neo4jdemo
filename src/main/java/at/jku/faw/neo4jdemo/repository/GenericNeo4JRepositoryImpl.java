package at.jku.faw.neo4jdemo.repository;

import at.jku.faw.neo4jdemo.model.neo4j.Type;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericNeo4JRepositoryImpl<T> {
	@Autowired
	protected SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.openSession();
	}


	public T save(T entity) {
		Session session = getSession();
		session.save(entity);
		return entity;
	}
}
