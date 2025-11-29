package com.xjmz.myvu;

import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "upgrade", "", "policyMd5", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class MYVUActivity$upgradePolicyCheck$1 extends Lambda implements Function2<Boolean, String, Unit> {
    public static final MYVUActivity$upgradePolicyCheck$1 INSTANCE = new MYVUActivity$upgradePolicyCheck$1();

    public MYVUActivity$upgradePolicyCheck$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Boolean) obj).booleanValue(), (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "policyMd5");
        if (z) {
            DataStoreUtils.e.a().o("PRIVACY_LATEST_MD5_KEY", str);
        } else {
            AppUpdateHelper.f7841a.E();
        }
    }
}
