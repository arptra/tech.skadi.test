package flyme.support.v7.util;

import android.content.Context;
import flyme.support.v7.appcompat.R;
import java.util.ArrayList;

public class PermissionUtils {
    public static final int OP_GROUP_BOOTCOMPLETED = 9;
    public static final int OP_GROUP_CAMERA = 7;
    public static final int OP_GROUP_GPS = 22;
    public static final int OP_GROUP_INTERNET = 25;
    public static final int OP_GROUP_LOCATION = 5;
    public static final int OP_GROUP_NFC = 13;
    public static final int OP_GROUP_NONE = -1;
    public static final int OP_GROUP_OPEN_BLUETOOTH = 8;
    public static final int OP_GROUP_OPEN_MOBILE_DATA = 3;
    public static final int OP_GROUP_OPEN_WLAN = 4;
    public static final int OP_GROUP_PHONE_CALL = 0;
    public static final int OP_GROUP_PHONE_OUT_GOING_CALL = 23;
    public static final int OP_GROUP_PHONE_READ_CALLLOG = 10;
    public static final int OP_GROUP_PHONE_WRITE_CALLLOG = 21;
    public static final int OP_GROUP_READ_CONTACTS = 1;
    public static final int OP_GROUP_READ_MMS = 11;
    public static final int OP_GROUP_READ_SMS = 2;
    public static final int OP_GROUP_RECEIVE_MMS = 20;
    public static final int OP_GROUP_RECEIVE_SMS = 17;
    public static final int OP_GROUP_RECORDAUDIO = 6;
    public static final int OP_GROUP_RECORDAUDIO_PHONE = 12;
    public static final int OP_GROUP_SEND_MMS = 19;
    public static final int OP_GROUP_SEND_SMS = 16;
    public static final int OP_GROUP_SYSTEM_ALERT = 24;
    public static final int OP_GROUP_WRITE_CONTACTS = 14;
    public static final int OP_GROUP_WRITE_MMS = 18;
    public static final int OP_GROUP_WRITE_SMS = 15;
    public static ArrayList<String> mBootCompletedList = new ArrayList<>();
    public static ArrayList<String> mCameraList = new ArrayList<>();
    public static ArrayList<String> mInternetList = new ArrayList<>();
    public static ArrayList<String> mLocationList = new ArrayList<>();
    public static ArrayList<String> mOPenBluetoothList = new ArrayList<>();
    public static ArrayList<String> mOPenGpsList = new ArrayList<>();
    public static ArrayList<String> mOPenWalnList = new ArrayList<>();
    public static ArrayList<String> mOpenMobileDataList = new ArrayList<>();
    public static ArrayList<String> mOpenNfcList = new ArrayList<>();
    public static ArrayList<String> mPhoneCallList = new ArrayList<>();
    public static ArrayList<String> mPhoneOutGoingList = new ArrayList<>();
    public static ArrayList<String> mReadCallLogList = new ArrayList<>();
    public static ArrayList<String> mReadContactsList = new ArrayList<>();
    public static ArrayList<String> mReadMmsList = new ArrayList<>();
    public static ArrayList<String> mReadSmsList = new ArrayList<>();
    public static ArrayList<String> mReceiveMMsList = new ArrayList<>();
    public static ArrayList<String> mReceiveSmsList = new ArrayList<>();
    public static ArrayList<String> mRecordAudioList = new ArrayList<>();
    public static ArrayList<String> mRecordAudioPhoneList = new ArrayList<>();
    public static ArrayList<String> mSendMmsList = new ArrayList<>();
    public static ArrayList<String> mSendSmsList = new ArrayList<>();
    public static ArrayList<String> mSystemAlertList = new ArrayList<>();
    public static ArrayList<String> mWriteCallLogList = new ArrayList<>();
    public static ArrayList<String> mWriteContactsList = new ArrayList<>();
    public static ArrayList<String> mWriteMmsList = new ArrayList<>();
    public static ArrayList<String> mWriteSmsList = new ArrayList<>();
    private String OP_GROUP_BOOTCOMPLETED_STRING;
    private String OP_GROUP_CAMERA_STRING;
    private String OP_GROUP_GPS_STRING;
    private String OP_GROUP_INTERNET_STRING;
    private String OP_GROUP_LOCATION_STRING;
    private String OP_GROUP_NFC_STRING;
    private String OP_GROUP_NONE_STRING;
    private String OP_GROUP_OPEN_BLUETOOTH_STRING;
    private String OP_GROUP_OPEN_MOBILE_DATA_STRING;
    private String OP_GROUP_OPEN_WLAN_STRING;
    private String OP_GROUP_PHONE_CALL_STRING;
    private String OP_GROUP_PHONE_OUT_GOING_CALL_STRING;
    private String OP_GROUP_PHONE_READ_CALLLOG_STRING;
    private String OP_GROUP_PHONE_WRITE_CALLLOG_STRING;
    private String OP_GROUP_READ_CONTACTS_STRING;
    private String OP_GROUP_READ_MMS_STRING;
    private String OP_GROUP_READ_SMS_STRING;
    private String OP_GROUP_RECEIVE_MMS_STRING;
    private String OP_GROUP_RECEIVE_SMS_STRING;
    private String OP_GROUP_RECORDAUDIO_PHONE_STRING;
    private String OP_GROUP_RECORDAUDIO_STRING;
    private String OP_GROUP_SEND_MMS_STRING;
    private String OP_GROUP_SEND_SMS_STRING;
    private String OP_GROUP_SYSTEM_ALERT_STRING;
    private String OP_GROUP_WRITE_CONTACTS_STRING;
    private String OP_GROUP_WRITE_MMS_STRING;
    private String OP_GROUP_WRITE_SMS_STRING;

