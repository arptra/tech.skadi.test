package com.skadi.myvu.bleclient.debug

data class Command(
    val name: String,
    val payloadHex: String,
    val withResponse: Boolean = false,
    val description: String? = null
)
