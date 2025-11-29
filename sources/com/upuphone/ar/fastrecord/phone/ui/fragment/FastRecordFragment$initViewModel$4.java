package com.upuphone.ar.fastrecord.phone.ui.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordFragment$initViewModel$4 extends Lambda implements Function1<RecordEntity, Unit> {
    final /* synthetic */ FastRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordFragment$initViewModel$4(FastRecordFragment fastRecordFragment) {
        super(1);
        this.this$0 = fastRecordFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RecordEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable RecordEntity recordEntity) {
        if (recordEntity != null) {
            FastRecordFragment fastRecordFragment = this.this$0;
            FastRecordViewAdapter access$getViewAdapter$p = fastRecordFragment.viewAdapter;
            LinearLayoutManager linearLayoutManager = null;
            if (access$getViewAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                access$getViewAdapter$p = null;
            }
            LinearLayoutManager access$getLayoutManager$p = fastRecordFragment.layoutManager;
            if (access$getLayoutManager$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            } else {
                linearLayoutManager = access$getLayoutManager$p;
            }
            access$getViewAdapter$p.updateRecordTime(recordEntity, linearLayoutManager);
        }
    }
}
