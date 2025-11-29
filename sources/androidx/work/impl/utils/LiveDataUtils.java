package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo
public class LiveDataUtils {
    public static LiveData a(LiveData liveData, final Function function, final TaskExecutor taskExecutor) {
        final Object obj = new Object();
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.c(liveData, new Observer<Object>() {

            /* renamed from: a  reason: collision with root package name */
            public Object f2232a = null;

            public void onChanged(final Object obj) {
                TaskExecutor.this.b(new Runnable() {
                    public void run() {
                        synchronized (obj) {
                            try {
                                Object apply = function.apply(obj);
                                AnonymousClass1 r2 = AnonymousClass1.this;
                                Object obj = r2.f2232a;
                                if (obj == null && apply != null) {
                                    r2.f2232a = apply;
                                    mediatorLiveData.postValue(apply);
                                } else if (obj != null && !obj.equals(apply)) {
                                    AnonymousClass1 r4 = AnonymousClass1.this;
                                    r4.f2232a = apply;
                                    mediatorLiveData.postValue(apply);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
            }
        });
        return mediatorLiveData;
    }
}
