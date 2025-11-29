package com.fm.sdk.deviceid;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import com.meizu.common.widget.MzContactsContract;
import java.io.File;
import java.util.Arrays;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2835a;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append(".mmm");
        sb.append(str);
        sb.append(".");
        sb.append("__maid");
        f2835a = sb.toString();
    }

    public static String a(Context context) {
        return a.b(Build.BOARD + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Arrays.deepToString(Build.SUPPORTED_ABIS) + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Build.DEVICE + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Build.DISPLAY + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Build.HOST + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Build.ID + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Build.MANUFACTURER + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Build.VERSION.INCREMENTAL + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Build.BRAND + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Build.MODEL + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Build.PRODUCT + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Build.BOOTLOADER + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Build.HARDWARE + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Build.TAGS + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Build.TYPE + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Build.USER + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Build.FINGERPRINT + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + Settings.System.getString(context.getContentResolver(), "android_id"), "UTF-8");
    }
}
