package com.rousetime.android_startup.utils;

import android.util.Log;
import com.rousetime.android_startup.model.LoggerLevel;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\n\u0010\tJ)\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/rousetime/android_startup/utils/StartupLogUtils;", "", "<init>", "()V", "Lkotlin/Function0;", "", "block", "", "c", "(Lkotlin/jvm/functions/Function0;)V", "b", "", "priority", "tag", "content", "d", "(ILjava/lang/String;Ljava/lang/String;)V", "", "bytes", "subLength", "a", "([BI)Ljava/lang/String;", "Lcom/rousetime/android_startup/model/LoggerLevel;", "Lcom/rousetime/android_startup/model/LoggerLevel;", "getLevel", "()Lcom/rousetime/android_startup/model/LoggerLevel;", "e", "(Lcom/rousetime/android_startup/model/LoggerLevel;)V", "level", "android-startup_release"}, k = 1, mv = {1, 4, 0})
public final class StartupLogUtils {

    /* renamed from: a  reason: collision with root package name */
    public static LoggerLevel f9837a = LoggerLevel.NONE;
    public static final StartupLogUtils b = new StartupLogUtils();

    public final String a(byte[] bArr, int i) {
        if (bArr == null || i < 1) {
            return null;
        }
        if (i >= bArr.length) {
            return new String(bArr, Charsets.UTF_8);
        }
        byte[] copyOf = Arrays.copyOf(bArr, i);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "Arrays.copyOf(bytes, subLength)");
        String str = new String(copyOf, Charsets.UTF_8);
        String substring = str.substring(0, str.length() - 1);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final void b(Function0 function0) {
        if (f9837a.compareTo(LoggerLevel.DEBUG) >= 0) {
            d(3, "StartupTrack", (String) function0.invoke());
        }
    }

    public final void c(Function0 function0) {
        if (f9837a.compareTo(LoggerLevel.ERROR) >= 0) {
            d(6, "StartupTrack", (String) function0.invoke());
        }
    }

    public final void d(int i, String str, String str2) {
        if (str2.length() < 1000) {
            Log.println(i, str, str2);
            return;
        }
        byte[] bytes = str2.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        if (4000 >= bytes.length) {
            Log.println(i, str, str2);
            return;
        }
        int i2 = 1;
        while (4000 < bytes.length) {
            String a2 = a(bytes, 4000);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            int i3 = i2 + 1;
            String format = String.format("Block printing(%s):%s", Arrays.copyOf(new Object[]{Integer.valueOf(i2), a2}, 2));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            Log.println(i, str, format);
            if (a2 == null) {
                Intrinsics.throwNpe();
            }
            Charset charset = Charsets.UTF_8;
            if (a2 != null) {
                byte[] bytes2 = a2.getBytes(charset);
                Intrinsics.checkExpressionValueIsNotNull(bytes2, "(this as java.lang.String).getBytes(charset)");
                bytes = ArraysKt.copyOfRange(bytes, bytes2.length, bytes.length);
                i2 = i3;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("Block printing(%s):%s", Arrays.copyOf(new Object[]{Integer.valueOf(i2), new String(bytes, Charsets.UTF_8)}, 2));
        Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
        Log.println(i, str, format2);
    }

    public final void e(LoggerLevel loggerLevel) {
        f9837a = loggerLevel;
    }
}
