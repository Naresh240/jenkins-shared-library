def call(Map config = [:]) {
    // Default configurations
    def execPattern = config.get('execPattern', '**/jacoco.exec')
    def classPattern = config.get('classPattern', '**/classes')
    def sourcePattern = config.get('sourcePattern', '**/src/main/java')

    // Optional configurations
    def showSource = config.get('showSource', true)
    def coverageThresholds = config.get('coverageThresholds', [:]) // Expecting a map of coverage thresholds like [line: 80, branch: 70]
    def alwaysRun = config.get('alwaysRun', false) // Whether to always collect coverage even on failure
    def failThresholds = config.get('failThresholds', [:]) // Thresholds for failing the build, e.g., [line: 75, branch: 60]
    
    // JaCoCo plugin configuration
    jacoco(
        execPattern: execPattern,
        classPattern: classPattern,
        sourcePattern: sourcePattern
    )

    // Handle coverage thresholds for reporting
    if (coverageThresholds) {
        // Add logic to handle coverage thresholds
        // Example: You could use coverageThresholds['line'], coverageThresholds['branch'], etc.
    }

    // If JaCoCo fails or the build is ABORTED, decide if you want to collect coverage anyway
    if (alwaysRun) {
        // Logic to always run coverage collection, even on failure or abortion
    }

    // Apply the build failure conditions based on delta thresholds
    if (failThresholds) {
        // Logic to fail the build if coverage degrades beyond the defined delta thresholds
    }

    // Optional: Disable source files display if configured
    if (!showSource) {
        // Logic to disable source display in the JaCoCo report
    }
}