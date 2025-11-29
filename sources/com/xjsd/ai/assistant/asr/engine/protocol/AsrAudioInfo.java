package com.xjsd.ai.assistant.asr.engine.protocol;

import androidx.annotation.Keep;
import java.util.List;

@Keep
public class AsrAudioInfo {
    String audioType;
    int channel;
    boolean enablePunctuation;
    List<String> hotWords;
    int sampleBytes;
    int sampleRate;

    public String getAudioType() {
        return this.audioType;
    }

    public int getChannel() {
        return this.channel;
    }

    public List<String> getHotWords() {
        return this.hotWords;
    }

    public int getSampleBytes() {
        return this.sampleBytes;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public boolean isEnablePunctuation() {
        return this.enablePunctuation;
    }

    public AsrAudioInfo setAudioType(String str) {
        this.audioType = str;
        return this;
    }

    public AsrAudioInfo setChannel(int i) {
        this.channel = i;
        return this;
    }

    public void setEnablePunctuation(boolean z) {
        this.enablePunctuation = z;
    }

    public void setHotWords(List<String> list) {
        this.hotWords = list;
    }

    public AsrAudioInfo setSampleBytes(int i) {
        this.sampleBytes = i;
        return this;
    }

    public AsrAudioInfo setSampleRate(int i) {
        this.sampleRate = i;
        return this;
    }
}
