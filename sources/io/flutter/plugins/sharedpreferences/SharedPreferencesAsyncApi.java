package io.flutter.plugins.sharedpreferences;

import com.honey.account.fb.i;
import com.honey.account.fb.j;
import com.honey.account.fb.k;
import com.honey.account.fb.l;
import com.honey.account.fb.m;
import com.honey.account.fb.n;
import com.honey.account.fb.o;
import com.honey.account.fb.p;
import com.honey.account.fb.q;
import com.honey.account.fb.r;
import com.honey.account.fb.s;
import com.honey.account.fb.t;
import com.honey.account.fb.u;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\bf\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eJ \u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J,\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\n2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u001f\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\u0014J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\u0018\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\u001b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\u001c\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J&\u0010\u001d\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\u001f"}, d2 = {"Lio/flutter/plugins/sharedpreferences/SharedPreferencesAsyncApi;", "", "clear", "", "allowList", "", "", "options", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;", "getAll", "", "getBool", "", "key", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/lang/Boolean;", "getDouble", "", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/lang/Double;", "getInt", "", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/lang/Long;", "getKeys", "getString", "getStringList", "setBool", "value", "setDouble", "setInt", "setString", "setStringList", "Companion", "shared_preferences_android_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SharedPreferencesAsyncApi {
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR#\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lio/flutter/plugins/sharedpreferences/SharedPreferencesAsyncApi$Companion;", "", "()V", "codec", "Lio/flutter/plugin/common/MessageCodec;", "getCodec", "()Lio/flutter/plugin/common/MessageCodec;", "codec$delegate", "Lkotlin/Lazy;", "setUp", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "api", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesAsyncApi;", "shared_preferences_android_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        @NotNull
        private static final Lazy<SharedPreferencesAsyncApiCodec> codec$delegate = LazyKt.lazy(SharedPreferencesAsyncApi$Companion$codec$2.INSTANCE);

        private Companion() {
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-1$lambda-0  reason: not valid java name */
        public static final void m1700setUp$lambda1$lambda0(SharedPreferencesAsyncApi sharedPreferencesAsyncApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list2 = (List) obj;
            Object obj2 = list2.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list2.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue = ((Boolean) obj3).booleanValue();
            Object obj4 = list2.get(2);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                sharedPreferencesAsyncApi.setBool(str, booleanValue, (SharedPreferencesPigeonOptions) obj4);
                list = CollectionsKt.listOf(null);
            } catch (Throwable th) {
                list = MessagesAsync_gKt.wrapError(th);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-10$lambda-9  reason: not valid java name */
        public static final void m1701setUp$lambda10$lambda9(SharedPreferencesAsyncApi sharedPreferencesAsyncApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list2 = (List) obj;
            Object obj2 = list2.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list2.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            List list3 = (List) obj3;
            Object obj4 = list2.get(2);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                sharedPreferencesAsyncApi.setStringList(str, list3, (SharedPreferencesPigeonOptions) obj4);
                list = CollectionsKt.listOf(null);
            } catch (Throwable th) {
                list = MessagesAsync_gKt.wrapError(th);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-12$lambda-11  reason: not valid java name */
        public static final void m1702setUp$lambda12$lambda11(SharedPreferencesAsyncApi sharedPreferencesAsyncApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list2 = (List) obj;
            Object obj2 = list2.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list2.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                list = CollectionsKt.listOf(sharedPreferencesAsyncApi.getString(str, (SharedPreferencesPigeonOptions) obj3));
            } catch (Throwable th) {
                list = MessagesAsync_gKt.wrapError(th);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-14$lambda-13  reason: not valid java name */
        public static final void m1703setUp$lambda14$lambda13(SharedPreferencesAsyncApi sharedPreferencesAsyncApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list2 = (List) obj;
            Object obj2 = list2.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list2.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                list = CollectionsKt.listOf(sharedPreferencesAsyncApi.getBool(str, (SharedPreferencesPigeonOptions) obj3));
            } catch (Throwable th) {
                list = MessagesAsync_gKt.wrapError(th);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-16$lambda-15  reason: not valid java name */
        public static final void m1704setUp$lambda16$lambda15(SharedPreferencesAsyncApi sharedPreferencesAsyncApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list2 = (List) obj;
            Object obj2 = list2.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list2.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                list = CollectionsKt.listOf(sharedPreferencesAsyncApi.getDouble(str, (SharedPreferencesPigeonOptions) obj3));
            } catch (Throwable th) {
                list = MessagesAsync_gKt.wrapError(th);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-18$lambda-17  reason: not valid java name */
        public static final void m1705setUp$lambda18$lambda17(SharedPreferencesAsyncApi sharedPreferencesAsyncApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list2 = (List) obj;
            Object obj2 = list2.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list2.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                list = CollectionsKt.listOf(sharedPreferencesAsyncApi.getInt(str, (SharedPreferencesPigeonOptions) obj3));
            } catch (Throwable th) {
                list = MessagesAsync_gKt.wrapError(th);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-20$lambda-19  reason: not valid java name */
        public static final void m1706setUp$lambda20$lambda19(SharedPreferencesAsyncApi sharedPreferencesAsyncApi, Object obj, BasicMessageChannel.Reply reply) {
            List<T> list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list2 = (List) obj;
            Object obj2 = list2.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list2.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                list = CollectionsKt.listOf(sharedPreferencesAsyncApi.getStringList(str, (SharedPreferencesPigeonOptions) obj3));
            } catch (Throwable th) {
                list = MessagesAsync_gKt.wrapError(th);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-22$lambda-21  reason: not valid java name */
        public static final void m1707setUp$lambda22$lambda21(SharedPreferencesAsyncApi sharedPreferencesAsyncApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list2 = (List) obj;
            List list3 = (List) list2.get(0);
            Object obj2 = list2.get(1);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                sharedPreferencesAsyncApi.clear(list3, (SharedPreferencesPigeonOptions) obj2);
                list = CollectionsKt.listOf(null);
            } catch (Throwable th) {
                list = MessagesAsync_gKt.wrapError(th);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-24$lambda-23  reason: not valid java name */
        public static final void m1708setUp$lambda24$lambda23(SharedPreferencesAsyncApi sharedPreferencesAsyncApi, Object obj, BasicMessageChannel.Reply reply) {
            List<T> list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list2 = (List) obj;
            List list3 = (List) list2.get(0);
            Object obj2 = list2.get(1);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                list = CollectionsKt.listOf(sharedPreferencesAsyncApi.getAll(list3, (SharedPreferencesPigeonOptions) obj2));
            } catch (Throwable th) {
                list = MessagesAsync_gKt.wrapError(th);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-26$lambda-25  reason: not valid java name */
        public static final void m1709setUp$lambda26$lambda25(SharedPreferencesAsyncApi sharedPreferencesAsyncApi, Object obj, BasicMessageChannel.Reply reply) {
            List<T> list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list2 = (List) obj;
            List list3 = (List) list2.get(0);
            Object obj2 = list2.get(1);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                list = CollectionsKt.listOf(sharedPreferencesAsyncApi.getKeys(list3, (SharedPreferencesPigeonOptions) obj2));
            } catch (Throwable th) {
                list = MessagesAsync_gKt.wrapError(th);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-3$lambda-2  reason: not valid java name */
        public static final void m1710setUp$lambda3$lambda2(SharedPreferencesAsyncApi sharedPreferencesAsyncApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list2 = (List) obj;
            Object obj2 = list2.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list2.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            String str2 = (String) obj3;
            Object obj4 = list2.get(2);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                sharedPreferencesAsyncApi.setString(str, str2, (SharedPreferencesPigeonOptions) obj4);
                list = CollectionsKt.listOf(null);
            } catch (Throwable th) {
                list = MessagesAsync_gKt.wrapError(th);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-6$lambda-5  reason: not valid java name */
        public static final void m1711setUp$lambda6$lambda5(SharedPreferencesAsyncApi sharedPreferencesAsyncApi, Object obj, BasicMessageChannel.Reply reply) {
            long j;
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list2 = (List) obj;
            Object obj2 = list2.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list2.get(1);
            if (obj3 instanceof Integer) {
                j = (long) ((Number) obj3).intValue();
            } else {
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Long");
                j = ((Long) obj3).longValue();
            }
            Object obj4 = list2.get(2);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                sharedPreferencesAsyncApi.setInt(str, j, (SharedPreferencesPigeonOptions) obj4);
                list = CollectionsKt.listOf(null);
            } catch (Throwable th) {
                list = MessagesAsync_gKt.wrapError(th);
            }
            reply.reply(list);
        }

        /* access modifiers changed from: private */
        /* renamed from: setUp$lambda-8$lambda-7  reason: not valid java name */
        public static final void m1712setUp$lambda8$lambda7(SharedPreferencesAsyncApi sharedPreferencesAsyncApi, Object obj, BasicMessageChannel.Reply reply) {
            List list;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list2 = (List) obj;
            Object obj2 = list2.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list2.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Double");
            double doubleValue = ((Double) obj3).doubleValue();
            Object obj4 = list2.get(2);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                sharedPreferencesAsyncApi.setDouble(str, doubleValue, (SharedPreferencesPigeonOptions) obj4);
                list = CollectionsKt.listOf(null);
            } catch (Throwable th) {
                list = MessagesAsync_gKt.wrapError(th);
            }
            reply.reply(list);
        }

        @NotNull
        public final MessageCodec<Object> getCodec() {
            return codec$delegate.getValue();
        }

        public final void setUp(@NotNull BinaryMessenger binaryMessenger, @Nullable SharedPreferencesAsyncApi sharedPreferencesAsyncApi) {
            Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setBool", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (sharedPreferencesAsyncApi != null) {
                basicMessageChannel.setMessageHandler(new i(sharedPreferencesAsyncApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setString", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (sharedPreferencesAsyncApi != null) {
                basicMessageChannel2.setMessageHandler(new p(sharedPreferencesAsyncApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setInt", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (sharedPreferencesAsyncApi != null) {
                basicMessageChannel3.setMessageHandler(new q(sharedPreferencesAsyncApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setDouble", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (sharedPreferencesAsyncApi != null) {
                basicMessageChannel4.setMessageHandler(new r(sharedPreferencesAsyncApi));
            } else {
                basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setStringList", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (sharedPreferencesAsyncApi != null) {
                basicMessageChannel5.setMessageHandler(new s(sharedPreferencesAsyncApi));
            } else {
                basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getString", getCodec());
            if (sharedPreferencesAsyncApi != null) {
                basicMessageChannel6.setMessageHandler(new t(sharedPreferencesAsyncApi));
            } else {
                basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getBool", getCodec());
            if (sharedPreferencesAsyncApi != null) {
                basicMessageChannel7.setMessageHandler(new u(sharedPreferencesAsyncApi));
            } else {
                basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getDouble", getCodec());
            if (sharedPreferencesAsyncApi != null) {
                basicMessageChannel8.setMessageHandler(new j(sharedPreferencesAsyncApi));
            } else {
                basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getInt", getCodec());
            if (sharedPreferencesAsyncApi != null) {
                basicMessageChannel9.setMessageHandler(new k(sharedPreferencesAsyncApi));
            } else {
                basicMessageChannel9.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getStringList", getCodec());
            if (sharedPreferencesAsyncApi != null) {
                basicMessageChannel10.setMessageHandler(new l(sharedPreferencesAsyncApi));
            } else {
                basicMessageChannel10.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.clear", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (sharedPreferencesAsyncApi != null) {
                basicMessageChannel11.setMessageHandler(new m(sharedPreferencesAsyncApi));
            } else {
                basicMessageChannel11.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getAll", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (sharedPreferencesAsyncApi != null) {
                basicMessageChannel12.setMessageHandler(new n(sharedPreferencesAsyncApi));
            } else {
                basicMessageChannel12.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel13 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getKeys", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (sharedPreferencesAsyncApi != null) {
                basicMessageChannel13.setMessageHandler(new o(sharedPreferencesAsyncApi));
            } else {
                basicMessageChannel13.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }
    }

    void clear(@Nullable List<String> list, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions);

    @NotNull
    Map<String, Object> getAll(@Nullable List<String> list, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions);

    @Nullable
    Boolean getBool(@NotNull String str, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions);

    @Nullable
    Double getDouble(@NotNull String str, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions);

    @Nullable
    Long getInt(@NotNull String str, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions);

    @NotNull
    List<String> getKeys(@Nullable List<String> list, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions);

    @Nullable
    String getString(@NotNull String str, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions);

    @Nullable
    List<String> getStringList(@NotNull String str, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions);

    void setBool(@NotNull String str, boolean z, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions);

    void setDouble(@NotNull String str, double d, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions);

    void setInt(@NotNull String str, long j, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions);

    void setString(@NotNull String str, @NotNull String str2, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions);

    void setStringList(@NotNull String str, @NotNull List<String> list, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions);
}
