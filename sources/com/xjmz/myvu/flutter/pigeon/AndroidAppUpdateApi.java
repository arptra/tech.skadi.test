package com.xjmz.myvu.flutter.pigeon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.r9.a0;
import com.honey.account.r9.b0;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AndroidAppUpdateApi {

    public interface AppUpdateApi {
        static void b(BinaryMessenger binaryMessenger, String str, AppUpdateApi appUpdateApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AppUpdateApi.checkIfShowForceUpdateDialog" + str2, getCodec());
            if (appUpdateApi != null) {
                basicMessageChannel.setMessageHandler(new a0(appUpdateApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static /* synthetic */ void c(AppUpdateApi appUpdateApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            appUpdateApi.a(new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        static void e(BinaryMessenger binaryMessenger, AppUpdateApi appUpdateApi) {
            b(binaryMessenger, "", appUpdateApi);
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8280a;
        }

        void a(Result result);
    }

    public static class FlutterAppUpdateApi {

        /* renamed from: a  reason: collision with root package name */
        public final BinaryMessenger f8279a;
        public final String b;

        public FlutterAppUpdateApi(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public static MessageCodec b() {
            return PigeonCodec.f8280a;
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
                voidResult.error(AndroidAppUpdateApi.a(str));
            }
        }

        public void d(Boolean bool, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterAppUpdateApi.notifyAppUpdateBadge" + this.b;
            new BasicMessageChannel(this.f8279a, str, b()).send(new ArrayList(Collections.singletonList(bool)), new b0(voidResult, str));
        }

        public FlutterAppUpdateApi(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.f8279a = binaryMessenger;
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

    public interface NullableResult<T> {
    }

    public static class PigeonCodec extends StandardMessageCodec {

        /* renamed from: a  reason: collision with root package name */
        public static final PigeonCodec f8280a = new PigeonCodec();

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
        void error(Throwable th);

        void success();
    }

    public static FlutterError a(String str) {
        return new FlutterError("channel-error", "Unable to establish connection on channel: " + str + ".", "");
    }
}
