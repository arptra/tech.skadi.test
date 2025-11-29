package com.here.sdk.core;

import androidx.annotation.NonNull;
import com.here.time.Duration;
import java.util.Objects;

public final class AuthenticationData {
    @NonNull
    public Duration expiryTime = Duration.ofSeconds(0);
    @NonNull
    public String token = "";

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthenticationData)) {
            return false;
        }
        AuthenticationData authenticationData = (AuthenticationData) obj;
        return Objects.equals(this.token, authenticationData.token) && Objects.equals(this.expiryTime, authenticationData.expiryTime);
    }

    public int hashCode() {
        String str = this.token;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        Duration duration = this.expiryTime;
        if (duration != null) {
            i = duration.hashCode();
        }
        return hashCode + i;
    }
}
