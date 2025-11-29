package com.upuphone.ai.ttsengine.base.utils;

import java.io.File;
import java.io.RandomAccessFile;

public class WavUtils {
    public static void a(File file, int i, int i2) {
        RandomAccessFile randomAccessFile;
        byte[] a2 = WaveHeader.a(((int) file.length()) - 44, i2, i);
        if (file.isFile()) {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0);
                randomAccessFile.write(a2);
                randomAccessFile.close();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            return;
        }
        throw th;
    }
}
