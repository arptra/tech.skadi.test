package com.upuphone.ar.fastrecord.phone.ui.fragment;

import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordFragment$showChangeNameDialog$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $pos;
    final /* synthetic */ RecordEntity $recordEntity;
    final /* synthetic */ FastRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordFragment$showChangeNameDialog$1$1(FastRecordFragment fastRecordFragment, int i, RecordEntity recordEntity) {
        super(0);
        this.this$0 = fastRecordFragment;
        this.$pos = i;
        this.$recordEntity = recordEntity;
    }

    public final void invoke() {
        FastRecordViewAdapter access$getViewAdapter$p = this.this$0.viewAdapter;
        if (access$getViewAdapter$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            access$getViewAdapter$p = null;
        }
        access$getViewAdapter$p.notifyItemDataChange(this.$pos, this.$recordEntity);
    }
}
