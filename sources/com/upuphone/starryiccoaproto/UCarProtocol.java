package com.upuphone.starryiccoaproto;

import com.honey.account.r6.b;
import com.upuphone.starrynet.core.ble.channel.packet.Packet;
import java.util.HashMap;
import java.util.Map;

public class UCarProtocol {

    /* renamed from: a  reason: collision with root package name */
    public static SourceDevice f6524a = SourceDevice.PHONE;
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

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r2 = (java.util.Map) b.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(com.upuphone.starryiccoaproto.CmdCategory r2, int r3) {
        /*
            java.lang.String r0 = "unknown"
            if (r2 != 0) goto L_0x0006
            return r0
        L_0x0006:
            java.util.Map r1 = b
            java.lang.Object r2 = r1.get(r2)
            java.util.Map r2 = (java.util.Map) r2
            if (r2 == 0) goto L_0x002c
            boolean r1 = r2.isEmpty()
            if (r1 == 0) goto L_0x0017
            goto L_0x002c
        L_0x0017:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            boolean r1 = r2.containsKey(r1)
            if (r1 == 0) goto L_0x002c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            return r2
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starryiccoaproto.UCarProtocol.b(com.upuphone.starryiccoaproto.CmdCategory, int):java.lang.String");
    }

    public static /* synthetic */ Map c(CmdCategory cmdCategory) {
        return new HashMap();
    }

    public static void d(CmdCategory cmdCategory, Map map) {
        ParamValidation.b(cmdCategory, "category");
        ParamValidation.b(map, "methodNames");
        ((Map) b.computeIfAbsent(cmdCategory, new b())).putAll(map);
    }
}
