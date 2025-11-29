package com.upuphone.xr.sapp.utils;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/datastore/preferences/core/Preferences;", "it", "Landroidx/datastore/core/CorruptionException;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DataStoreUtils$preferencesMigrationDataStore$dataStore$1 extends Lambda implements Function1<CorruptionException, Preferences> {
    public static final DataStoreUtils$preferencesMigrationDataStore$dataStore$1 INSTANCE = new DataStoreUtils$preferencesMigrationDataStore$dataStore$1();

    public DataStoreUtils$preferencesMigrationDataStore$dataStore$1() {
        super(1);
    }

    @NotNull
    public final Preferences invoke(@NotNull CorruptionException corruptionException) {
        Intrinsics.checkNotNullParameter(corruptionException, "it");
        return PreferencesFactory.a();
    }
}
