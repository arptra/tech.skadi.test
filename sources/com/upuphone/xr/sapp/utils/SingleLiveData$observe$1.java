package com.upuphone.xr.sapp.utils;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "t", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SingleLiveData$observe$1 extends Lambda implements Function1<T, Unit> {
    final /* synthetic */ Observer<? super T> $observer;
    final /* synthetic */ SingleLiveData<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleLiveData$observe$1(SingleLiveData<T> singleLiveData, Observer<? super T> observer) {
        super(1);
        this.this$0 = singleLiveData;
        this.$observer = observer;
    }

    public final void invoke(@Nullable T t) {
        if (this.this$0.f7914a.compareAndSet(true, false)) {
            this.$observer.onChanged(t);
        }
    }
}
