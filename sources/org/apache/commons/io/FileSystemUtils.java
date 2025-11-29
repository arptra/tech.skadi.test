package org.apache.commons.io;

import com.meizu.common.util.LunarCalendar;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

@Deprecated
public class FileSystemUtils {
    private static final String DF;
    private static final int INIT_PROBLEM = -1;
    private static final FileSystemUtils INSTANCE = new FileSystemUtils();
    private static final int OS;
    private static final int OTHER = 0;
    private static final int POSIX_UNIX = 3;
    private static final int UNIX = 2;
    private static final int WINDOWS = 1;

    static {
        int i;
        String str = "df";
        try {
            String property = System.getProperty("os.name");
            if (property != null) {
                String lowerCase = property.toLowerCase(Locale.ENGLISH);
                if (lowerCase.contains("windows")) {
                    i = 1;
                } else {
                    if (!lowerCase.contains("linux") && !lowerCase.contains("mpe/ix") && !lowerCase.contains("freebsd") && !lowerCase.contains("openbsd") && !lowerCase.contains("irix") && !lowerCase.contains("digital unix") && !lowerCase.contains("unix")) {
                        if (!lowerCase.contains("mac os x")) {
                            if (!lowerCase.contains("sun os") && !lowerCase.contains("sunos")) {
                                if (!lowerCase.contains("solaris")) {
                                    if (!lowerCase.contains("hp-ux")) {
                                        if (!lowerCase.contains("aix")) {
                                            i = 0;
                                        }
                                    }
                                    i = 3;
                                }
                            }
                            str = "/usr/xpg4/bin/df";
                            i = 3;
                        }
                    }
                    i = 2;
                }
                OS = i;
                DF = str;
                return;
            }
            throw new IOException("os.name not found");
        } catch (Exception unused) {
            i = -1;
        }
    }

    @Deprecated
    public static long freeSpace(String str) throws IOException {
        return INSTANCE.freeSpaceOS(str, OS, false, Duration.ofMillis(-1));
    }

    @Deprecated
    public static long freeSpaceKb(String str) throws IOException {
        return freeSpaceKb(str, -1);
    }

