package com.xjmz.myvu.flutter.pigeon;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.r9.e1;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class AndroidNavigatorRouteApi {

    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(@NonNull String str, @Nullable String str2, @Nullable Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    public interface NavigatorRouteApi {
        static void b(BinaryMessenger binaryMessenger, NavigatorRouteApi navigatorRouteApi) {
            d(binaryMessenger, "", navigatorRouteApi);
        }

        static /* synthetic */ void c(NavigatorRouteApi navigatorRouteApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                navigatorRouteApi.a((Boolean) ((ArrayList) obj).get(0));
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidNavigatorRouteApi.a(th);
            }
            reply.reply(arrayList);
        }

        static void d(BinaryMessenger binaryMessenger, String str, NavigatorRouteApi navigatorRouteApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.NavigatorRouteApi.notifyCanPop" + str2, getCodec());
            if (navigatorRouteApi != null) {
                basicMessageChannel.setMessageHandler(new e1(navigatorRouteApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8314a;
        }

        void a(Boolean bool);
    }

    public static class PigeonCodec extends StandardMessageCodec {

        /* renamed from: a  reason: collision with root package name */
        public static final PigeonCodec f8314a = new PigeonCodec();

        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            return super.readValueOfType(b, byteBuffer);
        }

        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
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
