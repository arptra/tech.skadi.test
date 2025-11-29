package com.honey.account.xb;

import java.util.function.Consumer;
import org.apache.commons.lang3.ArchUtils;
import org.apache.commons.lang3.arch.Processor;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Processor f7684a;

    public /* synthetic */ a(Processor processor) {
        this.f7684a = processor;
    }

    public final void accept(Object obj) {
        ArchUtils.addProcessor((String) obj, this.f7684a);
    }
}
