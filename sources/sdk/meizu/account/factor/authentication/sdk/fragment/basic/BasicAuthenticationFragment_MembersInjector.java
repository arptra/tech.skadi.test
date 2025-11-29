package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;
import sdk.meizu.account.factor.authentication.sdk.navigator.AuthenticationNavigator;

@QualifierMetadata
@DaggerGenerated
public final class BasicAuthenticationFragment_MembersInjector implements MembersInjector<BasicAuthenticationFragment> {
    private final Provider<AuthenticationNavigator> navigatorProvider;

    public BasicAuthenticationFragment_MembersInjector(Provider<AuthenticationNavigator> provider) {
        this.navigatorProvider = provider;
    }

    public static MembersInjector<BasicAuthenticationFragment> create(Provider<AuthenticationNavigator> provider) {
        return new BasicAuthenticationFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature
    public static void injectNavigator(BasicAuthenticationFragment basicAuthenticationFragment, AuthenticationNavigator authenticationNavigator) {
        basicAuthenticationFragment.navigator = authenticationNavigator;
    }

    public void injectMembers(BasicAuthenticationFragment basicAuthenticationFragment) {
        injectNavigator(basicAuthenticationFragment, (AuthenticationNavigator) this.navigatorProvider.get());
    }
}
