package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.relay.api.IntentKey;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u00019B\u000f\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J!\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J,\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\u00152\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001f\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0019J\u001f\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u001fJ&\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J-\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\u00152\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u001a\u0010#\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010$\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001f\u0010%\u001a\u0004\u0018\u00010\u00162\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030&H@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\n2\u0006\u0010)\u001a\u00020*H\u0016J*\u0010,\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00162\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010-H\u0002J\u001d\u0010.\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030&\u0018\u00010-H@ø\u0001\u0000¢\u0006\u0002\u0010/J \u00100\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u00101\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u00102\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u00103\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J&\u00104\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u00105\u001a\u00020\n2\u0006\u00106\u001a\u0002072\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0014\u00108\u001a\u0004\u0018\u00010\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lio/flutter/plugins/sharedpreferences/SharedPreferencesPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesAsyncApi;", "listEncoder", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesListEncoder;", "(Lio/flutter/plugins/sharedpreferences/SharedPreferencesListEncoder;)V", "()V", "context", "Landroid/content/Context;", "clear", "", "allowList", "", "", "options", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;", "dataStoreSetString", "key", "value", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "", "", "getBool", "", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/lang/Boolean;", "getDouble", "", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/lang/Double;", "getInt", "", "(Ljava/lang/String;Lio/flutter/plugins/sharedpreferences/SharedPreferencesPigeonOptions;)Ljava/lang/Long;", "getKeys", "getPrefs", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getString", "getStringList", "getValueByKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "(Landroidx/datastore/preferences/core/Preferences$Key;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAttachedToEngine", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "preferencesFilter", "", "readAllKeys", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setBool", "setDouble", "setInt", "setString", "setStringList", "setUp", "messenger", "Lio/flutter/plugin/common/BinaryMessenger;", "transformPref", "ListEncoder", "shared_preferences_android_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SharedPreferencesPlugin implements FlutterPlugin, SharedPreferencesAsyncApi {
    /* access modifiers changed from: private */
    public Context context;
    @NotNull
    private SharedPreferencesListEncoder listEncoder;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¨\u0006\t"}, d2 = {"Lio/flutter/plugins/sharedpreferences/SharedPreferencesPlugin$ListEncoder;", "Lio/flutter/plugins/sharedpreferences/SharedPreferencesListEncoder;", "()V", "decode", "", "", "listString", "encode", "list", "shared_preferences_android_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ListEncoder implements SharedPreferencesListEncoder {
        @NotNull
        public List<String> decode(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "listString");
            try {
                Object readObject = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str, 0))).readObject();
                Intrinsics.checkNotNull(readObject, "null cannot be cast to non-null type kotlin.collections.List<*>");
                ArrayList arrayList = new ArrayList();
                for (Object next : (List) readObject) {
                    if (next instanceof String) {
                        arrayList.add(next);
                    }
                }
                return arrayList;
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }

        @NotNull
        public String encode(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(list);
                objectOutputStream.flush();
                String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(byteStream.toByteArray(), 0)");
                return encodeToString;
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public SharedPreferencesPlugin() {
        this.listEncoder = new ListEncoder();
    }

    /* access modifiers changed from: private */
    public final Object dataStoreSetString(String str, String str2, Continuation<? super Unit> continuation) {
        Preferences.Key f = PreferencesKeys.f(str);
        Context context2 = this.context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context2 = null;
        }
        Object a2 = PreferencesKt.a(SharedPreferencesPluginKt.getSharedPreferencesDataStore(context2), new SharedPreferencesPlugin$dataStoreSetString$2(f, str2, (Continuation<? super SharedPreferencesPlugin$dataStoreSetString$2>) null), continuation);
        return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getPrefs(java.util.List<java.lang.String> r9, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getPrefs$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getPrefs$1 r0 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getPrefs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getPrefs$1 r0 = new io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getPrefs$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0059
            if (r2 == r4) goto L_0x0049
            if (r2 != r3) goto L_0x0041
            java.lang.Object r8 = r0.L$4
            androidx.datastore.preferences.core.Preferences$Key r8 = (androidx.datastore.preferences.core.Preferences.Key) r8
            java.lang.Object r9 = r0.L$3
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r2 = r0.L$2
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r4 = r0.L$1
            java.util.Set r4 = (java.util.Set) r4
            java.lang.Object r5 = r0.L$0
            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin r5 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin) r5
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00a7
        L_0x0041:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0049:
            java.lang.Object r8 = r0.L$2
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r9 = r0.L$1
            java.util.Set r9 = (java.util.Set) r9
            java.lang.Object r2 = r0.L$0
            io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin r2 = (io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x007c
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r10)
            if (r9 == 0) goto L_0x0063
            java.util.Set r9 = kotlin.collections.CollectionsKt.toSet(r9)
            goto L_0x0064
        L_0x0063:
            r9 = 0
        L_0x0064:
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
            r10.<init>()
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r4
            java.lang.Object r2 = r8.readAllKeys(r0)
            if (r2 != r1) goto L_0x0078
            return r1
        L_0x0078:
            r7 = r2
            r2 = r8
            r8 = r10
            r10 = r7
        L_0x007c:
            java.util.Set r10 = (java.util.Set) r10
            if (r10 == 0) goto L_0x00c0
            java.util.Iterator r10 = r10.iterator()
            r4 = r9
            r9 = r10
            r5 = r2
            r2 = r8
        L_0x0088:
            boolean r8 = r9.hasNext()
            if (r8 == 0) goto L_0x00bf
            java.lang.Object r8 = r9.next()
            androidx.datastore.preferences.core.Preferences$Key r8 = (androidx.datastore.preferences.core.Preferences.Key) r8
            r0.L$0 = r5
            r0.L$1 = r4
            r0.L$2 = r2
            r0.L$3 = r9
            r0.L$4 = r8
            r0.label = r3
            java.lang.Object r10 = r5.getValueByKey(r8, r0)
            if (r10 != r1) goto L_0x00a7
            return r1
        L_0x00a7:
            java.lang.String r6 = r8.toString()
            boolean r6 = r5.preferencesFilter(r6, r10, r4)
            if (r6 == 0) goto L_0x0088
            java.lang.Object r10 = r5.transformPref(r10)
            if (r10 == 0) goto L_0x0088
            java.lang.String r8 = r8.toString()
            r2.put(r8, r10)
            goto L_0x0088
        L_0x00bf:
            r8 = r2
        L_0x00c0:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin.getPrefs(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object getValueByKey(Preferences.Key<?> key, Continuation<Object> continuation) {
        Context context2 = this.context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context2 = null;
        }
        return FlowKt.y(new SharedPreferencesPlugin$getValueByKey$$inlined$map$1(SharedPreferencesPluginKt.getSharedPreferencesDataStore(context2).getData(), key), continuation);
    }

    private final boolean preferencesFilter(String str, Object obj, Set<String> set) {
        return set == null ? (obj instanceof Boolean) || (obj instanceof Long) || (obj instanceof String) || (obj instanceof Double) : set.contains(str);
    }

    /* access modifiers changed from: private */
    public final Object readAllKeys(Continuation<? super Set<? extends Preferences.Key<?>>> continuation) {
        Context context2 = this.context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context2 = null;
        }
        return FlowKt.y(new SharedPreferencesPlugin$readAllKeys$$inlined$map$1(SharedPreferencesPluginKt.getSharedPreferencesDataStore(context2).getData()), continuation);
    }

    private final void setUp(BinaryMessenger binaryMessenger, Context context2) {
        this.context = context2;
        try {
            SharedPreferencesAsyncApi.Companion.setUp(binaryMessenger, this);
        } catch (Exception e) {
            Log.e(SharedPreferencesPluginKt.TAG, "Received exception while setting up SharedPreferencesPlugin", e);
        }
    }

    /* access modifiers changed from: private */
    public final Object transformPref(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (StringsKt.startsWith$default(str, SharedPreferencesPluginKt.LIST_PREFIX, false, 2, (Object) null)) {
                SharedPreferencesListEncoder sharedPreferencesListEncoder = this.listEncoder;
                String substring = str.substring(40);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                return sharedPreferencesListEncoder.decode(substring);
            }
        }
        return obj;
    }

    public void clear(@Nullable List<String> list, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions) {
        Intrinsics.checkNotNullParameter(sharedPreferencesPigeonOptions, "options");
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new SharedPreferencesPlugin$clear$1(this, list, (Continuation<? super SharedPreferencesPlugin$clear$1>) null), 1, (Object) null);
    }

    @NotNull
    public Map<String, Object> getAll(@Nullable List<String> list, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions) {
        Intrinsics.checkNotNullParameter(sharedPreferencesPigeonOptions, "options");
        return (Map) BuildersKt__BuildersKt.b((CoroutineContext) null, new SharedPreferencesPlugin$getAll$1(this, list, (Continuation<? super SharedPreferencesPlugin$getAll$1>) null), 1, (Object) null);
    }

    @Nullable
    public Boolean getBool(@NotNull String str, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(sharedPreferencesPigeonOptions, "options");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new SharedPreferencesPlugin$getBool$1(str, this, objectRef, (Continuation<? super SharedPreferencesPlugin$getBool$1>) null), 1, (Object) null);
        return (Boolean) objectRef.element;
    }

    @Nullable
    public Double getDouble(@NotNull String str, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(sharedPreferencesPigeonOptions, "options");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new SharedPreferencesPlugin$getDouble$1(str, this, objectRef, (Continuation<? super SharedPreferencesPlugin$getDouble$1>) null), 1, (Object) null);
        return (Double) objectRef.element;
    }

    @Nullable
    public Long getInt(@NotNull String str, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(sharedPreferencesPigeonOptions, "options");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new SharedPreferencesPlugin$getInt$1(str, this, objectRef, (Continuation<? super SharedPreferencesPlugin$getInt$1>) null), 1, (Object) null);
        return (Long) objectRef.element;
    }

    @NotNull
    public List<String> getKeys(@Nullable List<String> list, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions) {
        Intrinsics.checkNotNullParameter(sharedPreferencesPigeonOptions, "options");
        return CollectionsKt.toList(((Map) BuildersKt__BuildersKt.b((CoroutineContext) null, new SharedPreferencesPlugin$getKeys$prefs$1(this, list, (Continuation<? super SharedPreferencesPlugin$getKeys$prefs$1>) null), 1, (Object) null)).keySet());
    }

    @Nullable
    public String getString(@NotNull String str, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(sharedPreferencesPigeonOptions, "options");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new SharedPreferencesPlugin$getString$1(str, this, objectRef, (Continuation<? super SharedPreferencesPlugin$getString$1>) null), 1, (Object) null);
        return (String) objectRef.element;
    }

    @Nullable
    public List<String> getStringList(@NotNull String str, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(sharedPreferencesPigeonOptions, "options");
        List list = (List) transformPref(getString(str, sharedPreferencesPigeonOptions));
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof String) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void onAttachedToEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "binding.binaryMessenger");
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "binding.applicationContext");
        setUp(binaryMessenger, applicationContext);
        new LegacySharedPreferencesPlugin().onAttachedToEngine(flutterPluginBinding);
    }

    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        SharedPreferencesAsyncApi.Companion companion = SharedPreferencesAsyncApi.Companion;
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "binding.binaryMessenger");
        companion.setUp(binaryMessenger, (SharedPreferencesAsyncApi) null);
    }

    public void setBool(@NotNull String str, boolean z, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(sharedPreferencesPigeonOptions, "options");
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new SharedPreferencesPlugin$setBool$1(str, this, z, (Continuation<? super SharedPreferencesPlugin$setBool$1>) null), 1, (Object) null);
    }

    public void setDouble(@NotNull String str, double d, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(sharedPreferencesPigeonOptions, "options");
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new SharedPreferencesPlugin$setDouble$1(str, this, d, (Continuation<? super SharedPreferencesPlugin$setDouble$1>) null), 1, (Object) null);
    }

    public void setInt(@NotNull String str, long j, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(sharedPreferencesPigeonOptions, "options");
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new SharedPreferencesPlugin$setInt$1(str, this, j, (Continuation<? super SharedPreferencesPlugin$setInt$1>) null), 1, (Object) null);
    }

    public void setString(@NotNull String str, @NotNull String str2, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
        Intrinsics.checkNotNullParameter(sharedPreferencesPigeonOptions, "options");
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new SharedPreferencesPlugin$setString$1(this, str, str2, (Continuation<? super SharedPreferencesPlugin$setString$1>) null), 1, (Object) null);
    }

    public void setStringList(@NotNull String str, @NotNull List<String> list, @NotNull SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(list, AccountConstantKt.RESPONSE_VALUE);
        Intrinsics.checkNotNullParameter(sharedPreferencesPigeonOptions, "options");
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new SharedPreferencesPlugin$setStringList$1(this, str, SharedPreferencesPluginKt.LIST_PREFIX + this.listEncoder.encode(list), (Continuation<? super SharedPreferencesPlugin$setStringList$1>) null), 1, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public SharedPreferencesPlugin(@NotNull SharedPreferencesListEncoder sharedPreferencesListEncoder) {
        this();
        Intrinsics.checkNotNullParameter(sharedPreferencesListEncoder, "listEncoder");
        this.listEncoder = sharedPreferencesListEncoder;
    }
}
