package com.upuphone.xr.sapp.utils;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.upuphone.star.core.log.ULog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0010j\b\u0012\u0004\u0012\u00020\n`\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\bJ-\u0010\u001d\u001a\u00020\u00062\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0010j\b\u0012\u0004\u0012\u00020\n`\u00112\u0006\u0010\u001c\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b#\u0010$J!\u0010'\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020%2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b'\u0010(J\u0019\u0010)\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b)\u0010\"¨\u0006*"}, d2 = {"Lcom/upuphone/xr/sapp/utils/FileUtils;", "", "<init>", "()V", "", "dir", "", "c", "(Ljava/lang/String;)V", "", "Ljava/io/File;", "excludeFiles", "d", "(Ljava/lang/String;Ljava/util/List;)V", "dirPath", "fileType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;", "source", "dest", "", "a", "(Ljava/io/File;Ljava/io/File;)J", "filePath", "b", "srcFiles", "zipFile", "j", "(Ljava/util/ArrayList;Ljava/io/File;)V", "Landroid/net/Uri;", "uri", "h", "(Landroid/net/Uri;)Ljava/lang/String;", "i", "(Landroid/net/Uri;)J", "Landroid/content/Context;", "context", "f", "(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;", "g", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nFileUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileUtils.kt\ncom/upuphone/xr/sapp/utils/FileUtils\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,276:1\n13309#2,2:277\n1#3:279\n*S KotlinDebug\n*F\n+ 1 FileUtils.kt\ncom/upuphone/xr/sapp/utils/FileUtils\n*L\n105#1:277,2\n*E\n"})
public final class FileUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final FileUtils f7881a = new FileUtils();

    public final long a(File file, File file2) {
        FileChannel channel = new FileInputStream(file).getChannel();
        FileChannel channel2 = new FileOutputStream(file2).getChannel();
        Intrinsics.checkNotNull(channel2);
        Intrinsics.checkNotNull(channel);
        long transferFrom = channel2.transferFrom(channel, 0, channel.size());
        channel.close();
        channel2.close();
        return transferFrom;
    }

    public final void b(String str) {
        if (str != null && str.length() > 0) {
            try {
                new File(str).delete();
            } catch (Exception e) {
                ULog.Delegate delegate = ULog.f6446a;
                String message = e.getMessage();
                delegate.c("deleteFile", "e is:" + message);
            }
        }
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "dir");
        try {
            Files.walkFileTree(Paths.get(str, new String[0]), new FileUtils$deleteFileInDir$1());
        } catch (Throwable th) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("FileUtils", "deleteFileInDir, error: " + th);
        }
    }

    public final void d(String str, List list) {
        Intrinsics.checkNotNullParameter(str, "dir");
        Intrinsics.checkNotNullParameter(list, "excludeFiles");
        try {
            Files.walkFileTree(Paths.get(str, new String[0]), new FileUtils$deleteFileInDir$2(list));
        } catch (Throwable th) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("FileUtils", "deleteFileInDir, error: " + th);
        }
    }

    public final ArrayList e(String str, String str2) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            File file = new File(str);
            if (!file.exists() || (listFiles = file.listFiles()) == null) {
                return arrayList;
            }
            Intrinsics.checkNotNull(listFiles);
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    String name = file2.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    Intrinsics.checkNotNull(str2);
                    if (!StringsKt.endsWith$default(name, str2, false, 2, (Object) null)) {
                        arrayList.add(file2);
                    }
                }
                if (file2.isDirectory()) {
                    arrayList.addAll(f7881a.e(file2.getAbsolutePath(), str2));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        if (r4 == 0) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String f(android.content.Context r11, android.net.Uri r12) {
        /*
            r10 = this;
            java.lang.String r10 = "_display_name"
            r0 = 0
            android.content.ContentResolver r1 = r11.getContentResolver()     // Catch:{ Exception -> 0x0085 }
            r5 = 0
            r6 = 0
            r3 = 0
            r4 = 0
            r2 = r12
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0085 }
            if (r1 == 0) goto L_0x0081
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ Exception -> 0x0085 }
            r2 = r1
            android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x0028 }
            boolean r3 = r2.moveToFirst()     // Catch:{ all -> 0x0028 }
            if (r3 == 0) goto L_0x0074
            int r3 = r2.getColumnIndex(r10)     // Catch:{ all -> 0x0028 }
            if (r3 < 0) goto L_0x002a
            java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x0028 }
            goto L_0x002b
        L_0x0028:
            r10 = move-exception
            goto L_0x007b
        L_0x002a:
            r3 = r0
        L_0x002b:
            if (r3 == 0) goto L_0x0033
            int r4 = r3.length()     // Catch:{ all -> 0x0028 }
            if (r4 != 0) goto L_0x0075
        L_0x0033:
            boolean r11 = android.provider.DocumentsContract.isDocumentUri(r11, r12)     // Catch:{ all -> 0x0028 }
            if (r11 == 0) goto L_0x0055
            java.lang.String r4 = android.provider.DocumentsContract.getDocumentId(r12)     // Catch:{ all -> 0x0028 }
            java.lang.String r10 = "getDocumentId(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r10)     // Catch:{ all -> 0x0028 }
            java.lang.String r10 = ":"
            java.lang.String[] r5 = new java.lang.String[]{r10}     // Catch:{ all -> 0x0028 }
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            java.util.List r10 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r4, (java.lang.String[]) r5, (boolean) r6, (int) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x0028 }
            java.lang.Object r3 = kotlin.collections.CollectionsKt.lastOrNull(r10)     // Catch:{ all -> 0x0028 }
            goto L_0x0075
        L_0x0055:
            java.lang.String r11 = r12.toString()     // Catch:{ all -> 0x0028 }
            java.lang.String r12 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)     // Catch:{ all -> 0x0028 }
            java.lang.String r12 = "/media/"
            r4 = 0
            r5 = 2
            boolean r11 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r11, (java.lang.CharSequence) r12, (boolean) r4, (int) r5, (java.lang.Object) r0)     // Catch:{ all -> 0x0028 }
            if (r11 == 0) goto L_0x0075
            int r10 = r2.getColumnIndex(r10)     // Catch:{ all -> 0x0028 }
            if (r10 < 0) goto L_0x0075
            java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x0028 }
            goto L_0x0075
        L_0x0074:
            r3 = r0
        L_0x0075:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0028 }
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ Exception -> 0x0085 }
            goto L_0x0082
        L_0x007b:
            throw r10     // Catch:{ all -> 0x007c }
        L_0x007c:
            r11 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r10)     // Catch:{ Exception -> 0x0085 }
            throw r11     // Catch:{ Exception -> 0x0085 }
        L_0x0081:
            r3 = r0
        L_0x0082:
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0085 }
            r0 = r3
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.FileUtils.f(android.content.Context, android.net.Uri):java.lang.String");
    }

    public final String g(Uri uri) {
        String path = uri.getPath();
        if (path != null) {
            return StringsKt.substringAfterLast$default(path, '/', (String) null, 2, (Object) null);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String h(android.net.Uri r4) {
        /*
            r3 = this;
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = r4.getScheme()
            if (r0 == 0) goto L_0x003a
            int r1 = r0.hashCode()
            r2 = 3143036(0x2ff57c, float:4.404332E-39)
            if (r1 == r2) goto L_0x002c
            r2 = 951530617(0x38b73479, float:8.735894E-5)
            if (r1 == r2) goto L_0x001b
            goto L_0x003a
        L_0x001b:
            java.lang.String r1 = "content"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003a
            android.content.Context r0 = com.upuphone.xr.sapp.utils.GlobalExtKt.f()
            java.lang.String r0 = r3.f(r0, r4)
            goto L_0x003b
        L_0x002c:
            java.lang.String r1 = "file"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0035
            goto L_0x003a
        L_0x0035:
            java.lang.String r0 = r4.getLastPathSegment()
            goto L_0x003b
        L_0x003a:
            r0 = 0
        L_0x003b:
            if (r0 != 0) goto L_0x0041
            java.lang.String r0 = r3.g(r4)
        L_0x0041:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.FileUtils.h(android.net.Uri):java.lang.String");
    }

    public final long i(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        long j = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            ParcelFileDescriptor openFileDescriptor = GlobalExtKt.f().getContentResolver().openFileDescriptor(uri, "r");
            if (openFileDescriptor != null) {
                j = openFileDescriptor.getStatSize();
            }
            if (openFileDescriptor != null) {
                openFileDescriptor.close();
            }
            return j;
        } catch (FileNotFoundException e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("FileUtils", "文件不存在: " + message);
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
            return 0;
        } catch (Throwable th) {
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j(java.util.ArrayList r7, java.io.File r8) {
        /*
            r6 = this;
            java.lang.String r6 = "srcFiles"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r6)
            java.lang.String r6 = "zipFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r6)
            boolean r6 = r8.exists()
            if (r6 != 0) goto L_0x0019
            r8.createNewFile()     // Catch:{ IOException -> 0x0015 }
            goto L_0x0019
        L_0x0015:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0019:
            r6 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0077, all -> 0x0073 }
            r0.<init>(r8)     // Catch:{ IOException -> 0x0077, all -> 0x0073 }
            java.util.zip.ZipOutputStream r8 = new java.util.zip.ZipOutputStream     // Catch:{ IOException -> 0x006f, all -> 0x006b }
            r8.<init>(r0)     // Catch:{ IOException -> 0x006f, all -> 0x006b }
            int r6 = r7.size()     // Catch:{ IOException -> 0x0059 }
            r1 = 0
            r2 = r1
        L_0x002a:
            if (r2 >= r6) goto L_0x0061
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0059 }
            java.lang.Object r4 = r7.get(r2)     // Catch:{ IOException -> 0x0059 }
            java.io.File r4 = (java.io.File) r4     // Catch:{ IOException -> 0x0059 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0059 }
            java.util.zip.ZipEntry r4 = new java.util.zip.ZipEntry     // Catch:{ IOException -> 0x0059 }
            java.lang.Object r5 = r7.get(r2)     // Catch:{ IOException -> 0x0059 }
            java.io.File r5 = (java.io.File) r5     // Catch:{ IOException -> 0x0059 }
            java.lang.String r5 = r5.getName()     // Catch:{ IOException -> 0x0059 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0059 }
            r8.putNextEntry(r4)     // Catch:{ IOException -> 0x0059 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0059 }
        L_0x004d:
            int r5 = r3.read(r4)     // Catch:{ IOException -> 0x0059 }
            if (r5 <= 0) goto L_0x005b
            r8.write(r4, r1, r5)     // Catch:{ IOException -> 0x0059 }
            goto L_0x004d
        L_0x0057:
            r6 = move-exception
            goto L_0x008a
        L_0x0059:
            r6 = move-exception
            goto L_0x007b
        L_0x005b:
            r3.close()     // Catch:{ IOException -> 0x0059 }
            int r2 = r2 + 1
            goto L_0x002a
        L_0x0061:
            r8.closeEntry()
            r8.close()
        L_0x0067:
            r0.close()
            goto L_0x0089
        L_0x006b:
            r7 = move-exception
            r8 = r6
        L_0x006d:
            r6 = r7
            goto L_0x008a
        L_0x006f:
            r7 = move-exception
            r8 = r6
        L_0x0071:
            r6 = r7
            goto L_0x007b
        L_0x0073:
            r7 = move-exception
            r8 = r6
            r0 = r8
            goto L_0x006d
        L_0x0077:
            r7 = move-exception
            r8 = r6
            r0 = r8
            goto L_0x0071
        L_0x007b:
            r6.printStackTrace()     // Catch:{ all -> 0x0057 }
            if (r8 == 0) goto L_0x0086
            r8.closeEntry()
            r8.close()
        L_0x0086:
            if (r0 == 0) goto L_0x0089
            goto L_0x0067
        L_0x0089:
            return
        L_0x008a:
            if (r8 == 0) goto L_0x0092
            r8.closeEntry()
            r8.close()
        L_0x0092:
            if (r0 == 0) goto L_0x0097
            r0.close()
        L_0x0097:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.FileUtils.j(java.util.ArrayList, java.io.File):void");
    }
}
