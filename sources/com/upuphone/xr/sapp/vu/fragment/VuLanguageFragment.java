package com.upuphone.xr.sapp.vu.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.fragment.FragmentKt;
import com.honey.account.c9.f0;
import com.honey.account.c9.g0;
import com.honey.account.c9.h0;
import com.honey.account.c9.i0;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.databinding.FragmentVuLanguageBinding;
import com.upuphone.xr.sapp.fragment.BaseFragment;
import com.upuphone.xr.sapp.vu.vm.VuGlassesLanguageModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\tR\u001b\u0010 \u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/upuphone/xr/sapp/vu/fragment/VuLanguageFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "", "lan", "N0", "(Ljava/lang/String;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "M0", "K0", "L0", "language", "O0", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesLanguageModel;", "j", "Lkotlin/Lazy;", "F0", "()Lcom/upuphone/xr/sapp/vu/vm/VuGlassesLanguageModel;", "languageModel", "Lcom/upuphone/xr/sapp/databinding/FragmentVuLanguageBinding;", "k", "Lcom/upuphone/xr/sapp/databinding/FragmentVuLanguageBinding;", "binding", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVuLanguageFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuLanguageFragment.kt\ncom/upuphone/xr/sapp/vu/fragment/VuLanguageFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,127:1\n172#2,9:128\n256#3,2:137\n*S KotlinDebug\n*F\n+ 1 VuLanguageFragment.kt\ncom/upuphone/xr/sapp/vu/fragment/VuLanguageFragment\n*L\n25#1:128,9\n52#1:137,2\n*E\n"})
public final class VuLanguageFragment extends BaseFragment {
    public final Lazy j = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(VuGlassesLanguageModel.class), new VuLanguageFragment$special$$inlined$activityViewModels$default$1(this), new VuLanguageFragment$special$$inlined$activityViewModels$default$2((Function0) null, this), new VuLanguageFragment$special$$inlined$activityViewModels$default$3(this));
    public FragmentVuLanguageBinding k;

    public static final void G0(VuLanguageFragment vuLanguageFragment, View view) {
        Intrinsics.checkNotNullParameter(vuLanguageFragment, "this$0");
        vuLanguageFragment.L0();
    }

    public static final void H0(VuLanguageFragment vuLanguageFragment, View view) {
        Intrinsics.checkNotNullParameter(vuLanguageFragment, "this$0");
        FragmentKt.a(vuLanguageFragment).T();
    }

    public static final void I0(VuLanguageFragment vuLanguageFragment, View view) {
        Intrinsics.checkNotNullParameter(vuLanguageFragment, "this$0");
        vuLanguageFragment.K0();
    }

    public static final void J0(VuLanguageFragment vuLanguageFragment, View view) {
        Intrinsics.checkNotNullParameter(vuLanguageFragment, "this$0");
        vuLanguageFragment.M0();
    }

    private final void N0(String str) {
        F0().e(str);
    }

    private final void initView() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        FragmentVuLanguageBinding fragmentVuLanguageBinding = null;
        if (bool.booleanValue()) {
            FragmentVuLanguageBinding fragmentVuLanguageBinding2 = this.k;
            if (fragmentVuLanguageBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuLanguageBinding2 = null;
            }
            ViewGroup.LayoutParams layoutParams = fragmentVuLanguageBinding2.d.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            FragmentVuLanguageBinding fragmentVuLanguageBinding3 = this.k;
            if (fragmentVuLanguageBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuLanguageBinding3 = null;
            }
            ViewGroup.LayoutParams layoutParams3 = fragmentVuLanguageBinding3.j.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
            FragmentVuLanguageBinding fragmentVuLanguageBinding4 = this.k;
            if (fragmentVuLanguageBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuLanguageBinding4 = null;
            }
            ViewGroup.LayoutParams layoutParams5 = fragmentVuLanguageBinding4.g.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
            FragmentVuLanguageBinding fragmentVuLanguageBinding5 = this.k;
            if (fragmentVuLanguageBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuLanguageBinding5 = null;
            }
            layoutParams6.i = fragmentVuLanguageBinding5.l.getId();
            FragmentVuLanguageBinding fragmentVuLanguageBinding6 = this.k;
            if (fragmentVuLanguageBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuLanguageBinding6 = null;
            }
            layoutParams4.j = fragmentVuLanguageBinding6.g.getId();
            FragmentVuLanguageBinding fragmentVuLanguageBinding7 = this.k;
            if (fragmentVuLanguageBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuLanguageBinding7 = null;
            }
            layoutParams2.j = fragmentVuLanguageBinding7.j.getId();
            layoutParams2.i = -1;
            FragmentVuLanguageBinding fragmentVuLanguageBinding8 = this.k;
            if (fragmentVuLanguageBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuLanguageBinding8 = null;
            }
            fragmentVuLanguageBinding8.g.setOnClickListener(new f0(this));
        } else {
            FragmentVuLanguageBinding fragmentVuLanguageBinding9 = this.k;
            if (fragmentVuLanguageBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuLanguageBinding9 = null;
            }
            ConstraintLayout constraintLayout = fragmentVuLanguageBinding9.g;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "languageEnMsLayout");
            constraintLayout.setVisibility(8);
        }
        F0().c().observe(getViewLifecycleOwner(), new VuLanguageFragment$sam$androidx_lifecycle_Observer$0(new VuLanguageFragment$initView$2(this)));
        FragmentVuLanguageBinding fragmentVuLanguageBinding10 = this.k;
        if (fragmentVuLanguageBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuLanguageBinding10 = null;
        }
        fragmentVuLanguageBinding10.b.setOnClickListener(new g0(this));
        FragmentVuLanguageBinding fragmentVuLanguageBinding11 = this.k;
        if (fragmentVuLanguageBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuLanguageBinding11 = null;
        }
        fragmentVuLanguageBinding11.d.setOnClickListener(new h0(this));
        FragmentVuLanguageBinding fragmentVuLanguageBinding12 = this.k;
        if (fragmentVuLanguageBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuLanguageBinding = fragmentVuLanguageBinding12;
        }
        fragmentVuLanguageBinding.j.setOnClickListener(new i0(this));
    }

    public final VuGlassesLanguageModel F0() {
        return (VuGlassesLanguageModel) this.j.getValue();
    }

    public final void K0() {
        if (!Intrinsics.areEqual((Object) F0().d(), (Object) "zh-CN")) {
            N0("zh-CN");
        }
    }

    public final void L0() {
        if (!Intrinsics.areEqual((Object) F0().d(), (Object) "ms-MY")) {
            N0("ms-MY");
        }
    }

    public final void M0() {
        if (!Intrinsics.areEqual((Object) F0().d(), (Object) "en-US")) {
            N0("en-US");
        }
    }

    public final void O0(String str) {
        int hashCode = str.hashCode();
        FragmentVuLanguageBinding fragmentVuLanguageBinding = null;
        if (hashCode != 96598594) {
            if (hashCode != 104135475) {
                if (hashCode == 115813226 && str.equals("zh-CN")) {
                    FragmentVuLanguageBinding fragmentVuLanguageBinding2 = this.k;
                    if (fragmentVuLanguageBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentVuLanguageBinding2 = null;
                    }
                    fragmentVuLanguageBinding2.e.setVisibility(0);
                    FragmentVuLanguageBinding fragmentVuLanguageBinding3 = this.k;
                    if (fragmentVuLanguageBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentVuLanguageBinding3 = null;
                    }
                    fragmentVuLanguageBinding3.c.setSelected(true);
                    FragmentVuLanguageBinding fragmentVuLanguageBinding4 = this.k;
                    if (fragmentVuLanguageBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentVuLanguageBinding4 = null;
                    }
                    fragmentVuLanguageBinding4.k.setVisibility(8);
                    FragmentVuLanguageBinding fragmentVuLanguageBinding5 = this.k;
                    if (fragmentVuLanguageBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentVuLanguageBinding5 = null;
                    }
                    fragmentVuLanguageBinding5.i.setSelected(false);
                    FragmentVuLanguageBinding fragmentVuLanguageBinding6 = this.k;
                    if (fragmentVuLanguageBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        fragmentVuLanguageBinding6 = null;
                    }
                    fragmentVuLanguageBinding6.h.setVisibility(8);
                    FragmentVuLanguageBinding fragmentVuLanguageBinding7 = this.k;
                    if (fragmentVuLanguageBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentVuLanguageBinding = fragmentVuLanguageBinding7;
                    }
                    fragmentVuLanguageBinding.f.setSelected(false);
                    return;
                }
            } else if (str.equals("ms-MY")) {
                FragmentVuLanguageBinding fragmentVuLanguageBinding8 = this.k;
                if (fragmentVuLanguageBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentVuLanguageBinding8 = null;
                }
                fragmentVuLanguageBinding8.k.setVisibility(8);
                FragmentVuLanguageBinding fragmentVuLanguageBinding9 = this.k;
                if (fragmentVuLanguageBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentVuLanguageBinding9 = null;
                }
                fragmentVuLanguageBinding9.i.setSelected(false);
                FragmentVuLanguageBinding fragmentVuLanguageBinding10 = this.k;
                if (fragmentVuLanguageBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentVuLanguageBinding10 = null;
                }
                fragmentVuLanguageBinding10.e.setVisibility(8);
                FragmentVuLanguageBinding fragmentVuLanguageBinding11 = this.k;
                if (fragmentVuLanguageBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentVuLanguageBinding11 = null;
                }
                fragmentVuLanguageBinding11.c.setSelected(false);
                FragmentVuLanguageBinding fragmentVuLanguageBinding12 = this.k;
                if (fragmentVuLanguageBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentVuLanguageBinding12 = null;
                }
                fragmentVuLanguageBinding12.h.setVisibility(0);
                FragmentVuLanguageBinding fragmentVuLanguageBinding13 = this.k;
                if (fragmentVuLanguageBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentVuLanguageBinding = fragmentVuLanguageBinding13;
                }
                fragmentVuLanguageBinding.f.setSelected(true);
                return;
            }
        } else if (str.equals("en-US")) {
            FragmentVuLanguageBinding fragmentVuLanguageBinding14 = this.k;
            if (fragmentVuLanguageBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuLanguageBinding14 = null;
            }
            fragmentVuLanguageBinding14.k.setVisibility(0);
            FragmentVuLanguageBinding fragmentVuLanguageBinding15 = this.k;
            if (fragmentVuLanguageBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuLanguageBinding15 = null;
            }
            fragmentVuLanguageBinding15.i.setSelected(true);
            FragmentVuLanguageBinding fragmentVuLanguageBinding16 = this.k;
            if (fragmentVuLanguageBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuLanguageBinding16 = null;
            }
            fragmentVuLanguageBinding16.e.setVisibility(8);
            FragmentVuLanguageBinding fragmentVuLanguageBinding17 = this.k;
            if (fragmentVuLanguageBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuLanguageBinding17 = null;
            }
            fragmentVuLanguageBinding17.c.setSelected(false);
            FragmentVuLanguageBinding fragmentVuLanguageBinding18 = this.k;
            if (fragmentVuLanguageBinding18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuLanguageBinding18 = null;
            }
            fragmentVuLanguageBinding18.h.setVisibility(8);
            FragmentVuLanguageBinding fragmentVuLanguageBinding19 = this.k;
            if (fragmentVuLanguageBinding19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVuLanguageBinding = fragmentVuLanguageBinding19;
            }
            fragmentVuLanguageBinding.f.setSelected(false);
            return;
        }
        FragmentVuLanguageBinding fragmentVuLanguageBinding20 = this.k;
        if (fragmentVuLanguageBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuLanguageBinding20 = null;
        }
        fragmentVuLanguageBinding20.k.setVisibility(8);
        FragmentVuLanguageBinding fragmentVuLanguageBinding21 = this.k;
        if (fragmentVuLanguageBinding21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuLanguageBinding21 = null;
        }
        fragmentVuLanguageBinding21.i.setSelected(false);
        FragmentVuLanguageBinding fragmentVuLanguageBinding22 = this.k;
        if (fragmentVuLanguageBinding22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuLanguageBinding22 = null;
        }
        fragmentVuLanguageBinding22.e.setVisibility(8);
        FragmentVuLanguageBinding fragmentVuLanguageBinding23 = this.k;
        if (fragmentVuLanguageBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuLanguageBinding23 = null;
        }
        fragmentVuLanguageBinding23.c.setSelected(false);
        FragmentVuLanguageBinding fragmentVuLanguageBinding24 = this.k;
        if (fragmentVuLanguageBinding24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuLanguageBinding24 = null;
        }
        fragmentVuLanguageBinding24.h.setVisibility(8);
        FragmentVuLanguageBinding fragmentVuLanguageBinding25 = this.k;
        if (fragmentVuLanguageBinding25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuLanguageBinding = fragmentVuLanguageBinding25;
        }
        fragmentVuLanguageBinding.f.setSelected(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentVuLanguageBinding c = FragmentVuLanguageBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.k = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        ConstraintLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }
}
