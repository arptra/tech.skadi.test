package androidx.paging;

import androidx.annotation.RestrictTo;
import androidx.paging.ViewportHint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a%\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/paging/ViewportHint;", "previous", "Landroidx/paging/LoadType;", "loadType", "", "a", "(Landroidx/paging/ViewportHint;Landroidx/paging/ViewportHint;Landroidx/paging/LoadType;)Z", "paging-common"}, k = 2, mv = {1, 8, 0})
@RestrictTo
public final class HintHandlerKt {
    public static final boolean a(ViewportHint viewportHint, ViewportHint viewportHint2, LoadType loadType) {
        Intrinsics.checkNotNullParameter(viewportHint, "<this>");
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        if (viewportHint2 == null) {
            return true;
        }
        if (!(viewportHint2 instanceof ViewportHint.Initial) || !(viewportHint instanceof ViewportHint.Access)) {
            return (!(viewportHint instanceof ViewportHint.Initial) || !(viewportHint2 instanceof ViewportHint.Access)) && !(viewportHint.a() == viewportHint2.a() && viewportHint.b() == viewportHint2.b() && viewportHint2.e(loadType) <= viewportHint.e(loadType));
        }
        return true;
    }
}
