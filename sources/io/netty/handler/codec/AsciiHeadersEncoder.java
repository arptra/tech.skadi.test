package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.Map;

public final class AsciiHeadersEncoder {
    private final ByteBuf buf;
    private final NewlineType newlineType;
    private final SeparatorType separatorType;

    /* renamed from: io.netty.handler.codec.AsciiHeadersEncoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        static {
            /*
                io.netty.handler.codec.AsciiHeadersEncoder$NewlineType[] r0 = io.netty.handler.codec.AsciiHeadersEncoder.NewlineType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType = r0
                r1 = 1
                io.netty.handler.codec.AsciiHeadersEncoder$NewlineType r2 = io.netty.handler.codec.AsciiHeadersEncoder.NewlineType.LF     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.AsciiHeadersEncoder$NewlineType r3 = io.netty.handler.codec.AsciiHeadersEncoder.NewlineType.CRLF     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                io.netty.handler.codec.AsciiHeadersEncoder$SeparatorType[] r2 = io.netty.handler.codec.AsciiHeadersEncoder.SeparatorType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType = r2
                io.netty.handler.codec.AsciiHeadersEncoder$SeparatorType r3 = io.netty.handler.codec.AsciiHeadersEncoder.SeparatorType.COLON     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType     // Catch:{ NoSuchFieldError -> 0x0038 }
                io.netty.handler.codec.AsciiHeadersEncoder$SeparatorType r2 = io.netty.handler.codec.AsciiHeadersEncoder.SeparatorType.COLON_SPACE     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.AsciiHeadersEncoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum NewlineType {
        LF,
        CRLF
    }

    public enum SeparatorType {
        COLON,
        COLON_SPACE
    }

    public AsciiHeadersEncoder(ByteBuf byteBuf) {
        this(byteBuf, SeparatorType.COLON_SPACE, NewlineType.CRLF);
    }

    private static void writeAscii(ByteBuf byteBuf, int i, CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            ByteBufUtil.copy((AsciiString) charSequence, 0, byteBuf, i, charSequence.length());
        } else {
            byteBuf.setCharSequence(i, charSequence, CharsetUtil.US_ASCII);
        }
    }

    public void encode(Map.Entry<CharSequence, CharSequence> entry) {
        int i;
        int i2;
        CharSequence key = entry.getKey();
        CharSequence value = entry.getValue();
        ByteBuf byteBuf = this.buf;
        int length = key.length();
        int length2 = value.length();
        int writerIndex = byteBuf.writerIndex();
        byteBuf.ensureWritable(length + length2 + 4);
        writeAscii(byteBuf, writerIndex, key);
        int i3 = writerIndex + length;
        int i4 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType[this.separatorType.ordinal()];
        if (i4 == 1) {
            byteBuf.setByte(i3, 58);
            i = i3 + 1;
        } else if (i4 == 2) {
            int i5 = i3 + 1;
            byteBuf.setByte(i3, 58);
            i = i3 + 2;
            byteBuf.setByte(i5, 32);
        } else {
            throw new Error();
        }
        writeAscii(byteBuf, i, value);
        int i6 = i + length2;
        int i7 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType[this.newlineType.ordinal()];
        if (i7 == 1) {
            byteBuf.setByte(i6, 10);
            i2 = i6 + 1;
        } else if (i7 == 2) {
            int i8 = i6 + 1;
            byteBuf.setByte(i6, 13);
            i2 = i6 + 2;
            byteBuf.setByte(i8, 10);
        } else {
            throw new Error();
        }
        byteBuf.writerIndex(i2);
    }

    public AsciiHeadersEncoder(ByteBuf byteBuf, SeparatorType separatorType2, NewlineType newlineType2) {
        this.buf = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "buf");
        this.separatorType = (SeparatorType) ObjectUtil.checkNotNull(separatorType2, "separatorType");
        this.newlineType = (NewlineType) ObjectUtil.checkNotNull(newlineType2, "newlineType");
    }
}
