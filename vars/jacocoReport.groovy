def call(Map config = [:]) {
    // Default configurations
    def execPattern = config.get('execPattern', '**/jacoco.exec') // String
    def classPattern = config.get('classPattern', '**/classes') // String
    def sourcePattern = config.get('sourcePattern', '**/src/main/java') // String

    def exclusionPattern = config.get('exclusionPattern')  // Optional, String
    def inclusionPattern = config.get('inclusionPattern')  // Optional, String
    def runAlways = config.get('runAlways')  // Optional, Boolean
    def skipCopyOfSrcFiles = config.get('skipCopyOfSrcFiles')  // Optional, Boolean
    def sourceExclusionPattern = config.get('sourceExclusionPattern')  // Optional, String
    def buildOverBuild = config.get('buildOverBuild')  // Optional, Boolean
    def changeBuildStatus = config.get('changeBuildStatus')  // Optional, Boolean

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

    // Ensure coverage thresholds are passed as strings if necessary (if they're integers)
    if (minimumBranchCoverage != null) {
        minimumBranchCoverage = minimumBranchCoverage.toString()
    }
    if (minimumClassCoverage != null) {
        minimumClassCoverage = minimumClassCoverage.toString()
    }
    if (minimumComplexityCoverage != null) {
        minimumComplexityCoverage = minimumComplexityCoverage.toString()
    }
    if (minimumInstructionCoverage != null) {
        minimumInstructionCoverage = minimumInstructionCoverage.toString()
    }
    if (minimumLineCoverage != null) {
        minimumLineCoverage = minimumLineCoverage.toString()
    }
    if (minimumMethodCoverage != null) {
        minimumMethodCoverage = minimumMethodCoverage.toString()
    }

    // Build Jacoco step with all parameters
    jacoco(
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
