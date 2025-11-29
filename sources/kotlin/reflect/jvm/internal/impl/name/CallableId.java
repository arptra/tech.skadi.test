package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

public final class CallableId {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final Name LOCAL_NAME;
    @NotNull
    private static final FqName PACKAGE_FQ_NAME_FOR_LOCAL;
    @NotNull
    private final Name callableName;
    @Nullable
    private final FqName className;
    @NotNull
    private final FqName packageName;
    @Nullable
    private final FqName pathToLocal;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Name name = SpecialNames.LOCAL;
        LOCAL_NAME = name;
        FqName fqName = FqName.topLevel(name);
        Intrinsics.checkNotNullExpressionValue(fqName, "topLevel(LOCAL_NAME)");
        PACKAGE_FQ_NAME_FOR_LOCAL = fqName;
    }

    public CallableId(@NotNull FqName fqName, @Nullable FqName fqName2, @NotNull Name name, @Nullable FqName fqName3) {
        Intrinsics.checkNotNullParameter(fqName, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(name, "callableName");
        this.packageName = fqName;
        this.className = fqName2;
        this.callableName = name;
        this.pathToLocal = fqName3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallableId)) {
            return false;
        }
        CallableId callableId = (CallableId) obj;
        return Intrinsics.areEqual((Object) this.packageName, (Object) callableId.packageName) && Intrinsics.areEqual((Object) this.className, (Object) callableId.className) && Intrinsics.areEqual((Object) this.callableName, (Object) callableId.callableName) && Intrinsics.areEqual((Object) this.pathToLocal, (Object) callableId.pathToLocal);
    }

    public int hashCode() {
        int hashCode = this.packageName.hashCode() * 31;
        FqName fqName = this.className;
        int i = 0;
        int hashCode2 = (((hashCode + (fqName == null ? 0 : fqName.hashCode())) * 31) + this.callableName.hashCode()) * 31;
        FqName fqName2 = this.pathToLocal;
        if (fqName2 != null) {
            i = fqName2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String asString = this.packageName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "packageName.asString()");
        sb.append(StringsKt.replace$default(asString, '.', '/', false, 4, (Object) null));
        sb.append("/");
        FqName fqName = this.className;
        if (fqName != null) {
            sb.append(fqName);
            sb.append(".");
        }
        sb.append(this.callableName);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallableId(FqName fqName, FqName fqName2, Name name, FqName fqName3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fqName, fqName2, name, (i & 8) != 0 ? null : fqName3);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CallableId(@NotNull FqName fqName, @NotNull Name name) {
        this(fqName, (FqName) null, name, (FqName) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fqName, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(name, "callableName");
    }
}
