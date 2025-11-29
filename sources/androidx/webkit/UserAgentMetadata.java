package androidx.webkit;

import com.meizu.common.widget.MzContactsContract;
import java.util.List;
import java.util.Objects;

public final class UserAgentMetadata {

    /* renamed from: a  reason: collision with root package name */
    public final List f1957a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public boolean g;
    public int h;
    public boolean i;

    public static final class BrandVersion {

        /* renamed from: a  reason: collision with root package name */
        public final String f1958a;
        public final String b;
        public final String c;

        public static final class Builder {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BrandVersion)) {
                return false;
            }
            BrandVersion brandVersion = (BrandVersion) obj;
            return Objects.equals(this.f1958a, brandVersion.f1958a) && Objects.equals(this.b, brandVersion.b) && Objects.equals(this.c, brandVersion.c);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f1958a, this.b, this.c});
        }

        public String toString() {
            return this.f1958a + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + this.b + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + this.c;
        }
    }

    public static final class Builder {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserAgentMetadata)) {
            return false;
        }
        UserAgentMetadata userAgentMetadata = (UserAgentMetadata) obj;
        return this.g == userAgentMetadata.g && this.h == userAgentMetadata.h && this.i == userAgentMetadata.i && Objects.equals(this.f1957a, userAgentMetadata.f1957a) && Objects.equals(this.b, userAgentMetadata.b) && Objects.equals(this.c, userAgentMetadata.c) && Objects.equals(this.d, userAgentMetadata.d) && Objects.equals(this.e, userAgentMetadata.e) && Objects.equals(this.f, userAgentMetadata.f);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f1957a, this.b, this.c, this.d, this.e, this.f, Boolean.valueOf(this.g), Integer.valueOf(this.h), Boolean.valueOf(this.i)});
    }
}
