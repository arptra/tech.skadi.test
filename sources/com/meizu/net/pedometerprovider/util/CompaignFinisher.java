package com.meizu.net.pedometerprovider.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.List;
import meizu.sdk.compaign.CompaignTask;
import meizu.sdk.compaign.CompaignTaskManager;

public class CompaignFinisher {
    private static final String TAG = "CompaignFinisher";
    private static Intent mCompaignIntent;
    private static Context mContext;

    public static boolean finishCompaign(String str) {
        Uri data;
        Intent intent = mCompaignIntent;
        if (!(intent == null || (data = intent.getData()) == null)) {
            Logs.d("uri is:" + data);
            List<String> pathSegments = data.getPathSegments();
            if (!(pathSegments == null || pathSegments.size() == 0)) {
                String str2 = pathSegments.get(0);
                Logs.d("task = " + str + " segment == " + str2);
                if (str.equalsIgnoreCase(str2)) {
                    CompaignTask compaignTask = new CompaignTask(mCompaignIntent);
                    new CompaignTaskManager(mContext).finishTask(compaignTask.getCompaignId(), compaignTask.getTaskId(), (Bundle) null);
                    Logs.d("finish compaign = " + str2);
                }
            }
        }
        return false;
    }

    public static void init(Context context, Intent intent) {
        if (intent != null) {
            mContext = context;
            String action = intent.getAction();
            if (TextUtils.equals(action, Constants.ACTION_SDK_TASK)) {
                Logs.d("Action ==>" + action);
                mCompaignIntent = intent;
            }
        }
    }
}
