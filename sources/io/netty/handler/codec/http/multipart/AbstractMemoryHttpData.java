package io.netty.handler.codec.http.multipart;

import com.here.posclient.UpdateOptions;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public abstract class AbstractMemoryHttpData extends AbstractHttpData {
    private ByteBuf byteBuf = Unpooled.EMPTY_BUFFER;
    private int chunkPosition;

    public AbstractMemoryHttpData(String str, Charset charset, long j) {
        super(str, charset, j);
    }

    public void addContent(ByteBuf byteBuf2, boolean z) throws IOException {
        if (byteBuf2 != null) {
            long readableBytes = (long) byteBuf2.readableBytes();
            try {
                checkSize(this.size + readableBytes);
                long j = this.definedSize;
                if (j <= 0 || j >= this.size + readableBytes) {
                    this.size += readableBytes;
                    ByteBuf byteBuf3 = this.byteBuf;
                    if (byteBuf3 == null) {
                        this.byteBuf = byteBuf2;
                    } else if (readableBytes == 0) {
                        byteBuf2.release();
                    } else if (byteBuf3.readableBytes() == 0) {
                        this.byteBuf.release();
                        this.byteBuf = byteBuf2;
                    } else {
                        ByteBuf byteBuf4 = this.byteBuf;
                        if (byteBuf4 instanceof CompositeByteBuf) {
                            ((CompositeByteBuf) byteBuf4).addComponent(true, byteBuf2);
                        } else {
                            CompositeByteBuf compositeBuffer = Unpooled.compositeBuffer(Integer.MAX_VALUE);
                            compositeBuffer.addComponents(true, this.byteBuf, byteBuf2);
                            this.byteBuf = compositeBuffer;
                        }
                    }
                } else {
                    byteBuf2.release();
                    throw new IOException("Out of size: " + (this.size + readableBytes) + " > " + this.definedSize);
                }
            } catch (IOException e) {
                byteBuf2.release();
                throw e;
            }
        }
        if (z) {
            setCompleted();
        } else {
            ObjectUtil.checkNotNull(byteBuf2, "buffer");
        }
    }

    public void delete() {
        ByteBuf byteBuf2 = this.byteBuf;
        if (byteBuf2 != null) {
            byteBuf2.release();
            this.byteBuf = null;
        }
    }

    public byte[] get() {
        ByteBuf byteBuf2 = this.byteBuf;
        if (byteBuf2 == null) {
            return Unpooled.EMPTY_BUFFER.array();
        }
        byte[] bArr = new byte[byteBuf2.readableBytes()];
        ByteBuf byteBuf3 = this.byteBuf;
        byteBuf3.getBytes(byteBuf3.readerIndex(), bArr);
        return bArr;
    }

    public ByteBuf getByteBuf() {
        return this.byteBuf;
    }

    public ByteBuf getChunk(int i) throws IOException {
        ByteBuf byteBuf2 = this.byteBuf;
        if (byteBuf2 == null || i == 0 || byteBuf2.readableBytes() == 0) {
            this.chunkPosition = 0;
            return Unpooled.EMPTY_BUFFER;
        }
        int readableBytes = this.byteBuf.readableBytes();
        int i2 = this.chunkPosition;
        int i3 = readableBytes - i2;
        if (i3 == 0) {
            this.chunkPosition = 0;
            return Unpooled.EMPTY_BUFFER;
        }
        if (i3 < i) {
            i = i3;
        }
        ByteBuf retainedSlice = this.byteBuf.retainedSlice(i2, i);
        this.chunkPosition += i;
        return retainedSlice;
    }

    public File getFile() throws IOException {
        throw new IOException("Not represented by a file");
    }

    public String getString() {
        return getString(HttpConstants.DEFAULT_CHARSET);
    }

    public boolean isInMemory() {
        return true;
    }

    public boolean renameTo(File file) throws IOException {
        FileChannel channel;
        ObjectUtil.checkNotNull(file, "dest");
        ByteBuf byteBuf2 = this.byteBuf;
        if (byteBuf2 != null) {
            int readableBytes = byteBuf2.readableBytes();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                channel = randomAccessFile.getChannel();
                long j = 0;
                if (this.byteBuf.nioBufferCount() == 1) {
                    ByteBuffer nioBuffer = this.byteBuf.nioBuffer();
                    while (j < ((long) readableBytes)) {
                        j += (long) channel.write(nioBuffer);
                    }
                } else {
                    ByteBuffer[] nioBuffers = this.byteBuf.nioBuffers();
                    while (j < ((long) readableBytes)) {
                        j += channel.write(nioBuffers);
                    }
                }
                channel.force(false);
                channel.close();
                randomAccessFile.close();
                return j == ((long) readableBytes);
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        } else if (file.createNewFile()) {
            return true;
        } else {
            throw new IOException("file exists already: " + file);
        }
    }

    public void setContent(ByteBuf byteBuf2) throws IOException {
        ObjectUtil.checkNotNull(byteBuf2, "buffer");
        long readableBytes = (long) byteBuf2.readableBytes();
        try {
            checkSize(readableBytes);
            long j = this.definedSize;
            if (j <= 0 || j >= readableBytes) {
                ByteBuf byteBuf3 = this.byteBuf;
                if (byteBuf3 != null) {
                    byteBuf3.release();
                }
                this.byteBuf = byteBuf2;
                this.size = readableBytes;
                setCompleted();
                return;
            }
            byteBuf2.release();
            throw new IOException("Out of size: " + readableBytes + " > " + this.definedSize);
        } catch (IOException e) {
            byteBuf2.release();
            throw e;
        }
    }

    public String getString(Charset charset) {
        ByteBuf byteBuf2 = this.byteBuf;
        if (byteBuf2 == null) {
            return "";
        }
        if (charset == null) {
            charset = HttpConstants.DEFAULT_CHARSET;
        }
        return byteBuf2.toString(charset);
    }

    public HttpData touch() {
        return touch((Object) null);
    }

    public HttpData touch(Object obj) {
        ByteBuf byteBuf2 = this.byteBuf;
        if (byteBuf2 != null) {
            byteBuf2.touch(obj);
        }
        return this;
    }

    public void setContent(InputStream inputStream) throws IOException {
        ObjectUtil.checkNotNull(inputStream, "inputStream");
        byte[] bArr = new byte[16384];
        ByteBuf buffer = Unpooled.buffer();
        try {
            int read = inputStream.read(bArr);
            int i = 0;
            while (read > 0) {
                buffer.writeBytes(bArr, 0, read);
                i += read;
                checkSize((long) i);
                read = inputStream.read(bArr);
            }
            long j = (long) i;
            this.size = j;
            long j2 = this.definedSize;
            if (j2 <= 0 || j2 >= j) {
                ByteBuf byteBuf2 = this.byteBuf;
                if (byteBuf2 != null) {
                    byteBuf2.release();
                }
                this.byteBuf = buffer;
                setCompleted();
                return;
            }
            buffer.release();
            throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
        } catch (IOException e) {
            buffer.release();
            throw e;
        }
    }

    public void setContent(File file) throws IOException {
        FileChannel channel;
        ObjectUtil.checkNotNull(file, "file");
        long length = file.length();
        if (length <= UpdateOptions.SOURCE_ANY) {
            checkSize(length);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                channel = randomAccessFile.getChannel();
                ByteBuffer wrap = ByteBuffer.wrap(new byte[((int) length)]);
                for (int i = 0; ((long) i) < length; i += channel.read(wrap)) {
                }
                channel.close();
                randomAccessFile.close();
                wrap.flip();
                ByteBuf byteBuf2 = this.byteBuf;
                if (byteBuf2 != null) {
                    byteBuf2.release();
                }
                this.byteBuf = Unpooled.wrappedBuffer(Integer.MAX_VALUE, wrap);
                this.size = length;
                setCompleted();
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("File too big to be loaded in memory");
        }
    }
}
