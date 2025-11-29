package com.bumptech.glide.manager;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class LifecycleRequestManagerRetriever {

    /* renamed from: a  reason: collision with root package name */
    public final Map f2679a = new HashMap();
    public final RequestManagerRetriever.RequestManagerFactory b;

    public final class SupportRequestManagerTreeNode implements RequestManagerTreeNode {

        /* renamed from: a  reason: collision with root package name */
        public final FragmentManager f2681a;

        public SupportRequestManagerTreeNode(FragmentManager fragmentManager) {
            this.f2681a = fragmentManager;
        }

        public Set a() {
            HashSet hashSet = new HashSet();
            b(this.f2681a, hashSet);
            return hashSet;
        }

        public final void b(FragmentManager fragmentManager, Set set) {
            List F0 = fragmentManager.F0();
            int size = F0.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) F0.get(i);
                b(fragment.getChildFragmentManager(), set);
                RequestManager a2 = LifecycleRequestManagerRetriever.this.a(fragment.getLifecycle());
                if (a2 != null) {
                    set.add(a2);
                }
            }
        }
    }

    public LifecycleRequestManagerRetriever(RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.b = requestManagerFactory;
    }

    public RequestManager a(Lifecycle lifecycle) {
        Util.b();
        return (RequestManager) this.f2679a.get(lifecycle);
    }

    public RequestManager b(Context context, Glide glide, final Lifecycle lifecycle, FragmentManager fragmentManager, boolean z) {
        Util.b();
        RequestManager a2 = a(lifecycle);
        if (a2 != null) {
            return a2;
        }
        LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(lifecycle);
        RequestManager a3 = this.b.a(glide, lifecycleLifecycle, new SupportRequestManagerTreeNode(fragmentManager), context);
        this.f2679a.put(lifecycle, a3);
        lifecycleLifecycle.b(new LifecycleListener() {
            public void onDestroy() {
                LifecycleRequestManagerRetriever.this.f2679a.remove(lifecycle);
            }

            public void onStart() {
            }

            public void onStop() {
            }
        });
        if (z) {
            a3.onStart();
        }
        return a3;
    }
}
