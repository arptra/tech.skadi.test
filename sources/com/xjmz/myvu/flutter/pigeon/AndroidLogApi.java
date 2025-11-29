package com.xjmz.myvu.flutter.pigeon;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.r9.a1;
import com.honey.account.r9.b1;
import com.honey.account.r9.c1;
import com.honey.account.r9.d1;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class AndroidLogApi {

    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(@NonNull String str, @Nullable String str2, @Nullable Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    public interface LogApi {
        static /* synthetic */ void a(LogApi logApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                logApi.l((String) ((ArrayList) obj).get(0));
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidLogApi.a(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void b(LogApi logApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                logApi.e((String) ((ArrayList) obj).get(0));
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidLogApi.a(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void d(LogApi logApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                logApi.h((String) ((ArrayList) obj).get(0));
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidLogApi.a(th);
            }
            reply.reply(arrayList);
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8313a;
        }

        static void i(BinaryMessenger binaryMessenger, String str, LogApi logApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.LogApi.logd" + str2, getCodec());
            if (logApi != null) {
                basicMessageChannel.setMessageHandler(new a1(logApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.LogApi.logi" + str2, getCodec());
            if (logApi != null) {
                basicMessageChannel2.setMessageHandler(new b1(logApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.LogApi.logw" + str2, getCodec());
            if (logApi != null) {
                basicMessageChannel3.setMessageHandler(new c1(logApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.LogApi.loge" + str2, getCodec());
            if (logApi != null) {
                basicMessageChannel4.setMessageHandler(new d1(logApi));
            } else {
                basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static void m(BinaryMessenger binaryMessenger, LogApi logApi) {
            i(binaryMessenger, "", logApi);
        }

        static /* synthetic */ void n(LogApi logApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                logApi.g((String) ((ArrayList) obj).get(0));
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidLogApi.a(th);
            }
            reply.reply(arrayList);
        }

        void e(String str);

        void g(String str);

        void h(String str);

        void l(String str);
    }

    public static class PigeonCodec extends StandardMessageCodec {

        /* renamed from: a  reason: collision with root package name */
        public static final PigeonCodec f8313a = new PigeonCodec();

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
