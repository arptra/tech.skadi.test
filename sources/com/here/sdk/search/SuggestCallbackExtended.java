package com.here.sdk.search;

import androidx.annotation.Nullable;
import java.util.List;

@FunctionalInterface
public interface SuggestCallbackExtended {
    void onSuggestExtendedCompleted(@Nullable SearchError searchError, @Nullable List<Suggestion> list, @Nullable ResponseDetails responseDetails);
}
