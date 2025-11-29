package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class CertificateSettings {
    @NonNull
    public String certFileBlob;
    @NonNull
    public String clientCertFileBlob;
    @NonNull
    public String clientKeyFileBlob;

    public CertificateSettings(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        this.clientCertFileBlob = str;
        this.clientKeyFileBlob = str2;
        this.certFileBlob = str3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CertificateSettings)) {
            return false;
        }
        CertificateSettings certificateSettings = (CertificateSettings) obj;
        return Objects.equals(this.clientCertFileBlob, certificateSettings.clientCertFileBlob) && Objects.equals(this.clientKeyFileBlob, certificateSettings.clientKeyFileBlob) && Objects.equals(this.certFileBlob, certificateSettings.certFileBlob);
    }

    public int hashCode() {
        String str = this.clientCertFileBlob;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.clientKeyFileBlob;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.certFileBlob;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }
}
