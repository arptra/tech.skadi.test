package org.apache.tika.pipes.pipesiterator;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.tika.pipes.FetchEmitTuple;

public class CallablePipesIterator implements Callable<Long> {

    /* renamed from: a  reason: collision with root package name */
    public final PipesIterator f3306a;
    public final ArrayBlockingQueue b;
    public final long c;
    public final int d;

    /* renamed from: a */
    public Long call() {
        long j = 0;
        int i = 0;
        if (this.c > 0) {
            Iterator it = this.f3306a.iterator();
            while (it.hasNext()) {
                if (this.b.offer((FetchEmitTuple) it.next(), this.c, TimeUnit.MILLISECONDS)) {
                    j++;
                } else {
                    throw new TimeoutException("timed out trying to offer tuple");
                }
            }
            while (i < this.d) {
                if (this.b.offer(PipesIterator.m)) {
                    i++;
                } else {
                    throw new TimeoutException("timed out trying to offer tuple");
                }
            }
        } else {
            Iterator it2 = this.f3306a.iterator();
            while (it2.hasNext()) {
                this.b.put((FetchEmitTuple) it2.next());
                j++;
            }
            while (i < this.d) {
                this.b.put(PipesIterator.m);
                i++;
            }
        }
        return Long.valueOf(j);
    }
}
