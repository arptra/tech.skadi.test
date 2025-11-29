package org.apache.commons.io.input;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.StandardLineSeparator;

public class ReversedLinesFileReader implements Closeable {
    private static final int DEFAULT_BLOCK_SIZE = 8192;
    private static final String EMPTY_STRING = "";
    /* access modifiers changed from: private */
    public final int avoidNewlineSplitBufferSize;
    /* access modifiers changed from: private */
    public final int blockSize;
    /* access modifiers changed from: private */
    public final int byteDecrement;
    /* access modifiers changed from: private */
    public final SeekableByteChannel channel;
    /* access modifiers changed from: private */
    public final Charset charset;
    private FilePart currentFilePart;
    /* access modifiers changed from: private */
    public final byte[][] newLineSequences;
    private final long totalBlockCount;
    private final long totalByteLength;
    private boolean trailingNewlineOfFileSkipped;

    public class FilePart {
        private int currentLastBytePos;
        private final byte[] data;
        private byte[] leftOver;

        /* renamed from: no  reason: collision with root package name */
        private final long f9149no;

        private void createLeftOver() {
            int i = this.currentLastBytePos + 1;
            if (i > 0) {
                byte[] byteArray = IOUtils.byteArray(i);
                this.leftOver = byteArray;
                System.arraycopy(this.data, 0, byteArray, 0, i);
            } else {
                this.leftOver = null;
            }
            this.currentLastBytePos = -1;
        }

        private int getNewLineMatchByteCount(byte[] bArr, int i) {
            for (byte[] bArr2 : ReversedLinesFileReader.this.newLineSequences) {
                boolean z = true;
                for (int length = bArr2.length - 1; length >= 0; length--) {
                    int length2 = (i + length) - (bArr2.length - 1);
                    z &= length2 >= 0 && bArr[length2] == bArr2[length];
                }
                if (z) {
                    return bArr2.length;
                }
            }
            return 0;
        }

        /* access modifiers changed from: private */
        public String readLine() {
            String str;
            byte[] bArr;
            boolean z = this.f9149no == 1;
            int i = this.currentLastBytePos;
            while (true) {
                if (i > -1) {
                    if (!z && i < ReversedLinesFileReader.this.avoidNewlineSplitBufferSize) {
                        createLeftOver();
                        break;
                    }
                    int newLineMatchByteCount = getNewLineMatchByteCount(this.data, i);
                    if (newLineMatchByteCount <= 0) {
                        i -= ReversedLinesFileReader.this.byteDecrement;
                        if (i < 0) {
                            createLeftOver();
                            break;
                        }
                    } else {
                        int i2 = i + 1;
                        int i3 = (this.currentLastBytePos - i2) + 1;
                        if (i3 >= 0) {
                            byte[] byteArray = IOUtils.byteArray(i3);
                            System.arraycopy(this.data, i2, byteArray, 0, i3);
                            str = new String(byteArray, ReversedLinesFileReader.this.charset);
                            this.currentLastBytePos = i - newLineMatchByteCount;
                        } else {
                            throw new IllegalStateException("Unexpected negative line length=" + i3);
                        }
                    }
                } else {
                    break;
                }
            }
            str = null;
            if (!z || (bArr = this.leftOver) == null) {
                return str;
            }
            String str2 = new String(bArr, ReversedLinesFileReader.this.charset);
            this.leftOver = null;
            return str2;
        }

