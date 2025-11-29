package sdk.meizu.account.factor.authentication.sdk.di;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import sdk.meizu.account.factor.authentication.sdk.navigator.AuthenticationNavigator;
import sdk.meizu.account.factor.authentication.sdk.navigator.AuthenticationNavigatorImpl;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/di/NavigatorModule;", "", "()V", "bindNavigator", "Lsdk/meizu/account/factor/authentication/sdk/navigator/AuthenticationNavigator;", "navigatorImpl", "Lsdk/meizu/account/factor/authentication/sdk/navigator/AuthenticationNavigatorImpl;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@InstallIn({ActivityComponent.class})
@Module
public abstract class NavigatorModule {
    @NotNull
    @Binds
    public abstract AuthenticationNavigator bindNavigator(@NotNull AuthenticationNavigatorImpl authenticationNavigatorImpl);
}
