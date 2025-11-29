package com.upuphone.runasone.share.lib.bean;

import android.os.Environment;
import java.io.File;

public final class Constants {
    public static final String ACTION_RECEIVE_FILE = "com.upuphone.runasone.uupshare.action.RECEIVE_FILE";
    public static final String ACTION_TRANSFERING = "com.upuphone.runasone.uupshare.action.TRANSFERING";
    public static final String ACTION_TRANSFER_FAIL = "com.upuphone.runasone.uupshare.action.TRANSFER_FAIL";
    public static final String ACTION_TRANSFER_OK = "com.upuphone.runasone.uupshare.action.TRANSFER_OK";
    public static final String EXTRA_FAIL_REASON = "failReason";
    public static final String EXTRA_FILE_COUNT = "fileCount";
    public static final String EXTRA_FILE_COUNT_FAILED = "fileCountFailed";
    public static final String EXTRA_FILE_COUNT_SUCCESS = "fileCountSuccess";
    public static final String EXTRA_SENDER_NAME = "senderName";
    public static final String FILE_SAVE_LOCATION;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getPath());
        String str = File.separator;
        sb.append(str);
        sb.append(Environment.DIRECTORY_DOWNLOADS);
        sb.append(str);
        sb.append("Uup Share");
        FILE_SAVE_LOCATION = sb.toString();
    }

    private Constants() {
    }
}
