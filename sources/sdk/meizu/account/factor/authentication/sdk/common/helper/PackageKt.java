package sdk.meizu.account.factor.authentication.sdk.common.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"TAG", "", "startAppByScheme", "", "context", "Landroid/content/Context;", "pkgName", "scheme", "sdk_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class PackageKt {
    @NotNull
    public static final String TAG = "PACKAGE";

    public static final void startAppByScheme(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "pkgName");
        Intrinsics.checkNotNullParameter(str2, "scheme");
        if (!TextUtils.isEmpty(str2)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setPackage(str);
                intent.setData(Uri.parse(str2));
                intent.setFlags(536870912);
                context.startActivity(intent);
            } catch (Exception e) {
                Log.w(TAG, "start app by scheme fail. ", e);
            }
        }
    }
}
