package org.zeromq;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.zeromq.ZMQ;
import org.zeromq.util.ZMetadata;

public class ZCertStore {

    /* renamed from: a  reason: collision with root package name */
    public final File f3486a;
    public final Map b = new HashMap();
    public final Map c = new HashMap();
    public final Fingerprinter d;

    public interface Fingerprinter {
        byte[] a(File file);
    }

    public static final class Hasher implements Fingerprinter {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f3489a;

        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0029 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public byte[] a(java.io.File r3) {
            /*
                r2 = this;
                java.io.InputStream r3 = r2.b(r3)
                r0 = 0
                if (r3 == 0) goto L_0x0031
                org.zeromq.util.ZDigest r1 = new org.zeromq.util.ZDigest     // Catch:{ IOException -> 0x0029, all -> 0x001f }
                byte[] r2 = r2.f3489a     // Catch:{ IOException -> 0x0029, all -> 0x001f }
                r1.<init>(r2)     // Catch:{ IOException -> 0x0029, all -> 0x001f }
                org.zeromq.util.ZDigest r2 = r1.b(r3)     // Catch:{ IOException -> 0x0029, all -> 0x001f }
                byte[] r2 = r2.a()     // Catch:{ IOException -> 0x0029, all -> 0x001f }
                r3.close()     // Catch:{ IOException -> 0x001a }
                goto L_0x001e
            L_0x001a:
                r3 = move-exception
                r3.printStackTrace()
            L_0x001e:
                return r2
            L_0x001f:
                r2 = move-exception
                r3.close()     // Catch:{ IOException -> 0x0024 }
                goto L_0x0028
            L_0x0024:
                r3 = move-exception
                r3.printStackTrace()
            L_0x0028:
                throw r2
            L_0x0029:
                r3.close()     // Catch:{ IOException -> 0x002d }
                goto L_0x0031
            L_0x002d:
                r2 = move-exception
                r2.printStackTrace()
            L_0x0031:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.zeromq.ZCertStore.Hasher.a(java.io.File):byte[]");
        }

        public final InputStream b(File file) {
            if (file.isFile()) {
                try {
                    return new FileInputStream(file);
                } catch (FileNotFoundException unused) {
                    return null;
                }
            } else if (!file.isDirectory()) {
                return null;
            } else {
                List asList = Arrays.asList(file.list());
                Collections.sort(asList);
                return new ByteArrayInputStream(asList.toString().getBytes(ZMQ.f));
            }
        }
    }

    public interface IFileVisitor {
        boolean a(File file);

        boolean b(File file);
    }

    public static final class Timestamper implements Fingerprinter {
        public byte[] a(File file) {
            long lastModified = file.lastModified();
            return new byte[]{(byte) ((int) ((lastModified >>> 56) & 255)), (byte) ((int) ((lastModified >>> 48) & 255)), (byte) ((int) ((lastModified >>> 40) & 255)), (byte) ((int) ((lastModified >>> 32) & 255)), (byte) ((int) ((lastModified >>> 24) & 255)), (byte) ((int) ((lastModified >>> 16) & 255)), (byte) ((int) ((lastModified >>> 8) & 255)), (byte) ((int) (lastModified & 255))};
        }
    }

    public ZCertStore(String str, Fingerprinter fingerprinter) {
        this.d = fingerprinter;
        this.f3486a = new File(str);
        f();
    }

    public boolean c() {
        final HashMap hashMap = new HashMap(this.b);
        return i(this.f3486a, new IFileVisitor() {
            public boolean a(File file) {
                return ZCertStore.this.g((byte[]) hashMap.remove(file), file);
            }

            public boolean b(File file) {
                return ZCertStore.this.g((byte[]) hashMap.remove(file), file);
            }
        }) || !hashMap.isEmpty();
    }

    public boolean d(String str) {
        boolean z = str.length() == 40;
        Utils.a(z, "z85 publickeys should have a length of 40 bytes but got " + str.length());
        h();
        return this.c.containsKey(str);
    }

    public ZMetadata e(String str) {
        h();
        return (ZMetadata) this.c.get(str);
    }

    public final void f() {
        final HashMap hashMap = new HashMap();
        if (!this.f3486a.exists()) {
            this.f3486a.mkdirs();
        }
        final HashMap hashMap2 = new HashMap();
        i(this.f3486a, new IFileVisitor() {
            public boolean a(File file) {
                try {
                    ZConfig g = ZConfig.g(file.getAbsolutePath());
                    String d = g.d("curve/public-key");
                    if (d == null) {
                        System.out.printf("Warning!! File %s has no curve/public-key-element. SKIPPING!%n", new Object[]{file.getAbsolutePath()});
                        return false;
                    }
                    if (d.length() == 32) {
                        d = ZMQ.Curve.a(d.getBytes(ZMQ.f));
                    }
                    hashMap.put(d, ZMetadata.b(g));
                    hashMap2.put(file, ZCertStore.this.d.a(file));
                    return false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public boolean b(File file) {
                hashMap2.put(file, ZCertStore.this.d.a(file));
                return false;
            }
        });
        this.c.clear();
        this.c.putAll(hashMap);
        this.b.clear();
        this.b.putAll(hashMap2);
    }

    public final boolean g(byte[] bArr, File file) {
        if (file.exists() && bArr != null) {
            return !Arrays.equals(bArr, this.d.a(file));
        }
        return true;
    }

    public boolean h() {
        if (!c()) {
            return false;
        }
        f();
        return true;
    }

    public final boolean i(File file, IFileVisitor iFileVisitor) {
        if (iFileVisitor.b(file)) {
            return true;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isFile()) {
                if (iFileVisitor.a(file2)) {
                    return true;
                }
            } else if (!file2.isDirectory()) {
                System.out.printf("WARNING: %s is neither file nor directory? This shouldn't happen....SKIPPING%n", new Object[]{file2.getAbsolutePath()});
            } else if (i(file2, iFileVisitor)) {
                return true;
            }
        }
        return false;
    }
}
