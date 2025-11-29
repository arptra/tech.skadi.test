package com.upuphone.star.core.log.file.clean;

import java.io.File;

public class FileLastModifiedCleanStrategy implements CleanStrategy {

    /* renamed from: a  reason: collision with root package name */
    public long f6451a;

    public FileLastModifiedCleanStrategy(long j) {
        this.f6451a = j;
    }

    public boolean a(File file) {
        return System.currentTimeMillis() - file.lastModified() > this.f6451a;
    }
}
