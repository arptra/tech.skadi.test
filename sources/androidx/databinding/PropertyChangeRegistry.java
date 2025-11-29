package androidx.databinding;

import androidx.databinding.CallbackRegistry;
import androidx.databinding.Observable;

public class PropertyChangeRegistry extends CallbackRegistry<Observable.OnPropertyChangedCallback, Observable, Void> {
    public static final CallbackRegistry.NotifierCallback f = new CallbackRegistry.NotifierCallback<Observable.OnPropertyChangedCallback, Observable, Void>() {
        /* renamed from: b */
        public void a(Observable.OnPropertyChangedCallback onPropertyChangedCallback, Observable observable, int i, Void voidR) {
            onPropertyChangedCallback.c(observable, i);
        }
    };

    public PropertyChangeRegistry() {
        super(f);
    }
}
