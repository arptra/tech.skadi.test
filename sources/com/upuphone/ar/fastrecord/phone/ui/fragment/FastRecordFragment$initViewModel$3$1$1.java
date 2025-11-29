package com.upuphone.ar.fastrecord.phone.ui.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isNewItem", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordFragment$initViewModel$3$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ RecordGlassStatus $status;
    final /* synthetic */ FastRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordFragment$initViewModel$3$1$1(RecordGlassStatus recordGlassStatus, FastRecordFragment fastRecordFragment) {
        super(1);
        this.$status = recordGlassStatus;
        this.this$0 = fastRecordFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        LogExt.logE("state = " + this.$status.getState() + ",isNewItem = " + z, "FastRecordFragment");
        LinearLayoutManager linearLayoutManager = null;
        if (this.$status.getState() != 1 || !z) {
            FastRecordViewAdapter access$getViewAdapter$p = this.this$0.viewAdapter;
            if (access$getViewAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                access$getViewAdapter$p = null;
            }
            RecordGlassStatus recordGlassStatus = this.$status;
            final FastRecordFragment fastRecordFragment = this.this$0;
            access$getViewAdapter$p.updateRecordStatus(recordGlassStatus, new Function0<Unit>() {
                public final void invoke() {
                    LogExt.logW("record is finish or new item", "FastRecordFragment");
                    fastRecordFragment.initFastRecordList();
                }
            });
        }
        if (this.$status.getState() == 2 || this.$status.getState() == 5) {
            FastRecordViewAdapter access$getViewAdapter$p2 = this.this$0.viewAdapter;
            if (access$getViewAdapter$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                access$getViewAdapter$p2 = null;
            }
            RecordGlassStatus recordGlassStatus2 = this.$status;
            LinearLayoutManager access$getLayoutManager$p = this.this$0.layoutManager;
            if (access$getLayoutManager$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            } else {
                linearLayoutManager = access$getLayoutManager$p;
            }
            access$getViewAdapter$p2.stopRecordCpt(recordGlassStatus2, linearLayoutManager);
        }
    }
}
