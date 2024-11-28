def call() {
    def mvnCommand = 'mvn clean test -X'
    def exitCode = sh(script: mvnCommand, returnStatus: true)

    if (exitCode != 0) {
        error "Maven test failed with exit code: $exitCode"
    }

    def unitTest = "junit '**/target/surefire-reports/*.xml'"
}