def call(String project, String hubUser) {
    sh "docker rmi ${hubUser}/${project}:${env.BUILD_NUMBER}"
    sh "docker rmi ${hubUser}/${project}:latest"
}
