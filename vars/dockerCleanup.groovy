def call(Map stageParams) {
    def command = "docker rmi ${stageParams.dockerUser}/${stageParams.imageName}:${stageParams.imageTag}"
    echo "Executing: ${command}"
    sh command
}
