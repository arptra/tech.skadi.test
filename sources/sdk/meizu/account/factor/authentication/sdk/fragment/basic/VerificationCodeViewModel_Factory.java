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
public final class VerificationCodeViewModel_Factory implements Factory<VerificationCodeViewModel> {
    private final Provider<FactorAuthenticationRepository> repositoryProvider;

    public VerificationCodeViewModel_Factory(Provider<FactorAuthenticationRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static VerificationCodeViewModel_Factory create(Provider<FactorAuthenticationRepository> provider) {
        return new VerificationCodeViewModel_Factory(provider);
    }

    public static VerificationCodeViewModel newInstance(FactorAuthenticationRepository factorAuthenticationRepository) {
        return new VerificationCodeViewModel(factorAuthenticationRepository);
    }

    public VerificationCodeViewModel get() {
        return newInstance((FactorAuthenticationRepository) this.repositoryProvider.get());
    }
}
