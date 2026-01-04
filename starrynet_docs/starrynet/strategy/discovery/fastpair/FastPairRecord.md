# FastPairRecord

*Пакет:* `com.upuphone.starrynet.strategy.discovery.fastpair`\n
*Источник:* `starrynet/strategy/discovery/fastpair/FastPairRecord.java`\n
*Тип:* Class

## Назначение
Класс FastPairRecord управляет логикой, связанной с FastPairRecord.

## Поля
- `String TAG`
- `List mActiveDisconnectPad`
- `boolean mIsNotify`
- `HashMap mPairRecords`

## Методы
- `public static FastPairRecord getInstance()`
- `public void addPairRecord(byte bArr, int i)`
- `public void clearPairRecord()`
- `public boolean getNotifyLabel()`
- `public int getPairRecord(byte bArr)`
- `public boolean isActiveDisconnectPad(String str)`
- `public void removeActiveDisconnectPad(String str)`
- `public void removeAllActiveDisconnectPad()`
- `public void removePairRecord(byte bArr)`
- `public void setActiveDisconnectPad(String str)`
- `public void setNotifyLabel(boolean z)`
- `private FastPairRecord()`
