package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;
import org.eclipse.jetty.util.IO;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class FileResource extends URLResource {
    private static final Logger LOG = Log.getLogger((Class<?>) FileResource.class);
    private static boolean __checkAliases = true;
    private transient URL _alias = null;
    private transient boolean _aliasChecked = false;
    private File _file;

    public FileResource(URL url) throws IOException, URISyntaxException {
        super(url, (URLConnection) null);
        try {
            this._file = new File(new URI(url.toString()));
        } catch (URISyntaxException e) {
            throw e;
        } catch (Exception e2) {
            LOG.ignore(e2);
            try {
                URI uri = new URI("file:" + URIUtil.encodePath(url.toString().substring(5)));
                if (uri.getAuthority() == null) {
                    this._file = new File(uri);
                } else {
                    this._file = new File("//" + uri.getAuthority() + URIUtil.decodePath(url.getFile()));
                }
            } catch (Exception e3) {
                LOG.ignore(e3);
                checkConnection();
                Permission permission = this._connection.getPermission();
                this._file = new File(permission == null ? url.getFile() : permission.getName());
            }
        }
        if (this._file.isDirectory()) {
            if (!this._urlString.endsWith("/")) {
                this._urlString += "/";
            }
        } else if (this._urlString.endsWith("/")) {
            String str = this._urlString;
            this._urlString = str.substring(0, str.length() - 1);
        }
    }

    public static boolean getCheckAliases() {
        return __checkAliases;
    }

    public static void setCheckAliases(boolean z) {
        __checkAliases = z;
    }

    public Resource addPath(String str) throws IOException, MalformedURLException {
        URLResource uRLResource;
        String canonicalPath = URIUtil.canonicalPath(str);
        if ("/".equals(canonicalPath)) {
            return this;
        }
        if (!isDirectory()) {
            uRLResource = (FileResource) super.addPath(canonicalPath);
            String str2 = uRLResource._urlString;
        } else if (canonicalPath != null) {
            uRLResource = (URLResource) Resource.newResource(URIUtil.addPaths(this._urlString, URIUtil.encodePath(canonicalPath.startsWith("/") ? canonicalPath.substring(1) : canonicalPath)));
        } else {
            throw new MalformedURLException();
        }
        String encodePath = URIUtil.encodePath(canonicalPath);
        int length = uRLResource.toString().length() - encodePath.length();
        int lastIndexOf = uRLResource._urlString.lastIndexOf(encodePath, length);
        if (length != lastIndexOf && ((length - 1 != lastIndexOf || canonicalPath.endsWith("/") || !uRLResource.isDirectory()) && (uRLResource instanceof FileResource))) {
            FileResource fileResource = (FileResource) uRLResource;
            fileResource._alias = fileResource._file.getCanonicalFile().toURI().toURL();
            fileResource._aliasChecked = true;
        }
        return uRLResource;
    }

    public void copyTo(File file) throws IOException {
        if (isDirectory()) {
            IO.copyDir(getFile(), file);
        } else if (!file.exists()) {
            IO.copy(getFile(), file);
        } else {
            throw new IllegalArgumentException(file + " exists");
        }
    }

    public boolean delete() throws SecurityException {
        return this._file.delete();
    }

    public String encode(String str) {
        return str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FileResource)) {
            return false;
        }
        File file = ((FileResource) obj)._file;
        File file2 = this._file;
        if (file != file2) {
            return file2 != null && file2.equals(file);
        }
        return true;
    }

    public boolean exists() {
        return this._file.exists();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A[Catch:{ Exception -> 0x0025 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.net.URL getAlias() {
        /*
            r5 = this;
            boolean r0 = __checkAliases
            if (r0 == 0) goto L_0x007b
            boolean r0 = r5._aliasChecked
            if (r0 != 0) goto L_0x007b
            java.io.File r0 = r5._file     // Catch:{ Exception -> 0x0025 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x0025 }
            java.io.File r1 = r5._file     // Catch:{ Exception -> 0x0025 }
            java.lang.String r1 = r1.getCanonicalPath()     // Catch:{ Exception -> 0x0025 }
            int r2 = r0.length()     // Catch:{ Exception -> 0x0025 }
            int r3 = r1.length()     // Catch:{ Exception -> 0x0025 }
            if (r2 != r3) goto L_0x0027
            boolean r2 = r0.equals(r1)     // Catch:{ Exception -> 0x0025 }
            if (r2 != 0) goto L_0x0032
            goto L_0x0027
        L_0x0025:
            r0 = move-exception
            goto L_0x006f
        L_0x0027:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0025 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0025 }
            java.net.URL r2 = org.eclipse.jetty.util.resource.Resource.toURL(r2)     // Catch:{ Exception -> 0x0025 }
            r5._alias = r2     // Catch:{ Exception -> 0x0025 }
        L_0x0032:
            r2 = 1
            r5._aliasChecked = r2     // Catch:{ Exception -> 0x0025 }
            java.net.URL r2 = r5._alias     // Catch:{ Exception -> 0x0025 }
            if (r2 == 0) goto L_0x007b
            org.eclipse.jetty.util.log.Logger r2 = LOG     // Catch:{ Exception -> 0x0025 }
            boolean r3 = r2.isDebugEnabled()     // Catch:{ Exception -> 0x0025 }
            if (r3 == 0) goto L_0x007b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r3.<init>()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r4 = "ALIAS abs="
            r3.append(r4)     // Catch:{ Exception -> 0x0025 }
            r3.append(r0)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0025 }
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0025 }
            r2.debug((java.lang.String) r0, (java.lang.Object[]) r4)     // Catch:{ Exception -> 0x0025 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r0.<init>()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r4 = "ALIAS can="
            r0.append(r4)     // Catch:{ Exception -> 0x0025 }
            r0.append(r1)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0025 }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0025 }
            r2.debug((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x0025 }
            goto L_0x007b
        L_0x006f:
            org.eclipse.jetty.util.log.Logger r1 = LOG
            java.lang.String r2 = "EXCEPTION "
            r1.warn((java.lang.String) r2, (java.lang.Throwable) r0)
            java.net.URL r5 = r5.getURL()
            return r5
        L_0x007b:
            java.net.URL r5 = r5._alias
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.resource.FileResource.getAlias():java.net.URL");
    }

    public File getFile() {
        return this._file;
    }

    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this._file);
    }

    public String getName() {
        return this._file.getAbsolutePath();
    }

    public OutputStream getOutputStream() throws IOException, SecurityException {
        return new FileOutputStream(this._file);
    }

    public int hashCode() {
        File file = this._file;
        return file == null ? super.hashCode() : file.hashCode();
    }

    public boolean isDirectory() {
        return this._file.isDirectory();
    }

    public long lastModified() {
        return this._file.lastModified();
    }

    public long length() {
        return this._file.length();
    }

    public String[] list() {
        String[] list = this._file.list();
        if (list == null) {
            return null;
        }
        int length = list.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return list;
            }
            if (new File(this._file, list[i]).isDirectory() && !list[i].endsWith("/")) {
                list[i] = list[i] + "/";
            }
            length = i;
        }
    }

    public boolean renameTo(Resource resource) throws SecurityException {
        if (resource instanceof FileResource) {
            return this._file.renameTo(((FileResource) resource)._file);
        }
        return false;
    }

    public FileResource(URL url, URLConnection uRLConnection, File file) {
        super(url, uRLConnection);
        this._file = file;
        if (file.isDirectory() && !this._urlString.endsWith("/")) {
            this._urlString += "/";
        }
    }
}
