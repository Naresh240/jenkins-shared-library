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
    
    // Coverage values from config (defaults to 0 if not provided)
    def instructionCoverage = config.get('instructionCoverage', 0)
    def branchCoverage = config.get('branchCoverage', 0)
    def complexityCoverage = config.get('complexityCoverage', 0)
    def lineCoverage = config.get('lineCoverage', 0)
    def methodCoverage = config.get('methodCoverage', 0)
    def classCoverage = config.get('classCoverage', 0)

    // JaCoCo plugin configuration
    jacoco(
        execPattern: execPattern,
        classPattern: classPattern,
        sourcePattern: sourcePattern
    )

    // Logic to handle coverage thresholds for reporting
    if (coverageThresholds) {
        echo "Coverage thresholds set: Instruction: $instructionCoverage, Branch: $branchCoverage, Complexity: $complexityCoverage, Line: $lineCoverage, Method: $methodCoverage, Class: $classCoverage"

        // Logic to check if the coverage meets the thresholds
        if (lineCoverage < coverageThresholds.line) {
            currentBuild.result = 'FAILURE'
            error "Line coverage is below threshold: ${lineCoverage}% < ${coverageThresholds.line}%"
        }

        if (branchCoverage < coverageThresholds.branch) {
            currentBuild.result = 'FAILURE'
            error "Branch coverage is below threshold: ${branchCoverage}% < ${coverageThresholds.branch}%"
        }

        if (instructionCoverage < coverageThresholds.instruction) {
            currentBuild.result = 'FAILURE'
            error "Instruction coverage is below threshold: ${instructionCoverage}% < ${coverageThresholds.instruction}%"
        }

        if (complexityCoverage < coverageThresholds.complexity) {
            currentBuild.result = 'FAILURE'
            error "Complexity coverage is below threshold: ${complexityCoverage}% < ${coverageThresholds.complexity}%"
        }

        if (methodCoverage < coverageThresholds.method) {
            currentBuild.result = 'FAILURE'
            error "Method coverage is below threshold: ${methodCoverage}% < ${coverageThresholds.method}%"
        }

        if (classCoverage < coverageThresholds.class) {
            currentBuild.result = 'FAILURE'
            error "Class coverage is below threshold: ${classCoverage}% < ${coverageThresholds.class}%"
        }
    }

    // If JaCoCo fails or the build is ABORTED, decide if you want to collect coverage anyway
    if (alwaysRun) {
        // Logic to always run coverage collection, even on failure or abortion
        echo "Running coverage collection regardless of build status..."
    }

    // Apply the build failure conditions based on delta thresholds
    if (failThresholds) {
        // Logic to fail the build if coverage degrades beyond the defined delta thresholds
        def coverageDelta = calculateCoverageDelta() // Define a method to calculate coverage degradation
        if (coverageDelta < failThresholds.line) {
            currentBuild.result = 'FAILURE'
            error "Line coverage has degraded beyond the acceptable threshold."
        }
    }

    // Optional: Disable source files display if configured
    if (!showSource) {
        // Logic to disable source display in the JaCoCo report
        echo "Disabling source display in JaCoCo report..."
    }
}

// Helper method to calculate the coverage delta (for failThresholds)
def calculateCoverageDelta() {
    // Implement logic to calculate coverage degradation based on historical data or previous builds
    return 5 // Example data: 5% degradation in coverage
}
