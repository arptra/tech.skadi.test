package com.ucar.protocol;

import com.honey.account.f3.e;
import com.upuphone.starrynet.core.ble.channel.packet.Packet;
import java.util.HashMap;
import java.util.Map;

public class UCarProtocol {

    /* renamed from: a  reason: collision with root package name */
    public static SourceDevice f9641a = SourceDevice.PHONE;
    public static final Map b;

    static {
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put(CmdCategory.ACK, new HashMap<Integer, String>() {
            {
                put(0, Packet.ACK);
            }
        });
    }

    public static void b(DataFormat dataFormat, CmdCategory cmdCategory, int i, UCarMessage uCarMessage) {
        c(dataFormat, cmdCategory, i, uCarMessage, (MessageType) null);
    }

    public static void c(DataFormat dataFormat, CmdCategory cmdCategory, int i, UCarMessage uCarMessage, MessageType messageType) {
        CmdDescription e = uCarMessage.g().e();
        if (dataFormat != null && dataFormat != e.b()) {
            throw new ProtocolException("Check dataFormat error: " + e.b() + ", expect: " + dataFormat);
        } else if (cmdCategory != e.a()) {
            throw new ProtocolException("Check category error: " + e.a() + ", expect: " + cmdCategory);
        } else if (i != -1 && i != e.d()) {
            throw new ProtocolException("Check method error: " + e.d() + ", expect: " + i);
        } else if (messageType != null && messageType != uCarMessage.h()) {
            throw new ProtocolException("Check MessageType error: " + uCarMessage.h() + ", expect: " + messageType);
        }
    }

    public static UCarMessage d(UCarMessage uCarMessage) {
        ParamValidation.c(uCarMessage, "message");
        CmdDescription e = uCarMessage.g().e();
        ParamValidation.b(e, "message.header.cmdDescription");
        SourceDevice e2 = e.e();
        if (e2 == f9641a) {
            return uCarMessage;
        }
        throw new ProtocolException("Can not create " + e2 + " message in " + f9641a + " device");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r2 = (java.util.Map) b.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String e(com.ucar.protocol.CmdCategory r2, int r3) {
        /*
            java.lang.String r0 = "unknown"
            if (r2 != 0) goto L_0x0005
            return r0
        L_0x0005:
            java.util.Map r1 = b
            java.lang.Object r2 = r1.get(r2)
            java.util.Map r2 = (java.util.Map) r2
            if (r2 == 0) goto L_0x002b
            boolean r1 = r2.isEmpty()
            if (r1 == 0) goto L_0x0016
            goto L_0x002b
        L_0x0016:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            boolean r1 = r2.containsKey(r1)
            if (r1 == 0) goto L_0x002b
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            return r2
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.protocol.UCarProtocol.e(com.ucar.protocol.CmdCategory, int):java.lang.String");
    }

    public static SourceDevice f() {
        return f9641a;
    }

    public static /* synthetic */ Map g(CmdCategory cmdCategory) {
        return new HashMap();
    }

    public static void h(CmdCategory cmdCategory, Map map) {
        ParamValidation.b(cmdCategory, "category");
        ParamValidation.b(map, "methodNames");
        ((Map) b.computeIfAbsent(cmdCategory, new e())).putAll(map);
    }

    public static void i(SourceDevice sourceDevice) {
        ParamValidation.c(sourceDevice, "sourceDevice");
        f9641a = sourceDevice;
    }
}
