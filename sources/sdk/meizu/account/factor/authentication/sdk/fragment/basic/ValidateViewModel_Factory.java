package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ValidateViewModel_Factory implements Factory<ValidateViewModel> {
    private final Provider<FactorAuthenticationRepository> repositoryProvider;

    public ValidateViewModel_Factory(Provider<FactorAuthenticationRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static ValidateViewModel_Factory create(Provider<FactorAuthenticationRepository> provider) {
        return new ValidateViewModel_Factory(provider);
    }

    public static ValidateViewModel newInstance(FactorAuthenticationRepository factorAuthenticationRepository) {
        return new ValidateViewModel(factorAuthenticationRepository);
    }

    public ValidateViewModel get() {
        return newInstance((FactorAuthenticationRepository) this.repositoryProvider.get());
    }
}
