package com.xjmz.myvu.flutter.pigeon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.r9.f1;
import com.honey.account.r9.g1;
import com.honey.account.r9.h1;
import com.honey.account.r9.i1;
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
import java.util.Objects;

public class AndroidPermissionApi {

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

    public interface NullableResult<T> {
    }

    public enum Permission {
        RECORD_AUDIO(0),
        ALBUM(1),
        CAMERA(2),
        LOCATION(3),
        BACKGROUND_LOCATION(4);
        
        final int index;

        private Permission(int i) {
            this.index = i;
        }
    }

    public interface PermissionApi {
        static void a(BinaryMessenger binaryMessenger, String str, PermissionApi permissionApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.PermissionApi.requestPermission" + str2, getCodec());
            if (permissionApi != null) {
                basicMessageChannel.setMessageHandler(new f1(permissionApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.PermissionApi.checkPermission" + str2, getCodec());
            if (permissionApi != null) {
                basicMessageChannel2.setMessageHandler(new g1(permissionApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.PermissionApi.checkSportPermission" + str2, getCodec());
            if (permissionApi != null) {
                basicMessageChannel3.setMessageHandler(new h1(permissionApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.PermissionApi.requestBluetoothState" + str2, getCodec());
            if (permissionApi != null) {
                basicMessageChannel4.setMessageHandler(new i1(permissionApi));
            } else {
                basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static void b(BinaryMessenger binaryMessenger, PermissionApi permissionApi) {
            a(binaryMessenger, "", permissionApi);
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8321a;
        }

        static /* synthetic */ void j(PermissionApi permissionApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            permissionApi.c(new Result<PermissionResult>() {
                /* renamed from: a */
                public void success(PermissionResult permissionResult) {
                    arrayList.add(0, permissionResult);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void k(PermissionApi permissionApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            permissionApi.i(new Result<PermissionResult>() {
                /* renamed from: a */
                public void success(PermissionResult permissionResult) {
                    arrayList.add(0, permissionResult);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void l(PermissionApi permissionApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            permissionApi.d((Permission) ((ArrayList) obj).get(0), new Result<PermissionResult>() {
                /* renamed from: a */
                public void success(PermissionResult permissionResult) {
                    arrayList.add(0, permissionResult);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void m(PermissionApi permissionApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            permissionApi.f((Permission) ((ArrayList) obj).get(0), new Result<PermissionResult>() {
                /* renamed from: a */
                public void success(PermissionResult permissionResult) {
                    arrayList.add(0, permissionResult);
                    reply.reply(arrayList);
                }
            });
        }

        void c(Result result);

        void d(Permission permission, Result result);

        void f(Permission permission, Result result);

        void i(Result result);
    }

    public static final class PermissionResult {

        /* renamed from: a  reason: collision with root package name */
        public Boolean f8319a;
        public String b;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public Boolean f8320a;
            public String b;

            public PermissionResult a() {
                PermissionResult permissionResult = new PermissionResult();
                permissionResult.c(this.f8320a);
                permissionResult.b(this.b);
                return permissionResult;
            }

            public Builder b(String str) {
                this.b = str;
                return this;
            }

            public Builder c(Boolean bool) {
                this.f8320a = bool;
                return this;
            }
        }

        public static PermissionResult a(ArrayList arrayList) {
            PermissionResult permissionResult = new PermissionResult();
            permissionResult.c((Boolean) arrayList.get(0));
            permissionResult.b((String) arrayList.get(1));
            return permissionResult;
        }

        public void b(String str) {
            if (str != null) {
                this.b = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"errorMsg\" is null.");
        }

        public void c(Boolean bool) {
            if (bool != null) {
                this.f8319a = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"success\" is null.");
        }

        public ArrayList d() {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(this.f8319a);
            arrayList.add(this.b);
            return arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || PermissionResult.class != obj.getClass()) {
                return false;
            }
            PermissionResult permissionResult = (PermissionResult) obj;
            return this.f8319a.equals(permissionResult.f8319a) && this.b.equals(permissionResult.b);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8319a, this.b});
        }
    }

    public static class PigeonCodec extends StandardMessageCodec {

        /* renamed from: a  reason: collision with root package name */
        public static final PigeonCodec f8321a = new PigeonCodec();

        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            if (b != -127) {
                return b != -126 ? super.readValueOfType(b, byteBuffer) : PermissionResult.a((ArrayList) readValue(byteBuffer));
            }
            Object readValue = readValue(byteBuffer);
            if (readValue == null) {
                return null;
            }
            return Permission.values()[((Long) readValue).intValue()];
        }

        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof Permission) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, obj == null ? null : Integer.valueOf(((Permission) obj).index));
            } else if (obj instanceof PermissionResult) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, ((PermissionResult) obj).d());
            } else {
                super.writeValue(byteArrayOutputStream, obj);
            }
        }
    }

    public interface Result<T> {
        void success(Object obj);
    }

    public interface VoidResult {
    }
}
