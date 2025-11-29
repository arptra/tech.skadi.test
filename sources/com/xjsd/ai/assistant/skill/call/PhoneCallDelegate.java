package com.xjsd.ai.assistant.skill.call;

import android.content.Context;
import android.text.TextUtils;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.nlu.NluContextDataMaintainer;
import com.xjsd.ai.assistant.nlu.bean.ContextData;
import com.xjsd.ai.assistant.phone.R;
import com.xjsd.ai.assistant.phone.VoiceAssistantApi;
import com.xjsd.ai.assistant.phone.event.DomainChangeEvent;
import com.xjsd.ai.assistant.phone.event.UserAbortEvent;
import com.xjsd.ai.assistant.phone.helper.VersionUtil;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.phone.tts.UniqueTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.BusinessDataType;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.call.ContactSingleInfo;
import com.xjsd.ai.assistant.protocol.call.PhoneBusinessData;
import com.xjsd.ai.assistant.skill.call.bean.ContactBean;
import com.xjsd.ai.assistant.skill.call.bean.PhoneNumberBean;
import com.xjsd.ai.assistant.skill.call.util.CallConditionLack;
import com.xjsd.ai.assistant.skill.call.util.CallLogUtil;
import com.xjsd.ai.assistant.skill.call.util.PhoneCallCache;
import com.xjsd.ai.assistant.skill.call.util.SimCardUtil;
import com.xjsd.ai.assistant.template.TtsCallTemplate;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import com.xjsd.ai.assistant.template.TtsTemplate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u001e\u0010\u000fJ\u0019\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010'\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0012H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u001fH\u0002¢\u0006\u0004\b*\u0010+J'\u0010.\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u001fH\u0002¢\u0006\u0004\b.\u0010/J/\u00104\u001a\u00020\u00062\f\u00102\u001a\b\u0012\u0004\u0012\u000201002\b\u0010,\u001a\u0004\u0018\u00010\u001f2\u0006\u00103\u001a\u00020!H\u0002¢\u0006\u0004\b4\u00105J-\u00107\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u001f2\b\u0010)\u001a\u0004\u0018\u00010\u001f2\b\u00106\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b7\u0010/J)\u0010:\u001a\u00020\u00062\u0006\u00108\u001a\u00020!2\b\u00109\u001a\u0004\u0018\u00010\u001f2\u0006\u00106\u001a\u00020\u001fH\u0002¢\u0006\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020<8\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010=R\u0014\u0010A\u001a\u00020?8\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010CR\u0014\u0010F\u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010E¨\u0006H"}, d2 = {"Lcom/xjsd/ai/assistant/skill/call/PhoneCallDelegate;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/phone/event/UserAbortEvent;", "event", "", "onReceiveUserAbortEvent", "(Lcom/xjsd/ai/assistant/phone/event/UserAbortEvent;)V", "Lcom/xjsd/ai/assistant/phone/event/DomainChangeEvent;", "onReceiveDomainChangeEvent", "(Lcom/xjsd/ai/assistant/phone/event/DomainChangeEvent;)V", "Lcom/xjsd/ai/assistant/protocol/call/PhoneBusinessData;", "phoneBusinessData", "onReceivePhoneBusinessData", "(Lcom/xjsd/ai/assistant/protocol/call/PhoneBusinessData;)V", "Lcom/xjsd/ai/assistant/protocol/VuiModel;", "model", "", "h", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)Z", "c", "Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowStrategy;", "f", "()Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowStrategy;", "Lcom/xjsd/ai/assistant/skill/call/util/CallConditionLack;", "e", "()Lcom/xjsd/ai/assistant/skill/call/util/CallConditionLack;", "m", "()Z", "l", "", "tag", "", "g", "(Ljava/lang/String;)I", "Lcom/xjsd/ai/assistant/template/TtsTemplate;", "template", "isMultipleWheel", "k", "(Lcom/xjsd/ai/assistant/template/TtsTemplate;Z)V", "contactName", "j", "(Ljava/lang/String;)V", "cardType", "phoneNumber", "i", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "Lcom/xjsd/ai/assistant/skill/call/bean/ContactBean;", "list", "phoneType", "a", "(Ljava/util/List;Ljava/lang/String;I)V", "tel", "b", "cardIndex", "contact", "d", "(ILjava/lang/String;Ljava/lang/String;)V", "Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowFor618Strategy;", "Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowFor618Strategy;", "for618Strategy", "Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowForSpringStrategy;", "Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowForSpringStrategy;", "springStrategy", "Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowForSpringOldStrategy;", "Lcom/xjsd/ai/assistant/skill/call/PhoneCallFlowForSpringOldStrategy;", "springOldStrategy", "Ljava/lang/String;", "targetVersion", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PhoneCallDelegate {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final PhoneCallFlowFor618Strategy f8670a = new PhoneCallFlowFor618Strategy();
    public final PhoneCallFlowForSpringStrategy b = new PhoneCallFlowForSpringStrategy();
    public final PhoneCallFlowForSpringOldStrategy c = new PhoneCallFlowForSpringOldStrategy();
    public final String d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/xjsd/ai/assistant/skill/call/PhoneCallDelegate$Companion;", "", "()V", "SIM_CARD_1", "", "SIM_CARD_2", "TAG", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public PhoneCallDelegate() {
        this.d = VoiceAssistantApi.isOversea ? GlassInfoExtKt.c(GlassInfoExtKt.d("1.0.3.76")) : GlassInfoExtKt.c(GlassInfoExtKt.d("Flyme AR 1.0.6.3.20240424_Air_FR"));
        EventBus.c().o(this);
    }

    public final void a(List list, String str, int i) {
        int size = list.size();
        ILog.a("PhoneCallDelegate", "callContact: 联系人列表长度->" + size + ", cardType->" + str + ", phoneType->" + i);
        if (list.size() > 1) {
            ILog.a("PhoneCallDelegate", "callContact: 匹配多个联系人，进入多伦选择");
            ContextData contextData = new ContextData(VuiModelType.PHONE, "contacts");
            contextData.appendPayload("numbers", Integer.valueOf(list.size()));
            NluContextDataMaintainer.f8512a.a("contacts", contextData);
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ContactBean contactBean = (ContactBean) it.next();
                for (PhoneNumberBean num : contactBean.getPhoneNumber()) {
                    ContactSingleInfo contactSingleInfo = new ContactSingleInfo();
                    contactSingleInfo.setCompany(contactBean.getCompany());
                    contactSingleInfo.setContactId(contactBean.getContactId());
                    contactSingleInfo.setLookup(contactBean.getLookup());
                    contactSingleInfo.setName(contactBean.getName());
                    contactSingleInfo.setPhoneNumber(num.getNum());
                    arrayList.add(contactSingleInfo);
                }
            }
            PhoneBusinessData phoneBusinessData = new PhoneBusinessData();
            phoneBusinessData.setType(1);
            phoneBusinessData.setMultipleWheel(true);
            phoneBusinessData.setContactSingleInfo(arrayList);
            phoneBusinessData.setCardType(str);
            l(phoneBusinessData);
            k(TtsCallTemplate.CALL02_P06, true);
            return;
        }
        ContactBean contactBean2 = (ContactBean) list.get(0);
        if (contactBean2.getPhoneNumber().size() == 1) {
            ILog.a("PhoneCallDelegate", "callContact: 匹配到唯一联系人，直接拨打");
            b(str, contactBean2.getName(), contactBean2.getPhoneNumber().get(0).getNum());
            return;
        }
        if (i != 0) {
            ILog.a("PhoneCallDelegate", "callContact: 电话类型被指定了，匹配电话号码");
            ArrayList arrayList2 = new ArrayList();
            for (PhoneNumberBean next : contactBean2.getPhoneNumber()) {
                if (next.getType() == i) {
                    String num2 = next.getNum();
                    Intrinsics.checkNotNullExpressionValue(num2, "getNum(...)");
                    arrayList2.add(num2);
                }
            }
            if (arrayList2.size() == 1) {
                ILog.a("PhoneCallDelegate", "callContact: 指定电话类型只有一个号码，直接拨打");
                b(str, contactBean2.getName(), (String) arrayList2.get(0));
                return;
            }
        }
        Context a2 = ContextHelper.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getContext(...)");
        Set<String> a3 = CallLogUtil.a(a2);
        if (VoiceAssistantApi.isOversea || a3 != null) {
            HashSet hashSet = new HashSet();
            for (PhoneNumberBean num3 : contactBean2.getPhoneNumber()) {
                String num4 = num3.getNum();
                Intrinsics.checkNotNull(num4);
                String replace = new Regex("[^0-9]").replace((CharSequence) num4, "");
                hashSet.add(num4);
                hashSet.add(replace);
            }
            Intrinsics.checkNotNull(a3);
            for (String str2 : a3) {
                if (hashSet.contains(str2)) {
                    ILog.a("PhoneCallDelegate", "callContact: 找到最近的通话记录->" + str2 + "，直接拨打");
                    b(str, contactBean2.getName(), str2);
                    return;
                }
            }
            ILog.a("PhoneCallDelegate", "callContact: 单个联系人存在多个电话号码，进入多伦选择");
            ArrayList arrayList3 = new ArrayList();
            for (PhoneNumberBean next2 : contactBean2.getPhoneNumber()) {
                if (i == 0 || i == next2.getType()) {
                    ContactSingleInfo contactSingleInfo2 = new ContactSingleInfo();
                    contactSingleInfo2.setCompany(contactBean2.getCompany());
                    contactSingleInfo2.setContactId(contactBean2.getContactId());
                    contactSingleInfo2.setLookup(contactBean2.getLookup());
                    contactSingleInfo2.setName(contactBean2.getName());
                    contactSingleInfo2.setPhoneNumber(next2.getNum());
                    arrayList3.add(contactSingleInfo2);
                }
            }
            PhoneBusinessData phoneBusinessData2 = new PhoneBusinessData();
            phoneBusinessData2.setType(2);
            phoneBusinessData2.setMultipleWheel(true);
            phoneBusinessData2.setContactSingleInfo(arrayList3);
            phoneBusinessData2.setCardType(str);
            l(phoneBusinessData2);
            k(TtsCallTemplate.CALL02_P03, true);
            return;
        }
        ILog.a("PhoneCallDelegate", "callContact: 缺少读取最近通话记录的权限");
        k(TtsGlobalTemplate.GLOBAL02_R08, false);
    }

    public final void b(String str, String str2, String str3) {
        ILog.a("PhoneCallDelegate", "callDirectly: cardType->" + str + ", contactName->" + str2 + ", tel->" + str3);
        if (TextUtils.isEmpty(str3)) {
            new PhoneTtsPlayBuilder().d(R.string.tts_common_error_retry).g(2).a().c();
            return;
        }
        Intrinsics.checkNotNull(str3);
        if (Intrinsics.areEqual((Object) str, (Object) "first")) {
            d(0, str2, str3);
        } else if (Intrinsics.areEqual((Object) str, (Object) "second")) {
            d(1, str2, str3);
        } else {
            SimCardUtil.SimCardInfo e2 = SimCardUtil.e(ContextHelper.a());
            ILog.a("PhoneCallDelegate", "callDirectly: sim card info->" + e2);
            int c2 = e2.c();
            if (c2 == 0) {
                ILog.m("PhoneCallDelegate", "callDirectly: there is no sim card, call fail");
            } else if (c2 == 1) {
                ILog.a("PhoneCallDelegate", "callDirectly: there is only one sim card, so call directly");
                d(0, str2, str3);
            } else if (e2.a() == -1) {
                ILog.a("PhoneCallDelegate", "callDirectly: there are multiple cards, enter choose flow");
                PhoneCallFlowStrategy f = f();
                List b2 = e2.b();
                Intrinsics.checkNotNullExpressionValue(b2, "getSimCardBeanList(...)");
                f.b(b2, str2, str3);
            } else {
                d(e2.a(), str2, str3);
            }
        }
    }

    public final void c() {
        NluContextDataMaintainer nluContextDataMaintainer = NluContextDataMaintainer.f8512a;
        nluContextDataMaintainer.d("contacts");
        nluContextDataMaintainer.d("simCardsCount");
    }

    public final void d(int i, String str, String str2) {
        ILog.a("PhoneCallDelegate", "dialWithSimCard: cardIndex->" + i + ", contactName->" + str + ", tel->" + str2);
        f().c(i, str, str2);
    }

    public final CallConditionLack e() {
        return f().j();
    }

    public final PhoneCallFlowStrategy f() {
        return (DeviceUtils.c() || DeviceUtils.i()) ? this.f8670a : VersionUtil.f8566a.c(this.d) ? this.f8670a : this.c;
    }

    public final int g(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Intrinsics.checkNotNull(str);
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "家庭", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "住宅", false, 2, (Object) null)) {
            return 1;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "手机", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "移动", false, 2, (Object) null)) {
            return 2;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "工作", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "公司", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "单位", false, 2, (Object) null)) {
            return 3;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "传真", false, 2, (Object) null)) {
            return 4;
        }
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "其他", false, 2, (Object) null) ? 7 : 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h(com.xjsd.ai.assistant.protocol.VuiModel r11) {
        /*
            r10 = this;
            java.lang.String r0 = "model"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handle: 手机端处理电话流程->"
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "PhoneCallDelegate"
            com.xjsd.ai.assistant.log.ILog.a(r1, r0)
            boolean r0 = r10.m()
            r2 = 1
            if (r0 != 0) goto L_0x0029
            java.lang.String r10 = "拨打电话前置条件校验未通过"
            com.xjsd.ai.assistant.log.ILog.a(r1, r10)
            return r2
        L_0x0029:
            r10.c()
            com.xjsd.ai.assistant.protocol.vui.Header r0 = r11.getHeader()
            java.lang.String r0 = r0.getName()
            com.alibaba.fastjson.JSONObject r11 = r11.getPayload()
            java.lang.String r3 = "card_type"
            java.lang.String r3 = r11.getString(r3)
            java.lang.String r4 = "name"
            java.lang.String r4 = r11.getString(r4)
            java.lang.String r5 = "number"
            java.lang.String r5 = r11.getString(r5)
            java.lang.String r6 = "number_tag"
            java.lang.String r6 = r11.getString(r6)
            int r6 = r10.g(r6)
            android.content.Context r7 = com.xjsd.ai.assistant.core.ContextHelper.a()
            if (r0 == 0) goto L_0x0146
            int r8 = r0.hashCode()
            java.lang.String r9 = ""
            switch(r8) {
                case -499709741: goto L_0x0106;
                case -322675975: goto L_0x00f9;
                case 2129808: goto L_0x00ea;
                case 478039676: goto L_0x008e;
                case 1539021424: goto L_0x0065;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x0146
        L_0x0065:
            java.lang.String r11 = "DialContact"
            boolean r11 = r0.equals(r11)
            if (r11 != 0) goto L_0x006f
            goto L_0x0146
        L_0x006f:
            java.util.List r11 = com.xjsd.ai.assistant.skill.call.util.ContactUtil.d(r7, r4)
            boolean r0 = r11.isEmpty()
            if (r0 == 0) goto L_0x0086
            java.lang.String r11 = "DialContact: 联系人列表为空"
            com.xjsd.ai.assistant.log.ILog.a(r1, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r10.j(r4)
            goto L_0x015a
        L_0x0086:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            r10.a(r11, r3, r6)
            goto L_0x015a
        L_0x008e:
            java.lang.String r5 = "DialRelative"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0098
            goto L_0x0146
        L_0x0098:
            java.lang.String r0 = "relative"
            java.lang.Object r11 = r11.get(r0)
            if (r11 != 0) goto L_0x00a1
            goto L_0x00a2
        L_0x00a1:
            r9 = r11
        L_0x00a2:
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            java.util.List r11 = com.xjsd.ai.assistant.json.GsonUtils.c(r9, r11)
            java.util.List r0 = com.xjsd.ai.assistant.skill.call.util.ContactUtil.d(r7, r4)
            boolean r5 = r0.isEmpty()
            if (r5 == 0) goto L_0x00d4
            java.lang.String r5 = "DialRelative: 根据名字没有搜到对应的亲戚"
            com.xjsd.ai.assistant.log.ILog.j(r1, r5)
            java.util.Iterator r11 = r11.iterator()
        L_0x00bb:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x00d4
            java.lang.Object r1 = r11.next()
            java.lang.String r1 = (java.lang.String) r1
            java.util.List r1 = com.xjsd.ai.assistant.skill.call.util.ContactUtil.d(r7, r1)
            java.lang.String r5 = "searchContact(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            r0.addAll(r1)
            goto L_0x00bb
        L_0x00d4:
            boolean r11 = r0.isEmpty()
            if (r11 == 0) goto L_0x00e2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r10.j(r4)
            goto L_0x015a
        L_0x00e2:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r10.a(r0, r3, r6)
            goto L_0x015a
        L_0x00ea:
            java.lang.String r11 = "Dial"
            boolean r11 = r0.equals(r11)
            if (r11 != 0) goto L_0x00f3
            goto L_0x0146
        L_0x00f3:
            com.xjsd.ai.assistant.template.TtsCallTemplate r11 = com.xjsd.ai.assistant.template.TtsCallTemplate.CALL07_P01
            r10.k(r11, r2)
            goto L_0x015a
        L_0x00f9:
            java.lang.String r11 = "DialNumber"
            boolean r11 = r0.equals(r11)
            if (r11 != 0) goto L_0x0102
            goto L_0x0146
        L_0x0102:
            r10.b(r3, r9, r5)
            goto L_0x015a
        L_0x0106:
            java.lang.String r11 = "DialYellowPage"
            boolean r11 = r0.equals(r11)
            if (r11 != 0) goto L_0x010f
            goto L_0x0146
        L_0x010f:
            java.util.List r11 = com.xjsd.ai.assistant.skill.call.util.ContactUtil.d(r7, r4)
            boolean r0 = r11.isEmpty()
            if (r0 == 0) goto L_0x013f
            java.lang.String r11 = "DialYellowPage: 联系人列表为空"
            com.xjsd.ai.assistant.log.ILog.a(r1, r11)
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 == 0) goto L_0x013b
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r10 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r10.<init>()
            com.xjsd.ai.assistant.template.TtsCallTemplate r11 = com.xjsd.ai.assistant.template.TtsCallTemplate.CALL02_P04
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r10 = r10.e(r11)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$PhoneTts r10 = r10.g(r2)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r10 = r10.a()
            r10.c()
            goto L_0x015a
        L_0x013b:
            r10.b(r3, r9, r5)
            goto L_0x015a
        L_0x013f:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            r10.a(r11, r3, r6)
            goto L_0x015a
        L_0x0146:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "handle: not support this cmd->"
            r10.append(r11)
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            com.xjsd.ai.assistant.log.ILog.a(r1, r10)
        L_0x015a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.call.PhoneCallDelegate.h(com.xjsd.ai.assistant.protocol.VuiModel):boolean");
    }

    public final void i(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            ILog.a("PhoneCallDelegate", "handleReplyCall: 电话号码为空，不能回拨");
            new UniqueTtsPlayBuilder().e(R.string.tts_common_error_retry).a().d();
            return;
        }
        CallConditionLack e2 = e();
        if (e2 != null) {
            ILog.a("PhoneCallDelegate", "handleReplyCall: 拨号前置条件校验失败，原因->" + e2);
            PhoneBusinessData phoneBusinessData = new PhoneBusinessData();
            phoneBusinessData.setType(5);
            phoneBusinessData.setFailType(e2.name());
            l(phoneBusinessData);
            new UniqueTtsPlayBuilder().f(e2.getTemplate()).a().d();
            return;
        }
        int i = !Intrinsics.areEqual((Object) "first", (Object) str);
        if (i > SimCardUtil.a(ContextHelper.a())) {
            new UniqueTtsPlayBuilder().e(R.string.tts_phone_sim_card_not_find).a().d();
            return;
        }
        ILog.a("PhoneCallDelegate", "handleReplyCall: simIndex->" + i + ", contactName->" + str2 + ",phoneNumber->" + str3);
        f().a(i, str2, str3, true);
    }

    public final void j(String str) {
        ContextData contextData = new ContextData(VuiModelType.PHONE, "contacts");
        contextData.appendPayload("numbers", 0);
        NluContextDataMaintainer.f8512a.a("contacts", contextData);
        new PhoneTtsPlayBuilder().e(TtsCallTemplate.CALL02_P05).o(str).k("contactName", str).g(2).a().c();
    }

    public final void k(TtsTemplate ttsTemplate, boolean z) {
        new PhoneTtsPlayBuilder().e(ttsTemplate).g(z ? 2 : 0).a().c();
    }

    public final void l(PhoneBusinessData phoneBusinessData) {
        Communicator.a(BusinessDataType.PHONE, phoneBusinessData, new PhoneCallDelegate$sendBusinessDataToGlass$1());
    }

    public final boolean m() {
        CallConditionLack e2 = e();
        if (e2 == null) {
            return true;
        }
        new PhoneTtsPlayBuilder().e(e2.getTemplate()).a().c();
        return false;
    }

    @Subscribe
    public final void onReceiveDomainChangeEvent(@NotNull DomainChangeEvent domainChangeEvent) {
        Intrinsics.checkNotNullParameter(domainChangeEvent, "event");
        if (Intrinsics.areEqual((Object) domainChangeEvent.b(), (Object) VuiModelType.PHONE) && !Intrinsics.areEqual((Object) domainChangeEvent.a(), (Object) VuiModelType.PHONE)) {
            ILog.a("PhoneCallDelegate", "onReceiveDomainChangeEvent: 跨域了，重置标记");
            c();
        }
    }

    @Subscribe
    public final void onReceivePhoneBusinessData(@NotNull PhoneBusinessData phoneBusinessData) {
        Intrinsics.checkNotNullParameter(phoneBusinessData, "phoneBusinessData");
        int type = phoneBusinessData.getType();
        String cardType = phoneBusinessData.getCardType();
        String contactName = phoneBusinessData.getContactName();
        String phoneNumber = phoneBusinessData.getPhoneNumber();
        if (type == 4) {
            Intrinsics.checkNotNull(cardType);
            Intrinsics.checkNotNull(contactName);
            Intrinsics.checkNotNull(phoneNumber);
            i(cardType, contactName, phoneNumber);
        } else if (!m()) {
            ILog.a("PhoneCallDelegate", "当前不可拨打电话");
        } else if (type == 1 || type == 2 || type == 3) {
            if (TextUtils.isEmpty(contactName)) {
                contactName = PhoneCallCache.f8678a.c();
            }
            if (TextUtils.isEmpty(phoneNumber)) {
                phoneNumber = PhoneCallCache.f8678a.d();
            }
            b(cardType, contactName, phoneNumber);
        } else {
            ILog.m("PhoneCallDelegate", "不支持处理该类型->" + type);
        }
    }

    @Subscribe
    public final void onReceiveUserAbortEvent(@NotNull UserAbortEvent userAbortEvent) {
        Intrinsics.checkNotNullParameter(userAbortEvent, "event");
        c();
    }
}
