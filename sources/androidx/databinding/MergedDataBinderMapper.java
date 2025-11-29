package androidx.databinding;

import android.util.Log;
import android.view.View;
import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

@RestrictTo
public class MergedDataBinderMapper extends DataBinderMapper {

    /* renamed from: a  reason: collision with root package name */
    public Set f970a = new HashSet();
    public List b = new CopyOnWriteArrayList();
    public List c = new CopyOnWriteArrayList();

    public ViewDataBinding b(DataBindingComponent dataBindingComponent, View view, int i) {
        for (DataBinderMapper b2 : this.b) {
            ViewDataBinding b3 = b2.b(dataBindingComponent, view, i);
            if (b3 != null) {
                return b3;
            }
        }
        if (e()) {
            return b(dataBindingComponent, view, i);
        }
        return null;
    }

    public ViewDataBinding c(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        for (DataBinderMapper c2 : this.b) {
            ViewDataBinding c3 = c2.c(dataBindingComponent, viewArr, i);
            if (c3 != null) {
                return c3;
            }
        }
        if (e()) {
            return c(dataBindingComponent, viewArr, i);
        }
        return null;
    }

    public void d(DataBinderMapper dataBinderMapper) {
        if (this.f970a.add(dataBinderMapper.getClass())) {
            this.b.add(dataBinderMapper);
            for (DataBinderMapper d : dataBinderMapper.a()) {
                d(d);
            }
        }
    }

    public final boolean e() {
        boolean z = false;
        for (String str : this.c) {
            try {
                Class<?> cls = Class.forName(str);
                if (DataBinderMapper.class.isAssignableFrom(cls)) {
                    d((DataBinderMapper) cls.newInstance());
                    this.c.remove(str);
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e);
            } catch (InstantiationException e2) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e2);
            }
        }
        return z;
    }
}
