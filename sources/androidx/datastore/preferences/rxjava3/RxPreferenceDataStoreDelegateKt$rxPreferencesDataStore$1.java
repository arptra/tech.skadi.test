package androidx.datastore.preferences.rxjava3;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.preferences.core.Preferences;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Landroidx/datastore/core/DataMigration;", "Landroidx/datastore/preferences/core/Preferences;", "it", "Landroid/content/Context;"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class RxPreferenceDataStoreDelegateKt$rxPreferencesDataStore$1 extends Lambda implements Function1<Context, List<? extends DataMigration<Preferences>>> {
    public static final RxPreferenceDataStoreDelegateKt$rxPreferencesDataStore$1 INSTANCE = new RxPreferenceDataStoreDelegateKt$rxPreferencesDataStore$1();

    public RxPreferenceDataStoreDelegateKt$rxPreferencesDataStore$1() {
        super(1);
    }

    @NotNull
    public final List<DataMigration<Preferences>> invoke(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "it");
        return CollectionsKt.emptyList();
    }
}
