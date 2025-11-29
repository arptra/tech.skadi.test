package com.luck.picture.lib.basic;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.luck.picture.lib.PictureOnlyCameraFragment;
import com.luck.picture.lib.PictureSelectorPreviewFragment;
import com.luck.picture.lib.PictureSelectorSystemFragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.immersive.ImmersiveManager;
import com.luck.picture.lib.interfaces.OnInjectActivityPreviewListener;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.StyleUtils;
import java.util.ArrayList;

public class PictureSelectorTransparentActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    public SelectorConfig f9402a;

    private void n0() {
        if (this.f9402a.K0 == null) {
            SelectorProviders.c().d();
        }
        SelectMainStyle c = this.f9402a.K0.c();
        int T = c.T();
        int A = c.A();
        boolean W = c.W();
        if (!StyleUtils.c(T)) {
            T = ContextCompat.getColor(this, R.color.ps_color_grey);
        }
        if (!StyleUtils.c(A)) {
            A = ContextCompat.getColor(this, R.color.ps_color_grey);
        }
        ImmersiveManager.a(this, T, A, W);
    }

    private void o0() {
        this.f9402a = SelectorProviders.c().d();
    }

    private void v0() {
        PictureSelectorSystemFragment pictureSelectorSystemFragment;
        String str;
        PictureSelectorPreviewFragment pictureSelectorPreviewFragment;
        int intExtra = getIntent().getIntExtra("com.luck.picture.lib.mode_type_source", 0);
        if (intExtra == 1) {
            str = PictureSelectorSystemFragment.p;
            pictureSelectorSystemFragment = PictureSelectorSystemFragment.n2();
        } else if (intExtra == 2) {
            OnInjectActivityPreviewListener onInjectActivityPreviewListener = this.f9402a.b1;
            PictureSelectorPreviewFragment a2 = onInjectActivityPreviewListener != null ? onInjectActivityPreviewListener.a() : null;
            if (a2 != null) {
                pictureSelectorPreviewFragment = a2;
                str = a2.S2();
            } else {
                str = PictureSelectorPreviewFragment.P;
                pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.i3();
            }
            int intExtra2 = getIntent().getIntExtra("com.luck.picture.lib.current_preview_position", 0);
            ArrayList arrayList = new ArrayList(this.f9402a.s1);
            pictureSelectorPreviewFragment.x3(intExtra2, arrayList.size(), arrayList, getIntent().getBooleanExtra("com.luck.picture.lib.external_preview_display_delete", false));
            pictureSelectorSystemFragment = pictureSelectorPreviewFragment;
        } else {
            str = PictureOnlyCameraFragment.l;
            pictureSelectorSystemFragment = PictureOnlyCameraFragment.W1();
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment p0 = supportFragmentManager.p0(str);
        if (p0 != null) {
            supportFragmentManager.s().s(p0).k();
        }
        FragmentInjectManager.b(supportFragmentManager, str, pictureSelectorSystemFragment);
    }

    public void finish() {
        super.finish();
        if (getIntent().getIntExtra("com.luck.picture.lib.mode_type_source", 0) == 2) {
            SelectorConfig selectorConfig = this.f9402a;
            if (!selectorConfig.L) {
                overridePendingTransition(0, selectorConfig.K0.e().b);
                return;
            }
        }
        overridePendingTransition(0, R.anim.ps_anim_fade_out);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o0();
        n0();
        setContentView(R.layout.ps_empty);
        if (!s0()) {
            u0();
        }
        v0();
    }

    public final boolean s0() {
        return getIntent().getIntExtra("com.luck.picture.lib.mode_type_source", 0) == 2;
    }

    public final void u0() {
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
    }
}