    static {
        mPhoneCallList.add("android.permission.CALL_PHONE");
        mReadContactsList.add("android.permission.READ_CONTACTS");
        mReadSmsList.add("android.permission.READ_SMS");
        mOpenMobileDataList.add("android.permission.CHANGE_NETWORK_STATE");
        mOPenWalnList.add("android.permission.CHANGE_WIFI_STATE");
        mLocationList.add("android.permission.ACCESS_COARSE_LOCATION");
        mLocationList.add("android.permission.ACCESS_FINE_LOCATION");
        mRecordAudioList.add("android.permission.RECORD_AUDIO");
        mCameraList.add("android.permission.CAMERA");
        mOPenBluetoothList.add("android.permission.BLUETOOTH");
        mOPenBluetoothList.add("android.permission.BLUETOOTH_ADMIN");
        mBootCompletedList.add("android.permission.RECEIVE_BOOT_COMPLETED");
        mReadCallLogList.add("android.permission.READ_CALL_LOG");
        mReadMmsList.add("android.permission.READ_SMS");
        mOpenNfcList.add("android.permission.NFC");
        mWriteContactsList.add("android.permission.WRITE_CONTACTS");
        mWriteSmsList.add("android.permission.WRITE_SMS");
        mSendSmsList.add("android.permission.SEND_SMS");
        mReceiveSmsList.add("android.permission.RECEIVE_SMS");
        mReceiveMMsList.add("android.permission.RECEIVE_MMS");
        mWriteCallLogList.add("android.permission.WRITE_CALL_LOG");
        mPhoneOutGoingList.add("android.permission.PROCESS_OUTGOING_CALLS");
        mSystemAlertList.add("android.permission.SYSTEM_ALERT_WINDOW");
        mInternetList.add("android.permission.INTERNET");
    }

    public PermissionUtils(Context context) {
        getStringInfo(context);
    }

    private void getStringInfo(Context context) {
        this.OP_GROUP_PHONE_CALL_STRING = context.getResources().getString(R.string.mz_pm_call);
        this.OP_GROUP_READ_CONTACTS_STRING = context.getResources().getString(R.string.mz_pm_contacts);
        this.OP_GROUP_READ_SMS_STRING = context.getResources().getString(R.string.mz_pm_r_sms);
        this.OP_GROUP_OPEN_MOBILE_DATA_STRING = context.getResources().getString(R.string.mz_pm_set_gprs_on);
        this.OP_GROUP_OPEN_WLAN_STRING = context.getResources().getString(R.string.mz_pm_set_wifi_on);
        this.OP_GROUP_LOCATION_STRING = context.getResources().getString(R.string.mz_pm_location);
        this.OP_GROUP_RECORDAUDIO_STRING = context.getResources().getString(R.string.mz_pm_recordaudio_local);
        this.OP_GROUP_CAMERA_STRING = context.getResources().getString(R.string.mz_pm_camera);
        this.OP_GROUP_OPEN_BLUETOOTH_STRING = context.getResources().getString(R.string.mz_pm_set_bluetooth_on);
        this.OP_GROUP_BOOTCOMPLETED_STRING = "";
        this.OP_GROUP_PHONE_READ_CALLLOG_STRING = context.getResources().getString(R.string.mz_pm_call_log);
        this.OP_GROUP_READ_MMS_STRING = context.getResources().getString(R.string.mz_pm_r_mms);
        this.OP_GROUP_RECORDAUDIO_PHONE_STRING = context.getResources().getString(R.string.mz_pm_recordaudio_phone);
        this.OP_GROUP_NFC_STRING = context.getResources().getString(R.string.mz_pm_nfc);
        this.OP_GROUP_WRITE_CONTACTS_STRING = "";
        this.OP_GROUP_WRITE_SMS_STRING = "";
        this.OP_GROUP_SEND_SMS_STRING = context.getResources().getString(R.string.mz_pm_s_sms);
        this.OP_GROUP_RECEIVE_SMS_STRING = "";
        this.OP_GROUP_WRITE_MMS_STRING = "";
        this.OP_GROUP_SEND_MMS_STRING = context.getResources().getString(R.string.mz_pm_s_mms);
        this.OP_GROUP_RECEIVE_MMS_STRING = "";
        this.OP_GROUP_PHONE_WRITE_CALLLOG_STRING = "";
        this.OP_GROUP_GPS_STRING = "";
        this.OP_GROUP_PHONE_OUT_GOING_CALL_STRING = "";
        this.OP_GROUP_SYSTEM_ALERT_STRING = "";
        this.OP_GROUP_INTERNET_STRING = context.getResources().getString(R.string.mz_pm_online_intenert);
    }

