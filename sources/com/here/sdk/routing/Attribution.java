package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class Attribution {
    @Nullable
    public String href = null;
    @Nullable
    public String hrefText;
    @NonNull
    String id;
    @NonNull
    public String text;
    @NonNull
    public AttributionType type;

    public Attribution(@NonNull String str, @NonNull String str2, @NonNull AttributionType attributionType) {
        this.id = str;
        this.text = str2;
        this.hrefText = null;
        this.type = attributionType;
    }
}
