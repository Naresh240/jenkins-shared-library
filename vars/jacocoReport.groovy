def call(Map config = [:]) {
    // Default configurations
    def execPattern = config.get('execPattern', '**/jacoco.exec')
    def classPattern = config.get('classPattern', '**/classes')
    def sourcePattern = config.get('sourcePattern', '**/src/main/java')

    // Optional fields (with default values where necessary)
    def exclusionPattern = config.get('exclusionPattern', null)
    def inclusionPattern = config.get('inclusionPattern', null)
    def runAlways = config.get('runAlways', null)
    def skipCopyOfSrcFiles = config.get('skipCopyOfSrcFiles', null)
    def sourceExclusionPattern = config.get('sourceExclusionPattern', null)
    def buildOverBuild = config.get('buildOverBuild', null)
    def changeBuildStatus = config.get('changeBuildStatus', null)

    // Delta Thresholds
    def deltaBranchCoverage = config.get('deltaBranchCoverage', 100)
    def deltaClassCoverage = config.get('deltaClassCoverage', 90)
    def deltaComplexityCoverage = config.get('deltaComplexityCoverage', 80)
    def deltaInstructionCoverage = config.get('deltaInstructionCoverage', 90)
    def deltaLineCoverage = config.get('deltaLineCoverage', 75)
    def deltaMethodCoverage = config.get('deltaMethodCoverage', 80)

    // Minimum Coverage thresholds
    def minimumBranchCoverage = config.get('minimumBranchCoverage', 80)
    def minimumClassCoverage = config.get('minimumClassCoverage', 80)
    def minimumComplexityCoverage = config.get('minimumComplexityCoverage', 80)
    def minimumInstructionCoverage = config.get('minimumInstructionCoverage', 80)
    def minimumLineCoverage = config.get('minimumLineCoverage', 80)
    def minimumMethodCoverage = config.get('minimumMethodCoverage', 80)

    // Maximum Coverage thresholds
    def maximumBranchCoverage = config.get('maximumBranchCoverage', 80)
    def maximumClassCoverage = config.get('maximumClassCoverage', 100)
    def maximumComplexityCoverage = config.get('maximumComplexityCoverage', 100)
    def maximumInstructionCoverage = config.get('maximumInstructionCoverage', 80)
    def maximumLineCoverage = config.get('maximumLineCoverage', 80)
    def maximumMethodCoverage = config.get('maximumMethodCoverage', 90)

    // Call the Jacoco step with the parameters
    jacoco(
        execPattern: execPattern,
        classPattern: classPattern,
        sourcePattern: sourcePattern,
        exclusionPattern: exclusionPattern,
        inclusionPattern: inclusionPattern,
        runAlways: runAlways,
        skipCopyOfSrcFiles: skipCopyOfSrcFiles,
        sourceExclusionPattern: sourceExclusionPattern,
        buildOverBuild: buildOverBuild,
        changeBuildStatus: changeBuildStatus,

        // Delta thresholds
        deltaBranchCoverage: deltaBranchCoverage,
        deltaClassCoverage: deltaClassCoverage,
        deltaComplexityCoverage: deltaComplexityCoverage,
        deltaInstructionCoverage: deltaInstructionCoverage,
        deltaLineCoverage: deltaLineCoverage,
        deltaMethodCoverage: deltaMethodCoverage,

        // Minimum Coverage thresholds
        minimumBranchCoverage: minimumBranchCoverage,
        minimumClassCoverage: minimumClassCoverage,
        minimumComplexityCoverage: minimumComplexityCoverage,
        minimumInstructionCoverage: minimumInstructionCoverage,
        minimumLineCoverage: minimumLineCoverage,
        minimumMethodCoverage: minimumMethodCoverage,

        // Maximum Coverage thresholds
        maximumBranchCoverage: maximumBranchCoverage,
        maximumClassCoverage: maximumClassCoverage,
        maximumComplexityCoverage: maximumComplexityCoverage,
        maximumInstructionCoverage: maximumInstructionCoverage,
        maximumLineCoverage: maximumLineCoverage,
        maximumMethodCoverage: maximumMethodCoverage,
    )
}
