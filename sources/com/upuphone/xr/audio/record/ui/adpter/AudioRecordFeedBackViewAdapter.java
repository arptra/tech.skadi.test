package com.upuphone.xr.audio.record.ui.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.p7.a;
import com.honey.account.p7.b;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.audio.record.common.FeedBackType;
import com.upuphone.xr.sapp.audio.record.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nAudioRecordFeedBackViewAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioRecordFeedBackViewAdapter.kt\ncom/upuphone/xr/audio/record/ui/adpter/AudioRecordFeedBackViewAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,139:1\n1855#2,2:140\n1855#2,2:142\n*S KotlinDebug\n*F\n+ 1 AudioRecordFeedBackViewAdapter.kt\ncom/upuphone/xr/audio/record/ui/adpter/AudioRecordFeedBackViewAdapter\n*L\n67#1:140,2\n76#1:142,2\n*E\n"})
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 -2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003./0B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\r2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0018j\b\u0012\u0004\u0012\u00020\u0007`\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010 \u001a\u00020\r2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u0018j\b\u0012\u0004\u0012\u00020\u001e`\u0019¢\u0006\u0004\b \u0010!R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u00061"}, d2 = {"Lcom/upuphone/xr/audio/record/ui/adpter/AudioRecordFeedBackViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/upuphone/xr/audio/record/ui/adpter/AudioRecordFeedBackViewAdapter$FeedBackViewHolder;", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "j", "(Landroid/view/ViewGroup;I)Lcom/upuphone/xr/audio/record/ui/adpter/AudioRecordFeedBackViewAdapter$FeedBackViewHolder;", "holder", "position", "", "i", "(Lcom/upuphone/xr/audio/record/ui/adpter/AudioRecordFeedBackViewAdapter$FeedBackViewHolder;I)V", "getItemCount", "()I", "getItemViewType", "(I)I", "Lcom/upuphone/xr/audio/record/ui/adpter/AudioRecordFeedBackViewAdapter$ItemClickListener;", "listener", "l", "(Lcom/upuphone/xr/audio/record/ui/adpter/AudioRecordFeedBackViewAdapter$ItemClickListener;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "h", "()Ljava/util/ArrayList;", "k", "(I)V", "Lcom/upuphone/xr/audio/record/common/FeedBackType;", "list", "notifyData", "(Ljava/util/ArrayList;)V", "", "a", "Ljava/util/List;", "feedBackTypeList", "Landroid/content/Context;", "b", "Landroid/content/Context;", "mContext", "c", "Lcom/upuphone/xr/audio/record/ui/adpter/AudioRecordFeedBackViewAdapter$ItemClickListener;", "mListener", "d", "Companion", "FeedBackViewHolder", "ItemClickListener", "lib_audio_record_release"}, k = 1, mv = {1, 9, 0})
public final class AudioRecordFeedBackViewAdapter extends RecyclerView.Adapter<FeedBackViewHolder> {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public List f6563a = new ArrayList();
    public Context b;
    public ItemClickListener c;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/audio/record/ui/adpter/AudioRecordFeedBackViewAdapter$Companion;", "", "()V", "DELAY_SHOW_TIME", "", "TAG", "", "lib_audio_record_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/audio/record/ui/adpter/AudioRecordFeedBackViewAdapter$FeedBackViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/upuphone/xr/audio/record/ui/adpter/AudioRecordFeedBackViewAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "getIvSelect", "()Landroid/widget/ImageView;", "ivSelect", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getTvContent", "()Landroid/widget/TextView;", "tvContent", "lib_audio_record_release"}, k = 1, mv = {1, 9, 0})
    public final class FeedBackViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final ImageView f6564a;
        public final TextView b;
        public final /* synthetic */ AudioRecordFeedBackViewAdapter c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FeedBackViewHolder(AudioRecordFeedBackViewAdapter audioRecordFeedBackViewAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.c = audioRecordFeedBackViewAdapter;
            View findViewById = view.findViewById(R.id.iv_feed_back_type);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.f6564a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.tv_feed_back_type);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.b = (TextView) findViewById2;
            view.setOnClickListener(new a(audioRecordFeedBackViewAdapter, this));
            view.setOnLongClickListener(new b(audioRecordFeedBackViewAdapter, this));
        }

        public static final void c(AudioRecordFeedBackViewAdapter audioRecordFeedBackViewAdapter, FeedBackViewHolder feedBackViewHolder, View view) {
            Intrinsics.checkNotNullParameter(audioRecordFeedBackViewAdapter, "this$0");
            Intrinsics.checkNotNullParameter(feedBackViewHolder, "this$1");
            ItemClickListener g = audioRecordFeedBackViewAdapter.c;
            if (g != null) {
                g.onItemClick(feedBackViewHolder.getBindingAdapterPosition());
            }
        }

        public static final boolean d(AudioRecordFeedBackViewAdapter audioRecordFeedBackViewAdapter, FeedBackViewHolder feedBackViewHolder, View view) {
            Intrinsics.checkNotNullParameter(audioRecordFeedBackViewAdapter, "this$0");
            Intrinsics.checkNotNullParameter(feedBackViewHolder, "this$1");
            ItemClickListener g = audioRecordFeedBackViewAdapter.c;
            if (g == null) {
                return false;
            }
            g.onLongClick(feedBackViewHolder.getBindingAdapterPosition());
            return false;
        }

        public final ImageView getIvSelect() {
            return this.f6564a;
        }

        public final TextView getTvContent() {
            return this.b;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/audio/record/ui/adpter/AudioRecordFeedBackViewAdapter$ItemClickListener;", "", "", "position", "", "onItemClick", "(I)V", "onLongClick", "lib_audio_record_release"}, k = 1, mv = {1, 9, 0})
    public interface ItemClickListener {
        void onItemClick(int i);

        void onLongClick(int i);
    }

    public int getItemCount() {
        return this.f6563a.size();
    }

    public int getItemViewType(int i) {
        return i;
    }

    public final ArrayList h() {
        ArrayList arrayList = new ArrayList();
        for (FeedBackType feedBackType : this.f6563a) {
            if (feedBackType.a()) {
                arrayList.add(Integer.valueOf(feedBackType.b()));
            }
        }
        return arrayList;
    }

    /* renamed from: i */
    public void onBindViewHolder(FeedBackViewHolder feedBackViewHolder, int i) {
        Intrinsics.checkNotNullParameter(feedBackViewHolder, "holder");
        FeedBackType feedBackType = (FeedBackType) this.f6563a.get(i);
        feedBackViewHolder.getTvContent().setText(feedBackType.c());
        Context context = null;
        if (feedBackType.a()) {
            ImageView ivSelect = feedBackViewHolder.getIvSelect();
            Context context2 = this.b;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context2;
            }
            ivSelect.setImageDrawable(context.getDrawable(R.drawable.ic_feedback_selected));
            return;
        }
        ImageView ivSelect2 = feedBackViewHolder.getIvSelect();
        Context context3 = this.b;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context = context3;
        }
        ivSelect2.setImageDrawable(context.getDrawable(R.drawable.ic_feedback_no_select));
    }

    /* renamed from: j */
    public FeedBackViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.b = context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_audio_record_feed_back_type, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        return new FeedBackViewHolder(this, inflate);
    }

    public final void k(int i) {
        for (FeedBackType d2 : this.f6563a) {
            d2.d(false);
        }
        ((FeedBackType) this.f6563a.get(i)).d(true);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("FR-AudioRecordFeedBackViewAdapter", "updateSelectState,position = " + i + ",selectState true");
        notifyDataSetChanged();
    }

    public final void l(ItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.c = itemClickListener;
    }

    public final void notifyData(ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "list");
        this.f6563a = arrayList;
        notifyDataSetChanged();
    }
}
