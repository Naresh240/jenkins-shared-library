def call(Map stageParams) {
    sh """
        docker image build -t $stageParams.dockerUser/$stageParams.imageName .
        docker tag $stageParams.dockerUser/$stageParams.imageName $stageParams.dockerUser/$stageParams.imageName:$stageParams.imageTag
        docker tag $stageParams.dockerUser/$stageParams.imageName $stageParams.dockerUser/$stageParams.imageName:latest
    """
}
