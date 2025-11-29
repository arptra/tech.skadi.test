package com.here.sdk.search;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class ResponseDetails {
    @NonNull
    public String correlationId;
    @NonNull
    public String requestId;

    public ResponseDetails(@NonNull String str, @NonNull String str2) {
        this.correlationId = str;
        this.requestId = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseDetails)) {
            return false;
        }
        ResponseDetails responseDetails = (ResponseDetails) obj;
        return Objects.equals(this.correlationId, responseDetails.correlationId) && Objects.equals(this.requestId, responseDetails.requestId);
    }

    public int hashCode() {
        String str = this.correlationId;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.requestId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }
}
