package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DefaultSpecialEffectsController$TransitionEffect$onStart$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ViewGroup $container;
    final /* synthetic */ Object $mergedTransition;
    final /* synthetic */ Ref.ObjectRef<Function0<Unit>> $seekCancelLambda;
    final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController$TransitionEffect$onStart$4(DefaultSpecialEffectsController.TransitionEffect transitionEffect, ViewGroup viewGroup, Object obj, Ref.ObjectRef<Function0<Unit>> objectRef) {
        super(0);
        this.this$0 = transitionEffect;
        this.$container = viewGroup;
        this.$mergedTransition = obj;
        this.$seekCancelLambda = objectRef;
    }

    public final void invoke() {
        DefaultSpecialEffectsController.TransitionEffect transitionEffect = this.this$0;
        transitionEffect.C(transitionEffect.v().j(this.$container, this.$mergedTransition));
        boolean z = this.this$0.s() != null;
        final Object obj = this.$mergedTransition;
        final ViewGroup viewGroup = this.$container;
        if (z) {
            Ref.ObjectRef<Function0<Unit>> objectRef = this.$seekCancelLambda;
            final DefaultSpecialEffectsController.TransitionEffect transitionEffect2 = this.this$0;
            objectRef.element = new Function0<Unit>() {
                /* access modifiers changed from: private */
                public static final void invoke$lambda$2(DefaultSpecialEffectsController.TransitionEffect transitionEffect, ViewGroup viewGroup) {
                    Intrinsics.checkNotNullParameter(transitionEffect, "this$0");
                    Intrinsics.checkNotNullParameter(viewGroup, "$container");
                    for (DefaultSpecialEffectsController.TransitionInfo a2 : transitionEffect.w()) {
                        SpecialEffectsController.Operation a3 = a2.a();
                        View view = a3.h().getView();
                        if (view != null) {
                            a3.g().applyState(view, viewGroup);
                        }
                    }
                }

                /* access modifiers changed from: private */
                public static final void invoke$lambda$4(DefaultSpecialEffectsController.TransitionEffect transitionEffect) {
                    Intrinsics.checkNotNullParameter(transitionEffect, "this$0");
                    if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "Transition for all operations has completed");
                    }
                    for (DefaultSpecialEffectsController.TransitionInfo a2 : transitionEffect.w()) {
                        a2.a().e(transitionEffect);
                    }
                }

                public final void invoke() {
                    List<DefaultSpecialEffectsController.TransitionInfo> w = transitionEffect2.w();
                    if (!(w instanceof Collection) || !w.isEmpty()) {
                        for (DefaultSpecialEffectsController.TransitionInfo a2 : w) {
                            if (!a2.a().m()) {
                                if (FragmentManager.T0(2)) {
                                    Log.v("FragmentManager", "Completing animating immediately");
                                }
                                CancellationSignal cancellationSignal = new CancellationSignal();
                                transitionEffect2.v().w(((DefaultSpecialEffectsController.TransitionInfo) transitionEffect2.w().get(0)).a().h(), obj, cancellationSignal, new i(transitionEffect2));
                                cancellationSignal.a();
                                return;
                            }
                        }
                    }
                    if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "Animating to start");
                    }
                    FragmentTransitionImpl v = transitionEffect2.v();
                    Object s = transitionEffect2.s();
                    Intrinsics.checkNotNull(s);
                    v.d(s, new h(transitionEffect2, viewGroup));
                }
            };
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Started executing operations from " + this.this$0.t() + " to " + this.this$0.u());
                return;
            }
            return;
        }
        throw new IllegalStateException(("Unable to start transition " + obj + " for container " + viewGroup + '.').toString());
    }
}
