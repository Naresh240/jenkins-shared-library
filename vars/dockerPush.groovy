def push(Map stageParams) {
    sh """
        docker login -u '$username' -p '$password'
        docker image push $stageParams.dockerUser/$stageParams.imageName:$stageParams.imageTag
        docker image push $stageParams.dockerUser/$stageParams.imageName:latest
    """
}