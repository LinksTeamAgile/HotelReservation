## Important things
- <b>DON'T PUSH/MERGE TO <i>master</i> BRANCH</b>;
- to integrate code: <i>your branch</i>-> pull-request-> <i>alpha</i> [-> refactoring-> pull-request-><i>master</i>];
- make all pull-requests to <i>alpha</i> and wait for a response;
- don't merge a pull-request from a normal branch to <i>master</i>;

## Getting started
- In order to run this project has to be used Eclipse following the next steps:
	1)Import->Git->Projects from Git;
	2)Clone URI;
	3)Follow instructions;
	4)When asked, use import Wizard->Java project;
	5)In the new java project menu, uncheck "use default location", select the git repo location, click finish.
	
## JDBC Drivers
- JDBC drivers are the "sqlite-jdbc-3.8.11.2", you can get it at the next link (https://bitbucket.org/xerial/sqlite-jdbc/downloads/sqlite-jdbc-3.8.11.2.jar).
- To import the library to the the project you have to follow the next steps:
	1)Right click on the java project -> Build Path -> Configure Build Path;
	2)Move to Libraries;
	3)Click on Add External JARs and select the jar file downloaded;
	4)Apply changes.
	
## Configs files
| RESOURCE | PARAM | VALUE |
|------------|-------|------------|
| **res/configs/config.properties** | db_path |/your/path/HotelReservation.sqlite|

## Team Members
- TheRealkam
- gianlucadv
- Apocaliss92
- federica
- albiSan
- davide
- Annalisa
- Antonio
- Dale
