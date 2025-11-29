package com.upuphone.ar.transcribe.phone.repo;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/repo/AIRequest;", "", "metadata", "Lcom/upuphone/ar/transcribe/phone/repo/AIRequest$Metadata;", "services", "", "Lcom/upuphone/ar/transcribe/phone/repo/AIRequest$Service;", "(Lcom/upuphone/ar/transcribe/phone/repo/AIRequest$Metadata;Ljava/util/List;)V", "getMetadata", "()Lcom/upuphone/ar/transcribe/phone/repo/AIRequest$Metadata;", "getServices", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Metadata", "Service", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AIRequest {
    @NotNull
    private final Metadata metadata;
    @NotNull
    private final List<Service> services;

    @Keep
    @kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/repo/AIRequest$Service;", "", "payload", "Lcom/upuphone/ar/transcribe/phone/repo/AIRequest$Service$Payload;", "type", "", "(Lcom/upuphone/ar/transcribe/phone/repo/AIRequest$Service$Payload;Ljava/lang/String;)V", "getPayload", "()Lcom/upuphone/ar/transcribe/phone/repo/AIRequest$Service$Payload;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Payload", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Service {
        @NotNull
        private final Payload payload;
        @NotNull
        private final String type;

        public Service(@NotNull Payload payload2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(payload2, "payload");
            Intrinsics.checkNotNullParameter(str, "type");
            this.payload = payload2;
            this.type = str;
        }

        public static /* synthetic */ Service copy$default(Service service, Payload payload2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                payload2 = service.payload;
            }
            if ((i & 2) != 0) {
                str = service.type;
            }
            return service.copy(payload2, str);
        }

        @NotNull
        public final Payload component1() {
            return this.payload;
        }

        @NotNull
        public final String component2() {
            return this.type;
        }

        @NotNull
        public final Service copy(@NotNull Payload payload2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(payload2, "payload");
            Intrinsics.checkNotNullParameter(str, "type");
            return new Service(payload2, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Service)) {
                return false;
            }
            Service service = (Service) obj;
            return Intrinsics.areEqual((Object) this.payload, (Object) service.payload) && Intrinsics.areEqual((Object) this.type, (Object) service.type);
        }

        @NotNull
        public final Payload getPayload() {
            return this.payload;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            return (this.payload.hashCode() * 31) + this.type.hashCode();
        }

        @NotNull
        public String toString() {
            Payload payload2 = this.payload;
            String str = this.type;
            return "Service(payload=" + payload2 + ", type=" + str + ")";
        }

        @Keep
        @kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/repo/AIRequest$Service$Payload;", "", "payload", "Lcom/upuphone/ar/transcribe/phone/repo/AIRequest$Service$Payload$Payload;", "type", "", "(Lcom/upuphone/ar/transcribe/phone/repo/AIRequest$Service$Payload$Payload;Ljava/lang/String;)V", "getPayload", "()Lcom/upuphone/ar/transcribe/phone/repo/AIRequest$Service$Payload$Payload;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Payload", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Payload {
            @NotNull
            private final C0024Payload payload;
            @NotNull
            private final String type;

            public Payload(@NotNull C0024Payload payload2, @NotNull String str) {
                Intrinsics.checkNotNullParameter(payload2, "payload");
                Intrinsics.checkNotNullParameter(str, "type");
                this.payload = payload2;
                this.type = str;
            }

            public static /* synthetic */ Payload copy$default(Payload payload2, C0024Payload payload3, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    payload3 = payload2.payload;
                }
                if ((i & 2) != 0) {
                    str = payload2.type;
                }
                return payload2.copy(payload3, str);
            }

            @NotNull
            public final C0024Payload component1() {
                return this.payload;
            }

            @NotNull
            public final String component2() {
                return this.type;
            }

            @NotNull
            public final Payload copy(@NotNull C0024Payload payload2, @NotNull String str) {
                Intrinsics.checkNotNullParameter(payload2, "payload");
                Intrinsics.checkNotNullParameter(str, "type");
                return new Payload(payload2, str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Payload)) {
                    return false;
                }
                Payload payload2 = (Payload) obj;
                return Intrinsics.areEqual((Object) this.payload, (Object) payload2.payload) && Intrinsics.areEqual((Object) this.type, (Object) payload2.type);
            }

            @NotNull
            public final C0024Payload getPayload() {
                return this.payload;
            }

            @NotNull
            public final String getType() {
                return this.type;
            }

            public int hashCode() {
                return (this.payload.hashCode() * 31) + this.type.hashCode();
            }

            @NotNull
            public String toString() {
                C0024Payload payload2 = this.payload;
                String str = this.type;
                return "Payload(payload=" + payload2 + ", type=" + str + ")";
            }

            @Keep
            @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/repo/AIRequest$Service$Payload$Payload;", "", "recognizeId", "", "sceneType", "", "(Ljava/lang/String;I)V", "getRecognizeId", "()Ljava/lang/String;", "getSceneType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.upuphone.ar.transcribe.phone.repo.AIRequest$Service$Payload$Payload  reason: collision with other inner class name */
            public static final class C0024Payload {
                @NotNull
                private final String recognizeId;
                private final int sceneType;

                public C0024Payload(@NotNull String str, int i) {
                    Intrinsics.checkNotNullParameter(str, "recognizeId");
                    this.recognizeId = str;
                    this.sceneType = i;
                }

                public static /* synthetic */ C0024Payload copy$default(C0024Payload payload, String str, int i, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        str = payload.recognizeId;
                    }
                    if ((i2 & 2) != 0) {
                        i = payload.sceneType;
                    }
                    return payload.copy(str, i);
                }

                @NotNull
                public final String component1() {
                    return this.recognizeId;
                }

                public final int component2() {
                    return this.sceneType;
                }

                @NotNull
                public final C0024Payload copy(@NotNull String str, int i) {
                    Intrinsics.checkNotNullParameter(str, "recognizeId");
                    return new C0024Payload(str, i);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof C0024Payload)) {
                        return false;
                    }
                    C0024Payload payload = (C0024Payload) obj;
                    return Intrinsics.areEqual((Object) this.recognizeId, (Object) payload.recognizeId) && this.sceneType == payload.sceneType;
                }

                @NotNull
                public final String getRecognizeId() {
                    return this.recognizeId;
                }

                public final int getSceneType() {
                    return this.sceneType;
                }

                public int hashCode() {
                    return (this.recognizeId.hashCode() * 31) + Integer.hashCode(this.sceneType);
                }

                @NotNull
                public String toString() {
                    String str = this.recognizeId;
                    int i = this.sceneType;
                    return "Payload(recognizeId=" + str + ", sceneType=" + i + ")";
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ C0024Payload(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                    this(str, (i2 & 2) != 0 ? 0 : i);
                }
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Service(Payload payload2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(payload2, (i & 2) != 0 ? "llm" : str);
        }
    }

    public AIRequest(@NotNull Metadata metadata2, @NotNull List<Service> list) {
        Intrinsics.checkNotNullParameter(metadata2, "metadata");
        Intrinsics.checkNotNullParameter(list, "services");
        this.metadata = metadata2;
        this.services = list;
    }

    public static /* synthetic */ AIRequest copy$default(AIRequest aIRequest, Metadata metadata2, List<Service> list, int i, Object obj) {
        if ((i & 1) != 0) {
            metadata2 = aIRequest.metadata;
        }
        if ((i & 2) != 0) {
            list = aIRequest.services;
        }
        return aIRequest.copy(metadata2, list);
    }

    @NotNull
    public final Metadata component1() {
        return this.metadata;
    }

    @NotNull
    public final List<Service> component2() {
        return this.services;
    }

    @NotNull
    public final AIRequest copy(@NotNull Metadata metadata2, @NotNull List<Service> list) {
        Intrinsics.checkNotNullParameter(metadata2, "metadata");
        Intrinsics.checkNotNullParameter(list, "services");
        return new AIRequest(metadata2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AIRequest)) {
            return false;
        }
        AIRequest aIRequest = (AIRequest) obj;
        return Intrinsics.areEqual((Object) this.metadata, (Object) aIRequest.metadata) && Intrinsics.areEqual((Object) this.services, (Object) aIRequest.services);
    }

    @NotNull
    public final Metadata getMetadata() {
        return this.metadata;
    }

    @NotNull
    public final List<Service> getServices() {
        return this.services;
    }

    public int hashCode() {
        return (this.metadata.hashCode() * 31) + this.services.hashCode();
    }

    @NotNull
    public String toString() {
        Metadata metadata2 = this.metadata;
        List<Service> list = this.services;
        return "AIRequest(metadata=" + metadata2 + ", services=" + list + ")";
    }

    @Keep
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/repo/AIRequest$Metadata;", "", "accountId", "", "appName", "functionType", "", "terminalTraceId", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getAccountId", "()Ljava/lang/String;", "getAppName", "getFunctionType", "()I", "getTerminalTraceId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Metadata {
        @NotNull
        private final String accountId;
        @NotNull
        private final String appName;
        private final int functionType;
        @NotNull
        private final String terminalTraceId;

        public Metadata(@NotNull String str, @NotNull String str2, int i, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "accountId");
            Intrinsics.checkNotNullParameter(str2, "appName");
            Intrinsics.checkNotNullParameter(str3, "terminalTraceId");
            this.accountId = str;
            this.appName = str2;
            this.functionType = i;
            this.terminalTraceId = str3;
        }

        public static /* synthetic */ Metadata copy$default(Metadata metadata, String str, String str2, int i, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = metadata.accountId;
            }
            if ((i2 & 2) != 0) {
                str2 = metadata.appName;
            }
            if ((i2 & 4) != 0) {
                i = metadata.functionType;
            }
            if ((i2 & 8) != 0) {
                str3 = metadata.terminalTraceId;
            }
            return metadata.copy(str, str2, i, str3);
        }

        @NotNull
        public final String component1() {
            return this.accountId;
        }

        @NotNull
        public final String component2() {
            return this.appName;
        }

        public final int component3() {
            return this.functionType;
        }

        @NotNull
        public final String component4() {
            return this.terminalTraceId;
        }

        @NotNull
        public final Metadata copy(@NotNull String str, @NotNull String str2, int i, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "accountId");
            Intrinsics.checkNotNullParameter(str2, "appName");
            Intrinsics.checkNotNullParameter(str3, "terminalTraceId");
            return new Metadata(str, str2, i, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Metadata)) {
                return false;
            }
            Metadata metadata = (Metadata) obj;
            return Intrinsics.areEqual((Object) this.accountId, (Object) metadata.accountId) && Intrinsics.areEqual((Object) this.appName, (Object) metadata.appName) && this.functionType == metadata.functionType && Intrinsics.areEqual((Object) this.terminalTraceId, (Object) metadata.terminalTraceId);
        }

        @NotNull
        public final String getAccountId() {
            return this.accountId;
        }

        @NotNull
        public final String getAppName() {
            return this.appName;
        }

        public final int getFunctionType() {
            return this.functionType;
        }

        @NotNull
        public final String getTerminalTraceId() {
            return this.terminalTraceId;
        }

        public int hashCode() {
            return (((((this.accountId.hashCode() * 31) + this.appName.hashCode()) * 31) + Integer.hashCode(this.functionType)) * 31) + this.terminalTraceId.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.accountId;
            String str2 = this.appName;
            int i = this.functionType;
            String str3 = this.terminalTraceId;
            return "Metadata(accountId=" + str + ", appName=" + str2 + ", functionType=" + i + ", terminalTraceId=" + str3 + ")";
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Metadata(java.lang.String r1, java.lang.String r2, int r3, java.lang.String r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
            /*
                r0 = this;
                r6 = r5 & 2
                if (r6 == 0) goto L_0x0006
                java.lang.String r2 = "com.upuphone.ar.transcribe"
            L_0x0006:
                r6 = r5 & 4
                if (r6 == 0) goto L_0x000b
                r3 = 4
            L_0x000b:
                r5 = r5 & 8
                if (r5 == 0) goto L_0x001d
                java.util.UUID r4 = java.util.UUID.randomUUID()
                java.lang.String r4 = r4.toString()
                java.lang.String r5 = "toString(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            L_0x001d:
                r0.<init>(r1, r2, r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.repo.AIRequest.Metadata.<init>(java.lang.String, java.lang.String, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
