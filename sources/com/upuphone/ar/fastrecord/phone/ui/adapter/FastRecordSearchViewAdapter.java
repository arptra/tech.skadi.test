package com.upuphone.ar.fastrecord.phone.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.v3.d;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.db.RecordContentTagEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.widget.labels.RecordSingleLineTagView;
import com.upuphone.ar.fastrecord.phone.utils.RecordDateUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordSearchViewAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordSearchViewAdapter.kt\ncom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordSearchViewAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,158:1\n262#2,2:159\n262#2,2:161\n262#2,2:163\n262#2,2:165\n262#2,2:167\n1855#3,2:169\n*S KotlinDebug\n*F\n+ 1 FastRecordSearchViewAdapter.kt\ncom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordSearchViewAdapter\n*L\n63#1:159,2\n64#1:161,2\n66#1:163,2\n67#1:165,2\n83#1:167,2\n85#1:169,2\n*E\n"})
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003\u001e\u001f B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\nJ\u001e\u0010\u0012\u001a\u00020\u00102\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0014j\b\u0012\u0004\u0012\u00020\n`\u0015J\u001c\u0010\u0016\u001a\u00020\u00102\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\fH\u0017J\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordSearchViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordSearchViewAdapter$FastRecordViewHolder;", "()V", "mContext", "Landroid/content/Context;", "mListener", "Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordSearchViewAdapter$ItemClickListener;", "modelList", "", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "getItemCount", "", "getPositionData", "position", "notifyItemDataChange", "", "model", "notifyRecordData", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemListener", "listener", "Companion", "FastRecordViewHolder", "ItemClickListener", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordSearchViewAdapter extends RecyclerView.Adapter<FastRecordViewHolder> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "FastRecordViewAdapter";
    @NotNull
    public static final String TIME_FORMAT = "HH:mm:ss";
    @NotNull
    public static final String TIME_FORMAT_TWO = "H:mm:ss";
    private Context mContext;
    /* access modifiers changed from: private */
    @Nullable
    public ItemClickListener mListener;
    @NotNull
    private List<RecordEntity> modelList = new ArrayList();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordSearchViewAdapter$Companion;", "", "()V", "TAG", "", "TIME_FORMAT", "TIME_FORMAT_TWO", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordSearchViewAdapter$FastRecordViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordSearchViewAdapter;Landroid/view/View;)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "labelsView", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/labels/RecordSingleLineTagView;", "getLabelsView", "()Lcom/upuphone/ar/fastrecord/phone/ui/widget/labels/RecordSingleLineTagView;", "locationTv", "getLocationTv", "recordCreateTimeTv", "getRecordCreateTimeTv", "recordTimeTv", "getRecordTimeTv", "recordTitleTv", "getRecordTitleTv", "splitIv", "Landroid/widget/ImageView;", "getSplitIv", "()Landroid/widget/ImageView;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class FastRecordViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final TextView contentTv;
        @NotNull
        private final RecordSingleLineTagView labelsView;
        @NotNull
        private final TextView locationTv;
        @NotNull
        private final TextView recordCreateTimeTv;
        @NotNull
        private final TextView recordTimeTv;
        @NotNull
        private final TextView recordTitleTv;
        @NotNull
        private final ImageView splitIv;
        final /* synthetic */ FastRecordSearchViewAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FastRecordViewHolder(@NotNull FastRecordSearchViewAdapter fastRecordSearchViewAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = fastRecordSearchViewAdapter;
            View findViewById = view.findViewById(R.id.tv_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.recordTitleTv = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.tv_content);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.contentTv = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.tv_record_time);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.recordTimeTv = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.tv_location);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.locationTv = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.iv_split);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.splitIv = (ImageView) findViewById5;
            View findViewById6 = view.findViewById(R.id.tv_record_create_time);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.recordCreateTimeTv = (TextView) findViewById6;
            View findViewById7 = view.findViewById(R.id.labels);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
            this.labelsView = (RecordSingleLineTagView) findViewById7;
            view.setOnClickListener(new d(fastRecordSearchViewAdapter, this));
        }

        /* access modifiers changed from: private */
        public static final void _init_$lambda$0(FastRecordSearchViewAdapter fastRecordSearchViewAdapter, FastRecordViewHolder fastRecordViewHolder, View view) {
            Intrinsics.checkNotNullParameter(fastRecordSearchViewAdapter, "this$0");
            Intrinsics.checkNotNullParameter(fastRecordViewHolder, "this$1");
            ItemClickListener access$getMListener$p = fastRecordSearchViewAdapter.mListener;
            if (access$getMListener$p != null) {
                access$getMListener$p.onItemClick(fastRecordViewHolder.getBindingAdapterPosition());
            }
        }

        @NotNull
        public final TextView getContentTv() {
            return this.contentTv;
        }

        @NotNull
        public final RecordSingleLineTagView getLabelsView() {
            return this.labelsView;
        }

        @NotNull
        public final TextView getLocationTv() {
            return this.locationTv;
        }

        @NotNull
        public final TextView getRecordCreateTimeTv() {
            return this.recordCreateTimeTv;
        }

        @NotNull
        public final TextView getRecordTimeTv() {
            return this.recordTimeTv;
        }

        @NotNull
        public final TextView getRecordTitleTv() {
            return this.recordTitleTv;
        }

        @NotNull
        public final ImageView getSplitIv() {
            return this.splitIv;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordSearchViewAdapter$ItemClickListener;", "", "onItemClick", "", "position", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface ItemClickListener {
        void onItemClick(int i);
    }

    public int getItemCount() {
        return this.modelList.size();
    }

    @NotNull
    public final RecordEntity getPositionData(int i) {
        return this.modelList.get(i);
    }

    public final void notifyItemDataChange(int i, @NotNull RecordEntity recordEntity) {
        Intrinsics.checkNotNullParameter(recordEntity, "model");
        this.modelList.set(i, recordEntity);
        notifyItemChanged(i);
    }

    public final void notifyRecordData(@NotNull ArrayList<RecordEntity> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "list");
        this.modelList = arrayList;
        notifyDataSetChanged();
    }

    public final void setItemListener(@NotNull ItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener = itemClickListener;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void onBindViewHolder(@NotNull FastRecordViewHolder fastRecordViewHolder, int i) {
        Intrinsics.checkNotNullParameter(fastRecordViewHolder, "holder");
        LogExt.logD("onBindViewHolder begin modelList[position] downloading = " + this.modelList.get(i).isDownloading(), "FastRecordViewAdapter");
        RecordEntity recordEntity = this.modelList.get(i);
        TextView contentTv = fastRecordViewHolder.getContentTv();
        Context context = this.mContext;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        contentTv.setTextColor(context.getColor(R.color.fast_record_content_color));
        String shortHandText = recordEntity.getShortHandText();
        if (shortHandText == null) {
            shortHandText = StringsKt.trim((CharSequence) "").toString();
        }
        if (TextUtils.isEmpty(shortHandText)) {
            TextView contentTv2 = fastRecordViewHolder.getContentTv();
            Context context3 = this.mContext;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context3 = null;
            }
            contentTv2.setText(context3.getText(R.string.fast_record_no_content));
            TextView contentTv3 = fastRecordViewHolder.getContentTv();
            Context context4 = this.mContext;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context4 = null;
            }
            contentTv3.setTextColor(context4.getColor(R.color.fast_record_hint));
        } else {
            fastRecordViewHolder.getContentTv().setText(recordEntity.getShortHandText());
        }
        fastRecordViewHolder.getLocationTv().setText(recordEntity.getLocationShort());
        LogExt.logW("record.locationShort = " + recordEntity.getLocationShort(), "FastRecordViewAdapter");
        int i2 = 8;
        if (!TextUtils.isEmpty(recordEntity.getLocationShort())) {
            fastRecordViewHolder.getLocationTv().setVisibility(0);
            fastRecordViewHolder.getSplitIv().setVisibility(0);
        } else {
            fastRecordViewHolder.getLocationTv().setVisibility(8);
            fastRecordViewHolder.getSplitIv().setVisibility(8);
        }
        LogExt.logE("time = " + recordEntity.getCreateTime() + ",title = " + recordEntity.getShortHandTitle(), "FastRecordViewAdapter");
        TextView recordTimeTv = fastRecordViewHolder.getRecordTimeTv();
        Context context5 = this.mContext;
        if (context5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context2 = context5;
        }
        recordTimeTv.setTextColor(ContextCompat.getColor(context2, R.color.fast_record_time_size_color));
        fastRecordViewHolder.getRecordTitleTv().setText(recordEntity.getShortHandTitle());
        TextView recordCreateTimeTv = fastRecordViewHolder.getRecordCreateTimeTv();
        RecordDateUtil recordDateUtil = RecordDateUtil.INSTANCE;
        recordCreateTimeTv.setText(recordDateUtil.formatRecordDate(recordEntity.getCreateTime()));
        fastRecordViewHolder.getRecordCreateTimeTv().requestLayout();
        fastRecordViewHolder.getRecordTimeTv().setText(recordDateUtil.getDateToString(recordEntity.getTotalTime(), "H:mm:ss"));
        fastRecordViewHolder.getRecordTimeTv().requestLayout();
        LogExt.logD("onBindViewHolder end", "FastRecordViewAdapter");
        RecordSingleLineTagView labelsView = fastRecordViewHolder.getLabelsView();
        if (!recordEntity.getTagBeanList().isEmpty()) {
            i2 = 0;
        }
        labelsView.setVisibility(i2);
        RecordSingleLineTagView labelsView2 = fastRecordViewHolder.getLabelsView();
        ArrayList arrayList = new ArrayList();
        for (RecordContentTagEntity contentName : recordEntity.getTagBeanList()) {
            String contentName2 = contentName.getContentName();
            if (!TextUtils.isEmpty(contentName2)) {
                if (contentName2 == null) {
                    contentName2 = "";
                }
                arrayList.add(contentName2);
            }
        }
        labelsView2.setTags(arrayList);
        fastRecordViewHolder.getLabelsView().requestLayout();
    }

    @NotNull
    public FastRecordViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.mContext = context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.fast_record_search_item_info, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        return new FastRecordViewHolder(this, inflate);
    }
}
