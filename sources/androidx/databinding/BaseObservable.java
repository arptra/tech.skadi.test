package androidx.databinding;

import androidx.annotation.NonNull;
import androidx.databinding.Observable;

public class BaseObservable implements Observable {
    private transient PropertyChangeRegistry mCallbacks;

    public void addOnPropertyChangedCallback(@NonNull Observable.OnPropertyChangedCallback onPropertyChangedCallback) {
        synchronized (this) {
            try {
                if (this.mCallbacks == null) {
                    this.mCallbacks = new PropertyChangeRegistry();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.mCallbacks.b(onPropertyChangedCallback);
    }

    public void notifyChange() {
        synchronized (this) {
            try {
                PropertyChangeRegistry propertyChangeRegistry = this.mCallbacks;
                if (propertyChangeRegistry != null) {
                    propertyChangeRegistry.e(this, 0, (Object) null);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public void notifyPropertyChanged(int i) {
        synchronized (this) {
            try {
                PropertyChangeRegistry propertyChangeRegistry = this.mCallbacks;
                if (propertyChangeRegistry != null) {
                    propertyChangeRegistry.e(this, i, (Object) null);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public void removeOnPropertyChangedCallback(@NonNull Observable.OnPropertyChangedCallback onPropertyChangedCallback) {
        synchronized (this) {
            try {
                PropertyChangeRegistry propertyChangeRegistry = this.mCallbacks;
                if (propertyChangeRegistry != null) {
                    propertyChangeRegistry.j(onPropertyChangedCallback);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }
}
