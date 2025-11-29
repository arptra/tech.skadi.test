package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DecodeJob<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<DecodeJob<?>>, FactoryPools.Poolable {
    public DataSource A;
    public DataFetcher B;
    public volatile DataFetcherGenerator C;
    public volatile boolean D;
    public volatile boolean E;
    public boolean F;

    /* renamed from: a  reason: collision with root package name */
    public final DecodeHelper f2475a = new DecodeHelper();
    public final List b = new ArrayList();
    public final StateVerifier c = StateVerifier.a();
    public final DiskCacheProvider d;
    public final Pools.Pool e;
    public final DeferredEncodeManager f = new DeferredEncodeManager();
    public final ReleaseManager g = new ReleaseManager();
    public GlideContext h;
    public Key i;
    public Priority j;
    public EngineKey k;
    public int l;
    public int m;
    public DiskCacheStrategy n;
    public Options o;
    public Callback p;
    public int q;
    public Stage r;
    public RunReason s;
    public long t;
    public boolean u;
    public Object v;
    public Thread w;
    public Key x;
    public Key y;
    public Object z;

    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2476a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
        static {
            /*
                com.bumptech.glide.load.EncodeStrategy[] r0 = com.bumptech.glide.load.EncodeStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                c = r0
                r1 = 1
                com.bumptech.glide.load.EncodeStrategy r2 = com.bumptech.glide.load.EncodeStrategy.SOURCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bumptech.glide.load.EncodeStrategy r3 = com.bumptech.glide.load.EncodeStrategy.TRANSFORMED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.bumptech.glide.load.engine.DecodeJob$Stage[] r2 = com.bumptech.glide.load.engine.DecodeJob.Stage.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                b = r2
                com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.DATA_CACHE     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                r2 = 3
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.SOURCE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x004e }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.FINISHED     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                com.bumptech.glide.load.engine.DecodeJob$RunReason[] r3 = com.bumptech.glide.load.engine.DecodeJob.RunReason.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f2476a = r3
                com.bumptech.glide.load.engine.DecodeJob$RunReason r4 = com.bumptech.glide.load.engine.DecodeJob.RunReason.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x006a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x006a }
            L_0x006a:
                int[] r1 = f2476a     // Catch:{ NoSuchFieldError -> 0x0074 }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r3 = com.bumptech.glide.load.engine.DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                int[] r0 = f2476a     // Catch:{ NoSuchFieldError -> 0x007e }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r1 = com.bumptech.glide.load.engine.DecodeJob.RunReason.DECODE_DATA     // Catch:{ NoSuchFieldError -> 0x007e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.AnonymousClass1.<clinit>():void");
        }
    }

    public interface Callback<R> {
        void b(GlideException glideException);

        void c(Resource resource, DataSource dataSource, boolean z);

        void d(DecodeJob decodeJob);
    }

    public final class DecodeCallback<Z> implements DecodePath.DecodeCallback<Z> {

        /* renamed from: a  reason: collision with root package name */
        public final DataSource f2477a;

        public DecodeCallback(DataSource dataSource) {
            this.f2477a = dataSource;
        }

        public Resource a(Resource resource) {
            return DecodeJob.this.y(this.f2477a, resource);
        }
    }

    public static class DeferredEncodeManager<Z> {

        /* renamed from: a  reason: collision with root package name */
        public Key f2478a;
        public ResourceEncoder b;
        public LockedResource c;

        public void a() {
            this.f2478a = null;
            this.b = null;
            this.c = null;
        }

        public void b(DiskCacheProvider diskCacheProvider, Options options) {
            GlideTrace.a("DecodeJob.encode");
            try {
                diskCacheProvider.a().a(this.f2478a, new DataCacheWriter(this.b, this.c, options));
            } finally {
                this.c.h();
                GlideTrace.e();
            }
        }

        public boolean c() {
            return this.c != null;
        }

        public void d(Key key, ResourceEncoder resourceEncoder, LockedResource lockedResource) {
            this.f2478a = key;
            this.b = resourceEncoder;
            this.c = lockedResource;
        }
    }

    public interface DiskCacheProvider {
        DiskCache a();
    }

    public static class ReleaseManager {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2479a;
        public boolean b;
        public boolean c;

        public final boolean a(boolean z) {
            return (this.c || z || this.b) && this.f2479a;
        }

        public synchronized boolean b() {
            this.b = true;
            return a(false);
        }

        public synchronized boolean c() {
            this.c = true;
            return a(false);
        }

        public synchronized boolean d(boolean z) {
            this.f2479a = true;
            return a(z);
        }

        public synchronized void e() {
            this.b = false;
            this.f2479a = false;
            this.c = false;
        }
    }

    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public DecodeJob(DiskCacheProvider diskCacheProvider, Pools.Pool pool) {
        this.d = diskCacheProvider;
        this.e = pool;
    }

    public final void A() {
        this.g.e();
        this.f.a();
        this.f2475a.a();
        this.D = false;
        this.h = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0;
        this.E = false;
        this.v = null;
        this.b.clear();
        this.e.a(this);
    }

    public final void B(RunReason runReason) {
        this.s = runReason;
        this.p.d(this);
    }

    public final void C() {
        this.w = Thread.currentThread();
        this.t = LogTime.b();
        boolean z2 = false;
        while (!this.E && this.C != null && !(z2 = this.C.a())) {
            this.r = n(this.r);
            this.C = m();
            if (this.r == Stage.SOURCE) {
                B(RunReason.SWITCH_TO_SOURCE_SERVICE);
                return;
            }
        }
        if ((this.r == Stage.FINISHED || this.E) && !z2) {
            v();
        }
    }

    public final Resource D(Object obj, DataSource dataSource, LoadPath loadPath) {
        Options o2 = o(dataSource);
        DataRewinder l2 = this.h.i().l(obj);
        try {
            return loadPath.a(l2, o2, this.l, this.m, new DecodeCallback(dataSource));
        } finally {
            l2.b();
        }
    }

    public final void E() {
        int i2 = AnonymousClass1.f2476a[this.s.ordinal()];
        if (i2 == 1) {
            this.r = n(Stage.INITIALIZE);
            this.C = m();
            C();
        } else if (i2 == 2) {
            C();
        } else if (i2 == 3) {
            l();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.s);
        }
    }

    public final void F() {
        Throwable th;
        this.c.c();
        if (this.D) {
            if (this.b.isEmpty()) {
                th = null;
            } else {
                List list = this.b;
                th = (Throwable) list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.D = true;
    }

    public boolean G() {
        Stage n2 = n(Stage.INITIALIZE);
        return n2 == Stage.RESOURCE_CACHE || n2 == Stage.DATA_CACHE;
    }

    public void b(Key key, Exception exc, DataFetcher dataFetcher, DataSource dataSource) {
        dataFetcher.b();
        GlideException glideException = new GlideException("Fetching data failed", (Throwable) exc);
        glideException.setLoggingDetails(key, dataSource, dataFetcher.a());
        this.b.add(glideException);
        if (Thread.currentThread() != this.w) {
            B(RunReason.SWITCH_TO_SOURCE_SERVICE);
        } else {
            C();
        }
    }

    public void d() {
        B(RunReason.SWITCH_TO_SOURCE_SERVICE);
    }

    public StateVerifier f() {
        return this.c;
    }

    public void g(Key key, Object obj, DataFetcher dataFetcher, DataSource dataSource, Key key2) {
        this.x = key;
        this.z = obj;
        this.B = dataFetcher;
        this.A = dataSource;
        this.y = key2;
        boolean z2 = false;
        if (key != this.f2475a.c().get(0)) {
            z2 = true;
        }
        this.F = z2;
        if (Thread.currentThread() != this.w) {
            B(RunReason.DECODE_DATA);
            return;
        }
        GlideTrace.a("DecodeJob.decodeFromRetrievedData");
        try {
            l();
        } finally {
            GlideTrace.e();
        }
    }

    public void h() {
        this.E = true;
        DataFetcherGenerator dataFetcherGenerator = this.C;
        if (dataFetcherGenerator != null) {
            dataFetcherGenerator.cancel();
        }
    }

    /* renamed from: i */
    public int compareTo(DecodeJob decodeJob) {
        int p2 = p() - decodeJob.p();
        return p2 == 0 ? this.q - decodeJob.q : p2;
    }

    public final Resource j(DataFetcher dataFetcher, Object obj, DataSource dataSource) {
        if (obj == null) {
            dataFetcher.b();
            return null;
        }
        try {
            long b2 = LogTime.b();
            Resource k2 = k(obj, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                r("Decoded result " + k2, b2);
            }
            return k2;
        } finally {
            dataFetcher.b();
        }
    }

    public final Resource k(Object obj, DataSource dataSource) {
        return D(obj, dataSource, this.f2475a.h(obj.getClass()));
    }

    public final void l() {
        Resource resource;
        if (Log.isLoggable("DecodeJob", 2)) {
            long j2 = this.t;
            s("Retrieved data", j2, "data: " + this.z + ", cache key: " + this.x + ", fetcher: " + this.B);
        }
        try {
            resource = j(this.B, this.z, this.A);
        } catch (GlideException e2) {
            e2.setLoggingDetails(this.y, this.A);
            this.b.add(e2);
            resource = null;
        }
        if (resource != null) {
            u(resource, this.A, this.F);
        } else {
            C();
        }
    }

    public final DataFetcherGenerator m() {
        int i2 = AnonymousClass1.b[this.r.ordinal()];
        if (i2 == 1) {
            return new ResourceCacheGenerator(this.f2475a, this);
        }
        if (i2 == 2) {
            return new DataCacheGenerator(this.f2475a, this);
        }
        if (i2 == 3) {
            return new SourceGenerator(this.f2475a, this);
        }
        if (i2 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.r);
    }

    public final Stage n(Stage stage) {
        int i2 = AnonymousClass1.b[stage.ordinal()];
        if (i2 == 1) {
            return this.n.a() ? Stage.DATA_CACHE : n(Stage.DATA_CACHE);
        }
        if (i2 == 2) {
            return this.u ? Stage.FINISHED : Stage.SOURCE;
        }
        if (i2 == 3 || i2 == 4) {
            return Stage.FINISHED;
        }
        if (i2 == 5) {
            return this.n.b() ? Stage.RESOURCE_CACHE : n(Stage.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + stage);
    }

    public final Options o(DataSource dataSource) {
        Options options = this.o;
        boolean z2 = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f2475a.x();
        Option option = Downsampler.j;
        Boolean bool = (Boolean) options.c(option);
        if (bool != null && (!bool.booleanValue() || z2)) {
            return options;
        }
        Options options2 = new Options();
        options2.d(this.o);
        options2.f(option, Boolean.valueOf(z2));
        return options2;
    }

    public final int p() {
        return this.j.ordinal();
    }

    public DecodeJob q(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i2, int i3, Class cls, Class cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map map, boolean z2, boolean z3, boolean z4, Options options, Callback callback, int i4) {
        this.f2475a.v(glideContext, obj, key, i2, i3, diskCacheStrategy, cls, cls2, priority, options, map, z2, z3, this.d);
        this.h = glideContext;
        this.i = key;
        this.j = priority;
        this.k = engineKey;
        this.l = i2;
        this.m = i3;
        this.n = diskCacheStrategy;
        this.u = z4;
        this.o = options;
        this.p = callback;
        this.q = i4;
        this.s = RunReason.INITIALIZE;
        this.v = obj;
        return this;
    }

    public final void r(String str, long j2) {
        s(str, j2, (String) null);
    }

    public void run() {
        GlideTrace.c("DecodeJob#run(reason=%s, model=%s)", this.s, this.v);
        DataFetcher dataFetcher = this.B;
        try {
            if (this.E) {
                v();
                if (dataFetcher != null) {
                    dataFetcher.b();
                }
                GlideTrace.e();
                return;
            }
            E();
            if (dataFetcher != null) {
                dataFetcher.b();
            }
            GlideTrace.e();
        } catch (CallbackException e2) {
            throw e2;
        } catch (Throwable th) {
            if (dataFetcher != null) {
                dataFetcher.b();
            }
            GlideTrace.e();
            throw th;
        }
    }

    public final void s(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.a(j2));
        sb.append(", load key: ");
        sb.append(this.k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    public final void t(Resource resource, DataSource dataSource, boolean z2) {
        F();
        this.p.c(resource, dataSource, z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.bumptech.glide.load.engine.Resource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.bumptech.glide.load.engine.LockedResource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.bumptech.glide.load.engine.LockedResource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.bumptech.glide.load.engine.Resource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.bumptech.glide.load.engine.LockedResource} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void u(com.bumptech.glide.load.engine.Resource r2, com.bumptech.glide.load.DataSource r3, boolean r4) {
        /*
            r1 = this;
            java.lang.String r0 = "DecodeJob.notifyEncodeAndRelease"
            com.bumptech.glide.util.pool.GlideTrace.a(r0)
            boolean r0 = r2 instanceof com.bumptech.glide.load.engine.Initializable     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x0012
            r0 = r2
            com.bumptech.glide.load.engine.Initializable r0 = (com.bumptech.glide.load.engine.Initializable) r0     // Catch:{ all -> 0x0010 }
            r0.initialize()     // Catch:{ all -> 0x0010 }
            goto L_0x0012
        L_0x0010:
            r1 = move-exception
            goto L_0x004e
        L_0x0012:
            com.bumptech.glide.load.engine.DecodeJob$DeferredEncodeManager r0 = r1.f     // Catch:{ all -> 0x0010 }
            boolean r0 = r0.c()     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x0020
            com.bumptech.glide.load.engine.LockedResource r2 = com.bumptech.glide.load.engine.LockedResource.e(r2)     // Catch:{ all -> 0x0010 }
            r0 = r2
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            r1.t(r2, r3, r4)     // Catch:{ all -> 0x0010 }
            com.bumptech.glide.load.engine.DecodeJob$Stage r2 = com.bumptech.glide.load.engine.DecodeJob.Stage.ENCODE     // Catch:{ all -> 0x0010 }
            r1.r = r2     // Catch:{ all -> 0x0010 }
            com.bumptech.glide.load.engine.DecodeJob$DeferredEncodeManager r2 = r1.f     // Catch:{ all -> 0x003a }
            boolean r2 = r2.c()     // Catch:{ all -> 0x003a }
            if (r2 == 0) goto L_0x003c
            com.bumptech.glide.load.engine.DecodeJob$DeferredEncodeManager r2 = r1.f     // Catch:{ all -> 0x003a }
            com.bumptech.glide.load.engine.DecodeJob$DiskCacheProvider r3 = r1.d     // Catch:{ all -> 0x003a }
            com.bumptech.glide.load.Options r4 = r1.o     // Catch:{ all -> 0x003a }
            r2.b(r3, r4)     // Catch:{ all -> 0x003a }
            goto L_0x003c
        L_0x003a:
            r1 = move-exception
            goto L_0x0048
        L_0x003c:
            if (r0 == 0) goto L_0x0041
            r0.h()     // Catch:{ all -> 0x0010 }
        L_0x0041:
            r1.w()     // Catch:{ all -> 0x0010 }
            com.bumptech.glide.util.pool.GlideTrace.e()
            return
        L_0x0048:
            if (r0 == 0) goto L_0x004d
            r0.h()     // Catch:{ all -> 0x0010 }
        L_0x004d:
            throw r1     // Catch:{ all -> 0x0010 }
        L_0x004e:
            com.bumptech.glide.util.pool.GlideTrace.e()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.u(com.bumptech.glide.load.engine.Resource, com.bumptech.glide.load.DataSource, boolean):void");
    }

    public final void v() {
        F();
        this.p.b(new GlideException("Failed to load resource", (List<Throwable>) new ArrayList(this.b)));
        x();
    }

    public final void w() {
        if (this.g.b()) {
            A();
        }
    }

    public final void x() {
        if (this.g.c()) {
            A();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: com.bumptech.glide.load.engine.DataCacheKey} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: com.bumptech.glide.load.engine.ResourceCacheKey} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.bumptech.glide.load.engine.ResourceCacheKey} */
    /* JADX WARNING: type inference failed for: r12v6, types: [com.bumptech.glide.load.Key] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bumptech.glide.load.engine.Resource y(com.bumptech.glide.load.DataSource r12, com.bumptech.glide.load.engine.Resource r13) {
        /*
            r11 = this;
            java.lang.Object r0 = r13.get()
            java.lang.Class r8 = r0.getClass()
            com.bumptech.glide.load.DataSource r0 = com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE
            r1 = 0
            if (r12 == r0) goto L_0x0020
            com.bumptech.glide.load.engine.DecodeHelper r0 = r11.f2475a
            com.bumptech.glide.load.Transformation r0 = r0.s(r8)
            com.bumptech.glide.GlideContext r2 = r11.h
            int r3 = r11.l
            int r4 = r11.m
            com.bumptech.glide.load.engine.Resource r2 = r0.a(r2, r13, r3, r4)
            r7 = r0
            r0 = r2
            goto L_0x0022
        L_0x0020:
            r0 = r13
            r7 = r1
        L_0x0022:
            boolean r2 = r13.equals(r0)
            if (r2 != 0) goto L_0x002b
            r13.a()
        L_0x002b:
            com.bumptech.glide.load.engine.DecodeHelper r13 = r11.f2475a
            boolean r13 = r13.w(r0)
            if (r13 == 0) goto L_0x0041
            com.bumptech.glide.load.engine.DecodeHelper r13 = r11.f2475a
            com.bumptech.glide.load.ResourceEncoder r1 = r13.n(r0)
            com.bumptech.glide.load.Options r13 = r11.o
            com.bumptech.glide.load.EncodeStrategy r13 = r1.b(r13)
        L_0x003f:
            r10 = r1
            goto L_0x0044
        L_0x0041:
            com.bumptech.glide.load.EncodeStrategy r13 = com.bumptech.glide.load.EncodeStrategy.NONE
            goto L_0x003f
        L_0x0044:
            com.bumptech.glide.load.engine.DecodeHelper r1 = r11.f2475a
            com.bumptech.glide.load.Key r2 = r11.x
            boolean r1 = r1.y(r2)
            r2 = 1
            r1 = r1 ^ r2
            com.bumptech.glide.load.engine.DiskCacheStrategy r3 = r11.n
            boolean r12 = r3.d(r1, r12, r13)
            if (r12 == 0) goto L_0x00b4
            if (r10 == 0) goto L_0x00a6
            int[] r12 = com.bumptech.glide.load.engine.DecodeJob.AnonymousClass1.c
            int r1 = r13.ordinal()
            r12 = r12[r1]
            if (r12 == r2) goto L_0x0093
            r1 = 2
            if (r12 != r1) goto L_0x007c
            com.bumptech.glide.load.engine.ResourceCacheKey r12 = new com.bumptech.glide.load.engine.ResourceCacheKey
            com.bumptech.glide.load.engine.DecodeHelper r13 = r11.f2475a
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r2 = r13.b()
            com.bumptech.glide.load.Key r3 = r11.x
            com.bumptech.glide.load.Key r4 = r11.i
            int r5 = r11.l
            int r6 = r11.m
            com.bumptech.glide.load.Options r9 = r11.o
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x009c
        L_0x007c:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Unknown strategy: "
            r12.append(r0)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x0093:
            com.bumptech.glide.load.engine.DataCacheKey r12 = new com.bumptech.glide.load.engine.DataCacheKey
            com.bumptech.glide.load.Key r13 = r11.x
            com.bumptech.glide.load.Key r1 = r11.i
            r12.<init>(r13, r1)
        L_0x009c:
            com.bumptech.glide.load.engine.LockedResource r0 = com.bumptech.glide.load.engine.LockedResource.e(r0)
            com.bumptech.glide.load.engine.DecodeJob$DeferredEncodeManager r11 = r11.f
            r11.d(r12, r10, r0)
            goto L_0x00b4
        L_0x00a6:
            com.bumptech.glide.Registry$NoResultEncoderAvailableException r11 = new com.bumptech.glide.Registry$NoResultEncoderAvailableException
            java.lang.Object r12 = r0.get()
            java.lang.Class r12 = r12.getClass()
            r11.<init>(r12)
            throw r11
        L_0x00b4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.y(com.bumptech.glide.load.DataSource, com.bumptech.glide.load.engine.Resource):com.bumptech.glide.load.engine.Resource");
    }

    public void z(boolean z2) {
        if (this.g.d(z2)) {
            A();
        }
    }
}
