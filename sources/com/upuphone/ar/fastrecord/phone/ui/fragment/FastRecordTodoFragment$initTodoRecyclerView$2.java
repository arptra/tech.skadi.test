package com.upuphone.ar.fastrecord.phone.ui.fragment;

import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordTodoFragment$initTodoRecyclerView$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTodoFragment$initTodoRecyclerView$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ FastRecordTodoFragment this$0;

    public FastRecordTodoFragment$initTodoRecyclerView$2(FastRecordTodoFragment fastRecordTodoFragment) {
        this.this$0 = fastRecordTodoFragment;
    }

    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0) {
            LogExt.logE("addOnScrollListener SCROLL_STATE_IDLE ", "TodoFragment");
        } else if (i == 1) {
            LogExt.logE("addOnScrollListener SCROLL_STATE_DRAGGING ", "TodoFragment");
            this.this$0.exitEditMode();
        }
    }
}
