# Neo4JDemo
This project is used for a lecture at the Johannes Kepler University Linz (JKU) in Austria. 
You are free to use it also if you do not participate in the course. 

---

## Running
ATTENTION: This application tries to create the subfolder 'database' in the working directory. 
If a folder of the same name is already present, the application will abort. 
Otherwise, the folder is deleted on application shutdown.

### Requirements
- Java 21 or above
- A folder without a subdirectory `database` in it

### Running from the console
1. Download the latest release at the releases page https://github.com/dahoat/neo4jdemo/releases
2. Open a cmd/terminal/... and navigate to the JAR file
3. Make sure no subdirectory `database` is present in the current directory
4. Execute `java -jar neo4jdemo-1.2.0.jar`
5. Navigate to http://localhost:8080/
6. When you are finished, click into the console and press [Ctrl]+[C] to shut down the application
7. Cleanup `database` in case of an error. 

### Running from your IDE
Clone the project and set up the Spring Boot Application.  
The Angular project located in the folder 'frontend' is only needed, if you would like to change the website with the examples. 
In that case, you have to use the command `ng build-spring` which will compile the angular project and store the result in 'resources/static' in the Spring project.

### Building
To build the project, use: `mvn package -DskipTests`
This will also trigger a build of the frontend. 


---
