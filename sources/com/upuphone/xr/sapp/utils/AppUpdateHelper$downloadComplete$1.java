package com.upuphone.xr.sapp.utils;

import androidx.appcompat.app.AppCompatActivity;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.xjmz.myvu.bridge.ActivityExtKt;
import java.io.File;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.AppUpdateHelper$downloadComplete$1", f = "AppUpdateHelper.kt", i = {}, l = {545}, m = "invokeSuspend", n = {}, s = {})
public final class AppUpdateHelper$downloadComplete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ String $digest;
    final /* synthetic */ File $downloadFile;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppUpdateHelper$downloadComplete$1(String str, File file, AppCompatActivity appCompatActivity, Continuation<? super AppUpdateHelper$downloadComplete$1> continuation) {
        super(2, continuation);
        this.$digest = str;
        this.$downloadFile = file;
        this.$activity = appCompatActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AppUpdateHelper$downloadComplete$1(this.$digest, this.$downloadFile, this.$activity, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher b = Dispatchers.b();
            AppUpdateHelper$downloadComplete$1$md5$1 appUpdateHelper$downloadComplete$1$md5$1 = new AppUpdateHelper$downloadComplete$1$md5$1(this.$downloadFile, (Continuation<? super AppUpdateHelper$downloadComplete$1$md5$1>) null);
            this.label = 1;
            obj = BuildersKt.g(b, appUpdateHelper$downloadComplete$1$md5$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str = (String) obj;
        if (!Intrinsics.areEqual((Object) this.$digest, (Object) str)) {
            ULog.Delegate delegate = ULog.f6446a;
            String str2 = this.$digest;
            delegate.c("AppUpdateHelper", "downloadComplete, expect digest: " + str2 + ", but was: " + str);
            ContextExtKt.e(R.string.status_verify_fail, 0, 2, (Object) null);
            return Unit.INSTANCE;
        }
        AppUpdateHelper appUpdateHelper = AppUpdateHelper.f7841a;
        AppUpdateHelper.k = this.$downloadFile;
        if (!GlobalExtKt.f().getPackageManager().canRequestPackageInstalls()) {
            ULog.f6446a.c("AppUpdateHelper", "downloadComplete, canRequestPackageInstalls=false");
            ActivityExtKt.a(this.$activity, AnonymousClass1.INSTANCE);
            return Unit.INSTANCE;
        }
        AppUtils appUtils = AppUtils.f7842a;
        appUtils.o(GlobalExtKt.f(), appUtils.f(GlobalExtKt.f(), this.$downloadFile));
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AppUpdateHelper$downloadComplete$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
