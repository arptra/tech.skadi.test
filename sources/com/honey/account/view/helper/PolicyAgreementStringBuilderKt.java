package com.honey.account.view.helper;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002¨\u0006\u0002"}, d2 = {"isZh", "", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class PolicyAgreementStringBuilderKt {
    /* access modifiers changed from: private */
    public static final boolean isZh() {
        return Intrinsics.areEqual((Object) "zh", (Object) Locale.getDefault().getLanguage());
    }
}
