# tech.skadi.test

## BLE Client App

This project is an Android BLE client for AR glasses that scans, bonds, connects, discovers services, negotiates MTU, enables notifications, and provides a simple UI for logging.

### How to run
1. Open this repository in Android Studio.
2. Let Gradle sync; build the `app` module targeting Android 12+.
3. Install on a device with BLE support (min SDK 26).
4. Launch the app and grant Bluetooth permissions when prompted.

### Using the app
1. Turn on the glasses and ensure they are not paired with another app.
2. Tap **Scan & Connect** to start scanning; the app prefers devices with names containing `MYVU` or `DCB1`.
3. Accept the system bonding prompt if shown.
4. Wait for the state machine to progress to **READY**; the log view will show service discovery, MTU change, and CCCD writes.
5. Tap **Send Test Command** to send a small payload (`01 00`) to the selected write characteristic.
6. Use **Disconnect** to close the GATT session cleanly.

### Troubleshooting
- **Device already connected to official app**: Disconnect from other apps or reboot the glasses; the client will fail to connect if another GATT session is active.
- **No notifications**: Confirm the characteristic exposes NOTIFY and that CCCD is present; check the log for CCCD write errors.
- **Bonding stuck**: Clear the pairing from Android settings and retry; the app listens for bond state changes and retries after failures.
- **GATT 133**: The client automatically retries up to three times with cache refresh; if it persists, toggle Bluetooth and try again.

