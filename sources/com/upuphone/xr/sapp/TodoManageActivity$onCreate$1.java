package com.upuphone.xr.sapp;

import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.adapter.TodoListAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTodoManageActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TodoManageActivity.kt\ncom/upuphone/xr/sapp/TodoManageActivity$onCreate$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,306:1\n256#2,2:307\n*S KotlinDebug\n*F\n+ 1 TodoManageActivity.kt\ncom/upuphone/xr/sapp/TodoManageActivity$onCreate$1\n*L\n114#1:307,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004¨\u0006\u000e"}, d2 = {"com/upuphone/xr/sapp/TodoManageActivity$onCreate$1", "Lcom/upuphone/xr/sapp/adapter/TodoListAdapter$TodoListStateListener;", "", "e", "()V", "b", "f", "", "count", "g", "(I)V", "d", "c", "a", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TodoManageActivity$onCreate$1 implements TodoListAdapter.TodoListStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TodoManageActivity f6595a;

    public TodoManageActivity$onCreate$1(TodoManageActivity todoManageActivity) {
        this.f6595a = todoManageActivity;
    }

    public void a() {
        this.f6595a.Z0();
    }

    public void b() {
        this.f6595a.b1(true);
    }

    public void c() {
        this.f6595a.Y0();
        TodoManageActivity todoManageActivity = this.f6595a;
        Toast.makeText(todoManageActivity, todoManageActivity.getString(R.string.todo_copy_tip), 0).show();
    }

    public void d(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("@TodoManageActivity", "onShowCountChange: 显示数量->" + i);
        ConstraintLayout constraintLayout = this.f6595a.L0().l;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "viewEmpty");
        int i2 = 0;
        if (!(i == 0)) {
            i2 = 8;
        }
        constraintLayout.setVisibility(i2);
    }

    public void e() {
        this.f6595a.c1(true);
    }

    public void f() {
        this.f6595a.b1(false);
    }

    public void g(int i) {
        if (i == 0) {
            this.f6595a.L0().h.setText(this.f6595a.getString(R.string.todo_select_title));
            this.f6595a.L0().k.setEnabled(false);
            this.f6595a.L0().k.setAlpha(0.3f);
            return;
        }
        this.f6595a.L0().h.setText(this.f6595a.getString(R.string.todo_select_count, new Object[]{Integer.valueOf(i)}));
        this.f6595a.L0().k.setEnabled(true);
        this.f6595a.L0().k.setAlpha(1.0f);
    }
}
