#execute cucumber scenarios in parallel with specified browser: mvn clean install -DbrowserType="chrome"


#execute scenarios grouped by tags via command line:

#ex: mvn clean install -DbrowserType="chrome" -Dcucumber.options="--tags @ShakeDown"

#ex2: mvn clean install -DbrowserType="chrome" -Dcucumber.options="--tags @TexasRegression"


#view results: target/generated-report/index.html