package com.xjsd.ai.assistant.phone.helper;

import android.os.Handler;
import android.os.HandlerThread;
import com.honey.account.ka.a;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.event.TimerTimeoutEvent;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.ai.assistant.protocol.Scene;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/xjsd/ai/assistant/phone/helper/ExitTimer;", "", "<init>", "()V", "", "d", "f", "c", "", "timeout", "e", "(J)V", "Landroid/os/HandlerThread;", "b", "Landroid/os/HandlerThread;", "mWorker", "Landroid/os/Handler;", "Lkotlin/Lazy;", "h", "()Landroid/os/Handler;", "mHandler", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "exitTask", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ExitTimer {

    /* renamed from: a  reason: collision with root package name */
    public static final ExitTimer f8563a = new ExitTimer();
    public static final HandlerThread b;
    public static final Lazy c = LazyKt.lazy(ExitTimer$mHandler$2.INSTANCE);
    public static final Runnable d = new a();

    static {
        HandlerThread handlerThread = new HandlerThread("ExitTimer");
        b = handlerThread;
        handlerThread.start();
    }

    public static final void g() {
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        String str = Scene.NORMAL;
        String str2 = cacheAbility != null ? (String) cacheAbility.getCacheWithDefault(AssistantConstants.Key.SCENE_ID, str) : null;
        if (str2 != null) {
            str = str2;
        }
        if (Intrinsics.areEqual((Object) str, (Object) Scene.CALL)) {
            ILog.a("ExitTimer", "手机端触发超时策略，但当前场景是通话场景，不退出");
            return;
        }
        ILog.a("ExitTimer", "手机端触发退出策略");
        EventBus.c().k(new TimerTimeoutEvent());
    }

    public final void c() {
        if (DeviceUtils.d()) {
            ILog.a("ExitTimer", "取消超时检测任务");
            h().removeCallbacks(d);
        }
    }

    public final void d() {
        e(8000);
    }

    public final void e(long j) {
        if (DeviceUtils.d()) {
            CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
            boolean a2 = VrStateHelper.f8567a.a();
            Boolean bool = cacheAbility != null ? (Boolean) cacheAbility.getCacheWithDefault("isAsrOnlyWakeup", Boolean.FALSE) : null;
            boolean booleanValue = bool == null ? false : bool.booleanValue();
            if (a2 && !booleanValue) {
                ILog.a("ExitTimer", "启动超时检测任务，时间->" + j);
                Handler h = h();
                Runnable runnable = d;
                h.removeCallbacks(runnable);
                h().postDelayed(runnable, j);
            }
        }
    }

    public final void f() {
        e(15000);
    }

    public final Handler h() {
        return (Handler) c.getValue();
    }
}
