# AdvEncoder

*Пакет:* `com.upuphone.starrynet.strategy.discovery.advertiser.codec`\n
*Источник:* `starrynet/strategy/discovery/advertiser/codec/AdvEncoder.java`\n
*Тип:* Class

## Назначение
Класс AdvEncoder управляет логикой, связанной с AdvEncoder.

## Поля
- `int MAX_RSP_DATA_LEN`
- `String TAG`

## Методы
- `private static byte buffer2Bytes(ByteBuffer byteBuffer)`
- `public static byte buildAdv(int r10, int r11)`
- `public static byte buildResponseAdv(int r6, byte r7, short r8, byte r9)`
- `public static byte getDeviceName(int i)`
- `public static byte getOwnBondState()`
- `public static byte getUpgradeData(StDevice stDevice)`
- `private static void putDeviceBaseInfo(StDevice stDevice, ByteBuffer byteBuffer)`
