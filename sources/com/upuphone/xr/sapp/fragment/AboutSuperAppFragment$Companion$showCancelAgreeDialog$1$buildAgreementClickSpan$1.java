package com.upuphone.xr.sapp.fragment;

import android.app.Activity;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.contract.ProtocolType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AboutSuperAppFragment$Companion$showCancelAgreeDialog$1$buildAgreementClickSpan$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Activity $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AboutSuperAppFragment$Companion$showCancelAgreeDialog$1$buildAgreementClickSpan$1(Activity activity) {
        super(1);
        this.$context = activity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        ContractEntry.w(ContractEntry.f6691a, this.$context, ProtocolType.CATEGORY_PP, (String) null, 4, (Object) null);
    }
}
