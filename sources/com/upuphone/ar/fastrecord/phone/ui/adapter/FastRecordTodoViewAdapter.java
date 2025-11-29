package com.upuphone.ar.fastrecord.phone.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.honey.account.v3.e;
import com.honey.account.v3.f;
import com.honey.account.v3.g;
import com.honey.account.v3.h;
import com.honey.account.v3.i;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.widget.CopyEditText;
import com.upuphone.star.common.phone.UToast;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordTodoViewAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTodoViewAdapter.kt\ncom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordTodoViewAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,442:1\n262#2,2:443\n262#2,2:445\n262#2,2:447\n262#2,2:449\n262#2,2:451\n262#2,2:453\n262#2,2:455\n262#2,2:457\n262#2,2:459\n262#2,2:461\n1855#3,2:463\n215#4,2:465\n*S KotlinDebug\n*F\n+ 1 FastRecordTodoViewAdapter.kt\ncom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordTodoViewAdapter\n*L\n62#1:443,2\n63#1:445,2\n64#1:447,2\n65#1:449,2\n66#1:451,2\n67#1:453,2\n132#1:455,2\n133#1:457,2\n138#1:459,2\n139#1:461,2\n200#1:463,2\n317#1:465,2\n*E\n"})
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 A2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003ABCB\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u0014\u0010\u001b\u001a\u00020\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dJ\u0006\u0010\u001e\u001a\u00020\nJ\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u0006\u0010\"\u001a\u00020\nJ\b\u0010#\u001a\u00020\nH\u0002J\u0006\u0010$\u001a\u00020\nJ\b\u0010%\u001a\u00020\rH\u0002J\b\u0010&\u001a\u00020\rH\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0016J\u000e\u0010(\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\rJ\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016J\u001e\u0010*\u001a\u00020\n2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00060+j\b\u0012\u0004\u0012\u00020\u0006`,J\u0016\u0010-\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u0006J\u001c\u0010/\u001a\u00020\n2\n\u00100\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\rH\u0017J\u001c\u00101\u001a\u00060\u0002R\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\rH\u0016J\b\u00105\u001a\u00020\nH\u0002J\u0010\u00106\u001a\u00020\n2\u0006\u0010\u0018\u001a\u000207H\u0002J)\u00108\u001a\u00020\n2!\u00109\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005J\u001c\u0010:\u001a\u00020\n2\n\u00100\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\rH\u0003J\u000e\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u0014J\u001c\u0010=\u001a\u00020\n2\n\u00100\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u000e\u0010>\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\rJ\u0016\u0010?\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u0006R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordTodoViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordTodoViewAdapter$FastRecordTodoViewHolder;", "()V", "editClearCallback", "Lkotlin/Function1;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordTodoItemEntity;", "Lkotlin/ParameterName;", "name", "data", "", "editValueMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "latestEditPosition", "mContext", "Landroid/content/Context;", "mListener", "Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordTodoViewAdapter$ItemClickListener;", "todoList", "", "addContentEditTextChanged", "contentEdt", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/CopyEditText;", "position", "addData", "list", "", "changeItemToDisEnabled", "changeItemToEditState", "bindingAdapterPosition", "changeToEditState", "clearEditState", "clearItem", "clearMap", "getAllNormalDataSize", "getItemCount", "getItemViewType", "getPositionData", "getTodoIList", "notifyData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "notifyItemDataChange", "model", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "printlnMapValue", "requestSoftInput", "Landroid/widget/EditText;", "setEditClearCallback", "callback", "setEditData", "setItemListener", "listener", "setTodoStatus", "updateFinishInfo", "updateTodoInfo", "todo", "Companion", "FastRecordTodoViewHolder", "ItemClickListener", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTodoViewAdapter extends RecyclerView.Adapter<FastRecordTodoViewHolder> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DELAY_SHOW_TIME = 500;
    @NotNull
    public static final String TAG = "TodoViewAdapter";
    @NotNull
    private Function1<? super RecordTodoItemEntity, Unit> editClearCallback = FastRecordTodoViewAdapter$editClearCallback$1.INSTANCE;
    /* access modifiers changed from: private */
    @NotNull
    public HashMap<Integer, String> editValueMap = new HashMap<>();
    /* access modifiers changed from: private */
    public int latestEditPosition = -1;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    @Nullable
    public ItemClickListener mListener;
    /* access modifiers changed from: private */
    @NotNull
    public List<RecordTodoItemEntity> todoList = new ArrayList();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordTodoViewAdapter$Companion;", "", "()V", "DELAY_SHOW_TIME", "", "TAG", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordTodoViewAdapter$FastRecordTodoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordTodoViewAdapter;Landroid/view/View;)V", "addDealTv", "Landroid/widget/TextView;", "getAddDealTv", "()Landroid/widget/TextView;", "contentEdt", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/CopyEditText;", "getContentEdt", "()Lcom/upuphone/ar/fastrecord/phone/ui/widget/CopyEditText;", "contentItemView", "Landroid/view/ViewGroup;", "getContentItemView", "()Landroid/view/ViewGroup;", "dealTitleTv", "getDealTitleTv", "ivSelect", "Landroid/widget/ImageView;", "getIvSelect", "()Landroid/widget/ImageView;", "tvContent", "getTvContent", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class FastRecordTodoViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final TextView addDealTv;
        @NotNull
        private final CopyEditText contentEdt;
        @NotNull
        private final ViewGroup contentItemView;
        @NotNull
        private final TextView dealTitleTv;
        @NotNull
        private final ImageView ivSelect;
        final /* synthetic */ FastRecordTodoViewAdapter this$0;
        @NotNull
        private final TextView tvContent;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FastRecordTodoViewHolder(@NotNull final FastRecordTodoViewAdapter fastRecordTodoViewAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = fastRecordTodoViewAdapter;
            View findViewById = view.findViewById(R.id.iv_select);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            ImageView imageView = (ImageView) findViewById;
            this.ivSelect = imageView;
            View findViewById2 = view.findViewById(R.id.tv_add_deal);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            TextView textView = (TextView) findViewById2;
            this.addDealTv = textView;
            View findViewById3 = view.findViewById(R.id.tv_title);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.dealTitleTv = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.tv_content);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.tvContent = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.edt_content);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            CopyEditText copyEditText = (CopyEditText) findViewById5;
            this.contentEdt = copyEditText;
            View findViewById6 = view.findViewById(R.id.cl_deal);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.contentItemView = (ViewGroup) findViewById6;
            copyEditText.setOnPasteCallback(new CopyEditText.OnPasteCallback() {
                public boolean onCopy(@Nullable String str) {
                    LogExt.logE("onCopy content = " + str, FastRecordTodoViewAdapter.TAG);
                    UToast.Companion companion = UToast.f6444a;
                    Context access$getMContext$p = fastRecordTodoViewAdapter.mContext;
                    Context context = null;
                    if (access$getMContext$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        access$getMContext$p = null;
                    }
                    Context access$getMContext$p2 = fastRecordTodoViewAdapter.mContext;
                    if (access$getMContext$p2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    } else {
                        context = access$getMContext$p2;
                    }
                    String string = context.getString(R.string.fast_record_copy_success);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    companion.d(access$getMContext$p, string);
                    return true;
                }
            });
            view.setOnLongClickListener(new f(fastRecordTodoViewAdapter, this));
            view.setOnClickListener(new g(fastRecordTodoViewAdapter, this));
            imageView.setOnClickListener(new h(fastRecordTodoViewAdapter, this));
            textView.setOnClickListener(new i(fastRecordTodoViewAdapter, this));
        }

        /* access modifiers changed from: private */
        public static final boolean _init_$lambda$0(FastRecordTodoViewAdapter fastRecordTodoViewAdapter, FastRecordTodoViewHolder fastRecordTodoViewHolder, View view) {
            Intrinsics.checkNotNullParameter(fastRecordTodoViewAdapter, "this$0");
            Intrinsics.checkNotNullParameter(fastRecordTodoViewHolder, "this$1");
            RecordTodoItemEntity recordTodoItemEntity = (RecordTodoItemEntity) fastRecordTodoViewAdapter.todoList.get(fastRecordTodoViewHolder.getBindingAdapterPosition());
            int access$getLatestEditPosition$p = fastRecordTodoViewAdapter.latestEditPosition;
            Object obj = fastRecordTodoViewAdapter.editValueMap.get(Integer.valueOf(fastRecordTodoViewAdapter.latestEditPosition));
            boolean isFinish = recordTodoItemEntity.isFinish();
            int bindingAdapterPosition = fastRecordTodoViewHolder.getBindingAdapterPosition();
            LogExt.logE("setOnLongClickListener latestEditPosition = " + access$getLatestEditPosition$p + " ,editValueMap[latestEditPosition] = " + obj + "itemInfo.isFinish:" + isFinish + " ,position=" + bindingAdapterPosition, FastRecordTodoViewAdapter.TAG);
            if (recordTodoItemEntity.isFinish() || fastRecordTodoViewAdapter.latestEditPosition == fastRecordTodoViewHolder.getBindingAdapterPosition()) {
                return false;
            }
            fastRecordTodoViewAdapter.changeItemToEditState(fastRecordTodoViewHolder.getBindingAdapterPosition());
            ItemClickListener access$getMListener$p = fastRecordTodoViewAdapter.mListener;
            if (access$getMListener$p == null) {
                return false;
            }
            access$getMListener$p.onLongClick(fastRecordTodoViewHolder.getBindingAdapterPosition());
            return false;
        }

        /* access modifiers changed from: private */
        public static final void _init_$lambda$1(FastRecordTodoViewAdapter fastRecordTodoViewAdapter, FastRecordTodoViewHolder fastRecordTodoViewHolder, View view) {
            Intrinsics.checkNotNullParameter(fastRecordTodoViewAdapter, "this$0");
            Intrinsics.checkNotNullParameter(fastRecordTodoViewHolder, "this$1");
            ItemClickListener access$getMListener$p = fastRecordTodoViewAdapter.mListener;
            if (access$getMListener$p != null) {
                access$getMListener$p.onItemClick(fastRecordTodoViewHolder.getBindingAdapterPosition());
            }
            RecordTodoItemEntity recordTodoItemEntity = (RecordTodoItemEntity) fastRecordTodoViewAdapter.todoList.get(fastRecordTodoViewHolder.getBindingAdapterPosition());
            boolean isFinish = recordTodoItemEntity.isFinish();
            int access$getLatestEditPosition$p = fastRecordTodoViewAdapter.latestEditPosition;
            int bindingAdapterPosition = fastRecordTodoViewHolder.getBindingAdapterPosition();
            LogExt.logE("setOnClickListener isFinish = " + isFinish + ",latestEditPosition = " + access$getLatestEditPosition$p + ",bindingAdapterPosition = " + bindingAdapterPosition, FastRecordTodoViewAdapter.TAG);
            if (!recordTodoItemEntity.isFinish() && fastRecordTodoViewAdapter.latestEditPosition != fastRecordTodoViewHolder.getBindingAdapterPosition() && fastRecordTodoViewAdapter.latestEditPosition >= 0) {
                fastRecordTodoViewAdapter.changeItemToEditState(fastRecordTodoViewHolder.getBindingAdapterPosition());
            }
        }

        /* access modifiers changed from: private */
        public static final void _init_$lambda$2(FastRecordTodoViewAdapter fastRecordTodoViewAdapter, FastRecordTodoViewHolder fastRecordTodoViewHolder, View view) {
            Intrinsics.checkNotNullParameter(fastRecordTodoViewAdapter, "this$0");
            Intrinsics.checkNotNullParameter(fastRecordTodoViewHolder, "this$1");
            fastRecordTodoViewAdapter.updateFinishInfo(fastRecordTodoViewHolder.getBindingAdapterPosition());
            ItemClickListener access$getMListener$p = fastRecordTodoViewAdapter.mListener;
            if (access$getMListener$p != null) {
                access$getMListener$p.onTodoSelect(fastRecordTodoViewHolder.getBindingAdapterPosition());
            }
        }

        /* access modifiers changed from: private */
        public static final void _init_$lambda$3(FastRecordTodoViewAdapter fastRecordTodoViewAdapter, FastRecordTodoViewHolder fastRecordTodoViewHolder, View view) {
            ItemClickListener access$getMListener$p;
            Intrinsics.checkNotNullParameter(fastRecordTodoViewAdapter, "this$0");
            Intrinsics.checkNotNullParameter(fastRecordTodoViewHolder, "this$1");
            RecordTodoItemEntity recordTodoItemEntity = (RecordTodoItemEntity) fastRecordTodoViewAdapter.todoList.get(fastRecordTodoViewHolder.getBindingAdapterPosition());
            if (!recordTodoItemEntity.isAddSchedule() && (access$getMListener$p = fastRecordTodoViewAdapter.mListener) != null) {
                access$getMListener$p.addTodo(recordTodoItemEntity, fastRecordTodoViewHolder.getBindingAdapterPosition());
            }
        }

        @NotNull
        public final TextView getAddDealTv() {
            return this.addDealTv;
        }

        @NotNull
        public final CopyEditText getContentEdt() {
            return this.contentEdt;
        }

        @NotNull
        public final ViewGroup getContentItemView() {
            return this.contentItemView;
        }

        @NotNull
        public final TextView getDealTitleTv() {
            return this.dealTitleTv;
        }

        @NotNull
        public final ImageView getIvSelect() {
            return this.ivSelect;
        }

        @NotNull
        public final TextView getTvContent() {
            return this.tvContent;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordTodoViewAdapter$ItemClickListener;", "", "addTodo", "", "recordEntity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordTodoItemEntity;", "position", "", "deleteAllItem", "deleteItem", "onItemClick", "onLongClick", "onTodoSelect", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface ItemClickListener {
        void addTodo(@NotNull RecordTodoItemEntity recordTodoItemEntity, int i);

        void deleteAllItem();

        void deleteItem(@NotNull RecordTodoItemEntity recordTodoItemEntity);

        void onItemClick(int i);

        void onLongClick(int i);

        void onTodoSelect(int i);
    }

    private final void addContentEditTextChanged(CopyEditText copyEditText, int i) {
        if (copyEditText.getTag() == null) {
            copyEditText.setTag(Boolean.TRUE);
            copyEditText.addTextChangedListener(new FastRecordTodoViewAdapter$addContentEditTextChanged$1(this, i));
        }
    }

    /* access modifiers changed from: private */
    public final void changeItemToEditState(int i) {
        int i2 = this.latestEditPosition;
        int size = this.todoList.size();
        int size2 = this.editValueMap.size();
        LogExt.logE("changeItemToEditState bindingAdapterPosition = " + i + ",latestEditPosition = " + i2 + ",size = " + size + ",editValueMap.size = " + size2, TAG);
        printlnMapValue();
        int i3 = this.latestEditPosition;
        if (i3 >= 0 && i3 < this.todoList.size()) {
            this.todoList.get(this.latestEditPosition).setEdit(false);
            CharSequence charSequence = this.editValueMap.get(Integer.valueOf(this.latestEditPosition));
            if (charSequence == null || charSequence.length() == 0) {
                clearItem();
            } else {
                String str = this.editValueMap.get(Integer.valueOf(this.latestEditPosition));
                LogExt.logE("setOnLongClickListener set value = " + str, TAG);
                this.todoList.get(this.latestEditPosition).setContentTemp(this.editValueMap.get(Integer.valueOf(this.latestEditPosition)));
            }
            notifyItemChanged(this.latestEditPosition);
        }
        changeToEditState(i);
    }

    private final void changeToEditState(int i) {
        LogExt.logE("changeToEditState position = " + i, TAG);
        if (i >= 0 && i < this.todoList.size()) {
            this.todoList.get(i).setEdit(true);
            notifyItemChanged(i);
            this.latestEditPosition = i;
            HashMap<Integer, String> hashMap = this.editValueMap;
            Integer valueOf = Integer.valueOf(i);
            String contentTemp = this.todoList.get(i).getContentTemp();
            if (contentTemp == null) {
                contentTemp = "";
            }
            hashMap.put(valueOf, contentTemp);
        }
    }

    private final void clearItem() {
        ItemClickListener itemClickListener = this.mListener;
        if (itemClickListener != null) {
            itemClickListener.deleteItem(this.todoList.get(this.latestEditPosition));
        }
        notifyItemRemoved(this.latestEditPosition);
        this.todoList.remove(this.latestEditPosition);
        this.editValueMap.remove(Integer.valueOf(this.latestEditPosition));
        this.latestEditPosition = -1;
        if (getAllNormalDataSize() <= 0) {
            ItemClickListener itemClickListener2 = this.mListener;
            if (itemClickListener2 != null) {
                itemClickListener2.deleteAllItem();
            }
            this.todoList.clear();
            notifyDataSetChanged();
        }
    }

    private final int getAllNormalDataSize() {
        return this.todoList.size();
    }

    private final void printlnMapValue() {
        for (Map.Entry next : this.editValueMap.entrySet()) {
            int intValue = ((Number) next.getKey()).intValue();
            LogExt.logW("printlnMapValue index = " + intValue + ",dataValue= " + ((String) next.getValue()), TAG);
        }
    }

    private final void requestSoftInput(EditText editText) {
        LogExt.logE("showSoftInput Enter ", TAG);
        editText.postDelayed(new e(editText, this), 500);
    }

    /* access modifiers changed from: private */
    public static final void requestSoftInput$lambda$2(EditText editText, FastRecordTodoViewAdapter fastRecordTodoViewAdapter) {
        Intrinsics.checkNotNullParameter(editText, "$contentEdt");
        Intrinsics.checkNotNullParameter(fastRecordTodoViewAdapter, "this$0");
        LogExt.logE("showSoftInput processing ... ", TAG);
        editText.requestFocus();
        editText.setSelection(editText.getText().toString().length());
        Context context = fastRecordTodoViewAdapter.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        LogExt.logE("showSoftInput end ", TAG);
    }

    @SuppressLint({"SetTextI18n"})
    private final void setEditData(FastRecordTodoViewHolder fastRecordTodoViewHolder, int i) {
        RecordTodoItemEntity recordTodoItemEntity = this.todoList.get(i);
        LogExt.logE("onBindViewHolder todo:" + recordTodoItemEntity, TAG);
        fastRecordTodoViewHolder.getDealTitleTv().setText(recordTodoItemEntity.getTodoTitle());
        fastRecordTodoViewHolder.getContentEdt().setText(recordTodoItemEntity.getContentTemp());
        fastRecordTodoViewHolder.getTvContent().setText(recordTodoItemEntity.getContentTemp());
        addContentEditTextChanged(fastRecordTodoViewHolder.getContentEdt(), i);
        if (recordTodoItemEntity.isEdit()) {
            fastRecordTodoViewHolder.getTvContent().setVisibility(8);
            fastRecordTodoViewHolder.getContentEdt().setVisibility(0);
            fastRecordTodoViewHolder.getContentEdt().requestFocus();
            fastRecordTodoViewHolder.getContentEdt().setSelection(String.valueOf(fastRecordTodoViewHolder.getContentEdt().getText()).length());
            requestSoftInput(fastRecordTodoViewHolder.getContentEdt());
            return;
        }
        fastRecordTodoViewHolder.getTvContent().setVisibility(0);
        fastRecordTodoViewHolder.getContentEdt().setVisibility(8);
    }

    private final void setTodoStatus(FastRecordTodoViewHolder fastRecordTodoViewHolder, int i) {
        RecordTodoItemEntity recordTodoItemEntity = this.todoList.get(i);
        Context context = null;
        if (!recordTodoItemEntity.isAddSchedule()) {
            TextView addDealTv = fastRecordTodoViewHolder.getAddDealTv();
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context2 = null;
            }
            addDealTv.setText(context2.getString(R.string.fast_record_add_deal));
            TextView addDealTv2 = fastRecordTodoViewHolder.getAddDealTv();
            Context context3 = this.mContext;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context3 = null;
            }
            addDealTv2.setTextColor(ContextCompat.getColor(context3, R.color.fast_record_daily_deal_status));
        } else {
            TextView addDealTv3 = fastRecordTodoViewHolder.getAddDealTv();
            Context context4 = this.mContext;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context4 = null;
            }
            addDealTv3.setText(context4.getString(R.string.fast_record_add_deal_finish));
            TextView addDealTv4 = fastRecordTodoViewHolder.getAddDealTv();
            Context context5 = this.mContext;
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context5 = null;
            }
            addDealTv4.setTextColor(ContextCompat.getColor(context5, R.color.fast_record_daily_deal_status_finish));
        }
        if (recordTodoItemEntity.isFinish()) {
            ImageView ivSelect = fastRecordTodoViewHolder.getIvSelect();
            Context context6 = this.mContext;
            if (context6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context6;
            }
            ivSelect.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_fast_record_daily_finish));
            fastRecordTodoViewHolder.getTvContent().setAlpha(0.3f);
            fastRecordTodoViewHolder.getContentEdt().setAlpha(0.3f);
            fastRecordTodoViewHolder.getDealTitleTv().setAlpha(0.3f);
            fastRecordTodoViewHolder.getIvSelect().setAlpha(0.3f);
            fastRecordTodoViewHolder.getAddDealTv().setVisibility(8);
            return;
        }
        ImageView ivSelect2 = fastRecordTodoViewHolder.getIvSelect();
        Context context7 = this.mContext;
        if (context7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context = context7;
        }
        ivSelect2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_fast_record_daily_check_status));
        fastRecordTodoViewHolder.getTvContent().setAlpha(1.0f);
        fastRecordTodoViewHolder.getContentEdt().setAlpha(1.0f);
        fastRecordTodoViewHolder.getDealTitleTv().setAlpha(1.0f);
        fastRecordTodoViewHolder.getIvSelect().setAlpha(1.0f);
        fastRecordTodoViewHolder.getAddDealTv().setVisibility(0);
    }

    public final void addData(@NotNull List<RecordTodoItemEntity> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.todoList.addAll(list);
        notifyDataSetChanged();
    }

    public final void changeItemToDisEnabled() {
        for (RecordTodoItemEntity edit : this.todoList) {
            edit.setEdit(false);
        }
        notifyDataSetChanged();
    }

    public final void clearEditState() {
        int size = this.todoList.size();
        int i = this.latestEditPosition;
        String str = this.editValueMap.get(Integer.valueOf(i));
        LogExt.logW("clearEditState todoList.size = " + size + ", latestEditPosition = " + i + ",editValueMap[latestEditPosition] = " + str, TAG);
        int i2 = this.latestEditPosition;
        if (i2 >= 0 && i2 < this.todoList.size()) {
            this.todoList.get(this.latestEditPosition).setEdit(false);
            CharSequence charSequence = this.editValueMap.get(Integer.valueOf(this.latestEditPosition));
            if (charSequence == null || charSequence.length() == 0) {
                clearItem();
            } else {
                this.todoList.get(this.latestEditPosition).setContentTemp(String.valueOf(this.editValueMap.get(Integer.valueOf(this.latestEditPosition))));
                notifyItemChanged(this.latestEditPosition);
            }
        }
        this.latestEditPosition = -1;
    }

    public final void clearMap() {
        this.editValueMap.clear();
    }

    public int getItemCount() {
        return this.todoList.size();
    }

    public int getItemViewType(int i) {
        return i;
    }

    @NotNull
    public final RecordTodoItemEntity getPositionData(int i) {
        return this.todoList.get(i);
    }

    @NotNull
    public final List<RecordTodoItemEntity> getTodoIList() {
        return this.todoList;
    }

    public final void notifyData(@NotNull ArrayList<RecordTodoItemEntity> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "list");
        this.todoList = arrayList;
        changeItemToDisEnabled();
        notifyDataSetChanged();
    }

    public final void notifyItemDataChange(int i, @NotNull RecordTodoItemEntity recordTodoItemEntity) {
        Intrinsics.checkNotNullParameter(recordTodoItemEntity, "model");
        this.todoList.set(i, recordTodoItemEntity);
        notifyItemChanged(i);
    }

    public final void setEditClearCallback(@NotNull Function1<? super RecordTodoItemEntity, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.editClearCallback = function1;
    }

    public final void setItemListener(@NotNull ItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener = itemClickListener;
    }

    public final void updateFinishInfo(int i) {
        int size = this.todoList.size();
        LogExt.logE("updateFinishInfo position = " + i + ",size = " + size, TAG);
        if (i < this.todoList.size()) {
            this.todoList.get(i).setFinish(!this.todoList.get(i).isFinish());
            notifyItemChanged(i);
        }
    }

    public final void updateTodoInfo(int i, @NotNull RecordTodoItemEntity recordTodoItemEntity) {
        Intrinsics.checkNotNullParameter(recordTodoItemEntity, VuiModelType.TODO);
        int size = this.todoList.size();
        LogExt.logE("updateTodoInfo position = " + i + ",size = " + size, TAG);
        if (i < this.todoList.size()) {
            this.todoList.set(i, recordTodoItemEntity);
            notifyItemChanged(i);
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void onBindViewHolder(@NotNull FastRecordTodoViewHolder fastRecordTodoViewHolder, int i) {
        Intrinsics.checkNotNullParameter(fastRecordTodoViewHolder, "holder");
        int itemViewType = getItemViewType(i);
        fastRecordTodoViewHolder.getContentItemView().setTag(Integer.valueOf(i));
        LogExt.logE("onBindViewHolder begin  position=" + i + ",viewType = " + itemViewType, TAG);
        fastRecordTodoViewHolder.getContentItemView().setVisibility(0);
        fastRecordTodoViewHolder.getTvContent().setVisibility(0);
        fastRecordTodoViewHolder.getIvSelect().setVisibility(0);
        fastRecordTodoViewHolder.getAddDealTv().setVisibility(0);
        fastRecordTodoViewHolder.getDealTitleTv().setVisibility(0);
        fastRecordTodoViewHolder.getContentEdt().setVisibility(8);
        setEditData(fastRecordTodoViewHolder, i);
        setTodoStatus(fastRecordTodoViewHolder, i);
        fastRecordTodoViewHolder.getContentItemView().setBackgroundResource(R.drawable.bg_fast_record_single_item);
        LogExt.logD("onBindViewHolder end", TAG);
    }

    @NotNull
    public FastRecordTodoViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.mContext = context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.fast_record_todo_item_info, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        return new FastRecordTodoViewHolder(this, inflate);
    }
}
