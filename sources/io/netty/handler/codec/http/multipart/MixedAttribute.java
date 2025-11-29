package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class MixedAttribute extends AbstractMixedHttpData<Attribute> implements Attribute {
    public MixedAttribute(String str, long j) {
        this(str, j, HttpConstants.DEFAULT_CHARSET);
    }

    private static Attribute makeInitialAttributeFromValue(String str, String str2, long j, Charset charset, String str3, boolean z) {
        if (((long) str2.length()) > j) {
            try {
                return new DiskAttribute(str, str2, charset, str3, z);
            } catch (IOException e) {
                try {
                    return new MemoryAttribute(str, str2, charset);
                } catch (IOException unused) {
                    throw new IllegalArgumentException(e);
                }
            }
        } else {
            try {
                return new MemoryAttribute(str, str2, charset);
            } catch (IOException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
    }

    public /* bridge */ /* synthetic */ void addContent(ByteBuf byteBuf, boolean z) throws IOException {
        super.addContent(byteBuf, z);
    }

    public /* bridge */ /* synthetic */ void checkSize(long j) throws IOException {
        super.checkSize(j);
    }

    public /* bridge */ /* synthetic */ int compareTo(InterfaceHttpData interfaceHttpData) {
        return super.compareTo(interfaceHttpData);
    }

    public /* bridge */ /* synthetic */ ByteBuf content() {
        return super.content();
    }

    public /* bridge */ /* synthetic */ long definedLength() {
        return super.definedLength();
    }

    public /* bridge */ /* synthetic */ void delete() {
        super.delete();
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ byte[] get() throws IOException {
        return super.get();
    }

    public /* bridge */ /* synthetic */ ByteBuf getByteBuf() throws IOException {
        return super.getByteBuf();
    }

    public /* bridge */ /* synthetic */ Charset getCharset() {
        return super.getCharset();
    }

    public /* bridge */ /* synthetic */ ByteBuf getChunk(int i) throws IOException {
        return super.getChunk(i);
    }

    public /* bridge */ /* synthetic */ File getFile() throws IOException {
        return super.getFile();
    }

    public /* bridge */ /* synthetic */ InterfaceHttpData.HttpDataType getHttpDataType() {
        return super.getHttpDataType();
    }

    public /* bridge */ /* synthetic */ long getMaxSize() {
        return super.getMaxSize();
    }

    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    public /* bridge */ /* synthetic */ String getString() throws IOException {
        return super.getString();
    }

    public String getValue() throws IOException {
        return ((Attribute) this.wrapped).getValue();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean isCompleted() {
        return super.isCompleted();
    }

    public /* bridge */ /* synthetic */ boolean isInMemory() {
        return super.isInMemory();
    }

    public /* bridge */ /* synthetic */ long length() {
        return super.length();
    }

    public /* bridge */ /* synthetic */ boolean renameTo(File file) throws IOException {
        return super.renameTo(file);
    }

    public /* bridge */ /* synthetic */ void setCharset(Charset charset) {
        super.setCharset(charset);
    }

    public /* bridge */ /* synthetic */ void setContent(ByteBuf byteBuf) throws IOException {
        super.setContent(byteBuf);
    }

    public /* bridge */ /* synthetic */ void setMaxSize(long j) {
        super.setMaxSize(j);
    }

    public void setValue(String str) throws IOException {
        ((Attribute) this.wrapped).setValue(str);
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public MixedAttribute(String str, long j, long j2) {
        this(str, j, j2, HttpConstants.DEFAULT_CHARSET);
    }

    public /* bridge */ /* synthetic */ String getString(Charset charset) throws IOException {
        return super.getString(charset);
    }

    public Attribute makeDiskData() {
        DiskAttribute diskAttribute = new DiskAttribute(getName(), definedLength(), this.baseDir, this.deleteOnExit);
        diskAttribute.setMaxSize(getMaxSize());
        return diskAttribute;
    }

    public /* bridge */ /* synthetic */ void setContent(File file) throws IOException {
        super.setContent(file);
    }

    public MixedAttribute(String str, long j, Charset charset) {
        this(str, j, charset, DiskAttribute.baseDirectory, DiskAttribute.deleteOnExitTemporaryFile);
    }

    public Attribute copy() {
        return (Attribute) super.copy();
    }

    public Attribute duplicate() {
        return (Attribute) super.duplicate();
    }

    public Attribute replace(ByteBuf byteBuf) {
        return (Attribute) super.replace(byteBuf);
    }

    public Attribute retainedDuplicate() {
        return (Attribute) super.retainedDuplicate();
    }

    public /* bridge */ /* synthetic */ void setContent(InputStream inputStream) throws IOException {
        super.setContent(inputStream);
    }

    public MixedAttribute(String str, long j, Charset charset, String str2, boolean z) {
        this(str, 0, j, charset, str2, z);
    }

    public MixedAttribute(String str, long j, long j2, Charset charset) {
        this(str, j, j2, charset, DiskAttribute.baseDirectory, DiskAttribute.deleteOnExitTemporaryFile);
    }

    public MixedAttribute(String str, long j, long j2, Charset charset, String str2, boolean z) {
        super(j2, str2, z, new MemoryAttribute(str, j, charset));
    }

    public MixedAttribute(String str, String str2, long j) {
        this(str, str2, j, HttpConstants.DEFAULT_CHARSET, DiskAttribute.baseDirectory, DiskFileUpload.deleteOnExitTemporaryFile);
    }

    public MixedAttribute(String str, String str2, long j, Charset charset) {
        this(str, str2, j, charset, DiskAttribute.baseDirectory, DiskFileUpload.deleteOnExitTemporaryFile);
    }

    public MixedAttribute(String str, String str2, long j, Charset charset, String str3, boolean z) {
        super(j, str3, z, makeInitialAttributeFromValue(str, str2, j, charset, str3, z));
    }

    public Attribute retain() {
        return (Attribute) super.retain();
    }

    public Attribute touch() {
        return (Attribute) super.touch();
    }

    public Attribute retain(int i) {
        return (Attribute) super.retain(i);
    }

    public Attribute touch(Object obj) {
        return (Attribute) super.touch(obj);
    }
}
