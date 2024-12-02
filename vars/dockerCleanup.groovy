def call(Map stageParams) {
    sh """
        docker rmi $stageParams.dockerUser/$stageParams.imageName:$stageParams.imageTag
        docker rmi $stageParams.dockerUser/$stageParams.imageName:latest
    """
}