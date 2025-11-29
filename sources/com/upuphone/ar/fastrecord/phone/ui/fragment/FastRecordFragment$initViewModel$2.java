package com.upuphone.ar.fastrecord.phone.ui.fragment;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordFragment$initViewModel$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ FastRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordFragment$initViewModel$2(FastRecordFragment fastRecordFragment) {
        super(1);
        this.this$0 = fastRecordFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean bool) {
        FastRecordMainViewModel access$getViewModel$p = this.this$0.viewModel;
        FastRecordViewAdapter fastRecordViewAdapter = null;
        if (access$getViewModel$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            access$getViewModel$p = null;
        }
        LogExt.logE("mClearSelectStatus viewModel.getCurPage() = " + access$getViewModel$p.getCurPage() + ",recordType = " + this.this$0.recordType, "FastRecordFragment");
        FastRecordMainViewModel access$getViewModel$p2 = this.this$0.viewModel;
        if (access$getViewModel$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            access$getViewModel$p2 = null;
        }
        if (Intrinsics.areEqual((Object) access$getViewModel$p2.getCurPage(), (Object) this.this$0.recordType)) {
            Intrinsics.checkNotNull(bool);
            if (bool.booleanValue()) {
                FastRecordViewAdapter access$getViewAdapter$p = this.this$0.viewAdapter;
                if (access$getViewAdapter$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                } else {
                    fastRecordViewAdapter = access$getViewAdapter$p;
                }
                fastRecordViewAdapter.clearAllItemChooseStatus();
                return;
            }
            FastRecordViewAdapter access$getViewAdapter$p2 = this.this$0.viewAdapter;
            if (access$getViewAdapter$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                access$getViewAdapter$p2 = null;
            }
            access$getViewAdapter$p2.selectAllItemChooseStatus();
            FastRecordMainViewModel access$getViewModel$p3 = this.this$0.viewModel;
            if (access$getViewModel$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                access$getViewModel$p3 = null;
            }
            FastRecordViewAdapter access$getViewAdapter$p3 = this.this$0.viewAdapter;
            if (access$getViewAdapter$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            } else {
                fastRecordViewAdapter = access$getViewAdapter$p3;
            }
            access$getViewModel$p3.addSelectListEntity(fastRecordViewAdapter.getAllFinishItemData());
        }
    }
}
