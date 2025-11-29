package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.AsciiString;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.AppendableCharSequence;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StompSubframeEncoder extends MessageToMessageEncoder<StompSubframe> {
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final FastThreadLocal<LinkedHashMap<CharSequence, CharSequence>> ESCAPE_HEADER_KEY_CACHE = new FastThreadLocal<LinkedHashMap<CharSequence, CharSequence>>() {
        public LinkedHashMap<CharSequence, CharSequence> initialValue() throws Exception {
            AnonymousClass1 r0 = new LinkedHashMap<CharSequence, CharSequence>(32, StompSubframeEncoder.DEFAULT_LOAD_FACTOR, true) {
                public boolean removeEldestEntry(Map.Entry entry) {
                    return size() > 32;
                }
            };
            AsciiString asciiString = StompHeaders.ACCEPT_VERSION;
            r0.put(asciiString, asciiString);
            AsciiString asciiString2 = StompHeaders.HOST;
            r0.put(asciiString2, asciiString2);
            AsciiString asciiString3 = StompHeaders.LOGIN;
            r0.put(asciiString3, asciiString3);
            AsciiString asciiString4 = StompHeaders.PASSCODE;
            r0.put(asciiString4, asciiString4);
            AsciiString asciiString5 = StompHeaders.HEART_BEAT;
            r0.put(asciiString5, asciiString5);
            AsciiString asciiString6 = StompHeaders.VERSION;
            r0.put(asciiString6, asciiString6);
            AsciiString asciiString7 = StompHeaders.SESSION;
            r0.put(asciiString7, asciiString7);
            AsciiString asciiString8 = StompHeaders.SERVER;
            r0.put(asciiString8, asciiString8);
            AsciiString asciiString9 = StompHeaders.DESTINATION;
            r0.put(asciiString9, asciiString9);
            AsciiString asciiString10 = StompHeaders.ID;
            r0.put(asciiString10, asciiString10);
            AsciiString asciiString11 = StompHeaders.ACK;
            r0.put(asciiString11, asciiString11);
            AsciiString asciiString12 = StompHeaders.TRANSACTION;
            r0.put(asciiString12, asciiString12);
            AsciiString asciiString13 = StompHeaders.RECEIPT;
            r0.put(asciiString13, asciiString13);
            AsciiString asciiString14 = StompHeaders.MESSAGE_ID;
            r0.put(asciiString14, asciiString14);
            AsciiString asciiString15 = StompHeaders.SUBSCRIPTION;
            r0.put(asciiString15, asciiString15);
            AsciiString asciiString16 = StompHeaders.RECEIPT_ID;
            r0.put(asciiString16, asciiString16);
            AsciiString asciiString17 = StompHeaders.MESSAGE;
            r0.put(asciiString17, asciiString17);
            AsciiString asciiString18 = StompHeaders.CONTENT_LENGTH;
            r0.put(asciiString18, asciiString18);
            AsciiString asciiString19 = StompHeaders.CONTENT_TYPE;
            r0.put(asciiString19, asciiString19);
            return r0;
        }
    };
    private static final int ESCAPE_HEADER_KEY_CACHE_LIMIT = 32;

    private static ByteBuf encodeContent(StompContentSubframe stompContentSubframe, ChannelHandlerContext channelHandlerContext) {
        if (!(stompContentSubframe instanceof LastStompContentSubframe)) {
            return stompContentSubframe.content().retain();
        }
        ByteBuf buffer = channelHandlerContext.alloc().buffer(stompContentSubframe.content().readableBytes() + 1);
        buffer.writeBytes(stompContentSubframe.content());
        buffer.writeByte(0);
        return buffer;
    }

    private ByteBuf encodeFullFrame(StompFrame stompFrame, ChannelHandlerContext channelHandlerContext) {
        int readableBytes = stompFrame.content().readableBytes();
        ByteBuf buffer = channelHandlerContext.alloc().buffer(headersSubFrameSize(stompFrame) + readableBytes);
        encodeHeaders(stompFrame, buffer);
        if (readableBytes > 0) {
            buffer.writeBytes(stompFrame.content());
        }
        return buffer.writeByte(0);
    }

    private static void encodeHeaders(StompHeadersSubframe stompHeadersSubframe, ByteBuf byteBuf) {
        StompCommand command = stompHeadersSubframe.command();
        ByteBufUtil.writeUtf8(byteBuf, (CharSequence) command.toString());
        byteBuf.writeByte(10);
        boolean shouldEscape = shouldEscape(command);
        LinkedHashMap linkedHashMap = ESCAPE_HEADER_KEY_CACHE.get();
        for (Map.Entry entry : stompHeadersSubframe.headers()) {
            CharSequence charSequence = (CharSequence) entry.getKey();
            if (shouldEscape) {
                CharSequence charSequence2 = (CharSequence) linkedHashMap.get(charSequence);
                if (charSequence2 == null) {
                    charSequence2 = escape(charSequence);
                    linkedHashMap.put(charSequence, charSequence2);
                }
                charSequence = charSequence2;
            }
            ByteBufUtil.writeUtf8(byteBuf, charSequence);
            byteBuf.writeByte(58);
            CharSequence charSequence3 = (CharSequence) entry.getValue();
            if (shouldEscape) {
                charSequence3 = escape(charSequence3);
            }
            ByteBufUtil.writeUtf8(byteBuf, charSequence3);
            byteBuf.writeByte(10);
        }
        byteBuf.writeByte(10);
    }

    private static CharSequence escape(CharSequence charSequence) {
        AppendableCharSequence appendableCharSequence = null;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (charAt == '\\') {
                appendableCharSequence = escapeBuilder(appendableCharSequence, charSequence, i);
                appendableCharSequence.append((CharSequence) "\\\\");
            } else if (charAt == ':') {
                appendableCharSequence = escapeBuilder(appendableCharSequence, charSequence, i);
                appendableCharSequence.append((CharSequence) "\\c");
            } else if (charAt == 10) {
                appendableCharSequence = escapeBuilder(appendableCharSequence, charSequence, i);
                appendableCharSequence.append((CharSequence) "\\n");
            } else if (charAt == 13) {
                appendableCharSequence = escapeBuilder(appendableCharSequence, charSequence, i);
                appendableCharSequence.append((CharSequence) "\\r");
            } else if (appendableCharSequence != null) {
                appendableCharSequence.append(charAt);
            }
        }
        return appendableCharSequence != null ? appendableCharSequence : charSequence;
    }

    private static AppendableCharSequence escapeBuilder(AppendableCharSequence appendableCharSequence, CharSequence charSequence, int i) {
        return appendableCharSequence != null ? appendableCharSequence : new AppendableCharSequence(charSequence.length() + 8).append(charSequence, 0, i);
    }

    private static boolean shouldEscape(StompCommand stompCommand) {
        return (stompCommand == StompCommand.CONNECT || stompCommand == StompCommand.CONNECTED) ? false : true;
    }

    public Object convertContentSubFrame(StompContentSubframe stompContentSubframe, ByteBuf byteBuf) {
        return byteBuf;
    }

    public Object convertFullFrame(StompFrame stompFrame, ByteBuf byteBuf) {
        return byteBuf;
    }

    public Object convertHeadersSubFrame(StompHeadersSubframe stompHeadersSubframe, ByteBuf byteBuf) {
        return byteBuf;
    }

    public int headersSubFrameSize(StompHeadersSubframe stompHeadersSubframe) {
        int size = (stompHeadersSubframe.headers().size() * 34) + 48;
        if (size < 128) {
            return 128;
        }
        return Math.max(size, 256);
    }

    public void encode(ChannelHandlerContext channelHandlerContext, StompSubframe stompSubframe, List<Object> list) throws Exception {
        if (stompSubframe instanceof StompFrame) {
            StompFrame stompFrame = (StompFrame) stompSubframe;
            list.add(convertFullFrame(stompFrame, encodeFullFrame(stompFrame, channelHandlerContext)));
        } else if (stompSubframe instanceof StompHeadersSubframe) {
            StompHeadersSubframe stompHeadersSubframe = (StompHeadersSubframe) stompSubframe;
            ByteBuf buffer = channelHandlerContext.alloc().buffer(headersSubFrameSize(stompHeadersSubframe));
            encodeHeaders(stompHeadersSubframe, buffer);
            list.add(convertHeadersSubFrame(stompHeadersSubframe, buffer));
        } else if (stompSubframe instanceof StompContentSubframe) {
            StompContentSubframe stompContentSubframe = (StompContentSubframe) stompSubframe;
            list.add(convertContentSubFrame(stompContentSubframe, encodeContent(stompContentSubframe, channelHandlerContext)));
        }
    }
}
