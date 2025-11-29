package com.upuphone.xr.sapp.glass;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.meizu.common.app.SlideNotice;
import com.meizu.common.widget.ContentToastLayout;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassScreenShotHelper$handleScreenShotResult$1", f = "GlassScreenShotHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GlassScreenShotHelper$handleScreenShotResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $safeActivity;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassScreenShotHelper$handleScreenShotResult$1(AppCompatActivity appCompatActivity, Continuation<? super GlassScreenShotHelper$handleScreenShotResult$1> continuation) {
        super(2, continuation);
        this.$safeActivity = appCompatActivity;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(AppCompatActivity appCompatActivity, View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(GlassScreenShotHelper.c, "image/*");
        appCompatActivity.startActivity(intent);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassScreenShotHelper$handleScreenShotResult$1(this.$safeActivity, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SlideNotice slideNotice = new SlideNotice(this.$safeActivity);
            ContentToastLayout contentToastLayout = new ContentToastLayout(this.$safeActivity);
            contentToastLayout.setText(this.$safeActivity.getString(R.string.screenshot_save_success));
            contentToastLayout.setTitleTextMaxLine(2);
            contentToastLayout.setActionText(this.$safeActivity.getString(R.string.check_screen));
            contentToastLayout.setToastType(2);
            contentToastLayout.setActionClickListener(new b(this.$safeActivity));
            slideNotice.setCustomView(contentToastLayout);
            slideNotice.showNotice(false);
            DataStoreUtils.e.a().o("SCREEN_SHOT_SAVED", Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassScreenShotHelper$handleScreenShotResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
