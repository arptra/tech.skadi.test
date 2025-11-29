package com.upuphone.starrynet.strategy.message.payload;

import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.message.IMessageResponseListener;
import com.upuphone.starrynet.api.message.IReceivePayloadMessageListener;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.client.BleConnectManager;
import com.upuphone.starrynet.core.ble.client.response.BleWriteNoRespResponse;
import com.upuphone.starrynet.core.ble.event.BleEventBus;
import com.upuphone.starrynet.core.ble.event.CharacterChangedEvent;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import com.upuphone.starrynet.payload.PayloadProtocolMessage;
import com.upuphone.starrynet.strategy.message.payload.handler.IProtocolHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;

public class PayloadMessageManager implements EventReceiver {
    private static final String TAG = "PayloadMessageManager";
    private List<IProtocolHandler> mHandlers = new ArrayList();
    private IReceivePayloadMessageListener mReceivePayloadMessageListener = null;

    public static class Holder {
        public static final PayloadMessageManager instance = new PayloadMessageManager();
    }

    public PayloadMessageManager() {
        BleEventBus.get().register(CharacterChangedEvent.class, this);
    }

    private void directlySend(PayloadMessage payloadMessage) {
        final IMessageResponseListener innerListener = payloadMessage.getInnerListener();
        String bleMac = payloadMessage.getBleMac();
        UUID serviceUUID = payloadMessage.getServiceUUID();
        UUID characterUUID = payloadMessage.getCharacterUUID();
        byte[] content = payloadMessage.getContent();
        if (content == null || content.length == 0) {
            callbackError(innerListener, StErrorCode.PAYLOAD_MESSAGE_INVALID_PARAMS, "content cannot empty!");
        } else if (TextUtils.isEmpty(bleMac)) {
            callbackError(innerListener, StErrorCode.PAYLOAD_MESSAGE_INVALID_PARAMS, "bleMac cannot empty!");
        } else {
            BleConnectManager.getInstance().writeNoRsp(bleMac, serviceUUID, characterUUID, content, new BleWriteNoRespResponse() {
                public void onResponse(int i, Void voidR) {
                    if (i == 0) {
                        PayloadMessageManager.this.callbackSuccess(innerListener);
                    } else {
                        PayloadMessageManager.this.callbackError(innerListener, i, "internal ble error!");
                    }
                }
            });
        }
    }

    public static PayloadMessageManager getInstance() {
        return Holder.instance;
    }

    private void handleMessageByDestHandler(PayloadMessage payloadMessage, int i) {
        if (this.mHandlers.isEmpty()) {
            StLog.w(TAG, "handleProtocolMessage, but no handler register,then return !!!");
            return;
        }
        for (IProtocolHandler next : this.mHandlers) {
            if (next.getDeviceType() == i) {
                next.handleMessage(payloadMessage);
            }
        }
    }

    private void handleProtocolMessage(PayloadMessage payloadMessage, PayloadProtocolMessage payloadProtocolMessage) {
        if (this.mHandlers.isEmpty()) {
            StLog.w(TAG, "handleProtocolMessage, but no handler register,then return !!!");
            return;
        }
        int deviceType = payloadProtocolMessage.getDeviceType();
        for (IProtocolHandler next : this.mHandlers) {
            if (next.getDeviceType() == deviceType) {
                next.handleProtocolMessage(payloadMessage, payloadProtocolMessage);
            }
        }
    }

    private void receiveData(String str, UUID uuid, UUID uuid2, byte[] bArr) {
        boolean z;
        if (!this.mHandlers.isEmpty()) {
            Iterator<IProtocolHandler> it = this.mHandlers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                IProtocolHandler next = it.next();
                if (next.getServiceUUID().equals(uuid) && next.getCharacterUUID().equals(uuid2)) {
                    next.receiveData(str, bArr);
                    z = true;
                    break;
                }
            }
            if (!z && BluetoothConstants.BATTERY_SERVICE.equals(uuid)) {
                boolean z2 = false;
                for (IProtocolHandler next2 : this.mHandlers) {
                    if (next2.isSupportCommonService()) {
                        z2 |= next2.handleCommonService(str, uuid, uuid2, bArr);
                    }
                }
                z = z2;
            }
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        if (this.mReceivePayloadMessageListener != null) {
            this.mReceivePayloadMessageListener.receivePlayloadMessage(PayloadMessage.buildReceiveData2Bundle(str, uuid, uuid2, 0, bArr));
            return;
        }
        StLog.w(TAG, "receive data, but mReceivePayloadMessageListener is null, RunAsOne maybe not register the listener.");
    }

