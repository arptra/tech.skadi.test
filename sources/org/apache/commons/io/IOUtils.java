package org.apache.commons.io;

import com.here.posclient.UpdateOptions;
import com.honey.account.rb.e;
import com.honey.account.rb.f;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import org.apache.commons.io.function.IOConsumer;
import org.apache.commons.io.output.AppendableWriter;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.io.output.NullOutputStream;
import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.commons.io.output.ThresholdingOutputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;

public class IOUtils {
    public static final int CR = 13;
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    public static final char DIR_SEPARATOR = File.separatorChar;
    public static final char DIR_SEPARATOR_UNIX = '/';
    public static final char DIR_SEPARATOR_WINDOWS = '\\';
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final int EOF = -1;
    public static final int LF = 10;
    @Deprecated
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String LINE_SEPARATOR_UNIX = StandardLineSeparator.LF.getString();
    public static final String LINE_SEPARATOR_WINDOWS = StandardLineSeparator.CRLF.getString();
    private static final ThreadLocal<byte[]> SKIP_BYTE_BUFFER = ThreadLocal.withInitial(new e());
    private static final ThreadLocal<char[]> SKIP_CHAR_BUFFER = ThreadLocal.withInitial(new f());

    public static BufferedInputStream buffer(InputStream inputStream) {
        Objects.requireNonNull(inputStream, "inputStream");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
    }

    public static byte[] byteArray() {
        return byteArray(8192);
    }

    /* access modifiers changed from: private */
    public static char[] charArray() {
        return charArray(8192);
    }

