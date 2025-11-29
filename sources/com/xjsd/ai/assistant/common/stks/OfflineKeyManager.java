package com.xjsd.ai.assistant.common.stks;

import com.alibaba.fastjson.JSON;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.common.manager.VuiHandlerManager;
import com.xjsd.ai.assistant.core.Ability;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.NewFunctionCompact;
import com.xjsd.ai.assistant.phone.helper.HotWordMaintainer;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.stks.HotWordControl;
import com.xjsd.ai.assistant.protocol.vui.Header;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/xjsd/ai/assistant/common/stks/OfflineKeyManager;", "", "<init>", "()V", "", "asr", "Lcom/xjsd/ai/assistant/common/stks/OfflineKey;", "d", "(Ljava/lang/String;)Lcom/xjsd/ai/assistant/common/stks/OfflineKey;", "cmd", "", "isFromAssistant", "f", "(Ljava/lang/String;Z)Z", "offlineKey", "isOffline", "", "a", "(Lcom/xjsd/ai/assistant/common/stks/OfflineKey;ZZ)V", "key", "c", "(Lcom/xjsd/ai/assistant/common/stks/OfflineKey;)Z", "", "cmdCode", "msg", "logMsg", "e", "(ILjava/lang/Object;Ljava/lang/String;)V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class OfflineKeyManager {

    /* renamed from: a  reason: collision with root package name */
    public static final OfflineKeyManager f8436a = new OfflineKeyManager();

    public static /* synthetic */ void b(OfflineKeyManager offlineKeyManager, OfflineKey offlineKey, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        offlineKeyManager.a(offlineKey, z, z2);
    }

    public static final OfflineKey d(String str) {
        Intrinsics.checkNotNullParameter(str, "asr");
        return NewFunctionCompact.b() ? OfflineKeyManagerFor618.a().b(str) : OfflineKeyManagerForSpring.a().b(str);
    }

    public static final boolean f(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "cmd");
        OfflineKey d = d(str);
        if (d == null) {
            return false;
        }
        VuiHandlerManager.d.g((String) null);
        f8436a.a(d, false, z);
        return true;
    }

    public final void a(OfflineKey offlineKey, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(offlineKey, "offlineKey");
        List i = HotWordMaintainer.f8564a.i(offlineKey);
        if (i != null) {
            HotWordControl hotWordControl = new HotWordControl();
            hotWordControl.setControl(3);
            hotWordControl.setOffline(z);
            hotWordControl.setData(GsonUtils.e(i));
            String data = hotWordControl.getData();
            ILog.a("OfflineKeyManager2", "匹配到热词，走热词方式通知眼镜，" + data);
            f8436a.e(107, hotWordControl, "命中热词指令");
        } else if (!c(offlineKey)) {
            String e = GsonUtils.e(offlineKey);
            ILog.a("OfflineKeyManager2", "未匹配到热词，走INNER_STKS方式通知眼镜，" + e);
            VuiModel vuiModel = new VuiModel();
            Header header = new Header();
            header.setNamespace(VuiModelType.INNER_STKS);
            vuiModel.setHeader(header);
            vuiModel.setPayload(JSON.parseObject(GsonUtils.e(offlineKey)));
            Ability b = AbilityManager.b.b(CacheAbility.class);
            Intrinsics.checkNotNull(b);
            Boolean bool = (Boolean) ((CacheAbility) b).getCacheWithDefault("isGptCosplay", Boolean.FALSE);
            Intrinsics.checkNotNull(bool);
            if (bool.booleanValue()) {
                vuiModel.getHeader().setSpecialCmdInChatGptScene(true);
            }
            vuiModel.setSource(z2 ^ true ? 1 : 0);
            f8436a.e(102, vuiModel, VuiModelType.INNER_STKS);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0053, code lost:
        r0 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(com.xjsd.ai.assistant.common.stks.OfflineKey r7) {
        /*
            r6 = this;
            com.xjsd.ai.assistant.common.stks.OfflineKey$Data r6 = r7.getData()
            java.lang.String r6 = r6.getIntent()
            r0 = 0
            if (r6 == 0) goto L_0x0151
            int r1 = r6.hashCode()
            r2 = 3
            java.lang.String r3 = "导航"
            java.lang.String r4 = "导航播报"
            r5 = 1
            switch(r1) {
                case -1327173545: goto L_0x011e;
                case -1012282357: goto L_0x00c4;
                case -945000781: goto L_0x00a5;
                case -222981409: goto L_0x006d;
                case 1111916230: goto L_0x0056;
                case 1666319363: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x0151
        L_0x001c:
            java.lang.String r1 = "Intent_Sys_Close"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0026
            goto L_0x0151
        L_0x0026:
            com.xjsd.ai.assistant.common.stks.OfflineKey$Data r6 = r7.getData()
            java.lang.String r6 = r6.getSlot()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r4)
            if (r6 != 0) goto L_0x0042
            com.xjsd.ai.assistant.common.stks.OfflineKey$Data r6 = r7.getData()
            java.lang.String r6 = r6.getTarget()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r4)
            if (r6 == 0) goto L_0x0151
        L_0x0042:
            com.xjsd.ai.assistant.protocol.nav.NavBusinessData r6 = new com.xjsd.ai.assistant.protocol.nav.NavBusinessData
            r6.<init>(r2)
            java.lang.String r7 = "TurnOn"
            r6.setPayload(r7)
            org.greenrobot.eventbus.EventBus r7 = org.greenrobot.eventbus.EventBus.c()
            r7.k(r6)
        L_0x0053:
            r0 = r5
            goto L_0x0151
        L_0x0056:
            java.lang.String r7 = "Intent_Nav_ExitNav"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0060
            goto L_0x0151
        L_0x0060:
            org.greenrobot.eventbus.EventBus r6 = org.greenrobot.eventbus.EventBus.c()
            com.xjsd.ai.assistant.protocol.nav.NavBusinessData r7 = new com.xjsd.ai.assistant.protocol.nav.NavBusinessData
            r7.<init>(r5)
            r6.k(r7)
            goto L_0x0053
        L_0x006d:
            java.lang.String r1 = "Intent_Sys_Open"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0077
            goto L_0x0151
        L_0x0077:
            com.xjsd.ai.assistant.common.stks.OfflineKey$Data r6 = r7.getData()
            java.lang.String r6 = r6.getSlot()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r4)
            if (r6 != 0) goto L_0x0093
            com.xjsd.ai.assistant.common.stks.OfflineKey$Data r6 = r7.getData()
            java.lang.String r6 = r6.getTarget()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r4)
            if (r6 == 0) goto L_0x0151
        L_0x0093:
            com.xjsd.ai.assistant.protocol.nav.NavBusinessData r6 = new com.xjsd.ai.assistant.protocol.nav.NavBusinessData
            r6.<init>(r2)
            java.lang.String r7 = "TurnOff"
            r6.setPayload(r7)
            org.greenrobot.eventbus.EventBus r7 = org.greenrobot.eventbus.EventBus.c()
            r7.k(r6)
            goto L_0x0053
        L_0x00a5:
            java.lang.String r7 = "Intent_Single_Circulation"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00af
            goto L_0x0151
        L_0x00af:
            com.xjsd.ai.assistant.core.api.music.MediaModel r6 = new com.xjsd.ai.assistant.core.api.music.MediaModel
            r6.<init>()
            java.lang.String r7 = "PlayMode"
            r6.setCmdType(r7)
            java.lang.String r7 = "repeatOnce"
            r6.setPlayMode(r7)
            r7 = 2
            r1 = 0
            com.xjsd.ai.assistant.phone.media.MediaHelper.f(r6, r0, r7, r1)
            goto L_0x0053
        L_0x00c4:
            java.lang.String r1 = "Intent_App_Open"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x00ce
            goto L_0x0151
        L_0x00ce:
            com.xjsd.ai.assistant.common.stks.OfflineKey$Data r6 = r7.getData()
            java.lang.String r6 = r6.getTarget()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r3)
            if (r6 == 0) goto L_0x0151
            com.xjsd.ai.assistant.skill.navigation.enums.NavUnusableReason r6 = com.xjsd.ai.assistant.skill.navigation.NavUtil.a()
            if (r6 == 0) goto L_0x0151
            com.xjsd.ai.assistant.skill.navigation.enums.NavUnusableReason r7 = com.xjsd.ai.assistant.skill.navigation.enums.NavUnusableReason.NOT_AGREE_PROTOCOL
            if (r6 != r7) goto L_0x0108
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r7 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r7.<init>()
            com.xjsd.ai.assistant.template.TtsTemplate r6 = r6.getTemplate()
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r6 = r7.e(r6)
            com.xjsd.ai.assistant.common.stks.OfflineKeyManager$isPhoneHandleOfflineHotWord$3 r7 = com.xjsd.ai.assistant.common.stks.OfflineKeyManager$isPhoneHandleOfflineHotWord$3.INSTANCE
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$PhoneTts r6 = r6.h(r7)
            com.xjsd.ai.assistant.common.stks.OfflineKeyManager$isPhoneHandleOfflineHotWord$4 r7 = com.xjsd.ai.assistant.common.stks.OfflineKeyManager$isPhoneHandleOfflineHotWord$4.INSTANCE
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$PhoneTts r6 = r6.i(r7)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r6 = r6.a()
            r6.c()
            goto L_0x0053
        L_0x0108:
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r7 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r7.<init>()
            com.xjsd.ai.assistant.template.TtsTemplate r6 = r6.getTemplate()
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r6 = r7.e(r6)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r6 = r6.a()
            r6.c()
            goto L_0x0053
        L_0x011e:
            java.lang.String r1 = "Intent_App_Close"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0127
            goto L_0x0151
        L_0x0127:
            com.xjsd.ai.assistant.common.stks.OfflineKey$Data r6 = r7.getData()
            java.lang.String r6 = r6.getSlot()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r3)
            if (r6 != 0) goto L_0x0143
            com.xjsd.ai.assistant.common.stks.OfflineKey$Data r6 = r7.getData()
            java.lang.String r6 = r6.getTarget()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r3)
            if (r6 == 0) goto L_0x0151
        L_0x0143:
            org.greenrobot.eventbus.EventBus r6 = org.greenrobot.eventbus.EventBus.c()
            com.xjsd.ai.assistant.protocol.nav.NavBusinessData r7 = new com.xjsd.ai.assistant.protocol.nav.NavBusinessData
            r7.<init>(r5)
            r6.k(r7)
            goto L_0x0053
        L_0x0151:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "离线指令词在本地处理?->"
            r6.append(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "OfflineKeyManager2"
            com.xjsd.ai.assistant.log.ILog.a(r7, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.common.stks.OfflineKeyManager.c(com.xjsd.ai.assistant.common.stks.OfflineKey):boolean");
    }

    public final void e(int i, Object obj, String str) {
        Communicator.b(i, obj, new OfflineKeyManager$sendMsgToGlass$1(str));
    }
}
