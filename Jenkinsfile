@Library('jenkins-shared-library') _

pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS = "dockerhub_secret"
    }

    stages {
        stage("Checkout") {
            steps {
                gitCheckout(
                    url: 'https://github.com/Naresh240/springboot-with-jenkins-shared-library.git',
                    branch: 'main'
                )
            }
        }
        stage('Build') {
            steps {
                script {
                    sh "mkdir -p $WORKSPACE/.m2/repository"
                    mavenBuild()
                }
            }
        }
        stage('test') {
            steps {
                script {
                    runUnitTests()
                }
            }
        }
        stage('CodeCoverage') {
            steps {
                script {
                    jacocoReport(
                        execPattern: '**/**.exec',
                        classPattern: '**/classes',
                        sourcePattern: '**/src/main/java'
                    )
                }
            }
        }
        stage('SonarQube Analysis') {
            steps {
                runSonarQubeScanner(
                    sonarServer: 'sonarqube-server', 
                    toolName: 'sonar-scanner'
                )
            }
        }
        stage('Build_Docker_Image') {
            steps {
                withUserCredentials(env.DOCKER_CREDENTIALS) { username, password -> 
                    dockerBuild(
                        dockerUser: "naresh240"
                        imageName: "springboothello", 
                    )
                }
            }
        }
    }
}
