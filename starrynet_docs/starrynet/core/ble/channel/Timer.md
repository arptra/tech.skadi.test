# Timer

*Пакет:* `com.upuphone.starrynet.core.ble.channel`\n
*Источник:* `starrynet/core/ble/channel/Timer.java`\n
*Тип:* Class

## Назначение
Класс Timer управляет логикой, связанной с Timer.

## Поля
- `TimerCallback mCallback`
- `Handler mHandler`

## Методы
- `public static Timer newInstance()`
- `public synchronized String getName()`
- `public synchronized boolean isRunning()`
- `public synchronized void resetCallback()`
- `public synchronized void start(TimerCallback timerCallback, long j)`
- `public synchronized void stop()`
- `private Timer()`
