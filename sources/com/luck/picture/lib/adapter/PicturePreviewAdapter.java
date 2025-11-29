package com.luck.picture.lib.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.holder.BasePreviewHolder;
import com.luck.picture.lib.adapter.holder.PreviewVideoHolder;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.LinkedHashMap;
import java.util.List;

public class PicturePreviewAdapter extends RecyclerView.Adapter<BasePreviewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List f9348a;
    public BasePreviewHolder.OnPreviewEventListener b;
    public final LinkedHashMap c = new LinkedHashMap();
    public final SelectorConfig d;

    public PicturePreviewAdapter(SelectorConfig selectorConfig) {
        this.d = selectorConfig;
    }

    public void g() {
        for (Integer num : this.c.keySet()) {
            BasePreviewHolder basePreviewHolder = (BasePreviewHolder) this.c.get(num);
            if (basePreviewHolder != null) {
                basePreviewHolder.k();
            }
        }
    }

    public int getItemCount() {
        List list = this.f9348a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int getItemViewType(int i) {
        if (PictureMimeType.i(((LocalMedia) this.f9348a.get(i)).getMimeType())) {
            return 2;
        }
        return PictureMimeType.d(((LocalMedia) this.f9348a.get(i)).getMimeType()) ? 3 : 1;
    }

    public BasePreviewHolder h(int i) {
        return (BasePreviewHolder) this.c.get(Integer.valueOf(i));
    }

    public LocalMedia i(int i) {
        if (i > this.f9348a.size()) {
            return null;
        }
        return (LocalMedia) this.f9348a.get(i);
    }

    public boolean j(int i) {
        BasePreviewHolder h = h(i);
        return h != null && h.e();
    }

    /* renamed from: k */
    public void onBindViewHolder(BasePreviewHolder basePreviewHolder, int i) {
        basePreviewHolder.n(this.b);
        LocalMedia i2 = i(i);
        this.c.put(Integer.valueOf(i), basePreviewHolder);
        basePreviewHolder.a(i2, i);
    }

    /* renamed from: l */
    public BasePreviewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 2) {
            int a2 = InjectResourceSource.a(viewGroup.getContext(), 8, this.d);
            if (a2 == 0) {
                a2 = R.layout.ps_preview_video;
            }
            return BasePreviewHolder.c(viewGroup, i, a2);
        } else if (i == 3) {
            int a3 = InjectResourceSource.a(viewGroup.getContext(), 10, this.d);
            if (a3 == 0) {
                a3 = R.layout.ps_preview_audio;
            }
            return BasePreviewHolder.c(viewGroup, i, a3);
        } else {
            int a4 = InjectResourceSource.a(viewGroup.getContext(), 7, this.d);
            if (a4 == 0) {
                a4 = R.layout.ps_preview_image;
            }
            return BasePreviewHolder.c(viewGroup, i, a4);
        }
    }

    /* renamed from: m */
    public void onViewAttachedToWindow(BasePreviewHolder basePreviewHolder) {
        super.onViewAttachedToWindow(basePreviewHolder);
        basePreviewHolder.i();
    }

    /* renamed from: n */
    public void onViewDetachedFromWindow(BasePreviewHolder basePreviewHolder) {
        super.onViewDetachedFromWindow(basePreviewHolder);
        basePreviewHolder.j();
    }

    public void o(int i) {
        BasePreviewHolder h = h(i);
        if (h != null) {
            LocalMedia i2 = i(i);
            if (i2.getWidth() == 0 && i2.getHeight() == 0) {
                h.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                h.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    public void p(BasePreviewHolder.OnPreviewEventListener onPreviewEventListener) {
        this.b = onPreviewEventListener;
    }

    public void q(int i) {
        BasePreviewHolder h = h(i);
        if (h instanceof PreviewVideoHolder) {
            PreviewVideoHolder previewVideoHolder = (PreviewVideoHolder) h;
            if (!previewVideoHolder.e()) {
                previewVideoHolder.h.setVisibility(0);
            }
        }
    }

    public void r(int i) {
        BasePreviewHolder h = h(i);
        if (h instanceof PreviewVideoHolder) {
            ((PreviewVideoHolder) h).x();
        }
    }

    public void setData(List list) {
        this.f9348a = list;
    }
}
