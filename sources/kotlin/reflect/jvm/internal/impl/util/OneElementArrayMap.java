package kotlin.reflect.jvm.internal.impl.util;

import com.honey.account.constant.AccountConstantKt;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OneElementArrayMap<T> extends ArrayMap<T> {
    private final int index;
    @NotNull
    private final T value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneElementArrayMap(@NotNull T t, int i) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(t, AccountConstantKt.RESPONSE_VALUE);
        this.value = t;
        this.index = i;
    }

    @Nullable
    public T get(int i) {
        if (i == this.index) {
            return this.value;
        }
        return null;
    }

    public final int getIndex() {
        return this.index;
    }

    public int getSize() {
        return 1;
    }

    @NotNull
    public final T getValue() {
        return this.value;
    }

    @NotNull
    public Iterator<T> iterator() {
        return new OneElementArrayMap$iterator$1(this);
    }

    public void set(int i, @NotNull T t) {
        Intrinsics.checkNotNullParameter(t, AccountConstantKt.RESPONSE_VALUE);
        throw new IllegalStateException();
    }
}
