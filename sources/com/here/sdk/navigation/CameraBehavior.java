package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.sdk.core.Anchor2D;

public interface CameraBehavior {
    @NonNull
    Anchor2D getNormalizedPrincipalPoint();

    void setNormalizedPrincipalPoint(@NonNull Anchor2D anchor2D);
}
