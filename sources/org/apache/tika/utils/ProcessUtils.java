package org.apache.tika.utils;

import com.honey.account.oc.c;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ProcessUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap f3342a = new ConcurrentHashMap();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(new c()));
    }

    public static String b(String str) {
        if (str == null || !str.contains(" ") || !SystemUtils.m || str.startsWith("\"") || str.endsWith("\"")) {
            return str;
        }
        return "\"" + str + "\"";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Process} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.tika.utils.FileProcessResult c(java.lang.ProcessBuilder r11, long r12, int r14, int r15) {
        /*
            java.lang.String r0 = "\n"
            r1 = 0
            java.lang.Process r11 = r11.start()     // Catch:{ all -> 0x00c5 }
            java.lang.String r1 = f(r11)     // Catch:{ all -> 0x006f }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x006f }
            org.apache.tika.utils.StreamGobbler r4 = new org.apache.tika.utils.StreamGobbler     // Catch:{ all -> 0x006f }
            java.io.InputStream r5 = r11.getInputStream()     // Catch:{ all -> 0x006f }
            r4.<init>(r5, r14)     // Catch:{ all -> 0x006f }
            org.apache.tika.utils.StreamGobbler r14 = new org.apache.tika.utils.StreamGobbler     // Catch:{ all -> 0x006f }
            java.io.InputStream r5 = r11.getErrorStream()     // Catch:{ all -> 0x006f }
            r14.<init>(r5, r15)     // Catch:{ all -> 0x006f }
            java.lang.Thread r15 = new java.lang.Thread     // Catch:{ all -> 0x006f }
            r15.<init>(r4)     // Catch:{ all -> 0x006f }
            r15.start()     // Catch:{ all -> 0x006f }
            java.lang.Thread r5 = new java.lang.Thread     // Catch:{ all -> 0x006f }
            r5.<init>(r14)     // Catch:{ all -> 0x006f }
            r5.start()     // Catch:{ all -> 0x006f }
            r6 = 0
            r7 = -1
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x007b, all -> 0x004f }
            boolean r6 = r11.waitFor(r12, r9)     // Catch:{ InterruptedException -> 0x007b, all -> 0x004f }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ InterruptedException -> 0x007b, all -> 0x004f }
            long r7 = r12 - r2
            r12 = 1000(0x3e8, double:4.94E-321)
            if (r6 == 0) goto L_0x0051
            int r2 = r11.exitValue()     // Catch:{ InterruptedException -> 0x007b, all -> 0x004f }
            r15.join(r12)     // Catch:{ InterruptedException -> 0x007b, all -> 0x004f }
            r5.join(r12)     // Catch:{ InterruptedException -> 0x007b, all -> 0x004f }
            goto L_0x0068
        L_0x004f:
            r12 = move-exception
            goto L_0x0074
        L_0x0051:
            r11.destroyForcibly()     // Catch:{ InterruptedException -> 0x007b, all -> 0x004f }
            r15.join(r12)     // Catch:{ InterruptedException -> 0x007b, all -> 0x004f }
            r5.join(r12)     // Catch:{ InterruptedException -> 0x007b, all -> 0x004f }
            r12 = 500(0x1f4, double:2.47E-321)
            boolean r12 = r11.waitFor(r12, r9)     // Catch:{ InterruptedException -> 0x007b, all -> 0x004f }
            if (r12 == 0) goto L_0x0067
            int r2 = r11.exitValue()     // Catch:{ IllegalThreadStateException -> 0x0067 }
            goto L_0x0068
        L_0x0067:
            r2 = -1
        L_0x0068:
            r15.interrupt()     // Catch:{ all -> 0x006f }
            r5.interrupt()     // Catch:{ all -> 0x006f }
            goto L_0x0083
        L_0x006f:
            r12 = move-exception
            r10 = r1
            r1 = r11
            r11 = r10
            goto L_0x00c7
        L_0x0074:
            r15.interrupt()     // Catch:{ all -> 0x006f }
            r5.interrupt()     // Catch:{ all -> 0x006f }
            throw r12     // Catch:{ all -> 0x006f }
        L_0x007b:
            r15.interrupt()     // Catch:{ all -> 0x006f }
            r5.interrupt()     // Catch:{ all -> 0x006f }
            r2 = -1000(0xfffffffffffffc18, float:NaN)
        L_0x0083:
            org.apache.tika.utils.FileProcessResult r12 = new org.apache.tika.utils.FileProcessResult     // Catch:{ all -> 0x006f }
            r12.<init>()     // Catch:{ all -> 0x006f }
            r12.d = r7     // Catch:{ all -> 0x006f }
            long r7 = r14.c()     // Catch:{ all -> 0x006f }
            r12.g = r7     // Catch:{ all -> 0x006f }
            long r7 = r4.c()     // Catch:{ all -> 0x006f }
            r12.f = r7     // Catch:{ all -> 0x006f }
            r13 = r6 ^ 1
            r12.e = r13     // Catch:{ all -> 0x006f }
            r12.c = r2     // Catch:{ all -> 0x006f }
            java.util.List r13 = r4.b()     // Catch:{ all -> 0x006f }
            java.lang.String r13 = org.apache.tika.utils.StringUtils.c(r0, r13)     // Catch:{ all -> 0x006f }
            r12.b = r13     // Catch:{ all -> 0x006f }
            java.util.List r13 = r14.b()     // Catch:{ all -> 0x006f }
            java.lang.String r13 = org.apache.tika.utils.StringUtils.c(r0, r13)     // Catch:{ all -> 0x006f }
            r12.f3340a = r13     // Catch:{ all -> 0x006f }
            boolean r13 = r4.a()     // Catch:{ all -> 0x006f }
            r12.i = r13     // Catch:{ all -> 0x006f }
            boolean r13 = r14.a()     // Catch:{ all -> 0x006f }
            r12.h = r13     // Catch:{ all -> 0x006f }
            r11.destroyForcibly()
            if (r1 == 0) goto L_0x00c4
            g(r1)
        L_0x00c4:
            return r12
        L_0x00c5:
            r12 = move-exception
            r11 = r1
        L_0x00c7:
            if (r1 == 0) goto L_0x00cc
            r1.destroyForcibly()
        L_0x00cc:
            if (r11 == 0) goto L_0x00d1
            g(r11)
        L_0x00d1:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.utils.ProcessUtils.c(java.lang.ProcessBuilder, long, int, int):org.apache.tika.utils.FileProcessResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r0v10, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r10v15 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.tika.utils.FileProcessResult d(java.lang.ProcessBuilder r9, long r10, java.nio.file.Path r12, int r13) {
        /*
            java.nio.file.Path r0 = r12.getParent()
            r1 = 0
            java.nio.file.LinkOption[] r2 = new java.nio.file.LinkOption[r1]
            boolean r0 = java.nio.file.Files.isDirectory(r0, r2)
            if (r0 != 0) goto L_0x0016
            java.nio.file.Path r0 = r12.getParent()
            java.nio.file.attribute.FileAttribute[] r2 = new java.nio.file.attribute.FileAttribute[r1]
            java.nio.file.Files.createDirectories(r0, r2)
        L_0x0016:
            java.io.File r0 = r12.toFile()
            r9.redirectOutput(r0)
            r0 = 0
            java.lang.Process r9 = r9.start()     // Catch:{ all -> 0x009c }
            java.lang.String r0 = f(r9)     // Catch:{ all -> 0x0054 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0054 }
            org.apache.tika.utils.StreamGobbler r4 = new org.apache.tika.utils.StreamGobbler     // Catch:{ all -> 0x0054 }
            java.io.InputStream r5 = r9.getErrorStream()     // Catch:{ all -> 0x0054 }
            r4.<init>(r5, r13)     // Catch:{ all -> 0x0054 }
            java.lang.Thread r13 = new java.lang.Thread     // Catch:{ all -> 0x0054 }
            r13.<init>(r4)     // Catch:{ all -> 0x0054 }
            r13.start()     // Catch:{ all -> 0x0054 }
            r5 = -1
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0061 }
            boolean r10 = r9.waitFor(r10, r7)     // Catch:{ InterruptedException -> 0x0061 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ InterruptedException -> 0x0062 }
            long r5 = r5 - r2
            r2 = 1000(0x3e8, double:4.94E-321)
            if (r10 == 0) goto L_0x0059
            int r11 = r9.exitValue()     // Catch:{ InterruptedException -> 0x0062 }
            r13.join(r2)     // Catch:{ InterruptedException -> 0x0062 }
            goto L_0x0064
        L_0x0054:
            r10 = move-exception
            r8 = r0
            r0 = r9
            r9 = r8
            goto L_0x009e
        L_0x0059:
            r9.destroyForcibly()     // Catch:{ InterruptedException -> 0x0062 }
            r13.join(r2)     // Catch:{ InterruptedException -> 0x0062 }
            r11 = -1
            goto L_0x0064
        L_0x0061:
            r10 = r1
        L_0x0062:
            r11 = -1000(0xfffffffffffffc18, float:NaN)
        L_0x0064:
            org.apache.tika.utils.FileProcessResult r13 = new org.apache.tika.utils.FileProcessResult     // Catch:{ all -> 0x0054 }
            r13.<init>()     // Catch:{ all -> 0x0054 }
            r13.d = r5     // Catch:{ all -> 0x0054 }
            long r2 = r4.c()     // Catch:{ all -> 0x0054 }
            r13.g = r2     // Catch:{ all -> 0x0054 }
            long r2 = java.nio.file.Files.size(r12)     // Catch:{ all -> 0x0054 }
            r13.f = r2     // Catch:{ all -> 0x0054 }
            r10 = r10 ^ 1
            r13.e = r10     // Catch:{ all -> 0x0054 }
            r13.c = r11     // Catch:{ all -> 0x0054 }
            java.lang.String r10 = ""
            r13.b = r10     // Catch:{ all -> 0x0054 }
            java.lang.String r10 = "\n"
            java.util.List r11 = r4.b()     // Catch:{ all -> 0x0054 }
            java.lang.String r10 = org.apache.tika.utils.StringUtils.c(r10, r11)     // Catch:{ all -> 0x0054 }
            r13.f3340a = r10     // Catch:{ all -> 0x0054 }
            r13.i = r1     // Catch:{ all -> 0x0054 }
            boolean r10 = r4.a()     // Catch:{ all -> 0x0054 }
            r13.h = r10     // Catch:{ all -> 0x0054 }
            r9.destroyForcibly()
            g(r0)
            return r13
        L_0x009c:
            r10 = move-exception
            r9 = r0
        L_0x009e:
            if (r0 == 0) goto L_0x00a3
            r0.destroyForcibly()
        L_0x00a3:
            g(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.utils.ProcessUtils.d(java.lang.ProcessBuilder, long, java.nio.file.Path, int):org.apache.tika.utils.FileProcessResult");
    }

    public static String f(Process process) {
        String uuid = UUID.randomUUID().toString();
        f3342a.put(uuid, process);
        return uuid;
    }

    public static Process g(String str) {
        return (Process) f3342a.remove(str);
    }
}
