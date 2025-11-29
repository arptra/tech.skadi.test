package com.share.connect.security;

import android.content.Context;
import android.text.TextUtils;
import com.easy.logger.EasyLog;
import com.google.protobuf.ByteString;
import com.ucar.databus.proto.UCarProto;
import java.nio.charset.StandardCharsets;

public class ServerKeyNegotiator extends KeyNegotiator {
    public static UCarProto.AuthResponse e;

    public static class ClientInfo {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f9912a;
        public int b;
        public byte[] c;
        public byte[] d;
        public byte[] e;
        public byte[] f;
        public byte[] g;
        public boolean h;

        public ClientInfo() {
        }
    }

    static {
        try {
            UCarProto.AuthResponse.Builder version = UCarProto.AuthResponse.newBuilder().setVersion(KeyNegotiator.s());
            ByteString byteString = ByteString.EMPTY;
            e = version.setAuthPk(byteString).setAuthPkHmac(byteString).setAgreementPk(byteString).setAgreementPkSig(byteString).setRandom(byteString).setResult(3).build();
        } catch (Exception e2) {
            EasyLog.d("ServerKeyNegotiator", "build AuthResponse Exception", e2);
        }
    }

    public ServerKeyNegotiator(Context context) {
        super(context);
    }

    public static String B(byte[] bArr) {
        return "server_auth_key_for_client_" + new String(bArr, StandardCharsets.UTF_8);
    }

