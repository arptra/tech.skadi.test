package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.migrations.SharedPreferencesMigration;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a5\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a4\u0010\u000e\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a<\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00102\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\" \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroid/content/Context;", "context", "", "sharedPreferencesName", "", "keysToMigrate", "Landroidx/datastore/migrations/SharedPreferencesMigration;", "Landroidx/datastore/preferences/core/Preferences;", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Set;)Landroidx/datastore/migrations/SharedPreferencesMigration;", "Lkotlin/Function3;", "Landroidx/datastore/migrations/SharedPreferencesView;", "Lkotlin/coroutines/Continuation;", "", "d", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/Function2;", "", "e", "(Ljava/util/Set;)Lkotlin/jvm/functions/Function2;", "Ljava/util/Set;", "c", "()Ljava/util/Set;", "MIGRATE_ALL_KEYS", "datastore-preferences_release"}, k = 2, mv = {1, 5, 1})
public final class SharedPreferencesMigrationKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f1036a = new LinkedHashSet();

    public static final SharedPreferencesMigration a(Context context, String str, Set set) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "sharedPreferencesName");
        Intrinsics.checkNotNullParameter(set, "keysToMigrate");
        if (set == f1036a) {
            return new SharedPreferencesMigration(context, str, (Set) null, e(set), d(), 4, (DefaultConstructorMarker) null);
        }
        return new SharedPreferencesMigration(context, str, set, e(set), d());
    }

    public static /* synthetic */ SharedPreferencesMigration b(Context context, String str, Set set, int i, Object obj) {
        if ((i & 4) != 0) {
            set = f1036a;
        }
        return a(context, str, set);
    }

    public static final Set c() {
        return f1036a;
    }

    public static final Function3 d() {
        return new SharedPreferencesMigrationKt$getMigrationFunction$1((Continuation<? super SharedPreferencesMigrationKt$getMigrationFunction$1>) null);
    }

    public static final Function2 e(Set set) {
        return new SharedPreferencesMigrationKt$getShouldRunMigration$1(set, (Continuation<? super SharedPreferencesMigrationKt$getShouldRunMigration$1>) null);
    }
}
