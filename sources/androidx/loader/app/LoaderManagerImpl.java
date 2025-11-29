package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class LoaderManagerImpl extends LoaderManager {
    public static boolean c = false;

    /* renamed from: a  reason: collision with root package name */
    public final LifecycleOwner f1406a;
    public final LoaderViewModel b;

    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {

        /* renamed from: a  reason: collision with root package name */
        public final int f1407a;
        public final Bundle b;
        public final Loader c;
        public LifecycleOwner d;
        public LoaderObserver e;
        public Loader f;

        public void a(Loader loader, Object obj) {
            if (LoaderManagerImpl.c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(obj);
                return;
            }
            if (LoaderManagerImpl.c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            postValue(obj);
        }

        public Loader c(boolean z) {
            if (LoaderManagerImpl.c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.c.b();
            this.c.a();
            LoaderObserver loaderObserver = this.e;
            if (loaderObserver != null) {
                removeObserver(loaderObserver);
                if (z) {
                    loaderObserver.c();
                }
            }
            this.c.y(this);
            if ((loaderObserver == null || loaderObserver.b()) && !z) {
                return this.c;
            }
            this.c.t();
            return this.f;
        }

        public void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f1407a);
            printWriter.print(" mArgs=");
            printWriter.println(this.b);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.c);
            Loader loader = this.c;
            loader.g(str + FastRecordHistoryDetailActivity.TAG_SPLIT, fileDescriptor, printWriter, strArr);
            if (this.e != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.e);
                LoaderObserver loaderObserver = this.e;
                loaderObserver.a(str + FastRecordHistoryDetailActivity.TAG_SPLIT, printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(e().d(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        public Loader e() {
            return this.c;
        }

        public void f() {
            LifecycleOwner lifecycleOwner = this.d;
            LoaderObserver loaderObserver = this.e;
            if (lifecycleOwner != null && loaderObserver != null) {
                super.removeObserver(loaderObserver);
                observe(lifecycleOwner, loaderObserver);
            }
        }

        public void onActive() {
            if (LoaderManagerImpl.c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.c.v();
        }

        public void onInactive() {
            if (LoaderManagerImpl.c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.c.w();
        }

        public void removeObserver(Observer observer) {
            super.removeObserver(observer);
            this.d = null;
            this.e = null;
        }

        public void setValue(Object obj) {
            super.setValue(obj);
            Loader loader = this.f;
            if (loader != null) {
                loader.t();
                this.f = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f1407a);
            sb.append(" : ");
            DebugUtils.a(this.c, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    public static class LoaderObserver<D> implements Observer<D> {

        /* renamed from: a  reason: collision with root package name */
        public final Loader f1408a;
        public final LoaderManager.LoaderCallbacks b;
        public boolean c;

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }

        public boolean b() {
            return this.c;
        }

        public void c() {
            if (this.c) {
                if (LoaderManagerImpl.c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f1408a);
                }
                this.b.b(this.f1408a);
            }
        }

        public void onChanged(Object obj) {
            if (LoaderManagerImpl.c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f1408a + ": " + this.f1408a.d(obj));
            }
            this.b.a(this.f1408a, obj);
            this.c = true;
        }

        public String toString() {
            return this.b.toString();
        }
    }

    public static class LoaderViewModel extends ViewModel {
        public static final ViewModelProvider.Factory c = new ViewModelProvider.Factory() {
            public ViewModel create(Class cls) {
                return new LoaderViewModel();
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public SparseArrayCompat f1409a = new SparseArrayCompat();
        public boolean b = false;

        public static LoaderViewModel d(ViewModelStore viewModelStore) {
            return (LoaderViewModel) new ViewModelProvider(viewModelStore, c).get(LoaderViewModel.class);
        }

        public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f1409a.p() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f1409a.p(); i++) {
                    LoaderInfo loaderInfo = (LoaderInfo) this.f1409a.q(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f1409a.l(i));
                    printWriter.print(": ");
                    printWriter.println(loaderInfo.toString());
                    loaderInfo.d(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void e() {
            int p = this.f1409a.p();
            for (int i = 0; i < p; i++) {
                ((LoaderInfo) this.f1409a.q(i)).f();
            }
        }

        public void onCleared() {
            super.onCleared();
            int p = this.f1409a.p();
            for (int i = 0; i < p; i++) {
                ((LoaderInfo) this.f1409a.q(i)).c(true);
            }
            this.f1409a.c();
        }
    }

    public LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.f1406a = lifecycleOwner;
        this.b = LoaderViewModel.d(viewModelStore);
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.b.c(str, fileDescriptor, printWriter, strArr);
    }

    public void c() {
        this.b.e();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.a(this.f1406a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
