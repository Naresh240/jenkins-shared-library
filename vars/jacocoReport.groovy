def call(Map config = [:]) {
    // Default configurations
    def execPattern = config.get('execPattern', '**/jacoco.exec')
    def classPattern = config.get('classPattern', '**/classes')
    def sourcePattern = config.get('sourcePattern', '**/src/main/java')

    def showSource = config.get('showSource', false)  // Optional
    def alwaysRun = config.get('alwaysRun', false)    // Optional

    // Coverage thresholds (optional)
    def coverageThresholds = config.get('coverageThresholds', [:])
    def failThresholds = config.get('failThresholds', [:])

    // Call the Jacoco step with the parameters
    jacoco(
        execPattern: execPattern,
        classPattern: classPattern,
        sourcePattern: sourcePattern,
        showSource: showSource,
        alwaysRun: alwaysRun,
        coverageThresholds: coverageThresholds,
        failThresholds: failThresholds
    )
}
