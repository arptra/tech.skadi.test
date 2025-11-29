package com.upuphone.ar.fastrecord.phone.ui.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTagScheduleDialog$saveAllDataBeforeFinish$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FastRecordTagScheduleDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTagScheduleDialog$saveAllDataBeforeFinish$1(FastRecordTagScheduleDialog fastRecordTagScheduleDialog) {
        super(0);
        this.this$0 = fastRecordTagScheduleDialog;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(FastRecordTagScheduleDialog fastRecordTagScheduleDialog) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        fastRecordTagScheduleDialog.finish();
    }

    public final void invoke() {
        FastRecordTagScheduleDialog fastRecordTagScheduleDialog = this.this$0;
        fastRecordTagScheduleDialog.runOnUiThread(new g(fastRecordTagScheduleDialog));
    }
}
