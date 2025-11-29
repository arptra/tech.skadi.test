package sdk.meizu.account.factor.authentication.sdk.fragment.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/base/BasicAuthFragment;", "Lsdk/meizu/account/factor/authentication/sdk/fragment/base/BaseFragment;", "()V", "basicType", "Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;", "getBasicType", "()Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;", "setBasicType", "(Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;)V", "getType", "onAttach", "", "context", "Landroid/content/Context;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class BasicAuthFragment extends BaseFragment {
    public BasicInfoType basicType;

    private final BasicInfoType getType() {
        if (Build.VERSION.SDK_INT >= 33) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                return (BasicInfoType) arguments.getParcelable(ConstantKt.FRAGMENT_FACTOR_PARAM_TYPE, BasicInfoType.class);
            }
            return null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            return (BasicInfoType) arguments2.getParcelable(ConstantKt.FRAGMENT_FACTOR_PARAM_TYPE);
        }
        return null;
    }

    @NotNull
    public BasicInfoType getBasicType() {
        BasicInfoType basicInfoType = this.basicType;
        if (basicInfoType != null) {
            return basicInfoType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("basicType");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        BasicInfoType type = getType();
        if (type == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
                return;
            }
            return;
        }
        setBasicType(type);
    }

    public void setBasicType(@NotNull BasicInfoType basicInfoType) {
        Intrinsics.checkNotNullParameter(basicInfoType, "<set-?>");
        this.basicType = basicInfoType;
    }
}
