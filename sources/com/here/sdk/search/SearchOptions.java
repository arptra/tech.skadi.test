package com.here.sdk.search;

import androidx.annotation.Nullable;
import com.here.sdk.core.LanguageCode;
import java.util.Objects;

public final class SearchOptions {
    @Nullable
    public LanguageCode languageCode = null;
    @Nullable
    public Integer maxItems = null;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchOptions)) {
            return false;
        }
        SearchOptions searchOptions = (SearchOptions) obj;
        return Objects.equals(this.languageCode, searchOptions.languageCode) && Objects.equals(this.maxItems, searchOptions.maxItems);
    }

    public int hashCode() {
        LanguageCode languageCode2 = this.languageCode;
        int i = 0;
        int hashCode = (217 + (languageCode2 != null ? languageCode2.hashCode() : 0)) * 31;
        Integer num = this.maxItems;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }
}
