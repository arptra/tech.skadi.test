package com.upuphone.ar.translation.phone.fragment;

import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.databinding.FragmentDialogueTranslationBinding;
import com.upuphone.xr.sapp.context.IPhoneCallStatus;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/context/IPhoneCallStatus;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DialogueTranslationFragment$initViewModels$2 extends Lambda implements Function1<IPhoneCallStatus, Unit> {
    final /* synthetic */ DialogueTranslationFragment this$0;

    @SourceDebugExtension({"SMAP\nDialogueTranslationFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DialogueTranslationFragment.kt\ncom/upuphone/ar/translation/phone/fragment/DialogueTranslationFragment$initViewModels$2$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,1243:1\n262#2,2:1244\n*S KotlinDebug\n*F\n+ 1 DialogueTranslationFragment.kt\ncom/upuphone/ar/translation/phone/fragment/DialogueTranslationFragment$initViewModels$2$1\n*L\n304#1:1244,2\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.translation.phone.fragment.DialogueTranslationFragment$initViewModels$2$1", f = "DialogueTranslationFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.translation.phone.fragment.DialogueTranslationFragment$initViewModels$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(iPhoneCallStatus, dialogueTranslationFragment, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LogExt.j("Observe phoneCallStatus" + InterconnectMsgCodExtKt.a(iPhoneCallStatus.getCallStatus()), "DialogueTranslationFragment");
                int i = 0;
                boolean z = iPhoneCallStatus.getCallStatus() == 2;
                FragmentDialogueTranslationBinding D0 = dialogueTranslationFragment.f6274a;
                FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = null;
                if (D0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    D0 = null;
                }
                LinearLayout linearLayout = D0.r;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "llTeleUseInst");
                if (!(z && !dialogueTranslationFragment.d)) {
                    i = 8;
                }
                linearLayout.setVisibility(i);
                FragmentDialogueTranslationBinding D02 = dialogueTranslationFragment.f6274a;
                if (D02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    D02 = null;
                }
                D02.J.setText(R.string.tl_telephone_use_inst);
                FragmentDialogueTranslationBinding D03 = dialogueTranslationFragment.f6274a;
                if (D03 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    fragmentDialogueTranslationBinding = D03;
                }
                fragmentDialogueTranslationBinding.e.setEnabled(true);
                dialogueTranslationFragment.c1().Z(iPhoneCallStatus.getCallStatus());
                AlertDialog J0 = dialogueTranslationFragment.k;
                if (J0 != null && z && J0.isShowing()) {
                    J0.dismiss();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogueTranslationFragment$initViewModels$2(DialogueTranslationFragment dialogueTranslationFragment) {
        super(1);
        this.this$0 = dialogueTranslationFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IPhoneCallStatus) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(final IPhoneCallStatus iPhoneCallStatus) {
        LifecycleCoroutineScope a2 = LifecycleOwnerKt.a(this.this$0);
        final DialogueTranslationFragment dialogueTranslationFragment = this.this$0;
        Job unused = BuildersKt__Builders_commonKt.d(a2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }
}
