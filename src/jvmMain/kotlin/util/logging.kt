package util

import jdk.nashorn.internal.objects.Global.println

internal actual fun writeLogMessage(tag: String, message: String, logLevel: LogLevel) {
    println("[$logLevel]: $tag: $message")
}