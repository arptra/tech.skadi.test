package com.upuphone.ar.translation.phone.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.honey.account.d5.p;
import com.honey.account.d5.q;
import com.honey.account.d5.r;
import com.honey.account.d5.s;
import com.honey.account.d5.t;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.adapter.SearchRecordAdapter;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.bean.OperateMessage;
import com.upuphone.ar.translation.phone.databinding.ActivityTranslatorSearchBinding;
import com.upuphone.ar.translation.phone.view.GridSpacingItemDecoration;
import com.upuphone.ar.translation.utils.GraphicUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001c\u0010\u0010\u001a\u00020\b\"\u0004\b\u0000\u0010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0013H\u0002J\b\u0010\u0014\u001a\u00020\bH\u0003J\b\u0010\u0015\u001a\u00020\bH\u0003J\b\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0017\u001a\u00020\bH\u0002J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\bH\u0014J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\u001fH\u0002J\f\u0010\"\u001a\u00020\b*\u00020#H\u0002J\f\u0010$\u001a\u00020\b*\u00020#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/upuphone/ar/translation/phone/activity/TranslatorSearchActivity;", "Lcom/upuphone/ar/translation/phone/activity/TranslatorBaseActivity;", "()V", "mBinding", "Lcom/upuphone/ar/translation/phone/databinding/ActivityTranslatorSearchBinding;", "mSearchRecordAdapter", "Lcom/upuphone/ar/translation/phone/adapter/SearchRecordAdapter;", "handleSearchRecord", "", "keyWord", "", "handleSearchRemove", "etSearch", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "handleUiUpdateCallback", "T", "operateMessage", "Lcom/upuphone/ar/translation/phone/bean/OperateMessage;", "hideAllView", "initListener", "initRecordList", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "searchRecord", "showEmptyView", "isEmpty", "", "showIme", "show", "hideSoftInput", "Landroid/widget/EditText;", "showSoftInput", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTranslatorSearchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslatorSearchActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorSearchActivity\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,312:1\n65#2,16:313\n93#2,3:329\n262#3,2:332\n262#3,2:334\n262#3,2:336\n262#3,2:338\n*S KotlinDebug\n*F\n+ 1 TranslatorSearchActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorSearchActivity\n*L\n115#1:313,16\n115#1:329,3\n257#1:332,2\n258#1:334,2\n268#1:336,2\n269#1:338,2\n*E\n"})
public final class TranslatorSearchActivity extends TranslatorBaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "TranslatorSearchActivity";
    private ActivityTranslatorSearchBinding mBinding;
    /* access modifiers changed from: private */
    @Nullable
    public SearchRecordAdapter mSearchRecordAdapter;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/activity/TranslatorSearchActivity$Companion;", "", "()V", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final void handleSearchRecord(String str) {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.icon_sv_search);
        Drawable drawable2 = ContextCompat.getDrawable(this, R.drawable.icon_sv_delete);
        if (!StringsKt.isBlank(str)) {
            ActivityTranslatorSearchBinding activityTranslatorSearchBinding = this.mBinding;
            if (activityTranslatorSearchBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                activityTranslatorSearchBinding = null;
            }
            activityTranslatorSearchBinding.c.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, drawable2, (Drawable) null);
            searchRecord(str);
            return;
        }
        hideAllView();
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding2 = this.mBinding;
        if (activityTranslatorSearchBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorSearchBinding2 = null;
        }
        activityTranslatorSearchBinding2.c.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private final void handleSearchRemove(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && (view instanceof EditText)) {
            EditText editText = (EditText) view;
            Drawable drawable = editText.getCompoundDrawablesRelative()[2];
            if (drawable != null) {
                boolean f = ContextExtKt.f(this);
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (f) {
                    if (motionEvent.getX() <= ((float) (intrinsicWidth + editText.getPaddingEnd()))) {
                        editText.setText("");
                        view.performClick();
                    }
                } else if (motionEvent.getX() >= ((float) (((editText.getRight() - editText.getLeft()) - intrinsicWidth) - editText.getPaddingEnd()))) {
                    editText.setText("");
                    view.performClick();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final <T> void handleUiUpdateCallback(OperateMessage<T> operateMessage) {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorSearchActivity$handleUiUpdateCallback$1(operateMessage, this, (Continuation<? super TranslatorSearchActivity$handleUiUpdateCallback$1>) null), 2, (Object) null);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void hideAllView() {
        List data;
        SearchRecordAdapter searchRecordAdapter = this.mSearchRecordAdapter;
        if (!(searchRecordAdapter == null || (data = searchRecordAdapter.getData()) == null)) {
            data.clear();
        }
        SearchRecordAdapter searchRecordAdapter2 = this.mSearchRecordAdapter;
        if (searchRecordAdapter2 != null) {
            searchRecordAdapter2.notifyDataSetChanged();
        }
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding = this.mBinding;
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding2 = null;
        if (activityTranslatorSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorSearchBinding = null;
        }
        RecyclerView recyclerView = activityTranslatorSearchBinding.f;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rvRecords");
        recyclerView.setVisibility(8);
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding3 = this.mBinding;
        if (activityTranslatorSearchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranslatorSearchBinding2 = activityTranslatorSearchBinding3;
        }
        Group group = activityTranslatorSearchBinding2.d;
        Intrinsics.checkNotNullExpressionValue(group, "gpNoData");
        group.setVisibility(8);
    }

    private final void hideSoftInput(EditText editText) {
        Object systemService = getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 2);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initListener() {
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding = this.mBinding;
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding2 = null;
        if (activityTranslatorSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorSearchBinding = null;
        }
        activityTranslatorSearchBinding.h.setOnClickListener(new q(this));
        TranslationApp.registerUiUpdateCallback$ar_translator_intlRelease(TAG, new TranslatorSearchActivity$initListener$2(this));
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding3 = this.mBinding;
        if (activityTranslatorSearchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorSearchBinding3 = null;
        }
        EditText editText = activityTranslatorSearchBinding3.c;
        Intrinsics.checkNotNullExpressionValue(editText, "etSearch");
        editText.addTextChangedListener(new TranslatorSearchActivity$initListener$$inlined$addTextChangedListener$default$1(this));
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding4 = this.mBinding;
        if (activityTranslatorSearchBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorSearchBinding4 = null;
        }
        activityTranslatorSearchBinding4.c.setOnTouchListener(new r(this));
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding5 = this.mBinding;
        if (activityTranslatorSearchBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranslatorSearchBinding2 = activityTranslatorSearchBinding5;
        }
        activityTranslatorSearchBinding2.c.setOnEditorActionListener(new s(this));
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$3(TranslatorSearchActivity translatorSearchActivity, View view) {
        Intrinsics.checkNotNullParameter(translatorSearchActivity, "this$0");
        translatorSearchActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final boolean initListener$lambda$6(TranslatorSearchActivity translatorSearchActivity, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(translatorSearchActivity, "this$0");
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNull(motionEvent);
        translatorSearchActivity.handleSearchRemove(view, motionEvent);
        return false;
    }

    /* access modifiers changed from: private */
    public static final boolean initListener$lambda$7(TranslatorSearchActivity translatorSearchActivity, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(translatorSearchActivity, "this$0");
        if (i == 3) {
            showIme$default(translatorSearchActivity, false, 1, (Object) null);
        }
        return true;
    }

    private final void initRecordList() {
        SearchRecordAdapter searchRecordAdapter = new SearchRecordAdapter(R.layout.item_list_record_new, new ArrayList());
        searchRecordAdapter.q0(new t(this));
        this.mSearchRecordAdapter = searchRecordAdapter;
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding = this.mBinding;
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding2 = null;
        if (activityTranslatorSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorSearchBinding = null;
        }
        activityTranslatorSearchBinding.f.setLayoutManager(new GridLayoutManager(this, 1));
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding3 = this.mBinding;
        if (activityTranslatorSearchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorSearchBinding3 = null;
        }
        activityTranslatorSearchBinding3.f.addItemDecoration(new GridSpacingItemDecoration(1, GraphicUtils.a(12.0f), false));
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding4 = this.mBinding;
        if (activityTranslatorSearchBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranslatorSearchBinding2 = activityTranslatorSearchBinding4;
        }
        activityTranslatorSearchBinding2.f.setAdapter(this.mSearchRecordAdapter);
    }

    /* access modifiers changed from: private */
    public static final void initRecordList$lambda$2$lambda$1(TranslatorSearchActivity translatorSearchActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(translatorSearchActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Intent intent = new Intent(translatorSearchActivity, TranslatorRecordActivity.class);
        NoteBean noteBean = (NoteBean) baseQuickAdapter.getItem(i);
        intent.putExtra(TranslatorConstants.TRANSLATION_RECORD_ITEM_ID, noteBean != null ? noteBean.getId() : -1);
        translatorSearchActivity.startActivity(intent);
    }

    private final void initViews() {
        initRecordList();
        showIme(true);
    }

    private final void searchRecord(String str) {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.b(), (CoroutineStart) null, new TranslatorSearchActivity$searchRecord$1(str, this, (Continuation<? super TranslatorSearchActivity$searchRecord$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showEmptyView(boolean z) {
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding = this.mBinding;
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding2 = null;
        if (activityTranslatorSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorSearchBinding = null;
        }
        Group group = activityTranslatorSearchBinding.d;
        Intrinsics.checkNotNullExpressionValue(group, "gpNoData");
        int i = 8;
        group.setVisibility(z ? 0 : 8);
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding3 = this.mBinding;
        if (activityTranslatorSearchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranslatorSearchBinding2 = activityTranslatorSearchBinding3;
        }
        RecyclerView recyclerView = activityTranslatorSearchBinding2.f;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rvRecords");
        if (!z) {
            i = 0;
        }
        recyclerView.setVisibility(i);
    }

    public static /* synthetic */ void showEmptyView$default(TranslatorSearchActivity translatorSearchActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        translatorSearchActivity.showEmptyView(z);
    }

    private final void showIme(boolean z) {
        ActivityTranslatorSearchBinding activityTranslatorSearchBinding = this.mBinding;
        if (activityTranslatorSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorSearchBinding = null;
        }
        EditText editText = activityTranslatorSearchBinding.c;
        editText.post(new p(z, editText, this));
    }

    public static /* synthetic */ void showIme$default(TranslatorSearchActivity translatorSearchActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        translatorSearchActivity.showIme(z);
    }

    /* access modifiers changed from: private */
    public static final void showIme$lambda$9$lambda$8(boolean z, EditText editText, TranslatorSearchActivity translatorSearchActivity) {
        Intrinsics.checkNotNullParameter(editText, "$this_run");
        Intrinsics.checkNotNullParameter(translatorSearchActivity, "this$0");
        if (z) {
            editText.requestFocus();
            translatorSearchActivity.showSoftInput(editText);
            return;
        }
        editText.clearFocus();
        translatorSearchActivity.hideSoftInput(editText);
    }

    private final void showSoftInput(EditText editText) {
        Object systemService = getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 0);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityTranslatorSearchBinding c = ActivityTranslatorSearchBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.mBinding = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            c = null;
        }
        setContentView((View) c.getRoot());
        initViews();
        initListener();
    }

    public void onDestroy() {
        super.onDestroy();
        TranslationApp.unRegisterUiUpdateCallback$ar_translator_intlRelease(TAG);
    }
}
