package com.xjsd.ai.assistant.phone.helper;

import com.upuphone.starrynet.payload.PayloadConstant;
import com.xjsd.ai.assistant.connect.SendMsgCallback;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.WakeupControlDelegate;
import com.xjsd.ai.assistant.protocol.wakeup.WakeupControl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/xjsd/ai/assistant/phone/helper/VrStateSynchronizer$sendKeepListenCommand$1", "Lcom/xjsd/ai/assistant/connect/SendMsgCallback;", "onFail", "", "error", "", "msg", "", "onSuccess", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VrStateSynchronizer$sendKeepListenCommand$1 implements SendMsgCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f8569a;

    public VrStateSynchronizer$sendKeepListenCommand$1(String str) {
        this.f8569a = str;
    }

    public void onFail(int i, String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        ILog.c("VrStateSynchronizer", "发送同步VR状态->%d 命令失败->%s", 1, str);
    }

    public void onSuccess() {
        ILog.c("VrStateSynchronizer", "发送同步VR状态->%d 命令成功", 1);
        WakeupControl wakeupControl = new WakeupControl(11);
        wakeupControl.setScene(this.f8569a);
        WakeupControlDelegate.g.i(wakeupControl);
    }
}
