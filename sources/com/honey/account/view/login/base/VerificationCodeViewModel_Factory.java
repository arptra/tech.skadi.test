package com.honey.account.view.login.base;

import com.honey.account.view.login.repository.LoginRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VerificationCodeViewModel_Factory implements Factory<VerificationCodeViewModel> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public VerificationCodeViewModel_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    public static VerificationCodeViewModel_Factory create(Provider<LoginRepository> provider) {
        return new VerificationCodeViewModel_Factory(provider);
    }

    public static VerificationCodeViewModel newInstance(LoginRepository loginRepository) {
        return new VerificationCodeViewModel(loginRepository);
    }

    public VerificationCodeViewModel get() {
        return newInstance((LoginRepository) this.loginRepositoryProvider.get());
    }
}
