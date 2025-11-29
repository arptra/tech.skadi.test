package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

@RestrictTo
public class OperationImpl implements Operation {
    public final MutableLiveData c = new MutableLiveData();
    public final SettableFuture d = SettableFuture.s();

    public OperationImpl() {
        a(Operation.b);
    }

    public void a(Operation.State state) {
        this.c.postValue(state);
        if (state instanceof Operation.State.SUCCESS) {
            this.d.o((Operation.State.SUCCESS) state);
        } else if (state instanceof Operation.State.FAILURE) {
            this.d.p(((Operation.State.FAILURE) state).a());
        }
    }

    public ListenableFuture getResult() {
        return this.d;
    }
}
