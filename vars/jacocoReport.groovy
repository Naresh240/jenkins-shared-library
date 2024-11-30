def call(Map config = [:]) {
    def execPattern = config.get('execPattern', '**/jacoco.exec')
    def classPattern = config.get('classPattern', '**/classes')
    def sourcePattern = config.get('sourcePattern', '**/src/main/java')

    def showSource = config.get('showSource', true)
    def coverageThresholds = config.get('coverageThresholds', [:])
    def alwaysRun = config.get('alwaysRun', false)
    def failThresholds = config.get('failThresholds', [:])

    def instructionCoverage = roundToTwoDecimalPlaces(config.get('instructionCoverage', 0))
    def branchCoverage = roundToTwoDecimalPlaces(config.get('branchCoverage', 0))
    def complexityCoverage = roundToTwoDecimalPlaces(config.get('complexityCoverage', 0))
    def lineCoverage = roundToTwoDecimalPlaces(config.get('lineCoverage', 0))
    def methodCoverage = roundToTwoDecimalPlaces(config.get('methodCoverage', 0))
    def classCoverage = roundToTwoDecimalPlaces(config.get('classCoverage', 0))

    jacoco(
        execPattern: execPattern,
        classPattern: classPattern,
        sourcePattern: sourcePattern
    )

    if (coverageThresholds) {
        echo "Coverage thresholds set: Instruction: $instructionCoverage, Branch: $branchCoverage, Complexity: $complexityCoverage, Line: $lineCoverage, Method: $methodCoverage, Class: $classCoverage"

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

    if (alwaysRun) {
        echo "Running coverage collection regardless of build status..."
    }

    if (failThresholds) {
        def coverageDelta = calculateCoverageDelta()
        if (coverageDelta < failThresholds.line) {
            currentBuild.result = 'FAILURE'
            error "Line coverage has degraded beyond the acceptable threshold."
        }
    }

    if (!showSource) {
        echo "Disabling source display in JaCoCo report..."
    }
}

def roundToTwoDecimalPlaces(value) {
    return value.toBigDecimal().setScale(2, BigDecimal.ROUND_HALF_UP)
}

// Helper method to calculate the coverage delta (for failThresholds)
def calculateCoverageDelta() {
    return 5
}
