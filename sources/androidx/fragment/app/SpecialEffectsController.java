package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.fragment.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0017\b \u0018\u0000 52\u00020\u0001:\u0004JKLMB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0011J\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u0019J\r\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001eH\u0000¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\r¢\u0006\u0004\b\"\u0010\u0019J*\u0010&\u001a\u00020\r2\u0011\u0010%\u001a\r\u0012\t\u0012\u00070\u001e¢\u0006\u0002\b$0#2\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b&\u0010'J\"\u0010(\u001a\u00020\r2\u0011\u0010%\u001a\r\u0012\t\u0012\u00070\u001e¢\u0006\u0002\b$0#H\u0010¢\u0006\u0004\b(\u0010)J\u0015\u0010,\u001a\u00020\r2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\r¢\u0006\u0004\b.\u0010\u0019J\u0019\u00101\u001a\u0004\u0018\u00010\u001e2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u0019\u00103\u001a\u0004\u0018\u00010\u001e2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b3\u00102J'\u00105\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b5\u00106J\u001d\u00109\u001a\u00020\u00142\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e07H\u0002¢\u0006\u0004\b9\u0010:J\u001d\u0010;\u001a\u00020\u00142\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e07H\u0002¢\u0006\u0004\b;\u0010:J\u000f\u0010<\u001a\u00020\rH\u0002¢\u0006\u0004\b<\u0010\u0019J\"\u0010=\u001a\u00020\r2\u0011\u0010%\u001a\r\u0012\t\u0012\u00070\u001e¢\u0006\u0002\b$0#H\u0002¢\u0006\u0004\b=\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001e078\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001e078\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010CR\u0016\u0010G\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010FR\u0016\u0010H\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010FR\u0016\u0010I\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010F¨\u0006N"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController;", "", "Landroid/view/ViewGroup;", "container", "<init>", "(Landroid/view/ViewGroup;)V", "Landroidx/fragment/app/FragmentStateManager;", "fragmentStateManager", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "s", "(Landroidx/fragment/app/FragmentStateManager;)Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "finalState", "", "j", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/FragmentStateManager;)V", "m", "(Landroidx/fragment/app/FragmentStateManager;)V", "k", "l", "", "isPop", "D", "(Z)V", "z", "()V", "y", "()Z", "r", "n", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "operation", "c", "(Landroidx/fragment/app/SpecialEffectsController$Operation;)V", "q", "", "Lkotlin/jvm/JvmSuppressWildcards;", "operations", "d", "(Ljava/util/List;Z)V", "e", "(Ljava/util/List;)V", "Landroidx/activity/BackEventCompat;", "backEvent", "A", "(Landroidx/activity/BackEventCompat;)V", "f", "Landroidx/fragment/app/Fragment;", "fragment", "o", "(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/SpecialEffectsController$Operation;", "p", "lifecycleImpact", "g", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;Landroidx/fragment/app/FragmentStateManager;)V", "", "newPendingOperations", "x", "(Ljava/util/List;)Z", "w", "C", "B", "a", "Landroid/view/ViewGroup;", "t", "()Landroid/view/ViewGroup;", "b", "Ljava/util/List;", "pendingOperations", "runningOperations", "Z", "runningNonSeekableTransition", "operationDirectionIsPop", "isContainerPostponed", "Companion", "Effect", "FragmentStateManagerOperation", "Operation", "fragment_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSpecialEffectsController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialEffectsController.kt\nandroidx/fragment/app/SpecialEffectsController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,900:1\n288#2,2:901\n288#2,2:903\n533#2,6:905\n1855#2,2:911\n1855#2:913\n1726#2,3:914\n1856#2:917\n1360#2:918\n1446#2,5:919\n1360#2:924\n1446#2,5:925\n1360#2:930\n1446#2,5:931\n1360#2:936\n1446#2,5:937\n*S KotlinDebug\n*F\n+ 1 SpecialEffectsController.kt\nandroidx/fragment/app/SpecialEffectsController\n*L\n67#1:901,2\n73#1:903,2\n170#1:905,6\n306#1:911,2\n316#1:913\n319#1:914,3\n316#1:917\n321#1:918\n321#1:919,5\n423#1:924\n423#1:925,5\n451#1:930\n451#1:931,5\n467#1:936\n467#1:937,5\n*E\n"})
public abstract class SpecialEffectsController {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f1319a;
    public final List b = new ArrayList();
    public final List c = new ArrayList();
    public boolean d;
    public boolean e;
    public boolean f;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Companion;", "", "<init>", "()V", "Landroid/view/ViewGroup;", "container", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroidx/fragment/app/SpecialEffectsController;", "a", "(Landroid/view/ViewGroup;Landroidx/fragment/app/FragmentManager;)Landroidx/fragment/app/SpecialEffectsController;", "Landroidx/fragment/app/SpecialEffectsControllerFactory;", "factory", "b", "(Landroid/view/ViewGroup;Landroidx/fragment/app/SpecialEffectsControllerFactory;)Landroidx/fragment/app/SpecialEffectsController;", "fragment_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SpecialEffectsController a(ViewGroup viewGroup, FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            SpecialEffectsControllerFactory L0 = fragmentManager.L0();
            Intrinsics.checkNotNullExpressionValue(L0, "fragmentManager.specialEffectsControllerFactory");
            return b(viewGroup, L0);
        }

        public final SpecialEffectsController b(ViewGroup viewGroup, SpecialEffectsControllerFactory specialEffectsControllerFactory) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            Intrinsics.checkNotNullParameter(specialEffectsControllerFactory, "factory");
            Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
            if (tag instanceof SpecialEffectsController) {
                return (SpecialEffectsController) tag;
            }
            SpecialEffectsController a2 = specialEffectsControllerFactory.a(viewGroup);
            Intrinsics.checkNotNullExpressionValue(a2, "factory.createController(container)");
            viewGroup.setTag(R.id.special_effects_controller_view_tag, a2);
            return a2;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bR\u001a\u0010\u0015\u001a\u00020\u00118\u0016XD¢\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012¨\u0006\u0018"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Effect;", "", "<init>", "()V", "Landroid/view/ViewGroup;", "container", "", "g", "(Landroid/view/ViewGroup;)V", "f", "Landroidx/activity/BackEventCompat;", "backEvent", "e", "(Landroidx/activity/BackEventCompat;Landroid/view/ViewGroup;)V", "d", "a", "c", "", "Z", "b", "()Z", "isSeekingSupported", "isStarted", "isCancelled", "fragment_release"}, k = 1, mv = {1, 8, 0})
    public static class Effect {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f1320a;
        public boolean b;
        public boolean c;

        public final void a(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            if (!this.c) {
                c(viewGroup);
            }
            this.c = true;
        }

        public boolean b() {
            return this.f1320a;
        }

        public void c(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
        }

        public void d(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
        }

        public void e(BackEventCompat backEventCompat, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(backEventCompat, "backEvent");
            Intrinsics.checkNotNullParameter(viewGroup, "container");
        }

        public void f(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
        }

        public final void g(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            if (!this.b) {
                f(viewGroup);
            }
            this.b = true;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0010¢\u0006\u0004\b\r\u0010\fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$FragmentStateManagerOperation;", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "lifecycleImpact", "Landroidx/fragment/app/FragmentStateManager;", "fragmentStateManager", "<init>", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;Landroidx/fragment/app/FragmentStateManager;)V", "", "p", "()V", "d", "l", "Landroidx/fragment/app/FragmentStateManager;", "fragment_release"}, k = 1, mv = {1, 8, 0})
    public static final class FragmentStateManagerOperation extends Operation {
        public final FragmentStateManager l;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public FragmentStateManagerOperation(androidx.fragment.app.SpecialEffectsController.Operation.State r3, androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact r4, androidx.fragment.app.FragmentStateManager r5) {
            /*
                r2 = this;
                java.lang.String r0 = "finalState"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = "lifecycleImpact"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = "fragmentStateManager"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                androidx.fragment.app.Fragment r0 = r5.k()
                java.lang.String r1 = "fragmentStateManager.fragment"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                r2.<init>(r3, r4, r0)
                r2.l = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.FragmentStateManagerOperation.<init>(androidx.fragment.app.SpecialEffectsController$Operation$State, androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact, androidx.fragment.app.FragmentStateManager):void");
        }

        public void d() {
            super.d();
            h().mTransitioning = false;
            this.l.m();
        }

        public void p() {
            if (!n()) {
                super.p();
                if (i() == Operation.LifecycleImpact.ADDING) {
                    Fragment k = this.l.k();
                    Intrinsics.checkNotNullExpressionValue(k, "fragmentStateManager.fragment");
                    View findFocus = k.mView.findFocus();
                    if (findFocus != null) {
                        k.setFocusedView(findFocus);
                        if (FragmentManager.T0(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + k);
                        }
                    }
                    View requireView = h().requireView();
                    Intrinsics.checkNotNullExpressionValue(requireView, "this.fragment.requireView()");
                    if (requireView.getParent() == null) {
                        this.l.b();
                        requireView.setAlpha(0.0f);
                    }
                    if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                        requireView.setVisibility(4);
                    }
                    requireView.setAlpha(k.getPostOnViewCreatedAlpha());
                } else if (i() == Operation.LifecycleImpact.REMOVING) {
                    Fragment k2 = this.l.k();
                    Intrinsics.checkNotNullExpressionValue(k2, "fragmentStateManager.fragment");
                    View requireView2 = k2.requireView();
                    Intrinsics.checkNotNullExpressionValue(requireView2, "fragment.requireView()");
                    if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + requireView2.findFocus() + " on view " + requireView2 + " for Fragment " + k2);
                    }
                    requireView2.clearFocus();
                }
            }
        }
    }

    @SourceDebugExtension({"SMAP\nSpecialEffectsController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialEffectsController.kt\nandroidx/fragment/app/SpecialEffectsController$Operation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,900:1\n1855#2,2:901\n1855#2,2:903\n*S KotlinDebug\n*F\n+ 1 SpecialEffectsController.kt\nandroidx/fragment/app/SpecialEffectsController$Operation\n*L\n671#1:901,2\n761#1:903,2\n*E\n"})
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001:\u0002FGB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000fH\u0011¢\u0006\u0004\b\u001f\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00140-8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010.R$\u00105\u001a\u0002002\u0006\u00101\u001a\u0002008\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\b3\u00104R$\u00108\u001a\u0002002\u0006\u00101\u001a\u0002008\u0006@BX\u000e¢\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104R*\u0010<\u001a\u0002002\u0006\u00101\u001a\u0002008\u0006@@X\u000e¢\u0006\u0012\n\u0004\b!\u00102\u001a\u0004\b9\u00104\"\u0004\b:\u0010;R$\u0010>\u001a\u0002002\u0006\u00101\u001a\u0002008\u0006@BX\u000e¢\u0006\f\n\u0004\b+\u00102\u001a\u0004\b=\u00104R\"\u0010A\u001a\u0002008\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u00102\u001a\u0004\b?\u00104\"\u0004\b@\u0010;R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00180-8\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010.R \u0010E\u001a\b\u0012\u0004\u0012\u00020\u00180C8\u0000X\u0004¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b6\u0010D¨\u0006H"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation;", "", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "lifecycleImpact", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;Landroidx/fragment/app/Fragment;)V", "", "toString", "()Ljava/lang/String;", "Landroid/view/ViewGroup;", "container", "", "c", "(Landroid/view/ViewGroup;)V", "o", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;)V", "Ljava/lang/Runnable;", "listener", "a", "(Ljava/lang/Runnable;)V", "Landroidx/fragment/app/SpecialEffectsController$Effect;", "effect", "b", "(Landroidx/fragment/app/SpecialEffectsController$Effect;)V", "e", "p", "()V", "d", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "g", "()Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "setFinalState", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;)V", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "i", "()Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "setLifecycleImpact", "(Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;)V", "Landroidx/fragment/app/Fragment;", "h", "()Landroidx/fragment/app/Fragment;", "", "Ljava/util/List;", "completionListeners", "", "<set-?>", "Z", "k", "()Z", "isCanceled", "f", "l", "isComplete", "m", "r", "(Z)V", "isSeeking", "n", "isStarted", "j", "q", "isAwaitingContainerChanges", "_effects", "", "()Ljava/util/List;", "effects", "LifecycleImpact", "State", "fragment_release"}, k = 1, mv = {1, 8, 0})
    public static class Operation {

        /* renamed from: a  reason: collision with root package name */
        public State f1321a;
        public LifecycleImpact b;
        public final Fragment c;
        public final List d = new ArrayList();
        public boolean e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i = true;
        public final List j;
        public final List k;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "", "(Ljava/lang/String;I)V", "NONE", "ADDING", "REMOVING", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "", "(Ljava/lang/String;I)V", "applyState", "", "view", "Landroid/view/View;", "container", "Landroid/view/ViewGroup;", "REMOVED", "VISIBLE", "GONE", "INVISIBLE", "Companion", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;
            
            @NotNull
            public static final Companion Companion = null;

            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$State$Companion;", "", "<init>", "()V", "Landroid/view/View;", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "a", "(Landroid/view/View;)Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "", "visibility", "b", "(I)Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "fragment_release"}, k = 1, mv = {1, 8, 0})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final State a(View view) {
                    Intrinsics.checkNotNullParameter(view, "<this>");
                    return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? State.INVISIBLE : b(view.getVisibility());
                }

                public final State b(int i) {
                    if (i == 0) {
                        return State.VISIBLE;
                    }
                    if (i == 4) {
                        return State.INVISIBLE;
                    }
                    if (i == 8) {
                        return State.GONE;
                    }
                    throw new IllegalArgumentException("Unknown visibility " + i);
                }

                public Companion() {
                }
            }

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

                /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
                static {
                    /*
                        androidx.fragment.app.SpecialEffectsController$Operation$State[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x0010 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                        r2 = 1
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                    L_0x0010:
                        androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0019 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                        r2 = 2
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                    L_0x0019:
                        androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                        r2 = 3
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                    L_0x0022:
                        androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x002b }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                        r2 = 4
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                    L_0x002b:
                        $EnumSwitchMapping$0 = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.Operation.State.WhenMappings.<clinit>():void");
                }
            }

            static {
                Companion = new Companion((DefaultConstructorMarker) null);
            }

            @JvmStatic
            @NotNull
            public static final State from(int i) {
                return Companion.b(i);
            }

            /* JADX WARNING: type inference failed for: r4v3, types: [android.view.ViewParent] */
            /* JADX WARNING: type inference failed for: r4v8, types: [android.view.ViewParent] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Unknown variable types count: 2 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void applyState(@org.jetbrains.annotations.NotNull android.view.View r5, @org.jetbrains.annotations.NotNull android.view.ViewGroup r6) {
                /*
                    r4 = this;
                    java.lang.String r0 = "view"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                    java.lang.String r0 = "container"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                    int[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.State.WhenMappings.$EnumSwitchMapping$0
                    int r4 = r4.ordinal()
                    r4 = r0[r4]
                    r0 = 1
                    r1 = 0
                    java.lang.String r2 = "FragmentManager"
                    r3 = 2
                    if (r4 == r0) goto L_0x00bf
                    java.lang.String r0 = "SpecialEffectsController: Setting view "
                    if (r4 == r3) goto L_0x006b
                    r6 = 3
                    if (r4 == r6) goto L_0x0047
                    r6 = 4
                    if (r4 == r6) goto L_0x0025
                    goto L_0x00f1
                L_0x0025:
                    boolean r4 = androidx.fragment.app.FragmentManager.T0(r3)
                    if (r4 == 0) goto L_0x0042
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    r4.append(r0)
                    r4.append(r5)
                    java.lang.String r0 = " to INVISIBLE"
                    r4.append(r0)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.v(r2, r4)
                L_0x0042:
                    r5.setVisibility(r6)
                    goto L_0x00f1
                L_0x0047:
                    boolean r4 = androidx.fragment.app.FragmentManager.T0(r3)
                    if (r4 == 0) goto L_0x0064
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    r4.append(r0)
                    r4.append(r5)
                    java.lang.String r6 = " to GONE"
                    r4.append(r6)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.v(r2, r4)
                L_0x0064:
                    r4 = 8
                    r5.setVisibility(r4)
                    goto L_0x00f1
                L_0x006b:
                    boolean r4 = androidx.fragment.app.FragmentManager.T0(r3)
                    if (r4 == 0) goto L_0x0088
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    r4.append(r0)
                    r4.append(r5)
                    java.lang.String r0 = " to VISIBLE"
                    r4.append(r0)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.v(r2, r4)
                L_0x0088:
                    android.view.ViewParent r4 = r5.getParent()
                    boolean r0 = r4 instanceof android.view.ViewGroup
                    if (r0 == 0) goto L_0x0093
                    r1 = r4
                    android.view.ViewGroup r1 = (android.view.ViewGroup) r1
                L_0x0093:
                    if (r1 != 0) goto L_0x00ba
                    boolean r4 = androidx.fragment.app.FragmentManager.T0(r3)
                    if (r4 == 0) goto L_0x00b7
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.lang.String r0 = "SpecialEffectsController: Adding view "
                    r4.append(r0)
                    r4.append(r5)
                    java.lang.String r0 = " to Container "
                    r4.append(r0)
                    r4.append(r6)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.v(r2, r4)
                L_0x00b7:
                    r6.addView(r5)
                L_0x00ba:
                    r4 = 0
                    r5.setVisibility(r4)
                    goto L_0x00f1
                L_0x00bf:
                    android.view.ViewParent r4 = r5.getParent()
                    boolean r6 = r4 instanceof android.view.ViewGroup
                    if (r6 == 0) goto L_0x00ca
                    r1 = r4
                    android.view.ViewGroup r1 = (android.view.ViewGroup) r1
                L_0x00ca:
                    if (r1 == 0) goto L_0x00f1
                    boolean r4 = androidx.fragment.app.FragmentManager.T0(r3)
                    if (r4 == 0) goto L_0x00ee
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.lang.String r6 = "SpecialEffectsController: Removing view "
                    r4.append(r6)
                    r4.append(r5)
                    java.lang.String r6 = " from container "
                    r4.append(r6)
                    r4.append(r1)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.v(r2, r4)
                L_0x00ee:
                    r1.removeView(r5)
                L_0x00f1:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.Operation.State.applyState(android.view.View, android.view.ViewGroup):void");
            }
        }

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            static {
                /*
                    androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r1 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.ADDING     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r1 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.REMOVING     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r1 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.NONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.Operation.WhenMappings.<clinit>():void");
            }
        }

        public Operation(State state, LifecycleImpact lifecycleImpact, Fragment fragment) {
            Intrinsics.checkNotNullParameter(state, "finalState");
            Intrinsics.checkNotNullParameter(lifecycleImpact, "lifecycleImpact");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.f1321a = state;
            this.b = lifecycleImpact;
            this.c = fragment;
            ArrayList arrayList = new ArrayList();
            this.j = arrayList;
            this.k = arrayList;
        }

        public final void a(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.d.add(runnable);
        }

        public final void b(Effect effect) {
            Intrinsics.checkNotNullParameter(effect, "effect");
            this.j.add(effect);
        }

        public final void c(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            this.h = false;
            if (!this.e) {
                this.e = true;
                if (this.j.isEmpty()) {
                    d();
                    return;
                }
                for (Effect a2 : CollectionsKt.toList(this.k)) {
                    a2.a(viewGroup);
                }
            }
        }

        public void d() {
            this.h = false;
            if (!this.f) {
                if (FragmentManager.T0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
                }
                this.f = true;
                for (Runnable run : this.d) {
                    run.run();
                }
            }
        }

        public final void e(Effect effect) {
            Intrinsics.checkNotNullParameter(effect, "effect");
            if (this.j.remove(effect) && this.j.isEmpty()) {
                d();
            }
        }

        public final List f() {
            return this.k;
        }

        public final State g() {
            return this.f1321a;
        }

        public final Fragment h() {
            return this.c;
        }

        public final LifecycleImpact i() {
            return this.b;
        }

        public final boolean j() {
            return this.i;
        }

        public final boolean k() {
            return this.e;
        }

        public final boolean l() {
            return this.f;
        }

        public final boolean m() {
            return this.g;
        }

        public final boolean n() {
            return this.h;
        }

        public final void o(State state, LifecycleImpact lifecycleImpact) {
            Intrinsics.checkNotNullParameter(state, "finalState");
            Intrinsics.checkNotNullParameter(lifecycleImpact, "lifecycleImpact");
            int i2 = WhenMappings.$EnumSwitchMapping$0[lifecycleImpact.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.f1321a + " -> REMOVED. mLifecycleImpact  = " + this.b + " to REMOVING.");
                    }
                    this.f1321a = State.REMOVED;
                    this.b = LifecycleImpact.REMOVING;
                    this.i = true;
                } else if (i2 == 3 && this.f1321a != State.REMOVED) {
                    if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.f1321a + " -> " + state + '.');
                    }
                    this.f1321a = state;
                }
            } else if (this.f1321a == State.REMOVED) {
                if (FragmentManager.T0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.b + " to ADDING.");
                }
                this.f1321a = State.VISIBLE;
                this.b = LifecycleImpact.ADDING;
                this.i = true;
            }
        }

        public void p() {
            this.h = true;
        }

        public final void q(boolean z) {
            this.i = z;
        }

        public final void r(boolean z) {
            this.g = z;
        }

        public String toString() {
            String hexString = Integer.toHexString(System.identityHashCode(this));
            return "Operation {" + hexString + "} {finalState = " + this.f1321a + " lifecycleImpact = " + this.b + " fragment = " + this.c + '}';
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            try {
                iArr[Operation.LifecycleImpact.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SpecialEffectsController(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        this.f1319a = viewGroup;
    }

    public static final void h(SpecialEffectsController specialEffectsController, FragmentStateManagerOperation fragmentStateManagerOperation) {
        Intrinsics.checkNotNullParameter(specialEffectsController, "this$0");
        Intrinsics.checkNotNullParameter(fragmentStateManagerOperation, "$operation");
        if (specialEffectsController.b.contains(fragmentStateManagerOperation)) {
            Operation.State g2 = fragmentStateManagerOperation.g();
            View view = fragmentStateManagerOperation.h().mView;
            Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
            g2.applyState(view, specialEffectsController.f1319a);
        }
    }

    public static final void i(SpecialEffectsController specialEffectsController, FragmentStateManagerOperation fragmentStateManagerOperation) {
        Intrinsics.checkNotNullParameter(specialEffectsController, "this$0");
        Intrinsics.checkNotNullParameter(fragmentStateManagerOperation, "$operation");
        specialEffectsController.b.remove(fragmentStateManagerOperation);
        specialEffectsController.c.remove(fragmentStateManagerOperation);
    }

    public static final SpecialEffectsController u(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return g.a(viewGroup, fragmentManager);
    }

    public static final SpecialEffectsController v(ViewGroup viewGroup, SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        return g.b(viewGroup, specialEffectsControllerFactory);
    }

    public final void A(BackEventCompat backEventCompat) {
        Intrinsics.checkNotNullParameter(backEventCompat, "backEvent");
        if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + backEventCompat.a());
        }
        List<Operation> list = this.c;
        ArrayList arrayList = new ArrayList();
        for (Operation f2 : list) {
            CollectionsKt.addAll(arrayList, f2.f());
        }
        List list2 = CollectionsKt.toList(CollectionsKt.toSet(arrayList));
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            ((Effect) list2.get(i)).e(backEventCompat, this.f1319a);
        }
    }

    public final void B(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((Operation) list.get(i)).p();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((Operation) it.next()).f());
        }
        List list2 = CollectionsKt.toList(CollectionsKt.toSet(arrayList));
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((Effect) list2.get(i2)).g(this.f1319a);
        }
    }

    public final void C() {
        for (Operation operation : this.b) {
            if (operation.i() == Operation.LifecycleImpact.ADDING) {
                View requireView = operation.h().requireView();
                Intrinsics.checkNotNullExpressionValue(requireView, "fragment.requireView()");
                operation.o(Operation.State.Companion.b(requireView.getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public final void D(boolean z) {
        this.e = z;
    }

    public final void c(Operation operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (operation.j()) {
            Operation.State g2 = operation.g();
            View requireView = operation.h().requireView();
            Intrinsics.checkNotNullExpressionValue(requireView, "operation.fragment.requireView()");
            g2.applyState(requireView, this.f1319a);
            operation.q(false);
        }
    }

    public abstract void d(List list, boolean z);

    public void e(List list) {
        Intrinsics.checkNotNullParameter(list, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((Operation) it.next()).f());
        }
        List list2 = CollectionsKt.toList(CollectionsKt.toSet(arrayList));
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            ((Effect) list2.get(i)).d(this.f1319a);
        }
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            c((Operation) list.get(i2));
        }
        List list3 = CollectionsKt.toList(list);
        int size3 = list3.size();
        for (int i3 = 0; i3 < size3; i3++) {
            Operation operation = (Operation) list3.get(i3);
            if (operation.f().isEmpty()) {
                operation.d();
            }
        }
    }

    public final void f() {
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
        }
        B(this.c);
        e(this.c);
    }

    public final void g(Operation.State state, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager) {
        synchronized (this.b) {
            try {
                Fragment k = fragmentStateManager.k();
                Intrinsics.checkNotNullExpressionValue(k, "fragmentStateManager.fragment");
                Operation o = o(k);
                if (o == null) {
                    if (fragmentStateManager.k().mTransitioning) {
                        Fragment k2 = fragmentStateManager.k();
                        Intrinsics.checkNotNullExpressionValue(k2, "fragmentStateManager.fragment");
                        o = p(k2);
                    } else {
                        o = null;
                    }
                }
                if (o != null) {
                    o.o(state, lifecycleImpact);
                    return;
                }
                FragmentStateManagerOperation fragmentStateManagerOperation = new FragmentStateManagerOperation(state, lifecycleImpact, fragmentStateManager);
                this.b.add(fragmentStateManagerOperation);
                fragmentStateManagerOperation.a(new j(this, fragmentStateManagerOperation));
                fragmentStateManagerOperation.a(new k(this, fragmentStateManagerOperation));
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(Operation.State state, FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(state, "finalState");
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.k());
        }
        g(state, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    public final void k(FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.k());
        }
        g(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public final void l(FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.k());
        }
        g(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    public final void m(FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.k());
        }
        g(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public final void n() {
        if (!this.f) {
            if (!this.f1319a.isAttachedToWindow()) {
                q();
                this.e = false;
                return;
            }
            synchronized (this.b) {
                try {
                    List<Operation> mutableList = CollectionsKt.toMutableList(this.c);
                    this.c.clear();
                    for (Operation operation : mutableList) {
                        operation.r((this.b.isEmpty() ^ true) && operation.h().mTransitioning);
                    }
                    for (Operation operation2 : mutableList) {
                        if (this.d) {
                            if (FragmentManager.T0(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Completing non-seekable operation " + operation2);
                            }
                            operation2.d();
                        } else {
                            if (FragmentManager.T0(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation2);
                            }
                            operation2.c(this.f1319a);
                        }
                        this.d = false;
                        if (!operation2.l()) {
                            this.c.add(operation2);
                        }
                    }
                    if (!this.b.isEmpty()) {
                        C();
                        List mutableList2 = CollectionsKt.toMutableList(this.b);
                        if (!mutableList2.isEmpty()) {
                            this.b.clear();
                            this.c.addAll(mutableList2);
                            if (FragmentManager.T0(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                            }
                            d(mutableList2, this.e);
                            boolean w = w(mutableList2);
                            boolean x = x(mutableList2);
                            this.d = x && !w;
                            if (FragmentManager.T0(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Operation seekable = " + w + " \ntransition = " + x);
                            }
                            if (!x) {
                                B(mutableList2);
                                e(mutableList2);
                            } else if (w) {
                                B(mutableList2);
                                int size = mutableList2.size();
                                for (int i = 0; i < size; i++) {
                                    c((Operation) mutableList2.get(i));
                                }
                            }
                            this.e = false;
                            if (FragmentManager.T0(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                            }
                        } else {
                            return;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                }
            }
        }
    }

    public final Operation o(Fragment fragment) {
        Object obj;
        Iterator it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Operation operation = (Operation) obj;
            if (Intrinsics.areEqual((Object) operation.h(), (Object) fragment) && !operation.k()) {
                break;
            }
        }
        return (Operation) obj;
    }

    public final Operation p(Fragment fragment) {
        Object obj;
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Operation operation = (Operation) obj;
            if (Intrinsics.areEqual((Object) operation.h(), (Object) fragment) && !operation.k()) {
                break;
            }
        }
        return (Operation) obj;
    }

    public final void q() {
        String str;
        String str2;
        if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean isAttachedToWindow = this.f1319a.isAttachedToWindow();
        synchronized (this.b) {
            try {
                C();
                B(this.b);
                List<Operation> mutableList = CollectionsKt.toMutableList(this.c);
                for (Operation r : mutableList) {
                    r.r(false);
                }
                for (Operation operation : mutableList) {
                    if (FragmentManager.T0(2)) {
                        if (isAttachedToWindow) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f1319a + " is not attached to window. ";
                        }
                        Log.v("FragmentManager", "SpecialEffectsController: " + str2 + "Cancelling running operation " + operation);
                    }
                    operation.c(this.f1319a);
                }
                List<Operation> mutableList2 = CollectionsKt.toMutableList(this.b);
                for (Operation r2 : mutableList2) {
                    r2.r(false);
                }
                for (Operation operation2 : mutableList2) {
                    if (FragmentManager.T0(2)) {
                        if (isAttachedToWindow) {
                            str = "";
                        } else {
                            str = "Container " + this.f1319a + " is not attached to window. ";
                        }
                        Log.v("FragmentManager", "SpecialEffectsController: " + str + "Cancelling pending operation " + operation2);
                    }
                    operation2.c(this.f1319a);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r() {
        if (this.f) {
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f = false;
            n();
        }
    }

    public final Operation.LifecycleImpact s(FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        Fragment k = fragmentStateManager.k();
        Intrinsics.checkNotNullExpressionValue(k, "fragmentStateManager.fragment");
        Operation o = o(k);
        Operation.LifecycleImpact lifecycleImpact = null;
        Operation.LifecycleImpact i = o != null ? o.i() : null;
        Operation p = p(k);
        if (p != null) {
            lifecycleImpact = p.i();
        }
        int i2 = i == null ? -1 : WhenMappings.$EnumSwitchMapping$0[i.ordinal()];
        return (i2 == -1 || i2 == 1) ? lifecycleImpact : i;
    }

    public final ViewGroup t() {
        return this.f1319a;
    }

    public final boolean w(List list) {
        boolean z;
        Iterator it = list.iterator();
        loop0:
        while (true) {
            z = true;
            while (it.hasNext()) {
                Operation operation = (Operation) it.next();
                if (!operation.f().isEmpty()) {
                    List<Effect> f2 = operation.f();
                    if (!(f2 instanceof Collection) || !f2.isEmpty()) {
                        for (Effect b2 : f2) {
                            if (!b2.b()) {
                            }
                        }
                    }
                }
                z = false;
            }
            break loop0;
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                CollectionsKt.addAll(arrayList, ((Operation) it2.next()).f());
            }
            if (!arrayList.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final boolean x(List list) {
        Iterator it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!((Operation) it.next()).h().mTransitioning) {
                z = false;
            }
        }
        return z;
    }

    public final boolean y() {
        return !this.b.isEmpty();
    }

    public final void z() {
        Fragment fragment;
        Object obj;
        synchronized (this.b) {
            try {
                C();
                List list = this.b;
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    fragment = null;
                    if (!listIterator.hasPrevious()) {
                        obj = null;
                        break;
                    }
                    obj = listIterator.previous();
                    Operation operation = (Operation) obj;
                    Operation.State.Companion companion = Operation.State.Companion;
                    View view = operation.h().mView;
                    Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
                    Operation.State a2 = companion.a(view);
                    Operation.State g2 = operation.g();
                    Operation.State state = Operation.State.VISIBLE;
                    if (g2 == state && a2 != state) {
                        break;
                    }
                }
                Operation operation2 = (Operation) obj;
                if (operation2 != null) {
                    fragment = operation2.h();
                }
                this.f = fragment != null ? fragment.isPostponed() : false;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
