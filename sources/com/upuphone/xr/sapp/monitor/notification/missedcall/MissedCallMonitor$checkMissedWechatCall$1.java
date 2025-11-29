package com.upuphone.xr.sapp.monitor.notification.missedcall;

import com.meizu.common.util.LunarCalendar;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.monitor.notification.model.ArNotificationModel;
import com.upuphone.xr.sapp.monitor.notification.model.DiscernResultModel;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.monitor.starry.StarryNotificationBase;
import com.upuphone.xr.sapp.utils.AppInfoHelper;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.notification.missedcall.MissedCallMonitor$checkMissedWechatCall$1", f = "MissedCallMonitor.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
public final class MissedCallMonitor$checkMissedWechatCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public MissedCallMonitor$checkMissedWechatCall$1(Continuation<? super MissedCallMonitor$checkMissedWechatCall$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MissedCallMonitor$checkMissedWechatCall$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MissedCallMonitor missedCallMonitor = MissedCallMonitor.f7773a;
            this.label = 1;
            obj2 = missedCallMonitor.g(this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List<MissedCallInfo> list = (List) obj2;
        ULog.f6446a.a("MissedCallMonitor", "checkMissedWechatCall: callInfo: " + list.size());
        if (list.isEmpty()) {
            return Unit.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        for (MissedCallInfo missedCallInfo : list) {
            long currentTimeMillis = (System.currentTimeMillis() - missedCallInfo.b()) / ((long) 1000);
            if (currentTimeMillis < 86400) {
                if (currentTimeMillis > 3600) {
                    str = GlobalExtKt.g(R.string.missed_wechat_before_hours, Boxing.boxLong(currentTimeMillis / ((long) 3600)));
                } else {
                    str = GlobalExtKt.g(R.string.missed_wechat_before_minutes, Boxing.boxLong(Long.max(currentTimeMillis / ((long) 60), 1)));
                }
                if (missedCallInfo.a() > 1) {
                    str = str + GlobalExtKt.g(R.string.missed_call_num, Boxing.boxInt(missedCallInfo.a()));
                }
                arrayList.add(new ArNotificationModel("phone-com.android.dialer-" + missedCallInfo.c() + LunarCalendar.DATE_SEPARATOR + missedCallInfo.b(), missedCallInfo.c(), str, missedCallInfo.b(), "MSG_TYPE_MISSEDCALL", "com.tencent.mm", AppInfoHelper.f7840a.b("com.tencent.mm"), false, (String) null, (DiscernResultModel) null, 896, (DefaultConstructorMarker) null));
            }
        }
        StarryMessageHelper.t(StarryMessageHelper.f7799a, AppInfoHelper.f7840a.a(MainApplication.k.f(), "com.tencent.mm"), new StarryNotificationBase("SHOW_NOTIFICATION", arrayList), (SendMessageListener) null, 4, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MissedCallMonitor$checkMissedWechatCall$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
