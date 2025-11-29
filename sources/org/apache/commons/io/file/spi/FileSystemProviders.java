package org.apache.commons.io.file.spi;

import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;
import java.util.List;
import java.util.Objects;

public class FileSystemProviders {
    private static final FileSystemProviders INSTALLED = new FileSystemProviders(FileSystemProvider.installedProviders());
    private final List<FileSystemProvider> providers;

    private FileSystemProviders(List<FileSystemProvider> list) {
        this.providers = list;
    }

    public static FileSystemProvider getFileSystemProvider(Path path) {
        Objects.requireNonNull(path, "path");
        return path.getFileSystem().provider();
    }

    public static FileSystemProviders installed() {
        return INSTALLED;
    }

    public FileSystemProvider getFileSystemProvider(String str) {
        Objects.requireNonNull(str, "scheme");
        if (str.equalsIgnoreCase("file")) {
            return FileSystems.getDefault().provider();
        }
        List<FileSystemProvider> list = this.providers;
        if (list == null) {
            return null;
        }
        for (FileSystemProvider next : list) {
            if (next.getScheme().equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    public FileSystemProvider getFileSystemProvider(URI uri) {
        Objects.requireNonNull(uri, "uri");
        return getFileSystemProvider(uri.getScheme());
    }

    public FileSystemProvider getFileSystemProvider(URL url) {
        Objects.requireNonNull(url, "url");
        return getFileSystemProvider(url.getProtocol());
    }
}
