package com.upuphone.xr.sapp.vm.internal;

import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.monitor.weather.WeatherDataFlow;
import com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vm.internal.SuperMessageManger$registerWeatherDataCallback$1", f = "SuperMessageManger.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {})
public final class SuperMessageManger$registerWeatherDataCallback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SuperMessageManger this$0;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H@"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/monitor/weather/model/ArWeatherModel;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.vm.internal.SuperMessageManger$registerWeatherDataCallback$1$1", f = "SuperMessageManger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.vm.internal.SuperMessageManger$registerWeatherDataCallback$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ArWeatherModel, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(superMessageManger, continuation);
            r0.L$0 = obj;
            return r0;
        }

        @Nullable
        public final Object invoke(@Nullable ArWeatherModel arWeatherModel, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(arWeatherModel, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ArWeatherModel arWeatherModel = (ArWeatherModel) this.L$0;
                if (arWeatherModel != null) {
                    SuperMessageManger superMessageManger = superMessageManger;
                    long currentTimeMillis = System.currentTimeMillis();
                    String sunriseTime = arWeatherModel.getSunriseTime();
                    String str = "";
                    if (sunriseTime == null) {
                        sunriseTime = str;
                    }
                    Long j = superMessageManger.A0(sunriseTime);
                    String sunsetTime = arWeatherModel.getSunsetTime();
                    if (sunsetTime != null) {
                        str = sunsetTime;
                    }
                    Long j2 = superMessageManger.A0(str);
                    boolean e = ControlUtils.f7858a.e();
                    ULog.Delegate delegate = ULog.f6446a;
                    String f = SuperMessageManger.n;
                    String sunriseTime2 = arWeatherModel.getSunriseTime();
                    String sunsetTime2 = arWeatherModel.getSunsetTime();
                    delegate.a(f, "weatherData autoBriModel is: " + e + " and  sunriseTime:" + sunriseTime2 + "  sunsetTime:" + sunsetTime2 + " currentTimeMillis is: " + currentTimeMillis + " and sunrise is: " + j + " and sunset is: " + j2);
                    superMessageManger.w0(j);
                    superMessageManger.y0(j2);
                    if (!(!e || j == null || j2 == null)) {
                        if (currentTimeMillis < j.longValue() || currentTimeMillis >= j2.longValue()) {
                            superMessageManger.s0("sunset");
                        } else {
                            superMessageManger.s0("sunrise");
                        }
                    }
                    NaviManager.getInstance(GlobalExtKt.f()).setWeatherInfo(arWeatherModel.getSunriseTime(), arWeatherModel.getSunsetTime());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperMessageManger$registerWeatherDataCallback$1(SuperMessageManger superMessageManger, Continuation<? super SuperMessageManger$registerWeatherDataCallback$1> continuation) {
        super(2, continuation);
        this.this$0 = superMessageManger;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SuperMessageManger$registerWeatherDataCallback$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow a2 = WeatherDataFlow.f7804a.a();
            final SuperMessageManger superMessageManger = this.this$0;
            AnonymousClass1 r1 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (FlowKt.k(a2, r1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SuperMessageManger$registerWeatherDataCallback$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
