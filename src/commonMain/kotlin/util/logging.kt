package util

enum class LogLevel {
    DEBUG,
    WARN,
    ERROR
}

internal expect fun writeLogMessage(tag: String, message: String, logLevel: LogLevel)

fun logDebug(tag: String,  message: String) = writeLogMessage(tag, message, LogLevel.DEBUG)
fun logWarn(tag: String, message: String) = writeLogMessage(tag, message, LogLevel.WARN)
fun logError(tag: String, message: String) = writeLogMessage(tag, message, LogLevel.ERROR)