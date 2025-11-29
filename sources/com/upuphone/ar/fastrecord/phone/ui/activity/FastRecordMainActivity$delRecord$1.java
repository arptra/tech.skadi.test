package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordMainActivity$delRecord$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FastRecordMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainActivity$delRecord$1(FastRecordMainActivity fastRecordMainActivity) {
        super(0);
        this.this$0 = fastRecordMainActivity;
    }

    public final void invoke() {
        FastRecordMainViewModel access$getViewModel$p = this.this$0.viewModel;
        if (access$getViewModel$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            access$getViewModel$p = null;
        }
        final FastRecordMainActivity fastRecordMainActivity = this.this$0;
        access$getViewModel$p.delRecord(new Function0<Unit>() {
            public final void invoke() {
                fastRecordMainActivity.clearSelectDataAndExitStatus();
            }
        });
    }
}
