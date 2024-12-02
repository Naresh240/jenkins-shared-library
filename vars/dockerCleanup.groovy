def call(Map stageParams) {
    sh "docker rmi ${stageParams.dockerUser}/${stageParams.imageName}:${stageParams.imageTag}"
    sh "docker rmi ${stageParams.dockerUser}/${stageParams.imageName}:latest"
}