package com.honey.account.sb;

import java.util.function.Predicate;
import org.apache.commons.io.file.DeleteOption;
import org.apache.commons.io.file.PathUtils;

public final /* synthetic */ class e implements Predicate {
    public final boolean test(Object obj) {
        return PathUtils.lambda$overrideReadOnly$1((DeleteOption) obj);
    }
}
