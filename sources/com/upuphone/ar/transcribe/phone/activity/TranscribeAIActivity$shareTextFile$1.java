package com.upuphone.ar.transcribe.phone.activity;

import android.net.Uri;
import com.meizu.common.app.LoadingDialog;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.ext.ContextExtKt;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
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
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeAIActivity$shareTextFile$1", f = "TranscribeAIActivity.kt", i = {0}, l = {233}, m = "invokeSuspend", n = {"dialog"}, s = {"L$1"})
public final class TranscribeAIActivity$shareTextFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TranscribeAIActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeAIActivity$shareTextFile$1(TranscribeAIActivity transcribeAIActivity, Continuation<? super TranscribeAIActivity$shareTextFile$1> continuation) {
        super(2, continuation);
        this.this$0 = transcribeAIActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranscribeAIActivity$shareTextFile$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        TranscribeAIActivity transcribeAIActivity;
        LoadingDialog loadingDialog;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TranscribeBean access$getNoteBean$p = this.this$0.noteBean;
            if (access$getNoteBean$p != null) {
                TranscribeAIActivity transcribeAIActivity2 = this.this$0;
                StringBuilder sb = new StringBuilder();
                String str = (String) transcribeAIActivity2.getAiShareViewModel().k().getValue();
                if (str != null && (!StringsKt.isBlank(str))) {
                    sb.append(transcribeAIActivity2.getString(R.string.tl_to_do));
                    sb.append(StringUtils.LF);
                    sb.append(str);
                    sb.append("\n\n");
                }
                String str2 = (String) transcribeAIActivity2.getAiShareViewModel().j().getValue();
                if (str2 != null && (!StringsKt.isBlank(str2))) {
                    sb.append(transcribeAIActivity2.getString(R.string.tl_summary));
                    sb.append(StringUtils.LF);
                    sb.append(str2);
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                if (StringsKt.isBlank(sb2)) {
                    LogExt.g("分享的内容不能为空", "TranscribeAIActivity");
                    return Unit.INSTANCE;
                }
                LoadingDialog loadingDialog2 = new LoadingDialog(transcribeAIActivity2);
                loadingDialog2.setMessage((CharSequence) transcribeAIActivity2.getString(R.string.tl_share_record_wait_text));
                loadingDialog2.setMessageTextColorResource(R.color.color_tl_loading_msg_text);
                loadingDialog2.setBackgroundDrawableResource(R.drawable.trans_loading_alert_bg);
                loadingDialog2.show();
                CoroutineDispatcher b = Dispatchers.b();
                TranscribeAIActivity$shareTextFile$1$1$uri$1 transcribeAIActivity$shareTextFile$1$1$uri$1 = new TranscribeAIActivity$shareTextFile$1$1$uri$1(access$getNoteBean$p, transcribeAIActivity2, sb2, (Continuation<? super TranscribeAIActivity$shareTextFile$1$1$uri$1>) null);
                this.L$0 = transcribeAIActivity2;
                this.L$1 = loadingDialog2;
                this.label = 1;
                obj = BuildersKt.g(b, transcribeAIActivity$shareTextFile$1$1$uri$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                transcribeAIActivity = transcribeAIActivity2;
                loadingDialog = loadingDialog2;
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            loadingDialog = (LoadingDialog) this.L$1;
            transcribeAIActivity = (TranscribeAIActivity) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ContextExtKt.k(transcribeAIActivity, (Uri) obj, (String) null, 2, (Object) null);
        loadingDialog.dismiss();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranscribeAIActivity$shareTextFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
