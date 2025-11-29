package com.xjsd.ai.assistant.phone.bean;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Keep
public class OfflineAsrBean {
    private String cmd;
    private String id;
    private int source = 1;
    private String text;
    private int type;

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
        public static final int offline_asr = 1;
        public static final int offline_cmd = 2;
    }

    public String getCmd() {
        return this.cmd;
    }

    public String getId() {
        return this.id;
    }

    public int getSource() {
        return this.source;
    }

    public String getText() {
        return this.text;
    }

    public int getType() {
        return this.type;
    }

    public void setCmd(String str) {
        this.cmd = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setSource(int i) {
        this.source = i;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return "OfflineAsrBean{id='" + this.id + '\'' + ", text='" + this.text + '\'' + ", cmd='" + this.cmd + '\'' + ", type=" + this.type + ", source=" + this.source + '}';
    }
}
