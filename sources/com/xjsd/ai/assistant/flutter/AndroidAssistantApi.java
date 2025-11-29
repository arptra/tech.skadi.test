package com.xjsd.ai.assistant.flutter;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.posclient.analytics.TrackerEvent;
import com.honey.account.ca.a;
import com.honey.account.ca.b;
import com.honey.account.ca.c;
import com.honey.account.ca.d;
import com.honey.account.ca.e;
import com.honey.account.ca.f;
import com.honey.account.ca.g;
import com.honey.account.ca.h;
import com.honey.account.ca.i;
import com.honey.account.ca.j;
import com.honey.account.ca.k;
import com.honey.account.ca.l;
import com.honey.account.ca.m;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AndroidAssistantApi {

    public static final class AiEnvironment {

        /* renamed from: a  reason: collision with root package name */
        public String f8462a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;

        public static final class Builder {
        }

        public static AiEnvironment a(ArrayList arrayList) {
            AiEnvironment aiEnvironment = new AiEnvironment();
            aiEnvironment.d((String) arrayList.get(0));
            aiEnvironment.e((String) arrayList.get(1));
            aiEnvironment.b((String) arrayList.get(2));
            aiEnvironment.c((String) arrayList.get(3));
            aiEnvironment.f((String) arrayList.get(4));
            aiEnvironment.g((String) arrayList.get(5));
            return aiEnvironment;
        }

        public void b(String str) {
            if (str != null) {
                this.c = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"aiRecordUrl\" is null.");
        }

        public void c(String str) {
            if (str != null) {
                this.d = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"appId\" is null.");
        }

        public void d(String str) {
            if (str != null) {
                this.f8462a = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"asrUrl\" is null.");
        }

        public void e(String str) {
            if (str != null) {
                this.b = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"nluUrl\" is null.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AiEnvironment.class != obj.getClass()) {
                return false;
            }
            AiEnvironment aiEnvironment = (AiEnvironment) obj;
            return this.f8462a.equals(aiEnvironment.f8462a) && this.b.equals(aiEnvironment.b) && this.c.equals(aiEnvironment.c) && this.d.equals(aiEnvironment.d) && this.e.equals(aiEnvironment.e) && this.f.equals(aiEnvironment.f);
        }

        public void f(String str) {
            if (str != null) {
                this.e = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"userKey\" is null.");
        }

        public void g(String str) {
            if (str != null) {
                this.f = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"userSecret\" is null.");
        }

        public ArrayList h() {
            ArrayList arrayList = new ArrayList(6);
            arrayList.add(this.f8462a);
            arrayList.add(this.b);
            arrayList.add(this.c);
            arrayList.add(this.d);
            arrayList.add(this.e);
            arrayList.add(this.f);
            return arrayList;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8462a, this.b, this.c, this.d, this.e, this.f});
        }
    }

    public static class AssistantFlutterApi {

        /* renamed from: a  reason: collision with root package name */
        public final BinaryMessenger f8463a;
        public final String b;

        public AssistantFlutterApi(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public static MessageCodec d() {
            return PigeonCodec.f8476a;
        }

        public static /* synthetic */ void e(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), (String) list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidAssistantApi.createConnectionError(str));
            }
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
                voidResult.error(AndroidAssistantApi.createConnectionError(str));
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
                voidResult.error(AndroidAssistantApi.createConnectionError(str));
            }
        }

        public void h(NotifyEvent notifyEvent, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.AssistantFlutterApi.onBroadcastEvent" + this.b;
            new BasicMessageChannel(this.f8463a, str, d()).send(new ArrayList(Collections.singletonList(notifyEvent)), new a(voidResult, str));
        }

        public void i(Long l, String str, VoidResult voidResult) {
            String str2 = "dev.flutter.pigeon.myvu_flutter.AssistantFlutterApi.onCloudError" + this.b;
            new BasicMessageChannel(this.f8463a, str2, d()).send(new ArrayList(Arrays.asList(new Serializable[]{l, str})), new b(voidResult, str2));
        }

        public void j(CloudResponse cloudResponse, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.AssistantFlutterApi.onReceiveCloudResponse" + this.b;
            new BasicMessageChannel(this.f8463a, str, d()).send(new ArrayList(Collections.singletonList(cloudResponse)), new c(voidResult, str));
        }

        public AssistantFlutterApi(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.f8463a = binaryMessenger;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            this.b = str2;
        }
    }

    public interface AssistantHostApi {
        static /* synthetic */ void a(AssistantHostApi assistantHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            assistantHostApi.getAiEnvironment(new Result<AiEnvironment>() {
                /* renamed from: a */
                public void success(AiEnvironment aiEnvironment) {
                    arrayList.add(0, aiEnvironment);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void b(AssistantHostApi assistantHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            assistantHostApi.disconnectCloud((String) ((ArrayList) obj).get(0), new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void c(AssistantHostApi assistantHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            assistantHostApi.interrupt((String) ((ArrayList) obj).get(0), new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void e(AssistantHostApi assistantHostApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, assistantHostApi.endSendAudio());
            } catch (Throwable th) {
                arrayList = AndroidAssistantApi.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void f(AssistantHostApi assistantHostApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, assistantHostApi.sendAudioToCloud((byte[]) ((ArrayList) obj).get(0)));
            } catch (Throwable th) {
                arrayList = AndroidAssistantApi.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void g(AssistantHostApi assistantHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            assistantHostApi.startSendAudio((String) arrayList2.get(0), (Boolean) arrayList2.get(1), new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8476a;
        }

        static /* synthetic */ void h(AssistantHostApi assistantHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            assistantHostApi.sendTextToCloud((String) arrayList2.get(0), (String) arrayList2.get(1), (String) arrayList2.get(2), (Boolean) arrayList2.get(3), new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void i(AssistantHostApi assistantHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            assistantHostApi.connectCloud((String) ((ArrayList) obj).get(0), new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        static void j(BinaryMessenger binaryMessenger, String str, AssistantHostApi assistantHostApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AssistantHostApi.invokeGenericMethod" + str2, getCodec());
            if (assistantHostApi != null) {
                basicMessageChannel.setMessageHandler(new d(assistantHostApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AssistantHostApi.connectCloud" + str2, getCodec());
            if (assistantHostApi != null) {
                basicMessageChannel2.setMessageHandler(new e(assistantHostApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AssistantHostApi.sendTextToCloud" + str2, getCodec());
            if (assistantHostApi != null) {
                basicMessageChannel3.setMessageHandler(new f(assistantHostApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AssistantHostApi.startSendAudio" + str2, getCodec());
            if (assistantHostApi != null) {
                basicMessageChannel4.setMessageHandler(new g(assistantHostApi));
            } else {
                basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AssistantHostApi.sendAudioToCloud" + str2, getCodec());
            if (assistantHostApi != null) {
                basicMessageChannel5.setMessageHandler(new h(assistantHostApi));
            } else {
                basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AssistantHostApi.endSendAudio" + str2, getCodec());
            if (assistantHostApi != null) {
                basicMessageChannel6.setMessageHandler(new i(assistantHostApi));
            } else {
                basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AssistantHostApi.interrupt" + str2, getCodec());
            if (assistantHostApi != null) {
                basicMessageChannel7.setMessageHandler(new j(assistantHostApi));
            } else {
                basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AssistantHostApi.disconnectCloud" + str2, getCodec());
            if (assistantHostApi != null) {
                basicMessageChannel8.setMessageHandler(new k(assistantHostApi));
            } else {
                basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AssistantHostApi.getAiEnvironment" + str2, getCodec());
            if (assistantHostApi != null) {
                basicMessageChannel9.setMessageHandler(new l(assistantHostApi));
            } else {
                basicMessageChannel9.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AssistantHostApi.iosStopRecorder" + str2, getCodec());
            if (assistantHostApi != null) {
                basicMessageChannel10.setMessageHandler(new m(assistantHostApi));
            } else {
                basicMessageChannel10.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static /* synthetic */ void k(AssistantHostApi assistantHostApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                assistantHostApi.iosStopRecorder();
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidAssistantApi.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void u(AssistantHostApi assistantHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            assistantHostApi.invokeGenericMethod((InvokeRequest) ((ArrayList) obj).get(0), new Result<InvokeResult>() {
                /* renamed from: a */
                public void success(InvokeResult invokeResult) {
                    arrayList.add(0, invokeResult);
                    reply.reply(arrayList);
                }
            });
        }

        static void v(BinaryMessenger binaryMessenger, AssistantHostApi assistantHostApi) {
            j(binaryMessenger, "", assistantHostApi);
        }

        void connectCloud(String str, Result result);

        void disconnectCloud(String str, Result result);

        Boolean endSendAudio();

        void getAiEnvironment(Result result);

        void interrupt(String str, Result result);

        void invokeGenericMethod(InvokeRequest invokeRequest, Result result);

        void iosStopRecorder();

        Boolean sendAudioToCloud(byte[] bArr);

        void sendTextToCloud(String str, String str2, String str3, Boolean bool, Result result);

        void startSendAudio(String str, Boolean bool, Result result);
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface CanIgnoreReturnValue {
    }

    public static final class CloudResponse {

        /* renamed from: a  reason: collision with root package name */
        public String f8471a;
        public String b;
        public String c;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public String f8472a;
            public String b;
            public String c;

            public CloudResponse a() {
                CloudResponse cloudResponse = new CloudResponse();
                cloudResponse.c(this.f8472a);
                cloudResponse.d(this.b);
                cloudResponse.b(this.c);
                return cloudResponse;
            }

            public Builder b(String str) {
                this.c = str;
                return this;
            }

            public Builder c(String str) {
                this.f8472a = str;
                return this;
            }

            public Builder d(String str) {
                this.b = str;
                return this;
            }
        }

        public static CloudResponse a(ArrayList arrayList) {
            CloudResponse cloudResponse = new CloudResponse();
            cloudResponse.c((String) arrayList.get(0));
            cloudResponse.d((String) arrayList.get(1));
            cloudResponse.b((String) arrayList.get(2));
            return cloudResponse;
        }

        public void b(String str) {
            this.c = str;
        }

        public void c(String str) {
            if (str != null) {
                this.f8471a = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"requestId\" is null.");
        }

        public void d(String str) {
            if (str != null) {
                this.b = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"type\" is null.");
        }

        public ArrayList e() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f8471a);
            arrayList.add(this.b);
            arrayList.add(this.c);
            return arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || CloudResponse.class != obj.getClass()) {
                return false;
            }
            CloudResponse cloudResponse = (CloudResponse) obj;
            return this.f8471a.equals(cloudResponse.f8471a) && this.b.equals(cloudResponse.b) && Objects.equals(this.c, cloudResponse.c);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8471a, this.b, this.c});
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

    public static final class InvokeRequest {

        /* renamed from: a  reason: collision with root package name */
        public String f8473a;
        public String b;

        public static final class Builder {
        }

        public static InvokeRequest a(ArrayList arrayList) {
            InvokeRequest invokeRequest = new InvokeRequest();
            invokeRequest.e((String) arrayList.get(0));
            invokeRequest.d((String) arrayList.get(1));
            return invokeRequest;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.f8473a;
        }

        public void d(String str) {
            this.b = str;
        }

        public void e(String str) {
            if (str != null) {
                this.f8473a = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"target\" is null.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || InvokeRequest.class != obj.getClass()) {
                return false;
            }
            InvokeRequest invokeRequest = (InvokeRequest) obj;
            return this.f8473a.equals(invokeRequest.f8473a) && Objects.equals(this.b, invokeRequest.b);
        }

        public ArrayList f() {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(this.f8473a);
            arrayList.add(this.b);
            return arrayList;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8473a, this.b});
        }
    }

    public static final class InvokeResult {

        /* renamed from: a  reason: collision with root package name */
        public Long f8474a;
        public String b;

        public static final class Builder {
        }

        public static InvokeResult a(ArrayList arrayList) {
            Long l;
            InvokeResult invokeResult = new InvokeResult();
            Object obj = arrayList.get(0);
            if (obj == null) {
                l = null;
            } else {
                l = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            invokeResult.b(l);
            invokeResult.c((String) arrayList.get(1));
            return invokeResult;
        }

        public void b(Long l) {
            if (l != null) {
                this.f8474a = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"code\" is null.");
        }

        public void c(String str) {
            this.b = str;
        }

        public ArrayList d() {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(this.f8474a);
            arrayList.add(this.b);
            return arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || InvokeResult.class != obj.getClass()) {
                return false;
            }
            InvokeResult invokeResult = (InvokeResult) obj;
            return this.f8474a.equals(invokeResult.f8474a) && Objects.equals(this.b, invokeResult.b);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8474a, this.b});
        }
    }

    public static final class NotifyEvent {

        /* renamed from: a  reason: collision with root package name */
        public String f8475a;
        public String b;

        public static final class Builder {
        }

        public static NotifyEvent a(ArrayList arrayList) {
            NotifyEvent notifyEvent = new NotifyEvent();
            notifyEvent.c((String) arrayList.get(0));
            notifyEvent.b((String) arrayList.get(1));
            return notifyEvent;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            if (str != null) {
                this.f8475a = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"event\" is null.");
        }

        public ArrayList d() {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(this.f8475a);
            arrayList.add(this.b);
            return arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || NotifyEvent.class != obj.getClass()) {
                return false;
            }
            NotifyEvent notifyEvent = (NotifyEvent) obj;
            return this.f8475a.equals(notifyEvent.f8475a) && Objects.equals(this.b, notifyEvent.b);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8475a, this.b});
        }
    }

    public interface NullableResult<T> {
    }

    public static class PigeonCodec extends StandardMessageCodec {

        /* renamed from: a  reason: collision with root package name */
        public static final PigeonCodec f8476a = new PigeonCodec();

        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            switch (b) {
                case -127:
                    return NotifyEvent.a((ArrayList) readValue(byteBuffer));
                case -126:
                    return InvokeRequest.a((ArrayList) readValue(byteBuffer));
                case -125:
                    return InvokeResult.a((ArrayList) readValue(byteBuffer));
                case -124:
                    return CloudResponse.a((ArrayList) readValue(byteBuffer));
                case -123:
                    return AiEnvironment.a((ArrayList) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b, byteBuffer);
            }
        }

        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof NotifyEvent) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((NotifyEvent) obj).d());
            } else if (obj instanceof InvokeRequest) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, ((InvokeRequest) obj).f());
            } else if (obj instanceof InvokeResult) {
                byteArrayOutputStream.write(TrackerEvent.PositioningOfflineOutdoor);
                writeValue(byteArrayOutputStream, ((InvokeResult) obj).d());
            } else if (obj instanceof CloudResponse) {
                byteArrayOutputStream.write(132);
                writeValue(byteArrayOutputStream, ((CloudResponse) obj).e());
            } else if (obj instanceof AiEnvironment) {
                byteArrayOutputStream.write(133);
                writeValue(byteArrayOutputStream, ((AiEnvironment) obj).h());
            } else {
                super.writeValue(byteArrayOutputStream, obj);
            }
        }
    }

    public interface Result<T> {
        void success(Object obj);
    }

    public interface VoidResult {
        void error(Throwable th);

        void success();
    }

    @NonNull
    public static FlutterError createConnectionError(@NonNull String str) {
        return new FlutterError("channel-error", "Unable to establish connection on channel: " + str + ".", "");
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
