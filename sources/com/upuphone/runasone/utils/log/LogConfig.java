package com.upuphone.runasone.utils.log;

public class LogConfig {
    private int logLevel;
    private String tag;

    public int getLogLevel() {
        return this.logLevel;
    }

    public String getTag() {
        return this.tag;
    }

    public LogConfig setLogLevel(int i) {
        this.logLevel = i;
        return this;
    }

    public LogConfig setTag(String str) {
        this.tag = str;
        return this;
    }
}
