package io.ktor.http;

import io.ktor.util.TextKt;
import io.netty.util.internal.StringUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lio/ktor/http/ContentType;", "it", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class MimesKt$loadMimes$1 extends Lambda implements Function1<String, Pair<? extends String, ? extends ContentType>> {
    public static final MimesKt$loadMimes$1 INSTANCE = new MimesKt$loadMimes$1();

    public MimesKt$loadMimes$1() {
        super(1);
    }

    @Nullable
    public final Pair<String, ContentType> invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        String obj = StringsKt.trim((CharSequence) str).toString();
        if (obj.length() == 0) {
            return null;
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) obj, (char) StringUtil.COMMA, 0, false, 6, (Object) null);
        String substring = obj.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String substring2 = obj.substring(indexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        return TuplesKt.to(TextKt.c(StringsKt.removePrefix(substring, (CharSequence) ".")), FileContentTypeKt.b(substring2));
    }
}
