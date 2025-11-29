package com.honey.account.module;

import com.honey.account.api.TokenApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class NetworkModule_ProvideTokenApiServiceFactory implements Factory<TokenApiService> {
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvideTokenApiServiceFactory(Provider<Retrofit> provider) {
        this.retrofitProvider = provider;
    }

    public static NetworkModule_ProvideTokenApiServiceFactory create(Provider<Retrofit> provider) {
        return new NetworkModule_ProvideTokenApiServiceFactory(provider);
    }

    public static TokenApiService provideTokenApiService(Retrofit retrofit) {
        return (TokenApiService) Preconditions.d(NetworkModule.INSTANCE.provideTokenApiService(retrofit));
    }

    public TokenApiService get() {
        return provideTokenApiService((Retrofit) this.retrofitProvider.get());
    }
}
