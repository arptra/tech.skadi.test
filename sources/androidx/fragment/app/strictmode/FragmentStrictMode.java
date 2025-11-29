package androidx.fragment.app.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.honey.account.w.a;
import com.honey.account.w.b;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003<=>B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0016\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u001e\u0010\u0013J\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001f\u0010\u0015J\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b \u0010\u0015J\u001f\u0010!\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b!\u0010\u000eJ\u0019\u0010#\u001a\u00020\"2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J7\u0010-\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\"2\u000e\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040*2\u000e\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0*H\u0002¢\u0006\u0004\b-\u0010.J\u001f\u0010/\u001a\u00020\b2\u0006\u0010)\u001a\u00020\"2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b/\u00100J\u001f\u00103\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b3\u00104R\"\u0010;\u001a\u00020\"8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006?"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode;", "", "<init>", "()V", "Landroidx/fragment/app/Fragment;", "fragment", "", "previousFragmentId", "", "h", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Landroid/view/ViewGroup;", "container", "i", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;)V", "expectedParentFragment", "", "containerId", "q", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;I)V", "m", "(Landroidx/fragment/app/Fragment;)V", "j", "", "isVisibleToUser", "o", "(Landroidx/fragment/app/Fragment;Z)V", "violatingFragment", "targetFragment", "requestCode", "n", "l", "k", "p", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "c", "(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "Landroidx/fragment/app/strictmode/Violation;", "violation", "g", "(Landroidx/fragment/app/strictmode/Violation;)V", "policy", "Ljava/lang/Class;", "fragmentClass", "violationClass", "s", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;Ljava/lang/Class;Ljava/lang/Class;)Z", "d", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;Landroidx/fragment/app/strictmode/Violation;)V", "Ljava/lang/Runnable;", "runnable", "r", "(Landroidx/fragment/app/Fragment;Ljava/lang/Runnable;)V", "b", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "getDefaultPolicy", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "setDefaultPolicy", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;)V", "defaultPolicy", "Flag", "OnViolationListener", "Policy", "fragment_release"}, k = 1, mv = {1, 8, 0})
public final class FragmentStrictMode {

