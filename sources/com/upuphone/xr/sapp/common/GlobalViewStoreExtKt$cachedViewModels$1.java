package com.upuphone.xr.sapp.common;

import androidx.lifecycle.ViewModelStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 176)
@SourceDebugExtension({"SMAP\nGlobalViewStoreExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt$cachedViewModels$1\n*L\n1#1,61:1\n*E\n"})
public final class GlobalViewStoreExtKt$cachedViewModels$1 extends Lambda implements Function0<ViewModelStore> {
    final /* synthetic */ String $tag;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalViewStoreExtKt$cachedViewModels$1(String str) {
        super(0);
        this.$tag = str;
    }

    @NotNull
    public final ViewModelStore invoke() {
        GlobalViewStoreOwner globalViewStoreOwner = GlobalViewStoreOwner.f6658a;
        String str = this.$tag;
        Intrinsics.checkNotNullExpressionValue(str, "$tag");
        return globalViewStoreOwner.g(str);
    }
}
