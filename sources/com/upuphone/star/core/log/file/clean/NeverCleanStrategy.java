package com.upuphone.star.core.log.file.clean;

import java.io.File;

public class NeverCleanStrategy implements CleanStrategy {
    public boolean a(File file) {
        return false;
    }
}
