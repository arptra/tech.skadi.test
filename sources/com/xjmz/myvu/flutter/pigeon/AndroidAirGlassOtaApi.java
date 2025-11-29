package com.xjmz.myvu.flutter.pigeon;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.r9.h;
import com.honey.account.r9.i;
import com.honey.account.r9.j;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;

public class AndroidAirGlassOtaApi {

    public interface AirGlassOtaApi {
        static void a(BinaryMessenger binaryMessenger, AirGlassOtaApi airGlassOtaApi) {
            d(binaryMessenger, "", airGlassOtaApi);
        }

        static /* synthetic */ void b(AirGlassOtaApi airGlassOtaApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, airGlassOtaApi.i());
            } catch (Throwable th) {
                arrayList = AndroidAirGlassOtaApi.a(th);
            }
            reply.reply(arrayList);
        }

        static void d(BinaryMessenger binaryMessenger, String str, AirGlassOtaApi airGlassOtaApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AirGlassOtaApi.checkIfUpdating" + str2, getCodec());
            if (airGlassOtaApi != null) {
                basicMessageChannel.setMessageHandler(new h(airGlassOtaApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AirGlassOtaApi.signWithHMacSha256" + str2, getCodec());
            if (airGlassOtaApi != null) {
                basicMessageChannel2.setMessageHandler(new i(airGlassOtaApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AirGlassOtaApi.getDeviceModel" + str2, getCodec());
            if (airGlassOtaApi != null) {
                basicMessageChannel3.setMessageHandler(new j(airGlassOtaApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static /* synthetic */ void e(AirGlassOtaApi airGlassOtaApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, airGlassOtaApi.j((Map) ((ArrayList) obj).get(0)));
            } catch (Throwable th) {
                arrayList = AndroidAirGlassOtaApi.a(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void f(AirGlassOtaApi airGlassOtaApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            airGlassOtaApi.c(new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8258a;
        }

        void c(Result result);

        String i();

        String j(Map map);
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
        public static final PigeonCodec f8258a = new PigeonCodec();

        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            return super.readValueOfType(b, byteBuffer);
        }

        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            super.writeValue(byteArrayOutputStream, obj);
        }
    }

    public interface Result<T> {
        void success(Object obj);
    }

    public interface VoidResult {
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
