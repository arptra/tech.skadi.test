package com.upuphone.xr.sapp.glass;

import com.upuphone.star.core.log.ULog;
import com.upuphone.star.download.manager.Utils;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.JsonUtils;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nGlassScreenShotHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassScreenShotHelper.kt\ncom/upuphone/xr/sapp/glass/GlassScreenShotHelper$startScreenShot$1$result$1\n+ 2 GlassMessageHelper.kt\ncom/upuphone/xr/sapp/glass/GlassMessageHelper\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n*L\n1#1,587:1\n293#2,2:588\n186#2:590\n187#2,11:600\n209#2,11:611\n314#3,9:591\n323#3,2:622\n29#4,5:624\n*S KotlinDebug\n*F\n+ 1 GlassScreenShotHelper.kt\ncom/upuphone/xr/sapp/glass/GlassScreenShotHelper$startScreenShot$1$result$1\n*L\n256#1:588,2\n256#1:590\n256#1:600,11\n256#1:611,11\n256#1:591,9\n256#1:622,2\n256#1:624,5\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/sapp/glass/GlassScreenshotResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassScreenShotHelper$startScreenShot$1$result$1", f = "GlassScreenShotHelper.kt", i = {0, 0, 0, 0}, l = {591}, m = "invokeSuspend", n = {"msg", "action$iv", "subAction$iv", "needSendMessageCallback$iv"}, s = {"L$0", "L$1", "L$2", "Z$0"})
public final class GlassScreenShotHelper$startScreenShot$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GlassScreenshotResult>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;

    public GlassScreenShotHelper$startScreenShot$1$result$1(Continuation<? super GlassScreenShotHelper$startScreenShot$1$result$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassScreenShotHelper$startScreenShot$1$result$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        JsonUtils jsonUtils;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("GlassScreenShotHelper", "startScreenShot, start");
            Boolean bool = BuildConfig.b;
            Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
            String absolutePath = bool.booleanValue() ? Utils.f6462a.a(GlobalExtKt.f(), "glass_screens", "").getAbsolutePath() : null;
            JsonUtils jsonUtils2 = JsonUtils.f7893a;
            String d = jsonUtils2.d(new GlassScreenshotReq(absolutePath, (Boolean) null, 2, (DefaultConstructorMarker) null));
            delegate.a("GlassScreenShotHelper", "startScreenShot, msg: " + d);
            GlassMessageHelper glassMessageHelper = GlassMessageHelper.f7054a;
            boolean areEqual = Intrinsics.areEqual((Object) DynamicAdapterUtils.f7879a.a(), (Object) "1002");
            this.L$0 = d;
            this.L$1 = "screenshot";
            this.L$2 = "get_glass_screenshot";
            this.L$3 = jsonUtils2;
            this.Z$0 = areEqual;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            GlassMessageHelper$sendMessageAndWait$2$messageListener$1 glassMessageHelper$sendMessageAndWait$2$messageListener$1 = new GlassMessageHelper$sendMessageAndWait$2$messageListener$1(cancellableContinuationImpl);
            GlassMessageHelper glassMessageHelper2 = GlassMessageHelper.f7054a;
            glassMessageHelper2.c("screenshot", "get_glass_screenshot", glassMessageHelper$sendMessageAndWait$2$messageListener$1);
            cancellableContinuationImpl.E(new GlassMessageHelper$sendMessageAndWait$2$1(glassMessageHelper2.i(jsonUtils2.d(glassMessageHelper2.d("screenshot", "get_glass_screenshot", d)), (byte[]) null, new GlassMessageHelper$sendMessageAndWait$2$listener$1("screenshot", "get_glass_screenshot", glassMessageHelper$sendMessageAndWait$2$messageListener$1, cancellableContinuationImpl), areEqual), "screenshot", "get_glass_screenshot", glassMessageHelper$sendMessageAndWait$2$messageListener$1));
            obj = cancellableContinuationImpl.u();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            jsonUtils = jsonUtils2;
        } else if (i == 1) {
            jsonUtils = (JsonUtils) this.L$3;
            String str = (String) this.L$2;
            String str2 = (String) this.L$1;
            String str3 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str4 = (String) obj;
        Type type = new GlassScreenShotHelper$startScreenShot$1$result$1$invokeSuspend$$inlined$sendMessageAndWaitResult$1().getType();
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
            Intrinsics.checkNotNull(type);
            return jsonUtils.a("{}", type);
        }
        Intrinsics.checkNotNull(type);
        return jsonUtils.a(str4, type);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super GlassScreenshotResult> continuation) {
        return ((GlassScreenShotHelper$startScreenShot$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
