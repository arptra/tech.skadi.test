package com.upuphone.xr.sapp.unicron;

import android.os.Environment;
import android.os.StatFs;
import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.sapp.entity.CheckUpdateFileReq;
import com.upuphone.xr.sapp.entity.CheckUpdateFileResp;
import com.upuphone.xr.sapp.glass.GlassExtKt;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$downloadPreCheck$1", f = "UnicronUpdateHelper.kt", i = {}, l = {454}, m = "invokeSuspend", n = {}, s = {})
public final class UnicronUpdateHelper$downloadPreCheck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GlassUpdateInfo $glassUpdateInfo;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnicronUpdateHelper$downloadPreCheck$1(GlassUpdateInfo glassUpdateInfo, Continuation<? super UnicronUpdateHelper$downloadPreCheck$1> continuation) {
        super(2, continuation);
        this.$glassUpdateInfo = glassUpdateInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UnicronUpdateHelper$downloadPreCheck$1(this.$glassUpdateInfo, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CheckUpdateFileResp checkUpdateFileResp;
        long j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String latestVersion = this.$glassUpdateInfo.getLatestVersion();
            String digest = this.$glassUpdateInfo.getDigest();
            if (latestVersion == null || latestVersion.length() == 0 || digest == null || digest.length() == 0) {
                UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
                unicronUpdateHelper.M("downloadPreCheck, wrong latestVersion: " + latestVersion + ", digest: " + digest);
                return Unit.INSTANCE;
            }
            UnicronUpdateHelper.b.L("downloadPreCheck, checkUpdateFile start");
            UnicronUpdateAdapter unicronUpdateAdapter = UnicronUpdateAdapter.f7835a;
            CheckUpdateFileReq checkUpdateFileReq = new CheckUpdateFileReq(latestVersion, digest);
            this.label = 1;
            obj = unicronUpdateAdapter.c(checkUpdateFileReq, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                UnicronUpdateHelper unicronUpdateHelper2 = UnicronUpdateHelper.b;
                unicronUpdateHelper2.M("downloadPreCheck, checkUpdateFile error: " + e);
                checkUpdateFileResp = null;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        checkUpdateFileResp = (CheckUpdateFileResp) obj;
        UnicronUpdateHelper unicronUpdateHelper3 = UnicronUpdateHelper.b;
        unicronUpdateHelper3.L("downloadPreCheck, checkUpdateFile result: " + checkUpdateFileResp);
        if (checkUpdateFileResp == null || !checkUpdateFileResp.isSuccess() || !Intrinsics.areEqual((Object) checkUpdateFileResp.getExist(), (Object) Boxing.boxBoolean(true))) {
            long a2 = GlassExtKt.a(this.$glassUpdateInfo);
            try {
                j = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes();
            } catch (Exception e2) {
                UnicronUpdateHelper unicronUpdateHelper4 = UnicronUpdateHelper.b;
                unicronUpdateHelper4.L("downloadPreCheck, getDataDirectory availableBytes error: " + e2);
                j = 0;
            }
            if (j < a2) {
                UnicronUpdateHelper unicronUpdateHelper5 = UnicronUpdateHelper.b;
                unicronUpdateHelper5.L("downloadPreCheck, phoneAvailableBytes(" + j + ") < requiredStorage(" + a2 + ")");
                return Unit.INSTANCE;
            }
            UnicronUpdateHelper.b.Y(GlobalExtKt.f(), this.$glassUpdateInfo, true);
            return Unit.INSTANCE;
        }
        unicronUpdateHelper3.L("downloadPreCheck, update file already exist on remote");
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UnicronUpdateHelper$downloadPreCheck$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
