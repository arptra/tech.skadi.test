# BleConnectConfig

*Пакет:* `com.upuphone.starrynet.core.ble.client`\n
*Источник:* `starrynet/core/ble/client/BleConnectConfig.java`\n
*Тип:* Class

## Назначение
Класс BleConnectConfig управляет логикой, связанной с BleConnectConfig.

## Поля
- `boolean activelyOpen2MPhy`
- `String bleMac`
- `UUID destCharacterUUID`
- `UUID heartBeatUUID`
- `boolean openHighSpeed`
- `int retryTimes`

## Методы
- `public BleConnectConfig activelyOpen2MPhy(boolean z)`
- `public BleConnectConfig checkDestCharacterUUID(UUID uuid)`
- `public String getBleMac()`
- `public UUID getDestCharacterUUID()`
- `public UUID getHeartBeatUUID()`
- `public int getMaxRetryTimes()`
- `public BleConnectConfig heartBeatUUID(UUID uuid)`
- `public boolean isActivelyOpen2MPhy()`
- `public boolean isOpenHighSpeed()`
- `public BleConnectConfig openHighSpeed(boolean z)`
- `public void setMaxRetryTimes(int i)`
- `public BleConnectConfig(String str)`
