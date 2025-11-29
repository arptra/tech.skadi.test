package com.xjsd.ai.assistant.protocol.sys;

public class SyncSysInfoRes {
    private boolean hasWakeupVoicePrint = false;
    private boolean isAsrResultScreenEnable = true;
    private boolean isChatGptCardDisplayEnable = true;
    private boolean isChatGptTTSPlayEnable = true;
    private boolean isContinuousDialogueEnable = false;
    private boolean isLowPowerWakeupEnable = true;
    private boolean isLowPowerWakeupScreenOffEnable = false;
    private boolean isNetworkAvailable = false;
    private boolean isWakeupVoiceRecording = false;
    private int ttsTimbreValue = 0;

    public int getTtsTimbreValue() {
        return this.ttsTimbreValue;
    }

    public boolean isAsrResultScreenEnable() {
        return this.isAsrResultScreenEnable;
    }

    public boolean isChatGptCardDisplayEnable() {
        return this.isChatGptCardDisplayEnable;
    }

    public boolean isChatGptTTSPlayEnable() {
        return this.isChatGptTTSPlayEnable;
    }

    public boolean isContinuousDialogueEnable() {
        return this.isContinuousDialogueEnable;
    }

    public boolean isHasWakeupVoicePrint() {
        return this.hasWakeupVoicePrint;
    }

    public boolean isLowPowerWakeupEnable() {
        return this.isLowPowerWakeupEnable;
    }

    public boolean isLowPowerWakeupScreenOffEnable() {
        return this.isLowPowerWakeupScreenOffEnable;
    }

    public boolean isNetworkAvailable() {
        return this.isNetworkAvailable;
    }

    public boolean isWakeupVoiceRecording() {
        return this.isWakeupVoiceRecording;
    }

    public void setAsrResultScreenEnable(boolean z) {
        this.isAsrResultScreenEnable = z;
    }

    public void setChatGptCardDisplayEnable(boolean z) {
        this.isChatGptCardDisplayEnable = z;
    }

    public void setChatGptTTSPlayEnable(boolean z) {
        this.isChatGptTTSPlayEnable = z;
    }

    public void setContinuousDialogueEnable(boolean z) {
        this.isContinuousDialogueEnable = z;
    }

    public void setHasWakeupVoicePrint(boolean z) {
        this.hasWakeupVoicePrint = z;
    }

    public void setLowPowerWakeupEnable(boolean z) {
        this.isLowPowerWakeupEnable = z;
    }

    public void setLowPowerWakeupScreenOffEnable(boolean z) {
        this.isLowPowerWakeupScreenOffEnable = z;
    }

    public void setNetworkAvailable(boolean z) {
        this.isNetworkAvailable = z;
    }

    public void setTtsTimbreValue(int i) {
        this.ttsTimbreValue = i;
    }

    public void setWakeupVoiceRecording(boolean z) {
        this.isWakeupVoiceRecording = z;
    }
}
