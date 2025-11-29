package com.honey.account;

import com.honey.account.data.AccountData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "accountData", "Lcom/honey/account/data/AccountData;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class HoneyAccountManager$Companion$isSelfModifyPassword$1 extends Lambda implements Function3<Boolean, String, AccountData, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HoneyAccountManager$Companion$isSelfModifyPassword$1(Function1<? super Boolean, Unit> function1) {
        super(3);
        this.$callback = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Boolean) obj).booleanValue(), (String) obj2, (AccountData) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, @NotNull String str, @Nullable AccountData accountData) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
        this.$callback.invoke(Boolean.valueOf(accountData != null ? accountData.isSelfSetPassword() : false));
    }
}
