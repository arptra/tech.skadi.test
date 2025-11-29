package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;
import sdk.meizu.account.factor.authentication.sdk.navigator.AuthenticationNavigator;

@QualifierMetadata
@DaggerGenerated
public final class ValidateAllFragment_MembersInjector implements MembersInjector<ValidateAllFragment> {
    private final Provider<AuthenticationNavigator> navigatorProvider;

    public ValidateAllFragment_MembersInjector(Provider<AuthenticationNavigator> provider) {
        this.navigatorProvider = provider;
    }

    public static MembersInjector<ValidateAllFragment> create(Provider<AuthenticationNavigator> provider) {
        return new ValidateAllFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature
    public static void injectNavigator(ValidateAllFragment validateAllFragment, AuthenticationNavigator authenticationNavigator) {
        validateAllFragment.navigator = authenticationNavigator;
    }

    public void injectMembers(ValidateAllFragment validateAllFragment) {
        injectNavigator(validateAllFragment, (AuthenticationNavigator) this.navigatorProvider.get());
    }
}
