package sdk.meizu.account.factor.authentication.sdk.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/constant/Mode;", "", "mode", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "SIMPLE", "STRICT", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum Mode {
    SIMPLE(ConstantKt.FACTOR_MODE_LOCAL),
    STRICT(ConstantKt.FACTOR_MODE_STRICT);
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String mode;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/constant/Mode$Companion;", "", "()V", "parse", "Lsdk/meizu/account/factor/authentication/sdk/constant/Mode;", "name", "", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Mode parse(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            Mode mode = Mode.SIMPLE;
            if (Intrinsics.areEqual((Object) str, (Object) mode.toString())) {
                return mode;
            }
            Mode mode2 = Mode.STRICT;
            if (Intrinsics.areEqual((Object) str, (Object) mode2.toString())) {
                return mode2;
            }
            return null;
        }

        private Companion() {
        }
    }

    static {
        Mode[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private Mode(String str) {
        this.mode = str;
    }

    @NotNull
    public static EnumEntries<Mode> getEntries() {
        return $ENTRIES;
    }

    @NotNull
    public String toString() {
        return this.mode;
    }
}
