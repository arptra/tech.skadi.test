package com.bun.miitmdid.provider.huawei;

import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

public class HWProvider extends BaseProvider {
    private static final String TAG = "SDK call Huawei: ";
    private Context context;

    public HWProvider(Context context2) {
        this.context = context2;
    }

    public void doStart() {
        Utils.rL(new Object[]{this, 61, 1606976968533L});
    }

    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 62, 1606976968534L})).booleanValue();
    }
}
