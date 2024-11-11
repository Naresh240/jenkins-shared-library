def call(Map config = [:]) {
    def sonarServer = config.sonarServer
    def sonarToken = config.sonarToken
    def toolName = config.toolName ?: 'sonar-scanner'

    stage('SonarQube Analysis') {
        withSonarQubeEnv(installationName: sonarServer, credentialsId: sonarToken) {
            // Run SonarScanner
            sh "${tool(toolName)}/bin/sonar-scanner"
        }
    }

    stage('Quality Gate') {
        // Wait for the SonarQube Quality Gate to pass
        timeout(time: 3, unit: 'MINUTES') {
            echo "Initializing quality gates..."
            sh 'sleep 10'
            def result = waitForQualityGate()
            if (result.status != 'OK') {
                error "Pipeline aborted due to quality gate failure: ${result.status}"
            } else {
                echo "Quality gate passed with result: ${result.status}"
            }
        }
    }
}