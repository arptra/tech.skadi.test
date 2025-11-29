package androidx.core.util;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile {

    /* renamed from: a  reason: collision with root package name */
    public final File f842a;
    public final File b;
    public final File c;

    public AtomicFile(File file) {
        this.f842a = file;
        this.b = new File(file.getPath() + ".new");
        this.c = new File(file.getPath() + ".bak");
    }

    public static void c(File file, File file2) {
        if (file2.isDirectory() && !file2.delete()) {
            Log.e("AtomicFile", "Failed to delete file which is a directory " + file2);
        }
        if (!file.renameTo(file2)) {
            Log.e("AtomicFile", "Failed to rename " + file + " to " + file2);
        }
    }

    public static boolean e(FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            if (!e(fileOutputStream)) {
                Log.e("AtomicFile", "Failed to sync file output stream");
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                Log.e("AtomicFile", "Failed to close file output stream", e);
            }
            if (!this.b.delete()) {
                Log.e("AtomicFile", "Failed to delete new file " + this.b);
            }
        }
    }

    public void b(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            if (!e(fileOutputStream)) {
                Log.e("AtomicFile", "Failed to sync file output stream");
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                Log.e("AtomicFile", "Failed to close file output stream", e);
            }
            c(this.b, this.f842a);
        }
    }

    public FileOutputStream d() {
        if (this.c.exists()) {
            c(this.c, this.f842a);
        }
        try {
            return new FileOutputStream(this.b);
        } catch (FileNotFoundException unused) {
            if (this.b.getParentFile().mkdirs()) {
                try {
                    return new FileOutputStream(this.b);
                } catch (FileNotFoundException e) {
                    throw new IOException("Failed to create new file " + this.b, e);
                }
            } else {
                throw new IOException("Failed to create directory for " + this.b);
            }
        }
    }
}
