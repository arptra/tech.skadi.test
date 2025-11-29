package com.alibaba.fastjson.serializer;

public class ClobSeriliazer implements ObjectSerializer {
    public static final ClobSeriliazer instance = new ClobSeriliazer();

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0035, code lost:
        throw new com.alibaba.fastjson.JSONException("read string from reader error", r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        throw new java.io.IOException("write clob error", r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0006, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:1:0x0002, B:8:0x0015] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r2, java.lang.Object r3, java.lang.Object r4, java.lang.reflect.Type r5, int r6) throws java.io.IOException {
        /*
            r1 = this;
            if (r3 != 0) goto L_0x0008
            r2.writeNull()     // Catch:{ SQLException -> 0x0006 }
            return
        L_0x0006:
            r1 = move-exception
            goto L_0x0036
        L_0x0008:
            java.sql.Clob r3 = (java.sql.Clob) r3     // Catch:{ SQLException -> 0x0006 }
            java.io.Reader r1 = r3.getCharacterStream()     // Catch:{ SQLException -> 0x0006 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x0006 }
            r3.<init>()     // Catch:{ SQLException -> 0x0006 }
            r4 = 2048(0x800, float:2.87E-42)
            char[] r5 = new char[r4]     // Catch:{ Exception -> 0x002d }
        L_0x0017:
            r6 = 0
            int r0 = r1.read(r5, r6, r4)     // Catch:{ Exception -> 0x002d }
            if (r0 >= 0) goto L_0x0029
            java.lang.String r3 = r3.toString()     // Catch:{ SQLException -> 0x0006 }
            r1.close()     // Catch:{ SQLException -> 0x0006 }
            r2.write((java.lang.String) r3)     // Catch:{ SQLException -> 0x0006 }
            return
        L_0x0029:
            r3.append(r5, r6, r0)     // Catch:{ Exception -> 0x002d }
            goto L_0x0017
        L_0x002d:
            r1 = move-exception
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ SQLException -> 0x0006 }
            java.lang.String r3 = "read string from reader error"
            r2.<init>(r3, r1)     // Catch:{ SQLException -> 0x0006 }
            throw r2     // Catch:{ SQLException -> 0x0006 }
        L_0x0036:
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "write clob error"
            r2.<init>(r3, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ClobSeriliazer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int):void");
    }
}
