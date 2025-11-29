package com.xjsd.ai.assistant.phone;

import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.common.manager.VuiHandlerManager;
import com.xjsd.ai.assistant.common.util.CacheUtil;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.event.DomainChangeEvent;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.skill.navigation.NavHelper;
import com.xjsd.ai.assistant.skill.navigation.custom.CustomizedNavManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/xjsd/ai/assistant/phone/VuiHandleDelegate;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/protocol/VuiModel;", "vuiModel", "", "c", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)V", "b", "model", "", "a", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)Z", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuiHandleDelegate {

    /* renamed from: a  reason: collision with root package name */
    public static final VuiHandleDelegate f8537a = new VuiHandleDelegate();

    public final boolean a(VuiModel vuiModel) {
        if (Intrinsics.areEqual((Object) VuiModelType.GLOBAL, (Object) vuiModel.getHeader().getNamespace())) {
            return Intrinsics.areEqual((Object) "Back", (Object) vuiModel.getPayload().getString("directive"));
        }
        return false;
    }

    public final void b(VuiModel vuiModel) {
        Intrinsics.checkNotNullParameter(vuiModel, "vuiModel");
        if (VuiHandlerManager.d.e(vuiModel)) {
            ILog.a("VuiHandleDelegate", "垂域数据由手机端处理");
        } else {
            Communicator.b(102, vuiModel, new VuiHandleDelegate$dispatchVui$1());
        }
        String namespace = vuiModel.getHeader().getNamespace();
        if (Intrinsics.areEqual((Object) "llm", (Object) namespace)) {
            CacheUtil.a(namespace);
        } else {
            CacheUtil.a(vuiModel.getHeader().getName());
        }
    }

    public final void c(VuiModel vuiModel) {
        Intrinsics.checkNotNullParameter(vuiModel, "vuiModel");
        VuiHandlerManager vuiHandlerManager = VuiHandlerManager.d;
        String d = vuiHandlerManager.d();
        if (d == null) {
            d = "";
        }
        boolean c = vuiHandlerManager.c(vuiModel);
        if (Intrinsics.areEqual((Object) d, (Object) VuiModelType.NAVIGATION) && c) {
            ILog.a("VuiHandleDelegate", "clean nav poi data");
            NavHelper.b();
        }
        String namespace = vuiModel.getHeader().getNamespace();
        if (c && !Intrinsics.areEqual((Object) VuiModelType.VSP_ERROR, (Object) namespace) && (VoiceAssistantApi.isOversea || !vuiModel.isReject())) {
            Communicator.b(113, Boolean.valueOf(a(vuiModel)), new VuiHandleDelegate$handle$1());
        }
        CustomizedNavManager.c().h(d, namespace);
        EventBus.c().k(new DomainChangeEvent(d, namespace));
        b(vuiModel);
    }
}
