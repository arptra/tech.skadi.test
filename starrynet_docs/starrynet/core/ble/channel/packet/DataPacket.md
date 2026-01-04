# DataPacket

*Пакет:* `com.upuphone.starrynet.core.ble.channel.packet`\n
*Источник:* `starrynet/core/ble/channel/packet/DataPacket.java`\n
*Тип:* Class

## Назначение
Класс DataPacket управляет логикой, связанной с DataPacket.

## Поля
- `int BUFFER_SIZE`
- `Packet bytes`
- `int seq`

## Методы
- `public void fillByteBuffer(ByteBuffer byteBuffer)`
- `public int getDataLength()`
- `public String getName()`
- `public int getSeq()`
- `public byte toBytes()`
- `public String toString()`
- `public DataPacket(int i, Packet bytes2)`
- `public DataPacket(int i, byte bArr, int i2, int i3)`
