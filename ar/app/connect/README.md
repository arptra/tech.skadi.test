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

Send the MYVU WAKE packet (FEE0/FEE1, CRC16) directly from the laptop once the glasses are advertising:

```bash
python -m ar.app.connect.myvu_wake
```

The script scans for the `0000fee0-0000-1000-8000-00805f9b34fb` service (or the nearest unknown device), builds the WAKE frame with timestamp/nonce plus CRC16-IBM, and writes it to the `0000fee1-0000-1000-8000-00805f9b34fb` characteristic without response while printing the full packet in hex.

If the selected device does not expose the expected FEE1 characteristic after connecting, the script now prints every discovered service/characteristic pair so you can verify whether the glasses are advertising the correct GATT table (e.g., when they are paired only as a headset) before retrying.

### How to run the MYVU wake sender step-by-step

1. Install dependencies once so the package imports resolve:
   ```bash
   pip install -e .
   ```
2. Make sure Bluetooth is enabled on macOS and the glasses are powered on/advertising.
3. Run the wake sender from the repo root (the scan window defaults to 10s):
   ```bash
   python -m ar.app.connect.myvu_wake
   ```
   The script will:
   * scan for the `0000fee0-0000-1000-8000-00805f9b34fb` service (or fall back to the strongest unknown device),
   * build the WAKE packet with the required timestamp, nonce, and CRC16-IBM trailer,
   * write it via `0000fee1-0000-1000-8000-00805f9b34fb` using **write without response**, and
   * print the full packet bytes in hex before disconnecting.
4. If you need a longer discovery window, rerun with `--scan-timeout 15`.

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

## If you already paired them as a headset

When macOS shows the glasses as a headset (HFP/A2DP), you still need the BLE data channel to push messages or media. Do the following:

1. **Get the BLE address/UUID** using the scanner (match the name you see in Bluetooth settings, e.g., `DR-01`):
   ```bash
   python -m ar.app.connect.scanner --prefix "DR"
   ```
   Note the address shown in brackets (example: `5549FA62-DF3F-9F6A-5D13-7F760F63A12C`).
2. **Connect directly by address** and open the data channel, even while the audio profile is connected:
   ```bash
   python -m ar.app.connect.connect_manager \
     --mode ble \
     --address 5549FA62-DF3F-9F6A-5D13-7F760F63A12C \
     --service 00002000-0000-1000-8000-00805F9B34FB \
     --tx 00002002-0000-1000-8000-00805F9B34FB \
     --rx 00002001-0000-1000-8000-00805F9B34FB \
     --notify 00002001-0000-1000-8000-00805F9B34FB 00002002-0000-1000-8000-00805F9B34FB \
     --send "hello from mac"
   ```
3. **Stream an image or video** over the same BLE link once it connects:
   ```bash
   python -m ar.app.connect.media_test \
     --file demo.png \
     --mode ble \
     --address 5549FA62-DF3F-9F6A-5D13-7F760F63A12C \
     --chunk-size 180 \
     --pause 0.05
   ```

If the address changes after re-pairing, rerun the scanner to grab the updated value. Keeping the glasses powered on and in pairing/advertising mode ensures the BLE side stays visible even when the audio profile is already connected.

## If your Mac cannot see the glasses but your phone can

1. Make sure the glasses are **not already paired** to the phone (forget/disconnect them on the phone first).
2. **Power-cycle the glasses** into pairing mode (long-press the power button until they re-advertise).
3. Toggle Bluetooth **off/on on the Mac** to refresh CoreBluetooth and reopen the scan window.
4. Re-run the scanner with a **longer discovery window**, e.g. `python -m ar.app.connect.scanner --scan-timeout 15`.
5. If you renamed the glasses, pass the exact prefix: `python -m ar.app.connect.scanner --prefix "GLASSES"`.

On macOS the scanner logs an extra hint when no glasses are detected; follow the steps above so the Mac can see the device once it is advertising again.
