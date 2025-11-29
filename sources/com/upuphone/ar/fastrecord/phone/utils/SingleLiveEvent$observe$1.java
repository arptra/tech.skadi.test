package com.upuphone.ar.fastrecord.phone.utils;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"com/upuphone/ar/fastrecord/phone/utils/SingleLiveEvent$observe$1", "Landroidx/lifecycle/Observer;", "mInitVersion", "", "onChanged", "", "value", "(Ljava/lang/Object;)V", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SingleLiveEvent$observe$1 implements Observer<T> {
    final /* synthetic */ Observer<? super T> $observer;
    private final int mInitVersion;
    final /* synthetic */ SingleLiveEvent<T> this$0;

    public SingleLiveEvent$observe$1(SingleLiveEvent<T> singleLiveEvent, Observer<? super T> observer) {
        this.this$0 = singleLiveEvent;
        this.$observer = observer;
        this.mInitVersion = singleLiveEvent.mVersion;
    }

    public void onChanged(T t) {
        if (this.this$0.mVersion > this.mInitVersion) {
            this.$observer.onChanged(t);
        }
    }
}
