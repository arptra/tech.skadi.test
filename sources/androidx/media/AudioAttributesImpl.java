package androidx.media;

import androidx.versionedparcelable.VersionedParcelable;

interface AudioAttributesImpl extends VersionedParcelable {

    public interface Builder {
        Builder a(int i);

        Builder b(int i);

        AudioAttributesImpl build();
    }

    int a();
}
