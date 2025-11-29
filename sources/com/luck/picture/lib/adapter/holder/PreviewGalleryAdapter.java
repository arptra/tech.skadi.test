package com.luck.picture.lib.adapter.holder;

import android.graphics.ColorFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.StyleUtils;
import java.util.ArrayList;
import java.util.List;

public class PreviewGalleryAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public final List f9367a;
    public final boolean b;
    public final SelectorConfig c;
    public OnItemClickListener d;
    public OnItemLongClickListener e;

    public interface OnItemClickListener {
        void a(int i, LocalMedia localMedia, View view);
    }

    public interface OnItemLongClickListener {
        void a(RecyclerView.ViewHolder viewHolder, int i, View view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f9370a;
        public ImageView b;
        public ImageView c;
        public View d;

        public ViewHolder(View view) {
            super(view);
            this.f9370a = (ImageView) view.findViewById(R.id.ivImage);
            this.b = (ImageView) view.findViewById(R.id.ivPlay);
            this.c = (ImageView) view.findViewById(R.id.ivEditor);
            this.d = view.findViewById(R.id.viewBorder);
            SelectMainStyle c2 = PreviewGalleryAdapter.this.c.K0.c();
            if (StyleUtils.c(c2.m())) {
                this.c.setImageResource(c2.m());
            }
            if (StyleUtils.c(c2.p())) {
                this.d.setBackgroundResource(c2.p());
            }
            int q = c2.q();
            if (StyleUtils.b(q)) {
                view.setLayoutParams(new RelativeLayout.LayoutParams(q, q));
            }
        }
    }

    public PreviewGalleryAdapter(SelectorConfig selectorConfig, boolean z) {
        this.c = selectorConfig;
        this.b = z;
        this.f9367a = new ArrayList(selectorConfig.h());
        for (int i = 0; i < this.f9367a.size(); i++) {
            LocalMedia localMedia = (LocalMedia) this.f9367a.get(i);
            localMedia.setGalleryEnabledMask(false);
            localMedia.setChecked(false);
        }
    }

    public void clear() {
        this.f9367a.clear();
    }

    public List getData() {
        return this.f9367a;
    }

    public int getItemCount() {
        return this.f9367a.size();
    }

    public void j(LocalMedia localMedia) {
        int l = l();
        if (l != -1) {
            ((LocalMedia) this.f9367a.get(l)).setChecked(false);
            notifyItemChanged(l);
        }
        if (!this.b || !this.f9367a.contains(localMedia)) {
            localMedia.setChecked(true);
            this.f9367a.add(localMedia);
            notifyItemChanged(this.f9367a.size() - 1);
            return;
        }
        int k = k(localMedia);
        LocalMedia localMedia2 = (LocalMedia) this.f9367a.get(k);
        localMedia2.setGalleryEnabledMask(false);
        localMedia2.setChecked(true);
        notifyItemChanged(k);
    }

    public final int k(LocalMedia localMedia) {
        for (int i = 0; i < this.f9367a.size(); i++) {
            LocalMedia localMedia2 = (LocalMedia) this.f9367a.get(i);
            if (TextUtils.equals(localMedia2.getPath(), localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                return i;
            }
        }
        return -1;
    }

    public int l() {
        for (int i = 0; i < this.f9367a.size(); i++) {
            if (((LocalMedia) this.f9367a.get(i)).isChecked()) {
                return i;
            }
        }
        return -1;
    }

    public void m(LocalMedia localMedia) {
        int l = l();
        if (l != -1) {
            ((LocalMedia) this.f9367a.get(l)).setChecked(false);
            notifyItemChanged(l);
        }
        int k = k(localMedia);
        if (k != -1) {
            ((LocalMedia) this.f9367a.get(k)).setChecked(true);
            notifyItemChanged(k);
        }
    }

    /* renamed from: n */
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final LocalMedia localMedia = (LocalMedia) this.f9367a.get(i);
        ColorFilter g = StyleUtils.g(viewHolder.itemView.getContext(), localMedia.isGalleryEnabledMask() ? R.color.ps_color_half_white : R.color.ps_color_transparent);
        int i2 = 8;
        if (!localMedia.isChecked() || !localMedia.isGalleryEnabledMask()) {
            viewHolder.d.setVisibility(localMedia.isChecked() ? 0 : 8);
        } else {
            viewHolder.d.setVisibility(0);
        }
        String path = localMedia.getPath();
        if (!localMedia.isEditorImage() || TextUtils.isEmpty(localMedia.getCutPath())) {
            viewHolder.c.setVisibility(8);
        } else {
            path = localMedia.getCutPath();
            viewHolder.c.setVisibility(0);
        }
        viewHolder.f9370a.setColorFilter(g);
        ImageEngine imageEngine = this.c.L0;
        if (imageEngine != null) {
            imageEngine.f(viewHolder.itemView.getContext(), path, viewHolder.f9370a);
        }
        ImageView imageView = viewHolder.b;
        if (PictureMimeType.i(localMedia.getMimeType())) {
            i2 = 0;
        }
        imageView.setVisibility(i2);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (PreviewGalleryAdapter.this.d != null) {
                    PreviewGalleryAdapter.this.d.a(viewHolder.getAbsoluteAdapterPosition(), localMedia, view);
                }
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (PreviewGalleryAdapter.this.e == null) {
                    return true;
                }
                PreviewGalleryAdapter.this.e.a(viewHolder, viewHolder.getAbsoluteAdapterPosition(), view);
                return true;
            }
        });
    }

    /* renamed from: o */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int a2 = InjectResourceSource.a(viewGroup.getContext(), 9, this.c);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (a2 == 0) {
            a2 = R.layout.ps_preview_gallery_item;
        }
        return new ViewHolder(from.inflate(a2, viewGroup, false));
    }

    public void p(LocalMedia localMedia) {
        int k = k(localMedia);
        if (k == -1) {
            return;
        }
        if (this.b) {
            ((LocalMedia) this.f9367a.get(k)).setGalleryEnabledMask(true);
            notifyItemChanged(k);
            return;
        }
        this.f9367a.remove(k);
        notifyItemRemoved(k);
    }

    public void q(OnItemClickListener onItemClickListener) {
        this.d = onItemClickListener;
    }

    public void r(OnItemLongClickListener onItemLongClickListener) {
        this.e = onItemLongClickListener;
    }
}
