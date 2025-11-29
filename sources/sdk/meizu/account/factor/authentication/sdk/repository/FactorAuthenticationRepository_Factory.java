package sdk.meizu.account.factor.authentication.sdk.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FactorAuthenticationRepository_Factory implements Factory<FactorAuthenticationRepository> {
    private final Provider<FactorAuthenticationService> apiServiceProvider;

    public FactorAuthenticationRepository_Factory(Provider<FactorAuthenticationService> provider) {
        this.apiServiceProvider = provider;
    }

    public static FactorAuthenticationRepository_Factory create(Provider<FactorAuthenticationService> provider) {
        return new FactorAuthenticationRepository_Factory(provider);
    }

    public static FactorAuthenticationRepository newInstance(FactorAuthenticationService factorAuthenticationService) {
        return new FactorAuthenticationRepository(factorAuthenticationService);
    }

    public FactorAuthenticationRepository get() {
        return newInstance((FactorAuthenticationService) this.apiServiceProvider.get());
    }
}
