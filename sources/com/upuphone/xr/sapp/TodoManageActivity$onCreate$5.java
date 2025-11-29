package com.upuphone.xr.sapp;

import android.widget.ImageView;
import androidx.lifecycle.LiveData;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.adapter.TodoListAdapter;
import com.xjsd.ai.assistant.phone.vui.todo.TodoEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TodoManageActivity$onCreate$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TodoManageActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TodoManageActivity$onCreate$5(TodoManageActivity todoManageActivity) {
        super(0);
        this.this$0 = todoManageActivity;
    }

    public final void invoke() {
        LiveData d = this.this$0.O0().d();
        final TodoManageActivity todoManageActivity = this.this$0;
        d.observe(todoManageActivity, new TodoManageActivity$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends TodoEntry>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<TodoEntry>) (List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<TodoEntry> list) {
                ULog.f6446a.a("@TodoManageActivity", "数据库数据更新");
                ImageView imageView = todoManageActivity.L0().c;
                Intrinsics.checkNotNullExpressionValue(imageView, "ivMore");
                imageView.setVisibility(list.isEmpty() ^ true ? 0 : 8);
                TodoListAdapter D0 = todoManageActivity.e;
                Intrinsics.checkNotNull(list);
                D0.O(list);
            }
        }));
    }
}
