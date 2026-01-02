package com.skadi.myvu.bleclient.debug

/**
 * Predefined commands extracted from captured traffic. Payloads are hex strings so they can be tweaked on-screen.
 */
object DebugCommandRepository {
    val commands: List<Command> = listOf(
        Command(
            name = "Start handshake",
            payloadHex = "00 00 06 11 01 00",
            description = "Стартовый write в handle 0x0023 для перевода очков в READY"
        ),
        Command(
            name = "Auth challenge 1",
            payloadHex = "00 00 02 10 0a 06 c3 5b 3f 48 0d 1c 10 0b 1a 65 0a 5b 30 59 30 13 06 07 2a 86 48 ce 3d 02 01 06 08 2a 86 48 ce 3d 03 01 07 03 42 00 04 68 a7 ef 99 42 6e dc 53 21 fa 58 71 ba 1a df b0 56 f1 12 d2 6b 03 32 0d 8c e1 cc c7 aa 22 37 ad a6 29 40 87 77 ac 78 5f 4e 27 ed 2f 4e 70 ae e1 f6 39 65 1e 95 cc 0d 9c ff dc c7 48 e6 21 06 57 12 06 e3 f2 b7 c0 a4 3c",
            description = "Write Command в handle 0x0023 из лога 1"
        ),
        Command(
            name = "Auth challenge 2",
            payloadHex = "00 00 02 10 0a 06 c3 5b 3f 48 0d 1c 10 0d 1a 50 8f 95 cb 44 07 b7 3e 91 e2 f5 4c 23 69 2c e9 f5 e9 83 84 25 74 de 37 5d 4e d8 f2 c6 ca 48 7b fa 0e df fd 68 22 0d 42 e6 29 79 47 d9 f0 ae 99 fa 21 9d 65 7b 5b a8 1f a3 66 76 53 85 63 81 da c9 cb 08 53 d3 e4 9a 7c 13 0e 5f 94 7a ef f6 3a 0f",
            description = "Повторный большой пакет на 0x0023"
        ),
        Command(
            name = "Settings block",
            payloadHex = "00 00 08 00 01 00 02 1a 0c 65 33 66 32 62 37 63 30 61 34 33 63 22 e7 04 7b 22 61 62 69 6c 69 74 79 22 3a 5b 22 61 62 69 6c 69 74 79 52 65 6c 61 79 22 2c 22 61 62 69 6c 69 74 79 52 65 6c 61 79 42 79 70 61 73 73 22 2c 22 61 62 69 6c 69 74 79 41 69 72 22 2c 22 61 62 69 6c 69 74 79 53 68 61 72 65 22 5d 2c 22 61 62 69 6c 69 74 79 41 74 74 72 69 62 75 74 65 73 22 3a 7b 22 61 62 69 6c 69 74 79 41 74 74 72 69 62 75 74 65 73 22 3a 7b 22 61 62 69 6c 69 74 79 52 65 6c 61 79 22 3a 22 7b 5c 22 61 67 72 65 65 6d 65 6e 74 54 79 70 65 5c 22 3a 30 2c 5c 22 6a 73 6f 6e 5c 22 3a 5c 22 7b 5c 5c 5c 22 69 73 53 75 70 70 6f 72 74 4d 61 70 70 69 6e 67 5c 5c 5c 22 3a 66 61 6c 73 65 2c 5c 5c 5c 22 6d 65 74 61 49 6e 66 6f 5c 5c 5c 22 3a 5b 5d 2c 5c 5c 5c 22 6d 65 74 61 4d 61 70 5c 5c 5c 22 3a 7b 7d 7d 5c 22 2c 5c 22 73 75 70 70 6f 72 74 54 6c 76 5c 22 3a 74 72 75 65 7d 22 2c 22 61 62 69 6c 69 74 79 41 69 72 22 3a 22 7b 5c 22 61 67 72 65 65 6d 65 6e 74 54 79 70 65 5c 22 3a 30 2c 5c 22 6a 73 6f 6e 5c 22 3a 5c 22 7b 5c 5c 5c 22 61 69 72 4d 61 70 70 69 6e 67 5c 5c 5c 22 3a 7b 5c 5c 5c 22 31 5c 5c 5c 22 3a 5c 5c 5c 22 63 6f 6d 2e 75 70 75 70 68 6f 6e 65 2e 73 74 61 72 2e 6c 61 75 6e 63 68 65 72 5c 5c 5c 22 2c 5c 5c 5c 22 32 5c 5c 5c 22 3a 5c 5c 5c 22 63 6f 6d 2e 75 70 75 70 68 6f 6e 65 2e 74 68 61 6e 6f 73 2e 73 64 6b 5f 74 65 73 74 5c 5c 5c 22 7d 7d 5c 22 2c 5c 22 73 75 70 70 6f 72 74 54 6c 76 5c 22 3a 74 72 75 65 7d 22 7d 7d 2c 22 61 67 72 65 65 6d 65 6e 74 54 79 70 65 22 3a 30 2c 22 64 65 76 69 63 65 49 64 22 3a 22 65 33 66 32 62 37 63 30 61 34 33 63 22",
            description = "Большой JSON-блок на handle 0x0026"
        ),
        Command(
            name = "Settings commit",
            payloadHex = "01 00 37 63 30 61 34 33 63 22 2c 22 64 65 76 69 63 65 4e 61 6d 65 22 3a 22 50 69 78 65 6c 20 39 20 50 72 6f 22 2c 22 73 65 73 73 69 6f 6e 22 3a 22 37 37 33 36 22 2c 22 73 75 70 70 6f 72 74 54 6c 76 22 3a 74 72 75 65 2c 22 73 75 70 70 6f 72 74 56 69 72 74 75 61 6c 22 3a 66 61 6c 73 65 2c 22 76 65 72 73 69 6f 6e 22 3a 22 32 2e 34 30 2e 35 31 22 2c 22 77 65 69 67 68 74 22 3a 33 33 35 37 37 33 7d 3a 03 31 2e 32 4a 17 74 69 6d 65 73 74 61 6d 70 2d 31 37 36 36 38 39 35 37 35 37 38 31 39 60 d7 d3 c6 99 b6 33",
            description = "Короткое подтверждение настроек на handle 0x0026"
        )
    )
}
