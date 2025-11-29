package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.Phonemetadata;

public interface FormattingMetadataSource {
    Phonemetadata.PhoneMetadata getFormattingMetadataForCountryCallingCode(int i);
}
