package com.upuphone.ar.fastrecord.phone.ui.fragment;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;
import com.upuphone.ar.fastrecord.phone.utils.ViewUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordFragment$initView$1$onItemClick$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isAsrFail;
    final /* synthetic */ RecordEntity $itemRecord;
    final /* synthetic */ FastRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordFragment$initView$1$onItemClick$1(RecordEntity recordEntity, FastRecordFragment fastRecordFragment, boolean z) {
        super(0);
        this.$itemRecord = recordEntity;
        this.this$0 = fastRecordFragment;
        this.$isAsrFail = z;
    }

    public final void invoke() {
        if (this.$itemRecord.getRecordStatus() == 2 || this.$itemRecord.getRecordStatus() == 5) {
            LogExt.logE("onItemClick goto FastRecordHistoryDetailActivity", "FastRecordFragment");
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                FastRecordFragment fastRecordFragment = this.this$0;
                RecordEntity recordEntity = this.$itemRecord;
                boolean z = this.$isAsrFail;
                Intent intent = new Intent(activity, FastRecordHistoryDetailActivity.class);
                intent.putExtra(FastRecordHistoryDetailActivity.RECORD_ID, recordEntity.getRecordId());
                intent.putExtra(FastRecordHistoryDetailActivity.RECORD_FAIL, z);
                fastRecordFragment.startActivity(intent);
                return;
            }
            return;
        }
        LogExt.logE("onItemClick goto FastRecordIngDetailActivity", "FastRecordFragment");
        FragmentActivity activity2 = this.this$0.getActivity();
        if (activity2 != null) {
            ViewUtil.startFastRecordIngDetailActivity$default(ViewUtil.INSTANCE, this.$itemRecord.getRecordId(), activity2, (Function0) null, 4, (Object) null);
        }
    }
}
