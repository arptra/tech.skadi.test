package com.luck.picture.lib.config;

import com.luck.picture.lib.basic.IBridgeLoaderFactory;
import com.luck.picture.lib.basic.IBridgeViewLifecycle;
import com.luck.picture.lib.basic.InterpolatorFactory;
import com.luck.picture.lib.engine.CompressEngine;
import com.luck.picture.lib.engine.CompressFileEngine;
import com.luck.picture.lib.engine.CropEngine;
import com.luck.picture.lib.engine.CropFileEngine;
import com.luck.picture.lib.engine.ExtendLoaderEngine;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.engine.SandboxFileEngine;
import com.luck.picture.lib.engine.UriToFileTransformEngine;
import com.luck.picture.lib.engine.VideoPlayerEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnBitmapWatermarkEventListener;
import com.luck.picture.lib.interfaces.OnCameraInterceptListener;
import com.luck.picture.lib.interfaces.OnCustomLoadingListener;
import com.luck.picture.lib.interfaces.OnExternalPreviewEventListener;
import com.luck.picture.lib.interfaces.OnGridItemSelectAnimListener;
import com.luck.picture.lib.interfaces.OnInjectActivityPreviewListener;
import com.luck.picture.lib.interfaces.OnInjectLayoutResourceListener;
import com.luck.picture.lib.interfaces.OnMediaEditInterceptListener;
import com.luck.picture.lib.interfaces.OnPermissionDeniedListener;
import com.luck.picture.lib.interfaces.OnPermissionDescriptionListener;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.interfaces.OnPreviewInterceptListener;
import com.luck.picture.lib.interfaces.OnQueryFilterListener;
import com.luck.picture.lib.interfaces.OnRecordAudioInterceptListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.interfaces.OnSelectAnimListener;
import com.luck.picture.lib.interfaces.OnSelectFilterListener;
import com.luck.picture.lib.interfaces.OnSelectLimitTipsListener;
import com.luck.picture.lib.interfaces.OnVideoThumbnailEventListener;
import com.luck.picture.lib.magical.BuildRecycleItemViewParams;
import com.luck.picture.lib.style.PictureSelectorStyle;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.utils.FileDirMap;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.ArrayList;
import java.util.List;

public final class SelectorConfig {
    public long A;
    public boolean A0;
    public int B;
    public boolean B0;
    public int C;
    public boolean C0;
    public boolean D;
    public boolean D0;
    public boolean E;
    public boolean E0;
    public boolean F;
    public boolean F0;
    public boolean G;
    public boolean G0;
    public boolean H;
    public boolean H0;
    public boolean I;
    public boolean I0;
    public boolean J;
    public boolean J0;
    public boolean K;
    public PictureSelectorStyle K0;
    public boolean L;
    public ImageEngine L0;
    public boolean M;
    public CompressEngine M0;
    public boolean N;
    public CompressFileEngine N0;
    public boolean O;
    public CropEngine O0;
    public boolean P;
    public CropFileEngine P0;
    public List Q;
    public SandboxFileEngine Q0;
    public List R;
    public UriToFileTransformEngine R0;
    public boolean S;
    public ExtendLoaderEngine S0;
    public String T;
    public VideoPlayerEngine T0;
    public String U;
    public IBridgeViewLifecycle U0;
    public String V;
    public IBridgeLoaderFactory V0;
    public String W;
    public InterpolatorFactory W0;
    public String X;
    public OnCameraInterceptListener X0;
    public String Y;
    public OnSelectLimitTipsListener Y0;
    public String Z;
    public OnResultCallbackListener Z0;

    /* renamed from: a  reason: collision with root package name */
    public int f9404a;
    public String a0;
    public OnExternalPreviewEventListener a1;
    public boolean b;
    public String b0;
    public OnInjectActivityPreviewListener b1;
    public boolean c;
    public String c0;
    public OnMediaEditInterceptListener c1;
    public String d;
    public int d0;
    public OnPermissionsInterceptListener d1;
    public String e;
    public boolean e0;
    public OnInjectLayoutResourceListener e1;
    public String f;
    public boolean f0;
    public OnPreviewInterceptListener f1;
    public String g;
    public boolean g0;
    public OnSelectFilterListener g1;
    public int h;
    public int h0;
    public OnPermissionDescriptionListener h1;
    public boolean i;
    public boolean i0;
    public OnPermissionDeniedListener i1;
    public int j;
    public boolean j0;
    public OnRecordAudioInterceptListener j1;
    public int k;
    public boolean k0;
    public OnQueryFilterListener k1;
    public int l;
    public boolean l0;
    public OnBitmapWatermarkEventListener l1;
    public int m;
    public boolean m0;
    public OnVideoThumbnailEventListener m1;
    public int n;
    public int n0;
    public OnGridItemSelectAnimListener n1;
    public int o;
    public boolean o0;
    public OnSelectAnimListener o1;
    public int p;
    public boolean p0;
    public OnCustomLoadingListener p1;
    public int q;
    public boolean q0;
    public LocalMediaFolder q1;
    public int r;
    public boolean r0;
    public final ArrayList r1 = new ArrayList();
    public int s;
    public boolean s0;
    public final ArrayList s1 = new ArrayList();
    public int t;
    public boolean t0;
    public final ArrayList t1 = new ArrayList();
    public int u;
    public boolean u0;
    public final ArrayList u1 = new ArrayList();
    public int v;
    public boolean v0;
    public int w;
    public boolean w0;
    public long x;
    public boolean x0;
    public long y;
    public boolean y0;
    public long z;
    public boolean z0;

