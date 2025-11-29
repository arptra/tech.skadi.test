package com.upuphone.ar.transcribe.phone.activity;

import android.net.Uri;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.ar.transcribe.ext.ContextExtKt;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.utils.DateUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeAIActivity$shareTextFile$1$1$uri$1", f = "TranscribeAIActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranscribeAIActivity$shareTextFile$1$1$uri$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    final /* synthetic */ TranscribeBean $noteBean;
    final /* synthetic */ String $shareText;
    int label;
    final /* synthetic */ TranscribeAIActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeAIActivity$shareTextFile$1$1$uri$1(TranscribeBean transcribeBean, TranscribeAIActivity transcribeAIActivity, String str, Continuation<? super TranscribeAIActivity$shareTextFile$1$1$uri$1> continuation) {
        super(2, continuation);
        this.$noteBean = transcribeBean;
        this.this$0 = transcribeAIActivity;
        this.$shareText = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranscribeAIActivity$shareTextFile$1$1$uri$1(this.$noteBean, this.this$0, this.$shareText, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String superTitle = this.$noteBean.getSuperTitle();
            String replace = superTitle != null ? new Regex("\\s+").replace((CharSequence) superTitle, "") : null;
            String d = DateUtils.d(this.$noteBean.getRecordTime(), 7);
            return ContextExtKt.l(this.this$0, this.$shareText, replace + AccountConstantKt.DEFAULT_SEGMENT + d + ".txt");
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Uri> continuation) {
        return ((TranscribeAIActivity$shareTextFile$1$1$uri$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
