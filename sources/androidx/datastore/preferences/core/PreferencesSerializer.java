package androidx.datastore.preferences.core;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import androidx.datastore.preferences.PreferencesMapCompat;
import androidx.datastore.preferences.PreferencesProto;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import com.honey.account.constant.AccountConstantKt;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u00148\u0006XD¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Landroidx/datastore/preferences/core/PreferencesSerializer;", "Landroidx/datastore/core/Serializer;", "Landroidx/datastore/preferences/core/Preferences;", "<init>", "()V", "Ljava/io/InputStream;", "input", "b", "(Ljava/io/InputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "Ljava/io/OutputStream;", "output", "", "g", "(Landroidx/datastore/preferences/core/Preferences;Ljava/io/OutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "value", "Landroidx/datastore/preferences/PreferencesProto$Value;", "f", "(Ljava/lang/Object;)Landroidx/datastore/preferences/PreferencesProto$Value;", "", "name", "Landroidx/datastore/preferences/core/MutablePreferences;", "mutablePreferences", "c", "(Ljava/lang/String;Landroidx/datastore/preferences/PreferencesProto$Value;Landroidx/datastore/preferences/core/MutablePreferences;)V", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "fileExtension", "d", "()Landroidx/datastore/preferences/core/Preferences;", "defaultValue", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
public final class PreferencesSerializer implements Serializer<Preferences> {

    /* renamed from: a  reason: collision with root package name */
    public static final PreferencesSerializer f1042a = new PreferencesSerializer();
    public static final String b = "preferences_pb";

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PreferencesProto.Value.ValueCase.values().length];
            iArr[PreferencesProto.Value.ValueCase.BOOLEAN.ordinal()] = 1;
            iArr[PreferencesProto.Value.ValueCase.FLOAT.ordinal()] = 2;
            iArr[PreferencesProto.Value.ValueCase.DOUBLE.ordinal()] = 3;
            iArr[PreferencesProto.Value.ValueCase.INTEGER.ordinal()] = 4;
            iArr[PreferencesProto.Value.ValueCase.LONG.ordinal()] = 5;
            iArr[PreferencesProto.Value.ValueCase.STRING.ordinal()] = 6;
            iArr[PreferencesProto.Value.ValueCase.STRING_SET.ordinal()] = 7;
            iArr[PreferencesProto.Value.ValueCase.VALUE_NOT_SET.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Object b(InputStream inputStream, Continuation continuation) {
        PreferencesProto.PreferenceMap a2 = PreferencesMapCompat.f1033a.a(inputStream);
        MutablePreferences b2 = PreferencesFactory.b(new Preferences.Pair[0]);
        Map F = a2.F();
        Intrinsics.checkNotNullExpressionValue(F, "preferencesProto.preferencesMap");
        for (Map.Entry entry : F.entrySet()) {
            String str = (String) entry.getKey();
            PreferencesProto.Value value = (PreferencesProto.Value) entry.getValue();
            PreferencesSerializer preferencesSerializer = f1042a;
            Intrinsics.checkNotNullExpressionValue(str, "name");
            Intrinsics.checkNotNullExpressionValue(value, AccountConstantKt.RESPONSE_VALUE);
            preferencesSerializer.c(str, value, b2);
        }
        return b2.e();
    }

    public final void c(String str, PreferencesProto.Value value, MutablePreferences mutablePreferences) {
        PreferencesProto.Value.ValueCase S = value.S();
        switch (S == null ? -1 : WhenMappings.$EnumSwitchMapping$0[S.ordinal()]) {
            case -1:
                throw new CorruptionException("Value case is null.", (Throwable) null, 2, (DefaultConstructorMarker) null);
            case 1:
                mutablePreferences.k(PreferencesKeys.a(str), Boolean.valueOf(value.K()));
                return;
            case 2:
                mutablePreferences.k(PreferencesKeys.c(str), Float.valueOf(value.N()));
                return;
            case 3:
                mutablePreferences.k(PreferencesKeys.b(str), Double.valueOf(value.M()));
                return;
            case 4:
                mutablePreferences.k(PreferencesKeys.d(str), Integer.valueOf(value.O()));
                return;
            case 5:
                mutablePreferences.k(PreferencesKeys.e(str), Long.valueOf(value.P()));
                return;
            case 6:
                Preferences.Key f = PreferencesKeys.f(str);
                String Q = value.Q();
                Intrinsics.checkNotNullExpressionValue(Q, "value.string");
                mutablePreferences.k(f, Q);
                return;
            case 7:
                Preferences.Key g = PreferencesKeys.g(str);
                List H = value.R().H();
                Intrinsics.checkNotNullExpressionValue(H, "value.stringSet.stringsList");
                mutablePreferences.k(g, CollectionsKt.toSet(H));
                return;
            case 8:
                throw new CorruptionException("Value not set.", (Throwable) null, 2, (DefaultConstructorMarker) null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: d */
    public Preferences getDefaultValue() {
        return PreferencesFactory.a();
    }

    public final String e() {
        return b;
    }

    public final PreferencesProto.Value f(Object obj) {
        if (obj instanceof Boolean) {
            GeneratedMessageLite n = PreferencesProto.Value.T().y(((Boolean) obj).booleanValue()).build();
            Intrinsics.checkNotNullExpressionValue(n, "newBuilder().setBoolean(value).build()");
            return (PreferencesProto.Value) n;
        } else if (obj instanceof Float) {
            GeneratedMessageLite n2 = PreferencesProto.Value.T().A(((Number) obj).floatValue()).build();
            Intrinsics.checkNotNullExpressionValue(n2, "newBuilder().setFloat(value).build()");
            return (PreferencesProto.Value) n2;
        } else if (obj instanceof Double) {
            GeneratedMessageLite n3 = PreferencesProto.Value.T().z(((Number) obj).doubleValue()).build();
            Intrinsics.checkNotNullExpressionValue(n3, "newBuilder().setDouble(value).build()");
            return (PreferencesProto.Value) n3;
        } else if (obj instanceof Integer) {
            GeneratedMessageLite n4 = PreferencesProto.Value.T().B(((Number) obj).intValue()).build();
            Intrinsics.checkNotNullExpressionValue(n4, "newBuilder().setInteger(value).build()");
            return (PreferencesProto.Value) n4;
        } else if (obj instanceof Long) {
            GeneratedMessageLite n5 = PreferencesProto.Value.T().C(((Number) obj).longValue()).build();
            Intrinsics.checkNotNullExpressionValue(n5, "newBuilder().setLong(value).build()");
            return (PreferencesProto.Value) n5;
        } else if (obj instanceof String) {
            GeneratedMessageLite n6 = PreferencesProto.Value.T().D((String) obj).build();
            Intrinsics.checkNotNullExpressionValue(n6, "newBuilder().setString(value).build()");
            return (PreferencesProto.Value) n6;
        } else if (obj instanceof Set) {
            GeneratedMessageLite n7 = PreferencesProto.Value.T().E(PreferencesProto.StringSet.I().y((Set) obj)).build();
            Intrinsics.checkNotNullExpressionValue(n7, "newBuilder().setStringSet(\n                    StringSet.newBuilder().addAllStrings(value as Set<String>)\n                ).build()");
            return (PreferencesProto.Value) n7;
        } else {
            throw new IllegalStateException(Intrinsics.stringPlus("PreferencesSerializer does not support type: ", obj.getClass().getName()));
        }
    }

    /* renamed from: g */
    public Object a(Preferences preferences, OutputStream outputStream, Continuation continuation) {
        Map a2 = preferences.a();
        PreferencesProto.PreferenceMap.Builder I = PreferencesProto.PreferenceMap.I();
        for (Map.Entry entry : a2.entrySet()) {
            I.y(((Preferences.Key) entry.getKey()).a(), f(entry.getValue()));
        }
        ((PreferencesProto.PreferenceMap) I.build()).i(outputStream);
        return Unit.INSTANCE;
    }
}
