# Myvu BLE enablement toolkit

This toolkit helps reproduce the hidden-to-visible BLE transition of the Myvu glasses on macOS. It ships several CLI tools for scanning advertising frames, replaying wake/probe payloads, executing a protocol-driven handshake, and validating whether the expected hidden GATT services become available.

## Repository contents
- `myvu_ble_scan.py` — BLE scanner with filtering and manufacturer payload export.
- `myvu_enable_ble.py` — entrypoint for raw scans, manufacturer logging, wake/probe replay, and handshake execution using the protocol file.
- `myvu_verify.py` — verification helpers used by the enable flow and available as a standalone validator.
- `myvu_probe.py` — advertising capture/replay and mutation utilities for wake/probe experiments.
- `myvu_enable_ble_protocol.json` — protocol/schema describing filters, handshake steps, and success conditions.
- `myvu_classic_enable.py` — placeholder for any future Classic/RFCOMM enable logic (not automated yet).

## Protocol file
The protocol file controls device selection and handshake execution. Key sections:
- `device_filter`: target manufacturer IDs, name prefixes, and services to auto-select the device while avoiding Apple (0x004C).
- `ble.write_char_uuid` / `ble.notify_char_uuid`: default characteristics for writes and notifications.
- `ble.steps`: ordered handshake steps with `send_hex`, optional `write_char_uuid`, optional expected notification (`expect_notify_hex` or `expect_notify_prefix_hex`), and `timeout_ms`/`sleep_ms_after_write` timing controls.
- `success_condition`: expected services/characteristics after the handshake and a flag to force service discovery.

Populate the `ble.steps` and characteristic UUIDs from reverse-engineering findings; empty steps intentionally prevent accidental writes until the real sequence is known.

## Scanning for candidates
Run a filtered scan and display advertising metadata:
```bash
python3 myvu_ble_scan.py --timeout 8 --name-prefix myvu --min-rssi -80
```
Additional filters:
- `--service <uuid>`
- `--manufacturer-id 0x0BC1` (accepts hex or decimal)
- `--manufacturer-prefix-hex <hexprefix>`
- `--save-manufacturer payloads.json` (writes observed manufacturer payloads)

Results show address, local name, RSSI, service UUIDs, and manufacturer data in hex, sorted by RSSI.

## Capturing manufacturer payloads
To capture advertising payloads for later replay or mutation:
```bash
python3 myvu_ble_scan.py --timeout 10 --save-manufacturer payloads.json
```
The file lists address/name/RSSI/manufacturer payloads for each device that advertised manufacturer data.

## Running the wake/probe and handshake entrypoint
`myvu_enable_ble.py` orchestrates scanning, replay, and handshake steps using the protocol file. Common modes:

### Passive scan
```bash
python3 myvu_enable_ble.py --scan-raw --scan-timeout 8
```

### Log manufacturer data
```bash
python3 myvu_enable_ble.py --log-manufacturer payloads.json --scan-timeout 10
```

### Wake/probe replay or mutation
Replay captured advertising payloads (defaults to capturing if none provided):
```bash
python3 myvu_enable_ble.py --wake-probe --probe-payloads payloads.json --probe-interval 2.0
```
Add `--probe-mutate` to flip bits/bytes during replay and `--probe-manufacturer 0x0BC1` to override the manufacturer ID used while advertising.

### Execute handshake steps (requires populated protocol steps)
```bash
python3 myvu_enable_ble.py --enable --protocol myvu_enable_ble_protocol.json
```
- The tool auto-selects the device using the `device_filter` and refuses Apple devices.
- It subscribes to notifications (if `notify_char_uuid` is present), writes each step payload, waits for expected notifications, and performs service discovery.
- Success is reported only if the expected services/characteristics are found after the handshake.
Use `--address <mac_or_uuid>` to force a specific target.

### Verify after a handshake
```bash
python3 myvu_enable_ble.py --verify --scan-timeout 8
```
Runs the verification helper to rescan and/or connect (per protocol settings) to confirm whether hidden services became visible.

## Standalone verification
`myvu_verify.py` can validate advertising and, optionally, connect for service discovery:
```bash
python3 myvu_verify.py --protocol myvu_enable_ble_protocol.json --connect-verify --timeout 10
```
When connection is enabled, it checks for the expected services/characteristics after discovery.

## Notes
- All commands assume macOS with a working BLE adapter and Python environment capable of running `bleak`.
- Classic/RFCOMM automation is not implemented; `myvu_classic_enable.py` remains a stub for future work.
