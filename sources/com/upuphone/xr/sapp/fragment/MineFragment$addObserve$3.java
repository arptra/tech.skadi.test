package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.entity.AccountInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "accountInfo", "Lcom/upuphone/xr/sapp/entity/AccountInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class MineFragment$addObserve$3 extends Lambda implements Function1<AccountInfo, Unit> {
    final /* synthetic */ MineFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MineFragment$addObserve$3(MineFragment mineFragment) {
        super(1);
        this.this$0 = mineFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AccountInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable AccountInfo accountInfo) {
        this.this$0.b1(accountInfo);
    }
}
