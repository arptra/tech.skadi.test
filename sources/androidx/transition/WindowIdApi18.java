package androidx.transition;

import android.view.View;
import android.view.WindowId;
import androidx.annotation.RequiresApi;

@RequiresApi
class WindowIdApi18 implements WindowIdImpl {

    /* renamed from: a  reason: collision with root package name */
    public final WindowId f1890a;

    public WindowIdApi18(View view) {
        this.f1890a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi18) && ((WindowIdApi18) obj).f1890a.equals(this.f1890a);
    }

    public int hashCode() {
        return this.f1890a.hashCode();
    }
}
