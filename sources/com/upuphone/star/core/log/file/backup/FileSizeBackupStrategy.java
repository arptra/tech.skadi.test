package com.upuphone.star.core.log.file.backup;

import java.io.File;

public class FileSizeBackupStrategy extends AbstractBackupStrategy {

    /* renamed from: a  reason: collision with root package name */
    public long f6450a;
    public int b;

    public FileSizeBackupStrategy(long j, int i) {
        this.f6450a = j;
        this.b = i;
    }

    public int b() {
        return this.b;
    }

    public boolean c(File file) {
        return file.length() > this.f6450a;
    }
}
