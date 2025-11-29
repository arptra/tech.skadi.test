package com.xjmz.myvu.flutter.pigeon;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.posclient.analytics.TrackerEvent;
import com.honey.account.r9.h0;
import com.honey.account.r9.i0;
import com.honey.account.r9.j0;
import com.honey.account.r9.k0;
import com.honey.account.r9.l0;
import com.honey.account.r9.m0;
import com.honey.account.r9.n0;
import com.honey.account.r9.o0;
import com.honey.account.r9.p0;
import com.honey.account.r9.q0;
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
import java.util.Objects;

public class AndroidConnectApi {

    public static final class BatteryInfo {

        /* renamed from: a  reason: collision with root package name */
        public Long f8290a;
        public Boolean b;
        public String c;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public Long f8291a;
            public Boolean b;
            public String c;

            public BatteryInfo a() {
                BatteryInfo batteryInfo = new BatteryInfo();
                batteryInfo.b(this.f8291a);
                batteryInfo.d(this.b);
                batteryInfo.c(this.c);
                return batteryInfo;
            }

            public Builder b(Long l) {
                this.f8291a = l;
                return this;
            }

            public Builder c(String str) {
                this.c = str;
                return this;
            }

            public Builder d(Boolean bool) {
                this.b = bool;
                return this;
            }
        }

