# Laptop connector for the smart glasses

This directory contains a lightweight Python client that mirrors the discovery, connection, and message exchange patterns used by the Android `StarryNetHelper` utilities. The Android app initializes the StarryNet stack once, registers discovery triggers, and starts BLE discovery whenever both network/login state are satisfied. For laptop control, you can run the same flow with BLE or fall back to USB serial.

## Quick start

```bash
pip install bleak pyserial
python -m ar.app.connect.connect_manager \
  --mode ble \
  --service 00002000-0000-1000-8000-00805F9B34FB \
  --tx 00002002-0000-1000-8000-00805F9B34FB \
  --rx 00002001-0000-1000-8000-00805F9B34FB \
  --notify 00002001-0000-1000-8000-00805F9B34FB 00002002-0000-1000-8000-00805F9B34FB
```

Scan the surrounding BLE devices and highlight any glasses matches:

```bash
python -m ar.app.connect.scanner
```

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
