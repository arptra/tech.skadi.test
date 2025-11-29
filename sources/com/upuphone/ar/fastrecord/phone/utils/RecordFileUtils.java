package com.upuphone.ar.fastrecord.phone.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\"\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u001e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004J\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000eJ\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u000eH\u0002J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u001a\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u0004J\u001e\u0010&\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010'\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0004J\u0018\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004J&\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00042\b\u0010-\u001a\u0004\u0018\u00010\u00042\b\u0010.\u001a\u0004\u0018\u00010\u0004J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0016\u00100\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u00101\u001a\u000202J.\u00103\u001a\u00020\n2\u0006\u00104\u001a\u0002052\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`92\u0006\u0010\u0018\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/RecordFileUtils;", "", "()V", "FAST_RECORD_DIR_PATH", "", "LAST_PEX", "LAST_PEX_O_PLUS", "LAST_PEX_WAV", "TAG", "copyFile", "", "sourcePath", "destinationPath", "createExtractShareFile", "Ljava/io/File;", "context", "Landroid/content/Context;", "content", "fileName", "createPlusVoiceFilePath", "recordId", "dirPath", "createVoiceDirForRecord", "", "type", "createVoicePcmFilePath", "createVoiceZipFilePath", "createWavTempVoiceFilePath", "delete", "", "file", "filePath", "deleteDir", "dirFile", "deleteFile", "fileAppendFile", "addFilePath", "appendFile", "getDirOrCreateForRecord", "getFileSize", "getTempShareFile", "getTxtFileName", "title", "mergeFiles", "file1Path", "file2Path", "outputPath", "readAsset", "saveVoiceData", "byteArray", "", "shareUriList", "activity", "Landroid/app/Activity;", "shareTempFileUirList", "Ljava/util/ArrayList;", "Landroid/net/Uri;", "Lkotlin/collections/ArrayList;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecordFileUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordFileUtils.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordFileUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,345:1\n1#2:346\n*E\n"})
public final class RecordFileUtils {
    @NotNull
    private static final String FAST_RECORD_DIR_PATH = "fast_record";
    @NotNull
    public static final RecordFileUtils INSTANCE = new RecordFileUtils();
    @NotNull
    public static final String LAST_PEX = ".pcm";
    @NotNull
    private static final String LAST_PEX_O_PLUS = ".oplus";
    @NotNull
    private static final String LAST_PEX_WAV = ".wav";
    @NotNull
    public static final String TAG = "RecordFileUtils";

    private RecordFileUtils() {
    }

