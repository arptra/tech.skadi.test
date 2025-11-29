package com.here.sdk.search;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class LandlinePhone {
    @NonNull
    public List<PlaceCategory> categories;
    @NonNull
    public String phoneNumber;

    public LandlinePhone() {
        this.phoneNumber = "";
        this.categories = new ArrayList();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LandlinePhone)) {
            return false;
        }
        LandlinePhone landlinePhone = (LandlinePhone) obj;
        return Objects.equals(this.phoneNumber, landlinePhone.phoneNumber) && Objects.equals(this.categories, landlinePhone.categories);
    }

    public int hashCode() {
        String str = this.phoneNumber;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        List<PlaceCategory> list = this.categories;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public LandlinePhone(@NonNull String str, @NonNull List<PlaceCategory> list) {
        this.phoneNumber = str;
        this.categories = list;
    }
}
