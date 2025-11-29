package flyme.support.v7.permission;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PermissionGroup implements Comparable<PermissionGroup> {
    private final String mIdentifier;
    private final Localization mLocalization;
    private final PackageManagerProxy mProxy;
    private final List<Permission> mSubPermission = new ArrayList();

    public PermissionGroup(String str, Localization localization, PackageManagerProxy packageManagerProxy) {
        this.mIdentifier = str;
        this.mLocalization = localization;
        this.mProxy = packageManagerProxy;
    }

    public void addSubPermission(Permission permission) {
        this.mSubPermission.add(permission);
    }

    public String getDisplayName(Context context) {
        Localization localization;
        if ("zh_CN".equals(Locale.getDefault().toString()) && (localization = this.mLocalization) != null && !TextUtils.isEmpty(localization.getLabelString(context))) {
            return this.mLocalization.getLabelString(context);
        }
        String loadPermissionGroupDescription = this.mProxy.loadPermissionGroupDescription(context, this.mIdentifier);
        return TextUtils.isEmpty(loadPermissionGroupDescription) ? this.mIdentifier : loadPermissionGroupDescription;
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public Permission getSubPermission(String str) {
        for (Permission next : this.mSubPermission) {
            if (next.getIdentifier().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public int compareTo(@NonNull PermissionGroup permissionGroup) {
        Localization localization = this.mLocalization;
        if (localization != null && permissionGroup.mLocalization != null) {
            return localization.getPriority() - permissionGroup.mLocalization.getPriority();
        }
        if (localization != null) {
            return -1;
        }
        return permissionGroup.mLocalization != null ? 1 : 0;
    }

    public List<Permission> getSubPermission() {
        return this.mSubPermission;
    }
}
