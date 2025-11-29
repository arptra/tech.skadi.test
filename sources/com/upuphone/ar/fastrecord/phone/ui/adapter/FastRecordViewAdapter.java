package com.upuphone.ar.fastrecord.phone.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.v3.j;
import com.honey.account.v3.k;
import com.honey.account.v3.l;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.db.RecordContentTagEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ext.RecordViewKt;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.AsrDuringProgress;
import com.upuphone.ar.fastrecord.phone.ui.widget.RecordItemSoundVisualizerView;
import com.upuphone.ar.fastrecord.phone.ui.widget.labels.RecordSingleLineTagView;
import com.upuphone.ar.fastrecord.phone.utils.FastRecordTitleHelper;
import com.upuphone.ar.fastrecord.phone.utils.RecordDateUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordViewAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordViewAdapter.kt\ncom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordViewAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,615:1\n262#2,2:616\n262#2,2:618\n262#2,2:620\n262#2,2:622\n262#2,2:624\n262#2,2:626\n262#2,2:628\n262#2,2:630\n262#2,2:632\n262#2,2:634\n262#2,2:636\n262#2,2:638\n262#2,2:642\n262#2,2:644\n262#2,2:646\n262#2,2:648\n262#2,2:650\n262#2,2:652\n262#2,2:654\n262#2,2:656\n262#2,2:658\n262#2,2:660\n1855#3,2:640\n1855#3,2:662\n1864#3,3:664\n1864#3,3:667\n1864#3,3:670\n1864#3,3:673\n1855#3,2:676\n1855#3,2:678\n1864#3,3:680\n1855#3,2:683\n1855#3,2:685\n1855#3,2:687\n1855#3,2:689\n1855#3,2:691\n*S KotlinDebug\n*F\n+ 1 FastRecordViewAdapter.kt\ncom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordViewAdapter\n*L\n70#1:616,2\n71#1:618,2\n72#1:620,2\n73#1:622,2\n76#1:624,2\n77#1:626,2\n79#1:628,2\n80#1:630,2\n104#1:632,2\n106#1:634,2\n118#1:636,2\n119#1:638,2\n201#1:642,2\n217#1:644,2\n219#1:646,2\n220#1:648,2\n224#1:650,2\n225#1:652,2\n235#1:654,2\n236#1:656,2\n252#1:658,2\n253#1:660,2\n121#1:640,2\n262#1:662,2\n275#1:664,3\n317#1:667,3\n378#1:670,3\n395#1:673,3\n418#1:676,2\n440#1:678,2\n448#1:680,3\n484#1:683,2\n491#1:685,2\n499#1:687,2\n513#1:689,2\n516#1:691,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 O2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003OPQB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001b\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0010J\u001e\u0010\u001e\u001a\u00020\u00122\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\tj\b\u0012\u0004\u0012\u00020\u0010`\u000bJ\u0016\u0010 \u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0010J\u001c\u0010\"\u001a\u00020\u00122\n\u0010#\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0019H\u0017J\u001c\u0010$\u001a\u00060\u0002R\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0019H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010)\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010*\u001a\u00020\u0012J\u000e\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0005J\u000e\u0010-\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0019J\u000e\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\rJ8\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002042\u0006\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019H\u0002J \u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u0002042\u0006\u00106\u001a\u000204H\u0002J\u0016\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020?J \u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0002J0\u0010F\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\u00102\u0006\u00105\u001a\u0002042\u0006\u00101\u001a\u0002022\u0006\u0010G\u001a\u00020H2\u0006\u00106\u001a\u000204H\u0002J\u0016\u0010I\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020J2\u0006\u0010>\u001a\u00020?J\u001c\u0010K\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020J2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00120MJ\u0016\u0010N\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010>\u001a\u00020?R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordViewAdapter$FastRecordViewHolder;", "()V", "isChooseMode", "", "mContext", "Landroid/content/Context;", "mCurAsrDuringProgressList", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/AsrDuringProgress;", "Lkotlin/collections/ArrayList;", "mListener", "Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordViewAdapter$ItemClickListener;", "recordList", "", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "clearAllItemChooseStatus", "", "getAllFinishItemData", "", "getAsrDuringProgress", "recordId", "", "getItemCount", "", "getPositionData", "position", "isRecording", "mRecordEntity", "notifyData", "list", "notifyItemDataChange", "model", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeAsrDuringData", "resetAsrFailState", "selectAllItemChooseStatus", "setChooseMode", "mode", "setItemChooseStatus", "setItemListener", "listener", "setRecordIngState", "recordCpt", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/RecordItemSoundVisualizerView;", "recordTitle", "Landroid/widget/TextView;", "recordTimeTv", "contentTv", "index", "state", "showAsrProgressInfo", "recordEntity", "asrProgressTv", "showAsrState", "mAsrDuringProgress", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "showChooseItem", "record", "recordSelectIv", "Landroid/widget/ImageView;", "vTran", "Landroid/view/View;", "showRecordStateInfo", "recordCptLayout", "Landroid/widget/LinearLayout;", "stopRecordCpt", "Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordGlassStatus;", "updateRecordStatus", "callback", "Lkotlin/Function0;", "updateRecordTime", "Companion", "FastRecordViewHolder", "ItemClickListener", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordViewAdapter extends RecyclerView.Adapter<FastRecordViewHolder> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "FastRecordViewAdapter";
    @NotNull
    public static final String TIME_FORMAT_TWO = "H:mm:ss";
    private boolean isChooseMode;
    private Context mContext;
    @NotNull
    private ArrayList<AsrDuringProgress> mCurAsrDuringProgressList = new ArrayList<>();
    /* access modifiers changed from: private */
    @Nullable
    public ItemClickListener mListener;
    /* access modifiers changed from: private */
    @NotNull
    public List<RecordEntity> recordList = new ArrayList();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordViewAdapter$Companion;", "", "()V", "TAG", "", "TIME_FORMAT_TWO", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u001f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\bR\u0011\u0010!\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000eR\u0011\u0010#\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\bR\u0011\u0010%\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\bR\u0011\u0010'\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000eR\u0011\u0010,\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)¨\u0006."}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordViewAdapter$FastRecordViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordViewAdapter;Landroid/view/View;)V", "asrProgressTv", "Landroid/widget/TextView;", "getAsrProgressTv", "()Landroid/widget/TextView;", "contentTv", "getContentTv", "ivNewRecord", "Landroid/widget/ImageView;", "getIvNewRecord", "()Landroid/widget/ImageView;", "labelsView", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/labels/RecordSingleLineTagView;", "getLabelsView", "()Lcom/upuphone/ar/fastrecord/phone/ui/widget/labels/RecordSingleLineTagView;", "linearRecordSingleLineTagView", "Landroid/widget/LinearLayout;", "getLinearRecordSingleLineTagView", "()Landroid/widget/LinearLayout;", "locationTv", "getLocationTv", "recordCpt", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/RecordItemSoundVisualizerView;", "getRecordCpt", "()Lcom/upuphone/ar/fastrecord/phone/ui/widget/RecordItemSoundVisualizerView;", "recordCptLayout", "getRecordCptLayout", "recordCreateTimeTv", "getRecordCreateTimeTv", "recordSelectIv", "getRecordSelectIv", "recordTimeTv", "getRecordTimeTv", "recordTitleTv", "getRecordTitleTv", "rootView", "getRootView", "()Landroid/view/View;", "splitIv", "getSplitIv", "vTran", "getVTran", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class FastRecordViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final TextView asrProgressTv;
        @NotNull
        private final TextView contentTv;
        @NotNull
        private final ImageView ivNewRecord;
        @NotNull
        private final RecordSingleLineTagView labelsView;
        @NotNull
        private final LinearLayout linearRecordSingleLineTagView;
        @NotNull
        private final TextView locationTv;
        @NotNull
        private final RecordItemSoundVisualizerView recordCpt;
        @NotNull
        private final LinearLayout recordCptLayout;
        @NotNull
        private final TextView recordCreateTimeTv;
        @NotNull
        private final ImageView recordSelectIv;
        @NotNull
        private final TextView recordTimeTv;
        @NotNull
        private final TextView recordTitleTv;
        @NotNull
        private final View rootView;
        @NotNull
        private final ImageView splitIv;
        final /* synthetic */ FastRecordViewAdapter this$0;
        @NotNull
        private final View vTran;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FastRecordViewHolder(@NotNull FastRecordViewAdapter fastRecordViewAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = fastRecordViewAdapter;
            View rootView2 = view.getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView2, "getRootView(...)");
            this.rootView = rootView2;
            View findViewById = view.findViewById(R.id.tv_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            TextView textView = (TextView) findViewById;
            this.recordTitleTv = textView;
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
            View findViewById7 = view.findViewById(R.id.iv_select);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
            this.recordSelectIv = (ImageView) findViewById7;
            View findViewById8 = view.findViewById(R.id.v_record_cpt);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
            this.recordCpt = (RecordItemSoundVisualizerView) findViewById8;
            View findViewById9 = view.findViewById(R.id.ll_record_cpt);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
            this.recordCptLayout = (LinearLayout) findViewById9;
            View findViewById10 = view.findViewById(R.id.v_tran);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
            this.vTran = findViewById10;
            View findViewById11 = view.findViewById(R.id.tv_asr_progress);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
            this.asrProgressTv = (TextView) findViewById11;
            View findViewById12 = view.findViewById(R.id.labels);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
            this.labelsView = (RecordSingleLineTagView) findViewById12;
            View findViewById13 = view.findViewById(R.id.iv_new_record);
            Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
            this.ivNewRecord = (ImageView) findViewById13;
            View findViewById14 = view.findViewById(R.id.linear_RecordSingleLineTagView);
            Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(...)");
            this.linearRecordSingleLineTagView = (LinearLayout) findViewById14;
            view.setOnClickListener(new j(fastRecordViewAdapter, this));
            view.setOnLongClickListener(new k(fastRecordViewAdapter, this));
            textView.setOnClickListener(new l(this, fastRecordViewAdapter));
        }

        /* access modifiers changed from: private */
        public static final void _init_$lambda$0(FastRecordViewAdapter fastRecordViewAdapter, FastRecordViewHolder fastRecordViewHolder, View view) {
            Intrinsics.checkNotNullParameter(fastRecordViewAdapter, "this$0");
            Intrinsics.checkNotNullParameter(fastRecordViewHolder, "this$1");
            ItemClickListener access$getMListener$p = fastRecordViewAdapter.mListener;
            if (access$getMListener$p != null) {
                access$getMListener$p.onItemClick(fastRecordViewHolder.getBindingAdapterPosition());
            }
        }

        /* access modifiers changed from: private */
        public static final boolean _init_$lambda$1(FastRecordViewAdapter fastRecordViewAdapter, FastRecordViewHolder fastRecordViewHolder, View view) {
            Intrinsics.checkNotNullParameter(fastRecordViewAdapter, "this$0");
            Intrinsics.checkNotNullParameter(fastRecordViewHolder, "this$1");
            ItemClickListener access$getMListener$p = fastRecordViewAdapter.mListener;
            if (access$getMListener$p == null) {
                return false;
            }
            access$getMListener$p.onLongClick(fastRecordViewHolder.getBindingAdapterPosition());
            return false;
        }

        /* access modifiers changed from: private */
        public static final void _init_$lambda$2(FastRecordViewHolder fastRecordViewHolder, FastRecordViewAdapter fastRecordViewAdapter, View view) {
            ItemClickListener access$getMListener$p;
            Intrinsics.checkNotNullParameter(fastRecordViewHolder, "this$0");
            Intrinsics.checkNotNullParameter(fastRecordViewAdapter, "this$1");
            if (fastRecordViewHolder.getBindingAdapterPosition() < fastRecordViewAdapter.recordList.size() && (access$getMListener$p = fastRecordViewAdapter.mListener) != null) {
                access$getMListener$p.commandTitleClick(fastRecordViewHolder.getBindingAdapterPosition(), (RecordEntity) fastRecordViewAdapter.recordList.get(fastRecordViewHolder.getBindingAdapterPosition()));
            }
        }

        @NotNull
        public final TextView getAsrProgressTv() {
            return this.asrProgressTv;
        }

        @NotNull
        public final TextView getContentTv() {
            return this.contentTv;
        }

        @NotNull
        public final ImageView getIvNewRecord() {
            return this.ivNewRecord;
        }

        @NotNull
        public final RecordSingleLineTagView getLabelsView() {
            return this.labelsView;
        }

        @NotNull
        public final LinearLayout getLinearRecordSingleLineTagView() {
            return this.linearRecordSingleLineTagView;
        }

        @NotNull
        public final TextView getLocationTv() {
            return this.locationTv;
        }

        @NotNull
        public final RecordItemSoundVisualizerView getRecordCpt() {
            return this.recordCpt;
        }

        @NotNull
        public final LinearLayout getRecordCptLayout() {
            return this.recordCptLayout;
        }

        @NotNull
        public final TextView getRecordCreateTimeTv() {
            return this.recordCreateTimeTv;
        }

        @NotNull
        public final ImageView getRecordSelectIv() {
            return this.recordSelectIv;
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
        public final View getRootView() {
            return this.rootView;
        }

        @NotNull
        public final ImageView getSplitIv() {
            return this.splitIv;
        }

        @NotNull
        public final View getVTran() {
            return this.vTran;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordViewAdapter$ItemClickListener;", "", "commandRecordEntity", "", "isAdd", "", "recordEntity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "commandTitleClick", "position", "", "onItemClick", "onLongClick", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface ItemClickListener {
        void commandRecordEntity(boolean z, @NotNull RecordEntity recordEntity);

        void commandTitleClick(int i, @NotNull RecordEntity recordEntity);

        void onItemClick(int i);

        void onLongClick(int i);
    }

    private final AsrDuringProgress getAsrDuringProgress(long j) {
        AsrDuringProgress asrDuringProgress = null;
        for (AsrDuringProgress asrDuringProgress2 : this.mCurAsrDuringProgressList) {
            if (asrDuringProgress2.getRecordId() == j) {
                asrDuringProgress = asrDuringProgress2;
            }
        }
        LogExt.logE("getAsrDuringProgress curAsrDuringProgress = " + asrDuringProgress, "FastRecordViewAdapter");
        return asrDuringProgress;
    }

    private final void removeAsrDuringData(long j) {
        ArrayList arrayList = new ArrayList();
        for (AsrDuringProgress asrDuringProgress : this.mCurAsrDuringProgressList) {
            if (asrDuringProgress.getRecordId() == j) {
                LogExt.logE("removeAsrDuringData recordId = " + j, "FastRecordViewAdapter");
                arrayList.add(asrDuringProgress);
            }
        }
        this.mCurAsrDuringProgressList.removeAll(CollectionsKt.toSet(arrayList));
    }

    private final void setRecordIngState(RecordItemSoundVisualizerView recordItemSoundVisualizerView, TextView textView, TextView textView2, TextView textView3, int i, int i2) {
        textView3.setVisibility(8);
        textView2.setText(RecordDateUtil.INSTANCE.getDateToString(this.recordList.get(i).getTotalTime(), "H:mm:ss"));
        Context context = null;
        if (i2 == 1 || i2 == 4) {
            recordItemSoundVisualizerView.startVisualizing();
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context2 = null;
            }
            textView.setText(context2.getString(R.string.fast_record_ing));
            Context context3 = this.mContext;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context3;
            }
            textView2.setTextColor(ContextCompat.getColor(context, R.color.fast_record_recording_time_size_color));
            return;
        }
        Context context4 = this.mContext;
        if (context4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context4 = null;
        }
        textView2.setTextColor(ContextCompat.getColor(context4, R.color.fast_record_time_size_color));
        recordItemSoundVisualizerView.stopVisualizing();
        if (i2 == 3) {
            Context context5 = this.mContext;
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context5;
            }
            textView.setText(context.getString(R.string.fast_record_pause));
            return;
        }
        textView.setText(this.recordList.get(i).getShortHandTitle());
    }

    /* access modifiers changed from: private */
    public final void showAsrProgressInfo(RecordEntity recordEntity, TextView textView, TextView textView2) {
        String str;
        if (recordEntity.getArsIsStart()) {
            textView2.setVisibility(8);
            textView.setVisibility(0);
            Context context = null;
            if (recordEntity.getAsrFail()) {
                Context context2 = this.mContext;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context2 = null;
                }
                textView.setText(context2.getString(R.string.fast_record_fail_tip));
                Context context3 = this.mContext;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    context = context3;
                }
                textView.setTextColor(context.getColor(R.color.fast_record_item_asr_fail_color));
                return;
            }
            Context context4 = this.mContext;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context4 = null;
            }
            String string = context4.getString(R.string.fast_record_loading);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            LogExt.logE("progress = " + recordEntity.getArsProgress(), "FastRecordViewAdapter");
            Context context5 = this.mContext;
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context5 = null;
            }
            if (RecordViewKt.isRtl(context5)) {
                str = " %" + recordEntity.getArsProgress() + "...";
            } else {
                str = " " + recordEntity.getArsProgress() + "%...";
            }
            String str2 = string + str;
            Context context6 = this.mContext;
            if (context6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context6;
            }
            textView.setTextColor(context.getColor(R.color.fast_record_item_asr_downing_color));
            textView.setText(str2);
            return;
        }
        textView.setVisibility(8);
        textView2.setVisibility(0);
    }

    private final void showChooseItem(RecordEntity recordEntity, ImageView imageView, View view) {
        boolean z = this.isChooseMode;
        boolean isChoose = recordEntity.isChoose();
        LogExt.logW("showChooseItem start isChooseMode = " + z + " record isChoose = " + isChoose, "FastRecordViewAdapter");
        if (!this.isChooseMode) {
            imageView.setVisibility(8);
            view.setVisibility(8);
        } else if (!isRecording(recordEntity)) {
            imageView.setVisibility(0);
            Context context = null;
            if (recordEntity.isChoose()) {
                Context context2 = this.mContext;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    context = context2;
                }
                imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_fast_record_item_choose));
            } else {
                Context context3 = this.mContext;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    context = context3;
                }
                imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.bg_fast_record_item_no_choose));
            }
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
            imageView.setVisibility(8);
        }
    }

    private final void showRecordStateInfo(RecordEntity recordEntity, TextView textView, RecordItemSoundVisualizerView recordItemSoundVisualizerView, LinearLayout linearLayout, TextView textView2) {
        int recordStatus = recordEntity.getRecordStatus();
        LogExt.logD("showRecordStateInfo ,status = " + recordStatus, "FastRecordViewAdapter");
        Context context = null;
        if (recordEntity.getRecordStatus() == 2 || recordEntity.getRecordStatus() == 5) {
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context2;
            }
            textView.setTextColor(ContextCompat.getColor(context, R.color.fast_record_time_size_color));
            recordItemSoundVisualizerView.setVisibility(4);
            linearLayout.setVisibility(4);
            textView2.setVisibility(0);
        } else {
            Context context3 = this.mContext;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context3;
            }
            textView.setTextColor(ContextCompat.getColor(context, R.color.fast_record_recording_time_size_color));
            recordItemSoundVisualizerView.setVisibility(0);
            linearLayout.setVisibility(0);
            textView2.setVisibility(4);
        }
        textView2.requestLayout();
    }

    public final void clearAllItemChooseStatus() {
        for (RecordEntity choose : this.recordList) {
            choose.setChoose(false);
        }
        notifyDataSetChanged();
    }

    @NotNull
    public final List<RecordEntity> getAllFinishItemData() {
        ArrayList arrayList = new ArrayList();
        for (RecordEntity recordEntity : this.recordList) {
            if (!isRecording(recordEntity)) {
                arrayList.add(recordEntity);
            }
        }
        return arrayList;
    }

    public int getItemCount() {
        return this.recordList.size();
    }

    @Nullable
    public final RecordEntity getPositionData(int i) {
        int size = this.recordList.size();
        LogExt.logE("getPositionData position = " + i + ",size = " + size, "FastRecordViewAdapter");
        if (i < 0 || i >= this.recordList.size()) {
            return null;
        }
        return this.recordList.get(i);
    }

    public final boolean isRecording(@NotNull RecordEntity recordEntity) {
        Intrinsics.checkNotNullParameter(recordEntity, "mRecordEntity");
        LogExt.logE("isRecording mRecordEntity = " + recordEntity, "FastRecordViewAdapter");
        return (recordEntity.getRecordStatus() == 2 || recordEntity.getRecordStatus() == 5) ? false : true;
    }

    public final void notifyData(@NotNull ArrayList<RecordEntity> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "list");
        int size = this.mCurAsrDuringProgressList.size();
        LogExt.logE("notifyData asrDuringProgress size = " + size, "FastRecordViewAdapter");
        for (AsrDuringProgress asrDuringProgress : this.mCurAsrDuringProgressList) {
            LogExt.logE("notifyData asrDuringProgress data = " + asrDuringProgress, "FastRecordViewAdapter");
        }
        for (RecordEntity recordEntity : arrayList) {
            AsrDuringProgress asrDuringProgress2 = getAsrDuringProgress(recordEntity.getRecordId());
            if (asrDuringProgress2 != null && recordEntity.getRecordId() == asrDuringProgress2.getRecordId()) {
                recordEntity.setAsrFail(asrDuringProgress2.isFail());
                recordEntity.setArsProgress((long) ((((float) asrDuringProgress2.getCurAsrTime()) / ((float) asrDuringProgress2.getTotalTime())) * ((float) 100)));
                recordEntity.setArsIsStart(asrDuringProgress2.isStartAsr());
                recordEntity.setArsIsFinish(asrDuringProgress2.isFinish());
            }
        }
        this.recordList = arrayList;
        notifyDataSetChanged();
    }

    public final void notifyItemDataChange(int i, @NotNull RecordEntity recordEntity) {
        Intrinsics.checkNotNullParameter(recordEntity, "model");
        this.recordList.set(i, recordEntity);
        FastRecordTitleHelper instance = FastRecordTitleHelper.Companion.getInstance();
        if (instance != null) {
            instance.updateRecordTitle(recordEntity);
        }
        notifyItemChanged(i);
    }

    public final void resetAsrFailState(int i) {
        RecordEntity recordEntity = this.recordList.get(i);
        ArrayList arrayList = new ArrayList();
        for (AsrDuringProgress asrDuringProgress : this.mCurAsrDuringProgressList) {
            if (asrDuringProgress.getRecordId() == recordEntity.getRecordId() && asrDuringProgress.isFail()) {
                LogExt.logE("removeAsrDuringData recordId = " + recordEntity.getRecordId() + ",isFail = " + asrDuringProgress.isFail(), "FastRecordViewAdapter");
                arrayList.add(asrDuringProgress);
            }
        }
        this.mCurAsrDuringProgressList.removeAll(CollectionsKt.toSet(arrayList));
        LogExt.logD("resetAsrState  mCurAsrDuringProgress set null", "FastRecordViewAdapter");
        int i2 = 0;
        for (T next : this.recordList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            RecordEntity recordEntity2 = (RecordEntity) next;
            if (i2 == i && recordEntity2.getAsrFail()) {
                LogExt.logE("resetAsrState position = " + i + ",title = " + recordEntity2.getShortHandTitle() + ",recordEntity = " + recordEntity2, "FastRecordViewAdapter");
                recordEntity2.setArsIsStart(false);
                recordEntity2.setArsIsFinish(true);
            }
            i2 = i3;
        }
    }

    public final void selectAllItemChooseStatus() {
        for (RecordEntity choose : this.recordList) {
            choose.setChoose(true);
        }
        notifyDataSetChanged();
    }

    public final void setChooseMode(boolean z) {
        this.isChooseMode = z;
        notifyDataSetChanged();
    }

    public final void setItemChooseStatus(int i) {
        boolean isChoose = this.recordList.get(i).isChoose();
        LogExt.logI("setItemChooseStatus is not choose status = " + isChoose, "FastRecordViewAdapter");
        if (!this.isChooseMode || isRecording(this.recordList.get(i))) {
            LogExt.logI("setItemChooseStatus is not choose mode", "FastRecordViewAdapter");
            return;
        }
        this.recordList.get(i).setChoose(!this.recordList.get(i).isChoose());
        ItemClickListener itemClickListener = this.mListener;
        if (itemClickListener != null) {
            itemClickListener.commandRecordEntity(this.recordList.get(i).isChoose(), this.recordList.get(i));
        }
        notifyItemChanged(i);
    }

    public final void setItemListener(@NotNull ItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener = itemClickListener;
    }

    public final void showAsrState(@NotNull AsrDuringProgress asrDuringProgress, @NotNull LinearLayoutManager linearLayoutManager) {
        AsrDuringProgress asrDuringProgress2 = asrDuringProgress;
        Intrinsics.checkNotNullParameter(asrDuringProgress2, "mAsrDuringProgress");
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        long recordId = asrDuringProgress.getRecordId();
        LogExt.logD("mAsrDuringProgress  = " + asrDuringProgress2 + ",mAsrDuringProgress.recordId = " + recordId, "FastRecordViewAdapter");
        this.mCurAsrDuringProgressList.add(asrDuringProgress2);
        int i = 0;
        for (T next : this.recordList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            RecordEntity recordEntity = (RecordEntity) next;
            if (recordEntity.getRecordId() == asrDuringProgress.getRecordId()) {
                long recordId2 = recordEntity.getRecordId();
                LogExt.logE("recordEntity.recordId = " + recordId2 + " is equal", "FastRecordViewAdapter");
                recordEntity.setAsrFail(asrDuringProgress.isFail());
                recordEntity.setArsProgress((long) ((((float) asrDuringProgress.getCurAsrTime()) / ((float) asrDuringProgress.getTotalTime())) * ((float) 100)));
                recordEntity.setArsIsStart(asrDuringProgress.isStartAsr());
                recordEntity.setArsIsFinish(asrDuringProgress.isFinish());
                if (asrDuringProgress.isFinish()) {
                    recordEntity.setArsIsStart(false);
                    LogExt.logD("mAsrDuringProgress  mAsrDuringProgress.isFinish", "FastRecordViewAdapter");
                    removeAsrDuringData(asrDuringProgress.getRecordId());
                    Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordViewAdapter$showAsrState$1$1(asrDuringProgress, recordEntity, this, i, (Continuation<? super FastRecordViewAdapter$showAsrState$1$1>) null), 3, (Object) null);
                }
                Job unused2 = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordViewAdapter$showAsrState$1$2(linearLayoutManager, i, this, recordEntity, (Continuation<? super FastRecordViewAdapter$showAsrState$1$2>) null), 3, (Object) null);
            }
            i = i2;
        }
    }

    public final void stopRecordCpt(@NotNull RecordGlassStatus recordGlassStatus, @NotNull LinearLayoutManager linearLayoutManager) {
        View findViewByPosition;
        RecordItemSoundVisualizerView recordItemSoundVisualizerView;
        Intrinsics.checkNotNullParameter(recordGlassStatus, "mRecordEntity");
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        int i = 0;
        for (T next : this.recordList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (!(recordGlassStatus.getId() != ((RecordEntity) next).getRecordId() || (findViewByPosition = linearLayoutManager.findViewByPosition(i)) == null || (recordItemSoundVisualizerView = (RecordItemSoundVisualizerView) findViewByPosition.findViewById(R.id.v_record_cpt)) == null)) {
                recordItemSoundVisualizerView.stopVisualizing();
            }
            i = i2;
        }
    }

    public final void updateRecordStatus(@NotNull RecordGlassStatus recordGlassStatus, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(recordGlassStatus, "mRecordEntity");
        Intrinsics.checkNotNullParameter(function0, "callback");
        boolean z = false;
        int i = 0;
        for (T next : this.recordList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            RecordEntity recordEntity = (RecordEntity) next;
            if (recordGlassStatus.getId() == recordEntity.getRecordId()) {
                LogExt.logD("updateRecordTime findInfo mRecordEntity = " + recordGlassStatus, "FastRecordViewAdapter");
                recordEntity.setRecordStatus(recordGlassStatus.getState());
                int state = recordGlassStatus.getState();
                if (state == 2 || state == 5) {
                    function0.invoke();
                }
                notifyItemChanged(i);
                z = true;
            }
            i = i2;
        }
        if (!z) {
            function0.invoke();
        }
    }

    public final void updateRecordTime(@NotNull RecordEntity recordEntity, @NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(recordEntity, "mRecordEntity");
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        int i = 0;
        for (T next : this.recordList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            RecordEntity recordEntity2 = (RecordEntity) next;
            if (recordEntity.getRecordId() == recordEntity2.getRecordId()) {
                recordEntity2.setTotalTime(recordEntity.getTotalTime());
                View findViewByPosition = linearLayoutManager.findViewByPosition(i);
                if (findViewByPosition != null) {
                    ((TextView) findViewByPosition.findViewById(R.id.tv_record_time)).setText(RecordDateUtil.INSTANCE.getDateToString(this.recordList.get(i).getTotalTime(), "H:mm:ss"));
                    RecordItemSoundVisualizerView recordItemSoundVisualizerView = (RecordItemSoundVisualizerView) findViewByPosition.findViewById(R.id.v_record_cpt);
                    if (recordItemSoundVisualizerView != null) {
                        recordItemSoundVisualizerView.startVisualizing();
                    }
                }
            }
            i = i2;
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void onBindViewHolder(@NotNull FastRecordViewHolder fastRecordViewHolder, int i) {
        Intrinsics.checkNotNullParameter(fastRecordViewHolder, "holder");
        RecordEntity recordEntity = this.recordList.get(i);
        TextView recordTitleTv = fastRecordViewHolder.getRecordTitleTv();
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        recordTitleTv.setCompoundDrawables((Drawable) null, (Drawable) null, context.getDrawable(R.drawable.ic_fast_record_title_edt), (Drawable) null);
        fastRecordViewHolder.getContentTv().setVisibility(0);
        int i2 = 8;
        fastRecordViewHolder.getAsrProgressTv().setVisibility(8);
        fastRecordViewHolder.getRecordCpt().setVisibility(8);
        fastRecordViewHolder.getRecordCptLayout().setVisibility(8);
        fastRecordViewHolder.getLocationTv().setText(recordEntity.getLocationShort());
        if (!TextUtils.isEmpty(recordEntity.getLocationShort())) {
            fastRecordViewHolder.getLocationTv().setVisibility(0);
            fastRecordViewHolder.getSplitIv().setVisibility(0);
        } else {
            fastRecordViewHolder.getLocationTv().setVisibility(8);
            fastRecordViewHolder.getSplitIv().setVisibility(8);
        }
        fastRecordViewHolder.getContentTv().setText("");
        showRecordStateInfo(recordEntity, fastRecordViewHolder.getRecordTimeTv(), fastRecordViewHolder.getRecordCpt(), fastRecordViewHolder.getRecordCptLayout(), fastRecordViewHolder.getContentTv());
        TextView recordTimeTv = fastRecordViewHolder.getRecordTimeTv();
        RecordDateUtil recordDateUtil = RecordDateUtil.INSTANCE;
        recordTimeTv.setText(recordDateUtil.getDateToString(recordEntity.getTotalTime(), "H:mm:ss"));
        fastRecordViewHolder.getRecordTimeTv().requestLayout();
        fastRecordViewHolder.getRecordTitleTv().setText(recordEntity.getShortHandTitle());
        TextView recordTitleTv2 = fastRecordViewHolder.getRecordTitleTv();
        Context context2 = this.mContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context2 = null;
        }
        recordTitleTv2.setCompoundDrawables((Drawable) null, (Drawable) null, context2.getDrawable(R.drawable.ic_fast_record_title_edt), (Drawable) null);
        fastRecordViewHolder.getRecordCreateTimeTv().setText(recordDateUtil.formatRecordDate(recordEntity.getCreateTime()));
        fastRecordViewHolder.getRecordCreateTimeTv().requestLayout();
        showChooseItem(recordEntity, fastRecordViewHolder.getRecordSelectIv(), fastRecordViewHolder.getVTran());
        fastRecordViewHolder.getIvNewRecord().setVisibility(recordEntity.isNewRecordItem() ? 0 : 8);
        fastRecordViewHolder.getAsrProgressTv().setVisibility(8);
        showAsrProgressInfo(recordEntity, fastRecordViewHolder.getAsrProgressTv(), fastRecordViewHolder.getContentTv());
        TextView contentTv = fastRecordViewHolder.getContentTv();
        Context context3 = this.mContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context3 = null;
        }
        contentTv.setTextColor(context3.getColor(R.color.fast_record_content_color));
        if (!recordEntity.getArsIsStart()) {
            String shortHandText = recordEntity.getShortHandText();
            if (shortHandText == null) {
                shortHandText = StringsKt.trim((CharSequence) "").toString();
            }
            if (TextUtils.isEmpty(shortHandText)) {
                TextView contentTv2 = fastRecordViewHolder.getContentTv();
                Context context4 = this.mContext;
                if (context4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context4 = null;
                }
                contentTv2.setText(context4.getText(R.string.fast_record_no_content));
                TextView contentTv3 = fastRecordViewHolder.getContentTv();
                Context context5 = this.mContext;
                if (context5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context5 = null;
                }
                contentTv3.setTextColor(context5.getColor(R.color.fast_record_hint));
            } else {
                fastRecordViewHolder.getContentTv().setText(recordEntity.getShortHandText());
            }
        }
        fastRecordViewHolder.getLabelsView().setVisibility(recordEntity.getTagBeanList().isEmpty() ^ true ? 0 : 8);
        LinearLayout linearRecordSingleLineTagView = fastRecordViewHolder.getLinearRecordSingleLineTagView();
        if (!recordEntity.getTagBeanList().isEmpty()) {
            i2 = 0;
        }
        linearRecordSingleLineTagView.setVisibility(i2);
        RecordSingleLineTagView labelsView = fastRecordViewHolder.getLabelsView();
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
        labelsView.setTags(arrayList);
        if (isRecording(recordEntity)) {
            setRecordIngState(fastRecordViewHolder.getRecordCpt(), fastRecordViewHolder.getRecordTitleTv(), fastRecordViewHolder.getRecordTimeTv(), fastRecordViewHolder.getContentTv(), i, recordEntity.getRecordStatus());
            fastRecordViewHolder.getRecordTitleTv().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            Context context6 = this.mContext;
            if (context6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context6 = null;
            }
            if (RecordViewKt.isRtl(context6)) {
                TextView recordTitleTv3 = fastRecordViewHolder.getRecordTitleTv();
                Context context7 = this.mContext;
                if (context7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context7 = null;
                }
                recordTitleTv3.setCompoundDrawablesWithIntrinsicBounds(context7.getDrawable(R.drawable.ic_fast_record_title_edt), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                TextView recordTitleTv4 = fastRecordViewHolder.getRecordTitleTv();
                Context context8 = this.mContext;
                if (context8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context8 = null;
                }
                recordTitleTv4.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, context8.getDrawable(R.drawable.ic_fast_record_title_edt), (Drawable) null);
            }
            fastRecordViewHolder.getContentTv().setVisibility(0);
        }
        fastRecordViewHolder.getRecordTitleTv().requestLayout();
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.fast_record_item_info, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        return new FastRecordViewHolder(this, inflate);
    }
}
