package com.upuphone.ar.transcribe.phone.helper;

import com.upuphone.ar.transcribe.asr.XJAsrManager;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.xjsd.ai.voice.VoiceListenerAdapter;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTimer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timer.kt\nkotlin/concurrent/TimersKt$timerTask$1\n+ 2 VadCounter.kt\ncom/upuphone/ar/transcribe/phone/helper/VadCounter\n*L\n1#1,148:1\n91#2,4:149\n*E\n"})
public final class VadCounter$startTimer0$$inlined$fixedRateTimer$1 extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VadCounter f6115a;

    public void run() {
        LogExt.d("mute for remote", "VadCounter");
        XJAsrManager.e.a().i();
        VoiceListenerAdapter a2 = this.f6115a.f6114a;
        if (a2 != null) {
            a2.onData(1, (byte[]) null, 0, 0, 0.0f);
        }
    }
}
