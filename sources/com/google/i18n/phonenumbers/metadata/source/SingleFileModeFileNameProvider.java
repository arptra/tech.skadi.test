package com.google.i18n.phonenumbers.metadata.source;

public final class SingleFileModeFileNameProvider implements PhoneMetadataFileNameProvider {
    private final String phoneMetadataFileName;

    public SingleFileModeFileNameProvider(String str) {
        this.phoneMetadataFileName = str;
    }

    public String getFor(Object obj) {
        return this.phoneMetadataFileName;
    }
}