        public static BatteryInfo a(ArrayList arrayList) {
            Long l;
            BatteryInfo batteryInfo = new BatteryInfo();
            Object obj = arrayList.get(0);
            if (obj == null) {
                l = null;
            } else {
                l = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            batteryInfo.b(l);
            batteryInfo.d((Boolean) arrayList.get(1));
            batteryInfo.c((String) arrayList.get(2));
            return batteryInfo;
        }

        public void b(Long l) {
            if (l != null) {
                this.f8290a = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"battery\" is null.");
        }

        public void c(String str) {
            if (str != null) {
                this.c = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"deviceId\" is null.");
        }

        public void d(Boolean bool) {
            if (bool != null) {
                this.b = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"isCharging\" is null.");
        }

        public ArrayList e() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f8290a);
            arrayList.add(this.b);
            arrayList.add(this.c);
            return arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || BatteryInfo.class != obj.getClass()) {
                return false;
            }
            BatteryInfo batteryInfo = (BatteryInfo) obj;
            return this.f8290a.equals(batteryInfo.f8290a) && this.b.equals(batteryInfo.b) && this.c.equals(batteryInfo.c);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8290a, this.b, this.c});
        }
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface CanIgnoreReturnValue {
    }

    public interface ConnectApi {
        static void a(BinaryMessenger binaryMessenger, String str, ConnectApi connectApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.ConnectApi.reconnectDevice" + str2, getCodec());
            if (connectApi != null) {
                basicMessageChannel.setMessageHandler(new h0(connectApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.ConnectApi.getHistoryDevices" + str2, getCodec());
            if (connectApi != null) {
                basicMessageChannel2.setMessageHandler(new i0(connectApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.ConnectApi.getGlassSn" + str2, getCodec());
            if (connectApi != null) {
                basicMessageChannel3.setMessageHandler(new j0(connectApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.ConnectApi.refreshConnectState" + str2, getCodec());
            if (connectApi != null) {
                basicMessageChannel4.setMessageHandler(new k0(connectApi));
            } else {
                basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.ConnectApi.unbindDevice" + str2, getCodec());
            if (connectApi != null) {
                basicMessageChannel5.setMessageHandler(new l0(connectApi));
            } else {
                basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.ConnectApi.onDeviceSelect" + str2, getCodec());
            if (connectApi != null) {
                basicMessageChannel6.setMessageHandler(new m0(connectApi));
            } else {
                basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static /* synthetic */ void c(ConnectApi connectApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            connectApi.p(new Result<List<DeviceInfo>>() {
                /* renamed from: a */
                public void success(List list) {
                    arrayList.add(0, list);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void f(ConnectApi connectApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                connectApi.r();
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidConnectApi.b(th);
            }
            reply.reply(arrayList);
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8302a;
        }

        static /* synthetic */ void j(ConnectApi connectApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            connectApi.b((DeviceInfo) ((ArrayList) obj).get(0), new VoidResult() {
                public void error(Throwable th) {
                    reply.reply(AndroidConnectApi.b(th));
                }

                public void success() {
                    arrayList.add(0, (Object) null);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void l(ConnectApi connectApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            connectApi.e((DeviceInfo) ((ArrayList) obj).get(0), new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void n(ConnectApi connectApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                connectApi.d();
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidConnectApi.b(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void o(ConnectApi connectApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            connectApi.t((String) ((ArrayList) obj).get(0), new Result<String>() {
                /* renamed from: a */
                public void success(String str) {
                    arrayList.add(0, str);
                    reply.reply(arrayList);
                }
            });
        }

        static void s(BinaryMessenger binaryMessenger, ConnectApi connectApi) {
            a(binaryMessenger, "", connectApi);
        }

        void b(DeviceInfo deviceInfo, VoidResult voidResult);

        void d();

        void e(DeviceInfo deviceInfo, Result result);

        void p(Result result);

        void r();

        void t(String str, Result result);
    }

    public static final class ConnectState {

        /* renamed from: a  reason: collision with root package name */
        public StateEnum f8296a;
        public String b;
        public String c;
        public String d;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public StateEnum f8297a;
            public String b;
            public String c;
            public String d;

            public ConnectState a() {
                ConnectState connectState = new ConnectState();
                connectState.e(this.f8297a);
                connectState.b(this.b);
                connectState.c(this.c);
                connectState.d(this.d);
                return connectState;
            }

            public Builder b(String str) {
                this.b = str;
                return this;
            }

            public Builder c(String str) {
                this.c = str;
                return this;
            }

            public Builder d(String str) {
                this.d = str;
                return this;
            }

            public Builder e(StateEnum stateEnum) {
                this.f8297a = stateEnum;
                return this;
            }
        }

        public static ConnectState a(ArrayList arrayList) {
            ConnectState connectState = new ConnectState();
            connectState.e((StateEnum) arrayList.get(0));
            connectState.b((String) arrayList.get(1));
            connectState.c((String) arrayList.get(2));
            connectState.d((String) arrayList.get(3));
            return connectState;
        }

        public void b(String str) {
            if (str != null) {
                this.b = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"deviceId\" is null.");
        }

        public void c(String str) {
            if (str != null) {
                this.c = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"deviceName\" is null.");
        }

        public void d(String str) {
            if (str != null) {
                this.d = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"modelId\" is null.");
        }

        public void e(StateEnum stateEnum) {
            if (stateEnum != null) {
                this.f8296a = stateEnum;
                return;
            }
            throw new IllegalStateException("Nonnull field \"state\" is null.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ConnectState.class != obj.getClass()) {
                return false;
            }
            ConnectState connectState = (ConnectState) obj;
            return this.f8296a.equals(connectState.f8296a) && this.b.equals(connectState.b) && this.c.equals(connectState.c) && this.d.equals(connectState.d);
        }

        public ArrayList f() {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(this.f8296a);
            arrayList.add(this.b);
            arrayList.add(this.c);
            arrayList.add(this.d);
            return arrayList;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8296a, this.b, this.c, this.d});
        }
    }

    public static final class DeviceInfo {

        /* renamed from: a  reason: collision with root package name */
        public String f8298a;
        public String b;
        public String c;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public String f8299a;
            public String b;
            public String c;

            public DeviceInfo a() {
                DeviceInfo deviceInfo = new DeviceInfo();
                deviceInfo.f(this.f8299a);
                deviceInfo.g(this.b);
                deviceInfo.e(this.c);
                return deviceInfo;
            }

            public Builder b(String str) {
                this.c = str;
                return this;
            }

            public Builder c(String str) {
                this.f8299a = str;
                return this;
            }

            public Builder d(String str) {
                this.b = str;
                return this;
            }
        }

        public static DeviceInfo a(ArrayList arrayList) {
            DeviceInfo deviceInfo = new DeviceInfo();
            deviceInfo.f((String) arrayList.get(0));
            deviceInfo.g((String) arrayList.get(1));
            deviceInfo.e((String) arrayList.get(2));
            return deviceInfo;
        }

        public String b() {
            return this.c;
        }

        public String c() {
            return this.f8298a;
        }

        public String d() {
            return this.b;
        }

        public void e(String str) {
            if (str != null) {
                this.c = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"deviceId\" is null.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || DeviceInfo.class != obj.getClass()) {
                return false;
            }
            DeviceInfo deviceInfo = (DeviceInfo) obj;
            return this.f8298a.equals(deviceInfo.f8298a) && this.b.equals(deviceInfo.b) && this.c.equals(deviceInfo.c);
        }

        public void f(String str) {
            if (str != null) {
                this.f8298a = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"deviceName\" is null.");
        }

        public void g(String str) {
            if (str != null) {
                this.b = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"modelId\" is null.");
        }

        public ArrayList h() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f8298a);
            arrayList.add(this.b);
            arrayList.add(this.c);
            return arrayList;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8298a, this.b, this.c});
        }
    }

    public static class FlutterConnectApi {

        /* renamed from: a  reason: collision with root package name */
        public final BinaryMessenger f8300a;
        public final String b;

        public FlutterConnectApi(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public static MessageCodec d() {
            return PigeonCodec.f8302a;
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
                voidResult.error(AndroidConnectApi.a(str));
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
                voidResult.error(AndroidConnectApi.a(str));
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
                voidResult.error(AndroidConnectApi.a(str));
            }
        }

        public void h(BatteryInfo batteryInfo, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterConnectApi.notifyBatteryInfo" + this.b;
            new BasicMessageChannel(this.f8300a, str, d()).send(new ArrayList(Collections.singletonList(batteryInfo)), new o0(voidResult, str));
        }

        public void i(ConnectState connectState, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterConnectApi.notifyConnectState" + this.b;
            new BasicMessageChannel(this.f8300a, str, d()).send(new ArrayList(Collections.singletonList(connectState)), new n0(voidResult, str));
        }

        public void j(List list, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterConnectApi.notifyHistoryDevices" + this.b;
            new BasicMessageChannel(this.f8300a, str, d()).send(new ArrayList(Collections.singletonList(list)), new p0(voidResult, str));
        }

        public FlutterConnectApi(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.f8300a = binaryMessenger;
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

    public static class FlutterRing1ConnectApi {

        /* renamed from: a  reason: collision with root package name */
        public final BinaryMessenger f8301a;
        public final String b;

        public FlutterRing1ConnectApi(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public static MessageCodec b() {
            return PigeonCodec.f8302a;
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
                voidResult.error(AndroidConnectApi.a(str));
            }
        }

        public void d(Ring1Device ring1Device, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterRing1ConnectApi.notifyRingInfo" + this.b;
            new BasicMessageChannel(this.f8301a, str, b()).send(new ArrayList(Collections.singletonList(ring1Device)), new q0(voidResult, str));
        }

        public FlutterRing1ConnectApi(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.f8301a = binaryMessenger;
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
        public static final PigeonCodec f8302a = new PigeonCodec();

        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            switch (b) {
                case -127:
                    return BatteryInfo.a((ArrayList) readValue(byteBuffer));
                case -126:
                    return ConnectState.a((ArrayList) readValue(byteBuffer));
                case -125:
                    return DeviceInfo.a((ArrayList) readValue(byteBuffer));
                case -124:
                    return Ring1Device.a((ArrayList) readValue(byteBuffer));
                case -123:
                    Object readValue = readValue(byteBuffer);
                    if (readValue == null) {
                        return null;
                    }
                    return StateEnum.values()[((Integer) readValue).intValue()];
                default:
                    return super.readValueOfType(b, byteBuffer);
            }
        }

        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof BatteryInfo) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((BatteryInfo) obj).e());
            } else if (obj instanceof ConnectState) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, ((ConnectState) obj).f());
            } else if (obj instanceof DeviceInfo) {
                byteArrayOutputStream.write(TrackerEvent.PositioningOfflineOutdoor);
                writeValue(byteArrayOutputStream, ((DeviceInfo) obj).h());
            } else if (obj instanceof Ring1Device) {
                byteArrayOutputStream.write(132);
                writeValue(byteArrayOutputStream, ((Ring1Device) obj).e());
            } else if (obj instanceof StateEnum) {
                byteArrayOutputStream.write(133);
                writeValue(byteArrayOutputStream, obj == null ? null : Integer.valueOf(((StateEnum) obj).index));
            } else {
                super.writeValue(byteArrayOutputStream, obj);
            }
        }
    }

    public interface Result<T> {
        void success(Object obj);
    }

    public static final class Ring1Device {

        /* renamed from: a  reason: collision with root package name */
        public String f8303a;
        public Long b;
        public Boolean c;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public String f8304a;
            public Long b;
            public Boolean c;

            public Ring1Device a() {
                Ring1Device ring1Device = new Ring1Device();
                ring1Device.c(this.f8304a);
                ring1Device.b(this.b);
                ring1Device.d(this.c);
                return ring1Device;
            }

            public Builder b(Long l) {
                this.b = l;
                return this;
            }

            public Builder c(String str) {
                this.f8304a = str;
                return this;
            }

            public Builder d(Boolean bool) {
                this.c = bool;
                return this;
            }
        }

        public static Ring1Device a(ArrayList arrayList) {
            Long l;
            Ring1Device ring1Device = new Ring1Device();
            ring1Device.c((String) arrayList.get(0));
            Object obj = arrayList.get(1);
            if (obj == null) {
                l = null;
            } else {
                l = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            ring1Device.b(l);
            ring1Device.d((Boolean) arrayList.get(2));
            return ring1Device;
        }

        public void b(Long l) {
            if (l != null) {
                this.b = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"battery\" is null.");
        }

        public void c(String str) {
            if (str != null) {
                this.f8303a = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"deviceName\" is null.");
        }

        public void d(Boolean bool) {
            if (bool != null) {
                this.c = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"isConnect\" is null.");
        }

        public ArrayList e() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f8303a);
            arrayList.add(this.b);
            arrayList.add(this.c);
            return arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Ring1Device.class != obj.getClass()) {
                return false;
            }
            Ring1Device ring1Device = (Ring1Device) obj;
            return this.f8303a.equals(ring1Device.f8303a) && this.b.equals(ring1Device.b) && this.c.equals(ring1Device.c);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8303a, this.b, this.c});
        }
    }

    public enum StateEnum {
        SCANING(0),
        SCAN_TIMEOUT(1),
        SCAN_NEED_BLUETOOTH(2),
        CONNECT_SUCC(3),
        CONNECT_FAILED(4),
        CONNECT_NOT_SUPPORT(5);
        
        final int index;

        private StateEnum(int i) {
            this.index = i;
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
