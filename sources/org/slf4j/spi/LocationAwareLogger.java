package org.slf4j.spi;

import org.slf4j.Logger;
import org.slf4j.Marker;

public interface LocationAwareLogger extends Logger {
    void a(Marker marker, String str, int i, String str2, Object[] objArr, Throwable th);
}
