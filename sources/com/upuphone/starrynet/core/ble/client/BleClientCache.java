package com.upuphone.starrynet.core.ble.client;

import com.upuphone.starrynet.core.ble.BluetoothConstants;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class BleClientCache {
    private static final String KEY_CHARACTER_CATEGORY = "message.category";
    private static final String KEY_IS_CLIENT_REQUEST = ".isClientRequest";
    private static final String KEY_MTU = ".mtu";
    private Map<String, Object> objectMap;

    public static class Holder {
        public static final BleClientCache INSTANCE = new BleClientCache();

        private Holder() {
        }
    }

    private boolean getBoolean(String str, boolean z) {
        Object obj = this.objectMap.get(str);
        return !(obj instanceof Boolean) ? z : ((Boolean) obj).booleanValue();
    }

    public static BleClientCache getInstance() {
        return Holder.INSTANCE;
    }

    private int getInt(String str, int i) {
        Object obj = this.objectMap.get(str);
        return !(obj instanceof Integer) ? i : ((Integer) obj).intValue();
    }

    private void putBoolean(String str, boolean z) {
        this.objectMap.put(str, Boolean.valueOf(z));
    }

    public void clearCharacterCategory(String str) {
        Map<String, Object> map = this.objectMap;
        map.remove(str + KEY_CHARACTER_CATEGORY);
    }

    public void clearMtu(String str) {
        Map<String, Object> map = this.objectMap;
        map.remove(str + KEY_MTU);
    }

    public int getCharacterCategory(String str) {
        return getInt(str + KEY_CHARACTER_CATEGORY, -1);
    }

    public int getMtuSize(String str) {
        Map<String, Object> map = this.objectMap;
        Object obj = map.get(str + KEY_MTU);
        if (!(obj instanceof Integer)) {
            return 23;
        }
        return ((Integer) obj).intValue();
    }

    public boolean isClientConnected(String str) {
        return getBoolean(str + ".isConnected", false);
    }

    public boolean isClientReady(String str) {
        return getBoolean(str + ".ready", false);
    }

    public boolean isClientRequest(String str) {
        return getBoolean(str + KEY_IS_CLIENT_REQUEST, false);
    }

    public boolean isExternalDevice(String str) {
        return getBoolean(str + ".external.device", false);
    }

    public void markExternalDevice(String str, boolean z) {
        putBoolean(str + ".external.device", z);
    }

    public void putClientConnected(String str, boolean z) {
        putBoolean(str + ".isConnected", z);
    }

    public void putReadyClient(String str, boolean z) {
        putBoolean(str + ".ready", z);
    }

    public void updateDiscoveryServiceInfo(String str, UUID uuid) {
        int i = getInt(str + KEY_CHARACTER_CATEGORY, -1);
        int i2 = (BluetoothConstants.STARRY_NET_AIR_INTERNAL_MESSAGE_UUID.equals(uuid) || BluetoothConstants.STARRY_NET_AIR_EXTERNAL_MESSAGE_UUID.equals(uuid)) ? 2 : (BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID.equals(uuid) || BluetoothConstants.STARRY_NET_WRITE_MESSAGE_UUID.equals(uuid)) ? 0 : i;
        if (i2 > i) {
            Map<String, Object> map = this.objectMap;
            map.put(str + KEY_CHARACTER_CATEGORY, Integer.valueOf(i2));
        }
    }

    public void updateIsClientRequest(String str, boolean z) {
        putBoolean(str + KEY_IS_CLIENT_REQUEST, z);
    }

    public void updateMtu(String str, int i) {
        Map<String, Object> map = this.objectMap;
        map.put(str + KEY_MTU, Integer.valueOf(i));
    }

    private BleClientCache() {
        this.objectMap = new ConcurrentHashMap();
    }
}
