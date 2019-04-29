#execute cucumber scenarios in parallel with specified browser: mvn clean install -DbrowserType="chrome"


#execute scenarios grouped by tags via command line:

#ex: mvn clean install -DbrowserType="chrome" -Dcucumber.options="--tags @ShakeDown"

#ex2: mvn clean install -DbrowserType="chrome" -Dcucumber.options="--tags @TexasRegression"


#view results: target/generated-report/index.html




# This framework runs Cucumber Scenarios in parallel on different threads using TestNG and Maven. The Maven Failsafe plugin is used for this purpose. In TestNG the scenarios are run in parallel, which means all the steps in a scenario will be executed by the same thread. But different scenarios in a single feature file are executed by different threads. In the case of a scenario outline, the rows in an examples table are executed in parallel, each on its own thread.