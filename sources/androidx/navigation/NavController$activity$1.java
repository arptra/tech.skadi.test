package androidx.navigation;

import android.content.Context;
import android.content.ContextWrapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/content/Context;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavController$activity$1 extends Lambda implements Function1<Context, Context> {
    public static final NavController$activity$1 INSTANCE = new NavController$activity$1();

    public NavController$activity$1() {
        super(1);
    }

    @Nullable
    public final Context invoke(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "it");
        if (context instanceof ContextWrapper) {
            return ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
