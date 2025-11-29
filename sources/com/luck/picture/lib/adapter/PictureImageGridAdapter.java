package com.luck.picture.lib.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;

public class PictureImageGridAdapter extends RecyclerView.Adapter<BaseRecyclerMediaHolder> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9346a;
    public ArrayList b = new ArrayList();
    public final SelectorConfig c;
    public final Context d;
    public OnItemClickListener e;

    public interface OnItemClickListener {
        int a(View view, int i, LocalMedia localMedia);

        void b();

        void c(View view, int i, LocalMedia localMedia);

        void d(View view, int i);
    }

    public PictureImageGridAdapter(Context context, SelectorConfig selectorConfig) {
        this.c = selectorConfig;
        this.d = context;
    }

    public int getItemCount() {
        boolean z = this.f9346a;
        int size = this.b.size();
        return z ? size + 1 : size;
    }

    public int getItemViewType(int i) {
        boolean z = this.f9346a;
        if (z && i == 0) {
            return 1;
        }
        if (z) {
            i--;
        }
        String mimeType = ((LocalMedia) this.b.get(i)).getMimeType();
        if (PictureMimeType.i(mimeType)) {
            return 3;
        }
        return PictureMimeType.d(mimeType) ? 4 : 2;
    }

    public ArrayList h() {
        return this.b;
    }

    public final int i(int i) {
        if (i == 1) {
            return R.layout.ps_item_grid_camera;
        }
        if (i == 3) {
            int a2 = InjectResourceSource.a(this.d, 4, this.c);
            return a2 != 0 ? a2 : R.layout.ps_item_grid_video;
        } else if (i != 4) {
            int a3 = InjectResourceSource.a(this.d, 3, this.c);
            return a3 != 0 ? a3 : R.layout.ps_item_grid_image;
        } else {
            int a4 = InjectResourceSource.a(this.d, 5, this.c);
            return a4 != 0 ? a4 : R.layout.ps_item_grid_audio;
        }
    }

    public boolean j() {
        return this.b.size() == 0;
    }

    public boolean k() {
        return this.f9346a;
    }

    public void l(int i) {
        notifyItemChanged(i);
    }

    /* renamed from: m */
    public void onBindViewHolder(BaseRecyclerMediaHolder baseRecyclerMediaHolder, int i) {
        if (getItemViewType(i) == 1) {
            baseRecyclerMediaHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (PictureImageGridAdapter.this.e != null) {
                        PictureImageGridAdapter.this.e.b();
                    }
                }
            });
            return;
        }
        if (this.f9346a) {
            i--;
        }
        baseRecyclerMediaHolder.d((LocalMedia) this.b.get(i), i);
        baseRecyclerMediaHolder.k(this.e);
    }

    /* renamed from: n */
    public BaseRecyclerMediaHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return BaseRecyclerMediaHolder.f(viewGroup, i, i(i), this.c);
    }

    public void o(ArrayList arrayList) {
        if (arrayList != null) {
            this.b = arrayList;
            notifyDataSetChanged();
        }
    }

    public void p(boolean z) {
        this.f9346a = z;
    }

    public void q(OnItemClickListener onItemClickListener) {
        this.e = onItemClickListener;
    }
}
