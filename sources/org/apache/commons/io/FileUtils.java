package org.apache.commons.io;

import com.honey.account.rb.a;
import com.honey.account.rb.b;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.CRC32;
import org.apache.commons.io.file.AccumulatorPathVisitor;
import org.apache.commons.io.file.Counters;
import org.apache.commons.io.file.PathUtils;
import org.apache.commons.io.file.StandardDeleteOption;
import org.apache.commons.io.filefilter.FileEqualsFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

public class FileUtils {
    public static final File[] EMPTY_FILE_ARRAY = new File[0];
    public static final long ONE_EB = 1152921504606846976L;
    public static final BigInteger ONE_EB_BI;
    public static final long ONE_GB = 1073741824;
    public static final BigInteger ONE_GB_BI;
    public static final long ONE_KB = 1024;
    public static final BigInteger ONE_KB_BI;
    public static final long ONE_MB = 1048576;
    public static final BigInteger ONE_MB_BI;
    public static final long ONE_PB = 1125899906842624L;
    public static final BigInteger ONE_PB_BI;
    public static final long ONE_TB = 1099511627776L;
    public static final BigInteger ONE_TB_BI;
    public static final BigInteger ONE_YB;
    public static final BigInteger ONE_ZB;

    static {
        BigInteger valueOf = BigInteger.valueOf(1024);
        ONE_KB_BI = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        ONE_MB_BI = multiply;
        BigInteger multiply2 = valueOf.multiply(multiply);
        ONE_GB_BI = multiply2;
        BigInteger multiply3 = valueOf.multiply(multiply2);
        ONE_TB_BI = multiply3;
        BigInteger multiply4 = valueOf.multiply(multiply3);
        ONE_PB_BI = multiply4;
        ONE_EB_BI = valueOf.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(ONE_EB));
        ONE_ZB = multiply5;
        ONE_YB = valueOf.multiply(multiply5);
    }

    private static CopyOption[] addCopyAttributes(CopyOption... copyOptionArr) {
        CopyOption[] copyOptionArr2 = (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length + 1);
        Arrays.sort(copyOptionArr2, 0, copyOptionArr.length);
        int length = copyOptionArr.length;
        StandardCopyOption standardCopyOption = StandardCopyOption.COPY_ATTRIBUTES;
        if (Arrays.binarySearch(copyOptionArr, 0, length, standardCopyOption) >= 0) {
            return copyOptionArr;
        }
        copyOptionArr2[copyOptionArr2.length - 1] = standardCopyOption;
        return copyOptionArr2;
    }

    public static String byteCountToDisplaySize(BigInteger bigInteger) {
        Objects.requireNonNull(bigInteger, "size");
        BigInteger bigInteger2 = ONE_EB_BI;
        BigInteger divide = bigInteger.divide(bigInteger2);
        BigInteger bigInteger3 = BigInteger.ZERO;
        if (divide.compareTo(bigInteger3) > 0) {
            return bigInteger.divide(bigInteger2) + " EB";
        }
        BigInteger bigInteger4 = ONE_PB_BI;
        if (bigInteger.divide(bigInteger4).compareTo(bigInteger3) > 0) {
            return bigInteger.divide(bigInteger4) + " PB";
        }
        BigInteger bigInteger5 = ONE_TB_BI;
        if (bigInteger.divide(bigInteger5).compareTo(bigInteger3) > 0) {
            return bigInteger.divide(bigInteger5) + " TB";
        }
        BigInteger bigInteger6 = ONE_GB_BI;
        if (bigInteger.divide(bigInteger6).compareTo(bigInteger3) > 0) {
            return bigInteger.divide(bigInteger6) + " GB";
        }
        BigInteger bigInteger7 = ONE_MB_BI;
        if (bigInteger.divide(bigInteger7).compareTo(bigInteger3) > 0) {
            return bigInteger.divide(bigInteger7) + " MB";
        }
        BigInteger bigInteger8 = ONE_KB_BI;
        if (bigInteger.divide(bigInteger8).compareTo(bigInteger3) > 0) {
            return bigInteger.divide(bigInteger8) + " KB";
        }
        return bigInteger + " bytes";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r3 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.zip.Checksum checksum(java.io.File r2, java.util.zip.Checksum r3) throws java.io.IOException {
        /*
            java.lang.String r0 = "file"
            requireExistsChecked(r2, r0)
            requireFile(r2, r0)
            java.lang.String r0 = "checksum"
            java.util.Objects.requireNonNull(r3, r0)
            java.util.zip.CheckedInputStream r0 = new java.util.zip.CheckedInputStream
            java.nio.file.Path r2 = r2.toPath()
            r1 = 0
            java.nio.file.OpenOption[] r1 = new java.nio.file.OpenOption[r1]
            java.io.InputStream r2 = java.nio.file.Files.newInputStream(r2, r1)
            r0.<init>(r2, r3)
            org.apache.commons.io.IOUtils.consume(r0)     // Catch:{ all -> 0x0024 }
            r0.close()
            return r3
        L_0x0024:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0026 }
        L_0x0026:
            r3 = move-exception
            r0.close()     // Catch:{ all -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r0 = move-exception
            r2.addSuppressed(r0)
        L_0x002f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.checksum(java.io.File, java.util.zip.Checksum):java.util.zip.Checksum");
    }

    public static long checksumCRC32(File file) throws IOException {
        return checksum(file, new CRC32()).getValue();
    }

    public static void cleanDirectory(File file) throws IOException {
        File[] listFiles = listFiles(file, (FileFilter) null);
        ArrayList arrayList = new ArrayList();
        for (File forceDelete : listFiles) {
            try {
                forceDelete(forceDelete);
            } catch (IOException e) {
                arrayList.add(e);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new IOExceptionList(file.toString(), arrayList);
        }
    }

    private static void cleanDirectoryOnExit(File file) throws IOException {
        File[] listFiles = listFiles(file, (FileFilter) null);
        ArrayList arrayList = new ArrayList();
        for (File forceDeleteOnExit : listFiles) {
            try {
                forceDeleteOnExit(forceDeleteOnExit);
            } catch (IOException e) {
                arrayList.add(e);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new IOExceptionList(arrayList);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0069, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006a, code lost:
        if (r7 != null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0070, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r0.addSuppressed(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0074, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0076, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0077, code lost:
        if (r6 != null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x007d, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x007e, code lost:
        r7.addSuppressed(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0081, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean contentEquals(java.io.File r6, java.io.File r7) throws java.io.IOException {
        /*
            r0 = 1
            if (r6 != 0) goto L_0x0006
            if (r7 != 0) goto L_0x0006
            return r0
        L_0x0006:
            r1 = 0
            if (r6 == 0) goto L_0x0082
            if (r7 != 0) goto L_0x000d
            goto L_0x0082
        L_0x000d:
            boolean r2 = r6.exists()
            boolean r3 = r7.exists()
            if (r2 == r3) goto L_0x0018
            return r1
        L_0x0018:
            if (r2 != 0) goto L_0x001b
            return r0
        L_0x001b:
            java.lang.String r2 = "file1"
            requireFile(r6, r2)
            java.lang.String r2 = "file2"
            requireFile(r7, r2)
            long r2 = r6.length()
            long r4 = r7.length()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0032
            return r1
        L_0x0032:
            java.io.File r2 = r6.getCanonicalFile()
            java.io.File r3 = r7.getCanonicalFile()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0041
            return r0
        L_0x0041:
            java.nio.file.Path r6 = r6.toPath()
            java.nio.file.OpenOption[] r0 = new java.nio.file.OpenOption[r1]
            java.io.InputStream r6 = java.nio.file.Files.newInputStream(r6, r0)
            java.nio.file.Path r7 = r7.toPath()     // Catch:{ all -> 0x005f }
            java.nio.file.OpenOption[] r0 = new java.nio.file.OpenOption[r1]     // Catch:{ all -> 0x005f }
            java.io.InputStream r7 = java.nio.file.Files.newInputStream(r7, r0)     // Catch:{ all -> 0x005f }
            boolean r0 = org.apache.commons.io.IOUtils.contentEquals((java.io.InputStream) r6, (java.io.InputStream) r7)     // Catch:{ all -> 0x0067 }
            if (r7 == 0) goto L_0x0061
            r7.close()     // Catch:{ all -> 0x005f }
            goto L_0x0061
        L_0x005f:
            r7 = move-exception
            goto L_0x0075
        L_0x0061:
            if (r6 == 0) goto L_0x0066
            r6.close()
        L_0x0066:
            return r0
        L_0x0067:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r1 = move-exception
            if (r7 == 0) goto L_0x0074
            r7.close()     // Catch:{ all -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r7 = move-exception
            r0.addSuppressed(r7)     // Catch:{ all -> 0x005f }
        L_0x0074:
            throw r1     // Catch:{ all -> 0x005f }
        L_0x0075:
            throw r7     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r0 = move-exception
            if (r6 == 0) goto L_0x0081
            r6.close()     // Catch:{ all -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r6 = move-exception
            r7.addSuppressed(r6)
        L_0x0081:
            throw r0
        L_0x0082:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.contentEquals(java.io.File, java.io.File):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0064, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0069, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r5.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006d, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0074, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0075, code lost:
        r4.addSuppressed(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0078, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean contentEqualsIgnoreEOL(java.io.File r4, java.io.File r5, java.lang.String r6) throws java.io.IOException {
        /*
            r0 = 1
            if (r4 != 0) goto L_0x0006
            if (r5 != 0) goto L_0x0006
            return r0
        L_0x0006:
            r1 = 0
            if (r4 == 0) goto L_0x0079
            if (r5 != 0) goto L_0x000c
            goto L_0x0079
        L_0x000c:
            boolean r2 = r4.exists()
            boolean r3 = r5.exists()
            if (r2 == r3) goto L_0x0017
            return r1
        L_0x0017:
            if (r2 != 0) goto L_0x001a
            return r0
        L_0x001a:
            java.lang.String r2 = "file1"
            requireFile(r4, r2)
            java.lang.String r2 = "file2"
            requireFile(r5, r2)
            java.io.File r2 = r4.getCanonicalFile()
            java.io.File r3 = r5.getCanonicalFile()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0033
            return r0
        L_0x0033:
            java.nio.charset.Charset r6 = org.apache.commons.io.Charsets.toCharset((java.lang.String) r6)
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            java.nio.file.Path r4 = r4.toPath()
            java.nio.file.OpenOption[] r2 = new java.nio.file.OpenOption[r1]
            java.io.InputStream r4 = java.nio.file.Files.newInputStream(r4, r2)
            r0.<init>(r4, r6)
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x0060 }
            java.nio.file.Path r5 = r5.toPath()     // Catch:{ all -> 0x0060 }
            java.nio.file.OpenOption[] r1 = new java.nio.file.OpenOption[r1]     // Catch:{ all -> 0x0060 }
            java.io.InputStream r5 = java.nio.file.Files.newInputStream(r5, r1)     // Catch:{ all -> 0x0060 }
            r4.<init>(r5, r6)     // Catch:{ all -> 0x0060 }
            boolean r5 = org.apache.commons.io.IOUtils.contentEqualsIgnoreEOL(r0, r4)     // Catch:{ all -> 0x0062 }
            r4.close()     // Catch:{ all -> 0x0060 }
            r0.close()
            return r5
        L_0x0060:
            r4 = move-exception
            goto L_0x006e
        L_0x0062:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r6 = move-exception
            r4.close()     // Catch:{ all -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r4 = move-exception
            r5.addSuppressed(r4)     // Catch:{ all -> 0x0060 }
        L_0x006d:
            throw r6     // Catch:{ all -> 0x0060 }
        L_0x006e:
            throw r4     // Catch:{ all -> 0x006f }
        L_0x006f:
            r5 = move-exception
            r0.close()     // Catch:{ all -> 0x0074 }
            goto L_0x0078
        L_0x0074:
            r6 = move-exception
            r4.addSuppressed(r6)
        L_0x0078:
            throw r5
        L_0x0079:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(java.io.File, java.io.File, java.lang.String):boolean");
    }

    public static File[] convertFileCollectionToFileArray(Collection<File> collection) {
        return (File[]) collection.toArray(EMPTY_FILE_ARRAY);
    }

    public static void copyDirectory(File file, File file2) throws IOException {
        copyDirectory(file, file2, true);
    }

    public static void copyDirectoryToDirectory(File file, File file2) throws IOException {
        requireDirectoryIfExists(file, "sourceDir");
        requireDirectoryIfExists(file2, "destinationDir");
        copyDirectory(file, new File(file2, file.getName()), true);
    }

    public static void copyFile(File file, File file2) throws IOException {
        copyFile(file, file2, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void copyFileToDirectory(File file, File file2) throws IOException {
        copyFileToDirectory(file, file2, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        r2.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000c, code lost:
        if (r1 != null) goto L_0x000e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyInputStreamToFile(java.io.InputStream r1, java.io.File r2) throws java.io.IOException {
        /*
            copyToFile(r1, r2)     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x0008
            r1.close()
        L_0x0008:
            return
        L_0x0009:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x000b }
        L_0x000b:
            r0 = move-exception
            if (r1 == 0) goto L_0x0016
            r1.close()     // Catch:{ all -> 0x0012 }
            goto L_0x0016
        L_0x0012:
            r1 = move-exception
            r2.addSuppressed(r1)
        L_0x0016:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.copyInputStreamToFile(java.io.InputStream, java.io.File):void");
    }

    public static void copyToDirectory(File file, File file2) throws IOException {
        Objects.requireNonNull(file, "sourceFile");
        if (file.isFile()) {
            copyFileToDirectory(file, file2);
        } else if (file.isDirectory()) {
            copyDirectoryToDirectory(file, file2);
        } else {
            throw new FileNotFoundException("The source " + file + " does not exist");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r1.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        if (r2 != null) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyToFile(java.io.InputStream r1, java.io.File r2) throws java.io.IOException {
        /*
            java.io.FileOutputStream r2 = openOutputStream(r2)
            org.apache.commons.io.IOUtils.copy((java.io.InputStream) r1, (java.io.OutputStream) r2)     // Catch:{ all -> 0x000d }
            if (r2 == 0) goto L_0x000c
            r2.close()
        L_0x000c:
            return
        L_0x000d:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x000f }
        L_0x000f:
            r0 = move-exception
            if (r2 == 0) goto L_0x001a
            r2.close()     // Catch:{ all -> 0x0016 }
            goto L_0x001a
        L_0x0016:
            r2 = move-exception
            r1.addSuppressed(r2)
        L_0x001a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.copyToFile(java.io.InputStream, java.io.File):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r2.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        if (r1 != null) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyURLToFile(java.net.URL r1, java.io.File r2) throws java.io.IOException {
        /*
            java.io.InputStream r1 = r1.openStream()
            copyInputStreamToFile(r1, r2)     // Catch:{ all -> 0x000d }
            if (r1 == 0) goto L_0x000c
            r1.close()
        L_0x000c:
            return
        L_0x000d:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x000f }
        L_0x000f:
            r0 = move-exception
            if (r1 == 0) goto L_0x001a
            r1.close()     // Catch:{ all -> 0x0016 }
            goto L_0x001a
        L_0x0016:
            r1 = move-exception
            r2.addSuppressed(r1)
        L_0x001a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.copyURLToFile(java.net.URL, java.io.File):void");
    }

    public static File createParentDirectories(File file) throws IOException {
        return mkdirs(getParentFile(file));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
        if (r3.position() > 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        r3.flip();
        r2.append(java.nio.charset.StandardCharsets.UTF_8.decode(r3).toString());
        r3.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0075, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007c, code lost:
        r3.flip();
        r2.append(java.nio.charset.StandardCharsets.UTF_8.decode(r3).toString());
        r3.clear();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d A[ExcHandler: all (r8v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:8:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String decodeUrl(java.lang.String r8) {
        /*
            if (r8 == 0) goto L_0x009f
            r0 = 37
            int r1 = r8.indexOf(r0)
            if (r1 < 0) goto L_0x009f
            int r1 = r8.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r1)
            r4 = 0
        L_0x0018:
            if (r4 >= r1) goto L_0x009b
            char r5 = r8.charAt(r4)
            if (r5 != r0) goto L_0x008f
        L_0x0020:
            int r5 = r4 + 1
            int r6 = r4 + 3
            java.lang.String r5 = r8.substring(r5, r6)     // Catch:{ RuntimeException -> 0x0076, all -> 0x003d }
            r7 = 16
            int r5 = java.lang.Integer.parseInt(r5, r7)     // Catch:{ RuntimeException -> 0x0076, all -> 0x003d }
            byte r5 = (byte) r5     // Catch:{ RuntimeException -> 0x0076, all -> 0x003d }
            r3.put(r5)     // Catch:{ RuntimeException -> 0x0076, all -> 0x003d }
            if (r6 >= r1) goto L_0x0041
            char r4 = r8.charAt(r6)     // Catch:{ RuntimeException -> 0x003f, all -> 0x003d }
            if (r4 == r0) goto L_0x003b
            goto L_0x0041
        L_0x003b:
            r4 = r6
            goto L_0x0020
        L_0x003d:
            r8 = move-exception
            goto L_0x005c
        L_0x003f:
            r4 = r6
            goto L_0x0076
        L_0x0041:
            int r4 = r3.position()
            if (r4 <= 0) goto L_0x005a
            r3.flip()
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8
            java.nio.CharBuffer r4 = r4.decode(r3)
            java.lang.String r4 = r4.toString()
            r2.append(r4)
            r3.clear()
        L_0x005a:
            r4 = r6
            goto L_0x0018
        L_0x005c:
            int r0 = r3.position()
            if (r0 <= 0) goto L_0x0075
            r3.flip()
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8
            java.nio.CharBuffer r0 = r0.decode(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            r3.clear()
        L_0x0075:
            throw r8
        L_0x0076:
            int r5 = r3.position()
            if (r5 <= 0) goto L_0x008f
            r3.flip()
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8
            java.nio.CharBuffer r5 = r5.decode(r3)
            java.lang.String r5 = r5.toString()
            r2.append(r5)
            r3.clear()
        L_0x008f:
            int r5 = r4 + 1
            char r4 = r8.charAt(r4)
            r2.append(r4)
            r4 = r5
            goto L_0x0018
        L_0x009b:
            java.lang.String r8 = r2.toString()
        L_0x009f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.decodeUrl(java.lang.String):java.lang.String");
    }

    public static File delete(File file) throws IOException {
        Objects.requireNonNull(file, "file");
        Files.delete(file.toPath());
        return file;
    }

    public static void deleteDirectory(File file) throws IOException {
        Objects.requireNonNull(file, "directory");
        if (file.exists()) {
            if (!isSymlink(file)) {
                cleanDirectory(file);
            }
            delete(file);
        }
    }

    private static void deleteDirectoryOnExit(File file) throws IOException {
        if (file.exists()) {
            file.deleteOnExit();
            if (!isSymlink(file)) {
                cleanDirectoryOnExit(file);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:3|4|(1:6)|7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean deleteQuietly(java.io.File r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r2.isDirectory()     // Catch:{ Exception -> 0x000d }
            if (r1 == 0) goto L_0x000d
            cleanDirectory(r2)     // Catch:{ Exception -> 0x000d }
        L_0x000d:
            boolean r2 = r2.delete()     // Catch:{ Exception -> 0x0012 }
            return r2
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.deleteQuietly(java.io.File):boolean");
    }

    public static boolean directoryContains(File file, File file2) throws IOException {
        requireDirectoryExists(file, "directory");
        if (file2 != null && file.exists() && file2.exists()) {
            return FilenameUtils.directoryContains(file.getCanonicalPath(), file2.getCanonicalPath());
        }
        return false;
    }

    private static void doCopyDirectory(File file, File file2, FileFilter fileFilter, List<String> list, boolean z, CopyOption... copyOptionArr) throws IOException {
        File[] listFiles = listFiles(file, fileFilter);
        requireDirectoryIfExists(file2, "destDir");
        mkdirs(file2);
        requireCanWrite(file2, "destDir");
        for (File file3 : listFiles) {
            File file4 = new File(file2, file3.getName());
            if (list == null || !list.contains(file3.getCanonicalPath())) {
                if (file3.isDirectory()) {
                    doCopyDirectory(file3, file4, fileFilter, list, z, copyOptionArr);
                } else {
                    copyFile(file3, file4, copyOptionArr);
                }
            }
        }
        if (z) {
            setLastModified(file, file2);
        }
    }

    public static void forceDelete(File file) throws IOException {
        Objects.requireNonNull(file, "file");
        try {
            Counters.PathCounters delete = PathUtils.delete(file.toPath(), PathUtils.EMPTY_LINK_OPTION_ARRAY, StandardDeleteOption.OVERRIDE_READ_ONLY);
            if (delete.getFileCounter().get() < 1 && delete.getDirectoryCounter().get() < 1) {
                throw new FileNotFoundException("File does not exist: " + file);
            }
        } catch (IOException e) {
            throw new IOException("Cannot delete file: " + file, e);
        }
    }

    public static void forceDeleteOnExit(File file) throws IOException {
        Objects.requireNonNull(file, "file");
        if (file.isDirectory()) {
            deleteDirectoryOnExit(file);
        } else {
            file.deleteOnExit();
        }
    }

    public static void forceMkdir(File file) throws IOException {
        mkdirs(file);
    }

    public static void forceMkdirParent(File file) throws IOException {
        Objects.requireNonNull(file, "file");
        File parentFile = getParentFile(file);
        if (parentFile != null) {
            forceMkdir(parentFile);
        }
    }

    public static File getFile(File file, String... strArr) {
        Objects.requireNonNull(file, "directory");
        Objects.requireNonNull(strArr, "names");
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            i++;
            file = new File(file, strArr[i]);
        }
        return file;
    }

    private static File getParentFile(File file) {
        if (file == null) {
            return null;
        }
        return file.getParentFile();
    }

    public static File getTempDirectory() {
        return new File(getTempDirectoryPath());
    }

    public static String getTempDirectoryPath() {
        return System.getProperty("java.io.tmpdir");
    }

    public static File getUserDirectory() {
        return new File(getUserDirectoryPath());
    }

    public static String getUserDirectoryPath() {
        return System.getProperty("user.home");
    }

    public static boolean isDirectory(File file, LinkOption... linkOptionArr) {
        return file != null && Files.isDirectory(file.toPath(), linkOptionArr);
    }

    public static boolean isEmptyDirectory(File file) throws IOException {
        return PathUtils.isEmptyDirectory(file.toPath());
    }

    public static boolean isFileNewer(File file, ChronoLocalDate chronoLocalDate) {
        return isFileNewer(file, chronoLocalDate, LocalTime.now());
    }

    public static boolean isFileOlder(File file, ChronoLocalDate chronoLocalDate) {
        return isFileOlder(file, chronoLocalDate, LocalTime.now());
    }

    public static boolean isRegularFile(File file, LinkOption... linkOptionArr) {
        return file != null && Files.isRegularFile(file.toPath(), linkOptionArr);
    }

    public static boolean isSymlink(File file) {
        return file != null && Files.isSymbolicLink(file.toPath());
    }

    public static Iterator<File> iterateFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFiles(file, iOFileFilter, iOFileFilter2).iterator();
    }

    public static Iterator<File> iterateFilesAndDirs(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFilesAndDirs(file, iOFileFilter, iOFileFilter2).iterator();
    }

    public static long lastModified(File file) throws IOException {
        Path path = file.toPath();
        Objects.requireNonNull(path, "file");
        return Files.getLastModifiedTime(path, new LinkOption[0]).toMillis();
    }

    public static long lastModifiedUnchecked(File file) {
        try {
            return lastModified(file);
        } catch (IOException e) {
            throw new UncheckedIOException(file.toString(), e);
        }
    }

    public static LineIterator lineIterator(File file) throws IOException {
        return lineIterator(file, (String) null);
    }

    private static AccumulatorPathVisitor listAccumulate(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) throws IOException {
        boolean z = iOFileFilter2 != null;
        IOFileFilter fileEqualsFileFilter = new FileEqualsFileFilter(file);
        if (z) {
            fileEqualsFileFilter = fileEqualsFileFilter.or(iOFileFilter2);
        }
        AccumulatorPathVisitor accumulatorPathVisitor = new AccumulatorPathVisitor(Counters.noopPathCounters(), iOFileFilter, fileEqualsFileFilter);
        Files.walkFileTree(file.toPath(), Collections.emptySet(), toMaxDepth(z), accumulatorPathVisitor);
        return accumulatorPathVisitor;
    }

    private static File[] listFiles(File file, FileFilter fileFilter) throws IOException {
        requireDirectoryExists(file, "directory");
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles != null) {
            return listFiles;
        }
        throw new IOException("Unknown I/O error listing contents of directory: " + file);
    }

    public static Collection<File> listFilesAndDirs(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        try {
            AccumulatorPathVisitor listAccumulate = listAccumulate(file, iOFileFilter, iOFileFilter2);
            List<Path> fileList = listAccumulate.getFileList();
            fileList.addAll(listAccumulate.getDirList());
            return (Collection) fileList.stream().map(new a()).collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(file.toString(), e);
        }
    }

    private static File mkdirs(File file) throws IOException {
        if (file == null || file.mkdirs() || file.isDirectory()) {
            return file;
        }
        throw new IOException("Cannot create directory '" + file + "'.");
    }

    public static void moveDirectory(File file, File file2) throws IOException {
        validateMoveParameters(file, file2);
        requireDirectory(file, "srcDir");
        requireAbsent(file2, "destDir");
        if (!file.renameTo(file2)) {
            String canonicalPath = file2.getCanonicalPath();
            if (!canonicalPath.startsWith(file.getCanonicalPath() + File.separator)) {
                copyDirectory(file, file2);
                deleteDirectory(file);
                if (file.exists()) {
                    throw new IOException("Failed to delete original directory '" + file + "' after copy to '" + file2 + "'");
                }
                return;
            }
            throw new IOException("Cannot move directory: " + file + " to a subdirectory of itself: " + file2);
        }
    }

    public static void moveDirectoryToDirectory(File file, File file2, boolean z) throws IOException {
        validateMoveParameters(file, file2);
        if (!file2.isDirectory()) {
            if (file2.exists()) {
                throw new IOException("Destination '" + file2 + "' is not a directory");
            } else if (z) {
                mkdirs(file2);
            } else {
                throw new FileNotFoundException("Destination directory '" + file2 + "' does not exist [createDestDir=" + false + "]");
            }
        }
        moveDirectory(file, new File(file2, file.getName()));
    }

    public static void moveFile(File file, File file2) throws IOException {
        moveFile(file, file2, StandardCopyOption.COPY_ATTRIBUTES);
    }

    public static void moveFileToDirectory(File file, File file2, boolean z) throws IOException {
        validateMoveParameters(file, file2);
        if (!file2.exists() && z) {
            mkdirs(file2);
        }
        requireExistsChecked(file2, "destDir");
        requireDirectory(file2, "destDir");
        moveFile(file, new File(file2, file.getName()));
    }

    public static void moveToDirectory(File file, File file2, boolean z) throws IOException {
        validateMoveParameters(file, file2);
        if (file.isDirectory()) {
            moveDirectoryToDirectory(file, file2, z);
        } else {
            moveFileToDirectory(file, file2, z);
        }
    }

    public static FileInputStream openInputStream(File file) throws IOException {
        Objects.requireNonNull(file, "file");
        return new FileInputStream(file);
    }

    public static FileOutputStream openOutputStream(File file) throws IOException {
        return openOutputStream(file, false);
    }

    public static byte[] readFileToByteArray(File file) throws IOException {
        FileInputStream openInputStream = openInputStream(file);
        try {
            long length = file.length();
            byte[] byteArray = length > 0 ? IOUtils.toByteArray((InputStream) openInputStream, length) : IOUtils.toByteArray((InputStream) openInputStream);
            if (openInputStream != null) {
                openInputStream.close();
            }
            return byteArray;
        } catch (Throwable th) {
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Deprecated
    public static String readFileToString(File file) throws IOException {
        return readFileToString(file, Charset.defaultCharset());
    }

    @Deprecated
    public static List<String> readLines(File file) throws IOException {
        return readLines(file, Charset.defaultCharset());
    }

    private static void requireAbsent(File file, String str) throws FileExistsException {
        if (file.exists()) {
            throw new FileExistsException(String.format("File element in parameter '%s' already exists: '%s'", new Object[]{str, file}));
        }
    }

    private static void requireCanWrite(File file, String str) {
        Objects.requireNonNull(file, "file");
        if (!file.canWrite()) {
            throw new IllegalArgumentException("File parameter '" + str + " is not writable: '" + file + "'");
        }
    }

    private static void requireCanonicalPathsNotEquals(File file, File file2) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        if (canonicalPath.equals(file2.getCanonicalPath())) {
            throw new IllegalArgumentException(String.format("File canonical paths are equal: '%s' (file1='%s', file2='%s')", new Object[]{canonicalPath, file, file2}));
        }
    }

    private static File requireDirectory(File file, String str) {
        Objects.requireNonNull(file, str);
        if (file.isDirectory()) {
            return file;
        }
        throw new IllegalArgumentException("Parameter '" + str + "' is not a directory: '" + file + "'");
    }

    private static File requireDirectoryExists(File file, String str) {
        requireExists(file, str);
        requireDirectory(file, str);
        return file;
    }

    private static File requireDirectoryIfExists(File file, String str) {
        Objects.requireNonNull(file, str);
        if (file.exists()) {
            requireDirectory(file, str);
        }
        return file;
    }

    private static void requireEqualSizes(File file, File file2, long j, long j2) throws IOException {
        if (j != j2) {
            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + j + " Actual: " + j2);
        }
    }

    private static File requireExists(File file, String str) {
        Objects.requireNonNull(file, str);
        if (file.exists()) {
            return file;
        }
        throw new IllegalArgumentException("File system element for parameter '" + str + "' does not exist: '" + file + "'");
    }

    private static File requireExistsChecked(File file, String str) throws FileNotFoundException {
        Objects.requireNonNull(file, str);
        if (file.exists()) {
            return file;
        }
        throw new FileNotFoundException("File system element for parameter '" + str + "' does not exist: '" + file + "'");
    }

    private static File requireFile(File file, String str) {
        Objects.requireNonNull(file, str);
        if (file.isFile()) {
            return file;
        }
        throw new IllegalArgumentException("Parameter '" + str + "' is not a file: " + file);
    }

    private static void requireFileCopy(File file, File file2) throws FileNotFoundException {
        requireExistsChecked(file, "source");
        Objects.requireNonNull(file2, RtspHeaders.Values.DESTINATION);
    }

    private static File requireFileIfExists(File file, String str) {
        Objects.requireNonNull(file, str);
        return file.exists() ? requireFile(file, str) : file;
    }

    private static void setLastModified(File file, File file2) throws IOException {
        Objects.requireNonNull(file, "sourceFile");
        setLastModified(file2, lastModified(file));
    }

    public static long sizeOf(File file) {
        requireExists(file, "file");
        return file.isDirectory() ? sizeOfDirectory0(file) : file.length();
    }

    private static long sizeOf0(File file) {
        Objects.requireNonNull(file, "file");
        return file.isDirectory() ? sizeOfDirectory0(file) : file.length();
    }

    public static BigInteger sizeOfAsBigInteger(File file) {
        requireExists(file, "file");
        return file.isDirectory() ? sizeOfDirectoryBig0(file) : BigInteger.valueOf(file.length());
    }

    private static BigInteger sizeOfBig0(File file) {
        Objects.requireNonNull(file, "fileOrDir");
        return file.isDirectory() ? sizeOfDirectoryBig0(file) : BigInteger.valueOf(file.length());
    }

    public static long sizeOfDirectory(File file) {
        return sizeOfDirectory0(requireDirectoryExists(file, "directory"));
    }

    private static long sizeOfDirectory0(File file) {
        Objects.requireNonNull(file, "directory");
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        long j = 0;
        for (File file2 : listFiles) {
            if (!isSymlink(file2)) {
                j += sizeOf0(file2);
                if (j < 0) {
                    break;
                }
            }
        }
        return j;
    }

    public static BigInteger sizeOfDirectoryAsBigInteger(File file) {
        return sizeOfDirectoryBig0(requireDirectoryExists(file, "directory"));
    }

    private static BigInteger sizeOfDirectoryBig0(File file) {
        Objects.requireNonNull(file, "directory");
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return BigInteger.ZERO;
        }
        BigInteger bigInteger = BigInteger.ZERO;
        for (File file2 : listFiles) {
            if (!isSymlink(file2)) {
                bigInteger = bigInteger.add(sizeOfBig0(file2));
            }
        }
        return bigInteger;
    }

    public static Stream<File> streamFiles(File file, boolean z, String... strArr) throws IOException {
        return PathUtils.walk(file.toPath(), strArr == null ? FileFileFilter.INSTANCE : FileFileFilter.INSTANCE.and(new SuffixFileFilter(toSuffixes(strArr))), toMaxDepth(z), false, FileVisitOption.FOLLOW_LINKS).map(new a());
    }

    public static File toFile(URL url) {
        if (url == null || !"file".equalsIgnoreCase(url.getProtocol())) {
            return null;
        }
        return new File(decodeUrl(url.getFile().replace('/', File.separatorChar)));
    }

    public static File[] toFiles(URL... urlArr) {
        if (IOUtils.length((Object[]) urlArr) == 0) {
            return EMPTY_FILE_ARRAY;
        }
        File[] fileArr = new File[urlArr.length];
        for (int i = 0; i < urlArr.length; i++) {
            URL url = urlArr[i];
            if (url != null) {
                if ("file".equalsIgnoreCase(url.getProtocol())) {
                    fileArr[i] = toFile(url);
                } else {
                    throw new IllegalArgumentException("Can only convert file URL to a File: " + url);
                }
            }
        }
        return fileArr;
    }

    private static List<File> toList(Stream<File> stream) {
        return (List) stream.collect(Collectors.toList());
    }

    private static int toMaxDepth(boolean z) {
        return z ? Integer.MAX_VALUE : 1;
    }

    private static String[] toSuffixes(String... strArr) {
        Objects.requireNonNull(strArr, "extensions");
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = "." + strArr[i];
        }
        return strArr2;
    }

    public static URL[] toURLs(File... fileArr) throws IOException {
        Objects.requireNonNull(fileArr, "files");
        int length = fileArr.length;
        URL[] urlArr = new URL[length];
        for (int i = 0; i < length; i++) {
            urlArr[i] = fileArr[i].toURI().toURL();
        }
        return urlArr;
    }

    public static void touch(File file) throws IOException {
        Objects.requireNonNull(file, "file");
        if (!file.exists()) {
            openOutputStream(file).close();
        }
        setLastModified(file, System.currentTimeMillis());
    }

    private static void validateMoveParameters(File file, File file2) throws FileNotFoundException {
        Objects.requireNonNull(file, "source");
        Objects.requireNonNull(file2, RtspHeaders.Values.DESTINATION);
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
    }

    public static boolean waitFor(File file, int i) {
        Objects.requireNonNull(file, "file");
        long currentTimeMillis = System.currentTimeMillis() + (((long) i) * 1000);
        boolean z = false;
        while (!file.exists()) {
            try {
                long currentTimeMillis2 = currentTimeMillis - System.currentTimeMillis();
                if (currentTimeMillis2 < 0) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                }
                try {
                    Thread.sleep(Math.min(100, currentTimeMillis2));
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Exception unused2) {
                }
            } finally {
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return true;
    }

    @Deprecated
    public static void write(File file, CharSequence charSequence) throws IOException {
        write(file, charSequence, Charset.defaultCharset(), false);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr) throws IOException {
        writeByteArrayToFile(file, bArr, false);
    }

    public static void writeLines(File file, Collection<?> collection) throws IOException {
        writeLines(file, (String) null, collection, (String) null, false);
    }

    @Deprecated
    public static void writeStringToFile(File file, String str) throws IOException {
        writeStringToFile(file, str, Charset.defaultCharset(), false);
    }

    public static void copyDirectory(File file, File file2, boolean z) throws IOException {
        copyDirectory(file, file2, (FileFilter) null, z);
    }

    public static void copyFile(File file, File file2, boolean z) throws IOException {
        copyFile(file, file2, z ? new CopyOption[]{StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING} : new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
    }

    public static void copyFileToDirectory(File file, File file2, boolean z) throws IOException {
        Objects.requireNonNull(file, "sourceFile");
        requireDirectoryIfExists(file2, "destinationDir");
        copyFile(file, new File(file2, file.getName()), z);
    }

    public static boolean isFileNewer(File file, ChronoLocalDate chronoLocalDate, LocalTime localTime) {
        Objects.requireNonNull(chronoLocalDate, "chronoLocalDate");
        Objects.requireNonNull(localTime, "localTime");
        return isFileNewer(file, chronoLocalDate.atTime(localTime));
    }

    public static boolean isFileOlder(File file, ChronoLocalDate chronoLocalDate, LocalTime localTime) {
        Objects.requireNonNull(chronoLocalDate, "chronoLocalDate");
        Objects.requireNonNull(localTime, "localTime");
        return isFileOlder(file, chronoLocalDate.atTime(localTime));
    }

    public static Iterator<File> iterateFiles(File file, String[] strArr, boolean z) {
        try {
            return StreamIterator.iterator(streamFiles(file, z, strArr));
        } catch (IOException e) {
            throw new UncheckedIOException(file.toString(), e);
        }
    }

    public static LineIterator lineIterator(File file, String str) throws IOException {
        try {
            return IOUtils.lineIterator((InputStream) openInputStream(file), str);
        } catch (IOException | RuntimeException e) {
            IOUtils.closeQuietly((Closeable) null, new b(e));
            throw e;
        }
    }

    public static void moveFile(File file, File file2, CopyOption... copyOptionArr) throws IOException {
        validateMoveParameters(file, file2);
        requireFile(file, "srcFile");
        requireAbsent(file2, (String) null);
        if (!file.renameTo(file2)) {
            copyFile(file, file2, copyOptionArr);
            if (!file.delete()) {
                deleteQuietly(file2);
                throw new IOException("Failed to delete original file '" + file + "' after copy to '" + file2 + "'");
            }
        }
    }

    public static FileOutputStream openOutputStream(File file, boolean z) throws IOException {
        Objects.requireNonNull(file, "file");
        if (file.exists()) {
            requireFile(file, "file");
            requireCanWrite(file, "file");
        } else {
            createParentDirectories(file);
        }
        return new FileOutputStream(file, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        if (r1 != null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
        r2.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readFileToString(java.io.File r1, java.nio.charset.Charset r2) throws java.io.IOException {
        /*
            java.io.FileInputStream r1 = openInputStream(r1)
            java.nio.charset.Charset r2 = org.apache.commons.io.Charsets.toCharset((java.nio.charset.Charset) r2)     // Catch:{ all -> 0x0012 }
            java.lang.String r2 = org.apache.commons.io.IOUtils.toString((java.io.InputStream) r1, (java.nio.charset.Charset) r2)     // Catch:{ all -> 0x0012 }
            if (r1 == 0) goto L_0x0011
            r1.close()
        L_0x0011:
            return r2
        L_0x0012:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0014 }
        L_0x0014:
            r0 = move-exception
            if (r1 == 0) goto L_0x001f
            r1.close()     // Catch:{ all -> 0x001b }
            goto L_0x001f
        L_0x001b:
            r1 = move-exception
            r2.addSuppressed(r1)
        L_0x001f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.readFileToString(java.io.File, java.nio.charset.Charset):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        if (r1 != null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
        r2.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> readLines(java.io.File r1, java.nio.charset.Charset r2) throws java.io.IOException {
        /*
            java.io.FileInputStream r1 = openInputStream(r1)
            java.nio.charset.Charset r2 = org.apache.commons.io.Charsets.toCharset((java.nio.charset.Charset) r2)     // Catch:{ all -> 0x0012 }
            java.util.List r2 = org.apache.commons.io.IOUtils.readLines((java.io.InputStream) r1, (java.nio.charset.Charset) r2)     // Catch:{ all -> 0x0012 }
            if (r1 == 0) goto L_0x0011
            r1.close()
        L_0x0011:
            return r2
        L_0x0012:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0014 }
        L_0x0014:
            r0 = move-exception
            if (r1 == 0) goto L_0x001f
            r1.close()     // Catch:{ all -> 0x001b }
            goto L_0x001f
        L_0x001b:
            r1 = move-exception
            r2.addSuppressed(r1)
        L_0x001f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.readLines(java.io.File, java.nio.charset.Charset):java.util.List");
    }

    @Deprecated
    public static void write(File file, CharSequence charSequence, boolean z) throws IOException {
        write(file, charSequence, Charset.defaultCharset(), z);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, boolean z) throws IOException {
        writeByteArrayToFile(file, bArr, 0, bArr.length, z);
    }

    public static void writeLines(File file, Collection<?> collection, boolean z) throws IOException {
        writeLines(file, (String) null, collection, (String) null, z);
    }

    @Deprecated
    public static void writeStringToFile(File file, String str, boolean z) throws IOException {
        writeStringToFile(file, str, Charset.defaultCharset(), z);
    }

    public static void copyDirectory(File file, File file2, FileFilter fileFilter) throws IOException {
        copyDirectory(file, file2, fileFilter, true);
    }

    public static void copyFile(File file, File file2, boolean z, CopyOption... copyOptionArr) throws IOException {
        if (z) {
            copyOptionArr = addCopyAttributes(copyOptionArr);
        }
        copyFile(file, file2, copyOptionArr);
    }

    private static void setLastModified(File file, long j) throws IOException {
        Objects.requireNonNull(file, "file");
        if (!file.setLastModified(j)) {
            throw new IOException(String.format("Failed setLastModified(%s) on '%s'", new Object[]{Long.valueOf(j), file}));
        }
    }

    public static void write(File file, CharSequence charSequence, Charset charset) throws IOException {
        write(file, charSequence, charset, false);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, int i, int i2) throws IOException {
        writeByteArrayToFile(file, bArr, i, i2, false);
    }

    public static void writeLines(File file, Collection<?> collection, String str) throws IOException {
        writeLines(file, (String) null, collection, str, false);
    }

    public static void writeStringToFile(File file, String str, Charset charset) throws IOException {
        writeStringToFile(file, str, charset, false);
    }

    public static void copyDirectory(File file, File file2, FileFilter fileFilter, boolean z) throws IOException {
        copyDirectory(file, file2, fileFilter, z, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void copyFile(File file, File file2, CopyOption... copyOptionArr) throws IOException {
        requireFileCopy(file, file2);
        requireFile(file, "srcFile");
        requireCanonicalPathsNotEquals(file, file2);
        createParentDirectories(file2);
        requireFileIfExists(file2, "destFile");
        if (file2.exists()) {
            requireCanWrite(file2, "destFile");
        }
        Files.copy(file.toPath(), file2.toPath(), copyOptionArr);
        requireEqualSizes(file, file2, file.length(), file2.length());
    }

    public static Collection<File> listFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        try {
            return (Collection) listAccumulate(file, iOFileFilter, iOFileFilter2).getFileList().stream().map(new a()).collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(file.toString(), e);
        }
    }

    public static void write(File file, CharSequence charSequence, Charset charset, boolean z) throws IOException {
        writeStringToFile(file, Objects.toString(charSequence, (String) null), charset, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000e, code lost:
        if (r0 != null) goto L_0x0010;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeByteArrayToFile(java.io.File r0, byte[] r1, int r2, int r3, boolean r4) throws java.io.IOException {
        /*
            java.io.FileOutputStream r0 = openOutputStream(r0, r4)
            r0.write(r1, r2, r3)     // Catch:{ all -> 0x000b }
            r0.close()
            return
        L_0x000b:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x000d }
        L_0x000d:
            r2 = move-exception
            if (r0 == 0) goto L_0x0018
            r0.close()     // Catch:{ all -> 0x0014 }
            goto L_0x0018
        L_0x0014:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x0018:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.writeByteArrayToFile(java.io.File, byte[], int, int, boolean):void");
    }

    public static void writeLines(File file, Collection<?> collection, String str, boolean z) throws IOException {
        writeLines(file, (String) null, collection, str, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        if (r0 != null) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeStringToFile(java.io.File r0, java.lang.String r1, java.nio.charset.Charset r2, boolean r3) throws java.io.IOException {
        /*
            java.io.FileOutputStream r0 = openOutputStream(r0, r3)
            org.apache.commons.io.IOUtils.write((java.lang.String) r1, (java.io.OutputStream) r0, (java.nio.charset.Charset) r2)     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x000c
            r0.close()
        L_0x000c:
            return
        L_0x000d:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x000f }
        L_0x000f:
            r2 = move-exception
            if (r0 == 0) goto L_0x001a
            r0.close()     // Catch:{ all -> 0x0016 }
            goto L_0x001a
        L_0x0016:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x001a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.writeStringToFile(java.io.File, java.lang.String, java.nio.charset.Charset, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyDirectory(java.io.File r8, java.io.File r9, java.io.FileFilter r10, boolean r11, java.nio.file.CopyOption... r12) throws java.io.IOException {
        /*
            requireFileCopy(r8, r9)
            java.lang.String r0 = "srcDir"
            requireDirectory(r8, r0)
            requireCanonicalPathsNotEquals(r8, r9)
            java.lang.String r0 = r8.getCanonicalPath()
            java.lang.String r1 = r9.getCanonicalPath()
            boolean r0 = r1.startsWith(r0)
            if (r0 == 0) goto L_0x0041
            java.io.File[] r0 = listFiles(r8, r10)
            int r1 = r0.length
            if (r1 <= 0) goto L_0x0041
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.length
            r1.<init>(r2)
            int r2 = r0.length
            r3 = 0
        L_0x0028:
            if (r3 >= r2) goto L_0x003f
            r4 = r0[r3]
            java.io.File r5 = new java.io.File
            java.lang.String r4 = r4.getName()
            r5.<init>(r9, r4)
            java.lang.String r4 = r5.getCanonicalPath()
            r1.add(r4)
            int r3 = r3 + 1
            goto L_0x0028
        L_0x003f:
            r5 = r1
            goto L_0x0043
        L_0x0041:
            r1 = 0
            goto L_0x003f
        L_0x0043:
            if (r11 == 0) goto L_0x0049
            java.nio.file.CopyOption[] r12 = addCopyAttributes(r12)
        L_0x0049:
            r7 = r12
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r11
            doCopyDirectory(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.copyDirectory(java.io.File, java.io.File, java.io.FileFilter, boolean, java.nio.file.CopyOption[]):void");
    }

    public static File getFile(String... strArr) {
        Objects.requireNonNull(strArr, "names");
        File file = null;
        for (String str : strArr) {
            if (file == null) {
                file = new File(str);
            } else {
                file = new File(file, str);
            }
        }
        return file;
    }

    public static boolean isFileNewer(File file, ChronoLocalDateTime<?> chronoLocalDateTime) {
        return isFileNewer(file, chronoLocalDateTime, ZoneId.systemDefault());
    }

    public static boolean isFileOlder(File file, ChronoLocalDateTime<?> chronoLocalDateTime) {
        return isFileOlder(file, chronoLocalDateTime, ZoneId.systemDefault());
    }

    public static void write(File file, CharSequence charSequence, String str) throws IOException {
        write(file, charSequence, str, false);
    }

    public static void writeLines(File file, String str, Collection<?> collection) throws IOException {
        writeLines(file, str, collection, (String) null, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r0 != null) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyURLToFile(java.net.URL r0, java.io.File r1, int r2, int r3) throws java.io.IOException {
        /*
            java.net.URLConnection r0 = r0.openConnection()
            r0.setConnectTimeout(r2)
            r0.setReadTimeout(r3)
            java.io.InputStream r0 = r0.getInputStream()
            copyInputStreamToFile(r0, r1)     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0016
            r0.close()
        L_0x0016:
            return
        L_0x0017:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r2 = move-exception
            if (r0 == 0) goto L_0x0024
            r0.close()     // Catch:{ all -> 0x0020 }
            goto L_0x0024
        L_0x0020:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x0024:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.copyURLToFile(java.net.URL, java.io.File, int, int):void");
    }

    public static boolean isFileNewer(File file, ChronoLocalDateTime<?> chronoLocalDateTime, ZoneId zoneId) {
        Objects.requireNonNull(chronoLocalDateTime, "chronoLocalDateTime");
        Objects.requireNonNull(zoneId, "zoneId");
        return isFileNewer(file, chronoLocalDateTime.atZone(zoneId));
    }

    public static boolean isFileOlder(File file, ChronoLocalDateTime<?> chronoLocalDateTime, ZoneId zoneId) {
        Objects.requireNonNull(chronoLocalDateTime, "chronoLocalDateTime");
        Objects.requireNonNull(zoneId, "zoneId");
        return isFileOlder(file, chronoLocalDateTime.atZone(zoneId));
    }

    public static void write(File file, CharSequence charSequence, String str, boolean z) throws IOException {
        write(file, charSequence, Charsets.toCharset(str), z);
    }

    public static void writeLines(File file, String str, Collection<?> collection, boolean z) throws IOException {
        writeLines(file, str, collection, (String) null, z);
    }

    public static void copyToDirectory(Iterable<File> iterable, File file) throws IOException {
        Objects.requireNonNull(iterable, "sourceIterable");
        for (File copyFileToDirectory : iterable) {
            copyFileToDirectory(copyFileToDirectory, file);
        }
    }

    public static Collection<File> listFiles(File file, String[] strArr, boolean z) {
        try {
            return toList(streamFiles(file, z, strArr));
        } catch (IOException e) {
            throw new UncheckedIOException(file.toString(), e);
        }
    }

    public static String readFileToString(File file, String str) throws IOException {
        return readFileToString(file, Charsets.toCharset(str));
    }

    public static List<String> readLines(File file, String str) throws IOException {
        return readLines(file, Charsets.toCharset(str));
    }

    public static void writeLines(File file, String str, Collection<?> collection, String str2) throws IOException {
        writeLines(file, str, collection, str2, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r1.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r2 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeLines(java.io.File r1, java.lang.String r2, java.util.Collection<?> r3, java.lang.String r4, boolean r5) throws java.io.IOException {
        /*
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream
            java.io.FileOutputStream r1 = openOutputStream(r1, r5)
            r0.<init>(r1)
            org.apache.commons.io.IOUtils.writeLines((java.util.Collection<?>) r3, (java.lang.String) r4, (java.io.OutputStream) r0, (java.lang.String) r2)     // Catch:{ all -> 0x0010 }
            r0.close()
            return
        L_0x0010:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0017 }
            goto L_0x001b
        L_0x0017:
            r3 = move-exception
            r1.addSuppressed(r3)
        L_0x001b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.writeLines(java.io.File, java.lang.String, java.util.Collection, java.lang.String, boolean):void");
    }

    public static boolean isFileNewer(File file, ChronoZonedDateTime<?> chronoZonedDateTime) {
        Objects.requireNonNull(chronoZonedDateTime, "chronoZonedDateTime");
        return isFileNewer(file, chronoZonedDateTime.toInstant());
    }

    public static boolean isFileOlder(File file, ChronoZonedDateTime<?> chronoZonedDateTime) {
        Objects.requireNonNull(chronoZonedDateTime, "chronoZonedDateTime");
        return isFileOlder(file, chronoZonedDateTime.toInstant());
    }

    public static void writeStringToFile(File file, String str, String str2) throws IOException {
        writeStringToFile(file, str, str2, false);
    }

    public static void writeStringToFile(File file, String str, String str2, boolean z) throws IOException {
        writeStringToFile(file, str, Charsets.toCharset(str2), z);
    }

    public static boolean isFileNewer(File file, Date date) {
        Objects.requireNonNull(date, "date");
        return isFileNewer(file, date.getTime());
    }

    public static boolean isFileOlder(File file, Date date) {
        Objects.requireNonNull(date, "date");
        return isFileOlder(file, date.getTime());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        if (r2 != null) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        r3.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long copyFile(java.io.File r2, java.io.OutputStream r3) throws java.io.IOException {
        /*
            java.nio.file.Path r2 = r2.toPath()
            r0 = 0
            java.nio.file.OpenOption[] r0 = new java.nio.file.OpenOption[r0]
            java.io.InputStream r2 = java.nio.file.Files.newInputStream(r2, r0)
            long r0 = org.apache.commons.io.IOUtils.copyLarge((java.io.InputStream) r2, (java.io.OutputStream) r3)     // Catch:{ all -> 0x0015 }
            if (r2 == 0) goto L_0x0014
            r2.close()
        L_0x0014:
            return r0
        L_0x0015:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0017 }
        L_0x0017:
            r0 = move-exception
            if (r2 == 0) goto L_0x0022
            r2.close()     // Catch:{ all -> 0x001e }
            goto L_0x0022
        L_0x001e:
            r2 = move-exception
            r3.addSuppressed(r2)
        L_0x0022:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.copyFile(java.io.File, java.io.OutputStream):long");
    }

    public static boolean isFileNewer(File file, File file2) {
        requireExists(file2, "reference");
        return isFileNewer(file, lastModifiedUnchecked(file2));
    }

    public static boolean isFileOlder(File file, File file2) {
        requireExists(file2, "reference");
        return isFileOlder(file, lastModifiedUnchecked(file2));
    }

    public static String byteCountToDisplaySize(long j) {
        return byteCountToDisplaySize(BigInteger.valueOf(j));
    }

    public static boolean isFileNewer(File file, Instant instant) {
        Objects.requireNonNull(instant, "instant");
        return isFileNewer(file, instant.toEpochMilli());
    }

    public static boolean isFileOlder(File file, Instant instant) {
        Objects.requireNonNull(instant, "instant");
        return isFileOlder(file, instant.toEpochMilli());
    }

    public static boolean isFileNewer(File file, long j) {
        Objects.requireNonNull(file, "file");
        return file.exists() && lastModifiedUnchecked(file) > j;
    }

    public static boolean isFileOlder(File file, long j) {
        Objects.requireNonNull(file, "file");
        return file.exists() && lastModifiedUnchecked(file) < j;
    }
}
