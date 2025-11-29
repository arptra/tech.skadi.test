package com.upuphone.star.core.log.file.flattener;

import com.upuphone.star.core.log.file.LogItem;

public interface Flattener {
    CharSequence a(LogItem logItem);
}
