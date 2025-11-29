package com.xjmz.myvu.flutter.pigeon;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.posclient.analytics.TrackerEvent;
import com.honey.account.r9.a2;
import com.honey.account.r9.b2;
import com.honey.account.r9.c2;
import com.honey.account.r9.l1;
import com.honey.account.r9.m1;
import com.honey.account.r9.n1;
import com.honey.account.r9.o1;
import com.honey.account.r9.p1;
import com.honey.account.r9.q1;
import com.honey.account.r9.r1;
import com.honey.account.r9.s1;
import com.honey.account.r9.t1;
import com.honey.account.r9.u1;
import com.honey.account.r9.v1;
import com.honey.account.r9.w1;
import com.honey.account.r9.x1;
import com.honey.account.r9.y1;
import com.honey.account.r9.z1;
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

public class AndroidRingStarryNetApi {

    public enum AppCountryType {
        CHINA(0),
        OVERSEA(1);
        
        final int index;

        private AppCountryType(int i) {
            this.index = i;
        }
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface CanIgnoreReturnValue {
    }

    public enum DeviceCountryType {
        CHINA(0),
        OVERSEA(1),
        UNKNOWN(2);
        
        final int index;

        private DeviceCountryType(int i) {
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

    public static class FlutterStarryNetApi {

        /* renamed from: a  reason: collision with root package name */
        public final BinaryMessenger f8327a;
        public final String b;

        public FlutterStarryNetApi(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public static MessageCodec e() {
            return PigeonCodec.f8328a;
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
                voidResult.error(AndroidRingStarryNetApi.a(str));
            }
        }

        public static /* synthetic */ void g(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidRingStarryNetApi.a(str));
            }
        }

        public static /* synthetic */ void h(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidRingStarryNetApi.a(str));
            }
        }

