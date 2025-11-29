package com.upuphone.xr.interconnect.business.connect;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/ListenerLinkingCollector;", "L", "", "()V", "listeners", "", "getListeners", "()Ljava/util/Set;", "setListeners", "(Ljava/util/Set;)V", "get", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ListenerLinkingCollector<L> {
    public Set<? extends L> listeners;

    @NotNull
    public final Set<L> get() {
        return getListeners();
    }

    @NotNull
    public final Set<L> getListeners() {
        Set<? extends L> set = this.listeners;
        if (set != null) {
            return set;
        }
        Intrinsics.throwUninitializedPropertyAccessException("listeners");
        return null;
    }

    public final void setListeners(@NotNull Set<? extends L> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.listeners = set;
    }
}
