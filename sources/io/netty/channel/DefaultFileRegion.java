package io.netty.channel;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class DefaultFileRegion extends AbstractReferenceCounted implements FileRegion {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultFileRegion.class);
    private final long count;
    private final File f;
    private FileChannel file;
    private final long position;
    private long transferred;

    public DefaultFileRegion(FileChannel fileChannel, long j, long j2) {
        this.file = (FileChannel) ObjectUtil.checkNotNull(fileChannel, "file");
        this.position = ObjectUtil.checkPositiveOrZero(j, "position");
        this.count = ObjectUtil.checkPositiveOrZero(j2, "count");
        this.f = null;
    }

    public static void validate(DefaultFileRegion defaultFileRegion, long j) throws IOException {
        long size = defaultFileRegion.file.size();
        if (defaultFileRegion.position + (defaultFileRegion.count - j) + j > size) {
            throw new IOException("Underlying file size " + size + " smaller then requested count " + defaultFileRegion.count);
        }
    }

    public long count() {
        return this.count;
    }

    public void deallocate() {
        FileChannel fileChannel = this.file;
        if (fileChannel != null) {
            this.file = null;
            try {
                fileChannel.close();
            } catch (IOException e) {
                logger.warn("Failed to close a file.", (Throwable) e);
            }
        }
    }

    public boolean isOpen() {
        return this.file != null;
    }

    public void open() throws IOException {
        if (!isOpen() && refCnt() > 0) {
            this.file = new RandomAccessFile(this.f, "r").getChannel();
        }
    }

    public long position() {
        return this.position;
    }

    public FileRegion touch() {
        return this;
    }

    public long transferTo(WritableByteChannel writableByteChannel, long j) throws IOException {
        long j2 = this.count - j;
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i < 0 || j < 0) {
            throw new IllegalArgumentException("position out of range: " + j + " (expected: 0 - " + (this.count - 1) + ')');
        } else if (i == 0) {
            return 0;
        } else {
            if (refCnt() != 0) {
                open();
                long transferTo = this.file.transferTo(this.position + j, j2, writableByteChannel);
                int i2 = (transferTo > 0 ? 1 : (transferTo == 0 ? 0 : -1));
                if (i2 > 0) {
                    this.transferred += transferTo;
                } else if (i2 == 0) {
                    validate(this, j);
                }
                return transferTo;
            }
            throw new IllegalReferenceCountException(0);
        }
    }

    @Deprecated
    public long transfered() {
        return this.transferred;
    }

    public long transferred() {
        return this.transferred;
    }

    public FileRegion touch(Object obj) {
        return this;
    }

    public FileRegion retain() {
        super.retain();
        return this;
    }

    public FileRegion retain(int i) {
        super.retain(i);
        return this;
    }

    public DefaultFileRegion(File file2, long j, long j2) {
        this.f = (File) ObjectUtil.checkNotNull(file2, "f");
        this.position = ObjectUtil.checkPositiveOrZero(j, "position");
        this.count = ObjectUtil.checkPositiveOrZero(j2, "count");
    }
}
