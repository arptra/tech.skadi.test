package com.upuphone.ar.transcribe.phone.activity;

import android.content.Context;
import com.upuphone.ar.transcribe.databinding.ActivityTranscribeSettingBinding;
import com.upuphone.ar.transcribe.utils.PreferencesUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeSettingActivity$onCreate$4", f = "TranscribeSettingActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranscribeSettingActivity$onCreate$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TranscribeSettingActivity this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeSettingActivity$onCreate$4$1", f = "TranscribeSettingActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.transcribe.phone.activity.TranscribeSettingActivity$onCreate$4$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(e, transcribeSettingActivity, i, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActivityTranscribeSettingBinding activityTranscribeSettingBinding = null;
                if (e == 2) {
                    ActivityTranscribeSettingBinding access$getBinding$p = transcribeSettingActivity.binding;
                    if (access$getBinding$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        access$getBinding$p = null;
                    }
                    access$getBinding$p.c.setSelected(true);
                    ActivityTranscribeSettingBinding access$getBinding$p2 = transcribeSettingActivity.binding;
                    if (access$getBinding$p2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        access$getBinding$p2 = null;
                    }
                    access$getBinding$p2.b.setSelected(false);
                } else {
                    ActivityTranscribeSettingBinding access$getBinding$p3 = transcribeSettingActivity.binding;
                    if (access$getBinding$p3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        access$getBinding$p3 = null;
                    }
                    access$getBinding$p3.c.setSelected(false);
                    ActivityTranscribeSettingBinding access$getBinding$p4 = transcribeSettingActivity.binding;
                    if (access$getBinding$p4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        access$getBinding$p4 = null;
                    }
                    access$getBinding$p4.b.setSelected(true);
                }
                ActivityTranscribeSettingBinding access$getBinding$p5 = transcribeSettingActivity.binding;
                if (access$getBinding$p5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityTranscribeSettingBinding = access$getBinding$p5;
                }
                activityTranscribeSettingBinding.d.setSettingChecked(i);
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
    public TranscribeSettingActivity$onCreate$4(TranscribeSettingActivity transcribeSettingActivity, Continuation<? super TranscribeSettingActivity$onCreate$4> continuation) {
        super(2, continuation);
        this.this$0 = transcribeSettingActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TranscribeSettingActivity$onCreate$4 transcribeSettingActivity$onCreate$4 = new TranscribeSettingActivity$onCreate$4(this.this$0, continuation);
        transcribeSettingActivity$onCreate$4.L$0 = obj;
        return transcribeSettingActivity$onCreate$4;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PreferencesUtils preferencesUtils = PreferencesUtils.f6190a;
            Context applicationContext = this.this$0.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            final int e = preferencesUtils.e(applicationContext);
            Context applicationContext2 = this.this$0.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            final boolean i = preferencesUtils.i(applicationContext2);
            MainCoroutineDispatcher c = Dispatchers.c();
            final TranscribeSettingActivity transcribeSettingActivity = this.this$0;
            Job unused = BuildersKt__Builders_commonKt.d((CoroutineScope) this.L$0, c, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 2, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranscribeSettingActivity$onCreate$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
