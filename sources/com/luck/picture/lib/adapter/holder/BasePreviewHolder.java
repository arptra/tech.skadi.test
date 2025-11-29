package com.luck.picture.lib.adapter.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.utils.BitmapUtils;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.MediaUtils;

public abstract class BasePreviewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final int f9349a;
    public final int b;
    public final int c;
    public LocalMedia d;
    public final SelectorConfig e = SelectorProviders.c().d();
    public PhotoView f;
    public OnPreviewEventListener g;

    public interface OnPreviewEventListener {
        void a(LocalMedia localMedia);

        void b(String str);

        void onBackPressed();
    }

    public BasePreviewHolder(View view) {
        super(view);
        this.f9349a = DensityUtil.e(view.getContext());
        this.b = DensityUtil.g(view.getContext());
        this.c = DensityUtil.d(view.getContext());
        this.f = (PhotoView) view.findViewById(R.id.preview_image);
        b(view);
    }

    public static BasePreviewHolder c(ViewGroup viewGroup, int i, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
        return i == 2 ? new PreviewVideoHolder(inflate) : i == 3 ? new PreviewAudioHolder(inflate) : new PreviewImageHolder(inflate);
    }

    public void a(LocalMedia localMedia, int i) {
        this.d = localMedia;
        int[] d2 = d(localMedia);
        int[] b2 = BitmapUtils.b(d2[0], d2[1]);
        f(localMedia, b2[0], b2[1]);
        o(localMedia);
        m(localMedia);
        g();
        h(localMedia);
    }

    public abstract void b(View view);

    public int[] d(LocalMedia localMedia) {
        return (!localMedia.isCut() || localMedia.getCropImageWidth() <= 0 || localMedia.getCropImageHeight() <= 0) ? new int[]{localMedia.getWidth(), localMedia.getHeight()} : new int[]{localMedia.getCropImageWidth(), localMedia.getCropImageHeight()};
    }

    public boolean e() {
        return false;
    }

    public abstract void f(LocalMedia localMedia, int i, int i2);

    public abstract void g();

    public abstract void h(LocalMedia localMedia);

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }

    public void l() {
    }

    public void m(LocalMedia localMedia) {
        if (MediaUtils.p(localMedia.getWidth(), localMedia.getHeight())) {
            this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            this.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    public void n(OnPreviewEventListener onPreviewEventListener) {
        this.g = onPreviewEventListener;
    }

    public void o(LocalMedia localMedia) {
        if (!this.e.L && this.f9349a < this.b && localMedia.getWidth() > 0 && localMedia.getHeight() > 0) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams.width = this.f9349a;
            layoutParams.height = this.c;
            layoutParams.gravity = 17;
        }
    }
}
