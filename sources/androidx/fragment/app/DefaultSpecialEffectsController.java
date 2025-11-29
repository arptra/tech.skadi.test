package androidx.fragment.app;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.BackEventCompat;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001:\b%&'()*+,B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0003¢\u0006\u0004\b\u0012\u0010\u000fJ9\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001e\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010#\u001a\u00020\u000b2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0 2\u0006\u0010\"\u001a\u00020\u001bH\u0002¢\u0006\u0004\b#\u0010$¨\u0006-"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController;", "Landroidx/fragment/app/SpecialEffectsController;", "Landroid/view/ViewGroup;", "container", "<init>", "(Landroid/view/ViewGroup;)V", "", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "operations", "", "isPop", "", "d", "(Ljava/util/List;Z)V", "K", "(Ljava/util/List;)V", "Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "animationInfos", "F", "Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "transitionInfos", "firstOut", "lastIn", "H", "(Ljava/util/List;ZLandroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/fragment/app/SpecialEffectsController$Operation;)V", "Landroidx/collection/ArrayMap;", "", "Landroid/view/View;", "", "names", "J", "(Landroidx/collection/ArrayMap;Ljava/util/Collection;)V", "", "namedViews", "view", "I", "(Ljava/util/Map;Landroid/view/View;)V", "AnimationEffect", "AnimationInfo", "AnimatorEffect", "Api24Impl", "Api26Impl", "SpecialEffectsInfo", "TransitionEffect", "TransitionInfo", "fragment_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDefaultSpecialEffectsController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultSpecialEffectsController.kt\nandroidx/fragment/app/DefaultSpecialEffectsController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1151:1\n288#2,2:1152\n533#2,6:1154\n1360#2:1160\n1446#2,5:1161\n819#2:1166\n847#2,2:1167\n766#2:1169\n857#2,2:1170\n1789#2,3:1172\n1726#2,3:1175\n1855#2,2:1178\n*S KotlinDebug\n*F\n+ 1 DefaultSpecialEffectsController.kt\nandroidx/fragment/app/DefaultSpecialEffectsController\n*L\n52#1:1152,2\n58#1:1154,6\n117#1:1160\n117#1:1161,5\n190#1:1166\n190#1:1167,2\n193#1:1169\n193#1:1170,2\n197#1:1172,3\n355#1:1175,3\n366#1:1178,2\n*E\n"})
public final class DefaultSpecialEffectsController extends SpecialEffectsController {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationEffect;", "Landroidx/fragment/app/SpecialEffectsController$Effect;", "Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "animationInfo", "<init>", "(Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;)V", "Landroid/view/ViewGroup;", "container", "", "d", "(Landroid/view/ViewGroup;)V", "c", "Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "h", "()Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "fragment_release"}, k = 1, mv = {1, 8, 0})
    public static final class AnimationEffect extends SpecialEffectsController.Effect {
        public final AnimationInfo d;

        public AnimationEffect(AnimationInfo animationInfo) {
            Intrinsics.checkNotNullParameter(animationInfo, "animationInfo");
            this.d = animationInfo;
        }

        public void c(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            SpecialEffectsController.Operation a2 = this.d.a();
            View view = a2.h().mView;
            view.clearAnimation();
            viewGroup.endViewTransition(view);
            this.d.a().e(this);
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Animation from operation " + a2 + " has been cancelled.");
            }
        }

        public void d(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            if (this.d.b()) {
                this.d.a().e(this);
                return;
            }
            Context context = viewGroup.getContext();
            SpecialEffectsController.Operation a2 = this.d.a();
            View view = a2.h().mView;
            AnimationInfo animationInfo = this.d;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentAnim.AnimationOrAnimator c = animationInfo.c(context);
            if (c != null) {
                Animation animation = c.f1269a;
                if (animation == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                } else if (a2.g() != SpecialEffectsController.Operation.State.REMOVED) {
                    view.startAnimation(animation);
                    this.d.a().e(this);
                } else {
                    viewGroup.startViewTransition(view);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation, viewGroup, view);
                    endViewTransitionAnimation.setAnimationListener(new DefaultSpecialEffectsController$AnimationEffect$onCommit$1(a2, viewGroup, view, this));
                    view.startAnimation(endViewTransitionAnimation);
                    if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "Animation from operation " + a2 + " has started.");
                    }
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }

        public final AnimationInfo h() {
            return this.d;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "operation", "", "isPop", "<init>", "(Landroidx/fragment/app/SpecialEffectsController$Operation;Z)V", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentAnim$AnimationOrAnimator;", "c", "(Landroid/content/Context;)Landroidx/fragment/app/FragmentAnim$AnimationOrAnimator;", "b", "Z", "isAnimLoaded", "d", "Landroidx/fragment/app/FragmentAnim$AnimationOrAnimator;", "animation", "fragment_release"}, k = 1, mv = {1, 8, 0})
    public static final class AnimationInfo extends SpecialEffectsInfo {
        public final boolean b;
        public boolean c;
        public FragmentAnim.AnimationOrAnimator d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AnimationInfo(SpecialEffectsController.Operation operation, boolean z) {
            super(operation);
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.b = z;
        }

        public final FragmentAnim.AnimationOrAnimator c(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (this.c) {
                return this.d;
            }
            FragmentAnim.AnimationOrAnimator b2 = FragmentAnim.b(context, a().h(), a().g() == SpecialEffectsController.Operation.State.VISIBLE, this.b);
            this.d = b2;
            this.c = true;
            return b2;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$AnimatorEffect;", "Landroidx/fragment/app/SpecialEffectsController$Effect;", "Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "animatorInfo", "<init>", "(Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;)V", "Landroid/view/ViewGroup;", "container", "", "f", "(Landroid/view/ViewGroup;)V", "Landroidx/activity/BackEventCompat;", "backEvent", "e", "(Landroidx/activity/BackEventCompat;Landroid/view/ViewGroup;)V", "d", "c", "Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "h", "()Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "Landroid/animation/AnimatorSet;", "Landroid/animation/AnimatorSet;", "getAnimator", "()Landroid/animation/AnimatorSet;", "setAnimator", "(Landroid/animation/AnimatorSet;)V", "animator", "", "b", "()Z", "isSeekingSupported", "fragment_release"}, k = 1, mv = {1, 8, 0})
    public static final class AnimatorEffect extends SpecialEffectsController.Effect {
        public final AnimationInfo d;
        public AnimatorSet e;

        public AnimatorEffect(AnimationInfo animationInfo) {
            Intrinsics.checkNotNullParameter(animationInfo, "animatorInfo");
            this.d = animationInfo;
        }

        public boolean b() {
            return true;
        }

        public void c(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            AnimatorSet animatorSet = this.e;
            if (animatorSet == null) {
                this.d.a().e(this);
                return;
            }
            SpecialEffectsController.Operation a2 = this.d.a();
            if (a2.m()) {
                Api26Impl.f1251a.a(animatorSet);
            } else {
                animatorSet.end();
            }
            if (FragmentManager.T0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Animator from operation ");
                sb.append(a2);
                sb.append(" has been canceled");
                sb.append(a2.m() ? " with seeking." : ".");
                sb.append(' ');
                Log.v("FragmentManager", sb.toString());
            }
        }

        public void d(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            SpecialEffectsController.Operation a2 = this.d.a();
            AnimatorSet animatorSet = this.e;
            if (animatorSet == null) {
                this.d.a().e(this);
                return;
            }
            animatorSet.start();
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Animator from operation " + a2 + " has started.");
            }
        }

        public void e(BackEventCompat backEventCompat, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(backEventCompat, "backEvent");
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            SpecialEffectsController.Operation a2 = this.d.a();
            AnimatorSet animatorSet = this.e;
            if (animatorSet == null) {
                this.d.a().e(this);
            } else if (Build.VERSION.SDK_INT >= 34 && a2.h().mTransitioning) {
                if (FragmentManager.T0(2)) {
                    Log.v("FragmentManager", "Adding BackProgressCallbacks for Animators to operation " + a2);
                }
                long a3 = Api24Impl.f1250a.a(animatorSet);
                long a4 = (long) (backEventCompat.a() * ((float) a3));
                if (a4 == 0) {
                    a4 = 1;
                }
                if (a4 == a3) {
                    a4 = a3 - 1;
                }
                if (FragmentManager.T0(2)) {
                    Log.v("FragmentManager", "Setting currentPlayTime to " + a4 + " for Animator " + animatorSet + " on operation " + a2);
                }
                Api26Impl.f1251a.b(animatorSet, a4);
            }
        }

        public void f(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            if (!this.d.b()) {
                Context context = viewGroup.getContext();
                AnimationInfo animationInfo = this.d;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                FragmentAnim.AnimationOrAnimator c = animationInfo.c(context);
                this.e = c != null ? c.b : null;
                SpecialEffectsController.Operation a2 = this.d.a();
                Fragment h = a2.h();
                boolean z = a2.g() == SpecialEffectsController.Operation.State.GONE;
                View view = h.mView;
                viewGroup.startViewTransition(view);
                AnimatorSet animatorSet = this.e;
                if (animatorSet != null) {
                    animatorSet.addListener(new DefaultSpecialEffectsController$AnimatorEffect$onStart$1(viewGroup, view, z, a2, this));
                }
                AnimatorSet animatorSet2 = this.e;
                if (animatorSet2 != null) {
                    animatorSet2.setTarget(view);
                }
            }
        }

        public final AnimationInfo h() {
            return this.d;
        }
    }

    @RequiresApi
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$Api24Impl;", "", "<init>", "()V", "Landroid/animation/AnimatorSet;", "animatorSet", "", "a", "(Landroid/animation/AnimatorSet;)J", "fragment_release"}, k = 1, mv = {1, 8, 0})
    public static final class Api24Impl {

        /* renamed from: a  reason: collision with root package name */
        public static final Api24Impl f1250a = new Api24Impl();

        @DoNotInline
        public final long a(@NotNull AnimatorSet animatorSet) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            return animatorSet.getTotalDuration();
        }
    }

    @RequiresApi
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$Api26Impl;", "", "<init>", "()V", "Landroid/animation/AnimatorSet;", "animatorSet", "", "a", "(Landroid/animation/AnimatorSet;)V", "", "time", "b", "(Landroid/animation/AnimatorSet;J)V", "fragment_release"}, k = 1, mv = {1, 8, 0})
    public static final class Api26Impl {

        /* renamed from: a  reason: collision with root package name */
        public static final Api26Impl f1251a = new Api26Impl();

        @DoNotInline
        public final void a(@NotNull AnimatorSet animatorSet) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            animatorSet.reverse();
        }

        @DoNotInline
        public final void b(@NotNull AnimatorSet animatorSet, long j) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            animatorSet.setCurrentPlayTime(j);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "operation", "<init>", "(Landroidx/fragment/app/SpecialEffectsController$Operation;)V", "a", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "()Landroidx/fragment/app/SpecialEffectsController$Operation;", "", "b", "()Z", "isVisibilityUnchanged", "fragment_release"}, k = 1, mv = {1, 8, 0})
    public static class SpecialEffectsInfo {

        /* renamed from: a  reason: collision with root package name */
        public final SpecialEffectsController.Operation f1252a;

        public SpecialEffectsInfo(SpecialEffectsController.Operation operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.f1252a = operation;
        }

        public final SpecialEffectsController.Operation a() {
            return this.f1252a;
        }

        public final boolean b() {
            SpecialEffectsController.Operation.State state;
            View view = this.f1252a.h().mView;
            SpecialEffectsController.Operation.State a2 = view != null ? SpecialEffectsController.Operation.State.Companion.a(view) : null;
            SpecialEffectsController.Operation.State g = this.f1252a.g();
            return a2 == g || !(a2 == (state = SpecialEffectsController.Operation.State.VISIBLE) || g == state);
        }
    }

    @SourceDebugExtension({"SMAP\nDefaultSpecialEffectsController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultSpecialEffectsController.kt\nandroidx/fragment/app/DefaultSpecialEffectsController$TransitionEffect\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1151:1\n1726#2,3:1152\n1726#2,3:1155\n1855#2,2:1158\n1549#2:1160\n1620#2,3:1161\n1855#2,2:1164\n1855#2,2:1167\n1549#2:1169\n1620#2,3:1170\n1855#2,2:1173\n1#3:1166\n*S KotlinDebug\n*F\n+ 1 DefaultSpecialEffectsController.kt\nandroidx/fragment/app/DefaultSpecialEffectsController$TransitionEffect\n*L\n722#1:1152,3\n731#1:1155,3\n739#1:1158,2\n768#1:1160\n768#1:1161,3\n768#1:1164,2\n846#1:1167,2\n867#1:1169\n867#1:1170,3\n867#1:1173,2\n*E\n"})
    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u0001Bß\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\fj\b\u0012\u0004\u0012\u00020\u0012`\u000e\u0012\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00120\fj\b\u0012\u0004\u0012\u00020\u0012`\u000e\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u0011\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJG\u0010\u001f\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e\u0012\u0004\u0012\u00020\n0\u001e2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001f\u0010 J=\u0010%\u001a\u00020#2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002¢\u0006\u0004\b%\u0010&J/\u0010)\u001a\u00020#2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010(\u001a\u00020\rH\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010/\u001a\u00020#2\u0006\u0010.\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b1\u0010,J\u0017\u00102\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b2\u0010,R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b1\u00103\u001a\u0004\b4\u00105R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b/\u00106\u001a\u0004\b7\u00108R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b+\u00106\u001a\u0004\b9\u00108R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e8\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER'\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e8\u0006¢\u0006\f\n\u0004\bF\u0010C\u001a\u0004\bG\u0010ER#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR'\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\fj\b\u0012\u0004\u0012\u00020\u0012`\u000e8\u0006¢\u0006\f\n\u0004\bL\u0010C\u001a\u0004\bM\u0010ER'\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00120\fj\b\u0012\u0004\u0012\u00020\u0012`\u000e8\u0006¢\u0006\f\n\u0004\bN\u0010C\u001a\u0004\bO\u0010ER#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u00118\u0006¢\u0006\f\n\u0004\b)\u0010I\u001a\u0004\bP\u0010KR#\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u00118\u0006¢\u0006\f\n\u0004\b\u001f\u0010I\u001a\u0004\bQ\u0010KR\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\b\u0019\u0010TR\u001d\u0010\\\u001a\u00020U8\u0006¢\u0006\u0012\n\u0004\bV\u0010W\u0012\u0004\bZ\u0010[\u001a\u0004\bX\u0010YR$\u0010a\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b]\u0010?\u001a\u0004\b^\u0010A\"\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\bb\u0010TR\u0011\u0010e\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bd\u0010T¨\u0006f"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionEffect;", "Landroidx/fragment/app/SpecialEffectsController$Effect;", "", "Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "transitionInfos", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "firstOut", "lastIn", "Landroidx/fragment/app/FragmentTransitionImpl;", "transitionImpl", "", "sharedElementTransition", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "sharedElementFirstOutViews", "sharedElementLastInViews", "Landroidx/collection/ArrayMap;", "", "sharedElementNameMapping", "enteringNames", "exitingNames", "firstOutViews", "lastInViews", "", "isPop", "<init>", "(Ljava/util/List;Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/fragment/app/FragmentTransitionImpl;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/ArrayList;Landroidx/collection/ArrayMap;Ljava/util/ArrayList;Ljava/util/ArrayList;Landroidx/collection/ArrayMap;Landroidx/collection/ArrayMap;Z)V", "Landroid/view/ViewGroup;", "container", "Lkotlin/Pair;", "o", "(Landroid/view/ViewGroup;Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/fragment/app/SpecialEffectsController$Operation;)Lkotlin/Pair;", "enteringViews", "Lkotlin/Function0;", "", "executeTransition", "B", "(Ljava/util/ArrayList;Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)V", "transitioningViews", "view", "n", "(Ljava/util/ArrayList;Landroid/view/View;)V", "f", "(Landroid/view/ViewGroup;)V", "Landroidx/activity/BackEventCompat;", "backEvent", "e", "(Landroidx/activity/BackEventCompat;Landroid/view/ViewGroup;)V", "d", "c", "Ljava/util/List;", "w", "()Ljava/util/List;", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "t", "()Landroidx/fragment/app/SpecialEffectsController$Operation;", "u", "g", "Landroidx/fragment/app/FragmentTransitionImpl;", "v", "()Landroidx/fragment/app/FragmentTransitionImpl;", "h", "Ljava/lang/Object;", "getSharedElementTransition", "()Ljava/lang/Object;", "i", "Ljava/util/ArrayList;", "getSharedElementFirstOutViews", "()Ljava/util/ArrayList;", "j", "getSharedElementLastInViews", "k", "Landroidx/collection/ArrayMap;", "getSharedElementNameMapping", "()Landroidx/collection/ArrayMap;", "l", "getEnteringNames", "m", "getExitingNames", "getFirstOutViews", "getLastInViews", "p", "Z", "()Z", "Landroidx/core/os/CancellationSignal;", "q", "Landroidx/core/os/CancellationSignal;", "getTransitionSignal", "()Landroidx/core/os/CancellationSignal;", "getTransitionSignal$annotations", "()V", "transitionSignal", "r", "s", "C", "(Ljava/lang/Object;)V", "controller", "b", "isSeekingSupported", "x", "transitioning", "fragment_release"}, k = 1, mv = {1, 8, 0})
    public static final class TransitionEffect extends SpecialEffectsController.Effect {
        public final List d;
        public final SpecialEffectsController.Operation e;
        public final SpecialEffectsController.Operation f;
        public final FragmentTransitionImpl g;
        public final Object h;
        public final ArrayList i;
        public final ArrayList j;
        public final ArrayMap k;
        public final ArrayList l;
        public final ArrayList m;
        public final ArrayMap n;
        public final ArrayMap o;
        public final boolean p;
        public final CancellationSignal q = new CancellationSignal();
        public Object r;

        public TransitionEffect(List list, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, FragmentTransitionImpl fragmentTransitionImpl, Object obj, ArrayList arrayList, ArrayList arrayList2, ArrayMap arrayMap, ArrayList arrayList3, ArrayList arrayList4, ArrayMap arrayMap2, ArrayMap arrayMap3, boolean z) {
            Intrinsics.checkNotNullParameter(list, "transitionInfos");
            Intrinsics.checkNotNullParameter(fragmentTransitionImpl, "transitionImpl");
            Intrinsics.checkNotNullParameter(arrayList, "sharedElementFirstOutViews");
            Intrinsics.checkNotNullParameter(arrayList2, "sharedElementLastInViews");
            Intrinsics.checkNotNullParameter(arrayMap, "sharedElementNameMapping");
            Intrinsics.checkNotNullParameter(arrayList3, "enteringNames");
            Intrinsics.checkNotNullParameter(arrayList4, "exitingNames");
            Intrinsics.checkNotNullParameter(arrayMap2, "firstOutViews");
            Intrinsics.checkNotNullParameter(arrayMap3, "lastInViews");
            this.d = list;
            this.e = operation;
            this.f = operation2;
            this.g = fragmentTransitionImpl;
            this.h = obj;
            this.i = arrayList;
            this.j = arrayList2;
            this.k = arrayMap;
            this.l = arrayList3;
            this.m = arrayList4;
            this.n = arrayMap2;
            this.o = arrayMap3;
            this.p = z;
        }

        public static final void A(SpecialEffectsController.Operation operation, TransitionEffect transitionEffect) {
            Intrinsics.checkNotNullParameter(operation, "$operation");
            Intrinsics.checkNotNullParameter(transitionEffect, "this$0");
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
            }
            operation.e(transitionEffect);
        }

        public static final void p(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, TransitionEffect transitionEffect) {
            Intrinsics.checkNotNullParameter(transitionEffect, "this$0");
            FragmentTransition.a(operation.h(), operation2.h(), transitionEffect.p, transitionEffect.o, false);
        }

        public static final void q(FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
            Intrinsics.checkNotNullParameter(fragmentTransitionImpl, "$impl");
            Intrinsics.checkNotNullParameter(rect, "$lastInEpicenterRect");
            fragmentTransitionImpl.k(view, rect);
        }

        public static final void r(ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "$transitioningViews");
            FragmentTransition.e(arrayList, 4);
        }

        public static final void y(SpecialEffectsController.Operation operation, TransitionEffect transitionEffect) {
            Intrinsics.checkNotNullParameter(operation, "$operation");
            Intrinsics.checkNotNullParameter(transitionEffect, "this$0");
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
            }
            operation.e(transitionEffect);
        }

        public static final void z(Ref.ObjectRef objectRef) {
            Intrinsics.checkNotNullParameter(objectRef, "$seekCancelLambda");
            Function0 function0 = (Function0) objectRef.element;
            if (function0 != null) {
                function0.invoke();
            }
        }

        public final void B(ArrayList arrayList, ViewGroup viewGroup, Function0 function0) {
            FragmentTransition.e(arrayList, 4);
            ArrayList q2 = this.g.q(this.j);
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", ">>>>> Beginning transition <<<<<");
                Log.v("FragmentManager", ">>>>> SharedElementFirstOutViews <<<<<");
                Iterator it = this.i.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "sharedElementFirstOutViews");
                    View view = (View) next;
                    Log.v("FragmentManager", "View: " + view + " Name: " + ViewCompat.J(view));
                }
                Log.v("FragmentManager", ">>>>> SharedElementLastInViews <<<<<");
                Iterator it2 = this.j.iterator();
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "sharedElementLastInViews");
                    View view2 = (View) next2;
                    Log.v("FragmentManager", "View: " + view2 + " Name: " + ViewCompat.J(view2));
                }
            }
            function0.invoke();
            this.g.y(viewGroup, this.i, this.j, q2, this.k);
            FragmentTransition.e(arrayList, 0);
            this.g.A(this.h, this.i, this.j);
        }

        public final void C(Object obj) {
            this.r = obj;
        }

        public boolean b() {
            if (this.g.m()) {
                List list = this.d;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TransitionInfo transitionInfo = (TransitionInfo) it.next();
                        if (Build.VERSION.SDK_INT >= 34) {
                            if (transitionInfo.f() != null) {
                                if (!this.g.n(transitionInfo.f())) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                Object obj = this.h;
                if (obj == null || this.g.n(obj)) {
                    return true;
                }
            }
            return false;
        }

        public void c(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            this.q.a();
        }

        public void d(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            if (!viewGroup.isLaidOut()) {
                for (TransitionInfo transitionInfo : this.d) {
                    SpecialEffectsController.Operation a2 = transitionInfo.a();
                    if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + viewGroup + " has not been laid out. Completing operation " + a2);
                    }
                    transitionInfo.a().e(this);
                }
                return;
            }
            Object obj = this.r;
            if (obj != null) {
                FragmentTransitionImpl fragmentTransitionImpl = this.g;
                Intrinsics.checkNotNull(obj);
                fragmentTransitionImpl.c(obj);
                if (FragmentManager.T0(2)) {
                    Log.v("FragmentManager", "Ending execution of operations from " + this.e + " to " + this.f);
                    return;
                }
                return;
            }
            Pair o2 = o(viewGroup, this.f, this.e);
            ArrayList arrayList = (ArrayList) o2.component1();
            Object component2 = o2.component2();
            List<TransitionInfo> list = this.d;
            ArrayList<SpecialEffectsController.Operation> arrayList2 = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (TransitionInfo a3 : list) {
                arrayList2.add(a3.a());
            }
            for (SpecialEffectsController.Operation operation : arrayList2) {
                this.g.w(operation.h(), component2, this.q, new d(operation, this));
            }
            B(arrayList, viewGroup, new DefaultSpecialEffectsController$TransitionEffect$onCommit$4(this, viewGroup, component2));
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Completed executing operations from " + this.e + " to " + this.f);
            }
        }

        public void e(BackEventCompat backEventCompat, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(backEventCompat, "backEvent");
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            Object obj = this.r;
            if (obj != null) {
                this.g.t(obj, backEventCompat.a());
            }
        }

        public void f(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            if (!viewGroup.isLaidOut()) {
                for (TransitionInfo a2 : this.d) {
                    SpecialEffectsController.Operation a3 = a2.a();
                    if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + viewGroup + " has not been laid out. Skipping onStart for operation " + a3);
                    }
                }
                return;
            }
            if (x() && this.h != null && !b()) {
                Log.i("FragmentManager", "Ignoring shared elements transition " + this.h + " between " + this.e + " and " + this.f + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
            }
            if (b() && x()) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Pair o2 = o(viewGroup, this.f, this.e);
                ArrayList arrayList = (ArrayList) o2.component1();
                Object component2 = o2.component2();
                List<TransitionInfo> list = this.d;
                ArrayList<SpecialEffectsController.Operation> arrayList2 = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (TransitionInfo a4 : list) {
                    arrayList2.add(a4.a());
                }
                for (SpecialEffectsController.Operation operation : arrayList2) {
                    b bVar = new b(objectRef);
                    this.g.x(operation.h(), component2, this.q, bVar, new c(operation, this));
                }
                B(arrayList, viewGroup, new DefaultSpecialEffectsController$TransitionEffect$onStart$4(this, viewGroup, component2, objectRef));
            }
        }

        public final void n(ArrayList arrayList, View view) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (!ViewGroupCompat.a(viewGroup)) {
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (childAt.getVisibility() == 0) {
                            Intrinsics.checkNotNullExpressionValue(childAt, "child");
                            n(arrayList, childAt);
                        }
                    }
                } else if (!arrayList.contains(view)) {
                    arrayList.add(view);
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(view);
            }
        }

        public final Pair o(ViewGroup viewGroup, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
            ViewGroup viewGroup2 = viewGroup;
            SpecialEffectsController.Operation operation3 = operation;
            SpecialEffectsController.Operation operation4 = operation2;
            View view = new View(viewGroup.getContext());
            Rect rect = new Rect();
            boolean z = false;
            View view2 = null;
            for (TransitionInfo g2 : this.d) {
                if (!(!g2.g() || operation4 == null || operation3 == null || !(!this.k.isEmpty()) || this.h == null)) {
                    FragmentTransition.a(operation.h(), operation2.h(), this.p, this.n, true);
                    OneShotPreDrawListener.a(viewGroup2, new e(operation3, operation4, this));
                    this.i.addAll(this.n.values());
                    if (!this.m.isEmpty()) {
                        Object obj = this.m.get(0);
                        Intrinsics.checkNotNullExpressionValue(obj, "exitingNames[0]");
                        view2 = (View) this.n.get((String) obj);
                        this.g.v(this.h, view2);
                    }
                    this.j.addAll(this.o.values());
                    if (!this.l.isEmpty()) {
                        Object obj2 = this.l.get(0);
                        Intrinsics.checkNotNullExpressionValue(obj2, "enteringNames[0]");
                        View view3 = (View) this.o.get((String) obj2);
                        if (view3 != null) {
                            OneShotPreDrawListener.a(viewGroup2, new f(this.g, view3, rect));
                            z = true;
                        }
                    }
                    this.g.z(this.h, view, this.i);
                    FragmentTransitionImpl fragmentTransitionImpl = this.g;
                    Object obj3 = this.h;
                    fragmentTransitionImpl.s(obj3, (Object) null, (ArrayList) null, (Object) null, (ArrayList) null, obj3, this.j);
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = this.d.iterator();
            Object obj4 = null;
            Object obj5 = null;
            while (it.hasNext()) {
                TransitionInfo transitionInfo = (TransitionInfo) it.next();
                SpecialEffectsController.Operation a2 = transitionInfo.a();
                Iterator it2 = it;
                Object h2 = this.g.h(transitionInfo.f());
                if (h2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    Object obj6 = obj5;
                    View view4 = a2.h().mView;
                    Object obj7 = obj4;
                    Intrinsics.checkNotNullExpressionValue(view4, "operation.fragment.mView");
                    n(arrayList2, view4);
                    if (this.h != null && (a2 == operation4 || a2 == operation3)) {
                        if (a2 == operation4) {
                            arrayList2.removeAll(CollectionsKt.toSet(this.i));
                        } else {
                            arrayList2.removeAll(CollectionsKt.toSet(this.j));
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        this.g.a(h2, view);
                    } else {
                        this.g.b(h2, arrayList2);
                        this.g.s(h2, h2, arrayList2, (Object) null, (ArrayList) null, (Object) null, (ArrayList) null);
                        if (a2.g() == SpecialEffectsController.Operation.State.GONE) {
                            a2.q(false);
                            ArrayList arrayList3 = new ArrayList(arrayList2);
                            arrayList3.remove(a2.h().mView);
                            this.g.r(h2, a2.h().mView, arrayList3);
                            OneShotPreDrawListener.a(viewGroup2, new g(arrayList2));
                        }
                    }
                    if (a2.g() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList.addAll(arrayList2);
                        if (z) {
                            this.g.u(h2, rect);
                        }
                        if (FragmentManager.T0(2)) {
                            Log.v("FragmentManager", "Entering Transition: " + h2);
                            Log.v("FragmentManager", ">>>>> EnteringViews <<<<<");
                            Iterator it3 = arrayList2.iterator();
                            while (it3.hasNext()) {
                                Object next = it3.next();
                                Intrinsics.checkNotNullExpressionValue(next, "transitioningViews");
                                Log.v("FragmentManager", "View: " + ((View) next));
                            }
                        }
                    } else {
                        this.g.v(h2, view2);
                        if (FragmentManager.T0(2)) {
                            Log.v("FragmentManager", "Exiting Transition: " + h2);
                            Log.v("FragmentManager", ">>>>> ExitingViews <<<<<");
                            Iterator it4 = arrayList2.iterator();
                            while (it4.hasNext()) {
                                Object next2 = it4.next();
                                Intrinsics.checkNotNullExpressionValue(next2, "transitioningViews");
                                Log.v("FragmentManager", "View: " + ((View) next2));
                            }
                        }
                    }
                    if (transitionInfo.h()) {
                        obj4 = this.g.p(obj7, h2, (Object) null);
                        operation3 = operation;
                        it = it2;
                        obj5 = obj6;
                    } else {
                        obj4 = obj7;
                        obj5 = this.g.p(obj6, h2, (Object) null);
                    }
                }
                operation3 = operation;
                it = it2;
            }
            Object o2 = this.g.o(obj4, obj5, this.h);
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Final merged transition: " + o2);
            }
            return new Pair(arrayList, o2);
        }

        public final Object s() {
            return this.r;
        }

        public final SpecialEffectsController.Operation t() {
            return this.e;
        }

        public final SpecialEffectsController.Operation u() {
            return this.f;
        }

        public final FragmentTransitionImpl v() {
            return this.g;
        }

        public final List w() {
            return this.d;
        }

        public final boolean x() {
            List<TransitionInfo> list = this.d;
            if ((list instanceof Collection) && list.isEmpty()) {
                return true;
            }
            for (TransitionInfo a2 : list) {
                if (!a2.a().h().mTransitioning) {
                    return false;
                }
            }
            return true;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\nR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u001a¨\u0006\u001c"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "operation", "", "isPop", "providesSharedElementTransition", "<init>", "(Landroidx/fragment/app/SpecialEffectsController$Operation;ZZ)V", "g", "()Z", "", "transition", "Landroidx/fragment/app/FragmentTransitionImpl;", "d", "(Ljava/lang/Object;)Landroidx/fragment/app/FragmentTransitionImpl;", "b", "Ljava/lang/Object;", "f", "()Ljava/lang/Object;", "c", "Z", "h", "isOverlapAllowed", "e", "sharedElementTransition", "()Landroidx/fragment/app/FragmentTransitionImpl;", "handlingImpl", "fragment_release"}, k = 1, mv = {1, 8, 0})
    public static final class TransitionInfo extends SpecialEffectsInfo {
        public final Object b;
        public final boolean c;
        public final Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TransitionInfo(SpecialEffectsController.Operation operation, boolean z, boolean z2) {
            super(operation);
            Object obj;
            Intrinsics.checkNotNullParameter(operation, "operation");
            SpecialEffectsController.Operation.State g = operation.g();
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            if (g == state) {
                Fragment h = operation.h();
                obj = z ? h.getReenterTransition() : h.getEnterTransition();
            } else {
                Fragment h2 = operation.h();
                obj = z ? h2.getReturnTransition() : h2.getExitTransition();
            }
            this.b = obj;
            this.c = operation.g() == state ? z ? operation.h().getAllowReturnTransitionOverlap() : operation.h().getAllowEnterTransitionOverlap() : true;
            this.d = z2 ? z ? operation.h().getSharedElementReturnTransition() : operation.h().getSharedElementEnterTransition() : null;
        }

        public final FragmentTransitionImpl c() {
            FragmentTransitionImpl d2 = d(this.b);
            FragmentTransitionImpl d3 = d(this.d);
            if (d2 == null || d3 == null || d2 == d3) {
                return d2 == null ? d3 : d2;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + a().h() + " returned Transition " + this.b + " which uses a different Transition  type than its shared element transition " + this.d).toString());
        }

        public final FragmentTransitionImpl d(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.b;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.g(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.c;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.g(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + a().h() + " is not a valid framework Transition or AndroidX Transition");
        }

        public final Object e() {
            return this.d;
        }

        public final Object f() {
            return this.b;
        }

        public final boolean g() {
            return this.d != null;
        }

        public final boolean h() {
            return this.c;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "container");
    }

    public static final void G(DefaultSpecialEffectsController defaultSpecialEffectsController, SpecialEffectsController.Operation operation) {
        Intrinsics.checkNotNullParameter(defaultSpecialEffectsController, "this$0");
        Intrinsics.checkNotNullParameter(operation, "$operation");
        defaultSpecialEffectsController.c(operation);
    }

    public final void F(List list) {
        ArrayList<AnimationInfo> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList2, ((AnimationInfo) it.next()).a().f());
        }
        boolean z = !arrayList2.isEmpty();
        Iterator it2 = list.iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            AnimationInfo animationInfo = (AnimationInfo) it2.next();
            Context context = t().getContext();
            SpecialEffectsController.Operation a2 = animationInfo.a();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentAnim.AnimationOrAnimator c = animationInfo.c(context);
            if (c != null) {
                if (c.b == null) {
                    arrayList.add(animationInfo);
                } else {
                    Fragment h = a2.h();
                    if (!(!a2.f().isEmpty())) {
                        if (a2.g() == SpecialEffectsController.Operation.State.GONE) {
                            a2.q(false);
                        }
                        a2.b(new AnimatorEffect(animationInfo));
                        z2 = true;
                    } else if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "Ignoring Animator set on " + h + " as this Fragment was involved in a Transition.");
                    }
                }
            }
        }
        for (AnimationInfo animationInfo2 : arrayList) {
            SpecialEffectsController.Operation a3 = animationInfo2.a();
            Fragment h2 = a3.h();
            if (z) {
                if (FragmentManager.T0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + h2 + " as Animations cannot run alongside Transitions.");
                }
            } else if (!z2) {
                a3.b(new AnimationEffect(animationInfo2));
            } else if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Ignoring Animation set on " + h2 + " as Animations cannot run alongside Animators.");
            }
        }
    }

    public final void H(List list, boolean z, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
        Object obj;
        FragmentTransitionImpl fragmentTransitionImpl;
        ArrayList arrayList;
        ArrayList arrayList2;
        Iterator it;
        ArrayList arrayList3;
        Object obj2;
        String b;
        SpecialEffectsController.Operation operation3 = operation;
        SpecialEffectsController.Operation operation4 = operation2;
        ArrayList arrayList4 = new ArrayList();
        for (Object next : list) {
            if (!((TransitionInfo) next).b()) {
                arrayList4.add(next);
            }
        }
        ArrayList<TransitionInfo> arrayList5 = new ArrayList<>();
        for (Object next2 : arrayList4) {
            if (((TransitionInfo) next2).c() != null) {
                arrayList5.add(next2);
            }
        }
        FragmentTransitionImpl fragmentTransitionImpl2 = null;
        for (TransitionInfo transitionInfo : arrayList5) {
            FragmentTransitionImpl c = transitionInfo.c();
            if (fragmentTransitionImpl2 == null || c == fragmentTransitionImpl2) {
                fragmentTransitionImpl2 = c;
            } else {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.a().h() + " returned Transition " + transitionInfo.f() + " which uses a different Transition type than other Fragments.").toString());
            }
        }
        if (fragmentTransitionImpl2 != null) {
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = new ArrayList();
            ArrayMap arrayMap = new ArrayMap();
            ArrayList<String> arrayList8 = new ArrayList<>();
            ArrayList<String> arrayList9 = new ArrayList<>();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayMap arrayMap3 = new ArrayMap();
            Iterator it2 = arrayList5.iterator();
            ArrayList<String> arrayList10 = arrayList8;
            ArrayList<String> arrayList11 = arrayList9;
            loop3:
            while (true) {
                obj = null;
                while (it2.hasNext()) {
                    TransitionInfo transitionInfo2 = (TransitionInfo) it2.next();
                    if (!transitionInfo2.g() || operation3 == null || operation4 == null) {
                        fragmentTransitionImpl = fragmentTransitionImpl2;
                        arrayList = arrayList6;
                        arrayList2 = arrayList7;
                        it = it2;
                        arrayList3 = arrayList5;
                    } else {
                        Object B = fragmentTransitionImpl2.B(fragmentTransitionImpl2.h(transitionInfo2.e()));
                        arrayList11 = operation2.h().getSharedElementSourceNames();
                        Intrinsics.checkNotNullExpressionValue(arrayList11, "lastIn.fragment.sharedElementSourceNames");
                        ArrayList<String> sharedElementSourceNames = operation.h().getSharedElementSourceNames();
                        Intrinsics.checkNotNullExpressionValue(sharedElementSourceNames, "firstOut.fragment.sharedElementSourceNames");
                        ArrayList<String> sharedElementTargetNames = operation.h().getSharedElementTargetNames();
                        Intrinsics.checkNotNullExpressionValue(sharedElementTargetNames, "firstOut.fragment.sharedElementTargetNames");
                        int size = sharedElementTargetNames.size();
                        fragmentTransitionImpl = fragmentTransitionImpl2;
                        it = it2;
                        int i = 0;
                        while (i < size) {
                            int i2 = size;
                            int indexOf = arrayList11.indexOf(sharedElementTargetNames.get(i));
                            if (indexOf != -1) {
                                arrayList11.set(indexOf, sharedElementSourceNames.get(i));
                            }
                            i++;
                            size = i2;
                        }
                        arrayList10 = operation2.h().getSharedElementTargetNames();
                        Intrinsics.checkNotNullExpressionValue(arrayList10, "lastIn.fragment.sharedElementTargetNames");
                        Pair pair = !z ? TuplesKt.to(operation.h().getExitTransitionCallback(), operation2.h().getEnterTransitionCallback()) : TuplesKt.to(operation.h().getEnterTransitionCallback(), operation2.h().getExitTransitionCallback());
                        SharedElementCallback sharedElementCallback = (SharedElementCallback) pair.component1();
                        SharedElementCallback sharedElementCallback2 = (SharedElementCallback) pair.component2();
                        int size2 = arrayList11.size();
                        int i3 = 0;
                        arrayList3 = arrayList5;
                        while (true) {
                            arrayList2 = arrayList7;
                            if (i3 >= size2) {
                                break;
                            }
                            int i4 = size2;
                            String str = arrayList11.get(i3);
                            Intrinsics.checkNotNullExpressionValue(str, "exitingNames[i]");
                            String str2 = arrayList10.get(i3);
                            Intrinsics.checkNotNullExpressionValue(str2, "enteringNames[i]");
                            arrayMap.put(str, str2);
                            i3++;
                            arrayList7 = arrayList2;
                            size2 = i4;
                        }
                        if (FragmentManager.T0(2)) {
                            Log.v("FragmentManager", ">>> entering view names <<<");
                            Iterator<String> it3 = arrayList10.iterator();
                            while (true) {
                                arrayList = arrayList6;
                                if (!it3.hasNext()) {
                                    break;
                                }
                                Log.v("FragmentManager", "Name: " + it3.next());
                                B = B;
                                arrayList6 = arrayList;
                                it3 = it3;
                            }
                            obj2 = B;
                            Log.v("FragmentManager", ">>> exiting view names <<<");
                            for (Iterator<String> it4 = arrayList11.iterator(); it4.hasNext(); it4 = it4) {
                                Log.v("FragmentManager", "Name: " + it4.next());
                            }
                        } else {
                            arrayList = arrayList6;
                            obj2 = B;
                        }
                        View view = operation.h().mView;
                        Intrinsics.checkNotNullExpressionValue(view, "firstOut.fragment.mView");
                        I(arrayMap2, view);
                        arrayMap2.p(arrayList11);
                        if (sharedElementCallback != null) {
                            if (FragmentManager.T0(2)) {
                                Log.v("FragmentManager", "Executing exit callback for operation " + operation3);
                            }
                            sharedElementCallback.d(arrayList11, arrayMap2);
                            int size3 = arrayList11.size() - 1;
                            if (size3 >= 0) {
                                while (true) {
                                    int i5 = size3 - 1;
                                    String str3 = arrayList11.get(size3);
                                    Intrinsics.checkNotNullExpressionValue(str3, "exitingNames[i]");
                                    String str4 = str3;
                                    View view2 = (View) arrayMap2.get(str4);
                                    if (view2 == null) {
                                        arrayMap.remove(str4);
                                    } else if (!Intrinsics.areEqual((Object) str4, (Object) ViewCompat.J(view2))) {
                                        arrayMap.put(ViewCompat.J(view2), (String) arrayMap.remove(str4));
                                    }
                                    if (i5 < 0) {
                                        break;
                                    }
                                    size3 = i5;
                                }
                            }
                        } else {
                            arrayMap.p(arrayMap2.keySet());
                        }
                        View view3 = operation2.h().mView;
                        Intrinsics.checkNotNullExpressionValue(view3, "lastIn.fragment.mView");
                        I(arrayMap3, view3);
                        arrayMap3.p(arrayList10);
                        arrayMap3.p(arrayMap.values());
                        if (sharedElementCallback2 != null) {
                            if (FragmentManager.T0(2)) {
                                Log.v("FragmentManager", "Executing enter callback for operation " + operation4);
                            }
                            sharedElementCallback2.d(arrayList10, arrayMap3);
                            int size4 = arrayList10.size() - 1;
                            if (size4 >= 0) {
                                while (true) {
                                    int i6 = size4 - 1;
                                    String str5 = arrayList10.get(size4);
                                    Intrinsics.checkNotNullExpressionValue(str5, "enteringNames[i]");
                                    String str6 = str5;
                                    View view4 = (View) arrayMap3.get(str6);
                                    if (view4 == null) {
                                        String b2 = FragmentTransition.b(arrayMap, str6);
                                        if (b2 != null) {
                                            arrayMap.remove(b2);
                                        }
                                    } else if (!Intrinsics.areEqual((Object) str6, (Object) ViewCompat.J(view4)) && (b = FragmentTransition.b(arrayMap, str6)) != null) {
                                        arrayMap.put(b, ViewCompat.J(view4));
                                    }
                                    if (i6 < 0) {
                                        break;
                                    }
                                    size4 = i6;
                                }
                            }
                        } else {
                            FragmentTransition.d(arrayMap, arrayMap3);
                        }
                        Set keySet = arrayMap.keySet();
                        Intrinsics.checkNotNullExpressionValue(keySet, "sharedElementNameMapping.keys");
                        J(arrayMap2, keySet);
                        Collection values = arrayMap.values();
                        Intrinsics.checkNotNullExpressionValue(values, "sharedElementNameMapping.values");
                        J(arrayMap3, values);
                        if (arrayMap.isEmpty()) {
                            Log.i("FragmentManager", "Ignoring shared elements transition " + obj2 + " between " + operation3 + " and " + operation4 + " as there are no matching elements in both the entering and exiting fragment. In order to run a SharedElementTransition, both fragments involved must have the element.");
                            arrayList.clear();
                            arrayList2.clear();
                            arrayList5 = arrayList3;
                            it2 = it;
                            fragmentTransitionImpl2 = fragmentTransitionImpl;
                            arrayList7 = arrayList2;
                            arrayList6 = arrayList;
                        } else {
                            obj = obj2;
                        }
                    }
                    arrayList5 = arrayList3;
                    it2 = it;
                    fragmentTransitionImpl2 = fragmentTransitionImpl;
                    arrayList7 = arrayList2;
                    arrayList6 = arrayList;
                }
                break loop3;
            }
            FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
            ArrayList arrayList12 = arrayList6;
            ArrayList arrayList13 = arrayList7;
            ArrayList<TransitionInfo> arrayList14 = arrayList5;
            if (obj != null) {
                TransitionEffect transitionEffect = new TransitionEffect(arrayList14, operation, operation2, fragmentTransitionImpl3, obj, arrayList12, arrayList13, arrayMap, arrayList10, arrayList11, arrayMap2, arrayMap3, z);
            } else if (!arrayList14.isEmpty()) {
                for (TransitionInfo f : arrayList14) {
                    if (f.f() != null) {
                    }
                }
                return;
            } else {
                return;
            }
            TransitionEffect transitionEffect2 = new TransitionEffect(arrayList14, operation, operation2, fragmentTransitionImpl3, obj, arrayList12, arrayList13, arrayMap, arrayList10, arrayList11, arrayMap2, arrayMap3, z);
            for (TransitionInfo a2 : arrayList14) {
                a2.a().b(transitionEffect2);
            }
        }
    }

    public final void I(Map map, View view) {
        String J = ViewCompat.J(view);
        if (J != null) {
            map.put(J, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    Intrinsics.checkNotNullExpressionValue(childAt, "child");
                    I(map, childAt);
                }
            }
        }
    }

    public final void J(ArrayMap arrayMap, Collection collection) {
        Set entrySet = arrayMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "entries");
        CollectionsKt.retainAll(entrySet, new DefaultSpecialEffectsController$retainMatchingViews$1(collection));
    }

    public final void K(List list) {
        Fragment h = ((SpecialEffectsController.Operation) CollectionsKt.last(list)).h();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SpecialEffectsController.Operation operation = (SpecialEffectsController.Operation) it.next();
            operation.h().mAnimationInfo.c = h.mAnimationInfo.c;
            operation.h().mAnimationInfo.d = h.mAnimationInfo.d;
            operation.h().mAnimationInfo.e = h.mAnimationInfo.e;
            operation.h().mAnimationInfo.f = h.mAnimationInfo.f;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: androidx.fragment.app.SpecialEffectsController$Operation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: androidx.fragment.app.SpecialEffectsController$Operation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: androidx.fragment.app.SpecialEffectsController$Operation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: androidx.fragment.app.SpecialEffectsController$Operation} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(java.util.List r9, boolean r10) {
        /*
            r8 = this;
            java.lang.String r0 = "operations"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.util.Iterator r0 = r9.iterator()
        L_0x0009:
            boolean r1 = r0.hasNext()
            r2 = 0
            java.lang.String r3 = "operation.fragment.mView"
            if (r1 == 0) goto L_0x0033
            java.lang.Object r1 = r0.next()
            r4 = r1
            androidx.fragment.app.SpecialEffectsController$Operation r4 = (androidx.fragment.app.SpecialEffectsController.Operation) r4
            androidx.fragment.app.SpecialEffectsController$Operation$State$Companion r5 = androidx.fragment.app.SpecialEffectsController.Operation.State.Companion
            androidx.fragment.app.Fragment r6 = r4.h()
            android.view.View r6 = r6.mView
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
            androidx.fragment.app.SpecialEffectsController$Operation$State r5 = r5.a(r6)
            androidx.fragment.app.SpecialEffectsController$Operation$State r6 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
            if (r5 != r6) goto L_0x0009
            androidx.fragment.app.SpecialEffectsController$Operation$State r4 = r4.g()
            if (r4 == r6) goto L_0x0009
            goto L_0x0034
        L_0x0033:
            r1 = r2
        L_0x0034:
            androidx.fragment.app.SpecialEffectsController$Operation r1 = (androidx.fragment.app.SpecialEffectsController.Operation) r1
            int r0 = r9.size()
            java.util.ListIterator r0 = r9.listIterator(r0)
        L_0x003e:
            boolean r4 = r0.hasPrevious()
            if (r4 == 0) goto L_0x0065
            java.lang.Object r4 = r0.previous()
            r5 = r4
            androidx.fragment.app.SpecialEffectsController$Operation r5 = (androidx.fragment.app.SpecialEffectsController.Operation) r5
            androidx.fragment.app.SpecialEffectsController$Operation$State$Companion r6 = androidx.fragment.app.SpecialEffectsController.Operation.State.Companion
            androidx.fragment.app.Fragment r7 = r5.h()
            android.view.View r7 = r7.mView
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r3)
            androidx.fragment.app.SpecialEffectsController$Operation$State r6 = r6.a(r7)
            androidx.fragment.app.SpecialEffectsController$Operation$State r7 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
            if (r6 == r7) goto L_0x003e
            androidx.fragment.app.SpecialEffectsController$Operation$State r5 = r5.g()
            if (r5 != r7) goto L_0x003e
            r2 = r4
        L_0x0065:
            androidx.fragment.app.SpecialEffectsController$Operation r2 = (androidx.fragment.app.SpecialEffectsController.Operation) r2
            r0 = 2
            boolean r0 = androidx.fragment.app.FragmentManager.T0(r0)
            if (r0 == 0) goto L_0x008c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Executing operations from "
            r0.append(r3)
            r0.append(r1)
            java.lang.String r3 = " to "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "FragmentManager"
            android.util.Log.v(r3, r0)
        L_0x008c:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r8.K(r9)
            java.util.Iterator r9 = r9.iterator()
        L_0x009d:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L_0x00cd
            java.lang.Object r4 = r9.next()
            androidx.fragment.app.SpecialEffectsController$Operation r4 = (androidx.fragment.app.SpecialEffectsController.Operation) r4
            androidx.fragment.app.DefaultSpecialEffectsController$AnimationInfo r5 = new androidx.fragment.app.DefaultSpecialEffectsController$AnimationInfo
            r5.<init>(r4, r10)
            r0.add(r5)
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r5 = new androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo
            r6 = 0
            r7 = 1
            if (r10 == 0) goto L_0x00bb
            if (r4 != r1) goto L_0x00be
        L_0x00b9:
            r6 = r7
            goto L_0x00be
        L_0x00bb:
            if (r4 != r2) goto L_0x00be
            goto L_0x00b9
        L_0x00be:
            r5.<init>(r4, r10, r6)
            r3.add(r5)
            com.honey.account.v.a r5 = new com.honey.account.v.a
            r5.<init>(r8, r4)
            r4.a(r5)
            goto L_0x009d
        L_0x00cd:
            r8.H(r3, r10, r1, r2)
            r8.F(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.d(java.util.List, boolean):void");
    }
}
