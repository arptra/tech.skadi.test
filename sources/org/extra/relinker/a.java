package org.extra.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.extra.relinker.c;

public class a implements c.a {

    /* renamed from: org.extra.relinker.a$a  reason: collision with other inner class name */
    public static class C0022a {

        /* renamed from: a  reason: collision with root package name */
        public ZipFile f3350a;
        public ZipEntry b;

        public C0022a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f3350a = zipFile;
            this.b = zipEntry;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: org.extra.relinker.a$a} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x009b A[SYNTHETIC, Splitter:B:67:0x009b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r9, java.lang.String[] r10, java.lang.String r11, java.io.File r12, org.extra.relinker.d r13) {
        /*
            r8 = this;
            r0 = 0
            org.extra.relinker.a$a r9 = r8.c(r9, r10, r11, r13)     // Catch:{ all -> 0x0098 }
            if (r9 == 0) goto L_0x0092
            r10 = 0
            r1 = r10
        L_0x0009:
            int r2 = r1 + 1
            r3 = 5
            if (r1 >= r3) goto L_0x0085
            java.lang.String r1 = "Found %s! Extracting..."
            java.lang.Object[] r3 = new java.lang.Object[]{r11}     // Catch:{ all -> 0x0024 }
            r13.f(r1, r3)     // Catch:{ all -> 0x0024 }
            boolean r1 = r12.exists()     // Catch:{ IOException -> 0x0083 }
            if (r1 != 0) goto L_0x0028
            boolean r1 = r12.createNewFile()     // Catch:{ IOException -> 0x0083 }
            if (r1 != 0) goto L_0x0028
            goto L_0x0083
        L_0x0024:
            r8 = move-exception
            r0 = r9
            goto L_0x0099
        L_0x0028:
            java.util.zip.ZipFile r1 = r9.f3350a     // Catch:{ FileNotFoundException -> 0x007b, IOException -> 0x0075, all -> 0x006c }
            java.util.zip.ZipEntry r3 = r9.b     // Catch:{ FileNotFoundException -> 0x007b, IOException -> 0x0075, all -> 0x006c }
            java.io.InputStream r1 = r1.getInputStream(r3)     // Catch:{ FileNotFoundException -> 0x007b, IOException -> 0x0075, all -> 0x006c }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x007c, IOException -> 0x0076, all -> 0x006a }
            r3.<init>(r12)     // Catch:{ FileNotFoundException -> 0x007c, IOException -> 0x0076, all -> 0x006a }
            long r4 = r8.b(r1, r3)     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x0077, all -> 0x0067 }
            java.io.FileDescriptor r6 = r3.getFD()     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x0077, all -> 0x0067 }
            r6.sync()     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x0077, all -> 0x0067 }
            long r6 = r12.length()     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x0077, all -> 0x0067 }
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x004f
            r8.d(r1)     // Catch:{ all -> 0x0024 }
            r8.d(r3)     // Catch:{ all -> 0x0024 }
            goto L_0x0083
        L_0x004f:
            r8.d(r1)     // Catch:{ all -> 0x0024 }
            r8.d(r3)     // Catch:{ all -> 0x0024 }
            r8 = 1
            r12.setReadable(r8, r10)     // Catch:{ all -> 0x0024 }
            r12.setExecutable(r8, r10)     // Catch:{ all -> 0x0024 }
            r12.setWritable(r8)     // Catch:{ all -> 0x0024 }
            java.util.zip.ZipFile r8 = r9.f3350a     // Catch:{ IOException -> 0x0066 }
            if (r8 == 0) goto L_0x0066
            r8.close()     // Catch:{ IOException -> 0x0066 }
        L_0x0066:
            return
        L_0x0067:
            r10 = move-exception
            r0 = r3
            goto L_0x006e
        L_0x006a:
            r10 = move-exception
            goto L_0x006e
        L_0x006c:
            r10 = move-exception
            r1 = r0
        L_0x006e:
            r8.d(r1)     // Catch:{ all -> 0x0024 }
            r8.d(r0)     // Catch:{ all -> 0x0024 }
            throw r10     // Catch:{ all -> 0x0024 }
        L_0x0075:
            r1 = r0
        L_0x0076:
            r3 = r0
        L_0x0077:
            r8.d(r1)     // Catch:{ all -> 0x0024 }
            goto L_0x0080
        L_0x007b:
            r1 = r0
        L_0x007c:
            r3 = r0
        L_0x007d:
            r8.d(r1)     // Catch:{ all -> 0x0024 }
        L_0x0080:
            r8.d(r3)     // Catch:{ all -> 0x0024 }
        L_0x0083:
            r1 = r2
            goto L_0x0009
        L_0x0085:
            java.lang.String r8 = "FATAL! Couldn't extract the library from the APK!"
            r13.e(r8)     // Catch:{ all -> 0x0024 }
            java.util.zip.ZipFile r8 = r9.f3350a     // Catch:{ IOException -> 0x0091 }
            if (r8 == 0) goto L_0x0091
            r8.close()     // Catch:{ IOException -> 0x0091 }
        L_0x0091:
            return
        L_0x0092:
            org.extra.relinker.b r8 = new org.extra.relinker.b     // Catch:{ all -> 0x0024 }
            r8.<init>(r11)     // Catch:{ all -> 0x0024 }
            throw r8     // Catch:{ all -> 0x0024 }
        L_0x0098:
            r8 = move-exception
        L_0x0099:
            if (r0 == 0) goto L_0x00a2
            java.util.zip.ZipFile r9 = r0.f3350a     // Catch:{ IOException -> 0x00a2 }
            if (r9 == 0) goto L_0x00a2
            r9.close()     // Catch:{ IOException -> 0x00a2 }
        L_0x00a2:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.extra.relinker.a.a(android.content.Context, java.lang.String[], java.lang.String, java.io.File, org.extra.relinker.d):void");
    }

    public final long b(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public final C0022a c(Context context, String[] strArr, String str, d dVar) {
        String[] strArr2 = strArr;
        ZipFile zipFile = null;
        for (String str2 : e(context)) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i = i2;
                }
            }
            if (zipFile == null) {
                String str3 = str;
                d dVar2 = dVar;
            } else {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    if (i3 < 5) {
                        for (String append : strArr2) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("lib");
                            char c = File.separatorChar;
                            sb.append(c);
                            sb.append(append);
                            sb.append(c);
                            sb.append(str);
                            String sb2 = sb.toString();
                            dVar.f("Looking for %s in APK %s...", sb2, str2);
                            ZipEntry entry = zipFile.getEntry(sb2);
                            if (entry != null) {
                                return new C0022a(zipFile, entry);
                            }
                        }
                        String str4 = str;
                        d dVar3 = dVar;
                        i3 = i4;
                    } else {
                        String str5 = str;
                        d dVar4 = dVar;
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
        }
        return null;
    }

    public final void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public final String[] e(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[(strArr.length + 1)];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }
}
