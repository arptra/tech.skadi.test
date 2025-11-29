package com.upuphone.runasone.share.lib.listener;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.share.api.IHubUupShareStatusCallback;
import com.upuphone.runasone.share.lib.TransferHandler;
import com.upuphone.runasone.share.lib.TransferMode;
import com.upuphone.runasone.share.lib.UupShare;
import com.upuphone.runasone.share.lib.bean.BleFileInfo;
import java.util.HashMap;
import java.util.Map;

public class BleTransfer {
    public final Map<String, StarryDevice> deviceMap = new HashMap();
    protected final TransferHandler handler = new TransferHandler();
    public final Map<String, Boolean> mCanceledMap = new HashMap();
    public final Map<String, BleFileInfo> mSource = new HashMap();

    public IHubUupShareStatusCallback getmCallback(String str, @TransferMode int i) {
        return UupShare.getInstance().mService.getCallbackByTaskId(str, i);
    }
}
