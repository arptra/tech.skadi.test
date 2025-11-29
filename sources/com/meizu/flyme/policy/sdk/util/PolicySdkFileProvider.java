package com.meizu.flyme.policy.sdk.util;

import androidx.core.content.FileProvider;
import com.meizu.flyme.policy.sdk.R;

public class PolicySdkFileProvider extends FileProvider {
    public PolicySdkFileProvider() {
        super(R.xml.policy_sdk_file_paths);
    }
}
