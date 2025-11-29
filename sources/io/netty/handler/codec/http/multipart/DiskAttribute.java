package io.netty.handler.codec.http.multipart;

import com.honey.account.constant.AccountConstantKt;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.charset.Charset;

public class DiskAttribute extends AbstractDiskHttpData implements Attribute {
    public static String baseDirectory = null;
    public static boolean deleteOnExitTemporaryFile = true;
    public static final String postfix = ".att";
    public static final String prefix = "Attr_";
    private String baseDir;
    private boolean deleteOnExit;

    public DiskAttribute(String str) {
        this(str, HttpConstants.DEFAULT_CHARSET);
    }

    public void addContent(ByteBuf byteBuf, boolean z) throws IOException {
        long readableBytes = this.size + ((long) byteBuf.readableBytes());
        try {
            checkSize(readableBytes);
            long j = this.definedSize;
            if (j > 0 && j < readableBytes) {
                this.definedSize = readableBytes;
            }
            super.addContent(byteBuf, z);
        } catch (IOException e) {
            byteBuf.release();
            throw e;
        }
    }

    public boolean deleteOnExit() {
        return this.deleteOnExit;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Attribute)) {
            return false;
        }
        return getName().equalsIgnoreCase(((Attribute) obj).getName());
    }

    public String getBaseDirectory() {
        return this.baseDir;
    }

    public String getDiskFilename() {
        return getName() + postfix;
    }

    public InterfaceHttpData.HttpDataType getHttpDataType() {
        return InterfaceHttpData.HttpDataType.Attribute;
    }

    public String getPostfix() {
        return postfix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getValue() throws IOException {
        return new String(get(), getCharset());
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public void setValue(String str) throws IOException {
        ObjectUtil.checkNotNull(str, AccountConstantKt.RESPONSE_VALUE);
        byte[] bytes = str.getBytes(getCharset());
        checkSize((long) bytes.length);
        ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(bytes);
        if (this.definedSize > 0) {
            this.definedSize = (long) wrappedBuffer.readableBytes();
        }
        setContent(wrappedBuffer);
    }

    public String toString() {
        try {
            return getName() + '=' + getValue();
        } catch (IOException e) {
            return getName() + '=' + e;
        }
    }

    public DiskAttribute(String str, String str2, boolean z) {
        this(str, HttpConstants.DEFAULT_CHARSET);
        this.baseDir = str2 == null ? baseDirectory : str2;
        this.deleteOnExit = z;
    }

    public int compareTo(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData instanceof Attribute) {
            return compareTo((Attribute) interfaceHttpData);
        }
        throw new ClassCastException("Cannot compare " + getHttpDataType() + " with " + interfaceHttpData.getHttpDataType());
    }

    public Attribute copy() {
        ByteBuf content = content();
        return replace(content != null ? content.copy() : null);
    }

    public Attribute duplicate() {
        ByteBuf content = content();
        return replace(content != null ? content.duplicate() : null);
    }

    public Attribute replace(ByteBuf byteBuf) {
        DiskAttribute diskAttribute = new DiskAttribute(getName(), this.baseDir, this.deleteOnExit);
        diskAttribute.setCharset(getCharset());
        if (byteBuf != null) {
            try {
                diskAttribute.setContent(byteBuf);
            } catch (IOException e) {
                throw new ChannelException((Throwable) e);
            }
        }
        diskAttribute.setCompleted(isCompleted());
        return diskAttribute;
    }

    public Attribute retainedDuplicate() {
        ByteBuf content = content();
        if (content == null) {
            return replace((ByteBuf) null);
        }
        ByteBuf retainedDuplicate = content.retainedDuplicate();
        try {
            return replace(retainedDuplicate);
        } catch (Throwable th) {
            retainedDuplicate.release();
            throw th;
        }
    }

    public DiskAttribute(String str, long j) {
        this(str, j, HttpConstants.DEFAULT_CHARSET, baseDirectory, deleteOnExitTemporaryFile);
    }

    public DiskAttribute(String str, long j, String str2, boolean z) {
        this(str, j, HttpConstants.DEFAULT_CHARSET);
        this.baseDir = str2 == null ? baseDirectory : str2;
        this.deleteOnExit = z;
    }

    public int compareTo(Attribute attribute) {
        return getName().compareToIgnoreCase(attribute.getName());
    }

    public DiskAttribute(String str, Charset charset) {
        this(str, charset, baseDirectory, deleteOnExitTemporaryFile);
    }

    public Attribute retain(int i) {
        super.retain(i);
        return this;
    }

    public Attribute touch() {
        super.touch();
        return this;
    }

    public DiskAttribute(String str, Charset charset, String str2, boolean z) {
        super(str, charset, 0);
        this.baseDir = str2 == null ? baseDirectory : str2;
        this.deleteOnExit = z;
    }

    public Attribute retain() {
        super.retain();
        return this;
    }

    public Attribute touch(Object obj) {
        super.touch(obj);
        return this;
    }

    public DiskAttribute(String str, long j, Charset charset) {
        this(str, j, charset, baseDirectory, deleteOnExitTemporaryFile);
    }

    public DiskAttribute(String str, long j, Charset charset, String str2, boolean z) {
        super(str, charset, j);
        this.baseDir = str2 == null ? baseDirectory : str2;
        this.deleteOnExit = z;
    }

    public DiskAttribute(String str, String str2) throws IOException {
        this(str, str2, HttpConstants.DEFAULT_CHARSET);
    }

    public DiskAttribute(String str, String str2, Charset charset) throws IOException {
        this(str, str2, charset, baseDirectory, deleteOnExitTemporaryFile);
    }

    public DiskAttribute(String str, String str2, Charset charset, String str3, boolean z) throws IOException {
        super(str, charset, 0);
        setValue(str2);
        this.baseDir = str3 == null ? baseDirectory : str3;
        this.deleteOnExit = z;
    }
}
