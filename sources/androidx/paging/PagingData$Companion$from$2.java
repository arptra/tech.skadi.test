package androidx.paging;

import androidx.paging.PageEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/paging/PageEvent$Insert;", "T", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class PagingData$Companion$from$2 extends Lambda implements Function0<PageEvent.Insert<Object>> {
    final /* synthetic */ List<Object> $data;
    final /* synthetic */ LoadStates $mediatorLoadStates;
    final /* synthetic */ LoadStates $sourceLoadStates;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagingData$Companion$from$2(List<Object> list, LoadStates loadStates, LoadStates loadStates2) {
        super(0);
        this.$data = list;
        this.$sourceLoadStates = loadStates;
        this.$mediatorLoadStates = loadStates2;
    }

    @Nullable
    public final PageEvent.Insert<Object> invoke() {
        return PageEvent.Insert.g.c(CollectionsKt.listOf(new TransformablePage(0, this.$data)), 0, 0, this.$sourceLoadStates, this.$mediatorLoadStates);
    }
}
