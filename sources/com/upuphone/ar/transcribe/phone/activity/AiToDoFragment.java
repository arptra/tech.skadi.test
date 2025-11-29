package com.upuphone.ar.transcribe.phone.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.honey.account.v4.d;
import com.honey.account.v4.e;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.databinding.FragmentTranscribeTodoBinding;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.adapter.AiTodoAdapter;
import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.repo.AiResponseSensitive;
import com.upuphone.ar.transcribe.phone.vm.AiShareViewModel;
import com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel;
import com.upuphone.star.common.phone.UToast;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\rH\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0002J\u0012\u0010#\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\rH\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\u0016\u0010&\u001a\u00020\u00192\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\b\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\b\u0010*\u001a\u00020\u0019H\u0002J\b\u0010+\u001a\u00020\u0019H\u0002J\u0012\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J$\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00105\u001a\u00020\u0019H\u0016J\b\u00106\u001a\u00020\u0019H\u0016J\u001a\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u0002002\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00109\u001a\u00020\u0019H\u0002J\u0012\u0010:\u001a\u00020\u00192\b\b\u0001\u0010;\u001a\u00020<H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\tX\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006>"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/AiToDoFragment;", "Landroidx/fragment/app/Fragment;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "adapter", "Lcom/upuphone/ar/transcribe/phone/adapter/AiTodoAdapter;", "binding", "Lcom/upuphone/ar/transcribe/databinding/FragmentTranscribeTodoBinding;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "isFirst", "", "notebean", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "shareViewModel", "Lcom/upuphone/ar/transcribe/phone/vm/AiShareViewModel;", "todoViewModel", "Lcom/upuphone/ar/transcribe/phone/vm/AiTodoViewModel;", "getTodoViewModel", "()Lcom/upuphone/ar/transcribe/phone/vm/AiTodoViewModel;", "todoViewModel$delegate", "Lkotlin/Lazy;", "createTodo", "", "handleDbData", "list", "", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;", "handleReport", "success", "handleSensitive", "sensitive", "Lcom/upuphone/ar/transcribe/phone/repo/AiResponseSensitive;", "handleTodoEmpty", "toast", "handleTodoFailure", "handleTodoSuccess", "todos", "initData", "initListener", "initViewModels", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onResume", "onViewCreated", "view", "showLoading", "toToast", "stringResId", "", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAiToDoFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiToDoFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/AiToDoFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,369:1\n106#2,15:370\n262#3,2:385\n262#3,2:387\n262#3,2:391\n262#3,2:393\n262#3,2:395\n262#3,2:397\n262#3,2:399\n262#3,2:401\n262#3,2:403\n262#3,2:405\n262#3,2:407\n262#3,2:409\n262#3,2:411\n262#3,2:413\n262#3,2:415\n262#3,2:417\n262#3,2:419\n262#3,2:421\n1855#4,2:389\n*S KotlinDebug\n*F\n+ 1 AiToDoFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/AiToDoFragment\n*L\n65#1:370,15\n279#1:385,2\n281#1:387,2\n308#1:391,2\n309#1:393,2\n311#1:395,2\n319#1:397,2\n320#1:399,2\n322#1:401,2\n326#1:403,2\n327#1:405,2\n332#1:407,2\n334#1:409,2\n335#1:411,2\n345#1:413,2\n346#1:415,2\n347#1:417,2\n362#1:419,2\n363#1:421,2\n295#1:389,2\n*E\n"})
public final class AiToDoFragment extends Fragment implements CoroutineScope {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "AiToDoFragment";
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.b();
    /* access modifiers changed from: private */
    @Nullable
    public AiTodoAdapter adapter;
    /* access modifiers changed from: private */
    public FragmentTranscribeTodoBinding binding;
    private boolean isFirst = true;
    /* access modifiers changed from: private */
    @Nullable
    public TranscribeBean notebean;
    /* access modifiers changed from: private */
    public AiShareViewModel shareViewModel;
    @NotNull
    private final Lazy todoViewModel$delegate;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/AiToDoFragment$Companion;", "", "()V", "TAG", "", "getInstance", "Lcom/upuphone/ar/transcribe/phone/activity/AiToDoFragment;", "noteBean", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AiToDoFragment getInstance(@Nullable TranscribeBean transcribeBean) {
            AiToDoFragment aiToDoFragment = new AiToDoFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_record_bean", transcribeBean);
            aiToDoFragment.setArguments(bundle);
            return aiToDoFragment;
        }

        private Companion() {
        }
    }

    public AiToDoFragment() {
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new AiToDoFragment$special$$inlined$viewModels$default$2(new AiToDoFragment$special$$inlined$viewModels$default$1(this)));
        this.todoViewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(AiTodoViewModel.class), new AiToDoFragment$special$$inlined$viewModels$default$3(lazy), new AiToDoFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new AiToDoFragment$special$$inlined$viewModels$default$5(this, lazy));
    }

    /* access modifiers changed from: private */
    public final void createTodo() {
        TranscribeBean transcribeBean = this.notebean;
        LogExt.g("creatingTodo noteBean: " + transcribeBean, TAG);
        TranscribeBean transcribeBean2 = this.notebean;
        if (transcribeBean2 != null) {
            Job unused = BuildersKt__Builders_commonKt.d(this, Dispatchers.c(), (CoroutineStart) null, new AiToDoFragment$createTodo$1$1(transcribeBean2, this, (Continuation<? super AiToDoFragment$createTodo$1$1>) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final AiTodoViewModel getTodoViewModel() {
        return (AiTodoViewModel) this.todoViewModel$delegate.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.upuphone.ar.transcribe.phone.vm.AiShareViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.upuphone.ar.transcribe.databinding.FragmentTranscribeTodoBinding} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleDbData(java.util.List<com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity> r10) {
        /*
            r9 = this;
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeTodoBinding r0 = r9.binding
            java.lang.String r1 = "binding"
            r2 = 0
            if (r0 != 0) goto L_0x000b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x000b:
            androidx.constraintlayout.widget.Group r0 = r0.b
            java.lang.String r3 = "gpLoading"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            r3 = 8
            r0.setVisibility(r3)
            boolean r0 = r10.isEmpty()
            java.lang.String r4 = "mbtTodo"
            java.lang.String r5 = "gpTodoTip"
            r6 = 1
            r7 = 0
            if (r0 == 0) goto L_0x006b
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeTodoBinding r10 = r9.binding
            if (r10 != 0) goto L_0x002b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r10 = r2
        L_0x002b:
            androidx.constraintlayout.widget.Group r10 = r10.c
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r5)
            r10.setVisibility(r7)
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeTodoBinding r10 = r9.binding
            if (r10 != 0) goto L_0x003b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r10 = r2
        L_0x003b:
            com.meizu.common.widget.MzButton r10 = r10.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r4)
            r10.setVisibility(r7)
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeTodoBinding r10 = r9.binding
            if (r10 != 0) goto L_0x004b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x004c
        L_0x004b:
            r2 = r10
        L_0x004c:
            com.meizu.common.widget.MzButton r10 = r2.f
            r10.setEnabled(r6)
            com.upuphone.ar.transcribe.phone.adapter.AiTodoAdapter r9 = r9.adapter
            if (r9 == 0) goto L_0x00c8
            java.util.List r10 = r9.getData()
            boolean r10 = r10.isEmpty()
            r10 = r10 ^ r6
            if (r10 == 0) goto L_0x00c8
            java.util.List r10 = r9.getData()
            r10.clear()
            r9.notifyDataSetChanged()
            goto L_0x00c8
        L_0x006b:
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeTodoBinding r0 = r9.binding
            if (r0 != 0) goto L_0x0073
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0073:
            androidx.recyclerview.widget.RecyclerView r0 = r0.g
            java.lang.String r8 = "rvTodo"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r8)
            r0.setVisibility(r7)
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeTodoBinding r0 = r9.binding
            if (r0 != 0) goto L_0x0085
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0085:
            androidx.constraintlayout.widget.Group r0 = r0.c
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            r0.setVisibility(r3)
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeTodoBinding r0 = r9.binding
            if (r0 != 0) goto L_0x0095
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0095:
            com.meizu.common.widget.MzButton r0 = r0.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            r0.setVisibility(r3)
            com.upuphone.ar.transcribe.phone.adapter.AiTodoAdapter r0 = r9.adapter
            if (r0 == 0) goto L_0x00aa
            java.util.List r0 = r0.getData()
            if (r0 == 0) goto L_0x00aa
            r0.clear()
        L_0x00aa:
            com.upuphone.ar.transcribe.phone.adapter.AiTodoAdapter r0 = r9.adapter
            if (r0 == 0) goto L_0x00b1
            r0.r(r10)
        L_0x00b1:
            com.upuphone.ar.transcribe.phone.vm.AiShareViewModel r9 = r9.shareViewModel
            if (r9 != 0) goto L_0x00bb
            java.lang.String r9 = "shareViewModel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            goto L_0x00bc
        L_0x00bb:
            r2 = r9
        L_0x00bc:
            int r9 = r10.size()
            int r9 = r9 - r6
            java.util.List r9 = r10.subList(r7, r9)
            r2.p(r9)
        L_0x00c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.activity.AiToDoFragment.handleDbData(java.util.List):void");
    }

    /* access modifiers changed from: private */
    public final void handleReport(boolean z) {
        List<AiTodoEntity> data;
        AiTodoAdapter aiTodoAdapter = this.adapter;
        if (aiTodoAdapter != null && (data = aiTodoAdapter.getData()) != null) {
            for (AiTodoEntity reported : data) {
                reported.setReported(Integer.valueOf(z ? 1 : 0));
                AiTodoAdapter aiTodoAdapter2 = this.adapter;
                if (aiTodoAdapter2 != null) {
                    aiTodoAdapter2.notifyDataSetChanged();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void handleSensitive(AiResponseSensitive aiResponseSensitive) {
        if (Intrinsics.areEqual((Object) aiResponseSensitive.getRiskLevel(), (Object) "LOCKED")) {
            UToast.Companion companion = UToast.f6444a;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            companion.d(requireContext, aiResponseSensitive.getRiskDescription());
        } else {
            toToast(R.string.tl_generate_sensitive_disable_func);
        }
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding = this.binding;
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding2 = null;
        if (fragmentTranscribeTodoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeTodoBinding = null;
        }
        fragmentTranscribeTodoBinding.f.setEnabled(true);
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding3 = this.binding;
        if (fragmentTranscribeTodoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeTodoBinding3 = null;
        }
        MzButton mzButton = fragmentTranscribeTodoBinding3.f;
        Intrinsics.checkNotNullExpressionValue(mzButton, "mbtTodo");
        mzButton.setVisibility(0);
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding4 = this.binding;
        if (fragmentTranscribeTodoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTranscribeTodoBinding2 = fragmentTranscribeTodoBinding4;
        }
        Group group = fragmentTranscribeTodoBinding2.c;
        Intrinsics.checkNotNullExpressionValue(group, "gpTodoTip");
        group.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void handleTodoEmpty(boolean z) {
        if (z) {
            toToast(R.string.tl_generate_to_do_empty);
        }
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding = this.binding;
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding2 = null;
        if (fragmentTranscribeTodoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeTodoBinding = null;
        }
        Group group = fragmentTranscribeTodoBinding.c;
        Intrinsics.checkNotNullExpressionValue(group, "gpTodoTip");
        group.setVisibility(0);
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding3 = this.binding;
        if (fragmentTranscribeTodoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeTodoBinding3 = null;
        }
        MzButton mzButton = fragmentTranscribeTodoBinding3.f;
        Intrinsics.checkNotNullExpressionValue(mzButton, "mbtTodo");
        mzButton.setVisibility(0);
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding4 = this.binding;
        if (fragmentTranscribeTodoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeTodoBinding4 = null;
        }
        fragmentTranscribeTodoBinding4.f.setEnabled(true);
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding5 = this.binding;
        if (fragmentTranscribeTodoBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTranscribeTodoBinding2 = fragmentTranscribeTodoBinding5;
        }
        RecyclerView recyclerView = fragmentTranscribeTodoBinding2.g;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rvTodo");
        recyclerView.setVisibility(8);
    }

    public static /* synthetic */ void handleTodoEmpty$default(AiToDoFragment aiToDoFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        aiToDoFragment.handleTodoEmpty(z);
    }

    /* access modifiers changed from: private */
    public final void handleTodoFailure() {
        toToast(R.string.tl_generate_content_fail);
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding = this.binding;
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding2 = null;
        if (fragmentTranscribeTodoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeTodoBinding = null;
        }
        Group group = fragmentTranscribeTodoBinding.c;
        Intrinsics.checkNotNullExpressionValue(group, "gpTodoTip");
        group.setVisibility(0);
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding3 = this.binding;
        if (fragmentTranscribeTodoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeTodoBinding3 = null;
        }
        MzButton mzButton = fragmentTranscribeTodoBinding3.f;
        Intrinsics.checkNotNullExpressionValue(mzButton, "mbtTodo");
        mzButton.setVisibility(0);
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding4 = this.binding;
        if (fragmentTranscribeTodoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeTodoBinding4 = null;
        }
        fragmentTranscribeTodoBinding4.f.setEnabled(true);
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding5 = this.binding;
        if (fragmentTranscribeTodoBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTranscribeTodoBinding2 = fragmentTranscribeTodoBinding5;
        }
        RecyclerView recyclerView = fragmentTranscribeTodoBinding2.g;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rvTodo");
        recyclerView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void handleTodoSuccess(List<AiTodoEntity> list) {
        AiShareViewModel aiShareViewModel;
        List data;
        List<AiTodoEntity> list2 = list;
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding = this.binding;
        if (fragmentTranscribeTodoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeTodoBinding = null;
        }
        MzButton mzButton = fragmentTranscribeTodoBinding.f;
        Intrinsics.checkNotNullExpressionValue(mzButton, "mbtTodo");
        mzButton.setVisibility(8);
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding2 = this.binding;
        if (fragmentTranscribeTodoBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeTodoBinding2 = null;
        }
        RecyclerView recyclerView = fragmentTranscribeTodoBinding2.g;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rvTodo");
        recyclerView.setVisibility(0);
        AiTodoAdapter aiTodoAdapter = this.adapter;
        if (!(aiTodoAdapter == null || (data = aiTodoAdapter.getData()) == null)) {
            data.clear();
        }
        AiTodoAdapter aiTodoAdapter2 = this.adapter;
        if (aiTodoAdapter2 != null) {
            aiTodoAdapter2.r(list2);
        }
        AiTodoAdapter aiTodoAdapter3 = this.adapter;
        if (aiTodoAdapter3 != null) {
            AiTodoEntity aiTodoEntity = r6;
            AiTodoEntity aiTodoEntity2 = new AiTodoEntity(0, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (Integer) null, false, (String) null, (Integer) null, false, 65535, (DefaultConstructorMarker) null);
            aiTodoEntity.setReported(((AiTodoEntity) CollectionsKt.first(list)).getReported());
            aiTodoEntity.setItemType(1);
            aiTodoAdapter3.q(aiTodoEntity);
        }
        AiTodoAdapter aiTodoAdapter4 = this.adapter;
        if (aiTodoAdapter4 != null) {
            aiTodoAdapter4.notifyDataSetChanged();
        }
        AiShareViewModel aiShareViewModel2 = this.shareViewModel;
        if (aiShareViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareViewModel");
            aiShareViewModel = null;
        } else {
            aiShareViewModel = aiShareViewModel2;
        }
        aiShareViewModel.p(list2.subList(0, list.size() - 1));
    }

    private final void initData() {
        String recognizeId;
        TranscribeBean transcribeBean = this.notebean;
        if (transcribeBean != null) {
            String account = transcribeBean.getAccount();
            if (account == null || StringsKt.isBlank(account) || (recognizeId = transcribeBean.getRecognizeId()) == null || StringsKt.isBlank(recognizeId)) {
                LogExt.g("initData 数据库中无待办事项", TAG);
            } else {
                getTodoViewModel().D(transcribeBean);
            }
        }
    }

    private final void initListener() {
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding = this.binding;
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding2 = null;
        if (fragmentTranscribeTodoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeTodoBinding = null;
        }
        fragmentTranscribeTodoBinding.f.setOnClickListener(new e(this));
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding3 = this.binding;
        if (fragmentTranscribeTodoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTranscribeTodoBinding2 = fragmentTranscribeTodoBinding3;
        }
        fragmentTranscribeTodoBinding2.g.addOnItemTouchListener(new AiToDoFragment$initListener$2(this));
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$6(AiToDoFragment aiToDoFragment, View view) {
        Intrinsics.checkNotNullParameter(aiToDoFragment, "this$0");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(aiToDoFragment), Dispatchers.b(), (CoroutineStart) null, new AiToDoFragment$initListener$1$1(aiToDoFragment, (Continuation<? super AiToDoFragment$initListener$1$1>) null), 2, (Object) null);
    }

    private final void initViewModels() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.shareViewModel = (AiShareViewModel) new ViewModelProvider(requireActivity).get(AiShareViewModel.class);
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new AiToDoFragment$initViewModels$1(this, (Continuation<? super AiToDoFragment$initViewModels$1>) null), 3, (Object) null);
    }

    private final void initViews() {
        Drawable drawable;
        AiTodoAdapter aiTodoAdapter = new AiTodoAdapter(new ArrayList(), new AiToDoFragment$initViews$1(this), new AiToDoFragment$initViews$2(this), new AiToDoFragment$initViews$3(this), new AiToDoFragment$initViews$4(this));
        this.adapter = aiTodoAdapter;
        aiTodoAdapter.n0(new d(this));
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding = this.binding;
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding2 = null;
        if (fragmentTranscribeTodoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeTodoBinding = null;
        }
        fragmentTranscribeTodoBinding.g.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding3 = this.binding;
        if (fragmentTranscribeTodoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeTodoBinding3 = null;
        }
        RecyclerView recyclerView = fragmentTranscribeTodoBinding3.g;
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), 1);
        FragmentActivity activity = getActivity();
        if (!(activity == null || (drawable = ContextCompat.getDrawable(activity, R.drawable.linear_verical_divider)) == null)) {
            dividerItemDecoration.setDrawable(drawable);
        }
        recyclerView.addItemDecoration(dividerItemDecoration);
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding4 = this.binding;
        if (fragmentTranscribeTodoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTranscribeTodoBinding2 = fragmentTranscribeTodoBinding4;
        }
        fragmentTranscribeTodoBinding2.g.setAdapter(this.adapter);
    }

    /* access modifiers changed from: private */
    public static final void initViews$lambda$1(AiToDoFragment aiToDoFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(aiToDoFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.tv_add_schedule) {
            Object obj = baseQuickAdapter.getData().get(i);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity");
            AiTodoEntity aiTodoEntity = (AiTodoEntity) obj;
            if (aiTodoEntity.getCalendarEventId() == 0) {
                Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(aiToDoFragment), Dispatchers.b(), (CoroutineStart) null, new AiToDoFragment$initViews$5$1(aiToDoFragment, aiTodoEntity, (Continuation<? super AiToDoFragment$initViews$5$1>) null), 2, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showLoading() {
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding = this.binding;
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding2 = null;
        if (fragmentTranscribeTodoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeTodoBinding = null;
        }
        Group group = fragmentTranscribeTodoBinding.b;
        Intrinsics.checkNotNullExpressionValue(group, "gpLoading");
        group.setVisibility(0);
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding3 = this.binding;
        if (fragmentTranscribeTodoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeTodoBinding3 = null;
        }
        Group group2 = fragmentTranscribeTodoBinding3.c;
        Intrinsics.checkNotNullExpressionValue(group2, "gpTodoTip");
        group2.setVisibility(8);
        FragmentTranscribeTodoBinding fragmentTranscribeTodoBinding4 = this.binding;
        if (fragmentTranscribeTodoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTranscribeTodoBinding2 = fragmentTranscribeTodoBinding4;
        }
        fragmentTranscribeTodoBinding2.f.setEnabled(false);
    }

    /* access modifiers changed from: private */
    public final void toToast(@StringRes int i) {
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        companion.b(requireContext, i);
    }

    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.notebean = Build.VERSION.SDK_INT >= 33 ? (TranscribeBean) arguments.getParcelable("key_record_bean", TranscribeBean.class) : (TranscribeBean) arguments.getParcelable("key_record_bean");
        }
        TranscribeBean transcribeBean = this.notebean;
        LogExt.g("翻译记录对象 " + transcribeBean, TAG);
        initViewModels();
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTranscribeTodoBinding c = FragmentTranscribeTodoBinding.c(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.binding = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        ConstraintLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroy() {
        super.onDestroy();
        AiTodoViewModel todoViewModel = getTodoViewModel();
        TranscribeBean transcribeBean = this.notebean;
        String recognizeId = transcribeBean != null ? transcribeBean.getRecognizeId() : null;
        Intrinsics.checkNotNull(recognizeId);
        todoViewModel.F(recognizeId);
    }

    public void onResume() {
        super.onResume();
        if (this.isFirst) {
            this.isFirst = false;
        } else {
            initData();
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initViews();
        initData();
        initListener();
    }
}
