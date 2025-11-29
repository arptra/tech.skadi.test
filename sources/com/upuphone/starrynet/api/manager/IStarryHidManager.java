package com.upuphone.starrynet.api.manager;

import com.upuphone.starrynet.api.ICommonCallback;
import com.upuphone.starrynet.api.hid.IKeyBoardWrapper;
import com.upuphone.starrynet.api.hid.IMouseWrapper;
import com.upuphone.starrynet.api.hid.ITouchPadWrapper;

public interface IStarryHidManager {
    void closeHid();

    IKeyBoardWrapper getKeyBoardWrapper();

    IMouseWrapper getMouseWrapper();

    ITouchPadWrapper getTouchPadWrapper();

    void openHid(byte[] bArr, byte b, ICommonCallback iCommonCallback);
}
