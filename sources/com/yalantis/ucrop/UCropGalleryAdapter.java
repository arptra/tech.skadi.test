package com.yalantis.ucrop;

import android.graphics.ColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UCropGalleryAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public final List f8738a;
    public int b;
    public OnItemClickListener c;

    public interface OnItemClickListener {
        void a(int i, View view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f8740a;
        public View b;

        public ViewHolder(View view) {
            super(view);
            this.f8740a = (ImageView) view.findViewById(R.id.iv_photo);
            this.b = view.findViewById(R.id.view_current_select);
        }
    }

    public UCropGalleryAdapter(List list) {
        this.f8738a = list;
    }

    public int getItemCount() {
        List list = this.f8738a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int h() {
        return this.b;
    }

    /* renamed from: i */
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        ColorFilter colorFilter;
        String str = (String) this.f8738a.get(i);
        UCropImageEngine uCropImageEngine = UCropDevelopConfig.f8727a;
        if (uCropImageEngine != null) {
            uCropImageEngine.a(viewHolder.itemView.getContext(), str, viewHolder.f8740a);
        }
        if (this.b == i) {
            viewHolder.b.setVisibility(0);
            colorFilter = BlendModeColorFilterCompat.a(ContextCompat.getColor(viewHolder.itemView.getContext(), R.color.ucrop_color_80), BlendModeCompat.SRC_ATOP);
        } else {
            colorFilter = BlendModeColorFilterCompat.a(ContextCompat.getColor(viewHolder.itemView.getContext(), R.color.ucrop_color_20), BlendModeCompat.SRC_ATOP);
            viewHolder.b.setVisibility(8);
        }
        viewHolder.f8740a.setColorFilter(colorFilter);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (UCropGalleryAdapter.this.c != null) {
                    UCropGalleryAdapter.this.c.a(viewHolder.getAbsoluteAdapterPosition(), view);
                }
            }
        });
    }

    /* renamed from: j */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ucrop_gallery_adapter_item, viewGroup, false));
    }

    public void k(int i) {
        this.b = i;
    }

    public void l(OnItemClickListener onItemClickListener) {
        this.c = onItemClickListener;
    }
}
