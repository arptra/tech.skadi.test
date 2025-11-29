package com.upuphone.ar.transcribe.phone.activity;

import android.text.SpannableStringBuilder;
import com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding;
import com.upuphone.ar.transcribe.phone.view.ClipboardEditText;
import com.upuphone.ar.transcribe.utils.JsonUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity$analysisAirData$1", f = "TranscribeDetailActivity.kt", i = {}, l = {366}, m = "invokeSuspend", n = {}, s = {})
public final class TranscribeDetailActivity$analysisAirData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $src;
    Object L$0;
    int label;
    final /* synthetic */ TranscribeDetailActivity this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Landroid/text/SpannableStringBuilder;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity$analysisAirData$1$1", f = "TranscribeDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity$analysisAirData$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SpannableStringBuilder>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(transcribeDetailActivity, str2, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return transcribeDetailActivity.getAirRecordData(str2);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super SpannableStringBuilder> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeDetailActivity$analysisAirData$1(String str, TranscribeDetailActivity transcribeDetailActivity, Continuation<? super TranscribeDetailActivity$analysisAirData$1> continuation) {
        super(2, continuation);
        this.$src = str;
        this.this$0 = transcribeDetailActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranscribeDetailActivity$analysisAirData$1(this.$src, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ClipboardEditText clipboardEditText;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$src;
            if (str == null || StringsKt.isBlank(str) || !JsonUtils.a(this.$src)) {
                return Unit.INSTANCE;
            }
            ActivityTranscribeDetailBinding access$getMBinding$p = this.this$0.mBinding;
            if (access$getMBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                access$getMBinding$p = null;
            }
            ClipboardEditText clipboardEditText2 = access$getMBinding$p.k;
            CoroutineDispatcher b = Dispatchers.b();
            final TranscribeDetailActivity transcribeDetailActivity = this.this$0;
            final String str2 = this.$src;
            AnonymousClass1 r4 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.L$0 = clipboardEditText2;
            this.label = 1;
            Object g = BuildersKt.g(b, r4, this);
            if (g == coroutine_suspended) {
                return coroutine_suspended;
            }
            ClipboardEditText clipboardEditText3 = clipboardEditText2;
            obj = g;
            clipboardEditText = clipboardEditText3;
        } else if (i == 1) {
            clipboardEditText = (ClipboardEditText) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        clipboardEditText.setText((CharSequence) obj);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranscribeDetailActivity$analysisAirData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
