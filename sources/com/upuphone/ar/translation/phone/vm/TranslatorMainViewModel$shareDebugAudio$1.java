package com.upuphone.ar.translation.phone.vm;

import android.app.Activity;
import android.net.Uri;
import com.meizu.common.app.LoadingDialog;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.phone.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorMainViewModel$shareDebugAudio$1", f = "TranslatorMainViewModel.kt", i = {0}, l = {432}, m = "invokeSuspend", n = {"dialog"}, s = {"L$0"})
public final class TranslatorMainViewModel$shareDebugAudio$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorMainViewModel$shareDebugAudio$1(Activity activity, Continuation<? super TranslatorMainViewModel$shareDebugAudio$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorMainViewModel$shareDebugAudio$1(this.$activity, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        LoadingDialog loadingDialog;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LoadingDialog loadingDialog2 = new LoadingDialog(this.$activity);
            loadingDialog2.setMessage(R.string.tl_share_record_wait_text);
            loadingDialog2.setMessageTextColorResource(R.color.color_tl_loading_msg_text);
            loadingDialog2.setBackgroundDrawableResource(R.drawable.trans_loading_alert_bg);
            loadingDialog2.show();
            CoroutineDispatcher b = Dispatchers.b();
            TranslatorMainViewModel$shareDebugAudio$1$uri$1 translatorMainViewModel$shareDebugAudio$1$uri$1 = new TranslatorMainViewModel$shareDebugAudio$1$uri$1(this.$activity, (Continuation<? super TranslatorMainViewModel$shareDebugAudio$1$uri$1>) null);
            this.L$0 = loadingDialog2;
            this.label = 1;
            Object g = BuildersKt.g(b, translatorMainViewModel$shareDebugAudio$1$uri$1, this);
            if (g == coroutine_suspended) {
                return coroutine_suspended;
            }
            loadingDialog = loadingDialog2;
            obj = g;
        } else if (i == 1) {
            loadingDialog = (LoadingDialog) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Uri uri = (Uri) obj;
        if (uri != null) {
            ContextExtKt.B(this.$activity, uri, (String) null, 2, (Object) null);
        }
        loadingDialog.dismiss();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorMainViewModel$shareDebugAudio$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
