package androidx.fragment.app;

import android.view.View;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.transition.FragmentTransitionSupport;
import com.honey.account.constant.AccountConstantKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\f\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0004H\u0007¢\u0006\u0004\b\f\u0010\rJC\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0014\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001b\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b \u0010!R\u0016\u0010#\u001a\u0004\u0018\u00010\u001f8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\"R\u0016\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006X\u0004¢\u0006\u0006\n\u0004\b \u0010\"¨\u0006%"}, d2 = {"Landroidx/fragment/app/FragmentTransition;", "", "<init>", "()V", "Landroidx/collection/ArrayMap;", "", "value", "b", "(Landroidx/collection/ArrayMap;Ljava/lang/String;)Ljava/lang/String;", "Landroid/view/View;", "namedViews", "", "d", "(Landroidx/collection/ArrayMap;Landroidx/collection/ArrayMap;)V", "Landroidx/fragment/app/Fragment;", "inFragment", "outFragment", "", "isPop", "sharedElements", "isStart", "a", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;ZLandroidx/collection/ArrayMap;Z)V", "", "views", "", "visibility", "e", "(Ljava/util/List;I)V", "f", "()Z", "Landroidx/fragment/app/FragmentTransitionImpl;", "c", "()Landroidx/fragment/app/FragmentTransitionImpl;", "Landroidx/fragment/app/FragmentTransitionImpl;", "PLATFORM_IMPL", "SUPPORT_IMPL", "fragment_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFragmentTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FragmentTransition.kt\nandroidx/fragment/app/FragmentTransition\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,123:1\n515#2:124\n500#2,6:125\n125#3:131\n152#3,3:132\n125#3:135\n152#3,3:136\n125#3:139\n152#3,3:140\n1855#4,2:143\n*S KotlinDebug\n*F\n+ 1 FragmentTransition.kt\nandroidx/fragment/app/FragmentTransition\n*L\n50#1:124\n50#1:125,6\n53#1:131\n53#1:132,3\n98#1:135\n98#1:136,3\n99#1:139\n99#1:140,3\n113#1:143,2\n*E\n"})
public final class FragmentTransition {

    /* renamed from: a  reason: collision with root package name */
    public static final FragmentTransition f1307a;
    public static final FragmentTransitionImpl b = new FragmentTransitionCompat21();
    public static final FragmentTransitionImpl c;

    static {
        FragmentTransition fragmentTransition = new FragmentTransition();
        f1307a = fragmentTransition;
        c = fragmentTransition.c();
    }

    public static final void a(Fragment fragment, Fragment fragment2, boolean z, ArrayMap arrayMap, boolean z2) {
        Intrinsics.checkNotNullParameter(fragment, "inFragment");
        Intrinsics.checkNotNullParameter(fragment2, "outFragment");
        Intrinsics.checkNotNullParameter(arrayMap, "sharedElements");
        SharedElementCallback enterTransitionCallback = z ? fragment2.getEnterTransitionCallback() : fragment.getEnterTransitionCallback();
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList(arrayMap.size());
            for (Map.Entry value : arrayMap.entrySet()) {
                arrayList.add((View) value.getValue());
            }
            ArrayList arrayList2 = new ArrayList(arrayMap.size());
            for (Map.Entry key : arrayMap.entrySet()) {
                arrayList2.add((String) key.getKey());
            }
            if (z2) {
                enterTransitionCallback.g(arrayList2, arrayList, (List) null);
            } else {
                enterTransitionCallback.f(arrayList2, arrayList, (List) null);
            }
        }
    }

    public static final String b(ArrayMap arrayMap, String str) {
        Intrinsics.checkNotNullParameter(arrayMap, "<this>");
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : arrayMap.entrySet()) {
            if (Intrinsics.areEqual(entry.getValue(), (Object) str)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry key : linkedHashMap.entrySet()) {
            arrayList.add((String) key.getKey());
        }
        return (String) CollectionsKt.firstOrNull(arrayList);
    }

    public static final void d(ArrayMap arrayMap, ArrayMap arrayMap2) {
        Intrinsics.checkNotNullParameter(arrayMap, "<this>");
        Intrinsics.checkNotNullParameter(arrayMap2, "namedViews");
        int size = arrayMap.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (!arrayMap2.containsKey((String) arrayMap.n(size))) {
                arrayMap.l(size);
            }
        }
    }

    public static final void e(List list, int i) {
        Intrinsics.checkNotNullParameter(list, "views");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(i);
        }
    }

    public static final boolean f() {
        return (b == null && c == null) ? false : true;
    }

    public final FragmentTransitionImpl c() {
        Class<FragmentTransitionSupport> cls = FragmentTransitionSupport.class;
        try {
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<androidx.fragment.app.FragmentTransitionImpl>");
            return cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }
}
