package com.xjsd.ai.assistant.core.api.tts;

import androidx.annotation.Keep;
import com.xjsd.ai.assistant.annotation.TtsOverNextStep;
import com.xjsd.ai.assistant.core.bean.SessionData;
import java.util.Map;

@Keep
public class TtsData extends SessionData {
    private String emotionType;
    private String extra;
    private String functionId;
    private boolean isChatGpt = false;
    @TtsOverNextStep
    private int nextStep = 0;
    private String nlgId;
    private Map<String, String> slots;
    private int source = 0;
    private String text;
    private String timbre;

    public String getEmotionType() {
        return this.emotionType;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getFunctionId() {
        return this.functionId;
    }

    public int getNextStep() {
        return this.nextStep;
    }

    public String getNlgId() {
        return this.nlgId;
    }

    public Map<String, String> getSlots() {
        return this.slots;
    }

    public int getSource() {
        return this.source;
    }

    public String getText() {
        return this.text;
    }

    public String getTimbre() {
        return this.timbre;
    }

    public boolean isChatGpt() {
        return this.isChatGpt;
    }

    public void setChatGpt(boolean z) {
        this.isChatGpt = z;
    }

    public void setEmotionType(String str) {
        this.emotionType = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setFunctionId(String str) {
        this.functionId = str;
    }

    public void setNextStep(int i) {
        this.nextStep = i;
    }

    public void setNlgId(String str) {
        this.nlgId = str;
    }

    public void setSlots(Map<String, String> map) {
        this.slots = map;
    }

    public void setSource(int i) {
        this.source = i;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTimbre(String str) {
        this.timbre = str;
    }

    public String toString() {
        return "TtsData{text='" + this.text + '\'' + ", emotionType='" + this.emotionType + '\'' + ", nlgId='" + this.nlgId + '\'' + ", functionId='" + this.functionId + '\'' + ", slots=" + this.slots + ", nextStep=" + this.nextStep + ", extra='" + this.extra + '\'' + ", isChatGpt='" + this.isChatGpt + '\'' + ", source='" + this.source + '\'' + '}';
    }
}
