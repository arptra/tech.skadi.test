package com.honey.account.da;

import androidx.core.util.Consumer;
import com.xjsd.ai.assistant.flutter.util.AmrWbEncoder;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AmrWbEncoder f7220a;

    public /* synthetic */ b(AmrWbEncoder amrWbEncoder) {
        this.f7220a = amrWbEncoder;
    }

    public final void accept(Object obj) {
        AmrWbEncoder.g(this.f7220a, (byte[]) obj);
    }
}
