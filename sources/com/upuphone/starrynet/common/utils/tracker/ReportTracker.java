package com.upuphone.starrynet.common.utils.tracker;

import java.util.Map;

public interface ReportTracker {
    void report3rdEvent(String str, int i, Map<String, Object> map, String str2, String str3, String str4);

    void reportMap(String str, int i, Map<String, Object> map);
}
