package com.xjsd.ai.assistant.skill.call;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import androidx.core.content.ContextCompat;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.api.SappAbilityOperator;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.connect.InterconnectAbility;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.nlu.NluContextDataMaintainer;
import com.xjsd.ai.assistant.nlu.bean.ContextData;
import com.xjsd.ai.assistant.phone.R;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.BusinessDataType;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.call.PhoneBusinessData;
import com.xjsd.ai.assistant.skill.call.util.CallConditionLack;
import com.xjsd.ai.assistant.skill.call.util.PhoneCallCache;
import com.xjsd.ai.assistant.skill.call.util.PhoneCallUtil;
import com.xjsd.ai.assistant.skill.call.util.SimCardUtil;
import com.xjsd.ai.assistant.template.TtsCallTemplate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u001a2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\u0006J/\u0010\u000f\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000bH&¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0011\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0004¢\u0006\u0004\b\u0011\u0010\u0010J'\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000bH\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000bH&¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010\"\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\u00020\u000e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0002¢\u0006\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowStrategy;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/skill/call/util/CallConditionLack;", "i", "()Lcom/xjsd/ai/assistant/skill/call/util/CallConditionLack;", "j", "", "Lcom/xjsd/ai/assistant/protocol/call/SimCardBean;", "simCards", "", "contactName", "phoneNumber", "", "b", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "h", "", "cardIndex", "contact", "tel", "c", "(ILjava/lang/String;Ljava/lang/String;)V", "", "isReplyCall", "a", "(ILjava/lang/String;Ljava/lang/String;Z)V", "telNum", "d", "(ILjava/lang/String;)V", "e", "Lcom/xjsd/ai/assistant/protocol/call/PhoneBusinessData;", "phoneBusinessData", "g", "(Lcom/xjsd/ai/assistant/protocol/call/PhoneBusinessData;)V", "permissions", "f", "(Ljava/util/List;)V", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class PhoneCallFlowStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8671a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowStrategy$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public abstract void a(int i, String str, String str2, boolean z);

    public abstract void b(List list, String str, String str2);

    public final void c(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "tel");
        ILog.a("PhoneCallFlowStrategy", "dial: cardIndex->" + i + ", contactName->" + str + ", tel->" + str2);
        if (i > SimCardUtil.a(ContextHelper.a())) {
            PhoneCallCache.f8678a.b();
            new PhoneTtsPlayBuilder().d(R.string.tts_phone_sim_card_not_find).g(2).a().c();
            return;
        }
        a(i, str, str2, false);
    }

    public final void d(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "telNum");
        ILog.a("PhoneCallFlowStrategy", "makeCallByPhone: 发起拨号->" + i + "/" + str);
        Context a2 = ContextHelper.a();
        if (ContextCompat.checkSelfPermission(a2, "android.permission.READ_PHONE_STATE") == 0) {
            ILog.a("PhoneCallFlowStrategy", "makeCallByPhone: dial with dialer");
            Object systemService = a2.getSystemService("telecom");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telecom.TelecomManager");
            List<PhoneAccountHandle> callCapablePhoneAccounts = ((TelecomManager) systemService).getCallCapablePhoneAccounts();
            if (callCapablePhoneAccounts.size() == 1) {
                i = 0;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.CALL");
            intent.setData(Uri.parse("tel:" + str));
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            intent.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", callCapablePhoneAccounts.get(i));
            a2.startActivity(intent);
            return;
        }
        ILog.a("PhoneCallFlowStrategy", "makeCallByPhone: dial failed due to lack permission");
        e(i, str);
    }

    public abstract void e(int i, String str);

    public final void f(List list) {
        OperatorManager operatorManager;
        SappAbilityOperator sappAbilityOperator;
        ILog.a("PhoneCallFlowStrategy", "调用主应用申请权限");
        InterconnectAbility interconnectAbility = (InterconnectAbility) AbilityManager.b.b(InterconnectAbility.class);
        if (interconnectAbility != null && (operatorManager = interconnectAbility.getOperatorManager()) != null && (sappAbilityOperator = operatorManager.getSappAbilityOperator()) != null) {
            sappAbilityOperator.requestPermission(list, new PhoneCallFlowStrategy$requestPermissions$1());
        }
    }

    public final void g(PhoneBusinessData phoneBusinessData) {
        Communicator.a(BusinessDataType.PHONE, phoneBusinessData, new PhoneCallFlowStrategy$sendBusinessDataToGlass$1());
    }

    public final void h(List list, String str, String str2) {
        Intrinsics.checkNotNullParameter(list, "simCards");
        Intrinsics.checkNotNullParameter(str2, "phoneNumber");
        String e = GsonUtils.e(list);
        ILog.a("PhoneCallFlowStrategy", "sendSimCardsToGlass, sim card list->" + e);
        PhoneCallCache.f8678a.a(str, str2);
        PhoneBusinessData phoneBusinessData = new PhoneBusinessData();
        phoneBusinessData.setType(3);
        phoneBusinessData.setMultipleWheel(true);
        phoneBusinessData.setSimCardBean(list);
        phoneBusinessData.setContactName(str);
        phoneBusinessData.setPhoneNumber(str2);
        g(phoneBusinessData);
        ContextData contextData = new ContextData(VuiModelType.PHONE, "SIM_card");
        contextData.appendPayload("numbers", Integer.valueOf(list.size()));
        NluContextDataMaintainer.f8512a.a("simCardsCount", contextData);
        new PhoneTtsPlayBuilder().e(TtsCallTemplate.CALL02_P11).g(2).a().c();
    }

    public final CallConditionLack i() {
        boolean z;
        Context a2 = ContextHelper.a();
        if (PhoneCallUtil.h()) {
            return CallConditionLack.FLIGHT_MODE;
        }
        ArrayList arrayList = new ArrayList();
        if (ContextHelper.f("android.permission.CALL_PHONE")) {
            arrayList.add("android.permission.CALL_PHONE");
            z = true;
        } else {
            z = false;
        }
        if (ContextHelper.f("android.permission.READ_PHONE_STATE")) {
            arrayList.add("android.permission.READ_PHONE_STATE");
            z = true;
        }
        if (ContextHelper.f("android.permission.READ_CONTACTS")) {
            arrayList.add("android.permission.READ_CONTACTS");
        }
        if (!arrayList.isEmpty()) {
            f(arrayList);
            return z ? CallConditionLack.LACK_CALL_PERMISSION : CallConditionLack.LACK_READ_CONTACT_PERMISSION;
        } else if (SimCardUtil.a(a2) == 0) {
            return CallConditionLack.LACK_READ_PHONE_STATE_PERMISSION;
        } else {
            return null;
        }
    }

    public abstract CallConditionLack j();
}
