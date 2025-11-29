package com.honey.account.view.login.validate;

import com.honey.account.view.login.repository.LoginRepository;
import com.honey.account.view.oauth.TokenRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ValidateAccountViewModel_Factory implements Factory<ValidateAccountViewModel> {
    private final Provider<LoginRepository> loginRepositoryProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    public ValidateAccountViewModel_Factory(Provider<LoginRepository> provider, Provider<TokenRepository> provider2) {
        this.loginRepositoryProvider = provider;
        this.tokenRepositoryProvider = provider2;
    }

    public static ValidateAccountViewModel_Factory create(Provider<LoginRepository> provider, Provider<TokenRepository> provider2) {
        return new ValidateAccountViewModel_Factory(provider, provider2);
    }

    public static ValidateAccountViewModel newInstance(LoginRepository loginRepository, TokenRepository tokenRepository) {
        return new ValidateAccountViewModel(loginRepository, tokenRepository);
    }

    public ValidateAccountViewModel get() {
        return newInstance((LoginRepository) this.loginRepositoryProvider.get(), (TokenRepository) this.tokenRepositoryProvider.get());
    }
}
