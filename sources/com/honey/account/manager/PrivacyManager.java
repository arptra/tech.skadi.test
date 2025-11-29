package com.honey.account.manager;

import android.content.Context;
import android.util.Log;
import com.honey.account.BuildConfig;
import com.honey.account.R;
import com.honey.account.utils.system.SystemUtilsKt;
import com.meizu.flyme.policy.sdk.PolicySdk;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/honey/account/manager/PrivacyManager;", "", "()V", "TAG", "", "initSDK", "", "context", "Landroid/content/Context;", "belong", "openOnlinePolicy", "title", "category", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PrivacyManager {
    @NotNull
    public static final PrivacyManager INSTANCE = new PrivacyManager();
    @NotNull
    private static final String TAG = "PrivacyManager";

    private PrivacyManager() {
    }

    public final void initSDK(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "belong");
        if (Intrinsics.areEqual((Object) str, (Object) "MEIZU")) {
            PolicySdk.initSDK(context, context.getResources().getString(R.string.MEIZU_POLICY_ID), context.getResources().getString(R.string.MEIZU_POLICY_SECRET), BuildConfig.VERSION_NAME, new HashMap());
        } else {
            Log.w(TAG, "Unknown account ownership. Can't init privacy.");
        }
    }

    public final void openOnlinePolicy(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "category");
        PolicySdk.getOnlinePolicyMethod(context, SystemUtilsKt.getLocalLanguage(), str2, str, Boolean.TRUE, (PolicySdk.PolicySdkCallback) null);
    }
}
