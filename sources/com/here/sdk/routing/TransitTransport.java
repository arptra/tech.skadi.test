package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.Color;

public final class TransitTransport {
    @Nullable
    public String category;
    @Nullable
    public Color color;
    @Nullable
    public String headsign;
    @NonNull
    public TransitMode mode;
    @Nullable
    public String name;
    @Nullable
    public Color textColor;

    public TransitTransport(@NonNull TransitMode transitMode, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Color color2, @Nullable Color color3) {
        this.mode = transitMode;
        this.name = str;
        this.headsign = str2;
        this.category = str3;
        this.color = color2;
        this.textColor = color3;
    }
}
