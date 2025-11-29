package com.here.sdk.location;

import androidx.annotation.NonNull;
import java.util.List;

public interface LocationIssueListener {
    void onLocationIssueChanged(@NonNull List<LocationIssueType> list);
}
