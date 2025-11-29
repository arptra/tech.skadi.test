package com.upuphone.ar.translation.phone.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.eventtrack.EventTrackingHelper;
import com.upuphone.ar.translation.eventtrack.event.ClickEvent;
import com.upuphone.ar.translation.ext.AnyExtKt;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.bean.NoteDetailBean;
import com.upuphone.ar.translation.phone.bean.TransRecord;
import com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding;
import com.upuphone.ar.translation.phone.databinding.ItemDetailListHeadBinding;
import com.upuphone.ar.translation.phone.view.TranslatorLoadingView;
import com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel;
import com.upuphone.ar.translation.utils.JsonUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 :2\u00020\u0001:\u0001:B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\nH\u0003J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0002J\b\u0010%\u001a\u00020\u0017H\u0002J\b\u0010&\u001a\u00020\u0017H\u0002J\b\u0010'\u001a\u00020\u0017H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J\u0012\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020\u0019H\u0014J\u0018\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u000fH\u0002J(\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0017H\u0002J\b\u00108\u001a\u00020\u0019H\u0002J\b\u00109\u001a\u00020\u0019H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006;"}, d2 = {"Lcom/upuphone/ar/translation/phone/activity/TranslatorRecordActivity;", "Lcom/upuphone/ar/translation/phone/activity/TranslatorBaseActivity;", "()V", "mAdapter", "Lcom/upuphone/ar/translation/phone/adapter/NoteDetailAdapter;", "mBinding", "Lcom/upuphone/ar/translation/phone/databinding/ActivityTranslatorRecordBinding;", "mListHeadBinding", "Lcom/upuphone/ar/translation/phone/databinding/ItemDetailListHeadBinding;", "mNoteBean", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "mOriginalRecordContent", "", "mOriginalRecordTitle", "mRecordType", "", "mTranslatorRecordVm", "Lcom/upuphone/ar/translation/phone/vm/TranslatorRecordViewModel;", "getMTranslatorRecordVm", "()Lcom/upuphone/ar/translation/phone/vm/TranslatorRecordViewModel;", "mTranslatorRecordVm$delegate", "Lkotlin/Lazy;", "checkRecordEdited", "", "clickSmartExtraction", "", "handleListData", "noteBean", "handleSmartExtraction", "handleTextData", "initData", "initListener", "initViewModels", "initialRecyclerView", "isListRecordBlank", "isListRecordEdited", "isListRecordUpdated", "isListTitleBlank", "isListTitleUpdated", "isTextRecordUpdated", "isTextTitleBlank", "isTextTitleUpdated", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onListRecordChanged", "position", "editable", "Landroid/text/Editable;", "refreshListDeleteStatus", "updateEditStatus", "editType", "titleEnableEdit", "recordEnableEdit", "isContentUpdated", "updateListRecord", "updateTextRecord", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTranslatorRecordActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslatorRecordActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorRecordActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,934:1\n75#2,13:935\n262#3,2:948\n*S KotlinDebug\n*F\n+ 1 TranslatorRecordActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorRecordActivity\n*L\n76#1:935,13\n239#1:948,2\n*E\n"})
public final class TranslatorRecordActivity extends TranslatorBaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int EDIT_RECORD = 2;
    private static final int EDIT_TITLE = 1;
    private static final int RECORD_TYPE_LIST = 2;
    private static final int RECORD_TYPE_TEXT = 1;
    @NotNull
    private static final String TAG = "TranslatorRecordActivity";
    /* access modifiers changed from: private */
    @Nullable
    public NoteDetailAdapter mAdapter;
    /* access modifiers changed from: private */
    public ActivityTranslatorRecordBinding mBinding;
    /* access modifiers changed from: private */
    public ItemDetailListHeadBinding mListHeadBinding;
    /* access modifiers changed from: private */
    @Nullable
    public NoteBean mNoteBean;
    /* access modifiers changed from: private */
    @NotNull
    public String mOriginalRecordContent = "";
    /* access modifiers changed from: private */
    @NotNull
    public String mOriginalRecordTitle = "";
    /* access modifiers changed from: private */
    public int mRecordType;
    @NotNull
    private final Lazy mTranslatorRecordVm$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(TranslatorRecordViewModel.class), new TranslatorRecordActivity$special$$inlined$viewModels$default$2(this), new TranslatorRecordActivity$special$$inlined$viewModels$default$1(this), new TranslatorRecordActivity$special$$inlined$viewModels$default$3((Function0) null, this));

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/translation/phone/activity/TranslatorRecordActivity$Companion;", "", "()V", "EDIT_RECORD", "", "EDIT_TITLE", "RECORD_TYPE_LIST", "RECORD_TYPE_TEXT", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final boolean checkRecordEdited() {
        int i = this.mRecordType;
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            boolean isListTitleUpdated = isListTitleUpdated();
            boolean isListTitleBlank = isListTitleBlank();
            boolean isListRecordUpdated = isListRecordUpdated();
            boolean isListRecordBlank = isListRecordBlank();
            LogExt.g("checkRecordEdited list[titleUpdated=" + isListTitleUpdated + ", titleBlank=" + isListTitleBlank + ", recordUpdated=" + isListRecordUpdated + ", recordBlank=" + isListRecordBlank + "]", TAG);
            if (!isListTitleUpdated && !isListTitleBlank && !isListRecordUpdated) {
                return false;
            }
            getMTranslatorRecordVm().V(this);
        } else if (!isTextTitleUpdated() && !isTextRecordUpdated() && !isTextTitleBlank()) {
            return false;
        } else {
            getMTranslatorRecordVm().V(this);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void clickSmartExtraction() {
        NoteBean noteBean = this.mNoteBean;
        if (noteBean != null) {
            LogExt.j("1. [Start] clickSmartExtraction " + noteBean, TAG);
            NoteBean noteBean2 = (NoteBean) AnyExtKt.a(noteBean, NoteBean.class);
            noteBean2.setSrcContent("");
            noteBean2.setDstContent("");
            LogExt.j("2. [End] clickSmartExtraction " + noteBean2, TAG);
            if (getMTranslatorRecordVm().I(noteBean2)) {
                Intent intent = new Intent(this, TranslatorIntelExtnActivity.class);
                intent.putExtra(TranslatorConstants.TRANSFER_TRANS_RECORD, noteBean2);
                startActivity(intent);
                return;
            }
            getMTranslatorRecordVm().M(TranslatorConstants.isIntlVersion() ? R.string.tl_intel_extn_not_support_intl : R.string.tl_intel_extn_not_support);
        }
    }

    /* access modifiers changed from: private */
    public final TranslatorRecordViewModel getMTranslatorRecordVm() {
        return (TranslatorRecordViewModel) this.mTranslatorRecordVm$delegate.getValue();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NotifyDataSetChanged"})
    public final void handleListData(NoteBean noteBean) {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorRecordActivity$handleListData$1(this, noteBean, (Continuation<? super TranslatorRecordActivity$handleListData$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        if ((!kotlin.text.StringsKt.isBlank(r6.getDstLanguage())) != false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleSmartExtraction(com.upuphone.ar.translation.phone.bean.NoteBean r6) {
        /*
            r5 = this;
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r0 = r5.mBinding
            r1 = 0
            java.lang.String r2 = "mBinding"
            if (r0 != 0) goto L_0x000b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L_0x000b:
            com.upuphone.ar.translation.phone.view.TransTitleBar r0 = r0.i
            boolean r3 = com.upuphone.ar.translation.constants.TranslatorConstants.isAirPro()
            if (r3 == 0) goto L_0x0020
            java.lang.String r3 = r6.getDstLanguage()
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            r4 = 1
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r4 = 0
        L_0x0021:
            r0.setIconMenu1Visible(r4)
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorRecordBinding r0 = r5.mBinding
            if (r0 != 0) goto L_0x002c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x002d
        L_0x002c:
            r1 = r0
        L_0x002d:
            com.upuphone.ar.translation.phone.view.TransTitleBar r0 = r1.i
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel r5 = r5.getMTranslatorRecordVm()
            boolean r5 = r5.I(r6)
            if (r5 == 0) goto L_0x003c
            int r5 = com.upuphone.ar.translation.phone.R.drawable.tl_icon_ai_enable
            goto L_0x003e
        L_0x003c:
            int r5 = com.upuphone.ar.translation.phone.R.drawable.tl_icon_ai_disable
        L_0x003e:
            r0.setIconMenu1(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity.handleSmartExtraction(com.upuphone.ar.translation.phone.bean.NoteBean):void");
    }

    /* access modifiers changed from: private */
    public final void handleTextData(NoteBean noteBean) {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorRecordActivity$handleTextData$1(this, noteBean, (Continuation<? super TranslatorRecordActivity$handleTextData$1>) null), 2, (Object) null);
    }

    private final void initData() {
        EventTrackingHelper.f6200a.b(new ClickEvent(8, 0, 2, (DefaultConstructorMarker) null));
        long longExtra = getIntent().getLongExtra(TranslatorConstants.TRANSLATION_RECORD_ITEM_ID, -1);
        LogExt.j("initData recordId=" + longExtra, TAG);
        if (longExtra != -1) {
            ActivityTranslatorRecordBinding activityTranslatorRecordBinding = this.mBinding;
            if (activityTranslatorRecordBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                activityTranslatorRecordBinding = null;
            }
            TranslatorLoadingView translatorLoadingView = activityTranslatorRecordBinding.e;
            Intrinsics.checkNotNullExpressionValue(translatorLoadingView, "loadingView");
            translatorLoadingView.setVisibility(0);
            getMTranslatorRecordVm().y(longExtra, new TranslatorRecordActivity$initData$1(this));
        }
    }

    private final void initListener() {
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding = this.mBinding;
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding2 = null;
        if (activityTranslatorRecordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorRecordBinding = null;
        }
        activityTranslatorRecordBinding.i.l(new TranslatorRecordActivity$initListener$1(this));
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        OnBackPressedDispatcherKt.a(onBackPressedDispatcher, this, true, new TranslatorRecordActivity$initListener$2(this));
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding3 = this.mBinding;
        if (activityTranslatorRecordBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorRecordBinding3 = null;
        }
        activityTranslatorRecordBinding3.i.r(new TranslatorRecordActivity$initListener$3(this));
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding4 = this.mBinding;
        if (activityTranslatorRecordBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorRecordBinding4 = null;
        }
        activityTranslatorRecordBinding4.i.n(new TranslatorRecordActivity$initListener$4(this));
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding5 = this.mBinding;
        if (activityTranslatorRecordBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorRecordBinding5 = null;
        }
        activityTranslatorRecordBinding5.i.p(new TranslatorRecordActivity$initListener$5(this));
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding6 = this.mBinding;
        if (activityTranslatorRecordBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranslatorRecordBinding2 = activityTranslatorRecordBinding6;
        }
        activityTranslatorRecordBinding2.i.t(new TranslatorRecordActivity$initListener$6(this));
    }

    private final void initViewModels() {
        getMTranslatorRecordVm().x().observe(this, new TranslatorRecordActivity$sam$androidx_lifecycle_Observer$0(new TranslatorRecordActivity$initViewModels$1(this)));
        getMTranslatorRecordVm().w().observe(this, new TranslatorRecordActivity$sam$androidx_lifecycle_Observer$0(new TranslatorRecordActivity$initViewModels$2(this)));
    }

    /* access modifiers changed from: private */
    public final void initialRecyclerView() {
        NoteDetailAdapter noteDetailAdapter = new NoteDetailAdapter(TranslatorConstants.isAirPro(), new ArrayList(), new TranslatorRecordActivity$initialRecyclerView$1(this), new TranslatorRecordActivity$initialRecyclerView$2(this));
        Boolean bool = (Boolean) getMTranslatorRecordVm().w().getValue();
        if (bool != null) {
            boolean f = ContextExtKt.f(this);
            LogExt.j("init recycler isListTextRtl=" + bool + ", isViewRtl=" + f, TAG);
            Intrinsics.checkNotNull(bool);
            noteDetailAdapter.R0(bool.booleanValue(), f);
        }
        this.mAdapter = noteDetailAdapter;
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding = this.mBinding;
        ItemDetailListHeadBinding itemDetailListHeadBinding = null;
        if (activityTranslatorRecordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorRecordBinding = null;
        }
        activityTranslatorRecordBinding.h.setLayoutManager(new LinearLayoutManager(this, 1, false));
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding2 = this.mBinding;
        if (activityTranslatorRecordBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorRecordBinding2 = null;
        }
        activityTranslatorRecordBinding2.h.setItemAnimator((RecyclerView.ItemAnimator) null);
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding3 = this.mBinding;
        if (activityTranslatorRecordBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorRecordBinding3 = null;
        }
        activityTranslatorRecordBinding3.h.setNestedScrollingEnabled(false);
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding4 = this.mBinding;
        if (activityTranslatorRecordBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorRecordBinding4 = null;
        }
        activityTranslatorRecordBinding4.h.setAdapter(this.mAdapter);
        ItemDetailListHeadBinding c = ItemDetailListHeadBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.mListHeadBinding = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListHeadBinding");
            c = null;
        }
        c.b.setEnableClickEdit(TranslatorConstants.isAirPro());
        NoteDetailAdapter noteDetailAdapter2 = this.mAdapter;
        if (noteDetailAdapter2 != null) {
            ItemDetailListHeadBinding itemDetailListHeadBinding2 = this.mListHeadBinding;
            if (itemDetailListHeadBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListHeadBinding");
            } else {
                itemDetailListHeadBinding = itemDetailListHeadBinding2;
            }
            ConstraintLayout b = itemDetailListHeadBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
            BaseQuickAdapter.u(noteDetailAdapter2, b, 0, 0, 6, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isListRecordBlank() {
        /*
            r3 = this;
            com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter r3 = r3.mAdapter
            if (r3 == 0) goto L_0x0009
            java.util.List r3 = r3.getData()
            goto L_0x000a
        L_0x0009:
            r3 = 0
        L_0x000a:
            r0 = 1
            if (r3 == 0) goto L_0x0032
            boolean r1 = r3.isEmpty()
            if (r1 == 0) goto L_0x0014
            goto L_0x0032
        L_0x0014:
            java.util.Iterator r3 = r3.iterator()
        L_0x0018:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r3.next()
            com.upuphone.ar.translation.phone.bean.NoteDetailBean r1 = (com.upuphone.ar.translation.phone.bean.NoteDetailBean) r1
            int r2 = r1.getNoteStatus()
            if (r2 == 0) goto L_0x0030
            int r1 = r1.getNoteStatus()
            if (r1 != r0) goto L_0x0018
        L_0x0030:
            r3 = 0
            return r3
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity.isListRecordBlank():boolean");
    }

    /* access modifiers changed from: private */
    public final boolean isListRecordEdited() {
        NoteDetailAdapter noteDetailAdapter = this.mAdapter;
        List<NoteDetailBean> data = noteDetailAdapter != null ? noteDetailAdapter.getData() : null;
        if (data != null && !data.isEmpty()) {
            for (NoteDetailBean editStatus : data) {
                if (editStatus.getEditStatus() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isListRecordUpdated() {
        /*
            r4 = this;
            com.upuphone.ar.translation.phone.adapter.NoteDetailAdapter r4 = r4.mAdapter
            if (r4 == 0) goto L_0x0009
            java.util.List r4 = r4.getData()
            goto L_0x000a
        L_0x0009:
            r4 = 0
        L_0x000a:
            r0 = 0
            if (r4 == 0) goto L_0x0033
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto L_0x0014
            goto L_0x0033
        L_0x0014:
            java.util.Iterator r4 = r4.iterator()
        L_0x0018:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0033
            java.lang.Object r1 = r4.next()
            com.upuphone.ar.translation.phone.bean.NoteDetailBean r1 = (com.upuphone.ar.translation.phone.bean.NoteDetailBean) r1
            int r2 = r1.getNoteStatus()
            r3 = 1
            if (r2 == r3) goto L_0x0032
            int r1 = r1.getNoteStatus()
            r2 = 2
            if (r1 != r2) goto L_0x0018
        L_0x0032:
            return r3
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity.isListRecordUpdated():boolean");
    }

    /* access modifiers changed from: private */
    public final boolean isListTitleBlank() {
        ItemDetailListHeadBinding itemDetailListHeadBinding = this.mListHeadBinding;
        if (itemDetailListHeadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListHeadBinding");
            itemDetailListHeadBinding = null;
        }
        return StringsKt.isBlank(String.valueOf(itemDetailListHeadBinding.b.getText()));
    }

    /* access modifiers changed from: private */
    public final boolean isListTitleUpdated() {
        ItemDetailListHeadBinding itemDetailListHeadBinding = this.mListHeadBinding;
        if (itemDetailListHeadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListHeadBinding");
            itemDetailListHeadBinding = null;
        }
        String valueOf = String.valueOf(itemDetailListHeadBinding.b.getText());
        return !Intrinsics.areEqual((Object) valueOf, (Object) this.mOriginalRecordTitle) && (StringsKt.isBlank(valueOf) ^ true);
    }

    /* access modifiers changed from: private */
    public final boolean isTextRecordUpdated() {
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding = this.mBinding;
        if (activityTranslatorRecordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorRecordBinding = null;
        }
        return !Intrinsics.areEqual((Object) String.valueOf(activityTranslatorRecordBinding.c.getText()), (Object) this.mOriginalRecordContent);
    }

    /* access modifiers changed from: private */
    public final boolean isTextTitleBlank() {
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding = this.mBinding;
        if (activityTranslatorRecordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorRecordBinding = null;
        }
        return StringsKt.isBlank(String.valueOf(activityTranslatorRecordBinding.d.getText()));
    }

    /* access modifiers changed from: private */
    public final boolean isTextTitleUpdated() {
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding = this.mBinding;
        if (activityTranslatorRecordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorRecordBinding = null;
        }
        String valueOf = String.valueOf(activityTranslatorRecordBinding.d.getText());
        return !Intrinsics.areEqual((Object) valueOf, (Object) this.mOriginalRecordTitle) && (StringsKt.isBlank(valueOf) ^ true);
    }

    /* access modifiers changed from: private */
    public final void onListRecordChanged(int i, Editable editable) {
        NoteDetailAdapter noteDetailAdapter = this.mAdapter;
        if (noteDetailAdapter != null) {
            NoteDetailBean noteDetailBean = (NoteDetailBean) noteDetailAdapter.getData().get(i);
            getMTranslatorRecordVm().K(noteDetailBean.getSpeaker(), editable, new TranslatorRecordActivity$onListRecordChanged$1$1(noteDetailBean, noteDetailAdapter, i, this));
        }
    }

    /* access modifiers changed from: private */
    public final void refreshListDeleteStatus(int i) {
        NoteDetailAdapter noteDetailAdapter = this.mAdapter;
        if (noteDetailAdapter != null) {
            NoteDetailBean noteDetailBean = (NoteDetailBean) noteDetailAdapter.getData().get(i);
            if (noteDetailBean.getNoteStatus() == 2) {
                LogExt.j("refreshListDeleteStatus position=" + i, TAG);
                noteDetailAdapter.j0(i, noteDetailBean);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateEditStatus(int i, boolean z, boolean z2, boolean z3) {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorRecordActivity$updateEditStatus$1(this, i, z, z2, z3, (Continuation<? super TranslatorRecordActivity$updateEditStatus$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void updateListRecord() {
        String str;
        ItemDetailListHeadBinding itemDetailListHeadBinding = this.mListHeadBinding;
        if (itemDetailListHeadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListHeadBinding");
            itemDetailListHeadBinding = null;
        }
        Editable text = itemDetailListHeadBinding.b.getText();
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        String str2 = str;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorRecordActivity$updateListRecord$1(this, str2, booleanRef, booleanRef2, (Continuation<? super TranslatorRecordActivity$updateListRecord$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void updateTextRecord() {
        String str;
        String str2;
        boolean z;
        boolean z2;
        String L;
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding = this.mBinding;
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding2 = null;
        if (activityTranslatorRecordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorRecordBinding = null;
        }
        Editable text = activityTranslatorRecordBinding.d.getText();
        String str3 = "";
        if (text == null || (str = text.toString()) == null) {
            str = str3;
        }
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding3 = this.mBinding;
        if (activityTranslatorRecordBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorRecordBinding3 = null;
        }
        Editable text2 = activityTranslatorRecordBinding3.c.getText();
        if (text2 == null || (str2 = text2.toString()) == null) {
            str2 = str3;
        }
        NoteBean noteBean = this.mNoteBean;
        boolean z3 = false;
        if (noteBean != null) {
            if (isTextTitleUpdated()) {
                this.mOriginalRecordTitle = str;
                noteBean.setTitle(str);
                z2 = true;
            } else {
                z2 = false;
            }
            if (isTextRecordUpdated()) {
                this.mOriginalRecordContent = str2;
                noteBean.setSrcContent(StringsKt.isBlank(str2) ^ true ? JsonUtils.d(CollectionsKt.mutableListOf(new TransRecord())) : str3);
                if (!StringsKt.isBlank(str2)) {
                    TransRecord transRecord = new TransRecord();
                    transRecord.setRContent(str2);
                    if (!(text2 == null || (L = getMTranslatorRecordVm().L(text2)) == null)) {
                        str3 = L;
                    }
                    transRecord.setRContentIndex(str3);
                    Unit unit = Unit.INSTANCE;
                    str3 = JsonUtils.d(CollectionsKt.mutableListOf(transRecord));
                }
                noteBean.setDstContent(str3);
                z3 = true;
            }
            boolean z4 = z3;
            z3 = z2;
            z = z4;
        } else {
            noteBean = null;
            z = false;
        }
        this.mNoteBean = noteBean;
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding4 = this.mBinding;
        if (activityTranslatorRecordBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorRecordBinding4 = null;
        }
        activityTranslatorRecordBinding4.d.j();
        ActivityTranslatorRecordBinding activityTranslatorRecordBinding5 = this.mBinding;
        if (activityTranslatorRecordBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranslatorRecordBinding2 = activityTranslatorRecordBinding5;
        }
        activityTranslatorRecordBinding2.c.j();
        LogExt.j("updateTextRecord mNoteBean=" + this.mNoteBean, TAG);
        NoteBean noteBean2 = this.mNoteBean;
        if (noteBean2 != null) {
            getMTranslatorRecordVm().Z(noteBean2, z3, z);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityTranslatorRecordBinding c = ActivityTranslatorRecordBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.mBinding = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            c = null;
        }
        setContentView((View) c.getRoot());
        initListener();
        initData();
        initViewModels();
    }

    public void onDestroy() {
        List data;
        super.onDestroy();
        NoteDetailAdapter noteDetailAdapter = this.mAdapter;
        if (!(noteDetailAdapter == null || (data = noteDetailAdapter.getData()) == null)) {
            data.clear();
        }
        this.mNoteBean = null;
        this.mOriginalRecordTitle = "";
        this.mOriginalRecordContent = "";
        this.mRecordType = 0;
    }
}
