package io.ktor.utils.io.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0005\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u000f\u0012\b\b\u0002\u0010\f\u001a\u00020\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/utils/io/core/InsufficientSpaceException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "size", "", "availableSpace", "(II)V", "name", "", "(Ljava/lang/String;II)V", "", "(JJ)V", "message", "(Ljava/lang/String;)V", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InsufficientSpaceException extends Exception {
    public InsufficientSpaceException() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InsufficientSpaceException(@NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "message");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InsufficientSpaceException(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Not enough free space" : str);
    }

    public InsufficientSpaceException(int i, int i2) {
        this("Not enough free space to write " + i + " bytes, available " + i2 + " bytes.");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InsufficientSpaceException(@NotNull String str, int i, int i2) {
        this("Not enough free space to write " + str + " of " + i + " bytes, available " + i2 + " bytes.");
        Intrinsics.checkNotNullParameter(str, "name");
    }

    public InsufficientSpaceException(long j, long j2) {
        this("Not enough free space to write " + j + " bytes, available " + j2 + " bytes.");
    }
}
