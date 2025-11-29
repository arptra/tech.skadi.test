package com.here.odnp.util;

public interface ITimeManager {
    long currentTimeMillis();

    long timeSinceBoot();

    long uptimeMillis();
}
