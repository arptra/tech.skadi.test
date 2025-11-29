package sdk.meizu.account.factor.authentication.sdk.navigator;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.R;
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;
import sdk.meizu.account.factor.authentication.sdk.fragment.answer.AnswerFragment;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.PasswordFragment;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateAllFragment;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.VerificationCodeFragment;
import sdk.meizu.account.factor.authentication.sdk.fragment.login_account.LoginAccountFragment;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/navigator/AuthenticationNavigatorImpl;", "Lsdk/meizu/account/factor/authentication/sdk/navigator/AuthenticationNavigator;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "clearAll", "", "currentPage", "Lsdk/meizu/account/factor/authentication/sdk/navigator/Screens;", "navigateTo", "type", "Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;", "screens", "onBackPressed", "", "restorePage", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AuthenticationNavigatorImpl implements AuthenticationNavigator {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "AuthenticationNavigatorImpl";
    @NotNull
    private final FragmentActivity activity;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/navigator/AuthenticationNavigatorImpl$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                sdk.meizu.account.factor.authentication.sdk.navigator.Screens[] r0 = sdk.meizu.account.factor.authentication.sdk.navigator.Screens.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                sdk.meizu.account.factor.authentication.sdk.navigator.Screens r1 = sdk.meizu.account.factor.authentication.sdk.navigator.Screens.PASSWORD     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                sdk.meizu.account.factor.authentication.sdk.navigator.Screens r1 = sdk.meizu.account.factor.authentication.sdk.navigator.Screens.VERIFICATION_CODE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                sdk.meizu.account.factor.authentication.sdk.navigator.Screens r1 = sdk.meizu.account.factor.authentication.sdk.navigator.Screens.ALL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                sdk.meizu.account.factor.authentication.sdk.navigator.Screens r1 = sdk.meizu.account.factor.authentication.sdk.navigator.Screens.ANSWER     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                sdk.meizu.account.factor.authentication.sdk.navigator.Screens r1 = sdk.meizu.account.factor.authentication.sdk.navigator.Screens.ACCOUNT     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.navigator.AuthenticationNavigatorImpl.WhenMappings.<clinit>():void");
        }
    }

    @Inject
    public AuthenticationNavigatorImpl(@NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        this.activity = fragmentActivity;
    }

    public void clearAll() {
        AuthenticationNavigatorImplKt.getFragmentStack().clear();
        AuthenticationNavigatorImplKt.getFragmentStackTypeData().clear();
        Log.d(TAG, "clearAll.. fragmentStack  " + AuthenticationNavigatorImplKt.getFragmentStack() + ", fragmentStackTypeData: " + AuthenticationNavigatorImplKt.getFragmentStackTypeData());
    }

    @Nullable
    public Screens currentPage() {
        return (Screens) CollectionsKt.firstOrNull(AuthenticationNavigatorImplKt.getFragmentStack());
    }

    public void navigateTo(@NotNull Screens screens, @Nullable BasicInfoType basicInfoType) {
        Fragment fragment;
        Intrinsics.checkNotNullParameter(screens, "screens");
        Log.d(TAG, "navigateTo.. 111  -------------\n screens: " + screens + ", type: " + basicInfoType + "\n fragmentStack: " + AuthenticationNavigatorImplKt.getFragmentStack() + ", size: " + AuthenticationNavigatorImplKt.getFragmentStack().size());
        int indexOf = AuthenticationNavigatorImplKt.getFragmentStack().indexOf(screens);
        StringBuilder sb = new StringBuilder();
        sb.append("navigateTo.. 222, index: ");
        sb.append(indexOf);
        sb.append(", fragmentStackTypeData: ");
        sb.append(AuthenticationNavigatorImplKt.getFragmentStackTypeData());
        sb.append(", size: ");
        sb.append(AuthenticationNavigatorImplKt.getFragmentStackTypeData().size());
        Log.d(TAG, sb.toString());
        AuthenticationNavigatorImplKt.getFragmentStack().remove(screens);
        if (indexOf != -1) {
            AuthenticationNavigatorImplKt.getFragmentStackTypeData().remove(indexOf);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[screens.ordinal()];
        if (i == 1) {
            PasswordFragment.Companion companion = PasswordFragment.Companion;
            if (basicInfoType != null) {
                fragment = companion.newInstance(basicInfoType);
            } else {
                return;
            }
        } else if (i == 2) {
            VerificationCodeFragment.Companion companion2 = VerificationCodeFragment.Companion;
            if (basicInfoType != null) {
                fragment = companion2.newInstance(basicInfoType);
            } else {
                return;
            }
        } else if (i == 3) {
            ValidateAllFragment.Companion companion3 = ValidateAllFragment.Companion;
            if (basicInfoType != null) {
                fragment = companion3.newInstance(basicInfoType);
            } else {
                return;
            }
        } else if (i == 4) {
            fragment = AnswerFragment.Companion.newInstance();
        } else if (i == 5) {
            fragment = LoginAccountFragment.Companion.newInstance();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.activity.getSupportFragmentManager().s().t(R.id.main_container, fragment).k();
        if (!AuthenticationNavigatorImplKt.getFragmentStack().contains(screens)) {
            AuthenticationNavigatorImplKt.getFragmentStack().add(screens);
            AuthenticationNavigatorImplKt.getFragmentStackTypeData().add(basicInfoType);
        }
        Log.d(TAG, "navigateTo.. 333, fragment: " + fragment + ", fragmentStack: " + AuthenticationNavigatorImplKt.getFragmentStack() + ", fragmentStackTypeData: " + AuthenticationNavigatorImplKt.getFragmentStackTypeData());
    }

    public boolean onBackPressed() {
        Log.d(TAG, "onBackPressed.. fragmentStack  " + AuthenticationNavigatorImplKt.getFragmentStack() + ", size: " + AuthenticationNavigatorImplKt.getFragmentStack().size());
        if (AuthenticationNavigatorImplKt.getFragmentStack().size() == 1) {
            Log.d(TAG, "onBackPressed.. size is 1, return. ");
            return false;
        }
        CollectionsKt.removeLast(AuthenticationNavigatorImplKt.getFragmentStack());
        CollectionsKt.removeLast(AuthenticationNavigatorImplKt.getFragmentStackTypeData());
        Screens screens = AuthenticationNavigatorImplKt.getFragmentStack().get(CollectionsKt.getLastIndex(AuthenticationNavigatorImplKt.getFragmentStack()));
        BasicInfoType basicInfoType = AuthenticationNavigatorImplKt.getFragmentStackTypeData().get(CollectionsKt.getLastIndex(AuthenticationNavigatorImplKt.getFragmentStackTypeData()));
        Log.d(TAG, "onBackPressed.. last data, screens  " + screens + ", type: " + basicInfoType);
        navigateTo(screens, basicInfoType);
        return true;
    }

    public void restorePage() {
        Screens screens = AuthenticationNavigatorImplKt.getFragmentStack().get(CollectionsKt.getLastIndex(AuthenticationNavigatorImplKt.getFragmentStack()));
        BasicInfoType basicInfoType = AuthenticationNavigatorImplKt.getFragmentStackTypeData().get(CollectionsKt.getLastIndex(AuthenticationNavigatorImplKt.getFragmentStackTypeData()));
        Log.d(TAG, "restorePage.. screens  " + screens + ", type: " + basicInfoType);
        navigateTo(screens, basicInfoType);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (r0.equals(sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt.FACTOR_TYPE_PHONE) == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        r0 = sdk.meizu.account.factor.authentication.sdk.navigator.Screens.VERIFICATION_CODE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r0.equals(sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt.FACTOR_TYPE_EMAIL) == false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void navigateTo(@org.jetbrains.annotations.NotNull sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType r4) {
        /*
            r3 = this;
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = r4.getValidateType()
            int r1 = r0.hashCode()
            r2 = -827199977(0xffffffffceb1ee17, float:-1.49258534E9)
            if (r1 == r2) goto L_0x0032
            r2 = 921521722(0x36ed4e3a, float:7.072257E-6)
            if (r1 == r2) goto L_0x0026
            r2 = 1930793925(0x731593c5, float:1.1850729E31)
            if (r1 == r2) goto L_0x001d
            goto L_0x003a
        L_0x001d:
            java.lang.String r1 = "email_code_validate"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003d
            goto L_0x003a
        L_0x0026:
            java.lang.String r1 = "password_validate"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002f
            goto L_0x003a
        L_0x002f:
            sdk.meizu.account.factor.authentication.sdk.navigator.Screens r0 = sdk.meizu.account.factor.authentication.sdk.navigator.Screens.PASSWORD
            goto L_0x003f
        L_0x0032:
            java.lang.String r1 = "phone_code_validate"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003d
        L_0x003a:
            sdk.meizu.account.factor.authentication.sdk.navigator.Screens r0 = sdk.meizu.account.factor.authentication.sdk.navigator.Screens.ALL
            goto L_0x003f
        L_0x003d:
            sdk.meizu.account.factor.authentication.sdk.navigator.Screens r0 = sdk.meizu.account.factor.authentication.sdk.navigator.Screens.VERIFICATION_CODE
        L_0x003f:
            r3.navigateTo(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.navigator.AuthenticationNavigatorImpl.navigateTo(sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType):void");
    }
}
