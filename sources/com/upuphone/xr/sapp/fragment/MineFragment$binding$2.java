package com.upuphone.xr.sapp.fragment;

import android.view.ViewGroup;
import com.upuphone.xr.sapp.databinding.FragmentMineBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/sapp/databinding/FragmentMineBinding;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class MineFragment$binding$2 extends Lambda implements Function0<FragmentMineBinding> {
    final /* synthetic */ MineFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MineFragment$binding$2(MineFragment mineFragment) {
        super(0);
        this.this$0 = mineFragment;
    }

    @NotNull
    public final FragmentMineBinding invoke() {
        FragmentMineBinding c = FragmentMineBinding.c(this.this$0.getLayoutInflater(), (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        return c;
    }
}
