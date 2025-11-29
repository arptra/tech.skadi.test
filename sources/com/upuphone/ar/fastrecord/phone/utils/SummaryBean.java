package com.upuphone.ar.fastrecord.phone.utils;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/SummaryBean;", "", "()V", "payload", "Lcom/upuphone/ar/fastrecord/phone/utils/SummaryBean$PayLoad;", "getPayload", "()Lcom/upuphone/ar/fastrecord/phone/utils/SummaryBean$PayLoad;", "setPayload", "(Lcom/upuphone/ar/fastrecord/phone/utils/SummaryBean$PayLoad;)V", "recognizeId", "", "getRecognizeId", "()Ljava/lang/String;", "setRecognizeId", "(Ljava/lang/String;)V", "requestId", "getRequestId", "setRequestId", "type", "getType", "setType", "PayLoad", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public class SummaryBean {
    @Nullable
    private PayLoad payload;
    @NotNull
    private String recognizeId = "";
    @NotNull
    private String requestId = "";
    @NotNull
    private String type = "";

    @Keep
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/SummaryBean$PayLoad;", "", "()V", "requestId", "", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "requestStatus", "getRequestStatus", "setRequestStatus", "riskDescription", "getRiskDescription", "setRiskDescription", "riskLevel", "getRiskLevel", "setRiskLevel", "summary", "getSummary", "setSummary", "version_code", "getVersion_code", "setVersion_code", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PayLoad {
        @NotNull
        private String requestId = "";
        @NotNull
        private String requestStatus = "";
        @NotNull
        private String riskDescription = "";
        @NotNull
        private String riskLevel = "";
        @NotNull
        private String summary = "";
        @NotNull
        private String version_code = "";

        @NotNull
        public final String getRequestId() {
            return this.requestId;
        }

        @NotNull
        public final String getRequestStatus() {
            return this.requestStatus;
        }

        @NotNull
        public final String getRiskDescription() {
            return this.riskDescription;
        }

        @NotNull
        public final String getRiskLevel() {
            return this.riskLevel;
        }

        @NotNull
        public final String getSummary() {
            return this.summary;
        }

        @NotNull
        public final String getVersion_code() {
            return this.version_code;
        }

        public final void setRequestId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.requestId = str;
        }

        public final void setRequestStatus(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.requestStatus = str;
        }

        public final void setRiskDescription(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.riskDescription = str;
        }

        public final void setRiskLevel(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.riskLevel = str;
        }

        public final void setSummary(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.summary = str;
        }

        public final void setVersion_code(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.version_code = str;
        }
    }

    @Nullable
    public final PayLoad getPayload() {
        return this.payload;
    }

    @NotNull
    public final String getRecognizeId() {
        return this.recognizeId;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final void setPayload(@Nullable PayLoad payLoad) {
        this.payload = payLoad;
    }

    public final void setRecognizeId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.recognizeId = str;
    }

    public final void setRequestId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestId = str;
    }

    public final void setType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }
}
