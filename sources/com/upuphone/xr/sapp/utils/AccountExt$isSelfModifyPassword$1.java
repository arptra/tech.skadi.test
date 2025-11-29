package com.upuphone.xr.sapp.utils;

import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "aBoolean", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AccountExt$isSelfModifyPassword$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function3<Boolean, Integer, String, Unit> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountExt$isSelfModifyPassword$1(Function3<? super Boolean, ? super Integer, ? super String, Unit> function3) {
        super(1);
        this.$callback = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        Function3<Boolean, Integer, String, Unit> function3;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AccountExt", "isSelfModifyPassword() aBoolean:" + z);
        if (z && (function3 = this.$callback) != null) {
            function3.invoke(Boolean.valueOf(z), -1, "success");
        }
    }
}
