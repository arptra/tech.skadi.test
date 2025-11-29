package com.honey.account.z7;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IFileReceiver;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class h implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IFileReceiver f5355a;

    public /* synthetic */ h(IFileReceiver iFileReceiver) {
        this.f5355a = iFileReceiver;
    }

    public final Object invoke(Object obj) {
        return InterconnectManager.getInstance().getMainDispatcher().addReceiver((String) obj, this.f5355a);
    }
}
