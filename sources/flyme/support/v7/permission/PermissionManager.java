package flyme.support.v7.permission;

import android.content.Context;
import androidx.annotation.NonNull;
import flyme.support.v7.appcompat.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PermissionManager {
    private static volatile PermissionManager sInstance;
    private Map<String, Set<String>> mAllPermissions;
    private Map<String, Localization> mLocalizations;
    private final PackageManagerProxy mPackageManagerProxy;

    private PermissionManager(Context context) {
        this.mPackageManagerProxy = new PackageManagerProxy(context.getApplicationContext().getPackageManager());
        initLocalization();
        loadAllPermissions();
    }

    public static PermissionManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (PermissionManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new PermissionManager(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    @NonNull
    private String getParentGroup(String str) {
        for (Map.Entry next : this.mAllPermissions.entrySet()) {
            Iterator it = ((Set) next.getValue()).iterator();
            while (true) {
                if (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return (String) next.getKey();
                    }
                }
            }
        }
        return PackageManagerProxy.PERMISSION_GROUP_OTHER;
    }

    private void initLocalization() {
        HashMap hashMap = new HashMap();
        this.mLocalizations = hashMap;
        hashMap.put(PackageManagerProxy.PERMISSION_GROUP_NETWORK, new Localization(0, "连接网络", R.drawable.mz_permission_net));
        this.mLocalizations.put("android.permission-group.LOCATION", new Localization(1, "获取位置信息", R.drawable.mz_permission_location));
        this.mLocalizations.put("android.permission-group.CAMERA", new Localization(2, "拍照和录像", R.drawable.mz_permission_camera));
        this.mLocalizations.put("android.permission-group.MICROPHONE", new Localization(3, "录制音频", R.drawable.mz_permission_microphone));
        this.mLocalizations.put("android.permission-group.PHONE", new Localization(4, "拨打电话或获取手机状态", R.drawable.mz_permission_phone));
        this.mLocalizations.put("android.permission-group.SMS", new Localization(5, "读取或发送信息", R.drawable.mz_permission_sms));
        this.mLocalizations.put("android.permission-group.CONTACTS", new Localization(6, "读取或修改联系人", R.drawable.mz_permission_contacts));
        this.mLocalizations.put("android.permission-group.CALL_LOG", new Localization(7, "读取或修改通话记录", R.drawable.mz_permission_calllog));
        this.mLocalizations.put("android.permission-group.STORAGE", new Localization(8, "读写手机存储", R.drawable.mz_permission_storage));
        this.mLocalizations.put(PackageManagerProxy.PERMISSION_GROUP_BLUETOOTH, new Localization(9, (String) null, R.drawable.mz_permission_net));
        this.mLocalizations.put(PackageManagerProxy.PERMISSION_GROUP_CHANGE_NETWORK, new Localization(10, "开启和关闭无线网络", R.drawable.mz_permission_net));
        this.mLocalizations.put("android.permission-group.CALENDAR", new Localization(11, "读取或修改日历", R.drawable.mz_permission_calendar));
        this.mLocalizations.put("android.permission-group.SENSORS", new Localization(12, (String) null, R.drawable.mz_permission_sensors));
        this.mLocalizations.put("android.permission-group.ACTIVITY_RECOGNITION", new Localization(13, (String) null, R.drawable.mz_permission_sensors));
        this.mLocalizations.put(PackageManagerProxy.PERMISSION_GROUP_OTHER, new Localization(14, (String) null, R.drawable.mz_permission_other));
        this.mLocalizations.put(PackageManagerProxy.PERMISSION_GROUP_PACKAGES, new Localization(15, "读取应用列表", 0));
        this.mLocalizations.put(PackageManagerProxy.PERMISSION_GROUP_PRIMARY_CLIP, new Localization(16, "读取或写入剪切板", 0));
        this.mLocalizations.put("android.permission.CALL_PHONE", new Localization(0, (String) null, 0));
        this.mLocalizations.put("android.permission.ANSWER_PHONE_CALLS", new Localization(1, "接听电话", 0));
        this.mLocalizations.put("android.permission.USE_SIP", new Localization(2, "拨打或接听 SIP 电话", 0));
        this.mLocalizations.put("android.permission.READ_PHONE_NUMBERS", new Localization(3, (String) null, 0));
        this.mLocalizations.put("android.permission.READ_PHONE_STATE", new Localization(4, "读取手机状态和识别码", 0));
        this.mLocalizations.put("com.android.voicemail.permission.ADD_VOICEMAIL", new Localization(5, (String) null, 0));
        this.mLocalizations.put("android.permission.ACCEPT_HANDOVER", new Localization(6, "继续进行来自其他应用的通话", 0));
        this.mLocalizations.put("android.permission.ACCESS_UCE_OPTIONS_SERVICE", new Localization(7, (String) null, 0));
        this.mLocalizations.put("android.permission.ACCESS_UCE_PRESENCE_SERVICE", new Localization(8, (String) null, 0));
        this.mLocalizations.put("android.permission.READ_CALL_LOG", new Localization(0, (String) null, 0));
        this.mLocalizations.put("android.permission.WRITE_CALL_LOG", new Localization(1, "修改通话记录", 0));
        this.mLocalizations.put("android.permission.PROCESS_OUTGOING_CALLS", new Localization(2, "修改默认电话应用", 0));
        this.mLocalizations.put("android.permission.READ_SMS", new Localization(0, "读取短信或彩信", 0));
        this.mLocalizations.put("android.permission.READ_CELL_BROADCASTS", new Localization(1, "读取小区广播", 0));
        this.mLocalizations.put("android.permission.SEND_SMS", new Localization(2, "发送短信或彩信", 0));
        this.mLocalizations.put("android.permission.RECEIVE_SMS", new Localization(3, "接收短信", 0));
        this.mLocalizations.put("android.permission.RECEIVE_MMS", new Localization(4, "接收彩信", 0));
        this.mLocalizations.put("android.permission.RECEIVE_WAP_PUSH", new Localization(5, "接收 WAP 讯息", 0));
        this.mLocalizations.put("android.permission.WRITE_SMS", new Localization(6, "修改短信或彩信", 0));
        this.mLocalizations.put("android.permission.READ_CONTACTS", new Localization(0, (String) null, 0));
        this.mLocalizations.put("android.permission.WRITE_CONTACTS", new Localization(1, "修改联系人", 0));
        this.mLocalizations.put("android.permission.GET_ACCOUNTS", new Localization(2, "读取应用账号", 0));
        this.mLocalizations.put("android.permission.CAMERA", new Localization(0, "拍照或录像", 0));
        this.mLocalizations.put("android.permission.RECORD_AUDIO", new Localization(0, "使用麦克风或录音", 0));
        this.mLocalizations.put("android.permission.ACCESS_FINE_LOCATION", new Localization(0, "获取确切位置信息", 0));
        this.mLocalizations.put("android.permission.ACCESS_COARSE_LOCATION", new Localization(1, "获取大致位置信息", 0));
        this.mLocalizations.put("android.permission.ACCESS_BACKGROUND_LOCATION", new Localization(2, "应用在后台时获取位置信息", 0));
        this.mLocalizations.put("android.permission.READ_CALENDAR", new Localization(0, "读取日历", 0));
        this.mLocalizations.put("android.permission.WRITE_CALENDAR", new Localization(1, "修改日历", 0));
        this.mLocalizations.put("android.permission.READ_EXTERNAL_STORAGE", new Localization(0, "读取手机存储", 0));
        this.mLocalizations.put("android.permission.WRITE_EXTERNAL_STORAGE", new Localization(1, "写入手机存储", 0));
        this.mLocalizations.put("android.permission.CHANGE_WIFI_STATE", new Localization(0, "开启或关闭无线网络", 0));
        this.mLocalizations.put("android.permission.BLUETOOTH", new Localization(0, (String) null, 0));
        this.mLocalizations.put("android.permission.BLUETOOTH_ADMIN", new Localization(1, (String) null, 0));
        this.mLocalizations.put("android.permission.BODY_SENSORS", new Localization(0, "读取身体传感器数据", 0));
        this.mLocalizations.put("android.permission.USE_FINGERPRINT", new Localization(1, (String) null, 0));
        this.mLocalizations.put("android.permission.USE_BIOMETRIC", new Localization(2, (String) null, 0));
        this.mLocalizations.put("android.permission.ACTIVITY_RECOGNITION", new Localization(0, "识别健身运动类型和状态", 0));
        this.mLocalizations.put("android.permission.INTERNET", new Localization(0, "连接网络", 0));
        this.mLocalizations.put("android.permission.ACCESS_NETWORK_STATE", new Localization(1, (String) null, 0));
        this.mLocalizations.put("android.permission.CHANGE_NETWORK_STATE", new Localization(2, "修改网络连接", 0));
        this.mLocalizations.put("android.permission.QUERY_ALL_PACKAGES", new Localization(0, "读取应用列表", 0));
        this.mLocalizations.put("android.permission.GET_PRIMARY_CLIP", new Localization(0, "读取剪切板", 0));
        this.mLocalizations.put("android.permission.SET_PRIMARY_CLIP", new Localization(1, "写入剪切板", 0));
        this.mLocalizations.put("android.permission.READ_MEDIA_AUDIO", new Localization(0, "读取音乐和音频", 0));
        this.mLocalizations.put("android.permission-group.READ_MEDIA_VISUAL", new Localization(1, "读取照片和视频", 0));
        this.mLocalizations.put("android.permission.LOCAL_MAC_ADDRESS", new Localization(0, "唯一设备标识符", 0));
    }

    private PermissionGroup insertGroupIfAbsent(List<PermissionGroup> list, String str) {
        for (PermissionGroup next : list) {
            if (next.getIdentifier().equals(str)) {
                return next;
            }
        }
        PermissionGroup permissionGroup = new PermissionGroup(str, this.mLocalizations.get(str), this.mPackageManagerProxy);
        list.add(permissionGroup);
        return permissionGroup;
    }

    private Permission insertPermissionIfAbsent(List<PermissionGroup> list, String str) {
        for (PermissionGroup subPermission : list) {
            Permission subPermission2 = subPermission.getSubPermission(str);
            if (subPermission2 != null) {
                return subPermission2;
            }
        }
        Permission permission = new Permission(str, this.mLocalizations.get(str), this.mPackageManagerProxy);
        insertGroupIfAbsent(list, getParentGroup(str)).addSubPermission(permission);
        return permission;
    }

    private boolean isGroup(String str) {
        return this.mAllPermissions.containsKey(str);
    }

    private void loadAllPermissions() {
        this.mAllPermissions = new HashMap();
        for (String next : this.mPackageManagerProxy.getAllPermissionGroups()) {
            this.mAllPermissions.put(next, this.mPackageManagerProxy.queryPermissionsByGroup(next));
        }
    }

    public List<PermissionGroup> getAllPermissions() {
        return getRequestPermission((String[]) this.mAllPermissions.keySet().toArray(new String[0]), true);
    }

    public String getPermissionName(Context context, String str) {
        return new Permission(str, this.mLocalizations.get(str), this.mPackageManagerProxy).getDisplayName(context);
    }

    public List<PermissionGroup> getRequestPermission(String[] strArr, boolean z) {
        if (strArr == null || strArr.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList<PermissionGroup> arrayList = new ArrayList<>();
        for (String str : strArr) {
            if (isGroup(str)) {
                insertGroupIfAbsent(arrayList, str);
                if (z) {
                    for (String insertPermissionIfAbsent : this.mAllPermissions.get(str)) {
                        insertPermissionIfAbsent(arrayList, insertPermissionIfAbsent);
                    }
                }
            } else {
                insertPermissionIfAbsent(arrayList, str);
            }
        }
        Collections.sort(arrayList);
        for (PermissionGroup subPermission : arrayList) {
            Collections.sort(subPermission.getSubPermission());
        }
        return arrayList;
    }
}
