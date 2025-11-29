package com.upuphone.starrynet.payload.ring;

public interface IRingOutputListener {
    void ringNotifyAlgoState(int i, int i2);

    void ringNotifyUpdateOtaStatus(int i, int i2, int i3);

    void ringResponseDeviceInfo(int i, int i2, String str, int i3);

    @Deprecated
    void ringResponseRemoteMouseStatus(int i, boolean z);

    void ringResponseRemoteMouseWorkMode(int i, int i2);

    void ringResponseRingModel(int i, String str);

    void ringResponseRingName(int i, String str);

    @Deprecated
    void ringResponseRingVersion(int i, int i2, String str);

    void ringResponseRingVersionV2(int i, int i2, String str, String str2);
}
