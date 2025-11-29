package com.xjmz.myvu.flutter.pigeon;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.posclient.analytics.TrackerEvent;
import com.honey.account.r9.d0;
import com.honey.account.r9.e0;
import com.honey.account.r9.f0;
import com.honey.account.r9.g0;
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
import java.util.List;
import java.util.Objects;

public class AndroidBindingDeviceApi {

    public interface BindingDeviceApi {
        static void a(BinaryMessenger binaryMessenger, BindingDeviceApi bindingDeviceApi) {
            e(binaryMessenger, "", bindingDeviceApi);
        }

        static void e(BinaryMessenger binaryMessenger, String str, BindingDeviceApi bindingDeviceApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.BindingDeviceApi.getBindingDevices" + str2, getCodec());
            if (bindingDeviceApi != null) {
                basicMessageChannel.setMessageHandler(new d0(bindingDeviceApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.BindingDeviceApi.checkStateAndPermission" + str2, getCodec());
            if (bindingDeviceApi != null) {
                basicMessageChannel2.setMessageHandler(new e0(bindingDeviceApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.BindingDeviceApi.checkBluetoothStateAndNecessaryPermission" + str2, getCodec());
            if (bindingDeviceApi != null) {
                basicMessageChannel3.setMessageHandler(new f0(bindingDeviceApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8288a;
        }

        static /* synthetic */ void h(BindingDeviceApi bindingDeviceApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            bindingDeviceApi.c(new Result<List<BindingDeviceItem>>() {
                /* renamed from: a */
                public void success(List list) {
                    arrayList.add(0, list);
                    reply.reply(arrayList);
                }

                public void error(Throwable th) {
                    reply.reply(AndroidBindingDeviceApi.b(th));
                }
            });
        }

        static /* synthetic */ void i(BindingDeviceApi bindingDeviceApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            bindingDeviceApi.k((BindingDeviceType) ((ArrayList) obj).get(0), new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }

                public void error(Throwable th) {
                    reply.reply(AndroidBindingDeviceApi.b(th));
                }
            });
        }

        static /* synthetic */ void j(BindingDeviceApi bindingDeviceApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            bindingDeviceApi.d(new Result<Boolean>() {
                /* renamed from: a */
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }

                public void error(Throwable th) {
                    reply.reply(AndroidBindingDeviceApi.b(th));
                }
            });
        }

        void c(Result result);

        void d(Result result);

        void k(BindingDeviceType bindingDeviceType, Result result);
    }

    public static final class BindingDeviceItem {

        /* renamed from: a  reason: collision with root package name */
        public BindingDeviceType f8285a;
        public BindingDeviceStatus b;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public BindingDeviceType f8286a;
            public BindingDeviceStatus b;

            public BindingDeviceItem a() {
                BindingDeviceItem bindingDeviceItem = new BindingDeviceItem();
                bindingDeviceItem.c(this.f8286a);
                bindingDeviceItem.b(this.b);
                return bindingDeviceItem;
            }

            public Builder b(BindingDeviceStatus bindingDeviceStatus) {
                this.b = bindingDeviceStatus;
                return this;
            }

            public Builder c(BindingDeviceType bindingDeviceType) {
                this.f8286a = bindingDeviceType;
                return this;
            }
        }

        public static BindingDeviceItem a(ArrayList arrayList) {
            BindingDeviceItem bindingDeviceItem = new BindingDeviceItem();
            bindingDeviceItem.c((BindingDeviceType) arrayList.get(0));
            bindingDeviceItem.b((BindingDeviceStatus) arrayList.get(1));
            return bindingDeviceItem;
        }

        public void b(BindingDeviceStatus bindingDeviceStatus) {
            if (bindingDeviceStatus != null) {
                this.b = bindingDeviceStatus;
                return;
            }
            throw new IllegalStateException("Nonnull field \"status\" is null.");
        }

        public void c(BindingDeviceType bindingDeviceType) {
            if (bindingDeviceType != null) {
                this.f8285a = bindingDeviceType;
                return;
            }
            throw new IllegalStateException("Nonnull field \"type\" is null.");
        }

        public ArrayList d() {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(this.f8285a);
            arrayList.add(this.b);
            return arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || BindingDeviceItem.class != obj.getClass()) {
                return false;
            }
            BindingDeviceItem bindingDeviceItem = (BindingDeviceItem) obj;
            return this.f8285a.equals(bindingDeviceItem.f8285a) && this.b.equals(bindingDeviceItem.b);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8285a, this.b});
        }
    }

    public enum BindingDeviceStatus {
        NONE(0),
        NOT_BOUND(1),
        BOUND(2);
        
        final int index;

        private BindingDeviceStatus(int i) {
            this.index = i;
        }
    }

    public enum BindingDeviceType {
        MYVU_GLASS(0),
        VIEW_GLASS(1),
        RING2(2),
        RING1(3);
        
        final int index;

        private BindingDeviceType(int i) {
            this.index = i;
        }
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface CanIgnoreReturnValue {
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

    public static class FlutterRing2ConnectApi {

        /* renamed from: a  reason: collision with root package name */
        public final BinaryMessenger f8287a;
        public final String b;

        public FlutterRing2ConnectApi(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public static MessageCodec b() {
            return PigeonCodec.f8288a;
        }

        public static /* synthetic */ void d(Result result, String str, Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 1) {
                    result.error(new FlutterError((String) list.get(0), (String) list.get(1), (String) list.get(2)));
                } else if (list.get(0) == null) {
                    result.error(new FlutterError("null-error", "Flutter api returned null value for non-null return value.", ""));
                } else {
                    result.success((Ring2DeviceInfo) list.get(0));
                }
            } else {
                result.error(AndroidBindingDeviceApi.a(str));
            }
        }

        public void c(Result result) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterRing2ConnectApi.getRing2DeviceInfo" + this.b;
            new BasicMessageChannel(this.f8287a, str, b()).send(null, new g0(result, str));
        }

        public FlutterRing2ConnectApi(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.f8287a = binaryMessenger;
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
        public static final PigeonCodec f8288a = new PigeonCodec();

        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            switch (b) {
                case -127:
                    return BindingDeviceItem.a((ArrayList) readValue(byteBuffer));
                case -126:
                    return Ring2DeviceInfo.a((ArrayList) readValue(byteBuffer));
                case -125:
                    Object readValue = readValue(byteBuffer);
                    if (readValue == null) {
                        return null;
                    }
                    return BindingDeviceType.values()[((Integer) readValue).intValue()];
                case -124:
                    Object readValue2 = readValue(byteBuffer);
                    if (readValue2 == null) {
                        return null;
                    }
                    return BindingDeviceStatus.values()[((Integer) readValue2).intValue()];
                default:
                    return super.readValueOfType(b, byteBuffer);
            }
        }

        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof BindingDeviceItem) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((BindingDeviceItem) obj).d());
            } else if (obj instanceof Ring2DeviceInfo) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, ((Ring2DeviceInfo) obj).h());
            } else {
                Integer num = null;
                if (obj instanceof BindingDeviceType) {
                    byteArrayOutputStream.write(TrackerEvent.PositioningOfflineOutdoor);
                    if (obj != null) {
                        num = Integer.valueOf(((BindingDeviceType) obj).index);
                    }
                    writeValue(byteArrayOutputStream, num);
                } else if (obj instanceof BindingDeviceStatus) {
                    byteArrayOutputStream.write(132);
                    if (obj != null) {
                        num = Integer.valueOf(((BindingDeviceStatus) obj).index);
                    }
                    writeValue(byteArrayOutputStream, num);
                } else {
                    super.writeValue(byteArrayOutputStream, obj);
                }
            }
        }
    }

    public interface Result<T> {
        void error(Throwable th);

        void success(Object obj);
    }

    public static final class Ring2DeviceInfo {

        /* renamed from: a  reason: collision with root package name */
        public String f8289a;
        public String b;
        public String c;

        public static final class Builder {
        }

        public static Ring2DeviceInfo a(ArrayList arrayList) {
            Ring2DeviceInfo ring2DeviceInfo = new Ring2DeviceInfo();
            ring2DeviceInfo.f((String) arrayList.get(0));
            ring2DeviceInfo.e((String) arrayList.get(1));
            ring2DeviceInfo.g((String) arrayList.get(2));
            return ring2DeviceInfo;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.f8289a;
        }

        public String d() {
            return this.c;
        }

        public void e(String str) {
            if (str != null) {
                this.b = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"model\" is null.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Ring2DeviceInfo.class != obj.getClass()) {
                return false;
            }
            Ring2DeviceInfo ring2DeviceInfo = (Ring2DeviceInfo) obj;
            return this.f8289a.equals(ring2DeviceInfo.f8289a) && this.b.equals(ring2DeviceInfo.b) && this.c.equals(ring2DeviceInfo.c);
        }

        public void f(String str) {
            if (str != null) {
                this.f8289a = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"sn\" is null.");
        }

        public void g(String str) {
            if (str != null) {
                this.c = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"version\" is null.");
        }

        public ArrayList h() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f8289a);
            arrayList.add(this.b);
            arrayList.add(this.c);
            return arrayList;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8289a, this.b, this.c});
        }
    }

    public interface VoidResult {
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
