def push(Map stageParams) {
    sh "docker login -u '$username' -p '$password'"
    sh "docker image push $stageParams.dockerUser/$stageParams.imageName:$stageParams.imageTag"
    sh "docker image push $stageParams.dockerUser/$stageParams.imageName:latest"
}