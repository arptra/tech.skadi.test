package com.here.sdk.search;

import androidx.annotation.Nullable;
import java.util.List;

@FunctionalInterface
public interface SuggestCallback {
    void onSuggestCompleted(@Nullable SearchError searchError, @Nullable List<Suggestion> list);
}
