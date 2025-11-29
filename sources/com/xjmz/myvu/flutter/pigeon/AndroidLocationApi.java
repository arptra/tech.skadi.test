package com.xjmz.myvu.flutter.pigeon;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.r9.w0;
import com.honey.account.r9.x0;
import com.honey.account.r9.y0;
import com.honey.account.r9.z0;
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
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AndroidLocationApi {

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

    public static final class Location {

        /* renamed from: a  reason: collision with root package name */
        public Double f8308a;
        public Double b;
        public Double c;
        public Double d;
        public Double e;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public Double f8309a;
            public Double b;
            public Double c;
            public Double d;
            public Double e;

            public Location a() {
                Location location = new Location();
                location.d(this.f8309a);
                location.e(this.b);
                location.c(this.c);
                location.b(this.d);
                location.f(this.e);
                return location;
            }

            public Builder b(Double d2) {
                this.d = d2;
                return this;
            }

            public Builder c(Double d2) {
                this.c = d2;
                return this;
            }

            public Builder d(Double d2) {
                this.f8309a = d2;
                return this;
            }

            public Builder e(Double d2) {
                this.b = d2;
                return this;
            }

            public Builder f(Double d2) {
                this.e = d2;
                return this;
            }
        }

        public static Location a(ArrayList arrayList) {
            Location location = new Location();
            location.d((Double) arrayList.get(0));
            location.e((Double) arrayList.get(1));
            location.c((Double) arrayList.get(2));
            location.b((Double) arrayList.get(3));
            location.f((Double) arrayList.get(4));
            return location;
        }

        public void b(Double d2) {
            if (d2 != null) {
                this.d = d2;
                return;
            }
            throw new IllegalStateException("Nonnull field \"accuracy\" is null.");
        }

        public void c(Double d2) {
            if (d2 != null) {
                this.c = d2;
                return;
            }
            throw new IllegalStateException("Nonnull field \"altitude\" is null.");
        }

        public void d(Double d2) {
            if (d2 != null) {
                this.f8308a = d2;
                return;
            }
            throw new IllegalStateException("Nonnull field \"latitude\" is null.");
        }

        public void e(Double d2) {
            if (d2 != null) {
                this.b = d2;
                return;
            }
            throw new IllegalStateException("Nonnull field \"longitude\" is null.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Location.class != obj.getClass()) {
                return false;
            }
            Location location = (Location) obj;
            return this.f8308a.equals(location.f8308a) && this.b.equals(location.b) && this.c.equals(location.c) && this.d.equals(location.d) && this.e.equals(location.e);
        }

        public void f(Double d2) {
            if (d2 != null) {
                this.e = d2;
                return;
            }
            throw new IllegalStateException("Nonnull field \"speed\" is null.");
        }

        public ArrayList g() {
            ArrayList arrayList = new ArrayList(5);
            arrayList.add(this.f8308a);
            arrayList.add(this.b);
            arrayList.add(this.c);
            arrayList.add(this.d);
            arrayList.add(this.e);
            return arrayList;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8308a, this.b, this.c, this.d, this.e});
        }
    }

    public interface LocationApi {
        static void d(BinaryMessenger binaryMessenger, String str, LocationApi locationApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.LocationApi.isLocationServiceEnabled" + str2, getCodec());
            if (locationApi != null) {
                basicMessageChannel.setMessageHandler(new w0(locationApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.LocationApi.startLocation" + str2, getCodec());
            if (locationApi != null) {
                basicMessageChannel2.setMessageHandler(new x0(locationApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.LocationApi.stopLocation" + str2, getCodec());
            if (locationApi != null) {
                basicMessageChannel3.setMessageHandler(new y0(locationApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static void g(BinaryMessenger binaryMessenger, LocationApi locationApi) {
            d(binaryMessenger, "", locationApi);
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8312a;
        }

        static /* synthetic */ void h(LocationApi locationApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                locationApi.stopLocation();
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidLocationApi.b(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void i(LocationApi locationApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                locationApi.e();
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidLocationApi.b(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void j(LocationApi locationApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            locationApi.a(new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        void a(Result result);

        void e();

        void stopLocation();
    }

    public static class LocationResultApi {

        /* renamed from: a  reason: collision with root package name */
        public final BinaryMessenger f8311a;
        public final String b;

        public LocationResultApi(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public static MessageCodec b() {
            return PigeonCodec.f8312a;
        }

        public static /* synthetic */ void c(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), (String) list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidLocationApi.a(str));
            }
        }

        public void d(Location location, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.LocationResultApi.onLocationChanged" + this.b;
            new BasicMessageChannel(this.f8311a, str, b()).send(new ArrayList(Collections.singletonList(location)), new z0(voidResult, str));
        }

        public LocationResultApi(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.f8311a = binaryMessenger;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            this.b = str2;
        }
    }

    public interface NullableResult<T> {
    }

    public static class PigeonCodec extends StandardMessageCodec {

        /* renamed from: a  reason: collision with root package name */
        public static final PigeonCodec f8312a = new PigeonCodec();

        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            return b != -127 ? super.readValueOfType(b, byteBuffer) : Location.a((ArrayList) readValue(byteBuffer));
        }

        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof Location) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((Location) obj).g());
                return;
            }
            super.writeValue(byteArrayOutputStream, obj);
        }
    }

    public interface Result<T> {
        void success(Object obj);
    }

    public interface VoidResult {
        void error(Throwable th);

        void success();
    }

    public static FlutterError a(String str) {
        return new FlutterError("channel-error", "Unable to establish connection on channel: " + str + ".", "");
    }

    public static ArrayList b(Throwable th) {
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
