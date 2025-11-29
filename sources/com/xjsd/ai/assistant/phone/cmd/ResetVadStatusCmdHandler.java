package com.xjsd.ai.assistant.phone.cmd;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.common.handler.CmdHandler;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.vad.VadAbility;
import com.xjsd.ai.assistant.protocol.Cmd;
import com.xjsd.ai.assistant.protocol.CmdCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/xjsd/ai/assistant/phone/cmd/ResetVadStatusCmdHandler;", "Lcom/xjsd/ai/assistant/common/handler/CmdHandler;", "<init>", "()V", "", "getHandleCode", "()I", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "message", "Lcom/xjsd/ai/assistant/protocol/Cmd;", "cmd", "", "handle", "(Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;Lcom/xjsd/ai/assistant/protocol/Cmd;)V", "a", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ResetVadStatusCmdHandler implements CmdHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8546a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/phone/cmd/ResetVadStatusCmdHandler$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public int getHandleCode() {
        return CmdCode.CODE_RESET_VAD_STATUS;
    }

    public void handle(StarryNetMessage starryNetMessage, Cmd cmd) {
        ILog.a("ResetVadStatusCmdHandler", "收到重置vad状态命令");
        VadAbility vadAbility = (VadAbility) AbilityManager.b.b(VadAbility.class);
        if (vadAbility != null) {
            vadAbility.setOneShotFlag();
        }
    }
}
