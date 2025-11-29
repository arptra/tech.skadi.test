package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.utils.ViewUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isNewItem", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordMainActivity$checkRecordIngState$1$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ RecordEntity $entity;
    final /* synthetic */ boolean $isRecording;
    final /* synthetic */ FastRecordMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainActivity$checkRecordIngState$1$1$1(RecordEntity recordEntity, boolean z, FastRecordMainActivity fastRecordMainActivity) {
        super(1);
        this.$entity = recordEntity;
        this.$isRecording = z;
        this.this$0 = fastRecordMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        RecordEntity recordEntity = this.$entity;
        LogExt.logE("checkRecordIngState entity = " + recordEntity + ",isNewItem = " + z, "FastRecordMainActivity");
        if (!this.$isRecording || !z) {
            LogExt.logE("checkRecordIngState createMainPage init", "FastRecordMainActivity");
            this.this$0.createMainPage();
            return;
        }
        this.this$0.clearSelectDataAndExitStatus();
        ViewUtil viewUtil = ViewUtil.INSTANCE;
        long recordId = this.$entity.getRecordId();
        final FastRecordMainActivity fastRecordMainActivity = this.this$0;
        viewUtil.startFastRecordIngDetailActivity(recordId, fastRecordMainActivity, new Function0<Unit>() {
            public final void invoke() {
                LogExt.logE("checkRecordIngState createMainPage after startFastRecordIngDetailActivity", "FastRecordMainActivity");
                fastRecordMainActivity.createMainPage();
            }
        });
    }
}
