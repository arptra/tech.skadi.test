package com.honey.account.view.home;

import com.honey.account.api.AccountApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AccountRepository_Factory implements Factory<AccountRepository> {
    private final Provider<AccountApiService> accountApiServiceProvider;

    public AccountRepository_Factory(Provider<AccountApiService> provider) {
        this.accountApiServiceProvider = provider;
    }

    public static AccountRepository_Factory create(Provider<AccountApiService> provider) {
        return new AccountRepository_Factory(provider);
    }

    public static AccountRepository newInstance(AccountApiService accountApiService) {
        return new AccountRepository(accountApiService);
    }

    public AccountRepository get() {
        return newInstance((AccountApiService) this.accountApiServiceProvider.get());
    }
}
