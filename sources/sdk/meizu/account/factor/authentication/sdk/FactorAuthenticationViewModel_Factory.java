package sdk.meizu.account.factor.authentication.sdk;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FactorAuthenticationViewModel_Factory implements Factory<FactorAuthenticationViewModel> {
    private final Provider<FactorAuthenticationRepository> repositoryProvider;

    public FactorAuthenticationViewModel_Factory(Provider<FactorAuthenticationRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static FactorAuthenticationViewModel_Factory create(Provider<FactorAuthenticationRepository> provider) {
        return new FactorAuthenticationViewModel_Factory(provider);
    }

    public static FactorAuthenticationViewModel newInstance(FactorAuthenticationRepository factorAuthenticationRepository) {
        return new FactorAuthenticationViewModel(factorAuthenticationRepository);
    }

    public FactorAuthenticationViewModel get() {
        return newInstance((FactorAuthenticationRepository) this.repositoryProvider.get());
    }
}
