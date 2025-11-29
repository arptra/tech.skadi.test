package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.honey.account.h8.g6;
import com.honey.account.h8.h6;
import com.honey.account.h8.i6;
import com.honey.account.h8.j6;
import com.honey.account.h8.k6;
import com.honey.account.h8.l6;
import com.honey.account.h8.m6;
import com.honey.account.h8.n6;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.meizu.common.fastscrollletter.FastScrollLetterCursorColumn;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentMediaShowListBinding;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002./B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u001c\u0010&\u001a\b\u0018\u00010#R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001fR\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u00060"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/MediaShowListFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "H0", "Lcom/upuphone/xr/sapp/databinding/FragmentMediaShowListBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentMediaShowListBinding;", "binding", "Ljava/util/ArrayList;", "Lcom/luck/picture/lib/entity/LocalMedia;", "Lkotlin/collections/ArrayList;", "k", "Ljava/util/ArrayList;", "mData", "", "l", "I", "count", "m", "dataIndex", "Lcom/upuphone/xr/sapp/fragment/MediaShowListFragment$MediaShowAdapter;", "n", "Lcom/upuphone/xr/sapp/fragment/MediaShowListFragment$MediaShowAdapter;", "mAdapter", "o", "mSelectIndex", "", "p", "Z", "mIsShow", "q", "Companion", "MediaShowAdapter", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nMediaShowListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaShowListFragment.kt\ncom/upuphone/xr/sapp/fragment/MediaShowListFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,231:1\n1#2:232\n*E\n"})
public final class MediaShowListFragment extends BaseFragment {
    public static final Companion q = new Companion((DefaultConstructorMarker) null);
    public FragmentMediaShowListBinding j;
    public ArrayList k = new ArrayList();
    public int l;
    public int m = -1;
    public MediaShowAdapter n;
    public int o;
    public boolean p = true;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/MediaShowListFragment$Companion;", "", "()V", "MAX_IMG_HEIGHT", "", "MAX_IMG_WIDTH", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @SourceDebugExtension({"SMAP\nMediaShowListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaShowListFragment.kt\ncom/upuphone/xr/sapp/fragment/MediaShowListFragment$MediaShowAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,231:1\n254#2,4:232\n254#2,4:236\n*S KotlinDebug\n*F\n+ 1 MediaShowListFragment.kt\ncom/upuphone/xr/sapp/fragment/MediaShowListFragment$MediaShowAdapter\n*L\n154#1:232,4\n158#1:236,4\n*E\n"})
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/MediaShowListFragment$MediaShowAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lcom/luck/picture/lib/entity/LocalMedia;", "Lkotlin/collections/ArrayList;", "mData", "<init>", "(Lcom/upuphone/xr/sapp/fragment/MediaShowListFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "Landroid/view/ViewGroup;", "container", "", "position", "", "instantiateItem", "(Landroid/view/ViewGroup;I)Ljava/lang/Object;", "getCount", "()I", "object", "", "destroyItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "Landroid/view/View;", "view", "o", "", "isViewFromObject", "(Landroid/view/View;Ljava/lang/Object;)Z", "f", "()V", "a", "Landroid/content/Context;", "b", "Ljava/util/ArrayList;", "Landroid/widget/VideoView;", "c", "Landroid/widget/VideoView;", "mVideoPlayer", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "mPlayImg", "", "e", "Ljava/lang/String;", "mUrl", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class MediaShowAdapter extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final Context f6980a;
        public final ArrayList b;
        public VideoView c;
        public ImageView d;
        public String e = "";
        public final /* synthetic */ MediaShowListFragment f;

        public MediaShowAdapter(MediaShowListFragment mediaShowListFragment, Context context, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(arrayList, "mData");
            this.f = mediaShowListFragment;
            this.f6980a = context;
            this.b = arrayList;
        }

        public static final void g(MediaShowListFragment mediaShowListFragment, View view) {
            Intrinsics.checkNotNullParameter(mediaShowListFragment, "this$0");
            FragmentMediaShowListBinding D0 = mediaShowListFragment.j;
            FragmentMediaShowListBinding fragmentMediaShowListBinding = null;
            if (D0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                D0 = null;
            }
            RelativeLayout relativeLayout = D0.e;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "titlebarLayout");
            FragmentMediaShowListBinding D02 = mediaShowListFragment.j;
            if (D02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentMediaShowListBinding = D02;
            }
            RelativeLayout relativeLayout2 = fragmentMediaShowListBinding.e;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "titlebarLayout");
            int i = 0;
            if (!(!(relativeLayout2.getVisibility() == 0))) {
                i = 8;
            }
            relativeLayout.setVisibility(i);
        }

        public static final void h(MediaShowListFragment mediaShowListFragment, View view) {
            Intrinsics.checkNotNullParameter(mediaShowListFragment, "this$0");
            FragmentMediaShowListBinding D0 = mediaShowListFragment.j;
            FragmentMediaShowListBinding fragmentMediaShowListBinding = null;
            if (D0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                D0 = null;
            }
            RelativeLayout relativeLayout = D0.e;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "titlebarLayout");
            FragmentMediaShowListBinding D02 = mediaShowListFragment.j;
            if (D02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentMediaShowListBinding = D02;
            }
            RelativeLayout relativeLayout2 = fragmentMediaShowListBinding.e;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "titlebarLayout");
            int i = 0;
            if (!(!(relativeLayout2.getVisibility() == 0))) {
                i = 8;
            }
            relativeLayout.setVisibility(i);
        }

        public static final void i(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, MediaShowAdapter mediaShowAdapter, LocalMedia localMedia, View view) {
            Intrinsics.checkNotNullParameter(objectRef, "$largeImg");
            Intrinsics.checkNotNullParameter(objectRef2, "$playImg");
            Intrinsics.checkNotNullParameter(objectRef3, "$videoPlayer");
            Intrinsics.checkNotNullParameter(mediaShowAdapter, "this$0");
            Intrinsics.checkNotNullParameter(localMedia, "$media");
            ((ImageView) objectRef.element).setVisibility(8);
            ((ImageView) objectRef2.element).setVisibility(8);
            ((VideoView) objectRef3.element).setVisibility(0);
            ((VideoView) objectRef3.element).start();
            mediaShowAdapter.c = (VideoView) objectRef3.element;
            mediaShowAdapter.d = (ImageView) objectRef2.element;
            String path = localMedia.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            mediaShowAdapter.e = path;
        }

        public static final void j(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, MediaPlayer mediaPlayer) {
            Intrinsics.checkNotNullParameter(objectRef, "$largeImg");
            Intrinsics.checkNotNullParameter(objectRef2, "$playImg");
            Intrinsics.checkNotNullParameter(objectRef3, "$videoPlayer");
            ((ImageView) objectRef.element).setVisibility(0);
            ((ImageView) objectRef2.element).setVisibility(0);
            ((VideoView) objectRef3.element).setVisibility(8);
        }

        public static final void k(Ref.ObjectRef objectRef, LocalMedia localMedia, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, View view) {
            Intrinsics.checkNotNullParameter(objectRef, "$videoPlayer");
            Intrinsics.checkNotNullParameter(localMedia, "$media");
            Intrinsics.checkNotNullParameter(objectRef2, "$playImg");
            Intrinsics.checkNotNullParameter(objectRef3, "$largeImg");
            ((VideoView) objectRef.element).stopPlayback();
            ((VideoView) objectRef.element).setVideoURI(Uri.parse(localMedia.getPath()));
            ((ImageView) objectRef2.element).setVisibility(0);
            ((ImageView) objectRef3.element).setVisibility(0);
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            Intrinsics.checkNotNullParameter(obj, "object");
            viewGroup.removeView((View) obj);
        }

        public final void f() {
            VideoView videoView = this.c;
            if (videoView != null) {
                videoView.stopPlayback();
            }
            ImageView imageView = this.d;
            if (imageView != null) {
                Intrinsics.checkNotNull(imageView);
                imageView.setVisibility(0);
            }
            VideoView videoView2 = this.c;
            if (videoView2 != null) {
                videoView2.setVideoURI(Uri.parse(this.e));
            }
        }

        public int getCount() {
            return this.b.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            View inflate = LayoutInflater.from(this.f6980a).inflate(R.layout.item_media_show, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            T findViewById = inflate.findViewById(R.id.video_player);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.VideoView");
            T t = (VideoView) findViewById;
            objectRef.element = t;
            t.setOnClickListener(new j6(this.f));
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            T findViewById2 = inflate.findViewById(R.id.large_img);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
            T t2 = (ImageView) findViewById2;
            objectRef2.element = t2;
            t2.setOnClickListener(new k6(this.f));
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            T findViewById3 = inflate.findViewById(R.id.play_img);
            Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
            objectRef3.element = (ImageView) findViewById3;
            Object obj = this.b.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            LocalMedia localMedia = (LocalMedia) obj;
            if (PictureMimeType.i(localMedia.getMimeType())) {
                ((ImageView) objectRef3.element).setVisibility(0);
                ((VideoView) objectRef.element).setVideoURI(Uri.parse(localMedia.getPath()));
                ((VideoView) objectRef.element).stopPlayback();
            } else {
                ((ImageView) objectRef3.element).setVisibility(8);
            }
            Context context = this.f6980a;
            if (context != null) {
                MediaShowListFragment mediaShowListFragment = this.f;
                int i2 = mediaShowListFragment.getResources().getDisplayMetrics().widthPixels;
                int i3 = mediaShowListFragment.getResources().getDisplayMetrics().heightPixels;
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("MediaShowListFragment", "instantiateItem width=" + i2 + " height=" + i3);
                MediaShowListFragment$MediaShowAdapter$instantiateItem$3$1 mediaShowListFragment$MediaShowAdapter$instantiateItem$3$1 = (MediaShowListFragment$MediaShowAdapter$instantiateItem$3$1) ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.t(context).f().D0(localMedia.getAvailablePath()).V(R.color.default_img)).j()).U(i2, i3)).w0(new MediaShowListFragment$MediaShowAdapter$instantiateItem$3$1(objectRef2));
            }
            ((ImageView) objectRef3.element).setOnClickListener(new l6(objectRef2, objectRef3, objectRef, this, localMedia));
            ((VideoView) objectRef.element).setOnCompletionListener(new m6(objectRef2, objectRef3, objectRef));
            ((VideoView) objectRef.element).setOnClickListener(new n6(objectRef, localMedia, objectRef3, objectRef2));
            viewGroup.addView(inflate);
            return inflate;
        }

        public boolean isViewFromObject(View view, Object obj) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(obj, "o");
            return view == obj;
        }
    }

    public static final void I0(MediaShowListFragment mediaShowListFragment, View view) {
        Intrinsics.checkNotNullParameter(mediaShowListFragment, "this$0");
        MediaShowAdapter mediaShowAdapter = mediaShowListFragment.n;
        Intrinsics.checkNotNull(mediaShowAdapter);
        mediaShowAdapter.f();
        StaticMethodUtilsKt.q(mediaShowListFragment);
    }

    public static final void J0(MediaShowListFragment mediaShowListFragment, View view) {
        Intrinsics.checkNotNullParameter(mediaShowListFragment, "this$0");
        MediaShowAdapter mediaShowAdapter = mediaShowListFragment.n;
        Intrinsics.checkNotNull(mediaShowAdapter);
        mediaShowAdapter.f();
        StaticMethodUtilsKt.q(mediaShowListFragment);
    }

    public static final void K0(MediaShowListFragment mediaShowListFragment, View view) {
        Intrinsics.checkNotNullParameter(mediaShowListFragment, "this$0");
        FragmentMediaShowListBinding fragmentMediaShowListBinding = null;
        if (((LocalMedia) mediaShowListFragment.k.get(mediaShowListFragment.o)).isChecked()) {
            mediaShowListFragment.l--;
            FragmentMediaShowListBinding fragmentMediaShowListBinding2 = mediaShowListFragment.j;
            if (fragmentMediaShowListBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMediaShowListBinding2 = null;
            }
            fragmentMediaShowListBinding2.c.setText(mediaShowListFragment.getString(R.string.done) + "（" + mediaShowListFragment.l + "/9）");
            ((LocalMedia) mediaShowListFragment.k.get(mediaShowListFragment.o)).setChecked(((LocalMedia) mediaShowListFragment.k.get(mediaShowListFragment.o)).isChecked() ^ true);
            FragmentMediaShowListBinding fragmentMediaShowListBinding3 = mediaShowListFragment.j;
            if (fragmentMediaShowListBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentMediaShowListBinding = fragmentMediaShowListBinding3;
            }
            fragmentMediaShowListBinding.d.setSelected(false);
            return;
        }
        int i = mediaShowListFragment.l;
        if (i < 9) {
            mediaShowListFragment.l = i + 1;
            FragmentMediaShowListBinding fragmentMediaShowListBinding4 = mediaShowListFragment.j;
            if (fragmentMediaShowListBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMediaShowListBinding4 = null;
            }
            fragmentMediaShowListBinding4.c.setText(mediaShowListFragment.getString(R.string.done) + "（" + mediaShowListFragment.l + "/9）");
            ((LocalMedia) mediaShowListFragment.k.get(mediaShowListFragment.o)).setChecked(((LocalMedia) mediaShowListFragment.k.get(mediaShowListFragment.o)).isChecked() ^ true);
            FragmentMediaShowListBinding fragmentMediaShowListBinding5 = mediaShowListFragment.j;
            if (fragmentMediaShowListBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentMediaShowListBinding = fragmentMediaShowListBinding5;
            }
            fragmentMediaShowListBinding.d.setSelected(true);
            return;
        }
        Context context = mediaShowListFragment.getContext();
        if (context != null) {
            UToast.Companion companion = UToast.f6444a;
            String string = mediaShowListFragment.getString(R.string.max_9);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(context, string);
        }
    }

    private final void initView() {
        ULog.f6446a.a("MediaShowListFragment", "initView");
        FragmentMediaShowListBinding fragmentMediaShowListBinding = null;
        if (this.p) {
            FragmentMediaShowListBinding fragmentMediaShowListBinding2 = this.j;
            if (fragmentMediaShowListBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMediaShowListBinding2 = null;
            }
            fragmentMediaShowListBinding2.d.setVisibility(8);
            FragmentMediaShowListBinding fragmentMediaShowListBinding3 = this.j;
            if (fragmentMediaShowListBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMediaShowListBinding3 = null;
            }
            fragmentMediaShowListBinding3.c.setVisibility(8);
        } else {
            FragmentMediaShowListBinding fragmentMediaShowListBinding4 = this.j;
            if (fragmentMediaShowListBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMediaShowListBinding4 = null;
            }
            fragmentMediaShowListBinding4.d.setVisibility(0);
            FragmentMediaShowListBinding fragmentMediaShowListBinding5 = this.j;
            if (fragmentMediaShowListBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMediaShowListBinding5 = null;
            }
            fragmentMediaShowListBinding5.c.setVisibility(0);
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.n = new MediaShowAdapter(this, requireContext, this.k);
        FragmentMediaShowListBinding fragmentMediaShowListBinding6 = this.j;
        if (fragmentMediaShowListBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaShowListBinding6 = null;
        }
        fragmentMediaShowListBinding6.f.setAdapter(this.n);
        FragmentMediaShowListBinding fragmentMediaShowListBinding7 = this.j;
        if (fragmentMediaShowListBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaShowListBinding7 = null;
        }
        fragmentMediaShowListBinding7.b.setOnClickListener(new g6(this));
        FragmentMediaShowListBinding fragmentMediaShowListBinding8 = this.j;
        if (fragmentMediaShowListBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaShowListBinding8 = null;
        }
        fragmentMediaShowListBinding8.c.setOnClickListener(new h6(this));
        FragmentMediaShowListBinding fragmentMediaShowListBinding9 = this.j;
        if (fragmentMediaShowListBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaShowListBinding9 = null;
        }
        fragmentMediaShowListBinding9.f.addOnPageChangeListener(new MediaShowListFragment$initView$3(this));
        FragmentMediaShowListBinding fragmentMediaShowListBinding10 = this.j;
        if (fragmentMediaShowListBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaShowListBinding10 = null;
        }
        fragmentMediaShowListBinding10.f.setCurrentItem(this.m);
        FragmentMediaShowListBinding fragmentMediaShowListBinding11 = this.j;
        if (fragmentMediaShowListBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaShowListBinding11 = null;
        }
        fragmentMediaShowListBinding11.d.setOnClickListener(new i6(this));
        FragmentMediaShowListBinding fragmentMediaShowListBinding12 = this.j;
        if (fragmentMediaShowListBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentMediaShowListBinding = fragmentMediaShowListBinding12;
        }
        fragmentMediaShowListBinding.c.setText(getString(R.string.done) + "（" + this.l + "/9）");
    }

    public final void H0() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.k;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                String fileName = ((LocalMedia) this.k.get(i)).getFileName();
                if (fileName == null || StringsKt.isBlank(fileName)) {
                    arrayList.add(this.k.get(i));
                }
            }
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.k.remove(arrayList.get(i2));
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentMediaShowListBinding c = FragmentMediaShowListBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        return c.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        Boolean bool = null;
        ArrayList parcelableArrayList = arguments != null ? arguments.getParcelableArrayList("data") : null;
        Intrinsics.checkNotNull(parcelableArrayList);
        this.k = parcelableArrayList;
        Bundle arguments2 = getArguments();
        Integer valueOf = arguments2 != null ? Integer.valueOf(arguments2.getInt("data_account")) : null;
        Intrinsics.checkNotNull(valueOf);
        this.l = valueOf.intValue();
        Bundle arguments3 = getArguments();
        Integer valueOf2 = arguments3 != null ? Integer.valueOf(arguments3.getInt(FastScrollLetterCursorColumn.DATA_INDEX)) : null;
        Intrinsics.checkNotNull(valueOf2);
        this.m = valueOf2.intValue();
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            bool = Boolean.valueOf(arguments4.getBoolean("show_key"));
        }
        Intrinsics.checkNotNull(bool);
        this.p = bool.booleanValue();
        this.o = this.m;
        H0();
        initView();
    }
}
