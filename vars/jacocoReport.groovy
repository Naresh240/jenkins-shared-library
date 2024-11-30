// vars/jacocoReport.groovy
def call(Map config = [:]) {
    // Default configurations
    def execPattern = config.get('execPattern', '**/jacoco.exec')
    def classPattern = config.get('classPattern', '**/classes')
    def sourcePattern = config.get('sourcePattern', '**/src/main/java')

    def exclusionPattern = config.get('exclusionPattern')  // Optional
    def inclusionPattern = config.get('inclusionPattern')  // Optional
    def runAlways = config.get('runAlways')  // Optional
    def skipCopyOfSrcFiles = config.get('skipCopyOfSrcFiles')  // Optional
    def sourceExclusionPattern = config.get('sourceExclusionPattern')  // Optional
    def buildOverBuild = config.get('buildOverBuild')  // Optional
    def changeBuildStatus = config.get('changeBuildStatus')  // Optional

    // Coverage thresholds (optional, no default values)
    def instructionThreshold = config.get('instructionThreshold')  // Optional
    def branchThreshold = config.get('branchThreshold')  // Optional
    def complexityThreshold = config.get('complexityThreshold')  // Optional
    def lineThreshold = config.get('lineThreshold')  // Optional
    def methodThreshold = config.get('methodThreshold')  // Optional
    def classThreshold = config.get('classThreshold')  // Optional

    // Delta Thresholds (optional, no default values)
    def deltaBranchCoverage = config.get('deltaBranchCoverage')  // Optional
    def deltaClassCoverage = config.get('deltaClassCoverage')  // Optional
    def deltaComplexityCoverage = config.get('deltaComplexityCoverage')  // Optional
    def deltaInstructionCoverage = config.get('deltaInstructionCoverage')  // Optional
    def deltaLineCoverage = config.get('deltaLineCoverage')  // Optional
    def deltaMethodCoverage = config.get('deltaMethodCoverage')  // Optional

    // Minimum Coverage thresholds (optional, no default values)
    def minimumBranchCoverage = config.get('minimumBranchCoverage')  // Optional
    def minimumClassCoverage = config.get('minimumClassCoverage')  // Optional
    def minimumComplexityCoverage = config.get('minimumComplexityCoverage')  // Optional
    def minimumInstructionCoverage = config.get('minimumInstructionCoverage')  // Optional
    def minimumLineCoverage = config.get('minimumLineCoverage')  // Optional
    def minimumMethodCoverage = config.get('minimumMethodCoverage')  // Optional

    // Maximum Coverage thresholds (optional, no default values)
    def maximumBranchCoverage = config.get('maximumBranchCoverage')  // Optional
    def maximumClassCoverage = config.get('maximumClassCoverage')  // Optional
    def maximumComplexityCoverage = config.get('maximumComplexityCoverage')  // Optional
    def maximumInstructionCoverage = config.get('maximumInstructionCoverage')  // Optional
    def maximumLineCoverage = config.get('maximumLineCoverage')  // Optional
    def maximumMethodCoverage = config.get('maximumMethodCoverage')  // Optional

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
        instructionThreshold: instructionThreshold,
        branchThreshold: branchThreshold,
        complexityThreshold: complexityThreshold,
        lineThreshold: lineThreshold,
        methodThreshold: methodThreshold,
        classThreshold: classThreshold,
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
