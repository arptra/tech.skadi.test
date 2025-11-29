package com.upuphone.xr.sapp.unicron;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.sapp.entity.BasicGlassResponse;
import com.upuphone.xr.sapp.entity.ReceiveUnicronUpdateFileCmd;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.unicron.StarUnicronUpdater$sendReceiveUpdateFileCmd$1", f = "StarUnicronUpdater.kt", i = {}, l = {342}, m = "invokeSuspend", n = {}, s = {})
public final class StarUnicronUpdater$sendReceiveUpdateFileCmd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $downloadFile;
    final /* synthetic */ GlassUpdateInfo $glassUpdateInfo;
    final /* synthetic */ String $taskId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarUnicronUpdater$sendReceiveUpdateFileCmd$1(GlassUpdateInfo glassUpdateInfo, String str, File file, Continuation<? super StarUnicronUpdater$sendReceiveUpdateFileCmd$1> continuation) {
        super(2, continuation);
        this.$glassUpdateInfo = glassUpdateInfo;
        this.$taskId = str;
        this.$downloadFile = file;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new StarUnicronUpdater$sendReceiveUpdateFileCmd$1(this.$glassUpdateInfo, this.$taskId, this.$downloadFile, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        BasicGlassResponse basicGlassResponse;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String digest = this.$glassUpdateInfo.getDigest();
            String latestVersion = this.$glassUpdateInfo.getLatestVersion();
            if (digest == null || latestVersion == null) {
                StarUnicronUpdater starUnicronUpdater = StarUnicronUpdater.b;
                starUnicronUpdater.x("sendReceiveUpdateFileCmd null info, digest: " + digest + ", latestVersion: " + latestVersion);
                return Unit.INSTANCE;
            }
            StarUnicronUpdater.b.w("sendReceiveUpdateFileCmd start");
            UnicronHelper unicronHelper = UnicronHelper.f7834a;
            ReceiveUnicronUpdateFileCmd receiveUnicronUpdateFileCmd = new ReceiveUnicronUpdateFileCmd(latestVersion, digest, this.$taskId);
            this.label = 1;
            obj = UnicronHelper.j(unicronHelper, receiveUnicronUpdateFileCmd, 0, this, 2, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                StarUnicronUpdater starUnicronUpdater2 = StarUnicronUpdater.b;
                starUnicronUpdater2.x("sendReceiveUpdateFileCmd error: " + e);
                basicGlassResponse = null;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        basicGlassResponse = (BasicGlassResponse) obj;
        StarUnicronUpdater starUnicronUpdater3 = StarUnicronUpdater.b;
        starUnicronUpdater3.w("sendReceiveUpdateFileCmd response: " + basicGlassResponse);
        if (basicGlassResponse == null || !basicGlassResponse.isSuccess()) {
            starUnicronUpdater3.w("sendReceiveUpdateFileCmd, shareAbility#cancel");
            starUnicronUpdater3.t().cancel(this.$taskId, 1);
            StarUnicronUpdater.G(starUnicronUpdater3, this.$downloadFile, this.$glassUpdateInfo, 0, 4, (Object) null);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((StarUnicronUpdater$sendReceiveUpdateFileCmd$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
