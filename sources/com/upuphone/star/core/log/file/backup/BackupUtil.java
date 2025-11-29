package com.upuphone.star.core.log.file.backup;

import java.io.File;

public class BackupUtil {
    public static void a(File file, BackupStrategy backupStrategy) {
        String name = file.getName();
        String parent = file.getParent();
        int b = backupStrategy.b();
        if (b > 0) {
            File file2 = new File(parent, backupStrategy.a(name, b));
            if (file2.exists()) {
                file2.delete();
            }
            for (int i = b - 1; i > 0; i--) {
                File file3 = new File(parent, backupStrategy.a(name, i));
                if (file3.exists()) {
                    file3.renameTo(new File(parent, backupStrategy.a(name, i + 1)));
                }
            }
            file.renameTo(new File(parent, backupStrategy.a(name, 1)));
        } else if (b == 0) {
            for (int i2 = 1; i2 < Integer.MAX_VALUE; i2++) {
                File file4 = new File(parent, backupStrategy.a(name, i2));
                if (!file4.exists()) {
                    file.renameTo(file4);
                    return;
                }
            }
        }
    }
}
