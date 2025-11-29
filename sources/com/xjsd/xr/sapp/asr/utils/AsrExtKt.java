package com.xjsd.xr.sapp.asr.utils;

import com.upuphone.star.core.log.ULog;
import com.xjsd.xr.sapp.asr.dao.AsrRequestConfig;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0005H\u0000\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0003\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0003\u001a\n\u0010\t\u001a\u00020\u0003*\u00020\u0003\u001a\n\u0010\n\u001a\u00020\u0003*\u00020\u0003\u001a\n\u0010\u000b\u001a\u00020\u0003*\u00020\u0003\u001a\n\u0010\f\u001a\u00020\u0003*\u00020\b\u001a\n\u0010\r\u001a\u00020\u0003*\u00020\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"HEX_DIGITS", "", "TAG", "", "accessChannelToStr", "", "asrSha256", "hexToByteArray", "", "md5", "mixSpecialData", "sha256", "toHexString", "toRecognizeId", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RecognizeData;", "asr_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAsrExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AsrExt.kt\ncom/xjsd/xr/sapp/asr/utils/AsrExtKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,139:1\n12734#2,3:140\n*S KotlinDebug\n*F\n+ 1 AsrExt.kt\ncom/xjsd/xr/sapp/asr/utils/AsrExtKt\n*L\n90#1:140,3\n*E\n"})
public final class AsrExtKt {
    @NotNull
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    @NotNull
    private static final String TAG = "AsrExt";

    @NotNull
    public static final String accessChannelToStr(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "无效的通道类型" : "佩戴者通道" : "非佩戴者通道" : "双通道" : "无效的通道类型";
    }

    @NotNull
    public static final String asrSha256(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            byte[] bytes = ("RhdNS`Z?" + str).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            instance.update(bytes);
            byte[] digest = instance.digest();
            Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
            return toHexString(digest);
        } catch (NoSuchAlgorithmException e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g(TAG, "获取Sha256加密对象失败！errorMsg=" + ExceptionsKt.stackTraceToString(e));
            return "";
        }
    }

    @NotNull
    public static final byte[] hexToByteArray(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, length), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                bArr[first / 2] = (byte) ((CharsKt.digitToInt(str.charAt(first), 16) << 4) + CharsKt.digitToInt(str.charAt(first + 1), 16));
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        return bArr;
    }

    @NotNull
    public static final String md5(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] digest = instance.digest(bytes);
        Intrinsics.checkNotNull(digest);
        return ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) AsrExtKt$md5$1.INSTANCE, 30, (Object) null);
    }

    @NotNull
    public static final String mixSpecialData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.isBlank(str)) {
            return "#NULL#";
        }
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String hexString = toHexString(bytes);
        if (StringsKt.isBlank(hexString)) {
            return "#NULL#";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            sb.append(String.valueOf(hexString.charAt(i % hexString.length())));
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    @NotNull
    public static final String sha256(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] digest = instance.digest(bytes);
        Intrinsics.checkNotNull(digest);
        String str2 = "";
        for (byte valueOf : digest) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(valueOf)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            sb.append(format);
            str2 = sb.toString();
        }
        return str2;
    }

    @NotNull
    public static final String toHexString(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            char[] cArr = HEX_DIGITS;
            sb.append(cArr[(b & 240) >>> 4]);
            sb.append(cArr[b & 15]);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    @NotNull
    public static final String toRecognizeId(@NotNull AsrRequestConfig.RecognizeData recognizeData) {
        Intrinsics.checkNotNullParameter(recognizeData, "<this>");
        return md5(recognizeData.getAccount() + recognizeData.getDeviceId() + recognizeData.getAppName() + recognizeData.getRecordId() + recognizeData.getCreateTime());
    }
}
