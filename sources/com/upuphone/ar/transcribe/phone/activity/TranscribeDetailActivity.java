package com.upuphone.ar.transcribe.phone.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.WindowInsets;
import android.widget.EditText;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.v4.i;
import com.honey.account.v4.j;
import com.honey.account.v4.k;
import com.honey.account.v4.l;
import com.honey.account.v4.m;
import com.honey.account.v4.n;
import com.honey.account.v4.o;
import com.honey.account.v4.p;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding;
import com.upuphone.ar.transcribe.eventtrack.EventTrackingHelper;
import com.upuphone.ar.transcribe.eventtrack.event.ClickEvent;
import com.upuphone.ar.transcribe.ext.ActivityExtKt;
import com.upuphone.ar.transcribe.ext.ContextExtKt;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.ext.StringExtKt;
import com.upuphone.ar.transcribe.phone.adapter.NoteDetailAdapter;
import com.upuphone.ar.transcribe.phone.bean.NoteDetailBean;
import com.upuphone.ar.transcribe.phone.bean.TransRecord;
import com.upuphone.ar.transcribe.phone.db.entity.MessageEntity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.view.ClipboardEditText;
import com.upuphone.ar.transcribe.phone.view.TbTitleInputFilter;
import com.upuphone.ar.transcribe.utils.GsonUtils;
import com.upuphone.ar.transcribe.utils.JsonUtils;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.star.common.phone.UToast;
import flyme.support.v7.app.AlertDialog;
import flyme.support.v7.util.NavigationBarUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0003J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0012H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\b\u0010'\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\b\u0010*\u001a\u00020 H\u0002J\b\u0010+\u001a\u00020 H\u0002J\b\u0010,\u001a\u00020 H\u0002J\b\u0010-\u001a\u00020\u0019H\u0002J\u0012\u0010.\u001a\u00020\u00192\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\b\u00101\u001a\u00020\u0019H\u0014J\b\u00102\u001a\u00020\u0019H\u0002J \u00103\u001a\u00020\u00192\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0015H\u0002J\b\u00109\u001a\u00020\u0019H\u0002J\b\u0010:\u001a\u00020\u0019H\u0002R\u0012\u0010\u0004\u001a\u00020\u0005X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/TranscribeDetailActivity;", "Lcom/upuphone/ar/transcribe/phone/activity/TranscribeBaseActivity;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "mAdapter", "Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter;", "mBinding", "Lcom/upuphone/ar/transcribe/databinding/ActivityTranscribeDetailBinding;", "mDeleteDataDialog", "Lflyme/support/v7/app/AlertDialog;", "mNoteDetailBeans", "", "Lcom/upuphone/ar/transcribe/phone/bean/NoteDetailBean;", "mTranscribeBean", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "sharedDialog", "transType", "", "updatingMessage", "Lcom/upuphone/ar/transcribe/phone/db/entity/MessageEntity;", "adjustSoftInputHeight", "", "analysisAirData", "src", "", "analysisData", "changeMode", "edit", "", "deleteData", "generateText", "bean", "getAirRecordData", "Landroid/text/SpannableStringBuilder;", "gotoShareActivity", "initData", "initView", "initialRecyclerView", "isEditTextChange", "isInEditModel", "isSupportAi", "jumpToAIPage", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "reSaveData", "scrollToCursorPosition", "editText", "Landroid/widget/EditText;", "scrollView", "Landroidx/core/widget/NestedScrollView;", "imeHeight", "shareRecord", "showRecordEditedDialog", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTranscribeDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeDetailActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeDetailActivity\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,683:1\n58#2,23:684\n93#2,3:707\n58#2,23:710\n93#2,3:733\n1855#3,2:736\n*S KotlinDebug\n*F\n+ 1 TranscribeDetailActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeDetailActivity\n*L\n179#1:684,23\n179#1:707,3\n185#1:710,23\n185#1:733,3\n617#1:736,2\n*E\n"})
public final class TranscribeDetailActivity extends TranscribeBaseActivity implements CoroutineScope {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "TranscribeDetailActivity";
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.b();
    /* access modifiers changed from: private */
    @Nullable
    public NoteDetailAdapter mAdapter;
    /* access modifiers changed from: private */
    public ActivityTranscribeDetailBinding mBinding;
    @Nullable
    private AlertDialog mDeleteDataDialog;
    /* access modifiers changed from: private */
    @NotNull
    public final List<NoteDetailBean> mNoteDetailBeans = new ArrayList();
    /* access modifiers changed from: private */
    @Nullable
    public TranscribeBean mTranscribeBean;
    @Nullable
    private AlertDialog sharedDialog;
    /* access modifiers changed from: private */
    public int transType = 1;
    /* access modifiers changed from: private */
    @Nullable
    public MessageEntity updatingMessage;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/TranscribeDetailActivity$Companion;", "", "()V", "TAG", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void adjustSoftInputHeight() {
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding = this.mBinding;
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding2 = null;
        if (activityTranscribeDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding = null;
        }
        int paddingBottom = activityTranscribeDetailBinding.g.getPaddingBottom();
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding3 = this.mBinding;
        if (activityTranscribeDetailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranscribeDetailBinding2 = activityTranscribeDetailBinding3;
        }
        activityTranscribeDetailBinding2.getRoot().setOnApplyWindowInsetsListener(new p(this, paddingBottom));
    }

    /* access modifiers changed from: private */
    public static final WindowInsets adjustSoftInputHeight$lambda$1(TranscribeDetailActivity transcribeDetailActivity, int i, View view, WindowInsets windowInsets) {
        int i2;
        Intrinsics.checkNotNullParameter(transcribeDetailActivity, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowInsets, "insets");
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding = transcribeDetailActivity.mBinding;
        if (activityTranscribeDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding = null;
        }
        NestedScrollView nestedScrollView = activityTranscribeDetailBinding.g;
        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "nsvText");
        boolean z = false;
        if (Build.VERSION.SDK_INT < 30 ? (i2 = windowInsets.getSystemWindowInsetBottom()) > NavigationBarUtils.getNavigationBarHeight((Activity) transcribeDetailActivity) : (i2 = windowInsets.getInsets(WindowInsetsCompat.Type.a()).bottom) != windowInsets.getInsets(WindowInsetsCompat.Type.f()).bottom) {
            z = true;
        }
        if (z) {
            nestedScrollView.setPadding(nestedScrollView.getPaddingLeft(), nestedScrollView.getPaddingTop(), nestedScrollView.getPaddingRight(), i2);
            nestedScrollView.post(new m(transcribeDetailActivity, i2));
        } else {
            nestedScrollView.setPadding(nestedScrollView.getPaddingLeft(), nestedScrollView.getPaddingTop(), nestedScrollView.getPaddingRight(), i);
        }
        return windowInsets;
    }

    /* access modifiers changed from: private */
    public static final void adjustSoftInputHeight$lambda$1$lambda$0(TranscribeDetailActivity transcribeDetailActivity, int i) {
        Intrinsics.checkNotNullParameter(transcribeDetailActivity, "this$0");
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding = transcribeDetailActivity.mBinding;
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding2 = null;
        if (activityTranscribeDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding = null;
        }
        ClipboardEditText clipboardEditText = activityTranscribeDetailBinding.k;
        Intrinsics.checkNotNullExpressionValue(clipboardEditText, "tvRecord");
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding3 = transcribeDetailActivity.mBinding;
        if (activityTranscribeDetailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranscribeDetailBinding2 = activityTranscribeDetailBinding3;
        }
        NestedScrollView nestedScrollView = activityTranscribeDetailBinding2.g;
        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "nsvText");
        transcribeDetailActivity.scrollToCursorPosition(clipboardEditText, nestedScrollView, i);
    }

    /* access modifiers changed from: private */
    public final void analysisAirData(String str) {
        Job unused = BuildersKt__Builders_commonKt.d(this, Dispatchers.c(), (CoroutineStart) null, new TranscribeDetailActivity$analysisAirData$1(str, this, (Continuation<? super TranscribeDetailActivity$analysisAirData$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NotifyDataSetChanged"})
    public final void analysisData(String str) {
        if (str != null && !StringsKt.isBlank(str) && JsonUtils.a(str)) {
            List b = GsonUtils.b(str, TransRecord.class);
            int size = b.size();
            for (int i = 0; i < size; i++) {
                TransRecord transRecord = (TransRecord) b.get(i);
                NoteDetailBean noteDetailBean = new NoteDetailBean((Long) null, (String) null, 0, (String) null, 15, (DefaultConstructorMarker) null);
                if (transRecord.getRContent().length() > 0) {
                    noteDetailBean.setOwnerType(1);
                    noteDetailBean.setTimestamp(transRecord.getRTime());
                    noteDetailBean.setContent(StringExtKt.a(transRecord.getRContent()));
                } else {
                    noteDetailBean.setOwnerType(0);
                    noteDetailBean.setTimestamp(transRecord.getPTime());
                    noteDetailBean.setContent(StringExtKt.a(transRecord.getPContent()));
                }
                this.mNoteDetailBeans.add(noteDetailBean);
            }
            NoteDetailAdapter noteDetailAdapter = this.mAdapter;
            if (noteDetailAdapter != null) {
                noteDetailAdapter.notifyDataSetChanged();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void changeMode(boolean z) {
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding = null;
        if (z) {
            ActivityTranscribeDetailBinding activityTranscribeDetailBinding2 = this.mBinding;
            if (activityTranscribeDetailBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                activityTranscribeDetailBinding2 = null;
            }
            activityTranscribeDetailBinding2.i.setIconMenuVisible(false);
            ActivityTranscribeDetailBinding activityTranscribeDetailBinding3 = this.mBinding;
            if (activityTranscribeDetailBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                activityTranscribeDetailBinding3 = null;
            }
            activityTranscribeDetailBinding3.i.setIconMenu2Visible(false);
            ActivityTranscribeDetailBinding activityTranscribeDetailBinding4 = this.mBinding;
            if (activityTranscribeDetailBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                activityTranscribeDetailBinding4 = null;
            }
            activityTranscribeDetailBinding4.i.setIconMenu3Visible(false);
            ActivityTranscribeDetailBinding activityTranscribeDetailBinding5 = this.mBinding;
            if (activityTranscribeDetailBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                activityTranscribeDetailBinding5 = null;
            }
            activityTranscribeDetailBinding5.i.setTextMenu(R.string.fast_record_save);
            ActivityTranscribeDetailBinding activityTranscribeDetailBinding6 = this.mBinding;
            if (activityTranscribeDetailBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                activityTranscribeDetailBinding = activityTranscribeDetailBinding6;
            }
            activityTranscribeDetailBinding.i.setTextMenuVisible(true);
            return;
        }
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding7 = this.mBinding;
        if (activityTranscribeDetailBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding7 = null;
        }
        activityTranscribeDetailBinding7.i.setIconMenuVisible(true);
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding8 = this.mBinding;
        if (activityTranscribeDetailBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding8 = null;
        }
        activityTranscribeDetailBinding8.i.setIconMenu2Visible(true);
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding9 = this.mBinding;
        if (activityTranscribeDetailBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding9 = null;
        }
        activityTranscribeDetailBinding9.i.setIconMenu3Visible(true);
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding10 = this.mBinding;
        if (activityTranscribeDetailBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranscribeDetailBinding = activityTranscribeDetailBinding10;
        }
        activityTranscribeDetailBinding.i.setTextMenuVisible(false);
    }

    /* access modifiers changed from: private */
    public final void deleteData() {
        if (this.mDeleteDataDialog == null) {
            this.mDeleteDataDialog = new AlertDialog.Builder(this).setTitle(R.string.trsb_dialog_delete).setMessage(R.string.trsb_dialog_delete_tips).setPositiveButton(R.string.trsb_dialog_delete_ok, (DialogInterface.OnClickListener) new n(this)).setNegativeButton(R.string.trsb_dialog_cancel, (DialogInterface.OnClickListener) new o()).create();
        }
        AlertDialog alertDialog = this.mDeleteDataDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void deleteData$lambda$4(TranscribeDetailActivity transcribeDetailActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(transcribeDetailActivity, "this$0");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(transcribeDetailActivity), Dispatchers.b(), (CoroutineStart) null, new TranscribeDetailActivity$deleteData$1$1(transcribeDetailActivity, (Continuation<? super TranscribeDetailActivity$deleteData$1$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void deleteData$lambda$5(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    private final String generateText(TranscribeBean transcribeBean) {
        List<NoteDetailBean> data;
        LogExt.d("generate Text", TAG);
        StringBuilder sb = new StringBuilder();
        String superTitle = transcribeBean.getSuperTitle();
        if (superTitle == null) {
            superTitle = getString(R.string.transcribe_app_name);
            Intrinsics.checkNotNullExpressionValue(superTitle, "getString(...)");
        }
        sb.append(superTitle + StringUtils.LF);
        String location = transcribeBean.getLocation();
        if (location != null && (!StringsKt.isBlank(location))) {
            sb.append(transcribeBean.getLocation());
            sb.append(StringUtils.LF);
        }
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding = this.mBinding;
        if (activityTranscribeDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding = null;
        }
        CharSequence text = activityTranscribeDetailBinding.l.getText();
        sb.append(text + StringUtils.LF);
        sb.append(StringUtils.LF);
        NoteDetailAdapter noteDetailAdapter = this.mAdapter;
        if (!(noteDetailAdapter == null || (data = noteDetailAdapter.getData()) == null)) {
            for (NoteDetailBean noteDetailBean : data) {
                if (noteDetailBean.getOwnerType() == 1) {
                    sb.append(String.valueOf(getString(R.string.trsb_share_text_other_side)));
                } else {
                    sb.append(String.valueOf(getString(R.string.trsb_share_text_me)));
                }
                String content = noteDetailBean.getContent();
                sb.append(content + StringUtils.LF);
            }
        }
        sb.append(StringUtils.LF);
        sb.append("MYVU");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* access modifiers changed from: private */
    public final SpannableStringBuilder getAirRecordData(String str) {
        List b = GsonUtils.b(str, TransRecord.class);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            TransRecord transRecord = (TransRecord) b.get(i);
            if (i != CollectionsKt.getLastIndex(b)) {
                spannableStringBuilder.append(StringExtKt.a(transRecord.getRContent())).append("\n\n");
            } else {
                spannableStringBuilder.append(StringExtKt.a(transRecord.getRContent()));
            }
        }
        return spannableStringBuilder;
    }

    private final void gotoShareActivity() {
        Job unused = BuildersKt__Builders_commonKt.d(this, Dispatchers.c(), (CoroutineStart) null, new TranscribeDetailActivity$gotoShareActivity$1(this, (Continuation<? super TranscribeDetailActivity$gotoShareActivity$1>) null), 2, (Object) null);
    }

    private final void initData() {
        long longExtra = getIntent().getLongExtra(TranslatorConstants.TRANSLATION_RECORD_ITEM_ID, -1);
        long longExtra2 = getIntent().getLongExtra("trans_search_id", -1);
        LogExt.g("Translation record id=" + longExtra, TAG);
        Job unused = BuildersKt__Builders_commonKt.d(this, Dispatchers.c(), (CoroutineStart) null, new TranscribeDetailActivity$initData$1(longExtra, this, longExtra2, (Continuation<? super TranscribeDetailActivity$initData$1>) null), 2, (Object) null);
        EventTrackingHelper eventTrackingHelper = EventTrackingHelper.f6058a;
        TranscribeBean transcribeBean = this.mTranscribeBean;
        eventTrackingHelper.c(new ClickEvent(8, 0, transcribeBean != null ? transcribeBean.getType() : 1, 2, (DefaultConstructorMarker) null));
    }

    private final void initView() {
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding = this.mBinding;
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding2 = null;
        if (activityTranscribeDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding = null;
        }
        activityTranscribeDetailBinding.i.l(new TranscribeDetailActivity$initView$1(this));
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding3 = this.mBinding;
        if (activityTranscribeDetailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding3 = null;
        }
        activityTranscribeDetailBinding3.i.r(new TranscribeDetailActivity$initView$2(this));
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding4 = this.mBinding;
        if (activityTranscribeDetailBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding4 = null;
        }
        activityTranscribeDetailBinding4.i.n(new TranscribeDetailActivity$initView$3(this));
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding5 = this.mBinding;
        if (activityTranscribeDetailBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding5 = null;
        }
        activityTranscribeDetailBinding5.i.p(new TranscribeDetailActivity$initView$4(this));
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding6 = this.mBinding;
        if (activityTranscribeDetailBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding6 = null;
        }
        activityTranscribeDetailBinding6.i.t(new TranscribeDetailActivity$initView$5(this));
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding7 = this.mBinding;
        if (activityTranscribeDetailBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding7 = null;
        }
        activityTranscribeDetailBinding7.m.h(new TranscribeDetailActivity$initView$6(this));
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding8 = this.mBinding;
        if (activityTranscribeDetailBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding8 = null;
        }
        activityTranscribeDetailBinding8.m.setFilters((InputFilter[]) new TbTitleInputFilter[]{new TbTitleInputFilter()});
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding9 = this.mBinding;
        if (activityTranscribeDetailBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding9 = null;
        }
        ClipboardEditText clipboardEditText = activityTranscribeDetailBinding9.m;
        Intrinsics.checkNotNullExpressionValue(clipboardEditText, "tvTitle");
        clipboardEditText.addTextChangedListener(new TranscribeDetailActivity$initView$$inlined$doAfterTextChanged$1(this));
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding10 = this.mBinding;
        if (activityTranscribeDetailBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding10 = null;
        }
        activityTranscribeDetailBinding10.k.h(new TranscribeDetailActivity$initView$8(this));
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding11 = this.mBinding;
        if (activityTranscribeDetailBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranscribeDetailBinding2 = activityTranscribeDetailBinding11;
        }
        ClipboardEditText clipboardEditText2 = activityTranscribeDetailBinding2.k;
        Intrinsics.checkNotNullExpressionValue(clipboardEditText2, "tvRecord");
        clipboardEditText2.addTextChangedListener(new TranscribeDetailActivity$initView$$inlined$doAfterTextChanged$2(this));
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        OnBackPressedDispatcherKt.a(onBackPressedDispatcher, this, true, new TranscribeDetailActivity$initView$10(this));
        initialRecyclerView();
    }

    private final void initialRecyclerView() {
        this.mAdapter = new NoteDetailAdapter(this.mNoteDetailBeans, new TranscribeDetailActivity$initialRecyclerView$1(this));
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding = this.mBinding;
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding2 = null;
        if (activityTranscribeDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding = null;
        }
        activityTranscribeDetailBinding.h.setLayoutManager(new LinearLayoutManager(this, 1, false));
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding3 = this.mBinding;
        if (activityTranscribeDetailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding3 = null;
        }
        activityTranscribeDetailBinding3.h.setItemAnimator((RecyclerView.ItemAnimator) null);
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding4 = this.mBinding;
        if (activityTranscribeDetailBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding4 = null;
        }
        activityTranscribeDetailBinding4.h.setNestedScrollingEnabled(false);
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding5 = this.mBinding;
        if (activityTranscribeDetailBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranscribeDetailBinding2 = activityTranscribeDetailBinding5;
        }
        activityTranscribeDetailBinding2.h.setAdapter(this.mAdapter);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0077, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) (r5 == null || (r5 = r5.getMessage()) == null || (r6 = com.upuphone.ar.transcribe.ext.StringExtKt.a(r5)) == null) ? null : kotlin.text.StringsKt.replace$default(r6, org.apache.commons.lang3.StringUtils.LF, "\n\n", false, 4, (java.lang.Object) null)) != false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0086, code lost:
        if (r0.G0() == true) goto L_0x0088;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isEditTextChange() {
        /*
            r12 = this;
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r0 = r12.mBinding
            java.lang.String r1 = "mBinding"
            r2 = 0
            if (r0 != 0) goto L_0x000b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x000b:
            com.upuphone.ar.transcribe.phone.view.ClipboardEditText r0 = r0.m
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            r3 = 1
            r0 = r0 ^ r3
            r4 = 0
            if (r0 == 0) goto L_0x008a
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r0 = r12.mBinding
            if (r0 != 0) goto L_0x0026
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0026:
            com.upuphone.ar.transcribe.phone.view.ClipboardEditText r0 = r0.m
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r5 = r12.mTranscribeBean
            if (r5 == 0) goto L_0x0039
            java.lang.String r5 = r5.getSuperTitle()
            goto L_0x003a
        L_0x0039:
            r5 = r2
        L_0x003a:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            if (r0 == 0) goto L_0x0088
            int r0 = r12.transType
            if (r0 != r3) goto L_0x0079
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r0 = r12.mBinding
            if (r0 != 0) goto L_0x004c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x004c:
            com.upuphone.ar.transcribe.phone.view.ClipboardEditText r0 = r0.k
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.upuphone.ar.transcribe.phone.db.entity.MessageEntity r5 = r12.updatingMessage
            if (r5 == 0) goto L_0x0072
            java.lang.String r5 = r5.getMessage()
            if (r5 == 0) goto L_0x0072
            java.lang.String r6 = com.upuphone.ar.transcribe.ext.StringExtKt.a(r5)
            if (r6 == 0) goto L_0x0072
            r10 = 4
            r11 = 0
            java.lang.String r7 = "\n"
            java.lang.String r8 = "\n\n"
            r9 = 0
            java.lang.String r5 = kotlin.text.StringsKt.replace$default((java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (boolean) r9, (int) r10, (java.lang.Object) r11)
            goto L_0x0073
        L_0x0072:
            r5 = r2
        L_0x0073:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            if (r0 == 0) goto L_0x0088
        L_0x0079:
            int r0 = r12.transType
            r5 = 4
            if (r0 != r5) goto L_0x008a
            com.upuphone.ar.transcribe.phone.adapter.NoteDetailAdapter r0 = r12.mAdapter
            if (r0 == 0) goto L_0x008a
            boolean r0 = r0.G0()
            if (r0 != r3) goto L_0x008a
        L_0x0088:
            r0 = r3
            goto L_0x008b
        L_0x008a:
            r0 = r4
        L_0x008b:
            com.upuphone.star.core.log.ULog$Delegate r5 = com.upuphone.star.core.log.ULog.f6446a
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r6 = r12.mBinding
            if (r6 != 0) goto L_0x0095
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r6 = r2
        L_0x0095:
            com.upuphone.ar.transcribe.phone.view.ClipboardEditText r6 = r6.m
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r7 = r12.mTranscribeBean
            if (r7 == 0) goto L_0x00a8
            java.lang.String r7 = r7.getSuperTitle()
            goto L_0x00a9
        L_0x00a8:
            r7 = r2
        L_0x00a9:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            r6 = r6 ^ r3
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r7 = r12.mBinding
            if (r7 != 0) goto L_0x00b6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r7 = r2
        L_0x00b6:
            com.upuphone.ar.transcribe.phone.view.ClipboardEditText r1 = r7.k
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            com.upuphone.ar.transcribe.phone.db.entity.MessageEntity r7 = r12.updatingMessage
            if (r7 == 0) goto L_0x00c8
            java.lang.String r2 = r7.getMessage()
        L_0x00c8:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            r1 = r1 ^ r3
            com.upuphone.ar.transcribe.phone.adapter.NoteDetailAdapter r2 = r12.mAdapter
            if (r2 == 0) goto L_0x00d8
            boolean r2 = r2.G0()
            if (r2 != r3) goto L_0x00d8
            goto L_0x00d9
        L_0x00d8:
            r3 = r4
        L_0x00d9:
            int r12 = r12.transType
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "title change: "
            r2.append(r4)
            r2.append(r6)
            java.lang.String r4 = ", recordChange: "
            r2.append(r4)
            r2.append(r1)
            java.lang.String r1 = ", adapter change: "
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = ", transType: "
            r2.append(r1)
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            java.lang.String r1 = "Trcb-TranscribeDetailActivity"
            r5.a(r1, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity.isEditTextChange():boolean");
    }

    /* access modifiers changed from: private */
    public final boolean isInEditModel() {
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding = this.mBinding;
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding2 = null;
        if (activityTranscribeDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeDetailBinding = null;
        }
        if (activityTranscribeDetailBinding.k.q()) {
            return true;
        }
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding3 = this.mBinding;
        if (activityTranscribeDetailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranscribeDetailBinding2 = activityTranscribeDetailBinding3;
        }
        if (activityTranscribeDetailBinding2.m.q()) {
            return true;
        }
        NoteDetailAdapter noteDetailAdapter = this.mAdapter;
        return noteDetailAdapter != null && noteDetailAdapter.H0();
    }

    /* access modifiers changed from: private */
    public final boolean isSupportAi() {
        int hashCode;
        TranscribeBean transcribeBean = this.mTranscribeBean;
        String language = transcribeBean != null ? transcribeBean.getLanguage() : null;
        return language != null && ((hashCode = language.hashCode()) == 3179 ? language.equals("cn") : !(hashCode == 3201 ? !language.equals("de") : !(hashCode == 3241 ? language.equals("en") : hashCode == 3383 && language.equals("ja"))));
    }

    /* access modifiers changed from: private */
    public final void jumpToAIPage() {
        TranscribeBean transcribeBean = this.mTranscribeBean;
        String str = null;
        if (!Intrinsics.areEqual((Object) transcribeBean != null ? transcribeBean.getLanguage() : null, (Object) "cn")) {
            TranscribeBean transcribeBean2 = this.mTranscribeBean;
            if (!Intrinsics.areEqual((Object) transcribeBean2 != null ? transcribeBean2.getLanguage() : null, (Object) "en")) {
                TranscribeBean transcribeBean3 = this.mTranscribeBean;
                if (!Intrinsics.areEqual((Object) transcribeBean3 != null ? transcribeBean3.getLanguage() : null, (Object) "ja")) {
                    TranscribeBean transcribeBean4 = this.mTranscribeBean;
                    if (transcribeBean4 != null) {
                        str = transcribeBean4.getLanguage();
                    }
                    if (!Intrinsics.areEqual((Object) str, (Object) "de")) {
                        UToast.f6444a.b(this, R.string.fr_ai_support_tip);
                        return;
                    }
                }
            }
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this, TranscribeAIActivity.class));
        intent.putExtra("key_record_bean", this.mTranscribeBean);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void reSaveData() {
        ClipboardEditText F0;
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding = null;
        if (this.transType == 1) {
            MessageEntity messageEntity = this.updatingMessage;
            if (messageEntity != null) {
                Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.b(), (CoroutineStart) null, new TranscribeDetailActivity$reSaveData$1$1(this, messageEntity, (Continuation<? super TranscribeDetailActivity$reSaveData$1$1>) null), 2, (Object) null);
            }
            ActivityTranscribeDetailBinding activityTranscribeDetailBinding2 = this.mBinding;
            if (activityTranscribeDetailBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                activityTranscribeDetailBinding2 = null;
            }
            activityTranscribeDetailBinding2.k.i(true);
        } else {
            MessageEntity messageEntity2 = this.updatingMessage;
            if (messageEntity2 != null) {
                Job unused2 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.b(), (CoroutineStart) null, new TranscribeDetailActivity$reSaveData$2$1(this, messageEntity2, (Continuation<? super TranscribeDetailActivity$reSaveData$2$1>) null), 2, (Object) null);
            }
            NoteDetailAdapter noteDetailAdapter = this.mAdapter;
            if (!(noteDetailAdapter == null || (F0 = noteDetailAdapter.F0()) == null)) {
                F0.i(true);
            }
        }
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding3 = this.mBinding;
        if (activityTranscribeDetailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranscribeDetailBinding = activityTranscribeDetailBinding3;
        }
        activityTranscribeDetailBinding.m.i(true);
        changeMode(false);
    }

    private final void scrollToCursorPosition(EditText editText, NestedScrollView nestedScrollView, int i) {
        int selectionStart = editText.getSelectionStart();
        Layout layout = editText.getLayout();
        if (layout != null && selectionStart != -1) {
            int lineBottom = layout.getLineBottom(layout.getLineForOffset(selectionStart));
            int[] iArr = new int[2];
            editText.getLocationOnScreen(iArr);
            int i2 = (iArr[1] + lineBottom) - (getResources().getDisplayMetrics().heightPixels - i);
            if (i2 > 0) {
                nestedScrollView.smoothScrollTo(0, nestedScrollView.getScrollY() + i2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void shareRecord() {
        if (this.sharedDialog == null) {
            this.sharedDialog = new AlertDialog.Builder(this).setItems((CharSequence[]) new String[]{getString(R.string.trsb_share_image), getString(R.string.trsb_share_text)}, (DialogInterface.OnClickListener) new i(this), true, ColorStateList.valueOf(getColor(R.color.color_bg_item_trans_me_record))).setNegativeButton(R.string.trsb_dialog_cancel, (DialogInterface.OnClickListener) new j()).create();
        }
        AlertDialog alertDialog = this.sharedDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void shareRecord$lambda$8(TranscribeDetailActivity transcribeDetailActivity, DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        String location;
        Intrinsics.checkNotNullParameter(transcribeDetailActivity, "this$0");
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        if (i == 0) {
            transcribeDetailActivity.gotoShareActivity();
        } else if (i == 1) {
            LogExt.d("share text type: " + transcribeDetailActivity.transType, TAG);
            if (transcribeDetailActivity.transType == 1) {
                StringBuilder sb = new StringBuilder();
                TranscribeBean transcribeBean = transcribeDetailActivity.mTranscribeBean;
                if (transcribeBean == null || (str2 = transcribeBean.getSuperTitle()) == null) {
                    str2 = transcribeDetailActivity.getString(R.string.transcribe_app_name);
                    Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
                }
                sb.append(str2);
                sb.append(StringUtils.LF);
                TranscribeBean transcribeBean2 = transcribeDetailActivity.mTranscribeBean;
                if (!(transcribeBean2 == null || (location = transcribeBean2.getLocation()) == null || !(!StringsKt.isBlank(location)))) {
                    TranscribeBean transcribeBean3 = transcribeDetailActivity.mTranscribeBean;
                    sb.append(transcribeBean3 != null ? transcribeBean3.getLocation() : null);
                    sb.append(StringUtils.LF);
                }
                ActivityTranscribeDetailBinding activityTranscribeDetailBinding = transcribeDetailActivity.mBinding;
                if (activityTranscribeDetailBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    activityTranscribeDetailBinding = null;
                }
                sb.append(activityTranscribeDetailBinding.l.getText());
                sb.append("\n\n");
                ActivityTranscribeDetailBinding activityTranscribeDetailBinding2 = transcribeDetailActivity.mBinding;
                if (activityTranscribeDetailBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    activityTranscribeDetailBinding2 = null;
                }
                sb.append(activityTranscribeDetailBinding2.k.getText());
                sb.append("\n\n");
                sb.append("MYVU");
                str = sb.toString();
            } else {
                TranscribeBean transcribeBean4 = transcribeDetailActivity.mTranscribeBean;
                Intrinsics.checkNotNull(transcribeBean4);
                str = transcribeDetailActivity.generateText(transcribeBean4);
            }
            Intrinsics.checkNotNull(str);
            ContextExtKt.i(transcribeDetailActivity, str, (String) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void shareRecord$lambda$9(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public final void showRecordEditedDialog() {
        AlertDialog create = new AlertDialog.Builder(this).setTitle(R.string.trsb_abandon_current_edit).setPositiveButton(R.string.trsb_abandon, (DialogInterface.OnClickListener) new k(this)).setNegativeButton(R.string.trsb_dialog_cancel, (DialogInterface.OnClickListener) new l()).create();
        Intrinsics.checkNotNull(create);
        ActivityExtKt.a(create);
        create.show();
    }

    /* access modifiers changed from: private */
    public static final void showRecordEditedDialog$lambda$12(TranscribeDetailActivity transcribeDetailActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(transcribeDetailActivity, "this$0");
        dialogInterface.dismiss();
        transcribeDetailActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void showRecordEditedDialog$lambda$13(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityTranscribeDetailBinding c = ActivityTranscribeDetailBinding.c(ContextExtKt.a(this));
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.mBinding = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            c = null;
        }
        setContentView((View) c.getRoot());
        initView();
        initData();
        adjustSoftInputHeight();
    }

    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.mDeleteDataDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.mDeleteDataDialog = null;
        this.mNoteDetailBeans.clear();
        this.mTranscribeBean = null;
        CoroutineScopeKt.e(this, (CancellationException) null, 1, (Object) null);
    }
}
