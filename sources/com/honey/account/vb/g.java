package com.honey.account.vb;

import java.util.concurrent.ThreadFactory;
import org.apache.commons.io.input.ReadAheadInputStream;

public final /* synthetic */ class g implements ThreadFactory {
    public final Thread newThread(Runnable runnable) {
        return ReadAheadInputStream.newThread(runnable);
    }
}
