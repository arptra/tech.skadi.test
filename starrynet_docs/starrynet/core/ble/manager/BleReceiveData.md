# BleReceiveData

*Пакет:* `com.upuphone.starrynet.core.ble.manager`\n
*Источник:* `starrynet/core/ble/manager/BleReceiveData.java`\n
*Тип:* Class

## Назначение
Класс BleReceiveData управляет логикой, связанной с BleReceiveData.

## Поля
- `byte data`
- `UUID fromUUID`
- `boolean isClient`
- `String remoteBleMac`
- `ChannelTag tag`

## Методы
- `public byte getData()`
- `public UUID getFromUUID()`
- `public String getRemoteBleMac()`
- `public ChannelTag getTag()`
- `public boolean isClient()`
- `public int isCtr()`
- `public BleReceiveData(boolean z, String str, UUID uuid, byte bArr)`
