package com.upuphone.xr.interconnect;

import com.upuphone.xr.interconnect.inner.OperatorManagerCreator;
import java.util.Set;
import java.util.function.BiConsumer;

public final /* synthetic */ class a implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OperatorManagerCreator f6567a;
    public final /* synthetic */ InnerSuperAppServiceManager b;

    public /* synthetic */ a(OperatorManagerCreator operatorManagerCreator, InnerSuperAppServiceManager innerSuperAppServiceManager) {
        this.f6567a = operatorManagerCreator;
        this.b = innerSuperAppServiceManager;
    }

    public final void accept(Object obj, Object obj2) {
        InnerSuperAppServiceManager$inject$1.invoke$lambda$1(this.f6567a, this.b, (String) obj, (Set) obj2);
    }
}
