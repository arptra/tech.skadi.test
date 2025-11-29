package com.upuphone.star.core.log.file.flattener;

import com.upuphone.star.core.log.LogLevel;
import com.upuphone.star.core.log.file.LogItem;

public class DefaultFlattener implements Flattener {
    public CharSequence a(LogItem logItem) {
        return Long.toString(logItem.f6449a) + '|' + LogLevel.b(logItem.b) + '|' + logItem.c + '|' + logItem.d;
    }
}
