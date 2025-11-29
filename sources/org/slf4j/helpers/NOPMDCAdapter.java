package org.slf4j.helpers;

import java.util.Map;
import org.slf4j.spi.MDCAdapter;

public class NOPMDCAdapter implements MDCAdapter {
    public Map a() {
        return null;
    }

    public void b(Map map) {
    }

    public void clear() {
    }

    public void remove(String str) {
    }
}
