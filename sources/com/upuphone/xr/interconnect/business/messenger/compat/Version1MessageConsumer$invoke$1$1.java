package com.upuphone.xr.interconnect.business.messenger.compat;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class Version1MessageConsumer$invoke$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryNetMessage $it;
    final /* synthetic */ String $logTag;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Version1MessageConsumer$invoke$1$1(String str, StarryNetMessage starryNetMessage) {
        super(0);
        this.$logTag = str;
        this.$it = starryNetMessage;
    }

    public final void invoke() {
        ULog.Delegate delegate = ULog.f6446a;
        String str = this.$logTag;
        String id = this.$it.getId();
        String name = Thread.currentThread().getName();
        delegate.c(str, "command msg id = " + id + ",thread name = " + name);
        InterconnectManager.getInstance().getMainDispatcher().dispatch(this.$it);
    }
}
