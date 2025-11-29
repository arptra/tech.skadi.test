package com.xingin.xhssharesdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.honey.account.constant.AccountConstantKt;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import com.xingin.xhssharesdk.l.a;
import com.xingin.xhssharesdk.m.b;
import com.xingin.xhssharesdk.model.other.VersionCheckResult;
import com.xingin.xhssharesdk.model.sharedata.XhsNote;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.UUID;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Keep
public class XhsShareSdkTools {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String TAG = "XhsShare_XhsShareSdkTools";
    private static String guid;

    public static String byteToString(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = HEX_DIGITS;
            cArr[i2] = cArr2[(b >>> 4) & 15];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061 A[SYNTHETIC, Splitter:B:23:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0081 A[LOOP:0: B:9:0x002e->B:29:0x0081, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0084 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int compare(java.lang.String r11, java.lang.String r12) {
        /*
            java.lang.String r0 = r11.trim()
            java.lang.String r1 = "."
            boolean r2 = r0.contains(r1)
            java.lang.String r3 = "\\."
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0015
            java.lang.String[] r0 = r0.split(r3)
            goto L_0x001a
        L_0x0015:
            java.lang.String[] r2 = new java.lang.String[r4]
            r2[r5] = r0
            r0 = r2
        L_0x001a:
            java.lang.String r2 = r12.trim()
            boolean r1 = r2.contains(r1)
            if (r1 == 0) goto L_0x0029
            java.lang.String[] r1 = r2.split(r3)
            goto L_0x002d
        L_0x0029:
            java.lang.String[] r1 = new java.lang.String[r4]
            r1[r5] = r2
        L_0x002d:
            r2 = r5
        L_0x002e:
            int r3 = r0.length
            if (r3 > r2) goto L_0x0036
            int r3 = r1.length
            if (r3 <= r2) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            return r5
        L_0x0036:
            int r3 = r0.length
            java.lang.String r6 = "XhsShare_XhsShareSdkTools"
            java.lang.String r7 = "version2 is "
            java.lang.String r8 = "Compare version error! version1 is "
            if (r3 <= r2) goto L_0x005d
            r3 = r0[r2]     // Catch:{ Exception -> 0x0047 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x0047 }
            goto L_0x005e
        L_0x0047:
            r3 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r8)
            r9.append(r11)
            r9.append(r7)
            r9.append(r12)
            java.lang.String r9 = r9.toString()
            com.xingin.xhssharesdk.core.XhsShareSdk.d(r6, r9, r3)
        L_0x005d:
            r3 = r5
        L_0x005e:
            int r9 = r1.length
            if (r9 <= r2) goto L_0x007e
            r9 = r1[r2]     // Catch:{ Exception -> 0x0068 }
            int r6 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x0068 }
            goto L_0x007f
        L_0x0068:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r8)
            r10.append(r11)
            r10.append(r7)
            r10.append(r12)
            java.lang.String r7 = r10.toString()
            com.xingin.xhssharesdk.core.XhsShareSdk.d(r6, r7, r9)
        L_0x007e:
            r6 = r5
        L_0x007f:
            if (r3 != r6) goto L_0x0084
            int r2 = r2 + 1
            goto L_0x002e
        L_0x0084:
            if (r3 <= r6) goto L_0x0087
            goto L_0x0088
        L_0x0087:
            r4 = -1
        L_0x0088:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xingin.xhssharesdk.XhsShareSdkTools.compare(java.lang.String, java.lang.String):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.xingin.xhssharesdk.j.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.xingin.xhssharesdk.j.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.xingin.xhssharesdk.j.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: com.xingin.xhssharesdk.j.b} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.net.Uri convertAvailableUri(@androidx.annotation.NonNull android.content.Context r6, @androidx.annotation.NonNull java.lang.String r7, @androidx.annotation.NonNull java.io.File r8) {
        /*
            com.xingin.xhssharesdk.j.d r0 = com.xingin.xhssharesdk.j.c.f8190a
            if (r0 != 0) goto L_0x003c
            com.xingin.xhssharesdk.j.b r0 = new com.xingin.xhssharesdk.j.b
            r0.<init>()
            int r1 = androidx.core.content.FileProvider.f686a     // Catch:{ ClassNotFoundException -> 0x000c }
            goto L_0x0031
        L_0x000c:
            r0 = move-exception
            java.lang.String r1 = "XhsShare_AndroidXFileProvider"
            java.lang.String r2 = "androidx.core.content.FileProvider find error."
            com.xingin.xhssharesdk.core.XhsShareSdk.d(r1, r2, r0)
            com.xingin.xhssharesdk.j.a r0 = new com.xingin.xhssharesdk.j.a
            r0.<init>()
            java.lang.String r1 = "android.support.v4.content.FileProvider"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0034 }
            java.lang.String r2 = "getUriForFile"
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            java.lang.Class<java.io.File> r5 = java.io.File.class
            java.lang.Class[] r3 = new java.lang.Class[]{r3, r4, r5}     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0034 }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r3)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0034 }
            r0.f8189a = r1     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0034 }
        L_0x0031:
            com.xingin.xhssharesdk.j.c.f8190a = r0
            goto L_0x003c
        L_0x0034:
            r0 = move-exception
            java.lang.String r1 = "XhsShare_AndroidSupportFileProvider"
            java.lang.String r2 = "android.support.v4.content.FileProvider find error."
            com.xingin.xhssharesdk.core.XhsShareSdk.d(r1, r2, r0)
        L_0x003c:
            com.xingin.xhssharesdk.j.d r0 = com.xingin.xhssharesdk.j.c.f8190a
            if (r0 != 0) goto L_0x0042
            r7 = 0
            goto L_0x0046
        L_0x0042:
            android.net.Uri r7 = r0.a(r6, r7, r8)
        L_0x0046:
            grantUriPermission(r6, r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xingin.xhssharesdk.XhsShareSdkTools.convertAvailableUri(android.content.Context, java.lang.String, java.io.File):android.net.Uri");
    }

    @WorkerThread
    public static void copyFile(Context context, Uri uri, File file) {
        FileOutputStream fileOutputStream;
        if (isUriExist(context, uri)) {
            try {
                ensureFileAvailable(file);
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                try {
                    fileOutputStream = new FileOutputStream(file);
                    if (openInputStream != null) {
                        byte[] bArr = new byte[1000];
                        while (openInputStream.read(bArr, 0, 1000) >= 0) {
                            fileOutputStream.write(bArr, 0, 1000);
                            if (Thread.currentThread().isInterrupted()) {
                                throw new InterruptedException("[copyFile] The thread be Interrupted!!");
                            }
                        }
                        fileOutputStream.close();
                        openInputStream.close();
                        return;
                    }
                    throw new a(3, "The inputStream from src is null!!!");
                } catch (Throwable th) {
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (a e) {
                int i = e.f8191a;
                throw new a(i, "In function [createNewFile]: " + e.getMessage());
            }
        } else {
            throw new a(1, "Src uri not exist! uri is " + uri);
        }
        throw th;
    }

    public static File createTempFile(String str) {
        return new File(str, "temp_" + System.currentTimeMillis());
    }

    public static void deleteFile(File file, boolean z) {
        if (file != null && !Thread.currentThread().isInterrupted()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File deleteFile : listFiles) {
                        deleteFile(deleteFile, true);
                    }
                    if (!z) {
                        return;
                    }
                } else {
                    return;
                }
            } else if (!file.exists()) {
                return;
            }
            file.delete();
        }
    }

    public static boolean ensureFileAvailable(File file) {
        if (file == null) {
            throw new a(2, "The file can not be null!");
        } else if (file.exists()) {
            return true;
        } else {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                throw new a(2, "The file's parent dir can not be null!");
            } else if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            } else {
                throw new a(2, "The file's parent dir mkdirs failed!");
            }
        }
    }

    public static String generateSessionId(@NonNull XhsNote xhsNote) {
        return Base64.encodeToString((xhsNote.hashCode() + AccountConstantKt.DEFAULT_SEGMENT + System.currentTimeMillis()).getBytes(StandardCharsets.UTF_8), 2);
    }

    @NonNull
    public static String getAppVersionName(@Nullable Context context, String str) {
        PackageInfo packageInfo = getPackageInfo(context, str);
        return packageInfo == null ? "" : packageInfo.versionName;
    }

    @NonNull
    public static String getCurrentAppPackageName(@Nullable Context context) {
        return context == null ? "" : context.getPackageName();
    }

    public static int getCurrentAppVersionCode(@Nullable Context context) {
        PackageInfo packageInfo = getPackageInfo(context, getCurrentAppPackageName(context));
        if (packageInfo == null) {
            return -1;
        }
        return packageInfo.versionCode;
    }

    public static String getCurrentAppVersionName(@Nullable Context context) {
        return getAppVersionName(context, getCurrentAppPackageName(context));
    }

    public static String getDefaultCacheDirPath(@NonNull Context context) {
        return new File(context.getExternalCacheDir(), "xhs_share_cache_dir").getAbsolutePath();
    }

    public static String getDid(@Nullable Context context) {
        if (context == null) {
            return "";
        }
        if (!TextUtils.isEmpty(guid)) {
            return guid;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("XHS_SHARE_SDK_SP", 0);
        String string = sharedPreferences.getString("XHS_SHARE_SDK_SP_KEY_GUID", "");
        guid = string;
        if (TextUtils.isEmpty(string)) {
            guid = UUID.randomUUID().toString();
            sharedPreferences.edit().putString("XHS_SHARE_SDK_SP_KEY_GUID", guid).apply();
        }
        return guid;
    }

    public static Pair<Integer, Integer> getErrorCodeFromXhsShareResult(b bVar) {
        int i;
        int i2;
        int i3 = bVar.b;
        if (i3 == 2) {
            i2 = XhsShareConstants$XhsShareNoteErrorCode.INTERRUPTED_BY_NEW_SHARE;
            i = XhsShareConstants$XhsShareNoteNewErrorCode.INTERRUPTED_BY_NEW_SHARE_IN_XHS;
        } else if (i3 == 3) {
            i2 = XhsShareConstants$XhsShareNoteErrorCode.SHARE_TYPE_ERROR;
            i = XhsShareConstants$XhsShareNoteNewErrorCode.SHARE_TYPE_ERROR_IN_XHS;
        } else if (i3 == 4) {
            i2 = XhsShareConstants$XhsShareNoteErrorCode.CAN_NOT_POST;
            i = XhsShareConstants$XhsShareNoteNewErrorCode.CAN_NOT_POST_IN_XHS;
        } else if (i3 != 5) {
            i2 = XhsShareConstants$XhsShareNoteErrorCode.UNKNOWN;
            i = i3 != 6 ? XhsShareConstants$XhsShareNoteNewErrorCode.UNKNOWN : XhsShareConstants$XhsShareNoteNewErrorCode.DATA_PARSE_ERROR;
        } else {
            i2 = XhsShareConstants$XhsShareNoteErrorCode.POST_CANCEL;
            i = XhsShareConstants$XhsShareNoteNewErrorCode.POST_CANCEL_IN_XHS;
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static long getFileLength(@NonNull Context context, @NonNull Uri uri) {
        if (TextUtils.equals(uri.getScheme(), "file")) {
            return new File(uri.getPath()).length();
        }
        long j = -1;
        if (TextUtils.equals(uri.getScheme(), "content")) {
            Cursor query = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        j = query.getLong(query.getColumnIndex("_size"));
                    }
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return j;
        throw th;
    }

    @Nullable
    private static PackageInfo getPackageInfo(@Nullable Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return context.getApplicationContext().getPackageManager().getPackageInfo(str, 0);
    }

    public static String getSdkVersion() {
        return "1.1.6";
    }

    public static String getXhsPackageName() {
        return "com.xingin.xhs";
    }

    public static void grantUriPermission(@NonNull Context context, @Nullable Uri uri) {
        if (uri != null) {
            context.grantUriPermission(getXhsPackageName(), uri, 1);
        }
    }

    public static boolean isNetworkUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }

    @NonNull
    public static VersionCheckResult isSupportShareNote(Context context) {
        try {
            String appVersionName = getAppVersionName(context, getXhsPackageName());
            if (!TextUtils.isEmpty(XhsSdkInject.getShareNoteMinXhsVersionName()) && compare(appVersionName, XhsSdkInject.getShareNoteMinXhsVersionName()) < 0) {
                return new VersionCheckResult(-2, "Xhs version is " + appVersionName + ", low than " + XhsSdkInject.getShareNoteMinXhsVersionName() + "!", (Throwable) null);
            } else if (TextUtils.isEmpty(XhsSdkInject.getShareNoteMaxXhsVersionName()) || compare(appVersionName, XhsSdkInject.getShareNoteMaxXhsVersionName()) <= 0) {
                return new VersionCheckResult(0, "", (Throwable) null);
            } else {
                return new VersionCheckResult(-2, "Xhs version is " + appVersionName + ", large than " + XhsSdkInject.getShareNoteMaxXhsVersionName() + "!", (Throwable) null);
            }
        } catch (PackageManager.NameNotFoundException e) {
            XhsShareSdk.d(TAG, "Get Xhs PackageInfo error!", e);
            return new VersionCheckResult(-1, "Xhs not install!", e);
        }
    }

    public static boolean isUriExist(Context context, @Nullable Uri uri) {
        boolean z = false;
        if (uri == null) {
            return false;
        }
        if (TextUtils.equals(uri.getScheme(), "file")) {
            return new File(uri.getPath()).exists();
        }
        Cursor query = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    z = true;
                }
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        if (query != null) {
            query.close();
        }
        return z;
        throw th;
    }

    public static boolean isXhsInstalled(Context context) {
        try {
            getAppVersionName(context, getXhsPackageName());
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            XhsShareSdk.d(TAG, "Get Xhs PackageInfo error!", e);
            return false;
        }
    }

    public static String md5(String str) {
        return md5(str.getBytes(StandardCharsets.UTF_8));
    }

    @WorkerThread
    public static boolean saveBitmapToFile(Bitmap bitmap, File file) {
        if (bitmap == null || bitmap.isRecycled()) {
            throw new a(-1, "Bitmap is null or has be recycled!");
        } else if (file == null || !file.exists() || !file.isFile() || !file.canWrite()) {
            throw new a(-1, "The dstFile is unavailable!");
        } else {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                boolean compress = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                bufferedOutputStream.close();
                return compress;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        throw th;
    }

    public static String md5(byte[] bArr) {
        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        instance.update(bArr);
        return byteToString(instance.digest()).toLowerCase();
    }
}
