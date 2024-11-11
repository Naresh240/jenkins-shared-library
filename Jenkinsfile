@Library('jenkins-shared-library') _

pipeline {
    agent any
    stages {
        stage("Checkout") {
            steps {
                gitCheckout(
                    url: 'https://github.com/Naresh240/springboot-hello.git',
                    branch: 'main'
                )
            }
        }
        stage('Build') {
            steps {
                script {
                    sh '''
                    mkdir -p ${env.WORKSPACE}/.m2/repository
                    maven.build()
                    '''
                }
            }
        }
    }
}
