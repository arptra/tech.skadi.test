package com.meizu.common.util;

import android.graphics.Path;
import android.util.LruCache;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.util.SmoothCornerPathGenerator;
import com.upuphone.runasone.relay.api.IntentKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\b\u0010\n\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0010¸\u0006\u0000"}, d2 = {"androidx/core/util/LruCacheKt$lruCache$4", "Landroid/util/LruCache;", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "sizeOf", "", "value", "(Ljava/lang/Object;Ljava/lang/Object;)I", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmoothCornerPathGenerator$special$$inlined$lruCache$default$1 extends LruCache<SmoothCornerPathGenerator.SmoothPathParams, Path> {
    public SmoothCornerPathGenerator$special$$inlined$lruCache$default$1(int i) {
        super(i);
    }

    @Nullable
    public Path create(@NotNull SmoothCornerPathGenerator.SmoothPathParams smoothPathParams) {
        Intrinsics.checkNotNullParameter(smoothPathParams, IntentKey.ACTIVITY.ACTION_KEY);
        return null;
    }

    public void entryRemoved(boolean z, @NotNull SmoothCornerPathGenerator.SmoothPathParams smoothPathParams, @NotNull Path path, @Nullable Path path2) {
        Intrinsics.checkNotNullParameter(smoothPathParams, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(path, "oldValue");
    }

    public int sizeOf(@NotNull SmoothCornerPathGenerator.SmoothPathParams smoothPathParams, @NotNull Path path) {
        Intrinsics.checkNotNullParameter(smoothPathParams, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(path, AccountConstantKt.RESPONSE_VALUE);
        return 1;
    }
}
