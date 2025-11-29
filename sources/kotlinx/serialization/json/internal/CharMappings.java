package kotlinx.serialization.json.internal;

import com.xjsd.ai.assistant.protocol.CmdCode;
import io.netty.util.internal.StringUtil;
import kotlin.Metadata;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\b\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00148\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0006X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0018¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/json/internal/CharMappings;", "", "<init>", "()V", "", "f", "e", "", "c", "", "esc", "b", "(IC)V", "a", "(CC)V", "", "cl", "d", "(IB)V", "(CB)V", "", "[C", "ESCAPE_2_CHAR", "", "[B", "CHAR_TO_TOKEN", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
public final class CharMappings {

    /* renamed from: a  reason: collision with root package name */
    public static final CharMappings f4100a;
    public static final char[] b = new char[CmdCode.CODE_TTS_PLAY_STATE];
    public static final byte[] c = new byte[126];

    static {
        CharMappings charMappings = new CharMappings();
        f4100a = charMappings;
        charMappings.f();
        charMappings.e();
    }

    public final void a(char c2, char c3) {
        b(c2, c3);
    }

    public final void b(int i, char c2) {
        if (c2 != 'u') {
            b[c2] = (char) i;
        }
    }

    public final void c(char c2, byte b2) {
        d(c2, b2);
    }

    public final void d(int i, byte b2) {
        c[i] = b2;
    }

    public final void e() {
        for (int i = 0; i < 33; i++) {
            d(i, Byte.MAX_VALUE);
        }
        d(9, (byte) 3);
        d(10, (byte) 3);
        d(13, (byte) 3);
        d(32, (byte) 3);
        c(StringUtil.COMMA, (byte) 4);
        c(':', (byte) 5);
        c('{', (byte) 6);
        c('}', (byte) 7);
        c('[', (byte) 8);
        c(']', (byte) 9);
        c('\"', (byte) 1);
        c(IOUtils.DIR_SEPARATOR_WINDOWS, (byte) 2);
    }

    public final void f() {
        for (int i = 0; i < 32; i++) {
            b(i, 'u');
        }
        b(8, 'b');
        b(9, 't');
        b(10, 'n');
        b(12, 'f');
        b(13, 'r');
        a('/', '/');
        a('\"', '\"');
        a(IOUtils.DIR_SEPARATOR_WINDOWS, IOUtils.DIR_SEPARATOR_WINDOWS);
    }
}
