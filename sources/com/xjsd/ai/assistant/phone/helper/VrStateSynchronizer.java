package com.xjsd.ai.assistant.phone.helper;

import com.xjsd.ai.assistant.common.Communicator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/xjsd/ai/assistant/phone/helper/VrStateSynchronizer;", "", "<init>", "()V", "", "scene", "", "a", "(Ljava/lang/String;)V", "", "state", "b", "(I)V", "c", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VrStateSynchronizer {

    /* renamed from: a  reason: collision with root package name */
    public static final VrStateSynchronizer f8568a = new VrStateSynchronizer();

    public static final void a(String str) {
        Communicator.b(106, 5, new VrStateSynchronizer$sendKeepListenCommand$1(str));
    }

    public static final void b(int i) {
        f8568a.c(i);
    }

    public final void c(int i) {
        Communicator.b(106, Integer.valueOf(i), new VrStateSynchronizer$syncStateToStarGlass$1(i));
    }
}
