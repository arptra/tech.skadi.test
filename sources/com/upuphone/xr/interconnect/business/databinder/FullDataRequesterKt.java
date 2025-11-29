package com.upuphone.xr.interconnect.business.databinder;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"#\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00038BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"FAILURE_MINIMUM_DELAY_MS", "", "requestMessage", "", "kotlin.jvm.PlatformType", "getRequestMessage", "()Ljava/lang/String;", "requestMessage$delegate", "Lkotlin/Lazy;", "SharedImpl_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class FullDataRequesterKt {
    private static final long FAILURE_MINIMUM_DELAY_MS = 600;
    @NotNull
    private static final Lazy requestMessage$delegate = LazyKt.lazy(FullDataRequesterKt$requestMessage$2.INSTANCE);

    /* access modifiers changed from: private */
    public static final String getRequestMessage() {
        return (String) requestMessage$delegate.getValue();
    }
}
