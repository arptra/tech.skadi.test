package sdk.meizu.account.factor.authentication.sdk.module;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;
import sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class NetworkModule_ProvideApiServiceFactory implements Factory<FactorAuthenticationService> {
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvideApiServiceFactory(Provider<Retrofit> provider) {
        this.retrofitProvider = provider;
    }

    public static NetworkModule_ProvideApiServiceFactory create(Provider<Retrofit> provider) {
        return new NetworkModule_ProvideApiServiceFactory(provider);
    }

    public static FactorAuthenticationService provideApiService(Retrofit retrofit) {
        return (FactorAuthenticationService) Preconditions.d(NetworkModule.INSTANCE.provideApiService(retrofit));
    }

    public FactorAuthenticationService get() {
        return provideApiService((Retrofit) this.retrofitProvider.get());
    }
}
