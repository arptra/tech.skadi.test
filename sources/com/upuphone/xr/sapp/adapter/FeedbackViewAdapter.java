package com.upuphone.xr.sapp.adapter;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.c8.e;
import com.honey.account.c8.f;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 +2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003,-.B\u001f\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0012\u001a\u00020\u00112\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b!\u0010\"R$\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006/"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/FeedbackViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/upuphone/xr/sapp/adapter/FeedbackViewAdapter$FeedbackViewHolder;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "itemList", "<init>", "(Ljava/util/ArrayList;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "k", "(Landroid/view/ViewGroup;I)Lcom/upuphone/xr/sapp/adapter/FeedbackViewAdapter$FeedbackViewHolder;", "holder", "position", "", "j", "(Lcom/upuphone/xr/sapp/adapter/FeedbackViewAdapter$FeedbackViewHolder;I)V", "getItemCount", "()I", "Lcom/upuphone/xr/sapp/adapter/FeedbackViewAdapter$ItemClickListener;", "listener", "l", "(Lcom/upuphone/xr/sapp/adapter/FeedbackViewAdapter$ItemClickListener;)V", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "h", "(Landroid/content/Context;Landroid/net/Uri;)I", "Landroid/graphics/Bitmap;", "i", "(Landroid/content/Context;Landroid/net/Uri;)Landroid/graphics/Bitmap;", "a", "Ljava/util/ArrayList;", "b", "Landroid/content/Context;", "mContext", "c", "Lcom/upuphone/xr/sapp/adapter/FeedbackViewAdapter$ItemClickListener;", "mListener", "d", "Companion", "FeedbackViewHolder", "ItemClickListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FeedbackViewAdapter extends RecyclerView.Adapter<FeedbackViewHolder> {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f6609a;
    public Context b;
    public ItemClickListener c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/FeedbackViewAdapter$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/FeedbackViewAdapter$FeedbackViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/upuphone/xr/sapp/adapter/FeedbackViewAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "f", "()Landroid/widget/ImageView;", "imageView", "b", "e", "delView", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class FeedbackViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final ImageView f6610a;
        public final ImageView b;
        public final /* synthetic */ FeedbackViewAdapter c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FeedbackViewHolder(FeedbackViewAdapter feedbackViewAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.c = feedbackViewAdapter;
            View findViewById = view.findViewById(R.id.screenshot);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            ImageView imageView = (ImageView) findViewById;
            this.f6610a = imageView;
            View findViewById2 = view.findViewById(R.id.delView);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            ImageView imageView2 = (ImageView) findViewById2;
            this.b = imageView2;
            imageView.setOnClickListener(new e(feedbackViewAdapter, this));
            imageView2.setOnClickListener(new f(feedbackViewAdapter, this));
        }

        public static final void c(FeedbackViewAdapter feedbackViewAdapter, FeedbackViewHolder feedbackViewHolder, View view) {
            Intrinsics.checkNotNullParameter(feedbackViewAdapter, "this$0");
            Intrinsics.checkNotNullParameter(feedbackViewHolder, "this$1");
            ItemClickListener g = feedbackViewAdapter.c;
            if (g == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListener");
                g = null;
            }
            g.a(feedbackViewHolder.getAdapterPosition());
        }

        public static final void d(FeedbackViewAdapter feedbackViewAdapter, FeedbackViewHolder feedbackViewHolder, View view) {
            Intrinsics.checkNotNullParameter(feedbackViewAdapter, "this$0");
            Intrinsics.checkNotNullParameter(feedbackViewHolder, "this$1");
            ItemClickListener g = feedbackViewAdapter.c;
            if (g == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListener");
                g = null;
            }
            g.b(feedbackViewHolder.getAdapterPosition());
        }

        public final ImageView e() {
            return this.b;
        }

        public final ImageView f() {
            return this.f6610a;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/FeedbackViewAdapter$ItemClickListener;", "", "", "position", "", "b", "(I)V", "a", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface ItemClickListener {
        void a(int i);

        void b(int i);
    }

    public FeedbackViewAdapter(ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "itemList");
        this.f6609a = arrayList;
    }

    public int getItemCount() {
        return this.f6609a.size();
    }

    public final int h(Context context, Uri uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        ContentResolver contentResolver = context.getContentResolver();
        BitmapFactory.decodeStream(contentResolver != null ? contentResolver.openInputStream(uri) : null, (Rect) null, options);
        int i = options.outWidth;
        int i2 = options.outHeight;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AppFragment", "picWidth: " + i + ", picHeight: " + i2);
        if (i2 > 500 || i > 500) {
            return ((i2 / 500) + (i / 500)) / 2;
        }
        return 1;
    }

    public final Bitmap i(Context context, Uri uri) {
        int h = h(context, uri);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = h;
        ContentResolver contentResolver = context.getContentResolver();
        return BitmapFactory.decodeStream(contentResolver != null ? contentResolver.openInputStream(uri) : null, (Rect) null, options);
    }

    /* renamed from: j */
    public void onBindViewHolder(FeedbackViewHolder feedbackViewHolder, int i) {
        Intrinsics.checkNotNullParameter(feedbackViewHolder, "holder");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("FeedbackViewAdapter", "onBindViewHolder begin");
        Object obj = this.f6609a.get(i);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        String str = (String) obj;
        if (str.equals("addScreenshotPic")) {
            feedbackViewHolder.f().setImageResource(R.drawable.add_screenshot);
            feedbackViewHolder.e().setVisibility(8);
        } else {
            delegate.g("FeedbackViewAdapter", "compress begin");
            Context context = this.b;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            Bitmap i2 = i(context, parse);
            delegate.g("FeedbackViewAdapter", "compress end");
            feedbackViewHolder.f().setImageBitmap(i2);
        }
        delegate.a("FeedbackViewAdapter", "onBindViewHolder end");
    }

    /* renamed from: k */
    public FeedbackViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.b = context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.feedback_screenshot, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        return new FeedbackViewHolder(this, inflate);
    }

    public final void l(ItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.c = itemClickListener;
    }
}
