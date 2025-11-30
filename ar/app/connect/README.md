# Laptop connector for the smart glasses

This directory (`ar/app/connect`) contains a lightweight Python client that mirrors the discovery, connection, and message exchange patterns used by the Android `StarryNetHelper` utilities. The Android app initializes the StarryNet stack once, registers discovery triggers, and starts BLE discovery whenever both network/login state are satisfied. For laptop control, you can run the same flow with BLE or fall back to USB serial. Install the package once (editable mode recommended) so the `ar.app.connect` modules resolve no matter where you invoke them:

```bash
pip install -e .
```

## Quick start

```bash
python -m ar.app.connect.connect_manager \
  --mode ble \
  --service 00002000-0000-1000-8000-00805F9B34FB \
  --tx 00002002-0000-1000-8000-00805F9B34FB \
  --rx 00002001-0000-1000-8000-00805F9B34FB \
  --notify 00002001-0000-1000-8000-00805F9B34FB 00002002-0000-1000-8000-00805F9B34FB
```

Scan the surrounding BLE devices, highlight any glasses matches, and print their full details (address, RSSI, advertised UUIDs, metadata):

```bash
python -m ar.app.connect.scanner
```

The scan output ends with a summary of how many glasses candidates were matched. If none are found, re-run with
`--prefix` (to match your exact model name) or `--service` (to look for the 00002000 service) after powering the
glasses on and putting them into pairing mode.

If Bluetooth is off or blocked, the scanner prints a clear message and exits instead of crashing.

* Use `--prefix` to restrict the BLE scan to model name prefixes (defaults cover Air/AirPro/Star/MyVu/XR).
* Add `--send` to push an initial payload once the link is ready.
* `--tx` uses the primary write characteristic; `--notify` subscribes to both notify-capable UUIDs (00002001 and 00002002). An alternate no-response write path (OTA) is available on 00002001 if your payloads require it.
* Switch to USB with `--mode usb`; VID/PID filters can be set inside `config.py` if needed.

The BLE client performs a filtered scan, connects with automatic retries, optionally subscribes to notifications, and exposes `send` for writing to the configured characteristic. The USB client opens a serial port at the configured baud rate and provides simple `send`/`receive` helpers for wired control.

## Send a test image/video payload

Stream any local file (PNG/JPEG frame or an encoded video segment) to the glasses using the media tester. The defaults reuse the provided service/characteristic UUIDs:

```bash
python -m ar.app.connect.media_test \
  --file demo.png \
  --mode ble \
  --service 00002000-0000-1000-8000-00805F9B34FB \
  --tx 00002002-0000-1000-8000-00805F9B34FB \
  --rx 00002001-0000-1000-8000-00805F9B34FB \
  --notify 00002001-0000-1000-8000-00805F9B34FB 00002002-0000-1000-8000-00805F9B34FB
```

Use `--chunk-size` to fit within your MTU (defaults to 180 bytes) and `--pause` to throttle between writes so the glasses can render the incoming stream.

## How to use the toolkit end-to-end

1. **Install the package** (once per environment so `python -m ar.app.connect.*` works from any folder):
   ```bash
   pip install -e .
   ```
2. **Discover glasses nearby** (highlights names with the known prefixes and the `00002000` service):
   ```bash
   python -m ar.app.connect.scanner
   ```
3. **Pair and open a session** (BLE example with the provided service/characteristic UUIDs):
   ```bash
   python -m ar.app.connect.connect_manager \
     --mode ble \
     --service 00002000-0000-1000-8000-00805F9B34FB \
     --tx 00002002-0000-1000-8000-00805F9B34FB \
     --rx 00002001-0000-1000-8000-00805F9B34FB \
     --notify 00002001-0000-1000-8000-00805F9B34FB 00002002-0000-1000-8000-00805F9B34FB
   ```
   The CLI performs a filtered scan, connects, subscribes to both notify characteristics, and prints incoming notifications. Use `--send "payload"` to push an initial message after the link comes up.
4. **Send media for validation** (image/video stream with pacing controls):
   ```bash
   python -m ar.app.connect.media_test --file demo.png --chunk-size 180 --pause 0.05
   ```
5. **Prefer USB when wired** (stable during development):
   ```bash
   python -m ar.app.connect.connect_manager --mode usb --send "ping"
   ```
   Adjust USB VID/PID filters inside `config.py` if your adapter uses different IDs.
6. **Reuse programmatically** by importing the helpers (remember to run inside an event loop for BLE):
   ```python
   import asyncio
   from ar.app.connect import BleDeviceScanner, ConnectionManager, GlassMediaTester

   async def main():
       scanner = BleDeviceScanner()
       await scanner.scan_and_print()

       manager = ConnectionManager()
       client = await manager.connect_ble()
       await client.send(b"hello")

       tester = GlassMediaTester(manager)
       await tester.play_ble("demo.png")

   asyncio.run(main())
   ```

These steps mirror the on-device `StarryNetHelper` sequence: discover, connect, subscribe to notifications, and write payloads via the primary characteristic. All defaults are pre-filled with the glasses' GATT service and characteristic UUIDs so you can run the commands verbatim.
