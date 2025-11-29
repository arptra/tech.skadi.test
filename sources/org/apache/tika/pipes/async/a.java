package org.apache.tika.pipes.async;

import java.util.function.Function;
import org.apache.tika.pipes.async.AsyncEmitter;

public final /* synthetic */ class a implements Function {
    public final Object apply(Object obj) {
        return AsyncEmitter.EmitDataCache.e((String) obj);
    }
}
