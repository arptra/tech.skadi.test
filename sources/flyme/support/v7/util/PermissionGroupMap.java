package flyme.support.v7.util;

import android.content.Context;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import flyme.support.v7.appcompat.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermissionGroupMap {
    public static String NET_PERMISSION_GROUP = "net_group";
    public static String OTHER_PERMISSION_GROUP = "other_group";
    private static Map<String, ArrayList<String>> permissionGroup;
    private static Map<String, String> permissionGroupNames;
    private static Map<String, Integer> permissionResGroup;
    private Context activity;

    private void disposePermissionGroupFromDefault() {
        List<PermissionGroupInfo> allPermissionGroups = this.activity.getPackageManager().getAllPermissionGroups(128);
        int i = 0;
        while (i < allPermissionGroups.size()) {
            try {
                String str = allPermissionGroups.get(i).name;
                List<PermissionInfo> queryPermissionsByGroup = this.activity.getPackageManager().queryPermissionsByGroup(str, 128);
                ArrayList arrayList = new ArrayList();
                for (PermissionInfo permissionInfo : queryPermissionsByGroup) {
                    arrayList.add(permissionInfo.name);
                }
                permissionGroup.put(str, arrayList);
                permissionGroupNames.put(str, this.activity.getPackageManager().getPermissionGroupInfo(str, 128).loadLabel(this.activity.getPackageManager()).toString());
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("android.permission.INTERNET");
        arrayList2.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList2.add("android.permission.CHANGE_NETWORK_STATE");
        permissionGroup.put(NET_PERMISSION_GROUP, arrayList2);
        permissionGroupNames.put(NET_PERMISSION_GROUP, this.activity.getResources().getString(R.string.mz_permissiongroup_name_net));
    }

    private void disposePermissionResGroupFromDefault() {
        permissionResGroup.put("android.permission-group.CONTACTS", Integer.valueOf(R.drawable.mz_permission_contacts));
        permissionResGroup.put("android.permission-group.PHONE", Integer.valueOf(R.drawable.mz_permission_phone));
        permissionResGroup.put("android.permission-group.CALENDAR", Integer.valueOf(R.drawable.mz_permission_calendar));
        permissionResGroup.put("android.permission-group.CAMERA", Integer.valueOf(R.drawable.mz_permission_camera));
        permissionResGroup.put("android.permission-group.SENSORS", Integer.valueOf(R.drawable.mz_permission_sensors));
        permissionResGroup.put("android.permission-group.LOCATION", Integer.valueOf(R.drawable.mz_permission_location));
        permissionResGroup.put("android.permission-group.STORAGE", Integer.valueOf(R.drawable.mz_permission_storage));
        permissionResGroup.put("android.permission-group.SMS", Integer.valueOf(R.drawable.mz_permission_sms));
        permissionResGroup.put("android.permission-group.MICROPHONE", Integer.valueOf(R.drawable.mz_permission_microphone));
        permissionResGroup.put("android.permission-group.CALL_LOG", Integer.valueOf(R.drawable.mz_permission_calllog));
        permissionResGroup.put(OTHER_PERMISSION_GROUP, Integer.valueOf(R.drawable.mz_permission_other));
        permissionResGroup.put(NET_PERMISSION_GROUP, Integer.valueOf(R.drawable.mz_permission_net));
    }

    @Deprecated
    public void disposePermissionGroupFromCustom(Map<String, ArrayList<String>> map) {
    }

    public void disposePermissionResGroupFromCustom(Map<String, Integer> map) {
    }

    public ArrayList<String> get(String str) {
        return permissionGroup.get(str);
    }

    public Map<String, ArrayList<String>> getGroups() {
        return permissionGroup;
    }

    public int getPermissionGroupResId(String str) {
        Integer num = permissionResGroup.get(str);
        return num == null ? permissionResGroup.get(OTHER_PERMISSION_GROUP).intValue() : num.intValue();
    }

    public String getPermissionGroupTitleFromName(String str) {
        return permissionGroupNames.get(str);
    }

    public void initialize(Context context) {
        this.activity = context;
        if (permissionGroupNames == null) {
            permissionGroupNames = new HashMap();
        }
        if (permissionGroup == null) {
            permissionGroup = new HashMap();
            disposePermissionGroupFromDefault();
        }
        if (permissionResGroup == null) {
            permissionResGroup = new HashMap();
            disposePermissionResGroupFromDefault();
        }
        disposePermissionGroupFromCustom(permissionGroup);
        disposePermissionGroupFromCustom(permissionGroup, permissionGroupNames);
        disposePermissionResGroupFromCustom(permissionResGroup);
    }

    public void disposePermissionGroupFromCustom(Map<String, ArrayList<String>> map, Map<String, String> map2) {
    }
}
