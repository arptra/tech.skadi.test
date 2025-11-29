package com.upuphone.ar.fastrecord.phone.ui.fragment;

import com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/fastrecord/phone/db/RecordTodoItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTodoFragment$initTodoRecyclerView$3 extends Lambda implements Function1<RecordTodoItemEntity, Unit> {
    final /* synthetic */ FastRecordTodoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTodoFragment$initTodoRecyclerView$3(FastRecordTodoFragment fastRecordTodoFragment) {
        super(1);
        this.this$0 = fastRecordTodoFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RecordTodoItemEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull RecordTodoItemEntity recordTodoItemEntity) {
        Intrinsics.checkNotNullParameter(recordTodoItemEntity, "it");
        LogExt.logE("delete info = " + recordTodoItemEntity, "TodoFragment");
        FastRecordTodoViewModel access$getViewModel$p = this.this$0.viewModel;
        if (access$getViewModel$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            access$getViewModel$p = null;
        }
        access$getViewModel$p.deleteTodo(recordTodoItemEntity);
    }
}
