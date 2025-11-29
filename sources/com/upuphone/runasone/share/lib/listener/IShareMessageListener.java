package com.upuphone.runasone.share.lib.listener;

import android.os.Bundle;

public interface IShareMessageListener {
    boolean sendMessageToShare(Bundle bundle);

    void startSendFile(String str);

    boolean startShare(Bundle bundle);
}
