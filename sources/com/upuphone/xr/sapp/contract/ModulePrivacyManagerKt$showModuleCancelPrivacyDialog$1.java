package com.upuphone.xr.sapp.contract;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ModulePrivacyManagerKt$showModuleCancelPrivacyDialog$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Function0<Unit> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModulePrivacyManagerKt$showModuleCancelPrivacyDialog$1(Function0<Unit> function0) {
        super(1);
        this.$callback = function0;
    }

    public final void invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        Function0<Unit> function0 = this.$callback;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
