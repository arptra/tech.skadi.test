package com.here.sdk.search;

import androidx.annotation.NonNull;
import java.util.Date;
import java.util.Objects;

public final class WebImage {
    @NonNull
    public Date date;
    @NonNull
    public WebSource source;

    public WebImage(@NonNull Date date2, @NonNull WebSource webSource) {
        this.date = date2;
        this.source = webSource;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return Objects.equals(this.date, webImage.date) && Objects.equals(this.source, webImage.source);
    }

    public int hashCode() {
        Date date2 = this.date;
        int i = 0;
        int hashCode = (217 + (date2 != null ? date2.hashCode() : 0)) * 31;
        WebSource webSource = this.source;
        if (webSource != null) {
            i = webSource.hashCode();
        }
        return hashCode + i;
    }
}
