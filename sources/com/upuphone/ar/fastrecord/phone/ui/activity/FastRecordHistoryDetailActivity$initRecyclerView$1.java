package com.upuphone.ar.fastrecord.phone.ui.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordDetailHistoryViewAdapter;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/activity/FastRecordHistoryDetailActivity$initRecyclerView$1", "Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordDetailHistoryViewAdapter$ItemClickListener;", "onItemClick", "", "position", "", "onLongClick", "scrollToPosition", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryDetailActivity$initRecyclerView$1 implements FastRecordDetailHistoryViewAdapter.ItemClickListener {
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    public FastRecordHistoryDetailActivity$initRecyclerView$1(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        this.this$0 = fastRecordHistoryDetailActivity;
    }

    public void onItemClick(int i) {
        FastRecordDetailHistoryViewAdapter access$getViewAdapter$p = this.this$0.viewAdapter;
        FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter = null;
        if (access$getViewAdapter$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            access$getViewAdapter$p = null;
        }
        LogExt.logW("onItemClick position = " + i + ",EdtItemPosition = " + access$getViewAdapter$p.getEdtItemPosition(), "FastRecordHistoryDetailActivity");
        if (Intrinsics.areEqual((Object) this.this$0.getViewModel().getPageState(), (Object) FastRecordDetailRecordHistoryViewModel.PLAY_STATE)) {
            this.this$0.playPosition(i);
            return;
        }
        FastRecordDetailHistoryViewAdapter access$getViewAdapter$p2 = this.this$0.viewAdapter;
        if (access$getViewAdapter$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            access$getViewAdapter$p2 = null;
        }
        if (i != access$getViewAdapter$p2.getEdtItemPosition()) {
            FastRecordDetailHistoryViewAdapter access$getViewAdapter$p3 = this.this$0.viewAdapter;
            if (access$getViewAdapter$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            } else {
                fastRecordDetailHistoryViewAdapter = access$getViewAdapter$p3;
            }
            fastRecordDetailHistoryViewAdapter.changeToEditState(i);
        }
    }

    public void onLongClick(int i) {
        LogExt.logW("onLongClick", "FastRecordHistoryDetailActivity");
        FastRecordDetailHistoryViewAdapter access$getViewAdapter$p = this.this$0.viewAdapter;
        if (access$getViewAdapter$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            access$getViewAdapter$p = null;
        }
        access$getViewAdapter$p.changeToEditState(i);
        this.this$0.getViewModel().setPageState(FastRecordDetailRecordHistoryViewModel.EDIT_STATE);
    }

    public void scrollToPosition(int i) {
        LogExt.logW("scrollToPosition position = " + i, "FastRecordHistoryDetailActivity");
        RecyclerView.LayoutManager layoutManager = this.this$0.getLayout().j.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.scrollToPosition(i);
        }
        RecyclerView.LayoutManager layoutManager2 = this.this$0.getLayout().j.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager2).findLastVisibleItemPosition();
        if (i > findLastVisibleItemPosition - 2) {
            FastRecordDetailHistoryViewAdapter access$getViewAdapter$p = this.this$0.viewAdapter;
            FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter = null;
            if (access$getViewAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                access$getViewAdapter$p = null;
            }
            LogExt.logW("scrollToPosition position = " + i + ",lastVisiblePosition = " + findLastVisibleItemPosition + ",viewAdapter.itemCount = " + access$getViewAdapter$p + ".itemCount", "FastRecordHistoryDetailActivity");
            FastRecordDetailHistoryViewAdapter access$getViewAdapter$p2 = this.this$0.viewAdapter;
            if (access$getViewAdapter$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            } else {
                fastRecordDetailHistoryViewAdapter = access$getViewAdapter$p2;
            }
            int i2 = i + 2;
            if (i2 < fastRecordDetailHistoryViewAdapter.getItemCount()) {
                RecyclerView.LayoutManager layoutManager3 = this.this$0.getLayout().j.getLayoutManager();
                if (layoutManager3 != null) {
                    layoutManager3.scrollToPosition(i2);
                    return;
                }
                return;
            }
            RecyclerView.LayoutManager layoutManager4 = this.this$0.getLayout().j.getLayoutManager();
            if (layoutManager4 != null) {
                layoutManager4.scrollToPosition(i);
                return;
            }
            return;
        }
        RecyclerView.LayoutManager layoutManager5 = this.this$0.getLayout().j.getLayoutManager();
        if (layoutManager5 != null) {
            layoutManager5.scrollToPosition(i);
        }
    }
}
