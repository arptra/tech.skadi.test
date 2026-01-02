package com.skadi.myvu.bleclient.debug

data class CommandResult(
    val command: Command,
    val success: Boolean,
    val message: String
)
