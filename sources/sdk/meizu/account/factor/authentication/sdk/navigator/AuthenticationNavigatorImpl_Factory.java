package sdk.meizu.account.factor.authentication.sdk.navigator;

import androidx.fragment.app.FragmentActivity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AuthenticationNavigatorImpl_Factory implements Factory<AuthenticationNavigatorImpl> {
    private final Provider<FragmentActivity> activityProvider;

    public AuthenticationNavigatorImpl_Factory(Provider<FragmentActivity> provider) {
        this.activityProvider = provider;
    }

    public static AuthenticationNavigatorImpl_Factory create(Provider<FragmentActivity> provider) {
        return new AuthenticationNavigatorImpl_Factory(provider);
    }

    public static AuthenticationNavigatorImpl newInstance(FragmentActivity fragmentActivity) {
        return new AuthenticationNavigatorImpl(fragmentActivity);
    }

    public AuthenticationNavigatorImpl get() {
        return newInstance((FragmentActivity) this.activityProvider.get());
    }
}
