package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.eclipse.jetty.util.IO;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class JarResource extends URLResource {
    private static final Logger LOG = Log.getLogger((Class<?>) JarResource.class);
    protected JarURLConnection _jarConnection;

    public JarResource(URL url) {
        super(url, (URLConnection) null);
    }

    public static Resource newJarResource(Resource resource) throws IOException {
        if (resource instanceof JarResource) {
            return resource;
        }
        return Resource.newResource("jar:" + resource + "!/");
    }

    public synchronized boolean checkConnection() {
        super.checkConnection();
        try {
            if (this._jarConnection != this._connection) {
                newConnection();
            }
        } catch (IOException e) {
            LOG.ignore(e);
            this._jarConnection = null;
        }
        return this._jarConnection != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d4, code lost:
        if (r7.equals("") == false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d8, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e0, code lost:
        if (r7.startsWith(r13) == false) goto L_0x00d8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void copyTo(java.io.File r14) throws java.io.IOException {
        /*
            r13 = this;
            boolean r0 = r13.exists()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            org.eclipse.jetty.util.log.Logger r0 = LOG
            boolean r1 = r0.isDebugEnabled()
            r2 = 0
            if (r1 == 0) goto L_0x002e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Extract "
            r1.append(r3)
            r1.append(r13)
            java.lang.String r3 = " to "
            r1.append(r3)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.debug((java.lang.String) r1, (java.lang.Object[]) r3)
        L_0x002e:
            java.net.URL r13 = r13.getURL()
            java.lang.String r13 = r13.toExternalForm()
            java.lang.String r13 = r13.trim()
            java.lang.String r1 = "!/"
            int r1 = r13.indexOf(r1)
            if (r1 < 0) goto L_0x0044
            r3 = 4
            goto L_0x0045
        L_0x0044:
            r3 = r2
        L_0x0045:
            if (r1 < 0) goto L_0x01b0
            java.net.URL r4 = new java.net.URL
            java.lang.String r3 = r13.substring(r3, r1)
            r4.<init>(r3)
            int r1 = r1 + 2
            int r3 = r13.length()
            r5 = 0
            if (r1 >= r3) goto L_0x005e
            java.lang.String r13 = r13.substring(r1)
            goto L_0x005f
        L_0x005e:
            r13 = r5
        L_0x005f:
            java.lang.String r1 = "/"
            r3 = 1
            if (r13 == 0) goto L_0x006c
            boolean r6 = r13.endsWith(r1)
            if (r6 == 0) goto L_0x006c
            r6 = r3
            goto L_0x006d
        L_0x006c:
            r6 = r2
        L_0x006d:
            boolean r7 = r0.isDebugEnabled()
            if (r7 == 0) goto L_0x0091
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Extracting entry = "
            r7.append(r8)
            r7.append(r13)
            java.lang.String r8 = " from jar "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r2]
            r0.debug((java.lang.String) r7, (java.lang.Object[]) r8)
        L_0x0091:
            java.net.URLConnection r0 = r4.openConnection()
            java.io.InputStream r0 = r0.getInputStream()
            java.util.jar.JarInputStream r4 = new java.util.jar.JarInputStream
            r4.<init>(r0)
        L_0x009e:
            java.util.jar.JarEntry r0 = r4.getNextJarEntry()
            if (r0 == 0) goto L_0x0180
            java.lang.String r7 = r0.getName()
            if (r13 == 0) goto L_0x00da
            boolean r8 = r7.startsWith(r13)
            if (r8 == 0) goto L_0x00da
            if (r6 != 0) goto L_0x00c4
            int r8 = r13.length()
            int r8 = r8 + r3
            int r9 = r7.length()
            if (r8 != r9) goto L_0x00c4
            boolean r8 = r7.endsWith(r1)
            if (r8 == 0) goto L_0x00c4
            r6 = r3
        L_0x00c4:
            if (r6 == 0) goto L_0x00d6
            int r8 = r13.length()
            java.lang.String r7 = r7.substring(r8)
            java.lang.String r8 = ""
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x00d8
        L_0x00d6:
            r8 = r3
            goto L_0x00e3
        L_0x00d8:
            r8 = r2
            goto L_0x00e3
        L_0x00da:
            if (r13 == 0) goto L_0x00d6
            boolean r8 = r7.startsWith(r13)
            if (r8 != 0) goto L_0x00d6
            goto L_0x00d8
        L_0x00e3:
            if (r8 != 0) goto L_0x0104
            org.eclipse.jetty.util.log.Logger r0 = LOG
            boolean r8 = r0.isDebugEnabled()
            if (r8 == 0) goto L_0x009e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Skipping entry: "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.Object[] r8 = new java.lang.Object[r2]
            r0.debug((java.lang.String) r7, (java.lang.Object[]) r8)
            goto L_0x009e
        L_0x0104:
            r8 = 92
            r9 = 47
            java.lang.String r8 = r7.replace(r8, r9)
            java.lang.String r8 = org.eclipse.jetty.util.URIUtil.canonicalPath(r8)
            if (r8 != 0) goto L_0x0132
            org.eclipse.jetty.util.log.Logger r0 = LOG
            boolean r8 = r0.isDebugEnabled()
            if (r8 == 0) goto L_0x009e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Invalid entry: "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.Object[] r8 = new java.lang.Object[r2]
            r0.debug((java.lang.String) r7, (java.lang.Object[]) r8)
            goto L_0x009e
        L_0x0132:
            java.io.File r8 = new java.io.File
            r8.<init>(r14, r7)
            boolean r7 = r0.isDirectory()
            if (r7 == 0) goto L_0x0148
            boolean r0 = r8.exists()
            if (r0 != 0) goto L_0x009e
            r8.mkdirs()
            goto L_0x009e
        L_0x0148:
            java.io.File r7 = new java.io.File
            java.lang.String r9 = r8.getParent()
            r7.<init>(r9)
            boolean r9 = r7.exists()
            if (r9 != 0) goto L_0x015a
            r7.mkdirs()
        L_0x015a:
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x017b }
            r7.<init>(r8)     // Catch:{ all -> 0x017b }
            org.eclipse.jetty.util.IO.copy((java.io.InputStream) r4, (java.io.OutputStream) r7)     // Catch:{ all -> 0x0178 }
            org.eclipse.jetty.util.IO.close((java.io.OutputStream) r7)
            long r9 = r0.getTime()
            r11 = 0
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 < 0) goto L_0x009e
            long r9 = r0.getTime()
            r8.setLastModified(r9)
            goto L_0x009e
        L_0x0178:
            r13 = move-exception
            r5 = r7
            goto L_0x017c
        L_0x017b:
            r13 = move-exception
        L_0x017c:
            org.eclipse.jetty.util.IO.close((java.io.OutputStream) r5)
            throw r13
        L_0x0180:
            if (r13 == 0) goto L_0x018a
            java.lang.String r0 = "META-INF/MANIFEST.MF"
            boolean r13 = r13.equalsIgnoreCase(r0)
            if (r13 == 0) goto L_0x01ac
        L_0x018a:
            java.util.jar.Manifest r13 = r4.getManifest()
            if (r13 == 0) goto L_0x01ac
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "META-INF"
            r0.<init>(r14, r1)
            r0.mkdir()
            java.io.File r14 = new java.io.File
            java.lang.String r1 = "MANIFEST.MF"
            r14.<init>(r0, r1)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r14)
            r13.write(r0)
            r0.close()
        L_0x01ac:
            org.eclipse.jetty.util.IO.close((java.io.InputStream) r4)
            return
        L_0x01b0:
            java.io.IOException r14 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Not a valid jar url: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r14.<init>(r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.resource.JarResource.copyTo(java.io.File):void");
    }

    public boolean exists() {
        return this._urlString.endsWith("!/") ? checkConnection() : super.exists();
    }

    public File getFile() throws IOException {
        return null;
    }

    public InputStream getInputStream() throws IOException {
        checkConnection();
        if (!this._urlString.endsWith("!/")) {
            return new FilterInputStream(super.getInputStream()) {
                public void close() throws IOException {
                    this.in = IO.getClosedStream();
                }
            };
        }
        String str = this._urlString;
        return new URL(str.substring(4, str.length() - 2)).openStream();
    }

    public void newConnection() throws IOException {
        this._jarConnection = (JarURLConnection) this._connection;
    }

    public synchronized void release() {
        this._jarConnection = null;
        super.release();
    }

    public JarResource(URL url, boolean z) {
        super(url, (URLConnection) null, z);
    }
}
