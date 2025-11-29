package com.upuphone.ar.transcribe.ext;

import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0002¨\u0006\u0004"}, d2 = {"", "a", "(Ljava/lang/String;)Ljava/lang/String;", "b", "ar-transcribe_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class StringExtKt {
    public static final String a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.isBlank(str)) {
            return str;
        }
        String obj = StringsKt.trim((CharSequence) str).toString();
        char charAt = obj.charAt(0);
        if (('a' > charAt || charAt >= '{') && ('A' > charAt || charAt >= '[')) {
            return obj;
        }
        if ('A' <= charAt && charAt < '[') {
            return obj;
        }
        String valueOf = String.valueOf(charAt);
        String upperCase = valueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        LogExt.d("firstLetterUppercase old=" + valueOf + ", new=" + upperCase, "StringExt");
        return StringsKt.replaceFirst$default(obj, valueOf, upperCase, false, 4, (Object) null);
    }

    public static final String b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        switch (str.hashCode()) {
            case 3121:
                return !str.equals("ar") ? str : "ar-SA";
            case 3179:
                return !str.equals("cn") ? str : "cmn-Hans-CN";
            case 3201:
                return !str.equals("de") ? str : "de-DE";
            case 3241:
                if (!str.equals("en")) {
                    return str;
                }
                break;
            case 3246:
                return !str.equals("es") ? str : AsrConstants.SrcLangType.ES;
            case 3276:
                return !str.equals("fr") ? str : "fr-FR";
            case 3355:
                return !str.equals("id") ? str : "id-ID";
            case 3371:
                return !str.equals("it") ? str : "it-IT";
            case 3383:
                return !str.equals("ja") ? str : "ja-JP";
            case 3428:
                return !str.equals("ko") ? str : "ko-KR";
            case 3494:
                return !str.equals("ms") ? str : "ms-MY";
            case 3651:
                return !str.equals("ru") ? str : AsrConstants.SrcLangType.RU;
            case 3700:
                return !str.equals("th") ? str : "th-TH";
            case 3710:
                return !str.equals("tr") ? str : "tr-TR";
            case 3763:
                return !str.equals("vi") ? str : AsrConstants.SrcLangType.VI;
            case 3058260:
                if (!str.equals("cnen")) {
                    return str;
                }
                break;
            default:
                return str;
        }
        return "en-GB";
    }
}
