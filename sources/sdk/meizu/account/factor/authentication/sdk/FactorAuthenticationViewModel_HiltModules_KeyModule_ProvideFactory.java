package sdk.meizu.account.factor.authentication.sdk;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationViewModel_HiltModules;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FactorAuthenticationViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FactorAuthenticationViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new FactorAuthenticationViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }

    public static FactorAuthenticationViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return FactorAuthenticationViewModel_HiltModules.KeyModule.provide();
    }

    public Boolean get() {
        return Boolean.valueOf(provide());
    }
}
