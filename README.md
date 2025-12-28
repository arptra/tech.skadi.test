# MYVU BLE diagnostic client

Android Kotlin app that performs BLE advertising scan, identifies MYVU glasses strictly by advertising payload, connects with a deterministic GATT state machine, executes the vendor handshake writes, and then lets Android drive Classic Bluetooth pairing.

[Документация: модуль подключения к очкам](documents/module_podklyucheniya_k_ochkam.md)

## Key terms
- **BLE Advertising**: broadcast packets sent without a connection.
- **BLE Scan**: listening for advertising packets.
- **Advertising payload**: bytes inside an advertisement (flags, service UUIDs, manufacturer data).
- **GATT**: BLE protocol for data exchange after connecting.
- **Classic Bluetooth Pairing (bonding)**: Android system pairing dialog (numeric comparison/SSP) that occurs after the BLE handshake.

## Preconditions
- Bluetooth must be ON.
- Permissions granted: `BLUETOOTH_SCAN`, `BLUETOOTH_CONNECT`, and `ACCESS_FINE_LOCATION` (needed on some OEMs to return scan results).
- Location services enabled if the device hides scan results without it.
- Official MYVU app must not be connected (force stop / toggle Bluetooth if needed).
- Glasses must be advertising/discoverable; if already paired or in another mode, advertising may be absent.

## UI controls
- **Найти очки** – start BLE scan (no filters).
- **Подключиться** – connect to the selected MYVU target via GATT.
- **Создать пару** – trigger `createBond()` after the BLE handshake (if the system has not already prompted pairing).
- **Отключиться** – close the current GATT session and clear the queue.

## Recognition rules
- Every scan result with RSSI > -80 is logged: MAC, RSSI, manufacturer IDs/data, raw advertising bytes.
- A device is considered MYVU only if:
  - Manufacturer Specific Data exists and matches the Hubei vendor pattern (manufacturer ID `0x02E1` with the first payload byte equaling the remaining length), **or**
  - MAC override match: `2C:6F:4E:00:DC:B1`.
- The best RSSI candidate is fixed as target; scan stops once selected and the target MAC/reason is logged.

## GATT & handshake constants (fixed)
- Service UUID16 `0x0BD1` → `00000bd1-0000-1000-8000-00805f9b34fb`.
- Notify/data characteristic UUID16 `0x2021` (value handle 0x0026, CCCD handle 0x0027).
- Control/write+notify characteristic UUID16 `0x2020` (value handle 0x0023, CCCD handle 0x0024).
- CCCD UUID16 `0x2902`, enable notify value `01 00`.
- Handshake start payload (write command to 0x2020): `00 00 06 11 01 00`.
- Both CCCDs must be written with notifications enabled before sending the start payload.

## State machine (exact)
`IDLE → SCANNING → DEVICE_FOUND → BLE_CONNECTING → BLE_CONNECTED → SERVICES_DISCOVERING → HANDSHAKE_WRITING → HANDSHAKE_DONE → WAITING_FOR_SYSTEM_PAIRING → BONDED → CONNECTED` or `ERROR`.

Forbidden transition: SCANNING → BONDING (bonding only after handshake). Errors surfaced as `ERROR:<reason>` where reason ∈ {SCAN_TIMEOUT, NO_MATCHING_ADVERTISING, GATT_CONNECT_FAILED, SERVICE_DISCOVERY_FAILED, HANDSHAKE_WRITE_FAILED, BONDING_FAILED, BONDING_TIMEOUT}.

## Timeouts
- Scan: 25s (NO_MATCHING_ADVERTISING or SCAN_TIMEOUT).
- GATT connect: 12s.
- Service discovery: 10s.
- Handshake writes (CCCD + start command): 10s.
- Bonding: 60s.

## How the flow runs
1. Tap **Найти очки**. Preconditions are checked; scan runs with no filters. Logs show every relevant advertisement and when the MYVU match hits.
2. After MYVU is fixed (best RSSI), **Подключиться** becomes enabled. Tap it to open GATT with `TRANSPORT_LE`.
3. `onConnectionStateChange → discoverServices`.
4. `onServicesDiscovered` locates service `0x0BD1`, characteristics `0x2021` (notify) and `0x2020` (write+notify), enables notifications on both CCCDs (0x0027 and 0x0024), then writes the start payload `00 00 06 11 01 00` to `0x2020` (with response).
5. After the write succeeds, state = HANDSHAKE_DONE then WAITING_FOR_SYSTEM_PAIRING. The system pairing dialog should appear; the app does **not** call `createBond()` automatically. Android drives SSP; the app only observes `ACTION_BOND_STATE_CHANGED`.
6. If bonding is needed manually, tap **Создать пару** to invoke `device.createBond()` (only allowed after HANDSHAKE_DONE). Bond transitions: BOND_NONE → BOND_BONDING → BOND_BONDED.
7. On `BOND_BONDED`, the app moves to BONDED then CONNECTED and stays ready for protocol analysis. Use **Отключиться** to tear down the session.

## Troubleshooting
- **No advertising found**: ensure glasses are in discoverable mode; toggle Bluetooth and rerun scan; check logs for manufacturer data.
- **Scan empty**: location services might be OFF on the handset; enable GPS/Network location and retry.
- **Pairing dialog missing**: verify the handshake writes completed (CCCD + start payload) in logs; then tap **Создать пару** to force `createBond()`.
- **GATT 133/connect fail**: the manager retries up to 3 times with cache refresh; if it persists, toggle Bluetooth and close the official app.
- **Bonding stuck**: bonding timeout is 60s; if it fails, clear the bond in Android settings and retry after re-running the handshake.

## Build/run notes
- Min SDK 26, target SDK 34+. No third-party BLE libraries.
- `local.properties` is generated from `ANDROID_HOME`/`ANDROID_SDK_ROOT` if absent; edit if your SDK path differs.
