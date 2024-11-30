def call(Map config = [:]) {
    def execPattern = config.get('execPattern', '**/jacoco.exec')
    def classPattern = config.get('classPattern', '**/classes')
    def sourcePattern = config.get('sourcePattern', '**/src/main/java')

    jacoco(
        execPattern: execPattern,
        classPattern: classPattern,
        sourcePattern: sourcePattern,
    )
}
