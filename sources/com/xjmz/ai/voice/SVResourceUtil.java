package com.xjmz.ai.voice;

import android.content.Context;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class SVResourceUtil {
    private static final String TAG = "SVResourceUtil";

    private SVResourceUtil() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x007e A[SYNTHETIC, Splitter:B:21:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyAssetsData(@androidx.annotation.NonNull android.content.Context r9) {
        /*
            java.lang.String r0 = "SVResourceUtil"
            java.io.File r1 = new java.io.File
            java.io.File r2 = r9.getFilesDir()
            java.lang.String r2 = r2.getAbsolutePath()
            java.lang.String r3 = "vprint"
            r1.<init>(r2, r3)
            java.lang.String r2 = "-1"
            r4 = 0
            android.content.res.AssetManager r5 = r9.getAssets()     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            java.lang.String r6 = "vprint/version"
            java.io.InputStream r5 = r5.open(r6)     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            r7.<init>(r5)     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            java.lang.String r2 = r6.readLine()     // Catch:{ IOException -> 0x004f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004f }
            r5.<init>()     // Catch:{ IOException -> 0x004f }
            java.lang.String r7 = "AAR version "
            r5.append(r7)     // Catch:{ IOException -> 0x004f }
            r5.append(r2)     // Catch:{ IOException -> 0x004f }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x004f }
            android.util.Log.i(r0, r5)     // Catch:{ IOException -> 0x004f }
            r6.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x005c
        L_0x0046:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x005c
        L_0x004b:
            r9 = move-exception
            r4 = r6
            goto L_0x00f9
        L_0x004f:
            r5 = move-exception
            goto L_0x0056
        L_0x0051:
            r9 = move-exception
            goto L_0x00f9
        L_0x0054:
            r5 = move-exception
            r6 = r4
        L_0x0056:
            r5.printStackTrace()     // Catch:{ all -> 0x004b }
            r6.close()     // Catch:{ IOException -> 0x0046 }
        L_0x005c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.io.File r6 = r9.getFilesDir()
            r5.append(r6)
            java.lang.String r6 = "/vprint/version"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.io.File r6 = new java.io.File
            r6.<init>(r5)
            java.lang.String r7 = "-2"
            boolean r6 = r6.exists()
            if (r6 == 0) goto L_0x00d9
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            java.io.FileReader r8 = new java.io.FileReader     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            r8.<init>(r5)     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            r6.<init>(r8)     // Catch:{ IOException -> 0x00b0, all -> 0x00ae }
            java.lang.String r7 = r6.readLine()     // Catch:{ IOException -> 0x00ac }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ac }
            r4.<init>()     // Catch:{ IOException -> 0x00ac }
            java.lang.String r5 = "current version "
            r4.append(r5)     // Catch:{ IOException -> 0x00ac }
            r4.append(r7)     // Catch:{ IOException -> 0x00ac }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00ac }
            android.util.Log.i(r0, r4)     // Catch:{ IOException -> 0x00ac }
            r6.close()     // Catch:{ IOException -> 0x00a4 }
            goto L_0x00b9
        L_0x00a4:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x00b9
        L_0x00a9:
            r9 = move-exception
            r4 = r6
            goto L_0x00d0
        L_0x00ac:
            r4 = move-exception
            goto L_0x00b3
        L_0x00ae:
            r9 = move-exception
            goto L_0x00d0
        L_0x00b0:
            r5 = move-exception
            r6 = r4
            r4 = r5
        L_0x00b3:
            r4.printStackTrace()     // Catch:{ all -> 0x00a9 }
            r6.close()     // Catch:{ IOException -> 0x00a4 }
        L_0x00b9:
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x00c6
            java.lang.String r9 = "资源无更新，无需再次拷贝"
            android.util.Log.i(r0, r9)
            return
        L_0x00c6:
            java.lang.String r2 = "删除已有文件"
            android.util.Log.i(r0, r2)
            delete(r1)
            goto L_0x00df
        L_0x00d0:
            r4.close()     // Catch:{ IOException -> 0x00d4 }
            goto L_0x00d8
        L_0x00d4:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00d8:
            throw r9
        L_0x00d9:
            java.lang.String r2 = "当前设备上无资源文件"
            android.util.Log.i(r0, r2)
        L_0x00df:
            java.lang.String r2 = "拷贝资源文件"
            android.util.Log.i(r0, r2)     // Catch:{ IOException -> 0x00f1 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ IOException -> 0x00f1 }
            r2 = 10240(0x2800, float:1.4349E-41)
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x00f1 }
            copyFilesFromAssets(r9, r3, r1, r2)     // Catch:{ IOException -> 0x00f1 }
            goto L_0x00f8
        L_0x00f1:
            r9 = move-exception
            java.lang.String r1 = "文件拷贝异常"
            android.util.Log.i(r0, r1, r9)
        L_0x00f8:
            return
        L_0x00f9:
            r4.close()     // Catch:{ IOException -> 0x00fd }
            goto L_0x0101
        L_0x00fd:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0101:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.ai.voice.SVResourceUtil.copyAssetsData(android.content.Context):void");
    }

    public static void copyFilesFromAssets(Context context, String str, String str2, byte[] bArr) throws IOException {
        String[] list = context.getAssets().list(str);
        if (list == null || list.length <= 0) {
            Log.i(TAG, "copyFilesFromAssets assetsPath=" + str + " ,fileName=" + str.substring(str.lastIndexOf(File.separator) + 1));
            copyOtherFile(context, str, str2, bArr);
            return;
        }
        File file = new File(str2);
        if (file.exists() || file.mkdirs()) {
            for (String str3 : list) {
                copyFilesFromAssets(context, str + "/" + str3, str2 + "/" + str3, bArr);
            }
            return;
        }
        Log.i(TAG, "创建文件夹--" + file.getAbsolutePath() + "失败");
    }

    private static void copyOtherFile(Context context, String str, String str2, byte[] bArr) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(context.getAssets().open(str));
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    bufferedInputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        throw th;
    }

    public static void delete(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                Objects.requireNonNull(listFiles);
                for (File delete : listFiles) {
                    delete(delete);
                }
            }
            Log.i(TAG, "删除文件--" + file.getAbsolutePath() + "，result--" + file.delete());
        }
    }
}
