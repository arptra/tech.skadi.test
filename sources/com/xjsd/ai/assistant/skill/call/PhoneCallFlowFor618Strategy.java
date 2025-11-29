package com.xjsd.ai.assistant.skill.call;

import android.content.Context;
import android.text.TextUtils;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.call.PhoneBusinessData;
import com.xjsd.ai.assistant.skill.call.util.CallConditionLack;
import com.xjsd.ai.assistant.skill.call.util.CallType;
import com.xjsd.ai.assistant.skill.call.util.PhoneCallCache;
import com.xjsd.ai.assistant.skill.call.util.PhoneCallUtil;
import com.xjsd.ai.assistant.skill.call.util.SimCardUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\u0018\u0000 \u000e2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u000e\u001a\u00020\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019JU\u0010#\u001a\u00020\r2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0\u001a2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u001f0\u001aH\u0002¢\u0006\u0004\b#\u0010$J]\u0010%\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00042!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0\u001a2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u001f0\u001aH\u0002¢\u0006\u0004\b%\u0010&J)\u0010'\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\u001bH\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowFor618Strategy;", "Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowStrategy;", "<init>", "()V", "Lcom/xjsd/ai/assistant/skill/call/util/CallConditionLack;", "j", "()Lcom/xjsd/ai/assistant/skill/call/util/CallConditionLack;", "", "Lcom/xjsd/ai/assistant/protocol/call/SimCardBean;", "simCards", "", "contactName", "phoneNumber", "", "b", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "", "cardIndex", "tel", "", "isReplyCall", "a", "(ILjava/lang/String;Ljava/lang/String;Z)V", "telNum", "e", "(ILjava/lang/String;)V", "Lkotlin/Function1;", "Lcom/xjsd/ai/assistant/skill/call/util/CallType;", "Lkotlin/ParameterName;", "name", "callType", "", "callFlow", "lack", "playTipFlow", "l", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "o", "(Lcom/xjsd/ai/assistant/skill/call/util/CallConditionLack;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "n", "(ILjava/lang/String;Lcom/xjsd/ai/assistant/skill/call/util/CallType;)V", "m", "(Ljava/lang/String;)V", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PhoneCallFlowFor618Strategy extends PhoneCallFlowStrategy {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowFor618Strategy$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void a(int i, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str2, "tel");
        PhoneCallFlowFor618Strategy$chooseChannelToDialFlow$callAction$1 phoneCallFlowFor618Strategy$chooseChannelToDialFlow$callAction$1 = new PhoneCallFlowFor618Strategy$chooseChannelToDialFlow$callAction$1(this, i, str2);
        l(new PhoneCallFlowFor618Strategy$chooseChannelToDialFlow$callFlow$1(z, this, i, str2, str, phoneCallFlowFor618Strategy$chooseChannelToDialFlow$callAction$1), new PhoneCallFlowFor618Strategy$chooseChannelToDialFlow$playTipFlow$1(z, phoneCallFlowFor618Strategy$chooseChannelToDialFlow$callAction$1));
    }

    public void b(List list, String str, String str2) {
        Intrinsics.checkNotNullParameter(list, "simCards");
        Intrinsics.checkNotNullParameter(str2, "phoneNumber");
        PhoneCallFlowFor618Strategy$chooseSimCardFlow$chooseSimCardFlow$1 phoneCallFlowFor618Strategy$chooseSimCardFlow$chooseSimCardFlow$1 = new PhoneCallFlowFor618Strategy$chooseSimCardFlow$chooseSimCardFlow$1(this, list, str, str2);
        if (PhoneCallUtil.c()) {
            phoneCallFlowFor618Strategy$chooseSimCardFlow$chooseSimCardFlow$1.invoke();
            return;
        }
        Context a2 = ContextHelper.a();
        Intrinsics.checkNotNull(a2);
        boolean i = PhoneCallUtil.i(a2);
        boolean f = PhoneCallUtil.f();
        if (!i && f) {
            ILog.a("PhoneCallFlowFor618Strategy", "chooseSimCardFlow: 未锁屏且应用在前台");
            phoneCallFlowFor618Strategy$chooseSimCardFlow$chooseSimCardFlow$1.invoke();
        } else if (PhoneCallUtil.i(a2) && PhoneCallUtil.b(a2)) {
            ILog.a("PhoneCallFlowFor618Strategy", "chooseSimCardFlow: 适配国内三方手机，锁屏且有权限");
            phoneCallFlowFor618Strategy$chooseSimCardFlow$chooseSimCardFlow$1.invoke();
        } else if (!PhoneCallUtil.e() || !PhoneCallUtil.a(a2)) {
            ILog.a("PhoneCallFlowFor618Strategy", "chooseSimCardFlow: 适配三方手机，缺乏权限不能选卡，直接拨打");
            new PhoneCallFlowFor618Strategy$chooseSimCardFlow$dialFlow$1(this, str, str2).invoke();
        } else {
            ILog.a("PhoneCallFlowFor618Strategy", "chooseSimCardFlow: 适配国内三方手机，未锁屏，应用退后台且有权限");
            phoneCallFlowFor618Strategy$chooseSimCardFlow$chooseSimCardFlow$1.invoke();
        }
    }

    public void e(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "telNum");
        ILog.a("PhoneCallFlowFor618Strategy", "makeCallByPhoneFail: 使用眼镜蓝牙拨打");
        m(str);
    }

    public CallConditionLack j() {
        ILog.a("PhoneCallFlowFor618Strategy", "validDialPrecondition: 拨打电话条件校验");
        return !PhoneCallUtil.g() ? CallConditionLack.BLUETOOTH_SCO : i();
    }

    public final void l(Function1 function1, Function1 function12) {
        if (PhoneCallUtil.c()) {
            function1.invoke(CallType.PHONE);
            return;
        }
        Context a2 = ContextHelper.a();
        Intrinsics.checkNotNull(a2);
        if (!PhoneCallUtil.i(a2) && PhoneCallUtil.f()) {
            function1.invoke(CallType.PHONE);
        } else if (PhoneCallUtil.i(a2)) {
            if (PhoneCallUtil.b(a2)) {
                ILog.a("PhoneCallFlowFor618Strategy", "chooseFlowToInvoke: 当前锁屏，但相关权限已被授予，可直接拨打电话");
                function1.invoke(CallType.PHONE);
                return;
            }
            o(CallConditionLack.LOCK_SCREEN_618, function1, function12);
        } else if (PhoneCallUtil.a(a2)) {
            ILog.a("PhoneCallFlowFor618Strategy", "chooseFlowToInvoke: 应用在后台，但相关权限已被授予，可直接拨打电话");
            function1.invoke(CallType.PHONE);
        } else {
            o(CallConditionLack.APP_IN_BACKGROUND_618, function1, function12);
        }
    }

    public final void m(String str) {
        ILog.a("PhoneCallFlowFor618Strategy", "makeCallByBluetooth: phoneNumber->" + str);
        PhoneBusinessData phoneBusinessData = new PhoneBusinessData();
        phoneBusinessData.setType(6);
        phoneBusinessData.setMultipleWheel(false);
        phoneBusinessData.setPhoneNumber(str);
        g(phoneBusinessData);
    }

    public final void n(int i, String str, CallType callType) {
        String name = callType.name();
        ILog.a("PhoneCallFlowFor618Strategy", "makeCallWithType: cardIndex->" + i + ", telNum->" + str + ", callType->" + name);
        PhoneCallCache.f8678a.b();
        if (callType == CallType.BLUETOOTH) {
            m(str);
        } else {
            d(i, str);
        }
    }

    public final void o(CallConditionLack callConditionLack, Function1 function1, Function1 function12) {
        int i;
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (cacheAbility != null) {
            String persistValue = cacheAbility.getPersistValue("SIM_TTS_TIPS_NUMBER");
            if (TextUtils.isEmpty(persistValue)) {
                i = 0;
            } else {
                Intrinsics.checkNotNull(persistValue);
                i = Integer.parseInt(persistValue);
            }
            if (i < 3) {
                int a2 = SimCardUtil.a(ContextHelper.a());
                int c = SimCardUtil.c();
                if (a2 > 1 && c == -1) {
                    ILog.a("PhoneCallFlowFor618Strategy", "playTipAndDial: 有多张SIM卡，且未设置默认卡，使用蓝牙拨打");
                    function12.invoke(callConditionLack);
                    cacheAbility.persist("SIM_TTS_TIPS_NUMBER", String.valueOf(i + 1));
                    return;
                }
            }
            function1.invoke(CallType.BLUETOOTH);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
