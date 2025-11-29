package com.upuphone.starrynet.core.dns;

import com.upuphone.starrynet.common.StLog;

public class NsdLog extends StLog {
    public static NsdLog LOG = new NsdLog("[NsdLog]");

    private NsdLog(String str) {
        super(str);
    }
}