    public SelectorConfig() {
        i();
    }

    public void a(List list) {
        if (list != null) {
            this.t1.clear();
            this.t1.addAll(list);
        }
    }

    public void b(ArrayList arrayList) {
        if (arrayList != null) {
            this.u1.clear();
            this.u1.addAll(arrayList);
        }
    }

    public void c(LocalMedia localMedia) {
        this.r1.add(localMedia);
    }

    public void d(ArrayList arrayList) {
        if (arrayList != null) {
            this.s1.clear();
            this.s1.addAll(arrayList);
        }
    }

    public void e() {
        this.L0 = null;
        this.M0 = null;
        this.N0 = null;
        this.O0 = null;
        this.P0 = null;
        this.Q0 = null;
        this.R0 = null;
        this.S0 = null;
        this.Z0 = null;
        this.X0 = null;
        this.a1 = null;
        this.b1 = null;
        this.c1 = null;
        this.d1 = null;
        this.e1 = null;
        this.f1 = null;
        this.Y0 = null;
        this.g1 = null;
        this.h1 = null;
        this.i1 = null;
        this.j1 = null;
        this.k1 = null;
        this.l1 = null;
        this.m1 = null;
        this.U0 = null;
        this.V0 = null;
        this.W0 = null;
        this.n1 = null;
        this.o1 = null;
        this.T0 = null;
        this.p1 = null;
        this.q1 = null;
        this.u1.clear();
        this.r1.clear();
        this.t1.clear();
        this.s1.clear();
        PictureThreadUtils.e(PictureThreadUtils.j());
        BuildRecycleItemViewParams.a();
        FileDirMap.a();
        LocalMedia.destroyPool();
    }

    public String f() {
        return this.r1.size() > 0 ? ((LocalMedia) this.r1.get(0)).getMimeType() : "";
    }

    public int g() {
        return this.r1.size();
    }

    public synchronized ArrayList h() {
        return this.r1;
    }

    public final void i() {
        this.f9404a = SelectMimeType.c();
        this.b = false;
        this.j = 2;
        this.K0 = new PictureSelectorStyle();
        this.k = 9;
        this.l = 0;
        this.m = 1;
        this.n = 0;
        this.o = 0;
        this.p = 1;
        this.B = -2;
        this.C = -1;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.u = 60;
        this.v = 0;
        this.w = 4;
        this.i = false;
        this.P = false;
        this.D = true;
        this.E = false;
        this.F = true;
        this.G = true;
        this.S = false;
        this.c = false;
        this.H = true;
        this.I = true;
        this.J = true;
        this.O = false;
        this.M = false;
        this.N = false;
        this.d = ".jpeg";
        this.e = ".mp4";
        this.f = "image/jpeg";
        this.g = "video/mp4";
        this.T = "";
        this.U = "";
        this.V = "";
        this.Q = new ArrayList();
        this.W = "";
        this.X = "";
        this.Y = "";
        this.Z = "";
        this.a0 = "";
        this.d0 = 60;
        this.e0 = true;
        this.f0 = false;
        this.g0 = false;
        this.h0 = -1;
        this.i0 = true;
        this.j0 = true;
        this.k0 = true;
        this.l0 = true;
        this.m0 = !SdkVersionUtils.f();
        this.n0 = SelectMimeType.a();
        this.o0 = false;
        this.h = -1;
        this.p0 = false;
        this.q0 = true;
        this.s0 = false;
        this.t0 = false;
        this.u0 = false;
        this.v0 = false;
        this.w0 = false;
        this.K = true;
        this.L = this.f9404a != SelectMimeType.b();
        this.x0 = false;
        this.r0 = false;
        this.y0 = true;
        this.z0 = false;
        this.R = new ArrayList();
        this.b0 = "";
        this.A0 = true;
        this.c0 = "";
        this.B0 = false;
        this.C0 = false;
        this.D0 = true;
        this.E0 = false;
        this.F0 = false;
        this.G0 = true;
        this.H0 = false;
        this.I0 = true;
        this.J0 = false;
    }
}
