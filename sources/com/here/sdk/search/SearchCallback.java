package com.here.sdk.search;

import androidx.annotation.Nullable;
import java.util.List;

@FunctionalInterface
public interface SearchCallback {
    void onSearchCompleted(@Nullable SearchError searchError, @Nullable List<Place> list);
}
