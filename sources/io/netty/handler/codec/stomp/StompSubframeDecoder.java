package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.AppendableCharSequence;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import okio.Utf8;
import org.apache.commons.io.IOUtils;

public class StompSubframeDecoder extends ReplayingDecoder<State> {
    private static final int DEFAULT_CHUNK_SIZE = 8132;
    private static final int DEFAULT_MAX_LINE_LENGTH = 1024;
    private int alreadyReadChunkSize;
    private final Utf8LineParser commandParser;
    private long contentLength;
    private final HeaderParser headerParser;
    private LastStompContentSubframe lastContent;
    private final int maxChunkSize;

    /* renamed from: io.netty.handler.codec.stomp.StompSubframeDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.netty.handler.codec.stomp.StompSubframeDecoder$State[] r0 = io.netty.handler.codec.stomp.StompSubframeDecoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State = r0
                io.netty.handler.codec.stomp.StompSubframeDecoder$State r1 = io.netty.handler.codec.stomp.StompSubframeDecoder.State.SKIP_CONTROL_CHARACTERS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.stomp.StompSubframeDecoder$State r1 = io.netty.handler.codec.stomp.StompSubframeDecoder.State.READ_HEADERS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.stomp.StompSubframeDecoder$State r1 = io.netty.handler.codec.stomp.StompSubframeDecoder.State.BAD_FRAME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.stomp.StompSubframeDecoder$State r1 = io.netty.handler.codec.stomp.StompSubframeDecoder.State.READ_CONTENT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State     // Catch:{ NoSuchFieldError -> 0x003e }
                io.netty.handler.codec.stomp.StompSubframeDecoder$State r1 = io.netty.handler.codec.stomp.StompSubframeDecoder.State.FINALIZE_FRAME_READ     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.stomp.StompSubframeDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class HeaderParser extends Utf8LineParser {
        private String name;
        private boolean shouldUnescape;
        private boolean unescapeInProgress;
        private boolean valid;
        private final boolean validateHeaders;

        public HeaderParser(AppendableCharSequence appendableCharSequence, int i, boolean z) {
            super(appendableCharSequence, i);
            this.validateHeaders = z;
        }

        private static boolean shouldUnescape(StompCommand stompCommand) {
            return (stompCommand == StompCommand.CONNECT || stompCommand == StompCommand.CONNECTED) ? false : true;
        }

        public void appendTo(AppendableCharSequence appendableCharSequence, char c) {
            if (!this.shouldUnescape) {
                super.appendTo(appendableCharSequence, c);
            } else if (c == '\\') {
                if (this.unescapeInProgress) {
                    super.appendTo(appendableCharSequence, c);
                    this.unescapeInProgress = false;
                    return;
                }
                this.unescapeInProgress = true;
            } else if (this.unescapeInProgress) {
                if (c == 'c') {
                    appendableCharSequence.append(':');
                } else if (c == 'r') {
                    appendableCharSequence.append(13);
                } else if (c == 'n') {
                    appendableCharSequence.append(10);
                } else {
                    appendableCharSequence.append((char) IOUtils.DIR_SEPARATOR_WINDOWS).append(c);
                    throw new IllegalArgumentException("received an invalid escape header sequence '" + appendableCharSequence + '\'');
                }
                this.unescapeInProgress = false;
            } else {
                super.appendTo(appendableCharSequence, c);
            }
        }

        public boolean parseHeader(StompHeadersSubframe stompHeadersSubframe, ByteBuf byteBuf) {
            this.shouldUnescape = shouldUnescape(stompHeadersSubframe.command());
            AppendableCharSequence parse = super.parse(byteBuf);
            if (parse == null) {
                return false;
            }
            if (this.name == null && parse.length() == 0) {
                return false;
            }
            if (this.valid) {
                stompHeadersSubframe.headers().add(this.name, parse.toString());
                return true;
            } else if (!this.validateHeaders) {
                return true;
            } else {
                if (StringUtil.isNullOrEmpty(this.name)) {
                    throw new IllegalArgumentException("received an invalid header line '" + parse + '\'');
                }
                throw new IllegalArgumentException("a header value or name contains a prohibited character ':', " + (this.name + ':' + parse));
            }
        }

        public boolean process(byte b) throws Exception {
            if (b == 58) {
                if (this.name == null) {
                    AppendableCharSequence charSequence = charSequence();
                    if (charSequence.length() != 0) {
                        this.name = charSequence.substring(0, charSequence.length());
                        charSequence.reset();
                        this.valid = true;
                        return true;
                    }
                    this.name = "";
                } else {
                    this.valid = false;
                }
            }
            return super.process(b);
        }

        public void reset() {
            this.name = null;
            this.valid = false;
            this.unescapeInProgress = false;
            super.reset();
        }
    }

    public enum State {
        SKIP_CONTROL_CHARACTERS,
        READ_HEADERS,
        READ_CONTENT,
        FINALIZE_FRAME_READ,
        BAD_FRAME,
        INVALID_CHUNK
    }

    public static class Utf8LineParser implements ByteProcessor {
        private final AppendableCharSequence charSeq;
        private char interim;
        private int lineLength;
        private final int maxLineLength;
        private boolean nextRead;

        public Utf8LineParser(AppendableCharSequence appendableCharSequence, int i) {
            this.charSeq = (AppendableCharSequence) ObjectUtil.checkNotNull(appendableCharSequence, "charSeq");
            this.maxLineLength = i;
        }

        public void appendTo(AppendableCharSequence appendableCharSequence, char c) {
            appendableCharSequence.append(c);
        }

        public AppendableCharSequence charSequence() {
            return this.charSeq;
        }

        public AppendableCharSequence parse(ByteBuf byteBuf) {
            reset();
            int forEachByte = byteBuf.forEachByte(this);
            if (forEachByte == -1) {
                return null;
            }
            byteBuf.readerIndex(forEachByte + 1);
            return this.charSeq;
        }

        public boolean process(byte b) throws Exception {
            if (b == 13) {
                this.lineLength++;
                return true;
            } else if (b == 10) {
                return false;
            } else {
                int i = this.lineLength + 1;
                this.lineLength = i;
                if (i <= this.maxLineLength) {
                    if (this.nextRead) {
                        this.interim = (char) (((b & Utf8.REPLACEMENT_BYTE) << 6) | this.interim);
                        this.nextRead = false;
                    } else {
                        char c = this.interim;
                        if (c != 0) {
                            appendTo(this.charSeq, (char) ((b & '?') | c));
                            this.interim = 0;
                        } else if (b >= 0) {
                            appendTo(this.charSeq, (char) b);
                        } else if ((b & 224) == 192) {
                            this.interim = (char) ((b & 31) << 6);
                        } else {
                            this.interim = (char) ((b & 15) << 12);
                            this.nextRead = true;
                        }
                    }
                    return true;
                }
                throw new TooLongFrameException("An STOMP line is larger than " + this.maxLineLength + " bytes.");
            }
        }

        public void reset() {
            this.charSeq.reset();
            this.lineLength = 0;
            this.interim = 0;
            this.nextRead = false;
        }
    }

    public StompSubframeDecoder() {
        this(1024, DEFAULT_CHUNK_SIZE);
    }

    private static long getContentLength(StompHeaders stompHeaders) {
        AsciiString asciiString = StompHeaders.CONTENT_LENGTH;
        long j = stompHeaders.getLong(asciiString, 0);
        if (j >= 0) {
            return j;
        }
        throw new DecoderException(asciiString + " must be non-negative");
    }

    private StompCommand readCommand(ByteBuf byteBuf) {
        AppendableCharSequence parse = this.commandParser.parse(byteBuf);
        if (parse != null) {
            String charSequence = parse.toString();
            try {
                return StompCommand.valueOf(charSequence);
            } catch (IllegalArgumentException unused) {
                throw new DecoderException("Cannot to parse command " + charSequence);
            }
        } else {
            throw new DecoderException("Failed to read command from channel");
        }
    }

    private State readHeaders(ByteBuf byteBuf, StompHeadersSubframe stompHeadersSubframe) {
        StompHeaders headers = stompHeadersSubframe.headers();
        do {
        } while (this.headerParser.parseHeader(stompHeadersSubframe, byteBuf));
        if (headers.contains(StompHeaders.CONTENT_LENGTH)) {
            long contentLength2 = getContentLength(headers);
            this.contentLength = contentLength2;
            if (contentLength2 == 0) {
                return State.FINALIZE_FRAME_READ;
            }
        }
        return State.READ_CONTENT;
    }

    private void resetDecoder() {
        checkpoint(State.SKIP_CONTROL_CHARACTERS);
        this.contentLength = -1;
        this.alreadyReadChunkSize = 0;
        this.lastContent = null;
    }

    private static void skipControlCharacters(ByteBuf byteBuf) {
        while (true) {
            byte readByte = byteBuf.readByte();
            if (readByte != 13 && readByte != 10) {
                byteBuf.readerIndex(byteBuf.readerIndex() - 1);
                return;
            }
        }
    }

    private static void skipNullCharacter(ByteBuf byteBuf) {
        byte readByte = byteBuf.readByte();
        if (readByte != 0) {
            throw new IllegalStateException("unexpected byte in buffer " + readByte + " while expecting NULL byte");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d A[Catch:{ Exception -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052 A[Catch:{ Exception -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e7 A[Catch:{ Exception -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decode(io.netty.channel.ChannelHandlerContext r7, io.netty.buffer.ByteBuf r8, java.util.List<java.lang.Object> r9) throws java.lang.Exception {
        /*
            r6 = this;
            int[] r0 = io.netty.handler.codec.stomp.StompSubframeDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State
            java.lang.Object r1 = r6.state()
            io.netty.handler.codec.stomp.StompSubframeDecoder$State r1 = (io.netty.handler.codec.stomp.StompSubframeDecoder.State) r1
            int r1 = r1.ordinal()
            r1 = r0[r1]
            r2 = 1
            r3 = 0
            if (r1 == r2) goto L_0x0021
            r2 = 2
            if (r1 == r2) goto L_0x0029
            r2 = 3
            if (r1 == r2) goto L_0x0019
            goto L_0x003e
        L_0x0019:
            int r6 = r6.actualReadableBytes()
            r8.skipBytes(r6)
            return
        L_0x0021:
            skipControlCharacters(r8)
            io.netty.handler.codec.stomp.StompSubframeDecoder$State r1 = io.netty.handler.codec.stomp.StompSubframeDecoder.State.READ_HEADERS
            r6.checkpoint(r1)
        L_0x0029:
            io.netty.handler.codec.stomp.StompCommand r1 = io.netty.handler.codec.stomp.StompCommand.UNKNOWN
            io.netty.handler.codec.stomp.StompCommand r1 = r6.readCommand(r8)     // Catch:{ Exception -> 0x0120 }
            io.netty.handler.codec.stomp.DefaultStompHeadersSubframe r2 = new io.netty.handler.codec.stomp.DefaultStompHeadersSubframe     // Catch:{ Exception -> 0x0120 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0120 }
            io.netty.handler.codec.stomp.StompSubframeDecoder$State r4 = r6.readHeaders(r8, r2)     // Catch:{ Exception -> 0x011d }
            r6.checkpoint(r4)     // Catch:{ Exception -> 0x011d }
            r9.add(r2)     // Catch:{ Exception -> 0x011d }
        L_0x003e:
            java.lang.Object r1 = r6.state()     // Catch:{ Exception -> 0x008f }
            io.netty.handler.codec.stomp.StompSubframeDecoder$State r1 = (io.netty.handler.codec.stomp.StompSubframeDecoder.State) r1     // Catch:{ Exception -> 0x008f }
            int r1 = r1.ordinal()     // Catch:{ Exception -> 0x008f }
            r0 = r0[r1]     // Catch:{ Exception -> 0x008f }
            r1 = 4
            if (r0 == r1) goto L_0x0052
            r7 = 5
            if (r0 == r7) goto L_0x00e0
            goto L_0x011c
        L_0x0052:
            int r0 = r8.readableBytes()     // Catch:{ Exception -> 0x008f }
            if (r0 != 0) goto L_0x0059
            return
        L_0x0059:
            int r1 = r6.maxChunkSize     // Catch:{ Exception -> 0x008f }
            if (r0 <= r1) goto L_0x005e
            r0 = r1
        L_0x005e:
            long r1 = r6.contentLength     // Catch:{ Exception -> 0x008f }
            r4 = 0
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x009a
            int r4 = r6.alreadyReadChunkSize     // Catch:{ Exception -> 0x008f }
            long r4 = (long) r4     // Catch:{ Exception -> 0x008f }
            long r1 = r1 - r4
            int r1 = (int) r1     // Catch:{ Exception -> 0x008f }
            if (r0 <= r1) goto L_0x006e
            r0 = r1
        L_0x006e:
            io.netty.buffer.ByteBufAllocator r7 = r7.alloc()     // Catch:{ Exception -> 0x008f }
            io.netty.buffer.ByteBuf r7 = io.netty.buffer.ByteBufUtil.readBytes(r7, r8, r0)     // Catch:{ Exception -> 0x008f }
            int r1 = r6.alreadyReadChunkSize     // Catch:{ Exception -> 0x008f }
            int r1 = r1 + r0
            r6.alreadyReadChunkSize = r1     // Catch:{ Exception -> 0x008f }
            long r0 = (long) r1     // Catch:{ Exception -> 0x008f }
            long r4 = r6.contentLength     // Catch:{ Exception -> 0x008f }
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x0091
            io.netty.handler.codec.stomp.DefaultLastStompContentSubframe r0 = new io.netty.handler.codec.stomp.DefaultLastStompContentSubframe     // Catch:{ Exception -> 0x008f }
            r0.<init>(r7)     // Catch:{ Exception -> 0x008f }
            r6.lastContent = r0     // Catch:{ Exception -> 0x008f }
            io.netty.handler.codec.stomp.StompSubframeDecoder$State r7 = io.netty.handler.codec.stomp.StompSubframeDecoder.State.FINALIZE_FRAME_READ     // Catch:{ Exception -> 0x008f }
            r6.checkpoint(r7)     // Catch:{ Exception -> 0x008f }
            goto L_0x00e0
        L_0x008f:
            r7 = move-exception
            goto L_0x00fd
        L_0x0091:
            io.netty.handler.codec.stomp.DefaultStompContentSubframe r8 = new io.netty.handler.codec.stomp.DefaultStompContentSubframe     // Catch:{ Exception -> 0x008f }
            r8.<init>(r7)     // Catch:{ Exception -> 0x008f }
            r9.add(r8)     // Catch:{ Exception -> 0x008f }
            return
        L_0x009a:
            int r0 = r8.readerIndex()     // Catch:{ Exception -> 0x008f }
            int r1 = r8.writerIndex()     // Catch:{ Exception -> 0x008f }
            r2 = 0
            int r0 = io.netty.buffer.ByteBufUtil.indexOf(r8, r0, r1, r2)     // Catch:{ Exception -> 0x008f }
            int r1 = r8.readerIndex()     // Catch:{ Exception -> 0x008f }
            if (r0 != r1) goto L_0x00b3
            io.netty.handler.codec.stomp.StompSubframeDecoder$State r7 = io.netty.handler.codec.stomp.StompSubframeDecoder.State.FINALIZE_FRAME_READ     // Catch:{ Exception -> 0x008f }
            r6.checkpoint(r7)     // Catch:{ Exception -> 0x008f }
            goto L_0x00e0
        L_0x00b3:
            if (r0 <= 0) goto L_0x00bc
            int r1 = r8.readerIndex()     // Catch:{ Exception -> 0x008f }
            int r1 = r0 - r1
            goto L_0x00c5
        L_0x00bc:
            int r1 = r8.writerIndex()     // Catch:{ Exception -> 0x008f }
            int r2 = r8.readerIndex()     // Catch:{ Exception -> 0x008f }
            int r1 = r1 - r2
        L_0x00c5:
            io.netty.buffer.ByteBufAllocator r7 = r7.alloc()     // Catch:{ Exception -> 0x008f }
            io.netty.buffer.ByteBuf r7 = io.netty.buffer.ByteBufUtil.readBytes(r7, r8, r1)     // Catch:{ Exception -> 0x008f }
            int r2 = r6.alreadyReadChunkSize     // Catch:{ Exception -> 0x008f }
            int r2 = r2 + r1
            r6.alreadyReadChunkSize = r2     // Catch:{ Exception -> 0x008f }
            if (r0 <= 0) goto L_0x00f4
            io.netty.handler.codec.stomp.DefaultLastStompContentSubframe r0 = new io.netty.handler.codec.stomp.DefaultLastStompContentSubframe     // Catch:{ Exception -> 0x008f }
            r0.<init>(r7)     // Catch:{ Exception -> 0x008f }
            r6.lastContent = r0     // Catch:{ Exception -> 0x008f }
            io.netty.handler.codec.stomp.StompSubframeDecoder$State r7 = io.netty.handler.codec.stomp.StompSubframeDecoder.State.FINALIZE_FRAME_READ     // Catch:{ Exception -> 0x008f }
            r6.checkpoint(r7)     // Catch:{ Exception -> 0x008f }
        L_0x00e0:
            skipNullCharacter(r8)     // Catch:{ Exception -> 0x008f }
            io.netty.handler.codec.stomp.LastStompContentSubframe r7 = r6.lastContent     // Catch:{ Exception -> 0x008f }
            if (r7 != 0) goto L_0x00eb
            io.netty.handler.codec.stomp.LastStompContentSubframe r7 = io.netty.handler.codec.stomp.LastStompContentSubframe.EMPTY_LAST_CONTENT     // Catch:{ Exception -> 0x008f }
            r6.lastContent = r7     // Catch:{ Exception -> 0x008f }
        L_0x00eb:
            io.netty.handler.codec.stomp.LastStompContentSubframe r7 = r6.lastContent     // Catch:{ Exception -> 0x008f }
            r9.add(r7)     // Catch:{ Exception -> 0x008f }
            r6.resetDecoder()     // Catch:{ Exception -> 0x008f }
            goto L_0x011c
        L_0x00f4:
            io.netty.handler.codec.stomp.DefaultStompContentSubframe r8 = new io.netty.handler.codec.stomp.DefaultStompContentSubframe     // Catch:{ Exception -> 0x008f }
            r8.<init>(r7)     // Catch:{ Exception -> 0x008f }
            r9.add(r8)     // Catch:{ Exception -> 0x008f }
            return
        L_0x00fd:
            io.netty.handler.codec.stomp.LastStompContentSubframe r8 = r6.lastContent
            if (r8 == 0) goto L_0x0106
            r8.release()
            r6.lastContent = r3
        L_0x0106:
            io.netty.handler.codec.stomp.DefaultLastStompContentSubframe r8 = new io.netty.handler.codec.stomp.DefaultLastStompContentSubframe
            io.netty.buffer.ByteBuf r0 = io.netty.buffer.Unpooled.EMPTY_BUFFER
            r8.<init>(r0)
            io.netty.handler.codec.DecoderResult r7 = io.netty.handler.codec.DecoderResult.failure(r7)
            r8.setDecoderResult(r7)
            r9.add(r8)
            io.netty.handler.codec.stomp.StompSubframeDecoder$State r7 = io.netty.handler.codec.stomp.StompSubframeDecoder.State.BAD_FRAME
            r6.checkpoint(r7)
        L_0x011c:
            return
        L_0x011d:
            r7 = move-exception
            r3 = r2
            goto L_0x0121
        L_0x0120:
            r7 = move-exception
        L_0x0121:
            if (r3 != 0) goto L_0x0128
            io.netty.handler.codec.stomp.DefaultStompHeadersSubframe r3 = new io.netty.handler.codec.stomp.DefaultStompHeadersSubframe
            r3.<init>(r1)
        L_0x0128:
            io.netty.handler.codec.DecoderResult r7 = io.netty.handler.codec.DecoderResult.failure(r7)
            r3.setDecoderResult(r7)
            r9.add(r3)
            io.netty.handler.codec.stomp.StompSubframeDecoder$State r7 = io.netty.handler.codec.stomp.StompSubframeDecoder.State.BAD_FRAME
            r6.checkpoint(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.stomp.StompSubframeDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public StompSubframeDecoder(boolean z) {
        this(1024, DEFAULT_CHUNK_SIZE, z);
    }

    public StompSubframeDecoder(int i, int i2) {
        this(i, i2, false);
    }

    public StompSubframeDecoder(int i, int i2, boolean z) {
        super(State.SKIP_CONTROL_CHARACTERS);
        this.contentLength = -1;
        ObjectUtil.checkPositive(i, "maxLineLength");
        ObjectUtil.checkPositive(i2, "maxChunkSize");
        this.maxChunkSize = i2;
        this.commandParser = new Utf8LineParser(new AppendableCharSequence(16), i);
        this.headerParser = new HeaderParser(new AppendableCharSequence(128), i, z);
    }
}
