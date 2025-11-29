package com.honey.account.view.home;

import com.honey.account.view.home.AccountHomepageViewModel_HiltModules;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AccountHomepageViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final AccountHomepageViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new AccountHomepageViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }

    public static AccountHomepageViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return AccountHomepageViewModel_HiltModules.KeyModule.provide();
    }

    public Boolean get() {
        return Boolean.valueOf(provide());
    }
}
