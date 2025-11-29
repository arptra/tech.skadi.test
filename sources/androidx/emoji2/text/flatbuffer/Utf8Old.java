package androidx.emoji2.text.flatbuffer;

import com.honey.account.u.a;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

public class Utf8Old extends Utf8 {
    public static final ThreadLocal b = ThreadLocal.withInitial(new a());

    public static class Cache {

        /* renamed from: a  reason: collision with root package name */
        public final CharsetEncoder f1234a;
        public final CharsetDecoder b;
        public CharSequence c = null;
        public ByteBuffer d = null;

        public Cache() {
            Charset charset = StandardCharsets.UTF_8;
            this.f1234a = charset.newEncoder();
            this.b = charset.newDecoder();
        }
    }

    public static /* synthetic */ Cache c() {
        return new Cache();
    }
}
