package com.example.myvuserver.ble

/**
 * WHY: StarryNet performs custom handshakes after CCC is enabled.
 * We keep this type around so future protocol steps can be slotted
 * without rewriting the GATT plumbing. For now it just captures raw
 * inbound payloads so testers can see the bytes in the UI/logs.
 */
class ProtocolHooks {
    fun onInboundPayload(bytes: ByteArray): String {
        return bytes.joinToString(separator = " ") { String.format("%02X", it) }
    }
}
