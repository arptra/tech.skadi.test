package com.upuphone.xr.sapp.entity;

import android.net.Uri;
import androidx.annotation.Keep;

@Keep
public class XiaoMiQuerrySteps {
    public static final String AUTHORITY = "com.miui.providers.steps";
    public static final String BEGIN_TIME = "_begin_time";
    public static final Uri CONTENT_URI = Uri.parse("content://com.miui.providers.steps/item");
    public static final String DEFAULT_SORT_ORDER = "_id asc";
    public static final String END_TIME = "_end_time";
    public static final String ID = "_id";
    public static final String MODE = "_mode";
    public static final String STEPS = "_steps";
    public static String[] projection = {"_id", BEGIN_TIME, END_TIME, MODE, STEPS};
}
