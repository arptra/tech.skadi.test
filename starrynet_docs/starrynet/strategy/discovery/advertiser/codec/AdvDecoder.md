# AdvDecoder

*Пакет:* `com.upuphone.starrynet.strategy.discovery.advertiser.codec`\n
*Источник:* `starrynet/strategy/discovery/advertiser/codec/AdvDecoder.java`\n
*Тип:* Class

## Назначение
Класс AdvDecoder управляет логикой, связанной с AdvDecoder.

## Поля
- `String TAG`

## Методы
- `public static boolean decodeAdvData(StDiscoveryDevice stDiscoveryDevice, byte bArr)`
- `private static void decodeCommonDeviceInfo(StDiscoveryDevice stDiscoveryDevice, ByteBuffer byteBuffer)`
- `public static boolean decodeResponseData(StDiscoveryDevice stDiscoveryDevice, byte bArr)`
- `private static boolean decodeTLVData(byte b, StDiscoveryDevice stDiscoveryDevice, ByteBuffer byteBuffer)`
- `private static boolean decodeV1Data(StDiscoveryDevice stDiscoveryDevice, ByteBuffer byteBuffer)`
- `private static boolean decodeV2PlusData(StDiscoveryDevice stDiscoveryDevice, ByteBuffer byteBuffer)`
