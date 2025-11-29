package androidx.work;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Data {
    public static final String b = Logger.i("Data");
    public static final Data c = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    public Map f2053a;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Map f2054a = new HashMap();

        public Data a() {
            Data data = new Data(this.f2054a);
            Data.k(data);
            return data;
        }

        public Builder b(String str, Object obj) {
            if (obj == null) {
                this.f2054a.put(str, (Object) null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.f2054a.put(str, obj);
                } else if (cls == boolean[].class) {
                    this.f2054a.put(str, Data.a((boolean[]) obj));
                } else if (cls == byte[].class) {
                    this.f2054a.put(str, Data.b((byte[]) obj));
                } else if (cls == int[].class) {
                    this.f2054a.put(str, Data.e((int[]) obj));
                } else if (cls == long[].class) {
                    this.f2054a.put(str, Data.f((long[]) obj));
                } else if (cls == float[].class) {
                    this.f2054a.put(str, Data.d((float[]) obj));
                } else if (cls == double[].class) {
                    this.f2054a.put(str, Data.c((double[]) obj));
                } else {
                    throw new IllegalArgumentException("Key " + str + " has invalid type " + cls);
                }
            }
            return this;
        }

        public Builder c(Map map) {
            for (Map.Entry entry : map.entrySet()) {
                b((String) entry.getKey(), entry.getValue());
            }
            return this;
        }
    }

    public Data(Data data) {
        this.f2053a = new HashMap(data.f2053a);
    }

    public static Boolean[] a(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    public static Byte[] b(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    public static Double[] c(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    public static Float[] d(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    public static Integer[] e(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    public static Long[] f(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0053 A[SYNTHETIC, Splitter:B:27:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068 A[SYNTHETIC, Splitter:B:36:0x0068] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0039=Splitter:B:16:0x0039, B:31:0x005d=Splitter:B:31:0x005d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.work.Data g(byte[] r7) {
        /*
            java.lang.String r0 = "Error in Data#fromByteArray: "
            int r1 = r7.length
            r2 = 10240(0x2800, float:1.4349E-41)
            if (r1 > r2) goto L_0x007d
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r7)
            r7 = 0
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ IOException | ClassNotFoundException -> 0x0048, all -> 0x0044 }
            r3.<init>(r2)     // Catch:{ IOException | ClassNotFoundException -> 0x0048, all -> 0x0044 }
            int r7 = r3.readInt()     // Catch:{ IOException | ClassNotFoundException -> 0x002d }
        L_0x001b:
            if (r7 <= 0) goto L_0x002f
            java.lang.String r4 = r3.readUTF()     // Catch:{ IOException | ClassNotFoundException -> 0x002d }
            java.lang.Object r5 = r3.readObject()     // Catch:{ IOException | ClassNotFoundException -> 0x002d }
            r1.put(r4, r5)     // Catch:{ IOException | ClassNotFoundException -> 0x002d }
            int r7 = r7 + -1
            goto L_0x001b
        L_0x002b:
            r7 = move-exception
            goto L_0x0066
        L_0x002d:
            r7 = move-exception
            goto L_0x004c
        L_0x002f:
            r3.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0039
        L_0x0033:
            r7 = move-exception
            java.lang.String r3 = b
            android.util.Log.e(r3, r0, r7)
        L_0x0039:
            r2.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0060
        L_0x003d:
            r7 = move-exception
            java.lang.String r2 = b
            android.util.Log.e(r2, r0, r7)
            goto L_0x0060
        L_0x0044:
            r1 = move-exception
            r3 = r7
            r7 = r1
            goto L_0x0066
        L_0x0048:
            r3 = move-exception
            r6 = r3
            r3 = r7
            r7 = r6
        L_0x004c:
            java.lang.String r4 = b     // Catch:{ all -> 0x002b }
            android.util.Log.e(r4, r0, r7)     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x005d
            r3.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x005d
        L_0x0057:
            r7 = move-exception
            java.lang.String r3 = b
            android.util.Log.e(r3, r0, r7)
        L_0x005d:
            r2.close()     // Catch:{ IOException -> 0x003d }
        L_0x0060:
            androidx.work.Data r7 = new androidx.work.Data
            r7.<init>((java.util.Map) r1)
            return r7
        L_0x0066:
            if (r3 == 0) goto L_0x0072
            r3.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x0072
        L_0x006c:
            r1 = move-exception
            java.lang.String r3 = b
            android.util.Log.e(r3, r0, r1)
        L_0x0072:
            r2.close()     // Catch:{ IOException -> 0x0076 }
            goto L_0x007c
        L_0x0076:
            r1 = move-exception
            java.lang.String r2 = b
            android.util.Log.e(r2, r0, r1)
        L_0x007c:
            throw r7
        L_0x007d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.g(byte[]):androidx.work.Data");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0078 A[SYNTHETIC, Splitter:B:31:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008f A[SYNTHETIC, Splitter:B:41:0x008f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] k(androidx.work.Data r5) {
        /*
            java.lang.String r0 = "Error in Data#toByteArray: "
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 0
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x006c }
            r3.<init>(r1)     // Catch:{ IOException -> 0x006c }
            int r2 = r5.j()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r3.writeInt(r2)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.util.Map r5 = r5.f2053a     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
        L_0x001e:
            boolean r2 = r5.hasNext()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            if (r2 == 0) goto L_0x0041
            java.lang.Object r2 = r5.next()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.lang.Object r4 = r2.getKey()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r3.writeUTF(r4)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.lang.Object r2 = r2.getValue()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r3.writeObject(r2)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            goto L_0x001e
        L_0x003b:
            r5 = move-exception
            r2 = r3
            goto L_0x008d
        L_0x003e:
            r5 = move-exception
            r2 = r3
            goto L_0x006d
        L_0x0041:
            r3.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x004b
        L_0x0045:
            r5 = move-exception
            java.lang.String r2 = b
            android.util.Log.e(r2, r0, r5)
        L_0x004b:
            r1.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0055
        L_0x004f:
            r5 = move-exception
            java.lang.String r2 = b
            android.util.Log.e(r2, r0, r5)
        L_0x0055:
            int r5 = r1.size()
            r0 = 10240(0x2800, float:1.4349E-41)
            if (r5 > r0) goto L_0x0062
            byte[] r5 = r1.toByteArray()
            return r5
        L_0x0062:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r5.<init>(r0)
            throw r5
        L_0x006a:
            r5 = move-exception
            goto L_0x008d
        L_0x006c:
            r5 = move-exception
        L_0x006d:
            java.lang.String r3 = b     // Catch:{ all -> 0x006a }
            android.util.Log.e(r3, r0, r5)     // Catch:{ all -> 0x006a }
            byte[] r5 = r1.toByteArray()     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x0082
            r2.close()     // Catch:{ IOException -> 0x007c }
            goto L_0x0082
        L_0x007c:
            r2 = move-exception
            java.lang.String r3 = b
            android.util.Log.e(r3, r0, r2)
        L_0x0082:
            r1.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008c
        L_0x0086:
            r1 = move-exception
            java.lang.String r2 = b
            android.util.Log.e(r2, r0, r1)
        L_0x008c:
            return r5
        L_0x008d:
            if (r2 == 0) goto L_0x0099
            r2.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x0099
        L_0x0093:
            r2 = move-exception
            java.lang.String r3 = b
            android.util.Log.e(r3, r0, r2)
        L_0x0099:
            r1.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00a3
        L_0x009d:
            r1 = move-exception
            java.lang.String r2 = b
            android.util.Log.e(r2, r0, r1)
        L_0x00a3:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.k(androidx.work.Data):byte[]");
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj == null || Data.class != obj.getClass()) {
            return false;
        }
        Data data = (Data) obj;
        Set<String> keySet = this.f2053a.keySet();
        if (!keySet.equals(data.f2053a.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj2 = this.f2053a.get(str);
            Object obj3 = data.f2053a.get(str);
            if (obj2 == null || obj3 == null) {
                if (obj2 == obj3) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } else if (!(obj2 instanceof Object[]) || !(obj3 instanceof Object[])) {
                z = obj2.equals(obj3);
                continue;
            } else {
                z = Arrays.deepEquals((Object[]) obj2, (Object[]) obj3);
                continue;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public Map h() {
        return Collections.unmodifiableMap(this.f2053a);
    }

    public int hashCode() {
        return this.f2053a.hashCode() * 31;
    }

    public String i(String str) {
        Object obj = this.f2053a.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public int j() {
        return this.f2053a.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.f2053a.isEmpty()) {
            for (String str : this.f2053a.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = this.f2053a.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public Data(Map map) {
        this.f2053a = new HashMap(map);
    }
}
