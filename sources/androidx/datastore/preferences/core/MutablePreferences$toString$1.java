package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "entry", "", "Landroidx/datastore/preferences/core/Preferences$Key;", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class MutablePreferences$toString$1 extends Lambda implements Function1<Map.Entry<Preferences.Key<?>, Object>, CharSequence> {
    public static final MutablePreferences$toString$1 INSTANCE = new MutablePreferences$toString$1();

    public MutablePreferences$toString$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull Map.Entry<Preferences.Key<?>, Object> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return FastRecordHistoryDetailActivity.TAG_SPLIT + entry.getKey().a() + " = " + entry.getValue();
    }
}
