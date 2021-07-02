(based on https://github.com/julianjupiter/java-web-app-with-embedded-tomcat)

# Java Web Application with Embedded Tomcat

This is a simple web application in Java with Apache Tomcat and other dependencies embedded in a JAR.
This is used as showcase for [root360 deployments](https://www.root360.de/skalierbares-cloud-deployment/).

# Running the application
```
git clone https://github.com/julianjupiter/java-web-app-with-embedded-tomcat
cd simple-java-web-app
mvn clean package && bash run.sh
```
Open your browser: http://localhost:8080/

# Creating a Release

1. build app
   ```
   git clone https://github.com/julianjupiter/java-web-app-with-embedded-tomcat
   cd simple-java-web-app
   bash release.sh target-version
   # e.g. bash release.sh v1.0.1
   ```
2. upload generated jar file from target/ to Github Releases

# Developing the application

This project used [pre-commit](https://pre-commit.com) to run some code checks on every commit.

1. install pre-commit `pip install pre-commit`
2. activate pre-commit `pre-commit install`
3. commit your changes
