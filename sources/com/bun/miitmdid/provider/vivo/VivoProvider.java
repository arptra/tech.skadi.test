package com.bun.miitmdid.provider.vivo;

import android.content.Context;
import com.bun.miitmdid.provider.BaseProvider;
import com.netease.nis.sdkwrapper.Utils;

public class VivoProvider extends BaseProvider {
    private static final String TAG = "SDK call Vivo: ";
    private String appID;
    private Context context;

    public VivoProvider(Context context2, String str) {
        this.context = context2;
        this.appID = str;
    }

    public void doStart() {
        Utils.rL(new Object[]{this, 94, 1606976968566L});
    }

    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 95, 1606976968567L})).booleanValue();
    }
}
