package com.yalantis.ucrop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.statusbar.ImmersiveManager;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class UCropActivity extends AppCompatActivity {
    public static final Bitmap.CompressFormat H = Bitmap.CompressFormat.JPEG;
    public View A;
    public Transition B;
    public Bitmap.CompressFormat C = H;
    public int D = 90;
    public int[] E = {1, 2, 3};
    public TransformImageView.TransformImageListener F = new TransformImageView.TransformImageListener() {
        public void a() {
            UCropActivity.this.o.animate().alpha(1.0f).setDuration(300).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.A.setClickable(false);
            if (UCropActivity.this.getIntent().getBooleanExtra("com.yalantis.ucrop.ForbidCropGifWebp", false)) {
                String f = FileUtils.f(UCropActivity.this, (Uri) UCropActivity.this.getIntent().getParcelableExtra("com.yalantis.ucrop.InputUri"));
                if (FileUtils.m(f) || FileUtils.t(f)) {
                    UCropActivity.this.A.setClickable(true);
                }
            }
            boolean unused = UCropActivity.this.m = false;
            UCropActivity.this.supportInvalidateOptionsMenu();
        }

        public void b(Exception exc) {
            UCropActivity.this.P0(exc);
            UCropActivity.this.finish();
        }

        public void c(float f) {
            UCropActivity.this.R0(f);
        }

        public void d(float f) {
            UCropActivity.this.L0(f);
        }
    };
    public final View.OnClickListener G = new View.OnClickListener() {
        public void onClick(View view) {
            if (!view.isSelected()) {
                UCropActivity.this.T0(view.getId());
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f8718a;
    public int b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public boolean m = true;
    public boolean n;
    public UCropView o;
    public GestureCropImageView p;
    public OverlayView q;
    public ViewGroup r;
    public ViewGroup s;
    public ViewGroup t;
    public ViewGroup u;
    public ViewGroup v;
    public ViewGroup w;
    public List x = new ArrayList();
    public TextView y;
    public TextView z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GestureTypes {
    }

    static {
        AppCompatDelegate.G(true);
    }

    private void F0() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("com.yalantis.ucrop.isDarkStatusBarBlack", false);
        int intExtra = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", ContextCompat.getColor(this, R.color.ucrop_color_statusbar));
        this.e = intExtra;
        ImmersiveManager.a(this, intExtra, intExtra, booleanExtra);
    }

    private void setStatusBarColor(int i2) {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i2);
        }
    }

    public final void C0() {
        if (this.A == null) {
            this.A = new View(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.toolbar);
            this.A.setLayoutParams(layoutParams);
            this.A.setClickable(true);
        }
        ((RelativeLayout) findViewById(R.id.ucrop_photobox)).addView(this.A);
    }

    public final void D0(int i2) {
        TransitionManager.b((ViewGroup) findViewById(R.id.ucrop_photobox), this.B);
        int i3 = 8;
        this.t.findViewById(R.id.text_view_scale).setVisibility(i2 == R.id.state_scale ? 0 : 8);
        this.r.findViewById(R.id.text_view_crop).setVisibility(i2 == R.id.state_aspect_ratio ? 0 : 8);
        View findViewById = this.s.findViewById(R.id.text_view_rotate);
        if (i2 == R.id.state_rotate) {
            i3 = 0;
        }
        findViewById.setVisibility(i3);
    }

    public void E0() {
        this.A.setClickable(true);
        this.m = true;
        supportInvalidateOptionsMenu();
        this.p.s(this.C, this.D, new BitmapCropCallback() {
            public void a(Uri uri, int i, int i2, int i3, int i4) {
                UCropActivity uCropActivity = UCropActivity.this;
                uCropActivity.Q0(uri, uCropActivity.p.getTargetAspectRatio(), i, i2, i3, i4);
                UCropActivity.this.finish();
            }

            public void b(Throwable th) {
                UCropActivity.this.P0(th);
                UCropActivity.this.finish();
            }
        });
    }

    public final void G0() {
        UCropView uCropView = (UCropView) findViewById(R.id.ucrop);
        this.o = uCropView;
        this.p = uCropView.getCropImageView();
        this.q = this.o.getOverlayView();
        this.p.setTransformImageListener(this.F);
        ((ImageView) findViewById(R.id.image_view_logo)).setColorFilter(this.k, PorterDuff.Mode.SRC_ATOP);
        findViewById(R.id.ucrop_frame).setBackgroundColor(this.h);
        if (!this.l) {
            ((RelativeLayout.LayoutParams) findViewById(R.id.ucrop_frame).getLayoutParams()).bottomMargin = 0;
            findViewById(R.id.ucrop_frame).requestLayout();
        }
    }

    public final void H0(Intent intent) {
        String stringExtra = intent.getStringExtra("com.yalantis.ucrop.CompressionFormatName");
        Bitmap.CompressFormat valueOf = !TextUtils.isEmpty(stringExtra) ? Bitmap.CompressFormat.valueOf(stringExtra) : null;
        if (valueOf == null) {
            valueOf = H;
        }
        this.C = valueOf;
        this.D = intent.getIntExtra("com.yalantis.ucrop.CompressionQuality", 90);
        int[] intArrayExtra = intent.getIntArrayExtra("com.yalantis.ucrop.AllowedGestures");
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.E = intArrayExtra;
        }
        this.c = intent.getBooleanExtra("com.yalantis.ucrop.CustomLoaderCropBitmap", false);
        this.p.setMaxBitmapSize(intent.getIntExtra("com.yalantis.ucrop.MaxBitmapSize", 0));
        this.p.setMaxScaleMultiplier(intent.getFloatExtra("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
        this.p.setImageToWrapCropBoundsAnimDuration((long) intent.getIntExtra("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
        this.q.setFreestyleCropEnabled(intent.getBooleanExtra("com.yalantis.ucrop.FreeStyleCrop", false));
        this.q.setDragSmoothToCenter(intent.getBooleanExtra("com.yalantis.ucrop.DragSmoothToCenter", false));
        this.q.setDimmedColor(intent.getIntExtra("com.yalantis.ucrop.DimmedLayerColor", getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.q.setCircleStrokeColor(intent.getIntExtra("com.yalantis.ucrop.CircleStrokeColor", getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.q.setCircleDimmedLayer(intent.getBooleanExtra("com.yalantis.ucrop.CircleDimmedLayer", false));
        this.q.setShowCropFrame(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropFrame", true));
        this.q.setCropFrameColor(intent.getIntExtra("com.yalantis.ucrop.CropFrameColor", getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.q.setCropFrameStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropFrameStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.q.setShowCropGrid(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropGrid", true));
        this.q.setCropGridRowCount(intent.getIntExtra("com.yalantis.ucrop.CropGridRowCount", 2));
        this.q.setCropGridColumnCount(intent.getIntExtra("com.yalantis.ucrop.CropGridColumnCount", 2));
        this.q.setCropGridColor(intent.getIntExtra("com.yalantis.ucrop.CropGridColor", getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.q.setCropGridStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropGridStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        this.q.setDimmedStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CircleStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioX", -1.0f);
        float floatExtra2 = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioY", -1.0f);
        int intExtra = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        float f2 = 0.0f;
        if (floatExtra >= 0.0f && floatExtra2 >= 0.0f) {
            ViewGroup viewGroup = this.r;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            float f3 = floatExtra / floatExtra2;
            GestureCropImageView gestureCropImageView = this.p;
            if (!Float.isNaN(f3)) {
                f2 = f3;
            }
            gestureCropImageView.setTargetAspectRatio(f2);
        } else if (parcelableArrayListExtra == null || intExtra >= parcelableArrayListExtra.size()) {
            this.p.setTargetAspectRatio(0.0f);
        } else {
            float aspectRatioX = ((AspectRatio) parcelableArrayListExtra.get(intExtra)).getAspectRatioX() / ((AspectRatio) parcelableArrayListExtra.get(intExtra)).getAspectRatioY();
            GestureCropImageView gestureCropImageView2 = this.p;
            if (!Float.isNaN(aspectRatioX)) {
                f2 = aspectRatioX;
            }
            gestureCropImageView2.setTargetAspectRatio(f2);
        }
        int intExtra2 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeX", 0);
        int intExtra3 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeY", 0);
        if (intExtra2 > 0 && intExtra3 > 0) {
            this.p.setMaxResultImageSizeX(intExtra2);
            this.p.setMaxResultImageSizeY(intExtra3);
        }
    }

    public final void I0() {
        GestureCropImageView gestureCropImageView = this.p;
        gestureCropImageView.v(-gestureCropImageView.getCurrentAngle());
        this.p.x();
    }

    public final void J0(int i2) {
        this.p.v((float) i2);
        this.p.x();
    }

    public final void K0(int i2) {
        GestureCropImageView gestureCropImageView = this.p;
        int i3 = this.E[i2];
        boolean z2 = false;
        gestureCropImageView.setScaleEnabled(i3 == 3 || i3 == 1);
        GestureCropImageView gestureCropImageView2 = this.p;
        int i4 = this.E[i2];
        if (i4 == 3 || i4 == 2) {
            z2 = true;
        }
        gestureCropImageView2.setRotateEnabled(z2);
        this.p.setGestureEnabled(getIntent().getBooleanExtra("com.yalantis.ucrop.isDragImages", true));
    }

    public final void L0(float f2) {
        TextView textView = this.y;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", new Object[]{Float.valueOf(f2)}));
        }
    }

    public final void M0(int i2) {
        TextView textView = this.y;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public final void N0(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.InputUri");
        Uri uri2 = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        H0(intent);
        if (uri == null || uri2 == null) {
            P0(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent)));
            finish();
            return;
        }
        try {
            this.p.j(uri, FileUtils.u(this, this.n, uri, uri2), this.c);
        } catch (Exception e2) {
            P0(e2);
            finish();
        }
    }

    public final void O0() {
        if (!this.l) {
            K0(0);
        } else if (this.r.getVisibility() == 0) {
            T0(R.id.state_aspect_ratio);
        } else {
            T0(R.id.state_scale);
        }
    }

    public void P0(Throwable th) {
        setResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", th));
    }

    public void Q0(Uri uri, float f2, int i2, int i3, int i4, int i5) {
        setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", uri).putExtra("com.yalantis.ucrop.CropAspectRatio", f2).putExtra("com.yalantis.ucrop.ImageWidth", i4).putExtra("com.yalantis.ucrop.ImageHeight", i5).putExtra("com.yalantis.ucrop.OffsetX", i2).putExtra("com.yalantis.ucrop.OffsetY", i3).putExtra("com.yalantis.ucrop.CropInputOriginal", FileUtils.e((Uri) getIntent().getParcelableExtra("com.yalantis.ucrop.InputUri"))));
    }

    public final void R0(float f2) {
        TextView textView = this.z;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", new Object[]{Integer.valueOf((int) (f2 * 100.0f))}));
        }
    }

    public final void S0(int i2) {
        TextView textView = this.z;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public final void T0(int i2) {
        if (this.l) {
            this.r.setSelected(i2 == R.id.state_aspect_ratio);
            this.s.setSelected(i2 == R.id.state_rotate);
            this.t.setSelected(i2 == R.id.state_scale);
            int i3 = 8;
            this.u.setVisibility(i2 == R.id.state_aspect_ratio ? 0 : 8);
            this.v.setVisibility(i2 == R.id.state_rotate ? 0 : 8);
            ViewGroup viewGroup = this.w;
            if (i2 == R.id.state_scale) {
                i3 = 0;
            }
            viewGroup.setVisibility(i3);
            D0(i2);
            if (i2 == R.id.state_scale) {
                K0(0);
            } else if (i2 == R.id.state_rotate) {
                K0(1);
            } else {
                K0(2);
            }
        }
    }

    public final void U0() {
        setStatusBarColor(this.e);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(this.d);
        toolbar.setTitleTextColor(this.g);
        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.g);
        textView.setText(this.f8718a);
        textView.setTextSize((float) this.b);
        Drawable mutate = AppCompatResources.b(this, this.i).mutate();
        mutate.setColorFilter(BlendModeColorFilterCompat.a(this.g, BlendModeCompat.SRC_ATOP));
        toolbar.setNavigationIcon(mutate);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(false);
        }
    }

    public final void V0(Intent intent) {
        int intExtra = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new AspectRatio((String) null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new AspectRatio((String) null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayListExtra.add(new AspectRatio((String) null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new AspectRatio((String) null, 16.0f, 9.0f));
            intExtra = 2;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.f);
            aspectRatioTextView.setAspectRatio((AspectRatio) it.next());
            linearLayout.addView(frameLayout);
            this.x.add(frameLayout);
        }
        ((ViewGroup) this.x.get(intExtra)).setSelected(true);
        for (ViewGroup onClickListener : this.x) {
            onClickListener.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    UCropActivity.this.p.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).c(view.isSelected()));
                    UCropActivity.this.p.x();
                    if (!view.isSelected()) {
                        for (ViewGroup viewGroup : UCropActivity.this.x) {
                            viewGroup.setSelected(viewGroup == view);
                        }
                    }
                }
            });
        }
    }

    public final void W0() {
        this.y = (TextView) findViewById(R.id.text_view_rotate);
        ((HorizontalProgressWheelView) findViewById(R.id.rotate_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() {
            public void a() {
                UCropActivity.this.p.x();
            }

            public void b() {
                UCropActivity.this.p.r();
            }

            public void c(float f, float f2) {
                UCropActivity.this.p.v(f / 42.0f);
            }
        });
        ((HorizontalProgressWheelView) findViewById(R.id.rotate_scroll_wheel)).setMiddleLineColor(this.f);
        findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UCropActivity.this.I0();
            }
        });
        findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UCropActivity.this.J0(90);
            }
        });
        M0(this.f);
    }

    public final void X0() {
        this.z = (TextView) findViewById(R.id.text_view_scale);
        ((HorizontalProgressWheelView) findViewById(R.id.scale_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() {
            public void a() {
                UCropActivity.this.p.x();
            }

            public void b() {
                UCropActivity.this.p.r();
            }

            public void c(float f, float f2) {
                if (f > 0.0f) {
                    UCropActivity.this.p.A(UCropActivity.this.p.getCurrentScale() + (f * ((UCropActivity.this.p.getMaxScale() - UCropActivity.this.p.getMinScale()) / 15000.0f)));
                } else {
                    UCropActivity.this.p.C(UCropActivity.this.p.getCurrentScale() + (f * ((UCropActivity.this.p.getMaxScale() - UCropActivity.this.p.getMinScale()) / 15000.0f)));
                }
            }
        });
        ((HorizontalProgressWheelView) findViewById(R.id.scale_scroll_wheel)).setMiddleLineColor(this.f);
        S0(this.f);
    }

    public final void Y0() {
        ImageView imageView = (ImageView) findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.f));
        imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.f));
        imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.f));
    }

    public final void Z0(Intent intent) {
        this.n = intent.getBooleanExtra("com.yalantis.ucrop.ForbidCropGifWebp", false);
        this.e = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", ContextCompat.getColor(this, R.color.ucrop_color_statusbar));
        this.d = intent.getIntExtra("com.yalantis.ucrop.ToolbarColor", ContextCompat.getColor(this, R.color.ucrop_color_toolbar));
        this.f = intent.getIntExtra("com.yalantis.ucrop.UcropColorControlsWidgetActive", ContextCompat.getColor(this, R.color.ucrop_color_active_controls_color));
        this.g = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarWidgetColor", ContextCompat.getColor(this, R.color.ucrop_color_toolbar_widget));
        this.i = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCancelDrawable", R.drawable.ucrop_ic_cross);
        this.j = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCropDrawable", R.drawable.ucrop_ic_done);
        this.f8718a = intent.getStringExtra("com.yalantis.ucrop.UcropToolbarTitleText");
        this.b = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarTitleTextSize", 18);
        String str = this.f8718a;
        if (str == null) {
            str = getResources().getString(R.string.ucrop_label_edit_photo);
        }
        this.f8718a = str;
        this.k = intent.getIntExtra("com.yalantis.ucrop.UcropLogoColor", ContextCompat.getColor(this, R.color.ucrop_color_default_logo));
        this.l = !intent.getBooleanExtra("com.yalantis.ucrop.HideBottomControls", false);
        this.h = intent.getIntExtra("com.yalantis.ucrop.UcropRootViewBackgroundColor", ContextCompat.getColor(this, R.color.ucrop_color_crop_background));
        U0();
        G0();
        if (this.l) {
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(R.id.ucrop_photobox)).findViewById(R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            LayoutInflater.from(this).inflate(R.layout.ucrop_controls, viewGroup, true);
            AutoTransition autoTransition = new AutoTransition();
            this.B = autoTransition;
            autoTransition.setDuration(50);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.state_aspect_ratio);
            this.r = viewGroup2;
            viewGroup2.setOnClickListener(this.G);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.state_rotate);
            this.s = viewGroup3;
            viewGroup3.setOnClickListener(this.G);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(R.id.state_scale);
            this.t = viewGroup4;
            viewGroup4.setOnClickListener(this.G);
            this.u = (ViewGroup) findViewById(R.id.layout_aspect_ratio);
            this.v = (ViewGroup) findViewById(R.id.layout_rotate_wheel);
            this.w = (ViewGroup) findViewById(R.id.layout_scale_wheel);
            V0(intent);
            W0();
            X0();
            Y0();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        F0();
        setContentView(R.layout.ucrop_activity_photobox);
        Intent intent = getIntent();
        Z0(intent);
        N0(intent);
        O0();
        C0();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu);
        MenuItem findItem = menu.findItem(R.id.menu_loader);
        Drawable icon = findItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(BlendModeColorFilterCompat.a(this.g, BlendModeCompat.SRC_ATOP));
                findItem.setIcon(icon);
            } catch (IllegalStateException e2) {
                Log.i("UCropActivity", String.format("%s - %s", new Object[]{e2.getMessage(), getString(R.string.ucrop_mutate_exception_hint)}));
            }
            ((Animatable) findItem.getIcon()).start();
        }
        MenuItem findItem2 = menu.findItem(R.id.menu_crop);
        Drawable drawable = ContextCompat.getDrawable(this, this.j);
        if (drawable == null) {
            return true;
        }
        drawable.mutate();
        drawable.setColorFilter(BlendModeColorFilterCompat.a(this.g, BlendModeCompat.SRC_ATOP));
        findItem2.setIcon(drawable);
        return true;
    }

    public void onDestroy() {
        UCropDevelopConfig.a();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_crop) {
            E0();
            return true;
        } else if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            onBackPressed();
            return true;
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_crop).setVisible(!this.m);
        menu.findItem(R.id.menu_loader).setVisible(this.m);
        return super.onPrepareOptionsMenu(menu);
    }

    public void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.p;
        if (gestureCropImageView != null) {
            gestureCropImageView.r();
        }
    }
}
