package com.honey.account.module;

import com.honey.account.api.AccountApiService;
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
public final class NetworkModule_ProvideAccountApiServiceFactory implements Factory<AccountApiService> {
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvideAccountApiServiceFactory(Provider<Retrofit> provider) {
        this.retrofitProvider = provider;
    }

    public static NetworkModule_ProvideAccountApiServiceFactory create(Provider<Retrofit> provider) {
        return new NetworkModule_ProvideAccountApiServiceFactory(provider);
    }

    public static AccountApiService provideAccountApiService(Retrofit retrofit) {
        return (AccountApiService) Preconditions.d(NetworkModule.INSTANCE.provideAccountApiService(retrofit));
    }

    public AccountApiService get() {
        return provideAccountApiService((Retrofit) this.retrofitProvider.get());
    }
}
