package com.xjsd.ai.voice;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.xjsd.ai.entity.AudioConfig;
import com.xjsd.ai.utils.GsonUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class FspResourceUtil {
    private static final String TAG = "FspResourceUtil";

    private FspResourceUtil() {
    }

    private static void copyAudioConfigFile(Context context, String str, String str2) {
        BufferedWriter bufferedWriter;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str2)));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                String sb2 = sb.toString();
                Log.i(TAG, "copyAudioConfig originalContent=" + sb2);
                if (!TextUtils.isEmpty(sb2)) {
                    String str3 = context.getFilesDir().getAbsolutePath() + "/fsp/res/";
                    AudioConfig audioConfig = (AudioConfig) GsonUtils.a(sb2, AudioConfig.class);
                    Log.i(TAG, "engineConfig=" + audioConfig);
                    if (audioConfig.getModules() != null) {
                        audioConfig.getModules().setDir(str3);
                        sb2 = GsonUtils.c(audioConfig);
                    } else {
                        sb2 = sb2.replace("/home/res/", str3);
                    }
                }
                Log.i(TAG, "copyAudioConfig updateContent=" + sb2);
                bufferedWriter.write(sb2);
                bufferedWriter.flush();
                bufferedWriter.close();
                bufferedReader.close();
                return;
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
            throw th;
        } catch (Exception e) {
            Log.e(TAG, "copyAudioConfig文件失败", e);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    public static void copyFilesFromAssets(Context context, String str, String str2, byte[] bArr) throws IOException {
        String[] list = context.getAssets().list(str);
        if (list == null || list.length <= 0) {
            String substring = str.substring(str.lastIndexOf(File.separator) + 1);
            Log.i(TAG, "copyFilesFromAssets assetsPath=" + str + " ,fileName=" + substring);
            if (substring.startsWith("gloable-")) {
                copyAudioConfigFile(context, str, str2);
            } else {
                copyOtherFile(context, str, str2, bArr);
            }
        } else {
            File file = new File(str2);
            if (file.exists() || file.mkdirs()) {
                for (String str3 : list) {
                    copyFilesFromAssets(context, str + "/" + str3, str2 + "/" + str3, bArr);
                }
                return;
            }
            Log.i(TAG, "创建文件夹--" + file.getAbsolutePath() + "失败");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x007c A[SYNTHETIC, Splitter:B:21:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyModelData(@androidx.annotation.NonNull android.content.Context r9) {
        /*
            java.lang.String r0 = "FspResourceUtil"
            java.io.File r1 = new java.io.File
            java.io.File r2 = r9.getFilesDir()
            java.lang.String r2 = r2.getAbsolutePath()
            java.lang.String r3 = "fsp"
            r1.<init>(r2, r3)
            java.lang.String r2 = "-1"
            r4 = 0
            android.content.res.AssetManager r5 = r9.getAssets()     // Catch:{ IOException -> 0x0052, all -> 0x004f }
            java.lang.String r6 = "fsp/version"
            java.io.InputStream r5 = r5.open(r6)     // Catch:{ IOException -> 0x0052, all -> 0x004f }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0052, all -> 0x004f }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0052, all -> 0x004f }
            r7.<init>(r5)     // Catch:{ IOException -> 0x0052, all -> 0x004f }
            r6.<init>(r7)     // Catch:{ IOException -> 0x0052, all -> 0x004f }
            java.lang.String r2 = r6.readLine()     // Catch:{ IOException -> 0x004d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004d }
            r5.<init>()     // Catch:{ IOException -> 0x004d }
            java.lang.String r7 = "AAR version "
            r5.append(r7)     // Catch:{ IOException -> 0x004d }
            r5.append(r2)     // Catch:{ IOException -> 0x004d }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x004d }
            android.util.Log.i(r0, r5)     // Catch:{ IOException -> 0x004d }
            r6.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x005a
        L_0x0044:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x005a
        L_0x0049:
            r9 = move-exception
            r4 = r6
            goto L_0x00f7
        L_0x004d:
            r5 = move-exception
            goto L_0x0054
        L_0x004f:
            r9 = move-exception
            goto L_0x00f7
        L_0x0052:
            r5 = move-exception
            r6 = r4
        L_0x0054:
            r5.printStackTrace()     // Catch:{ all -> 0x0049 }
            r6.close()     // Catch:{ IOException -> 0x0044 }
        L_0x005a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.io.File r6 = r9.getFilesDir()
            r5.append(r6)
            java.lang.String r6 = "/fsp/version"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.io.File r6 = new java.io.File
            r6.<init>(r5)
            java.lang.String r7 = "-2"
            boolean r6 = r6.exists()
            if (r6 == 0) goto L_0x00d7
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00ae, all -> 0x00ac }
            java.io.FileReader r8 = new java.io.FileReader     // Catch:{ IOException -> 0x00ae, all -> 0x00ac }
            r8.<init>(r5)     // Catch:{ IOException -> 0x00ae, all -> 0x00ac }
            r6.<init>(r8)     // Catch:{ IOException -> 0x00ae, all -> 0x00ac }
            java.lang.String r7 = r6.readLine()     // Catch:{ IOException -> 0x00aa }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00aa }
            r4.<init>()     // Catch:{ IOException -> 0x00aa }
            java.lang.String r5 = "current version "
            r4.append(r5)     // Catch:{ IOException -> 0x00aa }
            r4.append(r7)     // Catch:{ IOException -> 0x00aa }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00aa }
            android.util.Log.i(r0, r4)     // Catch:{ IOException -> 0x00aa }
            r6.close()     // Catch:{ IOException -> 0x00a2 }
            goto L_0x00b7
        L_0x00a2:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x00b7
        L_0x00a7:
            r9 = move-exception
            r4 = r6
            goto L_0x00ce
        L_0x00aa:
            r4 = move-exception
            goto L_0x00b1
        L_0x00ac:
            r9 = move-exception
            goto L_0x00ce
        L_0x00ae:
            r5 = move-exception
            r6 = r4
            r4 = r5
        L_0x00b1:
            r4.printStackTrace()     // Catch:{ all -> 0x00a7 }
            r6.close()     // Catch:{ IOException -> 0x00a2 }
        L_0x00b7:
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x00c4
            java.lang.String r9 = "前端信号资源无更新，无需再次拷贝"
            android.util.Log.i(r0, r9)
            return
        L_0x00c4:
            java.lang.String r2 = "删除已有文件"
            android.util.Log.i(r0, r2)
            delete(r1)
            goto L_0x00dd
        L_0x00ce:
            r4.close()     // Catch:{ IOException -> 0x00d2 }
            goto L_0x00d6
        L_0x00d2:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00d6:
            throw r9
        L_0x00d7:
            java.lang.String r2 = "当前设备上无资源文件"
            android.util.Log.i(r0, r2)
        L_0x00dd:
            java.lang.String r2 = "拷贝资源文件"
            android.util.Log.i(r0, r2)     // Catch:{ IOException -> 0x00ef }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ IOException -> 0x00ef }
            r2 = 10240(0x2800, float:1.4349E-41)
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x00ef }
            copyFilesFromAssets(r9, r3, r1, r2)     // Catch:{ IOException -> 0x00ef }
            goto L_0x00f6
        L_0x00ef:
            r9 = move-exception
            java.lang.String r1 = "前端信号处理相关文件拷贝异常"
            android.util.Log.i(r0, r1, r9)
        L_0x00f6:
            return
        L_0x00f7:
            r4.close()     // Catch:{ IOException -> 0x00fb }
            goto L_0x00ff
        L_0x00fb:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00ff:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.voice.FspResourceUtil.copyModelData(android.content.Context):void");
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
