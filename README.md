# HTML search engine for MongoDB
This is simple web application showing use case for [mongodb-search-query-translator](https://github.com/pwszpl/mongodb-search-query-translator).
It has a simple comment mechanism allowing you to add and search comments based on query.

# Usage
## Prerequsites
To build and run you need to install [Docker](https://www.docker.com/) on your workstation.

## Run
You can either import project into any GUI and run `io.github.pwszpl.Application` class, or build project with maven:

        mvn clean package
        java -jar ./target/mongodb-html-search-engine-1.0.jar

Webserver starts at port 8080. To view example just go in your browser to:

        https://localhost:8080/index.html