    /* renamed from: a  reason: collision with root package name */
    public static final FragmentStrictMode f1333a = new FragmentStrictMode();
    public static Policy b = Policy.e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "", "(Ljava/lang/String;I)V", "PENALTY_LOG", "PENALTY_DEATH", "DETECT_FRAGMENT_REUSE", "DETECT_FRAGMENT_TAG_USAGE", "DETECT_WRONG_NESTED_HIERARCHY", "DETECT_RETAIN_INSTANCE_USAGE", "DETECT_SET_USER_VISIBLE_HINT", "DETECT_TARGET_FRAGMENT_USAGE", "DETECT_WRONG_FRAGMENT_CONTAINER", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_WRONG_NESTED_HIERARCHY,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "", "Landroidx/fragment/app/strictmode/Violation;", "violation", "", "a", "(Landroidx/fragment/app/strictmode/Violation;)V", "fragment_release"}, k = 1, mv = {1, 8, 0})
    public interface OnViolationListener {
        void a(Violation violation);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u00192\u00020\u0001:\u0002\u001a\u001bBC\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012 \u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\t0\u0007¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0000X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R4\u0010\u0018\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\u00020\u00078\u0000X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u001c"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "flags", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "listener", "", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "allowedViolations", "<init>", "(Ljava/util/Set;Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;Ljava/util/Map;)V", "a", "Ljava/util/Set;", "()Ljava/util/Set;", "b", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "c", "Ljava/util/Map;", "()Ljava/util/Map;", "mAllowedViolations", "d", "Builder", "Companion", "fragment_release"}, k = 1, mv = {1, 8, 0})
    public static final class Policy {
        public static final Companion d = new Companion((DefaultConstructorMarker) null);
        public static final Policy e = new Policy(SetsKt.emptySet(), (OnViolationListener) null, MapsKt.emptyMap());

        /* renamed from: a  reason: collision with root package name */
        public final Set f1334a;
        public final OnViolationListener b;
        public final Map c;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Builder;", "", "fragment_release"}, k = 1, mv = {1, 8, 0})
        public static final class Builder {
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Companion;", "", "()V", "LAX", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public Companion() {
            }
        }

        public Policy(Set set, OnViolationListener onViolationListener, Map map) {
            Intrinsics.checkNotNullParameter(set, "flags");
            Intrinsics.checkNotNullParameter(map, "allowedViolations");
            this.f1334a = set;
            this.b = onViolationListener;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put((String) entry.getKey(), (Set) entry.getValue());
            }
            this.c = linkedHashMap;
        }

        public final Set a() {
            return this.f1334a;
        }

        public final OnViolationListener b() {
            return this.b;
        }

        public final Map c() {
            return this.c;
        }
    }

    public static final void e(Policy policy, Violation violation) {
        Intrinsics.checkNotNullParameter(policy, "$policy");
        Intrinsics.checkNotNullParameter(violation, "$violation");
        policy.b().a(violation);
    }

    public static final void f(String str, Violation violation) {
        Intrinsics.checkNotNullParameter(violation, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    public static final void h(Fragment fragment, String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(str, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, str);
        FragmentStrictMode fragmentStrictMode = f1333a;
        fragmentStrictMode.g(fragmentReuseViolation);
        Policy c = fragmentStrictMode.c(fragment);
        if (c.a().contains(Flag.DETECT_FRAGMENT_REUSE) && fragmentStrictMode.s(c, fragment.getClass(), fragmentReuseViolation.getClass())) {
            fragmentStrictMode.d(c, fragmentReuseViolation);
        }
    }

    public static final void i(Fragment fragment, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = f1333a;
        fragmentStrictMode.g(fragmentTagUsageViolation);
        Policy c = fragmentStrictMode.c(fragment);
        if (c.a().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && fragmentStrictMode.s(c, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            fragmentStrictMode.d(c, fragmentTagUsageViolation);
        }
    }

    public static final void j(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f1333a;
        fragmentStrictMode.g(getRetainInstanceUsageViolation);
        Policy c = fragmentStrictMode.c(fragment);
        if (c.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.s(c, fragment.getClass(), getRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.d(c, getRetainInstanceUsageViolation);
        }
    }

    public static final void k(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f1333a;
        fragmentStrictMode.g(getTargetFragmentRequestCodeUsageViolation);
        Policy c = fragmentStrictMode.c(fragment);
        if (c.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.s(c, fragment.getClass(), getTargetFragmentRequestCodeUsageViolation.getClass())) {
            fragmentStrictMode.d(c, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    public static final void l(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f1333a;
        fragmentStrictMode.g(getTargetFragmentUsageViolation);
        Policy c = fragmentStrictMode.c(fragment);
        if (c.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.s(c, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.d(c, getTargetFragmentUsageViolation);
        }
    }

    public static final void m(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f1333a;
        fragmentStrictMode.g(setRetainInstanceUsageViolation);
        Policy c = fragmentStrictMode.c(fragment);
        if (c.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.s(c, fragment.getClass(), setRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.d(c, setRetainInstanceUsageViolation);
        }
    }

    public static final void n(Fragment fragment, Fragment fragment2, int i) {
        Intrinsics.checkNotNullParameter(fragment, "violatingFragment");
        Intrinsics.checkNotNullParameter(fragment2, "targetFragment");
        SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(fragment, fragment2, i);
        FragmentStrictMode fragmentStrictMode = f1333a;
        fragmentStrictMode.g(setTargetFragmentUsageViolation);
        Policy c = fragmentStrictMode.c(fragment);
        if (c.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.s(c, fragment.getClass(), setTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.d(c, setTargetFragmentUsageViolation);
        }
    }

    public static final void o(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, z);
        FragmentStrictMode fragmentStrictMode = f1333a;
        fragmentStrictMode.g(setUserVisibleHintViolation);
        Policy c = fragmentStrictMode.c(fragment);
        if (c.a().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && fragmentStrictMode.s(c, fragment.getClass(), setUserVisibleHintViolation.getClass())) {
            fragmentStrictMode.d(c, setUserVisibleHintViolation);
        }
    }

    public static final void p(Fragment fragment, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = f1333a;
        fragmentStrictMode.g(wrongFragmentContainerViolation);
        Policy c = fragmentStrictMode.c(fragment);
        if (c.a().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && fragmentStrictMode.s(c, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            fragmentStrictMode.d(c, wrongFragmentContainerViolation);
        }
    }

    public static final void q(Fragment fragment, Fragment fragment2, int i) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(fragment2, "expectedParentFragment");
        WrongNestedHierarchyViolation wrongNestedHierarchyViolation = new WrongNestedHierarchyViolation(fragment, fragment2, i);
        FragmentStrictMode fragmentStrictMode = f1333a;
        fragmentStrictMode.g(wrongNestedHierarchyViolation);
        Policy c = fragmentStrictMode.c(fragment);
        if (c.a().contains(Flag.DETECT_WRONG_NESTED_HIERARCHY) && fragmentStrictMode.s(c, fragment.getClass(), wrongNestedHierarchyViolation.getClass())) {
            fragmentStrictMode.d(c, wrongNestedHierarchyViolation);
        }
    }

    public final Policy c(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.M0() != null) {
                    Policy M0 = parentFragmentManager.M0();
                    Intrinsics.checkNotNull(M0);
                    return M0;
                }
            }
            fragment = fragment.getParentFragment();
        }
        return b;
    }

    public final void d(Policy policy, Violation violation) {
        Fragment fragment = violation.getFragment();
        String name = fragment.getClass().getName();
        if (policy.a().contains(Flag.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, violation);
        }
        if (policy.b() != null) {
            r(fragment, new a(policy, violation));
        }
        if (policy.a().contains(Flag.PENALTY_DEATH)) {
            r(fragment, new b(name, violation));
        }
    }

    public final void g(Violation violation) {
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + violation.getFragment().getClass().getName(), violation);
        }
    }

    public final void r(Fragment fragment, Runnable runnable) {
        if (fragment.isAdded()) {
            Handler h = fragment.getParentFragmentManager().G0().h();
            if (Intrinsics.areEqual((Object) h.getLooper(), (Object) Looper.myLooper())) {
                runnable.run();
            } else {
                h.post(runnable);
            }
        } else {
            runnable.run();
        }
    }

    public final boolean s(Policy policy, Class cls, Class cls2) {
        Set set = (Set) policy.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (Intrinsics.areEqual((Object) cls2.getSuperclass(), (Object) Violation.class) || !CollectionsKt.contains(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