    private final boolean deleteDir(File file) {
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return file.delete();
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    return false;
                }
            } else if (file2.isDirectory()) {
                Intrinsics.checkNotNull(file2);
                if (!deleteDir(file2)) {
                    return false;
                }
            } else {
                continue;
            }
        }
        return file.delete();
    }

    private final boolean deleteFile(File file) {
        if (!file.exists()) {
            return true;
        }
        return file.isFile() && file.delete();
    }

    public final void copyFile(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "sourcePath");
        Intrinsics.checkNotNullParameter(str2, "destinationPath");
        FileInputStream fileInputStream = new FileInputStream(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                fileInputStream.close();
                fileOutputStream.close();
                throw th;
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    @Nullable
    public final File createExtractShareFile(@NotNull Context context, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "content");
        String absolutePath = context.getCacheDir().getAbsolutePath();
        String str3 = File.separator;
        String str4 = absolutePath + str3 + FAST_RECORD_DIR_PATH + str3;
        File file = new File(str4);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str4, str2);
        if (file2.exists()) {
            file2.delete();
        }
        file2.createNewFile();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            fileOutputStream.write(bytes);
            fileOutputStream.close();
            return file2;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @NotNull
    public final String createPlusVoiceFilePath(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "recordId");
        Intrinsics.checkNotNullParameter(str2, "dirPath");
        String str3 = File.separator;
        File file = new File(str2 + str3 + str + LAST_PEX_O_PLUS);
        delete(file);
        boolean createNewFile = file.createNewFile();
        LogExt.logW("createVoiceFilePath statue = " + createNewFile, TAG);
        if (!createNewFile) {
            return "";
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNull(absolutePath);
        return absolutePath;
    }

    @NotNull
    public final String createVoiceDirForRecord(@NotNull Context context, long j, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "type");
        String absolutePath = context.getFilesDir().getAbsolutePath();
        String str2 = File.separator;
        String str3 = absolutePath + str2 + FAST_RECORD_DIR_PATH + str2;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str3 + j + AccountConstantKt.DEFAULT_SEGMENT + str + str2);
        String absolutePath2 = file2.getAbsolutePath();
        StringBuilder sb = new StringBuilder();
        sb.append("createVoiceDirForRecord record path = ");
        sb.append(absolutePath2);
        LogExt.logW(sb.toString(), TAG);
        delete(file2);
        file2.mkdirs();
        String absolutePath3 = file2.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath3, "getAbsolutePath(...)");
        return absolutePath3;
    }

    @NotNull
    public final String createVoicePcmFilePath(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(str2, "dirPath");
        String str3 = File.separator;
        File file = new File(str2 + str3 + str + LAST_PEX);
        delete(file);
        boolean createNewFile = file.createNewFile();
        LogExt.logW("createVoiceFilePath statue = " + createNewFile, TAG);
        if (!createNewFile) {
            return "";
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNull(absolutePath);
        return absolutePath;
    }

    @NotNull
    public final String createVoiceZipFilePath(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(str2, "dirPath");
        String str3 = File.separator;
        File file = new File(str2 + str3 + str + ".zip");
        delete(file);
        boolean createNewFile = file.createNewFile();
        LogExt.logW("createVoiceFilePath statue = " + createNewFile, TAG);
        if (!createNewFile) {
            return "";
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNull(absolutePath);
        return absolutePath;
    }

    @NotNull
    public final String createWavTempVoiceFilePath(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "recordId");
        Intrinsics.checkNotNullParameter(str2, "dirPath");
        String str3 = File.separator;
        File file = new File(str2 + str3 + str + "_wav.wav");
        delete(file);
        boolean createNewFile = file.createNewFile();
        LogExt.logW("createVoiceFilePath statue = " + createNewFile, TAG);
        if (!createNewFile) {
            return "";
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNull(absolutePath);
        return absolutePath;
    }

    public final boolean delete(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isFile() && file.delete()) {
            return true;
        }
        return false;
    }

    public final void fileAppendFile(@Nullable String str, @Nullable String str2) {
        FileInputStream fileInputStream = new FileInputStream(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2, true);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.close();
                fileInputStream.close();
                return;
            }
        }
    }

    @NotNull
    public final String getDirOrCreateForRecord(@NotNull Context context, long j, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "type");
        String absolutePath = context.getFilesDir().getAbsolutePath();
        String str2 = File.separator;
        String str3 = absolutePath + str2 + FAST_RECORD_DIR_PATH + str2;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str3 + j + AccountConstantKt.DEFAULT_SEGMENT + str + str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String absolutePath2 = file2.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
        return absolutePath2;
    }

    public final long getFileSize(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return -1;
        }
        return file.length();
    }

    @NotNull
    public final File getTempShareFile(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        String absolutePath = context.getCacheDir().getAbsolutePath();
        String str2 = File.separator;
        File file = new File(absolutePath + str2 + str);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        return file;
    }

    @NotNull
    public final String getTxtFileName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        String str2 = str + AccountConstantKt.DEFAULT_SEGMENT + new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())) + ".txt";
        Intrinsics.checkNotNullExpressionValue(str2, "toString(...)");
        return str2;
    }

    @Nullable
    public final String mergeFiles(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        FileInputStream fileInputStream = new FileInputStream(str);
        FileInputStream fileInputStream2 = new FileInputStream(str2);
        FileOutputStream fileOutputStream = new FileOutputStream(str3, true);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read <= 0) {
                break;
            }
            fileOutputStream.write(bArr, 0, read);
        }
        while (true) {
            int read2 = fileInputStream2.read(bArr);
            if (read2 > 0) {
                fileOutputStream.write(bArr, 0, read2);
            } else {
                fileOutputStream.close();
                fileInputStream.close();
                fileInputStream2.close();
                return str3;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0040, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0044, code lost:
        throw r0;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String readAsset(@org.jetbrains.annotations.NotNull android.content.Context r3, @org.jetbrains.annotations.Nullable java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            android.content.res.AssetManager r2 = r3.getAssets()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ IOException -> 0x0035 }
            java.io.InputStream r2 = r2.open(r4)     // Catch:{ IOException -> 0x0035 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x0037 }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ all -> 0x0037 }
            r0.<init>(r2)     // Catch:{ all -> 0x0037 }
            r4.<init>(r0)     // Catch:{ all -> 0x0037 }
        L_0x001f:
            java.lang.String r0 = r4.readLine()     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x002b
            r3.append(r0)     // Catch:{ all -> 0x0029 }
            goto L_0x001f
        L_0x0029:
            r0 = move-exception
            goto L_0x0039
        L_0x002b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0029 }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r4, r0)     // Catch:{ all -> 0x0037 }
            kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ IOException -> 0x0035 }
            goto L_0x0048
        L_0x0035:
            r2 = move-exception
            goto L_0x0045
        L_0x0037:
            r4 = move-exception
            goto L_0x003f
        L_0x0039:
            throw r0     // Catch:{ all -> 0x003a }
        L_0x003a:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r0)     // Catch:{ all -> 0x0037 }
            throw r1     // Catch:{ all -> 0x0037 }
        L_0x003f:
            throw r4     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r4)     // Catch:{ IOException -> 0x0035 }
            throw r0     // Catch:{ IOException -> 0x0035 }
        L_0x0045:
            r2.printStackTrace()
        L_0x0048:
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils.readAsset(android.content.Context, java.lang.String):java.lang.String");
    }

    public final void saveVoiceData(@NotNull String str, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        File file = new File(str);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        fileOutputStream.write(bArr);
        fileOutputStream.flush();
        LogExt.logW("savePcmData success", TAG);
    }

    public final void shareUriList(@NotNull Activity activity, @NotNull ArrayList<Uri> arrayList, @NotNull String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(arrayList, "shareTempFileUirList");
        Intrinsics.checkNotNullParameter(str, "type");
        String str2 = Intrinsics.areEqual((Object) str, (Object) RecordConstants.SHARE_TYPE_WORD) ? "text/plain" : RecordConstants.SHARE_TYPE_AUDIO;
        LogExt.logE("shareUriList fileType = " + str2 + ",type = " + str, TAG);
        if (!(!arrayList.isEmpty())) {
            return;
        }
        if (arrayList.size() == 1) {
            Uri uri = arrayList.get(0);
            Intrinsics.checkNotNullExpressionValue(uri, "get(...)");
            RecordExtKt.shareFile$default(activity, uri, str2, (String) null, 4, (Object) null);
            return;
        }
        RecordExtKt.shareMoreFile$default(activity, arrayList, str2, (String) null, 4, (Object) null);
    }

    public final boolean delete(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (file.isDirectory()) {
            return deleteDir(file);
        }
        return deleteFile(file);
    }
}
