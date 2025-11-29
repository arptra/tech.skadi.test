package com.upuphone.xr.sapp.aspect;

import androidx.annotation.Keep;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.annotation.FastClickCheck;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/aspect/FastClickAspect;", "", "()V", "lastClick", "", "doubleClickCheck", "", "joinPoint", "Lorg/aspectj/lang/ProceedingJoinPoint;", "doubleClickCheckPointcut", "isFastClick", "", "interval", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Aspect
@Keep
public final class FastClickAspect {
    private static /* synthetic */ Throwable ajc$initFailureCause;
    public static /* synthetic */ FastClickAspect ajc$perSingletonInstance;
    private long lastClick;

    static {
        try {
            ajc$perSingletonInstance = new FastClickAspect();
        } catch (Throwable th) {
            ajc$initFailureCause = th;
        }
    }

    public static FastClickAspect aspectOf() {
        FastClickAspect fastClickAspect = ajc$perSingletonInstance;
        if (fastClickAspect != null) {
            return fastClickAspect;
        }
        throw new NoAspectBoundException("com.upuphone.xr.sapp.aspect.FastClickAspect", ajc$initFailureCause);
    }

    public static boolean hasAspect() {
        return ajc$perSingletonInstance != null;
    }

    /* access modifiers changed from: private */
    public final boolean isFastClick(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClick > j) {
            this.lastClick = currentTimeMillis;
            return false;
        }
        this.lastClick = currentTimeMillis;
        return true;
    }

    @Around("doubleClickCheckPointcut()")
    @Keep
    public final void doubleClickCheck(@NotNull ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !isFastClick(fastClickCheck.interval())) {
            proceedingJoinPoint.proceed();
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    @Pointcut("execution(@com.upuphone.xr.annotation.FastClickCheck * *(..))")
    public final void doubleClickCheckPointcut() {
    }
}
