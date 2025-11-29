package com.upuphone.star.core.log.file.backup;

public abstract class AbstractBackupStrategy implements BackupStrategy {
    public String a(String str, int i) {
        return str + ".bak." + i;
    }
}
