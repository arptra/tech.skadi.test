package com.upuphone.xr.sapp;

import android.widget.ImageView;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.adapter.TodoListAdapter;
import com.xjsd.ai.assistant.phone.vui.todo.TodoEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTodoManageActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TodoManageActivity.kt\ncom/upuphone/xr/sapp/TodoManageActivity$onCreate$4$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,306:1\n256#2,2:307\n*S KotlinDebug\n*F\n+ 1 TodoManageActivity.kt\ncom/upuphone/xr/sapp/TodoManageActivity$onCreate$4$1\n*L\n160#1:307,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "list", "", "Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TodoManageActivity$onCreate$4$1 extends Lambda implements Function1<List<? extends TodoEntry>, Unit> {
    final /* synthetic */ TodoManageActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TodoManageActivity$onCreate$4$1(TodoManageActivity todoManageActivity) {
        super(1);
        this.this$0 = todoManageActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<TodoEntry>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<TodoEntry> list) {
        ULog.f6446a.a("@TodoManageActivity", "数据库数据更新");
        ImageView imageView = this.this$0.L0().c;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivMore");
        imageView.setVisibility(list.isEmpty() ^ true ? 0 : 8);
        TodoListAdapter D0 = this.this$0.e;
        Intrinsics.checkNotNull(list);
        D0.O(list);
    }
}
