package org.apache.commons.io.monitor;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import org.apache.commons.io.FileUtils;

public class FileEntry implements Serializable {
    static final FileEntry[] EMPTY_FILE_ENTRY_ARRAY = new FileEntry[0];
    private static final long serialVersionUID = -2505664948818681153L;
    private FileEntry[] children;
    private boolean directory;
    private boolean exists;
    private final File file;
    private long lastModified;
    private long length;
    private String name;
    private final FileEntry parent;

    public FileEntry(File file2) {
        this((FileEntry) null, file2);
    }

    public FileEntry[] getChildren() {
        FileEntry[] fileEntryArr = this.children;
        return fileEntryArr != null ? fileEntryArr : EMPTY_FILE_ENTRY_ARRAY;
    }

    public File getFile() {
        return this.file;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public long getLength() {
        return this.length;
    }

    public int getLevel() {
        FileEntry fileEntry = this.parent;
        if (fileEntry == null) {
            return 0;
        }
        return fileEntry.getLevel() + 1;
    }

    public String getName() {
        return this.name;
    }

    public FileEntry getParent() {
        return this.parent;
    }

    public boolean isDirectory() {
        return this.directory;
    }

    public boolean isExists() {
        return this.exists;
    }

    public FileEntry newChildInstance(File file2) {
        return new FileEntry(this, file2);
    }

    public boolean refresh(File file2) {
        boolean z = this.exists;
        long j = this.lastModified;
        boolean z2 = this.directory;
        long j2 = this.length;
        this.name = file2.getName();
        boolean exists2 = Files.exists(file2.toPath(), new LinkOption[0]);
        this.exists = exists2;
        this.directory = exists2 && file2.isDirectory();
        long j3 = 0;
        try {
            this.lastModified = this.exists ? FileUtils.lastModified(file2) : 0;
        } catch (IOException unused) {
            this.lastModified = 0;
        }
        if (this.exists && !this.directory) {
            j3 = file2.length();
        }
        this.length = j3;
        return (this.exists == z && this.lastModified == j && this.directory == z2 && j3 == j2) ? false : true;
    }

    public void setChildren(FileEntry... fileEntryArr) {
        this.children = fileEntryArr;
    }

    public void setDirectory(boolean z) {
        this.directory = z;
    }

    public void setExists(boolean z) {
        this.exists = z;
    }

    public void setLastModified(long j) {
        this.lastModified = j;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public FileEntry(FileEntry fileEntry, File file2) {
        if (file2 != null) {
            this.file = file2;
            this.parent = fileEntry;
            this.name = file2.getName();
            return;
        }
        throw new IllegalArgumentException("File is missing");
    }
}
