package com.here.sdk.routing;

import androidx.annotation.NonNull;
import com.here.sdk.core.LanguageCode;
import com.here.sdk.core.TextFormat;
import com.here.sdk.core.UnitSystem;
import java.util.Objects;

public final class RouteTextOptions {
    @NonNull
    @Deprecated
    public TextFormat instructionFormat = TextFormat.PLAIN;
    @NonNull
    public LanguageCode language = LanguageCode.EN_US;
    @NonNull
    public UnitSystem unitSystem = UnitSystem.METRIC;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteTextOptions)) {
            return false;
        }
        RouteTextOptions routeTextOptions = (RouteTextOptions) obj;
        return Objects.equals(this.language, routeTextOptions.language) && Objects.equals(this.instructionFormat, routeTextOptions.instructionFormat) && Objects.equals(this.unitSystem, routeTextOptions.unitSystem);
    }

    public int hashCode() {
        LanguageCode languageCode = this.language;
        int i = 0;
        int hashCode = (217 + (languageCode != null ? languageCode.hashCode() : 0)) * 31;
        TextFormat textFormat = this.instructionFormat;
        int hashCode2 = (hashCode + (textFormat != null ? textFormat.hashCode() : 0)) * 31;
        UnitSystem unitSystem2 = this.unitSystem;
        if (unitSystem2 != null) {
            i = unitSystem2.hashCode();
        }
        return hashCode2 + i;
    }
}
