package com.meizu.flyme.policy.sdk;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\" \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\" \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0004\"\u0004\b\n\u0010\u0006\"%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f*\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"KEY_POLICY_OPERATE", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getKEY_POLICY_OPERATE", "()Landroidx/datastore/preferences/core/Preferences$Key;", "setKEY_POLICY_OPERATE", "(Landroidx/datastore/preferences/core/Preferences$Key;)V", "KEY_POLICY_OPERATE_JSON", "", "getKEY_POLICY_OPERATE_JSON", "setKEY_POLICY_OPERATE_JSON", "policySdkDataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Landroid/content/Context;", "getPolicySdkDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "policySdkDataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "policysdk_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3198a = {Reflection.property1(new PropertyReference1Impl(d.class, "policySdkDataStore", "getPolicySdkDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1))};
    @NotNull
    public static final ReadOnlyProperty b = PreferenceDataStoreDelegateKt.b("policy_sdk_data", (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 14, (Object) null);
    @NotNull
    public static Preferences.Key<Boolean> c = PreferencesKeys.a("policyOperate");
    @NotNull
    public static Preferences.Key<String> d = PreferencesKeys.f("policyOperateRequestJson");

    public static final DataStore a(Context context) {
        return (DataStore) b.getValue(context, f3198a[0]);
    }
}
