package com.upuphone.ar.transcribe.utils;

import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008FX\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroid/content/Context;", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "b", "Lkotlin/properties/ReadOnlyProperty;", "getTransDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "transDataStore", "ar-transcribe_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class DataStoreUtilsKt {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f6183a = {Reflection.property1(new PropertyReference1Impl(DataStoreUtilsKt.class, "transDataStore", "getTransDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1))};
    public static final ReadOnlyProperty b = PreferenceDataStoreDelegateKt.b("ArTranslation", (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 14, (Object) null);
}
