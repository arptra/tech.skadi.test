# AOAPreambleParser

*Пакет:* `com.upuphone.starrynet.strategy.discovery.iccoa`\n
*Источник:* `starrynet/strategy/discovery/iccoa/AOAPreambleParser.java`\n
*Тип:* Class

## Назначение
Класс AOAPreambleParser управляет логикой, связанной с AOAPreambleParser.

## Поля
- `int AOA_PREAMBLE_INDEX_CAR_ID`
- `int AOA_PREAMBLE_INDEX_CAR_MODEL_ID`
- `int AOA_PREAMBLE_INDEX_CAR_NAME`
- `int AOA_PREAMBLE_INDEX_CAR_PIN`
- `int AOA_PREAMBLE_INDEX_PROTO_VER`
- `int AOA_PREAMBLE_INDEX_VENDOR_DATA`
- `int AOA_PREAMBLE_PART_NUM`
- `int CAR_PID_LENGTH`
- `int CAR_VID_LENGTH`
- `String sRaw`

## Методы
- `public static String getCarId()`
- `public static String getCarName()`
- `public static String getPid()`
- `public static String getPinCode()`
- `public static String getVendorData()`
- `public static String getVersion()`
- `public static String getVid()`
- `public static boolean init(String str)`
