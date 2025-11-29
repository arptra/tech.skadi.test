package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class RealisticView {
    @NonNull
    public String junctionViewSvgImageContent;
    @NonNull
    public String signpostSvgImageContent;

    public RealisticView(@NonNull String str, @NonNull String str2) {
        this.junctionViewSvgImageContent = str;
        this.signpostSvgImageContent = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RealisticView)) {
            return false;
        }
        RealisticView realisticView = (RealisticView) obj;
        return Objects.equals(this.junctionViewSvgImageContent, realisticView.junctionViewSvgImageContent) && Objects.equals(this.signpostSvgImageContent, realisticView.signpostSvgImageContent);
    }

    public int hashCode() {
        String str = this.junctionViewSvgImageContent;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.signpostSvgImageContent;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }
}
