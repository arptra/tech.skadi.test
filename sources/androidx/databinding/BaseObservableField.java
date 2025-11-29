package androidx.databinding;

import androidx.databinding.Observable;

abstract class BaseObservableField extends BaseObservable {

    public class DependencyCallback extends Observable.OnPropertyChangedCallback {
        public DependencyCallback() {
        }

        public void c(Observable observable, int i) {
            BaseObservableField.this.notifyChange();
        }
    }

    public BaseObservableField() {
    }

    public BaseObservableField(Observable... observableArr) {
        if (observableArr != null && observableArr.length != 0) {
            DependencyCallback dependencyCallback = new DependencyCallback();
            for (Observable addOnPropertyChangedCallback : observableArr) {
                addOnPropertyChangedCallback.addOnPropertyChangedCallback(dependencyCallback);
            }
        }
    }
}
