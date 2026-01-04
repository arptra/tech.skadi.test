# MdnsAdvertising

*Пакет:* `com.upuphone.starrynet.strategy.discovery.mdns`\n
*Источник:* `starrynet/strategy/discovery/mdns/MdnsAdvertising.java`\n
*Тип:* Class

## Назначение
Класс MdnsAdvertising управляет логикой, связанной с MdnsAdvertising.

## Поля
- `String TAG`
- `NsdServiceManager mNsdServiceManager`
- `boolean mRepeat`
- `boolean mStartAdvStatus`
- `Object mStartAdvertisingSync`
- `boolean mStopAdvStatus`
- `Object mStopAdvertisingSync`
- `String serviceType`

## Методы
- `private String generateData()`
- `private int generateGoDefaultPort()`
- `private String generateName()`
- `private String getNetworkInterfaceIPByName(String str)`
- `private void printNetInterface(List list)`
- `private void saveCachePort(int i)`
- `private int takeCachePort()`
- `private int testPortAvailable(int i)`
- `public void onServiceRegisterStatus(NsdServiceInfo nsdServiceInfo, int i, boolean z)`
- `public void onServiceUnregisterStatus(NsdServiceInfo nsdServiceInfo, int i, boolean z)`
- `public boolean startAdvertising()`
- `public boolean stopAdvertising()`
- `public MdnsAdvertising(Context context)`
