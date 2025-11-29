package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class Agency {
    @NonNull
    String id;
    @NonNull
    public String name;
    @Nullable
    public String website;

    public Agency(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        this.id = str;
        this.name = str2;
        this.website = str3;
    }
}
