package com.honey.account.view.login.repository;

import com.honey.account.api.LoginApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LoginRepository_Factory implements Factory<LoginRepository> {
    private final Provider<LoginApiService> loginApiServiceProvider;

    public LoginRepository_Factory(Provider<LoginApiService> provider) {
        this.loginApiServiceProvider = provider;
    }

    public static LoginRepository_Factory create(Provider<LoginApiService> provider) {
        return new LoginRepository_Factory(provider);
    }

    public static LoginRepository newInstance(LoginApiService loginApiService) {
        return new LoginRepository(loginApiService);
    }

    public LoginRepository get() {
        return newInstance((LoginApiService) this.loginApiServiceProvider.get());
    }
}
