package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.annotation.SuppressLint;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperatorManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0017¨\u0006\r"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/activity/FastRecordHistoryDetailActivity$initAsrRequestCallback$1", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordHistoryAsrOperatorManager$AsrCallbackInterface;", "asrResultEmpty", "", "recordId", "", "asrResultFail", "code", "", "asrResultFinish", "asrResultProgress", "totalTime", "curTime", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryDetailActivity$initAsrRequestCallback$1 implements FastRecordHistoryAsrOperatorManager.AsrCallbackInterface {
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    public FastRecordHistoryDetailActivity$initAsrRequestCallback$1(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        this.this$0 = fastRecordHistoryDetailActivity;
    }

    public void asrResultEmpty(long j) {
        Long access$getRecordId$p = this.this$0.recordId;
        LogExt.logW("asrResultEmpty recordId = " + j + ",curPage id = " + access$getRecordId$p, "FastRecordHistoryDetailActivity");
        Long access$getRecordId$p2 = this.this$0.recordId;
        if (access$getRecordId$p2 != null && j == access$getRecordId$p2.longValue()) {
            FastRecordDetailRecordHistoryViewModel.updateCurRecordLanguageType$default(this.this$0.getViewModel(), j, false, new FastRecordHistoryDetailActivity$initAsrRequestCallback$1$asrResultEmpty$1(this.this$0, j), 2, (Object) null);
        }
    }

    public void asrResultFail(long j, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "code");
        Long access$getRecordId$p = this.this$0.recordId;
        LogExt.logW("asrResultFail recordId = " + j + ",code = " + str + ",curPage id = " + access$getRecordId$p, "FastRecordHistoryDetailActivity");
        Long access$getRecordId$p2 = this.this$0.recordId;
        if (access$getRecordId$p2 != null && j == access$getRecordId$p2.longValue()) {
            FastRecordDetailRecordHistoryViewModel.updateCurRecordLanguageType$default(this.this$0.getViewModel(), j, false, new FastRecordHistoryDetailActivity$initAsrRequestCallback$1$asrResultFail$1(this.this$0, str), 2, (Object) null);
        }
    }

    public void asrResultFinish(long j) {
        Long access$getRecordId$p = this.this$0.recordId;
        LogExt.logW("asrResultFinish recordId = " + j + ",curPage id = " + access$getRecordId$p, "FastRecordHistoryDetailActivity");
        Long access$getRecordId$p2 = this.this$0.recordId;
        if (access$getRecordId$p2 != null && j == access$getRecordId$p2.longValue()) {
            this.this$0.getViewModel().updateCurRecordLanguageType(j, true, new FastRecordHistoryDetailActivity$initAsrRequestCallback$1$asrResultFinish$1(this.this$0, j));
            this.this$0.getViewModel().changeAiResultState(j);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void asrResultProgress(long j, long j2, long j3) {
    }
}
