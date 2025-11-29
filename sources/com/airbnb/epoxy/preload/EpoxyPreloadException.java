package com.airbnb.epoxy.preload;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/airbnb/epoxy/preload/EpoxyPreloadException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "errorMessage", "", "(Ljava/lang/String;)V", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EpoxyPreloadException extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EpoxyPreloadException(@NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "errorMessage");
    }
}
