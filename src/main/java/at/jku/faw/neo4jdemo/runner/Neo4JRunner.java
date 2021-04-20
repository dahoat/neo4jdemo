package at.jku.faw.neo4jdemo.runner;

import org.neo4j.configuration.connectors.BoltConnector;
import org.neo4j.dbms.api.DatabaseManagementService;
import org.neo4j.dbms.api.DatabaseManagementServiceBuilder;
import org.neo4j.graphdb.GraphDatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Stack;

@Component
public class Neo4JRunner implements ApplicationRunner {
	private static final Logger logger = LoggerFactory.getLogger(Neo4JRunner.class);

	private File dbDir;
	private DatabaseManagementService dbms;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		dbDir = new File("database");
		if (!dbDir.exists()) {
			Files.createDirectory(dbDir.toPath());
		}

		logger.warn("Database location is {}", dbDir.toPath().toAbsolutePath());

		dbms = new DatabaseManagementServiceBuilder(dbDir.toPath())
				.setConfig(BoltConnector.enabled, true)
				.build();

		GraphDatabaseService db = dbms.database("neo4j");
		if(db.isAvailable(10*1000)) {
			logger.info("Neo4J is now available.");
		}
		logger.warn("Press [CTRL]+[C] to shutdown.");
	}

	@PreDestroy
	public void onExit() {
		logger.warn("Shutting database down.");
		dbms.shutdown();

		logger.warn("Deleting database directory.");
		try {
			Stack<File> files = new Stack<>();
			files.add(dbDir);

			while (!files.empty()) {
				File file = files.pop();
				if(file.isDirectory()) {
					File[] childFiles = file.listFiles();
					if(childFiles != null && childFiles.length > 0) {
						files.add(file);
						for(File f: childFiles) {
							files.push(f);
						}
					} else {
						Files.deleteIfExists(file.toPath());
					}
				} else {
					Files.deleteIfExists(file.toPath());
				}
			}

		} catch (IOException e) {
			logger.error("Could not cleanup database directory {}: {}", dbDir.getAbsolutePath(), e.getMessage());
		}
	}
}
