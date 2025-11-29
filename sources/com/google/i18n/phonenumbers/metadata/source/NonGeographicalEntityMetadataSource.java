package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.Phonemetadata;

public interface NonGeographicalEntityMetadataSource {
    Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int i);
}
