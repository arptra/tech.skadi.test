package com.xjmz.myvu.flutter.pigeon;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.r9.r0;
import com.honey.account.r9.s0;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;

public class AndroidDataTrackApi {

    public interface DataTrackApi {
        static /* synthetic */ void a(DataTrackApi dataTrackApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                dataTrackApi.g((String) arrayList2.get(0), (Map) arrayList2.get(1), (String) arrayList2.get(2), (String) arrayList2.get(3), (String) arrayList2.get(4));
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidDataTrackApi.a(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void b(DataTrackApi dataTrackApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                dataTrackApi.reportEvent((String) arrayList2.get(0), (Map) arrayList2.get(1));
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidDataTrackApi.a(th);
            }
            reply.reply(arrayList);
        }

        static void c(BinaryMessenger binaryMessenger, String str, DataTrackApi dataTrackApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.DataTrackApi.reportEvent" + str2, getCodec());
            if (dataTrackApi != null) {
                basicMessageChannel.setMessageHandler(new r0(dataTrackApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.DataTrackApi.reportEvent2" + str2, getCodec());
            if (dataTrackApi != null) {
                basicMessageChannel2.setMessageHandler(new s0(dataTrackApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static void e(BinaryMessenger binaryMessenger, DataTrackApi dataTrackApi) {
            c(binaryMessenger, "", dataTrackApi);
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8305a;
        }

        void g(String str, Map map, String str2, String str3, String str4);

        void reportEvent(String str, Map map);
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

    public static class PigeonCodec extends StandardMessageCodec {

        /* renamed from: a  reason: collision with root package name */
        public static final PigeonCodec f8305a = new PigeonCodec();

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
