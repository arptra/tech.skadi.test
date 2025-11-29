package com.upuphone.ar.translation.ext;

import android.util.Log;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.star.core.log.ULog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a)\u0010\u0007\u001a\u00020\u0002*\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a7\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u000e\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u0004\u001a\u0011\u0010\u000f\u001a\u00020\u0002*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0013\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0017\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0017\u0010\u0004\u001a\u0019\u0010\u0018\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0004\u001a\u0019\u0010\u0019\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u0004\" \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001b¨\u0006\u001d"}, d2 = {"", "tag", "", "c", "(Ljava/lang/String;Ljava/lang/String;)V", "", "tr", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "", "logType", "data", "b", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "g", "i", "(Ljava/lang/String;)V", "key", "count", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "a", "()V", "j", "k", "h", "", "Ljava/util/Map;", "logCountMap", "ar-translator_intlRelease"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nLogExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LogExt.kt\ncom/upuphone/ar/translation/ext/LogExt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,451:1\n151#2,6:452\n151#2,6:458\n*S KotlinDebug\n*F\n+ 1 LogExt.kt\ncom/upuphone/ar/translation/ext/LogExt\n*L\n206#1:452,6\n214#1:458,6\n*E\n"})
@JvmName(name = "LogExt")
public final class LogExt {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f6207a = new LinkedHashMap();

    public static final void a() {
        f6207a.clear();
    }

    public static final void b(int i, String str, String str2, Throwable th) {
        String str3;
        String str4;
        int i2 = i;
        String str5 = str2;
        Throwable th2 = th;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length == 0 || stackTrace.length < 5) {
            str3 = "TrsP-StringExt";
            str4 = "NotMethodName";
        } else {
            StackTraceElement stackTraceElement = stackTrace[5];
            String className = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
            int i3 = -1;
            if (StringsKt.contains$default((CharSequence) className, (CharSequence) ".", false, 2, (Object) null)) {
                String className2 = stackTraceElement.getClassName();
                Intrinsics.checkNotNullExpressionValue(className2, "getClassName(...)");
                str3 = StringsKt.substringAfterLast$default(className2, ".", (String) null, 2, (Object) null);
                if (StringsKt.contains$default((CharSequence) str3, (CharSequence) "$", false, 2, (Object) null)) {
                    int length = str3.length();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            i4 = -1;
                            break;
                        } else if (str3.charAt(i4) == '$') {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    str3 = str3.substring(0, i4);
                    Intrinsics.checkNotNullExpressionValue(str3, "substring(...)");
                }
            } else {
                str3 = stackTraceElement.getClassName();
                Intrinsics.checkNotNull(str3);
            }
            String methodName = stackTraceElement.getMethodName();
            Intrinsics.checkNotNullExpressionValue(methodName, "getMethodName(...)");
            if (StringsKt.contains$default((CharSequence) methodName, (CharSequence) "$", false, 2, (Object) null)) {
                String methodName2 = stackTraceElement.getMethodName();
                Intrinsics.checkNotNullExpressionValue(methodName2, "getMethodName(...)");
                int length2 = methodName2.length();
                int i5 = 0;
                while (true) {
                    if (i5 >= length2) {
                        break;
                    } else if (methodName2.charAt(i5) == '$') {
                        i3 = i5;
                        break;
                    } else {
                        i5++;
                    }
                }
                String methodName3 = stackTraceElement.getMethodName();
                Intrinsics.checkNotNullExpressionValue(methodName3, "getMethodName(...)");
                str4 = methodName3.substring(0, i3);
                Intrinsics.checkNotNullExpressionValue(str4, "substring(...)");
            } else {
                str4 = stackTraceElement.getMethodName();
                Intrinsics.checkNotNull(str4);
            }
        }
        String str6 = (str == null || StringsKt.isBlank(str)) ? str3 : str;
        if (i2 == 2) {
            Log.v(str6, "[" + str3 + "][" + str4 + "]:: " + str5, th2);
        } else if (i2 == 3) {
            Log.d(str6, "[" + str3 + "][" + str4 + "]:: " + str5, th2);
        } else if (i2 == 4) {
            Log.i(str6, "[" + str3 + "][" + str4 + "]:: " + str5, th2);
        } else if (i2 == 5) {
            Log.w(str6, "[" + str3 + "][" + str4 + "]:: " + str5, th2);
        } else if (i2 == 6) {
            Log.e(str6, "[" + str3 + "][" + str4 + "]:: " + str5, th2);
        }
    }

    public static final void c(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        d(str, str2, (Throwable) null);
    }

    public static final void d(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        b(4, TranslatorConstants.TAG_PREFIX + str2, str, th);
    }

    public static final void e(String str, String str2, String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        Intrinsics.checkNotNullParameter(str3, IntentKey.ACTIVITY.ACTION_KEY);
        Map map = f6207a;
        if (map.containsKey(str3)) {
            Object obj = map.get(str3);
            Intrinsics.checkNotNull(obj);
            int intValue = ((Number) obj).intValue() + 1;
            map.put(str3, Integer.valueOf(intValue));
            if (intValue == i) {
                map.put(str3, 0);
            }
        } else {
            map.put(str3, 0);
        }
        Integer num = (Integer) map.get(str3);
        if (num != null && num.intValue() == 0) {
            j(str, str2);
        }
    }

    public static /* synthetic */ void f(String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 100;
        }
        e(str, str2, str3, i);
    }

    public static final void g(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TranslatorConstants.TAG_PREFIX + str2, str);
    }

    public static final void h(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c(TranslatorConstants.TAG_PREFIX + str2, str);
    }

    public static final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ULog.f6446a.f(str);
    }

    public static final void j(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g(TranslatorConstants.TAG_PREFIX + str2, str);
    }

    public static final void k(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o(TranslatorConstants.TAG_PREFIX + str2, str);
    }
}
