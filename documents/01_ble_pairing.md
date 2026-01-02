# 01. BLE pairing: advertising и идентификация

## Advertising / manufacturer data
В JSON-дампе `1_phase_pair_connection_log.json` отсутствуют LE Advertising Report события, поэтому реальный RAW-пакет сканирования не зафиксирован. Единственное, что видно — сервисы и характеристики уже после подключения. Из-за отсутствия события `_evt.le_meta_subevent=0x02` manufacturer data остается **UNKNOWN**.

## Почему устройство определяется как MYVU DCB1
После установления канала GATT читается стандартная характеристика Device Name (UUID 0x2a00). Запросы `Read Request (0x08)` идут по handle-ам с UUID 0x2a00/0x2a01 в районе кадров 12214–12230, а лог сообщает имя `MYVU DCB1`, что и используется приложением для выбора цели.
