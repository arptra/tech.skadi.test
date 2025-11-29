package com.luck.picture.lib.basic;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.PictureSelectorFragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.immersive.ImmersiveManager;
import com.luck.picture.lib.language.PictureLanguageUtils;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.StyleUtils;

public class PictureSelectorSupporterActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    public SelectorConfig f9401a;

    public void attachBaseContext(Context context) {
        SelectorConfig d = SelectorProviders.c().d();
        if (d != null) {
            super.attachBaseContext(PictureContextWrapper.a(context, d.B, d.C));
        } else {
            super.attachBaseContext(context);
        }
    }

    public void finish() {
        super.finish();
        SelectorConfig selectorConfig = this.f9401a;
        if (selectorConfig != null) {
            overridePendingTransition(0, selectorConfig.K0.e().b);
        }
    }

    public final void n0() {
        SelectMainStyle c = this.f9401a.K0.c();
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

    public void o0() {
        int i;
        SelectorConfig selectorConfig = this.f9401a;
        if (selectorConfig != null && (i = selectorConfig.B) != -2 && !selectorConfig.b) {
            PictureLanguageUtils.d(this, i, selectorConfig.C);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        o0();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        s0();
        n0();
        setContentView(R.layout.ps_activity_container);
        u0();
    }

    public final void s0() {
        this.f9401a = SelectorProviders.c().d();
    }

    public final void u0() {
        FragmentInjectManager.a(this, PictureSelectorFragment.A, PictureSelectorFragment.A3());
    }
}
