package com.upuphone.ai.ttsengine.base.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.List;

@Keep
public class TtsSpeakersConfig implements Serializable {
    List<SpeakerInfo> bytedance_speakers;

    public List<SpeakerInfo> getBytedanceSpeakers() {
        return this.bytedance_speakers;
    }
}
