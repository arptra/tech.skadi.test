package com.upuphone.ar.transcribe.phone.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.honey.account.v4.a0;
import com.honey.account.v4.b0;
import com.honey.account.v4.c0;
import com.honey.account.v4.d0;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.databinding.ActivityTranscirbeSearchBinding;
import com.upuphone.ar.transcribe.phone.adapter.NoteListAdapter;
import com.upuphone.ar.transcribe.phone.bean.ListItemBean;
import com.upuphone.ar.transcribe.phone.bean.SearchBean;
import com.upuphone.ar.transcribe.phone.view.GridSpacingItemDecoration;
import com.upuphone.ar.transcribe.utils.GraphicUtils;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0003J\u0006\u0010\u001a\u001a\u00020\bJ\u0012\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0013H\u0014J\b\u0010\u001f\u001a\u00020\u0013H\u0014J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0010H\u0002J\b\u0010\"\u001a\u00020\u0013H\u0002J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\bH\u0002J\u001e\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00102\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/TranscribeSearchActivity;", "Lcom/upuphone/ar/transcribe/phone/activity/TranscribeBaseActivity;", "()V", "adapter", "Lcom/upuphone/ar/transcribe/phone/adapter/NoteListAdapter;", "binding", "Lcom/upuphone/ar/transcribe/databinding/ActivityTranscirbeSearchBinding;", "isFirst", "", "searchData", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/transcribe/phone/bean/ListItemBean;", "Lkotlin/collections/ArrayList;", "getSpannableString", "", "src", "", "key", "handleSearchRemove", "", "etSearch", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "hideViews", "initViews", "isRtl", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "searchText", "words", "showEmptyView", "showIme", "show", "showSearchResult", "search", "result", "", "Lcom/upuphone/ar/transcribe/phone/bean/SearchBean;", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTranscribeSearchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeSearchActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeSearchActivity\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,242:1\n65#2,16:243\n93#2,3:259\n262#3,2:262\n262#3,2:264\n262#3,2:266\n262#3,2:268\n262#3,2:270\n262#3,2:272\n1620#4,3:274\n*S KotlinDebug\n*F\n+ 1 TranscribeSearchActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeSearchActivity\n*L\n86#1:243,16\n86#1:259,3\n177#1:262,2\n178#1:264,2\n196#1:266,2\n197#1:268,2\n202#1:270,2\n203#1:272,2\n205#1:274,3\n*E\n"})
public final class TranscribeSearchActivity extends TranscribeBaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "TranscribeSearchActivity";
    @Nullable
    private NoteListAdapter adapter;
    /* access modifiers changed from: private */
    public ActivityTranscirbeSearchBinding binding;
    private boolean isFirst = true;
    @NotNull
    private final ArrayList<ListItemBean> searchData = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/TranscribeSearchActivity$Companion;", "", "()V", "TAG", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final CharSequence getSpannableString(String str, String str2) {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        int length = str2.length();
        int i = indexOf$default + length;
        if (i > 43) {
            if (length >= 43) {
                str = str2;
            } else {
                str = str.substring(i - 43, i);
                Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
            }
        }
        int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(getColor(R.color.color_bg_item_trans_me_record)), indexOf$default2, length + indexOf$default2, 33);
        return spannableString;
    }

    private final void handleSearchRemove(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && (view instanceof EditText)) {
            EditText editText = (EditText) view;
            Drawable drawable = editText.getCompoundDrawablesRelative()[2];
            if (drawable != null) {
                boolean isRtl = isRtl();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (isRtl) {
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
    public final void hideViews() {
        this.searchData.clear();
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding = this.binding;
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding2 = null;
        if (activityTranscirbeSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscirbeSearchBinding = null;
        }
        RecyclerView recyclerView = activityTranscirbeSearchBinding.f;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "searchList");
        recyclerView.setVisibility(8);
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding3 = this.binding;
        if (activityTranscirbeSearchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTranscirbeSearchBinding2 = activityTranscirbeSearchBinding3;
        }
        Group group = activityTranscirbeSearchBinding2.b;
        Intrinsics.checkNotNullExpressionValue(group, "emptyContainer");
        group.setVisibility(8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initViews() {
        NoteListAdapter noteListAdapter = new NoteListAdapter(R.layout.trsb_item_list_note, this.searchData, (NoteListAdapter.OnRenameTitleListener) null, 4, (DefaultConstructorMarker) null);
        this.adapter = noteListAdapter;
        noteListAdapter.q0(new a0(this));
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding = this.binding;
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding2 = null;
        if (activityTranscirbeSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscirbeSearchBinding = null;
        }
        activityTranscirbeSearchBinding.f.setAdapter(this.adapter);
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding3 = this.binding;
        if (activityTranscirbeSearchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscirbeSearchBinding3 = null;
        }
        activityTranscirbeSearchBinding3.f.setLayoutManager(new GridLayoutManager(this, 1));
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding4 = this.binding;
        if (activityTranscirbeSearchBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscirbeSearchBinding4 = null;
        }
        activityTranscirbeSearchBinding4.f.addItemDecoration(new GridSpacingItemDecoration(1, GraphicUtils.a(12.0f), false));
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding5 = this.binding;
        if (activityTranscirbeSearchBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscirbeSearchBinding5 = null;
        }
        EditText editText = activityTranscirbeSearchBinding5.g;
        Intrinsics.checkNotNullExpressionValue(editText, "searchTv");
        editText.addTextChangedListener(new TranscribeSearchActivity$initViews$$inlined$addTextChangedListener$default$1(this));
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding6 = this.binding;
        if (activityTranscirbeSearchBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscirbeSearchBinding6 = null;
        }
        activityTranscirbeSearchBinding6.g.setOnTouchListener(new b0(this));
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding7 = this.binding;
        if (activityTranscirbeSearchBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscirbeSearchBinding7 = null;
        }
        activityTranscirbeSearchBinding7.g.setOnEditorActionListener(new c0(this));
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding8 = this.binding;
        if (activityTranscirbeSearchBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTranscirbeSearchBinding2 = activityTranscirbeSearchBinding8;
        }
        activityTranscirbeSearchBinding2.c.setOnClickListener(new d0(this));
    }

    /* access modifiers changed from: private */
    public static final void initViews$lambda$2(TranscribeSearchActivity transcribeSearchActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(transcribeSearchActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.upuphone.ar.transcribe.phone.bean.ListItemBean");
        ListItemBean listItemBean = (ListItemBean) item;
        Intent intent = new Intent(transcribeSearchActivity, TranscribeDetailActivity.class);
        intent.putExtra(TranslatorConstants.TRANSLATION_RECORD_ITEM_ID, listItemBean.getId());
        intent.putExtra("trans_search_id", listItemBean.getMessageId());
        transcribeSearchActivity.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public static final boolean initViews$lambda$4(TranscribeSearchActivity transcribeSearchActivity, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(transcribeSearchActivity, "this$0");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.EditText");
        if (((EditText) view).getCompoundDrawables()[2] == null || motionEvent.getAction() != 1) {
            return false;
        }
        Intrinsics.checkNotNull(motionEvent);
        transcribeSearchActivity.handleSearchRemove(view, motionEvent);
        return false;
    }

    /* access modifiers changed from: private */
    public static final boolean initViews$lambda$5(TranscribeSearchActivity transcribeSearchActivity, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(transcribeSearchActivity, "this$0");
        if (i != 3) {
            return true;
        }
        transcribeSearchActivity.showIme(false);
        return true;
    }

    /* access modifiers changed from: private */
    public static final void initViews$lambda$6(TranscribeSearchActivity transcribeSearchActivity, View view) {
        Intrinsics.checkNotNullParameter(transcribeSearchActivity, "this$0");
        transcribeSearchActivity.finish();
    }

    /* access modifiers changed from: private */
    public final void searchText(String str) {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.b(), (CoroutineStart) null, new TranscribeSearchActivity$searchText$1(str, this, (Continuation<? super TranscribeSearchActivity$searchText$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showEmptyView() {
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding = this.binding;
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding2 = null;
        if (activityTranscirbeSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscirbeSearchBinding = null;
        }
        Group group = activityTranscirbeSearchBinding.b;
        Intrinsics.checkNotNullExpressionValue(group, "emptyContainer");
        group.setVisibility(0);
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding3 = this.binding;
        if (activityTranscirbeSearchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTranscirbeSearchBinding2 = activityTranscirbeSearchBinding3;
        }
        RecyclerView recyclerView = activityTranscirbeSearchBinding2.f;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "searchList");
        recyclerView.setVisibility(8);
        this.searchData.clear();
    }

    /* access modifiers changed from: private */
    public final void showIme(boolean z) {
        Object systemService = getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding = null;
        if (z) {
            ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding2 = this.binding;
            if (activityTranscirbeSearchBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityTranscirbeSearchBinding2 = null;
            }
            activityTranscirbeSearchBinding2.g.requestFocus();
            ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding3 = this.binding;
            if (activityTranscirbeSearchBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityTranscirbeSearchBinding = activityTranscirbeSearchBinding3;
            }
            inputMethodManager.showSoftInput(activityTranscirbeSearchBinding.g, 0);
            return;
        }
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding4 = this.binding;
        if (activityTranscirbeSearchBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscirbeSearchBinding4 = null;
        }
        activityTranscirbeSearchBinding4.g.clearFocus();
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding5 = this.binding;
        if (activityTranscirbeSearchBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTranscirbeSearchBinding = activityTranscirbeSearchBinding5;
        }
        inputMethodManager.hideSoftInputFromWindow(activityTranscirbeSearchBinding.g.getWindowToken(), 2);
    }

    /* access modifiers changed from: private */
    public final void showSearchResult(String str, List<SearchBean> list) {
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding = this.binding;
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding2 = null;
        if (activityTranscirbeSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscirbeSearchBinding = null;
        }
        Group group = activityTranscirbeSearchBinding.b;
        Intrinsics.checkNotNullExpressionValue(group, "emptyContainer");
        group.setVisibility(8);
        ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding3 = this.binding;
        if (activityTranscirbeSearchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTranscirbeSearchBinding2 = activityTranscirbeSearchBinding3;
        }
        RecyclerView recyclerView = activityTranscirbeSearchBinding2.f;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "searchList");
        recyclerView.setVisibility(0);
        this.searchData.clear();
        ArrayList<ListItemBean> arrayList = this.searchData;
        for (SearchBean searchBean : list) {
            ListItemBean listItemBean = r4;
            ListItemBean listItemBean2 = new ListItemBean(searchBean.getId(), searchBean.getRecordTime(), searchBean.getType(), searchBean.getSuperTitle(), searchBean.getMessage(), (String) null, searchBean.getMessageId(), searchBean.getSimpleLocation(), false, 256, (DefaultConstructorMarker) null);
            arrayList.add(listItemBean);
        }
        NoteListAdapter noteListAdapter = this.adapter;
        if (noteListAdapter != null) {
            noteListAdapter.notifyDataSetChanged();
        }
    }

    public final boolean isRtl() {
        return getResources().getConfiguration().getLayoutDirection() == 1;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityTranscirbeSearchBinding c = ActivityTranscirbeSearchBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.binding = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        setContentView((View) c.getRoot());
        initViews();
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TranscribeSearchActivity$onCreate$1(this, (Continuation<? super TranscribeSearchActivity$onCreate$1>) null), 3, (Object) null);
    }

    public void onPause() {
        super.onPause();
        showIme(false);
    }

    public void onResume() {
        super.onResume();
        if (!this.isFirst) {
            ActivityTranscirbeSearchBinding activityTranscirbeSearchBinding = this.binding;
            if (activityTranscirbeSearchBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityTranscirbeSearchBinding = null;
            }
            Editable text = activityTranscirbeSearchBinding.g.getText();
            Intrinsics.checkNotNull(text);
            if (!StringsKt.isBlank(text)) {
                searchText(text.toString());
            }
        }
        this.isFirst = false;
    }
}
