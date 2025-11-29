package kotlin.reflect.jvm.internal.impl.util;

import com.honey.account.constant.AccountConstantKt;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class EmptyArrayMap extends ArrayMap {
    @NotNull
    public static final EmptyArrayMap INSTANCE = new EmptyArrayMap();

    private EmptyArrayMap() {
        super((DefaultConstructorMarker) null);
    }

    @Nullable
    public Void get(int i) {
        return null;
    }

    public int getSize() {
        return 0;
    }

    @NotNull
    public Iterator iterator() {
        return new EmptyArrayMap$iterator$1();
    }

    public void set(int i, @NotNull Void voidR) {
        Intrinsics.checkNotNullParameter(voidR, AccountConstantKt.RESPONSE_VALUE);
        throw new IllegalStateException();
    }
}
