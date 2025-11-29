package com.luck.picture.lib.adapter.holder;

import android.content.Context;
import android.graphics.ColorFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.PictureImageGridAdapter;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnGridItemSelectAnimListener;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.AnimUtils;
import com.luck.picture.lib.utils.StyleUtils;
import com.luck.picture.lib.utils.ValueOf;

public class BaseRecyclerMediaHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f9350a;
    public TextView b;
    public View c;
    public Context d;
    public SelectorConfig e;
    public boolean f;
    public boolean g;
    public ColorFilter h;
    public ColorFilter i;
    public ColorFilter j;
    public PictureImageGridAdapter.OnItemClickListener k;

    public BaseRecyclerMediaHolder(View view) {
        super(view);
    }

    public static BaseRecyclerMediaHolder f(ViewGroup viewGroup, int i2, int i3, SelectorConfig selectorConfig) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false);
        return i2 != 1 ? i2 != 3 ? i2 != 4 ? new ImageViewHolder(inflate, selectorConfig) : new AudioViewHolder(inflate, selectorConfig) : new VideoViewHolder(inflate, selectorConfig) : new CameraViewHolder(inflate);
    }

    public void d(final LocalMedia localMedia, final int i2) {
        localMedia.position = getAbsoluteAdapterPosition();
        j(g(localMedia));
        if (this.f) {
            i(localMedia);
        }
        if (this.g && this.e.g0) {
            e(localMedia);
        }
        String path = localMedia.getPath();
        if (localMedia.isEditorImage()) {
            path = localMedia.getCutPath();
        }
        h(path);
        this.b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseRecyclerMediaHolder.this.c.performClick();
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int a2;
                OnGridItemSelectAnimListener onGridItemSelectAnimListener;
                if (!localMedia.isMaxSelectEnabledMask() && BaseRecyclerMediaHolder.this.k != null && (a2 = BaseRecyclerMediaHolder.this.k.a(BaseRecyclerMediaHolder.this.b, i2, localMedia)) != -1) {
                    if (a2 == 0) {
                        BaseRecyclerMediaHolder baseRecyclerMediaHolder = BaseRecyclerMediaHolder.this;
                        SelectorConfig selectorConfig = baseRecyclerMediaHolder.e;
                        if (selectorConfig.A0) {
                            OnGridItemSelectAnimListener onGridItemSelectAnimListener2 = selectorConfig.n1;
                            if (onGridItemSelectAnimListener2 != null) {
                                onGridItemSelectAnimListener2.a(baseRecyclerMediaHolder.f9350a, true);
                            } else {
                                AnimUtils.b(baseRecyclerMediaHolder.f9350a);
                            }
                        }
                    } else if (a2 == 1) {
                        BaseRecyclerMediaHolder baseRecyclerMediaHolder2 = BaseRecyclerMediaHolder.this;
                        SelectorConfig selectorConfig2 = baseRecyclerMediaHolder2.e;
                        if (selectorConfig2.A0 && (onGridItemSelectAnimListener = selectorConfig2.n1) != null) {
                            onGridItemSelectAnimListener.a(baseRecyclerMediaHolder2.f9350a, false);
                        }
                    }
                    BaseRecyclerMediaHolder baseRecyclerMediaHolder3 = BaseRecyclerMediaHolder.this;
                    baseRecyclerMediaHolder3.j(baseRecyclerMediaHolder3.g(localMedia));
                }
            }
        });
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (BaseRecyclerMediaHolder.this.k == null) {
                    return false;
                }
                BaseRecyclerMediaHolder.this.k.d(view, i2);
                return false;
            }
        });
        this.itemView.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
                if (r3.j != 1) goto L_0x0046;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
                if (r3.j != 1) goto L_0x005f;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r3) {
                /*
                    r2 = this;
                    com.luck.picture.lib.entity.LocalMedia r3 = r3
                    boolean r3 = r3.isMaxSelectEnabledMask()
                    if (r3 != 0) goto L_0x0078
                    com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder r3 = com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.this
                    com.luck.picture.lib.adapter.PictureImageGridAdapter$OnItemClickListener r3 = r3.k
                    if (r3 != 0) goto L_0x0011
                    goto L_0x0078
                L_0x0011:
                    com.luck.picture.lib.entity.LocalMedia r3 = r3
                    java.lang.String r3 = r3.getMimeType()
                    boolean r3 = com.luck.picture.lib.config.PictureMimeType.h(r3)
                    if (r3 == 0) goto L_0x0025
                    com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder r3 = com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.this
                    com.luck.picture.lib.config.SelectorConfig r3 = r3.e
                    boolean r3 = r3.H
                    if (r3 != 0) goto L_0x0067
                L_0x0025:
                    com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder r3 = com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.this
                    com.luck.picture.lib.config.SelectorConfig r3 = r3.e
                    boolean r3 = r3.c
                    if (r3 != 0) goto L_0x0067
                    com.luck.picture.lib.entity.LocalMedia r3 = r3
                    java.lang.String r3 = r3.getMimeType()
                    boolean r3 = com.luck.picture.lib.config.PictureMimeType.i(r3)
                    r0 = 1
                    if (r3 == 0) goto L_0x0046
                    com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder r3 = com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.this
                    com.luck.picture.lib.config.SelectorConfig r3 = r3.e
                    boolean r1 = r3.I
                    if (r1 != 0) goto L_0x0067
                    int r3 = r3.j
                    if (r3 == r0) goto L_0x0067
                L_0x0046:
                    com.luck.picture.lib.entity.LocalMedia r3 = r3
                    java.lang.String r3 = r3.getMimeType()
                    boolean r3 = com.luck.picture.lib.config.PictureMimeType.d(r3)
                    if (r3 == 0) goto L_0x005f
                    com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder r3 = com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.this
                    com.luck.picture.lib.config.SelectorConfig r3 = r3.e
                    boolean r1 = r3.J
                    if (r1 != 0) goto L_0x0067
                    int r3 = r3.j
                    if (r3 != r0) goto L_0x005f
                    goto L_0x0067
                L_0x005f:
                    com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder r2 = com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.this
                    android.view.View r2 = r2.c
                    r2.performClick()
                    goto L_0x0078
                L_0x0067:
                    com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder r3 = com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.this
                    com.luck.picture.lib.adapter.PictureImageGridAdapter$OnItemClickListener r3 = r3.k
                    com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder r0 = com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.this
                    android.widget.TextView r0 = r0.b
                    int r1 = r4
                    com.luck.picture.lib.entity.LocalMedia r2 = r3
                    r3.c(r0, r1, r2)
                L_0x0078:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.AnonymousClass4.onClick(android.view.View):void");
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        if (com.luck.picture.lib.config.PictureMimeType.h(r5.getMimeType()) == false) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
        if (com.luck.picture.lib.config.PictureMimeType.i(r5.getMimeType()) == false) goto L_0x0083;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(com.luck.picture.lib.entity.LocalMedia r5) {
        /*
            r4 = this;
            com.luck.picture.lib.config.SelectorConfig r0 = r4.e
            int r0 = r0.g()
            if (r0 <= 0) goto L_0x0083
            com.luck.picture.lib.config.SelectorConfig r0 = r4.e
            java.util.ArrayList r0 = r0.h()
            boolean r0 = r0.contains(r5)
            if (r0 != 0) goto L_0x0083
            com.luck.picture.lib.config.SelectorConfig r0 = r4.e
            boolean r1 = r0.P
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = 1
            if (r1 == 0) goto L_0x0034
            int r1 = r0.j
            if (r1 != r3) goto L_0x0029
            int r0 = r0.g()
            if (r0 != r2) goto L_0x0083
            goto L_0x0078
        L_0x0029:
            int r0 = r0.g()
            com.luck.picture.lib.config.SelectorConfig r1 = r4.e
            int r1 = r1.k
            if (r0 != r1) goto L_0x0083
            goto L_0x0078
        L_0x0034:
            java.lang.String r0 = r0.f()
            boolean r0 = com.luck.picture.lib.config.PictureMimeType.i(r0)
            if (r0 == 0) goto L_0x005f
            com.luck.picture.lib.config.SelectorConfig r0 = r4.e
            int r1 = r0.j
            if (r1 != r3) goto L_0x0045
            goto L_0x004e
        L_0x0045:
            int r1 = r0.m
            if (r1 <= 0) goto L_0x004b
        L_0x0049:
            r2 = r1
            goto L_0x004e
        L_0x004b:
            int r1 = r0.k
            goto L_0x0049
        L_0x004e:
            int r0 = r0.g()
            if (r0 == r2) goto L_0x0078
            java.lang.String r0 = r5.getMimeType()
            boolean r0 = com.luck.picture.lib.config.PictureMimeType.h(r0)
            if (r0 == 0) goto L_0x0083
            goto L_0x0078
        L_0x005f:
            com.luck.picture.lib.config.SelectorConfig r0 = r4.e
            int r1 = r0.j
            if (r1 != r3) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            int r2 = r0.k
        L_0x0068:
            int r0 = r0.g()
            if (r0 == r2) goto L_0x0078
            java.lang.String r0 = r5.getMimeType()
            boolean r0 = com.luck.picture.lib.config.PictureMimeType.i(r0)
            if (r0 == 0) goto L_0x0083
        L_0x0078:
            android.widget.ImageView r0 = r4.f9350a
            android.graphics.ColorFilter r4 = r4.j
            r0.setColorFilter(r4)
            r5.setMaxSelectEnabledMask(r3)
            goto L_0x0087
        L_0x0083:
            r4 = 0
            r5.setMaxSelectEnabledMask(r4)
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.e(com.luck.picture.lib.entity.LocalMedia):void");
    }

    public final boolean g(LocalMedia localMedia) {
        LocalMedia compareLocalMedia;
        boolean contains = this.e.h().contains(localMedia);
        if (contains && (compareLocalMedia = localMedia.getCompareLocalMedia()) != null && compareLocalMedia.isEditorImage()) {
            localMedia.setCutPath(compareLocalMedia.getCutPath());
            localMedia.setCut(!TextUtils.isEmpty(compareLocalMedia.getCutPath()));
            localMedia.setEditorImage(compareLocalMedia.isEditorImage());
        }
        return contains;
    }

    public void h(String str) {
        ImageEngine imageEngine = this.e.L0;
        if (imageEngine != null) {
            imageEngine.f(this.f9350a.getContext(), str, this.f9350a);
        }
    }

    public final void i(LocalMedia localMedia) {
        this.b.setText("");
        for (int i2 = 0; i2 < this.e.g(); i2++) {
            LocalMedia localMedia2 = (LocalMedia) this.e.h().get(i2);
            if (TextUtils.equals(localMedia2.getPath(), localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                localMedia.setNum(localMedia2.getNum());
                localMedia2.setPosition(localMedia.getPosition());
                this.b.setText(ValueOf.g(Integer.valueOf(localMedia.getNum())));
            }
        }
    }

    public final void j(boolean z) {
        if (this.b.isSelected() != z) {
            this.b.setSelected(z);
        }
        if (this.e.c) {
            this.f9350a.setColorFilter(this.h);
        } else {
            this.f9350a.setColorFilter(z ? this.i : this.h);
        }
    }

    public void k(PictureImageGridAdapter.OnItemClickListener onItemClickListener) {
        this.k = onItemClickListener;
    }

    public BaseRecyclerMediaHolder(View view, SelectorConfig selectorConfig) {
        super(view);
        int i2;
        this.e = selectorConfig;
        Context context = view.getContext();
        this.d = context;
        this.h = StyleUtils.g(context, R.color.ps_color_20);
        this.i = StyleUtils.g(this.d, R.color.ps_color_80);
        this.j = StyleUtils.g(this.d, R.color.ps_color_half_white);
        SelectMainStyle c2 = this.e.K0.c();
        this.f = c2.a0();
        this.f9350a = (ImageView) view.findViewById(R.id.ivPicture);
        this.b = (TextView) view.findViewById(R.id.tvCheck);
        this.c = view.findViewById(R.id.btnCheck);
        boolean z = true;
        if (selectorConfig.j != 1 || !selectorConfig.c) {
            this.b.setVisibility(0);
            this.c.setVisibility(0);
        } else {
            this.b.setVisibility(8);
            this.c.setVisibility(8);
        }
        if (selectorConfig.c || !((i2 = selectorConfig.j) == 1 || i2 == 2)) {
            z = false;
        }
        this.g = z;
        int u = c2.u();
        if (StyleUtils.b(u)) {
            this.b.setTextSize((float) u);
        }
        int t = c2.t();
        if (StyleUtils.c(t)) {
            this.b.setTextColor(t);
        }
        int I = c2.I();
        if (StyleUtils.c(I)) {
            this.b.setBackgroundResource(I);
        }
        int[] s = c2.s();
        if (StyleUtils.a(s)) {
            if (this.b.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.b.getLayoutParams()).removeRule(21);
                for (int addRule : s) {
                    ((RelativeLayout.LayoutParams) this.b.getLayoutParams()).addRule(addRule);
                }
            }
            if (this.c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.c.getLayoutParams()).removeRule(21);
                for (int addRule2 : s) {
                    ((RelativeLayout.LayoutParams) this.c.getLayoutParams()).addRule(addRule2);
                }
            }
            int r = c2.r();
            if (StyleUtils.b(r)) {
                ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                layoutParams.width = r;
                layoutParams.height = r;
            }
        }
    }
}
