def call(Map stageParams) {
    sh "docker image build -t $stageParams.dockerUser/$stageParams.imageName ."
    sh "docker tag $stageParams.dockerUser/$stageParams.imageName $stageParams.dockerUser/$stageParams.imageName:$stageParams.imageTag"
    sh "docker tag $stageParams.dockerUser/$stageParams.imageName $stageParams.dockerUser/$stageParams.imageName:latest"
    sh "docker login -u '$username' -p '$password'"
    sh "docker image push $stageParams.dockerUser/$stageParams.imageName:$stageParams.imageTag"
    sh "docker image push $stageParams.dockerUser/$stageParams.imageName:latest"
}
