package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"%\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"LIST_PREFIX", "", "SHARED_PREFERENCES_NAME", "TAG", "sharedPreferencesDataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Landroid/content/Context;", "getSharedPreferencesDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "sharedPreferencesDataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "shared_preferences_android_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SharedPreferencesPluginKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SharedPreferencesPluginKt.class, "sharedPreferencesDataStore", "getSharedPreferencesDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1))};
    @NotNull
    public static final String LIST_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu";
    @NotNull
    public static final String SHARED_PREFERENCES_NAME = "FlutterSharedPreferences";
    @NotNull
    public static final String TAG = "SharedPreferencesPlugin";
    @NotNull
    private static final ReadOnlyProperty sharedPreferencesDataStore$delegate = PreferenceDataStoreDelegateKt.b(SHARED_PREFERENCES_NAME, (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 14, (Object) null);

    /* access modifiers changed from: private */
    public static final DataStore<Preferences> getSharedPreferencesDataStore(Context context) {
        return (DataStore) sharedPreferencesDataStore$delegate.getValue(context, $$delegatedProperties[0]);
    }
}
