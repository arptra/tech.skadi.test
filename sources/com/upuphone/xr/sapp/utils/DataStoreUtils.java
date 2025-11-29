package com.upuphone.xr.sapp.utils;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.SharedPreferencesMigrationKt;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.entity.AccountInfo;
import java.util.HashMap;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0011\u001a\u00020\f\"\u0004\b\u0000\u0010\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00028\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00028\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u0003J\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u0007R%\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R<\u0010+\u001a*\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040'j\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004`(8\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/upuphone/xr/sapp/utils/DataStoreUtils;", "", "<init>", "()V", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "l", "()Landroidx/datastore/core/DataStore;", "T", "", "key", "value", "", "o", "(Ljava/lang/String;Ljava/lang/Object;)V", "", "associateUser", "p", "(Ljava/lang/String;Ljava/lang/Object;Z)V", "defaultValue", "Landroid/content/Context;", "mContext", "g", "(Ljava/lang/String;Ljava/lang/Object;Landroid/content/Context;)Ljava/lang/Object;", "h", "(Ljava/lang/String;Ljava/lang/Object;ZLandroid/content/Context;)Ljava/lang/Object;", "e", "sharedPreferName", "n", "(Ljava/lang/String;)Landroidx/datastore/core/DataStore;", "m", "a", "Lkotlin/properties/ReadOnlyProperty;", "k", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "dataStore", "b", "Ljava/lang/Object;", "lock", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "userStoreCache", "d", "Ljava/lang/String;", "userAccountId", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DataStoreUtils {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public static final /* synthetic */ KProperty[] f = {Reflection.property2(new PropertyReference2Impl(DataStoreUtils.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};
    public static final Lazy g = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, DataStoreUtils$Companion$instance$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public final ReadOnlyProperty f7866a = PreferenceDataStoreDelegateKt.b("super_app_sp", (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 14, (Object) null);
    public final Object b = new Object();
    public final HashMap c = new HashMap();
    public String d;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/utils/DataStoreUtils$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/utils/DataStoreUtils;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/upuphone/xr/sapp/utils/DataStoreUtils;", "instance", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DataStoreUtils a() {
            return (DataStoreUtils) DataStoreUtils.g.getValue();
        }

        public Companion() {
        }
    }

    public static /* synthetic */ Object i(DataStoreUtils dataStoreUtils, String str, Object obj, Context context, int i, Object obj2) {
        if ((i & 4) != 0) {
            context = GlobalExtKt.f();
        }
        return dataStoreUtils.g(str, obj, context);
    }

    public static /* synthetic */ Object j(DataStoreUtils dataStoreUtils, String str, Object obj, boolean z, Context context, int i, Object obj2) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            context = GlobalExtKt.f();
        }
        return dataStoreUtils.h(str, obj, z, context);
    }

    public final void e() {
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new DataStoreUtils$clearUserData$1(this, (Continuation<? super DataStoreUtils$clearUserData$1>) null), 1, (Object) null);
    }

    public final Object f(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        return i(this, str, obj, (Context) null, 4, (Object) null);
    }

    public final Object g(String str, Object obj, Context context) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(context, "mContext");
        return h(str, obj, false, context);
    }

    public final Object h(String str, Object obj, boolean z, Context context) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(context, "mContext");
        Object f2 = BuildersKt__BuildersKt.b((CoroutineContext) null, new DataStoreUtils$getData$cache$1(obj, str, z, this, context, (Continuation<? super DataStoreUtils$getData$cache$1>) null), 1, (Object) null);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("DataStoreUtils", "getData key:" + str + " cache:" + f2 + " default:" + obj + " associateUser:" + z);
        return f2;
    }

    public final DataStore k(Context context) {
        return (DataStore) this.f7866a.getValue(context, f[0]);
    }

    public final DataStore l() {
        return k(GlobalExtKt.f());
    }

    public final DataStore m() {
        synchronized (this.b) {
            try {
                AccountInfo accountInfo = (AccountInfo) MzAccountManager.c.b().d().getValue();
                String id = accountInfo != null ? accountInfo.getId() : null;
                this.d = id;
                if (id == null) {
                    return null;
                }
                String str = "super_app_sp_" + id;
                if (this.c.containsKey(str)) {
                    DataStore dataStore = (DataStore) this.c.get(str);
                    return dataStore;
                }
                DataStore n = n(str);
                this.c.put(str, n);
                ULog.f6446a.a("DataStoreUtils", "crate UserStore key:" + str);
                return n;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final DataStore n(String str) {
        DataStore a2 = PreferenceDataStoreFactory.f1039a.a(new ReplaceFileCorruptionHandler(DataStoreUtils$preferencesMigrationDataStore$dataStore$1.INSTANCE), CollectionsKt.listOf(SharedPreferencesMigrationKt.b(MainApplication.k.f(), str, (Set) null, 4, (Object) null)), CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null))), new DataStoreUtils$preferencesMigrationDataStore$dataStore$2(str));
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new DataStoreUtils$preferencesMigrationDataStore$1(a2, (Continuation<? super DataStoreUtils$preferencesMigrationDataStore$1>) null), 1, (Object) null);
        return a2;
    }

    public final void o(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        p(str, obj, false);
    }

    public final void p(String str, Object obj, boolean z) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new DataStoreUtils$putData$1(this, z, str, obj, (Continuation<? super DataStoreUtils$putData$1>) null), 1, (Object) null);
    }
}
