package sdk.meizu.account.factor.authentication.sdk.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/constant/ModeScenario;", "", "code", "", "(Ljava/lang/String;II)V", "toString", "", "LOGGED_ACCOUNT", "LOGGED_ACCOUNT_THREE", "LOGGED_ANSWER", "LOGIN_ACCOUNT_VALIDATE", "LOGIN_ACCOUNT_RISK", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum ModeScenario {
    LOGGED_ACCOUNT(1),
    LOGGED_ACCOUNT_THREE(2),
    LOGGED_ANSWER(3),
    LOGIN_ACCOUNT_VALIDATE(4),
    LOGIN_ACCOUNT_RISK(5);
    
    @NotNull
    public static final Companion Companion = null;
    private final int code;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/constant/ModeScenario$Companion;", "", "()V", "isLogged", "", "modeScenario", "Lsdk/meizu/account/factor/authentication/sdk/constant/ModeScenario;", "parse", "code", "", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isLogged(@NotNull ModeScenario modeScenario) {
            Intrinsics.checkNotNullParameter(modeScenario, ConstantKt.FACTOR_PARAMS_MODE_SCENARIO);
            return modeScenario == ModeScenario.LOGGED_ACCOUNT || modeScenario == ModeScenario.LOGGED_ACCOUNT_THREE || modeScenario == ModeScenario.LOGGED_ANSWER;
        }

        @Nullable
        public final ModeScenario parse(int i) {
            if (i == 1) {
                return ModeScenario.LOGGED_ACCOUNT;
            }
            if (i == 2) {
                return ModeScenario.LOGGED_ACCOUNT_THREE;
            }
            if (i == 3) {
                return ModeScenario.LOGGED_ANSWER;
            }
            if (i == 4) {
                return ModeScenario.LOGIN_ACCOUNT_VALIDATE;
            }
            if (i != 5) {
                return null;
            }
            return ModeScenario.LOGIN_ACCOUNT_RISK;
        }

        private Companion() {
        }
    }

    static {
        ModeScenario[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private ModeScenario(int i) {
        this.code = i;
    }

    @NotNull
    public static EnumEntries<ModeScenario> getEntries() {
        return $ENTRIES;
    }

    @NotNull
    public String toString() {
        return String.valueOf(this.code);
    }
}