        /* access modifiers changed from: private */
        public FilePart rollOver() throws IOException {
            if (this.currentLastBytePos <= -1) {
                long j = this.f9149no;
                if (j > 1) {
                    ReversedLinesFileReader reversedLinesFileReader = ReversedLinesFileReader.this;
                    return new FilePart(j - 1, reversedLinesFileReader.blockSize, this.leftOver);
                } else if (this.leftOver == null) {
                    return null;
                } else {
                    throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(this.leftOver, ReversedLinesFileReader.this.charset));
                }
            } else {
                throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.currentLastBytePos);
            }
        }

        private FilePart(long j, int i, byte[] bArr) throws IOException {
            this.f9149no = j;
            byte[] bArr2 = new byte[((bArr != null ? bArr.length : 0) + i)];
            this.data = bArr2;
            long access$000 = (j - 1) * ((long) ReversedLinesFileReader.this.blockSize);
            if (j > 0) {
                ReversedLinesFileReader.this.channel.position(access$000);
                if (ReversedLinesFileReader.this.channel.read(ByteBuffer.wrap(bArr2, 0, i)) != i) {
                    throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
                }
            }
            if (bArr != null) {
                System.arraycopy(bArr, 0, bArr2, i, bArr.length);
            }
            this.currentLastBytePos = bArr2.length - 1;
            this.leftOver = null;
        }
    }

    @Deprecated
    public ReversedLinesFileReader(File file) throws IOException {
        this(file, 8192, Charset.defaultCharset());
    }

    public void close() throws IOException {
        this.channel.close();
    }

    public String readLine() throws IOException {
        String access$700 = this.currentFilePart.readLine();
        while (access$700 == null) {
            FilePart access$800 = this.currentFilePart.rollOver();
            this.currentFilePart = access$800;
            if (access$800 == null) {
                break;
            }
            access$700 = access$800.readLine();
        }
        if (!"".equals(access$700) || this.trailingNewlineOfFileSkipped) {
            return access$700;
        }
        this.trailingNewlineOfFileSkipped = true;
        return readLine();
    }

    public List<String> readLines(int i) throws IOException {
        if (i >= 0) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                String readLine = readLine();
                if (readLine == null) {
                    return arrayList;
                }
                arrayList.add(readLine);
            }
            return arrayList;
        }
        throw new IllegalArgumentException("lineCount < 0");
    }

    public String toString(int i) throws IOException {
        List<String> readLines = readLines(i);
        Collections.reverse(readLines);
        if (readLines.isEmpty()) {
            return "";
        }
        return String.join(System.lineSeparator(), readLines) + System.lineSeparator();
    }

    public ReversedLinesFileReader(File file, Charset charset2) throws IOException {
        this(file.toPath(), charset2);
    }

    public ReversedLinesFileReader(File file, int i, Charset charset2) throws IOException {
        this(file.toPath(), i, charset2);
    }

    public ReversedLinesFileReader(File file, int i, String str) throws IOException {
        this(file.toPath(), i, str);
    }

    public ReversedLinesFileReader(Path path, Charset charset2) throws IOException {
        this(path, 8192, charset2);
    }

    public ReversedLinesFileReader(Path path, int i, Charset charset2) throws IOException {
        int i2;
        this.blockSize = i;
        Charset charset3 = Charsets.toCharset(charset2);
        this.charset = charset3;
        if (charset3.newEncoder().maxBytesPerChar() == 1.0f) {
            this.byteDecrement = 1;
        } else if (charset3 == StandardCharsets.UTF_8) {
            this.byteDecrement = 1;
        } else if (charset3 == Charset.forName("Shift_JIS") || charset3 == Charset.forName("windows-31j") || charset3 == Charset.forName("x-windows-949") || charset3 == Charset.forName("gbk") || charset3 == Charset.forName("x-windows-950")) {
            this.byteDecrement = 1;
        } else if (charset3 == StandardCharsets.UTF_16BE || charset3 == StandardCharsets.UTF_16LE) {
            this.byteDecrement = 2;
        } else if (charset3 == StandardCharsets.UTF_16) {
            throw new UnsupportedEncodingException("For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)");
        } else {
            throw new UnsupportedEncodingException("Encoding " + charset2 + " is not supported yet (feel free to submit a patch)");
        }
        byte[][] bArr = {StandardLineSeparator.CRLF.getBytes(charset3), StandardLineSeparator.LF.getBytes(charset3), StandardLineSeparator.CR.getBytes(charset3)};
        this.newLineSequences = bArr;
        this.avoidNewlineSplitBufferSize = bArr[0].length;
        SeekableByteChannel newByteChannel = Files.newByteChannel(path, new OpenOption[]{StandardOpenOption.READ});
        this.channel = newByteChannel;
        long size = newByteChannel.size();
        this.totalByteLength = size;
        long j = (long) i;
        int i3 = (int) (size % j);
        if (i3 > 0) {
            this.totalBlockCount = (size / j) + 1;
        } else {
            this.totalBlockCount = size / j;
            if (size > 0) {
                i2 = i;
                this.currentFilePart = new FilePart(this.totalBlockCount, i2, (byte[]) null);
            }
        }
        i2 = i3;
        this.currentFilePart = new FilePart(this.totalBlockCount, i2, (byte[]) null);
    }

    public ReversedLinesFileReader(Path path, int i, String str) throws IOException {
        this(path, i, Charsets.toCharset(str));
    }
}