    public long freeSpaceOS(String str, int i, boolean z, Duration duration) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("Path must not be null");
        } else if (i == 0) {
            throw new IllegalStateException("Unsupported operating system");
        } else if (i == 1) {
            long freeSpaceWindows = freeSpaceWindows(str, duration);
            return z ? freeSpaceWindows / 1024 : freeSpaceWindows;
        } else if (i == 2) {
            return freeSpaceUnix(str, z, false, duration);
        } else {
            if (i == 3) {
                return freeSpaceUnix(str, z, true, duration);
            }
            throw new IllegalStateException("Exception caught when determining operating system");
        }
    }

    public long freeSpaceUnix(String str, boolean z, boolean z2, Duration duration) throws IOException {
        if (!str.isEmpty()) {
            String str2 = LunarCalendar.DATE_SEPARATOR;
            if (z) {
                str2 = str2 + "k";
            }
            if (z2) {
                str2 = str2 + "P";
            }
            List<String> performCommand = performCommand(str2.length() > 1 ? new String[]{DF, str2, str} : new String[]{DF, str}, 3, duration);
            if (performCommand.size() >= 2) {
                StringTokenizer stringTokenizer = new StringTokenizer(performCommand.get(1), " ");
                if (stringTokenizer.countTokens() >= 4) {
                    stringTokenizer.nextToken();
                } else if (stringTokenizer.countTokens() != 1 || performCommand.size() < 3) {
                    throw new IOException("Command line '" + DF + "' did not return data as expected for path '" + str + "'- check path is valid");
                } else {
                    stringTokenizer = new StringTokenizer(performCommand.get(2), " ");
                }
                stringTokenizer.nextToken();
                stringTokenizer.nextToken();
                return parseBytes(stringTokenizer.nextToken(), str);
            }
            throw new IOException("Command line '" + DF + "' did not return info as expected for path '" + str + "'- response was " + performCommand);
        }
        throw new IllegalArgumentException("Path must not be empty");
    }

    public long freeSpaceWindows(String str, Duration duration) throws IOException {
        String normalize = FilenameUtils.normalize(str, false);
        if (normalize != null) {
            if (!normalize.isEmpty() && normalize.charAt(0) != '\"') {
                normalize = "\"" + normalize + "\"";
            }
            List<String> performCommand = performCommand(new String[]{"cmd.exe", "/C", "dir /a /-c " + normalize}, Integer.MAX_VALUE, duration);
            for (int size = performCommand.size() + -1; size >= 0; size--) {
                String str2 = performCommand.get(size);
                if (!str2.isEmpty()) {
                    return parseDir(str2, normalize);
                }
            }
            throw new IOException("Command line 'dir /-c' did not return any info for path '" + normalize + "'");
        }
        throw new IllegalArgumentException(str);
    }

    public Process openProcess(String[] strArr) throws IOException {
        return Runtime.getRuntime().exec(strArr);
    }

    public long parseBytes(String str, String str2) throws IOException {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong >= 0) {
                return parseLong;
            }
            throw new IOException("Command line '" + DF + "' did not find free space in response for path '" + str2 + "'- check path is valid");
        } catch (NumberFormatException e) {
            throw new IOException("Command line '" + DF + "' did not return numeric data as expected for path '" + str2 + "'- check path is valid", e);
        }
    }

    public long parseDir(String str, String str2) throws IOException {
        int i;
        int i2;
        int i3;
        int length = str.length();
        while (true) {
            length--;
            i = 0;
            if (length < 0) {
                i2 = 0;
                break;
            } else if (Character.isDigit(str.charAt(length))) {
                i2 = length + 1;
                break;
            }
        }
        while (true) {
            if (length < 0) {
                i3 = 0;
                break;
            }
            char charAt = str.charAt(length);
            if (!Character.isDigit(charAt) && charAt != ',' && charAt != '.') {
                i3 = length + 1;
                break;
            }
            length--;
        }
        if (length >= 0) {
            StringBuilder sb = new StringBuilder(str.substring(i3, i2));
            while (i < sb.length()) {
                if (sb.charAt(i) == ',' || sb.charAt(i) == '.') {
                    sb.deleteCharAt(i);
                    i--;
                }
                i++;
            }
            return parseBytes(sb.toString(), str2);
        }
        throw new IOException("Command line 'dir /-c' did not return valid info for path '" + str2 + "'");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> performCommand(java.lang.String[] r10, int r11, java.time.Duration r12) throws java.io.IOException {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 20
            r0.<init>(r1)
            r1 = 0
            java.lang.Thread r2 = org.apache.commons.io.ThreadMonitor.start(r12)     // Catch:{ InterruptedException -> 0x00f4, all -> 0x00f0 }
            java.lang.Process r9 = r9.openProcess(r10)     // Catch:{ InterruptedException -> 0x00f4, all -> 0x00f0 }
            java.io.InputStream r3 = r9.getInputStream()     // Catch:{ InterruptedException -> 0x00ec, all -> 0x00e7 }
            java.io.OutputStream r4 = r9.getOutputStream()     // Catch:{ InterruptedException -> 0x00e3, all -> 0x00df }
            java.io.InputStream r5 = r9.getErrorStream()     // Catch:{ InterruptedException -> 0x00da, all -> 0x00d5 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ InterruptedException -> 0x0090, all -> 0x008d }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ InterruptedException -> 0x0090, all -> 0x008d }
            java.nio.charset.Charset r8 = java.nio.charset.Charset.defaultCharset()     // Catch:{ InterruptedException -> 0x0090, all -> 0x008d }
            r7.<init>(r3, r8)     // Catch:{ InterruptedException -> 0x0090, all -> 0x008d }
            r6.<init>(r7)     // Catch:{ InterruptedException -> 0x0090, all -> 0x008d }
            java.lang.String r7 = r6.readLine()     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
        L_0x002e:
            if (r7 == 0) goto L_0x0050
            int r8 = r0.size()     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            if (r8 >= r11) goto L_0x0050
            java.util.Locale r8 = java.util.Locale.ENGLISH     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            java.lang.String r7 = r7.toLowerCase(r8)     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            java.lang.String r7 = r7.trim()     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            r0.add(r7)     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            java.lang.String r7 = r6.readLine()     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            goto L_0x002e
        L_0x0048:
            r10 = move-exception
        L_0x0049:
            r1 = r3
            goto L_0x0120
        L_0x004c:
            r11 = move-exception
        L_0x004d:
            r1 = r9
            goto L_0x00f9
        L_0x0050:
            r9.waitFor()     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            org.apache.commons.io.ThreadMonitor.stop(r2)     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            int r11 = r9.exitValue()     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            if (r11 != 0) goto L_0x00ae
            boolean r11 = r0.isEmpty()     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            if (r11 != 0) goto L_0x0093
            r6.close()     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            r3.close()     // Catch:{ InterruptedException -> 0x0090, all -> 0x008d }
            if (r4 == 0) goto L_0x0077
            r4.close()     // Catch:{ InterruptedException -> 0x0073, all -> 0x006f }
            r4 = r1
            goto L_0x0077
        L_0x006f:
            r10 = move-exception
            r6 = r1
            goto L_0x0120
        L_0x0073:
            r11 = move-exception
            r3 = r1
            r6 = r3
            goto L_0x004d
        L_0x0077:
            if (r5 == 0) goto L_0x007d
            r5.close()     // Catch:{ InterruptedException -> 0x0073, all -> 0x006f }
            r5 = r1
        L_0x007d:
            org.apache.commons.io.IOUtils.closeQuietly((java.io.InputStream) r1)
            org.apache.commons.io.IOUtils.closeQuietly((java.io.OutputStream) r4)
            org.apache.commons.io.IOUtils.closeQuietly((java.io.InputStream) r5)
            org.apache.commons.io.IOUtils.closeQuietly((java.io.Reader) r1)
            r9.destroy()
            return r0
        L_0x008d:
            r10 = move-exception
            r6 = r1
            goto L_0x0049
        L_0x0090:
            r11 = move-exception
            r6 = r1
            goto L_0x004d
        L_0x0093:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            r0.<init>()     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            java.lang.String r1 = "Command line did not return any info for command "
            r0.append(r1)     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            java.util.List r1 = java.util.Arrays.asList(r10)     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            r0.append(r1)     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            java.lang.String r0 = r0.toString()     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            r11.<init>(r0)     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            throw r11     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
        L_0x00ae:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            r0.<init>()     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            java.lang.String r1 = "Command line returned OS error code '"
            r0.append(r1)     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            int r1 = r9.exitValue()     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            r0.append(r1)     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            java.lang.String r1 = "' for command "
            r0.append(r1)     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            java.util.List r1 = java.util.Arrays.asList(r10)     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            r0.append(r1)     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            java.lang.String r0 = r0.toString()     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            r11.<init>(r0)     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
            throw r11     // Catch:{ InterruptedException -> 0x004c, all -> 0x0048 }
        L_0x00d5:
            r10 = move-exception
            r5 = r1
        L_0x00d7:
            r6 = r5
            goto L_0x0049
        L_0x00da:
            r11 = move-exception
            r5 = r1
        L_0x00dc:
            r6 = r5
            goto L_0x004d
        L_0x00df:
            r10 = move-exception
            r4 = r1
            r5 = r4
            goto L_0x00d7
        L_0x00e3:
            r11 = move-exception
            r4 = r1
        L_0x00e5:
            r5 = r4
            goto L_0x00dc
        L_0x00e7:
            r10 = move-exception
            r4 = r1
        L_0x00e9:
            r5 = r4
            r6 = r5
            goto L_0x0120
        L_0x00ec:
            r11 = move-exception
            r3 = r1
            r4 = r3
            goto L_0x00e5
        L_0x00f0:
            r10 = move-exception
            r9 = r1
            r4 = r9
            goto L_0x00e9
        L_0x00f4:
            r11 = move-exception
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r5
        L_0x00f9:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x011c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x011c }
            r0.<init>()     // Catch:{ all -> 0x011c }
            java.lang.String r2 = "Command line threw an InterruptedException for command "
            r0.append(r2)     // Catch:{ all -> 0x011c }
            java.util.List r10 = java.util.Arrays.asList(r10)     // Catch:{ all -> 0x011c }
            r0.append(r10)     // Catch:{ all -> 0x011c }
            java.lang.String r10 = " timeout="
            r0.append(r10)     // Catch:{ all -> 0x011c }
            r0.append(r12)     // Catch:{ all -> 0x011c }
            java.lang.String r10 = r0.toString()     // Catch:{ all -> 0x011c }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x011c }
            throw r9     // Catch:{ all -> 0x011c }
        L_0x011c:
            r10 = move-exception
            r9 = r1
            goto L_0x0049
        L_0x0120:
            org.apache.commons.io.IOUtils.closeQuietly((java.io.InputStream) r1)
            org.apache.commons.io.IOUtils.closeQuietly((java.io.OutputStream) r4)
            org.apache.commons.io.IOUtils.closeQuietly((java.io.InputStream) r5)
            org.apache.commons.io.IOUtils.closeQuietly((java.io.Reader) r6)
            if (r9 == 0) goto L_0x0131
            r9.destroy()
        L_0x0131:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileSystemUtils.performCommand(java.lang.String[], int, java.time.Duration):java.util.List");
    }

    @Deprecated
    public static long freeSpaceKb(String str, long j) throws IOException {
        return INSTANCE.freeSpaceOS(str, OS, true, Duration.ofMillis(j));
    }

    @Deprecated
    public static long freeSpaceKb() throws IOException {
        return freeSpaceKb(-1);
    }

    @Deprecated
    public static long freeSpaceKb(long j) throws IOException {
        return freeSpaceKb(new File(".").getAbsolutePath(), j);
    }
}
