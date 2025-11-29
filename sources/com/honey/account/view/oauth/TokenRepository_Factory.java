package com.honey.account.view.oauth;

import com.honey.account.api.TokenApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TokenRepository_Factory implements Factory<TokenRepository> {
    private final Provider<TokenApiService> tokenApiServiceProvider;

    public TokenRepository_Factory(Provider<TokenApiService> provider) {
        this.tokenApiServiceProvider = provider;
    }

    public static TokenRepository_Factory create(Provider<TokenApiService> provider) {
        return new TokenRepository_Factory(provider);
    }

    public static TokenRepository newInstance(TokenApiService tokenApiService) {
        return new TokenRepository(tokenApiService);
    }

    public TokenRepository get() {
        return newInstance((TokenApiService) this.tokenApiServiceProvider.get());
    }
}
