package com.upuphone.ar.translation.phone.vm;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.common.app.LoadingDialog;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.activity.ShareImagePreviewActivity;
import com.upuphone.ar.translation.phone.bean.NoteBean;
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
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$shareRecordImage$1", f = "TranslatorRecordViewModel.kt", i = {0, 0}, l = {1052}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u242", "dialog"}, s = {"L$0", "L$1"})
public final class TranslatorRecordViewModel$shareRecordImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ NoteBean $noteBean;
    final /* synthetic */ RecyclerView $recyclerView;
    final /* synthetic */ View $view;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordViewModel$shareRecordImage$1(Activity activity, NoteBean noteBean, RecyclerView recyclerView, View view, Continuation<? super TranslatorRecordViewModel$shareRecordImage$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$noteBean = noteBean;
        this.$recyclerView = recyclerView;
        this.$view = view;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorRecordViewModel$shareRecordImage$1(this.$activity, this.$noteBean, this.$recyclerView, this.$view, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Activity activity;
        LoadingDialog loadingDialog;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Activity activity2 = this.$activity;
            NoteBean noteBean = this.$noteBean;
            RecyclerView recyclerView = this.$recyclerView;
            View view = this.$view;
            LoadingDialog loadingDialog2 = new LoadingDialog(activity2);
            loadingDialog2.setMessage(R.string.tl_share_record_wait_text);
            loadingDialog2.setMessageTextColorResource(R.color.color_tl_loading_msg_text);
            loadingDialog2.setBackgroundDrawableResource(R.drawable.trans_loading_alert_bg);
            loadingDialog2.show();
            CoroutineDispatcher b = Dispatchers.b();
            TranslatorRecordViewModel$shareRecordImage$1$1$uri$1 translatorRecordViewModel$shareRecordImage$1$1$uri$1 = new TranslatorRecordViewModel$shareRecordImage$1$1$uri$1(noteBean, activity2, recyclerView, view, (Continuation<? super TranslatorRecordViewModel$shareRecordImage$1$1$uri$1>) null);
            this.L$0 = activity2;
            this.L$1 = loadingDialog2;
            this.label = 1;
            Object g = BuildersKt.g(b, translatorRecordViewModel$shareRecordImage$1$1$uri$1, this);
            if (g == coroutine_suspended) {
                return coroutine_suspended;
            }
            loadingDialog = loadingDialog2;
            Activity activity3 = activity2;
            obj = g;
            activity = activity3;
        } else if (i == 1) {
            loadingDialog = (LoadingDialog) this.L$1;
            activity = (Activity) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Uri uri = (Uri) obj;
        if (TranslatorConstants.isAirPro()) {
            Intent intent = new Intent(activity, ShareImagePreviewActivity.class);
            intent.setData(uri);
            activity.startActivity(intent);
        } else {
            ContextExtKt.D(activity, uri, (String) null, 2, (Object) null);
        }
        loadingDialog.dismiss();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorRecordViewModel$shareRecordImage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
