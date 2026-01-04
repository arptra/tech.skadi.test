# Packet

*Пакет:* `com.upuphone.starrynet.core.ble.channel.packet`\n
*Источник:* `starrynet/core/ble/channel/packet/Packet.java`\n
*Тип:* Class

## Назначение
Класс Packet управляет логикой, связанной с Packet.

## Поля
- `String ACK`
- `String CTR`
- `String DATA`
- `String FAST_ACK`
- `String FAST_CTR`
- `String MIX_CTR`
- `String MNG_ACK`
- `String MNG_CMD`
- `String SINGLE_ACK`
- `String SINGLE_CMD`
- `String SINGLE_CMD_NO_ACK`
- `int SN_CTR`
- `int TYPE_ACK`
- `int TYPE_CMD`
- `int TYPE_FAST_ACK`
- `int TYPE_FAST_CTR`
- `int TYPE_MIX_CTR`
- `int TYPE_MNG`
- `int TYPE_MNG_ACK`
- `int TYPE_SINGLE_ACK`
- `int TYPE_SINGLE_CMD`
- `int TYPE_SINGLE_CMD_NO_ACK`

## Методы
- `private static Packet getDataPacket(Header header)`
- `private static Packet getFlowPacket(Header header)`
- `public static Packet getPacket(byte bArr)`
- `private static Header parse(byte bArr)`
- `abstract public String getName()`
- `abstract public byte toBytes()`
