package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class Url$encodedFragment$2 extends Lambda implements Function0<String> {
    final /* synthetic */ Url this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Url$encodedFragment$2(Url url) {
        super(0);
        this.this$0 = url;
    }

    @NotNull
    public final String invoke() {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.this$0.j, '#', 0, false, 6, (Object) null) + 1;
        if (indexOf$default == 0) {
            return "";
        }
        String substring = this.this$0.j.substring(indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }
}