    private void updateHandlerListener() {
        if (!this.mHandlers.isEmpty()) {
            for (IProtocolHandler registerReceiveMessageListener : this.mHandlers) {
                registerReceiveMessageListener.registerReceiveMessageListener(this.mReceivePayloadMessageListener);
            }
        }
    }

    public void callbackError(IMessageResponseListener iMessageResponseListener, int i, String str) {
        if (iMessageResponseListener != null) {
            iMessageResponseListener.onFail(i, str);
        }
    }

    public void callbackSuccess(IMessageResponseListener iMessageResponseListener) {
        if (iMessageResponseListener != null) {
            iMessageResponseListener.onSuccess();
        }
    }

    public void onEvent(Object obj) {
        if (obj instanceof CharacterChangedEvent) {
            CharacterChangedEvent characterChangedEvent = (CharacterChangedEvent) obj;
            if (!BluetoothConstants.STARRY_NET_SERVICE_UUID.equals(characterChangedEvent.getService())) {
                receiveData(characterChangedEvent.getMac(), characterChangedEvent.getService(), characterChangedEvent.getCharacter(), characterChangedEvent.getValue());
            }
        }
    }

    public void registerProtocolHandler(IProtocolHandler iProtocolHandler) {
        if (iProtocolHandler != null) {
            if (this.mHandlers.isEmpty() || !this.mHandlers.contains(iProtocolHandler)) {
                this.mHandlers.add(iProtocolHandler);
                iProtocolHandler.registerReceiveMessageListener(this.mReceivePayloadMessageListener);
            }
        }
    }

    public void registerReceivePayloadMessageListener(IReceivePayloadMessageListener iReceivePayloadMessageListener) {
        this.mReceivePayloadMessageListener = iReceivePayloadMessageListener;
        updateHandlerListener();
    }

    public void sendInternalMessage(String str, int i, byte b, byte[] bArr, Consumer<byte[]> consumer) {
        List<IProtocolHandler> list = this.mHandlers;
        if (list == null || list.isEmpty()) {
            StLog.w(TAG, "sendInternalMessage ,found handlers is empty!!!");
            return;
        }
        for (IProtocolHandler next : this.mHandlers) {
            if (next.getDeviceType() == i) {
                next.sendInternalMessage(str, b, bArr, consumer);
            }
        }
    }

    public void sendMessage(PayloadMessage payloadMessage) {
        int i = payloadMessage.msgType;
        if (i == 0) {
            directlySend(payloadMessage);
        } else if (i == 1) {
            try {
                handleProtocolMessage(payloadMessage, new PayloadProtocolMessage(payloadMessage.content));
            } catch (JSONException e) {
                StLog.w(TAG, "payload message cannot convert to protocol message, may be wrong json format.", (Throwable) e);
                callbackError(payloadMessage.getInnerListener(), StErrorCode.PAYLOAD_MESSAGE_INVALID_JSON_STRING, "happen json exception");
            }
        } else if (i == 2) {
            handleMessageByDestHandler(payloadMessage, 2);
        }
    }

    public void unregisterProtocolHandler(IProtocolHandler iProtocolHandler) {
        if (!this.mHandlers.isEmpty() && this.mHandlers.contains(iProtocolHandler)) {
            this.mHandlers.remove(iProtocolHandler);
            iProtocolHandler.registerReceiveMessageListener((IReceivePayloadMessageListener) null);
        }
    }
}
