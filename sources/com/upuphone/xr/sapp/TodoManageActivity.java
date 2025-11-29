package com.upuphone.xr.sapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.a8.a0;
import com.honey.account.a8.b0;
import com.honey.account.a8.c0;
import com.honey.account.a8.v;
import com.honey.account.a8.w;
import com.honey.account.a8.x;
import com.honey.account.a8.y;
import com.honey.account.a8.z;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.adapter.TodoListAdapter;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.databinding.ActivityTodoManageBinding;
import com.upuphone.xr.sapp.entity.AccountInfo;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.vm.TodoViewModel;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import flyme.support.v7.app.ShowAtBottomAlertDialog;
import flyme.support.v7.widget.PopupMenu;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000 32\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0019\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R$\u0010)\u001a\u00020#2\u0006\u0010$\u001a\u00020#8\u0002@BX\u000e¢\u0006\f\n\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010,\u001a\u00020#2\u0006\u0010$\u001a\u00020#8\u0002@BX\u000e¢\u0006\f\n\u0004\b*\u0010&\"\u0004\b+\u0010(R$\u0010/\u001a\u00020#2\u0006\u0010$\u001a\u00020#8\u0002@BX\u000e¢\u0006\f\n\u0004\b-\u0010&\"\u0004\b.\u0010(R$\u00102\u001a\u00020#2\u0006\u0010$\u001a\u00020#8\u0002@BX\u000e¢\u0006\f\n\u0004\b0\u0010&\"\u0004\b1\u0010(¨\u00065"}, d2 = {"Lcom/upuphone/xr/sapp/TodoManageActivity;", "Lcom/upuphone/xr/sapp/BaseActivity;", "<init>", "()V", "", "N0", "()Ljava/lang/String;", "", "P0", "Z0", "Y0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/upuphone/xr/sapp/databinding/ActivityTodoManageBinding;", "b", "Lkotlin/Lazy;", "L0", "()Lcom/upuphone/xr/sapp/databinding/ActivityTodoManageBinding;", "binding", "Lflyme/support/v7/widget/PopupMenu;", "c", "M0", "()Lflyme/support/v7/widget/PopupMenu;", "morePopupMenu", "Lcom/upuphone/xr/sapp/vm/TodoViewModel;", "d", "O0", "()Lcom/upuphone/xr/sapp/vm/TodoViewModel;", "todoViewMode", "Lcom/upuphone/xr/sapp/adapter/TodoListAdapter;", "e", "Lcom/upuphone/xr/sapp/adapter/TodoListAdapter;", "todoListAdapter", "", "value", "f", "Z", "d1", "(Z)V", "isShowCompleted", "g", "c1", "isSelectMode", "h", "b1", "isSelectAll", "i", "a1", "isKeyboardVisible", "j", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTodoManageActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TodoManageActivity.kt\ncom/upuphone/xr/sapp/TodoManageActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,306:1\n75#2,13:307\n256#3,2:320\n256#3,2:322\n256#3,2:324\n*S KotlinDebug\n*F\n+ 1 TodoManageActivity.kt\ncom/upuphone/xr/sapp/TodoManageActivity\n*L\n52#1:307,13\n64#1:320,2\n65#1:322,2\n66#1:324,2\n*E\n"})
public final class TodoManageActivity extends BaseActivity {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);
    public final Lazy b = LazyKt.lazy(new TodoManageActivity$binding$2(this));
    public final Lazy c = LazyKt.lazy(new TodoManageActivity$morePopupMenu$2(this));
    public final Lazy d = new ViewModelLazy(Reflection.getOrCreateKotlinClass(TodoViewModel.class), new TodoManageActivity$special$$inlined$viewModels$default$2(this), new TodoManageActivity$special$$inlined$viewModels$default$1(this), new TodoManageActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    public TodoListAdapter e = new TodoListAdapter();
    public boolean f = true;
    public boolean g;
    public boolean h;
    public boolean i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/TodoManageActivity$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void Q0(TodoManageActivity todoManageActivity) {
        Intrinsics.checkNotNullParameter(todoManageActivity, "this$0");
        int height = todoManageActivity.L0().getRoot().getRootView().getHeight();
        Rect rect = new Rect();
        todoManageActivity.L0().getRoot().getWindowVisibleDisplayFrame(rect);
        if (((double) (height - rect.bottom)) > ((double) height) * 0.15d) {
            if (!todoManageActivity.i) {
                todoManageActivity.a1(true);
                View currentFocus = todoManageActivity.getCurrentFocus();
                if (currentFocus != null) {
                    currentFocus.postDelayed(new c0(todoManageActivity), 200);
                }
            }
        } else if (todoManageActivity.i) {
            todoManageActivity.a1(false);
        }
    }

    public static final void R0(TodoManageActivity todoManageActivity) {
        Intrinsics.checkNotNullParameter(todoManageActivity, "this$0");
        View currentFocus = todoManageActivity.getCurrentFocus();
        if (currentFocus != null) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            todoManageActivity.L0().e.getLocationOnScreen(iArr);
            int paddingTop = iArr[1] + todoManageActivity.L0().e.getPaddingTop();
            currentFocus.getGlobalVisibleRect(rect);
            currentFocus.getLocationOnScreen(iArr);
            int i2 = iArr[1];
            int i3 = i2 < paddingTop ? ((rect.bottom - rect.top) + paddingTop) - i2 : rect.bottom - rect.top;
            int measuredHeight = currentFocus.getMeasuredHeight();
            if (i3 < measuredHeight) {
                int i4 = (measuredHeight - i3) + 10;
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("@TodoManageActivity", "monitorSoftInput: 滑动距离->" + i4);
                todoManageActivity.L0().e.smoothScrollBy(0, i4);
            }
        }
    }

    public static final void S0(TodoManageActivity todoManageActivity, View view) {
        Intrinsics.checkNotNullParameter(todoManageActivity, "this$0");
        if (todoManageActivity.i) {
            todoManageActivity.Y0();
        } else {
            todoManageActivity.finish();
        }
    }

    public static final void T0(TodoManageActivity todoManageActivity, View view) {
        Intrinsics.checkNotNullParameter(todoManageActivity, "this$0");
        todoManageActivity.Y0();
        todoManageActivity.M0().getFMenu().findFMenuItem(R.id.showMode).setTitle(todoManageActivity.getString(todoManageActivity.f ? R.string.todo_hide_complete : R.string.todo_show_complete));
        todoManageActivity.M0().show();
    }

    public static final void U0(TodoManageActivity todoManageActivity, View view) {
        Intrinsics.checkNotNullParameter(todoManageActivity, "this$0");
        todoManageActivity.c1(false);
        todoManageActivity.b1(false);
    }

    public static final void V0(TodoManageActivity todoManageActivity, View view) {
        Intrinsics.checkNotNullParameter(todoManageActivity, "this$0");
        todoManageActivity.b1(!todoManageActivity.h);
        todoManageActivity.e.L(todoManageActivity.h);
    }

    public static final void W0(TodoManageActivity todoManageActivity, View view) {
        Intrinsics.checkNotNullParameter(todoManageActivity, "this$0");
        List v = todoManageActivity.e.v();
        ColorStateList[] colorStateListArr = {todoManageActivity.getResources().getColorStateList(R.color.red)};
        String string = todoManageActivity.getString(R.string.todo_delete_count, new Object[]{Integer.valueOf(v.size())});
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (v.size() <= 1 && string.charAt(StringsKt.getLastIndex(string)) == 's') {
            string = string.substring(0, string.length() - 1);
            Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
        }
        new ShowAtBottomAlertDialog.Builder(todoManageActivity).setItems(new CharSequence[]{string}, (DialogInterface.OnClickListener) new b0(todoManageActivity, v), true, colorStateListArr).show();
    }

    public static final void X0(TodoManageActivity todoManageActivity, List list, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(todoManageActivity, "this$0");
        Intrinsics.checkNotNullParameter(list, "$selectItems");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new TodoManageActivity$onCreate$10$1$1(list, (Continuation<? super TodoManageActivity$onCreate$10$1$1>) null), 3, (Object) null);
        todoManageActivity.c1(false);
    }

    public final ActivityTodoManageBinding L0() {
        return (ActivityTodoManageBinding) this.b.getValue();
    }

    public final PopupMenu M0() {
        return (PopupMenu) this.c.getValue();
    }

    public final String N0() {
        String str;
        AccountInfo a2 = MzAccountManager.c.a();
        if (a2 == null || (str = a2.getMzUid()) == null) {
            str = "default";
        }
        return "todo_show_all_" + str;
    }

    public final TodoViewModel O0() {
        return (TodoViewModel) this.d.getValue();
    }

    public final void P0() {
        L0().getRoot().getViewTreeObserver().addOnGlobalLayoutListener(new a0(this));
    }

    public final void Y0() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            Object systemService = getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public final void Z0() {
        if (!this.i) {
            ULog.f6446a.a("@TodoManageActivity", "requestShowKeyboard: 申请显示软键盘");
            Object systemService = getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).toggleSoftInput(3, 0);
        }
    }

    public final void a1(boolean z) {
        this.i = z;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("@TodoManageActivity", "软键盘显示？" + z);
        if (!z) {
            this.e.I();
        }
    }

    public final void b1(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("@TodoManageActivity", "全选状态->" + z);
        this.h = z;
        L0().f.setText(getString(z ? R.string.todo_select_nothing : R.string.todo_select_all));
    }

    public final void c1(boolean z) {
        this.g = z;
        LinearLayout linearLayout = L0().n;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "viewTitle");
        int i2 = 8;
        linearLayout.setVisibility(z ^ true ? 0 : 8);
        ConstraintLayout constraintLayout = L0().m;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "viewSelect");
        constraintLayout.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout2 = L0().k;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "viewDelete");
        if (z) {
            i2 = 0;
        }
        linearLayout2.setVisibility(i2);
        this.e.u(z);
    }

    public final void d1(boolean z) {
        this.f = z;
        DataStoreUtils.e.a().o(N0(), Boolean.valueOf(this.f));
        this.e.N(z);
    }

    public void onCreate(Bundle bundle) {
        String mzUid;
        super.onCreate(bundle);
        setContentView((View) L0().getRoot());
        if (DeviceUtils.c() || DeviceUtils.i()) {
            L0().d.setImageResource(R.drawable.ic_todo_guide_starv);
        } else {
            L0().d.setImageResource(R.drawable.ic_todo_guide);
        }
        this.e.P(new TodoManageActivity$onCreate$1(this));
        L0().e.addItemDecoration(new TodoManageActivity$onCreate$2());
        L0().e.setAdapter(this.e);
        L0().e.setLayoutManager(new LinearLayoutManager(this, 1, false));
        L0().e.setItemAnimator((RecyclerView.ItemAnimator) null);
        L0().e.addOnScrollListener(new TodoManageActivity$onCreate$3(this));
        AccountInfo a2 = MzAccountManager.c.a();
        if (a2 == null || (mzUid = a2.getMzUid()) == null) {
            new TodoManageActivity$onCreate$5(this);
        } else {
            O0().c(mzUid).observe(this, new TodoManageActivity$sam$androidx_lifecycle_Observer$0(new TodoManageActivity$onCreate$4$1(this)));
            Unit unit = Unit.INSTANCE;
        }
        L0().b.setOnClickListener(new v(this));
        L0().c.setOnClickListener(new w(this));
        L0().g.setOnClickListener(new x(this));
        L0().f.setOnClickListener(new y(this));
        L0().k.setOnClickListener(new z(this));
        L0().k.setAlpha(0.3f);
        P0();
        d1(((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), N0(), Boolean.TRUE, (Context) null, 4, (Object) null)).booleanValue());
    }
}
