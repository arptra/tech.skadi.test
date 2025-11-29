package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.Phonemetadata;

interface MetadataContainer {
    void accept(Phonemetadata.PhoneMetadata phoneMetadata);
}
