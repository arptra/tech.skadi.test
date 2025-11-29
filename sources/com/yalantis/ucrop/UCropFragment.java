package com.yalantis.ucrop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.AspectRatio;
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

public class UCropFragment extends Fragment {
    public static final String A = UCropFragment.class.getSimpleName();
    public static final Bitmap.CompressFormat z = Bitmap.CompressFormat.JPEG;

    /* renamed from: a  reason: collision with root package name */
    public UCropFragmentCallback f8728a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public Transition g;
    public UCropView h;
    public GestureCropImageView i;
    public OverlayView j;
    public ViewGroup k;
    public ViewGroup l;
    public ViewGroup m;
    public ViewGroup n;
    public ViewGroup o;
    public ViewGroup p;
    public final List q = new ArrayList();
    public TextView r;
    public TextView s;
    public View t;
    public Bitmap.CompressFormat u = z;
    public int v = 90;
    public int[] w = {1, 2, 3};
    public final TransformImageView.TransformImageListener x = new TransformImageView.TransformImageListener() {
        public void a() {
            UCropFragment.this.h.animate().alpha(1.0f).setDuration(300).setInterpolator(new AccelerateInterpolator());
            UCropFragment.this.t.setClickable(false);
            UCropFragment.this.f8728a.n(false);
            if (UCropFragment.this.getArguments().getBoolean("com.yalantis.ucrop.ForbidCropGifWebp", false)) {
                String f = FileUtils.f(UCropFragment.this.getContext(), (Uri) UCropFragment.this.getArguments().getParcelable("com.yalantis.ucrop.InputUri"));
                if (FileUtils.m(f) || FileUtils.t(f)) {
                    UCropFragment.this.t.setClickable(true);
                }
            }
        }

        public void b(Exception exc) {
            UCropFragment.this.f8728a.v(UCropFragment.this.z0(exc));
        }

        public void c(float f) {
            UCropFragment.this.L0(f);
        }

        public void d(float f) {
            UCropFragment.this.H0(f);
        }
    };
    public final View.OnClickListener y = new View.OnClickListener() {
        public void onClick(View view) {
            if (!view.isSelected()) {
                UCropFragment.this.N0(view.getId());
            }
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    public @interface GestureTypes {
    }

    public static class UCropResult {

        /* renamed from: a  reason: collision with root package name */
        public int f8737a;
        public Intent b;

        public UCropResult(int i, Intent intent) {
            this.f8737a = i;
            this.b = intent;
        }
    }

    static {
        AppCompatDelegate.G(true);
    }

    public static UCropFragment C0(Bundle bundle) {
        UCropFragment uCropFragment = new UCropFragment();
        uCropFragment.setArguments(bundle);
        return uCropFragment;
    }

    /* access modifiers changed from: private */
    public void E0() {
        GestureCropImageView gestureCropImageView = this.i;
        gestureCropImageView.v(-gestureCropImageView.getCurrentAngle());
        this.i.x();
    }

    /* access modifiers changed from: private */
    public void F0(int i2) {
        this.i.v((float) i2);
        this.i.x();
    }

    private void G0(int i2) {
        GestureCropImageView gestureCropImageView = this.i;
        int i3 = this.w[i2];
        boolean z2 = false;
        gestureCropImageView.setScaleEnabled(i3 == 3 || i3 == 1);
        GestureCropImageView gestureCropImageView2 = this.i;
        int i4 = this.w[i2];
        if (i4 == 3 || i4 == 2) {
            z2 = true;
        }
        gestureCropImageView2.setRotateEnabled(z2);
        this.i.setGestureEnabled(getArguments().getBoolean("com.yalantis.ucrop.isDragImages", true));
    }

    /* access modifiers changed from: private */
    public void H0(float f2) {
        TextView textView = this.r;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", new Object[]{Float.valueOf(f2)}));
        }
    }

    private void I0(int i2) {
        TextView textView = this.r;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    private void K0() {
        if (!this.f) {
            G0(0);
        } else if (this.k.getVisibility() == 0) {
            N0(R.id.state_aspect_ratio);
        } else {
            N0(R.id.state_scale);
        }
    }

    /* access modifiers changed from: private */
    public void L0(float f2) {
        TextView textView = this.s;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", new Object[]{Integer.valueOf((int) (f2 * 100.0f))}));
        }
    }

    private void M0(int i2) {
        TextView textView = this.s;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    /* access modifiers changed from: private */
    public void N0(int i2) {
        if (this.f) {
            this.k.setSelected(i2 == R.id.state_aspect_ratio);
            this.l.setSelected(i2 == R.id.state_rotate);
            this.m.setSelected(i2 == R.id.state_scale);
            int i3 = 8;
            this.n.setVisibility(i2 == R.id.state_aspect_ratio ? 0 : 8);
            this.o.setVisibility(i2 == R.id.state_rotate ? 0 : 8);
            ViewGroup viewGroup = this.p;
            if (i2 == R.id.state_scale) {
                i3 = 0;
            }
            viewGroup.setVisibility(i3);
            v0(i2);
            if (i2 == R.id.state_scale) {
                G0(0);
            } else if (i2 == R.id.state_rotate) {
                G0(1);
            } else {
                G0(2);
            }
        }
    }

    private void v0(int i2) {
        if (getView() != null) {
            TransitionManager.b((ViewGroup) getView().findViewById(R.id.ucrop_photobox), this.g);
        }
        int i3 = 8;
        this.m.findViewById(R.id.text_view_scale).setVisibility(i2 == R.id.state_scale ? 0 : 8);
        this.k.findViewById(R.id.text_view_crop).setVisibility(i2 == R.id.state_aspect_ratio ? 0 : 8);
        View findViewById = this.l.findViewById(R.id.text_view_rotate);
        if (i2 == R.id.state_rotate) {
            i3 = 0;
        }
        findViewById.setVisibility(i3);
    }

    public UCropResult A0(Uri uri, float f2, int i2, int i3, int i4, int i5) {
        return new UCropResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", uri).putExtra("com.yalantis.ucrop.CropAspectRatio", f2).putExtra("com.yalantis.ucrop.ImageWidth", i4).putExtra("com.yalantis.ucrop.ImageHeight", i5).putExtra("com.yalantis.ucrop.OffsetX", i2).putExtra("com.yalantis.ucrop.OffsetY", i3).putExtra("com.yalantis.ucrop.CropInputOriginal", FileUtils.e((Uri) getArguments().getParcelable("com.yalantis.ucrop.InputUri"))));
    }

    public final void B0(View view) {
        UCropView uCropView = (UCropView) view.findViewById(R.id.ucrop);
        this.h = uCropView;
        this.i = uCropView.getCropImageView();
        this.j = this.h.getOverlayView();
        this.i.setTransformImageListener(this.x);
        ((ImageView) view.findViewById(R.id.image_view_logo)).setColorFilter(this.e, PorterDuff.Mode.SRC_ATOP);
        view.findViewById(R.id.ucrop_frame).setBackgroundColor(this.d);
    }

    public final void D0(Bundle bundle) {
        String string = bundle.getString("com.yalantis.ucrop.CompressionFormatName");
        Bitmap.CompressFormat valueOf = !TextUtils.isEmpty(string) ? Bitmap.CompressFormat.valueOf(string) : null;
        if (valueOf == null) {
            valueOf = z;
        }
        this.u = valueOf;
        this.v = bundle.getInt("com.yalantis.ucrop.CompressionQuality", 90);
        this.b = bundle.getBoolean("com.yalantis.ucrop.CustomLoaderCropBitmap", false);
        int[] intArray = bundle.getIntArray("com.yalantis.ucrop.AllowedGestures");
        if (intArray != null && intArray.length == 3) {
            this.w = intArray;
        }
        this.i.setMaxBitmapSize(bundle.getInt("com.yalantis.ucrop.MaxBitmapSize", 0));
        this.i.setMaxScaleMultiplier(bundle.getFloat("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
        this.i.setImageToWrapCropBoundsAnimDuration((long) bundle.getInt("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
        this.j.setFreestyleCropEnabled(bundle.getBoolean("com.yalantis.ucrop.FreeStyleCrop", false));
        this.j.setDragSmoothToCenter(bundle.getBoolean("com.yalantis.ucrop.DragSmoothToCenter", false));
        this.j.setDimmedColor(bundle.getInt("com.yalantis.ucrop.DimmedLayerColor", getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.j.setCircleStrokeColor(bundle.getInt("com.yalantis.ucrop.CircleStrokeColor", getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.j.setCircleDimmedLayer(bundle.getBoolean("com.yalantis.ucrop.CircleDimmedLayer", false));
        this.j.setShowCropFrame(bundle.getBoolean("com.yalantis.ucrop.ShowCropFrame", true));
        this.j.setCropFrameColor(bundle.getInt("com.yalantis.ucrop.CropFrameColor", getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.j.setCropFrameStrokeWidth(bundle.getInt("com.yalantis.ucrop.CropFrameStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.j.setShowCropGrid(bundle.getBoolean("com.yalantis.ucrop.ShowCropGrid", true));
        this.j.setCropGridRowCount(bundle.getInt("com.yalantis.ucrop.CropGridRowCount", 2));
        this.j.setCropGridColumnCount(bundle.getInt("com.yalantis.ucrop.CropGridColumnCount", 2));
        this.j.setCropGridColor(bundle.getInt("com.yalantis.ucrop.CropGridColor", getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.j.setCropGridStrokeWidth(bundle.getInt("com.yalantis.ucrop.CropGridStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        this.j.setDimmedStrokeWidth(bundle.getInt("com.yalantis.ucrop.CircleStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float f2 = bundle.getFloat("com.yalantis.ucrop.AspectRatioX", -1.0f);
        float f3 = bundle.getFloat("com.yalantis.ucrop.AspectRatioY", -1.0f);
        int i2 = bundle.getInt("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions");
        float f4 = 0.0f;
        if (f2 >= 0.0f && f3 >= 0.0f) {
            ViewGroup viewGroup = this.k;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            float f5 = f2 / f3;
            GestureCropImageView gestureCropImageView = this.i;
            if (!Float.isNaN(f5)) {
                f4 = f5;
            }
            gestureCropImageView.setTargetAspectRatio(f4);
        } else if (parcelableArrayList == null || i2 >= parcelableArrayList.size()) {
            this.i.setTargetAspectRatio(0.0f);
        } else {
            float aspectRatioX = ((AspectRatio) parcelableArrayList.get(i2)).getAspectRatioX() / ((AspectRatio) parcelableArrayList.get(i2)).getAspectRatioY();
            GestureCropImageView gestureCropImageView2 = this.i;
            if (!Float.isNaN(aspectRatioX)) {
                f4 = aspectRatioX;
            }
            gestureCropImageView2.setTargetAspectRatio(f4);
        }
        int i3 = bundle.getInt("com.yalantis.ucrop.MaxSizeX", 0);
        int i4 = bundle.getInt("com.yalantis.ucrop.MaxSizeY", 0);
        if (i3 > 0 && i4 > 0) {
            this.i.setMaxResultImageSizeX(i3);
            this.i.setMaxResultImageSizeY(i4);
        }
    }

    public final void J0(Bundle bundle) {
        Uri uri = (Uri) bundle.getParcelable("com.yalantis.ucrop.InputUri");
        Uri uri2 = (Uri) bundle.getParcelable("com.yalantis.ucrop.OutputUri");
        D0(bundle);
        if (uri == null || uri2 == null) {
            this.f8728a.v(z0(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent))));
            return;
        }
        try {
            this.i.j(uri, FileUtils.u(getContext(), bundle.getBoolean("com.yalantis.ucrop.ForbidCropGifWebp", false), uri, uri2), this.b);
        } catch (Exception e2) {
            this.f8728a.v(z0(e2));
        }
    }

    public final void O0(Bundle bundle, View view) {
        int i2 = bundle.getInt("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions");
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            parcelableArrayList = new ArrayList();
            parcelableArrayList.add(new AspectRatio((String) null, 1.0f, 1.0f));
            parcelableArrayList.add(new AspectRatio((String) null, 3.0f, 4.0f));
            parcelableArrayList.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayList.add(new AspectRatio((String) null, 3.0f, 2.0f));
            parcelableArrayList.add(new AspectRatio((String) null, 16.0f, 9.0f));
            i2 = 2;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.c);
            aspectRatioTextView.setAspectRatio((AspectRatio) it.next());
            linearLayout.addView(frameLayout);
            this.q.add(frameLayout);
        }
        ((ViewGroup) this.q.get(i2)).setSelected(true);
        for (ViewGroup onClickListener : this.q) {
            onClickListener.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    UCropFragment.this.i.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).c(view.isSelected()));
                    UCropFragment.this.i.x();
                    if (!view.isSelected()) {
                        for (ViewGroup viewGroup : UCropFragment.this.q) {
                            viewGroup.setSelected(viewGroup == view);
                        }
                    }
                }
            });
        }
    }

    public final void P0(View view) {
        this.r = (TextView) view.findViewById(R.id.text_view_rotate);
        ((HorizontalProgressWheelView) view.findViewById(R.id.rotate_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() {
            public void a() {
                UCropFragment.this.i.x();
            }

            public void b() {
                UCropFragment.this.i.r();
            }

            public void c(float f, float f2) {
                UCropFragment.this.i.v(f / 42.0f);
            }
        });
        ((HorizontalProgressWheelView) view.findViewById(R.id.rotate_scroll_wheel)).setMiddleLineColor(this.c);
        view.findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UCropFragment.this.E0();
            }
        });
        view.findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UCropFragment.this.F0(90);
            }
        });
        I0(this.c);
    }

    public final void Q0(View view) {
        this.s = (TextView) view.findViewById(R.id.text_view_scale);
        ((HorizontalProgressWheelView) view.findViewById(R.id.scale_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() {
            public void a() {
                UCropFragment.this.i.x();
            }

            public void b() {
                UCropFragment.this.i.r();
            }

            public void c(float f, float f2) {
                if (f > 0.0f) {
                    UCropFragment.this.i.A(UCropFragment.this.i.getCurrentScale() + (f * ((UCropFragment.this.i.getMaxScale() - UCropFragment.this.i.getMinScale()) / 15000.0f)));
                } else {
                    UCropFragment.this.i.C(UCropFragment.this.i.getCurrentScale() + (f * ((UCropFragment.this.i.getMaxScale() - UCropFragment.this.i.getMinScale()) / 15000.0f)));
                }
            }
        });
        ((HorizontalProgressWheelView) view.findViewById(R.id.scale_scroll_wheel)).setMiddleLineColor(this.c);
        M0(this.c);
    }

    public final void R0(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.c));
        imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.c));
        imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.c));
    }

    public void S0(View view, Bundle bundle) {
        this.c = bundle.getInt("com.yalantis.ucrop.UcropColorControlsWidgetActive", ContextCompat.getColor(getContext(), R.color.ucrop_color_active_controls_color));
        this.e = bundle.getInt("com.yalantis.ucrop.UcropLogoColor", ContextCompat.getColor(getContext(), R.color.ucrop_color_default_logo));
        this.f = !bundle.getBoolean("com.yalantis.ucrop.HideBottomControls", false);
        this.d = bundle.getInt("com.yalantis.ucrop.UcropRootViewBackgroundColor", ContextCompat.getColor(getContext(), R.color.ucrop_color_crop_background));
        B0(view);
        this.f8728a.n(true);
        if (this.f) {
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            LayoutInflater.from(getContext()).inflate(R.layout.ucrop_controls, viewGroup, true);
            AutoTransition autoTransition = new AutoTransition();
            this.g = autoTransition;
            autoTransition.setDuration(50);
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.state_aspect_ratio);
            this.k = viewGroup2;
            viewGroup2.setOnClickListener(this.y);
            ViewGroup viewGroup3 = (ViewGroup) view.findViewById(R.id.state_rotate);
            this.l = viewGroup3;
            viewGroup3.setOnClickListener(this.y);
            ViewGroup viewGroup4 = (ViewGroup) view.findViewById(R.id.state_scale);
            this.m = viewGroup4;
            viewGroup4.setOnClickListener(this.y);
            this.n = (ViewGroup) view.findViewById(R.id.layout_aspect_ratio);
            this.o = (ViewGroup) view.findViewById(R.id.layout_rotate_wheel);
            this.p = (ViewGroup) view.findViewById(R.id.layout_scale_wheel);
            O0(bundle, view);
            P0(view);
            Q0(view);
            R0(view);
            return;
        }
        ((RelativeLayout.LayoutParams) view.findViewById(R.id.ucrop_frame).getLayoutParams()).bottomMargin = 0;
        view.findViewById(R.id.ucrop_frame).requestLayout();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof UCropFragmentCallback) {
            this.f8728a = (UCropFragmentCallback) getParentFragment();
        } else if (context instanceof UCropFragmentCallback) {
            this.f8728a = (UCropFragmentCallback) context;
        } else {
            throw new IllegalArgumentException(context.toString() + " must implement UCropFragmentCallback");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ucrop_fragment_photobox, viewGroup, false);
        Bundle arguments = getArguments();
        S0(inflate, arguments);
        J0(arguments);
        K0();
        u0(inflate);
        return inflate;
    }

    public final void u0(View view) {
        if (this.t == null) {
            this.t = new View(getContext());
            this.t.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.t.setClickable(true);
        }
        ((RelativeLayout) view.findViewById(R.id.ucrop_photobox)).addView(this.t);
    }

    public void w0() {
        this.t.setClickable(true);
        this.f8728a.n(true);
        this.i.s(this.u, this.v, new BitmapCropCallback() {
            public void a(Uri uri, int i, int i2, int i3, int i4) {
                UCropFragmentCallback k0 = UCropFragment.this.f8728a;
                UCropFragment uCropFragment = UCropFragment.this;
                k0.v(uCropFragment.A0(uri, uCropFragment.i.getTargetAspectRatio(), i, i2, i3, i4));
                UCropFragment.this.f8728a.n(false);
            }

            public void b(Throwable th) {
                UCropFragment.this.f8728a.v(UCropFragment.this.z0(th));
            }
        });
    }

    public void y0() {
        J0(getArguments());
        this.h.animate().alpha(1.0f).setDuration(300).setInterpolator(new AccelerateInterpolator());
        boolean z2 = false;
        this.f8728a.n(false);
        if (getArguments().getBoolean("com.yalantis.ucrop.ForbidCropGifWebp", false)) {
            String f2 = FileUtils.f(getContext(), (Uri) getArguments().getParcelable("com.yalantis.ucrop.InputUri"));
            if (FileUtils.m(f2) || FileUtils.t(f2)) {
                z2 = true;
            }
        }
        this.t.setClickable(z2);
    }

    public UCropResult z0(Throwable th) {
        return new UCropResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", th));
    }
}
