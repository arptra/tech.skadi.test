# CTRPacket

*Пакет:* `com.upuphone.starrynet.core.ble.channel.packet`\n
*Источник:* `starrynet/core/ble/channel/packet/CTRPacket.java`\n
*Тип:* Class

## Назначение
Класс CTRPacket управляет логикой, связанной с CTRPacket.

## Поля
- `int BUFFER_SIZE`
- `int CMD_COMMON_DATA`
- `int CMD_COMMON_DATA_CRC32`
- `int CMD_COMMON_STARRY_DATA`
- `int CMD_COMMON_STARRY_DATA_INIT`
- `int frameCount`
- `int packageType`

## Методы
- `public int getFrameCount()`
- `public String getName()`
- `public int getPackageType()`
- `public byte toBytes()`
- `public String toString()`
- `public CTRPacket(int i, int i2)`
