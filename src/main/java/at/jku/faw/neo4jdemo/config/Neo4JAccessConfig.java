package at.jku.faw.neo4jdemo.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Neo4JAccessConfig {
	@Value("${neo4j.uri}")
	private String neo4jUri;

	@Bean
	public org.neo4j.ogm.config.Configuration getConfiguration() {
		return new org.neo4j.ogm.config.Configuration.Builder()
				.uri(neo4jUri)
				.build();
	}

	@Bean
	public SessionFactory getSessionFactory(org.neo4j.ogm.config.Configuration config) {
		return new SessionFactory( config, "at.jku.faw.neo4jdemo.model.neo4j" );
	}
}
