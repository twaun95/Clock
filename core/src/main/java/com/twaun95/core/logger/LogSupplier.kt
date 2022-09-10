package com.twaun95.core.logger

fun interface LogSupplier {
    fun log(message: String)
}

internal fun Any.getLifeCycleMessage(funcName: String, prefix: String = ""): String {
    return String.format(
        "[LifeCycle]$prefix${funcName}:: %s%s",
        javaClass.simpleName,
        "(${hashCode()})"
    )
}