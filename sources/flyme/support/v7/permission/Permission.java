package flyme.support.v7.permission;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Locale;

public class Permission implements Comparable<Permission> {
    private final String mIdentifier;
    private final Localization mLocalization;
    private final PackageManagerProxy mProxy;

    public Permission(String str, Localization localization, PackageManagerProxy packageManagerProxy) {
        this.mIdentifier = str;
        this.mLocalization = localization;
        this.mProxy = packageManagerProxy;
    }

    public String getDisplayName(Context context) {
        Localization localization;
        if ("zh_CN".equals(Locale.getDefault().toString()) && (localization = this.mLocalization) != null && !TextUtils.isEmpty(localization.getLabelString(context))) {
            return this.mLocalization.getLabelString(context);
        }
        String loadPermissionLabel = this.mProxy.loadPermissionLabel(this.mIdentifier);
        return TextUtils.isEmpty(loadPermissionLabel) ? this.mIdentifier : loadPermissionLabel;
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public int compareTo(@NonNull Permission permission) {
        Localization localization = this.mLocalization;
        if (localization != null && permission.mLocalization != null) {
            return localization.getPriority() - permission.mLocalization.getPriority();
        }
        if (localization != null) {
            return -1;
        }
        return permission.mLocalization != null ? 1 : 0;
    }
}
