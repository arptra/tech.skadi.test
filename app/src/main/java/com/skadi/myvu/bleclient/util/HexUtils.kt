package com.skadi.myvu.bleclient.util

/** Utility helpers for HEX formatting. */
object HexUtils {
    private val HEX_ARRAY = "0123456789ABCDEF".toCharArray()

    fun toHex(bytes: ByteArray): String {
        val result = CharArray(bytes.size * 3)
        var i = 0
        bytes.forEachIndexed { index, byte ->
            val v = byte.toInt() and 0xFF
            result[i] = HEX_ARRAY[v ushr 4]
            result[i + 1] = HEX_ARRAY[v and 0x0F]
            result[i + 2] = ' '
            i += 3
        }
        return result.concatToString().trim()
    }

    fun fromHex(hex: String): ByteArray {
        val clean = hex.replace(" ", "")
        val len = clean.length
        require(len % 2 == 0) { "Hex must have even length" }
        val out = ByteArray(len / 2)
        var i = 0
        while (i < len) {
            out[i / 2] = ((Character.digit(clean[i], 16) shl 4) + Character.digit(clean[i + 1], 16)).toByte()
            i += 2
        }
        return out
    }
}
