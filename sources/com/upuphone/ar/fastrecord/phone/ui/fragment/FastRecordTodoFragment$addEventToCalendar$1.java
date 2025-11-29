package com.upuphone.ar.fastrecord.phone.ui.fragment;

import androidx.fragment.app.FragmentActivity;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordTodoViewAdapter;
import com.upuphone.star.common.phone.UToast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "addTodo", "Lcom/upuphone/ar/fastrecord/phone/db/RecordTodoItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTodoFragment$addEventToCalendar$1 extends Lambda implements Function1<RecordTodoItemEntity, Unit> {
    final /* synthetic */ int $position;
    final /* synthetic */ FastRecordTodoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTodoFragment$addEventToCalendar$1(FastRecordTodoFragment fastRecordTodoFragment, int i) {
        super(1);
        this.this$0 = fastRecordTodoFragment;
        this.$position = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RecordTodoItemEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull RecordTodoItemEntity recordTodoItemEntity) {
        Intrinsics.checkNotNullParameter(recordTodoItemEntity, "addTodo");
        LogExt.logI("addEventToCalendar addTodo=" + recordTodoItemEntity, "TodoFragment");
        FastRecordTodoViewAdapter access$getViewAdapter$p = this.this$0.viewAdapter;
        if (access$getViewAdapter$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            access$getViewAdapter$p = null;
        }
        access$getViewAdapter$p.updateTodoInfo(this.$position, recordTodoItemEntity);
        UToast.Companion companion = UToast.f6444a;
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        String string = this.this$0.getString(R.string.fr_extract_add_todo_tips);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(requireActivity, string);
        this.this$0.updateTodoList();
    }
}
