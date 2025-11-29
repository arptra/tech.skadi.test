package com.xjmz.myvu.flutter.pigeon;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.r9.t0;
import com.honey.account.r9.u0;
import com.honey.account.r9.v0;
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
import java.util.Map;
import java.util.Objects;

public class AndroidIntentApi {

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

    public interface IntentApi {
        static /* synthetic */ void a(IntentApi intentApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                intentApi.h();
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidIntentApi.a(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void b(IntentApi intentApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                intentApi.g((IntentParams) ((ArrayList) obj).get(0));
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidIntentApi.a(th);
            }
            reply.reply(arrayList);
        }

        static void c(BinaryMessenger binaryMessenger, IntentApi intentApi) {
            e(binaryMessenger, "", intentApi);
        }

        static /* synthetic */ void d(IntentApi intentApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                intentApi.i((IntentParams) ((ArrayList) obj).get(0));
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidIntentApi.a(th);
            }
            reply.reply(arrayList);
        }

        static void e(BinaryMessenger binaryMessenger, String str, IntentApi intentApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.IntentApi.openIntent" + str2, getCodec());
            if (intentApi != null) {
                basicMessageChannel.setMessageHandler(new t0(intentApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.IntentApi.checkSosContacts" + str2, getCodec());
            if (intentApi != null) {
                basicMessageChannel2.setMessageHandler(new u0(intentApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.IntentApi.sendBroadCast" + str2, getCodec());
            if (intentApi != null) {
                basicMessageChannel3.setMessageHandler(new v0(intentApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8307a;
        }

        void g(IntentParams intentParams);

        void h();

        void i(IntentParams intentParams);
    }

    public static final class IntentParams {

        /* renamed from: a  reason: collision with root package name */
        public String f8306a;
        public String b;
        public String c;
        public String d;
        public String e;
        public Long f;
        public Map g;

        public static final class Builder {
        }

        public static IntentParams a(ArrayList arrayList) {
            IntentParams intentParams = new IntentParams();
            intentParams.i((String) arrayList.get(0));
            intentParams.j((String) arrayList.get(1));
            intentParams.o((String) arrayList.get(2));
            intentParams.m((String) arrayList.get(3));
            intentParams.n((String) arrayList.get(4));
            intentParams.l((Long) arrayList.get(5));
            intentParams.k((Map) arrayList.get(6));
            return intentParams;
        }

        public String b() {
            return this.f8306a;
        }

        public String c() {
            return this.b;
        }

        public Map d() {
            return this.g;
        }

        public Long e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || IntentParams.class != obj.getClass()) {
                return false;
            }
            IntentParams intentParams = (IntentParams) obj;
            return this.f8306a.equals(intentParams.f8306a) && Objects.equals(this.b, intentParams.b) && Objects.equals(this.c, intentParams.c) && Objects.equals(this.d, intentParams.d) && Objects.equals(this.e, intentParams.e) && Objects.equals(this.f, intentParams.f) && Objects.equals(this.g, intentParams.g);
        }

        public String f() {
            return this.d;
        }

        public String g() {
            return this.e;
        }

        public String h() {
            return this.c;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8306a, this.b, this.c, this.d, this.e, this.f, this.g});
        }

        public void i(String str) {
            if (str != null) {
                this.f8306a = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"mAction\" is null.");
        }

        public void j(String str) {
            this.b = str;
        }

        public void k(Map map) {
            this.g = map;
        }

        public void l(Long l) {
            this.f = l;
        }

        public void m(String str) {
            this.d = str;
        }

        public void n(String str) {
            this.e = str;
        }

        public void o(String str) {
            this.c = str;
        }

        public ArrayList p() {
            ArrayList arrayList = new ArrayList(7);
            arrayList.add(this.f8306a);
            arrayList.add(this.b);
            arrayList.add(this.c);
            arrayList.add(this.d);
            arrayList.add(this.e);
            arrayList.add(this.f);
            arrayList.add(this.g);
            return arrayList;
        }
    }

    public static class PigeonCodec extends StandardMessageCodec {

        /* renamed from: a  reason: collision with root package name */
        public static final PigeonCodec f8307a = new PigeonCodec();

        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            return b != -127 ? super.readValueOfType(b, byteBuffer) : IntentParams.a((ArrayList) readValue(byteBuffer));
        }

        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof IntentParams) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((IntentParams) obj).p());
                return;
            }
            super.writeValue(byteArrayOutputStream, obj);
        }
    }

    public static ArrayList a(Throwable th) {
        ArrayList arrayList = new ArrayList(3);
        if (th instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) th;
            arrayList.add(flutterError.code);
            arrayList.add(flutterError.getMessage());
            arrayList.add(flutterError.details);
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        }
        return arrayList;
    }
}
