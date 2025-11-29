package io.flutter.plugins.webviewflutter;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.hb.a0;
import com.honey.account.hb.a1;
import com.honey.account.hb.a2;
import com.honey.account.hb.b0;
import com.honey.account.hb.b1;
import com.honey.account.hb.b2;
import com.honey.account.hb.c;
import com.honey.account.hb.c0;
import com.honey.account.hb.c1;
import com.honey.account.hb.c2;
import com.honey.account.hb.d;
import com.honey.account.hb.d0;
import com.honey.account.hb.d1;
import com.honey.account.hb.d2;
import com.honey.account.hb.e;
import com.honey.account.hb.e0;
import com.honey.account.hb.e1;
import com.honey.account.hb.e2;
import com.honey.account.hb.f;
import com.honey.account.hb.f0;
import com.honey.account.hb.f1;
import com.honey.account.hb.f2;
import com.honey.account.hb.g;
import com.honey.account.hb.g0;
import com.honey.account.hb.g1;
import com.honey.account.hb.g2;
import com.honey.account.hb.h;
import com.honey.account.hb.h0;
import com.honey.account.hb.h1;
import com.honey.account.hb.h2;
import com.honey.account.hb.i;
import com.honey.account.hb.i0;
import com.honey.account.hb.i1;
import com.honey.account.hb.i2;
import com.honey.account.hb.j;
import com.honey.account.hb.j0;
import com.honey.account.hb.j1;
import com.honey.account.hb.j2;
import com.honey.account.hb.k;
import com.honey.account.hb.k0;
import com.honey.account.hb.k1;
import com.honey.account.hb.k2;
import com.honey.account.hb.l;
import com.honey.account.hb.l0;
import com.honey.account.hb.l1;
import com.honey.account.hb.l2;
import com.honey.account.hb.m;
import com.honey.account.hb.m0;
import com.honey.account.hb.m1;
import com.honey.account.hb.m2;
import com.honey.account.hb.n;
import com.honey.account.hb.n0;
import com.honey.account.hb.n1;
import com.honey.account.hb.n2;
import com.honey.account.hb.o;
import com.honey.account.hb.o0;
import com.honey.account.hb.o1;
import com.honey.account.hb.o2;
import com.honey.account.hb.p;
import com.honey.account.hb.p0;
import com.honey.account.hb.p1;
import com.honey.account.hb.p2;
import com.honey.account.hb.q;
import com.honey.account.hb.q0;
import com.honey.account.hb.q1;
import com.honey.account.hb.q2;
import com.honey.account.hb.r;
import com.honey.account.hb.r0;
import com.honey.account.hb.r1;
import com.honey.account.hb.r2;
import com.honey.account.hb.s;
import com.honey.account.hb.s0;
import com.honey.account.hb.s1;
import com.honey.account.hb.s2;
import com.honey.account.hb.t;
import com.honey.account.hb.t0;
import com.honey.account.hb.t1;
import com.honey.account.hb.t2;
import com.honey.account.hb.u;
import com.honey.account.hb.u0;
import com.honey.account.hb.u1;
import com.honey.account.hb.u2;
import com.honey.account.hb.v;
import com.honey.account.hb.v0;
import com.honey.account.hb.v1;
import com.honey.account.hb.v2;
import com.honey.account.hb.w;
import com.honey.account.hb.w0;
import com.honey.account.hb.w1;
import com.honey.account.hb.w2;
import com.honey.account.hb.x;
import com.honey.account.hb.x0;
import com.honey.account.hb.x1;
import com.honey.account.hb.y;
import com.honey.account.hb.y0;
import com.honey.account.hb.y1;
import com.honey.account.hb.z;
import com.honey.account.hb.z0;
import com.honey.account.hb.z1;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GeneratedAndroidWebView {

    public static final class ConsoleMessage {
        @NonNull
        private ConsoleMessageLevel level;
        @NonNull
        private Long lineNumber;
        @NonNull
        private String message;
        @NonNull
        private String sourceId;

        public static final class Builder {
            @Nullable
            private ConsoleMessageLevel level;
            @Nullable
            private Long lineNumber;
            @Nullable
            private String message;
            @Nullable
            private String sourceId;

            @NonNull
            public ConsoleMessage build() {
                ConsoleMessage consoleMessage = new ConsoleMessage();
                consoleMessage.setLineNumber(this.lineNumber);
                consoleMessage.setMessage(this.message);
                consoleMessage.setLevel(this.level);
                consoleMessage.setSourceId(this.sourceId);
                return consoleMessage;
            }

            @NonNull
            public Builder setLevel(@NonNull ConsoleMessageLevel consoleMessageLevel) {
                this.level = consoleMessageLevel;
                return this;
            }

            @NonNull
            public Builder setLineNumber(@NonNull Long l) {
                this.lineNumber = l;
                return this;
            }

            @NonNull
            public Builder setMessage(@NonNull String str) {
                this.message = str;
                return this;
            }

            @NonNull
            public Builder setSourceId(@NonNull String str) {
                this.sourceId = str;
                return this;
            }
        }

        @NonNull
        public static ConsoleMessage fromList(@NonNull ArrayList<Object> arrayList) {
            Long l;
            ConsoleMessage consoleMessage = new ConsoleMessage();
            Object obj = arrayList.get(0);
            if (obj == null) {
                l = null;
            } else {
                l = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            consoleMessage.setLineNumber(l);
            consoleMessage.setMessage((String) arrayList.get(1));
            consoleMessage.setLevel(ConsoleMessageLevel.values()[((Integer) arrayList.get(2)).intValue()]);
            consoleMessage.setSourceId((String) arrayList.get(3));
            return consoleMessage;
        }

        @NonNull
        public ConsoleMessageLevel getLevel() {
            return this.level;
        }

        @NonNull
        public Long getLineNumber() {
            return this.lineNumber;
        }

        @NonNull
        public String getMessage() {
            return this.message;
        }

        @NonNull
        public String getSourceId() {
            return this.sourceId;
        }

        public void setLevel(@NonNull ConsoleMessageLevel consoleMessageLevel) {
            if (consoleMessageLevel != null) {
                this.level = consoleMessageLevel;
                return;
            }
            throw new IllegalStateException("Nonnull field \"level\" is null.");
        }

        public void setLineNumber(@NonNull Long l) {
            if (l != null) {
                this.lineNumber = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"lineNumber\" is null.");
        }

        public void setMessage(@NonNull String str) {
            if (str != null) {
                this.message = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"message\" is null.");
        }

        public void setSourceId(@NonNull String str) {
            if (str != null) {
                this.sourceId = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"sourceId\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(4);
            arrayList.add(this.lineNumber);
            arrayList.add(this.message);
            ConsoleMessageLevel consoleMessageLevel = this.level;
            arrayList.add(consoleMessageLevel == null ? null : Integer.valueOf(consoleMessageLevel.index));
            arrayList.add(this.sourceId);
            return arrayList;
        }
    }

    public enum ConsoleMessageLevel {
        DEBUG(0),
        ERROR(1),
        LOG(2),
        TIP(3),
        WARNING(4),
        UNKNOWN(5);
        
        final int index;

        private ConsoleMessageLevel(int i) {
            this.index = i;
        }
    }

    public interface CookieManagerHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(CookieManagerHostApi cookieManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            cookieManagerHostApi.attachInstance(l);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$1(CookieManagerHostApi cookieManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            String str = (String) arrayList2.get(1);
            String str2 = (String) arrayList2.get(2);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            cookieManagerHostApi.setCookie(l, str, str2);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$2(CookieManagerHostApi cookieManagerHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            Number number = (Number) ((ArrayList) obj).get(0);
            cookieManagerHostApi.removeAllCookies(number == null ? null : Long.valueOf(number.longValue()), new Result<Boolean>() {
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidWebView.wrapError(th));
                }

                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$3(CookieManagerHostApi cookieManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Number number2 = (Number) arrayList2.get(1);
            Boolean bool = (Boolean) arrayList2.get(2);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            cookieManagerHostApi.setAcceptThirdPartyCookies(l, number2 == null ? null : Long.valueOf(number2.longValue()), bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable CookieManagerHostApi cookieManagerHostApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.CookieManagerHostApi.attachInstance", getCodec());
            if (cookieManagerHostApi != null) {
                basicMessageChannel.setMessageHandler(new c(cookieManagerHostApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.CookieManagerHostApi.setCookie", getCodec());
            if (cookieManagerHostApi != null) {
                basicMessageChannel2.setMessageHandler(new d(cookieManagerHostApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.CookieManagerHostApi.removeAllCookies", getCodec());
            if (cookieManagerHostApi != null) {
                basicMessageChannel3.setMessageHandler(new e(cookieManagerHostApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.CookieManagerHostApi.setAcceptThirdPartyCookies", getCodec());
            if (cookieManagerHostApi != null) {
                basicMessageChannel4.setMessageHandler(new f(cookieManagerHostApi));
            } else {
                basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void attachInstance(@NonNull Long l);

        void removeAllCookies(@NonNull Long l, @NonNull Result<Boolean> result);

        void setAcceptThirdPartyCookies(@NonNull Long l, @NonNull Long l2, @NonNull Boolean bool);

        void setCookie(@NonNull Long l, @NonNull String str, @NonNull String str2);
    }

    public static class CustomViewCallbackFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t);
        }

        public CustomViewCallbackFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        public void create(@NonNull Long l, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.CustomViewCallbackFlutterApi.create", getCodec()).send(new ArrayList(Collections.singletonList(l)), new g(reply));
        }
    }

    public interface CustomViewCallbackHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(CustomViewCallbackHostApi customViewCallbackHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            customViewCallbackHostApi.onCustomViewHidden(l);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable CustomViewCallbackHostApi customViewCallbackHostApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.CustomViewCallbackHostApi.onCustomViewHidden", getCodec());
            if (customViewCallbackHostApi != null) {
                basicMessageChannel.setMessageHandler(new h(customViewCallbackHostApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void onCustomViewHidden(@NonNull Long l);
    }

    public static class DownloadListenerFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t);
        }

        public DownloadListenerFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        public void onDownloadStart(@NonNull Long l, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull Long l2, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.DownloadListenerFlutterApi.onDownloadStart", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l, str, str2, str3, str4, l2})), new i(reply));
        }
    }

    public interface DownloadListenerHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(DownloadListenerHostApi downloadListenerHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            downloadListenerHostApi.create(l);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable DownloadListenerHostApi downloadListenerHostApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.DownloadListenerHostApi.create", getCodec());
            if (downloadListenerHostApi != null) {
                basicMessageChannel.setMessageHandler(new j(downloadListenerHostApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void create(@NonNull Long l);
    }

    public enum FileChooserMode {
        OPEN(0),
        OPEN_MULTIPLE(1),
        SAVE(2);
        
        final int index;

        private FileChooserMode(int i) {
            this.index = i;
        }
    }

    public static class FileChooserParamsFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t);
        }

        public FileChooserParamsFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        public void create(@NonNull Long l, @NonNull Boolean bool, @NonNull List<String> list, @NonNull FileChooserMode fileChooserMode, @Nullable String str, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.FileChooserParamsFlutterApi.create", getCodec()).send(new ArrayList(Arrays.asList(new Object[]{l, bool, list, Integer.valueOf(fileChooserMode.index), str})), new k(reply));
        }
    }

    public interface FlutterAssetManagerHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(FlutterAssetManagerHostApi flutterAssetManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, flutterAssetManagerHostApi.list((String) ((ArrayList) obj).get(0)));
            } catch (Throwable th) {
                arrayList = GeneratedAndroidWebView.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$1(FlutterAssetManagerHostApi flutterAssetManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, flutterAssetManagerHostApi.getAssetFilePathByName((String) ((ArrayList) obj).get(0)));
            } catch (Throwable th) {
                arrayList = GeneratedAndroidWebView.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable FlutterAssetManagerHostApi flutterAssetManagerHostApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.FlutterAssetManagerHostApi.list", getCodec());
            if (flutterAssetManagerHostApi != null) {
                basicMessageChannel.setMessageHandler(new l(flutterAssetManagerHostApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.FlutterAssetManagerHostApi.getAssetFilePathByName", getCodec());
            if (flutterAssetManagerHostApi != null) {
                basicMessageChannel2.setMessageHandler(new m(flutterAssetManagerHostApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        @NonNull
        String getAssetFilePathByName(@NonNull String str);

        @NonNull
        List<String> list(@NonNull String str);
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

    public static class GeolocationPermissionsCallbackFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t);
        }

        public GeolocationPermissionsCallbackFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        public void create(@NonNull Long l, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.GeolocationPermissionsCallbackFlutterApi.create", getCodec()).send(new ArrayList(Collections.singletonList(l)), new n(reply));
        }
    }

    public interface GeolocationPermissionsCallbackHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(GeolocationPermissionsCallbackHostApi geolocationPermissionsCallbackHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            String str = (String) arrayList2.get(1);
            Boolean bool = (Boolean) arrayList2.get(2);
            Boolean bool2 = (Boolean) arrayList2.get(3);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            geolocationPermissionsCallbackHostApi.invoke(l, str, bool, bool2);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable GeolocationPermissionsCallbackHostApi geolocationPermissionsCallbackHostApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.GeolocationPermissionsCallbackHostApi.invoke", getCodec());
            if (geolocationPermissionsCallbackHostApi != null) {
                basicMessageChannel.setMessageHandler(new o(geolocationPermissionsCallbackHostApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void invoke(@NonNull Long l, @NonNull String str, @NonNull Boolean bool, @NonNull Boolean bool2);
    }

    public static class HttpAuthHandlerFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t);
        }

        public HttpAuthHandlerFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        public void create(@NonNull Long l, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandlerFlutterApi.create", getCodec()).send(new ArrayList(Collections.singletonList(l)), new p(reply));
        }
    }

    public interface HttpAuthHandlerHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(HttpAuthHandlerHostApi httpAuthHandlerHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            arrayList.add(0, httpAuthHandlerHostApi.useHttpAuthUsernamePassword(l));
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$1(HttpAuthHandlerHostApi httpAuthHandlerHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            httpAuthHandlerHostApi.cancel(l);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$2(HttpAuthHandlerHostApi httpAuthHandlerHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            String str = (String) arrayList2.get(1);
            String str2 = (String) arrayList2.get(2);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            httpAuthHandlerHostApi.proceed(l, str, str2);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable HttpAuthHandlerHostApi httpAuthHandlerHostApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandlerHostApi.useHttpAuthUsernamePassword", getCodec());
            if (httpAuthHandlerHostApi != null) {
                basicMessageChannel.setMessageHandler(new q(httpAuthHandlerHostApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandlerHostApi.cancel", getCodec());
            if (httpAuthHandlerHostApi != null) {
                basicMessageChannel2.setMessageHandler(new r(httpAuthHandlerHostApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandlerHostApi.proceed", getCodec());
            if (httpAuthHandlerHostApi != null) {
                basicMessageChannel3.setMessageHandler(new s(httpAuthHandlerHostApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void cancel(@NonNull Long l);

        void proceed(@NonNull Long l, @NonNull String str, @NonNull String str2);

        @NonNull
        Boolean useHttpAuthUsernamePassword(@NonNull Long l);
    }

    public interface InstanceManagerHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(InstanceManagerHostApi instanceManagerHostApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                instanceManagerHostApi.clear();
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = GeneratedAndroidWebView.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable InstanceManagerHostApi instanceManagerHostApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.InstanceManagerHostApi.clear", getCodec());
            if (instanceManagerHostApi != null) {
                basicMessageChannel.setMessageHandler(new t(instanceManagerHostApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void clear();
    }

    public static class JavaObjectFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t);
        }

        public JavaObjectFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        public void dispose(@NonNull Long l, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.JavaObjectFlutterApi.dispose", getCodec()).send(new ArrayList(Collections.singletonList(l)), new u(reply));
        }
    }

    public interface JavaObjectHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(JavaObjectHostApi javaObjectHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            javaObjectHostApi.dispose(l);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable JavaObjectHostApi javaObjectHostApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.JavaObjectHostApi.dispose", getCodec());
            if (javaObjectHostApi != null) {
                basicMessageChannel.setMessageHandler(new v(javaObjectHostApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void dispose(@NonNull Long l);
    }

    public static class JavaScriptChannelFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t);
        }

        public JavaScriptChannelFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        public void postMessage(@NonNull Long l, @NonNull String str, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.JavaScriptChannelFlutterApi.postMessage", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l, str})), new w(reply));
        }
    }

    public interface JavaScriptChannelHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(JavaScriptChannelHostApi javaScriptChannelHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            String str = (String) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            javaScriptChannelHostApi.create(l, str);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable JavaScriptChannelHostApi javaScriptChannelHostApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.JavaScriptChannelHostApi.create", getCodec());
            if (javaScriptChannelHostApi != null) {
                basicMessageChannel.setMessageHandler(new x(javaScriptChannelHostApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void create(@NonNull Long l, @NonNull String str);
    }

    public static class PermissionRequestFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t);
        }

        public PermissionRequestFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        public void create(@NonNull Long l, @NonNull List<String> list, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.PermissionRequestFlutterApi.create", getCodec()).send(new ArrayList(Arrays.asList(new Object[]{l, list})), new y(reply));
        }
    }

    public interface PermissionRequestHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(PermissionRequestHostApi permissionRequestHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            List list = (List) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            permissionRequestHostApi.grant(l, list);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$1(PermissionRequestHostApi permissionRequestHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            permissionRequestHostApi.deny(l);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable PermissionRequestHostApi permissionRequestHostApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.PermissionRequestHostApi.grant", getCodec());
            if (permissionRequestHostApi != null) {
                basicMessageChannel.setMessageHandler(new z(permissionRequestHostApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.PermissionRequestHostApi.deny", getCodec());
            if (permissionRequestHostApi != null) {
                basicMessageChannel2.setMessageHandler(new a0(permissionRequestHostApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void deny(@NonNull Long l);

        void grant(@NonNull Long l, @NonNull List<String> list);
    }

    public interface Result<T> {
        void error(@NonNull Throwable th);

        void success(T t);
    }

    public static class ViewFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t);
        }

        public ViewFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        public void create(@NonNull Long l, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.ViewFlutterApi.create", getCodec()).send(new ArrayList(Collections.singletonList(l)), new b0(reply));
        }
    }

    public static class WebChromeClientFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t);
        }

        public WebChromeClientFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> getCodec() {
            return WebChromeClientFlutterApiCodec.INSTANCE;
        }

        public void onConsoleMessage(@NonNull Long l, @NonNull ConsoleMessage consoleMessage, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onConsoleMessage", getCodec()).send(new ArrayList(Arrays.asList(new Object[]{l, consoleMessage})), new g0(reply));
        }

        public void onGeolocationPermissionsHidePrompt(@NonNull Long l, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onGeolocationPermissionsHidePrompt", getCodec()).send(new ArrayList(Collections.singletonList(l)), new m0(reply));
        }

        public void onGeolocationPermissionsShowPrompt(@NonNull Long l, @NonNull Long l2, @NonNull String str, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onGeolocationPermissionsShowPrompt", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l, l2, str})), new c0(reply));
        }

        public void onHideCustomView(@NonNull Long l, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onHideCustomView", getCodec()).send(new ArrayList(Collections.singletonList(l)), new e0(reply));
        }

        public void onJsAlert(@NonNull Long l, @NonNull String str, @NonNull String str2, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onJsAlert", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l, str, str2})), new f0(reply));
        }

        public void onJsConfirm(@NonNull Long l, @NonNull String str, @NonNull String str2, @NonNull Reply<Boolean> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onJsConfirm", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l, str, str2})), new l0(reply));
        }

        public void onJsPrompt(@NonNull Long l, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull Reply<String> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onJsPrompt", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l, str, str2, str3})), new i0(reply));
        }

        public void onPermissionRequest(@NonNull Long l, @NonNull Long l2, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onPermissionRequest", getCodec()).send(new ArrayList(Arrays.asList(new Long[]{l, l2})), new h0(reply));
        }

        public void onProgressChanged(@NonNull Long l, @NonNull Long l2, @NonNull Long l3, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onProgressChanged", getCodec()).send(new ArrayList(Arrays.asList(new Long[]{l, l2, l3})), new k0(reply));
        }

        public void onShowCustomView(@NonNull Long l, @NonNull Long l2, @NonNull Long l3, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onShowCustomView", getCodec()).send(new ArrayList(Arrays.asList(new Long[]{l, l2, l3})), new j0(reply));
        }

        public void onShowFileChooser(@NonNull Long l, @NonNull Long l2, @NonNull Long l3, @NonNull Reply<List<String>> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientFlutterApi.onShowFileChooser", getCodec()).send(new ArrayList(Arrays.asList(new Long[]{l, l2, l3})), new d0(reply));
        }
    }

    public static class WebChromeClientFlutterApiCodec extends StandardMessageCodec {
        public static final WebChromeClientFlutterApiCodec INSTANCE = new WebChromeClientFlutterApiCodec();

        private WebChromeClientFlutterApiCodec() {
        }

        public Object readValueOfType(byte b, @NonNull ByteBuffer byteBuffer) {
            return b != Byte.MIN_VALUE ? super.readValueOfType(b, byteBuffer) : ConsoleMessage.fromList((ArrayList) readValue(byteBuffer));
        }

        public void writeValue(@NonNull ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof ConsoleMessage) {
                byteArrayOutputStream.write(128);
                writeValue(byteArrayOutputStream, ((ConsoleMessage) obj).toList());
                return;
            }
            super.writeValue(byteArrayOutputStream, obj);
        }
    }

    public interface WebChromeClientHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(WebChromeClientHostApi webChromeClientHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webChromeClientHostApi.create(l);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$1(WebChromeClientHostApi webChromeClientHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webChromeClientHostApi.setSynchronousReturnValueForOnShowFileChooser(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$2(WebChromeClientHostApi webChromeClientHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webChromeClientHostApi.setSynchronousReturnValueForOnConsoleMessage(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$3(WebChromeClientHostApi webChromeClientHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webChromeClientHostApi.setSynchronousReturnValueForOnJsAlert(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$4(WebChromeClientHostApi webChromeClientHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webChromeClientHostApi.setSynchronousReturnValueForOnJsConfirm(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$5(WebChromeClientHostApi webChromeClientHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webChromeClientHostApi.setSynchronousReturnValueForOnJsPrompt(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable WebChromeClientHostApi webChromeClientHostApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientHostApi.create", getCodec());
            if (webChromeClientHostApi != null) {
                basicMessageChannel.setMessageHandler(new n0(webChromeClientHostApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientHostApi.setSynchronousReturnValueForOnShowFileChooser", getCodec());
            if (webChromeClientHostApi != null) {
                basicMessageChannel2.setMessageHandler(new o0(webChromeClientHostApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientHostApi.setSynchronousReturnValueForOnConsoleMessage", getCodec());
            if (webChromeClientHostApi != null) {
                basicMessageChannel3.setMessageHandler(new p0(webChromeClientHostApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientHostApi.setSynchronousReturnValueForOnJsAlert", getCodec());
            if (webChromeClientHostApi != null) {
                basicMessageChannel4.setMessageHandler(new q0(webChromeClientHostApi));
            } else {
                basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientHostApi.setSynchronousReturnValueForOnJsConfirm", getCodec());
            if (webChromeClientHostApi != null) {
                basicMessageChannel5.setMessageHandler(new r0(webChromeClientHostApi));
            } else {
                basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClientHostApi.setSynchronousReturnValueForOnJsPrompt", getCodec());
            if (webChromeClientHostApi != null) {
                basicMessageChannel6.setMessageHandler(new s0(webChromeClientHostApi));
            } else {
                basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void create(@NonNull Long l);

        void setSynchronousReturnValueForOnConsoleMessage(@NonNull Long l, @NonNull Boolean bool);

        void setSynchronousReturnValueForOnJsAlert(@NonNull Long l, @NonNull Boolean bool);

        void setSynchronousReturnValueForOnJsConfirm(@NonNull Long l, @NonNull Boolean bool);

        void setSynchronousReturnValueForOnJsPrompt(@NonNull Long l, @NonNull Boolean bool);

        void setSynchronousReturnValueForOnShowFileChooser(@NonNull Long l, @NonNull Boolean bool);
    }

    public static final class WebResourceErrorData {
        @NonNull
        private String description;
        @NonNull
        private Long errorCode;

        public static final class Builder {
            @Nullable
            private String description;
            @Nullable
            private Long errorCode;

            @NonNull
            public WebResourceErrorData build() {
                WebResourceErrorData webResourceErrorData = new WebResourceErrorData();
                webResourceErrorData.setErrorCode(this.errorCode);
                webResourceErrorData.setDescription(this.description);
                return webResourceErrorData;
            }

            @NonNull
            public Builder setDescription(@NonNull String str) {
                this.description = str;
                return this;
            }

            @NonNull
            public Builder setErrorCode(@NonNull Long l) {
                this.errorCode = l;
                return this;
            }
        }

        @NonNull
        public static WebResourceErrorData fromList(@NonNull ArrayList<Object> arrayList) {
            Long l;
            WebResourceErrorData webResourceErrorData = new WebResourceErrorData();
            Object obj = arrayList.get(0);
            if (obj == null) {
                l = null;
            } else {
                l = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            webResourceErrorData.setErrorCode(l);
            webResourceErrorData.setDescription((String) arrayList.get(1));
            return webResourceErrorData;
        }

        @NonNull
        public String getDescription() {
            return this.description;
        }

        @NonNull
        public Long getErrorCode() {
            return this.errorCode;
        }

        public void setDescription(@NonNull String str) {
            if (str != null) {
                this.description = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"description\" is null.");
        }

        public void setErrorCode(@NonNull Long l) {
            if (l != null) {
                this.errorCode = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"errorCode\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.errorCode);
            arrayList.add(this.description);
            return arrayList;
        }
    }

    public static final class WebResourceRequestData {
        @NonNull
        private Boolean hasGesture;
        @NonNull
        private Boolean isForMainFrame;
        @Nullable
        private Boolean isRedirect;
        @NonNull
        private String method;
        @NonNull
        private Map<String, String> requestHeaders;
        @NonNull
        private String url;

        public static final class Builder {
            @Nullable
            private Boolean hasGesture;
            @Nullable
            private Boolean isForMainFrame;
            @Nullable
            private Boolean isRedirect;
            @Nullable
            private String method;
            @Nullable
            private Map<String, String> requestHeaders;
            @Nullable
            private String url;

            @NonNull
            public WebResourceRequestData build() {
                WebResourceRequestData webResourceRequestData = new WebResourceRequestData();
                webResourceRequestData.setUrl(this.url);
                webResourceRequestData.setIsForMainFrame(this.isForMainFrame);
                webResourceRequestData.setIsRedirect(this.isRedirect);
                webResourceRequestData.setHasGesture(this.hasGesture);
                webResourceRequestData.setMethod(this.method);
                webResourceRequestData.setRequestHeaders(this.requestHeaders);
                return webResourceRequestData;
            }

            @NonNull
            public Builder setHasGesture(@NonNull Boolean bool) {
                this.hasGesture = bool;
                return this;
            }

            @NonNull
            public Builder setIsForMainFrame(@NonNull Boolean bool) {
                this.isForMainFrame = bool;
                return this;
            }

            @NonNull
            public Builder setIsRedirect(@Nullable Boolean bool) {
                this.isRedirect = bool;
                return this;
            }

            @NonNull
            public Builder setMethod(@NonNull String str) {
                this.method = str;
                return this;
            }

            @NonNull
            public Builder setRequestHeaders(@NonNull Map<String, String> map) {
                this.requestHeaders = map;
                return this;
            }

            @NonNull
            public Builder setUrl(@NonNull String str) {
                this.url = str;
                return this;
            }
        }

        @NonNull
        public static WebResourceRequestData fromList(@NonNull ArrayList<Object> arrayList) {
            WebResourceRequestData webResourceRequestData = new WebResourceRequestData();
            webResourceRequestData.setUrl((String) arrayList.get(0));
            webResourceRequestData.setIsForMainFrame((Boolean) arrayList.get(1));
            webResourceRequestData.setIsRedirect((Boolean) arrayList.get(2));
            webResourceRequestData.setHasGesture((Boolean) arrayList.get(3));
            webResourceRequestData.setMethod((String) arrayList.get(4));
            webResourceRequestData.setRequestHeaders((Map) arrayList.get(5));
            return webResourceRequestData;
        }

        @NonNull
        public Boolean getHasGesture() {
            return this.hasGesture;
        }

        @NonNull
        public Boolean getIsForMainFrame() {
            return this.isForMainFrame;
        }

        @Nullable
        public Boolean getIsRedirect() {
            return this.isRedirect;
        }

        @NonNull
        public String getMethod() {
            return this.method;
        }

        @NonNull
        public Map<String, String> getRequestHeaders() {
            return this.requestHeaders;
        }

        @NonNull
        public String getUrl() {
            return this.url;
        }

        public void setHasGesture(@NonNull Boolean bool) {
            if (bool != null) {
                this.hasGesture = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"hasGesture\" is null.");
        }

        public void setIsForMainFrame(@NonNull Boolean bool) {
            if (bool != null) {
                this.isForMainFrame = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"isForMainFrame\" is null.");
        }

        public void setIsRedirect(@Nullable Boolean bool) {
            this.isRedirect = bool;
        }

        public void setMethod(@NonNull String str) {
            if (str != null) {
                this.method = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"method\" is null.");
        }

        public void setRequestHeaders(@NonNull Map<String, String> map) {
            if (map != null) {
                this.requestHeaders = map;
                return;
            }
            throw new IllegalStateException("Nonnull field \"requestHeaders\" is null.");
        }

        public void setUrl(@NonNull String str) {
            if (str != null) {
                this.url = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"url\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(6);
            arrayList.add(this.url);
            arrayList.add(this.isForMainFrame);
            arrayList.add(this.isRedirect);
            arrayList.add(this.hasGesture);
            arrayList.add(this.method);
            arrayList.add(this.requestHeaders);
            return arrayList;
        }
    }

    public static final class WebResourceResponseData {
        @NonNull
        private Long statusCode;

        public static final class Builder {
            @Nullable
            private Long statusCode;

            @NonNull
            public WebResourceResponseData build() {
                WebResourceResponseData webResourceResponseData = new WebResourceResponseData();
                webResourceResponseData.setStatusCode(this.statusCode);
                return webResourceResponseData;
            }

            @NonNull
            public Builder setStatusCode(@NonNull Long l) {
                this.statusCode = l;
                return this;
            }
        }

        @NonNull
        public static WebResourceResponseData fromList(@NonNull ArrayList<Object> arrayList) {
            Long l;
            WebResourceResponseData webResourceResponseData = new WebResourceResponseData();
            Object obj = arrayList.get(0);
            if (obj == null) {
                l = null;
            } else {
                l = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            webResourceResponseData.setStatusCode(l);
            return webResourceResponseData;
        }

        @NonNull
        public Long getStatusCode() {
            return this.statusCode;
        }

        public void setStatusCode(@NonNull Long l) {
            if (l != null) {
                this.statusCode = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"statusCode\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(this.statusCode);
            return arrayList;
        }
    }

    public interface WebSettingsHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Number number2 = (Number) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webSettingsHostApi.create(l, number2 == null ? null : Long.valueOf(number2.longValue()));
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$1(WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webSettingsHostApi.setDomStorageEnabled(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$10(WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webSettingsHostApi.setDisplayZoomControls(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$11(WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webSettingsHostApi.setBuiltInZoomControls(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$12(WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webSettingsHostApi.setAllowFileAccess(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$13(WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Number number2 = (Number) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webSettingsHostApi.setTextZoom(l, number2 == null ? null : Long.valueOf(number2.longValue()));
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$14(WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            arrayList.add(0, webSettingsHostApi.getUserAgentString(l));
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$2(WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webSettingsHostApi.setJavaScriptCanOpenWindowsAutomatically(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$3(WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webSettingsHostApi.setSupportMultipleWindows(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$4(WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webSettingsHostApi.setJavaScriptEnabled(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$5(WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            String str = (String) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webSettingsHostApi.setUserAgentString(l, str);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$6(WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webSettingsHostApi.setMediaPlaybackRequiresUserGesture(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$7(WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webSettingsHostApi.setSupportZoom(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$8(WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webSettingsHostApi.setLoadWithOverviewMode(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$9(WebSettingsHostApi webSettingsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webSettingsHostApi.setUseWideViewPort(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable WebSettingsHostApi webSettingsHostApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettingsHostApi.create", getCodec());
            if (webSettingsHostApi != null) {
                basicMessageChannel.setMessageHandler(new t0(webSettingsHostApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettingsHostApi.setDomStorageEnabled", getCodec());
            if (webSettingsHostApi != null) {
                basicMessageChannel2.setMessageHandler(new e1(webSettingsHostApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettingsHostApi.setJavaScriptCanOpenWindowsAutomatically", getCodec());
            if (webSettingsHostApi != null) {
                basicMessageChannel3.setMessageHandler(new f1(webSettingsHostApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettingsHostApi.setSupportMultipleWindows", getCodec());
            if (webSettingsHostApi != null) {
                basicMessageChannel4.setMessageHandler(new g1(webSettingsHostApi));
            } else {
                basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettingsHostApi.setJavaScriptEnabled", getCodec());
            if (webSettingsHostApi != null) {
                basicMessageChannel5.setMessageHandler(new h1(webSettingsHostApi));
            } else {
                basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettingsHostApi.setUserAgentString", getCodec());
            if (webSettingsHostApi != null) {
                basicMessageChannel6.setMessageHandler(new u0(webSettingsHostApi));
            } else {
                basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettingsHostApi.setMediaPlaybackRequiresUserGesture", getCodec());
            if (webSettingsHostApi != null) {
                basicMessageChannel7.setMessageHandler(new v0(webSettingsHostApi));
            } else {
                basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettingsHostApi.setSupportZoom", getCodec());
            if (webSettingsHostApi != null) {
                basicMessageChannel8.setMessageHandler(new w0(webSettingsHostApi));
            } else {
                basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettingsHostApi.setLoadWithOverviewMode", getCodec());
            if (webSettingsHostApi != null) {
                basicMessageChannel9.setMessageHandler(new x0(webSettingsHostApi));
            } else {
                basicMessageChannel9.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettingsHostApi.setUseWideViewPort", getCodec());
            if (webSettingsHostApi != null) {
                basicMessageChannel10.setMessageHandler(new y0(webSettingsHostApi));
            } else {
                basicMessageChannel10.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettingsHostApi.setDisplayZoomControls", getCodec());
            if (webSettingsHostApi != null) {
                basicMessageChannel11.setMessageHandler(new z0(webSettingsHostApi));
            } else {
                basicMessageChannel11.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettingsHostApi.setBuiltInZoomControls", getCodec());
            if (webSettingsHostApi != null) {
                basicMessageChannel12.setMessageHandler(new a1(webSettingsHostApi));
            } else {
                basicMessageChannel12.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel13 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettingsHostApi.setAllowFileAccess", getCodec());
            if (webSettingsHostApi != null) {
                basicMessageChannel13.setMessageHandler(new b1(webSettingsHostApi));
            } else {
                basicMessageChannel13.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel14 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettingsHostApi.setTextZoom", getCodec());
            if (webSettingsHostApi != null) {
                basicMessageChannel14.setMessageHandler(new c1(webSettingsHostApi));
            } else {
                basicMessageChannel14.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel15 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettingsHostApi.getUserAgentString", getCodec());
            if (webSettingsHostApi != null) {
                basicMessageChannel15.setMessageHandler(new d1(webSettingsHostApi));
            } else {
                basicMessageChannel15.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void create(@NonNull Long l, @NonNull Long l2);

        @NonNull
        String getUserAgentString(@NonNull Long l);

        void setAllowFileAccess(@NonNull Long l, @NonNull Boolean bool);

        void setBuiltInZoomControls(@NonNull Long l, @NonNull Boolean bool);

        void setDisplayZoomControls(@NonNull Long l, @NonNull Boolean bool);

        void setDomStorageEnabled(@NonNull Long l, @NonNull Boolean bool);

        void setJavaScriptCanOpenWindowsAutomatically(@NonNull Long l, @NonNull Boolean bool);

        void setJavaScriptEnabled(@NonNull Long l, @NonNull Boolean bool);

        void setLoadWithOverviewMode(@NonNull Long l, @NonNull Boolean bool);

        void setMediaPlaybackRequiresUserGesture(@NonNull Long l, @NonNull Boolean bool);

        void setSupportMultipleWindows(@NonNull Long l, @NonNull Boolean bool);

        void setSupportZoom(@NonNull Long l, @NonNull Boolean bool);

        void setTextZoom(@NonNull Long l, @NonNull Long l2);

        void setUseWideViewPort(@NonNull Long l, @NonNull Boolean bool);

        void setUserAgentString(@NonNull Long l, @Nullable String str);
    }

    public interface WebStorageHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(WebStorageHostApi webStorageHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webStorageHostApi.create(l);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$1(WebStorageHostApi webStorageHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webStorageHostApi.deleteAllData(l);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable WebStorageHostApi webStorageHostApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebStorageHostApi.create", getCodec());
            if (webStorageHostApi != null) {
                basicMessageChannel.setMessageHandler(new i1(webStorageHostApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebStorageHostApi.deleteAllData", getCodec());
            if (webStorageHostApi != null) {
                basicMessageChannel2.setMessageHandler(new j1(webStorageHostApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void create(@NonNull Long l);

        void deleteAllData(@NonNull Long l);
    }

    public static class WebViewClientFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t);
        }

        public WebViewClientFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> getCodec() {
            return WebViewClientFlutterApiCodec.INSTANCE;
        }

        public void doUpdateVisitedHistory(@NonNull Long l, @NonNull Long l2, @NonNull String str, @NonNull Boolean bool, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientFlutterApi.doUpdateVisitedHistory", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l, l2, str, bool})), new p1(reply));
        }

        public void onPageFinished(@NonNull Long l, @NonNull Long l2, @NonNull String str, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientFlutterApi.onPageFinished", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l, l2, str})), new q1(reply));
        }

        public void onPageStarted(@NonNull Long l, @NonNull Long l2, @NonNull String str, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientFlutterApi.onPageStarted", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l, l2, str})), new m1(reply));
        }

        public void onReceivedError(@NonNull Long l, @NonNull Long l2, @NonNull Long l3, @NonNull String str, @NonNull String str2, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientFlutterApi.onReceivedError", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l, l2, l3, str, str2})), new l1(reply));
        }

        public void onReceivedHttpAuthRequest(@NonNull Long l, @NonNull Long l2, @NonNull Long l3, @NonNull String str, @NonNull String str2, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientFlutterApi.onReceivedHttpAuthRequest", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l, l2, l3, str, str2})), new r1(reply));
        }

        public void onReceivedHttpError(@NonNull Long l, @NonNull Long l2, @NonNull WebResourceRequestData webResourceRequestData, @NonNull WebResourceResponseData webResourceResponseData, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientFlutterApi.onReceivedHttpError", getCodec()).send(new ArrayList(Arrays.asList(new Object[]{l, l2, webResourceRequestData, webResourceResponseData})), new s1(reply));
        }

        public void onReceivedRequestError(@NonNull Long l, @NonNull Long l2, @NonNull WebResourceRequestData webResourceRequestData, @NonNull WebResourceErrorData webResourceErrorData, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientFlutterApi.onReceivedRequestError", getCodec()).send(new ArrayList(Arrays.asList(new Object[]{l, l2, webResourceRequestData, webResourceErrorData})), new o1(reply));
        }

        public void requestLoading(@NonNull Long l, @NonNull Long l2, @NonNull WebResourceRequestData webResourceRequestData, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientFlutterApi.requestLoading", getCodec()).send(new ArrayList(Arrays.asList(new Object[]{l, l2, webResourceRequestData})), new n1(reply));
        }

        public void urlLoading(@NonNull Long l, @NonNull Long l2, @NonNull String str, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientFlutterApi.urlLoading", getCodec()).send(new ArrayList(Arrays.asList(new Serializable[]{l, l2, str})), new k1(reply));
        }
    }

    public static class WebViewClientFlutterApiCodec extends StandardMessageCodec {
        public static final WebViewClientFlutterApiCodec INSTANCE = new WebViewClientFlutterApiCodec();

        private WebViewClientFlutterApiCodec() {
        }

        public Object readValueOfType(byte b, @NonNull ByteBuffer byteBuffer) {
            switch (b) {
                case Byte.MIN_VALUE:
                    return WebResourceErrorData.fromList((ArrayList) readValue(byteBuffer));
                case -127:
                    return WebResourceRequestData.fromList((ArrayList) readValue(byteBuffer));
                case -126:
                    return WebResourceResponseData.fromList((ArrayList) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b, byteBuffer);
            }
        }

        public void writeValue(@NonNull ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof WebResourceErrorData) {
                byteArrayOutputStream.write(128);
                writeValue(byteArrayOutputStream, ((WebResourceErrorData) obj).toList());
            } else if (obj instanceof WebResourceRequestData) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((WebResourceRequestData) obj).toList());
            } else if (obj instanceof WebResourceResponseData) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, ((WebResourceResponseData) obj).toList());
            } else {
                super.writeValue(byteArrayOutputStream, obj);
            }
        }
    }

    public interface WebViewClientHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(WebViewClientHostApi webViewClientHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewClientHostApi.create(l);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$1(WebViewClientHostApi webViewClientHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewClientHostApi.setSynchronousReturnValueForShouldOverrideUrlLoading(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable WebViewClientHostApi webViewClientHostApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientHostApi.create", getCodec());
            if (webViewClientHostApi != null) {
                basicMessageChannel.setMessageHandler(new t1(webViewClientHostApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewClientHostApi.setSynchronousReturnValueForShouldOverrideUrlLoading", getCodec());
            if (webViewClientHostApi != null) {
                basicMessageChannel2.setMessageHandler(new u1(webViewClientHostApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void create(@NonNull Long l);

        void setSynchronousReturnValueForShouldOverrideUrlLoading(@NonNull Long l, @NonNull Boolean bool);
    }

    public static class WebViewFlutterApi {
        @NonNull
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t);
        }

        public WebViewFlutterApi(@NonNull BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        @NonNull
        public static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        public void create(@NonNull Long l, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewFlutterApi.create", getCodec()).send(new ArrayList(Collections.singletonList(l)), new w1(reply));
        }

        public void onScrollChanged(@NonNull Long l, @NonNull Long l2, @NonNull Long l3, @NonNull Long l4, @NonNull Long l5, @NonNull Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewFlutterApi.onScrollChanged", getCodec()).send(new ArrayList(Arrays.asList(new Long[]{l, l2, l3, l4, l5})), new v1(reply));
        }
    }

    public interface WebViewHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return WebViewHostApiCodec.INSTANCE;
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.create(l);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$1(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            String str = (String) arrayList2.get(1);
            String str2 = (String) arrayList2.get(2);
            String str3 = (String) arrayList2.get(3);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.loadData(l, str, str2, str3);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$10(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.reload(l);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$11(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Boolean bool = (Boolean) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.clearCache(l, bool);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$12(WebViewHostApi webViewHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            webViewHostApi.evaluateJavascript(number == null ? null : Long.valueOf(number.longValue()), (String) arrayList2.get(1), new Result<String>() {
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidWebView.wrapError(th));
                }

                public void success(String str) {
                    arrayList.add(0, str);
                    reply.reply(arrayList);
                }
            });
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$13(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            arrayList.add(0, webViewHostApi.getTitle(l));
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$14(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Number number2 = (Number) arrayList2.get(1);
            Number number3 = (Number) arrayList2.get(2);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.scrollTo(l, number2 == null ? null : Long.valueOf(number2.longValue()), number3 == null ? null : Long.valueOf(number3.longValue()));
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$15(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Number number2 = (Number) arrayList2.get(1);
            Number number3 = (Number) arrayList2.get(2);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.scrollBy(l, number2 == null ? null : Long.valueOf(number2.longValue()), number3 == null ? null : Long.valueOf(number3.longValue()));
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$16(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            arrayList.add(0, webViewHostApi.getScrollX(l));
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$17(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            arrayList.add(0, webViewHostApi.getScrollY(l));
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$18(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            arrayList.add(0, webViewHostApi.getScrollPosition(l));
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$19(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                webViewHostApi.setWebContentsDebuggingEnabled((Boolean) ((ArrayList) obj).get(0));
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = GeneratedAndroidWebView.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$2(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            String str = (String) arrayList2.get(1);
            String str2 = (String) arrayList2.get(2);
            String str3 = (String) arrayList2.get(3);
            String str4 = (String) arrayList2.get(4);
            String str5 = (String) arrayList2.get(5);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.loadDataWithBaseUrl(l, str, str2, str3, str4, str5);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$20(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Number number2 = (Number) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.setWebViewClient(l, number2 == null ? null : Long.valueOf(number2.longValue()));
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$21(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Number number2 = (Number) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.addJavaScriptChannel(l, number2 == null ? null : Long.valueOf(number2.longValue()));
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$22(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Number number2 = (Number) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.removeJavaScriptChannel(l, number2 == null ? null : Long.valueOf(number2.longValue()));
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$23(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Number number2 = (Number) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.setDownloadListener(l, number2 == null ? null : Long.valueOf(number2.longValue()));
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$24(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Number number2 = (Number) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.setWebChromeClient(l, number2 == null ? null : Long.valueOf(number2.longValue()));
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$25(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            Number number2 = (Number) arrayList2.get(1);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.setBackgroundColor(l, number2 == null ? null : Long.valueOf(number2.longValue()));
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$3(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            String str = (String) arrayList2.get(1);
            Map map = (Map) arrayList2.get(2);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.loadUrl(l, str, map);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$4(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            Number number = (Number) arrayList2.get(0);
            String str = (String) arrayList2.get(1);
            byte[] bArr = (byte[]) arrayList2.get(2);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.postUrl(l, str, bArr);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$5(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            arrayList.add(0, webViewHostApi.getUrl(l));
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$6(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            arrayList.add(0, webViewHostApi.canGoBack(l));
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$7(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            arrayList.add(0, webViewHostApi.canGoForward(l));
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$8(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.goBack(l);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$9(WebViewHostApi webViewHostApi, Object obj, BasicMessageChannel.Reply reply) {
            Long l;
            ArrayList<Object> arrayList = new ArrayList<>();
            Number number = (Number) ((ArrayList) obj).get(0);
            if (number == null) {
                l = null;
            } else {
                try {
                    l = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = GeneratedAndroidWebView.wrapError(th);
                }
            }
            webViewHostApi.goForward(l);
            arrayList.add(0, (Object) null);
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable WebViewHostApi webViewHostApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.create", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel.setMessageHandler(new x1(webViewHostApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.loadData", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel2.setMessageHandler(new z1(webViewHostApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.loadDataWithBaseUrl", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel3.setMessageHandler(new g2(webViewHostApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.loadUrl", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel4.setMessageHandler(new h2(webViewHostApi));
            } else {
                basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.postUrl", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel5.setMessageHandler(new j2(webViewHostApi));
            } else {
                basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.getUrl", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel6.setMessageHandler(new k2(webViewHostApi));
            } else {
                basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.canGoBack", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel7.setMessageHandler(new l2(webViewHostApi));
            } else {
                basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.canGoForward", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel8.setMessageHandler(new m2(webViewHostApi));
            } else {
                basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.goBack", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel9.setMessageHandler(new n2(webViewHostApi));
            } else {
                basicMessageChannel9.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.goForward", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel10.setMessageHandler(new o2(webViewHostApi));
            } else {
                basicMessageChannel10.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.reload", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel11.setMessageHandler(new i2(webViewHostApi));
            } else {
                basicMessageChannel11.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.clearCache", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel12.setMessageHandler(new p2(webViewHostApi));
            } else {
                basicMessageChannel12.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel13 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.evaluateJavascript", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel13.setMessageHandler(new q2(webViewHostApi));
            } else {
                basicMessageChannel13.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel14 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.getTitle", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel14.setMessageHandler(new r2(webViewHostApi));
            } else {
                basicMessageChannel14.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel15 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.scrollTo", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel15.setMessageHandler(new s2(webViewHostApi));
            } else {
                basicMessageChannel15.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel16 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.scrollBy", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel16.setMessageHandler(new t2(webViewHostApi));
            } else {
                basicMessageChannel16.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel17 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.getScrollX", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel17.setMessageHandler(new u2(webViewHostApi));
            } else {
                basicMessageChannel17.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel18 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.getScrollY", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel18.setMessageHandler(new v2(webViewHostApi));
            } else {
                basicMessageChannel18.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel19 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.getScrollPosition", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel19.setMessageHandler(new w2(webViewHostApi));
            } else {
                basicMessageChannel19.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel20 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.setWebContentsDebuggingEnabled", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel20.setMessageHandler(new y1(webViewHostApi));
            } else {
                basicMessageChannel20.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel21 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.setWebViewClient", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel21.setMessageHandler(new a2(webViewHostApi));
            } else {
                basicMessageChannel21.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel22 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.addJavaScriptChannel", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel22.setMessageHandler(new b2(webViewHostApi));
            } else {
                basicMessageChannel22.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel23 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.removeJavaScriptChannel", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel23.setMessageHandler(new c2(webViewHostApi));
            } else {
                basicMessageChannel23.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel24 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.setDownloadListener", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel24.setMessageHandler(new d2(webViewHostApi));
            } else {
                basicMessageChannel24.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel25 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.setWebChromeClient", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel25.setMessageHandler(new e2(webViewHostApi));
            } else {
                basicMessageChannel25.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel26 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebViewHostApi.setBackgroundColor", getCodec());
            if (webViewHostApi != null) {
                basicMessageChannel26.setMessageHandler(new f2(webViewHostApi));
            } else {
                basicMessageChannel26.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void addJavaScriptChannel(@NonNull Long l, @NonNull Long l2);

        @NonNull
        Boolean canGoBack(@NonNull Long l);

        @NonNull
        Boolean canGoForward(@NonNull Long l);

        void clearCache(@NonNull Long l, @NonNull Boolean bool);

        void create(@NonNull Long l);

        void evaluateJavascript(@NonNull Long l, @NonNull String str, @NonNull Result<String> result);

        @NonNull
        WebViewPoint getScrollPosition(@NonNull Long l);

        @NonNull
        Long getScrollX(@NonNull Long l);

        @NonNull
        Long getScrollY(@NonNull Long l);

        @Nullable
        String getTitle(@NonNull Long l);

        @Nullable
        String getUrl(@NonNull Long l);

        void goBack(@NonNull Long l);

        void goForward(@NonNull Long l);

        void loadData(@NonNull Long l, @NonNull String str, @Nullable String str2, @Nullable String str3);

        void loadDataWithBaseUrl(@NonNull Long l, @Nullable String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5);

        void loadUrl(@NonNull Long l, @NonNull String str, @NonNull Map<String, String> map);

        void postUrl(@NonNull Long l, @NonNull String str, @NonNull byte[] bArr);

        void reload(@NonNull Long l);

        void removeJavaScriptChannel(@NonNull Long l, @NonNull Long l2);

        void scrollBy(@NonNull Long l, @NonNull Long l2, @NonNull Long l3);

        void scrollTo(@NonNull Long l, @NonNull Long l2, @NonNull Long l3);

        void setBackgroundColor(@NonNull Long l, @NonNull Long l2);

        void setDownloadListener(@NonNull Long l, @Nullable Long l2);

        void setWebChromeClient(@NonNull Long l, @Nullable Long l2);

        void setWebContentsDebuggingEnabled(@NonNull Boolean bool);

        void setWebViewClient(@NonNull Long l, @NonNull Long l2);
    }

    public static class WebViewHostApiCodec extends StandardMessageCodec {
        public static final WebViewHostApiCodec INSTANCE = new WebViewHostApiCodec();

        private WebViewHostApiCodec() {
        }

        public Object readValueOfType(byte b, @NonNull ByteBuffer byteBuffer) {
            return b != Byte.MIN_VALUE ? super.readValueOfType(b, byteBuffer) : WebViewPoint.fromList((ArrayList) readValue(byteBuffer));
        }

        public void writeValue(@NonNull ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof WebViewPoint) {
                byteArrayOutputStream.write(128);
                writeValue(byteArrayOutputStream, ((WebViewPoint) obj).toList());
                return;
            }
            super.writeValue(byteArrayOutputStream, obj);
        }
    }

    public static final class WebViewPoint {
        @NonNull
        private Long x;
        @NonNull
        private Long y;

        public static final class Builder {
            @Nullable
            private Long x;
            @Nullable
            private Long y;

            @NonNull
            public WebViewPoint build() {
                WebViewPoint webViewPoint = new WebViewPoint();
                webViewPoint.setX(this.x);
                webViewPoint.setY(this.y);
                return webViewPoint;
            }

            @NonNull
            public Builder setX(@NonNull Long l) {
                this.x = l;
                return this;
            }

            @NonNull
            public Builder setY(@NonNull Long l) {
                this.y = l;
                return this;
            }
        }

        @NonNull
        public static WebViewPoint fromList(@NonNull ArrayList<Object> arrayList) {
            Long l;
            WebViewPoint webViewPoint = new WebViewPoint();
            Object obj = arrayList.get(0);
            Long l2 = null;
            if (obj == null) {
                l = null;
            } else {
                l = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            webViewPoint.setX(l);
            Object obj2 = arrayList.get(1);
            if (obj2 != null) {
                l2 = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            webViewPoint.setY(l2);
            return webViewPoint;
        }

        @NonNull
        public Long getX() {
            return this.x;
        }

        @NonNull
        public Long getY() {
            return this.y;
        }

        public void setX(@NonNull Long l) {
            if (l != null) {
                this.x = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"x\" is null.");
        }

        public void setY(@NonNull Long l) {
            if (l != null) {
                this.y = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"y\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.x);
            arrayList.add(this.y);
            return arrayList;
        }
    }

    @NonNull
    public static ArrayList<Object> wrapError(@NonNull Throwable th) {
        ArrayList<Object> arrayList = new ArrayList<>(3);
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
