package com.upuphone.ar.translation.phone.fragment;

import androidx.constraintlayout.widget.Group;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.adapter.IntelExtnTodoAdapter;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import com.upuphone.ar.translation.phone.databinding.FragmentToDoBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nToDoFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ToDoFragment.kt\ncom/upuphone/ar/translation/phone/fragment/ToDoFragment$initViews$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,817:1\n262#2,2:818\n262#2,2:820\n262#2,2:822\n*S KotlinDebug\n*F\n+ 1 ToDoFragment.kt\ncom/upuphone/ar/translation/phone/fragment/ToDoFragment$initViews$2\n*L\n168#1:818,2\n169#1:820,2\n170#1:822,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "position", "", "extnTodo", "Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ToDoFragment$initViews$2 extends Lambda implements Function2<Integer, IntelExtnTodo, Unit> {
    final /* synthetic */ ToDoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToDoFragment$initViews$2(ToDoFragment toDoFragment) {
        super(2);
        this.this$0 = toDoFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (IntelExtnTodo) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, @NotNull IntelExtnTodo intelExtnTodo) {
        Intrinsics.checkNotNullParameter(intelExtnTodo, "extnTodo");
        LogExt.j("deleteTodo position=" + i + ", extnTodo=" + intelExtnTodo, "ToDoFragment");
        this.this$0.D0().y(intelExtnTodo);
        IntelExtnTodoAdapter n0 = this.this$0.b;
        if (n0 != null) {
            n0.h0(intelExtnTodo);
        }
        IntelExtnTodoAdapter n02 = this.this$0.b;
        if (n02 != null) {
            ToDoFragment toDoFragment = this.this$0;
            List data = n02.getData();
            if (data.isEmpty()) {
                n02.getData().clear();
                n02.notifyDataSetChanged();
                FragmentToDoBinding m0 = toDoFragment.f6287a;
                FragmentToDoBinding fragmentToDoBinding = null;
                if (m0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    m0 = null;
                }
                Group group = m0.b;
                Intrinsics.checkNotNullExpressionValue(group, "gpTodoList");
                group.setVisibility(8);
                FragmentToDoBinding m02 = toDoFragment.f6287a;
                if (m02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    m02 = null;
                }
                Group group2 = m02.c;
                Intrinsics.checkNotNullExpressionValue(group2, "gpTodoTip");
                group2.setVisibility(0);
                FragmentToDoBinding m03 = toDoFragment.f6287a;
                if (m03 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    m03 = null;
                }
                MzButton mzButton = m03.g;
                Intrinsics.checkNotNullExpressionValue(mzButton, "mbtTodo");
                mzButton.setVisibility(0);
                FragmentToDoBinding m04 = toDoFragment.f6287a;
                if (m04 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    fragmentToDoBinding = m04;
                }
                fragmentToDoBinding.g.setEnabled(true);
            }
            toDoFragment.V0(data);
        }
    }
}
