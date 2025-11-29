package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\bR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig;", "T", "", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "Builder", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public final class BrvahAsyncDifferConfig<T> {

    /* renamed from: a  reason: collision with root package name */
    public final DiffUtil.ItemCallback f2787a;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u0003*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig$Builder;", "T", "", "b", "Companion", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
    public static final class Builder<T> {

        /* renamed from: a  reason: collision with root package name */
        public static final Object f2788a = new Object();
        public static final Companion b = new Companion((DefaultConstructorMarker) null);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig$Builder$Companion;", "", "()V", "sDiffExecutor", "Ljava/util/concurrent/Executor;", "sExecutorLock", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    public final DiffUtil.ItemCallback a() {
        return this.f2787a;
    }
}
