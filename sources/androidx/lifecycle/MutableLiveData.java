package androidx.lifecycle;

public class MutableLiveData<T> extends LiveData<T> {
    public MutableLiveData(Object obj) {
        super(obj);
    }

    public void postValue(T t) {
        super.postValue(t);
    }

    public void setValue(Object obj) {
        super.setValue(obj);
    }

    public MutableLiveData() {
    }
}
