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

    // Additional thresholds for Instruction, Branch, Complexity, Method, Class
    def instructionThreshold = coverageThresholds.get('instruction', 0)
    def branchThreshold = coverageThresholds.get('branch', 0)
    def complexityThreshold = coverageThresholds.get('complexity', 0)
    def lineThreshold = coverageThresholds.get('line', 0)
    def methodThreshold = coverageThresholds.get('method', 0)
    def classThreshold = coverageThresholds.get('class', 0)

    // JaCoCo plugin configuration
    jacoco(
        execPattern: execPattern,
        classPattern: classPattern,
        sourcePattern: sourcePattern
    )

    // Now, read the JaCoCo coverage data
    def coverageData = sh(script: 'cat target/site/jacoco/index.html', returnStdout: true) // Assuming the JaCoCo report is generated here, adjust if needed
    
    // For simplicity, we'll print the coverage data here. You can use a more complex parsing mechanism to extract actual coverage values
    echo "JaCoCo Coverage Data:\n${coverageData}"

    // Validate coverage against the thresholds and fail the build if necessary
    if (coverageThresholds) {
        // This is a simplified example. You should implement logic to parse the actual coverage values from the generated report.
        def instructionCoverage = 62 // Example value, replace with actual coverage from the report
        def branchCoverage = 100 // Example value, replace with actual coverage from the report
        def complexityCoverage = 75 // Example value, replace with actual coverage from the report
        def lineCoverage = 60 // Example value, replace with actual coverage from the report
        def methodCoverage = 80 // Example value, replace with actual coverage from the report
        def classCoverage = 100 // Example value, replace with actual coverage from the report

        // Check if any coverage is below the threshold
        if (instructionCoverage < instructionThreshold) {
            currentBuild.result = 'FAILURE'
            error "Build failed due to low Instruction coverage (expected ${instructionThreshold}%, but got ${instructionCoverage}%)"
        }
        if (branchCoverage < branchThreshold) {
            currentBuild.result = 'FAILURE'
            error "Build failed due to low Branch coverage (expected ${branchThreshold}%, but got ${branchCoverage}%)"
        }
        if (complexityCoverage < complexityThreshold) {
            currentBuild.result = 'FAILURE'
            error "Build failed due to low Complexity coverage (expected ${complexityThreshold}%, but got ${complexityCoverage}%)"
        }
        if (lineCoverage < lineThreshold) {
            currentBuild.result = 'FAILURE'
            error "Build failed due to low Line coverage (expected ${lineThreshold}%, but got ${lineCoverage}%)"
        }
        if (methodCoverage < methodThreshold) {
            currentBuild.result = 'FAILURE'
            error "Build failed due to low Method coverage (expected ${methodThreshold}%, but got ${methodCoverage}%)"
        }
        if (classCoverage < classThreshold) {
            currentBuild.result = 'FAILURE'
            error "Build failed due to low Class coverage (expected ${classThreshold}%, but got ${classCoverage}%)"
        }
    }

    // Optional: Disable source files display if configured
    if (!showSource) {
        // Logic to disable source display in the JaCoCo report
    }
}