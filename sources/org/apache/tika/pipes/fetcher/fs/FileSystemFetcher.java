package org.apache.tika.pipes.fetcher.fs;

import java.nio.file.Path;
import java.util.Map;
import org.apache.tika.config.Initializable;
import org.apache.tika.config.InitializableProblemHandler;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.pipes.fetcher.AbstractFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileSystemFetcher extends AbstractFetcher implements Initializable {
    public static final Logger c = LoggerFactory.k(FileSystemFetcher.class);
    public Path b;

    public void checkInitialization(InitializableProblemHandler initializableProblemHandler) {
        Path path = this.b;
        if (path == null || path.toString().trim().length() == 0) {
            c.warn("'basePath' has not been set. This means that client code or clients can read from any file that this process has permissions to read. If you are running tika-server, make absolutely certain that you've locked down access to tika-server and file-permissions for the tika-server process.");
        } else if (this.b.toString().startsWith("http://")) {
            throw new TikaConfigException("FileSystemFetcher only works with local file systems.  Please use the tika-fetcher-http module for http calls");
        } else if (this.b.toString().startsWith("ftp://")) {
            throw new TikaConfigException("FileSystemFetcher only works with local file systems.  Please consider contributing an ftp fetcher module");
        } else if (this.b.toString().startsWith("s3://")) {
            throw new TikaConfigException("FileSystemFetcher only works with local file systems.  Please use the tika-fetcher-s3 module");
        } else if (!this.b.toAbsolutePath().toString().contains("\u0000")) {
            c.info("A FileSystemFetcher ({}) has been initialized. Clients will be able to read all files under '{}' if this process has permission to read them.", a(), this.b.toAbsolutePath());
        } else {
            throw new TikaConfigException("base path must not contain \u0000. Seriously, what were you thinking?");
        }
    }

    public void initialize(Map map) {
    }
}
