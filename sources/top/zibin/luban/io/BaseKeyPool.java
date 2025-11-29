package top.zibin.luban.io;

import java.util.ArrayDeque;
import java.util.Queue;
import top.zibin.luban.io.PoolAble;

abstract class BaseKeyPool<T extends PoolAble> {

    /* renamed from: a  reason: collision with root package name */
    public final Queue f3587a = b(20);

    public static Queue b(int i) {
        return new ArrayDeque(i);
    }

    public abstract PoolAble a();

    public PoolAble c() {
        PoolAble poolAble = (PoolAble) this.f3587a.poll();
        return poolAble == null ? a() : poolAble;
    }

    public void d(PoolAble poolAble) {
        if (this.f3587a.size() < 20) {
            this.f3587a.offer(poolAble);
        }
    }
}
