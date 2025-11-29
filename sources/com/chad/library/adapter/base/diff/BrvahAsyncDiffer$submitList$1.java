package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "run"}, k = 3, mv = {1, 1, 16})
final class BrvahAsyncDiffer$submitList$1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BrvahAsyncDiffer f2784a;
    public final /* synthetic */ List b;
    public final /* synthetic */ List c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Runnable e;

    public final void run() {
        final DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new BrvahAsyncDiffer$submitList$1$result$1(this));
        Intrinsics.checkExpressionValueIsNotNull(calculateDiff, "DiffUtil.calculateDiff(o…         }\n            })");
        this.f2784a.b.execute(new Runnable(this) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BrvahAsyncDiffer$submitList$1 f2785a;

            {
                this.f2785a = r1;
            }

            public final void run() {
                int c = this.f2785a.f2784a.d;
                BrvahAsyncDiffer$submitList$1 brvahAsyncDiffer$submitList$1 = this.f2785a;
                if (c == brvahAsyncDiffer$submitList$1.d) {
                    brvahAsyncDiffer$submitList$1.f2784a.e(brvahAsyncDiffer$submitList$1.c, calculateDiff, brvahAsyncDiffer$submitList$1.e);
                }
            }
        });
    }
}
