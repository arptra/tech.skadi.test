package com.upuphone.runasone.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.upuphone.runasone.uupcast.CaptureType;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public final class SignatureUtil {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String getAppSignature(Context context) {
        Signature[] signingCertificateHistory;
        PackageInfo packageInfo = getPackageInfo(context);
        if (!(packageInfo == null || (signingCertificateHistory = packageInfo.signingInfo.getSigningCertificateHistory()) == null || signingCertificateHistory.length <= 0)) {
            try {
                byte[] byteArray = signingCertificateHistory[0].toByteArray();
                MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                instance.update(byteArray, 0, byteArray.length);
                return toHexString(instance.digest());
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    private static PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), CaptureType.CAPTURE_VIRTUAL_DISPLAY_ENABLE_MAGIC_WINDOW);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            char[] cArr = HEX_DIGITS;
            sb.append(cArr[(b & 240) >> 4]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString();
    }
}
