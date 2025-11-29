package com.xjsd.ai.assistant.net.ws;

import com.xjsd.ai.assistant.log.ILog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/xjsd/ai/assistant/net/ws/VirtualWebSocketManager;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/net/ws/VirtualWebSocket;", "socket", "", "a", "(Lcom/xjsd/ai/assistant/net/ws/VirtualWebSocket;)V", "c", "b", "", "Ljava/util/List;", "virtualWebSockets", "Lcom/xjsd/ai/assistant/net/ws/VirtualWebSocket;", "mAlonePermitHoldVWS", "lib_assistant_release"}, k = 1, mv = {1, 9, 0})
public final class VirtualWebSocketManager {

    /* renamed from: a  reason: collision with root package name */
    public static final VirtualWebSocketManager f8507a = new VirtualWebSocketManager();
    public static final List b = new ArrayList();
    public static VirtualWebSocket c;

    public final void a(VirtualWebSocket virtualWebSocket) {
        Intrinsics.checkNotNullParameter(virtualWebSocket, "socket");
        List list = b;
        if (!list.contains(virtualWebSocket)) {
            list.add(virtualWebSocket);
            ILog.a("VirtualWebSocketManager", "register: socket列表有->" + list);
        }
    }

    public final void b(VirtualWebSocket virtualWebSocket) {
        Intrinsics.checkNotNullParameter(virtualWebSocket, "socket");
        ILog.a("VirtualWebSocketManager", "tryReleaseAlonePermit: 释放单独使用许可");
        if (Intrinsics.areEqual((Object) virtualWebSocket, (Object) c)) {
            c = null;
            for (VirtualWebSocket virtualWebSocket2 : b) {
                if (!Intrinsics.areEqual((Object) virtualWebSocket2, (Object) virtualWebSocket)) {
                    virtualWebSocket2.onResume();
                }
            }
        }
    }

    public final synchronized void c(VirtualWebSocket virtualWebSocket) {
        try {
            Intrinsics.checkNotNullParameter(virtualWebSocket, "socket");
            if (!Intrinsics.areEqual((Object) c, (Object) virtualWebSocket)) {
                ILog.a("VirtualWebSocketManager", "tryRequireAlonePermit: 申请单独使用许可");
                c = virtualWebSocket;
                for (VirtualWebSocket virtualWebSocket2 : b) {
                    if (Intrinsics.areEqual((Object) virtualWebSocket2, (Object) virtualWebSocket)) {
                        virtualWebSocket2.onResume();
                    } else {
                        virtualWebSocket2.onParse();
                    }
                }
            }
        } finally {
        }
    }
}
