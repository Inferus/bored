openapi-generator-cli generate -i ./bored.yml -g java -o ./generatedClient
./mvnw clean install
java -jar target/bored-0.0.1-SNAPSHOT.jar
