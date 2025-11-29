package androidx.window.layout;

import androidx.core.util.Consumer;
import kotlinx.coroutines.channels.Channel;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Channel f2046a;

    public /* synthetic */ a(Channel channel) {
        this.f2046a = channel;
    }

    public final void accept(Object obj) {
        WindowInfoTrackerImpl$windowLayoutInfo$1.m0invokeSuspend$lambda0(this.f2046a, (WindowLayoutInfo) obj);
    }
}
