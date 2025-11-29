package com.upuphone.starrynet.strategy.message.payload;

import android.text.TextUtils;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.message.IMessageResponseListener;
import com.upuphone.starrynet.api.message.IReceivePayloadMessageListener;
import com.upuphone.starrynet.core.ble.client.BleConnectManager;
import com.upuphone.starrynet.core.ble.client.response.BleWriteNoRespResponse;
import com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair;
import com.upuphone.xr.interconnect.Constants;
import java.util.HashMap;
import java.util.UUID;

public class SimplePayloadMessageManager {
    private static final UUID DATA_Characteristic = UUID.fromString(Constants.DATA_Characteristic);
    private static final UUID NOTIY_Characteristic = UUID.fromString(Constants.NOTIY_Characteristic);
    private static final UUID SERVICE_DATA = UUID.fromString(Constants.SERVICE_DATA);
    private static final String TAG = "SimplePayloadMessageManager";
    private static final byte[] mProtocolOpcodeMap = {1, RingSecurityPair.OPCODE_RING_PAIR, RingSecurityPair.OPCODE_RING_ENCRYPTED_DATA, 3, RingSecurityPair.OPCODE_PHONE_START_REMOVE_BOND};
    private static HashMap<UUID, UUID> mServiceRecorder;
    boolean mEnableEncryptionMode;
    private IReceivePayloadMessageListener mReceivePayloadMessageListener;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final SimplePayloadMessageManager instance = new SimplePayloadMessageManager();
    }

    private boolean checkIfInternalProtocolMessage(byte b) {
        for (byte b2 : mProtocolOpcodeMap) {
            if (b2 == b) {
                return true;
            }
        }
        return false;
    }

    private String getFormatedBleMac(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (str.length() != 12 || str.contains(AccountConstantKt.CODE_SEPARTOR)) {
            return null;
        }
        int i = 2;
        for (int i2 = 0; i2 < 5; i2++) {
            sb.insert(i, AccountConstantKt.CODE_SEPARTOR);
            i += 3;
        }
        return sb.toString().toUpperCase();
    }

    public static SimplePayloadMessageManager getInstance() {
        return Holder.instance;
    }

    public void registerReceivePayloadMessageListener(IReceivePayloadMessageListener iReceivePayloadMessageListener) {
        this.mReceivePayloadMessageListener = iReceivePayloadMessageListener;
    }

    public void sendPayloadMessage(PayloadMessage payloadMessage) {
        byte[] bArr;
        final IMessageResponseListener innerListener = payloadMessage.getInnerListener();
        String formatedBleMac = getFormatedBleMac(payloadMessage.getBleMac());
        UUID serviceUUID = payloadMessage.getServiceUUID();
        UUID characterUUID = payloadMessage.getCharacterUUID();
        byte[] content = payloadMessage.getContent();
        if (content != null && content.length != 0 && !TextUtils.isEmpty(formatedBleMac)) {
            if (this.mEnableEncryptionMode) {
                byte[] ClientDataEncrypt = RingSecurityPair.getInstance().ClientDataEncrypt(content, getFormatedBleMac(payloadMessage.bleMac));
                if (ClientDataEncrypt != null) {
                    byte[] bArr2 = new byte[(ClientDataEncrypt.length + 2)];
                    bArr2[0] = RingSecurityPair.OPCODE_RING_ENCRYPTED_DATA;
                    bArr2[1] = (byte) content.length;
                    System.arraycopy(ClientDataEncrypt, 0, bArr2, 2, ClientDataEncrypt.length);
                    bArr = bArr2;
                } else {
                    return;
                }
            } else {
                bArr = content;
            }
            BleConnectManager.getInstance().writeNoRsp(formatedBleMac, serviceUUID, characterUUID, bArr, new BleWriteNoRespResponse() {
                public void onResponse(int i, Void voidR) {
                    IMessageResponseListener iMessageResponseListener = innerListener;
                    if (iMessageResponseListener != null) {
                        if (i == 0) {
                            iMessageResponseListener.onSuccess();
                        } else {
                            iMessageResponseListener.onFail(i, "internal ble error!");
                        }
                    }
                }
            });
        } else if (innerListener != null) {
            innerListener.onFail(StErrorCode.PAYLOAD_MESSAGE_INVALID_PARAMS, "param error!");
        }
    }

    public void setEncryptionMode(boolean z) {
        this.mEnableEncryptionMode = z;
    }

    public void uploadMessage(byte[] bArr, String str) {
        if (this.mReceivePayloadMessageListener != null) {
            this.mReceivePayloadMessageListener.receivePlayloadMessage(PayloadMessage.buildReceiveData2Bundle(str.replace(AccountConstantKt.CODE_SEPARTOR, "").toLowerCase(), SERVICE_DATA, NOTIY_Characteristic, 0, bArr));
        }
    }

    private SimplePayloadMessageManager() {
        this.mReceivePayloadMessageListener = null;
        this.mEnableEncryptionMode = false;
        HashMap<UUID, UUID> hashMap = new HashMap<>();
        mServiceRecorder = hashMap;
        hashMap.put(SERVICE_DATA, NOTIY_Characteristic);
    }
}
