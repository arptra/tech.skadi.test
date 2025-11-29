package com.here.sdk.search;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class MobilePhone {
    @NonNull
    public List<PlaceCategory> categories;
    @NonNull
    public String phoneNumber;

    public MobilePhone() {
        this.phoneNumber = "";
        this.categories = new ArrayList();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MobilePhone)) {
            return false;
        }
        MobilePhone mobilePhone = (MobilePhone) obj;
        return Objects.equals(this.phoneNumber, mobilePhone.phoneNumber) && Objects.equals(this.categories, mobilePhone.categories);
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

    public MobilePhone(@NonNull String str, @NonNull List<PlaceCategory> list) {
        this.phoneNumber = str;
        this.categories = list;
    }
}
