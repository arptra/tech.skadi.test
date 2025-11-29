package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(C)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 176)
@SourceDebugExtension({"SMAP\nCookieUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CookieUtils.kt\nio/ktor/http/CookieUtilsKt$tryParseDayOfMonth$2\n*L\n1#1,349:1\n*E\n"})
public final class CookieUtilsKt$tryParseDayOfMonth$2 extends Lambda implements Function1<Character, Boolean> {
    public static final CookieUtilsKt$tryParseDayOfMonth$2 INSTANCE = new CookieUtilsKt$tryParseDayOfMonth$2();

    public CookieUtilsKt$tryParseDayOfMonth$2() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(char c) {
        return Boolean.valueOf(CookieUtilsKt.f(c));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Character) obj).charValue());
    }
}
