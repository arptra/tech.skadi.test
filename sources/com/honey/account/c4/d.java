package com.honey.account.c4;

import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassCacheInfo;
import com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecordGlassCacheInfo f4194a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public /* synthetic */ d(RecordGlassCacheInfo recordGlassCacheInfo, int i, long j, long j2) {
        this.f4194a = recordGlassCacheInfo;
        this.b = i;
        this.c = j;
        this.d = j2;
    }

    public final void run() {
        RecordVoiceUtils.savePhoneOrSceneCacheMuteData$lambda$13(this.f4194a, this.b, this.c, this.d);
    }
}
