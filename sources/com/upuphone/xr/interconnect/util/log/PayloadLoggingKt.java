package com.upuphone.xr.interconnect.util.log;

import com.google.protobuf.ByteString;
import com.meizu.common.widget.CircularProgressButton;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Marker;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0006\u001a\u0018\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\f\u0010\u0011\u001a\u00020\u0004*\u00020\u0004H\u0000\u001a\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0004*\u00020\u0006H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0004*\u00020\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\")\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005*\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\")\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005*\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\n¨\u0006\u0015"}, d2 = {"SAMPLE_LENGTH", "", "appendSize", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/google/protobuf/ByteString;", "getAppendSize", "(Lcom/google/protobuf/ByteString;)Lkotlin/jvm/functions/Function1;", "", "([B)Lkotlin/jvm/functions/Function1;", "string", "size", "hexPrint", "byte", "", "humanPrint", "limitSizePrint", "readableSamplePrint", "sampleLength", "samplePrint", "SharedImpl_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class PayloadLoggingKt {
    private static final int SAMPLE_LENGTH = 10;

    /* access modifiers changed from: private */
    public static final String appendSize(String str, int i) {
        if (i <= 10) {
            return str;
        }
        return str + Marker.ANY_NON_NULL_MARKER + (i - 10) + "B";
    }

    private static final Function1<String, String> getAppendSize(byte[] bArr) {
        return new PayloadLoggingKt$appendSize$1(bArr);
    }

    /* access modifiers changed from: private */
    public static final String hexPrint(byte b) {
        return StringsKt.padStart(UStringsKt.m1324toStringLxnNnR4(UByte.m38constructorimpl(b), 16), 2, '0');
    }

    /* access modifiers changed from: private */
    public static final String humanPrint(byte b) {
        if (34 <= b && b < Byte.MAX_VALUE) {
            return String.valueOf((char) b);
        }
        String hexPrint = hexPrint(b);
        return "!" + hexPrint;
    }

    @NotNull
    public static final String limitSizePrint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String substring = str.substring(0, Integer.min(str.length(), CircularProgressButton.MorphingAnimation.DURATION_NORMAL));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    @NotNull
    public static final String readableSamplePrint(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] copyOf = Arrays.copyOf(bArr, Integer.min(bArr.length, i));
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return ArraysKt.joinToString$default(copyOf, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) PayloadLoggingKt$readableSamplePrint$1.INSTANCE, 30, (Object) null);
    }

    @NotNull
    public static final String samplePrint(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Function1<String, String> appendSize = getAppendSize(bArr);
        byte[] copyOf = Arrays.copyOf(bArr, Integer.min(bArr.length, 10));
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return appendSize.invoke(ArraysKt.joinToString$default(copyOf, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) PayloadLoggingKt$samplePrint$1.INSTANCE, 30, (Object) null));
    }

    private static final Function1<String, String> getAppendSize(ByteString byteString) {
        return new PayloadLoggingKt$appendSize$2(byteString);
    }

    @NotNull
    public static final String samplePrint(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Function1<String, String> appendSize = getAppendSize(byteString);
        ByteString substring = byteString.substring(0, Integer.min(byteString.size(), 10));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return appendSize.invoke(CollectionsKt.joinToString$default(substring, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, PayloadLoggingKt$samplePrint$2.INSTANCE, 30, (Object) null));
    }
}
