package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.eclipse.jetty.util.URIUtil;

public final class ap {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, String> f9536a;

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (al.a(th2)) {
                return "fail";
            }
            th2.printStackTrace();
            return "fail";
        }
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        al.c("[Util] Unzip %d bytes data with type %s", Integer.valueOf(bArr.length), "Gzip");
        try {
            return bh.a().b(bArr);
        } catch (Throwable th) {
            if (th.getMessage() != null && th.getMessage().contains("Not in GZIP format")) {
                al.d(th.getMessage(), new Object[0]);
                return null;
            } else if (al.a(th)) {
                return null;
            } else {
                th.printStackTrace();
                return null;
            }
        }
    }

    public static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "NULL";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
            instance.update(bArr);
            byte[] digest = instance.digest();
            if (digest == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString().toUpperCase();
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static long d(byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        try {
            return Long.parseLong(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static boolean d(String str) {
        if (b(str)) {
            return false;
        }
        if (str.length() > 255) {
            al.a("URL(%s)'s length is larger than 255.", str);
            return false;
        } else if (str.toLowerCase().startsWith(URIUtil.HTTP)) {
            return true;
        } else {
            al.a("URL(%s) is not start with \"http\".", str);
            return false;
        }
    }

    public static String a() {
        return a(System.currentTimeMillis());
    }

    public static long b() {
        try {
            return (((System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / DateUtils.MILLIS_PER_DAY) * DateUtils.MILLIS_PER_DAY) - ((long) TimeZone.getDefault().getRawOffset());
        } catch (Throwable th) {
            if (al.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String d(String str, String str2) {
        if (aa.b() == null || aa.b().O == null) {
            return "";
        }
        return aa.b().O.getString(str, str2);
    }

    public static String a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j));
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static String a(Date date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    private static boolean b(File file, File file2) {
        if (file == null || file2 == null || file.equals(file2)) {
            al.d("rqdp{  err ZF 1R!}", new Object[0]);
            return false;
        } else if (!file.exists() || !file.canRead()) {
            al.d("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
            return false;
        } else {
            try {
                if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                if (!file2.exists()) {
                    file2.createNewFile();
                }
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
            if (!file2.exists() || !file2.canWrite()) {
                return false;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a A[Catch:{ all -> 0x006e }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0072 A[SYNTHETIC, Splitter:B:30:0x0072] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "rqdp{  ZF end}"
            r1 = 0
            if (r6 == 0) goto L_0x0090
            int r2 = r6.length()
            if (r2 != 0) goto L_0x000d
            goto L_0x0090
        L_0x000d:
            java.lang.String r2 = "rqdp{  ZF start}"
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]
            com.tencent.bugly.proguard.al.c(r2, r4)
            java.lang.String r2 = "UTF-8"
            byte[] r6 = r6.getBytes(r2)     // Catch:{ all -> 0x0062 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0062 }
            r2.<init>(r6)     // Catch:{ all -> 0x0062 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0062 }
            r6.<init>()     // Catch:{ all -> 0x0062 }
            java.util.zip.ZipOutputStream r4 = new java.util.zip.ZipOutputStream     // Catch:{ all -> 0x0062 }
            r4.<init>(r6)     // Catch:{ all -> 0x0062 }
            r5 = 8
            r4.setMethod(r5)     // Catch:{ all -> 0x0045 }
            java.util.zip.ZipEntry r5 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x0045 }
            r5.<init>(r7)     // Catch:{ all -> 0x0045 }
            r4.putNextEntry(r5)     // Catch:{ all -> 0x0045 }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0045 }
        L_0x003b:
            int r5 = r2.read(r7)     // Catch:{ all -> 0x0045 }
            if (r5 <= 0) goto L_0x0047
            r4.write(r7, r3, r5)     // Catch:{ all -> 0x0045 }
            goto L_0x003b
        L_0x0045:
            r6 = move-exception
            goto L_0x0064
        L_0x0047:
            r4.closeEntry()     // Catch:{ all -> 0x0045 }
            r4.flush()     // Catch:{ all -> 0x0045 }
            r4.finish()     // Catch:{ all -> 0x0045 }
            byte[] r6 = r6.toByteArray()     // Catch:{ all -> 0x0045 }
            r4.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r7 = move-exception
            r7.printStackTrace()
        L_0x005c:
            java.lang.Object[] r7 = new java.lang.Object[r3]
            com.tencent.bugly.proguard.al.c(r0, r7)
            return r6
        L_0x0062:
            r6 = move-exception
            r4 = r1
        L_0x0064:
            boolean r7 = com.tencent.bugly.proguard.al.a(r6)     // Catch:{ all -> 0x006e }
            if (r7 != 0) goto L_0x0070
            r6.printStackTrace()     // Catch:{ all -> 0x006e }
            goto L_0x0070
        L_0x006e:
            r6 = move-exception
            goto L_0x0080
        L_0x0070:
            if (r4 == 0) goto L_0x007a
            r4.close()     // Catch:{ IOException -> 0x0076 }
            goto L_0x007a
        L_0x0076:
            r6 = move-exception
            r6.printStackTrace()
        L_0x007a:
            java.lang.Object[] r6 = new java.lang.Object[r3]
            com.tencent.bugly.proguard.al.c(r0, r6)
            return r1
        L_0x0080:
            if (r4 == 0) goto L_0x008a
            r4.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            r7 = move-exception
            r7.printStackTrace()
        L_0x008a:
            java.lang.Object[] r7 = new java.lang.Object[r3]
            com.tencent.bugly.proguard.al.c(r0, r7)
            throw r6
        L_0x0090:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ap.a(java.lang.String, java.lang.String):byte[]");
    }

    public static void c(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.isFile() && file.exists() && file.canWrite()) {
                file.delete();
            }
        }
    }

    public static byte[] c(long j) {
        try {
            return String.valueOf(j).getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void c(String str, String str2) {
        if (aa.b() != null && aa.b().O != null) {
            aa.b().O.edit().putString(str, str2).apply();
        }
    }

    public static void b(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean b(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static String b(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static void b(Parcel parcel, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle((Bundle) null);
            return;
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(next.getKey());
            arrayList2.add(next.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("keys", arrayList);
        bundle.putStringArrayList("values", arrayList2);
        parcel.writeBundle(bundle);
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        al.c("[Util] Zip %d bytes data with type %s", Integer.valueOf(bArr.length), "Gzip");
        try {
            return bh.a().a(bArr);
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> b(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = readBundle.getStringArrayList("keys");
        ArrayList<String> stringArrayList2 = readBundle.getStringArrayList("values");
        if (stringArrayList == null || stringArrayList2 == null || stringArrayList.size() != stringArrayList2.size()) {
            al.e("map parcel error!", new Object[0]);
        } else {
            hashMap = new HashMap(stringArrayList.size());
            for (int i = 0; i < stringArrayList.size(); i++) {
                hashMap.put(stringArrayList.get(i), stringArrayList2.get(i));
            }
        }
        return hashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.util.zip.ZipOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r4v0, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076 A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007e A[SYNTHETIC, Splitter:B:37:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0088 A[SYNTHETIC, Splitter:B:42:0x0088] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File r7, java.io.File r8) {
        /*
            java.lang.String r0 = "rqdp{  ZF end}"
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "rqdp{  ZF start}"
            com.tencent.bugly.proguard.al.c(r3, r2)
            boolean r2 = b((java.io.File) r7, (java.io.File) r8)
            if (r2 != 0) goto L_0x0011
            return r1
        L_0x0011:
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x006e }
            r3.<init>(r7)     // Catch:{ all -> 0x006e }
            java.util.zip.ZipOutputStream r4 = new java.util.zip.ZipOutputStream     // Catch:{ all -> 0x006b }
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x006b }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x006b }
            r6.<init>(r8)     // Catch:{ all -> 0x006b }
            r5.<init>(r6)     // Catch:{ all -> 0x006b }
            r4.<init>(r5)     // Catch:{ all -> 0x006b }
            r8 = 8
            r4.setMethod(r8)     // Catch:{ all -> 0x004b }
            java.util.zip.ZipEntry r8 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x004b }
            java.lang.String r7 = r7.getName()     // Catch:{ all -> 0x004b }
            r8.<init>(r7)     // Catch:{ all -> 0x004b }
            r4.putNextEntry(r8)     // Catch:{ all -> 0x004b }
            r7 = 5000(0x1388, float:7.006E-42)
            r8 = 1000(0x3e8, float:1.401E-42)
            int r7 = java.lang.Math.max(r7, r8)     // Catch:{ all -> 0x004b }
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x004b }
        L_0x0041:
            int r8 = r3.read(r7)     // Catch:{ all -> 0x004b }
            if (r8 <= 0) goto L_0x004e
            r4.write(r7, r1, r8)     // Catch:{ all -> 0x004b }
            goto L_0x0041
        L_0x004b:
            r7 = move-exception
        L_0x004c:
            r2 = r3
            goto L_0x0070
        L_0x004e:
            r4.flush()     // Catch:{ all -> 0x004b }
            r4.closeEntry()     // Catch:{ all -> 0x004b }
            r3.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r7 = move-exception
            r7.printStackTrace()
        L_0x005c:
            r4.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0064:
            java.lang.Object[] r7 = new java.lang.Object[r1]
            com.tencent.bugly.proguard.al.c(r0, r7)
            r7 = 1
            return r7
        L_0x006b:
            r7 = move-exception
            r4 = r2
            goto L_0x004c
        L_0x006e:
            r7 = move-exception
            r4 = r2
        L_0x0070:
            boolean r8 = com.tencent.bugly.proguard.al.a(r7)     // Catch:{ all -> 0x007a }
            if (r8 != 0) goto L_0x007c
            r7.printStackTrace()     // Catch:{ all -> 0x007a }
            goto L_0x007c
        L_0x007a:
            r7 = move-exception
            goto L_0x0096
        L_0x007c:
            if (r2 == 0) goto L_0x0086
            r2.close()     // Catch:{ IOException -> 0x0082 }
            goto L_0x0086
        L_0x0082:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0086:
            if (r4 == 0) goto L_0x0090
            r4.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x0090
        L_0x008c:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0090:
            java.lang.Object[] r7 = new java.lang.Object[r1]
            com.tencent.bugly.proguard.al.c(r0, r7)
            return r1
        L_0x0096:
            if (r2 == 0) goto L_0x00a0
            r2.close()     // Catch:{ IOException -> 0x009c }
            goto L_0x00a0
        L_0x009c:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00a0:
            if (r4 == 0) goto L_0x00aa
            r4.close()     // Catch:{ IOException -> 0x00a6 }
            goto L_0x00aa
        L_0x00a6:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00aa:
            java.lang.Object[] r8 = new java.lang.Object[r1]
            com.tencent.bugly.proguard.al.c(r0, r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ap.a(java.io.File, java.io.File):boolean");
    }

    public static boolean b(Context context, String str) {
        al.c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            al.c("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            al.a(th);
            return false;
        }
    }

    public static BufferedReader b(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str, str2);
            if (file.exists()) {
                if (file.canRead()) {
                    return a(file);
                }
            }
            return null;
        } catch (NullPointerException e) {
            al.a(e);
            return null;
        }
    }

    public static String a(String str) {
        if (str.trim().equals("")) {
            return "";
        }
        try {
            if (f9536a == null) {
                f9536a = new HashMap();
            }
            if (f9536a.containsKey(str)) {
                return f9536a.get(str);
            }
            String systemProperty = NativeCrashHandler.getInstance().getSystemProperty(str);
            if (!TextUtils.isEmpty(systemProperty) && !systemProperty.equals("fail")) {
                f9536a.put(str, systemProperty);
            }
            return systemProperty;
        } catch (Throwable th) {
            al.b(th);
            return "fail";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r0 = r1.getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Context a(android.content.Context r1) {
        /*
            if (r1 != 0) goto L_0x0003
            return r1
        L_0x0003:
            android.content.Context r0 = r1.getApplicationContext()
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ap.a(android.content.Context):android.content.Context");
    }

    public static void a(Class<?> cls, String str, Object obj) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set((Object) null, obj);
        } catch (Exception unused) {
        }
    }

    public static Object a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke((Object) null, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Parcel parcel, Map<String, PlugInBean> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle((Bundle) null);
            return;
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(next.getKey());
            arrayList2.add(next.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pluginNum", arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            bundle.putString("pluginKey".concat(String.valueOf(i)), (String) arrayList.get(i));
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            bundle.putString("pluginVal" + i2 + "plugInId", ((PlugInBean) arrayList2.get(i2)).f9503a);
            bundle.putString("pluginVal" + i2 + "plugInUUID", ((PlugInBean) arrayList2.get(i2)).c);
            bundle.putString("pluginVal" + i2 + "plugInVersion", ((PlugInBean) arrayList2.get(i2)).b);
        }
        parcel.writeBundle(bundle);
    }

    public static Map<String, PlugInBean> a(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int intValue = ((Integer) readBundle.get("pluginNum")).intValue();
        for (int i = 0; i < intValue; i++) {
            arrayList.add(readBundle.getString("pluginKey".concat(String.valueOf(i))));
        }
        for (int i2 = 0; i2 < intValue; i2++) {
            arrayList2.add(new PlugInBean(readBundle.getString("pluginVal" + i2 + "plugInId"), readBundle.getString("pluginVal" + i2 + "plugInVersion"), readBundle.getString("pluginVal" + i2 + "plugInUUID")));
        }
        if (arrayList.size() == arrayList2.size()) {
            hashMap = new HashMap(arrayList.size());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                hashMap.put(arrayList.get(i3), PlugInBean.class.cast(arrayList2.get(i3)));
            }
        } else {
            al.e("map plugin parcel error!", new Object[0]);
        }
        return hashMap;
    }

    public static byte[] a(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static String a(int i, String str) {
        String[] strArr;
        if (str == null) {
            strArr = new String[]{"logcat", "-d", "-v", "threadtime"};
        } else {
            strArr = new String[]{"logcat", "-d", "-v", "threadtime", "-s", str};
        }
        StringBuilder sb = new StringBuilder();
        Process process = null;
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append(StringUtils.LF);
                if (i > 0 && sb.length() > i) {
                    sb.delete(0, sb.length() - i);
                }
            }
            String sb2 = sb.toString();
            try {
                exec.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                exec.getInputStream().close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                exec.getErrorStream().close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return sb2;
        } catch (Throwable th) {
            if (process != null) {
                try {
                    process.getOutputStream().close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                try {
                    process.getInputStream().close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                try {
                    process.getErrorStream().close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static Map<String, String> a(boolean z, int i) {
        if (!z) {
            al.c("get all thread stack not enable", new Object[0]);
            return new HashMap();
        }
        Map<String, String> a2 = a(i);
        return a2 == null ? new HashMap() : a2;
    }

    private static Map<String, String> a(int i) {
        HashMap hashMap = new HashMap(12);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread thread = Looper.getMainLooper().getThread();
        if (!allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : allStackTraces.entrySet()) {
            int i2 = 0;
            sb.setLength(0);
            if (!(next.getValue() == null || ((StackTraceElement[]) next.getValue()).length == 0)) {
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) next.getValue();
                int length = stackTraceElementArr.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTraceElementArr[i2];
                    if (i > 0 && sb.length() >= i) {
                        sb.append("\n[Stack over limit size :" + i + " , has been cut!]");
                        break;
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append(StringUtils.LF);
                    i2++;
                }
                hashMap.put(((Thread) next.getKey()).getName() + "(" + ((Thread) next.getKey()).getId() + ")", sb.toString());
            }
        }
        return hashMap;
    }

    public static String a(Thread thread) {
        if (thread == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(StringUtils.LF);
        }
        return sb.toString();
    }

    public static boolean a(Context context, String str) {
        al.c("[Util] Try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < 10000) {
                    return false;
                }
                al.c("[Util] Lock file (%s) is expired, unlock it.", str);
                b(context, str);
            }
            if (file.createNewFile()) {
                al.c("[Util] Successfully locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                return true;
            }
            al.c("[Util] Failed to locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return false;
        } catch (Throwable th) {
            al.a(th);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0067 A[SYNTHETIC, Splitter:B:31:0x0067] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r5, int r6, boolean r7) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x007c
            boolean r1 = r5.exists()
            if (r1 == 0) goto L_0x007c
            boolean r1 = r5.canRead()
            if (r1 != 0) goto L_0x0011
            goto L_0x007c
        L_0x0011:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0060 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0060 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x0060 }
            r4.<init>(r5)     // Catch:{ all -> 0x0060 }
            java.lang.String r5 = "utf-8"
            r3.<init>(r4, r5)     // Catch:{ all -> 0x0060 }
            r2.<init>(r3)     // Catch:{ all -> 0x0060 }
        L_0x0027:
            java.lang.String r5 = r2.readLine()     // Catch:{ all -> 0x0047 }
            if (r5 == 0) goto L_0x0053
            r1.append(r5)     // Catch:{ all -> 0x0047 }
            java.lang.String r5 = "\n"
            r1.append(r5)     // Catch:{ all -> 0x0047 }
            if (r6 <= 0) goto L_0x0027
            int r5 = r1.length()     // Catch:{ all -> 0x0047 }
            if (r5 <= r6) goto L_0x0027
            if (r7 == 0) goto L_0x0049
            int r5 = r1.length()     // Catch:{ all -> 0x0047 }
            r1.delete(r6, r5)     // Catch:{ all -> 0x0047 }
            goto L_0x0053
        L_0x0047:
            r5 = move-exception
            goto L_0x0062
        L_0x0049:
            int r5 = r1.length()     // Catch:{ all -> 0x0047 }
            int r5 = r5 - r6
            r3 = 0
            r1.delete(r3, r5)     // Catch:{ all -> 0x0047 }
            goto L_0x0027
        L_0x0053:
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x0047 }
            r2.close()     // Catch:{ Exception -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r6 = move-exception
            com.tencent.bugly.proguard.al.a(r6)
        L_0x005f:
            return r5
        L_0x0060:
            r5 = move-exception
            r2 = r0
        L_0x0062:
            com.tencent.bugly.proguard.al.a(r5)     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x006f
            r2.close()     // Catch:{ Exception -> 0x006b }
            goto L_0x006f
        L_0x006b:
            r5 = move-exception
            com.tencent.bugly.proguard.al.a(r5)
        L_0x006f:
            return r0
        L_0x0070:
            r5 = move-exception
            if (r2 == 0) goto L_0x007b
            r2.close()     // Catch:{ Exception -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r6 = move-exception
            com.tencent.bugly.proguard.al.a(r6)
        L_0x007b:
            throw r5
        L_0x007c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ap.a(java.io.File, int, boolean):java.lang.String");
    }

    public static BufferedReader a(File file) {
        if (file.exists() && file.canRead()) {
            try {
                return new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            } catch (Throwable th) {
                al.a(th);
            }
        }
        return null;
    }

    public static Thread a(Runnable runnable, String str) {
        try {
            Thread thread = new Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (Throwable th) {
            al.e("[Util] Failed to start a thread to execute task with message: %s", th.getMessage());
            return null;
        }
    }

    public static boolean a(Runnable runnable) {
        ak a2 = ak.a();
        if (a2 != null) {
            return a2.a(runnable);
        }
        String[] split = runnable.getClass().getName().split("\\.");
        return a(runnable, split[split.length - 1]) != null;
    }

    public static SharedPreferences a(String str, Context context) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }

    /* JADX INFO: finally extract failed */
    public static <T> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        try {
            T createFromParcel = creator.createFromParcel(obtain);
            obtain.recycle();
            return createFromParcel;
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }
}
