package com.xingin.xhssharesdk.a;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

public final class t {
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x015b, code lost:
        if (((java.lang.Integer) r10).intValue() == 0) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x016c, code lost:
        if (((java.lang.Float) r10).floatValue() == 0.0f) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x017e, code lost:
        if (((java.lang.Double) r10).doubleValue() == 0.0d) goto L_0x01b0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.xingin.xhssharesdk.a.r r13, java.lang.StringBuilder r14, int r15) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.TreeSet r2 = new java.util.TreeSet
            r2.<init>()
            java.lang.Class r3 = r13.getClass()
            java.lang.reflect.Method[] r3 = r3.getDeclaredMethods()
            int r4 = r3.length
            r5 = 0
            r6 = r5
        L_0x001a:
            java.lang.String r7 = "get"
            if (r6 >= r4) goto L_0x0049
            r8 = r3[r6]
            java.lang.String r9 = r8.getName()
            r1.put(r9, r8)
            java.lang.Class[] r9 = r8.getParameterTypes()
            int r9 = r9.length
            if (r9 != 0) goto L_0x0046
            java.lang.String r9 = r8.getName()
            r0.put(r9, r8)
            java.lang.String r9 = r8.getName()
            boolean r7 = r9.startsWith(r7)
            if (r7 == 0) goto L_0x0046
            java.lang.String r7 = r8.getName()
            r2.add(r7)
        L_0x0046:
            int r6 = r6 + 1
            goto L_0x001a
        L_0x0049:
            java.util.Iterator r2 = r2.iterator()
        L_0x004d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x01f2
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = ""
            java.lang.String r3 = r3.replaceFirst(r7, r4)
            java.lang.String r6 = "List"
            boolean r6 = r3.endsWith(r6)
            java.lang.String r8 = "_"
            r9 = 1
            if (r6 == 0) goto L_0x00d1
            java.lang.String r6 = "OrBuilderList"
            boolean r6 = r3.endsWith(r6)
            if (r6 != 0) goto L_0x00d1
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r10 = r3.substring(r5, r9)
            java.lang.String r10 = r10.toLowerCase()
            r6.append(r10)
            int r10 = r3.length()
            int r10 = r10 + -4
            java.lang.String r10 = r3.substring(r9, r10)
            r6.append(r10)
            java.lang.String r6 = r6.toString()
            java.lang.String r10 = r7.concat(r3)
            java.lang.Object r10 = r0.get(r10)
            java.lang.reflect.Method r10 = (java.lang.reflect.Method) r10
            if (r10 == 0) goto L_0x00d1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = r5
        L_0x00a5:
            int r9 = r6.length()
            if (r4 >= r9) goto L_0x00c2
            char r9 = r6.charAt(r4)
            boolean r11 = java.lang.Character.isUpperCase(r9)
            if (r11 == 0) goto L_0x00b8
            r3.append(r8)
        L_0x00b8:
            char r9 = java.lang.Character.toLowerCase(r9)
            r3.append(r9)
            int r4 = r4 + 1
            goto L_0x00a5
        L_0x00c2:
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.Object r4 = com.xingin.xhssharesdk.a.k.f(r10, r13, r4)
            b(r14, r15, r3, r4)
            goto L_0x004d
        L_0x00d1:
            java.lang.String r6 = "set"
            java.lang.String r6 = r6.concat(r3)
            java.lang.Object r6 = r1.get(r6)
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            if (r6 != 0) goto L_0x00e1
            goto L_0x004d
        L_0x00e1:
            java.lang.String r6 = "Bytes"
            boolean r6 = r3.endsWith(r6)
            if (r6 == 0) goto L_0x0107
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r7)
            int r10 = r3.length()
            int r10 = r10 + -5
            java.lang.String r10 = r3.substring(r5, r10)
            r6.append(r10)
            java.lang.String r6 = r6.toString()
            boolean r6 = r0.containsKey(r6)
            if (r6 == 0) goto L_0x0107
            goto L_0x004d
        L_0x0107:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r10 = r3.substring(r5, r9)
            java.lang.String r10 = r10.toLowerCase()
            r6.append(r10)
            java.lang.String r10 = r3.substring(r9)
            r6.append(r10)
            java.lang.String r6 = r6.toString()
            java.lang.String r10 = r7.concat(r3)
            java.lang.Object r10 = r0.get(r10)
            java.lang.reflect.Method r10 = (java.lang.reflect.Method) r10
            java.lang.String r11 = "has"
            java.lang.String r3 = r11.concat(r3)
            java.lang.Object r3 = r0.get(r3)
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            if (r10 == 0) goto L_0x004d
            java.lang.Object[] r11 = new java.lang.Object[r5]
            java.lang.Object r10 = com.xingin.xhssharesdk.a.k.f(r10, r13, r11)
            if (r3 != 0) goto L_0x01b8
            boolean r3 = r10 instanceof java.lang.Boolean
            if (r3 == 0) goto L_0x0150
            r3 = r10
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r3 = r3 ^ r9
            goto L_0x01b3
        L_0x0150:
            boolean r3 = r10 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x015e
            r3 = r10
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 != 0) goto L_0x01b2
            goto L_0x01b0
        L_0x015e:
            boolean r3 = r10 instanceof java.lang.Float
            if (r3 == 0) goto L_0x016f
            r3 = r10
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x01b2
            goto L_0x01b0
        L_0x016f:
            boolean r3 = r10 instanceof java.lang.Double
            if (r3 == 0) goto L_0x0181
            r3 = r10
            java.lang.Double r3 = (java.lang.Double) r3
            double r3 = r3.doubleValue()
            r11 = 0
            int r3 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x01b2
            goto L_0x01b0
        L_0x0181:
            boolean r3 = r10 instanceof java.lang.String
            if (r3 == 0) goto L_0x018a
            boolean r3 = r10.equals(r4)
            goto L_0x01b3
        L_0x018a:
            boolean r3 = r10 instanceof com.xingin.xhssharesdk.a.e
            if (r3 == 0) goto L_0x0195
            com.xingin.xhssharesdk.a.e$d r3 = com.xingin.xhssharesdk.a.e.b
            boolean r3 = r10.equals(r3)
            goto L_0x01b3
        L_0x0195:
            boolean r3 = r10 instanceof com.xingin.xhssharesdk.a.r
            if (r3 == 0) goto L_0x01a3
            r3 = r10
            com.xingin.xhssharesdk.a.r r3 = (com.xingin.xhssharesdk.a.r) r3
            com.xingin.xhssharesdk.a.k r3 = r3.c()
            if (r10 != r3) goto L_0x01b2
            goto L_0x01b0
        L_0x01a3:
            boolean r3 = r10 instanceof java.lang.Enum
            if (r3 == 0) goto L_0x01b2
            r3 = r10
            java.lang.Enum r3 = (java.lang.Enum) r3
            int r3 = r3.ordinal()
            if (r3 != 0) goto L_0x01b2
        L_0x01b0:
            r3 = r9
            goto L_0x01b3
        L_0x01b2:
            r3 = r5
        L_0x01b3:
            if (r3 != 0) goto L_0x01b6
            goto L_0x01c4
        L_0x01b6:
            r9 = r5
            goto L_0x01c4
        L_0x01b8:
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.Object r3 = com.xingin.xhssharesdk.a.k.f(r3, r13, r4)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r9 = r3.booleanValue()
        L_0x01c4:
            if (r9 == 0) goto L_0x004d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = r5
        L_0x01cc:
            int r9 = r6.length()
            if (r4 >= r9) goto L_0x01e9
            char r9 = r6.charAt(r4)
            boolean r11 = java.lang.Character.isUpperCase(r9)
            if (r11 == 0) goto L_0x01df
            r3.append(r8)
        L_0x01df:
            char r9 = java.lang.Character.toLowerCase(r9)
            r3.append(r9)
            int r4 = r4 + 1
            goto L_0x01cc
        L_0x01e9:
            java.lang.String r3 = r3.toString()
            b(r14, r15, r3, r10)
            goto L_0x004d
        L_0x01f2:
            boolean r0 = r13 instanceof com.xingin.xhssharesdk.a.k.d
            if (r0 == 0) goto L_0x023c
            r0 = r13
            com.xingin.xhssharesdk.a.k$d r0 = (com.xingin.xhssharesdk.a.k.d) r0
            com.xingin.xhssharesdk.a.j r0 = r0.d
            boolean r1 = r0.c
            if (r1 == 0) goto L_0x0211
            com.xingin.xhssharesdk.a.n$b r1 = new com.xingin.xhssharesdk.a.n$b
            com.xingin.xhssharesdk.a.v r0 = r0.f8133a
            java.util.Set r0 = r0.entrySet()
            com.xingin.xhssharesdk.a.w$d r0 = (com.xingin.xhssharesdk.a.w.d) r0
            java.util.Iterator r0 = r0.iterator()
            r1.<init>(r0)
            goto L_0x021d
        L_0x0211:
            com.xingin.xhssharesdk.a.v r0 = r0.f8133a
            java.util.Set r0 = r0.entrySet()
            com.xingin.xhssharesdk.a.w$d r0 = (com.xingin.xhssharesdk.a.w.d) r0
            java.util.Iterator r1 = r0.iterator()
        L_0x021d:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x023c
            java.lang.Object r0 = r1.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r2 = r0.getKey()
            com.xingin.xhssharesdk.a.k$e r2 = (com.xingin.xhssharesdk.a.k.e) r2
            r2.getClass()
            java.lang.Object r0 = r0.getValue()
            java.lang.String r2 = "[0]"
            b(r14, r15, r2, r0)
            goto L_0x021d
        L_0x023c:
            com.xingin.xhssharesdk.a.k r13 = (com.xingin.xhssharesdk.a.k) r13
            com.xingin.xhssharesdk.a.z r13 = r13.b
            if (r13 == 0) goto L_0x025a
        L_0x0242:
            int r0 = r13.f8152a
            if (r5 >= r0) goto L_0x025a
            int[] r0 = r13.b
            r0 = r0[r5]
            int r0 = r0 >>> 3
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.Object[] r1 = r13.c
            r1 = r1[r5]
            b(r14, r15, r0, r1)
            int r5 = r5 + 1
            goto L_0x0242
        L_0x025a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xingin.xhssharesdk.a.t.a(com.xingin.xhssharesdk.a.r, java.lang.StringBuilder, int):void");
    }

    public static final void b(StringBuilder sb, int i, String str, Object obj) {
        String obj2;
        String a2;
        if (obj instanceof List) {
            for (Object b : (List) obj) {
                b(sb, i, str, b);
            }
            return;
        }
        sb.append(10);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            a2 = x.a(e.a((String) obj));
        } else if (obj instanceof e) {
            sb.append(": \"");
            a2 = x.a((e) obj);
        } else {
            if (obj instanceof k) {
                sb.append(" {");
                a((k) obj, sb, i + 2);
                sb.append(StringUtils.LF);
                for (int i3 = 0; i3 < i; i3++) {
                    sb.append(' ');
                }
                obj2 = "}";
            } else {
                sb.append(": ");
                obj2 = obj.toString();
            }
            sb.append(obj2);
            return;
        }
        sb.append(a2);
        sb.append('\"');
    }
}
