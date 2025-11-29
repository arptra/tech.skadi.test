package com.sina.weibo.sdk.openapi;

import android.content.Context;
import com.sina.weibo.sdk.e0;

public class WBAPIFactory {
    public static IWBAPI createWBAPI(Context context) {
        return new e0(context);
    }
}
