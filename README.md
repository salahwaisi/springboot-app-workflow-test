# Kristiania Messenger
Exam in PGR203 by candidate number 1006.

# Setup and development
## Software requirements
This solution is platform-agnostic can and be executed with any preferred IDE or via command line.

* Java 18 SDK (often built-in in the IDE)
* A browser that was installed or updated during the last years
* A IDE such as IntelliJ or Visual Studio are recommended
* Maven SDK (via Homebrew): https://formulae.brew.sh/formula/maven
* Postgres instance ready and configured with database and a user with correct roles

The solution was developed with
* MacOS 13
* IntelliJ IDEA 2023.3.2
* Maven 3.9.0

## Configuration
These next steps requires that your working folder is the root folder of this project from here on.

* Replace the config lines in *src/main/resources/application.properties* (```spring.datasource.url```, ```spring.datasource.username``` and ```spring.datasource.password```) to your running instance of Postgresql

* You are now ready to run the project. If everything is successful, flywaydb should migrate the database tables and it's data for you the first time you start the application.

# Tests