    public String getPermissionLabelByName(String str) {
        switch (getPermissionTypeByName(str)) {
            case 0:
                return this.OP_GROUP_PHONE_CALL_STRING;
            case 1:
                return this.OP_GROUP_READ_CONTACTS_STRING;
            case 2:
                return this.OP_GROUP_READ_SMS_STRING;
            case 3:
                return this.OP_GROUP_OPEN_MOBILE_DATA_STRING;
            case 4:
                return this.OP_GROUP_OPEN_WLAN_STRING;
            case 5:
                return this.OP_GROUP_LOCATION_STRING;
            case 6:
                return this.OP_GROUP_RECORDAUDIO_STRING;
            case 7:
                return this.OP_GROUP_CAMERA_STRING;
            case 8:
                return this.OP_GROUP_OPEN_BLUETOOTH_STRING;
            case 9:
                return this.OP_GROUP_BOOTCOMPLETED_STRING;
            case 10:
                return this.OP_GROUP_PHONE_READ_CALLLOG_STRING;
            case 11:
                return this.OP_GROUP_READ_MMS_STRING;
            case 12:
                return this.OP_GROUP_RECORDAUDIO_PHONE_STRING;
            case 13:
                return this.OP_GROUP_NFC_STRING;
            case 14:
                return this.OP_GROUP_WRITE_CONTACTS_STRING;
            case 15:
                return this.OP_GROUP_WRITE_SMS_STRING;
            case 16:
                return this.OP_GROUP_SEND_SMS_STRING;
            case 17:
                return this.OP_GROUP_RECEIVE_SMS_STRING;
            case 18:
                return this.OP_GROUP_WRITE_MMS_STRING;
            case 19:
                return this.OP_GROUP_SEND_MMS_STRING;
            case 20:
                return this.OP_GROUP_RECEIVE_MMS_STRING;
            case 21:
                return this.OP_GROUP_PHONE_WRITE_CALLLOG_STRING;
            case 22:
                return this.OP_GROUP_GPS_STRING;
            case 23:
                return this.OP_GROUP_PHONE_OUT_GOING_CALL_STRING;
            case 24:
                return this.OP_GROUP_SYSTEM_ALERT_STRING;
            case 25:
                return this.OP_GROUP_INTERNET_STRING;
            default:
                return null;
        }
    }

    public int getPermissionTypeByName(String str) {
        if (mPhoneCallList.contains(str)) {
            return 0;
        }
        if (mReadContactsList.contains(str)) {
            return 1;
        }
        if (mReadSmsList.contains(str)) {
            return 2;
        }
        if (mOpenMobileDataList.contains(str)) {
            return 3;
        }
        if (mOPenWalnList.contains(str)) {
            return 4;
        }
        if (mLocationList.contains(str)) {
            return 5;
        }
        if (mRecordAudioList.contains(str)) {
            return 6;
        }
        if (mCameraList.contains(str)) {
            return 7;
        }
        if (mOPenBluetoothList.contains(str)) {
            return 8;
        }
        if (mBootCompletedList.contains(str)) {
            return 9;
        }
        if (mReadCallLogList.contains(str)) {
            return 10;
        }
        if (mReadMmsList.contains(str)) {
            return 11;
        }
        if (mRecordAudioPhoneList.contains(str)) {
            return 12;
        }
        if (mOpenNfcList.contains(str)) {
            return 13;
        }
        if (mWriteContactsList.contains(str)) {
            return 14;
        }
        if (mWriteSmsList.contains(str)) {
            return 15;
        }
        if (mSendSmsList.contains(str)) {
            return 16;
        }
        if (mReceiveSmsList.contains(str)) {
            return 17;
        }
        if (mWriteMmsList.contains(str)) {
            return 18;
        }
        if (mSendMmsList.contains(str)) {
            return 19;
        }
        if (mReceiveMMsList.contains(str)) {
            return 20;
        }
        if (mWriteCallLogList.contains(str)) {
            return 21;
        }
        if (mOPenGpsList.contains(str)) {
            return 22;
        }
        if (mPhoneOutGoingList.contains(str)) {
            return 23;
        }
        if (mSystemAlertList.contains(str)) {
            return 24;
        }
        return mInternetList.contains(str) ? 25 : -1;
    }

    public String[] loadPemissionLables(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        ArrayList arrayList = new ArrayList();
        for (String permissionLabelByName : strArr) {
            arrayList.add(getPermissionLabelByName(permissionLabelByName));
        }
        arrayList.toArray(strArr2);
        return strArr2;
    }
}
