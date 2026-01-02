package com.skadi.myvu.bleclient.util

import java.util.Locale

object HexUtils {
    private val HEX_ARRAY = "0123456789ABCDEF".toCharArray()

    fun toHex(bytes: ByteArray?): String {
        if (bytes == null) return ""
        val hexChars = CharArray(bytes.size * 3)
        bytes.forEachIndexed { index, b ->
            val v = b.toInt() and 0xFF
            hexChars[index * 3] = HEX_ARRAY[v ushr 4]
            hexChars[index * 3 + 1] = HEX_ARRAY[v and 0x0F]
            hexChars[index * 3 + 2] = ' '
        }
        return String(hexChars).trim()
    }

    fun fromHex(input: String): ByteArray? {
        val cleaned = input.replace("\\s".toRegex(), "").uppercase(Locale.US)
        if (cleaned.length % 2 != 0) return null
        val result = ByteArray(cleaned.length / 2)
        return try {
            for (i in cleaned.indices step 2) {
                val byte = cleaned.substring(i, i + 2).toInt(16)
                result[i / 2] = byte.toByte()
            }
            result
        } catch (e: NumberFormatException) {
            null
        }
    }
}
