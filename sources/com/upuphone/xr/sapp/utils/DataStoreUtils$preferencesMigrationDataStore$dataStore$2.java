package com.upuphone.xr.sapp.utils;

import androidx.datastore.preferences.PreferenceDataStoreFile;
import com.upuphone.xr.sapp.MainApplication;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/File;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DataStoreUtils$preferencesMigrationDataStore$dataStore$2 extends Lambda implements Function0<File> {
    final /* synthetic */ String $sharedPreferName;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataStoreUtils$preferencesMigrationDataStore$dataStore$2(String str) {
        super(0);
        this.$sharedPreferName = str;
    }

    @NotNull
    public final File invoke() {
        return PreferenceDataStoreFile.a(MainApplication.k.f(), this.$sharedPreferName);
    }
}
