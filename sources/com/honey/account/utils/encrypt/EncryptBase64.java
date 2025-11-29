package com.honey.account.utils.encrypt;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000fJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/honey/account/utils/encrypt/EncryptBase64;", "", "mPrivateKey", "", "(Ljava/lang/String;)V", "BASE64_TABLE", "", "LAST2BYTE", "", "LAST4BYTE", "LAST6BYTE", "mBase64Table", "getMPrivateKey", "()Ljava/lang/String;", "offset", "", "base64To256", "base64", "", "decode", "", "data", "len", "encode", "contents", "initPrivateTable", "", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EncryptBase64 {
    @NotNull
    private final char[] BASE64_TABLE = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private final char LAST2BYTE = ((char) Integer.parseInt("00000011", CharsKt.checkRadix(2)));
    private final char LAST4BYTE = ((char) Integer.parseInt("00001111", CharsKt.checkRadix(2)));
    private final char LAST6BYTE = ((char) Integer.parseInt("00111111", CharsKt.checkRadix(2)));
    private char[] mBase64Table;
    @NotNull
    private final String mPrivateKey;
    private int offset;

    public EncryptBase64(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "mPrivateKey");
        this.mPrivateKey = str;
        initPrivateTable();
    }

    private final int base64To256(byte b) {
        if (b >= 65 && b <= 90) {
            char[] cArr = this.BASE64_TABLE;
            return ((b - 65) + (cArr.length - this.offset)) % cArr.length;
        } else if (b >= 97 && b <= 122) {
            char[] cArr2 = this.BASE64_TABLE;
            return ((b - 71) + (cArr2.length - this.offset)) % cArr2.length;
        } else if (b >= 48 && b <= 57) {
            char[] cArr3 = this.BASE64_TABLE;
            return ((b + 4) + (cArr3.length - this.offset)) % cArr3.length;
        } else if (b == 43) {
            char[] cArr4 = this.BASE64_TABLE;
            return ((cArr4.length - this.offset) + 62) % cArr4.length;
        } else if (b != 47) {
            return 64;
        } else {
            char[] cArr5 = this.BASE64_TABLE;
            return ((cArr5.length - this.offset) + 63) % cArr5.length;
        }
    }

    private final void initPrivateTable() {
        char[] cArr = new char[this.BASE64_TABLE.length];
        this.offset = this.mPrivateKey.charAt(0) % 13;
        int length = this.BASE64_TABLE.length;
        for (int i = 0; i < length; i++) {
            char[] cArr2 = this.BASE64_TABLE;
            cArr[i] = cArr2[(this.offset + i) % cArr2.length];
        }
        this.mBase64Table = cArr;
    }

    @NotNull
    public final byte[] decode(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        StringBuilder sb = new StringBuilder((i * 3) / 4);
        int[] iArr = new int[4];
        int i2 = 0;
        while (i2 < i) {
            int i3 = 0;
            while (i3 < 4) {
                iArr[i3] = base64To256(bArr[i2]);
                i3++;
                i2++;
            }
            sb.append((char) (((iArr[0] << 2) | iArr[1]) >>> 4));
            int i4 = iArr[2];
            if (i4 != 64) {
                sb.append((char) ((i4 | ((iArr[1] & this.LAST4BYTE) << 4)) >>> 2));
            }
            int i5 = iArr[3];
            if (i5 != 64) {
                sb.append((char) (i5 | ((iArr[2] & this.LAST2BYTE) << 6)));
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        Charset forName = Charset.forName("ISO8859-1");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
        byte[] bytes = sb2.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    @Nullable
    public final String encode(@Nullable byte[] bArr) {
        char[] cArr = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(((bArr.length + 2) / 3) * 4);
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            char c = bArr[i] & 255;
            if (i2 == length) {
                char[] cArr2 = this.mBase64Table;
                if (cArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBase64Table");
                    cArr2 = null;
                }
                sb.append(cArr2[c >>> 2]);
                char[] cArr3 = this.mBase64Table;
                if (cArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBase64Table");
                } else {
                    cArr = cArr3;
                }
                sb.append(cArr[(this.LAST2BYTE & c) << 4]);
                sb.append("==");
            } else {
                int i3 = i + 2;
                char c2 = bArr[i2] & 255;
                if (i3 == length) {
                    char[] cArr4 = this.mBase64Table;
                    if (cArr4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBase64Table");
                        cArr4 = null;
                    }
                    sb.append(cArr4[c >>> 2]);
                    char[] cArr5 = this.mBase64Table;
                    if (cArr5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBase64Table");
                        cArr5 = null;
                    }
                    sb.append(cArr5[((this.LAST2BYTE & c) << 4) | (c2 >>> 4)]);
                    char[] cArr6 = this.mBase64Table;
                    if (cArr6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBase64Table");
                    } else {
                        cArr = cArr6;
                    }
                    sb.append(cArr[(this.LAST4BYTE & c2) << 2]);
                    sb.append("=");
                } else {
                    i += 3;
                    char c3 = bArr[i3] & 255;
                    char[] cArr7 = this.mBase64Table;
                    if (cArr7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBase64Table");
                        cArr7 = null;
                    }
                    sb.append(cArr7[c >>> 2]);
                    char[] cArr8 = this.mBase64Table;
                    if (cArr8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBase64Table");
                        cArr8 = null;
                    }
                    sb.append(cArr8[((c & this.LAST2BYTE) << 4) | (c2 >>> 4)]);
                    char[] cArr9 = this.mBase64Table;
                    if (cArr9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBase64Table");
                        cArr9 = null;
                    }
                    sb.append(cArr9[((c2 & this.LAST4BYTE) << 2) | (c3 >>> 6)]);
                    char[] cArr10 = this.mBase64Table;
                    if (cArr10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBase64Table");
                        cArr10 = null;
                    }
                    sb.append(cArr10[this.LAST6BYTE & c3]);
                }
            }
        }
        return sb.toString();
    }

    @NotNull
    public final String getMPrivateKey() {
        return this.mPrivateKey;
    }
}
