package com.xjmz.myvu.flutter.pigeon;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.r9.c;
import com.honey.account.r9.d;
import com.honey.account.r9.e;
import com.honey.account.r9.f;
import com.honey.account.r9.g;
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

public class AndroidAirGlassControlApi {

    public interface AirGlassControlApi {
        static /* synthetic */ void b(AirGlassControlApi airGlassControlApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = AndroidAirGlassControlApi.b(th);
                }
            }
            airGlassControlApi.a(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        static void c(BinaryMessenger binaryMessenger, String str, AirGlassControlApi airGlassControlApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AirGlassControlApi.updateGlassVolume" + str2, getCodec());
            if (airGlassControlApi != null) {
                basicMessageChannel.setMessageHandler(new c(airGlassControlApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AirGlassControlApi.updateGlassBrightness" + str2, getCodec());
            if (airGlassControlApi != null) {
                basicMessageChannel2.setMessageHandler(new d(airGlassControlApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static /* synthetic */ void g(AirGlassControlApi airGlassControlApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            StreamType streamType = (StreamType) arrayList2.get(1);
            Boolean bool = (Boolean) arrayList2.get(2);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = AndroidAirGlassControlApi.b(th);
                }
            }
            airGlassControlApi.d(l, streamType, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8256a;
        }

        static void h(BinaryMessenger binaryMessenger, AirGlassControlApi airGlassControlApi) {
            c(binaryMessenger, "", airGlassControlApi);
        }

        void a(Long l, Boolean bool);

        void d(Long l, StreamType streamType, Boolean bool);
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface CanIgnoreReturnValue {
    }

    public static class FlutterAirGlassControlApi {

        /* renamed from: a  reason: collision with root package name */
        public final BinaryMessenger f8253a;
        public final String b;

        public FlutterAirGlassControlApi(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public static MessageCodec e() {
            return PigeonCodec.f8256a;
        }

        public static /* synthetic */ void f(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), (String) list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidAirGlassControlApi.a(str));
            }
        }

        public static /* synthetic */ void g(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), (String) list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidAirGlassControlApi.a(str));
            }
        }

        public static /* synthetic */ void h(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), (String) list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidAirGlassControlApi.a(str));
            }
        }

        public void d(Boolean bool, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterAirGlassControlApi.enableTici" + this.b;
            new BasicMessageChannel(this.f8253a, str, e()).send(new ArrayList(Collections.singletonList(bool)), new e(voidResult, str));
        }

        public void i(Long l, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterAirGlassControlApi.notifyGlassBrightness" + this.b;
            new BasicMessageChannel(this.f8253a, str, e()).send(new ArrayList(Collections.singletonList(l)), new f(voidResult, str));
        }

        public void j(GlassVolumeInfo glassVolumeInfo, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterAirGlassControlApi.notifyGlassVolume" + this.b;
            new BasicMessageChannel(this.f8253a, str, e()).send(new ArrayList(Collections.singletonList(glassVolumeInfo)), new g(voidResult, str));
        }

        public FlutterAirGlassControlApi(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.f8253a = binaryMessenger;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            this.b = str2;
        }
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

    public static final class GlassVolumeInfo {

        /* renamed from: a  reason: collision with root package name */
        public StreamType f8254a;
        public Long b;
        public Long c;
        public Long d;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public StreamType f8255a;
            public Long b;
            public Long c;
            public Long d;

            public GlassVolumeInfo a() {
                GlassVolumeInfo glassVolumeInfo = new GlassVolumeInfo();
                glassVolumeInfo.e(this.f8255a);
                glassVolumeInfo.c(this.b);
                glassVolumeInfo.d(this.c);
                glassVolumeInfo.b(this.d);
                return glassVolumeInfo;
            }

            public Builder b(Long l) {
                this.d = l;
                return this;
            }

            public Builder c(Long l) {
                this.b = l;
                return this;
            }

            public Builder d(Long l) {
                this.c = l;
                return this;
            }

            public Builder e(StreamType streamType) {
                this.f8255a = streamType;
                return this;
            }
        }

        public static GlassVolumeInfo a(ArrayList arrayList) {
            Long l;
            Long l2;
            GlassVolumeInfo glassVolumeInfo = new GlassVolumeInfo();
            glassVolumeInfo.e((StreamType) arrayList.get(0));
            Object obj = arrayList.get(1);
            Long l3 = null;
            if (obj == null) {
                l = null;
            } else {
                l = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            glassVolumeInfo.c(l);
            Object obj2 = arrayList.get(2);
            if (obj2 == null) {
                l2 = null;
            } else {
                l2 = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            glassVolumeInfo.d(l2);
            Object obj3 = arrayList.get(3);
            if (obj3 != null) {
                l3 = Long.valueOf(obj3 instanceof Integer ? (long) ((Integer) obj3).intValue() : ((Long) obj3).longValue());
            }
            glassVolumeInfo.b(l3);
            return glassVolumeInfo;
        }

        public void b(Long l) {
            if (l != null) {
                this.d = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"current\" is null.");
        }

        public void c(Long l) {
            if (l != null) {
                this.b = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"max\" is null.");
        }

        public void d(Long l) {
            if (l != null) {
                this.c = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"min\" is null.");
        }

        public void e(StreamType streamType) {
            if (streamType != null) {
                this.f8254a = streamType;
                return;
            }
            throw new IllegalStateException("Nonnull field \"streamType\" is null.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || GlassVolumeInfo.class != obj.getClass()) {
                return false;
            }
            GlassVolumeInfo glassVolumeInfo = (GlassVolumeInfo) obj;
            return this.f8254a.equals(glassVolumeInfo.f8254a) && this.b.equals(glassVolumeInfo.b) && this.c.equals(glassVolumeInfo.c) && this.d.equals(glassVolumeInfo.d);
        }

        public ArrayList f() {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(this.f8254a);
            arrayList.add(this.b);
            arrayList.add(this.c);
            arrayList.add(this.d);
            return arrayList;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8254a, this.b, this.c, this.d});
        }
    }

    public interface NullableResult<T> {
    }

    public static class PigeonCodec extends StandardMessageCodec {

        /* renamed from: a  reason: collision with root package name */
        public static final PigeonCodec f8256a = new PigeonCodec();

        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            if (b == -127) {
                return GlassVolumeInfo.a((ArrayList) readValue(byteBuffer));
            }
            if (b != -126) {
                return super.readValueOfType(b, byteBuffer);
            }
            Object readValue = readValue(byteBuffer);
            if (readValue == null) {
                return null;
            }
            return StreamType.values()[((Integer) readValue).intValue()];
        }

        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof GlassVolumeInfo) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((GlassVolumeInfo) obj).f());
            } else if (obj instanceof StreamType) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, obj == null ? null : Integer.valueOf(((StreamType) obj).index));
            } else {
                super.writeValue(byteArrayOutputStream, obj);
            }
        }
    }

    public interface Result<T> {
    }

    public enum StreamType {
        STREAM_VOICE_CALL(0),
        STREAM_MUSIC(1);
        
        final int index;

        private StreamType(int i) {
            this.index = i;
        }
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
