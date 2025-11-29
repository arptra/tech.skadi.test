package com.here.sdk.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;
import java.util.Objects;

public final class LocalizedText {
    @Nullable
    public Locale locale;
    @NonNull
    public String text;

    public LocalizedText(@NonNull String str, @Nullable Locale locale2) {
        this.text = str;
        this.locale = locale2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalizedText)) {
            return false;
        }
        LocalizedText localizedText = (LocalizedText) obj;
        return Objects.equals(this.text, localizedText.text) && Objects.equals(this.locale, localizedText.locale);
    }

    public int hashCode() {
        String str = this.text;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        Locale locale2 = this.locale;
        if (locale2 != null) {
            i = locale2.hashCode();
        }
        return hashCode + i;
    }
}
