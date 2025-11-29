package com.chad.library.adapter.base.diff;

import android.os.Handler;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001&J/\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R \u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010\"\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030 8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010!R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000#8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010$¨\u0006'"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDiffer;", "T", "Lcom/chad/library/adapter/base/diff/DifferImp;", "", "newList", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diffResult", "Ljava/lang/Runnable;", "commitCallback", "", "e", "(Ljava/util/List;Landroidx/recyclerview/widget/DiffUtil$DiffResult;Ljava/lang/Runnable;)V", "", "previousList", "f", "(Ljava/util/List;Ljava/lang/Runnable;)V", "Landroidx/recyclerview/widget/ListUpdateCallback;", "a", "Landroidx/recyclerview/widget/ListUpdateCallback;", "mUpdateCallback", "Ljava/util/concurrent/Executor;", "b", "Ljava/util/concurrent/Executor;", "mMainThreadExecutor", "Lcom/chad/library/adapter/base/diff/ListChangeListener;", "c", "Ljava/util/List;", "mListeners", "", "d", "I", "mMaxScheduledGeneration", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "adapter", "Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig;", "Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig;", "config", "MainThreadExecutor", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public final class BrvahAsyncDiffer<T> implements DifferImp<T> {

    /* renamed from: a  reason: collision with root package name */
    public final ListUpdateCallback f2782a;
    public Executor b;
    public final List c;
    public int d;
    public final BaseQuickAdapter e;
    public final BrvahAsyncDifferConfig f;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDiffer$MainThreadExecutor;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "command", "", "execute", "(Ljava/lang/Runnable;)V", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
    public static final class MainThreadExecutor implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f2783a;

        public void execute(Runnable runnable) {
            this.f2783a.post(runnable);
        }
    }

    public final void e(List list, DiffUtil.DiffResult diffResult, Runnable runnable) {
        List data = this.e.getData();
        this.e.k0(list);
        diffResult.dispatchUpdatesTo(this.f2782a);
        f(data, runnable);
    }

    public final void f(List list, Runnable runnable) {
        for (ListChangeListener onCurrentListChanged : this.c) {
            onCurrentListChanged.onCurrentListChanged(list, this.e.getData());
        }
        if (runnable != null) {
            runnable.run();
        }
    }
}
