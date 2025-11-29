package com.xjsd.ai.assistant.phone;

import com.xjsd.ai.assistant.common.ContinuousDialogDispatcher;
import com.xjsd.ai.assistant.common.UnSupportFeatureHandler;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.helper.VrStateSynchronizer;
import com.xjsd.ai.assistant.protocol.wakeup.WakeupControl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \b2\u00020\u00012\u00020\u0002:\u0001\u000fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u0019\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/xjsd/ai/assistant/phone/PhoneUnSupportFeatureHandler;", "Lcom/xjsd/ai/assistant/common/UnSupportFeatureHandler;", "Lcom/xjsd/ai/assistant/common/ContinuousDialogDispatcher$ActionExecutor;", "<init>", "()V", "", "state", "", "a", "(I)V", "e", "c", "d", "b", "f", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PhoneUnSupportFeatureHandler implements UnSupportFeatureHandler, ContinuousDialogDispatcher.ActionExecutor {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8522a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/phone/PhoneUnSupportFeatureHandler$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void a(int i) {
        if (i == 1) {
            f(3);
        } else if (i != 2) {
            ILog.a("PhoneUnSupportFeatureHandler", "播报状态->" + i + "，不处理");
        } else {
            f(4);
        }
    }

    public void b() {
        f(0);
        WakeupControlDelegate.g.i(new WakeupControl(0));
    }

    public void c() {
        b();
    }

    public void d() {
        f(2);
        WakeupControlDelegate.g.i(new WakeupControl(6));
    }

    public void e() {
        d();
    }

    public final void f(int i) {
        VrStateSynchronizer.b(i);
    }
}
