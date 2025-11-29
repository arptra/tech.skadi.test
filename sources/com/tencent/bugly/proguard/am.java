package com.tencent.bugly.proguard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class am {
    public static boolean a(File file, String str, long j, boolean z) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, z));
            BufferedWriter bufferedWriter2 = bufferedWriter;
            boolean a2 = a(bufferedWriter2, str.toCharArray(), str.length(), file.length(), j);
            bufferedWriter.close();
            return a2;
        } catch (Throwable th) {
            al.a(th);
            return false;
        }
    }

    private static List<File> b(String str, final String str2, final String str3, long j) {
        ArrayList arrayList = new ArrayList();
        if (str2 == null || str3 == null) {
            al.d("prefix %s and/or postfix %s is null.", str2, str3);
            return arrayList;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return arrayList;
        }
        try {
            File[] listFiles = file.listFiles(new FilenameFilter() {
                public final boolean accept(File file, String str) {
                    return str != null && str.startsWith(str2) && str.endsWith(str3);
                }
            });
            if (listFiles != null) {
                if (listFiles.length != 0) {
                    return a(listFiles, str2, str3, currentTimeMillis - j);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            al.a(th);
            return arrayList;
        }
    }

    private static boolean a(Writer writer, char[] cArr, int i, long j, long j2) {
        if (j >= j2) {
            return false;
        }
        if (((long) (i * 2)) + j <= j2) {
            try {
                writer.write(cArr, 0, i);
            } catch (IOException e) {
                al.a(e);
                return false;
            }
        } else {
            writer.write(cArr, 0, (int) ((j2 - j) / 2));
        }
        writer.flush();
        return true;
    }

    public static void a(String str, String str2, String str3, long j) {
        try {
            int i = 0;
            for (File next : b(str, str2, str3, j)) {
                al.c("File %s is to be deleted.", next.getName());
                if (next.delete()) {
                    i++;
                }
            }
            al.c("Number of overdue trace files that has deleted: ".concat(String.valueOf(i)), new Object[0]);
        } catch (Throwable th) {
            al.a(th);
        }
    }

    private static List<File> a(File[] fileArr, String str, String str2, long j) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            long a2 = a(file.getName(), str, str2);
            if (a2 >= 0 && 0 <= a2 && a2 <= j) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    public static long a(String str, String str2, String str3) {
        if (str == null) {
            al.d("File name is null.", new Object[0]);
            return -1;
        }
        try {
            if (str.startsWith(str2) && str.endsWith(str3)) {
                return Long.parseLong(str.substring(str2.length(), str.indexOf(str3)));
            }
        } catch (Throwable th) {
            al.a(th);
        }
        return -1;
    }

    public static boolean a(String str, String str2, int i) {
        al.c("rqdp{  sv sd start} %s", str);
        if (str2 != null && str2.trim().length() > 0) {
            File file = new File(str);
            try {
                if (!file.exists()) {
                    if (file.getParentFile() != null) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                long j = (long) i;
                return a(file, str2, j, file.length() < j);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }
}
