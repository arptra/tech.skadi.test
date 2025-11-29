package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IncompatibleVersionErrorData<T> {
    private final T actualVersion;
    @NotNull
    private final ClassId classId;
    private final T compilerVersion;
    private final T expectedVersion;
    @NotNull
    private final String filePath;
    private final T languageVersion;

    public IncompatibleVersionErrorData(T t, T t2, T t3, T t4, @NotNull String str, @NotNull ClassId classId2) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        Intrinsics.checkNotNullParameter(classId2, "classId");
        this.actualVersion = t;
        this.compilerVersion = t2;
        this.languageVersion = t3;
        this.expectedVersion = t4;
        this.filePath = str;
        this.classId = classId2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IncompatibleVersionErrorData)) {
            return false;
        }
        IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
        return Intrinsics.areEqual((Object) this.actualVersion, (Object) incompatibleVersionErrorData.actualVersion) && Intrinsics.areEqual((Object) this.compilerVersion, (Object) incompatibleVersionErrorData.compilerVersion) && Intrinsics.areEqual((Object) this.languageVersion, (Object) incompatibleVersionErrorData.languageVersion) && Intrinsics.areEqual((Object) this.expectedVersion, (Object) incompatibleVersionErrorData.expectedVersion) && Intrinsics.areEqual((Object) this.filePath, (Object) incompatibleVersionErrorData.filePath) && Intrinsics.areEqual((Object) this.classId, (Object) incompatibleVersionErrorData.classId);
    }

    public int hashCode() {
        T t = this.actualVersion;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.compilerVersion;
        int hashCode2 = (hashCode + (t2 == null ? 0 : t2.hashCode())) * 31;
        T t3 = this.languageVersion;
        int hashCode3 = (hashCode2 + (t3 == null ? 0 : t3.hashCode())) * 31;
        T t4 = this.expectedVersion;
        if (t4 != null) {
            i = t4.hashCode();
        }
        return ((((hashCode3 + i) * 31) + this.filePath.hashCode()) * 31) + this.classId.hashCode();
    }

    @NotNull
    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.actualVersion + ", compilerVersion=" + this.compilerVersion + ", languageVersion=" + this.languageVersion + ", expectedVersion=" + this.expectedVersion + ", filePath=" + this.filePath + ", classId=" + this.classId + ')';
    }
}
