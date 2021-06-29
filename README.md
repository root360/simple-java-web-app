(based on https://github.com/julianjupiter/java-web-app-with-embedded-tomcat)

# Java Web Application with Embedded Tomcat

This is a simple web application in Java with Apache Tomcat and other dependencies embedded in a JAR.
This is used as showcase for [root360 deployments](https://www.root360.de/skalierbares-cloud-deployment/).

# Running the application
```
git clone https://github.com/julianjupiter/java-web-app-with-embedded-tomcat
cd simple-java-web-app
mvn clean package && java -jar ./target/java-web-app-with-embedded-tomcat-1.0.0-SNAPSHOT.jar
```
Open your browser: http://localhost:8080/app

# Creating a Release

1. build app
   ```
   git clone https://github.com/julianjupiter/java-web-app-with-embedded-tomcat
   cd simple-java-web-app
   bash release.sh
   ```
2. upload generated jar file to Github Releases
