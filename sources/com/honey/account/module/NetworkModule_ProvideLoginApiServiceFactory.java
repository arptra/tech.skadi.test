package com.honey.account.module;

import com.honey.account.api.LoginApiService;
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
public final class NetworkModule_ProvideLoginApiServiceFactory implements Factory<LoginApiService> {
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvideLoginApiServiceFactory(Provider<Retrofit> provider) {
        this.retrofitProvider = provider;
    }

    public static NetworkModule_ProvideLoginApiServiceFactory create(Provider<Retrofit> provider) {
        return new NetworkModule_ProvideLoginApiServiceFactory(provider);
    }

    public static LoginApiService provideLoginApiService(Retrofit retrofit) {
        return (LoginApiService) Preconditions.d(NetworkModule.INSTANCE.provideLoginApiService(retrofit));
    }

    public LoginApiService get() {
        return provideLoginApiService((Retrofit) this.retrofitProvider.get());
    }
}
