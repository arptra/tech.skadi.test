package com.here.sdk.trafficbroadcast;

import androidx.annotation.NonNull;
import java.util.List;

public interface TMCServiceInterface {
    @NonNull
    List<RDSEncryptionKey> getRDSEncryptionKeys(@NonNull RDSEncryptionKeysRequest rDSEncryptionKeysRequest);

    @NonNull
    List<Short> getTMCPreferredSids(@NonNull TMCPreferredSidsRequest tMCPreferredSidsRequest);

    void requestTMCService(@NonNull TMCServiceRequest tMCServiceRequest);
}
