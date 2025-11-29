package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a  reason: collision with other inner class name */
    public static class C0034a {

        /* renamed from: a  reason: collision with root package name */
        public String f9604a;
        public String b;
        public String c;
        public long d;
        public Bundle e;
    }

    public static int a(Bundle bundle, String str, int i) {
        if (bundle == null) {
            return i;
        }
        try {
            return bundle.getInt(str, i);
        } catch (Exception e) {
            Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + e.getMessage());
            return i;
        }
    }

    public static Object a(int i, String str) {
        switch (i) {
            case 1:
                return Integer.valueOf(str);
            case 2:
                return Long.valueOf(str);
            case 3:
                return str;
            case 4:
                return Boolean.valueOf(str);
            case 5:
                return Float.valueOf(str);
            case 6:
                return Double.valueOf(str);
            default:
                try {
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                    return null;
                } catch (Exception e) {
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e.getMessage());
                    return null;
                }
        }
    }

    public static String a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + e.getMessage());
            return null;
        }
    }

    public static boolean a(Context context, C0034a aVar) {
        String str;
        String str2;
        if (context == null || aVar == null) {
            str = "send fail, invalid argument";
        } else if (b.b(aVar.b)) {
            str = "send fail, action is null";
        } else {
            if (!b.b(aVar.f9604a)) {
                str2 = aVar.f9604a + ".permission.MM_MESSAGE";
            } else {
                str2 = null;
            }
            Intent intent = new Intent(aVar.b);
            Bundle bundle = aVar.e;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, aVar.c);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, aVar.d);
            intent.putExtra(ConstantsAPI.CHECK_SUM, a(aVar.c, (int) Build.SDK_INT, packageName));
            context.sendBroadcast(intent, str2);
            Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
            return true;
        }
        Log.e("MicroMsg.SDK.MMessage", str);
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:40|41|(2:42|(1:44)(1:156))|53|54|55|56|57|58|59|60) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x008b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x008e */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0103 A[SYNTHETIC, Splitter:B:102:0x0103] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0123 A[SYNTHETIC, Splitter:B:112:0x0123] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0128 A[SYNTHETIC, Splitter:B:116:0x0128] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x012d A[SYNTHETIC, Splitter:B:120:0x012d] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x014a A[SYNTHETIC, Splitter:B:128:0x014a] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x014f A[SYNTHETIC, Splitter:B:132:0x014f] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0154 A[SYNTHETIC, Splitter:B:136:0x0154] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x015c A[SYNTHETIC, Splitter:B:142:0x015c] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0161 A[SYNTHETIC, Splitter:B:146:0x0161] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0166 A[SYNTHETIC, Splitter:B:150:0x0166] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x00f9 A[SYNTHETIC, Splitter:B:94:0x00f9] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x00fe A[SYNTHETIC, Splitter:B:98:0x00fe] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:91:0x00e1=Splitter:B:91:0x00e1, B:125:0x0132=Splitter:B:125:0x0132, B:109:0x010b=Splitter:B:109:0x010b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r8, int r9) {
        /*
            java.lang.String r0 = "httpGet ex:"
            java.lang.String r1 = "MicroMsg.SDK.NetUtil"
            r2 = 0
            if (r8 == 0) goto L_0x016a
            int r3 = r8.length()
            if (r3 != 0) goto L_0x000f
            goto L_0x016a
        L_0x000f:
            java.net.URL r3 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00d6, IOException -> 0x00d1, Exception -> 0x00cc, all -> 0x00c7 }
            r3.<init>(r8)     // Catch:{ MalformedURLException -> 0x00d6, IOException -> 0x00d1, Exception -> 0x00cc, all -> 0x00c7 }
            java.net.URLConnection r8 = r3.openConnection()     // Catch:{ MalformedURLException -> 0x00d6, IOException -> 0x00d1, Exception -> 0x00cc, all -> 0x00c7 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ MalformedURLException -> 0x00d6, IOException -> 0x00d1, Exception -> 0x00cc, all -> 0x00c7 }
            if (r8 != 0) goto L_0x002f
            java.lang.String r9 = "open connection failed."
            com.tencent.mm.opensdk.utils.Log.e(r1, r9)     // Catch:{ MalformedURLException -> 0x002d, IOException -> 0x002b, Exception -> 0x0029, all -> 0x0027 }
            if (r8 == 0) goto L_0x0026
            r8.disconnect()     // Catch:{ all -> 0x0026 }
        L_0x0026:
            return r2
        L_0x0027:
            r9 = move-exception
            goto L_0x004b
        L_0x0029:
            r9 = move-exception
            goto L_0x004e
        L_0x002b:
            r9 = move-exception
            goto L_0x0052
        L_0x002d:
            r9 = move-exception
            goto L_0x0056
        L_0x002f:
            java.lang.String r3 = "GET"
            r8.setRequestMethod(r3)     // Catch:{ MalformedURLException -> 0x00c3, IOException -> 0x00c0, Exception -> 0x00bd, all -> 0x00ba }
            r8.setConnectTimeout(r9)     // Catch:{ MalformedURLException -> 0x00c3, IOException -> 0x00c0, Exception -> 0x00bd, all -> 0x00ba }
            r8.setReadTimeout(r9)     // Catch:{ MalformedURLException -> 0x00c3, IOException -> 0x00c0, Exception -> 0x00bd, all -> 0x00ba }
            int r9 = r8.getResponseCode()     // Catch:{ MalformedURLException -> 0x00c3, IOException -> 0x00c0, Exception -> 0x00bd, all -> 0x00ba }
            r3 = 300(0x12c, float:4.2E-43)
            if (r9 < r3) goto L_0x005a
            java.lang.String r9 = "httpURLConnectionGet 300"
            com.tencent.mm.opensdk.utils.Log.e(r1, r9)     // Catch:{ MalformedURLException -> 0x002d, IOException -> 0x002b, Exception -> 0x0029, all -> 0x0027 }
            r8.disconnect()     // Catch:{ all -> 0x004a }
        L_0x004a:
            return r2
        L_0x004b:
            r0 = r2
            goto L_0x015a
        L_0x004e:
            r3 = r2
            r4 = r3
            goto L_0x00e1
        L_0x0052:
            r3 = r2
            r4 = r3
            goto L_0x010b
        L_0x0056:
            r3 = r2
            r4 = r3
            goto L_0x0132
        L_0x005a:
            java.io.InputStream r9 = r8.getInputStream()     // Catch:{ MalformedURLException -> 0x00c3, IOException -> 0x00c0, Exception -> 0x00bd, all -> 0x00ba }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ MalformedURLException -> 0x00b4, IOException -> 0x00ae, Exception -> 0x00a9, all -> 0x00a4 }
            r3.<init>()     // Catch:{ MalformedURLException -> 0x00b4, IOException -> 0x00ae, Exception -> 0x00a9, all -> 0x00a4 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ MalformedURLException -> 0x007d, IOException -> 0x007b, Exception -> 0x0079, all -> 0x0073 }
        L_0x0067:
            int r5 = r9.read(r4)     // Catch:{ MalformedURLException -> 0x007d, IOException -> 0x007b, Exception -> 0x0079, all -> 0x0073 }
            r6 = -1
            if (r5 == r6) goto L_0x007f
            r6 = 0
            r3.write(r4, r6, r5)     // Catch:{ MalformedURLException -> 0x007d, IOException -> 0x007b, Exception -> 0x0079, all -> 0x0073 }
            goto L_0x0067
        L_0x0073:
            r0 = move-exception
            r2 = r3
            r3 = r9
            r9 = r0
            goto L_0x0158
        L_0x0079:
            r4 = move-exception
            goto L_0x0092
        L_0x007b:
            r4 = move-exception
            goto L_0x0098
        L_0x007d:
            r4 = move-exception
            goto L_0x009e
        L_0x007f:
            byte[] r4 = r3.toByteArray()     // Catch:{ MalformedURLException -> 0x007d, IOException -> 0x007b, Exception -> 0x0079, all -> 0x0073 }
            java.lang.String r5 = "httpGet end"
            com.tencent.mm.opensdk.utils.Log.d(r1, r5)     // Catch:{ MalformedURLException -> 0x007d, IOException -> 0x007b, Exception -> 0x0079, all -> 0x0073 }
            r8.disconnect()     // Catch:{ all -> 0x008b }
        L_0x008b:
            r9.close()     // Catch:{ all -> 0x008e }
        L_0x008e:
            r3.close()     // Catch:{ all -> 0x0091 }
        L_0x0091:
            return r4
        L_0x0092:
            r7 = r3
            r3 = r9
            r9 = r4
            r4 = r7
            goto L_0x00e1
        L_0x0098:
            r7 = r3
            r3 = r9
            r9 = r4
            r4 = r7
            goto L_0x010b
        L_0x009e:
            r7 = r3
            r3 = r9
            r9 = r4
            r4 = r7
            goto L_0x0132
        L_0x00a4:
            r0 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
            goto L_0x00db
        L_0x00a9:
            r3 = move-exception
            r7 = r3
            r3 = r9
            r9 = r7
            goto L_0x00e0
        L_0x00ae:
            r3 = move-exception
            r7 = r3
            r3 = r9
            r9 = r7
            goto L_0x010a
        L_0x00b4:
            r3 = move-exception
            r7 = r3
            r3 = r9
            r9 = r7
            goto L_0x0131
        L_0x00ba:
            r9 = move-exception
            r0 = r2
            goto L_0x00db
        L_0x00bd:
            r9 = move-exception
            r3 = r2
            goto L_0x00e0
        L_0x00c0:
            r9 = move-exception
            r3 = r2
            goto L_0x010a
        L_0x00c3:
            r9 = move-exception
            r3 = r2
            goto L_0x0131
        L_0x00c7:
            r8 = move-exception
            r9 = r8
            r8 = r2
            r0 = r8
            goto L_0x00db
        L_0x00cc:
            r8 = move-exception
            r9 = r8
            r8 = r2
            r3 = r8
            goto L_0x00e0
        L_0x00d1:
            r8 = move-exception
            r9 = r8
            r8 = r2
            r3 = r8
            goto L_0x010a
        L_0x00d6:
            r8 = move-exception
            r9 = r8
            r8 = r2
            r3 = r8
            goto L_0x0131
        L_0x00db:
            r7 = r2
            r2 = r0
            r0 = r7
            goto L_0x015a
        L_0x00e0:
            r4 = r2
        L_0x00e1:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0107 }
            r5.<init>()     // Catch:{ all -> 0x0107 }
            r5.append(r0)     // Catch:{ all -> 0x0107 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0107 }
            r5.append(r9)     // Catch:{ all -> 0x0107 }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x0107 }
            com.tencent.mm.opensdk.utils.Log.e(r1, r9)     // Catch:{ all -> 0x0107 }
            if (r8 == 0) goto L_0x00fc
            r8.disconnect()     // Catch:{ all -> 0x00fc }
        L_0x00fc:
            if (r3 == 0) goto L_0x0101
            r3.close()     // Catch:{ all -> 0x0101 }
        L_0x0101:
            if (r4 == 0) goto L_0x0106
            r4.close()     // Catch:{ all -> 0x0106 }
        L_0x0106:
            return r2
        L_0x0107:
            r9 = move-exception
            r2 = r4
            goto L_0x0158
        L_0x010a:
            r4 = r2
        L_0x010b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0107 }
            r5.<init>()     // Catch:{ all -> 0x0107 }
            r5.append(r0)     // Catch:{ all -> 0x0107 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0107 }
            r5.append(r9)     // Catch:{ all -> 0x0107 }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x0107 }
            com.tencent.mm.opensdk.utils.Log.e(r1, r9)     // Catch:{ all -> 0x0107 }
            if (r8 == 0) goto L_0x0126
            r8.disconnect()     // Catch:{ all -> 0x0126 }
        L_0x0126:
            if (r3 == 0) goto L_0x012b
            r3.close()     // Catch:{ all -> 0x012b }
        L_0x012b:
            if (r4 == 0) goto L_0x0130
            r4.close()     // Catch:{ all -> 0x0130 }
        L_0x0130:
            return r2
        L_0x0131:
            r4 = r2
        L_0x0132:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0107 }
            r5.<init>()     // Catch:{ all -> 0x0107 }
            r5.append(r0)     // Catch:{ all -> 0x0107 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0107 }
            r5.append(r9)     // Catch:{ all -> 0x0107 }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x0107 }
            com.tencent.mm.opensdk.utils.Log.e(r1, r9)     // Catch:{ all -> 0x0107 }
            if (r8 == 0) goto L_0x014d
            r8.disconnect()     // Catch:{ all -> 0x014d }
        L_0x014d:
            if (r3 == 0) goto L_0x0152
            r3.close()     // Catch:{ all -> 0x0152 }
        L_0x0152:
            if (r4 == 0) goto L_0x0157
            r4.close()     // Catch:{ all -> 0x0157 }
        L_0x0157:
            return r2
        L_0x0158:
            r0 = r2
            r2 = r3
        L_0x015a:
            if (r8 == 0) goto L_0x015f
            r8.disconnect()     // Catch:{ all -> 0x015f }
        L_0x015f:
            if (r2 == 0) goto L_0x0164
            r2.close()     // Catch:{ all -> 0x0164 }
        L_0x0164:
            if (r0 == 0) goto L_0x0169
            r0.close()     // Catch:{ all -> 0x0169 }
        L_0x0169:
            throw r9
        L_0x016a:
            java.lang.String r8 = "httpGet, url is null"
            com.tencent.mm.opensdk.utils.Log.e(r1, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.channel.a.a.a(java.lang.String, int):byte[]");
    }

    public static byte[] a(String str, int i, String str2) {
        String str3;
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = stringBuffer.toString().substring(1, 9).getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bytes);
            char[] cArr2 = new char[(r9 * 2)];
            int i2 = 0;
            for (byte b : instance.digest()) {
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 += 2;
                cArr2[i3] = cArr[b & 15];
            }
            str3 = new String(cArr2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3.getBytes();
    }
}
