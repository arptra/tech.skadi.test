package com.honey.account;

import kotlin.Metadata;
import sdk.meizu.account.factor.authentication.sdk.module.BuildConfigProvider;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/honey/account/HoneyAccountManager$Companion$init$1", "Lsdk/meizu/account/factor/authentication/sdk/module/BuildConfigProvider;", "isDebug", "", "isOverseas", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HoneyAccountManager$Companion$init$1 implements BuildConfigProvider {
    final /* synthetic */ com.honey.account.module.BuildConfigProvider $buildConfigProvider;

    public HoneyAccountManager$Companion$init$1(com.honey.account.module.BuildConfigProvider buildConfigProvider) {
        this.$buildConfigProvider = buildConfigProvider;
    }

    public boolean isDebug() {
        com.honey.account.module.BuildConfigProvider buildConfigProvider = this.$buildConfigProvider;
        if (buildConfigProvider != null) {
            return buildConfigProvider.isDebug();
        }
        return false;
    }

    public boolean isOverseas() {
        return true;
    }
}
