package org.apache.tika.io;

import com.honey.account.ic.b;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemporaryResources implements Closeable {
    public static final Logger c = LoggerFactory.k(TemporaryResources.class);

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList f9659a = new LinkedList();
    public Path b = null;

    public static /* synthetic */ void j(Path path) {
        try {
            Files.delete(path);
        } catch (IOException unused) {
            c.warn("delete tmp file fail, will delete it on exit");
            path.toFile().deleteOnExit();
        }
    }

    public void b(Closeable closeable) {
        this.f9659a.addFirst(closeable);
    }

    public Path c() {
        return d("");
    }

    public void close() {
        Iterator it = this.f9659a.iterator();
        IOException iOException = null;
        while (it.hasNext()) {
            try {
                ((Closeable) it.next()).close();
            } catch (IOException e) {
                if (iOException == null) {
                    iOException = e;
                } else {
                    iOException.addSuppressed(e);
                }
            }
        }
        this.f9659a.clear();
        if (iOException != null) {
            throw iOException;
        }
    }

    public Path d(String str) {
        if (StringUtils.a(str)) {
            str = DiskFileUpload.postfix;
        }
        Path path = this.b;
        Path createTempFile = path == null ? Files.createTempFile("apache-tika-", str, new FileAttribute[0]) : Files.createTempFile(path, "apache-tika-", str, new FileAttribute[0]);
        b(new b(createTempFile));
        return createTempFile;
    }

    public void dispose() {
        try {
            close();
        } catch (IOException e) {
            throw new TikaException("Failed to close temporary resources", e);
        }
    }

    public Path g(Metadata metadata) {
        String str = metadata.get("resourceName");
        return StringUtils.a(str) ? d("") : d(FilenameUtils.b(str));
    }

    public File i() {
        return d("").toFile();
    }
}
