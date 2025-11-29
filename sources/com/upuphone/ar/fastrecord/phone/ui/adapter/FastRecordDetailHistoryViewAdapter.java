package com.upuphone.ar.fastrecord.phone.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.v3.a;
import com.honey.account.v3.b;
import com.honey.account.v3.c;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.db.RecordPersonEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.widget.CopyEditText;
import com.upuphone.ar.fastrecord.phone.utils.RecordConstants;
import com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordDetailHistoryViewAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordDetailHistoryViewAdapter.kt\ncom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordDetailHistoryViewAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,604:1\n1864#2,3:605\n1864#2,3:608\n1864#2,3:611\n1855#2,2:652\n1855#2,2:654\n1855#2,2:656\n1855#2,2:658\n1864#2,3:660\n1864#2,3:663\n262#3,2:614\n262#3,2:616\n262#3,2:618\n262#3,2:620\n262#3,2:622\n262#3,2:624\n262#3,2:626\n262#3,2:628\n262#3,2:630\n262#3,2:632\n262#3,2:634\n262#3,2:636\n262#3,2:638\n262#3,2:640\n262#3,2:642\n262#3,2:644\n262#3,2:646\n262#3,2:648\n262#3,2:650\n*S KotlinDebug\n*F\n+ 1 FastRecordDetailHistoryViewAdapter.kt\ncom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordDetailHistoryViewAdapter\n*L\n90#1:605,3\n98#1:608,3\n107#1:611,3\n439#1:652,2\n457#1:654,2\n484#1:656,2\n500#1:658,2\n509#1:660,3\n543#1:663,3\n139#1:614,2\n140#1:616,2\n145#1:618,2\n146#1:620,2\n162#1:622,2\n163#1:624,2\n178#1:626,2\n179#1:628,2\n180#1:630,2\n293#1:632,2\n294#1:634,2\n295#1:636,2\n296#1:638,2\n297#1:640,2\n300#1:642,2\n301#1:644,2\n308#1:646,2\n309#1:648,2\n346#1:650,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 U2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003UVWB\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u000bJ\u0006\u0010 \u001a\u00020\u001dJ\u0014\u0010!\u001a\u00020\u001d2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0#J\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020\u0005J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\tH\u0002J\b\u0010(\u001a\u00020\u0005H\u0016J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u000e\u0010*\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\u000bJ\b\u0010-\u001a\u00020\u001dH\u0003J\u001e\u0010.\u001a\u00020\u001d2\n\u0010/\u001a\u00060\u0002R\u00020\u00002\b\b\u0001\u0010\u001e\u001a\u00020\u0005H\u0017J\u001c\u00100\u001a\u00060\u0002R\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0005H\u0016J\u000e\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020+J\u0016\u00106\u001a\u00020\u001d2\u000e\u00107\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u000108J \u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\u0014\u0010?\u001a\u00020\u001d2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\t08J\u0018\u0010@\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020<2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u000e\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u0012J\u0018\u0010D\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010E\u001a\u000202H\u0002J\u000e\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u0007J\u000e\u0010H\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020\u000bJ \u0010J\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010K\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020LH\u0002J\u0018\u0010M\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020O2\u0006\u0010:\u001a\u00020\tH\u0002J(\u0010P\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\t2\u0006\u0010Q\u001a\u00020O2\u0006\u0010R\u001a\u00020>2\u0006\u0010N\u001a\u00020OH\u0002J\u0018\u0010S\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\t2\u0006\u0010N\u001a\u00020OH\u0002J\b\u0010T\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0014j\b\u0012\u0004\u0012\u00020\t`\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordDetailHistoryViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordDetailHistoryViewAdapter$FastRecordDealViewHolder;", "()V", "curEdtItemPosition", "", "curEdtValue", "", "curSelectData", "Lcom/upuphone/ar/fastrecord/phone/db/RecordVoiceWordEntity;", "isEditMode", "", "isShowSoftInput", "mContext", "Landroid/content/Context;", "mHandler", "Landroid/os/Handler;", "mListener", "Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordDetailHistoryViewAdapter$ItemClickListener;", "personOtherTagList", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordPersonEntity;", "Lkotlin/collections/ArrayList;", "personOtherTagString", "personSelfTagList", "personSelfTagString", "recordWordLanguageType", "recordWordList", "changeToEditState", "", "position", "checkItemWorkHasChange", "clearEditStateAndNoSaveData", "clearEditStateAndSaveData", "callBack", "Lkotlin/Function0;", "getAllContentValue", "getEdtItemPosition", "getIndexForList", "data", "getItemCount", "getItemViewType", "getPositionStartTime", "", "hasData", "notifyDataForNoEmpty", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectRecyclerViewItem", "time", "setAllPersonTagList", "tagList", "", "setContentValue", "recordWord", "edtContent", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/CopyEditText;", "tvContent", "Landroid/widget/TextView;", "setData", "setEdtPasteListener", "editText", "setItemListener", "listener", "setPaddingValue", "rootView", "setRecordWordLanguageType", "type", "setShowSoftInput", "state", "showContentColor", "showInput", "Landroid/widget/EditText;", "showRoleTypeColor", "ivRoleType", "Landroid/widget/ImageView;", "showRoleTypeInfo", "ivRoleTagType", "tvRoleTagType", "showRoleTypeIv", "toToastCopied", "Companion", "FastRecordDealViewHolder", "ItemClickListener", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordDetailHistoryViewAdapter extends RecyclerView.Adapter<FastRecordDealViewHolder> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DELAY_SHOW_TIME = 500;
    @NotNull
    public static final String TAG = "FastRecordDetailHistoryViewAdapter";
    /* access modifiers changed from: private */
    public int curEdtItemPosition = -1;
    /* access modifiers changed from: private */
    @NotNull
    public String curEdtValue = "";
    @Nullable
    private RecordVoiceWordEntity curSelectData;
    private boolean isEditMode;
    private boolean isShowSoftInput;
    private Context mContext;
    @NotNull
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    @Nullable
    public ItemClickListener mListener;
    @NotNull
    private ArrayList<RecordPersonEntity> personOtherTagList = new ArrayList<>();
    @NotNull
    private String personOtherTagString = "";
    @NotNull
    private ArrayList<RecordPersonEntity> personSelfTagList = new ArrayList<>();
    @NotNull
    private String personSelfTagString = "";
    @NotNull
    private String recordWordLanguageType = "";
    /* access modifiers changed from: private */
    @NotNull
    public ArrayList<RecordVoiceWordEntity> recordWordList = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordDetailHistoryViewAdapter$Companion;", "", "()V", "DELAY_SHOW_TIME", "", "TAG", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordDetailHistoryViewAdapter$FastRecordDealViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordDetailHistoryViewAdapter;Landroid/view/View;)V", "edtContent", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/CopyEditText;", "getEdtContent", "()Lcom/upuphone/ar/fastrecord/phone/ui/widget/CopyEditText;", "ivRoleTagType", "Landroid/widget/ImageView;", "getIvRoleTagType", "()Landroid/widget/ImageView;", "ivRoleType", "getIvRoleType", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "setRootView", "(Landroid/view/ViewGroup;)V", "tvContent", "Landroid/widget/TextView;", "getTvContent", "()Landroid/widget/TextView;", "tvRoleTagType", "getTvRoleTagType", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class FastRecordDealViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final CopyEditText edtContent;
        @NotNull
        private final ImageView ivRoleTagType;
        @NotNull
        private final ImageView ivRoleType;
        @NotNull
        private ViewGroup rootView;
        final /* synthetic */ FastRecordDetailHistoryViewAdapter this$0;
        @NotNull
        private final TextView tvContent;
        @NotNull
        private final TextView tvRoleTagType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FastRecordDealViewHolder(@NotNull FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = fastRecordDetailHistoryViewAdapter;
            View findViewById = view.findViewById(R.id.iv_role_type);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.ivRoleType = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.tv_content);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.tvContent = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.edt_content);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.edtContent = (CopyEditText) findViewById3;
            View findViewById4 = view.findViewById(R.id.iv_role_type_tag);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.ivRoleTagType = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(R.id.tv_tag_role_type);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.tvRoleTagType = (TextView) findViewById5;
            View findViewById6 = view.findViewById(R.id.cl_history_content);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.rootView = (ViewGroup) findViewById6;
            view.setOnClickListener(new b(fastRecordDetailHistoryViewAdapter, this));
            view.setOnLongClickListener(new c(fastRecordDetailHistoryViewAdapter, this));
        }

        /* access modifiers changed from: private */
        public static final void _init_$lambda$0(FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter, FastRecordDealViewHolder fastRecordDealViewHolder, View view) {
            Intrinsics.checkNotNullParameter(fastRecordDetailHistoryViewAdapter, "this$0");
            Intrinsics.checkNotNullParameter(fastRecordDealViewHolder, "this$1");
            ItemClickListener access$getMListener$p = fastRecordDetailHistoryViewAdapter.mListener;
            if (access$getMListener$p != null) {
                access$getMListener$p.onItemClick(fastRecordDealViewHolder.getBindingAdapterPosition());
            }
        }

        /* access modifiers changed from: private */
        public static final boolean _init_$lambda$1(FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter, FastRecordDealViewHolder fastRecordDealViewHolder, View view) {
            Intrinsics.checkNotNullParameter(fastRecordDetailHistoryViewAdapter, "this$0");
            Intrinsics.checkNotNullParameter(fastRecordDealViewHolder, "this$1");
            ItemClickListener access$getMListener$p = fastRecordDetailHistoryViewAdapter.mListener;
            if (access$getMListener$p == null) {
                return false;
            }
            access$getMListener$p.onLongClick(fastRecordDealViewHolder.getBindingAdapterPosition());
            return false;
        }

        @NotNull
        public final CopyEditText getEdtContent() {
            return this.edtContent;
        }

        @NotNull
        public final ImageView getIvRoleTagType() {
            return this.ivRoleTagType;
        }

        @NotNull
        public final ImageView getIvRoleType() {
            return this.ivRoleType;
        }

        @NotNull
        public final ViewGroup getRootView() {
            return this.rootView;
        }

        @NotNull
        public final TextView getTvContent() {
            return this.tvContent;
        }

        @NotNull
        public final TextView getTvRoleTagType() {
            return this.tvRoleTagType;
        }

        public final void setRootView(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.rootView = viewGroup;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordDetailHistoryViewAdapter$ItemClickListener;", "", "onItemClick", "", "position", "", "onLongClick", "scrollToPosition", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface ItemClickListener {
        void onItemClick(int i);

        void onLongClick(int i);

        void scrollToPosition(int i);
    }

    public FastRecordDetailHistoryViewAdapter() {
        RecordVoiceWordEntity recordVoiceWordEntity = r1;
        RecordVoiceWordEntity recordVoiceWordEntity2 = new RecordVoiceWordEntity(0, (String) null, 0, (String) null, 0, 0, (String) null, (String) null, false, false, false, (String) null, 4095, (DefaultConstructorMarker) null);
        this.curSelectData = recordVoiceWordEntity;
    }

    private final int getIndexForList(RecordVoiceWordEntity recordVoiceWordEntity) {
        int i = 0;
        for (T next : this.recordWordList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (recordVoiceWordEntity.getRecordId() == ((RecordVoiceWordEntity) next).getRecordId()) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void notifyDataForNoEmpty() {
        notifyDataSetChanged();
    }

    private final void setContentValue(RecordVoiceWordEntity recordVoiceWordEntity, CopyEditText copyEditText, TextView textView) {
        try {
            if (this.isEditMode) {
                textView.setText(recordVoiceWordEntity.getWordContentTemp());
                copyEditText.setText(recordVoiceWordEntity.getWordContentTemp());
                return;
            }
            textView.setText(recordVoiceWordEntity.getWordContent());
            copyEditText.setText(recordVoiceWordEntity.getWordContent());
        } catch (Exception e) {
            String message = e.getMessage();
            LogExt.logE("onBindViewHolder error = " + message, TAG);
        }
    }

    private final void setEdtPasteListener(CopyEditText copyEditText, int i) {
        if (copyEditText.getTag() != null) {
            LogExt.logE("setEdtListener tag info is true", TAG);
            return;
        }
        LogExt.logE("setEdtListener start", TAG);
        copyEditText.setTag(Boolean.TRUE);
        copyEditText.addTextChangedListener(new FastRecordDetailHistoryViewAdapter$setEdtPasteListener$1(this, i));
        copyEditText.setOnPasteCallback(new FastRecordDetailHistoryViewAdapter$setEdtPasteListener$2(this));
    }

    private final void setPaddingValue(int i, ViewGroup viewGroup) {
        Context context = null;
        if (i == 0) {
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context2;
            }
            viewGroup.setPadding(0, context.getResources().getDimensionPixelSize(R.dimen.fast_record_history_top_padding), 0, 0);
        } else if (i == this.recordWordList.size() - 1) {
            Context context3 = this.mContext;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context3;
            }
            viewGroup.setPadding(0, 0, 0, context.getResources().getDimensionPixelSize(R.dimen.fast_record_history_top_padding));
        } else {
            viewGroup.setPadding(0, 0, 0, 0);
        }
    }

    private final void showContentColor(RecordVoiceWordEntity recordVoiceWordEntity, CopyEditText copyEditText, TextView textView) {
        Context context = null;
        if (!recordVoiceWordEntity.isSelect() || this.isEditMode) {
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context2 = null;
            }
            textView.setTextColor(context2.getColor(R.color.fast_record_name));
            Context context3 = this.mContext;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context3;
            }
            copyEditText.setTextColor(context.getColor(R.color.fast_record_name));
            return;
        }
        Context context4 = this.mContext;
        if (context4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context4 = null;
        }
        textView.setTextColor(context4.getColor(R.color.speech_recognition_play_text));
        Context context5 = this.mContext;
        if (context5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context = context5;
        }
        copyEditText.setTextColor(context.getColor(R.color.speech_recognition_play_text));
    }

    private final void showInput(EditText editText) {
        this.mHandler.postDelayed(new a(this, editText), 500);
    }

    /* access modifiers changed from: private */
    public static final void showInput$lambda$4(FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter, EditText editText) {
        Intrinsics.checkNotNullParameter(fastRecordDetailHistoryViewAdapter, "this$0");
        Intrinsics.checkNotNullParameter(editText, "$editText");
        Context context = fastRecordDetailHistoryViewAdapter.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        boolean z = fastRecordDetailHistoryViewAdapter.isShowSoftInput;
        LogExt.logE("inputMethodManager.isActive isShowSoftInput = " + z, TAG);
        if (!fastRecordDetailHistoryViewAdapter.isShowSoftInput) {
            inputMethodManager.showSoftInput(editText, 1);
        }
        LogExt.logE("showSoftInput end ", TAG);
    }

    private final void showRoleTypeColor(ImageView imageView, RecordVoiceWordEntity recordVoiceWordEntity) {
        Context context = null;
        if (Intrinsics.areEqual((Object) RecordConstants.SCENE_PHONE_OTHER, (Object) recordVoiceWordEntity.getRoles())) {
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context2;
            }
            imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.bg_fast_record_detail_role_scene_phone_other));
        } else if (Intrinsics.areEqual((Object) RecordConstants.SCENE_PHONE_MY_SELF, (Object) recordVoiceWordEntity.getRoles())) {
            Context context3 = this.mContext;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context3;
            }
            imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.bg_fast_record_detail_role_scene_phone_my_self));
        } else if (Intrinsics.areEqual((Object) RecordConstants.SCENE_ONLY, (Object) recordVoiceWordEntity.getRoles())) {
            imageView.setVisibility(8);
        }
    }

    private final void showRoleTypeInfo(RecordVoiceWordEntity recordVoiceWordEntity, ImageView imageView, TextView textView, ImageView imageView2) {
        LogExt.logE("personOtherTagList.isEmpty() = " + this.personOtherTagList.isEmpty() + ",personSelfTagList.isEmpty()) = " + this.personSelfTagList.isEmpty(), TAG);
        String wordContent = recordVoiceWordEntity.getWordContent();
        StringBuilder sb = new StringBuilder();
        sb.append("wordContent = ");
        sb.append(wordContent);
        LogExt.logE(sb.toString(), TAG);
        if ((!this.personOtherTagList.isEmpty() || !this.personSelfTagList.isEmpty()) && !TextUtils.isEmpty(recordVoiceWordEntity.getWordContent())) {
            Context context = null;
            if (Intrinsics.areEqual((Object) RecordConstants.SCENE_PHONE_OTHER, (Object) recordVoiceWordEntity.getRoles())) {
                imageView2.setVisibility(4);
                imageView.setVisibility(0);
                textView.setVisibility(0);
                Context context2 = this.mContext;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context2 = null;
                }
                imageView.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.bg_fast_record_detail_role_scene_phone_other));
                if (TextUtils.isEmpty(this.personOtherTagString)) {
                    Context context3 = this.mContext;
                    if (context3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        context3 = null;
                    }
                    textView.setText(context3.getString(R.string.fast_record_role_type_null));
                    Context context4 = this.mContext;
                    if (context4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    } else {
                        context = context4;
                    }
                    textView.setTextColor(context.getColor(R.color.fast_record_item_role_tag_null_color));
                    return;
                }
                textView.setText(this.personOtherTagString);
                Context context5 = this.mContext;
                if (context5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    context = context5;
                }
                textView.setTextColor(context.getColor(R.color.fast_record_item_role_tag_other_color));
            } else if (Intrinsics.areEqual((Object) RecordConstants.SCENE_PHONE_MY_SELF, (Object) recordVoiceWordEntity.getRoles())) {
                imageView2.setVisibility(4);
                imageView.setVisibility(0);
                textView.setVisibility(0);
                Context context6 = this.mContext;
                if (context6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context6 = null;
                }
                imageView.setImageDrawable(ContextCompat.getDrawable(context6, R.drawable.bg_fast_record_detail_role_scene_phone_my_self));
                if (TextUtils.isEmpty(this.personSelfTagString)) {
                    Context context7 = this.mContext;
                    if (context7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        context7 = null;
                    }
                    textView.setText(context7.getString(R.string.fast_record_role_type_null));
                    Context context8 = this.mContext;
                    if (context8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    } else {
                        context = context8;
                    }
                    textView.setTextColor(context.getColor(R.color.fast_record_item_role_tag_null_color));
                    return;
                }
                textView.setText(this.personSelfTagString);
                Context context9 = this.mContext;
                if (context9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    context = context9;
                }
                textView.setTextColor(context.getColor(R.color.fast_record_item_role_tag_self_color));
            } else if (Intrinsics.areEqual((Object) RecordConstants.SCENE_ONLY, (Object) recordVoiceWordEntity.getRoles())) {
                imageView2.setVisibility(8);
                textView.setVisibility(8);
                imageView.setVisibility(8);
            }
        } else {
            imageView.setVisibility(8);
            textView.setVisibility(8);
        }
    }

    private final void showRoleTypeIv(RecordVoiceWordEntity recordVoiceWordEntity, ImageView imageView) {
        String wordContentTemp = recordVoiceWordEntity.getWordContentTemp();
        int i = 0;
        if (!((wordContentTemp == null || wordContentTemp.length() == 0 || Intrinsics.areEqual((Object) RecordConstants.SCENE_ONLY, (Object) recordVoiceWordEntity.getRoles())) ? false : true)) {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    /* access modifiers changed from: private */
    public final void toToastCopied() {
        UToast.Companion companion = UToast.f6444a;
        Context context = this.mContext;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        Context context3 = this.mContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context2 = context3;
        }
        String string = context2.getString(R.string.fast_record_copy_success);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.e(applicationContext, string, 0);
    }

    public final void changeToEditState(int i) {
        String str = this.curEdtValue;
        int i2 = this.curEdtItemPosition;
        LogExt.logW("changeToEditState position =" + i + ",curEdtValue = " + str + ",curEdtItemPosition = " + i2, TAG);
        if (this.curEdtItemPosition != i) {
            this.isEditMode = true;
            this.recordWordList.get(i).setEtdStatus(true);
            notifyItemChanged(i);
            int i3 = this.curEdtItemPosition;
            if (i3 != -1) {
                this.recordWordList.get(i3).setEtdStatus(false);
                notifyItemChanged(this.curEdtItemPosition);
            }
            String wordContent = this.recordWordList.get(i).getWordContent();
            if (wordContent == null) {
                wordContent = "";
            }
            this.curEdtValue = wordContent;
        }
    }

    public final boolean checkItemWorkHasChange() {
        for (RecordVoiceWordEntity recordVoiceWordEntity : this.recordWordList) {
            if (!Intrinsics.areEqual((Object) recordVoiceWordEntity.getWordContentTemp(), (Object) recordVoiceWordEntity.getWordContent())) {
                LogExt.logE("it.wordContentTemp != wordContent ,it = " + recordVoiceWordEntity, TAG);
                return true;
            }
        }
        return false;
    }

    public final void clearEditStateAndNoSaveData() {
        int i = this.curEdtItemPosition;
        LogExt.logW("clearEditState curEdtItemPosition = " + i + " ", TAG);
        this.curEdtValue = "";
        for (RecordVoiceWordEntity recordVoiceWordEntity : this.recordWordList) {
            recordVoiceWordEntity.setEtdStatus(false);
            recordVoiceWordEntity.setWordContentTemp(recordVoiceWordEntity.getWordContent());
            LogExt.logE("clearEditStateAndNoSaveData it info = " + recordVoiceWordEntity, TAG);
        }
        this.isEditMode = false;
        this.curEdtItemPosition = -1;
        notifyDataForNoEmpty();
    }

    public final void clearEditStateAndSaveData(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callBack");
        int i = this.curEdtItemPosition;
        LogExt.logW("clearEditState curEdtItemPosition = " + i + " ", TAG);
        int i2 = this.curEdtItemPosition;
        if (i2 != -1) {
            this.recordWordList.get(i2).setWordContentTemp(this.curEdtValue);
        }
        this.curEdtValue = "";
        StringBuffer stringBuffer = new StringBuffer();
        for (RecordVoiceWordEntity recordVoiceWordEntity : this.recordWordList) {
            recordVoiceWordEntity.setEtdStatus(false);
            recordVoiceWordEntity.setWordContent(recordVoiceWordEntity.getWordContentTemp());
            stringBuffer.append(recordVoiceWordEntity.getWordContentTemp());
            LogExt.logE("clearEditStateAndSaveData it info = " + recordVoiceWordEntity, TAG);
        }
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailHistoryViewAdapter$clearEditStateAndSaveData$2(this, stringBuffer, function0, (Continuation<? super FastRecordDetailHistoryViewAdapter$clearEditStateAndSaveData$2>) null), 3, (Object) null);
        this.isEditMode = false;
        this.curEdtItemPosition = -1;
        notifyDataForNoEmpty();
    }

    @NotNull
    public final String getAllContentValue() {
        StringBuffer stringBuffer = new StringBuffer();
        for (RecordVoiceWordEntity wordContent : this.recordWordList) {
            stringBuffer.append(wordContent.getWordContent());
            stringBuffer.append("\n\n");
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
        return stringBuffer2;
    }

    public final int getEdtItemPosition() {
        return this.curEdtItemPosition;
    }

    public int getItemCount() {
        return this.recordWordList.size();
    }

    public int getItemViewType(int i) {
        return i;
    }

    public final long getPositionStartTime(int i) {
        return this.recordWordList.get(i).getStartTime();
    }

    public final boolean hasData() {
        return !this.recordWordList.isEmpty();
    }

    public final void selectRecyclerViewItem(long j) {
        Long l = null;
        RecordVoiceWordEntity recordVoiceWordEntity = null;
        int i = 0;
        int i2 = 0;
        for (T next : this.recordWordList) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            RecordVoiceWordEntity recordVoiceWordEntity2 = (RecordVoiceWordEntity) next;
            if (j < recordVoiceWordEntity2.getStartTime() || j > recordVoiceWordEntity2.getEndTime()) {
                recordVoiceWordEntity2.setSelect(false);
            } else {
                recordVoiceWordEntity2.setSelect(true);
                i2 = i;
                recordVoiceWordEntity = recordVoiceWordEntity2;
            }
            i = i3;
        }
        if (recordVoiceWordEntity == null || recordVoiceWordEntity.equals(this.curSelectData)) {
            RecordVoiceWordEntity recordVoiceWordEntity3 = this.curSelectData;
            if (recordVoiceWordEntity3 == null) {
                return;
            }
            if (j < recordVoiceWordEntity3.getStartTime() || j > recordVoiceWordEntity3.getEndTime()) {
                int indexForList = getIndexForList(recordVoiceWordEntity3);
                if (indexForList >= 0) {
                    notifyItemChanged(indexForList);
                }
                this.curSelectData = null;
                return;
            }
            return;
        }
        notifyDataForNoEmpty();
        this.curSelectData = recordVoiceWordEntity;
        ItemClickListener itemClickListener = this.mListener;
        if (itemClickListener != null) {
            itemClickListener.scrollToPosition(i2);
        }
        RecordVoiceWordEntity recordVoiceWordEntity4 = this.curSelectData;
        if (recordVoiceWordEntity4 != null) {
            l = Long.valueOf(recordVoiceWordEntity4.getWordId());
        }
        LogExt.logE("curSelectData?.equals(tempCurSelectData) == false position = " + j + ", wordId = " + l, TAG);
    }

    public final void setAllPersonTagList(@Nullable List<RecordPersonEntity> list) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        this.personOtherTagString = "";
        this.personSelfTagString = "";
        this.personOtherTagList.clear();
        this.personSelfTagList.clear();
        if (list != null) {
            int i = 0;
            int i2 = 0;
            for (T next : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                RecordPersonEntity recordPersonEntity = (RecordPersonEntity) next;
                LogExt.logE("setAllPersonTagList recordContentTagEntity = " + recordPersonEntity, TAG);
                if (Intrinsics.areEqual((Object) RecordConstants.SCENE_PHONE_OTHER, (Object) recordPersonEntity.getPersonType())) {
                    this.personOtherTagList.add(recordPersonEntity);
                } else {
                    this.personSelfTagList.add(recordPersonEntity);
                }
                i2 = i3;
            }
            int i4 = 0;
            for (T next2 : this.personOtherTagList) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                RecordPersonEntity recordPersonEntity2 = (RecordPersonEntity) next2;
                if (i4 != this.personOtherTagList.size() - 1) {
                    stringBuffer.append(recordPersonEntity2.getPersonName());
                    stringBuffer.append("、");
                } else {
                    stringBuffer.append(recordPersonEntity2.getPersonName());
                }
                i4 = i5;
            }
            for (T next3 : this.personSelfTagList) {
                int i6 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                RecordPersonEntity recordPersonEntity3 = (RecordPersonEntity) next3;
                if (i != this.personSelfTagList.size() - 1) {
                    stringBuffer2.append(recordPersonEntity3.getPersonName());
                    stringBuffer2.append("、");
                } else {
                    stringBuffer2.append(recordPersonEntity3.getPersonName());
                }
                i = i6;
            }
            String stringBuffer3 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer3, "toString(...)");
            this.personOtherTagString = stringBuffer3;
            String stringBuffer4 = stringBuffer2.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer4, "toString(...)");
            this.personSelfTagString = stringBuffer4;
        }
        notifyDataForNoEmpty();
        LogExt.logW("setAllPersonTagList personOtherTagString =" + this.personOtherTagString + ",personSelfTagString = " + this.personSelfTagString, TAG);
    }

    public final void setData(@NotNull List<RecordVoiceWordEntity> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.curEdtItemPosition = -1;
        this.curEdtValue = "";
        this.recordWordList.clear();
        this.recordWordList.addAll(list);
        notifyDataForNoEmpty();
    }

    public final void setItemListener(@NotNull ItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener = itemClickListener;
    }

    public final void setRecordWordLanguageType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c(TAG, "setRecordWordLanguageType type = " + str);
        this.recordWordLanguageType = str;
    }

    public final void setShowSoftInput(boolean z) {
        this.isShowSoftInput = z;
    }

    @SuppressLint({"RtlHardcoded"})
    public void onBindViewHolder(@NotNull FastRecordDealViewHolder fastRecordDealViewHolder, @SuppressLint({"RecyclerView"}) int i) {
        Intrinsics.checkNotNullParameter(fastRecordDealViewHolder, "holder");
        RecordVoiceWordEntity recordVoiceWordEntity = this.recordWordList.get(i);
        String str = this.recordWordLanguageType;
        LogExt.logE("position = " + i + ", recordWordList[position] = " + recordVoiceWordEntity + ",recordWordLanguageType = " + str, TAG);
        boolean isRtlLanguage = RecordVoiceUtils.INSTANCE.isRtlLanguage(this.recordWordLanguageType);
        ULog.Delegate delegate = ULog.f6446a;
        String str2 = this.recordWordLanguageType;
        delegate.c(TAG, "isRtlLanguage = " + isRtlLanguage + ",recordWordLanguageType = " + str2);
        if (isRtlLanguage) {
            fastRecordDealViewHolder.itemView.setLayoutDirection(1);
        } else {
            fastRecordDealViewHolder.itemView.setLayoutDirection(0);
        }
        setPaddingValue(i, fastRecordDealViewHolder.getRootView());
        RecordVoiceWordEntity recordVoiceWordEntity2 = this.recordWordList.get(i);
        Intrinsics.checkNotNullExpressionValue(recordVoiceWordEntity2, "get(...)");
        RecordVoiceWordEntity recordVoiceWordEntity3 = recordVoiceWordEntity2;
        showContentColor(recordVoiceWordEntity3, fastRecordDealViewHolder.getEdtContent(), fastRecordDealViewHolder.getTvContent());
        setContentValue(recordVoiceWordEntity3, fastRecordDealViewHolder.getEdtContent(), fastRecordDealViewHolder.getTvContent());
        if (TextUtils.isEmpty(recordVoiceWordEntity3.getWordContent())) {
            fastRecordDealViewHolder.getTvContent().setVisibility(8);
            fastRecordDealViewHolder.getEdtContent().setVisibility(8);
            fastRecordDealViewHolder.getIvRoleType().setVisibility(8);
            fastRecordDealViewHolder.getIvRoleTagType().setVisibility(8);
            fastRecordDealViewHolder.getTvRoleTagType().setVisibility(8);
        } else if (recordVoiceWordEntity3.isEtdStatus()) {
            fastRecordDealViewHolder.getEdtContent().setVisibility(0);
            fastRecordDealViewHolder.getTvContent().setVisibility(8);
            fastRecordDealViewHolder.getEdtContent().requestFocus();
            fastRecordDealViewHolder.getEdtContent().setSelection(String.valueOf(fastRecordDealViewHolder.getEdtContent().getText()).length());
            this.curEdtItemPosition = i;
            setEdtPasteListener(fastRecordDealViewHolder.getEdtContent(), i);
            showInput(fastRecordDealViewHolder.getEdtContent());
        } else {
            fastRecordDealViewHolder.getEdtContent().setVisibility(8);
            fastRecordDealViewHolder.getTvContent().setVisibility(0);
        }
        fastRecordDealViewHolder.getEdtContent().setGravity(8388627);
        fastRecordDealViewHolder.getEdtContent().setTextAlignment(5);
        fastRecordDealViewHolder.getTvContent().setGravity(8388627);
        fastRecordDealViewHolder.getTvContent().setTextAlignment(5);
        showRoleTypeColor(fastRecordDealViewHolder.getIvRoleType(), recordVoiceWordEntity3);
        showRoleTypeIv(recordVoiceWordEntity3, fastRecordDealViewHolder.getIvRoleType());
        showRoleTypeInfo(recordVoiceWordEntity3, fastRecordDealViewHolder.getIvRoleTagType(), fastRecordDealViewHolder.getTvRoleTagType(), fastRecordDealViewHolder.getIvRoleType());
    }

    @NotNull
    public FastRecordDealViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.mContext = context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.fast_record_history_detail_item_info, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        return new FastRecordDealViewHolder(this, inflate);
    }
}
