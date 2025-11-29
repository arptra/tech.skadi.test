package com.here.sdk.search;

import androidx.annotation.Nullable;
import java.util.List;

@FunctionalInterface
public interface SearchCallbackExtended {
    void onSearchExtendedCompleted(@Nullable SearchError searchError, @Nullable List<Place> list, @Nullable ResponseDetails responseDetails);
}
