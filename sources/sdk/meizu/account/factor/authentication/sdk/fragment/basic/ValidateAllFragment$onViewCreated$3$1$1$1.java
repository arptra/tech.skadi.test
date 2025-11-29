package sdk.meizu.account.factor.authentication.sdk.fragment.basic;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.adapter.ValidateListAdapter;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"sdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateAllFragment$onViewCreated$3$1$1$1", "Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/adapter/ValidateListAdapter$OnSelectedListener;", "onSelected", "", "position", "", "type", "Lsdk/meizu/account/factor/authentication/sdk/data/BasicInfoType;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ValidateAllFragment$onViewCreated$3$1$1$1 implements ValidateListAdapter.OnSelectedListener {
    final /* synthetic */ ValidateAllFragment this$0;

    public ValidateAllFragment$onViewCreated$3$1$1$1(ValidateAllFragment validateAllFragment) {
        this.this$0 = validateAllFragment;
    }

    public void onSelected(int i, @NotNull BasicInfoType basicInfoType) {
        Intrinsics.checkNotNullParameter(basicInfoType, "type");
        this.this$0.getNavigator().navigateTo(basicInfoType);
    }
}
