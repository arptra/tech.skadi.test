package javax.obex;

public class ObexSession {

    /* renamed from: a  reason: collision with root package name */
    public Authenticator f3691a;
    public byte[] b;

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(javax.obex.HeaderSet r11) {
        /*
            r10 = this;
            javax.obex.Authenticator r0 = r10.f3691a
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            byte[] r0 = r11.t
            byte[] r0 = javax.obex.ObexHelper.i(r1, r0)
            byte[] r2 = r11.t
            r3 = 1
            byte[] r2 = javax.obex.ObexHelper.i(r3, r2)
            byte[] r4 = r11.t
            r5 = 2
            byte[] r4 = javax.obex.ObexHelper.i(r5, r4)
            r6 = 0
            if (r4 == 0) goto L_0x004a
            int r7 = r4.length
            int r7 = r7 - r3
            byte[] r8 = new byte[r7]
            java.lang.System.arraycopy(r4, r3, r8, r1, r7)
            byte r4 = r4[r1]
            r7 = 255(0xff, float:3.57E-43)
            r4 = r4 & r7
            java.lang.String r9 = "Unsupported Encoding Scheme"
            if (r4 == 0) goto L_0x003c
            if (r4 == r3) goto L_0x003c
            if (r4 != r7) goto L_0x0036
            java.lang.String r4 = javax.obex.ObexHelper.d(r8, r1)
            goto L_0x004b
        L_0x0036:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r9)
            throw r10
        L_0x003c:
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x0044 }
            java.lang.String r7 = "ISO8859_1"
            r4.<init>(r8, r7)     // Catch:{ Exception -> 0x0044 }
            goto L_0x004b
        L_0x0044:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r9)
            throw r10
        L_0x004a:
            r4 = r6
        L_0x004b:
            if (r2 == 0) goto L_0x005d
            byte r2 = r2[r1]
            r7 = r2 & 1
            if (r7 == 0) goto L_0x0055
            r7 = r3
            goto L_0x0056
        L_0x0055:
            r7 = r1
        L_0x0056:
            r2 = r2 & r5
            if (r2 == 0) goto L_0x005b
            r2 = r1
            goto L_0x005f
        L_0x005b:
            r2 = r3
            goto L_0x005f
        L_0x005d:
            r7 = r1
            goto L_0x005b
        L_0x005f:
            r11.t = r6
            javax.obex.Authenticator r10 = r10.f3691a     // Catch:{ Exception -> 0x00c8 }
            javax.obex.PasswordAuthentication r10 = r10.b(r4, r7, r2)     // Catch:{ Exception -> 0x00c8 }
            if (r10 != 0) goto L_0x006a
            return r1
        L_0x006a:
            byte[] r2 = r10.a()
            if (r2 != 0) goto L_0x0071
            return r1
        L_0x0071:
            byte[] r10 = r10.b()
            r4 = 36
            if (r10 == 0) goto L_0x008e
            int r6 = r10.length
            r7 = 38
            int r6 = r6 + r7
            byte[] r6 = new byte[r6]
            r11.u = r6
            r6[r4] = r3
            int r4 = r10.length
            byte r4 = (byte) r4
            r8 = 37
            r6[r8] = r4
            int r4 = r10.length
            java.lang.System.arraycopy(r10, r1, r6, r7, r4)
            goto L_0x0092
        L_0x008e:
            byte[] r10 = new byte[r4]
            r11.u = r10
        L_0x0092:
            int r10 = r0.length
            int r4 = r2.length
            int r10 = r10 + r4
            int r10 = r10 + r3
            byte[] r10 = new byte[r10]
            int r4 = r0.length
            java.lang.System.arraycopy(r0, r1, r10, r1, r4)
            int r4 = r0.length
            r6 = 58
            r10[r4] = r6
            int r4 = r0.length
            int r4 = r4 + r3
            int r6 = r2.length
            java.lang.System.arraycopy(r2, r1, r10, r4, r6)
            byte[] r2 = r11.u
            r2[r1] = r1
            r4 = 16
            r2[r3] = r4
            byte[] r10 = javax.obex.ObexHelper.a(r10)
            byte[] r2 = r11.u
            java.lang.System.arraycopy(r10, r1, r2, r5, r4)
            byte[] r10 = r11.u
            r11 = 18
            r10[r11] = r5
            r11 = 19
            r10[r11] = r4
            r11 = 20
            java.lang.System.arraycopy(r0, r1, r10, r11, r4)
            return r3
        L_0x00c8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.obex.ObexSession.a(javax.obex.HeaderSet):boolean");
    }

    public boolean b(byte[] bArr) {
        byte[] a2;
        Authenticator authenticator = this.f3691a;
        if (authenticator == null || (a2 = authenticator.a(ObexHelper.i((byte) 1, bArr))) == null) {
            return false;
        }
        byte[] bArr2 = new byte[(a2.length + 16)];
        System.arraycopy(this.b, 0, bArr2, 0, 16);
        System.arraycopy(a2, 0, bArr2, 16, a2.length);
        byte[] a3 = ObexHelper.a(bArr2);
        byte[] i = ObexHelper.i((byte) 0, bArr);
        for (int i2 = 0; i2 < 16; i2++) {
            if (a3[i2] != i[i2]) {
                return false;
            }
        }
        return true;
    }
}
