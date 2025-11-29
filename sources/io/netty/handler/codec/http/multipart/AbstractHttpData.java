package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

public abstract class AbstractHttpData extends AbstractReferenceCounted implements HttpData {
    private static final Pattern REPLACE_PATTERN = Pattern.compile("[\\r\\t]");
    private static final Pattern STRIP_PATTERN = Pattern.compile("(?:^\\s+|\\s+$|\\n)");
    private Charset charset = HttpConstants.DEFAULT_CHARSET;
    private boolean completed;
    protected long definedSize;
    private long maxSize = -1;
    private final String name;
    protected long size;

    public AbstractHttpData(String str, Charset charset2, long j) {
        ObjectUtil.checkNotNull(str, "name");
        this.name = ObjectUtil.checkNonEmpty(STRIP_PATTERN.matcher(REPLACE_PATTERN.matcher(str).replaceAll(" ")).replaceAll(""), "name");
        if (charset2 != null) {
            setCharset(charset2);
        }
        this.definedSize = j;
    }

    public void checkSize(long j) throws IOException {
        long j2 = this.maxSize;
        if (j2 >= 0 && j > j2) {
            throw new IOException("Size exceed allowed maximum capacity");
        }
    }

    public ByteBuf content() {
        try {
            return getByteBuf();
        } catch (IOException e) {
            throw new ChannelException((Throwable) e);
        }
    }

    public void deallocate() {
        delete();
    }

    public long definedLength() {
        return this.definedSize;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public long getMaxSize() {
        return this.maxSize;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public long length() {
        return this.size;
    }

    public void setCharset(Charset charset2) {
        this.charset = (Charset) ObjectUtil.checkNotNull(charset2, "charset");
    }

    public void setCompleted() {
        setCompleted(true);
    }

    public void setMaxSize(long j) {
        this.maxSize = j;
    }

    public abstract HttpData touch();

    public abstract HttpData touch(Object obj);

    public void setCompleted(boolean z) {
        this.completed = z;
    }

    public HttpData retain() {
        super.retain();
        return this;
    }

    public HttpData retain(int i) {
        super.retain(i);
        return this;
    }
}
