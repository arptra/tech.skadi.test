package com.upuphone.xr.sapp.glass;

import com.upuphone.star.fota.phone.GlassUpdateResultParam;
import com.upuphone.xr.sapp.entity.BasicGlassInfo;
import com.upuphone.xr.sapp.glass.db.GlassUpdateDB;
import com.upuphone.xr.sapp.glass.db.GlassUpdateResultDao;
import com.upuphone.xr.sapp.glass.db.GlassUpdateResultEntity;
import com.upuphone.xr.sapp.utils.JsonUtils;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateResultHelper$uploadUpdateResult$1", f = "GlassUpdateResultHelper.kt", i = {}, l = {207}, m = "invokeSuspend", n = {}, s = {})
public final class GlassUpdateResultHelper$uploadUpdateResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $errorCode;
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ String $uid;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateResultHelper$uploadUpdateResult$1(boolean z, String str, String str2, String str3, Continuation<? super GlassUpdateResultHelper$uploadUpdateResult$1> continuation) {
        super(2, continuation);
        this.$isSuccess = z;
        this.$errorMsg = str;
        this.$errorCode = str2;
        this.$uid = str3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GlassUpdateResultHelper$uploadUpdateResult$1 glassUpdateResultHelper$uploadUpdateResult$1 = new GlassUpdateResultHelper$uploadUpdateResult$1(this.$isSuccess, this.$errorMsg, this.$errorCode, this.$uid, continuation);
        glassUpdateResultHelper$uploadUpdateResult$1.L$0 = obj;
        return glassUpdateResultHelper$uploadUpdateResult$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            GlassUpdateResultHelper glassUpdateResultHelper = GlassUpdateResultHelper.b;
            BasicGlassInfo c = glassUpdateResultHelper.s();
            if (c == null) {
                glassUpdateResultHelper.y("uploadUpdateResult, savedGlassInfo is null");
                return Unit.INSTANCE;
            }
            String e = glassUpdateResultHelper.v();
            if (e == null) {
                glassUpdateResultHelper.y("uploadUpdateResult, savedGlassUpdateVersion is null");
                return Unit.INSTANCE;
            }
            long d = glassUpdateResultHelper.t();
            glassUpdateResultHelper.A(c, e, System.currentTimeMillis() - d, this.$isSuccess, this.$errorMsg, this.$errorCode);
            boolean z = this.$isSuccess;
            if (z) {
                str = this.$errorMsg;
            } else {
                str = "errorCode=" + this.$errorCode + ", errorMsg=" + this.$errorMsg;
            }
            GlassUpdateResultParam a2 = glassUpdateResultHelper.p(c, e, d, z, str, this.$uid);
            GlassUpdateResultDao e2 = GlassUpdateDB.f7073a.a().e();
            GlassUpdateResultEntity a3 = GlassUpdateResultEntity.Companion.a(JsonUtils.f7893a.d(a2));
            this.label = 1;
            if (e2.a(a3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        GlassUpdateResultHelper glassUpdateResultHelper2 = GlassUpdateResultHelper.b;
        GlassUpdateResultHelper.G(glassUpdateResultHelper2, 0, 1, (Object) null);
        glassUpdateResultHelper2.B((BasicGlassInfo) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassUpdateResultHelper$uploadUpdateResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
