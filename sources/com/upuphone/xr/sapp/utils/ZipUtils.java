package com.upuphone.xr.sapp.utils;

import com.upuphone.star.core.log.ULog;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/sapp/utils/ZipUtils;", "", "<init>", "()V", "Ljava/io/File;", "file", "", "d", "(Ljava/io/File;)Ljava/util/List;", "", "sourceFilePath", "targetFilePath", "", "e", "(Ljava/lang/String;Ljava/lang/String;)Z", "Ljava/util/zip/ZipFile;", "zipFile", "Ljava/util/zip/ZipEntry;", "entry", "outputFile", "", "c", "(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;)V", "Ljava/util/zip/ZipOutputStream;", "zos", "", "basePathLength", "a", "(Ljava/util/zip/ZipOutputStream;Ljava/io/File;I)V", "b", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nZipUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZipUtils.kt\ncom/upuphone/xr/sapp/utils/ZipUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,129:1\n1#2:130\n*E\n"})
public final class ZipUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final ZipUtils f7938a = new ZipUtils();

    public final void a(ZipOutputStream zipOutputStream, File file, int i) {
        if (file.isFile()) {
            b(zipOutputStream, file, i);
            return;
        }
        File[] listFiles = file.listFiles();
        Intrinsics.checkNotNull(listFiles);
        if (listFiles.length == 0) {
            ULog.f6446a.a("ZipUtils", "开始处理空文件夹->" + file.getAbsolutePath());
            String path = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            String substring = path.substring(i + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            zipOutputStream.putNextEntry(new ZipEntry(substring + File.separator));
            zipOutputStream.closeEntry();
            return;
        }
        for (File file2 : listFiles) {
            if (file.isDirectory()) {
                Intrinsics.checkNotNull(file2);
                a(zipOutputStream, file2, i);
            } else {
                Intrinsics.checkNotNull(file2);
                b(zipOutputStream, file2, file.getPath().length());
            }
        }
    }

    public final void b(ZipOutputStream zipOutputStream, File file, int i) {
        ULog.Delegate delegate = ULog.f6446a;
        String absolutePath = file.getAbsolutePath();
        delegate.a("ZipUtils", "开始处理->" + absolutePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[4096];
            String path = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            String substring = path.substring(i + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            zipOutputStream.putNextEntry(new ZipEntry(substring));
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    zipOutputStream.closeEntry();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                    return;
                }
            }
        } catch (Throwable th) {
            CloseableKt.closeFinally(fileInputStream, th);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.util.zip.ZipFile r2, java.util.zip.ZipEntry r3, java.io.File r4) {
        /*
            r1 = this;
            boolean r1 = r3.isDirectory()
            if (r1 == 0) goto L_0x000a
            r4.mkdir()
            goto L_0x0022
        L_0x000a:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream
            r1.<init>(r4)
            java.io.InputStream r2 = r2.getInputStream(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ all -> 0x0023 }
            r3 = 0
            r4 = 2
            r0 = 0
            kotlin.io.ByteStreamsKt.copyTo$default(r2, r1, r3, r4, r0)     // Catch:{ all -> 0x0023 }
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            r1.close()
        L_0x0022:
            return
        L_0x0023:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.ZipUtils.c(java.util.zip.ZipFile, java.util.zip.ZipEntry, java.io.File):void");
    }

    public final List d(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        ArrayList arrayList = new ArrayList();
        File parentFile = file.getParentFile();
        ZipFile zipFile = new ZipFile(file);
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                File file2 = new File(parentFile, zipEntry.getName());
                ZipUtils zipUtils = f7938a;
                Intrinsics.checkNotNull(zipEntry);
                zipUtils.c(zipFile, zipEntry, file2);
                arrayList.add(file2);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(zipFile, (Throwable) null);
            return arrayList;
        } catch (Throwable th) {
            CloseableKt.closeFinally(zipFile, th);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b6, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ba, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r9, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c0, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r7 = "sourceFilePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r7)
            java.lang.String r7 = "targetFilePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r7)
            java.io.File r7 = new java.io.File
            r7.<init>(r8)
            boolean r0 = r7.exists()
            r1 = 0
            java.lang.String r2 = "zip source file->"
            java.lang.String r3 = "ZipUtils"
            if (r0 != 0) goto L_0x0036
            com.upuphone.star.core.log.ULog$Delegate r7 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            r9.append(r8)
            java.lang.String r8 = " not exists"
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r7.a(r3, r8)
            return r1
        L_0x0036:
            java.io.File r0 = new java.io.File
            r0.<init>(r9)
            boolean r9 = r0.exists()
            if (r9 != 0) goto L_0x0075
            java.io.File r9 = r0.getParentFile()     // Catch:{ IOException -> 0x0053 }
            boolean r9 = r9.exists()     // Catch:{ IOException -> 0x0053 }
            if (r9 != 0) goto L_0x0055
            java.io.File r9 = r0.getParentFile()     // Catch:{ IOException -> 0x0053 }
            r9.mkdir()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0055
        L_0x0053:
            r9 = move-exception
            goto L_0x0059
        L_0x0055:
            r0.createNewFile()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0075
        L_0x0059:
            com.upuphone.star.core.log.ULog$Delegate r4 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "创建zip file->"
            r5.append(r6)
            r5.append(r8)
            java.lang.String r6 = " error"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.d(r3, r5, r9)
        L_0x0075:
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00b0 }
            r9.<init>(r0)     // Catch:{ Exception -> 0x00b0 }
            java.util.zip.ZipOutputStream r0 = new java.util.zip.ZipOutputStream     // Catch:{ all -> 0x00b2 }
            r0.<init>(r9)     // Catch:{ all -> 0x00b2 }
            com.upuphone.xr.sapp.utils.ZipUtils r4 = f7938a     // Catch:{ all -> 0x00b4 }
            java.lang.String r5 = r7.getParent()     // Catch:{ all -> 0x00b4 }
            int r5 = r5.length()     // Catch:{ all -> 0x00b4 }
            r4.a(r0, r7, r5)     // Catch:{ all -> 0x00b4 }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00b4 }
            r7 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r7)     // Catch:{ all -> 0x00b2 }
            kotlin.io.CloseableKt.closeFinally(r9, r7)     // Catch:{ Exception -> 0x00b0 }
            com.upuphone.star.core.log.ULog$Delegate r7 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x00b0 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b0 }
            r9.<init>()     // Catch:{ Exception -> 0x00b0 }
            r9.append(r2)     // Catch:{ Exception -> 0x00b0 }
            r9.append(r8)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r0 = " over"
            r9.append(r0)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00b0 }
            r7.a(r3, r9)     // Catch:{ Exception -> 0x00b0 }
            r7 = 1
            return r7
        L_0x00b0:
            r7 = move-exception
            goto L_0x00c1
        L_0x00b2:
            r7 = move-exception
            goto L_0x00bb
        L_0x00b4:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x00b6 }
        L_0x00b6:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r7)     // Catch:{ all -> 0x00b2 }
            throw r4     // Catch:{ all -> 0x00b2 }
        L_0x00bb:
            throw r7     // Catch:{ all -> 0x00bc }
        L_0x00bc:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r9, r7)     // Catch:{ Exception -> 0x00b0 }
            throw r0     // Catch:{ Exception -> 0x00b0 }
        L_0x00c1:
            com.upuphone.star.core.log.ULog$Delegate r9 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            r0.append(r8)
            java.lang.String r8 = " failed"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r9.d(r3, r8, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.ZipUtils.e(java.lang.String, java.lang.String):boolean");
    }
}
