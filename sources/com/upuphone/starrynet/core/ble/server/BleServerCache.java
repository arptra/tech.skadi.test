package com.upuphone.starrynet.core.ble.server;

import com.upuphone.starrynet.core.ble.BluetoothConstants;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class BleServerCache {
    private static final String DEFAULT_OPEN_SERVER_DONE_KEY = "key.open.server.done";
    private static final String DEFAULT_PHYSICS_CONNECT_STATUS_KEY = "key.server.physics.connect.status.";
    private static final String KEY_CHARACTER_CATEGORY = "message.category";
    private static final String KEY_MTU = ".mtu";
    private static final String LOGIC_SERVER_CONNECT_4_IOS_KEY = "key.logic.ios.connect.status.";
    Map<String, Object> cache;

    public static class Holder {
        public static final BleServerCache INSTANCE = new BleServerCache();

        private Holder() {
        }
    }

    public static BleServerCache getInstance() {
        return Holder.INSTANCE;
    }

    private int getInt(String str, int i) {
        Object obj = this.cache.get(str);
        return !(obj instanceof Integer) ? i : ((Integer) obj).intValue();
    }

    public void clearCharacterCategory(String str) {
        Map<String, Object> map = this.cache;
        map.remove(str + KEY_CHARACTER_CATEGORY);
    }

    public void clearMtu(String str) {
        Map<String, Object> map = this.cache;
        map.remove(str + KEY_MTU);
    }

    public void clearServerLogicConnected4IOS(String str) {
        Map<String, Object> map = this.cache;
        map.remove(LOGIC_SERVER_CONNECT_4_IOS_KEY + str);
    }

    public int getCharacterCategory(String str) {
        return getInt(str + KEY_CHARACTER_CATEGORY, -1);
    }

    public synchronized int getMtu(String str) {
        Map<String, Object> map = this.cache;
        Object obj = map.get(str + KEY_MTU);
        if (!(obj instanceof MtuObject)) {
            return 23;
        }
        return ((MtuObject) obj).getProtocolMtu();
    }

    public int isServerLogicConnected4IOS(String str) {
        Map<String, Object> map = this.cache;
        Object obj = map.get(LOGIC_SERVER_CONNECT_4_IOS_KEY + str);
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? 1 : 0;
        }
        return 0;
    }

    public boolean isServerPhysicsConnected(String str) {
        Map<String, Object> map = this.cache;
        Object obj = map.get(DEFAULT_PHYSICS_CONNECT_STATUS_KEY + str);
        if (obj == null || !(obj instanceof Boolean)) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public boolean openServerDone() {
        Object obj = this.cache.get(DEFAULT_OPEN_SERVER_DONE_KEY);
        if (obj == null || !(obj instanceof Boolean)) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public synchronized void putActualMtu(String str, int i) {
        try {
            String str2 = str + KEY_MTU;
            Object obj = this.cache.get(str2);
            if (!(obj instanceof MtuObject)) {
                MtuObject mtuObject = new MtuObject();
                mtuObject.updateActualMtu(i);
                this.cache.put(str2, mtuObject);
            } else {
                ((MtuObject) obj).updateActualMtu(i);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void putExpectedMtu(String str, int i) {
        try {
            String str2 = str + KEY_MTU;
            Object obj = this.cache.get(str2);
            if (!(obj instanceof MtuObject)) {
                MtuObject mtuObject = new MtuObject();
                mtuObject.updateExpectedMtu(i);
                this.cache.put(str2, mtuObject);
            } else {
                ((MtuObject) obj).updateExpectedMtu(i);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void updateOpenNotifyUUID(String str, UUID uuid) {
        int i = getInt(str + KEY_CHARACTER_CATEGORY, -1);
        int i2 = (BluetoothConstants.STARRY_NET_AIR_INTERNAL_MESSAGE_UUID.equals(uuid) || BluetoothConstants.STARRY_NET_AIR_EXTERNAL_MESSAGE_UUID.equals(uuid)) ? 2 : (BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID.equals(uuid) || BluetoothConstants.STARRY_NET_WRITE_MESSAGE_UUID.equals(uuid)) ? 0 : i;
        if (i2 > i) {
            Map<String, Object> map = this.cache;
            map.put(str + KEY_CHARACTER_CATEGORY, Integer.valueOf(i2));
        }
    }

    public void updateOpenServerDone(boolean z) {
        this.cache.put(DEFAULT_OPEN_SERVER_DONE_KEY, Boolean.valueOf(z));
    }

    public void updatePhysicsConnectStatus(String str, boolean z) {
        Map<String, Object> map = this.cache;
        map.put(DEFAULT_PHYSICS_CONNECT_STATUS_KEY + str, Boolean.valueOf(z));
    }

    public void updateServerLogicConnected4IOS(String str, boolean z) {
        Map<String, Object> map = this.cache;
        map.put(LOGIC_SERVER_CONNECT_4_IOS_KEY + str, Boolean.valueOf(z));
    }

    private BleServerCache() {
        this.cache = new ConcurrentHashMap();
    }
}
