def call(Map params) {
    if (!params.DOCKER_USER || !params.IMAGE_NAME || !params.IMAGE_TAG) {
        error "Missing required parameters: DOCKER_USER, IMAGE_NAME, or IMAGE_TAG"
    }

    try {
        echo "Starting Trivy scan for image: ${params.DOCKER_USER}/${params.IMAGE_NAME}:${params.IMAGE_TAG}"

        // Execute Trivy scan
        sh """
        trivy image ${params.DOCKER_USER}/${params.IMAGE_NAME}:${params.IMAGE_TAG}
        """
        
        echo "Trivy scan completed successfully for image: ${params.DOCKER_USER}/${params.IMAGE_NAME}:${params.IMAGE_TAG}"
    } catch (Exception e) {
        error "Trivy scan failed: ${e.message}"
    }
}
