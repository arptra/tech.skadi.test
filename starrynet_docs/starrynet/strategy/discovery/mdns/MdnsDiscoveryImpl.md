# MdnsDiscoveryImpl

*Пакет:* `com.upuphone.starrynet.strategy.discovery.mdns`\n
*Источник:* `starrynet/strategy/discovery/mdns/MdnsDiscoveryImpl.java`\n
*Тип:* Class

## Назначение
Класс MdnsDiscoveryImpl управляет логикой, связанной с MdnsDiscoveryImpl.

## Поля
- `String TAG`
- `boolean mIsDiscovery`
- `NsdServiceManager mNsdServiceManager`
- `boolean mStartDisStatus`
- `Object mStartDiscoverySync`
- `boolean mStopDisStatus`
- `Object mStopDiscoverySync`
- `String serviceType`

## Методы
- `public void onServiceFound(NsdServiceInfo nsdServiceInfo)`
- `public void onServiceLost(NsdServiceInfo nsdServiceInfo)`
- `public void onServiceResolvedStatus(NsdServiceInfo nsdServiceInfo, int i, boolean z)`
- `public void onStartDiscoveryStatus(String str, int i, boolean z)`
- `public void onStopDiscoveryStatus(String str, int i, boolean z)`
- `public boolean startDiscovery()`
- `public boolean stopDiscovery()`
- `public MdnsDiscoveryImpl(Context context)`
