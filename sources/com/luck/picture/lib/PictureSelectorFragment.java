package com.luck.picture.lib;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.luck.picture.lib.adapter.PictureImageGridAdapter;
import com.luck.picture.lib.animators.AlphaInAnimationAdapter;
import com.luck.picture.lib.animators.SlideInBottomAnimationAdapter;
import com.luck.picture.lib.basic.IBridgeLoaderFactory;
import com.luck.picture.lib.basic.IPictureSelectorEvent;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.luck.picture.lib.dialog.AlbumListPopWindow;
import com.luck.picture.lib.engine.ExtendLoaderEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnAlbumItemClickListener;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.interfaces.OnQueryAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.interfaces.OnRecyclerViewPreloadMoreListener;
import com.luck.picture.lib.interfaces.OnRecyclerViewScrollListener;
import com.luck.picture.lib.interfaces.OnRecyclerViewScrollStateListener;
import com.luck.picture.lib.interfaces.OnRequestPermissionListener;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.luck.picture.lib.loader.LocalMediaLoader;
import com.luck.picture.lib.loader.LocalMediaPageLoader;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.permissions.PermissionResultCallback;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.ActivityCompatHelper;
import com.luck.picture.lib.utils.AnimUtils;
import com.luck.picture.lib.utils.DateUtils;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.DoubleUtils;
import com.luck.picture.lib.utils.StyleUtils;
import com.luck.picture.lib.utils.ToastUtils;
import com.luck.picture.lib.utils.ValueOf;
import com.luck.picture.lib.widget.BottomNavBar;
import com.luck.picture.lib.widget.CompleteSelectView;
import com.luck.picture.lib.widget.RecyclerPreloadView;
import com.luck.picture.lib.widget.SlideSelectTouchListener;
import com.luck.picture.lib.widget.SlideSelectionHandler;
import com.luck.picture.lib.widget.TitleBar;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class PictureSelectorFragment extends PictureCommonFragment implements OnRecyclerViewPreloadMoreListener, IPictureSelectorEvent {
    public static final String A = "PictureSelectorFragment";
    public static final Object B = new Object();
    public static int C = 135;
    public RecyclerPreloadView l;
    public TextView m;
    public TitleBar n;
    public BottomNavBar o;
    public CompleteSelectView p;
    public TextView q;
    public long r = 0;
    public int s;
    public int t = -1;
    public boolean u;
    public boolean v;
    public boolean w;
    public PictureImageGridAdapter x;
    public AlbumListPopWindow y;
    public SlideSelectTouchListener z;

    public static PictureSelectorFragment A3() {
        PictureSelectorFragment pictureSelectorFragment = new PictureSelectorFragment();
        pictureSelectorFragment.setArguments(new Bundle());
        return pictureSelectorFragment;
    }

    public void A1(boolean z2, LocalMedia localMedia) {
        this.o.h();
        this.p.setSelectedChange(false);
        if (g3(z2)) {
            this.x.l(localMedia.position);
            this.l.postDelayed(new Runnable() {
                public void run() {
                    PictureSelectorFragment.this.x.notifyDataSetChanged();
                }
            }, (long) C);
        } else {
            this.x.l(localMedia.position);
        }
        if (!z2) {
            I1(true);
        }
    }

    public void B3() {
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

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void C3(int r14, boolean r15) {
        /*
            r13 = this;
            androidx.fragment.app.FragmentActivity r1 = r13.getActivity()
            java.lang.String r11 = com.luck.picture.lib.PictureSelectorPreviewFragment.P
            boolean r1 = com.luck.picture.lib.utils.ActivityCompatHelper.b(r1, r11)
            if (r1 == 0) goto L_0x00c0
            r1 = 0
            if (r15 == 0) goto L_0x0024
            java.util.ArrayList r2 = new java.util.ArrayList
            com.luck.picture.lib.config.SelectorConfig r3 = r13.e
            java.util.ArrayList r3 = r3.h()
            r2.<init>(r3)
            int r3 = r2.size()
            r4 = 0
        L_0x0020:
            r10 = r2
            r6 = r3
            r8 = r4
            goto L_0x0059
        L_0x0024:
            java.util.ArrayList r2 = new java.util.ArrayList
            com.luck.picture.lib.adapter.PictureImageGridAdapter r3 = r13.x
            java.util.ArrayList r3 = r3.h()
            r2.<init>(r3)
            com.luck.picture.lib.config.SelectorConfig r3 = r13.e
            com.luck.picture.lib.entity.LocalMediaFolder r3 = r3.q1
            if (r3 == 0) goto L_0x0041
            int r4 = r3.getFolderTotalNum()
            long r5 = r3.getBucketId()
            r10 = r2
            r8 = r5
            r6 = r4
            goto L_0x0059
        L_0x0041:
            int r3 = r2.size()
            int r4 = r2.size()
            if (r4 <= 0) goto L_0x0056
            java.lang.Object r4 = r2.get(r1)
            com.luck.picture.lib.entity.LocalMedia r4 = (com.luck.picture.lib.entity.LocalMedia) r4
            long r4 = r4.getBucketId()
            goto L_0x0020
        L_0x0056:
            r4 = -1
            goto L_0x0020
        L_0x0059:
            if (r15 != 0) goto L_0x0073
            com.luck.picture.lib.config.SelectorConfig r2 = r13.e
            boolean r3 = r2.L
            if (r3 == 0) goto L_0x0073
            com.luck.picture.lib.widget.RecyclerPreloadView r3 = r13.l
            boolean r2 = r2.K
            if (r2 == 0) goto L_0x0068
            goto L_0x0070
        L_0x0068:
            android.content.Context r1 = r13.getContext()
            int r1 = com.luck.picture.lib.utils.DensityUtil.i(r1)
        L_0x0070:
            com.luck.picture.lib.magical.BuildRecycleItemViewParams.c(r3, r1)
        L_0x0073:
            com.luck.picture.lib.config.SelectorConfig r1 = r13.e
            com.luck.picture.lib.interfaces.OnPreviewInterceptListener r1 = r1.f1
            if (r1 == 0) goto L_0x0097
            android.content.Context r2 = r13.getContext()
            int r4 = r13.c
            com.luck.picture.lib.widget.TitleBar r3 = r13.n
            java.lang.String r7 = r3.getTitleText()
            com.luck.picture.lib.adapter.PictureImageGridAdapter r0 = r13.x
            boolean r11 = r0.k()
            r0 = r1
            r1 = r2
            r2 = r14
            r3 = r6
            r5 = r8
            r8 = r11
            r9 = r10
            r10 = r15
            r0.a(r1, r2, r3, r4, r5, r7, r8, r9, r10)
            goto L_0x00c0
        L_0x0097:
            androidx.fragment.app.FragmentActivity r1 = r13.getActivity()
            boolean r1 = com.luck.picture.lib.utils.ActivityCompatHelper.b(r1, r11)
            if (r1 == 0) goto L_0x00c0
            com.luck.picture.lib.PictureSelectorPreviewFragment r12 = com.luck.picture.lib.PictureSelectorPreviewFragment.i3()
            com.luck.picture.lib.widget.TitleBar r1 = r13.n
            java.lang.String r3 = r1.getTitleText()
            com.luck.picture.lib.adapter.PictureImageGridAdapter r1 = r13.x
            boolean r4 = r1.k()
            int r7 = r13.c
            r1 = r12
            r2 = r15
            r5 = r14
            r1.y3(r2, r3, r4, r5, r6, r7, r8, r10)
            androidx.fragment.app.FragmentActivity r0 = r13.getActivity()
            com.luck.picture.lib.basic.FragmentInjectManager.a(r0, r11, r12)
        L_0x00c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorFragment.C3(int, boolean):void");
    }

    public final boolean D3() {
        Context requireContext;
        int i;
        SelectorConfig selectorConfig = this.e;
        if (!selectorConfig.e0 || !selectorConfig.I0) {
            return false;
        }
        LocalMediaFolder localMediaFolder = new LocalMediaFolder();
        localMediaFolder.setBucketId(-1);
        if (TextUtils.isEmpty(this.e.c0)) {
            TitleBar titleBar = this.n;
            if (this.e.f9404a == SelectMimeType.b()) {
                requireContext = requireContext();
                i = R.string.ps_all_audio;
            } else {
                requireContext = requireContext();
                i = R.string.ps_camera_roll;
            }
            titleBar.setTitle(requireContext.getString(i));
        } else {
            this.n.setTitle(this.e.c0);
        }
        localMediaFolder.setFolderName(this.n.getTitleText());
        this.e.q1 = localMediaFolder;
        w3(localMediaFolder.getBucketId());
        return true;
    }

    public void E3(Bundle bundle) {
        if (bundle != null) {
            this.s = bundle.getInt("com.luck.picture.lib.all_folder_size");
            this.c = bundle.getInt("com.luck.picture.lib.current_page", this.c);
            this.t = bundle.getInt("com.luck.picture.lib.current_preview_position", this.t);
            this.w = bundle.getBoolean("com.luck.picture.lib.display_camera", this.e.D);
            return;
        }
        this.w = this.e.D;
    }

    public final void F3() {
        this.x.p(this.w);
        M1(0);
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig.o0) {
            j3(selectorConfig.q1);
        } else {
            l3(new ArrayList(this.e.t1));
        }
    }

    public final void G3() {
        if (this.t > 0) {
            this.l.post(new Runnable() {
                public void run() {
                    PictureSelectorFragment.this.l.scrollToPosition(PictureSelectorFragment.this.t);
                    PictureSelectorFragment.this.l.setLastVisiblePosition(PictureSelectorFragment.this.t);
                }
            });
        }
    }

    public final void H3(List list) {
        try {
            if (this.e.e0 && this.u) {
                synchronized (B) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (this.x.h().contains(it.next())) {
                            it.remove();
                        }
                    }
                }
            }
        } catch (Exception e) {
            try {
                e.printStackTrace();
            } catch (Throwable th) {
                this.u = false;
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        this.u = false;
    }

    public void I1(boolean z2) {
        if (this.e.K0.c().a0()) {
            int i = 0;
            while (i < this.e.g()) {
                LocalMedia localMedia = (LocalMedia) this.e.h().get(i);
                i++;
                localMedia.setNum(i);
                if (z2) {
                    this.x.l(localMedia.position);
                }
            }
        }
    }

    public final void I3() {
        this.x.p(this.w);
        if (PermissionChecker.g(this.e.f9404a, getContext())) {
            f3();
            return;
        }
        final String[] a2 = PermissionConfig.a(T0(), this.e.f9404a);
        v1(true, a2);
        if (this.e.d1 != null) {
            f1(-1, a2);
        } else {
            PermissionChecker.b().m(this, a2, new PermissionResultCallback() {
                public void a() {
                    PictureSelectorFragment.this.f3();
                }

                public void b() {
                    PictureSelectorFragment.this.Z0(a2);
                }
            });
        }
    }

    public final void J3(final ArrayList arrayList) {
        long U0 = U0();
        if (U0 > 0) {
            requireView().postDelayed(new Runnable() {
                public void run() {
                    PictureSelectorFragment.this.K3(arrayList);
                }
            }, U0);
        } else {
            K3(arrayList);
        }
    }

    public final void K3(ArrayList arrayList) {
        M1(0);
        I1(false);
        this.x.o(arrayList);
        this.e.u1.clear();
        this.e.t1.clear();
        G3();
        if (this.x.j()) {
            N3();
        } else {
            o3();
        }
    }

    public final void L3() {
        int firstVisiblePosition;
        if (this.e.y0 && (firstVisiblePosition = this.l.getFirstVisiblePosition()) != -1) {
            ArrayList h = this.x.h();
            if (h.size() > firstVisiblePosition && ((LocalMedia) h.get(firstVisiblePosition)).getDateAddedTime() > 0) {
                this.q.setText(DateUtils.e(getContext(), ((LocalMedia) h.get(firstVisiblePosition)).getDateAddedTime()));
            }
        }
    }

    public final void M3() {
        if (this.e.y0 && this.x.h().size() > 0 && this.q.getAlpha() == 0.0f) {
            this.q.animate().setDuration(150).alphaBy(1.0f).start();
        }
    }

    public void N() {
        if (this.v) {
            requireView().postDelayed(new Runnable() {
                public void run() {
                    PictureSelectorFragment.this.x3();
                }
            }, 350);
        } else {
            x3();
        }
    }

    public final void N3() {
        LocalMediaFolder localMediaFolder = this.e.q1;
        if (localMediaFolder == null || localMediaFolder.getBucketId() == -1) {
            if (this.m.getVisibility() == 8) {
                this.m.setVisibility(0);
            }
            this.m.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.drawable.ps_ic_no_data, 0, 0);
            this.m.setText(getString(this.e.f9404a == SelectMimeType.b() ? R.string.ps_audio_empty : R.string.ps_empty));
        }
    }

    public void O0(LocalMedia localMedia) {
        if (!u3(this.y.g())) {
            this.x.h().add(0, localMedia);
            this.u = true;
        }
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig.j != 1 || !selectorConfig.c) {
            D0(localMedia, false);
        } else {
            selectorConfig.r1.clear();
            if (D0(localMedia, false) == 0) {
                Q0();
            }
        }
        this.x.notifyItemInserted(this.e.D ? 1 : 0);
        PictureImageGridAdapter pictureImageGridAdapter = this.x;
        boolean z2 = this.e.D;
        pictureImageGridAdapter.notifyItemRangeChanged(z2 ? 1 : 0, pictureImageGridAdapter.h().size());
        SelectorConfig selectorConfig2 = this.e;
        if (selectorConfig2.o0) {
            LocalMediaFolder localMediaFolder = selectorConfig2.q1;
            if (localMediaFolder == null) {
                localMediaFolder = new LocalMediaFolder();
            }
            localMediaFolder.setBucketId(ValueOf.e(Integer.valueOf(localMedia.getParentFolderName().hashCode())));
            localMediaFolder.setFolderName(localMedia.getParentFolderName());
            localMediaFolder.setFirstMimeType(localMedia.getMimeType());
            localMediaFolder.setFirstImagePath(localMedia.getPath());
            localMediaFolder.setFolderTotalNum(this.x.h().size());
            localMediaFolder.setCurrentDataPage(this.c);
            localMediaFolder.setHasMore(false);
            localMediaFolder.setData(this.x.h());
            this.l.setEnabledLoadMore(false);
            this.e.q1 = localMediaFolder;
        } else {
            z3(localMedia);
        }
        this.s = 0;
        if (this.x.h().size() > 0 || this.e.c) {
            o3();
        } else {
            N3();
        }
    }

    public int W0() {
        int a2 = InjectResourceSource.a(getContext(), 1, this.e);
        return a2 != 0 ? a2 : R.layout.ps_fragment_selector;
    }

    public void a1(String[] strArr) {
        if (strArr != null) {
            v1(false, (String[]) null);
            boolean z2 = strArr.length > 0 && TextUtils.equals(strArr[0], PermissionConfig.b[0]);
            OnPermissionsInterceptListener onPermissionsInterceptListener = this.e.d1;
            if (onPermissionsInterceptListener != null ? onPermissionsInterceptListener.a(this, strArr) : PermissionChecker.i(getContext(), strArr)) {
                if (z2) {
                    D1();
                } else {
                    f3();
                }
            } else if (z2) {
                ToastUtils.c(getContext(), getString(R.string.ps_camera));
            } else {
                ToastUtils.c(getContext(), getString(R.string.ps_jurisdiction));
                s1();
            }
            PermissionConfig.f9440a = new String[0];
        }
    }

    public final void d3() {
        this.y.k(new OnAlbumItemClickListener() {
            public void a(int i, LocalMediaFolder localMediaFolder) {
                PictureSelectorFragment pictureSelectorFragment = PictureSelectorFragment.this;
                boolean unused = pictureSelectorFragment.w = pictureSelectorFragment.e.D && localMediaFolder.getBucketId() == -1;
                PictureSelectorFragment.this.x.p(PictureSelectorFragment.this.w);
                PictureSelectorFragment.this.n.setTitle(localMediaFolder.getFolderName());
                LocalMediaFolder localMediaFolder2 = PictureSelectorFragment.this.e.q1;
                long bucketId = localMediaFolder2.getBucketId();
                if (PictureSelectorFragment.this.e.e0) {
                    if (localMediaFolder.getBucketId() != bucketId) {
                        localMediaFolder2.setData(PictureSelectorFragment.this.x.h());
                        localMediaFolder2.setCurrentDataPage(PictureSelectorFragment.this.c);
                        localMediaFolder2.setHasMore(PictureSelectorFragment.this.l.a());
                        if (localMediaFolder.getData().size() <= 0 || localMediaFolder.isHasMore()) {
                            int unused2 = PictureSelectorFragment.this.c = 1;
                            if (PictureSelectorFragment.this.e.S0 != null) {
                                PictureSelectorFragment.this.e.S0.d(PictureSelectorFragment.this.getContext(), localMediaFolder.getBucketId(), PictureSelectorFragment.this.c, PictureSelectorFragment.this.e.d0, new OnQueryDataResultListener<LocalMedia>() {
                                    public void a(ArrayList arrayList, boolean z) {
                                        PictureSelectorFragment.this.m3(arrayList, z);
                                    }
                                });
                            } else {
                                PictureSelectorFragment.this.d.h(localMediaFolder.getBucketId(), PictureSelectorFragment.this.c, PictureSelectorFragment.this.e.d0, new OnQueryDataResultListener<LocalMedia>() {
                                    public void a(ArrayList arrayList, boolean z) {
                                        PictureSelectorFragment.this.m3(arrayList, z);
                                    }
                                });
                            }
                        } else {
                            PictureSelectorFragment.this.J3(localMediaFolder.getData());
                            int unused3 = PictureSelectorFragment.this.c = localMediaFolder.getCurrentDataPage();
                            PictureSelectorFragment.this.l.setEnabledLoadMore(localMediaFolder.isHasMore());
                            PictureSelectorFragment.this.l.smoothScrollToPosition(0);
                        }
                    }
                } else if (localMediaFolder.getBucketId() != bucketId) {
                    PictureSelectorFragment.this.J3(localMediaFolder.getData());
                    PictureSelectorFragment.this.l.smoothScrollToPosition(0);
                }
                PictureSelectorFragment.this.e.q1 = localMediaFolder;
                PictureSelectorFragment.this.y.dismiss();
                if (PictureSelectorFragment.this.z != null && PictureSelectorFragment.this.e.z0) {
                    PictureSelectorFragment.this.z.n(PictureSelectorFragment.this.x.k() ? 1 : 0);
                }
            }
        });
    }

    public final void e3() {
        this.x.q(new PictureImageGridAdapter.OnItemClickListener() {
            public int a(View view, int i, LocalMedia localMedia) {
                int D0 = PictureSelectorFragment.this.D0(localMedia, view.isSelected());
                if (D0 == 0) {
                    if (PictureSelectorFragment.this.e.o1 != null) {
                        long a2 = PictureSelectorFragment.this.e.o1.a(view);
                        if (a2 > 0) {
                            int unused = PictureSelectorFragment.C = (int) a2;
                        }
                    } else {
                        Animation loadAnimation = AnimationUtils.loadAnimation(PictureSelectorFragment.this.getContext(), R.anim.ps_anim_modal_in);
                        int unused2 = PictureSelectorFragment.C = (int) loadAnimation.getDuration();
                        view.startAnimation(loadAnimation);
                    }
                }
                return D0;
            }

            public void b() {
                if (!DoubleUtils.a()) {
                    PictureSelectorFragment.this.D1();
                }
            }

            public void c(View view, int i, LocalMedia localMedia) {
                if (PictureSelectorFragment.this.e.j == 1 && PictureSelectorFragment.this.e.c) {
                    PictureSelectorFragment.this.e.r1.clear();
                    if (PictureSelectorFragment.this.D0(localMedia, false) == 0) {
                        PictureSelectorFragment.this.Q0();
                    }
                } else if (!DoubleUtils.a()) {
                    PictureSelectorFragment.this.C3(i, false);
                }
            }

            public void d(View view, int i) {
                if (PictureSelectorFragment.this.z != null && PictureSelectorFragment.this.e.z0) {
                    ((Vibrator) PictureSelectorFragment.this.getActivity().getSystemService("vibrator")).vibrate(50);
                    PictureSelectorFragment.this.z.p(i);
                }
            }
        });
        this.l.setOnRecyclerViewScrollStateListener(new OnRecyclerViewScrollStateListener() {
            public void a() {
                if (PictureSelectorFragment.this.e.L0 != null) {
                    PictureSelectorFragment.this.e.L0.d(PictureSelectorFragment.this.getContext());
                }
            }

            public void b() {
                if (PictureSelectorFragment.this.e.L0 != null) {
                    PictureSelectorFragment.this.e.L0.b(PictureSelectorFragment.this.getContext());
                }
            }
        });
        this.l.setOnRecyclerViewScrollListener(new OnRecyclerViewScrollListener() {
            public void a(int i) {
                if (i == 1) {
                    PictureSelectorFragment.this.M3();
                } else if (i == 0) {
                    PictureSelectorFragment.this.n3();
                }
            }

            public void b(int i, int i2) {
                PictureSelectorFragment.this.L3();
            }
        });
        if (this.e.z0) {
            final HashSet hashSet = new HashSet();
            SlideSelectTouchListener r2 = new SlideSelectTouchListener().n(this.x.k() ? 1 : 0).r(new SlideSelectionHandler(new SlideSelectionHandler.ISelectionHandler() {
                public void a(int i, int i2, boolean z, boolean z2) {
                    ArrayList h = PictureSelectorFragment.this.x.h();
                    if (h.size() != 0 && i <= h.size()) {
                        LocalMedia localMedia = (LocalMedia) h.get(i);
                        PictureSelectorFragment pictureSelectorFragment = PictureSelectorFragment.this;
                        PictureSelectorFragment.this.z.m(pictureSelectorFragment.D0(localMedia, pictureSelectorFragment.e.h().contains(localMedia)) != -1);
                    }
                }

                /* renamed from: b */
                public HashSet getSelection() {
                    for (int i = 0; i < PictureSelectorFragment.this.e.g(); i++) {
                        hashSet.add(Integer.valueOf(((LocalMedia) PictureSelectorFragment.this.e.h().get(i)).position));
                    }
                    return hashSet;
                }
            }));
            this.z = r2;
            this.l.addOnItemTouchListener(r2);
        }
    }

    public void f1(int i, String[] strArr) {
        if (i != -1) {
            super.f1(i, strArr);
        } else {
            this.e.d1.b(this, strArr, new OnRequestPermissionListener() {
            });
        }
    }

    public final void f3() {
        v1(false, (String[]) null);
        if (this.e.o0) {
            y3();
        } else {
            v3();
        }
    }

    public final boolean g3(boolean z2) {
        SelectorConfig selectorConfig = this.e;
        if (!selectorConfig.g0) {
            return false;
        }
        if (selectorConfig.P) {
            if (selectorConfig.j == 1) {
                return false;
            }
            int g = selectorConfig.g();
            SelectorConfig selectorConfig2 = this.e;
            if (g != selectorConfig2.k && (z2 || selectorConfig2.g() != this.e.k - 1)) {
                return false;
            }
        } else if (selectorConfig.g() != 0 && (!z2 || this.e.g() != 1)) {
            if (PictureMimeType.i(this.e.f())) {
                SelectorConfig selectorConfig3 = this.e;
                int i = selectorConfig3.m;
                if (i <= 0) {
                    i = selectorConfig3.k;
                }
                if (selectorConfig3.g() != i && (z2 || this.e.g() != i - 1)) {
                    return false;
                }
            } else {
                int g2 = this.e.g();
                SelectorConfig selectorConfig4 = this.e;
                if (g2 != selectorConfig4.k && (z2 || selectorConfig4.g() != this.e.k - 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void h3(boolean z2, List list) {
        LocalMediaFolder localMediaFolder;
        if (!ActivityCompatHelper.c(getActivity())) {
            if (list.size() > 0) {
                if (z2) {
                    localMediaFolder = (LocalMediaFolder) list.get(0);
                    this.e.q1 = localMediaFolder;
                } else {
                    localMediaFolder = this.e.q1;
                    if (localMediaFolder == null) {
                        localMediaFolder = (LocalMediaFolder) list.get(0);
                        this.e.q1 = localMediaFolder;
                    }
                }
                this.n.setTitle(localMediaFolder.getFolderName());
                this.y.c(list);
                SelectorConfig selectorConfig = this.e;
                if (!selectorConfig.e0) {
                    J3(localMediaFolder.getData());
                } else if (selectorConfig.I0) {
                    this.l.setEnabledLoadMore(true);
                } else {
                    w3(localMediaFolder.getBucketId());
                }
            } else {
                N3();
            }
        }
    }

    public void i1() {
        this.o.g();
    }

    public final void i3(ArrayList arrayList, boolean z2) {
        if (!ActivityCompatHelper.c(getActivity())) {
            this.l.setEnabledLoadMore(z2);
            if (!this.l.a() || arrayList.size() != 0) {
                J3(arrayList);
            } else {
                N();
            }
        }
    }

    public final void j3(LocalMediaFolder localMediaFolder) {
        if (!ActivityCompatHelper.c(getActivity())) {
            String str = this.e.Y;
            boolean z2 = localMediaFolder != null;
            this.n.setTitle(z2 ? localMediaFolder.getFolderName() : new File(str).getName());
            if (z2) {
                this.e.q1 = localMediaFolder;
                J3(localMediaFolder.getData());
                return;
            }
            N3();
        }
    }

    public final void k3(List list, boolean z2) {
        if (!ActivityCompatHelper.c(getActivity())) {
            this.l.setEnabledLoadMore(z2);
            if (this.l.a()) {
                H3(list);
                if (list.size() > 0) {
                    int size = this.x.h().size();
                    this.x.h().addAll(list);
                    PictureImageGridAdapter pictureImageGridAdapter = this.x;
                    pictureImageGridAdapter.notifyItemRangeChanged(size, pictureImageGridAdapter.getItemCount());
                    o3();
                } else {
                    N();
                }
                if (list.size() < 10) {
                    RecyclerPreloadView recyclerPreloadView = this.l;
                    recyclerPreloadView.onScrolled(recyclerPreloadView.getScrollX(), this.l.getScrollY());
                }
            }
        }
    }

    public final void l3(List list) {
        if (!ActivityCompatHelper.c(getActivity())) {
            if (list.size() > 0) {
                LocalMediaFolder localMediaFolder = this.e.q1;
                if (localMediaFolder == null) {
                    localMediaFolder = (LocalMediaFolder) list.get(0);
                    this.e.q1 = localMediaFolder;
                }
                this.n.setTitle(localMediaFolder.getFolderName());
                this.y.c(list);
                if (this.e.e0) {
                    i3(new ArrayList(this.e.u1), true);
                } else {
                    J3(localMediaFolder.getData());
                }
            } else {
                N3();
            }
        }
    }

    public final void m3(ArrayList arrayList, boolean z2) {
        if (!ActivityCompatHelper.c(getActivity())) {
            this.l.setEnabledLoadMore(z2);
            if (arrayList.size() == 0) {
                this.x.h().clear();
            }
            J3(arrayList);
            this.l.onScrolled(0, 0);
            this.l.smoothScrollToPosition(0);
        }
    }

    public final void n3() {
        if (this.e.y0 && this.x.h().size() > 0) {
            this.q.animate().setDuration(250).alpha(0.0f).start();
        }
    }

    public final void o3() {
        if (this.m.getVisibility() == 0) {
            this.m.setVisibility(8);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        SlideSelectTouchListener slideSelectTouchListener = this.z;
        if (slideSelectTouchListener != null) {
            slideSelectTouchListener.q();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("com.luck.picture.lib.all_folder_size", this.s);
        bundle.putInt("com.luck.picture.lib.current_page", this.c);
        bundle.putInt("com.luck.picture.lib.current_preview_position", this.l.getLastVisiblePosition());
        bundle.putBoolean("com.luck.picture.lib.display_camera", this.x.k());
        this.e.a(this.y.f());
        this.e.b(this.x.h());
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        E3(bundle);
        this.v = bundle != null;
        this.m = (TextView) view.findViewById(R.id.tv_data_empty);
        this.p = (CompleteSelectView) view.findViewById(R.id.ps_complete_select);
        this.n = (TitleBar) view.findViewById(R.id.title_bar);
        this.o = (BottomNavBar) view.findViewById(R.id.bottom_nar_bar);
        this.q = (TextView) view.findViewById(R.id.tv_current_data_time);
        B3();
        p3();
        t3();
        r3();
        s3(view);
        q3();
        if (this.v) {
            F3();
        } else {
            I3();
        }
    }

    public void p1(LocalMedia localMedia) {
        this.x.l(localMedia.position);
    }

    public final void p3() {
        AlbumListPopWindow d = AlbumListPopWindow.d(getContext(), this.e);
        this.y = d;
        d.l(new AlbumListPopWindow.OnPopupWindowStatusListener() {
            public void a() {
                if (!PictureSelectorFragment.this.e.o0) {
                    AnimUtils.a(PictureSelectorFragment.this.n.getImageArrow(), true);
                }
            }

            public void b() {
                if (!PictureSelectorFragment.this.e.o0) {
                    AnimUtils.a(PictureSelectorFragment.this.n.getImageArrow(), false);
                }
            }
        });
        d3();
    }

    public void q1() {
        P1(requireView());
    }

    public final void q3() {
        this.o.f();
        this.o.setOnBottomNavBarListener(new BottomNavBar.OnBottomNavBarListener() {
            public void a() {
                PictureSelectorFragment.this.L1();
            }

            public void d() {
                PictureSelectorFragment.this.C3(0, true);
            }
        });
        this.o.h();
    }

    public final void r3() {
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig.j != 1 || !selectorConfig.c) {
            this.p.c();
            this.p.setSelectedChange(false);
            if (this.e.K0.c().V()) {
                if (this.p.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                    ((ConstraintLayout.LayoutParams) this.p.getLayoutParams()).i = R.id.title_bar;
                    ((ConstraintLayout.LayoutParams) this.p.getLayoutParams()).l = R.id.title_bar;
                    if (this.e.K) {
                        ((ConstraintLayout.LayoutParams) this.p.getLayoutParams()).topMargin = DensityUtil.i(getContext());
                    }
                } else if ((this.p.getLayoutParams() instanceof RelativeLayout.LayoutParams) && this.e.K) {
                    ((RelativeLayout.LayoutParams) this.p.getLayoutParams()).topMargin = DensityUtil.i(getContext());
                }
            }
            this.p.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (!PictureSelectorFragment.this.e.N || PictureSelectorFragment.this.e.g() != 0) {
                        PictureSelectorFragment.this.Q0();
                    } else {
                        PictureSelectorFragment.this.o1();
                    }
                }
            });
            return;
        }
        selectorConfig.K0.d().v(false);
        this.n.getTitleCancelView().setVisibility(0);
        this.p.setVisibility(8);
    }

    public final void s3(View view) {
        this.l = (RecyclerPreloadView) view.findViewById(R.id.recycler);
        SelectMainStyle c = this.e.K0.c();
        int z2 = c.z();
        if (StyleUtils.c(z2)) {
            this.l.setBackgroundColor(z2);
        } else {
            this.l.setBackgroundColor(ContextCompat.getColor(T0(), R.color.ps_color_black));
        }
        int i = this.e.w;
        if (i <= 0) {
            i = 4;
        }
        if (this.l.getItemDecorationCount() == 0) {
            if (StyleUtils.b(c.n())) {
                this.l.addItemDecoration(new GridSpacingItemDecoration(i, c.n(), c.U()));
            } else {
                this.l.addItemDecoration(new GridSpacingItemDecoration(i, DensityUtil.a(view.getContext(), 1.0f), c.U()));
            }
        }
        this.l.setLayoutManager(new GridLayoutManager(getContext(), i));
        RecyclerView.ItemAnimator itemAnimator = this.l.getItemAnimator();
        if (itemAnimator != null) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            this.l.setItemAnimator((RecyclerView.ItemAnimator) null);
        }
        if (this.e.e0) {
            this.l.setReachBottomRow(2);
            this.l.setOnRecyclerViewPreloadListener(this);
        } else {
            this.l.setHasFixedSize(true);
        }
        PictureImageGridAdapter pictureImageGridAdapter = new PictureImageGridAdapter(getContext(), this.e);
        this.x = pictureImageGridAdapter;
        pictureImageGridAdapter.p(this.w);
        int i2 = this.e.h0;
        if (i2 == 1) {
            this.l.setAdapter(new AlphaInAnimationAdapter(this.x));
        } else if (i2 != 2) {
            this.l.setAdapter(this.x);
        } else {
            this.l.setAdapter(new SlideInBottomAnimationAdapter(this.x));
        }
        e3();
    }

    public final void t3() {
        if (this.e.K0.d().u()) {
            this.n.setVisibility(8);
        }
        this.n.d();
        this.n.setOnTitleBarListener(new TitleBar.OnTitleBarListener() {
            public void a() {
                if (PictureSelectorFragment.this.y.isShowing()) {
                    PictureSelectorFragment.this.y.dismiss();
                } else {
                    PictureSelectorFragment.this.s1();
                }
            }

            public void b(View view) {
                PictureSelectorFragment.this.y.showAsDropDown(view);
            }

            public void c() {
                if (!PictureSelectorFragment.this.e.i0) {
                    return;
                }
                if (SystemClock.uptimeMillis() - PictureSelectorFragment.this.r >= ((long) 500) || PictureSelectorFragment.this.x.getItemCount() <= 0) {
                    long unused = PictureSelectorFragment.this.r = SystemClock.uptimeMillis();
                } else {
                    PictureSelectorFragment.this.l.scrollToPosition(0);
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r1 = r1.s;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean u3(int r2) {
        /*
            r1 = this;
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r1.s
            if (r1 <= 0) goto L_0x000b
            if (r1 >= r2) goto L_0x000b
            r0 = 1
        L_0x000b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorFragment.u3(int):boolean");
    }

    public void v3() {
        ExtendLoaderEngine extendLoaderEngine = this.e.S0;
        if (extendLoaderEngine != null) {
            extendLoaderEngine.a(getContext(), new OnQueryAllAlbumListener<LocalMediaFolder>() {
                public void a(List list) {
                    PictureSelectorFragment.this.h3(false, list);
                }
            });
            return;
        }
        final boolean D3 = D3();
        this.d.f(new OnQueryAllAlbumListener<LocalMediaFolder>() {
            public void a(List list) {
                PictureSelectorFragment.this.h3(D3, list);
            }
        });
    }

    public void w3(long j) {
        this.c = 1;
        this.l.setEnabledLoadMore(true);
        SelectorConfig selectorConfig = this.e;
        ExtendLoaderEngine extendLoaderEngine = selectorConfig.S0;
        if (extendLoaderEngine != null) {
            Context context = getContext();
            int i = this.c;
            extendLoaderEngine.d(context, j, i, i * this.e.d0, new OnQueryDataResultListener<LocalMedia>() {
                public void a(ArrayList arrayList, boolean z) {
                    PictureSelectorFragment.this.i3(arrayList, z);
                }
            });
            return;
        }
        IBridgeMediaLoader iBridgeMediaLoader = this.d;
        int i2 = this.c;
        iBridgeMediaLoader.h(j, i2, i2 * selectorConfig.d0, new OnQueryDataResultListener<LocalMedia>() {
            public void a(ArrayList arrayList, boolean z) {
                PictureSelectorFragment.this.i3(arrayList, z);
            }
        });
    }

    public void x3() {
        if (this.l.a()) {
            this.c++;
            LocalMediaFolder localMediaFolder = this.e.q1;
            long bucketId = localMediaFolder != null ? localMediaFolder.getBucketId() : 0;
            SelectorConfig selectorConfig = this.e;
            ExtendLoaderEngine extendLoaderEngine = selectorConfig.S0;
            if (extendLoaderEngine != null) {
                Context context = getContext();
                int i = this.c;
                int i2 = this.e.d0;
                extendLoaderEngine.b(context, bucketId, i, i2, i2, new OnQueryDataResultListener<LocalMedia>() {
                    public void a(ArrayList arrayList, boolean z) {
                        PictureSelectorFragment.this.k3(arrayList, z);
                    }
                });
                return;
            }
            this.d.h(bucketId, this.c, selectorConfig.d0, new OnQueryDataResultListener<LocalMedia>() {
                public void a(ArrayList arrayList, boolean z) {
                    PictureSelectorFragment.this.k3(arrayList, z);
                }
            });
        }
    }

    public void y3() {
        ExtendLoaderEngine extendLoaderEngine = this.e.S0;
        if (extendLoaderEngine != null) {
            extendLoaderEngine.c(getContext(), new OnQueryAlbumListener<LocalMediaFolder>() {
                /* renamed from: b */
                public void a(LocalMediaFolder localMediaFolder) {
                    PictureSelectorFragment.this.j3(localMediaFolder);
                }
            });
        } else {
            this.d.g(new OnQueryAlbumListener<LocalMediaFolder>() {
                /* renamed from: b */
                public void a(LocalMediaFolder localMediaFolder) {
                    PictureSelectorFragment.this.j3(localMediaFolder);
                }
            });
        }
    }

    public final void z3(LocalMedia localMedia) {
        LocalMediaFolder localMediaFolder;
        LocalMediaFolder localMediaFolder2;
        String str;
        List f = this.y.f();
        if (this.y.i() == 0) {
            localMediaFolder = new LocalMediaFolder();
            if (TextUtils.isEmpty(this.e.c0)) {
                str = getString(this.e.f9404a == SelectMimeType.b() ? R.string.ps_all_audio : R.string.ps_camera_roll);
            } else {
                str = this.e.c0;
            }
            localMediaFolder.setFolderName(str);
            localMediaFolder.setFirstImagePath("");
            localMediaFolder.setBucketId(-1);
            f.add(0, localMediaFolder);
        } else {
            localMediaFolder = this.y.h(0);
        }
        localMediaFolder.setFirstImagePath(localMedia.getPath());
        localMediaFolder.setFirstMimeType(localMedia.getMimeType());
        localMediaFolder.setData(this.x.h());
        localMediaFolder.setBucketId(-1);
        localMediaFolder.setFolderTotalNum(u3(localMediaFolder.getFolderTotalNum()) ? localMediaFolder.getFolderTotalNum() : localMediaFolder.getFolderTotalNum() + 1);
        LocalMediaFolder localMediaFolder3 = this.e.q1;
        if (localMediaFolder3 == null || localMediaFolder3.getFolderTotalNum() == 0) {
            this.e.q1 = localMediaFolder;
        }
        int i = 0;
        while (true) {
            if (i >= f.size()) {
                localMediaFolder2 = null;
                break;
            }
            localMediaFolder2 = (LocalMediaFolder) f.get(i);
            if (TextUtils.equals(localMediaFolder2.getFolderName(), localMedia.getParentFolderName())) {
                break;
            }
            i++;
        }
        if (localMediaFolder2 == null) {
            localMediaFolder2 = new LocalMediaFolder();
            f.add(localMediaFolder2);
        }
        localMediaFolder2.setFolderName(localMedia.getParentFolderName());
        if (localMediaFolder2.getBucketId() == -1 || localMediaFolder2.getBucketId() == 0) {
            localMediaFolder2.setBucketId(localMedia.getBucketId());
        }
        if (this.e.e0) {
            localMediaFolder2.setHasMore(true);
        } else if (!u3(localMediaFolder.getFolderTotalNum()) || !TextUtils.isEmpty(this.e.W) || !TextUtils.isEmpty(this.e.X)) {
            localMediaFolder2.getData().add(0, localMedia);
        }
        localMediaFolder2.setFolderTotalNum(u3(localMediaFolder.getFolderTotalNum()) ? localMediaFolder2.getFolderTotalNum() : localMediaFolder2.getFolderTotalNum() + 1);
        localMediaFolder2.setFirstImagePath(this.e.a0);
        localMediaFolder2.setFirstMimeType(localMedia.getMimeType());
        this.y.c(f);
    }
}
