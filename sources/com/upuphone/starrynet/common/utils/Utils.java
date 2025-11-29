package com.upuphone.starrynet.common.utils;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import java.lang.Character;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Pattern;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class Utils {
    static final int BD_ADDR_LEN = 6;
    static final int BD_UUID_LEN = 16;

    private Utils() {
    }

    public static int byteArrayToInt(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length == 1) {
            return bArr[0] & 255;
        }
        if (bArr.length == 2) {
            return ((bArr[0] & 255) << 8) | (bArr[1] & 255);
        } else if (bArr.length == 3) {
            return ((bArr[0] & 255) << 16) | (bArr[2] & 255) | ((bArr[1] & 255) << 8);
        } else {
            return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
        }
    }

    public static int byteToInt(byte b) {
        return b & 255;
    }

    public static String bytes2HexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String bytesToHexString(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < bArr.length; i++) {
            sb.append("0x");
            String hexString = Integer.toHexString(bArr[i] & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
            if (i != bArr.length - 1) {
                sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
            }
        }
        return sb.toString();
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static byte[] generateSalt() {
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            str = Build.DEVICE;
        }
        return str.getBytes();
    }

    public static byte[] generateSaltFromSerial() {
        String str = Build.SERIAL;
        if (TextUtils.isEmpty(str)) {
            str = Build.DEVICE;
        }
        return str.getBytes();
    }

    @NonNull
    public static byte[] generateUniqueID(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[]{2, 0, 0, 0, 0, 0};
        }
        return generateUniqueID(str, generateSalt());
    }

    public static byte[] generateUniqueIDBySerial(String str) {
        return TextUtils.isEmpty(str) ? new byte[]{2, 0, 0, 0, 0, 0} : generateUniqueID(str, generateSaltFromSerial());
    }

    public static String getAddressStringFromByte(byte[] bArr) {
        if (bArr == null || bArr.length != 6) {
            return null;
        }
        return String.format("%02X:%02X:%02X:%02X:%02X:%02X", new Object[]{Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[4]), Byte.valueOf(bArr[5])});
    }

    public static byte[] getBytesFromAddress(String str) {
        int i = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[6];
        int i2 = 0;
        while (i < str.length()) {
            if (str.charAt(i) != ':') {
                bArr[i2] = (byte) Integer.parseInt(str.substring(i, i + 2), 16);
                i2++;
                i++;
            }
            i++;
        }
        return bArr;
    }

    public static String getRandomMac() {
        SecureRandom secureRandom;
        StringBuilder sb = new StringBuilder();
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException unused) {
            secureRandom = new SecureRandom();
        }
        for (int i = 0; i < 6; i++) {
            if (sb.length() > 0) {
                sb.append(AccountConstantKt.CODE_SEPARTOR);
            }
            String hexString = Integer.toHexString(secureRandom.nextInt(256));
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        String sb2 = sb.toString();
        return BleUtil.DEFAULT_ADDRESS.equals(sb2) ? getRandomMac() : sb2;
    }

    public static String getRandomString(int i) {
        try {
            SecureRandom instanceStrong = SecureRandom.getInstanceStrong();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(instanceStrong.nextInt(62)));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String getRing2DeviceVersion(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null) {
            return "";
        }
        int i = 1;
        while (i < 5) {
            sb.append(Integer.toHexString(bArr[i] & 255));
            sb.append(i == 4 ? "" : ".");
            i++;
        }
        return sb.length() <= 0 ? "" : sb.toString();
    }

    public static boolean hasMessyCode(String str) {
        char[] charArray = Pattern.compile("\\s*|\t*|\r*|\n*").matcher(str).replaceAll("").replaceAll("\\p{P}", "").trim().toCharArray();
        float f = 0.0f;
        float f2 = 0.0f;
        for (char c : charArray) {
            if (!Character.isLetterOrDigit(c)) {
                if (!isChinese(c)) {
                    f2 += 1.0f;
                }
                f += 1.0f;
            }
        }
        return f > 0.0f && f2 / f > 0.4f;
    }

    public static byte[] hexString2Bytes(String str) {
        if (str == null || str.equals("") || str.length() % 2 != 0) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = upperCase.toCharArray();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((charToByte(charArray[i2 + 1]) & 255) | (charToByte(charArray[i2]) << 4));
        }
        return bArr;
    }

    public static byte intToByte(int i) {
        return (byte) i;
    }

    public static byte[] intToByteArray(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private static boolean isChinese(char c) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c);
        return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static byte[] stringToByteArrayWithPadding(String str) {
        byte[] bArr = new byte[6];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    private static byte[] generateUniqueID(String str, byte[] bArr) {
        byte[] bArr2 = new byte[(str.length() + bArr.length)];
        System.arraycopy(str.getBytes(), 0, bArr2, 0, str.length());
        System.arraycopy(bArr, 0, bArr2, str.length(), bArr.length);
        try {
            byte[] bArr3 = new byte[6];
            System.arraycopy(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(bArr2), 0, bArr3, 0, 6);
            return bArr3;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return stringToByteArrayWithPadding(str);
        }
    }
}
