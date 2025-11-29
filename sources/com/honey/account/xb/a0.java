package com.honey.account.xb;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.function.ToBooleanBiFunction;

public final /* synthetic */ class a0 implements ToBooleanBiFunction {
    public final boolean applyAsBoolean(Object obj, Object obj2) {
        return StringUtils.contains((CharSequence) obj, (CharSequence) obj2);
    }
}
