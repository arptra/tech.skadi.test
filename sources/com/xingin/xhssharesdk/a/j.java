package com.xingin.xhssharesdk.a;

import com.xingin.xhssharesdk.a.c0;
import com.xingin.xhssharesdk.a.j.a;
import com.xingin.xhssharesdk.a.k;
import com.xingin.xhssharesdk.a.l;
import com.xingin.xhssharesdk.a.r;
import com.xingin.xhssharesdk.a.w;
import java.util.Map;

public final class j<FieldDescriptorType extends a<FieldDescriptorType>> {
    public static final /* synthetic */ int d = 0;

    /* renamed from: a  reason: collision with root package name */
    public final v f8133a = w.c(16);
    public boolean b;
    public boolean c = false;

    public interface a<T extends a<T>> extends Comparable<T> {
        void a();

        void b();

        c0.b c();

        k.a e(r.a aVar, r rVar);
    }

    static {
        new j(0);
    }

    public j() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c3, code lost:
        r0 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f8, code lost:
        return r5 + r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(com.xingin.xhssharesdk.a.c0.a r4, int r5, java.lang.String r6) {
        /*
            int r5 = com.xingin.xhssharesdk.a.g.n(r5)
            com.xingin.xhssharesdk.a.c0$a$b r0 = com.xingin.xhssharesdk.a.c0.a.d
            if (r4 != r0) goto L_0x000a
            int r5 = r5 * 2
        L_0x000a:
            int r4 = r4.ordinal()
            r0 = 8
            r1 = 4
            r2 = 1
            switch(r4) {
                case 0: goto L_0x00f2;
                case 1: goto L_0x00ec;
                case 2: goto L_0x00e1;
                case 3: goto L_0x00d6;
                case 4: goto L_0x00cb;
                case 5: goto L_0x00c5;
                case 6: goto L_0x00be;
                case 7: goto L_0x00b7;
                case 8: goto L_0x00a7;
                case 9: goto L_0x00a0;
                case 10: goto L_0x0078;
                case 11: goto L_0x0068;
                case 12: goto L_0x005c;
                case 13: goto L_0x0040;
                case 14: goto L_0x00be;
                case 15: goto L_0x00c5;
                case 16: goto L_0x002f;
                case 17: goto L_0x001d;
                default: goto L_0x0015;
            }
        L_0x0015:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = "There is no way to get here, but the compiler thinks otherwise."
            r4.<init>(r5)
            throw r4
        L_0x001d:
            java.lang.Long r6 = (java.lang.Long) r6
            long r0 = r6.longValue()
            long r2 = r0 << r2
            r4 = 63
            long r0 = r0 >> r4
            long r0 = r0 ^ r2
            int r0 = com.xingin.xhssharesdk.a.g.d(r0)
            goto L_0x00f7
        L_0x002f:
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r4 = r6.intValue()
            int r6 = r4 << 1
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r0 = com.xingin.xhssharesdk.a.g.v(r4)
            goto L_0x00f7
        L_0x0040:
            boolean r4 = r6 instanceof com.xingin.xhssharesdk.a.l.a
            if (r4 == 0) goto L_0x0050
            com.xingin.xhssharesdk.a.l$a r6 = (com.xingin.xhssharesdk.a.l.a) r6
            int r4 = r6.a()
            int r0 = com.xingin.xhssharesdk.a.g.b(r4)
            goto L_0x00f7
        L_0x0050:
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r4 = r6.intValue()
            int r0 = com.xingin.xhssharesdk.a.g.b(r4)
            goto L_0x00f7
        L_0x005c:
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r4 = r6.intValue()
            int r0 = com.xingin.xhssharesdk.a.g.v(r4)
            goto L_0x00f7
        L_0x0068:
            boolean r4 = r6 instanceof com.xingin.xhssharesdk.a.e
            if (r4 == 0) goto L_0x006d
            goto L_0x00ab
        L_0x006d:
            byte[] r6 = (byte[]) r6
            int r4 = r6.length
            int r6 = com.xingin.xhssharesdk.a.g.v(r4)
        L_0x0074:
            int r0 = r6 + r4
            goto L_0x00f7
        L_0x0078:
            boolean r4 = r6 instanceof com.xingin.xhssharesdk.a.n
            if (r4 == 0) goto L_0x0099
            com.xingin.xhssharesdk.a.n r6 = (com.xingin.xhssharesdk.a.n) r6
            com.xingin.xhssharesdk.a.e$d r4 = r6.b
            if (r4 == 0) goto L_0x0088
            com.xingin.xhssharesdk.a.e$d r4 = r6.b
            byte[] r4 = r4.d
            int r4 = r4.length
            goto L_0x0094
        L_0x0088:
            com.xingin.xhssharesdk.a.r r4 = r6.f8143a
            if (r4 == 0) goto L_0x0093
            com.xingin.xhssharesdk.a.r r4 = r6.f8143a
            int r4 = r4.b()
            goto L_0x0094
        L_0x0093:
            r4 = 0
        L_0x0094:
            int r6 = com.xingin.xhssharesdk.a.g.v(r4)
            goto L_0x0074
        L_0x0099:
            com.xingin.xhssharesdk.a.r r6 = (com.xingin.xhssharesdk.a.r) r6
            int r0 = com.xingin.xhssharesdk.a.g.f(r6)
            goto L_0x00f7
        L_0x00a0:
            com.xingin.xhssharesdk.a.r r6 = (com.xingin.xhssharesdk.a.r) r6
            int r0 = r6.b()
            goto L_0x00f7
        L_0x00a7:
            boolean r4 = r6 instanceof com.xingin.xhssharesdk.a.e
            if (r4 == 0) goto L_0x00b2
        L_0x00ab:
            com.xingin.xhssharesdk.a.e r6 = (com.xingin.xhssharesdk.a.e) r6
            int r0 = com.xingin.xhssharesdk.a.g.e(r6)
            goto L_0x00f7
        L_0x00b2:
            int r0 = com.xingin.xhssharesdk.a.g.g(r6)
            goto L_0x00f7
        L_0x00b7:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            r6.booleanValue()
            r0 = r2
            goto L_0x00f7
        L_0x00be:
            java.lang.Integer r6 = (java.lang.Integer) r6
            r6.intValue()
        L_0x00c3:
            r0 = r1
            goto L_0x00f7
        L_0x00c5:
            java.lang.Long r6 = (java.lang.Long) r6
            r6.longValue()
            goto L_0x00f7
        L_0x00cb:
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r4 = r6.intValue()
            int r0 = com.xingin.xhssharesdk.a.g.b(r4)
            goto L_0x00f7
        L_0x00d6:
            java.lang.Long r6 = (java.lang.Long) r6
            long r0 = r6.longValue()
            int r0 = com.xingin.xhssharesdk.a.g.d(r0)
            goto L_0x00f7
        L_0x00e1:
            java.lang.Long r6 = (java.lang.Long) r6
            long r0 = r6.longValue()
            int r0 = com.xingin.xhssharesdk.a.g.d(r0)
            goto L_0x00f7
        L_0x00ec:
            java.lang.Float r6 = (java.lang.Float) r6
            r6.floatValue()
            goto L_0x00c3
        L_0x00f2:
            java.lang.Double r6 = (java.lang.Double) r6
            r6.doubleValue()
        L_0x00f7:
            int r5 = r5 + r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xingin.xhssharesdk.a.j.a(com.xingin.xhssharesdk.a.c0$a, int, java.lang.String):int");
    }

    public static Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        if ((r2 instanceof byte[]) == false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        if ((r2 instanceof com.xingin.xhssharesdk.a.n) == false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if ((r2 instanceof com.xingin.xhssharesdk.a.l.a) == false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(com.xingin.xhssharesdk.a.c0.a r1, java.lang.Object r2) {
        /*
            r2.getClass()
            com.xingin.xhssharesdk.a.c0$b r1 = r1.f8124a
            int r1 = r1.ordinal()
            r0 = 0
            switch(r1) {
                case 0: goto L_0x0039;
                case 1: goto L_0x0036;
                case 2: goto L_0x0033;
                case 3: goto L_0x0030;
                case 4: goto L_0x002d;
                case 5: goto L_0x002a;
                case 6: goto L_0x0020;
                case 7: goto L_0x0017;
                case 8: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x003b
        L_0x000e:
            boolean r1 = r2 instanceof com.xingin.xhssharesdk.a.r
            if (r1 != 0) goto L_0x0028
            boolean r1 = r2 instanceof com.xingin.xhssharesdk.a.n
            if (r1 == 0) goto L_0x003b
            goto L_0x0028
        L_0x0017:
            boolean r1 = r2 instanceof java.lang.Integer
            if (r1 != 0) goto L_0x0028
            boolean r1 = r2 instanceof com.xingin.xhssharesdk.a.l.a
            if (r1 == 0) goto L_0x003b
            goto L_0x0028
        L_0x0020:
            boolean r1 = r2 instanceof com.xingin.xhssharesdk.a.e
            if (r1 != 0) goto L_0x0028
            boolean r1 = r2 instanceof byte[]
            if (r1 == 0) goto L_0x003b
        L_0x0028:
            r0 = 1
            goto L_0x003b
        L_0x002a:
            boolean r0 = r2 instanceof java.lang.String
            goto L_0x003b
        L_0x002d:
            boolean r0 = r2 instanceof java.lang.Boolean
            goto L_0x003b
        L_0x0030:
            boolean r0 = r2 instanceof java.lang.Double
            goto L_0x003b
        L_0x0033:
            boolean r0 = r2 instanceof java.lang.Float
            goto L_0x003b
        L_0x0036:
            boolean r0 = r2 instanceof java.lang.Long
            goto L_0x003b
        L_0x0039:
            boolean r0 = r2 instanceof java.lang.Integer
        L_0x003b:
            if (r0 == 0) goto L_0x003e
            return
        L_0x003e:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Wrong object type used with protocol message reflection."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xingin.xhssharesdk.a.j.d(com.xingin.xhssharesdk.a.c0$a, java.lang.Object):void");
    }

    public static void e(g gVar, c0.a aVar, int i, String str) {
        if (aVar == c0.a.d) {
            gVar.o(i, 3);
            ((r) str).b(gVar);
            gVar.o(i, 4);
            return;
        }
        gVar.o(i, aVar.b);
        switch (aVar.ordinal()) {
            case 0:
                gVar.q(Double.doubleToRawLongBits(((Double) str).doubleValue()));
                return;
            case 1:
                gVar.x(Float.floatToRawIntBits(((Float) str).floatValue()));
                return;
            case 2:
                gVar.y(((Long) str).longValue());
                return;
            case 3:
                gVar.y(((Long) str).longValue());
                return;
            case 4:
                gVar.z(((Integer) str).intValue());
                return;
            case 5:
                gVar.q(((Long) str).longValue());
                return;
            case 6:
                gVar.x(((Integer) str).intValue());
                return;
            case 7:
                gVar.i(((Boolean) str).booleanValue() ? (byte) 1 : 0);
                return;
            case 8:
                if (!(str instanceof e)) {
                    gVar.t(str);
                    return;
                }
                break;
            case 9:
                ((r) str).b(gVar);
                return;
            case 10:
                gVar.s((r) str);
                return;
            case 11:
                if (!(str instanceof e)) {
                    byte[] bArr = (byte[]) str;
                    gVar.m(bArr, bArr.length);
                    return;
                }
                break;
            case 12:
                gVar.A(((Integer) str).intValue());
                return;
            case 13:
                gVar.z(str instanceof l.a ? ((l.a) str).a() : ((Integer) str).intValue());
                return;
            case 14:
                gVar.x(((Integer) str).intValue());
                return;
            case 15:
                gVar.q(((Long) str).longValue());
                return;
            case 16:
                int intValue = ((Integer) str).intValue();
                gVar.A((intValue >> 31) ^ (intValue << 1));
                return;
            case 17:
                long longValue = ((Long) str).longValue();
                gVar.y((longValue >> 63) ^ (longValue << 1));
                return;
            default:
                return;
        }
        gVar.r((e) str);
    }

    /* renamed from: b */
    public final j clone() {
        j jVar = new j();
        for (int i = 0; i < this.f8133a.b.size(); i++) {
            Map.Entry entry = (Map.Entry) this.f8133a.b.get(i);
            jVar.f((a) entry.getKey(), entry.getValue());
        }
        v vVar = this.f8133a;
        for (Map.Entry entry2 : vVar.c.isEmpty() ? w.a.b : vVar.c.entrySet()) {
            jVar.f((a) entry2.getKey(), entry2.getValue());
        }
        jVar.c = this.c;
        return jVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        return this.f8133a.equals(((j) obj).f8133a);
    }

    public final void f(a aVar, Object obj) {
        aVar.a();
        aVar.b();
        d((c0.a) null, obj);
        if (obj instanceof n) {
            this.c = true;
        }
        this.f8133a.put(aVar, obj);
    }

    public final void g(Map.Entry entry) {
        v vVar;
        Object c2;
        a aVar = (a) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof n) {
            value = ((n) value).a();
        }
        aVar.a();
        if (aVar.c() == c0.b.MESSAGE) {
            Object obj = this.f8133a.get(aVar);
            if (obj instanceof n) {
                obj = ((n) obj).a();
            }
            if (obj != null) {
                c2 = aVar.e(((r) obj).d(), (r) value).e();
                vVar = this.f8133a;
                vVar.put(aVar, c2);
            }
        }
        vVar = this.f8133a;
        c2 = c(value);
        vVar.put(aVar, c2);
    }

    public final void h() {
        if (!this.b) {
            this.f8133a.f();
            this.b = true;
        }
    }

    public final int hashCode() {
        return this.f8133a.hashCode();
    }

    public j(int i) {
        h();
    }
}
