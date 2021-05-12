Export Neo4J Database to Cypher Script
===

Because the question arose, how to export the database for submission in case you do not want to give us your original queries.

This guide does not work for the embedded Version of Neo4J provided with the Pokemon example. 

In case you did your work in this database, DO NOT TERMINATE THE APPLICATION. In the working directory (the one you placed the neo4jdemo.jar), there is a folder 'database' containing the temporary database files which gets deleted on application termination. Copy this folder to a different location to rescue your database.

# Neo4J Server Community
This guide assumes you use Neo4J Server Community 
https://neo4j.com/download-center/#community

And extracted it somewhere with the folder `neo4j-community-4.2.6` (the version of course differs and reflects the time of writing). 

In case you rescued your database folder from the Pokemon demo, delete `neo4j-community-4.2.6/data`, copy (not move) the folder `database/data` from your backup in its place. 

# Enable APOC library
Copy/Move the file `neo4j-community-4.2.6/labs/apoc-4.2.0.2-core.jar` (version might differ) to `neo4j-community-4.2.6/plugins`

# Enable import/export
Create the file `neo4j-community-4.2.6/conf/apoc.conf` and put the following lines in it:

```
apoc.export.file.enabled=true
apoc.import.file.enabled=true
```

You need the first line, the second line only, if you want to test the import.

# Disable authentication for easier login
**DO NOT DO THIS FOR ANYTHING SLIGHTLY PRODUCTIVE OR ACCESSIBLE FROM SOMEWHERE ELSE THAN YOUR LOCAL MACHINE LISTENING FOR SOMETHING DIFFERENT THAN LOCALHOST.**

Uncomment the line `dbms.security.auth_enabled=false` in `neo4j-community-4.2.6/conf/neo4j.conf`

# Start the database
To start your database again, open the folder `neo4j-community-4.2.6` in a terminal and (depending on your operating system) execute `./bin/neo4j console` (Linux) or `bin\neo4j.bat console` (Windows, not tested)

# Export the database
Export your database by executing
`CALL apoc.export.cypher.all("theFileNameYouWantToUse.cypher")`

The exported file can then be found in `neo4j-community-4.2.6/import/`

Further reference: https://neo4j.com/labs/apoc/4.2/export/
