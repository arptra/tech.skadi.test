package sdk.meizu.account.factor.authentication.sdk.navigator;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"fragmentStack", "", "Lsdk/meizu/account/factor/authentication/sdk/navigator/Screens;", "getFragmentStack", "()Ljava/util/List;", "fragmentStackTypeData", "Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;", "getFragmentStackTypeData", "sdk_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class AuthenticationNavigatorImplKt {
    @NotNull
    private static final List<Screens> fragmentStack = new ArrayList();
    @NotNull
    private static final List<BasicInfoType> fragmentStackTypeData = new ArrayList();

    @NotNull
    public static final List<Screens> getFragmentStack() {
        return fragmentStack;
    }

    @NotNull
    public static final List<BasicInfoType> getFragmentStackTypeData() {
        return fragmentStackTypeData;
    }
}
