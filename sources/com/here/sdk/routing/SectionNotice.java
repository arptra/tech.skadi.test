package com.here.sdk.routing;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class SectionNotice {
    @NonNull
    public SectionNoticeCode code;
    @NonNull
    public NoticeSeverity severity;
    @NonNull
    public List<ViolatedRestriction> violatedRestrictions = new ArrayList();

    public SectionNotice(@NonNull SectionNoticeCode sectionNoticeCode, @NonNull NoticeSeverity noticeSeverity) {
        this.code = sectionNoticeCode;
        this.severity = noticeSeverity;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SectionNotice)) {
            return false;
        }
        SectionNotice sectionNotice = (SectionNotice) obj;
        return Objects.equals(this.code, sectionNotice.code) && Objects.equals(this.severity, sectionNotice.severity) && Objects.equals(this.violatedRestrictions, sectionNotice.violatedRestrictions);
    }

    public int hashCode() {
        SectionNoticeCode sectionNoticeCode = this.code;
        int i = 0;
        int hashCode = (217 + (sectionNoticeCode != null ? sectionNoticeCode.hashCode() : 0)) * 31;
        NoticeSeverity noticeSeverity = this.severity;
        int hashCode2 = (hashCode + (noticeSeverity != null ? noticeSeverity.hashCode() : 0)) * 31;
        List<ViolatedRestriction> list = this.violatedRestrictions;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }
}
