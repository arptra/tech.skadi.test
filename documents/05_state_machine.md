# 05. State machine приложения

## Состояния
* Idle — исходное состояние после reset.
* Scanning — активный BLE scan.
* DeviceFound — выбрана цель (фильтр по имени/рекламным данным).
* BleConnecting — GATT connect запущен.
* BleConnected — подключение установлено, ждём discovery.
* ServicesDiscovering — идёт GATT discovery.
* HandshakeWriting — включаются уведомления и отправляется стартовый пакет `00 00 06 11 01 00`.
* HandshakeDone — стартовый write завершён.
* WaitingForSystemPairing — установлен флаг ожидания bonding (авто или ручной триггер через кнопку Bond).
* Bonded — системная связка завершена.
* ApplicationInit — начало приложения: запуск команды `get_air_glass_info` и переход в рабочее меню очков.
* ApplicationReady — ответ на application-init получен, можно слать остальные команды.
* Disconnected — ручное/ошибочное разъединение.
* Error(reason) — любая ошибка (scan timeout, connect fail, handshake fail, bonding timeout и т.д.).

## Переходы и тайминги
* Idle → Scanning: `startScan()`; таймер 25 c, по истечении Error(NO_MATCHING_ADVERTISING).
* Scanning → DeviceFound: найдено рекламу/имя `MYVU DCB1`, сохраняется MAC.
* DeviceFound → BleConnecting: нажата кнопка Connect; таймер 12 c.
* BleConnecting → BleConnected → ServicesDiscovering: успешный connect.
* Сценарий A (устройство не спарено):
  * ServicesDiscovering → HandshakeWriting: сервис `0bd1` найден, подписка на 0x2020/0x2021; таймер discovery 10 c.
  * HandshakeWriting: включение CCCD, затем send START. Если WRITE_NR — HandshakeDone сразу; иначе ждём callback. Таймер handshake 10 c.
  * HandshakeDone → WaitingForSystemPairing: после первого notify/успешного write.
  * WaitingForSystemPairing → Bonded: системное событие BOND_BONDED (таймер 60 c).
  * Bonded → ApplicationInit: стартуем `get_air_glass_info`.
* Сценарий B (устройство уже спарено):
  * ServicesDiscovering → ApplicationInit: CCCD включены, handshake пропускается.
* ApplicationInit → ApplicationReady: получен ответ на `get_air_glass_info` (очки уходят с pairing-экрана в главное меню).
* Любая ошибка → Error(reason) с disconnect() и cleanup.

## Ошибки
* SCAN_TIMEOUT / NO_MATCHING_ADVERTISING — не найдено целевое устройство.
* GATT_CONNECT_FAILED — статус 133 или timeout.
* SERVICE_DISCOVERY_FAILED — сервис/характеристики не найдены.
* HANDSHAKE_WRITE_FAILED — не удалось включить CCCD или не пришёл notify.
* BONDING_TIMEOUT / BONDING_FAILED — системное спаривание не завершилось.
