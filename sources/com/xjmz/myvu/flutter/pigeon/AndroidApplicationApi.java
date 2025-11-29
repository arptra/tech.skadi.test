package com.xjmz.myvu.flutter.pigeon;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.r9.c0;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class AndroidApplicationApi {

    public interface ApplicationApi {
        static void b(BinaryMessenger binaryMessenger, String str, ApplicationApi applicationApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.ApplicationApi.currentApplicationState" + str2, getCodec());
            if (applicationApi != null) {
                basicMessageChannel.setMessageHandler(new c0(applicationApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static /* synthetic */ void c(ApplicationApi applicationApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, applicationApi.d());
            } catch (Throwable th) {
                arrayList = AndroidApplicationApi.a(th);
            }
            reply.reply(arrayList);
        }

        static void e(BinaryMessenger binaryMessenger, ApplicationApi applicationApi) {
            b(binaryMessenger, "", applicationApi);
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8281a;
        }

        ApplicationState d();
    }

    public enum ApplicationState {
        ACTIVE(0),
        INACTIVE(1),
        BACKGROUND(2);
        
        final int index;

        private ApplicationState(int i) {
            this.index = i;
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

    public static class PigeonCodec extends StandardMessageCodec {

        /* renamed from: a  reason: collision with root package name */
        public static final PigeonCodec f8281a = new PigeonCodec();

        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            if (b != -127) {
                return super.readValueOfType(b, byteBuffer);
            }
            Object readValue = readValue(byteBuffer);
            if (readValue == null) {
                return null;
            }
            return ApplicationState.values()[((Integer) readValue).intValue()];
        }

        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof ApplicationState) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, obj == null ? null : Integer.valueOf(((ApplicationState) obj).index));
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
