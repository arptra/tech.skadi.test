package com.upuphone.runasone.channel.proxy.client.adapter;

import android.text.TextUtils;
import com.upuphone.runasone.channel.proxy.client.channel.IPackHandler;
import com.upuphone.runasone.channel.proxy.client.channel.SimpleAdapter;
import com.upuphone.runasone.channel.proxy.client.nat.NatSession;
import com.upuphone.runasone.channel.proxy.client.nat.NatSessionManager;
import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import com.upuphone.runasone.channel.proxy.client.util.Global;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.UShort;
import org.apache.commons.lang3.BooleanUtils;

public class Socks5Adapter extends SimpleAdapter {
    private static final String TAG = "Socks5Adapter";
    private int CUR_STEP = 0;
    private final int STEP_CHECK_ACCOUNT = 2;
    private final int STEP_HAND_METHOD = 1;
    private final int STEP_SEND_PROXY = 3;
    private boolean isFinishShakeHands = false;
    private boolean isUDPProxyHands = false;

    private void handleCheckAccount(ByteBuffer byteBuffer, NatSession natSession) {
        DebugLog.v("%s session(%d): handleCheckAccount", TAG, Integer.valueOf(natSession.key & UShort.MAX_VALUE));
        if (this.shakeHandsListener != null) {
            byte b = byteBuffer.get();
            byte b2 = byteBuffer.get();
            if (b == 1 && b2 == 0) {
                sendOriginAddressPort(natSession);
                this.CUR_STEP = 3;
                return;
            }
            this.shakeHandsListener.onShakeHandFinish(false);
        }
    }

    private void handleProxyMethod(ByteBuffer byteBuffer, NatSession natSession) {
        if (this.shakeHandsListener != null) {
            byte b = byteBuffer.get();
            byte b2 = byteBuffer.get();
            if (b == 5 && b2 == 0) {
                sendOriginAddressPort(natSession);
                this.CUR_STEP = 3;
            } else if (b == 5 && b2 == 2) {
                this.shakeHandsListener.send(ByteBuffer.wrap(SocksCommend.createAccount(1, "user", "pass")));
                this.CUR_STEP = 2;
            } else {
                this.shakeHandsListener.onShakeHandFinish(false);
            }
        }
    }

