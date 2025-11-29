package com.honey.account.c4;

import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassAudioInfo;
import com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecordGlassAudioInfo f4192a;
    public final /* synthetic */ byte[] b;

    public /* synthetic */ a(RecordGlassAudioInfo recordGlassAudioInfo, byte[] bArr) {
        this.f4192a = recordGlassAudioInfo;
        this.b = bArr;
    }

    public final void run() {
        RecordVoiceUtils.feedPhoneMuteData$lambda$21$lambda$20(this.f4192a, this.b);
    }
}
