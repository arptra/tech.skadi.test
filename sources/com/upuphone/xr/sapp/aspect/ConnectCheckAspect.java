package com.upuphone.xr.sapp.aspect;

import androidx.annotation.Keep;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/aspect/ConnectCheckAspect;", "", "()V", "checkDeviceConnect", "", "joinPoint", "Lorg/aspectj/lang/ProceedingJoinPoint;", "connectCheckPointcut", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Aspect
public final class ConnectCheckAspect {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "ConnectCheckAspect";
    private static /* synthetic */ Throwable ajc$initFailureCause;
    public static /* synthetic */ ConnectCheckAspect ajc$perSingletonInstance;
    /* access modifiers changed from: private */
    public static boolean connectState;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/aspect/ConnectCheckAspect$Companion;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    static {
        try {
            ajc$perSingletonInstance = new ConnectCheckAspect();
        } catch (Throwable th) {
            ajc$initFailureCause = th;
        }
    }

    public static ConnectCheckAspect aspectOf() {
        ConnectCheckAspect connectCheckAspect = ajc$perSingletonInstance;
        if (connectCheckAspect != null) {
            return connectCheckAspect;
        }
        throw new NoAspectBoundException("com.upuphone.xr.sapp.aspect.ConnectCheckAspect", ajc$initFailureCause);
    }

    public static boolean hasAspect() {
        return ajc$perSingletonInstance != null;
    }

    @Around("connectCheckPointcut()")
    public final void checkDeviceConnect(@NotNull ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            proceedingJoinPoint.proceed();
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    @Pointcut("execution(@com.upuphone.xr.annotation.ConnectCheck * *(..))")
    public final void connectCheckPointcut() {
    }
}
