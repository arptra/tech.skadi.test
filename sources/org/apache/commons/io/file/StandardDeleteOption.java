package org.apache.commons.io.file;

import org.apache.commons.io.IOUtils;

public enum StandardDeleteOption implements DeleteOption {
    OVERRIDE_READ_ONLY;

    public static boolean overrideReadOnly(DeleteOption[] deleteOptionArr) {
        if (IOUtils.length((Object[]) deleteOptionArr) == 0) {
            return false;
        }
        for (StandardDeleteOption standardDeleteOption : deleteOptionArr) {
            if (standardDeleteOption == OVERRIDE_READ_ONLY) {
                return true;
            }
        }
        return false;
    }
}
