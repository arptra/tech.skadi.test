package com.upuphone.starrynet.strategy.message.payload;

import android.os.Bundle;
import com.upuphone.starrynet.api.StConstant;
import com.upuphone.starrynet.api.message.IMessageResponseListener;
import java.util.UUID;

public class PayloadMessage {
    protected String bleMac;
    protected UUID characterUUID;
    protected byte[] content;
    protected IMessageResponseListener innerListener;
    protected int msgType;
    protected UUID serviceUUID;
    protected String wrapperMessage = null;

    public PayloadMessage(String str, byte[] bArr, int i, UUID uuid, UUID uuid2, IMessageResponseListener iMessageResponseListener) {
        this.bleMac = str;
        this.content = bArr;
        this.msgType = i;
        this.serviceUUID = uuid;
        this.characterUUID = uuid2;
        if (i == 1) {
            this.wrapperMessage = new String(bArr);
        }
        this.innerListener = iMessageResponseListener;
    }

    public static Bundle buildReceiveData2Bundle(String str, UUID uuid, UUID uuid2, int i, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putInt(StConstant.KEY_PAYLOAD_MESSAGE_MSG_TYPE, i);
        bundle.putByteArray("bytes", bArr);
        bundle.putString(StConstant.KEY_PAYLOAD_MESSAGE_BLE_MAC, str);
        bundle.putString(StConstant.KEY_PAYLOAD_MESSAGE_SERVICE_UUID, uuid.toString());
        bundle.putString(StConstant.KEY_PAYLOAD_MESSAGE_CHARACTER_UUID, uuid2.toString());
        return bundle;
    }

    public static PayloadMessage parseBundle(Bundle bundle, IMessageResponseListener iMessageResponseListener) {
        return new PayloadMessage(bundle.getString(StConstant.KEY_PAYLOAD_MESSAGE_BLE_MAC), bundle.getByteArray("bytes"), bundle.getInt(StConstant.KEY_PAYLOAD_MESSAGE_MSG_TYPE), UUID.fromString(bundle.getString(StConstant.KEY_PAYLOAD_MESSAGE_SERVICE_UUID)), UUID.fromString(bundle.getString(StConstant.KEY_PAYLOAD_MESSAGE_CHARACTER_UUID)), iMessageResponseListener);
    }

    public String getBleMac() {
        return this.bleMac;
    }

    public UUID getCharacterUUID() {
        return this.characterUUID;
    }

    public byte[] getContent() {
        return this.content;
    }

    public IMessageResponseListener getInnerListener() {
        return this.innerListener;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public UUID getServiceUUID() {
        return this.serviceUUID;
    }

    public String getWrapperMessage() {
        return this.wrapperMessage;
    }

    public boolean isHidData() {
        return this.msgType == 2;
    }

    public boolean isNeedCustomParse() {
        return this.msgType == 1;
    }
}
