package com.luck.picture.lib;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.luck.picture.lib.adapter.PicturePreviewAdapter;
import com.luck.picture.lib.adapter.holder.BasePreviewHolder;
import com.luck.picture.lib.adapter.holder.PreviewGalleryAdapter;
import com.luck.picture.lib.adapter.holder.PreviewVideoHolder;
import com.luck.picture.lib.basic.IBridgeLoaderFactory;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.basic.PictureMediaScannerConnection;
import com.luck.picture.lib.config.Crop;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.decoration.HorizontalItemDecoration;
import com.luck.picture.lib.decoration.WrapContentLinearLayoutManager;
import com.luck.picture.lib.dialog.PictureCommonDialog;
import com.luck.picture.lib.engine.ExtendLoaderEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.MediaExtraInfo;
import com.luck.picture.lib.interfaces.OnCallbackListener;
import com.luck.picture.lib.interfaces.OnExternalPreviewEventListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.luck.picture.lib.loader.LocalMediaLoader;
import com.luck.picture.lib.loader.LocalMediaPageLoader;
import com.luck.picture.lib.magical.BuildRecycleItemViewParams;
import com.luck.picture.lib.magical.MagicalView;
import com.luck.picture.lib.magical.OnMagicalViewCallback;
import com.luck.picture.lib.magical.ViewParams;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.ActivityCompatHelper;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.DownloadFileUtils;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.StyleUtils;
import com.luck.picture.lib.utils.ToastUtils;
import com.luck.picture.lib.utils.ValueOf;
import com.luck.picture.lib.widget.BottomNavBar;
import com.luck.picture.lib.widget.CompleteSelectView;
import com.luck.picture.lib.widget.PreviewBottomNavBar;
import com.luck.picture.lib.widget.PreviewTitleBar;
import com.luck.picture.lib.widget.TitleBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class PictureSelectorPreviewFragment extends PictureCommonFragment {
    public static final String P = "PictureSelectorPreviewFragment";
    public int A;
    public int B;
    public int C;
    public long D = -1;
    public TextView E;
    public TextView F;
    public View G;
    public CompleteSelectView H;
    public boolean I = true;
    public boolean J = false;
    public RecyclerView K;
    public PreviewGalleryAdapter L;
    public List M = new ArrayList();
    public boolean N = false;
    public final ViewPager2.OnPageChangeCallback O = new ViewPager2.OnPageChangeCallback() {
        public void onPageScrolled(int i, float f, int i2) {
            if (PictureSelectorPreviewFragment.this.l.size() > i) {
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                int i3 = pictureSelectorPreviewFragment.B / 2;
                ArrayList arrayList = pictureSelectorPreviewFragment.l;
                if (i2 >= i3) {
                    i++;
                }
                LocalMedia localMedia = (LocalMedia) arrayList.get(i);
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                pictureSelectorPreviewFragment2.E.setSelected(pictureSelectorPreviewFragment2.g3(localMedia));
                PictureSelectorPreviewFragment.this.j3(localMedia);
                PictureSelectorPreviewFragment.this.l3(localMedia);
            }
        }

        public void onPageSelected(int i) {
            PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
            pictureSelectorPreviewFragment.s = i;
            PreviewTitleBar previewTitleBar = pictureSelectorPreviewFragment.q;
            previewTitleBar.setTitle((PictureSelectorPreviewFragment.this.s + 1) + "/" + PictureSelectorPreviewFragment.this.A);
            if (PictureSelectorPreviewFragment.this.l.size() > i) {
                LocalMedia localMedia = (LocalMedia) PictureSelectorPreviewFragment.this.l.get(i);
                PictureSelectorPreviewFragment.this.l3(localMedia);
                if (PictureSelectorPreviewFragment.this.e3()) {
                    PictureSelectorPreviewFragment.this.N2(i);
                }
                if (PictureSelectorPreviewFragment.this.e.L) {
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                    if (!pictureSelectorPreviewFragment2.t || !pictureSelectorPreviewFragment2.e.B0) {
                        PictureSelectorPreviewFragment.this.o.q(i);
                    } else {
                        PictureSelectorPreviewFragment.this.E3(i);
                    }
                } else if (PictureSelectorPreviewFragment.this.e.B0) {
                    PictureSelectorPreviewFragment.this.E3(i);
                }
                PictureSelectorPreviewFragment.this.j3(localMedia);
                PictureSelectorPreviewFragment.this.p.i(PictureMimeType.i(localMedia.getMimeType()) || PictureMimeType.d(localMedia.getMimeType()));
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment3 = PictureSelectorPreviewFragment.this;
                if (!pictureSelectorPreviewFragment3.x && !pictureSelectorPreviewFragment3.t && !pictureSelectorPreviewFragment3.e.o0 && PictureSelectorPreviewFragment.this.e.e0) {
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment4 = PictureSelectorPreviewFragment.this;
                    if (!pictureSelectorPreviewFragment4.r) {
                        return;
                    }
                    if (i == pictureSelectorPreviewFragment4.o.getItemCount() - 11 || i == PictureSelectorPreviewFragment.this.o.getItemCount() - 1) {
                        PictureSelectorPreviewFragment.this.h3();
                    }
                }
            }
        }
    };
    public ArrayList l = new ArrayList();
    public MagicalView m;
    public ViewPager2 n;
    public PicturePreviewAdapter o;
    public PreviewBottomNavBar p;
    public PreviewTitleBar q;
    public boolean r = true;
    public int s;
    public boolean t;
    public boolean u;
    public String v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public class MyOnPreviewEventListener implements BasePreviewHolder.OnPreviewEventListener {
        public MyOnPreviewEventListener() {
        }

        public void a(LocalMedia localMedia) {
            if (!PictureSelectorPreviewFragment.this.e.O) {
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                if (pictureSelectorPreviewFragment.x) {
                    pictureSelectorPreviewFragment.n3(localMedia);
                }
            }
        }

        public void b(String str) {
            if (TextUtils.isEmpty(str)) {
                PreviewTitleBar previewTitleBar = PictureSelectorPreviewFragment.this.q;
                previewTitleBar.setTitle((PictureSelectorPreviewFragment.this.s + 1) + "/" + PictureSelectorPreviewFragment.this.A);
                return;
            }
            PictureSelectorPreviewFragment.this.q.setTitle(str);
        }

        public void onBackPressed() {
            if (PictureSelectorPreviewFragment.this.e.K) {
                PictureSelectorPreviewFragment.this.u3();
                return;
            }
            PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
            if (pictureSelectorPreviewFragment.x) {
                if (pictureSelectorPreviewFragment.e.L) {
                    PictureSelectorPreviewFragment.this.m.t();
                } else {
                    PictureSelectorPreviewFragment.this.V2();
                }
            } else if (pictureSelectorPreviewFragment.t || !pictureSelectorPreviewFragment.e.L) {
                PictureSelectorPreviewFragment.this.g1();
            } else {
                PictureSelectorPreviewFragment.this.m.t();
            }
        }
    }

    private void Z2() {
        this.p.f();
        this.p.h();
        this.p.setOnBottomNavBarListener(new BottomNavBar.OnBottomNavBarListener() {
            public void a() {
                PictureSelectorPreviewFragment.this.L1();
            }

            public void b() {
                if (PictureSelectorPreviewFragment.this.e.c1 != null) {
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                    PictureSelectorPreviewFragment.this.e.c1.a(PictureSelectorPreviewFragment.this, (LocalMedia) pictureSelectorPreviewFragment.l.get(pictureSelectorPreviewFragment.n.getCurrentItem()), 696);
                }
            }

            public void c() {
                int currentItem = PictureSelectorPreviewFragment.this.n.getCurrentItem();
                if (PictureSelectorPreviewFragment.this.l.size() > currentItem) {
                    PictureSelectorPreviewFragment.this.D0((LocalMedia) PictureSelectorPreviewFragment.this.l.get(currentItem), false);
                }
            }
        });
    }

    private void a3() {
        final SelectMainStyle c = this.e.K0.c();
        if (StyleUtils.c(c.C())) {
            this.E.setBackgroundResource(c.C());
        } else if (StyleUtils.c(c.I())) {
            this.E.setBackgroundResource(c.I());
        }
        if (StyleUtils.c(c.G())) {
            this.F.setText(getString(c.G()));
        } else if (StyleUtils.f(c.E())) {
            this.F.setText(c.E());
        } else {
            this.F.setText("");
        }
        if (StyleUtils.b(c.H())) {
            this.F.setTextSize((float) c.H());
        }
        if (StyleUtils.c(c.F())) {
            this.F.setTextColor(c.F());
        }
        if (StyleUtils.b(c.D())) {
            if (this.E.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                if (this.E.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                    ((ConstraintLayout.LayoutParams) this.E.getLayoutParams()).rightMargin = c.D();
                }
            } else if (this.E.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.E.getLayoutParams()).rightMargin = c.D();
            }
        }
        this.H.c();
        this.H.setSelectedChange(true);
        if (c.V()) {
            if (this.H.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) this.H.getLayoutParams()).i = R.id.title_bar;
                ((ConstraintLayout.LayoutParams) this.H.getLayoutParams()).l = R.id.title_bar;
                if (this.e.K) {
                    ((ConstraintLayout.LayoutParams) this.H.getLayoutParams()).topMargin = DensityUtil.i(getContext());
                }
            } else if ((this.H.getLayoutParams() instanceof RelativeLayout.LayoutParams) && this.e.K) {
                ((RelativeLayout.LayoutParams) this.H.getLayoutParams()).topMargin = DensityUtil.i(getContext());
            }
        }
        if (c.Z()) {
            if (this.E.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) this.E.getLayoutParams()).i = R.id.bottom_nar_bar;
                ((ConstraintLayout.LayoutParams) this.E.getLayoutParams()).l = R.id.bottom_nar_bar;
                ((ConstraintLayout.LayoutParams) this.F.getLayoutParams()).i = R.id.bottom_nar_bar;
                ((ConstraintLayout.LayoutParams) this.F.getLayoutParams()).l = R.id.bottom_nar_bar;
                ((ConstraintLayout.LayoutParams) this.G.getLayoutParams()).i = R.id.bottom_nar_bar;
                ((ConstraintLayout.LayoutParams) this.G.getLayoutParams()).l = R.id.bottom_nar_bar;
            }
        } else if (this.e.K) {
            if (this.F.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) this.F.getLayoutParams()).topMargin = DensityUtil.i(getContext());
            } else if (this.F.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.F.getLayoutParams()).topMargin = DensityUtil.i(getContext());
            }
        }
        this.H.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: Code restructure failed: missing block: B:5:0x002a, code lost:
                if (r5.D0((com.luck.picture.lib.entity.LocalMedia) r5.l.get(r5.n.getCurrentItem()), false) == 0) goto L_0x003b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0039, code lost:
                if (com.luck.picture.lib.PictureSelectorPreviewFragment.s2(r4.b).g() > 0) goto L_0x003b;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r5) {
                /*
                    r4 = this;
                    com.luck.picture.lib.style.SelectMainStyle r5 = r0
                    boolean r5 = r5.V()
                    r0 = 1
                    r1 = 0
                    if (r5 == 0) goto L_0x002f
                    com.luck.picture.lib.PictureSelectorPreviewFragment r5 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    com.luck.picture.lib.config.SelectorConfig r5 = r5.e
                    int r5 = r5.g()
                    if (r5 != 0) goto L_0x002f
                    com.luck.picture.lib.PictureSelectorPreviewFragment r5 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    java.util.ArrayList r2 = r5.l
                    androidx.viewpager2.widget.ViewPager2 r3 = r5.n
                    int r3 = r3.getCurrentItem()
                    java.lang.Object r2 = r2.get(r3)
                    com.luck.picture.lib.entity.LocalMedia r2 = (com.luck.picture.lib.entity.LocalMedia) r2
                    int r5 = r5.D0(r2, r1)
                    if (r5 != 0) goto L_0x002d
                    goto L_0x003b
                L_0x002d:
                    r0 = r1
                    goto L_0x003b
                L_0x002f:
                    com.luck.picture.lib.PictureSelectorPreviewFragment r5 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    com.luck.picture.lib.config.SelectorConfig r5 = r5.e
                    int r5 = r5.g()
                    if (r5 <= 0) goto L_0x002d
                L_0x003b:
                    com.luck.picture.lib.PictureSelectorPreviewFragment r5 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    com.luck.picture.lib.config.SelectorConfig r5 = r5.e
                    boolean r5 = r5.N
                    if (r5 == 0) goto L_0x0057
                    com.luck.picture.lib.PictureSelectorPreviewFragment r5 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    com.luck.picture.lib.config.SelectorConfig r5 = r5.e
                    int r5 = r5.g()
                    if (r5 != 0) goto L_0x0057
                    com.luck.picture.lib.PictureSelectorPreviewFragment r4 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    r4.o1()
                    goto L_0x005e
                L_0x0057:
                    if (r0 == 0) goto L_0x005e
                    com.luck.picture.lib.PictureSelectorPreviewFragment r4 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    r4.Q0()
                L_0x005e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorPreviewFragment.AnonymousClass6.onClick(android.view.View):void");
            }
        });
    }

    private void c3() {
        if (this.e.K0.d().u()) {
            this.q.setVisibility(8);
        }
        this.q.d();
        this.q.setOnTitleBarListener(new TitleBar.OnTitleBarListener() {
            public void a() {
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                if (pictureSelectorPreviewFragment.x) {
                    if (pictureSelectorPreviewFragment.e.L) {
                        PictureSelectorPreviewFragment.this.m.t();
                    } else {
                        PictureSelectorPreviewFragment.this.V2();
                    }
                } else if (pictureSelectorPreviewFragment.t || !pictureSelectorPreviewFragment.e.L) {
                    PictureSelectorPreviewFragment.this.g1();
                } else {
                    PictureSelectorPreviewFragment.this.m.t();
                }
            }
        });
        PreviewTitleBar previewTitleBar = this.q;
        previewTitleBar.setTitle((this.s + 1) + "/" + this.A);
        this.q.getImageDelete().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PictureSelectorPreviewFragment.this.Q2();
            }
        });
        this.G.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                if (pictureSelectorPreviewFragment.x) {
                    pictureSelectorPreviewFragment.Q2();
                    return;
                }
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                if (pictureSelectorPreviewFragment2.D0((LocalMedia) pictureSelectorPreviewFragment.l.get(pictureSelectorPreviewFragment.n.getCurrentItem()), pictureSelectorPreviewFragment2.E.isSelected()) != 0) {
                    return;
                }
                if (PictureSelectorPreviewFragment.this.e.o1 != null) {
                    PictureSelectorPreviewFragment.this.e.o1.a(PictureSelectorPreviewFragment.this.E);
                    return;
                }
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment3 = PictureSelectorPreviewFragment.this;
                pictureSelectorPreviewFragment3.E.startAnimation(AnimationUtils.loadAnimation(pictureSelectorPreviewFragment3.getContext(), R.anim.ps_anim_modal_in));
            }
        });
        this.E.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PictureSelectorPreviewFragment.this.G.performClick();
            }
        });
    }

    public static PictureSelectorPreviewFragment i3() {
        PictureSelectorPreviewFragment pictureSelectorPreviewFragment = new PictureSelectorPreviewFragment();
        pictureSelectorPreviewFragment.setArguments(new Bundle());
        return pictureSelectorPreviewFragment;
    }

    public void A1(boolean z2, LocalMedia localMedia) {
        this.E.setSelected(this.e.h().contains(localMedia));
        this.p.h();
        this.H.setSelectedChange(true);
        l3(localMedia);
        k3(z2, localMedia);
    }

    public final void A3() {
        ArrayList arrayList;
        SelectMainStyle c = this.e.K0.c();
        if (StyleUtils.c(c.B())) {
            this.m.setBackgroundColor(c.B());
        } else if (this.e.f9404a == SelectMimeType.b() || ((arrayList = this.l) != null && arrayList.size() > 0 && PictureMimeType.d(((LocalMedia) this.l.get(0)).getMimeType()))) {
            this.m.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ps_color_white));
        } else {
            this.m.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ps_color_black));
        }
    }

    public final void B3(int i, int i2, int i3) {
        this.m.A(i, i2, true);
        if (this.w) {
            i3++;
        }
        ViewParams d = BuildRecycleItemViewParams.d(i3);
        if (d == null || i == 0 || i2 == 0) {
            this.m.F(0, 0, 0, 0, i, i2);
        } else {
            this.m.F(d.left, d.f9433top, d.width, d.height, i, i2);
        }
    }

    public final void C3() {
        for (int i = 0; i < this.M.size(); i++) {
            ((View) this.M.get(i)).setEnabled(false);
        }
        this.p.getEditor().setEnabled(false);
    }

    public final void D3(final int[] iArr) {
        int i;
        this.m.A(iArr[0], iArr[1], false);
        ViewParams d = BuildRecycleItemViewParams.d(this.w ? this.s + 1 : this.s);
        if (d == null || ((i = iArr[0]) == 0 && iArr[1] == 0)) {
            this.n.post(new Runnable() {
                public void run() {
                    MagicalView magicalView = PictureSelectorPreviewFragment.this.m;
                    int[] iArr = iArr;
                    magicalView.K(iArr[0], iArr[1], false);
                }
            });
            this.m.setBackgroundAlpha(1.0f);
            for (int i2 = 0; i2 < this.M.size(); i2++) {
                ((View) this.M.get(i2)).setAlpha(1.0f);
            }
        } else {
            this.m.F(d.left, d.f9433top, d.width, d.height, i, iArr[1]);
            this.m.J(false);
        }
        ObjectAnimator.ofFloat(this.n, "alpha", new float[]{0.0f, 1.0f}).setDuration(50).start();
    }

    public final void E3(final int i) {
        this.n.post(new Runnable() {
            public void run() {
                PictureSelectorPreviewFragment.this.o.r(i);
            }
        });
    }

    public void F3(LocalMedia localMedia) {
        if (!this.u && !this.t && this.e.L) {
            this.n.post(new Runnable() {
                public void run() {
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                    pictureSelectorPreviewFragment.o.o(pictureSelectorPreviewFragment.s);
                }
            });
            if (PictureMimeType.i(localMedia.getMimeType())) {
                U2(localMedia, !PictureMimeType.g(localMedia.getAvailablePath()), new OnCallbackListener<int[]>() {
                    /* renamed from: b */
                    public void a(int[] iArr) {
                        PictureSelectorPreviewFragment.this.D3(iArr);
                    }
                });
            } else {
                T2(localMedia, !PictureMimeType.g(localMedia.getAvailablePath()), new OnCallbackListener<int[]>() {
                    /* renamed from: b */
                    public void a(int[] iArr) {
                        PictureSelectorPreviewFragment.this.D3(iArr);
                    }
                });
            }
        }
    }

    public void I1(boolean z2) {
        if (this.e.K0.c().Y() && this.e.K0.c().a0()) {
            int i = 0;
            while (i < this.e.g()) {
                i++;
                ((LocalMedia) this.e.h().get(i)).setNum(i);
            }
        }
    }

    public void M2(View... viewArr) {
        Collections.addAll(this.M, viewArr);
    }

    public final void N2(final int i) {
        LocalMedia localMedia = (LocalMedia) this.l.get(i);
        if (PictureMimeType.i(localMedia.getMimeType())) {
            U2(localMedia, false, new OnCallbackListener<int[]>() {
                /* renamed from: b */
                public void a(int[] iArr) {
                    PictureSelectorPreviewFragment.this.B3(iArr[0], iArr[1], i);
                }
            });
        } else {
            T2(localMedia, false, new OnCallbackListener<int[]>() {
                /* renamed from: b */
                public void a(int[] iArr) {
                    PictureSelectorPreviewFragment.this.B3(iArr[0], iArr[1], i);
                }
            });
        }
    }

    public final void O2(int[] iArr) {
        int i;
        int i2;
        ViewParams d = BuildRecycleItemViewParams.d(this.w ? this.s + 1 : this.s);
        if (d == null || (i = iArr[0]) == 0 || (i2 = iArr[1]) == 0) {
            this.m.F(0, 0, 0, 0, iArr[0], iArr[1]);
            this.m.C(iArr[0], iArr[1], false);
            return;
        }
        this.m.F(d.left, d.f9433top, d.width, d.height, i, i2);
        this.m.B();
    }

    public PicturePreviewAdapter P2() {
        return new PicturePreviewAdapter(this.e);
    }

    public final void Q2() {
        OnExternalPreviewEventListener onExternalPreviewEventListener;
        if (this.y && (onExternalPreviewEventListener = this.e.a1) != null) {
            onExternalPreviewEventListener.b(this.n.getCurrentItem());
            int currentItem = this.n.getCurrentItem();
            this.l.remove(currentItem);
            if (this.l.size() == 0) {
                V2();
                return;
            }
            this.q.setTitle(getString(R.string.ps_preview_image_num, Integer.valueOf(this.s + 1), Integer.valueOf(this.l.size())));
            this.A = this.l.size();
            this.s = currentItem;
            if (this.n.getAdapter() != null) {
                this.n.setAdapter((RecyclerView.Adapter) null);
                this.n.setAdapter(this.o);
            }
            this.n.j(this.s, false);
        }
    }

    public final void R2() {
        this.q.getImageDelete().setVisibility(this.y ? 0 : 8);
        this.E.setVisibility(8);
        this.p.setVisibility(8);
        this.H.setVisibility(8);
    }

    public String S2() {
        return P;
    }

    public final void T2(final LocalMedia localMedia, boolean z2, final OnCallbackListener onCallbackListener) {
        int i;
        int i2;
        boolean z3 = true;
        if (MediaUtils.p(localMedia.getWidth(), localMedia.getHeight())) {
            i = this.B;
            i2 = this.C;
        } else {
            int width = localMedia.getWidth();
            int height = localMedia.getHeight();
            if (z2 && ((width <= 0 || height <= 0 || width > height) && this.e.G0)) {
                this.n.setAlpha(0.0f);
                MediaUtils.g(getContext(), localMedia.getAvailablePath(), new OnCallbackListener<MediaExtraInfo>() {
                    /* renamed from: b */
                    public void a(MediaExtraInfo mediaExtraInfo) {
                        if (mediaExtraInfo.c() > 0) {
                            localMedia.setWidth(mediaExtraInfo.c());
                        }
                        if (mediaExtraInfo.b() > 0) {
                            localMedia.setHeight(mediaExtraInfo.b());
                        }
                        OnCallbackListener onCallbackListener = onCallbackListener;
                        if (onCallbackListener != null) {
                            onCallbackListener.a(new int[]{localMedia.getWidth(), localMedia.getHeight()});
                        }
                    }
                });
                z3 = false;
            }
            i = width;
            i2 = height;
        }
        if (localMedia.isCut() && localMedia.getCropImageWidth() > 0 && localMedia.getCropImageHeight() > 0) {
            i = localMedia.getCropImageWidth();
            i2 = localMedia.getCropImageHeight();
        }
        if (z3) {
            onCallbackListener.a(new int[]{i, i2});
        }
    }

    public final void U2(final LocalMedia localMedia, boolean z2, final OnCallbackListener onCallbackListener) {
        if (!z2 || ((localMedia.getWidth() > 0 && localMedia.getHeight() > 0 && localMedia.getWidth() <= localMedia.getHeight()) || !this.e.G0)) {
            onCallbackListener.a(new int[]{localMedia.getWidth(), localMedia.getHeight()});
            return;
        }
        this.n.setAlpha(0.0f);
        MediaUtils.n(getContext(), localMedia.getAvailablePath(), new OnCallbackListener<MediaExtraInfo>() {
            /* renamed from: b */
            public void a(MediaExtraInfo mediaExtraInfo) {
                if (mediaExtraInfo.c() > 0) {
                    localMedia.setWidth(mediaExtraInfo.c());
                }
                if (mediaExtraInfo.b() > 0) {
                    localMedia.setHeight(mediaExtraInfo.b());
                }
                OnCallbackListener onCallbackListener = onCallbackListener;
                if (onCallbackListener != null) {
                    onCallbackListener.a(new int[]{localMedia.getWidth(), localMedia.getHeight()});
                }
            }
        });
    }

    public final void V2() {
        if (!ActivityCompatHelper.c(getActivity())) {
            if (this.e.K) {
                X2();
            }
            o1();
        }
    }

    public int W0() {
        int a2 = InjectResourceSource.a(getContext(), 2, this.e);
        return a2 != 0 ? a2 : R.layout.ps_fragment_preview;
    }

    public final void W2(List list, boolean z2) {
        if (!ActivityCompatHelper.c(getActivity())) {
            this.r = z2;
            if (!z2) {
                return;
            }
            if (list.size() > 0) {
                int size = this.l.size();
                this.l.addAll(list);
                this.o.notifyItemRangeChanged(size, this.l.size());
                return;
            }
            h3();
        }
    }

    public final void X2() {
        for (int i = 0; i < this.M.size(); i++) {
            ((View) this.M.get(i)).setEnabled(true);
        }
        this.p.getEditor().setEnabled(true);
    }

    public final void Y2() {
        float f = 1.0f;
        if (e3()) {
            if (!this.u) {
                f = 0.0f;
            }
            this.m.setBackgroundAlpha(f);
            for (int i = 0; i < this.M.size(); i++) {
                if (!(this.M.get(i) instanceof TitleBar)) {
                    ((View) this.M.get(i)).setAlpha(f);
                }
            }
            return;
        }
        this.m.setBackgroundAlpha(1.0f);
    }

    public void b3(ViewGroup viewGroup) {
        SelectMainStyle c = this.e.K0.c();
        if (c.X()) {
            this.K = new RecyclerView(getContext());
            if (StyleUtils.c(c.o())) {
                this.K.setBackgroundResource(c.o());
            } else {
                this.K.setBackgroundResource(R.drawable.ps_preview_gallery_bg);
            }
            viewGroup.addView(this.K);
            ViewGroup.LayoutParams layoutParams = this.K.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.width = -1;
                layoutParams2.height = -2;
                layoutParams2.k = R.id.bottom_nar_bar;
                layoutParams2.t = 0;
                layoutParams2.v = 0;
            }
            AnonymousClass11 r6 = new WrapContentLinearLayoutManager(getContext()) {
                public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
                    super.smoothScrollToPosition(recyclerView, state, i);
                    AnonymousClass1 r2 = new LinearSmoothScroller(recyclerView.getContext()) {
                        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                            return 300.0f / ((float) displayMetrics.densityDpi);
                        }
                    };
                    r2.setTargetPosition(i);
                    startSmoothScroll(r2);
                }
            };
            RecyclerView.ItemAnimator itemAnimator = this.K.getItemAnimator();
            if (itemAnimator != null) {
                ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            }
            if (this.K.getItemDecorationCount() == 0) {
                this.K.addItemDecoration(new HorizontalItemDecoration(Integer.MAX_VALUE, DensityUtil.a(getContext(), 6.0f)));
            }
            r6.setOrientation(0);
            this.K.setLayoutManager(r6);
            if (this.e.g() > 0) {
                this.K.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getContext(), R.anim.ps_anim_layout_fall_enter));
            }
            this.L = new PreviewGalleryAdapter(this.e, this.t);
            j3((LocalMedia) this.l.get(this.s));
            this.K.setAdapter(this.L);
            this.L.q(new PreviewGalleryAdapter.OnItemClickListener() {
                public void a(final int i, LocalMedia localMedia, View view) {
                    if (i != -1) {
                        String string = TextUtils.isEmpty(PictureSelectorPreviewFragment.this.e.c0) ? PictureSelectorPreviewFragment.this.getString(R.string.ps_camera_roll) : PictureSelectorPreviewFragment.this.e.c0;
                        PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                        if (pictureSelectorPreviewFragment.t || TextUtils.equals(pictureSelectorPreviewFragment.v, string) || TextUtils.equals(localMedia.getParentFolderName(), PictureSelectorPreviewFragment.this.v)) {
                            PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                            if (!pictureSelectorPreviewFragment2.t) {
                                i = pictureSelectorPreviewFragment2.w ? localMedia.position - 1 : localMedia.position;
                            }
                            if (i != pictureSelectorPreviewFragment2.n.getCurrentItem() || !localMedia.isChecked()) {
                                LocalMedia i2 = PictureSelectorPreviewFragment.this.o.i(i);
                                if (i2 == null || (TextUtils.equals(localMedia.getPath(), i2.getPath()) && localMedia.getId() == i2.getId())) {
                                    if (PictureSelectorPreviewFragment.this.n.getAdapter() != null) {
                                        PictureSelectorPreviewFragment.this.n.setAdapter((RecyclerView.Adapter) null);
                                        PictureSelectorPreviewFragment pictureSelectorPreviewFragment3 = PictureSelectorPreviewFragment.this;
                                        pictureSelectorPreviewFragment3.n.setAdapter(pictureSelectorPreviewFragment3.o);
                                    }
                                    PictureSelectorPreviewFragment.this.n.j(i, false);
                                    PictureSelectorPreviewFragment.this.j3(localMedia);
                                    PictureSelectorPreviewFragment.this.n.post(new Runnable() {
                                        public void run() {
                                            if (PictureSelectorPreviewFragment.this.e.L) {
                                                PictureSelectorPreviewFragment.this.o.q(i);
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    }
                }
            });
            if (this.e.g() > 0) {
                this.K.setVisibility(0);
            } else {
                this.K.setVisibility(4);
            }
            M2(this.K);
            final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
                public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                    int l;
                    viewHolder.itemView.setAlpha(1.0f);
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                    if (pictureSelectorPreviewFragment.J) {
                        pictureSelectorPreviewFragment.J = false;
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(viewHolder.itemView, "scaleX", new float[]{1.1f, 1.0f}), ObjectAnimator.ofFloat(viewHolder.itemView, "scaleY", new float[]{1.1f, 1.0f})});
                        animatorSet.setInterpolator(new LinearInterpolator());
                        animatorSet.setDuration(50);
                        animatorSet.start();
                        animatorSet.addListener(new AnimatorListenerAdapter() {
                            public void onAnimationEnd(Animator animator) {
                                PictureSelectorPreviewFragment.this.I = true;
                            }
                        });
                    }
                    super.clearView(recyclerView, viewHolder);
                    PictureSelectorPreviewFragment.this.L.notifyItemChanged(viewHolder.getAbsoluteAdapterPosition());
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                    if (!(!pictureSelectorPreviewFragment2.t || PictureSelectorPreviewFragment.this.n.getCurrentItem() == (l = pictureSelectorPreviewFragment2.L.l()) || l == -1)) {
                        if (PictureSelectorPreviewFragment.this.n.getAdapter() != null) {
                            PictureSelectorPreviewFragment.this.n.setAdapter((RecyclerView.Adapter) null);
                            PictureSelectorPreviewFragment pictureSelectorPreviewFragment3 = PictureSelectorPreviewFragment.this;
                            pictureSelectorPreviewFragment3.n.setAdapter(pictureSelectorPreviewFragment3.o);
                        }
                        PictureSelectorPreviewFragment.this.n.j(l, false);
                    }
                    if (PictureSelectorPreviewFragment.this.e.K0.c().a0() && !ActivityCompatHelper.c(PictureSelectorPreviewFragment.this.getActivity())) {
                        List F0 = PictureSelectorPreviewFragment.this.getActivity().getSupportFragmentManager().F0();
                        for (int i = 0; i < F0.size(); i++) {
                            Fragment fragment = (Fragment) F0.get(i);
                            if (fragment instanceof PictureCommonFragment) {
                                ((PictureCommonFragment) fragment).I1(true);
                            }
                        }
                    }
                }

                public long getAnimationDuration(RecyclerView recyclerView, int i, float f, float f2) {
                    return super.getAnimationDuration(recyclerView, i, f, f2);
                }

                public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                    viewHolder.itemView.setAlpha(0.7f);
                    return ItemTouchHelper.Callback.makeMovementFlags(12, 0);
                }

                public boolean isLongPressDragEnabled() {
                    return true;
                }

                public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
                    PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                    if (pictureSelectorPreviewFragment.I) {
                        pictureSelectorPreviewFragment.I = false;
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(viewHolder.itemView, "scaleX", new float[]{1.0f, 1.1f}), ObjectAnimator.ofFloat(viewHolder.itemView, "scaleY", new float[]{1.0f, 1.1f})});
                        animatorSet.setDuration(50);
                        animatorSet.setInterpolator(new LinearInterpolator());
                        animatorSet.start();
                        animatorSet.addListener(new AnimatorListenerAdapter() {
                            public void onAnimationEnd(Animator animator) {
                                PictureSelectorPreviewFragment.this.J = true;
                            }
                        });
                    }
                    super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
                }

                public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
                    try {
                        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
                        int absoluteAdapterPosition2 = viewHolder2.getAbsoluteAdapterPosition();
                        if (absoluteAdapterPosition < absoluteAdapterPosition2) {
                            int i = absoluteAdapterPosition;
                            while (i < absoluteAdapterPosition2) {
                                int i2 = i + 1;
                                Collections.swap(PictureSelectorPreviewFragment.this.L.getData(), i, i2);
                                Collections.swap(PictureSelectorPreviewFragment.this.e.h(), i, i2);
                                PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                                if (pictureSelectorPreviewFragment.t) {
                                    Collections.swap(pictureSelectorPreviewFragment.l, i, i2);
                                }
                                i = i2;
                            }
                        } else {
                            for (int i3 = absoluteAdapterPosition; i3 > absoluteAdapterPosition2; i3--) {
                                int i4 = i3 - 1;
                                Collections.swap(PictureSelectorPreviewFragment.this.L.getData(), i3, i4);
                                Collections.swap(PictureSelectorPreviewFragment.this.e.h(), i3, i4);
                                PictureSelectorPreviewFragment pictureSelectorPreviewFragment2 = PictureSelectorPreviewFragment.this;
                                if (pictureSelectorPreviewFragment2.t) {
                                    Collections.swap(pictureSelectorPreviewFragment2.l, i3, i4);
                                }
                            }
                        }
                        PictureSelectorPreviewFragment.this.L.notifyItemMoved(absoluteAdapterPosition, absoluteAdapterPosition2);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return true;
                    }
                }

                public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
                    super.onSelectedChanged(viewHolder, i);
                }

                public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
                }
            });
            itemTouchHelper.attachToRecyclerView(this.K);
            this.L.r(new PreviewGalleryAdapter.OnItemLongClickListener() {
                public void a(RecyclerView.ViewHolder viewHolder, int i, View view) {
                    ((Vibrator) PictureSelectorPreviewFragment.this.getActivity().getSystemService("vibrator")).vibrate(50);
                    if (PictureSelectorPreviewFragment.this.L.getItemCount() != PictureSelectorPreviewFragment.this.e.k) {
                        itemTouchHelper.startDrag(viewHolder);
                    } else if (viewHolder.getLayoutPosition() != PictureSelectorPreviewFragment.this.L.getItemCount() - 1) {
                        itemTouchHelper.startDrag(viewHolder);
                    }
                }
            });
        }
    }

    public final void d3(ArrayList arrayList) {
        int i;
        PicturePreviewAdapter P2 = P2();
        this.o = P2;
        P2.setData(arrayList);
        this.o.p(new MyOnPreviewEventListener());
        this.n.setOrientation(0);
        this.n.setAdapter(this.o);
        this.e.s1.clear();
        if (arrayList.size() == 0 || this.s >= arrayList.size() || (i = this.s) < 0) {
            s1();
            return;
        }
        LocalMedia localMedia = (LocalMedia) arrayList.get(i);
        this.p.i(PictureMimeType.i(localMedia.getMimeType()) || PictureMimeType.d(localMedia.getMimeType()));
        this.E.setSelected(this.e.h().contains(arrayList.get(this.n.getCurrentItem())));
        this.n.g(this.O);
        this.n.setPageTransformer(new MarginPageTransformer(DensityUtil.a(T0(), 3.0f)));
        this.n.j(this.s, false);
        I1(false);
        l3((LocalMedia) arrayList.get(this.s));
        F3(localMedia);
    }

    public final boolean e3() {
        return !this.t && this.e.L;
    }

    public final boolean f3() {
        PicturePreviewAdapter picturePreviewAdapter = this.o;
        return picturePreviewAdapter != null && picturePreviewAdapter.j(this.n.getCurrentItem());
    }

    public boolean g3(LocalMedia localMedia) {
        return this.e.h().contains(localMedia);
    }

    public final void h3() {
        int i = this.c + 1;
        this.c = i;
        SelectorConfig selectorConfig = this.e;
        ExtendLoaderEngine extendLoaderEngine = selectorConfig.S0;
        if (extendLoaderEngine != null) {
            Context context = getContext();
            long j = this.D;
            int i2 = this.c;
            int i3 = this.e.d0;
            extendLoaderEngine.b(context, j, i2, i3, i3, new OnQueryDataResultListener<LocalMedia>() {
                public void a(ArrayList arrayList, boolean z) {
                    PictureSelectorPreviewFragment.this.W2(arrayList, z);
                }
            });
            return;
        }
        this.d.h(this.D, i, selectorConfig.d0, new OnQueryDataResultListener<LocalMedia>() {
            public void a(ArrayList arrayList, boolean z) {
                PictureSelectorPreviewFragment.this.W2(arrayList, z);
            }
        });
    }

    public void i1() {
        this.p.g();
    }

    public final void j3(LocalMedia localMedia) {
        if (this.L != null && this.e.K0.c().X()) {
            this.L.m(localMedia);
        }
    }

    public final void k3(boolean z2, LocalMedia localMedia) {
        if (this.L != null && this.e.K0.c().X()) {
            if (this.K.getVisibility() == 4) {
                this.K.setVisibility(0);
            }
            if (z2) {
                if (this.e.j == 1) {
                    this.L.clear();
                }
                this.L.j(localMedia);
                this.K.smoothScrollToPosition(this.L.getItemCount() - 1);
                return;
            }
            this.L.p(localMedia);
            if (this.e.g() == 0) {
                this.K.setVisibility(4);
            }
        }
    }

    public void l1(Intent intent) {
        if (this.l.size() > this.n.getCurrentItem()) {
            LocalMedia localMedia = (LocalMedia) this.l.get(this.n.getCurrentItem());
            Uri b = Crop.b(intent);
            localMedia.setCutPath(b != null ? b.getPath() : "");
            localMedia.setCropImageWidth(Crop.h(intent));
            localMedia.setCropImageHeight(Crop.e(intent));
            localMedia.setCropOffsetX(Crop.f(intent));
            localMedia.setCropOffsetY(Crop.g(intent));
            localMedia.setCropResultAspectRatio(Crop.c(intent));
            localMedia.setCut(!TextUtils.isEmpty(localMedia.getCutPath()));
            localMedia.setCustomData(Crop.d(intent));
            localMedia.setEditorImage(localMedia.isCut());
            localMedia.setSandboxPath(localMedia.getCutPath());
            if (this.e.h().contains(localMedia)) {
                LocalMedia compareLocalMedia = localMedia.getCompareLocalMedia();
                if (compareLocalMedia != null) {
                    compareLocalMedia.setCutPath(localMedia.getCutPath());
                    compareLocalMedia.setCut(localMedia.isCut());
                    compareLocalMedia.setEditorImage(localMedia.isEditorImage());
                    compareLocalMedia.setCustomData(localMedia.getCustomData());
                    compareLocalMedia.setSandboxPath(localMedia.getCutPath());
                    compareLocalMedia.setCropImageWidth(Crop.h(intent));
                    compareLocalMedia.setCropImageHeight(Crop.e(intent));
                    compareLocalMedia.setCropOffsetX(Crop.f(intent));
                    compareLocalMedia.setCropOffsetY(Crop.g(intent));
                    compareLocalMedia.setCropResultAspectRatio(Crop.c(intent));
                }
                J1(localMedia);
            } else {
                D0(localMedia, false);
            }
            this.o.notifyItemChanged(this.n.getCurrentItem());
            j3(localMedia);
        }
    }

    public void l3(LocalMedia localMedia) {
        if (this.e.K0.c().Y() && this.e.K0.c().a0()) {
            this.E.setText("");
            for (int i = 0; i < this.e.g(); i++) {
                LocalMedia localMedia2 = (LocalMedia) this.e.h().get(i);
                if (TextUtils.equals(localMedia2.getPath(), localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                    localMedia.setNum(localMedia2.getNum());
                    localMedia2.setPosition(localMedia.getPosition());
                    this.E.setText(ValueOf.g(Integer.valueOf(localMedia.getNum())));
                }
            }
        }
    }

    public void m3() {
        if (!this.x) {
            SelectorConfig selectorConfig = this.e;
            IBridgeLoaderFactory iBridgeLoaderFactory = selectorConfig.V0;
            if (iBridgeLoaderFactory != null) {
                IBridgeMediaLoader a2 = iBridgeLoaderFactory.a();
                this.d = a2;
                if (a2 == null) {
                    throw new NullPointerException("No available " + IBridgeMediaLoader.class + " loader found");
                }
                return;
            }
            this.d = selectorConfig.e0 ? new LocalMediaPageLoader(T0(), this.e) : new LocalMediaLoader(T0(), this.e);
        }
    }

    public void n1() {
        if (this.e.K) {
            X2();
        }
    }

    public final void n3(final LocalMedia localMedia) {
        OnExternalPreviewEventListener onExternalPreviewEventListener = this.e.a1;
        if (onExternalPreviewEventListener != null && !onExternalPreviewEventListener.a(getContext(), localMedia)) {
            PictureCommonDialog.c(getContext(), getString(R.string.ps_prompt), (PictureMimeType.d(localMedia.getMimeType()) || PictureMimeType.l(localMedia.getAvailablePath())) ? getString(R.string.ps_prompt_audio_content) : (PictureMimeType.i(localMedia.getMimeType()) || PictureMimeType.o(localMedia.getAvailablePath())) ? getString(R.string.ps_prompt_video_content) : getString(R.string.ps_prompt_image_content)).b(new PictureCommonDialog.OnDialogEventListener() {
                public void a() {
                    String availablePath = localMedia.getAvailablePath();
                    if (PictureMimeType.g(availablePath)) {
                        PictureSelectorPreviewFragment.this.showLoading();
                    }
                    DownloadFileUtils.a(PictureSelectorPreviewFragment.this.getContext(), availablePath, localMedia.getMimeType(), new OnCallbackListener<String>() {
                        /* renamed from: b */
                        public void a(String str) {
                            PictureSelectorPreviewFragment.this.N0();
                            if (TextUtils.isEmpty(str)) {
                                ToastUtils.c(PictureSelectorPreviewFragment.this.getContext(), PictureMimeType.d(localMedia.getMimeType()) ? PictureSelectorPreviewFragment.this.getString(R.string.ps_save_audio_error) : PictureMimeType.i(localMedia.getMimeType()) ? PictureSelectorPreviewFragment.this.getString(R.string.ps_save_video_error) : PictureSelectorPreviewFragment.this.getString(R.string.ps_save_image_error));
                                return;
                            }
                            new PictureMediaScannerConnection(PictureSelectorPreviewFragment.this.getActivity(), str);
                            Context context = PictureSelectorPreviewFragment.this.getContext();
                            ToastUtils.c(context, PictureSelectorPreviewFragment.this.getString(R.string.ps_save_success) + StringUtils.LF + str);
                        }
                    });
                }
            });
        }
    }

    public void o1() {
        PicturePreviewAdapter picturePreviewAdapter = this.o;
        if (picturePreviewAdapter != null) {
            picturePreviewAdapter.g();
        }
        super.o1();
    }

    public final void o3() {
        if (ActivityCompatHelper.c(getActivity())) {
            return;
        }
        if (this.x) {
            if (this.e.L) {
                this.m.t();
            } else {
                o1();
            }
        } else if (this.t) {
            g1();
        } else if (this.e.L) {
            this.m.t();
        } else {
            g1();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i;
        super.onConfigurationChanged(configuration);
        if (e3() && this.l.size() > (i = this.s)) {
            LocalMedia localMedia = (LocalMedia) this.l.get(i);
            if (PictureMimeType.i(localMedia.getMimeType())) {
                U2(localMedia, false, new OnCallbackListener<int[]>() {
                    /* renamed from: b */
                    public void a(int[] iArr) {
                        PictureSelectorPreviewFragment.this.O2(iArr);
                    }
                });
            } else {
                T2(localMedia, false, new OnCallbackListener<int[]>() {
                    /* renamed from: b */
                    public void a(int[] iArr) {
                        PictureSelectorPreviewFragment.this.O2(iArr);
                    }
                });
            }
        }
    }

    public Animation onCreateAnimation(int i, boolean z2, int i2) {
        if (e3()) {
            return null;
        }
        PictureWindowAnimationStyle e = this.e.K0.e();
        if (e.c == 0 || e.d == 0) {
            return super.onCreateAnimation(i, z2, i2);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), z2 ? e.c : e.d);
        if (z2) {
            m1();
        } else {
            n1();
        }
        return loadAnimation;
    }

    public void onDestroy() {
        PicturePreviewAdapter picturePreviewAdapter = this.o;
        if (picturePreviewAdapter != null) {
            picturePreviewAdapter.g();
        }
        ViewPager2 viewPager2 = this.n;
        if (viewPager2 != null) {
            viewPager2.n(this.O);
        }
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        if (f3()) {
            w3();
            this.N = true;
        }
    }

    public void onResume() {
        super.onResume();
        if (this.N) {
            w3();
            this.N = false;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("com.luck.picture.lib.current_page", this.c);
        bundle.putLong("com.luck.picture.lib.current_bucketId", this.D);
        bundle.putInt("com.luck.picture.lib.current_preview_position", this.s);
        bundle.putInt("com.luck.picture.lib.current_album_total", this.A);
        bundle.putBoolean("com.luck.picture.lib.external_preview", this.x);
        bundle.putBoolean("com.luck.picture.lib.external_preview_display_delete", this.y);
        bundle.putBoolean("com.luck.picture.lib.display_camera", this.w);
        bundle.putBoolean("com.luck.picture.lib.bottom_preview", this.t);
        bundle.putString("com.luck.picture.lib.current_album_name", this.v);
        this.e.d(this.l);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        v3(bundle);
        this.u = bundle != null;
        this.B = DensityUtil.e(getContext());
        this.C = DensityUtil.g(getContext());
        this.q = (PreviewTitleBar) view.findViewById(R.id.title_bar);
        this.E = (TextView) view.findViewById(R.id.ps_tv_selected);
        this.F = (TextView) view.findViewById(R.id.ps_tv_selected_word);
        this.G = view.findViewById(R.id.select_click_area);
        this.H = (CompleteSelectView) view.findViewById(R.id.ps_complete_select);
        this.m = (MagicalView) view.findViewById(R.id.magical);
        this.n = new ViewPager2(getContext());
        this.p = (PreviewBottomNavBar) view.findViewById(R.id.bottom_nar_bar);
        this.m.setMagicalContent(this.n);
        A3();
        z3();
        M2(this.q, this.E, this.F, this.G, this.H, this.p);
        m3();
        c3();
        d3(this.l);
        if (this.x) {
            R2();
        } else {
            Z2();
            b3((ViewGroup) view);
            a3();
        }
        Y2();
    }

    public void p3(float f) {
        for (int i = 0; i < this.M.size(); i++) {
            if (!(this.M.get(i) instanceof TitleBar)) {
                ((View) this.M.get(i)).setAlpha(f);
            }
        }
    }

    public void q3(MagicalView magicalView, boolean z2) {
        int i;
        int i2;
        BasePreviewHolder h = this.o.h(this.n.getCurrentItem());
        if (h != null) {
            LocalMedia localMedia = (LocalMedia) this.l.get(this.n.getCurrentItem());
            if (!localMedia.isCut() || localMedia.getCropImageWidth() <= 0 || localMedia.getCropImageHeight() <= 0) {
                i2 = localMedia.getWidth();
                i = localMedia.getHeight();
            } else {
                i2 = localMedia.getCropImageWidth();
                i = localMedia.getCropImageHeight();
            }
            if (MediaUtils.p(i2, i)) {
                h.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                h.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            if (h instanceof PreviewVideoHolder) {
                PreviewVideoHolder previewVideoHolder = (PreviewVideoHolder) h;
                if (this.e.B0) {
                    E3(this.n.getCurrentItem());
                } else if (previewVideoHolder.h.getVisibility() == 8 && !f3()) {
                    previewVideoHolder.h.setVisibility(0);
                }
            }
        }
    }

    public void r3() {
        BasePreviewHolder h = this.o.h(this.n.getCurrentItem());
        if (h != null) {
            if (h.f.getVisibility() == 8) {
                h.f.setVisibility(0);
            }
            if (h instanceof PreviewVideoHolder) {
                PreviewVideoHolder previewVideoHolder = (PreviewVideoHolder) h;
                if (previewVideoHolder.h.getVisibility() == 0) {
                    previewVideoHolder.h.setVisibility(8);
                }
            }
        }
    }

    public void s1() {
        o3();
    }

    public void s3(boolean z2) {
        BasePreviewHolder h;
        ViewParams d = BuildRecycleItemViewParams.d(this.w ? this.s + 1 : this.s);
        if (d != null && (h = this.o.h(this.n.getCurrentItem())) != null) {
            h.f.getLayoutParams().width = d.width;
            h.f.getLayoutParams().height = d.height;
            h.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public void t3() {
        if (!this.x || !d1() || !e3()) {
            g1();
        } else {
            o1();
        }
    }

    public final void u3() {
        if (!this.z) {
            float f = 0.0f;
            final boolean z2 = this.q.getTranslationY() == 0.0f;
            AnimatorSet animatorSet = new AnimatorSet();
            float f2 = z2 ? 0.0f : (float) (-this.q.getHeight());
            float f3 = z2 ? (float) (-this.q.getHeight()) : 0.0f;
            float f4 = z2 ? 1.0f : 0.0f;
            if (!z2) {
                f = 1.0f;
            }
            for (int i = 0; i < this.M.size(); i++) {
                View view = (View) this.M.get(i);
                animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "alpha", new float[]{f4, f})});
                if (view instanceof TitleBar) {
                    animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "translationY", new float[]{f2, f3})});
                }
            }
            animatorSet.setDuration(350);
            animatorSet.start();
            this.z = true;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    PictureSelectorPreviewFragment.this.z = false;
                    if (SdkVersionUtils.e() && PictureSelectorPreviewFragment.this.isAdded()) {
                        Window window = PictureSelectorPreviewFragment.this.requireActivity().getWindow();
                        WindowManager.LayoutParams attributes = window.getAttributes();
                        if (z2) {
                            attributes.flags |= 1024;
                            attributes.layoutInDisplayCutoutMode = 1;
                            window.setAttributes(attributes);
                            window.addFlags(512);
                            return;
                        }
                        attributes.flags &= -1025;
                        window.setAttributes(attributes);
                        window.clearFlags(512);
                    }
                }
            });
            if (z2) {
                C3();
            } else {
                X2();
            }
        }
    }

    public void v3(Bundle bundle) {
        if (bundle != null) {
            this.c = bundle.getInt("com.luck.picture.lib.current_page", 1);
            this.D = bundle.getLong("com.luck.picture.lib.current_bucketId", -1);
            this.s = bundle.getInt("com.luck.picture.lib.current_preview_position", this.s);
            this.w = bundle.getBoolean("com.luck.picture.lib.display_camera", this.w);
            this.A = bundle.getInt("com.luck.picture.lib.current_album_total", this.A);
            this.x = bundle.getBoolean("com.luck.picture.lib.external_preview", this.x);
            this.y = bundle.getBoolean("com.luck.picture.lib.external_preview_display_delete", this.y);
            this.t = bundle.getBoolean("com.luck.picture.lib.bottom_preview", this.t);
            this.v = bundle.getString("com.luck.picture.lib.current_album_name", "");
            if (this.l.size() == 0) {
                this.l.addAll(new ArrayList(this.e.s1));
            }
        }
    }

    public final void w3() {
        BasePreviewHolder h;
        PicturePreviewAdapter picturePreviewAdapter = this.o;
        if (picturePreviewAdapter != null && (h = picturePreviewAdapter.h(this.n.getCurrentItem())) != null) {
            h.l();
        }
    }

    public void x3(int i, int i2, ArrayList arrayList, boolean z2) {
        this.l = arrayList;
        this.A = i2;
        this.s = i;
        this.y = z2;
        this.x = true;
    }

    public void y3(boolean z2, String str, boolean z3, int i, int i2, int i3, long j, ArrayList arrayList) {
        this.c = i3;
        this.D = j;
        this.l = arrayList;
        this.A = i2;
        this.s = i;
        this.v = str;
        this.w = z3;
        this.t = z2;
    }

    public void z3() {
        if (e3()) {
            this.m.setOnMojitoViewCallback(new OnMagicalViewCallback() {
                public void a(boolean z) {
                    PictureSelectorPreviewFragment.this.s3(z);
                }

                public void b(MagicalView magicalView, boolean z) {
                    PictureSelectorPreviewFragment.this.q3(magicalView, z);
                }

                public void c() {
                    PictureSelectorPreviewFragment.this.t3();
                }

                public void d(float f) {
                    PictureSelectorPreviewFragment.this.p3(f);
                }

                public void e() {
                    PictureSelectorPreviewFragment.this.r3();
                }
            });
        }
    }
}