    public static void z(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            EasyLog.i("ServerKeyNegotiator", "deletePhoneById received empty deviceId");
            return;
        }
        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            KeyNegotiator.t(context);
            KeyNegotiator.v(bytes, B(bytes));
        } catch (Exception e2) {
            EasyLog.d("ServerKeyNegotiator", "removePeer Exception", e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0288  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.ucar.databus.proto.UCarProto.AuthResponse A(com.ucar.databus.proto.UCarProto.AuthRequest r8, int r9, int r10, java.lang.String r11, boolean r12) {
        /*
            r7 = this;
            java.lang.String r0 = "ServerKeyNegotiator"
            byte[] r1 = r7.r()
            if (r1 == 0) goto L_0x0294
            byte[] r1 = r7.r()
            int r1 = r1.length
            r2 = 6
            if (r1 >= r2) goto L_0x0012
            goto L_0x0294
        L_0x0012:
            if (r9 != 0) goto L_0x0040
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = com.ucar.databus.proto.UCarProto.AuthResponse.newBuilder()
            int r8 = com.share.connect.security.KeyNegotiator.s()
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setVersion(r8)
            com.google.protobuf.ByteString r8 = com.google.protobuf.ByteString.EMPTY
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setAuthPk(r8)
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setAuthPkHmac(r8)
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setAgreementPk(r8)
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setAgreementPkSig(r8)
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setRandom(r8)
            r8 = 4
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setResult(r8)
            com.ucar.databus.proto.UCarProto$AuthResponse r7 = r7.build()
            return r7
        L_0x0040:
            r1 = 0
            com.share.connect.security.ServerKeyNegotiator$ClientInfo r8 = r7.C(r8)     // Catch:{ Exception -> 0x0280 }
            byte[] r2 = r8.e     // Catch:{ Exception -> 0x0136 }
            int r2 = r2.length     // Catch:{ Exception -> 0x0136 }
            if (r2 == 0) goto L_0x027f
            byte[] r2 = r8.g     // Catch:{ Exception -> 0x0136 }
            int r2 = r2.length     // Catch:{ Exception -> 0x0136 }
            if (r2 == 0) goto L_0x027f
            byte[] r2 = r8.f9912a     // Catch:{ Exception -> 0x0136 }
            int r2 = r2.length     // Catch:{ Exception -> 0x0136 }
            if (r2 != 0) goto L_0x0056
            goto L_0x027f
        L_0x0056:
            java.security.interfaces.ECPublicKey r1 = r7.g()     // Catch:{ Exception -> 0x0136 }
            byte[] r1 = r7.f(r1)     // Catch:{ Exception -> 0x0136 }
            r2 = 32
            byte[] r2 = r7.j(r2)     // Catch:{ Exception -> 0x0136 }
            byte[] r3 = r8.c     // Catch:{ Exception -> 0x0136 }
            int r3 = r3.length     // Catch:{ Exception -> 0x0136 }
            r4 = 0
            if (r3 == 0) goto L_0x014b
            byte[] r3 = r8.d     // Catch:{ Exception -> 0x0136 }
            int r3 = r3.length     // Catch:{ Exception -> 0x0136 }
            if (r3 != 0) goto L_0x0071
            goto L_0x014b
        L_0x0071:
            java.lang.String r12 = "normal connection initiated by the phone"
            com.easy.logger.EasyLog.e(r0, r12)     // Catch:{ Exception -> 0x0136 }
            byte[] r12 = r8.c     // Catch:{ Exception -> 0x0136 }
            byte[] r3 = new byte[r4]     // Catch:{ Exception -> 0x0136 }
            byte[] r5 = r8.g     // Catch:{ Exception -> 0x0136 }
            byte[] r6 = r8.d     // Catch:{ Exception -> 0x0136 }
            java.security.interfaces.ECPublicKey r12 = r7.q(r12, r3, r5, r6)     // Catch:{ Exception -> 0x0136 }
            byte[] r3 = r8.e     // Catch:{ Exception -> 0x0136 }
            byte[] r5 = r8.g     // Catch:{ Exception -> 0x0136 }
            byte[] r6 = r8.f     // Catch:{ Exception -> 0x0136 }
            java.security.interfaces.ECPublicKey r12 = r7.o(r3, r5, r6, r12)     // Catch:{ Exception -> 0x0136 }
            byte[] r3 = r8.g     // Catch:{ Exception -> 0x0136 }
            byte[] r5 = r7.m()     // Catch:{ Exception -> 0x0136 }
            byte[][] r3 = new byte[][]{r3, r5}     // Catch:{ Exception -> 0x0136 }
            byte[] r3 = com.google.common.primitives.Bytes.concat(r3)     // Catch:{ Exception -> 0x0136 }
            boolean r12 = r7.a(r12, r3)     // Catch:{ Exception -> 0x0136 }
            if (r12 == 0) goto L_0x013a
            byte[] r12 = r8.f9912a     // Catch:{ Exception -> 0x0136 }
            byte[] r3 = r8.c     // Catch:{ Exception -> 0x0136 }
            boolean r12 = r7.w(r12, r3)     // Catch:{ Exception -> 0x0136 }
            if (r12 != 0) goto L_0x00ac
            goto L_0x013a
        L_0x00ac:
            byte[] r12 = r8.f9912a     // Catch:{ Exception -> 0x0136 }
            java.lang.String r12 = B(r12)     // Catch:{ Exception -> 0x0136 }
            java.security.interfaces.ECPublicKey r12 = r7.h(r12)     // Catch:{ Exception -> 0x0136 }
            byte[] r12 = r7.f(r12)     // Catch:{ Exception -> 0x0136 }
            java.lang.String r3 = "normal connection succeeded"
            com.easy.logger.EasyLog.e(r0, r3)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r3 = com.ucar.databus.proto.UCarProto.AuthResponse.newBuilder()     // Catch:{ Exception -> 0x0136 }
            int r5 = com.share.connect.security.KeyNegotiator.s()     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r3 = r3.setVersion(r5)     // Catch:{ Exception -> 0x0136 }
            com.google.protobuf.ByteString r5 = com.google.protobuf.ByteString.copyFrom((byte[]) r12)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r3 = r3.setAuthPk(r5)     // Catch:{ Exception -> 0x0136 }
            byte[] r5 = r8.c     // Catch:{ Exception -> 0x0136 }
            byte[][] r12 = new byte[][]{r12, r5}     // Catch:{ Exception -> 0x0136 }
            byte[] r12 = com.google.common.primitives.Bytes.concat(r12)     // Catch:{ Exception -> 0x0136 }
            byte[] r5 = r8.g     // Catch:{ Exception -> 0x0136 }
            byte[][] r5 = new byte[][]{r2, r5}     // Catch:{ Exception -> 0x0136 }
            byte[] r5 = com.google.common.primitives.Bytes.concat(r5)     // Catch:{ Exception -> 0x0136 }
            byte[] r12 = r7.i(r12, r5)     // Catch:{ Exception -> 0x0136 }
            com.google.protobuf.ByteString r12 = com.google.protobuf.ByteString.copyFrom((byte[]) r12)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r12 = r3.setAuthPkHmac(r12)     // Catch:{ Exception -> 0x0136 }
            com.google.protobuf.ByteString r3 = com.google.protobuf.ByteString.copyFrom((byte[]) r1)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r12 = r12.setAgreementPk(r3)     // Catch:{ Exception -> 0x0136 }
            byte[] r3 = r8.f9912a     // Catch:{ Exception -> 0x0136 }
            java.lang.String r3 = B(r3)     // Catch:{ Exception -> 0x0136 }
            byte[] r5 = r8.e     // Catch:{ Exception -> 0x0136 }
            byte[] r6 = r8.g     // Catch:{ Exception -> 0x0136 }
            byte[][] r5 = new byte[][]{r5, r2, r6}     // Catch:{ Exception -> 0x0136 }
            byte[] r5 = com.google.common.primitives.Bytes.concat(r5)     // Catch:{ Exception -> 0x0136 }
            byte[] r7 = r7.k(r3, r1, r5)     // Catch:{ Exception -> 0x0136 }
            com.google.protobuf.ByteString r7 = com.google.protobuf.ByteString.copyFrom((byte[]) r7)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r12.setAgreementPkSig(r7)     // Catch:{ Exception -> 0x0136 }
            com.google.protobuf.ByteString r12 = com.google.protobuf.ByteString.copyFrom((byte[]) r2)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setRandom(r12)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setResult(r4)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setWorkModes(r9)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setDayOrNightMode(r10)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setScreenInfo(r11)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse r7 = r7.build()     // Catch:{ Exception -> 0x0136 }
            return r7
        L_0x0136:
            r7 = move-exception
            r1 = r8
            goto L_0x0281
        L_0x013a:
            java.lang.String r7 = "normal connection failed"
            com.easy.logger.EasyLog.c(r0, r7)     // Catch:{ Exception -> 0x0136 }
            byte[] r7 = r8.f9912a     // Catch:{ Exception -> 0x0136 }
            java.lang.String r9 = B(r7)     // Catch:{ Exception -> 0x0136 }
            com.share.connect.security.KeyNegotiator.v(r7, r9)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse r7 = e     // Catch:{ Exception -> 0x0136 }
            return r7
        L_0x014b:
            byte[] r3 = r8.f9912a     // Catch:{ Exception -> 0x0136 }
            com.share.connect.security.Peer r3 = r7.n(r3)     // Catch:{ Exception -> 0x0136 }
            if (r3 != 0) goto L_0x0190
            java.lang.String r7 = "quick connection rejected, need normal connection"
            com.easy.logger.EasyLog.e(r0, r7)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = com.ucar.databus.proto.UCarProto.AuthResponse.newBuilder()     // Catch:{ Exception -> 0x0136 }
            int r12 = com.share.connect.security.KeyNegotiator.s()     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setVersion(r12)     // Catch:{ Exception -> 0x0136 }
            com.google.protobuf.ByteString r12 = com.google.protobuf.ByteString.EMPTY     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setAuthPk(r12)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setAuthPkHmac(r12)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setAgreementPk(r12)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setAgreementPkSig(r12)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setRandom(r12)     // Catch:{ Exception -> 0x0136 }
            r12 = 1
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setResult(r12)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setWorkModes(r9)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setDayOrNightMode(r10)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setScreenInfo(r11)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse r7 = r7.build()     // Catch:{ Exception -> 0x0136 }
            return r7
        L_0x0190:
            com.share.connect.security.Peer r5 = r7.l()     // Catch:{ Exception -> 0x0136 }
            if (r5 == 0) goto L_0x01e3
            java.lang.String r5 = r5.f9905a     // Catch:{ Exception -> 0x0136 }
            java.lang.String r6 = r3.f9905a     // Catch:{ Exception -> 0x0136 }
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x0136 }
            if (r5 != 0) goto L_0x01e3
            boolean r5 = r8.h     // Catch:{ Exception -> 0x0136 }
            if (r5 != 0) goto L_0x01e3
            if (r12 != 0) goto L_0x01e3
            java.lang.String r7 = "the incoming phone wants quick connection but is not the last connected one, the phone needs to disconnect and ask for user confirmation"
            com.easy.logger.EasyLog.e(r0, r7)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = com.ucar.databus.proto.UCarProto.AuthResponse.newBuilder()     // Catch:{ Exception -> 0x0136 }
            int r12 = com.share.connect.security.KeyNegotiator.s()     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setVersion(r12)     // Catch:{ Exception -> 0x0136 }
            com.google.protobuf.ByteString r12 = com.google.protobuf.ByteString.EMPTY     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setAuthPk(r12)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setAuthPkHmac(r12)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setAgreementPk(r12)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setAgreementPkSig(r12)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setRandom(r12)     // Catch:{ Exception -> 0x0136 }
            r12 = 2
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setResult(r12)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setWorkModes(r9)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setDayOrNightMode(r10)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setScreenInfo(r11)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse r7 = r7.build()     // Catch:{ Exception -> 0x0136 }
            return r7
        L_0x01e3:
            java.lang.String r12 = r3.b     // Catch:{ Exception -> 0x0136 }
            byte[] r12 = r7.b(r12)     // Catch:{ Exception -> 0x0136 }
            java.security.interfaces.ECPublicKey r12 = r7.p(r12)     // Catch:{ Exception -> 0x0136 }
            byte[] r3 = r8.e     // Catch:{ Exception -> 0x0136 }
            byte[] r5 = r8.g     // Catch:{ Exception -> 0x0136 }
            byte[] r6 = r8.f     // Catch:{ Exception -> 0x0136 }
            java.security.interfaces.ECPublicKey r12 = r7.o(r3, r5, r6, r12)     // Catch:{ Exception -> 0x0136 }
            byte[] r3 = r8.g     // Catch:{ Exception -> 0x0136 }
            byte[] r5 = r7.m()     // Catch:{ Exception -> 0x0136 }
            byte[][] r3 = new byte[][]{r3, r5}     // Catch:{ Exception -> 0x0136 }
            byte[] r3 = com.google.common.primitives.Bytes.concat(r3)     // Catch:{ Exception -> 0x0136 }
            boolean r12 = r7.a(r12, r3)     // Catch:{ Exception -> 0x0136 }
            if (r12 != 0) goto L_0x021c
            java.lang.String r7 = "quick connection failed"
            com.easy.logger.EasyLog.c(r0, r7)     // Catch:{ Exception -> 0x0136 }
            byte[] r7 = r8.f9912a     // Catch:{ Exception -> 0x0136 }
            java.lang.String r9 = B(r7)     // Catch:{ Exception -> 0x0136 }
            com.share.connect.security.KeyNegotiator.v(r7, r9)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse r7 = e     // Catch:{ Exception -> 0x0136 }
            return r7
        L_0x021c:
            java.lang.String r12 = "quick connection succeeded"
            com.easy.logger.EasyLog.e(r0, r12)     // Catch:{ Exception -> 0x0136 }
            byte[] r12 = r8.f9912a     // Catch:{ Exception -> 0x0136 }
            r7.y(r12)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r12 = com.ucar.databus.proto.UCarProto.AuthResponse.newBuilder()     // Catch:{ Exception -> 0x0136 }
            int r3 = com.share.connect.security.KeyNegotiator.s()     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r12 = r12.setVersion(r3)     // Catch:{ Exception -> 0x0136 }
            com.google.protobuf.ByteString r3 = com.google.protobuf.ByteString.EMPTY     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r12 = r12.setAuthPk(r3)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r12 = r12.setAuthPkHmac(r3)     // Catch:{ Exception -> 0x0136 }
            com.google.protobuf.ByteString r3 = com.google.protobuf.ByteString.copyFrom((byte[]) r1)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r12 = r12.setAgreementPk(r3)     // Catch:{ Exception -> 0x0136 }
            byte[] r3 = r8.f9912a     // Catch:{ Exception -> 0x0136 }
            java.lang.String r3 = B(r3)     // Catch:{ Exception -> 0x0136 }
            byte[] r5 = r8.e     // Catch:{ Exception -> 0x0136 }
            byte[] r6 = r8.g     // Catch:{ Exception -> 0x0136 }
            byte[][] r5 = new byte[][]{r5, r2, r6}     // Catch:{ Exception -> 0x0136 }
            byte[] r5 = com.google.common.primitives.Bytes.concat(r5)     // Catch:{ Exception -> 0x0136 }
            byte[] r7 = r7.k(r3, r1, r5)     // Catch:{ Exception -> 0x0136 }
            com.google.protobuf.ByteString r7 = com.google.protobuf.ByteString.copyFrom((byte[]) r7)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r12.setAgreementPkSig(r7)     // Catch:{ Exception -> 0x0136 }
            com.google.protobuf.ByteString r12 = com.google.protobuf.ByteString.copyFrom((byte[]) r2)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setRandom(r12)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setResult(r4)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setWorkModes(r9)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setDayOrNightMode(r10)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse$Builder r7 = r7.setScreenInfo(r11)     // Catch:{ Exception -> 0x0136 }
            com.ucar.databus.proto.UCarProto$AuthResponse r7 = r7.build()     // Catch:{ Exception -> 0x0136 }
            return r7
        L_0x027f:
            return r1
        L_0x0280:
            r7 = move-exception
        L_0x0281:
            java.lang.String r8 = "generateKeyNegotiationInfo Exception"
            com.easy.logger.EasyLog.d(r0, r8, r7)
            if (r1 == 0) goto L_0x0291
            byte[] r7 = r1.f9912a
            java.lang.String r8 = B(r7)
            com.share.connect.security.KeyNegotiator.v(r7, r8)
        L_0x0291:
            com.ucar.databus.proto.UCarProto$AuthResponse r7 = e
            return r7
        L_0x0294:
            com.ucar.databus.proto.UCarProto$AuthResponse r7 = e
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.share.connect.security.ServerKeyNegotiator.A(com.ucar.databus.proto.UCarProto$AuthRequest, int, int, java.lang.String, boolean):com.ucar.databus.proto.UCarProto$AuthResponse");
    }

    public final ClientInfo C(UCarProto.AuthRequest authRequest) {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.f9912a = authRequest.getId().toByteArray();
        clientInfo.b = authRequest.getVersion();
        clientInfo.c = authRequest.getAuthPk().toByteArray();
        clientInfo.d = authRequest.getAuthPkHmac().toByteArray();
        clientInfo.e = authRequest.getAgreementPk().toByteArray();
        clientInfo.f = authRequest.getAgreementPkSig().toByteArray();
        clientInfo.g = authRequest.getRandom().toByteArray();
        clientInfo.h = authRequest.getUserConfirmed();
        return clientInfo;
    }
}
