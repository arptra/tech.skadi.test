package flyme.support.v7.permission;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.util.Log;
import flyme.support.v7.appcompat.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PackageManagerProxy {
    public static final String PERMISSION_GROUP_BLUETOOTH = "meizu.permission-group.BLUETOOTH";
    public static final String PERMISSION_GROUP_CHANGE_NETWORK = "meizu.permission-group.CHANGE_NETWORK";
    public static final String PERMISSION_GROUP_NETWORK = "meizu.permission-group.NETWORK";
    public static final String PERMISSION_GROUP_OTHER = "meizu.permission-group.OTHER";
    public static final String PERMISSION_GROUP_PACKAGES = "meizu.permission-group.PACKAGES";
    public static final String PERMISSION_GROUP_PRIMARY_CLIP = "meizu.permission-group.PRIMARY_CLIP";
    private PackageManager mPackageManager;

    public PackageManagerProxy(PackageManager packageManager) {
        this.mPackageManager = packageManager;
    }

    private void handleAndroidQRuntimePermissionIfNeed(String str, Set<String> set) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1639857183:
                if (str.equals("android.permission-group.CONTACTS")) {
                    c = 0;
                    break;
                }
                break;
            case -1410061184:
                if (str.equals("android.permission-group.PHONE")) {
                    c = 1;
                    break;
                }
                break;
            case -1250730292:
                if (str.equals("android.permission-group.CALENDAR")) {
                    c = 2;
                    break;
                }
                break;
            case -1243751087:
                if (str.equals("android.permission-group.CALL_LOG")) {
                    c = 3;
                    break;
                }
                break;
            case -1140935117:
                if (str.equals("android.permission-group.CAMERA")) {
                    c = 4;
                    break;
                }
                break;
            case 225035509:
                if (str.equals("android.permission-group.ACTIVITY_RECOGNITION")) {
                    c = 5;
                    break;
                }
                break;
            case 421761675:
                if (str.equals("android.permission-group.SENSORS")) {
                    c = 6;
                    break;
                }
                break;
            case 828638019:
                if (str.equals("android.permission-group.LOCATION")) {
                    c = 7;
                    break;
                }
                break;
            case 852078861:
                if (str.equals("android.permission-group.STORAGE")) {
                    c = 8;
                    break;
                }
                break;
            case 1581272376:
                if (str.equals("android.permission-group.MICROPHONE")) {
                    c = 9;
                    break;
                }
                break;
            case 1795181803:
                if (str.equals("android.permission-group.SMS")) {
                    c = 10;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                set.add("android.permission.WRITE_CONTACTS");
                set.add("android.permission.GET_ACCOUNTS");
                set.add("android.permission.READ_CONTACTS");
                return;
            case 1:
                set.add("android.permission.ANSWER_PHONE_CALLS");
                set.add("android.permission.READ_PHONE_NUMBERS");
                set.add("android.permission.READ_PHONE_STATE");
                set.add("android.permission.CALL_PHONE");
                set.add("android.permission.ACCEPT_HANDOVER");
                set.add("android.permission.USE_SIP");
                set.add("com.android.voicemail.permission.ADD_VOICEMAIL");
                return;
            case 2:
                set.add("android.permission.READ_CALENDAR");
                set.add("android.permission.WRITE_CALENDAR");
                return;
            case 3:
                set.add("android.permission.READ_CALL_LOG");
                set.add("android.permission.WRITE_CALL_LOG");
                set.add("android.permission.PROCESS_OUTGOING_CALLS");
                return;
            case 4:
                set.add("android.permission.CAMERA");
                return;
            case 5:
                set.add("android.permission.ACTIVITY_RECOGNITION");
                return;
            case 6:
                set.add("android.permission.BODY_SENSORS");
                return;
            case 7:
                set.add("android.permission.ACCESS_FINE_LOCATION");
                set.add("android.permission.ACCESS_COARSE_LOCATION");
                set.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                return;
            case 8:
                set.add("android.permission.READ_EXTERNAL_STORAGE");
                set.add("android.permission.WRITE_EXTERNAL_STORAGE");
                set.add("android.permission.ACCESS_MEDIA_LOCATION");
                return;
            case 9:
                set.add("android.permission.RECORD_AUDIO");
                return;
            case 10:
                set.add("android.permission.READ_SMS");
                set.add("android.permission.RECEIVE_WAP_PUSH");
                set.add("android.permission.RECEIVE_MMS");
                set.add("android.permission.RECEIVE_SMS");
                set.add("android.permission.SEND_SMS");
                set.add("android.permission.READ_CELL_BROADCASTS");
                return;
            default:
                return;
        }
    }

    public List<String> getAllPermissionGroups() {
        ArrayList arrayList = new ArrayList();
        for (PermissionGroupInfo next : this.mPackageManager.getAllPermissionGroups(128)) {
            if ("android".equals(next.packageName)) {
                arrayList.add(next.name);
            }
        }
        arrayList.add(PERMISSION_GROUP_NETWORK);
        arrayList.add(PERMISSION_GROUP_CHANGE_NETWORK);
        arrayList.add(PERMISSION_GROUP_BLUETOOTH);
        arrayList.add(PERMISSION_GROUP_OTHER);
        arrayList.add(PERMISSION_GROUP_PACKAGES);
        arrayList.add(PERMISSION_GROUP_PRIMARY_CLIP);
        arrayList.remove("android.permission-group.UNDEFINED");
        return arrayList;
    }

    public String loadPermissionGroupDescription(Context context, String str) {
        if (PERMISSION_GROUP_NETWORK.equals(str)) {
            return context.getResources().getString(R.string.mz_permissiongroup_name_net);
        }
        if (PERMISSION_GROUP_CHANGE_NETWORK.equals(str)) {
            return context.getResources().getString(R.string.mz_permissiongroup_name_change_network);
        }
        if (PERMISSION_GROUP_BLUETOOTH.equals(str)) {
            return context.getResources().getString(R.string.mz_permissiongroup_name_bluetooth);
        }
        if (PERMISSION_GROUP_OTHER.equals(str)) {
            return context.getResources().getString(R.string.mz_permissiongroup_name_other);
        }
        try {
            return this.mPackageManager.getPermissionGroupInfo(str, 128).loadDescription(this.mPackageManager).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public String loadPermissionLabel(String str) {
        try {
            PermissionInfo permissionInfo = this.mPackageManager.getPermissionInfo(str, 128);
            if (permissionInfo.labelRes == 0) {
                return null;
            }
            return permissionInfo.loadLabel(this.mPackageManager).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public Set<String> queryPermissionsByGroup(String str) {
        HashSet hashSet = new HashSet();
        if (PERMISSION_GROUP_NETWORK.equals(str)) {
            hashSet.add("android.permission.INTERNET");
            hashSet.add("android.permission.ACCESS_NETWORK_STATE");
            hashSet.add("android.permission.CHANGE_NETWORK_STATE");
        } else if (PERMISSION_GROUP_CHANGE_NETWORK.equals(str)) {
            hashSet.add("android.permission.CHANGE_WIFI_STATE");
        } else if (PERMISSION_GROUP_BLUETOOTH.equals(str)) {
            hashSet.add("android.permission.BLUETOOTH");
            hashSet.add("android.permission.BLUETOOTH_ADMIN");
        } else if (PERMISSION_GROUP_PACKAGES.equals(str)) {
            hashSet.add("android.permission.QUERY_ALL_PACKAGES");
        } else if (PERMISSION_GROUP_PRIMARY_CLIP.equals(str)) {
            hashSet.add("android.permission.GET_PRIMARY_CLIP");
            hashSet.add("android.permission.SET_PRIMARY_CLIP");
        } else if (!PERMISSION_GROUP_OTHER.equals(str)) {
            try {
                for (PermissionInfo next : this.mPackageManager.queryPermissionsByGroup(str, 128)) {
                    if (!"android".equals(next.packageName)) {
                        Log.d("PackageManagerProxy", "ignore permission=" + next.name + ", packageName=" + next.packageName);
                    } else {
                        hashSet.add(next.name);
                    }
                }
                if ("android.permission-group.SMS".equals(str)) {
                    hashSet.add("android.permission.WRITE_SMS");
                }
            } catch (Exception unused) {
            }
        }
        handleAndroidQRuntimePermissionIfNeed(str, hashSet);
        return hashSet;
    }
}
