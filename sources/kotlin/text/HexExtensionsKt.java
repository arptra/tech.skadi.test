package kotlin.text;

import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.HexFormat;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0004\u001a \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002\u001a@\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0000\u001a@\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0000\u001a \u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002\u001a,\u0010\u0016\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0003H\u0002\u001a,\u0010\u001b\u001a\u00020\u001c*\u00020\u00032\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0002\u001a\u001c\u0010!\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0002\u001a\u0014\u0010\"\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\tH\u0002\u001a*\u0010#\u001a\u00020$*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010#\u001a\u00020$*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a*\u0010'\u001a\u00020(*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010'\u001a\u00020(*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a*\u0010)\u001a\u00020\t*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010)\u001a\u00020\t*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a*\u0010*\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010*\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a0\u0010+\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\tH\u0003\u001a*\u0010,\u001a\u00020-*\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0003\u001a\u0016\u0010,\u001a\u00020-*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a*\u0010.\u001a\u00020\u0003*\u00020(2\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020(2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020\t2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020\u00062\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u0016\u0010.\u001a\u00020\u0003*\u00020-2\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a\u001c\u0010/\u001a\u00020\u0003*\u00020\u00062\u0006\u0010%\u001a\u00020&2\u0006\u00100\u001a\u00020\tH\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"HEX_DIGITS_TO_DECIMAL", "", "LOWER_CASE_HEX_DIGITS", "", "UPPER_CASE_HEX_DIGITS", "charsPerSet", "", "charsPerElement", "elementsPerSet", "", "elementSeparatorLength", "formattedStringLength", "totalBytes", "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "parsedByteArrayMaxSize", "stringLength", "wholeElementsPerSet", "checkContainsAt", "part", "index", "endIndex", "partName", "checkHexLength", "", "startIndex", "maxDigits", "requireMaxLength", "", "checkNewLineAt", "decimalFromHexDigitAt", "hexToByte", "", "format", "Lkotlin/text/HexFormat;", "hexToByteArray", "", "hexToInt", "hexToLong", "hexToLongImpl", "hexToShort", "", "toHexString", "toHexStringImpl", "bits", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHexExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,591:1\n1#2:592\n1183#3,3:593\n1183#3,3:596\n*S KotlinDebug\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n*L\n13#1:593,3\n14#1:596,3\n*E\n"})
public final class HexExtensionsKt {
    @NotNull
    private static final int[] HEX_DIGITS_TO_DECIMAL;
    @NotNull
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";
    @NotNull
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";

    static {
        int[] iArr = new int[128];
        int i = 0;
        for (int i2 = 0; i2 < 128; i2++) {
            iArr[i2] = -1;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < LOWER_CASE_HEX_DIGITS.length()) {
            iArr[LOWER_CASE_HEX_DIGITS.charAt(i3)] = i4;
            i3++;
            i4++;
        }
        int i5 = 0;
        while (i < UPPER_CASE_HEX_DIGITS.length()) {
            iArr[UPPER_CASE_HEX_DIGITS.charAt(i)] = i5;
            i++;
            i5++;
        }
        HEX_DIGITS_TO_DECIMAL = iArr;
    }

