package com.honey.account.i6;

import com.upuphone.runasone.relay.lib.manager.AppConfigManager;
import com.upuphone.runasone.relay.lib.manager.MetaBean;
import java.util.function.BiConsumer;

public final /* synthetic */ class a implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppConfigManager f4852a;

    public /* synthetic */ a(AppConfigManager appConfigManager) {
        this.f4852a = appConfigManager;
    }

    public final void accept(Object obj, Object obj2) {
        this.f4852a.lambda$addAppUnitCode$0((String) obj, (MetaBean) obj2);
    }
}
