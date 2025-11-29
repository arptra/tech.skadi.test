package com.xjmz.myvu.flutter.pigeon;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.posclient.analytics.TrackerEvent;
import com.honey.account.r9.k;
import com.honey.account.r9.l;
import com.honey.account.r9.m;
import com.honey.account.r9.n;
import com.honey.account.r9.o;
import com.honey.account.r9.p;
import com.honey.account.r9.q;
import com.honey.account.r9.r;
import com.honey.account.r9.s;
import com.honey.account.r9.t;
import com.honey.account.r9.u;
import com.honey.account.r9.v;
import com.honey.account.r9.w;
import com.honey.account.r9.x;
import com.honey.account.r9.y;
import com.honey.account.r9.z;
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
import java.util.Map;
import java.util.Objects;

public class AndroidAppApi {

    public interface AppApi {
        static /* synthetic */ void c(AppApi appApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            appApi.s(new Result<String>() {
                /* renamed from: a */
                public void success(String str) {
                    arrayList.add(0, str);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void d(AppApi appApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            appApi.h(new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        static void e(BinaryMessenger binaryMessenger, AppApi appApi) {
            t(binaryMessenger, "", appApi);
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8273a;
        }

        static /* synthetic */ void m(AppApi appApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            appApi.f((AppRequest) ((ArrayList) obj).get(0), new Result<AppReply>() {
                /* renamed from: a */
                public void success(AppReply appReply) {
                    arrayList.add(0, appReply);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void o(AppApi appApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            appApi.k(new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void p(AppApi appApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            appApi.i((AppRequest) ((ArrayList) obj).get(0), new Result<AppReply>() {
                /* renamed from: a */
                public void success(AppReply appReply) {
                    arrayList.add(0, appReply);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void q(AppApi appApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            appApi.r(new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        static void t(BinaryMessenger binaryMessenger, String str, AppApi appApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AppApi.openAnyNativeActivity" + str2, getCodec());
            if (appApi != null) {
                basicMessageChannel.setMessageHandler(new k(appApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AppApi.openNamedPage" + str2, getCodec());
            if (appApi != null) {
                basicMessageChannel2.setMessageHandler(new l(appApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AppApi.isIntlVersion" + str2, getCodec());
            if (appApi != null) {
                basicMessageChannel3.setMessageHandler(new m(appApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AppApi.isThirdPlatform" + str2, getCodec());
            if (appApi != null) {
                basicMessageChannel4.setMessageHandler(new n(appApi));
            } else {
                basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AppApi.checkDeviceConnectHelperState" + str2, getCodec());
            if (appApi != null) {
                basicMessageChannel5.setMessageHandler(new o(appApi));
            } else {
                basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AppApi.getDeviceId" + str2, getCodec());
            if (appApi != null) {
                basicMessageChannel6.setMessageHandler(new p(appApi));
            } else {
                basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void f(AppRequest appRequest, Result result);

        void h(Result result);

        void i(AppRequest appRequest, Result result);

        void k(Result result);

        void r(Result result);

        void s(Result result);
    }

    public static final class AppReply {

        /* renamed from: a  reason: collision with root package name */
        public Long f8265a;
        public String b;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public Long f8266a;
            public String b;

            public AppReply a() {
                AppReply appReply = new AppReply();
                appReply.b(this.f8266a);
                appReply.c(this.b);
                return appReply;
            }

            public Builder b(Long l) {
                this.f8266a = l;
                return this;
            }

            public Builder c(String str) {
                this.b = str;
                return this;
            }
        }

        public static AppReply a(ArrayList arrayList) {
            AppReply appReply = new AppReply();
            appReply.b((Long) arrayList.get(0));
            appReply.c((String) arrayList.get(1));
            return appReply;
        }

        public void b(Long l) {
            if (l != null) {
                this.f8265a = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"code\" is null.");
        }

        public void c(String str) {
            this.b = str;
        }

        public ArrayList d() {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(this.f8265a);
            arrayList.add(this.b);
            return arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AppReply.class != obj.getClass()) {
                return false;
            }
            AppReply appReply = (AppReply) obj;
            return this.f8265a.equals(appReply.f8265a) && Objects.equals(this.b, appReply.b);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8265a, this.b});
        }
    }

    public static final class AppRequest {

        /* renamed from: a  reason: collision with root package name */
        public String f8267a;
        public String b;
        public String c;

        public static final class Builder {
        }

        public static AppRequest a(ArrayList arrayList) {
            AppRequest appRequest = new AppRequest();
            appRequest.c((String) arrayList.get(0));
            appRequest.e((String) arrayList.get(1));
            appRequest.d((String) arrayList.get(2));
            return appRequest;
        }

        public String b() {
            return this.b;
        }

        public void c(String str) {
            this.f8267a = str;
        }

        public void d(String str) {
            this.c = str;
        }

        public void e(String str) {
            this.b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AppRequest.class != obj.getClass()) {
                return false;
            }
            AppRequest appRequest = (AppRequest) obj;
            return Objects.equals(this.f8267a, appRequest.f8267a) && Objects.equals(this.b, appRequest.b) && Objects.equals(this.c, appRequest.c);
        }

        public ArrayList f() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f8267a);
            arrayList.add(this.b);
            arrayList.add(this.c);
            return arrayList;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8267a, this.b, this.c});
        }
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface CanIgnoreReturnValue {
    }

    public static class FlutterAppApi {

        /* renamed from: a  reason: collision with root package name */
        public final BinaryMessenger f8268a;
        public final String b;

        public FlutterAppApi(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public static MessageCodec c() {
            return PigeonCodec.f8273a;
        }

        public static /* synthetic */ void d(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidAppApi.a(str));
            }
        }

        public static /* synthetic */ void e(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidAppApi.a(str));
            }
        }

        public void f(VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterAppApi.networkChanged" + this.b;
            new BasicMessageChannel(this.f8268a, str, c()).send(null, new q(voidResult, str));
        }

        public void g(VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterAppApi.onChannelReady" + this.b;
            new BasicMessageChannel(this.f8268a, str, c()).send(null, new r(voidResult, str));
        }

        public FlutterAppApi(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.f8268a = binaryMessenger;
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

    public static class FlutterGlassSettingApi {

        /* renamed from: a  reason: collision with root package name */
        public final BinaryMessenger f8269a;
        public final String b;

        public FlutterGlassSettingApi(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public static MessageCodec c() {
            return PigeonCodec.f8273a;
        }

        public static /* synthetic */ void d(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidAppApi.a(str));
            }
        }

        public static /* synthetic */ void e(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidAppApi.a(str));
            }
        }

        public void f(Boolean bool, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterGlassSettingApi.onCaptifyStateChange" + this.b;
            new BasicMessageChannel(this.f8269a, str, c()).send(new ArrayList(Collections.singletonList(bool)), new s(voidResult, str));
        }

        public void g(Boolean bool, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterGlassSettingApi.onWearDetectionModelChange" + this.b;
            new BasicMessageChannel(this.f8269a, str, c()).send(new ArrayList(Collections.singletonList(bool)), new t(voidResult, str));
        }

        public FlutterGlassSettingApi(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.f8269a = binaryMessenger;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            this.b = str2;
        }
    }

    public interface GlassSettingApi {
        static /* synthetic */ void a(GlassSettingApi glassSettingApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            glassSettingApi.c(new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        static void b(BinaryMessenger binaryMessenger, String str, GlassSettingApi glassSettingApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.GlassSettingApi.getWearDetectionModel" + str2, getCodec());
            if (glassSettingApi != null) {
                basicMessageChannel.setMessageHandler(new u(glassSettingApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static void e(BinaryMessenger binaryMessenger, GlassSettingApi glassSettingApi) {
            b(binaryMessenger, "", glassSettingApi);
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8273a;
        }

        void c(Result result);
    }

    public static final class HomeTips {

        /* renamed from: a  reason: collision with root package name */
        public String f8271a;
        public String b;
        public Long c;
        public Map d;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public String f8272a;
            public String b;
            public Long c;
            public Map d;

            public HomeTips a() {
                HomeTips homeTips = new HomeTips();
                homeTips.d(this.f8272a);
                homeTips.f(this.b);
                homeTips.c(this.c);
                homeTips.e(this.d);
                return homeTips;
            }

            public Builder b(Long l) {
                this.c = l;
                return this;
            }

            public Builder c(String str) {
                this.f8272a = str;
                return this;
            }

            public Builder d(Map map) {
                this.d = map;
                return this;
            }

            public Builder e(String str) {
                this.b = str;
                return this;
            }
        }

        public static HomeTips a(ArrayList arrayList) {
            HomeTips homeTips = new HomeTips();
            homeTips.d((String) arrayList.get(0));
            homeTips.f((String) arrayList.get(1));
            homeTips.c((Long) arrayList.get(2));
            homeTips.e((Map) arrayList.get(3));
            return homeTips;
        }

        public String b() {
            return this.f8271a;
        }

        public void c(Long l) {
            if (l != null) {
                this.c = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"priority\" is null.");
        }

        public void d(String str) {
            if (str != null) {
                this.f8271a = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"tipsKey\" is null.");
        }

        public void e(Map map) {
            if (map != null) {
                this.d = map;
                return;
            }
            throw new IllegalStateException("Nonnull field \"uiParam\" is null.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HomeTips.class != obj.getClass()) {
                return false;
            }
            HomeTips homeTips = (HomeTips) obj;
            return this.f8271a.equals(homeTips.f8271a) && this.b.equals(homeTips.b) && this.c.equals(homeTips.c) && this.d.equals(homeTips.d);
        }

        public void f(String str) {
            if (str != null) {
                this.b = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"uiType\" is null.");
        }

        public ArrayList g() {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(this.f8271a);
            arrayList.add(this.b);
            arrayList.add(this.c);
            arrayList.add(this.d);
            return arrayList;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8271a, this.b, this.c, this.d});
        }
    }

    public interface NullableResult<T> {
    }

    public static class PigeonCodec extends StandardMessageCodec {

        /* renamed from: a  reason: collision with root package name */
        public static final PigeonCodec f8273a = new PigeonCodec();

        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            switch (b) {
                case -127:
                    return AppRequest.a((ArrayList) readValue(byteBuffer));
                case -126:
                    return AppReply.a((ArrayList) readValue(byteBuffer));
                case -125:
                    return HomeTips.a((ArrayList) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b, byteBuffer);
            }
        }

        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof AppRequest) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((AppRequest) obj).f());
            } else if (obj instanceof AppReply) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, ((AppReply) obj).d());
            } else if (obj instanceof HomeTips) {
                byteArrayOutputStream.write(TrackerEvent.PositioningOfflineOutdoor);
                writeValue(byteArrayOutputStream, ((HomeTips) obj).g());
            } else {
                super.writeValue(byteArrayOutputStream, obj);
            }
        }
    }

    public interface Result<T> {
        void success(Object obj);
    }

    public interface RouteGuardApi {
        static void a(BinaryMessenger binaryMessenger, String str, RouteGuardApi routeGuardApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.RouteGuardApi.flutterPagePush" + str2, getCodec());
            if (routeGuardApi != null) {
                basicMessageChannel.setMessageHandler(new v(routeGuardApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static /* synthetic */ void c(RouteGuardApi routeGuardApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            routeGuardApi.b((String) ((ArrayList) obj).get(0), new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        static void d(BinaryMessenger binaryMessenger, RouteGuardApi routeGuardApi) {
            a(binaryMessenger, "", routeGuardApi);
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8273a;
        }

        void b(String str, Result result);
    }

    public interface TipsApi {
        static /* synthetic */ void b(TipsApi tipsApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            tipsApi.a((String) ((ArrayList) obj).get(0), new VoidResult() {
                public void error(Throwable th) {
                    reply.reply(AndroidAppApi.b(th));
                }

                public void success() {
                    arrayList.add(0, (Object) null);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void c(TipsApi tipsApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            tipsApi.d((String) ((ArrayList) obj).get(0), new VoidResult() {
                public void error(Throwable th) {
                    reply.reply(AndroidAppApi.b(th));
                }

                public void success() {
                    arrayList.add(0, (Object) null);
                    reply.reply(arrayList);
                }
            });
        }

        static void e(BinaryMessenger binaryMessenger, TipsApi tipsApi) {
            f(binaryMessenger, "", tipsApi);
        }

        static void f(BinaryMessenger binaryMessenger, String str, TipsApi tipsApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.TipsApi.clickTipsDismiss" + str2, getCodec());
            if (tipsApi != null) {
                basicMessageChannel.setMessageHandler(new w(tipsApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.TipsApi.clickTipsBtn" + str2, getCodec());
            if (tipsApi != null) {
                basicMessageChannel2.setMessageHandler(new x(tipsApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8273a;
        }

        void a(String str, VoidResult voidResult);

        void d(String str, VoidResult voidResult);
    }

    public static class TipsFlutterApi {

        /* renamed from: a  reason: collision with root package name */
        public final BinaryMessenger f8277a;
        public final String b;

        public TipsFlutterApi(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public static MessageCodec d() {
            return PigeonCodec.f8273a;
        }

        public static /* synthetic */ void e(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidAppApi.a(str));
            }
        }

        public static /* synthetic */ void f(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidAppApi.a(str));
            }
        }

        public void c(String str, VoidResult voidResult) {
            String str2 = "dev.flutter.pigeon.myvu_flutter.TipsFlutterApi.cancelTips" + this.b;
            new BasicMessageChannel(this.f8277a, str2, d()).send(new ArrayList(Collections.singletonList(str)), new y(voidResult, str2));
        }

        public void g(HomeTips homeTips, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.TipsFlutterApi.showHomeTips" + this.b;
            new BasicMessageChannel(this.f8277a, str, d()).send(new ArrayList(Collections.singletonList(homeTips)), new z(voidResult, str));
        }

        public TipsFlutterApi(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.f8277a = binaryMessenger;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            this.b = str2;
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
