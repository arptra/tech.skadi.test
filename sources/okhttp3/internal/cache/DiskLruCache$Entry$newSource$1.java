package okhttp3.internal.cache;

import kotlin.Metadata;
import kotlin.Unit;
import okhttp3.internal.cache.DiskLruCache;
import okio.ForwardingSource;
import okio.Source;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"okhttp3/internal/cache/DiskLruCache$Entry$newSource$1", "Lokio/ForwardingSource;", "closed", "", "close", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DiskLruCache$Entry$newSource$1 extends ForwardingSource {
    private boolean closed;
    final /* synthetic */ DiskLruCache this$0;
    final /* synthetic */ DiskLruCache.Entry this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DiskLruCache$Entry$newSource$1(Source source, DiskLruCache diskLruCache, DiskLruCache.Entry entry) {
        super(source);
        this.this$0 = diskLruCache;
        this.this$1 = entry;
    }

    public void close() {
        super.close();
        if (!this.closed) {
            this.closed = true;
            DiskLruCache diskLruCache = this.this$0;
            DiskLruCache.Entry entry = this.this$1;
            synchronized (diskLruCache) {
                try {
                    entry.setLockingSourceCount$okhttp(entry.getLockingSourceCount$okhttp() - 1);
                    if (entry.getLockingSourceCount$okhttp() == 0 && entry.getZombie$okhttp()) {
                        diskLruCache.removeEntry$okhttp(entry);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
