package com.upuphone.runasone.relay.lib.utils.log.file;

public interface ILogWrite {
    public static final String TAG_PREFIX = "[RunAsOneLog]";

    void close();

    void flush();

    void wirte(String str);
}
