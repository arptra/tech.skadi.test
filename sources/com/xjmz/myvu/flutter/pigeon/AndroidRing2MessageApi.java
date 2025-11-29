package com.xjmz.myvu.flutter.pigeon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.r9.j1;
import com.honey.account.r9.k1;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AndroidRing2MessageApi {

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface CanIgnoreReturnValue {
    }

    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(@NonNull String str, @Nullable String str2, @Nullable Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    public interface NullableResult<T> {
    }

    public static class PigeonCodec extends StandardMessageCodec {

        /* renamed from: a  reason: collision with root package name */
        public static final PigeonCodec f8322a = new PigeonCodec();

        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            return b != -127 ? super.readValueOfType(b, byteBuffer) : Ring2Message.a((ArrayList) readValue(byteBuffer));
        }

        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof Ring2Message) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((Ring2Message) obj).q());
                return;
            }
            super.writeValue(byteArrayOutputStream, obj);
        }
    }

    public interface Result<T> {
        void success(Object obj);
    }

    public static final class Ring2Message {

        /* renamed from: a  reason: collision with root package name */
        public String f8323a;
        public String b;
        public String c;
        public String d;
        public byte[] e;
        public String f;
        public Long g;
        public Long h;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public String f8324a;
            public String b;
            public String c;
            public String d;
            public byte[] e;
            public String f;
            public Long g;
            public Long h;

            public Ring2Message a() {
                Ring2Message ring2Message = new Ring2Message();
                ring2Message.j(this.f8324a);
                ring2Message.n(this.b);
                ring2Message.m(this.c);
                ring2Message.k(this.d);
                ring2Message.i(this.e);
                ring2Message.l(this.f);
                ring2Message.p(this.g);
                ring2Message.o(this.h);
                return ring2Message;
            }

            public Builder b(byte[] bArr) {
                this.e = bArr;
                return this;
            }

            public Builder c(String str) {
                this.f8324a = str;
                return this;
            }

            public Builder d(String str) {
                this.d = str;
                return this;
            }

            public Builder e(String str) {
                this.f = str;
                return this;
            }

            public Builder f(String str) {
                this.c = str;
                return this;
            }

            public Builder g(String str) {
                this.b = str;
                return this;
            }

            public Builder h(Long l) {
                this.h = l;
                return this;
            }

            public Builder i(Long l) {
                this.g = l;
                return this;
            }
        }

        public static Ring2Message a(ArrayList arrayList) {
            Ring2Message ring2Message = new Ring2Message();
            ring2Message.j((String) arrayList.get(0));
            ring2Message.n((String) arrayList.get(1));
            ring2Message.m((String) arrayList.get(2));
            ring2Message.k((String) arrayList.get(3));
            ring2Message.i((byte[]) arrayList.get(4));
            ring2Message.l((String) arrayList.get(5));
            ring2Message.p((Long) arrayList.get(6));
            ring2Message.o((Long) arrayList.get(7));
            return ring2Message;
        }

        public byte[] b() {
            return this.e;
        }

        public String c() {
            return this.f8323a;
        }

        public String d() {
            return this.d;
        }

        public String e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Ring2Message.class != obj.getClass()) {
                return false;
            }
            Ring2Message ring2Message = (Ring2Message) obj;
            return Objects.equals(this.f8323a, ring2Message.f8323a) && this.b.equals(ring2Message.b) && this.c.equals(ring2Message.c) && this.d.equals(ring2Message.d) && Arrays.equals(this.e, ring2Message.e) && Objects.equals(this.f, ring2Message.f) && this.g.equals(ring2Message.g) && this.h.equals(ring2Message.h);
        }

        public String f() {
            return this.c;
        }

        public String g() {
            return this.b;
        }

        public Long h() {
            return this.h;
        }

        public int hashCode() {
            return (Objects.hash(new Object[]{this.f8323a, this.b, this.c, this.d, this.f, this.g, this.h}) * 31) + Arrays.hashCode(this.e);
        }

        public void i(byte[] bArr) {
            this.e = bArr;
        }

        public void j(String str) {
            this.f8323a = str;
        }

        public void k(String str) {
            if (str != null) {
                this.d = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"message\" is null.");
        }

        public void l(String str) {
            this.f = str;
        }

        public void m(String str) {
            if (str != null) {
                this.c = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"receiverPkg\" is null.");
        }

        public void n(String str) {
            if (str != null) {
                this.b = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"senderPkg\" is null.");
        }

        public void o(Long l) {
            if (l != null) {
                this.h = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"target\" is null.");
        }

        public void p(Long l) {
            if (l != null) {
                this.g = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"version\" is null.");
        }

        public ArrayList q() {
            ArrayList arrayList = new ArrayList(8);
            arrayList.add(this.f8323a);
            arrayList.add(this.b);
            arrayList.add(this.c);
            arrayList.add(this.d);
            arrayList.add(this.e);
            arrayList.add(this.f);
            arrayList.add(this.g);
            arrayList.add(this.h);
            return arrayList;
        }
    }

    public static class Ring2MessageReceiveApi {

        /* renamed from: a  reason: collision with root package name */
        public final BinaryMessenger f8325a;
        public final String b;

        public Ring2MessageReceiveApi(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public static MessageCodec b() {
            return PigeonCodec.f8322a;
        }

        public static /* synthetic */ void c(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidRing2MessageApi.a(str));
            }
        }

        public void d(Ring2Message ring2Message, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.Ring2MessageReceiveApi.onReceiveMessage" + this.b;
            new BasicMessageChannel(this.f8325a, str, b()).send(new ArrayList(Collections.singletonList(ring2Message)), new j1(voidResult, str));
        }

        public Ring2MessageReceiveApi(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.f8325a = binaryMessenger;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            this.b = str2;
        }
    }

    public interface Ring2MessageSendApi {
        static void a(BinaryMessenger binaryMessenger, Ring2MessageSendApi ring2MessageSendApi) {
            e(binaryMessenger, "", ring2MessageSendApi);
        }

        static /* synthetic */ void b(Ring2MessageSendApi ring2MessageSendApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ring2MessageSendApi.d((Ring2Message) ((ArrayList) obj).get(0), new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        static void e(BinaryMessenger binaryMessenger, String str, Ring2MessageSendApi ring2MessageSendApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.Ring2MessageSendApi.sendMessage" + str2, getCodec());
            if (ring2MessageSendApi != null) {
                basicMessageChannel.setMessageHandler(new k1(ring2MessageSendApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8322a;
        }

        void d(Ring2Message ring2Message, Result result);
    }

    public interface VoidResult {
        void error(Throwable th);

        void success();
    }

    public static FlutterError a(String str) {
        return new FlutterError("channel-error", "Unable to establish connection on channel: " + str + ".", "");
    }
}
