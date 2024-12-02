def call(Map stageParams) {
    try {
        echo "Starting Trivy scan for image: $stageParams.dockerUser/$stageParams.imageName:$stageParams.imageTag"

        // Execute Trivy scan
        sh """
            trivy -d image $stageParams.dockerUser/$stageParams.imageName:$stageParams.imageTag
        """
        
        echo "Trivy scan completed successfully for image: $stageParams.dockerUser/$stageParams.imageName:$stageParams.imageTag"
    } catch (Exception e) {
        error "Trivy scan failed: ${e.message}"
    }
}
