package flyme.support.v7.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;
import flyme.support.v7.bean.Permission;
import java.util.ArrayList;

public class PermissionUtil {
    private Context activity;
    private PackageManager packageManager;
    private PermissionGroupMap permissionGroupMap;

    public PermissionUtil(Context context) {
        this.activity = context;
        this.packageManager = context.getPackageManager();
    }

    private String extractPermissionGroupFromPermission(String str) {
        for (String next : this.permissionGroupMap.getGroups().keySet()) {
            if (this.permissionGroupMap.getGroups().get(next).indexOf(str) != -1) {
                return next;
            }
        }
        return null;
    }

    private Permission getExistedPermissionGroup(ArrayList<Permission> arrayList, String str) {
        if (str == null) {
            str = PermissionGroupMap.OTHER_PERMISSION_GROUP;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getPermission().equals(str)) {
                return arrayList.get(i);
            }
        }
        return null;
    }

    private ArrayList<Permission> getPermissionFromGroup(String str) throws PackageManager.NameNotFoundException {
        ArrayList<Permission> arrayList = new ArrayList<>();
        for (int i = 0; i < this.permissionGroupMap.get(str).size(); i++) {
            arrayList.add(getPermissionFromName(this.permissionGroupMap.get(str).get(i)));
        }
        return arrayList;
    }

    private int getPermissionGroupResId(String str) {
        return this.permissionGroupMap.getPermissionGroupResId(str);
    }

    public static boolean hasOverlayPermission(Context context) {
        return Settings.canDrawOverlays(context);
    }

    private boolean isGroup(String str) {
        for (String equals : this.permissionGroupMap.getGroups().keySet()) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static void requestOverlayPermission(Context context) {
        if (!Settings.canDrawOverlays(context)) {
            context.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getPackageName())));
            return;
        }
        Toast.makeText(context, "悬浮窗权限已拥有", 0).show();
    }

    public ArrayList<Permission> assemblePermissionGroupsFromPermissions(String[] strArr, String[] strArr2, int[] iArr) {
        String str;
        int i;
        int i2;
        String str2;
        ArrayList<Permission> arrayList = new ArrayList<>();
        if (strArr != null) {
            int i3 = 0;
            while (i3 < strArr.length) {
                try {
                    String str3 = strArr[i3];
                    if (isGroup(str3)) {
                        Permission permission = new Permission();
                        if (strArr2 == null || strArr2.length <= i3 || (str2 = strArr2[i3]) == null) {
                            permission.setName(this.permissionGroupMap.getPermissionGroupTitleFromName(str3));
                        } else {
                            permission.setName(str2);
                        }
                        if (iArr == null || iArr.length <= i3 || (i2 = iArr[i3]) == 0) {
                            permission.setResId(getPermissionGroupResId(str3));
                        } else {
                            permission.setResId(i2);
                        }
                        permission.setPermission(str3);
                        permission.setPermissionChild(getPermissionFromGroup(str3));
                        arrayList.add(permission);
                    } else {
                        String extractPermissionGroupFromPermission = extractPermissionGroupFromPermission(str3);
                        Permission existedPermissionGroup = getExistedPermissionGroup(arrayList, extractPermissionGroupFromPermission);
                        if (existedPermissionGroup == null) {
                            existedPermissionGroup = new Permission();
                            arrayList.add(existedPermissionGroup);
                            if (extractPermissionGroupFromPermission == null) {
                                existedPermissionGroup.setName(PermissionGroupMap.OTHER_PERMISSION_GROUP);
                                existedPermissionGroup.setPermission(PermissionGroupMap.OTHER_PERMISSION_GROUP);
                            } else {
                                existedPermissionGroup.setName(this.permissionGroupMap.getPermissionGroupTitleFromName(extractPermissionGroupFromPermission));
                                existedPermissionGroup.setPermission(extractPermissionGroupFromPermission);
                            }
                            if (iArr == null || iArr.length <= i3 || (i = iArr[i3]) == 0) {
                                existedPermissionGroup.setResId(getPermissionGroupResId(existedPermissionGroup.getPermission()));
                            } else {
                                existedPermissionGroup.setResId(i);
                            }
                            existedPermissionGroup.setPermissionChild(new ArrayList());
                        }
                        Permission permissionFromName = getPermissionFromName(str3);
                        if (!(strArr2 == null || strArr2.length <= i3 || (str = strArr2[i3]) == null)) {
                            permissionFromName.setName(str);
                        }
                        existedPermissionGroup.getPermissionChild().add(permissionFromName);
                    }
                    i3++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public Permission getPermissionFromName(String str) throws PackageManager.NameNotFoundException {
        PermissionInfo permissionInfo = this.packageManager.getPermissionInfo(str, 0);
        Permission permission = new Permission();
        permission.setName(permissionInfo.loadLabel(this.packageManager).toString());
        permission.setPermission(str);
        return permission;
    }

    public void initialize() {
        PermissionGroupMap permissionGroupMap2 = new PermissionGroupMap();
        this.permissionGroupMap = permissionGroupMap2;
        permissionGroupMap2.initialize(this.activity);
    }
}
