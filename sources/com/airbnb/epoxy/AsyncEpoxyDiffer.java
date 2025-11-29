package com.airbnb.epoxy;

import android.os.Handler;
import androidx.recyclerview.widget.DiffUtil;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

class AsyncEpoxyDiffer {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2266a;
    public final ResultCallback b;
    public final DiffUtil.ItemCallback c;
    public final GenerationTracker d = new GenerationTracker();
    public volatile List e;
    public volatile List f = Collections.emptyList();

    public static class DiffCallback extends DiffUtil.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final List f2269a;
        public final List b;
        public final DiffUtil.ItemCallback c;

        public DiffCallback(List list, List list2, DiffUtil.ItemCallback itemCallback) {
            this.f2269a = list;
            this.b = list2;
            this.c = itemCallback;
        }

        public boolean areContentsTheSame(int i, int i2) {
            return this.c.areContentsTheSame((EpoxyModel) this.f2269a.get(i), (EpoxyModel) this.b.get(i2));
        }

        public boolean areItemsTheSame(int i, int i2) {
            return this.c.areItemsTheSame((EpoxyModel) this.f2269a.get(i), (EpoxyModel) this.b.get(i2));
        }

        public Object getChangePayload(int i, int i2) {
            return this.c.getChangePayload((EpoxyModel) this.f2269a.get(i), (EpoxyModel) this.b.get(i2));
        }

        public int getNewListSize() {
            return this.b.size();
        }

        public int getOldListSize() {
            return this.f2269a.size();
        }
    }

    public static class GenerationTracker {

        /* renamed from: a  reason: collision with root package name */
        public volatile int f2270a;
        public volatile int b;

        public GenerationTracker() {
        }

        public synchronized boolean a(int i) {
            boolean z;
            try {
                z = this.f2270a == i && i > this.b;
                if (z) {
                    this.b = i;
                }
            } catch (Throwable th) {
                throw th;
            }
            return z;
        }

        public synchronized boolean b() {
            boolean c;
            c = c();
            this.b = this.f2270a;
            return c;
        }

        public synchronized boolean c() {
            return this.f2270a > this.b;
        }

        public synchronized int d() {
            int i;
            i = this.f2270a + 1;
            this.f2270a = i;
            return i;
        }
    }

    public interface ResultCallback {
        void c(DiffResult diffResult);
    }

    public AsyncEpoxyDiffer(Handler handler, ResultCallback resultCallback, DiffUtil.ItemCallback itemCallback) {
        this.f2266a = new HandlerExecutor(handler);
        this.b = resultCallback;
        this.c = itemCallback;
    }

    public boolean d() {
        return this.d.b();
    }

    public synchronized boolean e(List list) {
        boolean d2;
        d2 = d();
        j(list, this.d.d());
        return d2;
    }

    public List f() {
        return this.f;
    }

    public boolean g() {
        return this.d.c();
    }

    public final void h(final int i, final List list, final DiffResult diffResult) {
        MainThreadExecutor.c.execute(new Runnable() {
            public void run() {
                boolean b2 = AsyncEpoxyDiffer.this.j(list, i);
                if (diffResult != null && b2) {
                    AsyncEpoxyDiffer.this.b.c(diffResult);
                }
            }
        });
    }

    public void i(List list) {
        final int d2;
        final List list2;
        synchronized (this) {
            d2 = this.d.d();
            list2 = this.e;
        }
        if (list == list2) {
            h(d2, list, DiffResult.f(list2));
        } else if (list == null || list.isEmpty()) {
            h(d2, (List) null, (list2 == null || list2.isEmpty()) ? null : DiffResult.a(list2));
        } else if (list2 == null || list2.isEmpty()) {
            h(d2, list, DiffResult.e(list));
        } else {
            final DiffCallback diffCallback = new DiffCallback(list2, list, this.c);
            final List list3 = list;
            this.f2266a.execute(new Runnable() {
                public void run() {
                    DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(diffCallback);
                    AsyncEpoxyDiffer asyncEpoxyDiffer = AsyncEpoxyDiffer.this;
                    int i = d2;
                    List list = list3;
                    asyncEpoxyDiffer.h(i, list, DiffResult.b(list2, list, calculateDiff));
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean j(java.util.List r2, int r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.airbnb.epoxy.AsyncEpoxyDiffer$GenerationTracker r0 = r1.d     // Catch:{ all -> 0x0014 }
            boolean r3 = r0.a(r3)     // Catch:{ all -> 0x0014 }
            if (r3 == 0) goto L_0x001f
            r1.e = r2     // Catch:{ all -> 0x0014 }
            if (r2 != 0) goto L_0x0016
            java.util.List r2 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0014 }
            r1.f = r2     // Catch:{ all -> 0x0014 }
            goto L_0x001c
        L_0x0014:
            r2 = move-exception
            goto L_0x0022
        L_0x0016:
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)     // Catch:{ all -> 0x0014 }
            r1.f = r2     // Catch:{ all -> 0x0014 }
        L_0x001c:
            monitor-exit(r1)
            r1 = 1
            return r1
        L_0x001f:
            monitor-exit(r1)
            r1 = 0
            return r1
        L_0x0022:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.epoxy.AsyncEpoxyDiffer.j(java.util.List, int):boolean");
    }
}
