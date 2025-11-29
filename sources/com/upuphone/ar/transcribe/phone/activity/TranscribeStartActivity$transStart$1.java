package com.upuphone.ar.transcribe.phone.activity;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.TranscribeApp;
import com.upuphone.ar.transcribe.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
import com.upuphone.ar.transcribe.phone.helper.InterConnectHelper;
import com.upuphone.star.common.phone.UToast;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranscribeStartActivity$transStart$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ String $langDst;
    final /* synthetic */ String $langSrc;
    final /* synthetic */ int $transType;
    final /* synthetic */ TranscribeStartActivity this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeStartActivity$transStart$1$1", f = "TranscribeStartActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.transcribe.phone.activity.TranscribeStartActivity$transStart$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(transcribeStartActivity, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                UToast.Companion companion = UToast.f6444a;
                Context applicationContext = transcribeStartActivity.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                String string = transcribeStartActivity.getString(R.string.trsb_network_off);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                companion.e(applicationContext, string, 0);
                transcribeStartActivity.updateStopUI();
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
    public TranscribeStartActivity$transStart$1(int i, String str, String str2, TranscribeStartActivity transcribeStartActivity) {
        super(1);
        this.$transType = i;
        this.$langSrc = str;
        this.$langDst = str2;
        this.this$0 = transcribeStartActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        TranscribeManager.Companion companion = TranscribeManager.j;
        if (companion.a().h().n() && (companion.a().h().g() || companion.a().h().i())) {
            String f = InterconnectMsgCodExtKt.f(this.$transType);
            LogExt.g("transStartOrStop: 翻译服务已启动，开始翻译=" + f, "TranscribeStartActivity");
            if (!z) {
                companion.a().h().o();
                return;
            }
            InterConnectHelper.c.a().z(this.$transType, this.$langSrc, this.$langDst);
            companion.a().h().E();
        } else if (!z) {
            LifecycleCoroutineScope a2 = LifecycleOwnerKt.a(this.this$0);
            final TranscribeStartActivity transcribeStartActivity = this.this$0;
            Job unused = BuildersKt__Builders_commonKt.d(a2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        } else {
            String f2 = InterconnectMsgCodExtKt.f(this.$transType);
            LogExt.g("transStartOrStop: 翻译服务未启动，开始翻译=" + f2, "TranscribeStartActivity");
            Context applicationContext = this.this$0.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            TranscribeApp.startService(applicationContext);
        }
    }
}
