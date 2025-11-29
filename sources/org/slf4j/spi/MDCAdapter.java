package org.slf4j.spi;

import java.util.Map;

public interface MDCAdapter {
    Map a();

    void b(Map map);

    void clear();

    void remove(String str);
}
