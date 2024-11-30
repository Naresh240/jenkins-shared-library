// vars/jacocoReport.groovy
def call(Map config = [:]) {
    // Default configurations
    def execPattern = config.get('execPattern', '**/jacoco.exec')
    def classPattern = config.get('classPattern', '**/classes')
    def sourcePattern = config.get('sourcePattern', '**/src/main/java')

    pipeline {
        stages {
            stage('JaCoCo Report') {
                steps {
                    jacoco(
                        execPattern: execPattern,
                        classPattern: classPattern,
                        sourcePattern: sourcePattern
                    )
                }
            }
        }
        post {
            always {
                jacoco()
            }
        }
    }
}
