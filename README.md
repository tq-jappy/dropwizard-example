dropwizard-example
==================

An example of [Dropwizard](https://dropwizard.github.io/dropwizard/)

- Java SE 8
- Dropwizard 0.7.0
- Gradle 2.0

## Preconditions

- Set the JAVA_HOME environment vailable to point the JDK8
- Installing Gradle is not required

## Build

```
./gradlew jar
```

## test

```
./gradlew test
```

## Run server

```
java -jar build/libs/dropwizard-example-{version}.jar server setting/example.yml
```

### Access to

- http://localhost:18080/hello
- http://localhost:18080/hello?name=world
- http://localhost:18081/
