package com.luck.picture.lib.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnAlbumItemClickListener;
import com.luck.picture.lib.style.AlbumWindowStyle;
import java.util.ArrayList;
import java.util.List;

public class PictureAlbumAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List f9343a;
    public final SelectorConfig b;
    public OnAlbumItemClickListener c;

    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f9345a;
        public TextView b;
        public TextView c;

        public ViewHolder(View view) {
            super(view);
            this.f9345a = (ImageView) view.findViewById(R.id.first_image);
            this.b = (TextView) view.findViewById(R.id.tv_folder_name);
            this.c = (TextView) view.findViewById(R.id.tv_select_tag);
            AlbumWindowStyle a2 = PictureAlbumAdapter.this.b.K0.a();
            int a3 = a2.a();
            if (a3 != 0) {
                view.setBackgroundResource(a3);
            }
            int b2 = a2.b();
            if (b2 != 0) {
                this.c.setBackgroundResource(b2);
            }
            int c2 = a2.c();
            if (c2 != 0) {
                this.b.setTextColor(c2);
            }
            int d2 = a2.d();
            if (d2 > 0) {
                this.b.setTextSize((float) d2);
            }
        }
    }

    public PictureAlbumAdapter(SelectorConfig selectorConfig) {
        this.b = selectorConfig;
    }

    public int getItemCount() {
        return this.f9343a.size();
    }

    public void i(List list) {
        this.f9343a = new ArrayList(list);
    }

    public List j() {
        List list = this.f9343a;
        return list != null ? list : new ArrayList();
    }

    /* renamed from: k */
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        final LocalMediaFolder localMediaFolder = (LocalMediaFolder) this.f9343a.get(i);
        String folderName = localMediaFolder.getFolderName();
        int folderTotalNum = localMediaFolder.getFolderTotalNum();
        String firstImagePath = localMediaFolder.getFirstImagePath();
        boolean z = false;
        viewHolder.c.setVisibility(localMediaFolder.isSelectTag() ? 0 : 4);
        LocalMediaFolder localMediaFolder2 = this.b.q1;
        View view = viewHolder.itemView;
        if (localMediaFolder2 != null && localMediaFolder.getBucketId() == localMediaFolder2.getBucketId()) {
            z = true;
        }
        view.setSelected(z);
        if (PictureMimeType.d(localMediaFolder.getFirstMimeType())) {
            viewHolder.f9345a.setImageResource(R.drawable.ps_audio_placeholder);
        } else {
            ImageEngine imageEngine = this.b.L0;
            if (imageEngine != null) {
                imageEngine.e(viewHolder.itemView.getContext(), firstImagePath, viewHolder.f9345a);
            }
        }
        viewHolder.b.setText(viewHolder.itemView.getContext().getString(R.string.ps_camera_roll_num, new Object[]{folderName, Integer.valueOf(folderTotalNum)}));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (PictureAlbumAdapter.this.c != null) {
                    PictureAlbumAdapter.this.c.a(i, localMediaFolder);
                }
            }
        });
    }

    /* renamed from: l */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int a2 = InjectResourceSource.a(viewGroup.getContext(), 6, this.b);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (a2 == 0) {
            a2 = R.layout.ps_album_folder_item;
        }
        return new ViewHolder(from.inflate(a2, viewGroup, false));
    }

    public void m(OnAlbumItemClickListener onAlbumItemClickListener) {
        this.c = onAlbumItemClickListener;
    }
}
