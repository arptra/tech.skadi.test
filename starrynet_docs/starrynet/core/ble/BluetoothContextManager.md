# BluetoothContextManager

*Пакет:* `com.upuphone.starrynet.core.ble`\n
*Источник:* `starrynet/core/ble/BluetoothContextManager.java`\n
*Тип:* Class

## Назначение
Класс BluetoothContextManager управляет логикой, связанной с BluetoothContextManager.

## Поля
- `boolean isReleaseBuildType`
- `Context mContext`
- `HandlerThread mCoreBleThread`
- `Handler mHandler`

## Методы
- `public static Context getContext()`
- `public static Looper getCoreBleLooper()`
- `public static String getCurrentMethodName()`
- `public static boolean isReleaseBuild()`
- `public static void post(Runnable runnable)`
- `public static void postDelayed(Runnable runnable, long j)`
- `public static void setContext(Context context, boolean z)`
- `public String getName()`
