package com.luck.picture.lib.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.PictureAlbumAdapter;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.decoration.WrapContentLinearLayoutManager;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnAlbumItemClickListener;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.List;

public class AlbumListPopWindow extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public final Context f9409a;
    public View b;
    public RecyclerView c;
    public boolean d = false;
    public int e;
    public PictureAlbumAdapter f;
    public SelectorConfig g;
    public OnPopupWindowStatusListener h;

    public interface OnPopupWindowStatusListener {
        void a();

        void b();
    }

    public AlbumListPopWindow(Context context, SelectorConfig selectorConfig) {
        this.f9409a = context;
        this.g = selectorConfig;
        setContentView(LayoutInflater.from(context).inflate(R.layout.ps_window_folder, (ViewGroup) null));
        setWidth(-1);
        setHeight(-2);
        setAnimationStyle(R.style.PictureThemeWindowStyle);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        j();
    }

    public static AlbumListPopWindow d(Context context, SelectorConfig selectorConfig) {
        return new AlbumListPopWindow(context, selectorConfig);
    }

    public void c(List list) {
        this.f.i(list);
        this.f.notifyDataSetChanged();
        this.c.getLayoutParams().height = list.size() > 8 ? this.e : -2;
    }

    public void dismiss() {
        if (!this.d) {
            this.b.setAlpha(0.0f);
            OnPopupWindowStatusListener onPopupWindowStatusListener = this.h;
            if (onPopupWindowStatusListener != null) {
                onPopupWindowStatusListener.b();
            }
            this.d = true;
            this.b.post(new Runnable() {
                public void run() {
                    AlbumListPopWindow.super.dismiss();
                    boolean unused = AlbumListPopWindow.this.d = false;
                }
            });
        }
    }

    public void e() {
        List j = this.f.j();
        for (int i = 0; i < j.size(); i++) {
            LocalMediaFolder localMediaFolder = (LocalMediaFolder) j.get(i);
            localMediaFolder.setSelectTag(false);
            this.f.notifyItemChanged(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.g.g()) {
                    break;
                } else if (TextUtils.equals(localMediaFolder.getFolderName(), ((LocalMedia) this.g.h().get(i2)).getParentFolderName()) || localMediaFolder.getBucketId() == -1) {
                    localMediaFolder.setSelectTag(true);
                    this.f.notifyItemChanged(i);
                } else {
                    i2++;
                }
            }
            localMediaFolder.setSelectTag(true);
            this.f.notifyItemChanged(i);
        }
    }

    public List f() {
        return this.f.j();
    }

    public int g() {
        if (i() > 0) {
            return h(0).getFolderTotalNum();
        }
        return 0;
    }

    public LocalMediaFolder h(int i) {
        if (this.f.j().size() <= 0 || i >= this.f.j().size()) {
            return null;
        }
        return (LocalMediaFolder) this.f.j().get(i);
    }

    public int i() {
        return this.f.j().size();
    }

    public final void j() {
        this.e = (int) (((double) DensityUtil.g(this.f9409a)) * 0.6d);
        this.c = (RecyclerView) getContentView().findViewById(R.id.folder_list);
        this.b = getContentView().findViewById(R.id.rootViewBg);
        this.c.setLayoutManager(new WrapContentLinearLayoutManager(this.f9409a));
        PictureAlbumAdapter pictureAlbumAdapter = new PictureAlbumAdapter(this.g);
        this.f = pictureAlbumAdapter;
        this.c.setAdapter(pictureAlbumAdapter);
        this.b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlbumListPopWindow.this.dismiss();
            }
        });
        getContentView().findViewById(R.id.rootView).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (SdkVersionUtils.b()) {
                    AlbumListPopWindow.this.dismiss();
                }
            }
        });
    }

    public void k(OnAlbumItemClickListener onAlbumItemClickListener) {
        this.f.m(onAlbumItemClickListener);
    }

    public void l(OnPopupWindowStatusListener onPopupWindowStatusListener) {
        this.h = onPopupWindowStatusListener;
    }

    public void showAsDropDown(View view) {
        if (f() != null && f().size() != 0) {
            if (SdkVersionUtils.c()) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                showAtLocation(view, 0, 0, iArr[1] + view.getHeight());
            } else {
                super.showAsDropDown(view);
            }
            this.d = false;
            OnPopupWindowStatusListener onPopupWindowStatusListener = this.h;
            if (onPopupWindowStatusListener != null) {
                onPopupWindowStatusListener.a();
            }
            this.b.animate().alpha(1.0f).setDuration(250).setStartDelay(250).start();
            e();
        }
    }
}
