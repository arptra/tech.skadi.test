package com.honey.account.utils.network;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0006H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR%\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/honey/account/utils/network/Response;", "", "builder", "Lcom/honey/account/utils/network/Response$Builder;", "(Lcom/honey/account/utils/network/Response$Builder;)V", "body", "", "getBody", "()Ljava/lang/String;", "code", "", "getCode", "()I", "headerFields", "", "", "getHeaderFields", "()Ljava/util/Map;", "message", "getMessage", "request", "Lcom/honey/account/utils/network/Request;", "getRequest", "()Lcom/honey/account/utils/network/Request;", "isSuccess", "", "toString", "Builder", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Response {
    @Nullable
    private final String body;
    private final int code;
    @Nullable
    private final Map<String, List<String>> headerFields;
    @Nullable
    private final String message;
    @Nullable
    private final Request request;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ \u0010\u0014\u001a\u00020\u00002\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0010J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0011\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/honey/account/utils/network/Response$Builder;", "", "()V", "body", "", "getBody", "()Ljava/lang/String;", "setBody", "(Ljava/lang/String;)V", "code", "", "getCode", "()I", "setCode", "(I)V", "headerFields", "", "", "getHeaderFields", "()Ljava/util/Map;", "setHeaderFields", "(Ljava/util/Map;)V", "message", "getMessage", "setMessage", "request", "Lcom/honey/account/utils/network/Request;", "getRequest", "()Lcom/honey/account/utils/network/Request;", "setRequest", "(Lcom/honey/account/utils/network/Request;)V", "build", "Lcom/honey/account/utils/network/Response;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder {
        @Nullable
        private String body;
        private int code;
        @Nullable
        private Map<String, ? extends List<String>> headerFields;
        @Nullable
        private String message;
        @Nullable
        private Request request;

        @NotNull
        public final Response build() {
            return new Response(this, (DefaultConstructorMarker) null);
        }

        @Nullable
        public final String getBody() {
            return this.body;
        }

        public final int getCode() {
            return this.code;
        }

        @Nullable
        public final Map<String, List<String>> getHeaderFields() {
            return this.headerFields;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        public final Request getRequest() {
            return this.request;
        }

        /* renamed from: setBody  reason: collision with other method in class */
        public final void m1723setBody(@Nullable String str) {
            this.body = str;
        }

        /* renamed from: setCode  reason: collision with other method in class */
        public final void m1724setCode(int i) {
            this.code = i;
        }

        /* renamed from: setHeaderFields  reason: collision with other method in class */
        public final void m1725setHeaderFields(@Nullable Map<String, ? extends List<String>> map) {
            this.headerFields = map;
        }

        /* renamed from: setMessage  reason: collision with other method in class */
        public final void m1726setMessage(@Nullable String str) {
            this.message = str;
        }

        /* renamed from: setRequest  reason: collision with other method in class */
        public final void m1727setRequest(@Nullable Request request2) {
            this.request = request2;
        }

        @NotNull
        public final Builder setBody(@Nullable String str) {
            this.body = str;
            return this;
        }

        @NotNull
        public final Builder setCode(int i) {
            this.code = i;
            return this;
        }

        @NotNull
        public final Builder setHeaderFields(@NotNull Map<String, ? extends List<String>> map) {
            Intrinsics.checkNotNullParameter(map, "headerFields");
            this.headerFields = map;
            return this;
        }

        @NotNull
        public final Builder setMessage(@Nullable String str) {
            this.message = str;
            return this;
        }

        @NotNull
        public final Builder setRequest(@Nullable Request request2) {
            this.request = request2;
            return this;
        }
    }

    public /* synthetic */ Response(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Nullable
    public final String getBody() {
        return this.body;
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final Map<String, List<String>> getHeaderFields() {
        return this.headerFields;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Request getRequest() {
        return this.request;
    }

    public final boolean isSuccess() {
        return this.code == 200;
    }

    @NotNull
    public String toString() {
        return "Response{ request = '" + this.request + "', code = '" + this.code + "', message = '" + this.message + "', body = '" + this.body + "', headerFields = '" + this.headerFields + "' }";
    }

    private Response(Builder builder) {
        this.request = builder.getRequest();
        this.code = builder.getCode();
        this.message = builder.getMessage();
        this.body = builder.getBody();
        this.headerFields = builder.getHeaderFields();
    }
}
