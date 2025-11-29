package com.honey.account.utils.network;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\r\u0018\u00002\u00020\u0001:\u00016B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00105\u001a\u00020$H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\nR\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010)\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010&\"\u0004\b1\u0010(R\u001a\u00102\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013¨\u00067"}, d2 = {"Lcom/honey/account/utils/network/Request;", "", "builder", "Lcom/honey/account/utils/network/Request$Builder;", "(Lcom/honey/account/utils/network/Request$Builder;)V", "chunkedStreamingMode", "", "getChunkedStreamingMode", "()I", "setChunkedStreamingMode", "(I)V", "connectTimeout", "getConnectTimeout", "setConnectTimeout", "doInput", "", "getDoInput", "()Z", "setDoInput", "(Z)V", "doOutput", "getDoOutput", "setDoOutput", "fixedLengthStreamingMode", "getFixedLengthStreamingMode", "setFixedLengthStreamingMode", "parameter", "", "getParameter", "()[B", "setParameter", "([B)V", "readTimeout", "getReadTimeout", "setReadTimeout", "requestMethod", "", "getRequestMethod", "()Ljava/lang/String;", "setRequestMethod", "(Ljava/lang/String;)V", "requestProperties", "", "getRequestProperties", "()Ljava/util/Map;", "setRequestProperties", "(Ljava/util/Map;)V", "url", "getUrl", "setUrl", "useCaches", "getUseCaches", "setUseCaches", "toString", "Builder", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Request {
    private int chunkedStreamingMode;
    private int connectTimeout;
    private boolean doInput;
    private boolean doOutput;
    private int fixedLengthStreamingMode;
    @Nullable
    private byte[] parameter;
    private int readTimeout;
    @NotNull
    private String requestMethod;
    @Nullable
    private Map<String, String> requestProperties;
    @NotNull
    private String url;
    private boolean useCaches;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u00101\u001a\u000202J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0006J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0006J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0003J\u001c\u0010+\u001a\u00020\u00002\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010(J\u000e\u00100\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\nR\u001a\u0010#\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\u0004R(\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u001a\u0010.\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0011\"\u0004\b0\u0010\u0013¨\u00063"}, d2 = {"Lcom/honey/account/utils/network/Request$Builder;", "", "url", "", "(Ljava/lang/String;)V", "chunkedStreamingMode", "", "getChunkedStreamingMode", "()I", "setChunkedStreamingMode", "(I)V", "connectTimeout", "getConnectTimeout", "setConnectTimeout", "doInput", "", "getDoInput", "()Z", "setDoInput", "(Z)V", "doOutput", "getDoOutput", "setDoOutput", "fixedLengthStreamingMode", "getFixedLengthStreamingMode", "setFixedLengthStreamingMode", "parameter", "", "getParameter", "()[B", "setParameter", "([B)V", "readTimeout", "getReadTimeout", "setReadTimeout", "requestMethod", "getRequestMethod", "()Ljava/lang/String;", "setRequestMethod", "requestProperties", "", "getRequestProperties", "()Ljava/util/Map;", "setRequestProperties", "(Ljava/util/Map;)V", "getUrl", "useCaches", "getUseCaches", "setUseCaches", "build", "Lcom/honey/account/utils/network/Request;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder {
        private int chunkedStreamingMode;
        private int connectTimeout;
        private boolean doInput = true;
        private boolean doOutput;
        private int fixedLengthStreamingMode;
        @Nullable
        private byte[] parameter;
        private int readTimeout;
        @NotNull
        private String requestMethod = "GET";
        @Nullable
        private Map<String, String> requestProperties;
        @NotNull
        private final String url;
        private boolean useCaches;

        public Builder(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            this.url = str;
        }

        @NotNull
        public final Request build() {
            return new Request(this, (DefaultConstructorMarker) null);
        }

        public final int getChunkedStreamingMode() {
            return this.chunkedStreamingMode;
        }

        public final int getConnectTimeout() {
            return this.connectTimeout;
        }

        public final boolean getDoInput() {
            return this.doInput;
        }

        public final boolean getDoOutput() {
            return this.doOutput;
        }

        public final int getFixedLengthStreamingMode() {
            return this.fixedLengthStreamingMode;
        }

        @Nullable
        public final byte[] getParameter() {
            return this.parameter;
        }

        public final int getReadTimeout() {
            return this.readTimeout;
        }

        @NotNull
        public final String getRequestMethod() {
            return this.requestMethod;
        }

        @Nullable
        public final Map<String, String> getRequestProperties() {
            return this.requestProperties;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        public final boolean getUseCaches() {
            return this.useCaches;
        }

        /* renamed from: setChunkedStreamingMode  reason: collision with other method in class */
        public final void m1713setChunkedStreamingMode(int i) {
            this.chunkedStreamingMode = i;
        }

        /* renamed from: setConnectTimeout  reason: collision with other method in class */
        public final void m1714setConnectTimeout(int i) {
            this.connectTimeout = i;
        }

        /* renamed from: setDoInput  reason: collision with other method in class */
        public final void m1715setDoInput(boolean z) {
            this.doInput = z;
        }

        /* renamed from: setDoOutput  reason: collision with other method in class */
        public final void m1716setDoOutput(boolean z) {
            this.doOutput = z;
        }

        /* renamed from: setFixedLengthStreamingMode  reason: collision with other method in class */
        public final void m1717setFixedLengthStreamingMode(int i) {
            this.fixedLengthStreamingMode = i;
        }

        /* renamed from: setParameter  reason: collision with other method in class */
        public final void m1718setParameter(@Nullable byte[] bArr) {
            this.parameter = bArr;
        }

        /* renamed from: setReadTimeout  reason: collision with other method in class */
        public final void m1719setReadTimeout(int i) {
            this.readTimeout = i;
        }

        /* renamed from: setRequestMethod  reason: collision with other method in class */
        public final void m1720setRequestMethod(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.requestMethod = str;
        }

        /* renamed from: setRequestProperties  reason: collision with other method in class */
        public final void m1721setRequestProperties(@Nullable Map<String, String> map) {
            this.requestProperties = map;
        }

        /* renamed from: setUseCaches  reason: collision with other method in class */
        public final void m1722setUseCaches(boolean z) {
            this.useCaches = z;
        }

        @NotNull
        public final Builder setChunkedStreamingMode(int i) {
            this.chunkedStreamingMode = i;
            return this;
        }

        @NotNull
        public final Builder setConnectTimeout(int i) {
            this.connectTimeout = i;
            return this;
        }

        @NotNull
        public final Builder setDoInput(boolean z) {
            this.doInput = z;
            return this;
        }

        @NotNull
        public final Builder setDoOutput(boolean z) {
            this.doOutput = z;
            return this;
        }

        @NotNull
        public final Builder setFixedLengthStreamingMode(int i) {
            this.fixedLengthStreamingMode = i;
            return this;
        }

        @NotNull
        public final Builder setParameter(@Nullable byte[] bArr) {
            this.parameter = bArr;
            return this;
        }

        @NotNull
        public final Builder setReadTimeout(int i) {
            this.readTimeout = i;
            return this;
        }

        @NotNull
        public final Builder setRequestMethod(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "requestMethod");
            this.requestMethod = str;
            return this;
        }

        @NotNull
        public final Builder setRequestProperties(@Nullable Map<String, String> map) {
            this.requestProperties = map;
            return this;
        }

        @NotNull
        public final Builder setUseCaches(boolean z) {
            this.useCaches = z;
            return this;
        }
    }

    public /* synthetic */ Request(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public final int getChunkedStreamingMode() {
        return this.chunkedStreamingMode;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final boolean getDoInput() {
        return this.doInput;
    }

    public final boolean getDoOutput() {
        return this.doOutput;
    }

    public final int getFixedLengthStreamingMode() {
        return this.fixedLengthStreamingMode;
    }

    @Nullable
    public final byte[] getParameter() {
        return this.parameter;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    @NotNull
    public final String getRequestMethod() {
        return this.requestMethod;
    }

    @Nullable
    public final Map<String, String> getRequestProperties() {
        return this.requestProperties;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final boolean getUseCaches() {
        return this.useCaches;
    }

    public final void setChunkedStreamingMode(int i) {
        this.chunkedStreamingMode = i;
    }

    public final void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public final void setDoInput(boolean z) {
        this.doInput = z;
    }

    public final void setDoOutput(boolean z) {
        this.doOutput = z;
    }

    public final void setFixedLengthStreamingMode(int i) {
        this.fixedLengthStreamingMode = i;
    }

    public final void setParameter(@Nullable byte[] bArr) {
        this.parameter = bArr;
    }

    public final void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public final void setRequestMethod(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestMethod = str;
    }

    public final void setRequestProperties(@Nullable Map<String, String> map) {
        this.requestProperties = map;
    }

    public final void setUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final void setUseCaches(boolean z) {
        this.useCaches = z;
    }

    @NotNull
    public String toString() {
        return "Request{ url = '" + this.url + "' , requestMethod = '" + this.requestMethod + "' , connectTimeout = '" + this.connectTimeout + "' , readTimeout = '" + this.readTimeout + "' , chunkedStreamingMode = '" + this.chunkedStreamingMode + "' , fixedLengthStreamingMode = '" + this.fixedLengthStreamingMode + "' , useCaches = '" + this.useCaches + "' , doInput = '" + this.doInput + "' , doOutput = '" + this.doOutput + "' , requestProperties = '" + this.requestProperties + "' , parameter = '" + this.parameter + "' }";
    }

    private Request(Builder builder) {
        this.url = builder.getUrl();
        this.requestMethod = builder.getRequestMethod();
        this.connectTimeout = builder.getConnectTimeout();
        this.readTimeout = builder.getReadTimeout();
        this.chunkedStreamingMode = builder.getChunkedStreamingMode();
        this.fixedLengthStreamingMode = builder.getFixedLengthStreamingMode();
        this.useCaches = builder.getUseCaches();
        this.doInput = builder.getDoInput();
        this.doOutput = builder.getDoOutput();
        this.requestProperties = builder.getRequestProperties();
        this.parameter = builder.getParameter();
    }
}
