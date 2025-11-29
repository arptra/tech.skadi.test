package androidx.paging;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/paging/GenerationalViewportHint;", "previous", "Landroidx/paging/LoadType;", "loadType", "", "a", "(Landroidx/paging/GenerationalViewportHint;Landroidx/paging/GenerationalViewportHint;Landroidx/paging/LoadType;)Z", "paging-common"}, k = 2, mv = {1, 8, 0})
@RestrictTo
public final class PageFetcherSnapshotKt {
    public static final boolean a(GenerationalViewportHint generationalViewportHint, GenerationalViewportHint generationalViewportHint2, LoadType loadType) {
        Intrinsics.checkNotNullParameter(generationalViewportHint, "<this>");
        Intrinsics.checkNotNullParameter(generationalViewportHint2, "previous");
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        if (generationalViewportHint.a() > generationalViewportHint2.a()) {
            return true;
        }
        if (generationalViewportHint.a() < generationalViewportHint2.a()) {
            return false;
        }
        return HintHandlerKt.a(generationalViewportHint.b(), generationalViewportHint2.b(), loadType);
    }
}
