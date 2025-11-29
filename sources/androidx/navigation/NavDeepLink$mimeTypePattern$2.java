package androidx.navigation;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/util/regex/Pattern;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavDeepLink$mimeTypePattern$2 extends Lambda implements Function0<Pattern> {
    final /* synthetic */ NavDeepLink this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavDeepLink$mimeTypePattern$2(NavDeepLink navDeepLink) {
        super(0);
        this.this$0 = navDeepLink;
    }

    @Nullable
    public final Pattern invoke() {
        String a2 = this.this$0.i;
        if (a2 == null) {
            return null;
        }
        return Pattern.compile(a2);
    }
}
