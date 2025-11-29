package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordMainActivity$checkRecordIngState$1 extends Lambda implements Function1<RecordEntity, Unit> {
    final /* synthetic */ FastRecordMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainActivity$checkRecordIngState$1(FastRecordMainActivity fastRecordMainActivity) {
        super(1);
        this.this$0 = fastRecordMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RecordEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable RecordEntity recordEntity) {
        LogExt.logE("checkRecordIngState it = " + recordEntity, "FastRecordMainActivity");
        if (recordEntity == null) {
            LogExt.logE("checkRecordIngState recording is null", "FastRecordMainActivity");
            this.this$0.createMainPage();
        }
        if (recordEntity != null) {
            FastRecordMainActivity fastRecordMainActivity = this.this$0;
            boolean z = true;
            if (!(recordEntity.getRecordStatus() == 1 || recordEntity.getRecordStatus() == 4)) {
                z = false;
            }
            FastRecordMainViewModel access$getViewModel$p = fastRecordMainActivity.viewModel;
            if (access$getViewModel$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                access$getViewModel$p = null;
            }
            access$getViewModel$p.checkIsNewRecordItem(recordEntity.getRecordId(), new FastRecordMainActivity$checkRecordIngState$1$1$1(recordEntity, z, fastRecordMainActivity));
        }
    }
}
