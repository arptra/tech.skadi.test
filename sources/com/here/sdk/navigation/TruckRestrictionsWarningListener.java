package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.List;

public interface TruckRestrictionsWarningListener {
    void onTruckRestrictionsWarningUpdated(@NonNull List<TruckRestrictionWarning> list);
}
