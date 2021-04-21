# Neo4JDemo
This project is used for a lecture at the Johannes Kepler University Linz (JKU) in Austria. 
You are free to using it also if you do not participate in the course. 

---

## Running
ATTENTION: This application tries to create the subfolder 'database' in the working directory. 
If a folder of the same name is already present, the application will abort. 
Otherwise, the folder is deleted on application shutdown.

### Requirements
- Java 11 or above
- A folder without 'database' in it

### Running from the console
1. Download the latest release at the releases page https://github.com/dahoat/neo4jdemo/releases
1. Open a cmd/terminal/... and navigate to the JAR file
1. Make sure no directory 'database' is present in the current directory
1. Execute `java --illegal-access=permit -jar neo4jdemo.jar`
1. Navigate to http://localhost:8080/
1. When you are finished, click into the console and press [Ctrl]+[C] to shutdown the application
1. Cleanup 'database' in case of an error. 

### Running from your IDE
Clone the project and set up the Spring Boot Application.  
The Angular project located in the folder 'frontend' is only needed, if you would like to change the website with the examples. 
In that case, you have to use the command `ng build-spring` which will compile the angular project and store the result in 'resources/static' in the Spring project.

---
