# ACKPacket

*Пакет:* `com.upuphone.starrynet.core.ble.channel.packet`\n
*Источник:* `starrynet/core/ble/channel/packet/ACKPacket.java`\n
*Тип:* Class

## Назначение
Класс ACKPacket управляет логикой, связанной с ACKPacket.

## Поля
- `int BUSY`
- `int CANCEL`
- `int READY`
- `int SUCCESS`
- `int SYNC`
- `int TIMEOUT`
- `List lostSeqs`
- `int status`

## Методы
- `public String getName()`
- `public List getSeq()`
- `public int getStatus()`
- `public byte toBytes()`
- `public String toString()`
- `public ACKPacket(int i)`
- `public ACKPacket(int i, List list)`
