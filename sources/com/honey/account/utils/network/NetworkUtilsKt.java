package com.honey.account.utils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.honey.account.utils.network.Request;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b\u001a\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b\u001a.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015\u001a:\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\u00152\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015\u001aF\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00152\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u001b\u001a\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"CONNECT_TIMEOUT", "", "READ_TIMEOUT", "TAG", "", "activeInfo", "Landroid/net/NetworkInfo;", "context", "Landroid/content/Context;", "getNetworkInfo", "inputStreamToString", "inputStream", "Ljava/io/InputStream;", "isNetworkConnected", "", "networkRequestToPost", "Lcom/honey/account/utils/network/Response;", "url", "parameter", "", "headerMap", "Ljava/util/HashMap;", "networkRequestToPostForm", "paramMap", "", "networkRequestUploadImage", "file", "Ljava/io/File;", "networkingRequest", "request", "Lcom/honey/account/utils/network/Request;", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNetworkUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkUtils.kt\ncom/honey/account/utils/network/NetworkUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,246:1\n1#2:247\n*E\n"})
public final class NetworkUtilsKt {
    private static final int CONNECT_TIMEOUT = 60000;
    private static final int READ_TIMEOUT = 60000;
    @NotNull
    private static final String TAG = "NetworkUtils";

    @Nullable
    public static final NetworkInfo activeInfo(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return ((ConnectivityManager) systemService).getActiveNetworkInfo();
    }

    public static final int getNetworkInfo(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NetworkInfo activeInfo = activeInfo(context);
        if (activeInfo != null) {
            return activeInfo.getType();
        }
        return 0;
    }

    private static final String inputStreamToString(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final boolean isNetworkConnected(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return true;
        }
    }

