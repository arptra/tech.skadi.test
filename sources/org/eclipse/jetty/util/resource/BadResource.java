package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

class BadResource extends URLResource {
    private String _message;

    public BadResource(URL url, String str) {
        super(url, (URLConnection) null);
        this._message = str;
    }

    public void copyTo(File file) throws IOException {
        throw new SecurityException(this._message);
    }

    public boolean delete() throws SecurityException {
        throw new SecurityException(this._message);
    }

    public boolean exists() {
        return false;
    }

    public File getFile() {
        return null;
    }

    public InputStream getInputStream() throws IOException {
        throw new FileNotFoundException(this._message);
    }

    public OutputStream getOutputStream() throws IOException, SecurityException {
        throw new FileNotFoundException(this._message);
    }

    public boolean isDirectory() {
        return false;
    }

    public long lastModified() {
        return -1;
    }

    public long length() {
        return -1;
    }

    public String[] list() {
        return null;
    }

    public boolean renameTo(Resource resource) throws SecurityException {
        throw new SecurityException(this._message);
    }

    public String toString() {
        return super.toString() + "; BadResource=" + this._message;
    }
}
