package com.upuphone.ar.translation.phone.helper;

import android.content.Context;
import com.upuphone.ar.translation.ext.LogExt;
import com.xjsd.ai.voice.VoiceAdapter;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.helper.TelephoneTransHelper$init$1", f = "TelephoneTransHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TelephoneTransHelper$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TelephoneTransHelper$init$1(Context context, Continuation<? super TelephoneTransHelper$init$1> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TelephoneTransHelper$init$1(this.$context, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                TelephoneTransHelper telephoneTransHelper = TelephoneTransHelper.f6305a;
                VoiceAdapter voiceAdapter = new VoiceAdapter();
                Context context = this.$context;
                TelephoneTransHelper telephoneTransHelper2 = TelephoneTransHelper.f6305a;
                voiceAdapter.init(context, telephoneTransHelper2.r());
                voiceAdapter.registerListener(new TelephoneTransHelper$init$1$1$1());
                voiceAdapter.Start();
                TelephoneTransHelper.m = voiceAdapter;
                VoiceAdapter voiceAdapter2 = new VoiceAdapter();
                voiceAdapter2.init(this.$context, telephoneTransHelper2.r());
                voiceAdapter2.registerListener(new TelephoneTransHelper$init$1$2$1());
                voiceAdapter2.Start();
                TelephoneTransHelper.n = voiceAdapter2;
                LogExt.j("init telephone voice success", "TelephoneTransHelper");
            } catch (Exception e) {
                String stackTraceToString = ExceptionsKt.stackTraceToString(e);
                LogExt.j("init telephone voice error=" + stackTraceToString, "TelephoneTransHelper");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TelephoneTransHelper$init$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
