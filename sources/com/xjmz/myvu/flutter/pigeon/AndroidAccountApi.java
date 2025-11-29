package com.xjmz.myvu.flutter.pigeon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.r9.a;
import com.honey.account.r9.b;
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

public class AndroidAccountApi {

    public static final class Account {

        /* renamed from: a  reason: collision with root package name */
        public String f8248a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public String f8249a;
            public String b;
            public String c;
            public String d;
            public String e;
            public String f;

            public Account a() {
                Account account = new Account();
                account.c(this.f8249a);
                account.e(this.b);
                account.g(this.c);
                account.b(this.d);
                account.f(this.e);
                account.d(this.f);
                return account;
            }

            public Builder b(String str) {
                this.d = str;
                return this;
            }

            public Builder c(String str) {
                this.f8249a = str;
                return this;
            }

            public Builder d(String str) {
                this.f = str;
                return this;
            }

            public Builder e(String str) {
                this.b = str;
                return this;
            }

            public Builder f(String str) {
                this.e = str;
                return this;
            }

            public Builder g(String str) {
                this.c = str;
                return this;
            }
        }

        public static Account a(ArrayList arrayList) {
            Account account = new Account();
            account.c((String) arrayList.get(0));
            account.e((String) arrayList.get(1));
            account.g((String) arrayList.get(2));
            account.b((String) arrayList.get(3));
            account.f((String) arrayList.get(4));
            account.d((String) arrayList.get(5));
            return account;
        }

        public void b(String str) {
            if (str != null) {
                this.d = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"icon\" is null.");
        }

        public void c(String str) {
            if (str != null) {
                this.f8248a = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"id\" is null.");
        }

        public void d(String str) {
            if (str != null) {
                this.f = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"mzToken\" is null.");
        }

        public void e(String str) {
            if (str != null) {
                this.b = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"mzUid\" is null.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Account.class != obj.getClass()) {
                return false;
            }
            Account account = (Account) obj;
            return this.f8248a.equals(account.f8248a) && this.b.equals(account.b) && this.c.equals(account.c) && this.d.equals(account.d) && this.e.equals(account.e) && this.f.equals(account.f);
        }

        public void f(String str) {
            if (str != null) {
                this.e = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"phone\" is null.");
        }

        public void g(String str) {
            if (str != null) {
                this.c = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"username\" is null.");
        }

        public ArrayList h() {
            ArrayList arrayList = new ArrayList(6);
            arrayList.add(this.f8248a);
            arrayList.add(this.b);
            arrayList.add(this.c);
            arrayList.add(this.d);
            arrayList.add(this.e);
            arrayList.add(this.f);
            return arrayList;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f8248a, this.b, this.c, this.d, this.e, this.f});
        }
    }

    public interface AccountApi {
        static void b(BinaryMessenger binaryMessenger, AccountApi accountApi) {
            d(binaryMessenger, "", accountApi);
        }

        static /* synthetic */ void c(AccountApi accountApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            accountApi.a(new NullableResult<Account>() {
                /* renamed from: a */
                public void success(Account account) {
                    arrayList.add(0, account);
                    reply.reply(arrayList);
                }
            });
        }

        static void d(BinaryMessenger binaryMessenger, String str, AccountApi accountApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.myvu_flutter.AccountApi.getAccountInfo" + str2, getCodec());
            if (accountApi != null) {
                basicMessageChannel.setMessageHandler(new a(accountApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        static MessageCodec getCodec() {
            return PigeonCodec.f8252a;
        }

        void a(NullableResult nullableResult);
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface CanIgnoreReturnValue {
    }

    public static class FlutterAccountApi {

        /* renamed from: a  reason: collision with root package name */
        public final BinaryMessenger f8251a;
        public final String b;

        public FlutterAccountApi(BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        public static MessageCodec b() {
            return PigeonCodec.f8252a;
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
                voidResult.error(AndroidAccountApi.a(str));
            }
        }

        public void d(Account account, VoidResult voidResult) {
            String str = "dev.flutter.pigeon.myvu_flutter.FlutterAccountApi.notifyAccountChange" + this.b;
            new BasicMessageChannel(this.f8251a, str, b()).send(new ArrayList(Collections.singletonList(account)), new b(voidResult, str));
        }

        public FlutterAccountApi(BinaryMessenger binaryMessenger, String str) {
            String str2;
            this.f8251a = binaryMessenger;
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
        void success(Object obj);
    }

    public static class PigeonCodec extends StandardMessageCodec {

        /* renamed from: a  reason: collision with root package name */
        public static final PigeonCodec f8252a = new PigeonCodec();

        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            return b != -127 ? super.readValueOfType(b, byteBuffer) : Account.a((ArrayList) readValue(byteBuffer));
        }

        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof Account) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((Account) obj).h());
                return;
            }
            super.writeValue(byteArrayOutputStream, obj);
        }
    }

    public interface Result<T> {
    }

    public interface VoidResult {
        void error(Throwable th);

        void success();
    }

    public static FlutterError a(String str) {
        return new FlutterError("channel-error", "Unable to establish connection on channel: " + str + ".", "");
    }
}
