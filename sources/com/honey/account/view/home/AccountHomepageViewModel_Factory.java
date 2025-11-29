package com.honey.account.view.home;

import com.honey.account.view.oauth.TokenRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AccountHomepageViewModel_Factory implements Factory<AccountHomepageViewModel> {
    private final Provider<AccountRepository> accountRepositoryProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    public AccountHomepageViewModel_Factory(Provider<AccountRepository> provider, Provider<TokenRepository> provider2) {
        this.accountRepositoryProvider = provider;
        this.tokenRepositoryProvider = provider2;
    }

    public static AccountHomepageViewModel_Factory create(Provider<AccountRepository> provider, Provider<TokenRepository> provider2) {
        return new AccountHomepageViewModel_Factory(provider, provider2);
    }

    public static AccountHomepageViewModel newInstance(AccountRepository accountRepository, TokenRepository tokenRepository) {
        return new AccountHomepageViewModel(accountRepository, tokenRepository);
    }

    public AccountHomepageViewModel get() {
        return newInstance((AccountRepository) this.accountRepositoryProvider.get(), (TokenRepository) this.tokenRepositoryProvider.get());
    }
}
