package com.upuphone.ar.translation.phone.activity;

import android.net.Uri;
import com.meizu.common.app.LoadingDialog;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.NoteBean;
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
@DebugMetadata(c = "com.upuphone.ar.translation.phone.activity.TranslatorIntelExtnActivity$shareTextFile$1", f = "TranslatorIntelExtnActivity.kt", i = {0}, l = {238}, m = "invokeSuspend", n = {"dialog"}, s = {"L$1"})
public final class TranslatorIntelExtnActivity$shareTextFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TranslatorIntelExtnActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorIntelExtnActivity$shareTextFile$1(TranslatorIntelExtnActivity translatorIntelExtnActivity, Continuation<? super TranslatorIntelExtnActivity$shareTextFile$1> continuation) {
        super(2, continuation);
        this.this$0 = translatorIntelExtnActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorIntelExtnActivity$shareTextFile$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        TranslatorIntelExtnActivity translatorIntelExtnActivity;
        LoadingDialog loadingDialog;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NoteBean access$getMNoteBean$p = this.this$0.mNoteBean;
            if (access$getMNoteBean$p != null) {
                TranslatorIntelExtnActivity translatorIntelExtnActivity2 = this.this$0;
                StringBuilder sb = new StringBuilder();
                String str = (String) translatorIntelExtnActivity2.getMIntelExtnShareVm().m().getValue();
                if (str != null) {
                    sb.append(translatorIntelExtnActivity2.getString(R.string.tl_to_do));
                    sb.append(StringUtils.LF);
                    sb.append(str);
                    sb.append("\n\n");
                }
                String str2 = (String) translatorIntelExtnActivity2.getMIntelExtnShareVm().l().getValue();
                if (str2 != null) {
                    sb.append(translatorIntelExtnActivity2.getString(R.string.tl_summary));
                    sb.append(StringUtils.LF);
                    sb.append(str2);
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                if (StringsKt.isBlank(sb2)) {
                    LogExt.j("分享的内容不能为空", "TranslatorIntelExtnActivity");
                    return Unit.INSTANCE;
                }
                LoadingDialog loadingDialog2 = new LoadingDialog(translatorIntelExtnActivity2);
                loadingDialog2.setMessage((CharSequence) translatorIntelExtnActivity2.getString(R.string.tl_share_record_wait_text));
                loadingDialog2.setMessageTextColorResource(R.color.color_tl_loading_msg_text);
                loadingDialog2.setBackgroundDrawableResource(R.drawable.trans_loading_alert_bg);
                loadingDialog2.show();
                CoroutineDispatcher b = Dispatchers.b();
                TranslatorIntelExtnActivity$shareTextFile$1$1$uri$1 translatorIntelExtnActivity$shareTextFile$1$1$uri$1 = new TranslatorIntelExtnActivity$shareTextFile$1$1$uri$1(access$getMNoteBean$p, translatorIntelExtnActivity2, sb2, (Continuation<? super TranslatorIntelExtnActivity$shareTextFile$1$1$uri$1>) null);
                this.L$0 = translatorIntelExtnActivity2;
                this.L$1 = loadingDialog2;
                this.label = 1;
                obj = BuildersKt.g(b, translatorIntelExtnActivity$shareTextFile$1$1$uri$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                translatorIntelExtnActivity = translatorIntelExtnActivity2;
                loadingDialog = loadingDialog2;
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            loadingDialog = (LoadingDialog) this.L$1;
            translatorIntelExtnActivity = (TranslatorIntelExtnActivity) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ContextExtKt.G(translatorIntelExtnActivity, (Uri) obj, (String) null, 2, (Object) null);
        loadingDialog.dismiss();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorIntelExtnActivity$shareTextFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
