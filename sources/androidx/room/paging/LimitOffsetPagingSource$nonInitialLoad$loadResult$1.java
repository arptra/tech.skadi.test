package androidx.room.paging;

import android.database.Cursor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class LimitOffsetPagingSource$nonInitialLoad$loadResult$1 extends FunctionReferenceImpl implements Function1<Cursor, List<? extends Value>> {
    public LimitOffsetPagingSource$nonInitialLoad$loadResult$1(Object obj) {
        super(1, obj, LimitOffsetPagingSource.class, "convertRows", "convertRows(Landroid/database/Cursor;)Ljava/util/List;", 0);
    }

    @NotNull
    public final List<Value> invoke(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "p0");
        return ((LimitOffsetPagingSource) this.receiver).n(cursor);
    }
}
