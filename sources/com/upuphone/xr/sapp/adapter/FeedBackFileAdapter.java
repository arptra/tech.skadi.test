package com.upuphone.xr.sapp.adapter;

import android.content.ContentResolver;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.honey.account.c8.a;
import com.honey.account.c8.b;
import com.honey.account.c8.c;
import com.luck.picture.lib.utils.DateUtils;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.RoundCornerImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension({"SMAP\nFeedBackFileAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedBackFileAdapter.kt\ncom/upuphone/xr/sapp/adapter/FeedBackFileAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,112:1\n256#2,2:113\n*S KotlinDebug\n*F\n+ 1 FeedBackFileAdapter.kt\ncom/upuphone/xr/sapp/adapter/FeedBackFileAdapter\n*L\n59#1:113,2\n*E\n"})
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 52\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u000267B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u00020\u00122\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR*\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R?\u00100\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0012\u0018\u00010&8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R?\u00104\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0012\u0018\u00010&8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b1\u0010+\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/¨\u00068"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/FeedBackFileAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/upuphone/xr/sapp/adapter/FeedBackFileAdapter$ViewHolder;", "", "Lcom/upuphone/xr/sapp/adapter/FeedBackFile;", "dataArray", "<init>", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "o", "(Landroid/view/ViewGroup;I)Lcom/upuphone/xr/sapp/adapter/FeedBackFileAdapter$ViewHolder;", "getItemCount", "()I", "holder", "position", "", "k", "(Lcom/upuphone/xr/sapp/adapter/FeedBackFileAdapter$ViewHolder;I)V", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "", "j", "(Landroid/content/Context;Landroid/net/Uri;)J", "a", "Ljava/util/List;", "Lkotlin/Function0;", "b", "Lkotlin/jvm/functions/Function0;", "getOnAddClick", "()Lkotlin/jvm/functions/Function0;", "p", "(Lkotlin/jvm/functions/Function0;)V", "onAddClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "c", "Lkotlin/jvm/functions/Function1;", "getOnClickDel", "()Lkotlin/jvm/functions/Function1;", "q", "(Lkotlin/jvm/functions/Function1;)V", "onClickDel", "d", "getOnClickPreview", "r", "onClickPreview", "e", "Companion", "ViewHolder", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FeedBackFileAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final List f6605a;
    public Function0 b;
    public Function1 c;
    public Function1 d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/FeedBackFileAdapter$Companion;", "", "()V", "MAX_SIZE", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/FeedBackFileAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/upuphone/xr/sapp/adapter/FeedBackFileAdapter;Landroid/view/View;)V", "Lcom/upuphone/xr/sapp/view/RoundCornerImageView;", "a", "Lcom/upuphone/xr/sapp/view/RoundCornerImageView;", "()Lcom/upuphone/xr/sapp/view/RoundCornerImageView;", "setIcImg", "(Lcom/upuphone/xr/sapp/view/RoundCornerImageView;)V", "icImg", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setSelectImg", "(Landroid/widget/ImageView;)V", "selectImg", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "setTimeTv", "(Landroid/widget/TextView;)V", "timeTv", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public RoundCornerImageView f6606a;
        public ImageView b;
        public TextView c;
        public final /* synthetic */ FeedBackFileAdapter d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(FeedBackFileAdapter feedBackFileAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.d = feedBackFileAdapter;
            View findViewById = view.findViewById(R.id.img);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.f6606a = (RoundCornerImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.select_img);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.b = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.time_tv);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.c = (TextView) findViewById3;
        }

        public final RoundCornerImageView a() {
            return this.f6606a;
        }

        public final ImageView b() {
            return this.b;
        }

        public final TextView c() {
            return this.c;
        }
    }

    public FeedBackFileAdapter(List list) {
        Intrinsics.checkNotNullParameter(list, "dataArray");
        this.f6605a = list;
    }

    public static final void l(FeedBackFileAdapter feedBackFileAdapter, View view) {
        Intrinsics.checkNotNullParameter(feedBackFileAdapter, "this$0");
        Function0 function0 = feedBackFileAdapter.b;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void m(FeedBackFileAdapter feedBackFileAdapter, int i, View view) {
        Intrinsics.checkNotNullParameter(feedBackFileAdapter, "this$0");
        Function1 function1 = feedBackFileAdapter.c;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i));
        }
    }

    public static final void n(FeedBackFileAdapter feedBackFileAdapter, int i, View view) {
        Intrinsics.checkNotNullParameter(feedBackFileAdapter, "this$0");
        Function1 function1 = feedBackFileAdapter.d;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i));
        }
    }

    public int getItemCount() {
        int size = this.f6605a.size();
        int size2 = this.f6605a.size();
        return size < 9 ? size2 + 1 : size2;
    }

    public final long j(Context context, Uri uri) {
        Long longOrNull;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        long j = 0;
        try {
            mediaMetadataRetriever.setDataSource(context, uri);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (!(extractMetadata == null || (longOrNull = StringsKt.toLongOrNull(extractMetadata)) == null)) {
                j = longOrNull.longValue();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
        mediaMetadataRetriever.release();
        return j;
    }

    /* renamed from: k */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        int i2 = 8;
        if (this.f6605a.size() >= 9 || i != this.f6605a.size()) {
            FeedBackFile feedBackFile = (FeedBackFile) this.f6605a.get(i);
            ContentResolver contentResolver = viewHolder.itemView.getContext().getContentResolver();
            Uri a2 = feedBackFile.a();
            Intrinsics.checkNotNull(a2);
            String type = contentResolver.getType(a2);
            if (type == null) {
                type = "";
            }
            ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.t(viewHolder.itemView.getContext()).q(feedBackFile.a()).d()).V(R.color.default_img)).h(DiskCacheStrategy.e)).z0(viewHolder.a());
            TextView c2 = viewHolder.c();
            if (StringsKt.startsWith$default(type, "video/", false, 2, (Object) null)) {
                i2 = 0;
            }
            c2.setVisibility(i2);
            viewHolder.b().setVisibility(0);
            viewHolder.b().setOnClickListener(new b(this, i));
            viewHolder.itemView.setOnClickListener(new c(this, i));
            if (StringsKt.startsWith$default(type, "video/", false, 2, (Object) null)) {
                TextView c3 = viewHolder.c();
                Context context = viewHolder.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                Uri a3 = feedBackFile.a();
                Intrinsics.checkNotNull(a3);
                c3.setText(DateUtils.b(j(context, a3)));
                return;
            }
            return;
        }
        viewHolder.a().setImageResource(R.drawable.ic_feedback_default);
        viewHolder.b().setVisibility(8);
        viewHolder.c().setVisibility(8);
        viewHolder.itemView.setOnClickListener(new a(this));
    }

    /* renamed from: o */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feedback_video_item_layout, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        return new ViewHolder(this, inflate);
    }

    public final void p(Function0 function0) {
        this.b = function0;
    }

    public final void q(Function1 function1) {
        this.c = function1;
    }

    public final void r(Function1 function1) {
        this.d = function1;
    }
}
