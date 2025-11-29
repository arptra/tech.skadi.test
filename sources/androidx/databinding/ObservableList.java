package androidx.databinding;

import java.util.List;

public interface ObservableList<T> extends List<T> {

    public static abstract class OnListChangedCallback<T extends ObservableList> {
        public abstract void a(ObservableList observableList);

        public abstract void c(ObservableList observableList, int i, int i2);

        public abstract void d(ObservableList observableList, int i, int i2);

        public abstract void e(ObservableList observableList, int i, int i2, int i3);

        public abstract void f(ObservableList observableList, int i, int i2);
    }

    void removeOnListChangedCallback(OnListChangedCallback onListChangedCallback);
}
