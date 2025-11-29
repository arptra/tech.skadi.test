package com.upuphone.ar.translation.phone.fragment;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.honey.account.f5.l0;
import com.honey.account.f5.m0;
import com.honey.account.f5.n0;
import com.honey.account.f5.o0;
import com.honey.account.f5.p0;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.adapter.IntelExtnTodoAdapter;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.databinding.FragmentToDoBinding;
import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import com.upuphone.ar.translation.phone.view.ClipboardEditText;
import com.upuphone.ar.translation.phone.view.TranslatorLoadingView;
import com.upuphone.ar.translation.phone.vm.IntelExtnShareViewModel;
import com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import com.xjsd.xr.sapp.asr.dao.SmartExTodo;
import com.xjsd.xr.sapp.asr.utils.AsrExtKt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \\2\u00020\u0001:\u0001]B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u001d\u0010\u0019\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0017H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002¢\u0006\u0004\b'\u0010\u001aJ\u000f\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b(\u0010\u0003J\u001f\u0010.\u001a\u00020-2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0004H\u0002¢\u0006\u0004\b0\u0010\u0003J\u0017\u00101\u001a\u00020-2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0004H\u0002¢\u0006\u0004\b3\u0010\u0003J\u0019\u00106\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b6\u00107J+\u0010<\u001a\u00020)2\u0006\u00109\u001a\u0002082\b\u0010;\u001a\u0004\u0018\u00010:2\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b<\u0010=J!\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020)2\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0004H\u0016¢\u0006\u0004\bA\u0010\u0003J\u000f\u0010B\u001a\u00020\u0004H\u0016¢\u0006\u0004\bB\u0010\u0003R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u001b\u0010S\u001a\u00020N8BX\u0002¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010Z¨\u0006^"}, d2 = {"Lcom/upuphone/ar/translation/phone/fragment/ToDoFragment;", "Lcom/upuphone/ar/translation/phone/fragment/TransBaseFragment;", "<init>", "()V", "", "initViews", "initData", "initListener", "initViewModels", "E0", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "noteBean", "C0", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "U0", "Lcom/xjsd/xr/sapp/asr/dao/SmartExTodo;", "resTodo", "M0", "(Lcom/xjsd/xr/sapp/asr/dao/SmartExTodo;)V", "O0", "N0", "handleTodoFailure", "", "Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;", "list", "H0", "(Ljava/util/List;)V", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "sensitive", "L0", "(Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;)V", "scheduleTodo", "K0", "(Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;)V", "Lcom/upuphone/ar/translation/phone/vm/IntelExtnShareViewModel$ImeBean;", "imeBean", "J0", "(Lcom/upuphone/ar/translation/phone/vm/IntelExtnShareViewModel$ImeBean;)V", "todoList", "V0", "F0", "Landroid/view/View;", "textView", "Landroid/view/MotionEvent;", "event", "", "W0", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "I0", "X0", "(Landroid/view/MotionEvent;)Z", "P0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onDestroyView", "Lcom/upuphone/ar/translation/phone/databinding/FragmentToDoBinding;", "a", "Lcom/upuphone/ar/translation/phone/databinding/FragmentToDoBinding;", "mBinding", "Lcom/upuphone/ar/translation/phone/adapter/IntelExtnTodoAdapter;", "b", "Lcom/upuphone/ar/translation/phone/adapter/IntelExtnTodoAdapter;", "mIntelExtnTodoAdapter", "c", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "mNoteBean", "Lcom/upuphone/ar/translation/phone/vm/IntelExtnTodoViewModel;", "d", "Lkotlin/Lazy;", "D0", "()Lcom/upuphone/ar/translation/phone/vm/IntelExtnTodoViewModel;", "mTodoViewModel", "Lcom/upuphone/ar/translation/phone/vm/IntelExtnShareViewModel;", "e", "Lcom/upuphone/ar/translation/phone/vm/IntelExtnShareViewModel;", "mIntelExtnShareVm", "Lcom/upuphone/ar/translation/phone/view/ClipboardEditText;", "f", "Lcom/upuphone/ar/translation/phone/view/ClipboardEditText;", "mImeVisibleEditText", "g", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nToDoFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ToDoFragment.kt\ncom/upuphone/ar/translation/phone/fragment/ToDoFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,817:1\n106#2,15:818\n262#3,2:833\n262#3,2:835\n262#3,2:837\n262#3,2:839\n262#3,2:841\n262#3,2:843\n262#3,2:845\n262#3,2:847\n262#3,2:849\n262#3,2:851\n262#3,2:853\n262#3,2:855\n262#3,2:857\n262#3,2:859\n262#3,2:861\n262#3,2:863\n262#3,2:865\n262#3,2:867\n262#3,2:869\n262#3,2:871\n262#3,2:873\n262#3,2:875\n262#3,2:877\n262#3,2:879\n262#3,2:881\n262#3,2:883\n262#3,2:885\n262#3,2:887\n262#3,2:889\n262#3,2:891\n262#3,2:893\n262#3,2:895\n262#3,2:897\n329#3,4:899\n260#3:903\n262#3,2:904\n262#3,2:906\n262#3,2:908\n*S KotlinDebug\n*F\n+ 1 ToDoFragment.kt\ncom/upuphone/ar/translation/phone/fragment/ToDoFragment\n*L\n73#1:818,15\n303#1:833,2\n330#1:835,2\n337#1:837,2\n338#1:839,2\n339#1:841,2\n352#1:843,2\n377#1:845,2\n378#1:847,2\n397#1:849,2\n398#1:851,2\n420#1:853,2\n422#1:855,2\n449#1:857,2\n450#1:859,2\n459#1:861,2\n460#1:863,2\n472#1:865,2\n473#1:867,2\n474#1:869,2\n491#1:871,2\n492#1:873,2\n493#1:875,2\n494#1:877,2\n499#1:879,2\n500#1:881,2\n501#1:883,2\n513#1:885,2\n514#1:887,2\n515#1:889,2\n544#1:891,2\n545#1:893,2\n547#1:895,2\n548#1:897,2\n589#1:899,4\n639#1:903\n652#1:904,2\n662#1:906,2\n667#1:908,2\n*E\n"})
public final class ToDoFragment extends TransBaseFragment {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public FragmentToDoBinding f6287a;
    public IntelExtnTodoAdapter b;
    public NoteBean c;
    public final Lazy d;
    public IntelExtnShareViewModel e;
    public ClipboardEditText f;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/ar/translation/phone/fragment/ToDoFragment$Companion;", "", "<init>", "()V", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "noteBean", "Lcom/upuphone/ar/translation/phone/fragment/ToDoFragment;", "a", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)Lcom/upuphone/ar/translation/phone/fragment/ToDoFragment;", "", "TAG", "Ljava/lang/String;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ToDoFragment a(NoteBean noteBean) {
            ToDoFragment toDoFragment = new ToDoFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(TranslatorConstants.TRANSFER_TRANS_RECORD, noteBean);
            toDoFragment.setArguments(bundle);
            return toDoFragment;
        }

        public Companion() {
        }
    }

    public ToDoFragment() {
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new ToDoFragment$special$$inlined$viewModels$default$2(new ToDoFragment$special$$inlined$viewModels$default$1(this)));
        this.d = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(IntelExtnTodoViewModel.class), new ToDoFragment$special$$inlined$viewModels$default$3(lazy), new ToDoFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new ToDoFragment$special$$inlined$viewModels$default$5(this, lazy));
    }

    /* access modifiers changed from: private */
    public final void C0(NoteBean noteBean) {
        LogExt.j("getTodo accountId=" + AsrExtKt.mixSpecialData(noteBean.getAccountId()) + ", recognizeId=" + noteBean.getRecognizeId(), "ToDoFragment");
        FragmentToDoBinding fragmentToDoBinding = null;
        if (StringsKt.isBlank(noteBean.getAccountId()) || StringsKt.isBlank(noteBean.getRecognizeId())) {
            FragmentToDoBinding fragmentToDoBinding2 = this.f6287a;
            if (fragmentToDoBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentToDoBinding2 = null;
            }
            fragmentToDoBinding2.g.setEnabled(true);
            FragmentToDoBinding fragmentToDoBinding3 = this.f6287a;
            if (fragmentToDoBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentToDoBinding = fragmentToDoBinding3;
            }
            MzButton mzButton = fragmentToDoBinding.g;
            Intrinsics.checkNotNullExpressionValue(mzButton, "mbtTodo");
            mzButton.setVisibility(0);
            D0().V(R.string.tl_generate_to_do_empty);
            return;
        }
        FragmentToDoBinding fragmentToDoBinding4 = this.f6287a;
        if (fragmentToDoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding4 = null;
        }
        Group group = fragmentToDoBinding4.c;
        Intrinsics.checkNotNullExpressionValue(group, "gpTodoTip");
        group.setVisibility(8);
        FragmentToDoBinding fragmentToDoBinding5 = this.f6287a;
        if (fragmentToDoBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding5 = null;
        }
        TranslatorLoadingView translatorLoadingView = fragmentToDoBinding5.f;
        Intrinsics.checkNotNullExpressionValue(translatorLoadingView, "loadingView");
        translatorLoadingView.setVisibility(0);
        FragmentToDoBinding fragmentToDoBinding6 = this.f6287a;
        if (fragmentToDoBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentToDoBinding = fragmentToDoBinding6;
        }
        TextView textView = fragmentToDoBinding.i;
        Intrinsics.checkNotNullExpressionValue(textView, "tvLoadingBackground");
        textView.setVisibility(0);
        D0().K(noteBean);
    }

    public static final void G0(ToDoFragment toDoFragment) {
        List data;
        Intrinsics.checkNotNullParameter(toDoFragment, "this$0");
        IntelExtnTodoAdapter intelExtnTodoAdapter = toDoFragment.b;
        if (intelExtnTodoAdapter != null && (data = intelExtnTodoAdapter.getData()) != null && !data.isEmpty()) {
            FragmentToDoBinding fragmentToDoBinding = toDoFragment.f6287a;
            FragmentToDoBinding fragmentToDoBinding2 = null;
            if (fragmentToDoBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentToDoBinding = null;
            }
            int paddingStart = fragmentToDoBinding.h.getPaddingStart();
            FragmentToDoBinding fragmentToDoBinding3 = toDoFragment.f6287a;
            if (fragmentToDoBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentToDoBinding3 = null;
            }
            int paddingTop = fragmentToDoBinding3.h.getPaddingTop();
            FragmentToDoBinding fragmentToDoBinding4 = toDoFragment.f6287a;
            if (fragmentToDoBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentToDoBinding4 = null;
            }
            int paddingEnd = fragmentToDoBinding4.h.getPaddingEnd();
            FragmentToDoBinding fragmentToDoBinding5 = toDoFragment.f6287a;
            if (fragmentToDoBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentToDoBinding5 = null;
            }
            int paddingBottom = fragmentToDoBinding5.h.getPaddingBottom();
            FragmentToDoBinding fragmentToDoBinding6 = toDoFragment.f6287a;
            if (fragmentToDoBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentToDoBinding6 = null;
            }
            int height = fragmentToDoBinding6.j.getHeight();
            Drawable drawable = ContextCompat.getDrawable(toDoFragment.requireActivity(), R.drawable.tl_linear_verical_divider_12);
            int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
            LogExt.j("handleAiMark[start=" + paddingStart + ", top=" + paddingTop + ", end=" + paddingEnd + ", bottom=" + paddingBottom + ", dividerHeight=" + intrinsicHeight + ", aiHeight=" + height + "]", "ToDoFragment");
            FragmentToDoBinding fragmentToDoBinding7 = toDoFragment.f6287a;
            if (fragmentToDoBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentToDoBinding2 = fragmentToDoBinding7;
            }
            RecyclerView recyclerView = fragmentToDoBinding2.h;
            if (height > intrinsicHeight) {
                height -= intrinsicHeight;
            }
            recyclerView.setPadding(paddingStart, paddingTop, paddingEnd, height);
        }
    }

    /* JADX WARNING: type inference failed for: r4v8, types: [kotlin.Unit] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void I0() {
        /*
            r9 = this;
            java.lang.String r0 = "handleIllegalContent 待办事项违规内容举报"
            java.lang.String r1 = "ToDoFragment"
            com.upuphone.ar.translation.ext.LogExt.j(r0, r1)
            com.upuphone.ar.translation.phone.adapter.IntelExtnTodoAdapter r0 = r9.b
            if (r0 == 0) goto L_0x006b
            java.util.List r2 = r0.getData()
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x001b
            java.lang.String r9 = "handleIllegalContent 待办事项列表为empty"
            com.upuphone.ar.translation.ext.LogExt.j(r9, r1)
            goto L_0x006b
        L_0x001b:
            com.upuphone.ar.translation.phone.bean.NoteBean r3 = r9.c
            r4 = 0
            if (r3 == 0) goto L_0x0064
            androidx.fragment.app.FragmentActivity r5 = r9.getActivity()
            if (r5 == 0) goto L_0x0064
            com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager r6 = com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager.f6560a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel r7 = r9.D0()
            com.upuphone.ar.translation.phone.vm.IntelExtnShareViewModel r8 = r9.e
            if (r8 != 0) goto L_0x0039
            java.lang.String r8 = "mIntelExtnShareVm"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            goto L_0x003a
        L_0x0039:
            r4 = r8
        L_0x003a:
            androidx.lifecycle.LiveData r4 = r4.m()
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L_0x0048
            java.lang.String r4 = ""
        L_0x0048:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r8 = 0
            java.lang.Object r2 = r2.get(r8)
            com.upuphone.ar.translation.phone.bean.IntelExtnTodo r2 = (com.upuphone.ar.translation.phone.bean.IntelExtnTodo) r2
            java.lang.String r2 = r2.getRequestId()
            com.upuphone.xr.audio.record.ai.bean.AiFeedBackRequest r2 = r7.I(r3, r4, r2)
            com.upuphone.ar.translation.phone.fragment.ToDoFragment$handleIllegalContent$1$1$1$1 r4 = new com.upuphone.ar.translation.phone.fragment.ToDoFragment$handleIllegalContent$1$1$1$1
            r4.<init>(r9, r3, r0)
            r6.k(r5, r2, r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x0064:
            if (r4 != 0) goto L_0x006b
            java.lang.String r9 = "handleIllegalContent 待办事项NoteBean对象为null"
            com.upuphone.ar.translation.ext.LogExt.j(r9, r1)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.fragment.ToDoFragment.I0():void");
    }

    /* access modifiers changed from: private */
    public final void L0(SensitivePayload sensitivePayload) {
        Unit unit;
        FragmentToDoBinding fragmentToDoBinding = null;
        if (sensitivePayload != null) {
            if (StringsKt.equals(sensitivePayload.getRiskLevel(), "LOCKED", true)) {
                D0().W(sensitivePayload.getRiskDescription());
            } else {
                D0().V(R.string.tl_generate_sensitive_disable_func);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            D0().V(R.string.tl_generate_content_sensitive_fail);
        }
        FragmentToDoBinding fragmentToDoBinding2 = this.f6287a;
        if (fragmentToDoBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding2 = null;
        }
        TranslatorLoadingView translatorLoadingView = fragmentToDoBinding2.f;
        Intrinsics.checkNotNullExpressionValue(translatorLoadingView, "loadingView");
        translatorLoadingView.setVisibility(8);
        FragmentToDoBinding fragmentToDoBinding3 = this.f6287a;
        if (fragmentToDoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding3 = null;
        }
        TextView textView = fragmentToDoBinding3.i;
        Intrinsics.checkNotNullExpressionValue(textView, "tvLoadingBackground");
        textView.setVisibility(8);
        FragmentToDoBinding fragmentToDoBinding4 = this.f6287a;
        if (fragmentToDoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding4 = null;
        }
        fragmentToDoBinding4.g.setEnabled(true);
        FragmentToDoBinding fragmentToDoBinding5 = this.f6287a;
        if (fragmentToDoBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding5 = null;
        }
        MzButton mzButton = fragmentToDoBinding5.g;
        Intrinsics.checkNotNullExpressionValue(mzButton, "mbtTodo");
        mzButton.setVisibility(0);
        FragmentToDoBinding fragmentToDoBinding6 = this.f6287a;
        if (fragmentToDoBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentToDoBinding = fragmentToDoBinding6;
        }
        Group group = fragmentToDoBinding.c;
        Intrinsics.checkNotNullExpressionValue(group, "gpTodoTip");
        group.setVisibility(0);
    }

    private final void P0() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Object systemService = activity.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public static final void Q0(ToDoFragment toDoFragment, View view) {
        Intrinsics.checkNotNullParameter(toDoFragment, "this$0");
        toDoFragment.E0();
    }

    public static final boolean R0(ToDoFragment toDoFragment, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(toDoFragment, "this$0");
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNull(motionEvent);
        return toDoFragment.W0(view, motionEvent);
    }

    public static final boolean S0(ToDoFragment toDoFragment, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(toDoFragment, "this$0");
        Intrinsics.checkNotNull(motionEvent);
        return toDoFragment.X0(motionEvent);
    }

    public static final void T0(ToDoFragment toDoFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(toDoFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.tv_add_schedule) {
            Object obj = baseQuickAdapter.getData().get(i);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ar.translation.phone.bean.IntelExtnTodo");
            IntelExtnTodo intelExtnTodo = (IntelExtnTodo) obj;
            if (!intelExtnTodo.isAddedSchedule()) {
                IntelExtnTodoViewModel D0 = toDoFragment.D0();
                FragmentActivity requireActivity = toDoFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                D0.v(requireActivity, intelExtnTodo);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void U0(NoteBean noteBean) {
        FragmentToDoBinding fragmentToDoBinding = this.f6287a;
        FragmentToDoBinding fragmentToDoBinding2 = null;
        if (fragmentToDoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding = null;
        }
        fragmentToDoBinding.g.setEnabled(true);
        FragmentToDoBinding fragmentToDoBinding3 = this.f6287a;
        if (fragmentToDoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentToDoBinding2 = fragmentToDoBinding3;
        }
        MzButton mzButton = fragmentToDoBinding2.g;
        Intrinsics.checkNotNullExpressionValue(mzButton, "mbtTodo");
        mzButton.setVisibility(0);
        InterConnectHelper.c.a().u(new ToDoFragment$notAgreeAiState$1(this, noteBean));
    }

    /* access modifiers changed from: private */
    public final void V0(List list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        IntelExtnTodo intelExtnTodo = (IntelExtnTodo) CollectionsKt.lastOrNull(arrayList);
        if (intelExtnTodo != null && intelExtnTodo.getItemType() == 1) {
            CollectionsKt.removeLastOrNull(arrayList);
        }
        IntelExtnShareViewModel intelExtnShareViewModel = this.e;
        if (intelExtnShareViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntelExtnShareVm");
            intelExtnShareViewModel = null;
        }
        intelExtnShareViewModel.r(arrayList);
    }

    private final boolean W0(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && (view instanceof TextView)) {
            TextView textView = (TextView) view;
            Drawable drawable = textView.getCompoundDrawablesRelative()[2];
            if (drawable == null) {
                return false;
            }
            FragmentActivity activity = getActivity();
            boolean f2 = activity != null ? ContextExtKt.f(activity) : false;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (f2) {
                if (motionEvent.getX() <= ((float) (textView.getPaddingEnd() + intrinsicWidth))) {
                    I0();
                    view.performClick();
                    return true;
                }
            } else if (motionEvent.getX() >= ((float) ((textView.getWidth() - textView.getPaddingEnd()) - intrinsicWidth)) && motionEvent.getX() <= ((float) (textView.getWidth() - textView.getPaddingEnd()))) {
                I0();
                view.performClick();
                return true;
            }
        }
        return false;
    }

    private final boolean X0(MotionEvent motionEvent) {
        View currentFocus;
        FragmentActivity activity = getActivity();
        if (activity == null || motionEvent.getAction() != 0 || (currentFocus = activity.getCurrentFocus()) == null || !(currentFocus instanceof EditText)) {
            return false;
        }
        Rect rect = new Rect();
        ((EditText) currentFocus).getGlobalVisibleRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        LogExt.j("touchEditOutside touch outside the EditText area", "ToDoFragment");
        P0();
        return false;
    }

    private final void initData() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.e = (IntelExtnShareViewModel) new ViewModelProvider(requireActivity).get(IntelExtnShareViewModel.class);
        NoteBean noteBean = this.c;
        if (noteBean == null) {
            return;
        }
        if (StringsKt.isBlank(noteBean.getAccountId()) || StringsKt.isBlank(noteBean.getRecognizeId())) {
            LogExt.j("initData 无待办事项可被加载", "ToDoFragment");
        } else {
            IntelExtnTodoViewModel.M(D0(), noteBean, false, 2, (Object) null);
        }
    }

    private final void initListener() {
        FragmentToDoBinding fragmentToDoBinding = this.f6287a;
        FragmentToDoBinding fragmentToDoBinding2 = null;
        if (fragmentToDoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding = null;
        }
        fragmentToDoBinding.g.setOnClickListener(new m0(this));
        FragmentToDoBinding fragmentToDoBinding3 = this.f6287a;
        if (fragmentToDoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding3 = null;
        }
        fragmentToDoBinding3.j.setOnTouchListener(new n0(this));
        IntelExtnTodoViewModel.U(D0(), (Function0) null, 1, (Object) null);
        FragmentToDoBinding fragmentToDoBinding4 = this.f6287a;
        if (fragmentToDoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentToDoBinding2 = fragmentToDoBinding4;
        }
        fragmentToDoBinding2.getRoot().setOnTouchListener(new o0(this));
    }

    private final void initViewModels() {
        D0().F().observe(getViewLifecycleOwner(), new ToDoFragment$sam$androidx_lifecycle_Observer$0(new ToDoFragment$initViewModels$1(this)));
        D0().D().observe(getViewLifecycleOwner(), new ToDoFragment$sam$androidx_lifecycle_Observer$0(new ToDoFragment$initViewModels$2(this)));
        D0().E().observe(getViewLifecycleOwner(), new ToDoFragment$sam$androidx_lifecycle_Observer$0(new ToDoFragment$initViewModels$3(this)));
        D0().G().observe(getViewLifecycleOwner(), new ToDoFragment$sam$androidx_lifecycle_Observer$0(new ToDoFragment$initViewModels$4(this)));
        IntelExtnShareViewModel intelExtnShareViewModel = this.e;
        if (intelExtnShareViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntelExtnShareVm");
            intelExtnShareViewModel = null;
        }
        intelExtnShareViewModel.j().observe(getViewLifecycleOwner(), new ToDoFragment$sam$androidx_lifecycle_Observer$0(new ToDoFragment$initViewModels$5(this)));
        D0().B().observe(getViewLifecycleOwner(), new ToDoFragment$sam$androidx_lifecycle_Observer$0(new ToDoFragment$initViewModels$6(this)));
    }

    private final void initViews() {
        IntelExtnTodoAdapter intelExtnTodoAdapter = new IntelExtnTodoAdapter(new ArrayList(), new ToDoFragment$initViews$1(this), new ToDoFragment$initViews$2(this), new ToDoFragment$initViews$3(this));
        this.b = intelExtnTodoAdapter;
        intelExtnTodoAdapter.n0(new p0(this));
        FragmentToDoBinding fragmentToDoBinding = this.f6287a;
        FragmentToDoBinding fragmentToDoBinding2 = null;
        if (fragmentToDoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding = null;
        }
        fragmentToDoBinding.h.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            FragmentToDoBinding fragmentToDoBinding3 = this.f6287a;
            if (fragmentToDoBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentToDoBinding3 = null;
            }
            RecyclerView recyclerView = fragmentToDoBinding3.h;
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(activity, 1);
            Drawable drawable = ContextCompat.getDrawable(activity, R.drawable.tl_linear_verical_divider_12);
            if (drawable != null) {
                dividerItemDecoration.setDrawable(drawable);
            }
            recyclerView.addItemDecoration(dividerItemDecoration);
        }
        FragmentToDoBinding fragmentToDoBinding4 = this.f6287a;
        if (fragmentToDoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentToDoBinding2 = fragmentToDoBinding4;
        }
        fragmentToDoBinding2.h.setAdapter(this.b);
    }

    public final IntelExtnTodoViewModel D0() {
        return (IntelExtnTodoViewModel) this.d.getValue();
    }

    public final void E0() {
        List data;
        NoteBean noteBean = this.c;
        if (noteBean != null) {
            IntelExtnTodoAdapter intelExtnTodoAdapter = this.b;
            if (!(intelExtnTodoAdapter == null || (data = intelExtnTodoAdapter.getData()) == null)) {
                data.clear();
            }
            Integer num = (Integer) D0().H().getValue();
            if (num == null) {
                num = 0;
            }
            Intrinsics.checkNotNull(num);
            if (num.intValue() > 0) {
                LogExt.j("getTodo from db todo", "ToDoFragment");
                D0().L(noteBean, true);
                return;
            }
            LogExt.j("getTodo from server noteBean=" + this.c, "ToDoFragment");
            FragmentToDoBinding fragmentToDoBinding = this.f6287a;
            if (fragmentToDoBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentToDoBinding = null;
            }
            fragmentToDoBinding.g.setEnabled(false);
            FragmentToDoBinding fragmentToDoBinding2 = this.f6287a;
            if (fragmentToDoBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentToDoBinding2 = null;
            }
            MzButton mzButton = fragmentToDoBinding2.g;
            Intrinsics.checkNotNullExpressionValue(mzButton, "mbtTodo");
            mzButton.setVisibility(0);
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.b(), (CoroutineStart) null, new ToDoFragment$getTodo$1$1(this, noteBean, (Continuation<? super ToDoFragment$getTodo$1$1>) null), 2, (Object) null);
        }
    }

    public final void F0() {
        List data;
        FragmentToDoBinding fragmentToDoBinding = this.f6287a;
        FragmentToDoBinding fragmentToDoBinding2 = null;
        if (fragmentToDoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding = null;
        }
        Group group = fragmentToDoBinding.b;
        Intrinsics.checkNotNullExpressionValue(group, "gpTodoList");
        if (group.getVisibility() == 0) {
            IntelExtnTodoAdapter intelExtnTodoAdapter = this.b;
            if (!(intelExtnTodoAdapter == null || (data = intelExtnTodoAdapter.getData()) == null || data.isEmpty())) {
                if (!TranslatorConstants.isIntlVersion()) {
                    FragmentToDoBinding fragmentToDoBinding3 = this.f6287a;
                    if (fragmentToDoBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        fragmentToDoBinding3 = null;
                    }
                    fragmentToDoBinding3.j.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
                    FragmentToDoBinding fragmentToDoBinding4 = this.f6287a;
                    if (fragmentToDoBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        fragmentToDoBinding4 = null;
                    }
                    TextView textView = fragmentToDoBinding4.k;
                    Intrinsics.checkNotNullExpressionValue(textView, "tvOuterReported");
                    textView.setVisibility(8);
                } else {
                    boolean isReported = ((IntelExtnTodo) data.get(0)).isReported();
                    LogExt.j("handleAiMark isReported=" + isReported, "ToDoFragment");
                    if (isReported) {
                        FragmentToDoBinding fragmentToDoBinding5 = this.f6287a;
                        if (fragmentToDoBinding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                            fragmentToDoBinding5 = null;
                        }
                        fragmentToDoBinding5.j.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
                        FragmentToDoBinding fragmentToDoBinding6 = this.f6287a;
                        if (fragmentToDoBinding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                            fragmentToDoBinding6 = null;
                        }
                        TextView textView2 = fragmentToDoBinding6.k;
                        Intrinsics.checkNotNullExpressionValue(textView2, "tvOuterReported");
                        textView2.setVisibility(0);
                    } else {
                        FragmentToDoBinding fragmentToDoBinding7 = this.f6287a;
                        if (fragmentToDoBinding7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                            fragmentToDoBinding7 = null;
                        }
                        fragmentToDoBinding7.j.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.icon_tl_smart_extract_report, 0);
                        FragmentToDoBinding fragmentToDoBinding8 = this.f6287a;
                        if (fragmentToDoBinding8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                            fragmentToDoBinding8 = null;
                        }
                        TextView textView3 = fragmentToDoBinding8.k;
                        Intrinsics.checkNotNullExpressionValue(textView3, "tvOuterReported");
                        textView3.setVisibility(8);
                    }
                }
            }
            FragmentToDoBinding fragmentToDoBinding9 = this.f6287a;
            if (fragmentToDoBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentToDoBinding2 = fragmentToDoBinding9;
            }
            fragmentToDoBinding2.h.post(new l0(this));
        }
    }

    public final void H0(List list) {
        Unit unit;
        List data;
        FragmentToDoBinding fragmentToDoBinding = null;
        if (!list.isEmpty()) {
            FragmentToDoBinding fragmentToDoBinding2 = this.f6287a;
            if (fragmentToDoBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentToDoBinding2 = null;
            }
            Group group = fragmentToDoBinding2.b;
            Intrinsics.checkNotNullExpressionValue(group, "gpTodoList");
            group.setVisibility(0);
            FragmentToDoBinding fragmentToDoBinding3 = this.f6287a;
            if (fragmentToDoBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentToDoBinding3 = null;
            }
            Group group2 = fragmentToDoBinding3.c;
            Intrinsics.checkNotNullExpressionValue(group2, "gpTodoTip");
            group2.setVisibility(8);
            FragmentToDoBinding fragmentToDoBinding4 = this.f6287a;
            if (fragmentToDoBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentToDoBinding = fragmentToDoBinding4;
            }
            MzButton mzButton = fragmentToDoBinding.g;
            Intrinsics.checkNotNullExpressionValue(mzButton, "mbtTodo");
            mzButton.setVisibility(8);
            IntelExtnTodoAdapter intelExtnTodoAdapter = this.b;
            if (!(intelExtnTodoAdapter == null || (data = intelExtnTodoAdapter.getData()) == null)) {
                data.clear();
            }
            IntelExtnTodoAdapter intelExtnTodoAdapter2 = this.b;
            if (intelExtnTodoAdapter2 != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                intelExtnTodoAdapter2.r(arrayList);
            }
            V0(list);
            F0();
            return;
        }
        NoteBean noteBean = this.c;
        if (noteBean != null) {
            if (D0().P(noteBean)) {
                FragmentToDoBinding fragmentToDoBinding5 = this.f6287a;
                if (fragmentToDoBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentToDoBinding5 = null;
                }
                Group group3 = fragmentToDoBinding5.c;
                Intrinsics.checkNotNullExpressionValue(group3, "gpTodoTip");
                group3.setVisibility(8);
                FragmentToDoBinding fragmentToDoBinding6 = this.f6287a;
                if (fragmentToDoBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentToDoBinding6 = null;
                }
                TranslatorLoadingView translatorLoadingView = fragmentToDoBinding6.f;
                Intrinsics.checkNotNullExpressionValue(translatorLoadingView, "loadingView");
                translatorLoadingView.setVisibility(0);
                FragmentToDoBinding fragmentToDoBinding7 = this.f6287a;
                if (fragmentToDoBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentToDoBinding7 = null;
                }
                TextView textView = fragmentToDoBinding7.i;
                Intrinsics.checkNotNullExpressionValue(textView, "tvLoadingBackground");
                textView.setVisibility(0);
                FragmentToDoBinding fragmentToDoBinding8 = this.f6287a;
                if (fragmentToDoBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentToDoBinding8 = null;
                }
                MzButton mzButton2 = fragmentToDoBinding8.g;
                Intrinsics.checkNotNullExpressionValue(mzButton2, "mbtTodo");
                mzButton2.setVisibility(0);
                FragmentToDoBinding fragmentToDoBinding9 = this.f6287a;
                if (fragmentToDoBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentToDoBinding9 = null;
                }
                fragmentToDoBinding9.g.setEnabled(false);
                D0().K(noteBean);
                unit = Unit.INSTANCE;
            } else {
                FragmentToDoBinding fragmentToDoBinding10 = this.f6287a;
                if (fragmentToDoBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentToDoBinding10 = null;
                }
                Group group4 = fragmentToDoBinding10.b;
                Intrinsics.checkNotNullExpressionValue(group4, "gpTodoList");
                group4.setVisibility(8);
                FragmentToDoBinding fragmentToDoBinding11 = this.f6287a;
                if (fragmentToDoBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentToDoBinding11 = null;
                }
                Group group5 = fragmentToDoBinding11.c;
                Intrinsics.checkNotNullExpressionValue(group5, "gpTodoTip");
                group5.setVisibility(0);
                FragmentToDoBinding fragmentToDoBinding12 = this.f6287a;
                if (fragmentToDoBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentToDoBinding12 = null;
                }
                MzButton mzButton3 = fragmentToDoBinding12.g;
                Intrinsics.checkNotNullExpressionValue(mzButton3, "mbtTodo");
                mzButton3.setVisibility(0);
                FragmentToDoBinding fragmentToDoBinding13 = this.f6287a;
                if (fragmentToDoBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentToDoBinding13 = null;
                }
                fragmentToDoBinding13.g.setEnabled(true);
                IntelExtnTodoAdapter intelExtnTodoAdapter3 = this.b;
                if (intelExtnTodoAdapter3 != null) {
                    if (!intelExtnTodoAdapter3.getData().isEmpty()) {
                        intelExtnTodoAdapter3.getData().clear();
                        intelExtnTodoAdapter3.notifyDataSetChanged();
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
            }
            if (unit != null) {
                return;
            }
        }
        FragmentToDoBinding fragmentToDoBinding14 = this.f6287a;
        if (fragmentToDoBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding14 = null;
        }
        Group group6 = fragmentToDoBinding14.b;
        Intrinsics.checkNotNullExpressionValue(group6, "gpTodoList");
        group6.setVisibility(8);
        FragmentToDoBinding fragmentToDoBinding15 = this.f6287a;
        if (fragmentToDoBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding15 = null;
        }
        Group group7 = fragmentToDoBinding15.c;
        Intrinsics.checkNotNullExpressionValue(group7, "gpTodoTip");
        group7.setVisibility(0);
        FragmentToDoBinding fragmentToDoBinding16 = this.f6287a;
        if (fragmentToDoBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding16 = null;
        }
        MzButton mzButton4 = fragmentToDoBinding16.g;
        Intrinsics.checkNotNullExpressionValue(mzButton4, "mbtTodo");
        mzButton4.setVisibility(0);
        FragmentToDoBinding fragmentToDoBinding17 = this.f6287a;
        if (fragmentToDoBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentToDoBinding = fragmentToDoBinding17;
        }
        fragmentToDoBinding.g.setEnabled(true);
        IntelExtnTodoAdapter intelExtnTodoAdapter4 = this.b;
        if (intelExtnTodoAdapter4 != null) {
            if (!intelExtnTodoAdapter4.getData().isEmpty()) {
                intelExtnTodoAdapter4.getData().clear();
                intelExtnTodoAdapter4.notifyDataSetChanged();
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final void J0(IntelExtnShareViewModel.ImeBean imeBean) {
        FragmentToDoBinding fragmentToDoBinding = this.f6287a;
        if (fragmentToDoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding = null;
        }
        RecyclerView recyclerView = fragmentToDoBinding.h;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rvTodo");
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = imeBean.a();
            recyclerView.setLayoutParams(marginLayoutParams);
            FragmentToDoBinding fragmentToDoBinding2 = this.f6287a;
            if (fragmentToDoBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentToDoBinding2 = null;
            }
            RecyclerView.LayoutManager layoutManager = fragmentToDoBinding2.h.getLayoutManager();
            if (layoutManager != null) {
                int childCount = layoutManager.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = layoutManager.getChildAt(i);
                    EditText editText = childAt != null ? (EditText) childAt.findViewById(R.id.et_todo_content) : null;
                    if (editText != null && (editText instanceof ClipboardEditText)) {
                        ClipboardEditText clipboardEditText = (ClipboardEditText) editText;
                        if (clipboardEditText.q()) {
                            LogExt.j("Todo et edit [imeVisible=" + imeBean.b() + ", position=" + i + "]", "ToDoFragment");
                            if (imeBean.b()) {
                                this.f = clipboardEditText;
                                return;
                            } else if (Intrinsics.areEqual((Object) this.f, (Object) editText)) {
                                LogExt.j("Todo et edit hided", "ToDoFragment");
                                clipboardEditText.j();
                            } else {
                                return;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void K0(IntelExtnTodo intelExtnTodo) {
        if (intelExtnTodo.getCalendarId() != 0) {
            D0().Z(intelExtnTodo, true, new ToDoFragment$handleScheduleTodo$1(this));
            IntelExtnTodoAdapter intelExtnTodoAdapter = this.b;
            if (intelExtnTodoAdapter != null) {
                int i = 0;
                for (IntelExtnTodo id : intelExtnTodoAdapter.getData()) {
                    int i2 = i + 1;
                    if (intelExtnTodo.getId() == id.getId()) {
                        intelExtnTodoAdapter.j0(i, intelExtnTodo);
                        return;
                    }
                    i = i2;
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [kotlin.Unit] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void M0(com.xjsd.xr.sapp.asr.dao.SmartExTodo r7) {
        /*
            r6 = this;
            com.upuphone.ar.translation.phone.bean.NoteBean r0 = r6.c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleTodo resTodo="
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = ", noteBean="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "ToDoFragment"
            com.upuphone.ar.translation.ext.LogExt.j(r0, r1)
            com.upuphone.ar.translation.phone.databinding.FragmentToDoBinding r0 = r6.f6287a
            java.lang.String r2 = "mBinding"
            r3 = 0
            if (r0 != 0) goto L_0x002b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r3
        L_0x002b:
            com.upuphone.ar.translation.phone.view.TranslatorLoadingView r0 = r0.f
            java.lang.String r4 = "loadingView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            r4 = 8
            r0.setVisibility(r4)
            com.upuphone.ar.translation.phone.databinding.FragmentToDoBinding r0 = r6.f6287a
            if (r0 != 0) goto L_0x003f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r3
        L_0x003f:
            android.widget.TextView r0 = r0.i
            java.lang.String r5 = "tvLoadingBackground"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            r0.setVisibility(r4)
            com.upuphone.ar.translation.phone.databinding.FragmentToDoBinding r0 = r6.f6287a
            if (r0 != 0) goto L_0x0052
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r3
        L_0x0052:
            com.meizu.common.widget.MzButton r0 = r0.g
            r4 = 1
            r0.setEnabled(r4)
            if (r7 == 0) goto L_0x00ad
            int r0 = r7.getBaseStatus()
            if (r0 == 0) goto L_0x00a8
            if (r0 == r4) goto L_0x00a4
            r7 = 2
            if (r0 == r7) goto L_0x00a0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r4 = "handleServerSummary 异常情况需要云端查看"
            r7.append(r4)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.upuphone.ar.translation.ext.LogExt.j(r7, r1)
            com.upuphone.ar.translation.phone.databinding.FragmentToDoBinding r7 = r6.f6287a
            if (r7 != 0) goto L_0x0081
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r7 = r3
        L_0x0081:
            androidx.constraintlayout.widget.Group r7 = r7.c
            java.lang.String r0 = "gpTodoTip"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            r0 = 0
            r7.setVisibility(r0)
            com.upuphone.ar.translation.phone.databinding.FragmentToDoBinding r7 = r6.f6287a
            if (r7 != 0) goto L_0x0094
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x0095
        L_0x0094:
            r3 = r7
        L_0x0095:
            com.meizu.common.widget.MzButton r7 = r3.g
            java.lang.String r1 = "mbtTodo"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            r7.setVisibility(r0)
            goto L_0x00ab
        L_0x00a0:
            r6.N0()
            goto L_0x00ab
        L_0x00a4:
            r6.N0()
            goto L_0x00ab
        L_0x00a8:
            r6.O0(r7)
        L_0x00ab:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x00ad:
            if (r3 != 0) goto L_0x00b2
            r6.handleTodoFailure()
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.fragment.ToDoFragment.M0(com.xjsd.xr.sapp.asr.dao.SmartExTodo):void");
    }

    public final void N0() {
        D0().V(R.string.tl_generate_to_do_empty);
        FragmentToDoBinding fragmentToDoBinding = this.f6287a;
        FragmentToDoBinding fragmentToDoBinding2 = null;
        if (fragmentToDoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding = null;
        }
        Group group = fragmentToDoBinding.c;
        Intrinsics.checkNotNullExpressionValue(group, "gpTodoTip");
        group.setVisibility(0);
        FragmentToDoBinding fragmentToDoBinding3 = this.f6287a;
        if (fragmentToDoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentToDoBinding2 = fragmentToDoBinding3;
        }
        MzButton mzButton = fragmentToDoBinding2.g;
        Intrinsics.checkNotNullExpressionValue(mzButton, "mbtTodo");
        mzButton.setVisibility(0);
    }

    public final void O0(SmartExTodo smartExTodo) {
        NoteBean noteBean = this.c;
        if (noteBean != null) {
            ArrayList<SmartExTodo.ToDo> todoList = smartExTodo.getTodoList();
            if (todoList.isEmpty()) {
                N0();
                return;
            }
            FragmentToDoBinding fragmentToDoBinding = this.f6287a;
            FragmentToDoBinding fragmentToDoBinding2 = null;
            if (fragmentToDoBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentToDoBinding = null;
            }
            MzButton mzButton = fragmentToDoBinding.g;
            Intrinsics.checkNotNullExpressionValue(mzButton, "mbtTodo");
            mzButton.setVisibility(8);
            FragmentToDoBinding fragmentToDoBinding3 = this.f6287a;
            if (fragmentToDoBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentToDoBinding2 = fragmentToDoBinding3;
            }
            Group group = fragmentToDoBinding2.b;
            Intrinsics.checkNotNullExpressionValue(group, "gpTodoList");
            group.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            Iterator<SmartExTodo.ToDo> it = todoList.iterator();
            int i = 0;
            while (it.hasNext()) {
                i++;
                SmartExTodo.ToDo next = it.next();
                IntelExtnTodo intelExtnTodo = new IntelExtnTodo();
                intelExtnTodo.setItemType(0);
                intelExtnTodo.setTitle(getResources().getString(R.string.tl_to_do_simple) + " " + i);
                intelExtnTodo.setContent(next.getContent());
                intelExtnTodo.setOriginalContent(next.getContent());
                intelExtnTodo.setStartTime(next.getStartTime());
                intelExtnTodo.setEndTime(next.getEndTime());
                intelExtnTodo.setAccountId(noteBean.getAccountId());
                intelExtnTodo.setRecognizeId(noteBean.getRecognizeId());
                intelExtnTodo.setRequestId(smartExTodo.getRequestId());
                arrayList.add(intelExtnTodo);
            }
            D0().O(arrayList, noteBean);
        }
    }

    public final void handleTodoFailure() {
        D0().V(R.string.tl_generate_content_fail);
        FragmentToDoBinding fragmentToDoBinding = this.f6287a;
        FragmentToDoBinding fragmentToDoBinding2 = null;
        if (fragmentToDoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentToDoBinding = null;
        }
        Group group = fragmentToDoBinding.c;
        Intrinsics.checkNotNullExpressionValue(group, "gpTodoTip");
        group.setVisibility(0);
        FragmentToDoBinding fragmentToDoBinding3 = this.f6287a;
        if (fragmentToDoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentToDoBinding2 = fragmentToDoBinding3;
        }
        MzButton mzButton = fragmentToDoBinding2.g;
        Intrinsics.checkNotNullExpressionValue(mzButton, "mbtTodo");
        mzButton.setVisibility(0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.c = (NoteBean) arguments.getSerializable(TranslatorConstants.TRANSFER_TRANS_RECORD, NoteBean.class);
            } else {
                Serializable serializable = arguments.getSerializable(TranslatorConstants.TRANSFER_TRANS_RECORD);
                if (serializable != null && (serializable instanceof NoteBean)) {
                    this.c = (NoteBean) serializable;
                }
            }
        }
        NoteBean noteBean = this.c;
        LogExt.j("翻译记录对象 " + noteBean, "ToDoFragment");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentToDoBinding c2 = FragmentToDoBinding.c(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6287a = c2;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            c2 = null;
        }
        ConstraintLayout b2 = c2.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        return b2;
    }

    public void onDestroyView() {
        super.onDestroyView();
        D0().X();
    }

    public void onResume() {
        super.onResume();
        D0().S(new ToDoFragment$onResume$1(this));
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initViews();
        initData();
        initListener();
        initViewModels();
    }
}
