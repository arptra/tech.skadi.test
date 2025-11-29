package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

class JarFileResource extends JarResource {
    private static final Logger LOG = Log.getLogger((Class<?>) JarFileResource.class);
    private boolean _directory;
    private JarEntry _entry;
    private boolean _exists;
    private File _file;
    private JarFile _jarFile;
    private String _jarUrl;
    private String[] _list;
    private String _path;

    public JarFileResource(URL url) {
        super(url);
    }

    public static Resource getNonCachingResource(Resource resource) {
        return !(resource instanceof JarFileResource) ? resource : new JarFileResource(((JarFileResource) resource).getURL(), false);
    }

    private List<String> listEntries() {
        checkConnection();
        ArrayList arrayList = new ArrayList(32);
        JarFile jarFile = this._jarFile;
        if (jarFile == null) {
            try {
                JarURLConnection jarURLConnection = (JarURLConnection) new URL(this._jarUrl).openConnection();
                jarURLConnection.setUseCaches(getUseCaches());
                jarFile = jarURLConnection.getJarFile();
            } catch (Exception e) {
                e.printStackTrace();
                LOG.ignore(e);
            }
        }
        Enumeration<JarEntry> entries = jarFile.entries();
        String str = this._urlString;
        String substring = str.substring(str.indexOf("!/") + 2);
        while (entries.hasMoreElements()) {
            String replace = entries.nextElement().getName().replace(IOUtils.DIR_SEPARATOR_WINDOWS, '/');
            if (replace.startsWith(substring) && replace.length() != substring.length()) {
                String substring2 = replace.substring(substring.length());
                int indexOf = substring2.indexOf(47);
                if (indexOf >= 0) {
                    if (indexOf != 0 || substring2.length() != 1) {
                        substring2 = indexOf == 0 ? substring2.substring(indexOf + 1, substring2.length()) : substring2.substring(0, indexOf + 1);
                        if (arrayList.contains(substring2)) {
                        }
                    }
                }
                arrayList.add(substring2);
            }
        }
        return arrayList;
    }

    public boolean checkConnection() {
        try {
            super.checkConnection();
            return this._jarFile != null;
        } finally {
            if (this._jarConnection == null) {
                this._entry = null;
                this._file = null;
                this._jarFile = null;
                this._list = null;
            }
        }
    }

    public String encode(String str) {
        return str;
    }

    public boolean exists() {
        JarFile jarFile;
        boolean z = true;
        if (this._exists) {
            return true;
        }
        if (this._urlString.endsWith("!/")) {
            String str = this._urlString;
            try {
                return Resource.newResource(str.substring(4, str.length() - 2)).exists();
            } catch (Exception e) {
                LOG.ignore(e);
                return false;
            }
        } else {
            boolean checkConnection = checkConnection();
            if (this._jarUrl == null || this._path != null) {
                if (checkConnection) {
                    jarFile = this._jarFile;
                } else {
                    try {
                        JarURLConnection jarURLConnection = (JarURLConnection) new URL(this._jarUrl).openConnection();
                        jarURLConnection.setUseCaches(getUseCaches());
                        jarFile = jarURLConnection.getJarFile();
                    } catch (Exception e2) {
                        LOG.ignore(e2);
                        jarFile = null;
                    }
                }
                if (jarFile != null && this._entry == null && !this._directory) {
                    Enumeration<JarEntry> entries = jarFile.entries();
                    while (true) {
                        if (!entries.hasMoreElements()) {
                            break;
                        }
                        JarEntry nextElement = entries.nextElement();
                        String replace = nextElement.getName().replace(IOUtils.DIR_SEPARATOR_WINDOWS, '/');
                        if (!replace.equals(this._path)) {
                            if (!this._path.endsWith("/")) {
                                if (replace.startsWith(this._path) && replace.length() > this._path.length() && replace.charAt(this._path.length()) == '/') {
                                    this._directory = true;
                                    break;
                                }
                            } else if (replace.startsWith(this._path)) {
                                this._directory = true;
                                break;
                            }
                        } else {
                            this._entry = nextElement;
                            this._directory = this._path.endsWith("/");
                            break;
                        }
                    }
                    if (this._directory && !this._urlString.endsWith("/")) {
                        this._urlString += "/";
                        try {
                            this._url = new URL(this._urlString);
                        } catch (MalformedURLException e3) {
                            LOG.warn(e3);
                        }
                    }
                }
                if (!this._directory && this._entry == null) {
                    z = false;
                }
                this._exists = z;
                return z;
            }
            this._directory = checkConnection;
            return true;
        }
    }

    public boolean isContainedIn(Resource resource) throws MalformedURLException {
        String str = this._urlString;
        int indexOf = str.indexOf("!/");
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        if (str.startsWith("jar:")) {
            str = str.substring(4);
        }
        return new URL(str).sameFile(resource.getURL());
    }

    public boolean isDirectory() {
        return this._urlString.endsWith("/") || (exists() && this._directory);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        r0 = r2._entry;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long lastModified() {
        /*
            r2 = this;
            boolean r0 = r2.checkConnection()
            if (r0 == 0) goto L_0x0020
            java.io.File r0 = r2._file
            if (r0 == 0) goto L_0x0020
            boolean r0 = r2.exists()
            if (r0 == 0) goto L_0x0019
            java.util.jar.JarEntry r0 = r2._entry
            if (r0 == 0) goto L_0x0019
            long r0 = r0.getTime()
            return r0
        L_0x0019:
            java.io.File r2 = r2._file
            long r0 = r2.lastModified()
            return r0
        L_0x0020:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.resource.JarFileResource.lastModified():long");
    }

    public long length() {
        JarEntry jarEntry;
        if (!isDirectory() && (jarEntry = this._entry) != null) {
            return jarEntry.getSize();
        }
        return -1;
    }

    public synchronized String[] list() {
        List<String> list;
        if (isDirectory() && this._list == null) {
            try {
                list = listEntries();
            } catch (Exception e) {
                Logger logger = LOG;
                logger.warn("Retrying list:" + e, new Object[0]);
                LOG.debug(e);
                release();
                list = listEntries();
            }
            if (list != null) {
                String[] strArr = new String[list.size()];
                this._list = strArr;
                list.toArray(strArr);
            }
        }
        return this._list;
    }

    public synchronized void newConnection() throws IOException {
        try {
            super.newConnection();
            this._entry = null;
            this._file = null;
            this._jarFile = null;
            this._list = null;
            int indexOf = this._urlString.indexOf("!/") + 2;
            this._jarUrl = this._urlString.substring(0, indexOf);
            String substring = this._urlString.substring(indexOf);
            this._path = substring;
            if (substring.length() == 0) {
                this._path = null;
            }
            this._jarFile = this._jarConnection.getJarFile();
            this._file = new File(this._jarFile.getName());
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void release() {
        this._list = null;
        this._entry = null;
        this._file = null;
        if (!getUseCaches() && this._jarFile != null) {
            try {
                Logger logger = LOG;
                logger.debug("Closing JarFile " + this._jarFile.getName(), new Object[0]);
                this._jarFile.close();
            } catch (IOException e) {
                LOG.ignore(e);
            }
        }
        this._jarFile = null;
        super.release();
    }

    public JarFileResource(URL url, boolean z) {
        super(url, z);
    }
}