    public static void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }

    public static void closeQuietly(Closeable closeable) {
        closeQuietly(closeable, (Consumer<IOException>) null);
    }

    public static long consume(InputStream inputStream) throws IOException {
        return copyLarge(inputStream, (OutputStream) NullOutputStream.NULL_OUTPUT_STREAM, getByteArray());
    }

    public static boolean contentEquals(InputStream inputStream, InputStream inputStream2) throws IOException {
        int read;
        int read2;
        if (inputStream == inputStream2) {
            return true;
        }
        if (inputStream == null || inputStream2 == null) {
            return false;
        }
        byte[] byteArray = getByteArray();
        byte[] byteArray2 = byteArray();
        while (true) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i < 8192) {
                    if (i2 == i) {
                        do {
                            read2 = inputStream.read(byteArray, i2, 8192 - i2);
                        } while (read2 == 0);
                        if (read2 != -1) {
                            i2 += read2;
                        } else if (i3 == i && inputStream2.read() == -1) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    if (i3 == i) {
                        do {
                            read = inputStream2.read(byteArray2, i3, 8192 - i3);
                        } while (read == 0);
                        if (read != -1) {
                            i3 += read;
                        } else if (i2 == i && inputStream.read() == -1) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    if (byteArray[i] != byteArray2[i]) {
                        return false;
                    }
                    i++;
                }
            }
        }
    }

    public static boolean contentEqualsIgnoreEOL(Reader reader, Reader reader2) throws IOException {
        boolean z = true;
        if (reader == reader2) {
            return true;
        }
        boolean z2 = reader == null;
        if (reader2 != null) {
            z = false;
        }
        if (z ^ z2) {
            return false;
        }
        BufferedReader bufferedReader = toBufferedReader(reader);
        BufferedReader bufferedReader2 = toBufferedReader(reader2);
        String readLine = bufferedReader.readLine();
        String readLine2 = bufferedReader2.readLine();
        while (readLine != null && readLine.equals(readLine2)) {
            readLine = bufferedReader.readLine();
            readLine2 = bufferedReader2.readLine();
        }
        return Objects.equals(readLine, readLine2);
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long copyLarge = copyLarge(inputStream, outputStream);
        if (copyLarge > UpdateOptions.SOURCE_ANY) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) throws IOException {
        return copy(inputStream, outputStream, 8192);
    }

    public static byte[] getByteArray() {
        return SKIP_BYTE_BUFFER.get();
    }

    public static char[] getCharArray() {
        return SKIP_CHAR_BUFFER.get();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$toByteArray$0(ThresholdingOutputStream thresholdingOutputStream) throws IOException {
        throw new IllegalArgumentException(String.format("Cannot read more than %,d into a byte array", new Object[]{Integer.MAX_VALUE}));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ OutputStream lambda$toByteArray$1(UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream, ThresholdingOutputStream thresholdingOutputStream) throws IOException {
        return unsynchronizedByteArrayOutputStream;
    }

    public static int length(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public static LineIterator lineIterator(InputStream inputStream, Charset charset) {
        return new LineIterator(new InputStreamReader(inputStream, Charsets.toCharset(charset)));
    }

    public static int read(InputStream inputStream, byte[] bArr) throws IOException {
        return read(inputStream, bArr, 0, bArr.length);
    }

    public static void readFully(InputStream inputStream, byte[] bArr) throws IOException {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    @Deprecated
    public static List<String> readLines(InputStream inputStream) throws IOException {
        return readLines(inputStream, Charset.defaultCharset());
    }

    public static byte[] resourceToByteArray(String str) throws IOException {
        return resourceToByteArray(str, (ClassLoader) null);
    }

    public static String resourceToString(String str, Charset charset) throws IOException {
        return resourceToString(str, charset, (ClassLoader) null);
    }

    public static URL resourceToURL(String str) throws IOException {
        return resourceToURL(str, (ClassLoader) null);
    }

    public static long skip(InputStream inputStream, long j) throws IOException {
        if (j >= 0) {
            long j2 = j;
            while (j2 > 0) {
                byte[] byteArray = getByteArray();
                long read = (long) inputStream.read(byteArray, 0, (int) Math.min(j2, (long) byteArray.length));
                if (read < 0) {
                    break;
                }
                j2 -= read;
            }
            return j - j2;
        }
        throw new IllegalArgumentException("Skip count must be non-negative, actual: " + j);
    }

    public static void skipFully(InputStream inputStream, long j) throws IOException {
        if (j >= 0) {
            long skip = skip(inputStream, j);
            if (skip != j) {
                throw new EOFException("Bytes to skip: " + j + " actual: " + skip);
            }
            return;
        }
        throw new IllegalArgumentException("Bytes to skip must not be negative: " + j);
    }

    public static InputStream toBufferedInputStream(InputStream inputStream) throws IOException {
        return ByteArrayOutputStream.toBufferedInputStream(inputStream);
    }

    public static BufferedReader toBufferedReader(Reader reader) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r5.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0039, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003a, code lost:
        r5.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003d, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] toByteArray(java.io.InputStream r5) throws java.io.IOException {
        /*
            org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream r0 = new org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream
            r0.<init>()
            org.apache.commons.io.output.ThresholdingOutputStream r1 = new org.apache.commons.io.output.ThresholdingOutputStream     // Catch:{ all -> 0x0025 }
            com.honey.account.rb.c r2 = new com.honey.account.rb.c     // Catch:{ all -> 0x0025 }
            r2.<init>()     // Catch:{ all -> 0x0025 }
            com.honey.account.rb.d r3 = new com.honey.account.rb.d     // Catch:{ all -> 0x0025 }
            r3.<init>(r0)     // Catch:{ all -> 0x0025 }
            r4 = 2147483647(0x7fffffff, float:NaN)
            r1.<init>(r4, r2, r3)     // Catch:{ all -> 0x0025 }
            copy((java.io.InputStream) r5, (java.io.OutputStream) r1)     // Catch:{ all -> 0x0027 }
            byte[] r5 = r0.toByteArray()     // Catch:{ all -> 0x0027 }
            r1.close()     // Catch:{ all -> 0x0025 }
            r0.close()
            return r5
        L_0x0025:
            r5 = move-exception
            goto L_0x0033
        L_0x0027:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r2 = move-exception
            r1.close()     // Catch:{ all -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r1 = move-exception
            r5.addSuppressed(r1)     // Catch:{ all -> 0x0025 }
        L_0x0032:
            throw r2     // Catch:{ all -> 0x0025 }
        L_0x0033:
            throw r5     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r0 = move-exception
            r5.addSuppressed(r0)
        L_0x003d:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.IOUtils.toByteArray(java.io.InputStream):byte[]");
    }

    @Deprecated
    public static char[] toCharArray(InputStream inputStream) throws IOException {
        return toCharArray(inputStream, Charset.defaultCharset());
    }

    @Deprecated
    public static InputStream toInputStream(CharSequence charSequence) {
        return toInputStream(charSequence, Charset.defaultCharset());
    }

    @Deprecated
    public static String toString(byte[] bArr) {
        return new String(bArr, Charset.defaultCharset());
    }

    public static void write(byte[] bArr, OutputStream outputStream) throws IOException {
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }

    public static void writeChunked(byte[] bArr, OutputStream outputStream) throws IOException {
        if (bArr != null) {
            int length = bArr.length;
            int i = 0;
            while (length > 0) {
                int min = Math.min(length, 8192);
                outputStream.write(bArr, i, min);
                length -= min;
                i += min;
            }
        }
    }

    @Deprecated
    public static void writeLines(Collection<?> collection, String str, OutputStream outputStream) throws IOException {
        writeLines(collection, str, outputStream, Charset.defaultCharset());
    }

    public static Writer writer(Appendable appendable) {
        Objects.requireNonNull(appendable, "appendable");
        return appendable instanceof Writer ? (Writer) appendable : appendable instanceof StringBuilder ? new StringBuilderWriter((StringBuilder) appendable) : new AppendableWriter(appendable);
    }

    public static byte[] byteArray(int i) {
        return new byte[i];
    }

    private static char[] charArray(int i) {
        return new char[i];
    }

    public static void close(Closeable... closeableArr) throws IOException {
        if (closeableArr != null) {
            for (Closeable close : closeableArr) {
                close(close);
            }
        }
    }

    public static void closeQuietly(Closeable... closeableArr) {
        if (closeableArr != null) {
            for (Closeable closeQuietly : closeableArr) {
                closeQuietly(closeQuietly);
            }
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        return copyLarge(inputStream, outputStream, byteArray(i));
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        Objects.requireNonNull(inputStream, "inputStream");
        Objects.requireNonNull(outputStream, "outputStream");
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public static int length(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        return cArr.length;
    }

    public static LineIterator lineIterator(InputStream inputStream, String str) {
        return lineIterator(inputStream, Charsets.toCharset(str));
    }

    public static int read(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = i2;
            while (i3 > 0) {
                int read = inputStream.read(bArr, (i2 - i3) + i, i3);
                if (-1 == read) {
                    break;
                }
                i3 -= read;
            }
            return i2 - i3;
        }
        throw new IllegalArgumentException("Length must not be negative: " + i2);
    }

    public static void readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int read = read(inputStream, bArr, i, i2);
        if (read != i2) {
            throw new EOFException("Length to read: " + i2 + " actual: " + read);
        }
    }

    public static List<String> readLines(InputStream inputStream, Charset charset) throws IOException {
        return readLines((Reader) new InputStreamReader(inputStream, Charsets.toCharset(charset)));
    }

    public static byte[] resourceToByteArray(String str, ClassLoader classLoader) throws IOException {
        return toByteArray(resourceToURL(str, classLoader));
    }

    public static String resourceToString(String str, Charset charset, ClassLoader classLoader) throws IOException {
        return toString(resourceToURL(str, classLoader), charset);
    }

    public static URL resourceToURL(String str, ClassLoader classLoader) throws IOException {
        URL resource = classLoader == null ? IOUtils.class.getResource(str) : classLoader.getResource(str);
        if (resource != null) {
            return resource;
        }
        throw new IOException("Resource not found: " + str);
    }

    public static InputStream toBufferedInputStream(InputStream inputStream, int i) throws IOException {
        return ByteArrayOutputStream.toBufferedInputStream(inputStream, i);
    }

    public static BufferedReader toBufferedReader(Reader reader, int i) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i);
    }

    public static char[] toCharArray(InputStream inputStream, Charset charset) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        copy(inputStream, (Writer) charArrayWriter, charset);
        return charArrayWriter.toCharArray();
    }

    public static InputStream toInputStream(CharSequence charSequence, Charset charset) {
        return toInputStream(charSequence.toString(), charset);
    }

    public static String toString(byte[] bArr, String str) {
        return new String(bArr, Charsets.toCharset(str));
    }

    @Deprecated
    public static void write(byte[] bArr, Writer writer) throws IOException {
        write(bArr, writer, Charset.defaultCharset());
    }

    public static void writeLines(Collection<?> collection, String str, OutputStream outputStream, Charset charset) throws IOException {
        if (collection != null) {
            if (str == null) {
                str = System.lineSeparator();
            }
            Charset charset2 = Charsets.toCharset(charset);
            for (Object next : collection) {
                if (next != null) {
                    outputStream.write(next.toString().getBytes(charset2));
                }
                outputStream.write(str.getBytes(charset2));
            }
        }
    }

    public static BufferedInputStream buffer(InputStream inputStream, int i) {
        Objects.requireNonNull(inputStream, "inputStream");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i);
    }

    @Deprecated
    public static void copy(InputStream inputStream, Writer writer) throws IOException {
        copy(inputStream, writer, Charset.defaultCharset());
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static LineIterator lineIterator(Reader reader) {
        return new LineIterator(reader);
    }

    public static InputStream toInputStream(CharSequence charSequence, String str) {
        return toInputStream(charSequence, Charsets.toCharset(str));
    }

    @Deprecated
    public static String toString(InputStream inputStream) throws IOException {
        return toString(inputStream, Charset.defaultCharset());
    }

    public static void write(byte[] bArr, Writer writer, Charset charset) throws IOException {
        if (bArr != null) {
            writer.write(new String(bArr, Charsets.toCharset(charset)));
        }
    }

    public static void close(Closeable closeable, IOConsumer<IOException> iOConsumer) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                if (iOConsumer != null) {
                    iOConsumer.accept(e);
                }
            }
        }
    }

    public static void closeQuietly(Closeable closeable, Consumer<IOException> consumer) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                if (consumer != null) {
                    consumer.accept(e);
                }
            }
        }
    }

    public static void copy(InputStream inputStream, Writer writer, Charset charset) throws IOException {
        copy((Reader) new InputStreamReader(inputStream, Charsets.toCharset(charset)), writer);
    }

    public static int length(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0004 A[LOOP:0: B:1:0x0004->B:4:0x000f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int read(java.nio.channels.ReadableByteChannel r3, java.nio.ByteBuffer r4) throws java.io.IOException {
        /*
            int r0 = r4.remaining()
        L_0x0004:
            int r1 = r4.remaining()
            if (r1 <= 0) goto L_0x0011
            int r1 = r3.read(r4)
            r2 = -1
            if (r2 != r1) goto L_0x0004
        L_0x0011:
            int r3 = r4.remaining()
            int r0 = r0 - r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.IOUtils.read(java.nio.channels.ReadableByteChannel, java.nio.ByteBuffer):int");
    }

    public static byte[] readFully(InputStream inputStream, int i) throws IOException {
        byte[] byteArray = byteArray(i);
        readFully(inputStream, byteArray, 0, byteArray.length);
        return byteArray;
    }

    public static List<String> readLines(InputStream inputStream, String str) throws IOException {
        return readLines(inputStream, Charsets.toCharset(str));
    }

    public static long skip(ReadableByteChannel readableByteChannel, long j) throws IOException {
        if (j >= 0) {
            ByteBuffer allocate = ByteBuffer.allocate((int) Math.min(j, 8192));
            long j2 = j;
            while (j2 > 0) {
                allocate.position(0);
                allocate.limit((int) Math.min(j2, 8192));
                int read = readableByteChannel.read(allocate);
                if (read == -1) {
                    break;
                }
                j2 -= (long) read;
            }
            return j - j2;
        }
        throw new IllegalArgumentException("Skip count must be non-negative, actual: " + j);
    }

    public static void skipFully(ReadableByteChannel readableByteChannel, long j) throws IOException {
        if (j >= 0) {
            long skip = skip(readableByteChannel, j);
            if (skip != j) {
                throw new EOFException("Bytes to skip: " + j + " actual: " + skip);
            }
            return;
        }
        throw new IllegalArgumentException("Bytes to skip must not be negative: " + j);
    }

    @Deprecated
    public static InputStream toInputStream(String str) {
        return toInputStream(str, Charset.defaultCharset());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r2 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String toString(java.io.InputStream r1, java.nio.charset.Charset r2) throws java.io.IOException {
        /*
            org.apache.commons.io.output.StringBuilderWriter r0 = new org.apache.commons.io.output.StringBuilderWriter
            r0.<init>()
            copy((java.io.InputStream) r1, (java.io.Writer) r0, (java.nio.charset.Charset) r2)     // Catch:{ all -> 0x0010 }
            java.lang.String r1 = r0.toString()     // Catch:{ all -> 0x0010 }
            r0.close()
            return r1
        L_0x0010:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0017 }
            goto L_0x001b
        L_0x0017:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x001b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.IOUtils.toString(java.io.InputStream, java.nio.charset.Charset):java.lang.String");
    }

    public static void write(byte[] bArr, Writer writer, String str) throws IOException {
        write(bArr, writer, Charsets.toCharset(str));
    }

    public static void writeChunked(char[] cArr, Writer writer) throws IOException {
        if (cArr != null) {
            int length = cArr.length;
            int i = 0;
            while (length > 0) {
                int min = Math.min(length, 8192);
                writer.write(cArr, i, min);
                length -= min;
                i += min;
            }
        }
    }

    public static BufferedOutputStream buffer(OutputStream outputStream) {
        Objects.requireNonNull(outputStream, "outputStream");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream);
    }

    public static List<String> readLines(Reader reader) throws IOException {
        BufferedReader bufferedReader = toBufferedReader(reader);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    public static char[] toCharArray(InputStream inputStream, String str) throws IOException {
        return toCharArray(inputStream, Charsets.toCharset(str));
    }

    public static InputStream toInputStream(String str, Charset charset) {
        return new ByteArrayInputStream(str.getBytes(Charsets.toCharset(charset)));
    }

    @Deprecated
    public static void write(char[] cArr, OutputStream outputStream) throws IOException {
        write(cArr, outputStream, Charset.defaultCharset());
    }

    public static void close(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    public static void closeQuietly(InputStream inputStream) {
        closeQuietly((Closeable) inputStream);
    }

    public static void copy(InputStream inputStream, Writer writer, String str) throws IOException {
        copy(inputStream, writer, Charsets.toCharset(str));
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, long j, long j2) throws IOException {
        return copyLarge(inputStream, outputStream, j, j2, getByteArray());
    }

    public static void readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        int remaining = byteBuffer.remaining();
        int read = read(readableByteChannel, byteBuffer);
        if (read != remaining) {
            throw new EOFException("Length to read: " + remaining + " actual: " + read);
        }
    }

    public static char[] toCharArray(Reader reader) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        copy(reader, (Writer) charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static InputStream toInputStream(String str, String str2) {
        return new ByteArrayInputStream(str.getBytes(Charsets.toCharset(str2)));
    }

    public static void write(char[] cArr, OutputStream outputStream, Charset charset) throws IOException {
        if (cArr != null) {
            outputStream.write(new String(cArr).getBytes(Charsets.toCharset(charset)));
        }
    }

    public static BufferedOutputStream buffer(OutputStream outputStream, int i) {
        Objects.requireNonNull(outputStream, "outputStream");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i);
    }

    public static void closeQuietly(OutputStream outputStream) {
        closeQuietly((Closeable) outputStream);
    }

    public static long copy(Reader reader, Appendable appendable) throws IOException {
        return copy(reader, appendable, CharBuffer.allocate(8192));
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, long j, long j2, byte[] bArr) throws IOException {
        long j3 = 0;
        if (j > 0) {
            skipFully(inputStream, j);
        }
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        int length = bArr.length;
        int i2 = (i <= 0 || j2 >= ((long) length)) ? length : (int) j2;
        while (i2 > 0) {
            int read = inputStream.read(bArr, 0, i2);
            if (-1 == read) {
                break;
            }
            outputStream.write(bArr, 0, read);
            j3 += (long) read;
            if (i > 0) {
                i2 = (int) Math.min(j2 - j3, (long) length);
            }
        }
        return j3;
    }

    public static void skipFully(Reader reader, long j) throws IOException {
        long skip = skip(reader, j);
        if (skip != j) {
            throw new EOFException("Chars to skip: " + j + " actual: " + skip);
        }
    }

    public static void write(char[] cArr, OutputStream outputStream, String str) throws IOException {
        write(cArr, outputStream, Charsets.toCharset(str));
    }

    public static void writeLines(Collection<?> collection, String str, OutputStream outputStream, String str2) throws IOException {
        writeLines(collection, str, outputStream, Charsets.toCharset(str2));
    }

    public static void closeQuietly(Reader reader) {
        closeQuietly((Closeable) reader);
    }

    public static boolean contentEquals(Reader reader, Reader reader2) throws IOException {
        int read;
        int read2;
        if (reader == reader2) {
            return true;
        }
        if (reader == null || reader2 == null) {
            return false;
        }
        char[] charArray = getCharArray();
        char[] charArray2 = charArray();
        while (true) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i < 8192) {
                    if (i2 == i) {
                        do {
                            read2 = reader.read(charArray, i2, 8192 - i2);
                        } while (read2 == 0);
                        if (read2 != -1) {
                            i2 += read2;
                        } else if (i3 == i && reader2.read() == -1) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    if (i3 == i) {
                        do {
                            read = reader2.read(charArray2, i3, 8192 - i3);
                        } while (read == 0);
                        if (read != -1) {
                            i3 += read;
                        } else if (i2 == i && reader.read() == -1) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    if (charArray[i] != charArray2[i]) {
                        return false;
                    }
                    i++;
                }
            }
        }
    }

    public static long copy(Reader reader, Appendable appendable, CharBuffer charBuffer) throws IOException {
        long j = 0;
        while (true) {
            int read = reader.read(charBuffer);
            if (-1 == read) {
                return j;
            }
            charBuffer.flip();
            appendable.append(charBuffer, 0, read);
            j += (long) read;
        }
    }

    public static int read(Reader reader, char[] cArr) throws IOException {
        return read(reader, cArr, 0, cArr.length);
    }

    public static void write(char[] cArr, Writer writer) throws IOException {
        if (cArr != null) {
            writer.write(cArr);
        }
    }

    public static void writeLines(Collection<?> collection, String str, Writer writer) throws IOException {
        if (collection != null) {
            if (str == null) {
                str = System.lineSeparator();
            }
            for (Object next : collection) {
                if (next != null) {
                    writer.write(next.toString());
                }
                writer.write(str);
            }
        }
    }

    public static BufferedReader buffer(Reader reader) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    public static void closeQuietly(Selector selector) {
        closeQuietly((Closeable) selector);
    }

    public static int read(Reader reader, char[] cArr, int i, int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = i2;
            while (i3 > 0) {
                int read = reader.read(cArr, (i2 - i3) + i, i3);
                if (-1 == read) {
                    break;
                }
                i3 -= read;
            }
            return i2 - i3;
        }
        throw new IllegalArgumentException("Length must not be negative: " + i2);
    }

    public static void readFully(Reader reader, char[] cArr) throws IOException {
        readFully(reader, cArr, 0, cArr.length);
    }

    public static long skip(Reader reader, long j) throws IOException {
        if (j >= 0) {
            long j2 = j;
            while (j2 > 0) {
                char[] charArray = getCharArray();
                long read = (long) reader.read(charArray, 0, (int) Math.min(j2, (long) charArray.length));
                if (read < 0) {
                    break;
                }
                j2 -= read;
            }
            return j - j2;
        }
        throw new IllegalArgumentException("Skip count must be non-negative, actual: " + j);
    }

    @Deprecated
    public static void write(CharSequence charSequence, OutputStream outputStream) throws IOException {
        write(charSequence, outputStream, Charset.defaultCharset());
    }

    public static BufferedReader buffer(Reader reader, int i) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i);
    }

    public static void closeQuietly(ServerSocket serverSocket) {
        closeQuietly((Closeable) serverSocket);
    }

    public static void readFully(Reader reader, char[] cArr, int i, int i2) throws IOException {
        int read = read(reader, cArr, i, i2);
        if (read != i2) {
            throw new EOFException("Length to read: " + i2 + " actual: " + read);
        }
    }

    public static byte[] toByteArray(InputStream inputStream, int i) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException("Size must be equal or greater than zero: " + i);
        } else if (i == 0) {
            return EMPTY_BYTE_ARRAY;
        } else {
            byte[] byteArray = byteArray(i);
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(byteArray, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == i) {
                return byteArray;
            }
            throw new IOException("Unexpected read size, current: " + i2 + ", expected: " + i);
        }
    }

    public static String toString(InputStream inputStream, String str) throws IOException {
        return toString(inputStream, Charsets.toCharset(str));
    }

    public static void write(CharSequence charSequence, OutputStream outputStream, Charset charset) throws IOException {
        if (charSequence != null) {
            write(charSequence.toString(), outputStream, charset);
        }
    }

    public static BufferedWriter buffer(Writer writer) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer);
    }

    public static void closeQuietly(Socket socket) {
        closeQuietly((Closeable) socket);
    }

    @Deprecated
    public static void copy(Reader reader, OutputStream outputStream) throws IOException {
        copy(reader, outputStream, Charset.defaultCharset());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String toString(java.io.Reader r2) throws java.io.IOException {
        /*
            org.apache.commons.io.output.StringBuilderWriter r0 = new org.apache.commons.io.output.StringBuilderWriter
            r0.<init>()
            copy((java.io.Reader) r2, (java.io.Writer) r0)     // Catch:{ all -> 0x0010 }
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x0010 }
            r0.close()
            return r2
        L_0x0010:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x0017 }
            goto L_0x001b
        L_0x0017:
            r0 = move-exception
            r2.addSuppressed(r0)
        L_0x001b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.IOUtils.toString(java.io.Reader):java.lang.String");
    }

    public static void write(CharSequence charSequence, OutputStream outputStream, String str) throws IOException {
        write(charSequence, outputStream, Charsets.toCharset(str));
    }

    public static BufferedWriter buffer(Writer writer, int i) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i);
    }

    public static void closeQuietly(Writer writer) {
        closeQuietly((Closeable) writer);
    }

    public static void copy(Reader reader, OutputStream outputStream, Charset charset) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, Charsets.toCharset(charset));
        copy(reader, (Writer) outputStreamWriter);
        outputStreamWriter.flush();
    }

    public static long copyLarge(Reader reader, Writer writer) throws IOException {
        return copyLarge(reader, writer, getCharArray());
    }

    public static void write(CharSequence charSequence, Writer writer) throws IOException {
        if (charSequence != null) {
            write(charSequence.toString(), writer);
        }
    }

    public static long copyLarge(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += (long) read;
        }
    }

    @Deprecated
    public static void write(String str, OutputStream outputStream) throws IOException {
        write(str, outputStream, Charset.defaultCharset());
    }

    public static void write(String str, OutputStream outputStream, Charset charset) throws IOException {
        if (str != null) {
            outputStream.write(str.getBytes(Charsets.toCharset(charset)));
        }
    }

    public static void copy(Reader reader, OutputStream outputStream, String str) throws IOException {
        copy(reader, outputStream, Charsets.toCharset(str));
    }

    public static long copyLarge(Reader reader, Writer writer, long j, long j2) throws IOException {
        return copyLarge(reader, writer, j, j2, getCharArray());
    }

    public static byte[] toByteArray(InputStream inputStream, long j) throws IOException {
        if (j <= UpdateOptions.SOURCE_ANY) {
            return toByteArray(inputStream, (int) j);
        }
        throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + j);
    }

    public static void write(String str, OutputStream outputStream, String str2) throws IOException {
        write(str, outputStream, Charsets.toCharset(str2));
    }

    public static int copy(Reader reader, Writer writer) throws IOException {
        long copyLarge = copyLarge(reader, writer);
        if (copyLarge > UpdateOptions.SOURCE_ANY) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static long copyLarge(Reader reader, Writer writer, long j, long j2, char[] cArr) throws IOException {
        long j3 = 0;
        if (j > 0) {
            skipFully(reader, j);
        }
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        int length = cArr.length;
        if (i > 0 && j2 < ((long) cArr.length)) {
            length = (int) j2;
        }
        while (length > 0) {
            int read = reader.read(cArr, 0, length);
            if (-1 == read) {
                break;
            }
            writer.write(cArr, 0, read);
            j3 += (long) read;
            if (i > 0) {
                length = (int) Math.min(j2 - j3, (long) cArr.length);
            }
        }
        return j3;
    }

    public static void write(String str, Writer writer) throws IOException {
        if (str != null) {
            writer.write(str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r3 != null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        r2.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r0 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long copy(java.net.URL r2, java.io.File r3) throws java.io.IOException {
        /*
            java.lang.String r0 = "file"
            java.util.Objects.requireNonNull(r3, r0)
            java.nio.file.Path r3 = r3.toPath()
            r0 = 0
            java.nio.file.OpenOption[] r0 = new java.nio.file.OpenOption[r0]
            java.io.OutputStream r3 = java.nio.file.Files.newOutputStream(r3, r0)
            long r0 = copy((java.net.URL) r2, (java.io.OutputStream) r3)     // Catch:{ all -> 0x001a }
            if (r3 == 0) goto L_0x0019
            r3.close()
        L_0x0019:
            return r0
        L_0x001a:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001c }
        L_0x001c:
            r0 = move-exception
            if (r3 == 0) goto L_0x0027
            r3.close()     // Catch:{ all -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r3 = move-exception
            r2.addSuppressed(r3)
        L_0x0027:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.IOUtils.copy(java.net.URL, java.io.File):long");
    }

    @Deprecated
    public static byte[] toByteArray(Reader reader) throws IOException {
        return toByteArray(reader, Charset.defaultCharset());
    }

    @Deprecated
    public static String toString(URI uri) throws IOException {
        return toString(uri, Charset.defaultCharset());
    }

    @Deprecated
    public static void write(StringBuffer stringBuffer, OutputStream outputStream) throws IOException {
        write(stringBuffer, outputStream, (String) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r2 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] toByteArray(java.io.Reader r1, java.nio.charset.Charset r2) throws java.io.IOException {
        /*
            org.apache.commons.io.output.ByteArrayOutputStream r0 = new org.apache.commons.io.output.ByteArrayOutputStream
            r0.<init>()
            copy((java.io.Reader) r1, (java.io.OutputStream) r0, (java.nio.charset.Charset) r2)     // Catch:{ all -> 0x0010 }
            byte[] r1 = r0.toByteArray()     // Catch:{ all -> 0x0010 }
            r0.close()
            return r1
        L_0x0010:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0017 }
            goto L_0x001b
        L_0x0017:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x001b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.IOUtils.toByteArray(java.io.Reader, java.nio.charset.Charset):byte[]");
    }

    public static String toString(URI uri, Charset charset) throws IOException {
        return toString(uri.toURL(), Charsets.toCharset(charset));
    }

    @Deprecated
    public static void write(StringBuffer stringBuffer, OutputStream outputStream, String str) throws IOException {
        if (stringBuffer != null) {
            outputStream.write(stringBuffer.toString().getBytes(Charsets.toCharset(str)));
        }
    }

    public static String toString(URI uri, String str) throws IOException {
        return toString(uri, Charsets.toCharset(str));
    }

    @Deprecated
    public static void write(StringBuffer stringBuffer, Writer writer) throws IOException {
        if (stringBuffer != null) {
            writer.write(stringBuffer.toString());
        }
    }

    @Deprecated
    public static String toString(URL url) throws IOException {
        return toString(url, Charset.defaultCharset());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        if (r1 != null) goto L_0x0013;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
        r2.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001b, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r0 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String toString(java.net.URL r1, java.nio.charset.Charset r2) throws java.io.IOException {
        /*
            java.io.InputStream r1 = r1.openStream()
            java.lang.String r2 = toString((java.io.InputStream) r1, (java.nio.charset.Charset) r2)     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x000d
            r1.close()
        L_0x000d:
            return r2
        L_0x000e:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0010 }
        L_0x0010:
            r0 = move-exception
            if (r1 == 0) goto L_0x001b
            r1.close()     // Catch:{ all -> 0x0017 }
            goto L_0x001b
        L_0x0017:
            r1 = move-exception
            r2.addSuppressed(r1)
        L_0x001b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.IOUtils.toString(java.net.URL, java.nio.charset.Charset):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r2 != null) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        r3.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        r0 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long copy(java.net.URL r2, java.io.OutputStream r3) throws java.io.IOException {
        /*
            java.lang.String r0 = "url"
            java.util.Objects.requireNonNull(r2, r0)
            java.io.InputStream r2 = r2.openStream()
            long r0 = copyLarge((java.io.InputStream) r2, (java.io.OutputStream) r3)     // Catch:{ all -> 0x0014 }
            if (r2 == 0) goto L_0x0013
            r2.close()
        L_0x0013:
            return r0
        L_0x0014:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0016 }
        L_0x0016:
            r0 = move-exception
            if (r2 == 0) goto L_0x0021
            r2.close()     // Catch:{ all -> 0x001d }
            goto L_0x0021
        L_0x001d:
            r2 = move-exception
            r3.addSuppressed(r2)
        L_0x0021:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.IOUtils.copy(java.net.URL, java.io.OutputStream):long");
    }

    public static byte[] toByteArray(Reader reader, String str) throws IOException {
        return toByteArray(reader, Charsets.toCharset(str));
    }

    @Deprecated
    public static byte[] toByteArray(String str) {
        return str.getBytes(Charset.defaultCharset());
    }

    public static byte[] toByteArray(URI uri) throws IOException {
        return toByteArray(uri.toURL());
    }

    public static String toString(URL url, String str) throws IOException {
        return toString(url, Charsets.toCharset(str));
    }

    public static byte[] toByteArray(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        try {
            return toByteArray(openConnection);
        } finally {
            close(openConnection);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        if (r2 != null) goto L_0x0013;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
        r0.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001b, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] toByteArray(java.net.URLConnection r2) throws java.io.IOException {
        /*
            java.io.InputStream r2 = r2.getInputStream()
            byte[] r0 = toByteArray((java.io.InputStream) r2)     // Catch:{ all -> 0x000e }
            if (r2 == 0) goto L_0x000d
            r2.close()
        L_0x000d:
            return r0
        L_0x000e:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0010 }
        L_0x0010:
            r1 = move-exception
            if (r2 == 0) goto L_0x001b
            r2.close()     // Catch:{ all -> 0x0017 }
            goto L_0x001b
        L_0x0017:
            r2 = move-exception
            r0.addSuppressed(r2)
        L_0x001b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.IOUtils.toByteArray(java.net.URLConnection):byte[]");
    }
}
