# DirectConnector

*Пакет:* `com.upuphone.starrynet.strategy.discovery.mdns`\n
*Источник:* `starrynet/strategy/discovery/mdns/DirectConnector.java`\n
*Тип:* Class

## Назначение
Класс DirectConnector управляет логикой, связанной с DirectConnector.

## Поля
- `DirectConnector directConnector`
- `IDirectConnectCallBack callBack`
- `MdnsStarryNetDiscovery discovery`

## Методы
- `public static synchronized DirectConnector getInstance()`
- `private void init()`
- `public void connect(StDevice stDevice)`
- `public void createServer(int i)`
- `public void setCallBack(IDirectConnectCallBack iDirectConnectCallBack)`
- `private DirectConnector()`
