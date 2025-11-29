package com.upuphone.starrynet.strategy.message;

import Starry.StarryLinkEncrypt;
import android.os.Bundle;
import com.google.protobuf.ByteString;
import com.upuphone.starrynet.api.StConstant;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.api.message.IMessageResponseListener;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import java.security.InvalidParameterException;

public class MessageHandler {
    private static final String TAG = "MessageHandler";

    private byte[] buildNormalMessage(StarryLinkEncrypt.COMMAND command, byte[] bArr) {
        return StarryLinkEncrypt.LinkProtocol.newBuilder().setDeviceId(ByteString.copyFrom(BleUtil.dealDeviceId(StarryNetData.getInstance().getIdentifier()))).setCmd(command).setData(ByteString.copyFrom(bArr)).build().toByteArray();
    }

    private byte[] encryptMessage(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        return buildNormalMessage(StarryLinkEncrypt.COMMAND.EXTERNAL_MESSAGE_ENCRYPT, EncryptionUtil.encrypt(bArr, bArr2, bArr3, i));
    }

    private static int msgMode2PacketType(int i) {
        return i != 2 ? 0 : 1;
    }

    public StarryMessage parse(Bundle bundle, IMessageResponseListener iMessageResponseListener) throws InvalidParameterException {
        if (bundle == null) {
            throw new InvalidParameterException("bundle cannot be null");
        } else if (bundle.containsKey("bytes")) {
            byte[] byteArray = bundle.getByteArray("bytes");
            if (bundle.containsKey("identifier")) {
                byte[] byteArray2 = bundle.getByteArray("identifier");
                boolean z = true;
                int i = bundle.getInt(StConstant.STARRY_MESSAGE_MODE, 1);
                StarryMessage starryMessage = new StarryMessage(byteArray, byteArray2, msgMode2PacketType(i), iMessageResponseListener);
                starryMessage.setOpCode(bundle.getInt(StConstant.STARRY_MESSAGE_OP_CODE, 3));
                if (i != 3) {
                    z = false;
                }
                starryMessage.setNeedEncrypt(z);
                starryMessage.setNeedSendAtOnce(bundle.getBoolean("sendAtOnce", false));
                StDevice device = StarryDeviceManager.getInstance().getDevice(byteArray2);
                if (device != null) {
                    starryMessage.setPeerBleMac(device.getBleMac());
                }
                return starryMessage;
            }
            throw new InvalidParameterException("bundle cannot find key:identifier");
        } else {
            throw new InvalidParameterException("bundle cannot find key:bytes");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void prepareAirMessage(com.upuphone.starrynet.strategy.message.StarryMessage r4) {
        /*
            r3 = this;
            int r3 = r4.getOpCode()
            if (r3 != 0) goto L_0x000a
            r3 = 2
            r4.setOpCode(r3)
        L_0x000a:
            com.upuphone.starrynet.strategy.StarryNetData r3 = com.upuphone.starrynet.strategy.StarryNetData.getInstance()
            boolean r3 = r3.isBleServer()
            r0 = 1
            r1 = 0
            if (r3 == 0) goto L_0x002c
            r4.setTerminalType(r0)
            java.lang.String r3 = r4.getPeerBleMac()
            if (r3 == 0) goto L_0x0042
            com.upuphone.starrynet.core.ble.server.BleServerCache r3 = com.upuphone.starrynet.core.ble.server.BleServerCache.getInstance()
            java.lang.String r2 = r4.getPeerBleMac()
            int r3 = r3.getMtu(r2)
            goto L_0x0043
        L_0x002c:
            r4.setTerminalType(r1)
            java.lang.String r3 = r4.getPeerBleMac()
            if (r3 == 0) goto L_0x0042
            com.upuphone.starrynet.core.ble.client.BleClientCache r3 = com.upuphone.starrynet.core.ble.client.BleClientCache.getInstance()
            java.lang.String r2 = r4.getPeerBleMac()
            int r3 = r3.getMtuSize(r2)
            goto L_0x0043
        L_0x0042:
            r3 = r1
        L_0x0043:
            if (r3 <= 0) goto L_0x0056
            byte[] r2 = r4.getContent()
            int r2 = r2.length
            int r3 = r3 + -7
            if (r2 > r3) goto L_0x0052
            r4.setSizeStatus(r1)
            goto L_0x005d
        L_0x0052:
            r4.setSizeStatus(r0)
            goto L_0x005d
        L_0x0056:
            java.lang.String r3 = "MessageHandler"
            java.lang.String r4 = "prepare, mtu is zero!"
            com.upuphone.starrynet.common.StLog.w(r3, r4)
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.message.MessageHandler.prepareAirMessage(com.upuphone.starrynet.strategy.message.StarryMessage):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void prepareMessage(com.upuphone.starrynet.strategy.message.StarryMessage r8) {
        /*
            r7 = this;
            com.upuphone.starrynet.strategy.StarryNetData r0 = com.upuphone.starrynet.strategy.StarryNetData.getInstance()
            boolean r0 = r0.isBleServer()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0022
            r8.setTerminalType(r1)
            java.lang.String r0 = r8.getPeerBleMac()
            if (r0 == 0) goto L_0x0038
            com.upuphone.starrynet.core.ble.server.BleServerCache r0 = com.upuphone.starrynet.core.ble.server.BleServerCache.getInstance()
            java.lang.String r3 = r8.getPeerBleMac()
            int r0 = r0.getMtu(r3)
            goto L_0x0039
        L_0x0022:
            r8.setTerminalType(r2)
            java.lang.String r0 = r8.getPeerBleMac()
            if (r0 == 0) goto L_0x0038
            com.upuphone.starrynet.core.ble.client.BleClientCache r0 = com.upuphone.starrynet.core.ble.client.BleClientCache.getInstance()
            java.lang.String r3 = r8.getPeerBleMac()
            int r0 = r0.getMtuSize(r3)
            goto L_0x0039
        L_0x0038:
            r0 = r2
        L_0x0039:
            if (r0 <= 0) goto L_0x008e
            boolean r3 = r8.isNeedEncrypt()
            if (r3 == 0) goto L_0x006a
            com.upuphone.starrynet.strategy.data.StarryDeviceManager r3 = com.upuphone.starrynet.strategy.data.StarryDeviceManager.getInstance()
            byte[] r4 = r8.getId()
            com.upuphone.starrynet.strategy.bean.StConnectDevice r3 = r3.getConnectDevice((byte[]) r4)
            if (r3 != 0) goto L_0x0053
            r8.setNeedEncrypt(r2)
            goto L_0x006a
        L_0x0053:
            byte[] r4 = r8.getContent()
            byte[] r5 = r3.getSecret()
            byte[] r6 = r3.getParam()
            int r3 = r3.getEncrypt()
            byte[] r3 = r7.encryptMessage(r4, r5, r6, r3)
            r8.setContent(r3)
        L_0x006a:
            boolean r3 = r8.isNeedEncrypt()
            if (r3 != 0) goto L_0x007d
            Starry.StarryLinkEncrypt$COMMAND r3 = Starry.StarryLinkEncrypt.COMMAND.EXTERNAL_MESSAGE_NORMAL
            byte[] r4 = r8.getContent()
            byte[] r7 = r7.buildNormalMessage(r3, r4)
            r8.setContent(r7)
        L_0x007d:
            byte[] r7 = r8.getContent()
            int r7 = r7.length
            int r0 = r0 + -3
            if (r7 > r0) goto L_0x008a
            r8.setSizeStatus(r2)
            goto L_0x0095
        L_0x008a:
            r8.setSizeStatus(r1)
            goto L_0x0095
        L_0x008e:
            java.lang.String r7 = "MessageHandler"
            java.lang.String r8 = "prepare, mtu is zero!"
            com.upuphone.starrynet.common.StLog.w(r7, r8)
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.message.MessageHandler.prepareMessage(com.upuphone.starrynet.strategy.message.StarryMessage):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void prepareMessageV2(com.upuphone.starrynet.strategy.message.StarryMessage r4) {
        /*
            r3 = this;
            com.upuphone.starrynet.strategy.StarryNetData r3 = com.upuphone.starrynet.strategy.StarryNetData.getInstance()
            boolean r3 = r3.isBleServer()
            r0 = 1
            r1 = 0
            if (r3 == 0) goto L_0x0022
            r4.setTerminalType(r0)
            java.lang.String r3 = r4.getPeerBleMac()
            if (r3 == 0) goto L_0x0038
            com.upuphone.starrynet.core.ble.server.BleServerCache r3 = com.upuphone.starrynet.core.ble.server.BleServerCache.getInstance()
            java.lang.String r2 = r4.getPeerBleMac()
            int r3 = r3.getMtu(r2)
            goto L_0x0039
        L_0x0022:
            r4.setTerminalType(r1)
            java.lang.String r3 = r4.getPeerBleMac()
            if (r3 == 0) goto L_0x0038
            com.upuphone.starrynet.core.ble.client.BleClientCache r3 = com.upuphone.starrynet.core.ble.client.BleClientCache.getInstance()
            java.lang.String r2 = r4.getPeerBleMac()
            int r3 = r3.getMtuSize(r2)
            goto L_0x0039
        L_0x0038:
            r3 = r1
        L_0x0039:
            if (r3 <= 0) goto L_0x004c
            byte[] r2 = r4.getContent()
            int r2 = r2.length
            int r3 = r3 + -7
            if (r2 > r3) goto L_0x0048
            r4.setSizeStatus(r1)
            goto L_0x0053
        L_0x0048:
            r4.setSizeStatus(r0)
            goto L_0x0053
        L_0x004c:
            java.lang.String r3 = "MessageHandler"
            java.lang.String r4 = "prepare, mtu is zero!"
            com.upuphone.starrynet.common.StLog.w(r3, r4)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.message.MessageHandler.prepareMessageV2(com.upuphone.starrynet.strategy.message.StarryMessage):void");
    }
}
