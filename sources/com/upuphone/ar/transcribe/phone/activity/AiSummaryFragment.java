package com.upuphone.ar.transcribe.phone.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.honey.account.v4.a;
import com.honey.account.v4.b;
import com.honey.account.v4.c;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.databinding.FragmentTranscribeSummaryBinding;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.view.TransLoadingView;
import com.upuphone.ar.transcribe.phone.vm.AiShareViewModel;
import com.upuphone.ar.transcribe.phone.vm.SummaryViewModel;
import com.upuphone.star.common.phone.UToast;
import com.xjsd.xr.sapp.asr.utils.AsrExtKt;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
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

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\u0012\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010&\u001a\u00020\u0015H\u0016J\u001a\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010)\u001a\u00020\u0015H\u0002J\u0012\u0010*\u001a\u00020\u00152\b\b\u0001\u0010+\u001a\u00020,H\u0002J\u0010\u0010*\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u000201H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\tX\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/AiSummaryFragment;", "Landroidx/fragment/app/Fragment;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "aiShareViewModel", "Lcom/upuphone/ar/transcribe/phone/vm/AiShareViewModel;", "binding", "Lcom/upuphone/ar/transcribe/databinding/FragmentTranscribeSummaryBinding;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "summaryViewModel", "Lcom/upuphone/ar/transcribe/phone/vm/SummaryViewModel;", "getSummaryViewModel", "()Lcom/upuphone/ar/transcribe/phone/vm/SummaryViewModel;", "summaryViewModel$delegate", "Lkotlin/Lazy;", "transcribeBean", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "getSummary", "", "handleServerSummary", "resSummary", "Lcom/upuphone/ar/transcribe/phone/repo/AiResponseSummary;", "handleSummaryEmpty", "initData", "initListener", "initViewModels", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", "view", "showLoading", "toToast", "stringResId", "", "string", "", "updateReportView", "report", "", "updateSummaryToDb", "fromEdit", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAiSummaryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiSummaryFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/AiSummaryFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,341:1\n106#2,15:342\n262#3,2:357\n262#3,2:359\n262#3,2:361\n262#3,2:363\n262#3,2:365\n262#3,2:367\n262#3,2:369\n262#3,2:371\n262#3,2:373\n262#3,2:375\n262#3,2:377\n262#3,2:379\n262#3,2:381\n262#3,2:383\n262#3,2:385\n262#3,2:387\n262#3,2:389\n262#3,2:391\n262#3,2:393\n262#3,2:395\n262#3,2:397\n*S KotlinDebug\n*F\n+ 1 AiSummaryFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/AiSummaryFragment\n*L\n55#1:342,15\n133#1:357,2\n134#1:359,2\n224#1:361,2\n225#1:363,2\n238#1:365,2\n243#1:367,2\n244#1:369,2\n252#1:371,2\n253#1:373,2\n254#1:375,2\n258#1:377,2\n259#1:379,2\n274#1:381,2\n275#1:383,2\n276#1:385,2\n317#1:387,2\n318#1:389,2\n320#1:391,2\n321#1:393,2\n324#1:395,2\n325#1:397,2\n*E\n"})
public final class AiSummaryFragment extends Fragment implements CoroutineScope {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "SummaryFragment";
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.b();
    /* access modifiers changed from: private */
    public AiShareViewModel aiShareViewModel;
    /* access modifiers changed from: private */
    public FragmentTranscribeSummaryBinding binding;
    @NotNull
    private final Lazy summaryViewModel$delegate;
    @Nullable
    private TranscribeBean transcribeBean;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/AiSummaryFragment$Companion;", "", "()V", "TAG", "", "getInstance", "Lcom/upuphone/ar/transcribe/phone/activity/AiSummaryFragment;", "noteBean", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final AiSummaryFragment getInstance(@Nullable TranscribeBean transcribeBean) {
            AiSummaryFragment aiSummaryFragment = new AiSummaryFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_record_bean", transcribeBean);
            aiSummaryFragment.setArguments(bundle);
            return aiSummaryFragment;
        }

        private Companion() {
        }
    }

    public AiSummaryFragment() {
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new AiSummaryFragment$special$$inlined$viewModels$default$2(new AiSummaryFragment$special$$inlined$viewModels$default$1(this)));
        this.summaryViewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(SummaryViewModel.class), new AiSummaryFragment$special$$inlined$viewModels$default$3(lazy), new AiSummaryFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new AiSummaryFragment$special$$inlined$viewModels$default$5(this, lazy));
    }

    @JvmStatic
    @NotNull
    public static final AiSummaryFragment getInstance(@Nullable TranscribeBean transcribeBean2) {
        return Companion.getInstance(transcribeBean2);
    }

    /* access modifiers changed from: private */
    public final void getSummary() {
        TranscribeBean transcribeBean2 = this.transcribeBean;
        LogExt.g("getSummary noteBean=" + transcribeBean2, TAG);
        TranscribeBean transcribeBean3 = this.transcribeBean;
        if (transcribeBean3 != null) {
            String account = transcribeBean3.getAccount();
            String mixSpecialData = account != null ? AsrExtKt.mixSpecialData(account) : null;
            String recognizeId = transcribeBean3.getRecognizeId();
            LogExt.g("getSummary accountId=" + mixSpecialData + ", recognizeId=" + recognizeId, TAG);
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new AiSummaryFragment$getSummary$1$1(transcribeBean3, this, (Continuation<? super AiSummaryFragment$getSummary$1$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final SummaryViewModel getSummaryViewModel() {
        return (SummaryViewModel) this.summaryViewModel$delegate.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.upuphone.ar.transcribe.phone.vm.AiShareViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.upuphone.ar.transcribe.databinding.FragmentTranscribeSummaryBinding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: com.upuphone.ar.transcribe.databinding.FragmentTranscribeSummaryBinding} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleServerSummary(com.upuphone.ar.transcribe.phone.repo.AiResponseSummary r9) {
        /*
            r8 = this;
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r0 = r8.transcribeBean
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleServerSummary resSummary="
            r1.append(r2)
            r1.append(r9)
            java.lang.String r2 = ", noteBean="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "SummaryFragment"
            com.upuphone.ar.transcribe.ext.LogExt.g(r0, r1)
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r0 = r8.transcribeBean
            if (r0 == 0) goto L_0x0117
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeSummaryBinding r0 = r8.binding
            java.lang.String r2 = "binding"
            r3 = 0
            if (r0 != 0) goto L_0x002f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r3
        L_0x002f:
            androidx.constraintlayout.widget.Group r0 = r0.c
            java.lang.String r4 = "gpLoading"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            r4 = 8
            r0.setVisibility(r4)
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeSummaryBinding r0 = r8.binding
            if (r0 != 0) goto L_0x0043
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r3
        L_0x0043:
            com.meizu.common.widget.MzButton r0 = r0.i
            r5 = 1
            r0.setEnabled(r5)
            if (r9 == 0) goto L_0x0112
            int r0 = r9.getBaseStatus()
            java.lang.String r6 = "mbtSummary"
            r7 = 0
            if (r0 == 0) goto L_0x00cf
            if (r0 == r5) goto L_0x00cb
            r9 = 2
            java.lang.String r5 = "gpSummaryTip"
            if (r0 == r9) goto L_0x0092
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r4 = "handleServerSummary 异常情况需要云端查看"
            r9.append(r4)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            com.upuphone.ar.transcribe.ext.LogExt.g(r9, r1)
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeSummaryBinding r9 = r8.binding
            if (r9 != 0) goto L_0x0077
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r9 = r3
        L_0x0077:
            com.meizu.common.widget.MzButton r9 = r9.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r6)
            r9.setVisibility(r7)
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeSummaryBinding r9 = r8.binding
            if (r9 != 0) goto L_0x0087
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x0088
        L_0x0087:
            r3 = r9
        L_0x0088:
            androidx.constraintlayout.widget.Group r9 = r3.d
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r5)
            r9.setVisibility(r7)
            goto L_0x0110
        L_0x0092:
            int r9 = com.upuphone.ar.transcribe.R.string.tl_generate_content_fail
            r8.toToast((int) r9)
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeSummaryBinding r9 = r8.binding
            if (r9 != 0) goto L_0x009f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r9 = r3
        L_0x009f:
            com.meizu.common.widget.MzButton r9 = r9.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r6)
            r9.setVisibility(r7)
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeSummaryBinding r9 = r8.binding
            if (r9 != 0) goto L_0x00af
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r9 = r3
        L_0x00af:
            androidx.constraintlayout.widget.Group r9 = r9.d
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r5)
            r9.setVisibility(r7)
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeSummaryBinding r9 = r8.binding
            if (r9 != 0) goto L_0x00bf
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x00c0
        L_0x00bf:
            r3 = r9
        L_0x00c0:
            com.upuphone.ar.transcribe.phone.view.TransLoadingView r9 = r3.h
            java.lang.String r0 = "loadingView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            r9.setVisibility(r4)
            goto L_0x0110
        L_0x00cb:
            r8.handleSummaryEmpty()
            goto L_0x0110
        L_0x00cf:
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeSummaryBinding r0 = r8.binding
            if (r0 != 0) goto L_0x00d7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r3
        L_0x00d7:
            com.meizu.common.widget.MzButton r0 = r0.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
            r0.setVisibility(r4)
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeSummaryBinding r0 = r8.binding
            if (r0 != 0) goto L_0x00e7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r3
        L_0x00e7:
            android.widget.ScrollView r0 = r0.j
            java.lang.String r1 = "svSummary"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0.setVisibility(r7)
            java.lang.String r9 = r9.getSummary()
            com.upuphone.ar.transcribe.databinding.FragmentTranscribeSummaryBinding r0 = r8.binding
            if (r0 != 0) goto L_0x00fd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r3
        L_0x00fd:
            com.upuphone.ar.transcribe.phone.view.ClipboardEditText r0 = r0.b
            r0.setText(r9)
            com.upuphone.ar.transcribe.phone.vm.AiShareViewModel r0 = r8.aiShareViewModel
            if (r0 != 0) goto L_0x010c
            java.lang.String r0 = "aiShareViewModel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x010d
        L_0x010c:
            r3 = r0
        L_0x010d:
            r3.n(r9)
        L_0x0110:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x0112:
            if (r3 != 0) goto L_0x0117
            r8.handleSummaryEmpty()
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.activity.AiSummaryFragment.handleServerSummary(com.upuphone.ar.transcribe.phone.repo.AiResponseSummary):void");
    }

    private final void handleSummaryEmpty() {
        toToast(R.string.tl_generate_summary_empty);
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding = this.binding;
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding2 = null;
        if (fragmentTranscribeSummaryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeSummaryBinding = null;
        }
        MzButton mzButton = fragmentTranscribeSummaryBinding.i;
        Intrinsics.checkNotNullExpressionValue(mzButton, "mbtSummary");
        mzButton.setVisibility(0);
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding3 = this.binding;
        if (fragmentTranscribeSummaryBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeSummaryBinding3 = null;
        }
        Group group = fragmentTranscribeSummaryBinding3.d;
        Intrinsics.checkNotNullExpressionValue(group, "gpSummaryTip");
        group.setVisibility(0);
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding4 = this.binding;
        if (fragmentTranscribeSummaryBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTranscribeSummaryBinding2 = fragmentTranscribeSummaryBinding4;
        }
        TransLoadingView transLoadingView = fragmentTranscribeSummaryBinding2.h;
        Intrinsics.checkNotNullExpressionValue(transLoadingView, "loadingView");
        transLoadingView.setVisibility(8);
    }

    private final void initData() {
        String recognizeId;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.aiShareViewModel = (AiShareViewModel) new ViewModelProvider(requireActivity).get(AiShareViewModel.class);
        TranscribeBean transcribeBean2 = this.transcribeBean;
        if (transcribeBean2 != null) {
            String account = transcribeBean2.getAccount();
            if (account == null || StringsKt.isBlank(account) || (recognizeId = transcribeBean2.getRecognizeId()) == null || StringsKt.isBlank(recognizeId)) {
                LogExt.g("initData 数据库中概要总结", TAG);
            } else {
                Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new AiSummaryFragment$initData$1$1(this, transcribeBean2, (Continuation<? super AiSummaryFragment$initData$1$1>) null), 3, (Object) null);
            }
        }
    }

    private final void initListener() {
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding = this.binding;
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding2 = null;
        if (fragmentTranscribeSummaryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeSummaryBinding = null;
        }
        fragmentTranscribeSummaryBinding.i.setOnClickListener(new a(this));
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding3 = this.binding;
        if (fragmentTranscribeSummaryBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeSummaryBinding3 = null;
        }
        fragmentTranscribeSummaryBinding3.b.h(new AiSummaryFragment$initListener$2(this));
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding4 = this.binding;
        if (fragmentTranscribeSummaryBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeSummaryBinding4 = null;
        }
        fragmentTranscribeSummaryBinding4.e.setOnClickListener(new b(this));
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding5 = this.binding;
        if (fragmentTranscribeSummaryBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeSummaryBinding5 = null;
        }
        ImageView imageView = fragmentTranscribeSummaryBinding5.e;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivFeedback");
        TranscribeConstants transcribeConstants = TranscribeConstants.f6027a;
        int i = 8;
        imageView.setVisibility(transcribeConstants.m() ? 0 : 8);
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding6 = this.binding;
        if (fragmentTranscribeSummaryBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTranscribeSummaryBinding2 = fragmentTranscribeSummaryBinding6;
        }
        TextView textView = fragmentTranscribeSummaryBinding2.k;
        Intrinsics.checkNotNullExpressionValue(textView, "tvFeedback");
        if (transcribeConstants.m()) {
            i = 0;
        }
        textView.setVisibility(i);
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$3(AiSummaryFragment aiSummaryFragment, View view) {
        Intrinsics.checkNotNullParameter(aiSummaryFragment, "this$0");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(aiSummaryFragment), Dispatchers.b(), (CoroutineStart) null, new AiSummaryFragment$initListener$1$1(aiSummaryFragment, (Continuation<? super AiSummaryFragment$initListener$1$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$4(AiSummaryFragment aiSummaryFragment, View view) {
        Intrinsics.checkNotNullParameter(aiSummaryFragment, "this$0");
        SummaryViewModel summaryViewModel = aiSummaryFragment.getSummaryViewModel();
        FragmentActivity requireActivity = aiSummaryFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        summaryViewModel.k(requireActivity);
    }

    private final void initViewModels() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new AiSummaryFragment$initViewModels$1(this, (Continuation<? super AiSummaryFragment$initViewModels$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$1(View view) {
        view.requestFocus();
    }

    /* access modifiers changed from: private */
    public final void showLoading() {
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding = this.binding;
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding2 = null;
        if (fragmentTranscribeSummaryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeSummaryBinding = null;
        }
        Group group = fragmentTranscribeSummaryBinding.d;
        Intrinsics.checkNotNullExpressionValue(group, "gpSummaryTip");
        group.setVisibility(8);
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding3 = this.binding;
        if (fragmentTranscribeSummaryBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTranscribeSummaryBinding3 = null;
        }
        Group group2 = fragmentTranscribeSummaryBinding3.c;
        Intrinsics.checkNotNullExpressionValue(group2, "gpLoading");
        group2.setVisibility(0);
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding4 = this.binding;
        if (fragmentTranscribeSummaryBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTranscribeSummaryBinding2 = fragmentTranscribeSummaryBinding4;
        }
        fragmentTranscribeSummaryBinding2.i.setEnabled(false);
    }

    /* access modifiers changed from: private */
    public final void toToast(@StringRes int i) {
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        companion.b(requireContext, i);
    }

    /* access modifiers changed from: private */
    public final void updateReportView(boolean z) {
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding = null;
        if (!TranscribeConstants.f6027a.m()) {
            FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding2 = this.binding;
            if (fragmentTranscribeSummaryBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTranscribeSummaryBinding2 = null;
            }
            ImageView imageView = fragmentTranscribeSummaryBinding2.e;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivFeedback");
            imageView.setVisibility(8);
            FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding3 = this.binding;
            if (fragmentTranscribeSummaryBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentTranscribeSummaryBinding = fragmentTranscribeSummaryBinding3;
            }
            TextView textView = fragmentTranscribeSummaryBinding.k;
            Intrinsics.checkNotNullExpressionValue(textView, "tvFeedback");
            textView.setVisibility(8);
        } else if (z) {
            FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding4 = this.binding;
            if (fragmentTranscribeSummaryBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTranscribeSummaryBinding4 = null;
            }
            ImageView imageView2 = fragmentTranscribeSummaryBinding4.e;
            Intrinsics.checkNotNullExpressionValue(imageView2, "ivFeedback");
            imageView2.setVisibility(8);
            FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding5 = this.binding;
            if (fragmentTranscribeSummaryBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentTranscribeSummaryBinding = fragmentTranscribeSummaryBinding5;
            }
            TextView textView2 = fragmentTranscribeSummaryBinding.k;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvFeedback");
            textView2.setVisibility(0);
        } else {
            FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding6 = this.binding;
            if (fragmentTranscribeSummaryBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTranscribeSummaryBinding6 = null;
            }
            ImageView imageView3 = fragmentTranscribeSummaryBinding6.e;
            Intrinsics.checkNotNullExpressionValue(imageView3, "ivFeedback");
            imageView3.setVisibility(0);
            FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding7 = this.binding;
            if (fragmentTranscribeSummaryBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentTranscribeSummaryBinding = fragmentTranscribeSummaryBinding7;
            }
            TextView textView3 = fragmentTranscribeSummaryBinding.k;
            Intrinsics.checkNotNullExpressionValue(textView3, "tvFeedback");
            textView3.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void updateSummaryToDb(boolean z) {
        AiSummaryEntity l = getSummaryViewModel().l();
        if (l != null) {
            String summary = l.getSummary();
            FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding = this.binding;
            AiShareViewModel aiShareViewModel2 = null;
            if (fragmentTranscribeSummaryBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTranscribeSummaryBinding = null;
            }
            String valueOf = String.valueOf(fragmentTranscribeSummaryBinding.b.getText());
            LogExt.g("originalSummary=" + summary + ", inputSummary=" + valueOf, TAG);
            if (!Intrinsics.areEqual((Object) summary, (Object) valueOf)) {
                AiShareViewModel aiShareViewModel3 = this.aiShareViewModel;
                if (aiShareViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aiShareViewModel");
                } else {
                    aiShareViewModel2 = aiShareViewModel3;
                }
                aiShareViewModel2.n(valueOf);
                Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new AiSummaryFragment$updateSummaryToDb$1$1(valueOf, z, this, l, summary, (Continuation<? super AiSummaryFragment$updateSummaryToDb$1$1>) null), 3, (Object) null);
            }
        }
    }

    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.transcribeBean = Build.VERSION.SDK_INT >= 33 ? (TranscribeBean) arguments.getParcelable("key_record_bean", TranscribeBean.class) : (TranscribeBean) arguments.getParcelable("key_record_bean");
        }
        TranscribeBean transcribeBean2 = this.transcribeBean;
        LogExt.g("翻译记录对象 " + transcribeBean2, TAG);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTranscribeSummaryBinding c = FragmentTranscribeSummaryBinding.c(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.binding = c;
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding = null;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        c.getRoot().setOnClickListener(new c());
        FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding2 = this.binding;
        if (fragmentTranscribeSummaryBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTranscribeSummaryBinding = fragmentTranscribeSummaryBinding2;
        }
        ConstraintLayout b = fragmentTranscribeSummaryBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroy() {
        String str;
        super.onDestroy();
        CoroutineScopeKt.e(this, (CancellationException) null, 1, (Object) null);
        SummaryViewModel summaryViewModel = getSummaryViewModel();
        TranscribeBean transcribeBean2 = this.transcribeBean;
        if (transcribeBean2 == null || (str = transcribeBean2.getRecognizeId()) == null) {
            str = "";
        }
        summaryViewModel.s(str);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initData();
        initListener();
        initViewModels();
    }

    /* access modifiers changed from: private */
    public final void toToast(String str) {
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        companion.d(requireContext, str);
    }
}
