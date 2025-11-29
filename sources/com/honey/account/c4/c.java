package com.honey.account.c4;

import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassAudioInfo;
import com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecordGlassAudioInfo f4193a;
    public final /* synthetic */ byte[] b;

    public /* synthetic */ c(RecordGlassAudioInfo recordGlassAudioInfo, byte[] bArr) {
        this.f4193a = recordGlassAudioInfo;
        this.b = bArr;
    }

    public final void run() {
        RecordVoiceUtils.feedSceneData$lambda$24$lambda$23(this.f4193a, this.b);
    }
}
