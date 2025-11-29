package com.upuphone.ai.ttsengine.base.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;

public class TtsAudioUtils {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap f5532a = new HashMap();
    public static byte[] b;
    public static int c = 100;

    static {
        byte[] bArr = new byte[3200];
        b = bArr;
        Arrays.fill(bArr, (byte) 0);
    }

    public static boolean a(String str, boolean z, boolean z2, int i) {
        if (!z) {
            return false;
        }
        try {
            FileOutputStream b2 = b(str);
            if (b2 != null) {
                b2.flush();
                b2.close();
                if (z2) {
                    WavUtils.a(new File(str), i, 1);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            f5532a.remove(str);
        }
    }

    public static FileOutputStream b(String str) {
        FileOutputStream fileOutputStream = (FileOutputStream) f5532a.get(str);
        if (fileOutputStream != null) {
            return fileOutputStream;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            Files.delete(file.toPath());
        }
        file.getParentFile().mkdirs();
        if (!file.createNewFile()) {
            return fileOutputStream;
        }
        FileOutputStream fileOutputStream2 = new FileOutputStream(str, true);
        f5532a.put(str, fileOutputStream2);
        return fileOutputStream2;
    }

    public static void c(String str, int i, boolean z) {
        if (z) {
            try {
                FileOutputStream b2 = b(str);
                if (b2 != null) {
                    for (int i2 = 0; i2 < i; i2++) {
                        byte[] bArr = b;
                        b2.write(bArr, 0, bArr.length);
                    }
                    b2.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean d(String str) {
        try {
            return Files.deleteIfExists(Paths.get(str, new String[0]));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void e(String str, byte[] bArr, int i, boolean z) {
        if (z) {
            try {
                FileOutputStream b2 = b(str);
                if (b2 != null) {
                    b2.write(bArr, 0, i);
                    b2.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
