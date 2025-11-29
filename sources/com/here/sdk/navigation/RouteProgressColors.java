package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.sdk.core.Color;
import com.here.sdk.core.NamedColor;

public final class RouteProgressColors {
    @NonNull
    public Color ahead;
    @NonNull
    public Color behind;
    @NonNull
    public Color offRoad = NamedColor.WHITE;
    @NonNull
    public Color outlineAhead;
    @NonNull
    public Color outlineBehind;

    public RouteProgressColors(@NonNull Color color, @NonNull Color color2, @NonNull Color color3, @NonNull Color color4) {
        this.ahead = color;
        this.behind = color2;
        this.outlineAhead = color3;
        this.outlineBehind = color4;
    }
}
