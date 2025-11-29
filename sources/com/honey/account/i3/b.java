package com.honey.account.i3;

import com.ucar.vehiclesdk.audio.UCarAudioManager;
import com.ucar.vehiclesdk.recorder.CarAudioRecorder;

public final /* synthetic */ class b implements CarAudioRecorder.Callback {
    public final void a(short[] sArr, int i) {
        UCarAudioManager.l(sArr, i);
    }
}
