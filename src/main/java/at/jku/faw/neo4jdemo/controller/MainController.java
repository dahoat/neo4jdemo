package at.jku.faw.neo4jdemo.controller;

import at.jku.faw.neo4jdemo.service.PokemonService;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MainController {

	@Value("classpath:data/map.cypher")
	private Resource sinnohMapQueryResource;

	private final SessionFactory sessionFactory;
	private final PokemonService pokemonService;

	public MainController(SessionFactory sessionFactory, PokemonService pokemonService) {
		this.sessionFactory = sessionFactory;
		this.pokemonService = pokemonService;
	}

	@PostMapping({"/pokemon/load"})
	@ResponseBody
	public Map<String, String> loadPokemon() throws IOException {
		pokemonService.importAllPokemon();
		Map<String, String> result = new HashMap<>();
		result.put("result", "Pokemon imported successfully");
		return result;
	}

	@PostMapping("/sinnoh-map/load")
	public Map<String, String> loadSinnohMap() throws IOException {
		Session session = sessionFactory.openSession();

		try(Reader reader = new InputStreamReader(sinnohMapQueryResource.getInputStream())) {
			String query = FileCopyUtils.copyToString(reader);
			session.query(query, new HashMap<>());

			Map<String, String> result = new HashMap<>();
			result.put("result", "Sinnoh map loaded successfully.");
			return result;
		}
	}

	@DeleteMapping("/database")
	public Map<String, String> clearDatabase() {
		sessionFactory.openSession().purgeDatabase();

		Map<String, String> result = new HashMap<>();
		result.put("result", "Database cleared successfully.");
		return result;
	}


}
