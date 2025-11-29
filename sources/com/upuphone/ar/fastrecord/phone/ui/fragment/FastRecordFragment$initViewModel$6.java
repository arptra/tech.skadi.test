package com.upuphone.ar.fastrecord.phone.ui.fragment;

import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000120\u0010\u0002\u001a,\u0012\u0004\u0012\u00020\u0004 \u0006*\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00050\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "recordData", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "Lkotlin/collections/ArrayList;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordFragment$initViewModel$6 extends Lambda implements Function1<ArrayList<RecordEntity>, Unit> {
    final /* synthetic */ FastRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordFragment$initViewModel$6(FastRecordFragment fastRecordFragment) {
        super(1);
        this.this$0 = fastRecordFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<RecordEntity>) (ArrayList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ArrayList<RecordEntity> arrayList) {
        if (Intrinsics.areEqual((Object) this.this$0.recordType, (Object) FastRecordMainViewModel.RECORD_TYPE_SCENE)) {
            LogExt.logE("sceneFastRecordData", "FastRecordFragment");
            FastRecordFragment fastRecordFragment = this.this$0;
            Intrinsics.checkNotNull(arrayList);
            fastRecordFragment.setChooseData(arrayList);
            FastRecordViewAdapter access$getViewAdapter$p = this.this$0.viewAdapter;
            if (access$getViewAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                access$getViewAdapter$p = null;
            }
            access$getViewAdapter$p.notifyData(arrayList);
            this.this$0.showRecordTip(arrayList);
        }
    }
}
