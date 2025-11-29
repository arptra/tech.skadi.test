package com.upuphone.ar.translation.phone.fragment;

import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.databinding.FragmentToDoBinding;
import com.upuphone.ar.translation.phone.view.TranslatorLoadingView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nToDoFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ToDoFragment.kt\ncom/upuphone/ar/translation/phone/fragment/ToDoFragment$notAgreeAiState$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,817:1\n262#2,2:818\n262#2,2:820\n262#2,2:822\n*S KotlinDebug\n*F\n+ 1 ToDoFragment.kt\ncom/upuphone/ar/translation/phone/fragment/ToDoFragment$notAgreeAiState$1\n*L\n363#1:818,2\n364#1:820,2\n365#1:822,2\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isAgree", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ToDoFragment$notAgreeAiState$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ NoteBean $noteBean;
    final /* synthetic */ ToDoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToDoFragment$notAgreeAiState$1(ToDoFragment toDoFragment, NoteBean noteBean) {
        super(1);
        this.this$0 = toDoFragment;
        this.$noteBean = noteBean;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        LogExt.j("getTodo requestAiModelPermission isAgree=" + z, "ToDoFragment");
        if (z) {
            FragmentToDoBinding m0 = this.this$0.f6287a;
            FragmentToDoBinding fragmentToDoBinding = null;
            if (m0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                m0 = null;
            }
            Group group = m0.c;
            Intrinsics.checkNotNullExpressionValue(group, "gpTodoTip");
            group.setVisibility(8);
            FragmentToDoBinding m02 = this.this$0.f6287a;
            if (m02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                m02 = null;
            }
            TranslatorLoadingView translatorLoadingView = m02.f;
            Intrinsics.checkNotNullExpressionValue(translatorLoadingView, "loadingView");
            translatorLoadingView.setVisibility(0);
            FragmentToDoBinding m03 = this.this$0.f6287a;
            if (m03 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentToDoBinding = m03;
            }
            TextView textView = fragmentToDoBinding.i;
            Intrinsics.checkNotNullExpressionValue(textView, "tvLoadingBackground");
            textView.setVisibility(0);
            this.this$0.D0().K(this.$noteBean);
        }
    }
}
