# DiscoveryClient

*Пакет:* `com.upuphone.starrynet.strategy.discovery`\n
*Источник:* `starrynet/strategy/discovery/DiscoveryClient.java`\n
*Тип:* Class

## Назначение
Класс DiscoveryClient управляет логикой, связанной с DiscoveryClient.

## Поля
- `String TAG`
- `List lstFoundDevices`
- `IStarryDiscoveryCallback mCallback`
- `IBinder mDeathRecipient`
- `UUID mDiscoveryID`
- `DiscoveryFilter mFilter`

## Методы
- `public boolean equals(Object obj)`
- `public IStarryDiscoveryCallback getCallback()`
- `public String getDiscoveryID()`
- `public DiscoveryFilter getFilter()`
- `public List getLstFoundDevices()`
- `public int hashCode()`
- `public void linkToDeath(IBinder deathRecipient)`
- `public void setCallback(IStarryDiscoveryCallback iStarryDiscoveryCallback)`
- `public void setFilter(DiscoveryFilter discoveryFilter)`
- `public void setLstFoundDevices(List list)`
- `public void unlinkToDeath()`
- `public DiscoveryClient(DiscoveryFilter discoveryFilter, IStarryDiscoveryCallback iStarryDiscoveryCallback)`
