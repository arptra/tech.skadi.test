package com.example.flutter_pag_plugin;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/util/LruCache;", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class DataLoadHelper$memoryCache$2 extends Lambda implements Function0<LruCache<String, byte[]>> {
    public static final DataLoadHelper$memoryCache$2 INSTANCE = new DataLoadHelper$memoryCache$2();

    public DataLoadHelper$memoryCache$2() {
        super(0);
    }

    @NotNull
    public final LruCache<String, byte[]> invoke() {
        return new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 50);
    }
}
