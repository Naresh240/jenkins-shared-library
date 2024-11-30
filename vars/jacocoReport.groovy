def call(Map config = [:]) {
    // Default configurations
    def execPattern = config.get('execPattern', '**/jacoco.exec') // String
    def classPattern = config.get('classPattern', '**/classes') // String
    def sourcePattern = config.get('sourcePattern', '**/src/main/java') // String

    def exclusionPattern = config.get('exclusionPattern')  // Optional, String
    def inclusionPattern = config.get('inclusionPattern')  // Optional, String
    def runAlways = config.get('runAlways', true)  // Optional, Boolean (default true)
    def skipCopyOfSrcFiles = config.get('skipCopyOfSrcFiles', false)  // Optional, Boolean (default false)
    def sourceExclusionPattern = config.get('sourceExclusionPattern')  // Optional, String
    def buildOverBuild = config.get('buildOverBuild', false)  // Optional, Boolean (default false)
    def changeBuildStatus = config.get('changeBuildStatus', false)  // Optional, Boolean (default false)

    // Delta Thresholds (optional, no default values)
    def deltaBranchCoverage = config.get('deltaBranchCoverage')  // Optional, Integer or String
    def deltaClassCoverage = config.get('deltaClassCoverage')  // Optional, Integer or String
    def deltaComplexityCoverage = config.get('deltaComplexityCoverage')  // Optional, Integer or String
    def deltaInstructionCoverage = config.get('deltaInstructionCoverage')  // Optional, Integer or String
    def deltaLineCoverage = config.get('deltaLineCoverage')  // Optional, Integer or String
    def deltaMethodCoverage = config.get('deltaMethodCoverage')  // Optional, Integer or String

    // Minimum Coverage thresholds (optional, no default values)
    def minimumBranchCoverage = config.get('minimumBranchCoverage')  // Optional, Integer or String
    def minimumClassCoverage = config.get('minimumClassCoverage')  // Optional, Integer or String
    def minimumComplexityCoverage = config.get('minimumComplexityCoverage')  // Optional, Integer or String
    def minimumInstructionCoverage = config.get('minimumInstructionCoverage')  // Optional, Integer or String
    def minimumLineCoverage = config.get('minimumLineCoverage')  // Optional, Integer or String
    def minimumMethodCoverage = config.get('minimumMethodCoverage')  // Optional, Integer or String

    // Maximum Coverage thresholds (optional, no default values)
    def maximumBranchCoverage = config.get('maximumBranchCoverage')  // Optional, Integer or String
    def maximumClassCoverage = config.get('maximumClassCoverage')  // Optional, Integer or String
    def maximumComplexityCoverage = config.get('maximumComplexityCoverage')  // Optional, Integer or String
    def maximumInstructionCoverage = config.get('maximumInstructionCoverage')  // Optional, Integer or String
    def maximumLineCoverage = config.get('maximumLineCoverage')  // Optional, Integer or String
    def maximumMethodCoverage = config.get('maximumMethodCoverage')  // Optional, Integer or String

    // Ensure coverage thresholds and delta values are passed as strings if necessary (if they're integers)
    def convertToString = { value ->
        value != null ? value.toString() : null
    }

    minimumBranchCoverage = convertToString(minimumBranchCoverage)
    minimumClassCoverage = convertToString(minimumClassCoverage)
    minimumComplexityCoverage = convertToString(minimumComplexityCoverage)
    minimumInstructionCoverage = convertToString(minimumInstructionCoverage)
    minimumLineCoverage = convertToString(minimumLineCoverage)
    minimumMethodCoverage = convertToString(minimumMethodCoverage)

    maximumBranchCoverage = convertToString(maximumBranchCoverage)
    maximumClassCoverage = convertToString(maximumClassCoverage)
    maximumComplexityCoverage = convertToString(maximumComplexityCoverage)
    maximumInstructionCoverage = convertToString(maximumInstructionCoverage)
    maximumLineCoverage = convertToString(maximumLineCoverage)
    maximumMethodCoverage = convertToString(maximumMethodCoverage)

    deltaBranchCoverage = convertToString(deltaBranchCoverage)
    deltaClassCoverage = convertToString(deltaClassCoverage)
    deltaComplexityCoverage = convertToString(deltaComplexityCoverage)
    deltaInstructionCoverage = convertToString(deltaInstructionCoverage)
    deltaLineCoverage = convertToString(deltaLineCoverage)
    deltaMethodCoverage = convertToString(deltaMethodCoverage)

    // Build Jacoco step with all parameters
    jacocoReport(
        execPattern: execPattern,
        classPattern: classPattern,
        sourcePattern: sourcePattern,
        exclusionPattern: exclusionPattern,
        inclusionPattern: inclusionPattern,
        runAlways: runAlways,
        sourceExclusionPattern: sourceExclusionPattern,
        skipCopyOfSrcFiles: skipCopyOfSrcFiles,
        buildOverBuild: buildOverBuild,
        changeBuildStatus: changeBuildStatus,
        deltaBranchCoverage: deltaBranchCoverage,
        deltaClassCoverage: deltaClassCoverage,
        deltaComplexityCoverage: deltaComplexityCoverage,
        deltaInstructionCoverage: deltaInstructionCoverage,
        deltaLineCoverage: deltaLineCoverage,
        deltaMethodCoverage: deltaMethodCoverage,
        minimumBranchCoverage: minimumBranchCoverage,
        minimumClassCoverage: minimumClassCoverage,
        minimumComplexityCoverage: minimumComplexityCoverage,
        minimumInstructionCoverage: minimumInstructionCoverage,
        minimumLineCoverage: minimumLineCoverage,
        minimumMethodCoverage: minimumMethodCoverage,
        maximumBranchCoverage: maximumBranchCoverage,
        maximumClassCoverage: maximumClassCoverage,
        maximumComplexityCoverage: maximumComplexityCoverage,
        maximumInstructionCoverage: maximumInstructionCoverage,
        maximumLineCoverage: maximumLineCoverage,
        maximumMethodCoverage: maximumMethodCoverage
    )
}
