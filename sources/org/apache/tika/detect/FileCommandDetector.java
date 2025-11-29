package org.apache.tika.detect;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import kotlin.time.DurationKt;
import org.apache.tika.config.Field;
import org.apache.tika.io.BoundedInputStream;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.ExternalProcess;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.external.ExternalParser;
import org.apache.tika.utils.FileProcessResult;
import org.apache.tika.utils.ProcessUtils;
import org.apache.tika.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileCommandDetector implements Detector {
    private static final String DEFAULT_FILE_COMMAND_PATH = "file";
    private static final long DEFAULT_TIMEOUT_MS = 6000;
    public static Property FILE_MIME = Property.k("file:mime");
    private static boolean HAS_WARNED = false;
    private static final Logger LOGGER = LoggerFactory.k(FileCommandDetector.class);
    private String fileCommandPath = DEFAULT_FILE_COMMAND_PATH;
    private Boolean hasFileCommand = null;
    private int maxBytes = DurationKt.NANOS_IN_MILLIS;
    private long timeoutMs = DEFAULT_TIMEOUT_MS;
    private boolean useMime = false;

    public static boolean checkHasFile() {
        return checkHasFile(DEFAULT_FILE_COMMAND_PATH);
    }

    private MediaType detectOnPath(Path path, Metadata metadata) throws IOException {
        FileProcessResult c = ProcessUtils.c(new ProcessBuilder(new String[]{ProcessUtils.b(this.fileCommandPath), "-b", "--mime-type", ProcessUtils.b(path.toAbsolutePath().toString())}), this.timeoutMs, 10000, 10000);
        if (c.h()) {
            metadata.set(ExternalProcess.h, true);
            return MediaType.OCTET_STREAM;
        } else if (c.a() != 0) {
            metadata.set(ExternalProcess.g, c.a());
            return MediaType.OCTET_STREAM;
        } else {
            String d = c.d();
            if (StringUtils.a(d)) {
                return MediaType.OCTET_STREAM;
            }
            metadata.set(FILE_MIME, d);
            if (!this.useMime) {
                return MediaType.OCTET_STREAM;
            }
            MediaType parse = MediaType.parse(d);
            return parse == null ? MediaType.OCTET_STREAM : parse;
        }
    }

    public MediaType detect(InputStream inputStream, Metadata metadata) throws IOException {
        TemporaryResources temporaryResources;
        if (this.hasFileCommand == null) {
            this.hasFileCommand = Boolean.valueOf(checkHasFile(this.fileCommandPath));
        }
        if (!this.hasFileCommand.booleanValue()) {
            if (!HAS_WARNED) {
                Logger logger = LOGGER;
                logger.warn("'file' command isn't working: '" + this.fileCommandPath + "'");
                HAS_WARNED = true;
            }
            return MediaType.OCTET_STREAM;
        }
        TikaInputStream a2 = TikaInputStream.a(inputStream);
        if (a2 != null) {
            return detectOnPath(a2.J(), metadata);
        }
        inputStream.mark(this.maxBytes);
        try {
            temporaryResources = new TemporaryResources();
            Path g = temporaryResources.g(metadata);
            Files.copy(new BoundedInputStream((long) this.maxBytes, inputStream), g, new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
            MediaType detectOnPath = detectOnPath(g, metadata);
            temporaryResources.close();
            inputStream.reset();
            return detectOnPath;
        } catch (Throwable th) {
            inputStream.reset();
            throw th;
        }
        throw th;
    }

    public boolean isUseMime() {
        return this.useMime;
    }

    @Field
    public void setFilePath(String str) {
        this.fileCommandPath = str;
        checkHasFile(str);
    }

    @Field
    public void setMaxBytes(int i) {
        this.maxBytes = i;
    }

    @Field
    public void setTimeoutMs(long j) {
        this.timeoutMs = j;
    }

    @Field
    public void setUseMime(boolean z) {
        this.useMime = z;
    }

    public static boolean checkHasFile(String str) {
        return ExternalParser.check(new String[]{str, "-v"}, new int[0]);
    }
}
