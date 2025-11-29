package com.upuphone.runasone.host.api;

import java.util.Map;

public interface CoreInitApplication extends InitApplication {
    void initComponents(Map<String, BaseComponent> map);
}
