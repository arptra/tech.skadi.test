package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.h8.b6;
import com.honey.account.h8.c6;
import com.honey.account.h8.d6;
import com.honey.account.h8.e6;
import com.honey.account.h8.f6;
import com.luck.picture.lib.basic.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.utils.DateUtils;
import com.luck.picture.lib.widget.RecyclerPreloadView;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentMediaSelectBinding;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 .2\u00020\u0001:\u0003/01B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R&\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010\"R&\u0010(\u001a\u0012\u0012\u0004\u0012\u00020&0\u001ej\b\u0012\u0004\u0012\u00020&` 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010\"R&\u0010*\u001a\u0012\u0012\u0004\u0012\u00020&0\u001ej\b\u0012\u0004\u0012\u00020&` 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010\"R\u0016\u0010-\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u00062"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/MediaSelectFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initData", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "isClose", "L0", "(Z)V", "", "H0", "()I", "Lcom/upuphone/xr/sapp/databinding/FragmentMediaSelectBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentMediaSelectBinding;", "binding", "Ljava/util/ArrayList;", "Lcom/luck/picture/lib/entity/LocalMedia;", "Lkotlin/collections/ArrayList;", "k", "Ljava/util/ArrayList;", "mData", "l", "mSelectData", "Landroid/net/Uri;", "m", "mImgCompressData", "n", "mVideoCompressData", "o", "I", "selectIndex", "p", "Companion", "GridAdapter", "ItemOnClickListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nMediaSelectFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaSelectFragment.kt\ncom/upuphone/xr/sapp/fragment/MediaSelectFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,285:1\n1#2:286\n*E\n"})
public final class MediaSelectFragment extends BaseFragment {
    public static final Companion p = new Companion((DefaultConstructorMarker) null);
    public FragmentMediaSelectBinding j;
    public final ArrayList k = new ArrayList();
    public ArrayList l = new ArrayList();
    public ArrayList m = new ArrayList();
    public ArrayList n = new ArrayList();
    public int o = -1;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/MediaSelectFragment$Companion;", "", "()V", "DATA_COUNT", "", "DATA_INDEX", "DATA_VALUE", "TAG", "VIDEO_MAX", "", "VIDEO_MAX_VALUE", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u001d\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/MediaSelectFragment$GridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/upuphone/xr/sapp/fragment/MediaSelectFragment$GridAdapter$ViewHolder;", "", "Lcom/luck/picture/lib/entity/LocalMedia;", "list", "Lcom/upuphone/xr/sapp/fragment/MediaSelectFragment$ItemOnClickListener;", "listener", "<init>", "(Ljava/util/List;Lcom/upuphone/xr/sapp/fragment/MediaSelectFragment$ItemOnClickListener;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "m", "(Landroid/view/ViewGroup;I)Lcom/upuphone/xr/sapp/fragment/MediaSelectFragment$GridAdapter$ViewHolder;", "viewHolder", "position", "", "j", "(Lcom/upuphone/xr/sapp/fragment/MediaSelectFragment$GridAdapter$ViewHolder;I)V", "getItemCount", "()I", "i", "a", "Ljava/util/List;", "b", "Lcom/upuphone/xr/sapp/fragment/MediaSelectFragment$ItemOnClickListener;", "ViewHolder", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class GridAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        public final List f6976a;
        public final ItemOnClickListener b;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/MediaSelectFragment$GridAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setMImg", "(Landroid/widget/ImageView;)V", "mImg", "b", "setMIvSelect", "mIvSelect", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "setTvDuration", "(Landroid/widget/TextView;)V", "tvDuration", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class ViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public ImageView f6977a;
            public ImageView b;
            public TextView c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ViewHolder(View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "view");
                View findViewById = view.findViewById(R.id.fiv);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                this.f6977a = (ImageView) findViewById;
                View findViewById2 = view.findViewById(R.id.iv_select);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
                this.b = (ImageView) findViewById2;
                View findViewById3 = view.findViewById(R.id.tv_duration);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
                this.c = (TextView) findViewById3;
            }

            public final ImageView a() {
                return this.f6977a;
            }

            public final ImageView b() {
                return this.b;
            }

            public final TextView c() {
                return this.c;
            }
        }

        public GridAdapter(List list, ItemOnClickListener itemOnClickListener) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(itemOnClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.f6976a = list;
            this.b = itemOnClickListener;
        }

        public static final void k(GridAdapter gridAdapter, int i, View view) {
            Intrinsics.checkNotNullParameter(gridAdapter, "this$0");
            gridAdapter.b.b(i);
        }

        public static final void l(GridAdapter gridAdapter, ViewHolder viewHolder, int i, View view) {
            Intrinsics.checkNotNullParameter(gridAdapter, "this$0");
            Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
            ItemOnClickListener itemOnClickListener = gridAdapter.b;
            View view2 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "itemView");
            itemOnClickListener.a(view2, i);
        }

        public int getItemCount() {
            return this.f6976a.size();
        }

        public final int i() {
            int size = this.f6976a.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (((LocalMedia) this.f6976a.get(i2)).isChecked()) {
                    i++;
                }
            }
            return i;
        }

        /* renamed from: j */
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            LocalMedia localMedia = (LocalMedia) this.f6976a.get(i);
            String path = localMedia.getPath();
            long duration = localMedia.getDuration();
            if (PictureMimeType.i(localMedia.getMimeType())) {
                viewHolder.c().setVisibility(0);
            } else {
                viewHolder.c().setVisibility(8);
            }
            viewHolder.c().setText(DateUtils.b(duration));
            RequestManager t = Glide.t(viewHolder.itemView.getContext());
            boolean c = PictureMimeType.c(path);
            Object obj = path;
            if (c) {
                obj = Uri.parse(path);
            }
            ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) t.r(obj).d()).V(R.color.default_img)).h(DiskCacheStrategy.e)).z0(viewHolder.a());
            viewHolder.b().setOnClickListener(new e6(this, i));
            viewHolder.a().setOnClickListener(new f6(this, viewHolder, i));
            viewHolder.b().setSelected(localMedia.isChecked());
            if (i() < 9) {
                viewHolder.a().setAlpha(1.0f);
            } else if (viewHolder.b().isSelected()) {
                viewHolder.a().setAlpha(1.0f);
            } else {
                viewHolder.a().setAlpha(0.28f);
            }
        }

        /* renamed from: m */
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gv_filter_image, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new ViewHolder(inflate);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/MediaSelectFragment$ItemOnClickListener;", "", "", "i", "", "b", "(I)V", "Landroid/view/View;", "view", "a", "(Landroid/view/View;I)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface ItemOnClickListener {
        void a(View view, int i);

        void b(int i);
    }

    public static final void I0(MediaSelectFragment mediaSelectFragment, View view) {
        Intrinsics.checkNotNullParameter(mediaSelectFragment, "this$0");
        mediaSelectFragment.L0(true);
    }

    public static final void J0(MediaSelectFragment mediaSelectFragment, GridAdapter gridAdapter, List list) {
        Intrinsics.checkNotNullParameter(mediaSelectFragment, "this$0");
        Intrinsics.checkNotNullParameter(gridAdapter, "$adapter");
        ULog.f6446a.a("MediaSelectFragment", "result");
        if (mediaSelectFragment.k.size() == 0) {
            mediaSelectFragment.k.addAll(list);
        }
        int size = mediaSelectFragment.k.size();
        for (int i = 0; i < size; i++) {
            int size2 = mediaSelectFragment.l.size();
            for (int i2 = 0; i2 < size2; i2++) {
                if (((LocalMedia) mediaSelectFragment.k.get(i)).getPath().equals(((LocalMedia) mediaSelectFragment.l.get(i2)).getPath())) {
                    ((LocalMedia) mediaSelectFragment.k.get(i)).setChecked(true);
                }
            }
        }
        gridAdapter.notifyDataSetChanged();
        Context context = mediaSelectFragment.getContext();
        if (context != null) {
            FragmentMediaSelectBinding fragmentMediaSelectBinding = mediaSelectFragment.j;
            if (fragmentMediaSelectBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMediaSelectBinding = null;
            }
            fragmentMediaSelectBinding.b.setText(context.getString(R.string.done) + "（" + mediaSelectFragment.H0() + "/9）");
        }
    }

    public static final void K0(MediaSelectFragment mediaSelectFragment, View view) {
        Intrinsics.checkNotNullParameter(mediaSelectFragment, "this$0");
        mediaSelectFragment.L0(false);
    }

    private final void initData() {
        ULog.f6446a.a("MediaSelectFragment", "initData");
    }

    private final void initView() {
        ULog.f6446a.a("MediaSelectFragment", "initView");
        FragmentMediaSelectBinding fragmentMediaSelectBinding = this.j;
        FragmentMediaSelectBinding fragmentMediaSelectBinding2 = null;
        if (fragmentMediaSelectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaSelectBinding = null;
        }
        fragmentMediaSelectBinding.c.setOnClickListener(new b6(this));
        FragmentMediaSelectBinding fragmentMediaSelectBinding3 = this.j;
        if (fragmentMediaSelectBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaSelectBinding3 = null;
        }
        RecyclerPreloadView recyclerPreloadView = fragmentMediaSelectBinding3.d;
        Intrinsics.checkNotNullExpressionValue(recyclerPreloadView, "recycler");
        recyclerPreloadView.addItemDecoration(new GridSpacingItemDecoration(4, StaticMethodUtilsKt.h(4.0f), false));
        recyclerPreloadView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        RecyclerView.ItemAnimator itemAnimator = recyclerPreloadView.getItemAnimator();
        if (itemAnimator != null) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            recyclerPreloadView.setItemAnimator((RecyclerView.ItemAnimator) null);
        }
        GridAdapter gridAdapter = new GridAdapter(this.k, new MediaSelectFragment$initView$adapter$1(this, recyclerPreloadView));
        recyclerPreloadView.setAdapter(gridAdapter);
        PictureSelector.a(this).b(SelectMimeType.a()).c("date_modified DESC").b(new c6(this, gridAdapter));
        FragmentMediaSelectBinding fragmentMediaSelectBinding4 = this.j;
        if (fragmentMediaSelectBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentMediaSelectBinding2 = fragmentMediaSelectBinding4;
        }
        fragmentMediaSelectBinding2.b.setOnClickListener(new d6(this));
    }

    public final int H0() {
        int size = this.k.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (((LocalMedia) this.k.get(i2)).isChecked()) {
                i++;
            }
        }
        return i;
    }

    public final void L0(boolean z) {
        SavedStateHandle i;
        this.m.clear();
        NavController a2 = FragmentKt.a(this);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        if (z) {
            int size = this.l.size();
            while (i2 < size) {
                arrayList.add(((LocalMedia) this.l.get(i2)).getPath());
                i2++;
            }
        } else {
            int size2 = this.k.size();
            while (i2 < size2) {
                if (((LocalMedia) this.k.get(i2)).isChecked()) {
                    arrayList.add(((LocalMedia) this.k.get(i2)).getPath());
                    if (Intrinsics.areEqual((Object) ((LocalMedia) this.k.get(i2)).getMimeType(), (Object) "image/jpeg")) {
                        this.m.add(Uri.parse(((LocalMedia) this.k.get(i2)).getPath()));
                    } else if (Intrinsics.areEqual((Object) ((LocalMedia) this.k.get(i2)).getMimeType(), (Object) "video/mp4")) {
                        this.n.add(Uri.parse(((LocalMedia) this.k.get(i2)).getPath()));
                    }
                }
                i2++;
            }
        }
        NavBackStackEntry I = FragmentKt.a(this).I();
        if (!(I == null || (i = I.i()) == null)) {
            i.i("back_data", arrayList);
        }
        a2.V();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentMediaSelectBinding c = FragmentMediaSelectBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        return c.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        SavedStateHandle i;
        MutableLiveData e;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        ArrayList parcelableArrayList = arguments != null ? arguments.getParcelableArrayList("video_max_value") : null;
        Intrinsics.checkNotNull(parcelableArrayList);
        this.l = parcelableArrayList;
        NavBackStackEntry B = FragmentKt.a(this).B();
        if (!(B == null || (i = B.i()) == null || (e = i.e("back_data")) == null)) {
            e.observe(getViewLifecycleOwner(), new MediaSelectFragment$sam$androidx_lifecycle_Observer$0(new MediaSelectFragment$onViewCreated$1(this)));
        }
        initData();
        initView();
    }
}
