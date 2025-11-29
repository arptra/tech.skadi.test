package com.xjmz.myvu.flutter.pigeon;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.r9.f2;
import com.honey.account.r9.g2;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AndroidViewGlassControlApi {

    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(@NonNull String str, @Nullable String str2, @Nullable Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    public static class FlutterViewGlassControlApi {

        /* renamed from: a  reason: collision with root package name */
        public final BinaryMessenger f8336a;
        public final String b;

        public FlutterViewGlassControlApi(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public static MessageCodec b() {
            return PigeonCodec.f8337a;
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
                voidResult.error(AndroidViewGlassControlApi.a(str));
            }
        }

        public void d(Long l, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterViewGlassControlApi.notifyGlassBrightness" + this.b;
            new BasicMessageChannel(this.f8336a, str, b()).send(new ArrayList(Collections.singletonList(l)), new f2(voidResult, str));
        }

        public FlutterViewGlassControlApi(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.f8336a = binaryMessenger;
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
        public static final PigeonCodec f8337a = new PigeonCodec();

        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            return super.readValueOfType(b, byteBuffer);
        }

        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            super.writeValue(byteArrayOutputStream, obj);
        }
    }

    public interface Result<T> {
    }

    public interface ViewGlassControlApi {
        static void c(BinaryMessenger binaryMessenger, ViewGlassControlApi viewGlassControlApi) {
            e(binaryMessenger, "", viewGlassControlApi);
        }

        static /* synthetic */ void d(ViewGlassControlApi viewGlassControlApi, Object obj, BasicMessageChannel.Reply reply) {
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
                    arrayList = AndroidViewGlassControlApi.b(th);
                }
            }
            viewGlassControlApi.a(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        static void e(BinaryMessenger binaryMessenger, String str, ViewGlassControlApi viewGlassControlApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.ViewGlassControlApi.updateGlassBrightness" + str2, getCodec());
            if (viewGlassControlApi != null) {
                basicMessageChannel.setMessageHandler(new g2(viewGlassControlApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8337a;
        }

        void a(Long l, Boolean bool);
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
