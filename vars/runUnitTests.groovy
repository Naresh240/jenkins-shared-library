def call() {
    def mvnCommand = 'mvn -X clean test'
    def exitCode = sh(script: mvnCommand, returnStatus: true)

    if (exitCode != 0) {
        error "Maven test failed with exit code: $exitCode"
    }

    def unitTestReports = '**/target/surefire-reports/*.xml'

    junit unitTestReports
}