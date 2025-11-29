package com.honey.account.view.login.validate;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.internal.lifecycle.HiltViewModelMap;
import dagger.hilt.codegen.OriginatingElement;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

@OriginatingElement(topLevelClass = ValidateAccountViewModel.class)
public final class ValidateAccountViewModel_HiltModules {

    @Module
    @InstallIn({ViewModelComponent.class})
    public static abstract class BindsModule {
        private BindsModule() {
        }

        @HiltViewModelMap
        @Binds
        @LazyClassKey
        @IntoMap
        public abstract ViewModel binds(ValidateAccountViewModel validateAccountViewModel);
    }

    @Module
    @InstallIn({ActivityRetainedComponent.class})
    public static final class KeyModule {
        private KeyModule() {
        }

        @LazyClassKey
        @IntoMap
        @HiltViewModelMap.KeySet
        @Provides
        public static boolean provide() {
            return true;
        }
    }

    private ValidateAccountViewModel_HiltModules() {
    }
}
