package com.here.sdk.search;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class WebDetails {
    @NonNull
    public List<WebEditorial> editorials = new ArrayList();
    @NonNull
    public List<WebImage> images = new ArrayList();
    @NonNull
    public List<WebRating> ratings = new ArrayList();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WebDetails)) {
            return false;
        }
        WebDetails webDetails = (WebDetails) obj;
        return Objects.equals(this.images, webDetails.images) && Objects.equals(this.editorials, webDetails.editorials) && Objects.equals(this.ratings, webDetails.ratings);
    }

    public int hashCode() {
        List<WebImage> list = this.images;
        int i = 0;
        int hashCode = (217 + (list != null ? list.hashCode() : 0)) * 31;
        List<WebEditorial> list2 = this.editorials;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<WebRating> list3 = this.ratings;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode2 + i;
    }
}
