package com.upuphone.ar.transcribe.phone.activity;

import android.widget.ScrollView;
import androidx.constraintlayout.widget.Group;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.transcribe.databinding.FragmentTranscribeSummaryBinding;
import com.upuphone.ar.transcribe.ext.ContextExtKt;
import com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity;
import com.upuphone.ar.transcribe.phone.view.TransLoadingView;
import com.upuphone.ar.transcribe.phone.vm.SummaryViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nAiSummaryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiSummaryFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/AiSummaryFragment$updateSummaryToDb$1$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,341:1\n262#2,2:342\n262#2,2:344\n262#2,2:346\n262#2,2:348\n*S KotlinDebug\n*F\n+ 1 AiSummaryFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/AiSummaryFragment$updateSummaryToDb$1$1\n*L\n295#1:342,2\n296#1:344,2\n297#1:346,2\n298#1:348,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.AiSummaryFragment$updateSummaryToDb$1$1", f = "AiSummaryFragment.kt", i = {}, l = {300, 304}, m = "invokeSuspend", n = {}, s = {})
public final class AiSummaryFragment$updateSummaryToDb$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromEdit;
    final /* synthetic */ String $inputSummary;
    final /* synthetic */ String $originalSummary;
    final /* synthetic */ AiSummaryEntity $summary;
    int label;
    final /* synthetic */ AiSummaryFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiSummaryFragment$updateSummaryToDb$1$1(String str, boolean z, AiSummaryFragment aiSummaryFragment, AiSummaryEntity aiSummaryEntity, String str2, Continuation<? super AiSummaryFragment$updateSummaryToDb$1$1> continuation) {
        super(2, continuation);
        this.$inputSummary = str;
        this.$fromEdit = z;
        this.this$0 = aiSummaryFragment;
        this.$summary = aiSummaryEntity;
        this.$originalSummary = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AiSummaryFragment$updateSummaryToDb$1$1(this.$inputSummary, this.$fromEdit, this.this$0, this.$summary, this.$originalSummary, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Class<AiSummaryEntity> cls = AiSummaryEntity.class;
            if (StringsKt.isBlank(this.$inputSummary)) {
                if (this.$fromEdit) {
                    FragmentTranscribeSummaryBinding access$getBinding$p = this.this$0.binding;
                    FragmentTranscribeSummaryBinding fragmentTranscribeSummaryBinding = null;
                    if (access$getBinding$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        access$getBinding$p = null;
                    }
                    access$getBinding$p.i.setEnabled(true);
                    FragmentTranscribeSummaryBinding access$getBinding$p2 = this.this$0.binding;
                    if (access$getBinding$p2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        access$getBinding$p2 = null;
                    }
                    MzButton mzButton = access$getBinding$p2.i;
                    Intrinsics.checkNotNullExpressionValue(mzButton, "mbtSummary");
                    mzButton.setVisibility(0);
                    FragmentTranscribeSummaryBinding access$getBinding$p3 = this.this$0.binding;
                    if (access$getBinding$p3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        access$getBinding$p3 = null;
                    }
                    Group group = access$getBinding$p3.d;
                    Intrinsics.checkNotNullExpressionValue(group, "gpSummaryTip");
                    group.setVisibility(0);
                    FragmentTranscribeSummaryBinding access$getBinding$p4 = this.this$0.binding;
                    if (access$getBinding$p4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        access$getBinding$p4 = null;
                    }
                    TransLoadingView transLoadingView = access$getBinding$p4.h;
                    Intrinsics.checkNotNullExpressionValue(transLoadingView, "loadingView");
                    transLoadingView.setVisibility(8);
                    FragmentTranscribeSummaryBinding access$getBinding$p5 = this.this$0.binding;
                    if (access$getBinding$p5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentTranscribeSummaryBinding = access$getBinding$p5;
                    }
                    ScrollView scrollView = fragmentTranscribeSummaryBinding.j;
                    Intrinsics.checkNotNullExpressionValue(scrollView, "svSummary");
                    scrollView.setVisibility(8);
                }
                SummaryViewModel access$getSummaryViewModel = this.this$0.getSummaryViewModel();
                AiSummaryEntity aiSummaryEntity = (AiSummaryEntity) ContextExtKt.c(this.$summary, cls);
                aiSummaryEntity.setSummary(this.$originalSummary);
                this.label = 1;
                if (access$getSummaryViewModel.j(aiSummaryEntity, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                SummaryViewModel access$getSummaryViewModel2 = this.this$0.getSummaryViewModel();
                AiSummaryEntity aiSummaryEntity2 = (AiSummaryEntity) ContextExtKt.c(this.$summary, cls);
                aiSummaryEntity2.setSummary(this.$inputSummary);
                this.label = 2;
                if (access$getSummaryViewModel2.t(aiSummaryEntity2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1 || i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AiSummaryFragment$updateSummaryToDb$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