        public static /* synthetic */ void i(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidRingStarryNetApi.a(str));
            }
        }

        public void j(String str, String str2, String str3, byte[] bArr, Long l, VoidResult voidResult) {
            String str4 = "dev.flutter.pigeon.myvu_flutter.FlutterStarryNetApi.listenBypassMessage" + this.b;
            new BasicMessageChannel(this.f8327a, str4, e()).send(new ArrayList(Arrays.asList(new Serializable[]{str, str2, str3, bArr, l})), new o1(voidResult, str4));
        }

        public void k(StarryNetDevice starryNetDevice, Long l, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterStarryNetApi.onBondStateChange" + this.b;
            new BasicMessageChannel(this.f8327a, str, e()).send(new ArrayList(Arrays.asList(new Object[]{starryNetDevice, l})), new m1(voidResult, str));
        }

        public void l(StarryNetDevice starryNetDevice, Long l, Long l2, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterStarryNetApi.onConnectFail" + this.b;
            new BasicMessageChannel(this.f8327a, str, e()).send(new ArrayList(Arrays.asList(new Object[]{starryNetDevice, l, l2})), new l1(voidResult, str));
        }

        public void m(StarryNetDevice starryNetDevice, Long l, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterStarryNetApi.onConnectStateChange" + this.b;
            new BasicMessageChannel(this.f8327a, str, e()).send(new ArrayList(Arrays.asList(new Object[]{starryNetDevice, l})), new n1(voidResult, str));
        }

        public FlutterStarryNetApi(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.f8327a = binaryMessenger;
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
        public static final PigeonCodec f8328a = new PigeonCodec();

        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            switch (b) {
                case -127:
                    Object readValue = readValue(byteBuffer);
                    if (readValue == null) {
                        return null;
                    }
                    return AppCountryType.values()[((Long) readValue).intValue()];
                case -126:
                    Object readValue2 = readValue(byteBuffer);
                    if (readValue2 == null) {
                        return null;
                    }
                    return DeviceCountryType.values()[((Long) readValue2).intValue()];
                case -125:
                    return StarryNetDevice.a((ArrayList) readValue(byteBuffer));
                case -124:
                    return Ring2BatteryInfo.a((ArrayList) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b, byteBuffer);
            }
        }

        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            Integer num = null;
            if (obj instanceof AppCountryType) {
                byteArrayOutputStream.write(129);
                if (obj != null) {
                    num = Integer.valueOf(((AppCountryType) obj).index);
                }
                writeValue(byteArrayOutputStream, num);
            } else if (obj instanceof DeviceCountryType) {
                byteArrayOutputStream.write(130);
                if (obj != null) {
                    num = Integer.valueOf(((DeviceCountryType) obj).index);
                }
                writeValue(byteArrayOutputStream, num);
            } else if (obj instanceof StarryNetDevice) {
                byteArrayOutputStream.write(TrackerEvent.PositioningOfflineOutdoor);
                writeValue(byteArrayOutputStream, ((StarryNetDevice) obj).l());
            } else if (obj instanceof Ring2BatteryInfo) {
                byteArrayOutputStream.write(132);
                writeValue(byteArrayOutputStream, ((Ring2BatteryInfo) obj).d());
            } else {
                super.writeValue(byteArrayOutputStream, obj);
            }
        }
    }

    public interface Result<T> {
        void success(Object obj);
    }

    public static final class Ring2BatteryInfo {

        /* renamed from: a  reason: collision with root package name */
        public Long f8329a;
        public Boolean b;

        public static final class Builder {
        }

        public static Ring2BatteryInfo a(ArrayList arrayList) {
            Ring2BatteryInfo ring2BatteryInfo = new Ring2BatteryInfo();
            ring2BatteryInfo.b((Long) arrayList.get(0));
            ring2BatteryInfo.c((Boolean) arrayList.get(1));
            return ring2BatteryInfo;
        }

        public void b(Long l) {
            if (l != null) {
                this.f8329a = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"battery\" is null.");
        }

        public void c(Boolean bool) {
            if (bool != null) {
                this.b = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"isCharging\" is null.");
        }

        public ArrayList d() {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(this.f8329a);
            arrayList.add(this.b);
            return arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Ring2BatteryInfo.class != obj.getClass()) {
                return false;
            }
            Ring2BatteryInfo ring2BatteryInfo = (Ring2BatteryInfo) obj;
            return this.f8329a.equals(ring2BatteryInfo.f8329a) && this.b.equals(ring2BatteryInfo.b);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8329a, this.b});
        }
    }

    public static class ScanDeviceCallback {

        /* renamed from: a  reason: collision with root package name */
        public final BinaryMessenger f8330a;
        public final String b;

        public ScanDeviceCallback(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public static MessageCodec d() {
            return PigeonCodec.f8328a;
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
                voidResult.error(AndroidRingStarryNetApi.a(str));
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
                voidResult.error(AndroidRingStarryNetApi.a(str));
            }
        }

        public static /* synthetic */ void g(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidRingStarryNetApi.a(str));
            }
        }

        public void h(StarryNetDevice starryNetDevice, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.ScanDeviceCallback.onDeviceLose" + this.b;
            new BasicMessageChannel(this.f8330a, str, d()).send(new ArrayList(Collections.singletonList(starryNetDevice)), new q1(voidResult, str));
        }

        public void i(StarryNetDevice starryNetDevice, Long l, AppCountryType appCountryType, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.ScanDeviceCallback.onFastFound" + this.b;
            new BasicMessageChannel(this.f8330a, str, d()).send(new ArrayList(Arrays.asList(new Object[]{starryNetDevice, l, appCountryType})), new r1(voidResult, str));
        }

        public void j(StarryNetDevice starryNetDevice, byte[] bArr, AppCountryType appCountryType, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.ScanDeviceCallback.onRing2Found" + this.b;
            new BasicMessageChannel(this.f8330a, str, d()).send(new ArrayList(Arrays.asList(new Object[]{starryNetDevice, bArr, appCountryType})), new p1(voidResult, str));
        }

        public ScanDeviceCallback(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.f8330a = binaryMessenger;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            this.b = str2;
        }
    }

    public static class SendMessageCallback {

        /* renamed from: a  reason: collision with root package name */
        public final BinaryMessenger f8331a;
        public final String b;

        public SendMessageCallback(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public static MessageCodec b() {
            return PigeonCodec.f8328a;
        }

        public static /* synthetic */ void c(VoidResult voidResult, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
                } else {
                    voidResult.success();
                }
            } else {
                voidResult.error(AndroidRingStarryNetApi.a(str));
            }
        }

        public void d(Boolean bool, Long l, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.SendMessageCallback.onResult" + this.b;
            new BasicMessageChannel(this.f8331a, str, b()).send(new ArrayList(Arrays.asList(new Serializable[]{bool, l})), new s1(voidResult, str));
        }

        public SendMessageCallback(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.f8331a = binaryMessenger;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            this.b = str2;
        }
    }

    public interface StarryNetApi {
        static /* synthetic */ void b(StarryNetApi starryNetApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                starryNetApi.u();
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidRingStarryNetApi.b(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void d(StarryNetApi starryNetApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, starryNetApi.getConnectedDevice());
            } catch (Throwable th) {
                arrayList = AndroidRingStarryNetApi.b(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void f(StarryNetApi starryNetApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, starryNetApi.getBondedDevice());
            } catch (Throwable th) {
                arrayList = AndroidRingStarryNetApi.b(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void g(StarryNetApi starryNetApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                starryNetApi.l((String) arrayList2.get(0), (byte[]) arrayList2.get(1));
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidRingStarryNetApi.b(th);
            }
            reply.reply(arrayList);
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8328a;
        }

        static /* synthetic */ void i(StarryNetApi starryNetApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, starryNetApi.a((String) ((ArrayList) obj).get(0)));
            } catch (Throwable th) {
                arrayList = AndroidRingStarryNetApi.b(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void k(StarryNetApi starryNetApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                starryNetApi.t((String) ((ArrayList) obj).get(0));
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidRingStarryNetApi.b(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void m(StarryNetApi starryNetApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                starryNetApi.v();
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidRingStarryNetApi.b(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void o(StarryNetApi starryNetApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                starryNetApi.disconnect((String) ((ArrayList) obj).get(0));
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidRingStarryNetApi.b(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void q(StarryNetApi starryNetApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            starryNetApi.A((String) ((ArrayList) obj).get(0), new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        static void r(BinaryMessenger binaryMessenger, StarryNetApi starryNetApi) {
            z(binaryMessenger, "", starryNetApi);
        }

        static /* synthetic */ void x(StarryNetApi starryNetApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList arrayList = new ArrayList();
            try {
                starryNetApi.w((Ring2BatteryInfo) ((ArrayList) obj).get(0));
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = AndroidRingStarryNetApi.b(th);
            }
            reply.reply(arrayList);
        }

        static void z(BinaryMessenger binaryMessenger, String str, StarryNetApi starryNetApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.StarryNetApi.scanDevice" + str2, getCodec());
            if (starryNetApi != null) {
                basicMessageChannel.setMessageHandler(new t1(starryNetApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.StarryNetApi.stopScanDevice" + str2, getCodec());
            if (starryNetApi != null) {
                basicMessageChannel2.setMessageHandler(new u1(starryNetApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.StarryNetApi.bindDevice" + str2, getCodec());
            if (starryNetApi != null) {
                basicMessageChannel3.setMessageHandler(new v1(starryNetApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.StarryNetApi.unbindDevice" + str2, getCodec());
            if (starryNetApi != null) {
                basicMessageChannel4.setMessageHandler(new w1(starryNetApi));
            } else {
                basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.StarryNetApi.disconnect" + str2, getCodec());
            if (starryNetApi != null) {
                basicMessageChannel5.setMessageHandler(new x1(starryNetApi));
            } else {
                basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.StarryNetApi.getBondedDevice" + str2, getCodec());
            if (starryNetApi != null) {
                basicMessageChannel6.setMessageHandler(new y1(starryNetApi));
            } else {
                basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.StarryNetApi.getConnectedDevice" + str2, getCodec());
            if (starryNetApi != null) {
                basicMessageChannel7.setMessageHandler(new z1(starryNetApi));
            } else {
                basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.StarryNetApi.isBonded" + str2, getCodec());
            if (starryNetApi != null) {
                basicMessageChannel8.setMessageHandler(new a2(starryNetApi));
            } else {
                basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.StarryNetApi.sendMessage" + str2, getCodec());
            if (starryNetApi != null) {
                basicMessageChannel9.setMessageHandler(new b2(starryNetApi));
            } else {
                basicMessageChannel9.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.StarryNetApi.ring2BatteryInfo" + str2, getCodec());
            if (starryNetApi != null) {
                basicMessageChannel10.setMessageHandler(new c2(starryNetApi));
            } else {
                basicMessageChannel10.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void A(String str, Result result);

        Boolean a(String str);

        void disconnect(String str);

        List getBondedDevice();

        List getConnectedDevice();

        void l(String str, byte[] bArr);

        void t(String str);

        void u();

        void v();

        void w(Ring2BatteryInfo ring2BatteryInfo);
    }

    public static final class StarryNetDevice {

        /* renamed from: a  reason: collision with root package name */
        public String f8333a;
        public String b;
        public String c;
        public String d;
        public Long e;
        public Long f;
        public Long g;
        public Long h;
        public Long i;
        public DeviceCountryType j;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public String f8334a;
            public String b;
            public String c;
            public String d;
            public Long e;
            public Long f;
            public Long g;
            public Long h;
            public Long i;
            public DeviceCountryType j;

            public StarryNetDevice a() {
                StarryNetDevice starryNetDevice = new StarryNetDevice();
                starryNetDevice.g(this.f8334a);
                starryNetDevice.j(this.b);
                starryNetDevice.h(this.c);
                starryNetDevice.b(this.d);
                starryNetDevice.i(this.e);
                starryNetDevice.k(this.f);
                starryNetDevice.d(this.g);
                starryNetDevice.c(this.h);
                starryNetDevice.f(this.i);
                starryNetDevice.e(this.j);
                return starryNetDevice;
            }

            public Builder b(String str) {
                this.d = str;
                return this;
            }

            public Builder c(Long l) {
                this.h = l;
                return this;
            }

            public Builder d(Long l) {
                this.g = l;
                return this;
            }

            public Builder e(DeviceCountryType deviceCountryType) {
                this.j = deviceCountryType;
                return this;
            }

            public Builder f(Long l) {
                this.i = l;
                return this;
            }

            public Builder g(String str) {
                this.f8334a = str;
                return this;
            }

            public Builder h(String str) {
                this.c = str;
                return this;
            }

            public Builder i(Long l) {
                this.e = l;
                return this;
            }

            public Builder j(String str) {
                this.b = str;
                return this;
            }

            public Builder k(Long l) {
                this.f = l;
                return this;
            }
        }

        public static StarryNetDevice a(ArrayList arrayList) {
            StarryNetDevice starryNetDevice = new StarryNetDevice();
            starryNetDevice.g((String) arrayList.get(0));
            starryNetDevice.j((String) arrayList.get(1));
            starryNetDevice.h((String) arrayList.get(2));
            starryNetDevice.b((String) arrayList.get(3));
            starryNetDevice.i((Long) arrayList.get(4));
            starryNetDevice.k((Long) arrayList.get(5));
            starryNetDevice.d((Long) arrayList.get(6));
            starryNetDevice.c((Long) arrayList.get(7));
            starryNetDevice.f((Long) arrayList.get(8));
            starryNetDevice.e((DeviceCountryType) arrayList.get(9));
            return starryNetDevice;
        }

        public void b(String str) {
            if (str != null) {
                this.d = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"address\" is null.");
        }

        public void c(Long l) {
            if (l != null) {
                this.h = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"bleStatus\" is null.");
        }

        public void d(Long l) {
            if (l != null) {
                this.g = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"boundStatus\" is null.");
        }

        public void e(DeviceCountryType deviceCountryType) {
            if (deviceCountryType != null) {
                this.j = deviceCountryType;
                return;
            }
            throw new IllegalStateException("Nonnull field \"countryType\" is null.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || StarryNetDevice.class != obj.getClass()) {
                return false;
            }
            StarryNetDevice starryNetDevice = (StarryNetDevice) obj;
            return this.f8333a.equals(starryNetDevice.f8333a) && this.b.equals(starryNetDevice.b) && this.c.equals(starryNetDevice.c) && this.d.equals(starryNetDevice.d) && this.e.equals(starryNetDevice.e) && this.f.equals(starryNetDevice.f) && this.g.equals(starryNetDevice.g) && this.h.equals(starryNetDevice.h) && this.i.equals(starryNetDevice.i) && this.j.equals(starryNetDevice.j);
        }

        public void f(Long l) {
            if (l != null) {
                this.i = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"deviceType\" is null.");
        }

        public void g(String str) {
            if (str != null) {
                this.f8333a = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"id\" is null.");
        }

        public void h(String str) {
            if (str != null) {
                this.c = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"name\" is null.");
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8333a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j});
        }

        public void i(Long l) {
            if (l != null) {
                this.e = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"port\" is null.");
        }

        public void j(String str) {
            if (str != null) {
                this.b = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"selfId\" is null.");
        }

        public void k(Long l) {
            if (l != null) {
                this.f = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"status\" is null.");
        }

        public ArrayList l() {
            ArrayList arrayList = new ArrayList(10);
            arrayList.add(this.f8333a);
            arrayList.add(this.b);
            arrayList.add(this.c);
            arrayList.add(this.d);
            arrayList.add(this.e);
            arrayList.add(this.f);
            arrayList.add(this.g);
            arrayList.add(this.h);
            arrayList.add(this.i);
            arrayList.add(this.j);
            return arrayList;
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
