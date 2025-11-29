package com.jstyle.nordic_otas.nordic_otas_plugin;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtils {
    private static final String TAG = "ZipUtils";
    public static final String fromPath1 = (Environment.getExternalStorageDirectory().getPath() + "/com.jstyle.app");

    public static byte[] ArrListToByteArray(List<Integer> list) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(list);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int CalcCRC16(byte[] r6, int r7) {
        /*
            r0 = 65535(0xffff, float:9.1834E-41)
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r7 <= 0) goto L_0x0028
            int r7 = r7 + -1
            int r3 = r2 + 1
            byte r2 = r6[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r0 = r0 ^ r2
            r2 = r1
        L_0x0011:
            r4 = 8
            if (r2 >= r4) goto L_0x0026
            r4 = r0 & 1
            r5 = 1
            if (r4 != r5) goto L_0x0021
            int r0 = r0 >> 1
            r4 = 40961(0xa001, float:5.7399E-41)
            r0 = r0 ^ r4
            goto L_0x0023
        L_0x0021:
            int r0 = r0 >> 1
        L_0x0023:
            int r2 = r2 + 1
            goto L_0x0011
        L_0x0026:
            r2 = r3
            goto L_0x0005
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jstyle.nordic_otas.nordic_otas_plugin.ZipUtils.CalcCRC16(byte[], int):int");
    }

    private static byte[] checkFile(byte[] bArr, byte[] bArr2, int i, int i2) {
        int length = bArr.length;
        int CalcCRC16 = CalcCRC16(bArr, bArr.length);
        byte[] bArr3 = new byte[27];
        bArr3[0] = -110;
        bArr3[1] = (byte) i;
        bArr3[2] = (byte) i2;
        bArr3[3] = (byte) (length & 255);
        bArr3[4] = (byte) ((length >> 8) & 255);
        bArr3[5] = (byte) ((length >> 16) & 255);
        bArr3[6] = (byte) ((length >> 24) & 255);
        bArr3[7] = (byte) (CalcCRC16 & 255);
        bArr3[8] = (byte) ((CalcCRC16 >> 8) & 255);
        System.arraycopy(bArr2, 0, bArr3, 9, bArr2.length);
        int CalcCRC162 = CalcCRC16(bArr3, 25);
        bArr3[25] = (byte) (CalcCRC162 & 255);
        bArr3[26] = (byte) ((CalcCRC162 >> 8) & 255);
        return bArr3;
    }

    public static byte[] checkUpdateFile(byte[] bArr, byte[] bArr2, int i, boolean z) {
        return checkFile(bArr, bArr2, 1, i);
    }

    public static String copyFile(Context context, InputStream inputStream, String str) {
        File file = new File(context.getFilesDir().getAbsolutePath());
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "ota");
            if (!file2.exists()) {
                file2.mkdir();
            }
            File file3 = new File(file2, str);
            if (file3.exists()) {
                file3.delete();
            }
            file3.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            byte[] bArr = new byte[1024];
            if (!str.endsWith("zip")) {
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } else {
                while (inputStream.read(bArr) > 0) {
                    fileOutputStream.write(bArr);
                }
            }
            fileOutputStream.flush();
            inputStream.close();
            fileOutputStream.close();
            String absolutePath = file3.getAbsolutePath();
            Log.i(TAG, "copyFileFromUri: " + absolutePath + " " + file3.length());
            return absolutePath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void copyFileFromAssets(Context context, String str) {
        File file = new File(getFromPath(context));
        try {
            if (file.exists()) {
                deleteDirectory(file);
            }
            file.mkdirs();
            File file2 = new File(file, str);
            file2.createNewFile();
            InputStream open = context.getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (open.read(bArr) > 0) {
                fileOutputStream.write(bArr);
            }
            fileOutputStream.flush();
            open.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0065 A[LOOP:0: B:13:0x005f->B:15:0x0065, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyFiles(java.io.File r6, java.lang.String r7) throws java.io.IOException {
        /*
            boolean r0 = r6.exists()
            java.lang.String r1 = "debug"
            if (r0 == 0) goto L_0x0078
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "source "
            r0.append(r2)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r1, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "des "
            r0.append(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r1, r0)
            r0 = 0
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x004c }
            r3.<init>(r6)     // Catch:{ FileNotFoundException -> 0x004c }
            java.io.File r6 = new java.io.File     // Catch:{ FileNotFoundException -> 0x004a }
            java.lang.String r4 = java.lang.String.valueOf(r7)     // Catch:{ FileNotFoundException -> 0x004a }
            r6.<init>(r4)     // Catch:{ FileNotFoundException -> 0x004a }
            r6.delete()     // Catch:{ FileNotFoundException -> 0x004a }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x004a }
            r6.<init>(r7, r0)     // Catch:{ FileNotFoundException -> 0x004a }
            r2 = r6
            goto L_0x0051
        L_0x004a:
            r6 = move-exception
            goto L_0x004e
        L_0x004c:
            r6 = move-exception
            r3 = r2
        L_0x004e:
            r6.printStackTrace()
        L_0x0051:
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream
            r7.<init>(r2)
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream
            r4.<init>(r3)
        L_0x005f:
            int r5 = r4.read(r6)
            if (r5 <= 0) goto L_0x0069
            r7.write(r6, r0, r5)
            goto L_0x005f
        L_0x0069:
            r3.close()
            r7.close()
            r2.close()
            java.lang.String r6 = "Copy file successful."
            android.util.Log.e(r1, r6)
            goto L_0x007d
        L_0x0078:
            java.lang.String r6 = "Copy file failed. Source file missing."
            android.util.Log.v(r1, r6)
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jstyle.nordic_otas.nordic_otas_plugin.ZipUtils.copyFiles(java.io.File, java.lang.String):void");
    }

    private static void deleteDirectory(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        for (String str : file.list()) {
            deleteDirectory(new File(file.getAbsolutePath() + "/" + str));
        }
        file.delete();
    }

    public static byte[] endUpdateFile(byte[] bArr, byte[] bArr2, int i) {
        return checkFile(bArr, bArr2, 2, i);
    }

    private static byte getByte(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return (byte) Integer.parseInt(str, 16);
    }

    public static String getFromPath(Context context) {
        return context.getExternalCacheDir().getPath() + "/update/";
    }

    public static byte[] getMd5Byte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = getByte(str.substring(i2, i2 + 2));
        }
        return bArr;
    }

    public static File getRealFileName(String str, String str2) {
        Log.i(TAG, "baseDir=" + str + "------absFileName=" + str2);
        String replace = str2.replace("\\", "/");
        StringBuilder sb = new StringBuilder();
        sb.append("absFileName=");
        sb.append(replace);
        Log.i(TAG, sb.toString());
        String[] split = replace.split("/");
        Log.i(TAG, "dirs=" + split);
        File file = new File(str);
        if (split.length <= 1) {
            return new File(file, replace);
        }
        int i = 0;
        while (i < split.length - 1) {
            i++;
            file = new File(file, split[i]);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, split[split.length - 1]);
    }

    public static String loadFromSDFile(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            byte[] bArr = new byte[((int) file.length())];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
            return new String(bArr, StandardCharsets.UTF_8);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean needResUpdate(String str) {
        try {
            Enumeration<? extends ZipEntry> entries = new ZipFile(str).entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                PrintStream printStream = System.out;
                printStream.println("dirstr=" + zipEntry.getName());
                if ("color565.bin".equals(zipEntry.getName())) {
                    return true;
                }
                zipEntry.isDirectory();
            }
        } catch (IOException unused) {
        }
        return false;
    }

    public static byte[] readFile(File file) {
        if (file.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (IOException unused) {
                return null;
            }
        } else {
            System.out.println("文件不存在！");
            return null;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean upZipFile(java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0096 }
            r1.<init>(r8)     // Catch:{ IOException -> 0x0096 }
            java.util.Enumeration r8 = r1.entries()
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r2]
            java.io.File r4 = new java.io.File
            r4.<init>(r9)
            boolean r5 = r4.exists()
            if (r5 != 0) goto L_0x001c
            r4.mkdirs()
        L_0x001c:
            boolean r4 = r8.hasMoreElements()
            if (r4 == 0) goto L_0x0091
            java.lang.Object r4 = r8.nextElement()
            java.util.zip.ZipEntry r4 = (java.util.zip.ZipEntry) r4
            boolean r5 = r4.isDirectory()
            if (r5 == 0) goto L_0x0063
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r9)
            java.lang.String r4 = r4.getName()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "dirstr="
            r5.append(r6)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "ZipUtils"
            android.util.Log.i(r6, r5)
            r4.trim()
            java.io.File r5 = new java.io.File
            r5.<init>(r4)
            r5.mkdir()
            goto L_0x001c
        L_0x0063:
            java.lang.String r5 = r4.getName()
            java.io.File r5 = getRealFileName(r9, r5)
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0090 }
            r6.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0090 }
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream
            r5.<init>(r6)
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{  }
            java.io.InputStream r4 = r1.getInputStream(r4)     // Catch:{  }
            r6.<init>(r4)     // Catch:{  }
        L_0x007e:
            int r4 = r6.read(r3, r0, r2)     // Catch:{  }
            r7 = -1
            if (r4 == r7) goto L_0x0089
            r5.write(r3, r0, r4)     // Catch:{  }
            goto L_0x007e
        L_0x0089:
            r6.close()     // Catch:{  }
            r5.close()     // Catch:{  }
            goto L_0x001c
        L_0x0090:
            return r0
        L_0x0091:
            r1.close()     // Catch:{  }
            r8 = 1
            return r8
        L_0x0096:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jstyle.nordic_otas.nordic_otas_plugin.ZipUtils.upZipFile(java.lang.String, java.lang.String):boolean");
    }
}
