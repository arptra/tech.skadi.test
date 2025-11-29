package sdk.meizu.account.factor.authentication.sdk;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;
import sdk.meizu.account.factor.authentication.sdk.navigator.AuthenticationNavigator;

@QualifierMetadata
@DaggerGenerated
public final class FactorAuthenticationActivity_MembersInjector implements MembersInjector<FactorAuthenticationActivity> {
    private final Provider<AuthenticationNavigator> navigatorProvider;

    public FactorAuthenticationActivity_MembersInjector(Provider<AuthenticationNavigator> provider) {
        this.navigatorProvider = provider;
    }

    public static MembersInjector<FactorAuthenticationActivity> create(Provider<AuthenticationNavigator> provider) {
        return new FactorAuthenticationActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature
    public static void injectNavigator(FactorAuthenticationActivity factorAuthenticationActivity, AuthenticationNavigator authenticationNavigator) {
        factorAuthenticationActivity.navigator = authenticationNavigator;
    }

    public void injectMembers(FactorAuthenticationActivity factorAuthenticationActivity) {
        injectNavigator(factorAuthenticationActivity, (AuthenticationNavigator) this.navigatorProvider.get());
    }
}
