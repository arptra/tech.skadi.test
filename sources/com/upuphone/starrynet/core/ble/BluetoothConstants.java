package com.upuphone.starrynet.core.ble;

import com.upuphone.starrynet.core.ble.utils.UUIDUtils;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuBaseService;

public class BluetoothConstants {
    public static final UUID BATTERY_LEVEL_CHARACTER = UUIDUtils.makeUUID(10777);
    public static final UUID BATTERY_SERVICE = UUIDUtils.makeUUID(6159);
    public static final UUID CLIENT_CHARACTERISTIC_CONFIG = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    public static final byte CONFIG_OPCODE_DISCONNECT_CLIENT = 1;
    public static final UUID DEVICE_INFORMATION_SERVICE = UUIDUtils.makeUUID(6154);
    public static final String KEY_BYTES = "key_bytes";
    public static final String KEY_CHARACTER_VALUE = "key_character_value";
    public static final String KEY_CODE = "key_code";
    public static final String KEY_MTU = "key_mtu";
    public static final int MANU_ID = 3025;
    public static final UUID MODEL_NUMBER_CHARACTER = UUIDUtils.makeUUID(10788);
    public static final UUID STARRY_NET_AIR_EXTERNAL_MESSAGE_UUID = UUIDUtils.makeUUID(8225);
    public static final UUID STARRY_NET_AIR_INTERNAL_MESSAGE_UUID = UUIDUtils.makeUUID(8224);
    public static final UUID STARRY_NET_AIR_URGENT_EXTERNAL_MESSAGE_UUID = UUIDUtils.makeUUID(8226);
    public static final UUID STARRY_NET_GLASS_WRITE_UUID = UUIDUtils.makeUUID(8227);
    public static final UUID STARRY_NET_MULTI_WRITE_UUID;
    public static final UUID STARRY_NET_READ_CONFIG_UUID = UUIDUtils.makeUUID((int) DfuBaseService.ERROR_FILE_NOT_FOUND);
    public static final UUID STARRY_NET_READ_UUID = UUIDUtils.makeUUID(4096);
    public static final UUID STARRY_NET_SERVICE_UUID = UUIDUtils.makeUUID(3025);
    public static final UUID STARRY_NET_V2_EXTERNAL_MESSAGE_UUID = UUIDUtils.makeUUID(8209);
    public static final UUID STARRY_NET_V2_INTERNAL_MESSAGE_UUID = UUIDUtils.makeUUID(8208);
    public static final UUID STARRY_NET_V2_URGENT_EXTERNAL_MESSAGE_UUID = UUIDUtils.makeUUID(8210);
    public static final UUID STARRY_NET_WRITE_MESSAGE_UUID;
    public static final UUID STARRY_NET_WRITE_UUID = UUIDUtils.makeUUID(8192);
    public static final int STATUS_CONNECTED = 16;
    public static final int STATUS_DISCONNECTED = 32;
    public static final List<UUID> XR_NOTIFY_UUIDS;

    static {
        UUID makeUUID = UUIDUtils.makeUUID(8194);
        STARRY_NET_WRITE_MESSAGE_UUID = makeUUID;
        UUID makeUUID2 = UUIDUtils.makeUUID(8193);
        STARRY_NET_MULTI_WRITE_UUID = makeUUID2;
        XR_NOTIFY_UUIDS = Arrays.asList(new UUID[]{makeUUID2, makeUUID});
    }

    private BluetoothConstants() {
    }
}
