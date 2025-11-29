package sdk.meizu.account.factor.authentication.sdk.module;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;
import sdk.meizu.account.factor.authentication.sdk.api.CaptchaApiService;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class NetworkModule_ProvideGeetestServiceFactory implements Factory<CaptchaApiService> {
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvideGeetestServiceFactory(Provider<Retrofit> provider) {
        this.retrofitProvider = provider;
    }

    public static NetworkModule_ProvideGeetestServiceFactory create(Provider<Retrofit> provider) {
        return new NetworkModule_ProvideGeetestServiceFactory(provider);
    }

    public static CaptchaApiService provideGeetestService(Retrofit retrofit) {
        return (CaptchaApiService) Preconditions.d(NetworkModule.INSTANCE.provideGeetestService(retrofit));
    }

    public CaptchaApiService get() {
        return provideGeetestService((Retrofit) this.retrofitProvider.get());
    }
}
