package com.honey.account.dc;

import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;

public final /* synthetic */ class e implements FailableConsumer {
    public final void accept(Object obj) {
        Failable.rethrow((Throwable) obj);
    }
}
