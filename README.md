Mower exercise SEAT:CODE
=====


### Building with Maven

First of all, make sure you have your development environment set up. If you don't, download and install the [Java Development Kit][jdk] and [Maven][maven].  Notice that this project requires JDK 8.

[jdk]: http://www.oracle.com/technetwork/java/javase/downloads/index.html
[maven]: http://maven.apache.org/

#### Compiling

```bash
$ mvn clean compile assembly:single
```

#### Running.

```bash
$ java -jar target/seat-mowers-1.0-SNAPSHOT-jar-with-dependencies.jar -i src/main/resources/input.txt
```
