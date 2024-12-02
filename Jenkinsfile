@Library('jenkins-shared-library') _

pipeline {
    
    agent any
    
    parameters {
        string(name: 'DOCKER_USER', defaultValue: '', description: 'Docker Hub username')
        string(name: 'IMAGE_NAME', defaultValue: '', description: 'Docker image name')
        string(name: 'IMAGE_TAG', defaultValue: '', description: 'Docker image tag')
    }

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
        stage('test') {
            steps {
                script {
                    runUnitTests()
                }
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
        stage('Build_Docker_Image') {
            steps {
                withUserCredentials(env.DOCKER_CREDENTIALS) { username, password -> 
                    dockerBuild(
                        dockerUser: params.DOCKER_USER,
                        imageName: params.IMAGE_NAME,
                        imageTag: params.IMAGE_TAG
                    )
                }
            }
        }
        stage("Docker_Image_CleanUp") {
            steps {
                script {
                    dockerCleanup(
                        dockerUser: params.DOCKER_USER,
                        imageName: params.IMAGE_NAME,
                        imageTag: params.IMAGE_TAG
                    )
                }
            }
        }
    }
}