package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.content.Intent;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordSearchViewAdapter;
import com.upuphone.ar.fastrecord.phone.utils.ViewUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/activity/FastRecordSearchActivity$initView$2", "Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordSearchViewAdapter$ItemClickListener;", "onItemClick", "", "position", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordSearchActivity$initView$2 implements FastRecordSearchViewAdapter.ItemClickListener {
    final /* synthetic */ FastRecordSearchActivity this$0;

    public FastRecordSearchActivity$initView$2(FastRecordSearchActivity fastRecordSearchActivity) {
        this.this$0 = fastRecordSearchActivity;
    }

    public void onItemClick(int i) {
        FastRecordSearchViewAdapter access$getViewAdapter$p = this.this$0.viewAdapter;
        FastRecordSearchViewAdapter fastRecordSearchViewAdapter = null;
        if (access$getViewAdapter$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            access$getViewAdapter$p = null;
        }
        LogExt.logI("onItemClick to detail page state = " + access$getViewAdapter$p.getPositionData(i).getRecordStatus(), "FastRecordSearchActivity");
        FastRecordSearchViewAdapter access$getViewAdapter$p2 = this.this$0.viewAdapter;
        if (access$getViewAdapter$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            access$getViewAdapter$p2 = null;
        }
        if (access$getViewAdapter$p2.getPositionData(i).getRecordStatus() != 2) {
            FastRecordSearchViewAdapter access$getViewAdapter$p3 = this.this$0.viewAdapter;
            if (access$getViewAdapter$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                access$getViewAdapter$p3 = null;
            }
            if (access$getViewAdapter$p3.getPositionData(i).getRecordStatus() != 5) {
                ViewUtil viewUtil = ViewUtil.INSTANCE;
                FastRecordSearchViewAdapter access$getViewAdapter$p4 = this.this$0.viewAdapter;
                if (access$getViewAdapter$p4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                } else {
                    fastRecordSearchViewAdapter = access$getViewAdapter$p4;
                }
                ViewUtil.startFastRecordIngDetailActivity$default(viewUtil, fastRecordSearchViewAdapter.getPositionData(i).getRecordId(), this.this$0, (Function0) null, 4, (Object) null);
                return;
            }
        }
        FastRecordSearchActivity fastRecordSearchActivity = this.this$0;
        Intent intent = new Intent(this.this$0, FastRecordHistoryDetailActivity.class);
        FastRecordSearchViewAdapter access$getViewAdapter$p5 = this.this$0.viewAdapter;
        if (access$getViewAdapter$p5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
        } else {
            fastRecordSearchViewAdapter = access$getViewAdapter$p5;
        }
        intent.putExtra(FastRecordHistoryDetailActivity.RECORD_ID, fastRecordSearchViewAdapter.getPositionData(i).getRecordId());
        fastRecordSearchActivity.startActivity(intent);
    }
}