    private static final long charsPerSet(long j, int i, int i2) {
        if (i > 0) {
            long j2 = (long) i;
            return (j * j2) + (((long) i2) * (j2 - 1));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final int checkContainsAt(String str, String str2, int i, int i2, String str3) {
        int length = str2.length() + i;
        if (length <= i2) {
            if (StringsKt.regionMatches(str, i, str2, 0, str2.length(), true)) {
                return length;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected ");
        sb.append(str3);
        sb.append(" \"");
        sb.append(str2);
        sb.append("\" at index ");
        sb.append(i);
        sb.append(", but was ");
        int coerceAtMost = RangesKt.coerceAtMost(length, i2);
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, coerceAtMost);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        sb.append(substring);
        throw new NumberFormatException(sb.toString());
    }

    private static final void checkHexLength(String str, int i, int i2, int i3, boolean z) {
        int i4 = i2 - i;
        if (z) {
            if (i4 == i3) {
                return;
            }
        } else if (i4 <= i3) {
            return;
        }
        String str2 = z ? "exactly" : "at most";
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + ' ' + i3 + " hexadecimal digits at index " + i + ", but was " + substring + " of length " + i4);
    }

    private static final int checkNewLineAt(String str, int i, int i2) {
        if (str.charAt(i) == 13) {
            int i3 = i + 1;
            return (i3 >= i2 || str.charAt(i3) != 10) ? i3 : i + 2;
        } else if (str.charAt(i) == 10) {
            return i + 1;
        } else {
            throw new NumberFormatException("Expected a new line at index " + i + ", but was " + str.charAt(i));
        }
    }

    private static final int decimalFromHexDigitAt(String str, int i) {
        int i2;
        char charAt = str.charAt(i);
        if (charAt <= 127 && (i2 = HEX_DIGITS_TO_DECIMAL[charAt]) >= 0) {
            return i2;
        }
        throw new NumberFormatException("Expected a hexadecimal digit at index " + i + ", but was " + str.charAt(i));
    }

    public static final int formattedStringLength(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i > 0) {
            int i8 = i - 1;
            int i9 = i8 / i2;
            int i10 = (i2 - 1) / i3;
            int i11 = i % i2;
            if (i11 != 0) {
                i2 = i11;
            }
            int i12 = (i10 * i9) + ((i2 - 1) / i3);
            long j = ((long) i9) + (((long) i12) * ((long) i4)) + (((long) ((i8 - i9) - i12)) * ((long) i5)) + (((long) i) * (((long) i6) + 2 + ((long) i7)));
            if (RangesKt.intRangeContains((ClosedRange<Integer>) new IntRange(0, Integer.MAX_VALUE), j)) {
                return (int) j;
            }
            throw new IllegalArgumentException("The resulting string length is too big: " + ULong.m240toStringimpl(ULong.m194constructorimpl(j)));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final byte hexToByte(@NotNull String str, @NotNull HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(hexFormat, "format");
        return hexToByte(str, 0, str.length(), hexFormat);
    }

    public static /* synthetic */ byte hexToByte$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToByte(str, hexFormat);
    }

    @NotNull
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final byte[] hexToByteArray(@NotNull String str, @NotNull HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(hexFormat, "format");
        return hexToByteArray(str, 0, str.length(), hexFormat);
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToByteArray(str, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final int hexToInt(@NotNull String str, @NotNull HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(hexFormat, "format");
        return hexToInt(str, 0, str.length(), hexFormat);
    }

    public static /* synthetic */ int hexToInt$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToInt(str, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final long hexToLong(@NotNull String str, @NotNull HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(hexFormat, "format");
        return hexToLong(str, 0, str.length(), hexFormat);
    }

    public static /* synthetic */ long hexToLong$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToLong(str, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final long hexToLongImpl(String str, int i, int i2, HexFormat hexFormat, int i3) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        String prefix = hexFormat.getNumber().getPrefix();
        String suffix = hexFormat.getNumber().getSuffix();
        if (prefix.length() + suffix.length() < i2 - i) {
            int checkContainsAt = checkContainsAt(str, prefix, i, i2, "prefix");
            int length = i2 - suffix.length();
            checkContainsAt(str, suffix, length, i2, "suffix");
            checkHexLength(str, checkContainsAt, length, i3, false);
            long j = 0;
            while (checkContainsAt < length) {
                j = (j << 4) | ((long) decimalFromHexDigitAt(str, checkContainsAt));
                checkContainsAt++;
            }
            return j;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected a hexadecimal number with prefix \"");
        sb.append(prefix);
        sb.append("\" and suffix \"");
        sb.append(suffix);
        sb.append("\", but was ");
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        sb.append(substring);
        throw new NumberFormatException(sb.toString());
    }

    public static /* synthetic */ long hexToLongImpl$default(String str, int i, int i2, HexFormat hexFormat, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = str.length();
        }
        return hexToLongImpl(str, i, i2, hexFormat, i3);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final short hexToShort(@NotNull String str, @NotNull HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(hexFormat, "format");
        return hexToShort(str, 0, str.length(), hexFormat);
    }

    public static /* synthetic */ short hexToShort$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToShort(str, hexFormat);
    }

    public static final int parsedByteArrayMaxSize(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        long j;
        int i8;
        int i9;
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        if (i10 > 0) {
            long j2 = ((long) i6) + 2 + ((long) i7);
            long charsPerSet = charsPerSet(j2, i12, i14);
            if (i11 <= i12) {
                j = charsPerSet(j2, i11, i14);
            } else {
                j = charsPerSet(charsPerSet, i11 / i12, i13);
                int i15 = i11 % i12;
                if (i15 != 0) {
                    j = j + ((long) i13) + charsPerSet(j2, i15, i14);
                }
            }
            long j3 = (long) i10;
            long wholeElementsPerSet = wholeElementsPerSet(j3, j, 1);
            long j4 = j3 - ((j + 1) * wholeElementsPerSet);
            long wholeElementsPerSet2 = wholeElementsPerSet(j4, charsPerSet, i13);
            long j5 = j4 - ((charsPerSet + ((long) i13)) * wholeElementsPerSet2);
            long wholeElementsPerSet3 = wholeElementsPerSet(j5, j2, i14);
            if (j5 - ((j2 + ((long) i14)) * wholeElementsPerSet3) > 0) {
                i8 = i2;
                i9 = 1;
            } else {
                i9 = 0;
                i8 = i2;
            }
            return (int) ((wholeElementsPerSet * ((long) i8)) + (wholeElementsPerSet2 * ((long) i12)) + wholeElementsPerSet3 + ((long) i9));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @NotNull
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(@NotNull byte[] bArr, @NotNull HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(hexFormat, "format");
        return toHexString(bArr, 0, bArr.length, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return toHexString(bArr, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final String toHexStringImpl(long j, HexFormat hexFormat, int i) {
        if ((i & 3) == 0) {
            String str = hexFormat.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
            String prefix = hexFormat.getNumber().getPrefix();
            String suffix = hexFormat.getNumber().getSuffix();
            boolean removeLeadingZeros = hexFormat.getNumber().getRemoveLeadingZeros();
            StringBuilder sb = new StringBuilder(prefix.length() + (i >> 2) + suffix.length());
            sb.append(prefix);
            while (i > 0) {
                i -= 4;
                int i2 = (int) ((j >> i) & 15);
                removeLeadingZeros = removeLeadingZeros && i2 == 0 && i > 0;
                if (!removeLeadingZeros) {
                    sb.append(str.charAt(i2));
                }
            }
            sb.append(suffix);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final long wholeElementsPerSet(long j, long j2, int i) {
        if (j <= 0 || j2 <= 0) {
            return 0;
        }
        long j3 = (long) i;
        return (j + j3) / (j2 + j3);
    }

    @ExperimentalStdlibApi
    private static final byte hexToByte(String str, int i, int i2, HexFormat hexFormat) {
        return (byte) ((int) hexToLongImpl(str, i, i2, hexFormat, 2));
    }

    public static /* synthetic */ byte hexToByte$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToByte(str, i, i2, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArray(String str, int i, int i2, HexFormat hexFormat) {
        int i3;
        String str2 = str;
        int i4 = i;
        int i5 = i2;
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i4, i5, str.length());
        if (i4 == i5) {
            return new byte[0];
        }
        HexFormat.BytesHexFormat bytes = hexFormat.getBytes();
        int bytesPerLine = bytes.getBytesPerLine();
        int bytesPerGroup = bytes.getBytesPerGroup();
        String bytePrefix = bytes.getBytePrefix();
        String byteSuffix = bytes.getByteSuffix();
        String byteSeparator = bytes.getByteSeparator();
        String groupSeparator = bytes.getGroupSeparator();
        String str3 = byteSeparator;
        int parsedByteArrayMaxSize = parsedByteArrayMaxSize(i5 - i4, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        byte[] bArr = new byte[parsedByteArrayMaxSize];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i3 < i5) {
            if (i7 == bytesPerLine) {
                i3 = checkNewLineAt(str2, i3, i5);
                i7 = 0;
            } else if (i8 == bytesPerGroup) {
                i3 = checkContainsAt(str2, groupSeparator, i3, i5, "group separator");
            } else {
                if (i8 != 0) {
                    i3 = checkContainsAt(str2, str3, i3, i5, "byte separator");
                }
                i7++;
                i8++;
                int checkContainsAt = checkContainsAt(str2, bytePrefix, i3, i5, "byte prefix");
                checkHexLength(str2, checkContainsAt, RangesKt.coerceAtMost(checkContainsAt + 2, i5), 2, true);
                bArr[i6] = (byte) ((decimalFromHexDigitAt(str2, checkContainsAt) << 4) | decimalFromHexDigitAt(str2, checkContainsAt + 1));
                i4 = checkContainsAt(str2, byteSuffix, checkContainsAt + 2, i5, "byte suffix");
                i6++;
                str3 = str3;
            }
            i8 = 0;
            i7++;
            i8++;
            int checkContainsAt2 = checkContainsAt(str2, bytePrefix, i3, i5, "byte prefix");
            checkHexLength(str2, checkContainsAt2, RangesKt.coerceAtMost(checkContainsAt2 + 2, i5), 2, true);
            bArr[i6] = (byte) ((decimalFromHexDigitAt(str2, checkContainsAt2) << 4) | decimalFromHexDigitAt(str2, checkContainsAt2 + 1));
            i4 = checkContainsAt(str2, byteSuffix, checkContainsAt2 + 2, i5, "byte suffix");
            i6++;
            str3 = str3;
        }
        if (i6 == parsedByteArrayMaxSize) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i6);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToByteArray(str, i, i2, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final int hexToInt(String str, int i, int i2, HexFormat hexFormat) {
        return (int) hexToLongImpl(str, i, i2, hexFormat, 8);
    }

    public static /* synthetic */ int hexToInt$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToInt(str, i, i2, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final long hexToLong(String str, int i, int i2, HexFormat hexFormat) {
        return hexToLongImpl(str, i, i2, hexFormat, 16);
    }

    public static /* synthetic */ long hexToLong$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToLong(str, i, i2, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final short hexToShort(String str, int i, int i2, HexFormat hexFormat) {
        return (short) ((int) hexToLongImpl(str, i, i2, hexFormat, 4));
    }

    public static /* synthetic */ short hexToShort$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToShort(str, i, i2, hexFormat);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0083 A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    @kotlin.SinceKotlin(version = "1.9")
    @kotlin.ExperimentalStdlibApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String toHexString(@org.jetbrains.annotations.NotNull byte[] r17, int r18, int r19, @org.jetbrains.annotations.NotNull kotlin.text.HexFormat r20) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "format"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            kotlin.collections.AbstractList$Companion r3 = kotlin.collections.AbstractList.Companion
            int r5 = r0.length
            r3.checkBoundsIndexes$kotlin_stdlib(r1, r2, r5)
            if (r1 != r2) goto L_0x001d
            java.lang.String r0 = ""
            return r0
        L_0x001d:
            boolean r3 = r20.getUpperCase()
            if (r3 == 0) goto L_0x0026
            java.lang.String r3 = "0123456789ABCDEF"
            goto L_0x0028
        L_0x0026:
            java.lang.String r3 = "0123456789abcdef"
        L_0x0028:
            kotlin.text.HexFormat$BytesHexFormat r4 = r20.getBytes()
            int r12 = r4.getBytesPerLine()
            int r13 = r4.getBytesPerGroup()
            java.lang.String r14 = r4.getBytePrefix()
            java.lang.String r15 = r4.getByteSuffix()
            java.lang.String r11 = r4.getByteSeparator()
            java.lang.String r4 = r4.getGroupSeparator()
            int r5 = r2 - r1
            int r8 = r4.length()
            int r9 = r11.length()
            int r10 = r14.length()
            int r16 = r15.length()
            r6 = r12
            r7 = r13
            r1 = r11
            r11 = r16
            int r5 = formattedStringLength(r5, r6, r7, r8, r9, r10, r11)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r8 = r18
            r9 = 0
            r10 = 0
        L_0x0068:
            if (r8 >= r2) goto L_0x00a2
            byte r11 = r0[r8]
            r7 = r11 & 255(0xff, float:3.57E-43)
            if (r9 != r12) goto L_0x0078
            r9 = 10
            r6.append(r9)
            r9 = 0
        L_0x0076:
            r10 = 0
            goto L_0x007e
        L_0x0078:
            if (r10 != r13) goto L_0x007e
            r6.append(r4)
            goto L_0x0076
        L_0x007e:
            if (r10 == 0) goto L_0x0083
            r6.append(r1)
        L_0x0083:
            r6.append(r14)
            int r7 = r7 >> 4
            char r7 = r3.charAt(r7)
            r6.append(r7)
            r7 = r11 & 15
            char r7 = r3.charAt(r7)
            r6.append(r7)
            r6.append(r15)
            int r10 = r10 + 1
            int r9 = r9 + 1
            int r8 = r8 + 1
            goto L_0x0068
        L_0x00a2:
            int r0 = r6.length()
            if (r5 != r0) goto L_0x00b2
            java.lang.String r0 = r6.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        L_0x00b2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Check failed."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.HexExtensionsKt.toHexString(byte[], int, int, kotlin.text.HexFormat):java.lang.String");
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return toHexString(bArr, i, i2, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(byte b, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return toHexString(b, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(short s, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return toHexString(s, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(int i, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return toHexString(i, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(long j, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return toHexString(j, hexFormat);
    }

    @NotNull
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(byte b, @NotNull HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(hexFormat, "format");
        return toHexStringImpl((long) b, hexFormat, 8);
    }

    @NotNull
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(short s, @NotNull HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(hexFormat, "format");
        return toHexStringImpl((long) s, hexFormat, 16);
    }

    @NotNull
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(int i, @NotNull HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(hexFormat, "format");
        return toHexStringImpl((long) i, hexFormat, 32);
    }

    @NotNull
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(long j, @NotNull HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(hexFormat, "format");
        return toHexStringImpl(j, hexFormat, 64);
    }
}
