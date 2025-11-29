package com.xjsd.ai.assistant.phone.cmd;

import android.text.TextUtils;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.common.AudioFocusManager;
import com.xjsd.ai.assistant.common.handler.CmdHandler;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.event.UserAbortEvent;
import com.xjsd.ai.assistant.protocol.Cmd;
import com.xjsd.ai.assistant.protocol.sys.RequestAudioFocusReq;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R0\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014`\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/xjsd/ai/assistant/phone/cmd/RequestAudioFocusCmdHandler;", "Lcom/xjsd/ai/assistant/common/handler/CmdHandler;", "<init>", "()V", "Lcom/xjsd/ai/assistant/phone/event/UserAbortEvent;", "event", "", "onReceiveUserAbortEvent", "(Lcom/xjsd/ai/assistant/phone/event/UserAbortEvent;)V", "", "getHandleCode", "()I", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "message", "Lcom/xjsd/ai/assistant/protocol/Cmd;", "cmd", "handle", "(Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;Lcom/xjsd/ai/assistant/protocol/Cmd;)V", "Ljava/util/HashMap;", "", "Lcom/xjsd/ai/assistant/phone/cmd/RequestAudioFocusCmdHandler$FocusBind;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "focusIdMap", "b", "Companion", "FocusBind", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class RequestAudioFocusCmdHandler implements CmdHandler {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f8544a = new HashMap();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/phone/cmd/RequestAudioFocusCmdHandler$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007R\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0017\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/xjsd/ai/assistant/phone/cmd/RequestAudioFocusCmdHandler$FocusBind;", "", "", "reqId", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getReqId", "b", "I", "c", "(I)V", "focusId", "d", "type", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class FocusBind {

        /* renamed from: a  reason: collision with root package name */
        public final String f8545a;
        public int b = -1;
        public String c = "";

        public FocusBind(String str) {
            Intrinsics.checkNotNullParameter(str, "reqId");
            this.f8545a = str;
        }

        public final int a() {
            return this.b;
        }

        public final String b() {
            return this.c;
        }

        public final void c(int i) {
            this.b = i;
        }

        public final void d(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FocusBind) && Intrinsics.areEqual((Object) this.f8545a, (Object) ((FocusBind) obj).f8545a);
        }

        public int hashCode() {
            return this.f8545a.hashCode();
        }

        public String toString() {
            String str = this.f8545a;
            return "FocusBind(reqId=" + str + ")";
        }
    }

    public RequestAudioFocusCmdHandler() {
        EventBus.c().o(this);
    }

    public int getHandleCode() {
        return 300;
    }

    public void handle(StarryNetMessage starryNetMessage, Cmd cmd) {
        int i;
        Intrinsics.checkNotNullParameter(starryNetMessage, "message");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        RequestAudioFocusReq requestAudioFocusReq = (RequestAudioFocusReq) cmd.parsePayload(RequestAudioFocusReq.class);
        ILog.a("RequestAudioFocusCmdHandler", "收到眼镜音频焦点操作请求->" + requestAudioFocusReq);
        String id = requestAudioFocusReq.getId();
        if (TextUtils.isEmpty(id)) {
            ILog.a("RequestAudioFocusCmdHandler", "音频焦点id为空，不处理");
            return;
        }
        AudioFocusManager a2 = AudioFocusManager.a();
        if (Intrinsics.areEqual((Object) "request", (Object) requestAudioFocusReq.getAction())) {
            String mode = requestAudioFocusReq.getMode();
            Intrinsics.checkNotNull(id);
            FocusBind focusBind = new FocusBind(id);
            if (Intrinsics.areEqual((Object) "long", (Object) mode) || Intrinsics.areEqual((Object) "short", (Object) mode)) {
                focusBind.d("short");
                i = a2.g(ContextHelper.a(), (AudioFocusManager.RequestAudioFocusCallback) null);
            } else {
                focusBind.d("mix");
                i = a2.f(ContextHelper.a(), (AudioFocusManager.RequestAudioFocusCallback) null);
            }
            focusBind.c(i);
            this.f8544a.put(id, focusBind);
            HashMap hashMap = this.f8544a;
            ILog.a("RequestAudioFocusCmdHandler", "申请音频焦点后，持有音频焦点数据->" + hashMap);
        } else if (Intrinsics.areEqual((Object) "release", (Object) requestAudioFocusReq.getAction())) {
            FocusBind focusBind2 = (FocusBind) this.f8544a.get(id);
            if (focusBind2 != null) {
                if (Intrinsics.areEqual((Object) "short", (Object) focusBind2.b())) {
                    a2.d(ContextHelper.a(), focusBind2.a());
                } else {
                    a2.c(ContextHelper.a(), focusBind2.a());
                }
                this.f8544a.remove(id);
                HashMap hashMap2 = this.f8544a;
                ILog.a("RequestAudioFocusCmdHandler", "释放音频焦点后，持有音频焦点数据->" + hashMap2);
            }
        } else {
            String action = requestAudioFocusReq.getAction();
            ILog.a("RequestAudioFocusCmdHandler", "不支持该音频焦点action->" + action);
        }
    }

    @Subscribe
    public void onReceiveUserAbortEvent(@NotNull UserAbortEvent userAbortEvent) {
        Intrinsics.checkNotNullParameter(userAbortEvent, "event");
        ILog.a("RequestAudioFocusCmdHandler", "收到语音助理退出事件，做清理工作");
    }
}
