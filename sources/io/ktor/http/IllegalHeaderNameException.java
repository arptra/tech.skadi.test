package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/http/IllegalHeaderNameException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "headerName", "", "position", "", "(Ljava/lang/String;I)V", "getHeaderName", "()Ljava/lang/String;", "getPosition", "()I", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IllegalHeaderNameException extends IllegalArgumentException {
    @NotNull
    private final String headerName;
    private final int position;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IllegalHeaderNameException(@NotNull String str, int i) {
        super("Header name '" + str + "' contains illegal character '" + str.charAt(i) + "' (code " + (str.charAt(i) & 255) + ')');
        Intrinsics.checkNotNullParameter(str, "headerName");
        this.headerName = str;
        this.position = i;
    }

    @NotNull
    public final String getHeaderName() {
        return this.headerName;
    }

    public final int getPosition() {
        return this.position;
    }
}