    private void handlerTCPSendProxy(ByteBuffer byteBuffer, NatSession natSession) {
        DebugLog.v("%s session(%d): handlerTCPSendProxy [%s]", TAG, Integer.valueOf(natSession.key & UShort.MAX_VALUE), Arrays.toString(byteBuffer.array()));
        if (this.shakeHandsListener != null) {
            byte b = byteBuffer.get();
            byte b2 = byteBuffer.get();
            if (b == 5 && b2 == 0) {
                this.shakeHandsListener.onShakeHandFinish(true);
                this.isFinishShakeHands = true;
                return;
            }
            DebugLog.i("%s session(%d): connect remote tcp proxy server fail!", TAG, Integer.valueOf(natSession.key & UShort.MAX_VALUE));
            this.shakeHandsListener.onShakeHandFinish(false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066 A[Catch:{ Exception -> 0x0090 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x008a A[Catch:{ Exception -> 0x0090 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handlerUDPSendProxy(java.nio.ByteBuffer r9, com.upuphone.runasone.channel.proxy.client.nat.NatSession r10) {
        /*
            r8 = this;
            short r0 = r10.key
            r1 = 65535(0xffff, float:9.1834E-41)
            r0 = r0 & r1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            byte[] r2 = r9.array()
            java.lang.String r2 = java.util.Arrays.toString(r2)
            java.lang.String r3 = "Socks5Adapter"
            java.lang.Object[] r0 = new java.lang.Object[]{r3, r0, r2}
            java.lang.String r2 = "%s session(%d): handlerUDPSendProxy [%s]"
            com.upuphone.runasone.channel.proxy.client.util.DebugLog.v(r2, r0)
            com.upuphone.runasone.channel.proxy.client.channel.IShakeHandsListener r0 = r8.shakeHandsListener
            if (r0 != 0) goto L_0x0022
            return
        L_0x0022:
            r0 = 0
            r9.get()     // Catch:{ Exception -> 0x0090 }
            r9.get()     // Catch:{ Exception -> 0x0090 }
            r9.get()     // Catch:{ Exception -> 0x0090 }
            byte r2 = r9.get()     // Catch:{ Exception -> 0x0090 }
            r4 = 2
            byte[] r5 = new byte[r4]     // Catch:{ Exception -> 0x0090 }
            r6 = 1
            if (r2 == r6) goto L_0x004e
            r7 = 3
            if (r2 == r7) goto L_0x003b
            r9 = 0
            goto L_0x005c
        L_0x003b:
            byte r2 = r9.get()     // Catch:{ Exception -> 0x0090 }
            byte[] r7 = new byte[r2]     // Catch:{ Exception -> 0x0090 }
            r9.get(r7, r0, r2)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0090 }
            r2.<init>(r7)     // Catch:{ Exception -> 0x0090 }
            r9.get(r5, r0, r4)     // Catch:{ Exception -> 0x0090 }
        L_0x004c:
            r9 = r2
            goto L_0x005c
        L_0x004e:
            r2 = 4
            byte[] r7 = new byte[r2]     // Catch:{ Exception -> 0x0090 }
            r9.get(r7, r0, r2)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r2 = com.upuphone.runasone.channel.proxy.client.tcpip.CommonMethods.ipBytesToString(r7)     // Catch:{ Exception -> 0x0090 }
            r9.get(r5, r0, r4)     // Catch:{ Exception -> 0x0090 }
            goto L_0x004c
        L_0x005c:
            int r2 = com.upuphone.runasone.channel.proxy.util.ByteHelper.byteArrayToInt(r5, r0, r4)     // Catch:{ Exception -> 0x0090 }
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0090 }
            if (r4 != 0) goto L_0x008a
            java.lang.String r4 = "%s session(%d): handlerUDPSendProxy setudpproxy address = %s"
            short r10 = r10.key     // Catch:{ Exception -> 0x0090 }
            r10 = r10 & r1
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x0090 }
            java.lang.Object[] r10 = new java.lang.Object[]{r3, r10, r9}     // Catch:{ Exception -> 0x0090 }
            com.upuphone.runasone.channel.proxy.client.util.DebugLog.v(r4, r10)     // Catch:{ Exception -> 0x0090 }
            com.upuphone.runasone.channel.proxy.client.util.Global r10 = com.upuphone.runasone.channel.proxy.client.util.Global.HOLDER     // Catch:{ Exception -> 0x0090 }
            com.upuphone.runasone.channel.proxy.client.channel.IPackHandler r10 = r10.getPackHandler()     // Catch:{ Exception -> 0x0090 }
            java.net.InetSocketAddress r1 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x0090 }
            r1.<init>(r9, r2)     // Catch:{ Exception -> 0x0090 }
            r10.setProxyAddress(r1)     // Catch:{ Exception -> 0x0090 }
            com.upuphone.runasone.channel.proxy.client.channel.IShakeHandsListener r9 = r8.shakeHandsListener     // Catch:{ Exception -> 0x0090 }
            r9.onShakeHandFinish(r6)     // Catch:{ Exception -> 0x0090 }
            goto L_0x0095
        L_0x008a:
            com.upuphone.runasone.channel.proxy.client.channel.IShakeHandsListener r9 = r8.shakeHandsListener     // Catch:{ Exception -> 0x0090 }
            r9.onShakeHandFinish(r0)     // Catch:{ Exception -> 0x0090 }
            goto L_0x0095
        L_0x0090:
            com.upuphone.runasone.channel.proxy.client.channel.IShakeHandsListener r8 = r8.shakeHandsListener
            r8.onShakeHandFinish(r0)
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.proxy.client.adapter.Socks5Adapter.handlerUDPSendProxy(java.nio.ByteBuffer, com.upuphone.runasone.channel.proxy.client.nat.NatSession):void");
    }

    private void sendOriginAddressPort(NatSession natSession) {
        DebugLog.v("%s session(%d): sendOriginAddressPort", TAG, Integer.valueOf(natSession.key & UShort.MAX_VALUE));
        this.shakeHandsListener.send(this.isUDPProxyHands ? ByteBuffer.wrap(SocksCommend.createUDPIP4Connect(0, 0)) : !TextUtils.isEmpty(natSession.remoteHost) ? ByteBuffer.wrap(SocksCommend.createTCPHostConnect(natSession.remoteHost, natSession.remotePort & UShort.MAX_VALUE)) : ByteBuffer.wrap(SocksCommend.createTCPIP4Connect(natSession.remoteIP, natSession.remotePort & UShort.MAX_VALUE)));
    }

    private void shakeHandStep(ByteBuffer byteBuffer, NatSession natSession) {
        int i = this.CUR_STEP;
        if (i == 1) {
            handleProxyMethod(byteBuffer, natSession);
        } else if (i == 2) {
            handleCheckAccount(byteBuffer, natSession);
        } else if (i == 3) {
            if (this.isUDPProxyHands) {
                handlerUDPSendProxy(byteBuffer, natSession);
            } else {
                handlerTCPSendProxy(byteBuffer, natSession);
            }
        }
    }

    private void startHands(NatSession natSession) {
        DebugLog.v("%s session(%d): startHands", TAG, Integer.valueOf(natSession.key & UShort.MAX_VALUE));
        this.shakeHandsListener.send(ByteBuffer.wrap(SocksCommend.createShakeHands()));
        this.CUR_STEP = 1;
    }

    public ByteBuffer afterReceived(NatSession natSession, ByteBuffer byteBuffer) {
        DebugLog.v("%s session(%d): afterReceived", TAG, Integer.valueOf(natSession.key & UShort.MAX_VALUE));
        return super.afterReceived(natSession, byteBuffer);
    }

    public ByteBuffer beforeSend(NatSession natSession, ByteBuffer byteBuffer) {
        DebugLog.v("%s session(%d): beforeSend", TAG, Integer.valueOf(natSession.key & UShort.MAX_VALUE));
        if (this.isFinishShakeHands) {
            return byteBuffer;
        }
        shakeHandStep(byteBuffer, natSession);
        return null;
    }

    public void init() {
    }

    public void onStartHands(NatSession natSession) {
        DebugLog.v("%s session(%d): onStartHands", TAG, Integer.valueOf(natSession.key & UShort.MAX_VALUE));
        IPackHandler packHandler = Global.HOLDER.getPackHandler();
        NatSession session = (packHandler == null || packHandler.getPort() <= 0) ? null : NatSessionManager.getSession((short) packHandler.getPort());
        this.isUDPProxyHands = session != null && natSession == session;
        DebugLog.v("%s session(%d): onStartHands isUDPProxyHands=%s", TAG, Integer.valueOf(natSession.key & UShort.MAX_VALUE), this.isUDPProxyHands ? BooleanUtils.TRUE : BooleanUtils.FALSE);
        startHands(natSession);
    }
}
