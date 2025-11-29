package com.upuphone.starrycommon.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class FileUtils {
    public static String a(File file) {
        StarryCastLog.b("FileUtils", "md5 start ");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            int i = 0;
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1 || i >= 896) {
                    fileInputStream.close();
                    byte[] digest = instance.digest();
                    StringBuilder sb = new StringBuilder();
                } else {
                    instance.update(bArr, 0, read);
                    i++;
                }
            }
            fileInputStream.close();
            byte[] digest2 = instance.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b : digest2) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb2.append(hexString);
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
