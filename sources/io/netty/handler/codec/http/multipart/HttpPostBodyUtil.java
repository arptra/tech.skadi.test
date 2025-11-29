package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpHeaders;

final class HttpPostBodyUtil {
    public static final String DEFAULT_BINARY_CONTENT_TYPE = "application/octet-stream";
    public static final String DEFAULT_TEXT_CONTENT_TYPE = "text/plain";
    public static final int chunkSize = 8096;

    public static class SeekAheadOptimize {
        ByteBuf buffer;
        byte[] bytes;
        int limit;
        int origPos;
        int pos;
        int readerIndex;

        public SeekAheadOptimize(ByteBuf byteBuf) {
            if (byteBuf.hasArray()) {
                this.buffer = byteBuf;
                this.bytes = byteBuf.array();
                this.readerIndex = byteBuf.readerIndex();
                int arrayOffset = byteBuf.arrayOffset() + this.readerIndex;
                this.pos = arrayOffset;
                this.origPos = arrayOffset;
                this.limit = byteBuf.arrayOffset() + byteBuf.writerIndex();
                return;
            }
            throw new IllegalArgumentException("buffer hasn't backing byte array");
        }

        public int getReadPosition(int i) {
            return (i - this.origPos) + this.readerIndex;
        }

        public void setReadPosition(int i) {
            int i2 = this.pos - i;
            this.pos = i2;
            int readPosition = getReadPosition(i2);
            this.readerIndex = readPosition;
            this.buffer.readerIndex(readPosition);
        }
    }

    public enum TransferEncodingMechanism {
        BIT7("7bit"),
        BIT8("8bit"),
        BINARY(HttpHeaders.Values.BINARY);
        
        private final String value;

        private TransferEncodingMechanism(String str) {
            this.value = str;
        }

        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }
    }

    private HttpPostBodyUtil() {
    }

    public static int findDelimiter(ByteBuf byteBuf, int i, byte[] bArr, boolean z) {
        int bytesBefore;
        int length = bArr.length;
        int readerIndex = byteBuf.readerIndex();
        int writerIndex = byteBuf.writerIndex() - i;
        loop0:
        while (true) {
            boolean z2 = true;
            while (z2 && length <= r2 && (bytesBefore = byteBuf.bytesBefore(r9, r2, bArr[0])) >= 0) {
                r9 += bytesBefore;
                int i2 = i2 - bytesBefore;
                if (i2 >= length) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            z2 = false;
                            continue;
                            break;
                        } else if (byteBuf.getByte(r9 + i3) != bArr[i3]) {
                            r9++;
                            i2--;
                            z2 = true;
                            continue;
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                if (!z2) {
                    if (!z || r9 <= readerIndex) {
                        break;
                    } else if (byteBuf.getByte(r9 - 1) == 10) {
                        int i4 = r9 - 1;
                        r9 = (i4 <= readerIndex || byteBuf.getByte(r9 + -2) != 13) ? i4 : r9 - 2;
                    } else {
                        i = r9 + 1;
                        writerIndex = i2 - 1;
                    }
                }
            }
            return -1;
        }
        return r9 - readerIndex;
    }

    public static int findEndOfString(String str) {
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return length;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r6.getByte(r7 + r0) == 13) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (r6.getByte(r7 + r0) == 13) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        r4 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int findLastLineBreak(io.netty.buffer.ByteBuf r6, int r7) {
        /*
            int r0 = findLineBreak(r6, r7)
            r1 = 1
            r2 = 2
            r3 = 13
            if (r0 < 0) goto L_0x0017
            int r4 = r7 + r0
            byte r4 = r6.getByte(r4)
            if (r4 != r3) goto L_0x0014
        L_0x0012:
            r4 = r2
            goto L_0x0015
        L_0x0014:
            r4 = r1
        L_0x0015:
            int r0 = r0 + r4
            goto L_0x0018
        L_0x0017:
            r4 = 0
        L_0x0018:
            if (r0 <= 0) goto L_0x002c
            int r5 = r7 + r0
            int r5 = findLineBreak(r6, r5)
            if (r5 < 0) goto L_0x002c
            int r0 = r0 + r5
            int r4 = r7 + r0
            byte r4 = r6.getByte(r4)
            if (r4 != r3) goto L_0x0014
            goto L_0x0012
        L_0x002c:
            int r0 = r0 - r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.HttpPostBodyUtil.findLastLineBreak(io.netty.buffer.ByteBuf, int):int");
    }

    public static int findLineBreak(ByteBuf byteBuf, int i) {
        int bytesBefore = byteBuf.bytesBefore(i, byteBuf.readableBytes() - (i - byteBuf.readerIndex()), (byte) 10);
        if (bytesBefore == -1) {
            return -1;
        }
        return (bytesBefore <= 0 || byteBuf.getByte((i + bytesBefore) + -1) != 13) ? bytesBefore : bytesBefore - 1;
    }

    public static int findNonWhitespace(String str, int i) {
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }
}
