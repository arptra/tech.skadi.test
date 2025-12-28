package com.skadi.myvu.bleclient.util

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
}
