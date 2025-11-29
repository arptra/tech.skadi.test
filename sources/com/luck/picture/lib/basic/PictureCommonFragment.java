package com.luck.picture.lib.basic;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.honey.account.constant.AccountConstantKt;
import com.luck.picture.lib.R;
import com.luck.picture.lib.app.PictureAppMaster;
import com.luck.picture.lib.config.Crop;
import com.luck.picture.lib.config.PermissionEvent;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.dialog.PhotoItemSelectedDialog;
import com.luck.picture.lib.dialog.PictureLoadingDialog;
import com.luck.picture.lib.dialog.RemindDialog;
import com.luck.picture.lib.engine.PictureSelectorEngine;
import com.luck.picture.lib.engine.SandboxFileEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.immersive.ImmersiveManager;
import com.luck.picture.lib.interfaces.OnCallbackIndexListener;
import com.luck.picture.lib.interfaces.OnCallbackListener;
import com.luck.picture.lib.interfaces.OnCustomLoadingListener;
import com.luck.picture.lib.interfaces.OnItemClickListener;
import com.luck.picture.lib.interfaces.OnKeyValueResultCallbackListener;
import com.luck.picture.lib.interfaces.OnPermissionDescriptionListener;
import com.luck.picture.lib.interfaces.OnRecordAudioInterceptListener;
import com.luck.picture.lib.interfaces.OnRequestPermissionListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.interfaces.OnSelectFilterListener;
import com.luck.picture.lib.interfaces.OnSelectLimitTipsListener;
import com.luck.picture.lib.language.PictureLanguageUtils;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.permissions.PermissionResultCallback;
import com.luck.picture.lib.permissions.PermissionUtil;
import com.luck.picture.lib.service.ForegroundService;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.utils.ActivityCompatHelper;
import com.luck.picture.lib.utils.BitmapUtils;
import com.luck.picture.lib.utils.DateUtils;
import com.luck.picture.lib.utils.FileDirMap;
import com.luck.picture.lib.utils.MediaStoreUtils;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.PictureFileUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.SpUtils;
import com.luck.picture.lib.utils.ToastUtils;
import com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class PictureCommonFragment extends Fragment implements IPictureSelectorCommonEvent {

    /* renamed from: a  reason: collision with root package name */
    public PermissionResultCallback f9380a;
    public IBridgePictureBehavior b;
    public int c = 1;
    public IBridgeMediaLoader d;
    public SelectorConfig e;
    public Dialog f;
    public SoundPool g;
    public int h;
    public long i;
    public Dialog j;
    public Context k;

    public static class SelectorResult {

        /* renamed from: a  reason: collision with root package name */
        public int f9394a;
        public Intent b;

        public SelectorResult(int i, Intent intent) {
            this.f9394a = i;
            this.b = intent;
        }
    }

    public static String Y0(Context context, String str, int i2) {
        return PictureMimeType.i(str) ? context.getString(R.string.ps_message_video_max_num, new Object[]{String.valueOf(i2)}) : PictureMimeType.d(str) ? context.getString(R.string.ps_message_audio_max_num, new Object[]{String.valueOf(i2)}) : context.getString(R.string.ps_message_max_num, new Object[]{String.valueOf(i2)});
    }

    public boolean A0() {
        return SdkVersionUtils.f() && this.e.R0 != null;
    }

    public void A1(boolean z, LocalMedia localMedia) {
    }

    public boolean B0() {
        return this.e.m1 != null;
    }

    public void B1() {
        PhotoItemSelectedDialog j0 = PhotoItemSelectedDialog.j0();
        j0.l0(new OnItemClickListener() {
            public void a(View view, int i) {
                if (i == 0) {
                    PictureCommonFragment pictureCommonFragment = PictureCommonFragment.this;
                    if (pictureCommonFragment.e.X0 != null) {
                        pictureCommonFragment.r1(1);
                    } else {
                        pictureCommonFragment.C1();
                    }
                } else if (i == 1) {
                    PictureCommonFragment pictureCommonFragment2 = PictureCommonFragment.this;
                    if (pictureCommonFragment2.e.X0 != null) {
                        pictureCommonFragment2.r1(2);
                    } else {
                        pictureCommonFragment2.F1();
                    }
                }
            }
        });
        j0.k0(new PhotoItemSelectedDialog.OnDismissListener() {
            public void a(boolean z, DialogInterface dialogInterface) {
                PictureCommonFragment pictureCommonFragment = PictureCommonFragment.this;
                if (pictureCommonFragment.e.b && z) {
                    pictureCommonFragment.s1();
                }
            }
        });
        j0.show(getChildFragmentManager(), "PhotoItemSelectedDialog");
    }

    public boolean C0(LocalMedia localMedia, boolean z, String str, int i2, long j2, long j3) {
        SelectorConfig selectorConfig = this.e;
        long j4 = selectorConfig.z;
        if (j4 <= 0 || j2 <= j4) {
            long j5 = selectorConfig.A;
            if (j5 > 0 && j2 < j5) {
                OnSelectLimitTipsListener onSelectLimitTipsListener = selectorConfig.Y0;
                if (onSelectLimitTipsListener != null && onSelectLimitTipsListener.a(T0(), localMedia, this.e, 2)) {
                    return true;
                }
                R1(getString(R.string.ps_select_min_size, PictureFileUtils.f(this.e.A)));
                return true;
            } else if (PictureMimeType.i(str)) {
                SelectorConfig selectorConfig2 = this.e;
                if (selectorConfig2.j == 2) {
                    if (selectorConfig2.m <= 0) {
                        OnSelectLimitTipsListener onSelectLimitTipsListener2 = selectorConfig2.Y0;
                        if (onSelectLimitTipsListener2 != null && onSelectLimitTipsListener2.a(T0(), localMedia, this.e, 3)) {
                            return true;
                        }
                        R1(getString(R.string.ps_rule));
                        return true;
                    }
                    if (!z) {
                        int size = selectorConfig2.h().size();
                        SelectorConfig selectorConfig3 = this.e;
                        if (size >= selectorConfig3.k) {
                            OnSelectLimitTipsListener onSelectLimitTipsListener3 = selectorConfig3.Y0;
                            if (onSelectLimitTipsListener3 != null && onSelectLimitTipsListener3.a(T0(), localMedia, this.e, 4)) {
                                return true;
                            }
                            R1(getString(R.string.ps_message_max_num, Integer.valueOf(this.e.k)));
                            return true;
                        }
                    }
                    if (!z) {
                        SelectorConfig selectorConfig4 = this.e;
                        if (i2 >= selectorConfig4.m) {
                            OnSelectLimitTipsListener onSelectLimitTipsListener4 = selectorConfig4.Y0;
                            if (onSelectLimitTipsListener4 != null && onSelectLimitTipsListener4.a(T0(), localMedia, this.e, 6)) {
                                return true;
                            }
                            R1(Y0(T0(), str, this.e.m));
                            return true;
                        }
                    }
                }
                if (!z && this.e.t > 0) {
                    long i3 = DateUtils.i(j3);
                    SelectorConfig selectorConfig5 = this.e;
                    if (i3 < ((long) selectorConfig5.t)) {
                        OnSelectLimitTipsListener onSelectLimitTipsListener5 = selectorConfig5.Y0;
                        if (onSelectLimitTipsListener5 != null && onSelectLimitTipsListener5.a(T0(), localMedia, this.e, 9)) {
                            return true;
                        }
                        R1(getString(R.string.ps_select_video_min_second, Integer.valueOf(this.e.t / 1000)));
                        return true;
                    }
                }
                if (z || this.e.s <= 0) {
                    return false;
                }
                long i4 = DateUtils.i(j3);
                SelectorConfig selectorConfig6 = this.e;
                if (i4 <= ((long) selectorConfig6.s)) {
                    return false;
                }
                OnSelectLimitTipsListener onSelectLimitTipsListener6 = selectorConfig6.Y0;
                if (onSelectLimitTipsListener6 != null && onSelectLimitTipsListener6.a(T0(), localMedia, this.e, 8)) {
                    return true;
                }
                R1(getString(R.string.ps_select_video_max_second, Integer.valueOf(this.e.s / 1000)));
                return true;
            } else {
                SelectorConfig selectorConfig7 = this.e;
                if (selectorConfig7.j != 2 || z) {
                    return false;
                }
                int size2 = selectorConfig7.h().size();
                SelectorConfig selectorConfig8 = this.e;
                if (size2 < selectorConfig8.k) {
                    return false;
                }
                OnSelectLimitTipsListener onSelectLimitTipsListener7 = selectorConfig8.Y0;
                if (onSelectLimitTipsListener7 != null && onSelectLimitTipsListener7.a(T0(), localMedia, this.e, 4)) {
                    return true;
                }
                R1(getString(R.string.ps_message_max_num, Integer.valueOf(this.e.k)));
                return true;
            }
        } else {
            OnSelectLimitTipsListener onSelectLimitTipsListener8 = selectorConfig.Y0;
            if (onSelectLimitTipsListener8 != null && onSelectLimitTipsListener8.a(T0(), localMedia, this.e, 1)) {
                return true;
            }
            R1(getString(R.string.ps_select_max_size, PictureFileUtils.f(this.e.z)));
            return true;
        }
    }

    public void C1() {
        String[] strArr = PermissionConfig.b;
        v1(true, strArr);
        if (this.e.d1 != null) {
            f1(PermissionEvent.f9403a, strArr);
        } else {
            PermissionChecker.b().m(this, strArr, new PermissionResultCallback() {
                public void a() {
                    PictureCommonFragment.this.S1();
                }

                public void b() {
                    PictureCommonFragment.this.Z0(PermissionConfig.b);
                }
            });
        }
    }

    public int D0(LocalMedia localMedia, boolean z) {
        OnSelectFilterListener onSelectFilterListener = this.e.g1;
        boolean z2 = false;
        if (onSelectFilterListener != null && onSelectFilterListener.a(localMedia)) {
            OnSelectLimitTipsListener onSelectLimitTipsListener = this.e.Y0;
            if (onSelectLimitTipsListener != null) {
                z2 = onSelectLimitTipsListener.a(T0(), localMedia, this.e, 13);
            }
            if (!z2) {
                ToastUtils.c(T0(), getString(R.string.ps_select_no_support));
            }
            return -1;
        } else if (c1(localMedia, z) != 200) {
            return -1;
        } else {
            ArrayList h2 = this.e.h();
            if (z) {
                h2.remove(localMedia);
                z2 = true;
            } else {
                if (this.e.j == 1 && h2.size() > 0) {
                    J1((LocalMedia) h2.get(0));
                    h2.clear();
                }
                h2.add(localMedia);
                localMedia.setNum(h2.size());
                G1();
            }
            K1(!z2, localMedia);
            return z2 ? 1 : 0;
        }
    }

    public void D1() {
        SelectorConfig selectorConfig = this.e;
        int i2 = selectorConfig.f9404a;
        if (i2 != 0) {
            if (i2 == 1) {
                C1();
            } else if (i2 == 2) {
                F1();
            } else if (i2 == 3) {
                E1();
            }
        } else if (selectorConfig.n0 == SelectMimeType.c()) {
            C1();
        } else if (this.e.n0 == SelectMimeType.d()) {
            F1();
        } else {
            B1();
        }
    }

    public final void E0(final ArrayList arrayList) {
        showLoading();
        PictureThreadUtils.h(new PictureThreadUtils.SimpleTask<ArrayList<LocalMedia>>() {
            /* renamed from: o */
            public ArrayList f() {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    PictureCommonFragment pictureCommonFragment = PictureCommonFragment.this;
                    SandboxFileEngine sandboxFileEngine = pictureCommonFragment.e.Q0;
                    Context T0 = pictureCommonFragment.T0();
                    sandboxFileEngine.a(T0, PictureCommonFragment.this.e.S, i2, (LocalMedia) arrayList.get(i2), new OnCallbackIndexListener<LocalMedia>() {
                    });
                }
                return arrayList;
            }

            /* renamed from: p */
            public void l(ArrayList arrayList) {
                PictureThreadUtils.d(this);
                PictureCommonFragment.this.R0(arrayList);
            }
        });
    }

    public void E1() {
        if (this.e.j1 != null) {
            ForegroundService.c(T0(), this.e.p0);
            this.e.j1.a(this, 909);
            return;
        }
        throw new NullPointerException(OnRecordAudioInterceptListener.class.getSimpleName() + " interface needs to be implemented for recording");
    }

    public final void F0() {
        String str;
        try {
            if (!TextUtils.isEmpty(this.e.X)) {
                InputStream a2 = PictureMimeType.c(this.e.a0) ? PictureContentResolver.a(T0(), Uri.parse(this.e.a0)) : new FileInputStream(this.e.a0);
                if (TextUtils.isEmpty(this.e.V)) {
                    str = "";
                } else {
                    SelectorConfig selectorConfig = this.e;
                    if (selectorConfig.b) {
                        str = selectorConfig.V;
                    } else {
                        str = System.currentTimeMillis() + AccountConstantKt.DEFAULT_SEGMENT + this.e.V;
                    }
                }
                Context T0 = T0();
                SelectorConfig selectorConfig2 = this.e;
                File b2 = PictureFileUtils.b(T0, selectorConfig2.f9404a, str, "", selectorConfig2.X);
                if (PictureFileUtils.r(a2, new FileOutputStream(b2.getAbsolutePath()))) {
                    MediaUtils.b(T0(), this.e.a0);
                    this.e.a0 = b2.getAbsolutePath();
                }
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public void F1() {
        String[] strArr = PermissionConfig.b;
        v1(true, strArr);
        if (this.e.d1 != null) {
            f1(PermissionEvent.b, strArr);
        } else {
            PermissionChecker.b().m(this, strArr, new PermissionResultCallback() {
                public void a() {
                    PictureCommonFragment.this.T1();
                }

                public void b() {
                    PictureCommonFragment.this.Z0(PermissionConfig.b);
                }
            });
        }
    }

    public final void G0() {
        PictureSelectorEngine a2;
        PictureSelectorEngine a3;
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig.t0) {
            if (selectorConfig.N0 == null && (a3 = PictureAppMaster.c().a()) != null) {
                this.e.N0 = a3.f();
            }
            if (this.e.M0 == null && (a2 = PictureAppMaster.c().a()) != null) {
                this.e.M0 = a2.g();
            }
        }
    }

    public final void G1() {
        SoundPool soundPool = this.g;
        if (soundPool != null && this.e.M) {
            soundPool.play(this.h, 0.1f, 0.5f, 0, 1, 1.0f);
        }
    }

    public final void H0() {
        PictureSelectorEngine a2;
        if (this.e.L0 == null && (a2 = PictureAppMaster.c().a()) != null) {
            this.e.L0 = a2.i();
        }
    }

    public final void H1() {
        try {
            SoundPool soundPool = this.g;
            if (soundPool != null) {
                soundPool.release();
                this.g = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void I0() {
        PictureSelectorEngine a2;
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig.r0 && selectorConfig.e1 == null && (a2 = PictureAppMaster.c().a()) != null) {
            this.e.e1 = a2.c();
        }
    }

    public void I1(boolean z) {
    }

    public final void J0() {
        PictureSelectorEngine a2;
        PictureSelectorEngine a3;
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig.u0 && selectorConfig.S0 == null && (a3 = PictureAppMaster.c().a()) != null) {
            this.e.S0 = a3.b();
        }
        SelectorConfig selectorConfig2 = this.e;
        if (selectorConfig2.v0 && selectorConfig2.V0 == null && (a2 = PictureAppMaster.c().a()) != null) {
            this.e.V0 = a2.a();
        }
    }

    public void J1(LocalMedia localMedia) {
        if (!ActivityCompatHelper.c(getActivity())) {
            List F0 = getActivity().getSupportFragmentManager().F0();
            for (int i2 = 0; i2 < F0.size(); i2++) {
                Fragment fragment = (Fragment) F0.get(i2);
                if (fragment instanceof PictureCommonFragment) {
                    ((PictureCommonFragment) fragment).p1(localMedia);
                }
            }
        }
    }

    public final void K0() {
        PictureSelectorEngine a2;
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig.q0 && selectorConfig.Z0 == null && (a2 = PictureAppMaster.c().a()) != null) {
            this.e.Z0 = a2.h();
        }
    }

    public void K1(boolean z, LocalMedia localMedia) {
        if (!ActivityCompatHelper.c(getActivity())) {
            List F0 = getActivity().getSupportFragmentManager().F0();
            for (int i2 = 0; i2 < F0.size(); i2++) {
                Fragment fragment = (Fragment) F0.get(i2);
                if (fragment instanceof PictureCommonFragment) {
                    ((PictureCommonFragment) fragment).A1(z, localMedia);
                }
            }
        }
    }

    public final void L0() {
        PictureSelectorEngine a2;
        PictureSelectorEngine a3;
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig.w0) {
            if (selectorConfig.R0 == null && (a3 = PictureAppMaster.c().a()) != null) {
                this.e.R0 = a3.j();
            }
            if (this.e.Q0 == null && (a2 = PictureAppMaster.c().a()) != null) {
                this.e.Q0 = a2.d();
            }
        }
    }

    public void L1() {
        if (!ActivityCompatHelper.c(getActivity())) {
            List F0 = getActivity().getSupportFragmentManager().F0();
            for (int i2 = 0; i2 < F0.size(); i2++) {
                Fragment fragment = (Fragment) F0.get(i2);
                if (fragment instanceof PictureCommonFragment) {
                    ((PictureCommonFragment) fragment).i1();
                }
            }
        }
    }

    public final void M0() {
        PictureSelectorEngine a2;
        if (this.e.T0 == null && (a2 = PictureAppMaster.c().a()) != null) {
            this.e.T0 = a2.e();
        }
    }

    public void M1(long j2) {
        this.i = j2;
    }

    public void N0() {
        try {
            if (!ActivityCompatHelper.c(getActivity()) && this.f.isShowing()) {
                this.f.dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void N1(PermissionResultCallback permissionResultCallback) {
        this.f9380a = permissionResultCallback;
    }

    public void O0(LocalMedia localMedia) {
    }

    public void O1() {
        if (!ActivityCompatHelper.c(getActivity())) {
            getActivity().setRequestedOrientation(this.e.h);
        }
    }

    public final void P0(final Intent intent) {
        PictureThreadUtils.h(new PictureThreadUtils.SimpleTask<LocalMedia>() {
            /* renamed from: o */
            public LocalMedia f() {
                String V0 = PictureCommonFragment.this.V0(intent);
                if (!TextUtils.isEmpty(V0)) {
                    PictureCommonFragment.this.e.a0 = V0;
                }
                if (TextUtils.isEmpty(PictureCommonFragment.this.e.a0)) {
                    return null;
                }
                if (PictureCommonFragment.this.e.f9404a == SelectMimeType.b()) {
                    PictureCommonFragment.this.F0();
                }
                PictureCommonFragment pictureCommonFragment = PictureCommonFragment.this;
                LocalMedia m0 = pictureCommonFragment.m0(pictureCommonFragment.e.a0);
                m0.setCameraSource(true);
                return m0;
            }

            /* renamed from: p */
            public void l(LocalMedia localMedia) {
                PictureThreadUtils.d(this);
                if (localMedia != null) {
                    PictureCommonFragment.this.y1(localMedia);
                    PictureCommonFragment.this.O0(localMedia);
                }
                PictureCommonFragment.this.e.a0 = "";
            }
        });
    }

    public void P1(View view) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                PictureCommonFragment.this.s1();
                return true;
            }
        });
    }

    public void Q0() {
        if (!o0() && isAdded()) {
            ArrayList arrayList = new ArrayList(this.e.h());
            if (u0()) {
                k1(arrayList);
            } else if (w0()) {
                u1(arrayList);
            } else if (s0()) {
                j1(arrayList);
            } else if (v0()) {
                t1(arrayList);
            } else {
                x1(arrayList);
            }
        }
    }

    public final void Q1() {
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig.K) {
            ImmersiveManager.c(requireActivity(), selectorConfig.K0.c().W());
        }
    }

    public final void R0(ArrayList arrayList) {
        showLoading();
        if (n0()) {
            l0(arrayList);
        } else if (B0()) {
            V1(arrayList);
        } else {
            h1(arrayList);
        }
    }

    public final void R1(String str) {
        if (!ActivityCompatHelper.c(getActivity())) {
            try {
                Dialog dialog = this.j;
                if (dialog == null || !dialog.isShowing()) {
                    RemindDialog a2 = RemindDialog.a(T0(), str);
                    this.j = a2;
                    a2.show();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void S0(ArrayList arrayList) {
        if (B0()) {
            V1(arrayList);
        } else {
            h1(arrayList);
        }
    }

    public void S1() {
        if (!ActivityCompatHelper.c(getActivity())) {
            v1(false, (String[]) null);
            if (this.e.X0 != null) {
                r1(1);
                return;
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                ForegroundService.c(T0(), this.e.p0);
                Uri c2 = MediaStoreUtils.c(T0(), this.e);
                if (c2 != null) {
                    if (this.e.i) {
                        intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                    }
                    intent.putExtra("output", c2);
                    startActivityForResult(intent, 909);
                }
            }
        }
    }

    public Context T0() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        Context b2 = PictureAppMaster.c().b();
        return b2 != null ? b2 : this.k;
    }

    public void T1() {
        if (!ActivityCompatHelper.c(getActivity())) {
            v1(false, (String[]) null);
            if (this.e.X0 != null) {
                r1(2);
                return;
            }
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                ForegroundService.c(T0(), this.e.p0);
                Uri d2 = MediaStoreUtils.d(T0(), this.e);
                if (d2 != null) {
                    intent.putExtra("output", d2);
                    if (this.e.i) {
                        intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                    }
                    intent.putExtra("android.intent.extra.quickCapture", this.e.j0);
                    intent.putExtra("android.intent.extra.durationLimit", this.e.u);
                    intent.putExtra("android.intent.extra.videoQuality", this.e.p);
                    startActivityForResult(intent, 909);
                }
            }
        }
    }

    public long U0() {
        long j2 = this.i;
        if (j2 > 50) {
            j2 -= 50;
        }
        if (j2 >= 0) {
            return j2;
        }
        return 0;
    }

    public final void U1(final ArrayList arrayList) {
        showLoading();
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            LocalMedia localMedia = (LocalMedia) arrayList.get(i2);
            concurrentHashMap.put(localMedia.getPath(), localMedia);
        }
        if (concurrentHashMap.size() == 0) {
            R0(arrayList);
        } else {
            PictureThreadUtils.h(new PictureThreadUtils.SimpleTask<ArrayList<LocalMedia>>() {
                /* renamed from: o */
                public ArrayList f() {
                    for (Map.Entry value : concurrentHashMap.entrySet()) {
                        LocalMedia localMedia = (LocalMedia) value.getValue();
                        if (PictureCommonFragment.this.e.S || TextUtils.isEmpty(localMedia.getSandboxPath())) {
                            PictureCommonFragment pictureCommonFragment = PictureCommonFragment.this;
                            pictureCommonFragment.e.R0.a(pictureCommonFragment.T0(), localMedia.getPath(), localMedia.getMimeType(), new OnKeyValueResultCallbackListener() {
                                public void a(String str, String str2) {
                                    LocalMedia localMedia;
                                    if (!TextUtils.isEmpty(str) && (localMedia = (LocalMedia) concurrentHashMap.get(str)) != null) {
                                        if (TextUtils.isEmpty(localMedia.getSandboxPath())) {
                                            localMedia.setSandboxPath(str2);
                                        }
                                        if (PictureCommonFragment.this.e.S) {
                                            localMedia.setOriginalPath(str2);
                                            localMedia.setOriginal(!TextUtils.isEmpty(str2));
                                        }
                                        concurrentHashMap.remove(str);
                                    }
                                }
                            });
                        }
                    }
                    return arrayList;
                }

                /* renamed from: p */
                public void l(ArrayList arrayList) {
                    PictureThreadUtils.d(this);
                    PictureCommonFragment.this.R0(arrayList);
                }
            });
        }
    }

    public String V0(Intent intent) {
        if (intent == null) {
            return null;
        }
        Uri uri = (Uri) intent.getParcelableExtra("output");
        String str = this.e.a0;
        boolean z = TextUtils.isEmpty(str) || PictureMimeType.c(str) || new File(str).exists();
        if ((this.e.f9404a == SelectMimeType.b() || !z) && uri == null) {
            uri = intent.getData();
        }
        if (uri == null) {
            return null;
        }
        return PictureMimeType.c(uri.toString()) ? uri.toString() : uri.getPath();
    }

    public final void V1(final ArrayList arrayList) {
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            LocalMedia localMedia = (LocalMedia) arrayList.get(i2);
            String availablePath = localMedia.getAvailablePath();
            if (PictureMimeType.i(localMedia.getMimeType()) || PictureMimeType.o(availablePath)) {
                concurrentHashMap.put(availablePath, localMedia);
            }
        }
        if (concurrentHashMap.size() == 0) {
            h1(arrayList);
            return;
        }
        for (Map.Entry key : concurrentHashMap.entrySet()) {
            this.e.m1.a(T0(), (String) key.getKey(), new OnKeyValueResultCallbackListener() {
                public void a(String str, String str2) {
                    LocalMedia localMedia = (LocalMedia) concurrentHashMap.get(str);
                    if (localMedia != null) {
                        localMedia.setVideoThumbnailPath(str2);
                        concurrentHashMap.remove(str);
                    }
                    if (concurrentHashMap.size() == 0) {
                        PictureCommonFragment.this.h1(arrayList);
                    }
                }
            });
        }
    }

    public int W0() {
        return 0;
    }

    public SelectorResult X0(int i2, ArrayList arrayList) {
        return new SelectorResult(i2, arrayList != null ? PictureSelector.d(arrayList) : null);
    }

    public void Z0(String[] strArr) {
        PermissionConfig.f9440a = strArr;
        if (strArr != null && strArr.length > 0) {
            SpUtils.c(T0(), strArr[0], true);
        }
        if (this.e.i1 != null) {
            v1(false, (String[]) null);
            this.e.i1.a(this, strArr, Ring2TrackerConstant.MSG_RING_EVENT_HANDLER, new OnCallbackListener<Boolean>() {
                /* renamed from: b */
                public void a(Boolean bool) {
                    if (bool.booleanValue()) {
                        PictureCommonFragment.this.a1(PermissionConfig.f9440a);
                    }
                }
            });
            return;
        }
        PermissionUtil.a(this, Ring2TrackerConstant.MSG_RING_EVENT_HANDLER);
    }

    public void a1(String[] strArr) {
    }

    public void b1() {
        if (this.e == null) {
            this.e = SelectorProviders.c().d();
        }
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig != null && selectorConfig.B != -2) {
            FragmentActivity activity = getActivity();
            SelectorConfig selectorConfig2 = this.e;
            PictureLanguageUtils.d(activity, selectorConfig2.B, selectorConfig2.C);
        }
    }

    public int c1(LocalMedia localMedia, boolean z) {
        String mimeType = localMedia.getMimeType();
        long duration = localMedia.getDuration();
        long size = localMedia.getSize();
        ArrayList h2 = this.e.h();
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig.P) {
            int i2 = 0;
            for (int i3 = 0; i3 < h2.size(); i3++) {
                if (PictureMimeType.i(((LocalMedia) h2.get(i3)).getMimeType())) {
                    i2++;
                }
            }
            return C0(localMedia, z, mimeType, i2, size, duration) ? -1 : 200;
        }
        return z0(localMedia, z, mimeType, selectorConfig.f(), size, duration) ? -1 : 200;
    }

    public boolean d1() {
        return (getActivity() instanceof PictureSelectorSupporterActivity) || (getActivity() instanceof PictureSelectorTransparentActivity);
    }

    public final void e1(ArrayList arrayList) {
        if (this.e.S) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                LocalMedia localMedia = (LocalMedia) arrayList.get(i2);
                localMedia.setOriginal(true);
                localMedia.setOriginalPath(localMedia.getPath());
            }
        }
    }

    public void f1(final int i2, String[] strArr) {
        this.e.d1.b(this, strArr, new OnRequestPermissionListener() {
        });
    }

    public void g1() {
        if (!ActivityCompatHelper.c(getActivity())) {
            if (!isStateSaved()) {
                IBridgeViewLifecycle iBridgeViewLifecycle = this.e.U0;
                if (iBridgeViewLifecycle != null) {
                    iBridgeViewLifecycle.b(this);
                }
                getActivity().getSupportFragmentManager().o1();
            }
            List F0 = getActivity().getSupportFragmentManager().F0();
            for (int i2 = 0; i2 < F0.size(); i2++) {
                Fragment fragment = (Fragment) F0.get(i2);
                if (fragment instanceof PictureCommonFragment) {
                    ((PictureCommonFragment) fragment).q1();
                }
            }
        }
    }

    public final void h1(ArrayList arrayList) {
        if (!ActivityCompatHelper.c(getActivity())) {
            N0();
            SelectorConfig selectorConfig = this.e;
            if (selectorConfig.s0) {
                getActivity().setResult(-1, PictureSelector.d(arrayList));
                z1(-1, arrayList);
            } else {
                OnResultCallbackListener onResultCallbackListener = selectorConfig.Z0;
                if (onResultCallbackListener != null) {
                    onResultCallbackListener.a(arrayList);
                }
            }
            o1();
        }
    }

    public void i1() {
    }

    public void j1(final ArrayList arrayList) {
        showLoading();
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            LocalMedia localMedia = (LocalMedia) arrayList.get(i2);
            String availablePath = localMedia.getAvailablePath();
            if (!PictureMimeType.g(availablePath)) {
                SelectorConfig selectorConfig = this.e;
                if ((!selectorConfig.S || !selectorConfig.H0) && PictureMimeType.h(localMedia.getMimeType())) {
                    arrayList2.add(PictureMimeType.c(availablePath) ? Uri.parse(availablePath) : Uri.fromFile(new File(availablePath)));
                    concurrentHashMap.put(availablePath, localMedia);
                }
            }
        }
        if (concurrentHashMap.size() == 0) {
            x1(arrayList);
        } else {
            this.e.N0.a(T0(), arrayList2, new OnKeyValueResultCallbackListener() {
                public void a(String str, String str2) {
                    if (TextUtils.isEmpty(str)) {
                        PictureCommonFragment.this.x1(arrayList);
                        return;
                    }
                    LocalMedia localMedia = (LocalMedia) concurrentHashMap.get(str);
                    if (localMedia != null) {
                        if (!SdkVersionUtils.f()) {
                            localMedia.setCompressPath(str2);
                            localMedia.setCompressed(!TextUtils.isEmpty(str2));
                        } else if (!TextUtils.isEmpty(str2) && (str2.contains("Android/data/") || str2.contains("data/user/"))) {
                            localMedia.setCompressPath(str2);
                            localMedia.setCompressed(!TextUtils.isEmpty(str2));
                            localMedia.setSandboxPath(localMedia.getCompressPath());
                        }
                        concurrentHashMap.remove(str);
                    }
                    if (concurrentHashMap.size() == 0) {
                        PictureCommonFragment.this.x1(arrayList);
                    }
                }
            });
        }
    }

    public void k1(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Uri uri = null;
        Uri uri2 = null;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            LocalMedia localMedia = (LocalMedia) arrayList.get(i2);
            arrayList2.add(localMedia.getAvailablePath());
            if (uri == null && PictureMimeType.h(localMedia.getMimeType())) {
                String availablePath = localMedia.getAvailablePath();
                uri = (PictureMimeType.c(availablePath) || PictureMimeType.g(availablePath)) ? Uri.parse(availablePath) : Uri.fromFile(new File(availablePath));
                uri2 = Uri.fromFile(new File(new File(FileDirMap.b(T0(), 1)).getAbsolutePath(), DateUtils.c("CROP_") + ".jpg"));
            }
        }
        this.e.P0.a(this, uri, uri2, arrayList2, 69);
    }

    public final void l0(final ArrayList arrayList) {
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            LocalMedia localMedia = (LocalMedia) arrayList.get(i2);
            if (!PictureMimeType.d(localMedia.getMimeType())) {
                concurrentHashMap.put(localMedia.getAvailablePath(), localMedia);
            }
        }
        if (concurrentHashMap.size() == 0) {
            S0(arrayList);
            return;
        }
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            this.e.l1.a(T0(), (String) entry.getKey(), ((LocalMedia) entry.getValue()).getMimeType(), new OnKeyValueResultCallbackListener() {
                public void a(String str, String str2) {
                    if (TextUtils.isEmpty(str)) {
                        PictureCommonFragment.this.S0(arrayList);
                        return;
                    }
                    LocalMedia localMedia = (LocalMedia) concurrentHashMap.get(str);
                    if (localMedia != null) {
                        localMedia.setWatermarkPath(str2);
                        concurrentHashMap.remove(str);
                    }
                    if (concurrentHashMap.size() == 0) {
                        PictureCommonFragment.this.S0(arrayList);
                    }
                }
            });
        }
    }

    public void l1(Intent intent) {
    }

    public LocalMedia m0(String str) {
        LocalMedia generateLocalMedia = LocalMedia.generateLocalMedia(T0(), str);
        generateLocalMedia.setChooseModel(this.e.f9404a);
        if (!SdkVersionUtils.f() || PictureMimeType.c(str)) {
            generateLocalMedia.setSandboxPath((String) null);
        } else {
            generateLocalMedia.setSandboxPath(str);
        }
        if (this.e.k0 && PictureMimeType.h(generateLocalMedia.getMimeType())) {
            BitmapUtils.e(T0(), str);
        }
        return generateLocalMedia;
    }

    public void m1() {
    }

    public boolean n0() {
        return this.e.l1 != null;
    }

    public void n1() {
    }

    public final boolean o0() {
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig.j == 2 && !selectorConfig.b) {
            if (selectorConfig.P) {
                ArrayList h2 = selectorConfig.h();
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < h2.size(); i4++) {
                    if (PictureMimeType.i(((LocalMedia) h2.get(i4)).getMimeType())) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
                SelectorConfig selectorConfig2 = this.e;
                int i5 = selectorConfig2.l;
                if (i5 <= 0 || i2 >= i5) {
                    int i6 = selectorConfig2.n;
                    if (i6 > 0 && i3 < i6) {
                        OnSelectLimitTipsListener onSelectLimitTipsListener = selectorConfig2.Y0;
                        if (onSelectLimitTipsListener != null && onSelectLimitTipsListener.a(T0(), (LocalMedia) null, this.e, 7)) {
                            return true;
                        }
                        R1(getString(R.string.ps_min_video_num, String.valueOf(this.e.n)));
                        return true;
                    }
                } else {
                    OnSelectLimitTipsListener onSelectLimitTipsListener2 = selectorConfig2.Y0;
                    if (onSelectLimitTipsListener2 != null && onSelectLimitTipsListener2.a(T0(), (LocalMedia) null, this.e, 5)) {
                        return true;
                    }
                    R1(getString(R.string.ps_min_img_num, String.valueOf(this.e.l)));
                    return true;
                }
            } else {
                String f2 = selectorConfig.f();
                if (PictureMimeType.h(f2)) {
                    SelectorConfig selectorConfig3 = this.e;
                    if (selectorConfig3.l > 0) {
                        int g2 = selectorConfig3.g();
                        SelectorConfig selectorConfig4 = this.e;
                        if (g2 < selectorConfig4.l) {
                            OnSelectLimitTipsListener onSelectLimitTipsListener3 = selectorConfig4.Y0;
                            if (onSelectLimitTipsListener3 != null && onSelectLimitTipsListener3.a(T0(), (LocalMedia) null, this.e, 5)) {
                                return true;
                            }
                            R1(getString(R.string.ps_min_img_num, String.valueOf(this.e.l)));
                            return true;
                        }
                    }
                }
                if (PictureMimeType.i(f2)) {
                    SelectorConfig selectorConfig5 = this.e;
                    if (selectorConfig5.n > 0) {
                        int g3 = selectorConfig5.g();
                        SelectorConfig selectorConfig6 = this.e;
                        if (g3 < selectorConfig6.n) {
                            OnSelectLimitTipsListener onSelectLimitTipsListener4 = selectorConfig6.Y0;
                            if (onSelectLimitTipsListener4 != null && onSelectLimitTipsListener4.a(T0(), (LocalMedia) null, this.e, 7)) {
                                return true;
                            }
                            R1(getString(R.string.ps_min_video_num, String.valueOf(this.e.n)));
                            return true;
                        }
                    }
                }
                if (PictureMimeType.d(f2)) {
                    SelectorConfig selectorConfig7 = this.e;
                    if (selectorConfig7.o > 0) {
                        int g4 = selectorConfig7.g();
                        SelectorConfig selectorConfig8 = this.e;
                        if (g4 < selectorConfig8.o) {
                            OnSelectLimitTipsListener onSelectLimitTipsListener5 = selectorConfig8.Y0;
                            if (onSelectLimitTipsListener5 != null && onSelectLimitTipsListener5.a(T0(), (LocalMedia) null, this.e, 12)) {
                                return true;
                            }
                            R1(getString(R.string.ps_min_audio_num, String.valueOf(this.e.o)));
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void o1() {
        if (!ActivityCompatHelper.c(getActivity())) {
            if (d1()) {
                IBridgeViewLifecycle iBridgeViewLifecycle = this.e.U0;
                if (iBridgeViewLifecycle != null) {
                    iBridgeViewLifecycle.b(this);
                }
                getActivity().finish();
            } else {
                List F0 = getActivity().getSupportFragmentManager().F0();
                for (int i2 = 0; i2 < F0.size(); i2++) {
                    if (((Fragment) F0.get(i2)) instanceof PictureCommonFragment) {
                        g1();
                    }
                }
            }
        }
        SelectorProviders.c().b();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        ForegroundService.d(T0());
        String str = "";
        if (i3 == -1) {
            if (i2 == 909) {
                P0(intent);
            } else if (i2 == 696) {
                l1(intent);
            } else if (i2 == 69) {
                ArrayList h2 = this.e.h();
                try {
                    if (h2.size() == 1) {
                        LocalMedia localMedia = (LocalMedia) h2.get(0);
                        Uri b2 = Crop.b(intent);
                        if (b2 != null) {
                            str = b2.getPath();
                        }
                        localMedia.setCutPath(str);
                        localMedia.setCut(!TextUtils.isEmpty(localMedia.getCutPath()));
                        localMedia.setCropImageWidth(Crop.h(intent));
                        localMedia.setCropImageHeight(Crop.e(intent));
                        localMedia.setCropOffsetX(Crop.f(intent));
                        localMedia.setCropOffsetY(Crop.g(intent));
                        localMedia.setCropResultAspectRatio(Crop.c(intent));
                        localMedia.setCustomData(Crop.d(intent));
                        localMedia.setSandboxPath(localMedia.getCutPath());
                    } else {
                        String stringExtra = intent.getStringExtra("output");
                        if (TextUtils.isEmpty(stringExtra)) {
                            stringExtra = intent.getStringExtra("com.yalantis.ucrop.OutputUri");
                        }
                        JSONArray jSONArray = new JSONArray(stringExtra);
                        if (jSONArray.length() == h2.size()) {
                            for (int i4 = 0; i4 < h2.size(); i4++) {
                                LocalMedia localMedia2 = (LocalMedia) h2.get(i4);
                                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                                localMedia2.setCutPath(optJSONObject.optString("outPutPath"));
                                localMedia2.setCut(!TextUtils.isEmpty(localMedia2.getCutPath()));
                                localMedia2.setCropImageWidth(optJSONObject.optInt("imageWidth"));
                                localMedia2.setCropImageHeight(optJSONObject.optInt("imageHeight"));
                                localMedia2.setCropOffsetX(optJSONObject.optInt("offsetX"));
                                localMedia2.setCropOffsetY(optJSONObject.optInt("offsetY"));
                                localMedia2.setCropResultAspectRatio((float) optJSONObject.optDouble("aspectRatio"));
                                localMedia2.setCustomData(optJSONObject.optString("customExtraData"));
                                localMedia2.setSandboxPath(localMedia2.getCutPath());
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    ToastUtils.c(T0(), e2.getMessage());
                }
                ArrayList arrayList = new ArrayList(h2);
                if (s0()) {
                    j1(arrayList);
                } else if (v0()) {
                    t1(arrayList);
                } else {
                    x1(arrayList);
                }
            }
        } else if (i3 == 96) {
            Throwable a2 = intent != null ? Crop.a(intent) : new Throwable("image crop error");
            if (a2 != null) {
                ToastUtils.c(T0(), a2.getMessage());
            }
        } else if (i3 != 0) {
        } else {
            if (i2 == 909) {
                if (!TextUtils.isEmpty(this.e.a0)) {
                    MediaUtils.b(T0(), this.e.a0);
                    this.e.a0 = str;
                }
            } else if (i2 == 1102) {
                a1(PermissionConfig.f9440a);
            }
        }
    }

    public void onAttach(Context context) {
        b1();
        w1();
        super.onAttach(context);
        this.k = context;
        if (getParentFragment() instanceof IBridgePictureBehavior) {
            this.b = (IBridgePictureBehavior) getParentFragment();
        } else if (context instanceof IBridgePictureBehavior) {
            this.b = (IBridgePictureBehavior) context;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b1();
    }

    public Animation onCreateAnimation(int i2, boolean z, int i3) {
        Animation animation;
        PictureWindowAnimationStyle e2 = this.e.K0.e();
        if (z) {
            animation = e2.f9456a != 0 ? AnimationUtils.loadAnimation(T0(), e2.f9456a) : AnimationUtils.loadAnimation(T0(), R.anim.ps_anim_alpha_enter);
            M1(animation.getDuration());
            m1();
        } else {
            animation = e2.b != 0 ? AnimationUtils.loadAnimation(T0(), e2.b) : AnimationUtils.loadAnimation(T0(), R.anim.ps_anim_alpha_exit);
            n1();
        }
        return animation;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return W0() != 0 ? layoutInflater.inflate(W0(), viewGroup, false) : super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        H1();
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (this.f9380a != null) {
            PermissionChecker.b().k(iArr, this.f9380a);
            this.f9380a = null;
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.e = SelectorProviders.c().d();
        FileDirMap.c(view.getContext());
        IBridgeViewLifecycle iBridgeViewLifecycle = this.e.U0;
        if (iBridgeViewLifecycle != null) {
            iBridgeViewLifecycle.a(this, view, bundle);
        }
        OnCustomLoadingListener onCustomLoadingListener = this.e.p1;
        if (onCustomLoadingListener != null) {
            this.f = onCustomLoadingListener.a(T0());
        } else {
            this.f = new PictureLoadingDialog(T0());
        }
        O1();
        Q1();
        P1(requireView());
        SelectorConfig selectorConfig = this.e;
        if (selectorConfig.M && !selectorConfig.b) {
            SoundPool soundPool = new SoundPool(1, 3, 0);
            this.g = soundPool;
            this.h = soundPool.load(T0(), R.raw.ps_click_music, 1);
        }
    }

    public void p1(LocalMedia localMedia) {
    }

    public void q1() {
    }

    public void r1(int i2) {
        ForegroundService.c(T0(), this.e.p0);
        this.e.X0.a(this, i2, 909);
    }

    public boolean s0() {
        if (this.e.N0 != null) {
            for (int i2 = 0; i2 < this.e.g(); i2++) {
                if (PictureMimeType.h(((LocalMedia) this.e.h().get(i2)).getMimeType())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void s1() {
        if (!ActivityCompatHelper.c(getActivity())) {
            SelectorConfig selectorConfig = this.e;
            if (selectorConfig.s0) {
                getActivity().setResult(0);
                z1(0, (ArrayList) null);
            } else {
                OnResultCallbackListener onResultCallbackListener = selectorConfig.Z0;
                if (onResultCallbackListener != null) {
                    onResultCallbackListener.onCancel();
                }
            }
            o1();
        }
    }

    public void showLoading() {
        try {
            if (!ActivityCompatHelper.c(getActivity()) && !this.f.isShowing()) {
                this.f.show();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void t1(ArrayList arrayList) {
        showLoading();
        SelectorConfig selectorConfig = this.e;
        if (!selectorConfig.S || !selectorConfig.H0) {
            selectorConfig.M0.a(T0(), arrayList, new OnCallbackListener<ArrayList<LocalMedia>>() {
                /* renamed from: b */
                public void a(ArrayList arrayList) {
                    PictureCommonFragment.this.x1(arrayList);
                }
            });
        } else {
            x1(arrayList);
        }
    }

    public boolean u0() {
        if (this.e.P0 == null) {
            return false;
        }
        HashSet hashSet = new HashSet();
        List list = this.e.R;
        if (list != null && list.size() > 0) {
            hashSet.addAll(list);
        }
        if (this.e.g() == 1) {
            String f2 = this.e.f();
            boolean h2 = PictureMimeType.h(f2);
            if (!h2 || !hashSet.contains(f2)) {
                return h2;
            }
            return false;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.e.g(); i3++) {
            LocalMedia localMedia = (LocalMedia) this.e.h().get(i3);
            if (PictureMimeType.h(localMedia.getMimeType()) && hashSet.contains(localMedia.getMimeType())) {
                i2++;
            }
        }
        return i2 != this.e.g();
    }

    public void u1(ArrayList arrayList) {
        LocalMedia localMedia;
        int i2 = 0;
        while (true) {
            if (i2 >= arrayList.size()) {
                localMedia = null;
                break;
            }
            localMedia = (LocalMedia) arrayList.get(i2);
            if (PictureMimeType.h(((LocalMedia) arrayList.get(i2)).getMimeType())) {
                break;
            }
            i2++;
        }
        this.e.O0.a(this, localMedia, arrayList, 69);
    }

    public boolean v0() {
        if (this.e.M0 != null) {
            for (int i2 = 0; i2 < this.e.g(); i2++) {
                if (PictureMimeType.h(((LocalMedia) this.e.h().get(i2)).getMimeType())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void v1(boolean z, String[] strArr) {
        OnPermissionDescriptionListener onPermissionDescriptionListener = this.e.h1;
        if (onPermissionDescriptionListener == null) {
            return;
        }
        if (!z) {
            onPermissionDescriptionListener.a(this);
        } else if (PermissionChecker.i(T0(), strArr)) {
            SpUtils.c(T0(), strArr[0], false);
        } else if (!SpUtils.a(T0(), strArr[0], false)) {
            this.e.h1.b(this, strArr);
        }
    }

    public boolean w0() {
        if (this.e.O0 == null) {
            return false;
        }
        HashSet hashSet = new HashSet();
        List list = this.e.R;
        if (list != null && list.size() > 0) {
            hashSet.addAll(list);
        }
        if (this.e.g() == 1) {
            String f2 = this.e.f();
            boolean h2 = PictureMimeType.h(f2);
            if (!h2 || !hashSet.contains(f2)) {
                return h2;
            }
            return false;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.e.g(); i3++) {
            LocalMedia localMedia = (LocalMedia) this.e.h().get(i3);
            if (PictureMimeType.h(localMedia.getMimeType()) && hashSet.contains(localMedia.getMimeType())) {
                i2++;
            }
        }
        return i2 != this.e.g();
    }

    public void w1() {
        H0();
        M0();
        G0();
        L0();
        J0();
        K0();
        I0();
    }

    public void x1(ArrayList arrayList) {
        if (A0()) {
            U1(arrayList);
        } else if (y0()) {
            E0(arrayList);
        } else {
            e1(arrayList);
            R0(arrayList);
        }
    }

    public boolean y0() {
        return SdkVersionUtils.f() && this.e.Q0 != null;
    }

    public final void y1(LocalMedia localMedia) {
        if (!ActivityCompatHelper.c(getActivity())) {
            if (!SdkVersionUtils.f()) {
                String realPath = PictureMimeType.c(localMedia.getPath()) ? localMedia.getRealPath() : localMedia.getPath();
                new PictureMediaScannerConnection(getActivity(), realPath);
                if (PictureMimeType.h(localMedia.getMimeType())) {
                    int e2 = MediaUtils.e(T0(), new File(realPath).getParent());
                    if (e2 != -1) {
                        MediaUtils.q(T0(), e2);
                    }
                }
            } else if (PictureMimeType.i(localMedia.getMimeType()) && PictureMimeType.c(localMedia.getPath())) {
                new PictureMediaScannerConnection(getActivity(), localMedia.getRealPath());
            }
        }
    }

    public boolean z0(LocalMedia localMedia, boolean z, String str, String str2, long j2, long j3) {
        if (PictureMimeType.k(str2, str)) {
            SelectorConfig selectorConfig = this.e;
            long j4 = selectorConfig.z;
            if (j4 <= 0 || j2 <= j4) {
                long j5 = selectorConfig.A;
                if (j5 > 0 && j2 < j5) {
                    OnSelectLimitTipsListener onSelectLimitTipsListener = selectorConfig.Y0;
                    if (onSelectLimitTipsListener != null && onSelectLimitTipsListener.a(T0(), localMedia, this.e, 2)) {
                        return true;
                    }
                    R1(getString(R.string.ps_select_min_size, PictureFileUtils.f(this.e.A)));
                    return true;
                } else if (PictureMimeType.i(str)) {
                    SelectorConfig selectorConfig2 = this.e;
                    if (selectorConfig2.j == 2) {
                        int i2 = selectorConfig2.m;
                        if (i2 <= 0) {
                            i2 = selectorConfig2.k;
                        }
                        selectorConfig2.m = i2;
                        if (!z) {
                            int g2 = selectorConfig2.g();
                            SelectorConfig selectorConfig3 = this.e;
                            if (g2 >= selectorConfig3.m) {
                                OnSelectLimitTipsListener onSelectLimitTipsListener2 = selectorConfig3.Y0;
                                if (onSelectLimitTipsListener2 != null && onSelectLimitTipsListener2.a(T0(), localMedia, this.e, 6)) {
                                    return true;
                                }
                                R1(Y0(T0(), str, this.e.m));
                                return true;
                            }
                        }
                    }
                    if (!z && this.e.t > 0) {
                        long i3 = DateUtils.i(j3);
                        SelectorConfig selectorConfig4 = this.e;
                        if (i3 < ((long) selectorConfig4.t)) {
                            OnSelectLimitTipsListener onSelectLimitTipsListener3 = selectorConfig4.Y0;
                            if (onSelectLimitTipsListener3 != null && onSelectLimitTipsListener3.a(T0(), localMedia, this.e, 9)) {
                                return true;
                            }
                            R1(getString(R.string.ps_select_video_min_second, Integer.valueOf(this.e.t / 1000)));
                            return true;
                        }
                    }
                    if (z || this.e.s <= 0) {
                        return false;
                    }
                    long i4 = DateUtils.i(j3);
                    SelectorConfig selectorConfig5 = this.e;
                    if (i4 <= ((long) selectorConfig5.s)) {
                        return false;
                    }
                    OnSelectLimitTipsListener onSelectLimitTipsListener4 = selectorConfig5.Y0;
                    if (onSelectLimitTipsListener4 != null && onSelectLimitTipsListener4.a(T0(), localMedia, this.e, 8)) {
                        return true;
                    }
                    R1(getString(R.string.ps_select_video_max_second, Integer.valueOf(this.e.s / 1000)));
                    return true;
                } else if (PictureMimeType.d(str)) {
                    SelectorConfig selectorConfig6 = this.e;
                    if (selectorConfig6.j == 2 && !z) {
                        int size = selectorConfig6.h().size();
                        SelectorConfig selectorConfig7 = this.e;
                        if (size >= selectorConfig7.k) {
                            OnSelectLimitTipsListener onSelectLimitTipsListener5 = selectorConfig7.Y0;
                            if (onSelectLimitTipsListener5 != null && onSelectLimitTipsListener5.a(T0(), localMedia, this.e, 4)) {
                                return true;
                            }
                            R1(Y0(T0(), str, this.e.k));
                            return true;
                        }
                    }
                    if (!z && this.e.t > 0) {
                        long i5 = DateUtils.i(j3);
                        SelectorConfig selectorConfig8 = this.e;
                        if (i5 < ((long) selectorConfig8.t)) {
                            OnSelectLimitTipsListener onSelectLimitTipsListener6 = selectorConfig8.Y0;
                            if (onSelectLimitTipsListener6 != null && onSelectLimitTipsListener6.a(T0(), localMedia, this.e, 11)) {
                                return true;
                            }
                            R1(getString(R.string.ps_select_audio_min_second, Integer.valueOf(this.e.t / 1000)));
                            return true;
                        }
                    }
                    if (z || this.e.s <= 0) {
                        return false;
                    }
                    long i6 = DateUtils.i(j3);
                    SelectorConfig selectorConfig9 = this.e;
                    if (i6 <= ((long) selectorConfig9.s)) {
                        return false;
                    }
                    OnSelectLimitTipsListener onSelectLimitTipsListener7 = selectorConfig9.Y0;
                    if (onSelectLimitTipsListener7 != null && onSelectLimitTipsListener7.a(T0(), localMedia, this.e, 10)) {
                        return true;
                    }
                    R1(getString(R.string.ps_select_audio_max_second, Integer.valueOf(this.e.s / 1000)));
                    return true;
                } else {
                    SelectorConfig selectorConfig10 = this.e;
                    if (selectorConfig10.j != 2 || z) {
                        return false;
                    }
                    int size2 = selectorConfig10.h().size();
                    SelectorConfig selectorConfig11 = this.e;
                    if (size2 < selectorConfig11.k) {
                        return false;
                    }
                    OnSelectLimitTipsListener onSelectLimitTipsListener8 = selectorConfig11.Y0;
                    if (onSelectLimitTipsListener8 != null && onSelectLimitTipsListener8.a(T0(), localMedia, this.e, 4)) {
                        return true;
                    }
                    R1(Y0(T0(), str, this.e.k));
                    return true;
                }
            } else {
                OnSelectLimitTipsListener onSelectLimitTipsListener9 = selectorConfig.Y0;
                if (onSelectLimitTipsListener9 != null && onSelectLimitTipsListener9.a(T0(), localMedia, this.e, 1)) {
                    return true;
                }
                R1(getString(R.string.ps_select_max_size, PictureFileUtils.f(this.e.z)));
                return true;
            }
        } else {
            OnSelectLimitTipsListener onSelectLimitTipsListener10 = this.e.Y0;
            if (onSelectLimitTipsListener10 != null && onSelectLimitTipsListener10.a(T0(), localMedia, this.e, 3)) {
                return true;
            }
            R1(getString(R.string.ps_rule));
            return true;
        }
    }

    public void z1(int i2, ArrayList arrayList) {
        if (this.b != null) {
            this.b.a(X0(i2, arrayList));
        }
    }
}
