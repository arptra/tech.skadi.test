package com.upuphone.ar.transcribe.phone.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.common.app.LoadingDialog;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding;
import com.upuphone.ar.transcribe.databinding.ShareTranscribeRecordMarkBinding;
import com.upuphone.ar.transcribe.ext.ContextExtKt;
import com.upuphone.ar.transcribe.phone.view.ClipboardEditText;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity$gotoShareActivity$1", f = "TranscribeDetailActivity.kt", i = {0}, l = {575}, m = "invokeSuspend", n = {"dialog"}, s = {"L$0"})
public final class TranscribeDetailActivity$gotoShareActivity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ TranscribeDetailActivity this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity$gotoShareActivity$1$1", f = "TranscribeDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity$gotoShareActivity$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(transcribeDetailActivity, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Uri uri;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Intent intent = new Intent(transcribeDetailActivity, ShareActivity.class);
                TranscribeDetailActivity transcribeDetailActivity = transcribeDetailActivity;
                ActivityTranscribeDetailBinding activityTranscribeDetailBinding = null;
                if (transcribeDetailActivity.transType == 1) {
                    ActivityTranscribeDetailBinding access$getMBinding$p = transcribeDetailActivity.mBinding;
                    if (access$getMBinding$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        access$getMBinding$p = null;
                    }
                    ClipboardEditText clipboardEditText = access$getMBinding$p.k;
                    Intrinsics.checkNotNullExpressionValue(clipboardEditText, "tvRecord");
                    ActivityTranscribeDetailBinding access$getMBinding$p2 = transcribeDetailActivity.mBinding;
                    if (access$getMBinding$p2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    } else {
                        activityTranscribeDetailBinding = access$getMBinding$p2;
                    }
                    ConstraintLayout constraintLayout = activityTranscribeDetailBinding.c;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout, "detailHeader");
                    Bitmap b = ContextExtKt.b(constraintLayout, transcribeDetailActivity);
                    ConstraintLayout b2 = ShareTranscribeRecordMarkBinding.c(ContextExtKt.a(transcribeDetailActivity)).getRoot();
                    Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
                    uri = ContextExtKt.n(transcribeDetailActivity, clipboardEditText, b, ContextExtKt.b(b2, transcribeDetailActivity));
                } else {
                    ActivityTranscribeDetailBinding access$getMBinding$p3 = transcribeDetailActivity.mBinding;
                    if (access$getMBinding$p3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        access$getMBinding$p3 = null;
                    }
                    RecyclerView recyclerView = access$getMBinding$p3.h;
                    Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                    ActivityTranscribeDetailBinding access$getMBinding$p4 = transcribeDetailActivity.mBinding;
                    if (access$getMBinding$p4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    } else {
                        activityTranscribeDetailBinding = access$getMBinding$p4;
                    }
                    ConstraintLayout constraintLayout2 = activityTranscribeDetailBinding.c;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout2, "detailHeader");
                    Bitmap b3 = ContextExtKt.b(constraintLayout2, transcribeDetailActivity);
                    ConstraintLayout b4 = ShareTranscribeRecordMarkBinding.c(ContextExtKt.a(transcribeDetailActivity)).getRoot();
                    Intrinsics.checkNotNullExpressionValue(b4, "getRoot(...)");
                    uri = ContextExtKt.e(transcribeDetailActivity, recyclerView, b3, ContextExtKt.b(b4, transcribeDetailActivity));
                }
                intent.putExtra(ShareActivity.BITMAP_URL_KEY, uri);
                transcribeDetailActivity.startActivity(intent);
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
    public TranscribeDetailActivity$gotoShareActivity$1(TranscribeDetailActivity transcribeDetailActivity, Continuation<? super TranscribeDetailActivity$gotoShareActivity$1> continuation) {
        super(2, continuation);
        this.this$0 = transcribeDetailActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranscribeDetailActivity$gotoShareActivity$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        LoadingDialog loadingDialog;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LoadingDialog loadingDialog2 = new LoadingDialog(this.this$0);
            loadingDialog2.setMessage((CharSequence) this.this$0.getString(R.string.tl_share_record_wait_text));
            loadingDialog2.setMessageTextColorResource(R.color.color_tl_loading_msg_text);
            loadingDialog2.setBackgroundDrawableResource(R.drawable.trans_loading_alert_bg);
            loadingDialog2.setCancelable(false);
            loadingDialog2.show();
            CoroutineDispatcher b = Dispatchers.b();
            final TranscribeDetailActivity transcribeDetailActivity = this.this$0;
            AnonymousClass1 r3 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.L$0 = loadingDialog2;
            this.label = 1;
            if (BuildersKt.g(b, r3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            loadingDialog = loadingDialog2;
        } else if (i == 1) {
            loadingDialog = (LoadingDialog) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        loadingDialog.dismiss();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranscribeDetailActivity$gotoShareActivity$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
