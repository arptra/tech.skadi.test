package com.upuphone.xr.sapp.adapter;

import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.c8.a0;
import com.honey.account.c8.b0;
import com.honey.account.c8.c0;
import com.honey.account.c8.d0;
import com.honey.account.c8.e0;
import com.honey.account.c8.f0;
import com.honey.account.c8.u;
import com.honey.account.c8.v;
import com.honey.account.c8.w;
import com.honey.account.c8.x;
import com.honey.account.c8.y;
import com.honey.account.c8.z;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.databinding.ItemTodoListBinding;
import com.upuphone.xr.sapp.databinding.ItemTodoListSectionBinding;
import com.upuphone.xr.sapp.view.MultiFuncEditText;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.phone.vui.todo.TodoEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@SourceDebugExtension({"SMAP\nTodoListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TodoListAdapter.kt\ncom/upuphone/xr/sapp/adapter/TodoListAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,425:1\n1855#2,2:426\n256#3,2:428\n256#3,2:430\n256#3,2:432\n256#3,2:434\n254#3:436\n*S KotlinDebug\n*F\n+ 1 TodoListAdapter.kt\ncom/upuphone/xr/sapp/adapter/TodoListAdapter\n*L\n136#1:426,2\n288#1:428,2\n306#1:430,2\n336#1:432,2\n364#1:434,2\n374#1:436\n*E\n"})
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 S2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002TUB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0016\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001aJ\u0015\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\f¢\u0006\u0004\b\u001e\u0010\u001aJ\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\u0004J\u001f\u0010&\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020$2\u0006\u0010(\u001a\u00020$H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020$H\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00022\u0006\u0010(\u001a\u00020$H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b0\u00101R\u0014\u00105\u001a\u0002028\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0014068\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u000202068\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u00108R$\u0010@\u001a\u00020\f2\u0006\u0010<\u001a\u00020\f8\u0002@BX\u000e¢\u0006\f\n\u0004\b=\u0010>\"\u0004\b?\u0010\u001aR\u0016\u0010B\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010>R\u0016\u0010D\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010>R\u0016\u0010F\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010!R$\u0010J\u001a\u00020$2\u0006\u0010<\u001a\u00020$8\u0002@BX\u000e¢\u0006\f\n\u0004\bG\u0010!\"\u0004\bH\u0010IR$\u0010R\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q¨\u0006V"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/TodoListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/upuphone/xr/sapp/adapter/VH;", "<init>", "()V", "", "S", "Landroid/widget/CheckBox;", "cbSelect", "R", "(Landroid/widget/CheckBox;)V", "t", "", "z", "()Z", "Landroid/widget/EditText;", "et", "Q", "(Landroid/widget/EditText;)V", "", "Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;", "data", "O", "(Ljava/util/List;)V", "isEnter", "u", "(Z)V", "showCompleted", "N", "selectAll", "L", "v", "()Ljava/util/List;", "I", "Landroid/view/ViewGroup;", "parent", "", "viewType", "H", "(Landroid/view/ViewGroup;I)Lcom/upuphone/xr/sapp/adapter/VH;", "position", "getItemViewType", "(I)I", "getItemCount", "()I", "holder", "A", "(Lcom/upuphone/xr/sapp/adapter/VH;I)V", "J", "(Lcom/upuphone/xr/sapp/adapter/VH;)V", "Lcom/upuphone/xr/sapp/adapter/TodoItem;", "a", "Lcom/upuphone/xr/sapp/adapter/TodoItem;", "mSectionItem", "", "b", "Ljava/util/List;", "mSrcData", "c", "mShowData", "value", "d", "Z", "M", "isSelectMode", "e", "isShowCompletedData", "f", "isCompletedDataEmpty", "g", "mSelectCount", "h", "K", "(I)V", "mCurrentEditIndex", "Lcom/upuphone/xr/sapp/adapter/TodoListAdapter$TodoListStateListener;", "i", "Lcom/upuphone/xr/sapp/adapter/TodoListAdapter$TodoListStateListener;", "y", "()Lcom/upuphone/xr/sapp/adapter/TodoListAdapter$TodoListStateListener;", "P", "(Lcom/upuphone/xr/sapp/adapter/TodoListAdapter$TodoListStateListener;)V", "stateListener", "j", "Companion", "TodoListStateListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TodoListAdapter extends RecyclerView.Adapter<VH> {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final TodoItem f6626a = new TodoItem(true);
    public final List b = new ArrayList();
    public final List c = new ArrayList();
    public boolean d;
    public boolean e = true;
    public boolean f;
    public int g;
    public int h = -1;
    public TodoListStateListener i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/TodoListAdapter$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/TodoListAdapter$TodoListStateListener;", "", "", "e", "()V", "b", "f", "", "count", "g", "(I)V", "d", "c", "a", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface TodoListStateListener {
        void a();

        void b();

        void c();

        void d(int i);

        void e();

        void f();

        void g(int i);
    }

    public static final boolean B(TodoListAdapter todoListAdapter, View view) {
        Intrinsics.checkNotNullParameter(todoListAdapter, "this$0");
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
        ((TodoItem) todoListAdapter.c.get(((Integer) tag).intValue())).h(true);
        TodoListStateListener todoListStateListener = todoListAdapter.i;
        if (todoListStateListener != null) {
            todoListStateListener.e();
        }
        return true;
    }

    public static final void C(TodoItem todoItem, TodoListAdapter todoListAdapter, View view, boolean z) {
        Intrinsics.checkNotNullParameter(todoItem, "$item");
        Intrinsics.checkNotNullParameter(todoListAdapter, "this$0");
        if (z) {
            BindTextWatcher bindTextWatcher = new BindTextWatcher(todoItem);
            view.setTag(bindTextWatcher);
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.EditText");
            ((EditText) view).addTextChangedListener(bindTextWatcher);
            TodoListStateListener todoListStateListener = todoListAdapter.i;
            if (todoListStateListener != null) {
                todoListStateListener.a();
            }
        } else if (view.getTag() != null) {
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type android.text.TextWatcher");
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.EditText");
            ((EditText) view).removeTextChangedListener((TextWatcher) tag);
        }
    }

    public static final void D(TodoListAdapter todoListAdapter, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(todoListAdapter, "this$0");
        Object tag = compoundButton.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
        ((TodoItem) todoListAdapter.c.get(((Integer) tag).intValue())).h(z);
    }

    public static final void E(TodoListAdapter todoListAdapter, VH vh, View view) {
        Intrinsics.checkNotNullParameter(todoListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(vh, "$holder");
        if (!todoListAdapter.z()) {
            if (todoListAdapter.d) {
                CheckBox checkBox = vh.a().b;
                Intrinsics.checkNotNullExpressionValue(checkBox, "cbSelect");
                todoListAdapter.R(checkBox);
                return;
            }
            vh.a().c.setChecked(!vh.a().c.isChecked());
        }
    }

    public static final void F(TodoEntry todoEntry, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(todoEntry, "$todoEntry");
        todoEntry.setCompleted(z);
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new TodoListAdapter$onBindViewHolder$2$1(todoEntry, (Continuation<? super TodoListAdapter$onBindViewHolder$2$1>) null), 3, (Object) null);
    }

    public static final void G(TodoListAdapter todoListAdapter, VH vh, View view) {
        Intrinsics.checkNotNullParameter(todoListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(vh, "$holder");
        if (todoListAdapter.d) {
            CheckBox checkBox = vh.a().b;
            Intrinsics.checkNotNullExpressionValue(checkBox, "cbSelect");
            todoListAdapter.R(checkBox);
            return;
        }
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) tag).intValue();
        TodoEntry c2 = ((TodoItem) todoListAdapter.c.get(intValue)).c();
        if (c2 == null || !c2.getCompleted()) {
            int i2 = todoListAdapter.h;
            todoListAdapter.K(intValue);
            if (i2 != -1) {
                ((TodoItem) todoListAdapter.c.get(i2)).f(false);
                todoListAdapter.notifyItemChanged(i2);
            }
            ((TodoItem) todoListAdapter.c.get(intValue)).f(true);
            todoListAdapter.notifyItemChanged(intValue);
        }
    }

    public static final boolean T(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    public static final void U(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final boolean V(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    public static final void W(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final boolean w(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    public static final void x(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final boolean z() {
        return this.h != -1;
    }

    /* renamed from: A */
    public void onBindViewHolder(VH vh, int i2) {
        Intrinsics.checkNotNullParameter(vh, "holder");
        TodoItem todoItem = (TodoItem) this.c.get(i2);
        if (!todoItem.e()) {
            TodoEntry c2 = todoItem.c();
            Intrinsics.checkNotNull(c2);
            boolean d2 = todoItem.d();
            ItemTodoListBinding a2 = vh.a();
            Intrinsics.checkNotNull(a2);
            a2.f.setAlpha(c2.getCompleted() ? 0.3f : 1.0f);
            vh.a().getRoot().setOnClickListener(new u(this, vh));
            vh.a().c.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            CheckBox checkBox = vh.a().c;
            Intrinsics.checkNotNullExpressionValue(checkBox, "cbTodoState");
            int i3 = 8;
            checkBox.setVisibility(this.d ^ true ? 0 : 8);
            vh.a().c.setChecked(c2.getCompleted());
            vh.a().c.setOnCheckedChangeListener(new x(c2));
            vh.a().e.setTag(Integer.valueOf(i2));
            TextView textView = vh.a().e;
            Intrinsics.checkNotNullExpressionValue(textView, "tvTodoContent");
            textView.setVisibility(d2 ^ true ? 0 : 8);
            vh.a().e.setText(todoItem.a());
            vh.a().e.setOnClickListener(new y(this, vh));
            vh.a().e.setOnLongClickListener(new z(this));
            MultiFuncEditText multiFuncEditText = vh.a().d;
            Intrinsics.checkNotNullExpressionValue(multiFuncEditText, "etTodoContent");
            multiFuncEditText.setVisibility(d2 ? 0 : 8);
            vh.a().d.setOnCopiedListener(new TodoListAdapter$onBindViewHolder$5(this));
            vh.a().d.setOnFocusChangeListener(new a0(todoItem, this));
            vh.a().d.setText(todoItem.a());
            if (this.h == i2) {
                MultiFuncEditText multiFuncEditText2 = vh.a().d;
                Intrinsics.checkNotNullExpressionValue(multiFuncEditText2, "etTodoContent");
                Q(multiFuncEditText2);
                TodoListStateListener todoListStateListener = this.i;
                if (todoListStateListener != null) {
                    todoListStateListener.a();
                }
            }
            vh.a().b.setTag(Integer.valueOf(i2));
            CheckBox checkBox2 = vh.a().b;
            Intrinsics.checkNotNullExpressionValue(checkBox2, "cbSelect");
            if (this.d) {
                i3 = 0;
            }
            checkBox2.setVisibility(i3);
            vh.a().b.setChecked(todoItem.b());
            vh.a().b.setOnCheckedChangeListener(new b0(this));
        }
    }

    /* renamed from: H */
    public VH onCreateViewHolder(ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i2 == 0) {
            ItemTodoListBinding c2 = ItemTodoListBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
            return new VH(c2, (ItemTodoListSectionBinding) null);
        }
        ItemTodoListSectionBinding c3 = ItemTodoListSectionBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c3, "inflate(...)");
        return new VH((ItemTodoListBinding) null, c3);
    }

    public final void I() {
        ULog.f6446a.a("@TodoListAdapter", "onKeyboardHide: 软件盘隐藏，开始更新数据库数据");
        int i2 = this.h;
        K(-1);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TodoItem todoItem : this.c) {
            if (!todoItem.e()) {
                String a2 = todoItem.a();
                TodoEntry c2 = todoItem.c();
                Intrinsics.checkNotNull(c2);
                if (!Intrinsics.areEqual((Object) a2, (Object) c2.getTarget())) {
                    TodoEntry c3 = todoItem.c();
                    Intrinsics.checkNotNull(c3);
                    ULog.Delegate delegate = ULog.f6446a;
                    String target = c3.getTarget();
                    String a3 = todoItem.a();
                    delegate.a("@TodoListAdapter", "update: old->" + target + ", new->" + a3);
                    c3.setTarget(todoItem.a());
                    if (todoItem.a().length() == 0) {
                        arrayList2.add(c3);
                    } else {
                        arrayList.add(c3);
                    }
                }
            }
        }
        if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new TodoListAdapter$onKeyboardHide$2(arrayList, arrayList2, (Continuation<? super TodoListAdapter$onKeyboardHide$2>) null), 3, (Object) null);
        } else if (i2 != -1) {
            ((TodoItem) this.c.get(i2)).f(false);
            notifyItemChanged(i2);
        }
    }

    /* renamed from: J */
    public void onViewAttachedToWindow(VH vh) {
        MultiFuncEditText multiFuncEditText;
        Intrinsics.checkNotNullParameter(vh, "holder");
        ItemTodoListBinding a2 = vh.a();
        if (a2 != null && (multiFuncEditText = a2.d) != null && multiFuncEditText.getVisibility() == 0) {
            ULog.f6446a.a("@TodoListAdapter", "onViewAttachedToWindow: 重置et");
            multiFuncEditText.setEnabled(false);
            multiFuncEditText.setEnabled(true);
        }
    }

    public final void K(int i2) {
        this.h = i2;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("@TodoListAdapter", "当前正在编辑：index->" + i2);
    }

    public final void L(boolean z) {
        this.g = 0;
        for (TodoItem todoItem : this.c) {
            todoItem.h(z);
            if (z && !todoItem.e()) {
                this.g++;
            }
        }
        TodoListStateListener todoListStateListener = this.i;
        if (todoListStateListener != null) {
            todoListStateListener.g(this.g);
        }
        notifyDataSetChanged();
    }

    public final void M(boolean z) {
        this.d = z;
        if (!z) {
            for (TodoItem h2 : this.c) {
                h2.h(false);
            }
            this.g = 0;
        } else {
            this.g = 1;
        }
        t();
        notifyDataSetChanged();
    }

    public final void N(boolean z) {
        this.e = z;
        S();
    }

    public final void O(List list) {
        Intrinsics.checkNotNullParameter(list, "data");
        ULog.Delegate delegate = ULog.f6446a;
        String e2 = GsonUtils.e(list);
        delegate.a("@TodoListAdapter", "setSrcData: " + e2);
        this.b.clear();
        this.b.addAll(list);
        S();
    }

    public final void P(TodoListStateListener todoListStateListener) {
        this.i = todoListStateListener;
    }

    public final void Q(EditText editText) {
        ULog.f6446a.a("@TodoListAdapter", "triggerRequestFocus: 申请焦点");
        editText.requestFocus();
        editText.setSelection(editText.getText().toString().length());
    }

    public final void R(CheckBox checkBox) {
        boolean z = !checkBox.isChecked();
        checkBox.setChecked(z);
        if (z) {
            this.g++;
        } else {
            this.g--;
        }
        t();
    }

    public final void S() {
        this.c.clear();
        this.g = 0;
        K(-1);
        this.b.stream().filter(new c0(TodoListAdapter$updateShowData$1.INSTANCE)).forEach(new d0(new TodoListAdapter$updateShowData$2(this)));
        if (this.e) {
            ArrayList arrayList = new ArrayList();
            this.b.stream().filter(new e0(TodoListAdapter$updateShowData$3.INSTANCE)).forEach(new f0(new TodoListAdapter$updateShowData$4(arrayList)));
            boolean isEmpty = arrayList.isEmpty();
            this.f = isEmpty;
            if (!isEmpty) {
                this.c.add(this.f6626a);
                this.c.addAll(arrayList);
            }
        }
        notifyDataSetChanged();
        TodoListStateListener todoListStateListener = this.i;
        if (todoListStateListener != null) {
            todoListStateListener.d(getItemCount());
        }
    }

    public int getItemCount() {
        return this.c.size();
    }

    public int getItemViewType(int i2) {
        return ((TodoItem) this.c.get(i2)).e() ? 1 : 0;
    }

    public final void t() {
        TodoListStateListener todoListStateListener = this.i;
        if (todoListStateListener != null) {
            todoListStateListener.g(this.g);
        }
        if (!this.e || this.f) {
            if (this.g == getItemCount()) {
                TodoListStateListener todoListStateListener2 = this.i;
                if (todoListStateListener2 != null) {
                    todoListStateListener2.b();
                    return;
                }
                return;
            }
            TodoListStateListener todoListStateListener3 = this.i;
            if (todoListStateListener3 != null) {
                todoListStateListener3.f();
            }
        } else if (this.g == getItemCount() - 1) {
            TodoListStateListener todoListStateListener4 = this.i;
            if (todoListStateListener4 != null) {
                todoListStateListener4.b();
            }
        } else {
            TodoListStateListener todoListStateListener5 = this.i;
            if (todoListStateListener5 != null) {
                todoListStateListener5.f();
            }
        }
    }

    public final void u(boolean z) {
        M(z);
    }

    public final List v() {
        ArrayList arrayList = new ArrayList();
        if (this.d) {
            this.c.stream().filter(new v(TodoListAdapter$getSelectItems$1.INSTANCE)).forEach(new w(new TodoListAdapter$getSelectItems$2(arrayList)));
        }
        return arrayList;
    }

    public final TodoListStateListener y() {
        return this.i;
    }
}
