package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateViewModel_HiltModules;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ValidateViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ValidateViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new ValidateViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }

    public static ValidateViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return ValidateViewModel_HiltModules.KeyModule.provide();
    }

    public Boolean get() {
        return Boolean.valueOf(provide());
    }
}
