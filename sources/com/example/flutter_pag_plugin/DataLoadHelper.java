package com.example.flutter_pag_plugin;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.util.LruCache;
import com.example.flutter_pag_plugin.utils.EncodeUtil;
import com.honey.account.w0.a;
import com.jakewharton.disklrucache.DiskLruCache;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\t\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R'\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070(8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010)\u001a\u0004\b*\u0010+R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010/¨\u00061"}, d2 = {"Lcom/example/flutter_pag_plugin/DataLoadHelper;", "", "<init>", "()V", "", "src", "Lkotlin/Function1;", "", "", "addPag", "", "from", "h", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;I)V", "Landroid/content/Context;", "context", "", "size", "g", "(Landroid/content/Context;J)V", "uniqueName", "Ljava/io/File;", "d", "(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;", "Lkotlin/Function2;", "j", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "urlString", "Ljava/io/OutputStream;", "outputStream", "", "c", "(Ljava/lang/String;Ljava/io/OutputStream;)Z", "key", "f", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/jakewharton/disklrucache/DiskLruCache;", "b", "Lcom/jakewharton/disklrucache/DiskLruCache;", "diskCache", "Landroid/util/LruCache;", "Lkotlin/Lazy;", "e", "()Landroid/util/LruCache;", "memoryCache", "", "Lcom/example/flutter_pag_plugin/ILoadListener;", "Ljava/util/List;", "loadListeners", "pag_release"}, k = 1, mv = {1, 7, 1})
public final class DataLoadHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final DataLoadHelper f2817a = new DataLoadHelper();
    public static DiskLruCache b;
    public static final Lazy c = LazyKt.lazy(DataLoadHelper$memoryCache$2.INSTANCE);
    public static final List d = new ArrayList();

    public static final void i(String str, Function1 function1, long j, int i) {
        Intrinsics.checkNotNullParameter(str, "$src");
        Intrinsics.checkNotNullParameter(function1, "$addPag");
        f2817a.j(str, new DataLoadHelper$loadPag$3$1(function1, str, j, i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006d A[SYNTHETIC, Splitter:B:38:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0075 A[Catch:{ IOException -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0085 A[SYNTHETIC, Splitter:B:48:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x008d A[Catch:{ IOException -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(java.lang.String r4, java.io.OutputStream r5) {
        /*
            r3 = this;
            r3 = 0
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x005e, all -> 0x0058 }
            r0.<init>(r4)     // Catch:{ IOException -> 0x005e, all -> 0x0058 }
            java.net.URLConnection r4 = r0.openConnection()     // Catch:{ IOException -> 0x005e, all -> 0x0058 }
            java.lang.String r0 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r0)     // Catch:{ IOException -> 0x005e, all -> 0x0058 }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x005e, all -> 0x0058 }
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0054, all -> 0x0050 }
            java.io.InputStream r1 = r4.getInputStream()     // Catch:{ IOException -> 0x0054, all -> 0x0050 }
            r2 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r1, r2)     // Catch:{ IOException -> 0x0054, all -> 0x0050 }
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x004c, all -> 0x0048 }
            r1.<init>(r5, r2)     // Catch:{ IOException -> 0x004c, all -> 0x0048 }
            kotlin.jvm.internal.Ref$IntRef r3 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ IOException -> 0x0036 }
            r3.<init>()     // Catch:{ IOException -> 0x0036 }
        L_0x0026:
            int r5 = r0.read()     // Catch:{ IOException -> 0x0036 }
            r3.element = r5     // Catch:{ IOException -> 0x0036 }
            r2 = -1
            if (r5 == r2) goto L_0x0038
            r1.write(r5)     // Catch:{ IOException -> 0x0036 }
            goto L_0x0026
        L_0x0033:
            r3 = move-exception
            goto L_0x007e
        L_0x0036:
            r3 = move-exception
            goto L_0x0063
        L_0x0038:
            r4.disconnect()
            r1.close()     // Catch:{ IOException -> 0x0042 }
            r0.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0046:
            r3 = 1
            return r3
        L_0x0048:
            r5 = move-exception
            r1 = r3
        L_0x004a:
            r3 = r5
            goto L_0x007e
        L_0x004c:
            r5 = move-exception
            r1 = r3
        L_0x004e:
            r3 = r5
            goto L_0x0063
        L_0x0050:
            r5 = move-exception
            r0 = r3
            r1 = r0
            goto L_0x004a
        L_0x0054:
            r5 = move-exception
            r0 = r3
            r1 = r0
            goto L_0x004e
        L_0x0058:
            r4 = move-exception
            r0 = r3
            r1 = r0
            r3 = r4
            r4 = r1
            goto L_0x007e
        L_0x005e:
            r4 = move-exception
            r0 = r3
            r1 = r0
            r3 = r4
            r4 = r1
        L_0x0063:
            r3.printStackTrace()     // Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x006b
            r4.disconnect()
        L_0x006b:
            if (r1 == 0) goto L_0x0073
            r1.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0073
        L_0x0071:
            r3 = move-exception
            goto L_0x0079
        L_0x0073:
            if (r0 == 0) goto L_0x007c
            r0.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x007c
        L_0x0079:
            r3.printStackTrace()
        L_0x007c:
            r3 = 0
            return r3
        L_0x007e:
            if (r4 == 0) goto L_0x0083
            r4.disconnect()
        L_0x0083:
            if (r1 == 0) goto L_0x008b
            r1.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x008b
        L_0x0089:
            r4 = move-exception
            goto L_0x0091
        L_0x008b:
            if (r0 == 0) goto L_0x0094
            r0.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x0094
        L_0x0091:
            r4.printStackTrace()
        L_0x0094:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flutter_pag_plugin.DataLoadHelper.c(java.lang.String, java.io.OutputStream):boolean");
    }

    public final File d(Context context, String str) {
        String str2;
        if (Intrinsics.areEqual((Object) "mounted", (Object) Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            File externalCacheDir = context.getExternalCacheDir();
            str2 = externalCacheDir != null ? externalCacheDir.getPath() : null;
        } else {
            str2 = context.getCacheDir().getPath();
        }
        if (str2 == null) {
            str2 = "";
        }
        String str3 = File.separator;
        return new File(str2 + str3 + str);
    }

    public final LruCache e() {
        return (LruCache) c.getValue();
    }

    public final String f(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(\"MD5\")");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            instance.update(bytes);
            return EncodeUtil.a(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    public final void g(Context context, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (b != null) {
            Log.w("DataLoadHelper", "diskCache do not need init again!");
            return;
        }
        File d2 = d(context, "pag");
        if (!d2.exists()) {
            d2.mkdirs();
        }
        try {
            DiskLruCache diskLruCache = b;
            if (diskLruCache == null) {
                diskLruCache = DiskLruCache.S(d2, context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode, 1, j);
            }
            b = diskLruCache;
        } catch (IOException e) {
            Log.e("DataLoadHelper", "initDiskCache error: " + e);
        }
    }

    public final void h(String str, Function1 function1, int i) {
        String str2 = str;
        Function1 function12 = function1;
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(function1, "addPag");
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr = (byte[]) e().get(f(str));
        for (ILoadListener b2 : d) {
            b2.b(str, i);
        }
        int i2 = i;
        if (bArr != null) {
            function1.invoke(bArr);
            for (ILoadListener a2 : d) {
                a2.a(str, bArr, System.currentTimeMillis() - currentTimeMillis, "", i);
            }
            return;
        }
        new Thread(new a(str, function1, currentTimeMillis, i)).start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void j(java.lang.String r9, kotlin.jvm.functions.Function2 r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = ""
            java.lang.String r1 = r8.f(r9)     // Catch:{ all -> 0x0012 }
            r2 = 0
            r3 = 0
            com.jakewharton.disklrucache.DiskLruCache r4 = b     // Catch:{ IOException -> 0x0015 }
            if (r4 == 0) goto L_0x0018
            com.jakewharton.disklrucache.DiskLruCache$Snapshot r4 = r4.J(r1)     // Catch:{ IOException -> 0x0015 }
            goto L_0x0019
        L_0x0012:
            r9 = move-exception
            goto L_0x012e
        L_0x0015:
            r9 = move-exception
            r4 = r3
            goto L_0x0059
        L_0x0018:
            r4 = r3
        L_0x0019:
            if (r4 != 0) goto L_0x0080
            java.lang.String r5 = "DataLoadHelper"
            java.lang.String r6 = "loadPag load from network"
            android.util.Log.d(r5, r6)     // Catch:{ IOException -> 0x002b }
            com.jakewharton.disklrucache.DiskLruCache r5 = b     // Catch:{ IOException -> 0x002b }
            if (r5 == 0) goto L_0x002d
            com.jakewharton.disklrucache.DiskLruCache$Editor r5 = r5.w(r1)     // Catch:{ IOException -> 0x002b }
            goto L_0x002e
        L_0x002b:
            r9 = move-exception
            goto L_0x0059
        L_0x002d:
            r5 = r3
        L_0x002e:
            if (r5 == 0) goto L_0x0046
            java.io.OutputStream r6 = r5.f(r2)     // Catch:{ IOException -> 0x002b }
            java.lang.String r7 = "outputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ IOException -> 0x002b }
            boolean r9 = r8.c(r9, r6)     // Catch:{ IOException -> 0x002b }
            if (r9 == 0) goto L_0x0043
            r5.e()     // Catch:{ IOException -> 0x002b }
            goto L_0x0046
        L_0x0043:
            r5.a()     // Catch:{ IOException -> 0x002b }
        L_0x0046:
            com.jakewharton.disklrucache.DiskLruCache r9 = b     // Catch:{ IOException -> 0x002b }
            if (r9 == 0) goto L_0x004d
            r9.flush()     // Catch:{ IOException -> 0x002b }
        L_0x004d:
            com.jakewharton.disklrucache.DiskLruCache r9 = b     // Catch:{ IOException -> 0x002b }
            if (r9 == 0) goto L_0x0057
            com.jakewharton.disklrucache.DiskLruCache$Snapshot r9 = r9.J(r1)     // Catch:{ IOException -> 0x002b }
            r4 = r9
            goto L_0x0080
        L_0x0057:
            r4 = r3
            goto L_0x0080
        L_0x0059:
            java.lang.String r0 = "DataLoadHelper"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0012 }
            r5.<init>()     // Catch:{ all -> 0x0012 }
            java.lang.String r6 = "loadPag load from network erro: "
            r5.append(r6)     // Catch:{ all -> 0x0012 }
            r5.append(r9)     // Catch:{ all -> 0x0012 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0012 }
            android.util.Log.e(r0, r5)     // Catch:{ all -> 0x0012 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0012 }
            r0.<init>()     // Catch:{ all -> 0x0012 }
            java.lang.String r5 = "loadPag load from network error: "
            r0.append(r5)     // Catch:{ all -> 0x0012 }
            r0.append(r9)     // Catch:{ all -> 0x0012 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0012 }
        L_0x0080:
            if (r4 == 0) goto L_0x00ef
            java.lang.String r9 = "DataLoadHelper"
            java.lang.String r5 = "loadPag load from snapShot"
            android.util.Log.d(r9, r5)     // Catch:{ all -> 0x0012 }
            java.io.InputStream r9 = r4.a(r2)     // Catch:{ IOException -> 0x00c2 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00c2 }
            r4.<init>()     // Catch:{ IOException -> 0x00c2 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x00a1 }
        L_0x0096:
            int r6 = r9.read(r5)     // Catch:{ all -> 0x00a1 }
            r7 = -1
            if (r6 == r7) goto L_0x00a4
            r4.write(r5, r2, r6)     // Catch:{ all -> 0x00a1 }
            goto L_0x0096
        L_0x00a1:
            r0 = move-exception
            r5 = r3
            goto L_0x00b6
        L_0x00a4:
            byte[] r5 = r4.toByteArray()     // Catch:{ all -> 0x00a1 }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00b5 }
            kotlin.io.CloseableKt.closeFinally(r4, r3)     // Catch:{ all -> 0x00b3 }
            kotlin.io.CloseableKt.closeFinally(r9, r3)     // Catch:{ IOException -> 0x00b1 }
            goto L_0x00f0
        L_0x00b1:
            r9 = move-exception
            goto L_0x00c4
        L_0x00b3:
            r0 = move-exception
            goto L_0x00bc
        L_0x00b5:
            r0 = move-exception
        L_0x00b6:
            throw r0     // Catch:{ all -> 0x00b7 }
        L_0x00b7:
            r6 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r0)     // Catch:{ all -> 0x00b3 }
            throw r6     // Catch:{ all -> 0x00b3 }
        L_0x00bc:
            throw r0     // Catch:{ all -> 0x00bd }
        L_0x00bd:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r9, r0)     // Catch:{ IOException -> 0x00b1 }
            throw r4     // Catch:{ IOException -> 0x00b1 }
        L_0x00c2:
            r9 = move-exception
            r5 = r3
        L_0x00c4:
            r9.printStackTrace()     // Catch:{ all -> 0x0012 }
            java.lang.String r0 = "DataLoadHelper"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0012 }
            r4.<init>()     // Catch:{ all -> 0x0012 }
            java.lang.String r6 = "loadPag load from snapShot erro: "
            r4.append(r6)     // Catch:{ all -> 0x0012 }
            r4.append(r9)     // Catch:{ all -> 0x0012 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0012 }
            android.util.Log.e(r0, r4)     // Catch:{ all -> 0x0012 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0012 }
            r0.<init>()     // Catch:{ all -> 0x0012 }
            java.lang.String r4 = "loadPag load from network error: "
            r0.append(r4)     // Catch:{ all -> 0x0012 }
            r0.append(r9)     // Catch:{ all -> 0x0012 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0012 }
            goto L_0x00f0
        L_0x00ef:
            r5 = r3
        L_0x00f0:
            java.lang.String r9 = "DataLoadHelper"
            if (r5 == 0) goto L_0x00f9
            int r3 = r5.length     // Catch:{ all -> 0x0012 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0012 }
        L_0x00f9:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0012 }
            r4.<init>()     // Catch:{ all -> 0x0012 }
            java.lang.String r6 = "loadPag bytes size: "
            r4.append(r6)     // Catch:{ all -> 0x0012 }
            r4.append(r3)     // Catch:{ all -> 0x0012 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0012 }
            android.util.Log.d(r9, r3)     // Catch:{ all -> 0x0012 }
            if (r5 == 0) goto L_0x0129
            int r9 = r5.length     // Catch:{ all -> 0x0012 }
            r3 = 1
            if (r9 != 0) goto L_0x0114
            r2 = r3
        L_0x0114:
            r9 = r2 ^ 1
            if (r9 == 0) goto L_0x0129
            android.util.LruCache r9 = r8.e()     // Catch:{ all -> 0x0012 }
            java.lang.Object r9 = r9.get(r1)     // Catch:{ all -> 0x0012 }
            if (r9 != 0) goto L_0x0129
            android.util.LruCache r9 = r8.e()     // Catch:{ all -> 0x0012 }
            r9.put(r1, r5)     // Catch:{ all -> 0x0012 }
        L_0x0129:
            r10.invoke(r5, r0)     // Catch:{ all -> 0x0012 }
            monitor-exit(r8)
            return
        L_0x012e:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.flutter_pag_plugin.DataLoadHelper.j(java.lang.String, kotlin.jvm.functions.Function2):void");
    }
}