    @NotNull
    public static final Response networkRequestToPost(@NotNull String str, @NotNull byte[] bArr, @Nullable HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bArr, "parameter");
        return networkingRequest(new Request.Builder(str).setParameter(bArr).setRequestMethod("POST").setConnectTimeout(60000).setReadTimeout(60000).setDoOutput(true).setUseCaches(false).setRequestProperties((Map<String, String>) hashMap).build());
    }

    public static /* synthetic */ Response networkRequestToPost$default(String str, byte[] bArr, HashMap hashMap, int i, Object obj) {
        if ((i & 4) != 0) {
            hashMap = null;
        }
        return networkRequestToPost(str, bArr, hashMap);
    }

    @NotNull
    public static final Response networkRequestToPostForm(@NotNull String str, @NotNull HashMap<String, Object> hashMap, @Nullable HashMap<String, String> hashMap2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(hashMap, "paramMap");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : hashMap.entrySet()) {
            Object value = next.getValue();
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append(StringsKt.replace$default(value.toString(), " ", "%20", false, 4, (Object) null));
            sb.append("&");
        }
        String substring = sb.substring(0, sb.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        if (hashMap2 == null) {
            hashMap2 = new HashMap<>();
        }
        hashMap2.put("Content-Type", HttpHeaders.Values.APPLICATION_X_WWW_FORM_URLENCODED);
        hashMap2.put("Charset", "UTF-8");
        hashMap2.put("accept", "*/*");
        hashMap2.put("Connection", "keep-alive");
        Charset charset = Charsets.UTF_8;
        byte[] bytes = substring.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        hashMap2.put("Content-Length", String.valueOf(bytes.length));
        byte[] bytes2 = substring.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        return networkRequestToPost(str, bytes2, hashMap2);
    }

    public static /* synthetic */ Response networkRequestToPostForm$default(String str, HashMap hashMap, HashMap hashMap2, int i, Object obj) {
        if ((i & 4) != 0) {
            hashMap2 = null;
        }
        return networkRequestToPostForm(str, hashMap, hashMap2);
    }

    @NotNull
    public static final Response networkRequestUploadImage(@NotNull String str, @Nullable HashMap<String, Object> hashMap, @Nullable HashMap<String, String> hashMap2, @NotNull File file) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(file, "file");
        if (hashMap != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry next : hashMap.entrySet()) {
                Object value = next.getValue();
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append(StringsKt.replace$default(value.toString(), " ", "%20", false, 4, (Object) null));
                sb.append("&");
            }
            String str2 = str + '?' + sb;
            str = str2.substring(0, str2.length() - 1);
            Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
        }
        if (hashMap2 == null) {
            hashMap2 = new HashMap<>();
        }
        hashMap2.put("Content-Type", "multipart/form-data; boundary=" + "---------------networkRequestUploadFile");
        hashMap2.put("Charset", "UTF-8");
        hashMap2.put("Accept", "*/*");
        hashMap2.put("Connection", "keep-alive");
        hashMap2.put("Accept-Encoding", HttpHeaders.Values.GZIP_DEFLATE);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--" + "---------------networkRequestUploadFile");
        sb2.append("\r\n");
        sb2.append("Content-Disposition: form-data;name=\"image\";filename=\"" + file.getName() + '\"');
        sb2.append("\r\n");
        sb2.append("Content-Type: image/*");
        sb2.append("\r\n");
        sb2.append("\r\n");
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        byte[] bytes = sb3.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byteArrayOutputStream.write(bytes);
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = dataInputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                dataInputStream.close();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("--" + "---------------networkRequestUploadFile");
                sb4.append("\r\n");
                sb4.append("Content-Disposition: form-data; name=\"" + file.getName() + '\"');
                sb4.append("\r\n");
                sb4.append("\r\n");
                sb4.append(file.getName());
                sb4.append("\r\n");
                sb4.append("--" + "---------------networkRequestUploadFile" + "--" + "\r\n");
                String sb5 = sb4.toString();
                Intrinsics.checkNotNullExpressionValue(sb5, "toString(...)");
                byte[] bytes2 = sb5.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                byteArrayOutputStream.write(bytes2);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                return networkRequestToPost(str, byteArray, hashMap2);
            }
        }
    }

    public static /* synthetic */ Response networkRequestUploadImage$default(String str, HashMap hashMap, HashMap hashMap2, File file, int i, Object obj) {
        if ((i & 2) != 0) {
            hashMap = null;
        }
        if ((i & 4) != 0) {
            hashMap2 = null;
        }
        return networkRequestUploadImage(str, hashMap, hashMap2, file);
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x017f A[SYNTHETIC, Splitter:B:61:0x017f] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0195 A[SYNTHETIC, Splitter:B:72:0x0195] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.honey.account.utils.network.Response networkingRequest(@org.jetbrains.annotations.NotNull com.honey.account.utils.network.Request r7) {
        /*
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.honey.account.utils.log.LogUtils r0 = com.honey.account.utils.log.LogUtils.INSTANCE
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "networking request : "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            r0.d(r1, r2)
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0149, all -> 0x0145 }
            java.lang.String r2 = r7.getUrl()     // Catch:{ Exception -> 0x0149, all -> 0x0145 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0149, all -> 0x0145 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x0149, all -> 0x0145 }
            java.lang.String r2 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)     // Catch:{ Exception -> 0x0149, all -> 0x0145 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x0149, all -> 0x0145 }
            java.lang.String r2 = r7.getRequestMethod()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            r1.setRequestMethod(r2)     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            int r2 = r7.getConnectTimeout()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            if (r2 == 0) goto L_0x0053
            int r2 = r7.getConnectTimeout()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            r1.setConnectTimeout(r2)     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            goto L_0x0053
        L_0x0047:
            r7 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
            goto L_0x0189
        L_0x004d:
            r7 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
            goto L_0x014c
        L_0x0053:
            int r2 = r7.getReadTimeout()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            if (r2 == 0) goto L_0x0060
            int r2 = r7.getReadTimeout()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            r1.setReadTimeout(r2)     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
        L_0x0060:
            int r2 = r7.getChunkedStreamingMode()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            if (r2 == 0) goto L_0x006d
            int r2 = r7.getChunkedStreamingMode()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            r1.setChunkedStreamingMode(r2)     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
        L_0x006d:
            int r2 = r7.getFixedLengthStreamingMode()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            if (r2 == 0) goto L_0x007a
            int r2 = r7.getFixedLengthStreamingMode()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            r1.setFixedLengthStreamingMode(r2)     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
        L_0x007a:
            boolean r2 = r7.getUseCaches()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            r1.setUseCaches(r2)     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            boolean r2 = r7.getDoInput()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            r1.setDoInput(r2)     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            boolean r2 = r7.getDoOutput()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            r1.setDoOutput(r2)     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            java.util.Map r2 = r7.getRequestProperties()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            if (r2 == 0) goto L_0x00c0
            java.util.Map r2 = r7.getRequestProperties()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
        L_0x00a4:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            if (r3 == 0) goto L_0x00c0
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            r1.setRequestProperty(r4, r3)     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            goto L_0x00a4
        L_0x00c0:
            byte[] r2 = r7.getParameter()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            if (r2 == 0) goto L_0x00e8
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x004d, all -> 0x0047 }
            byte[] r3 = r7.getParameter()     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            r2.write(r3)     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            r2.flush()     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            goto L_0x00e9
        L_0x00dd:
            r7 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0189
        L_0x00e3:
            r7 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x014c
        L_0x00e8:
            r2 = r0
        L_0x00e9:
            int r3 = r1.getResponseCode()     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x00fc
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            java.io.InputStream r5 = r1.getInputStream()     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
        L_0x00fa:
            r0 = r4
            goto L_0x0106
        L_0x00fc:
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            java.io.InputStream r5 = r1.getErrorStream()     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            goto L_0x00fa
        L_0x0106:
            java.lang.String r4 = inputStreamToString(r0)     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            com.honey.account.utils.network.Response$Builder r5 = new com.honey.account.utils.network.Response$Builder     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            r5.<init>()     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            com.honey.account.utils.network.Response$Builder r7 = r5.setRequest((com.honey.account.utils.network.Request) r7)     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            com.honey.account.utils.network.Response$Builder r7 = r7.setCode((int) r3)     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            java.lang.String r3 = r1.getResponseMessage()     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            com.honey.account.utils.network.Response$Builder r7 = r7.setMessage((java.lang.String) r3)     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            com.honey.account.utils.network.Response$Builder r7 = r7.setBody((java.lang.String) r4)     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            java.util.Map r3 = r1.getHeaderFields()     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            java.lang.String r4 = "getHeaderFields(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            com.honey.account.utils.network.Response$Builder r7 = r7.setHeaderFields((java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>>) r3)     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            com.honey.account.utils.network.Response r7 = r7.build()     // Catch:{ Exception -> 0x00e3, all -> 0x00dd }
            r1.disconnect()
            if (r2 == 0) goto L_0x013c
            r2.close()
        L_0x013c:
            r0.close()     // Catch:{ IOException -> 0x0140 }
            goto L_0x0144
        L_0x0140:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0144:
            return r7
        L_0x0145:
            r7 = move-exception
            r1 = r0
            r2 = r1
            goto L_0x0189
        L_0x0149:
            r7 = move-exception
            r1 = r0
            r2 = r1
        L_0x014c:
            r7.printStackTrace()     // Catch:{ all -> 0x0188 }
            com.honey.account.utils.log.LogUtils r3 = com.honey.account.utils.log.LogUtils.INSTANCE     // Catch:{ all -> 0x0188 }
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0188 }
            java.lang.String r5 = r7.getMessage()     // Catch:{ all -> 0x0188 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0188 }
            r3.e(r4, r5)     // Catch:{ all -> 0x0188 }
            com.honey.account.utils.network.Response$Builder r3 = new com.honey.account.utils.network.Response$Builder     // Catch:{ all -> 0x0188 }
            r3.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x0188 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0188 }
            com.honey.account.utils.network.Response$Builder r7 = r3.setMessage((java.lang.String) r7)     // Catch:{ all -> 0x0188 }
            com.honey.account.utils.network.Response r7 = r7.build()     // Catch:{ all -> 0x0188 }
            if (r0 == 0) goto L_0x0178
            r0.disconnect()
        L_0x0178:
            if (r2 == 0) goto L_0x017d
            r2.close()
        L_0x017d:
            if (r1 == 0) goto L_0x0187
            r1.close()     // Catch:{ IOException -> 0x0183 }
            goto L_0x0187
        L_0x0183:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0187:
            return r7
        L_0x0188:
            r7 = move-exception
        L_0x0189:
            if (r0 == 0) goto L_0x018e
            r0.disconnect()
        L_0x018e:
            if (r2 == 0) goto L_0x0193
            r2.close()
        L_0x0193:
            if (r1 == 0) goto L_0x019d
            r1.close()     // Catch:{ IOException -> 0x0199 }
            goto L_0x019d
        L_0x0199:
            r0 = move-exception
            r0.printStackTrace()
        L_0x019d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.honey.account.utils.network.NetworkUtilsKt.networkingRequest(com.honey.account.utils.network.Request):com.honey.account.utils.network.Response");
    }
}
