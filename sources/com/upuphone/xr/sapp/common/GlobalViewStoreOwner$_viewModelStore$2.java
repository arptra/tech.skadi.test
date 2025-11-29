package com.upuphone.xr.sapp.common;

import androidx.lifecycle.ViewModelStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlobalViewStoreOwner$_viewModelStore$2 extends Lambda implements Function0<ViewModelStore> {
    public static final GlobalViewStoreOwner$_viewModelStore$2 INSTANCE = new GlobalViewStoreOwner$_viewModelStore$2();

    public GlobalViewStoreOwner$_viewModelStore$2() {
        super(0);
    }

    @NotNull
    public final ViewModelStore invoke() {
        return new ViewModelStore();
    }
}
