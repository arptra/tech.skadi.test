package com.upuphone.starrynet.strategy.protocol;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.BleProtocolVersion;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.protocol.starrynet.StarryNetProtocol;

public class ProtocolVersions {
    public static final String PROTOCOL_KEY_BLE_VERSION = "b";
    public static final String PROTOCOL_KEY_CATEGORY_ID = "c";
    public static final String PROTOCOL_KEY_CONNECTION_VERSION = "v";
    public static final String PROTOCOL_KEY_ENCRYPT_TYPE = "e";
    public static final String PROTOCOL_KEY_IDENTIFIER = "i";
    public static final String PROTOCOL_KEY_MAX_MTU_SIZE = "m";
    private static final String TAG = "ProtocolVersions";
    private int bleVersion;
    private String categoryID;
    private int connectVersion;
    private int encryptType;
    private int maxMtuSize;
    private String selfIdentifier;

    public ProtocolVersions(String str) {
        this.selfIdentifier = str;
    }

    public static byte[] buildBytesFromVersions(ProtocolVersions protocolVersions) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(PROTOCOL_KEY_IDENTIFIER, protocolVersions.getSelfIdentifier());
        jsonObject.addProperty(PROTOCOL_KEY_CONNECTION_VERSION, (Number) Integer.valueOf(protocolVersions.getConnectVersion()));
        jsonObject.addProperty("e", (Number) Integer.valueOf(protocolVersions.getEncryptType()));
        jsonObject.addProperty(PROTOCOL_KEY_MAX_MTU_SIZE, (Number) Integer.valueOf(protocolVersions.getMaxMtuSize()));
        jsonObject.addProperty("b", (Number) Integer.valueOf(protocolVersions.getBleVersion()));
        jsonObject.addProperty("c", protocolVersions.getCategoryID());
        String jsonElement = jsonObject.toString();
        StLog.d(TAG, "version json=" + jsonElement);
        return jsonElement.getBytes();
    }

    public static ProtocolVersions buildOwnVersions() {
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        ProtocolVersions protocolVersions = new ProtocolVersions(ownDevice.getIdentifier2String());
        protocolVersions.setConnectVersion(StarryNetProtocol.PROTOCOL_CONNECT_VERSION_CURRENT);
        protocolVersions.setEncryptType(5);
        protocolVersions.setMaxMtuSize(512);
        protocolVersions.setBleVersion(BleProtocolVersion.sCurrentBleVersion);
        protocolVersions.setCategoryID(ownDevice.getCategoryID());
        return protocolVersions;
    }

    public static ProtocolVersions buildResponseVersions(ProtocolVersions protocolVersions) {
        int min = Math.min(protocolVersions.getConnectVersion(), StarryNetProtocol.PROTOCOL_CONNECT_VERSION_CURRENT);
        int encryptType2 = protocolVersions.getEncryptType() & 5;
        if (encryptType2 > 0) {
            int i = 0;
            while (encryptType2 != 1) {
                encryptType2 >>= 1;
                i++;
            }
            encryptType2 <<= i;
        }
        int min2 = Math.min(512, protocolVersions.getMaxMtuSize());
        int min3 = Math.min(protocolVersions.getBleVersion(), BleProtocolVersion.sCurrentBleVersion);
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        ProtocolVersions protocolVersions2 = new ProtocolVersions(ownDevice.getIdentifier2String());
        protocolVersions2.setConnectVersion(min);
        protocolVersions2.setEncryptType(encryptType2);
        protocolVersions2.setMaxMtuSize(min2);
        protocolVersions2.setBleVersion(min3);
        protocolVersions2.setCategoryID(ownDevice.getCategoryID());
        return protocolVersions2;
    }

    public static ProtocolVersions parseJson(String str) {
        JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
        String str2 = null;
        if (asJsonObject == null) {
            StLog.w(TAG, "parseJson error, data error, not json,detail:" + str);
            return null;
        }
        JsonElement jsonElement = asJsonObject.get(PROTOCOL_KEY_IDENTIFIER);
        if (jsonElement.isJsonNull()) {
            StLog.w(TAG, "data error, id element is null");
            return null;
        }
        String lowerCase = jsonElement.getAsString().toLowerCase();
        JsonElement jsonElement2 = asJsonObject.get(PROTOCOL_KEY_CONNECTION_VERSION);
        JsonElement jsonElement3 = asJsonObject.get("e");
        JsonElement jsonElement4 = asJsonObject.get(PROTOCOL_KEY_MAX_MTU_SIZE);
        JsonElement jsonElement5 = asJsonObject.get("b");
        JsonElement jsonElement6 = asJsonObject.get("c");
        ProtocolVersions protocolVersions = new ProtocolVersions(lowerCase);
        int i = -1;
        protocolVersions.setConnectVersion(jsonElement2 != null ? jsonElement2.getAsInt() : -1);
        protocolVersions.setEncryptType(jsonElement3 != null ? jsonElement3.getAsInt() : -1);
        if (jsonElement4 != null) {
            i = jsonElement4.getAsInt();
        }
        protocolVersions.setMaxMtuSize(i);
        protocolVersions.setBleVersion(jsonElement5 != null ? jsonElement5.getAsInt() : 1);
        if (jsonElement6 != null) {
            str2 = jsonElement6.getAsString();
        }
        protocolVersions.setCategoryID(str2);
        return protocolVersions;
    }

    public int getBleVersion() {
        return this.bleVersion;
    }

    public String getCategoryID() {
        return this.categoryID;
    }

    public int getConnectVersion() {
        return this.connectVersion;
    }

    public int getEncryptType() {
        return this.encryptType;
    }

    public int getMaxMtuSize() {
        return this.maxMtuSize;
    }

    public String getSelfIdentifier() {
        return this.selfIdentifier;
    }

    public void setBleVersion(int i) {
        this.bleVersion = i;
    }

    public void setCategoryID(String str) {
        this.categoryID = str;
    }

    public void setConnectVersion(int i) {
        this.connectVersion = i;
    }

    public void setEncryptType(int i) {
        this.encryptType = i;
    }

    public void setMaxMtuSize(int i) {
        this.maxMtuSize = i;
    }

    public void setSelfIdentifier(String str) {
        this.selfIdentifier = str;
    }
}
