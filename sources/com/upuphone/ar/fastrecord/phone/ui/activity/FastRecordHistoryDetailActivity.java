package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.honey.account.u3.a0;
import com.honey.account.u3.b0;
import com.honey.account.u3.c0;
import com.honey.account.u3.d0;
import com.honey.account.u3.e0;
import com.honey.account.u3.f;
import com.honey.account.u3.f0;
import com.honey.account.u3.g;
import com.honey.account.u3.h;
import com.honey.account.u3.i;
import com.honey.account.u3.j;
import com.honey.account.u3.k;
import com.honey.account.u3.l;
import com.honey.account.u3.m;
import com.honey.account.u3.n;
import com.honey.account.u3.o;
import com.honey.account.u3.p;
import com.honey.account.u3.q;
import com.honey.account.u3.r;
import com.honey.account.u3.s;
import com.honey.account.u3.t;
import com.honey.account.u3.u;
import com.honey.account.u3.v;
import com.honey.account.u3.w;
import com.honey.account.u3.x;
import com.honey.account.u3.y;
import com.honey.account.u3.z;
import com.meizu.common.app.LoadingDialog;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordHistoryDetailActivityBinding;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.bean.FastRecordLanguageBean;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordDetailHistoryViewAdapter;
import com.upuphone.ar.fastrecord.phone.ui.dialog.FastRecordDeleteDialog;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiSummaryOperatorManager;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperatorManager;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.AsrDuringProgress;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperator;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperatorManager;
import com.upuphone.ar.fastrecord.phone.utils.RecordConstants;
import com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil;
import com.upuphone.ar.fastrecord.phone.utils.RecordDateUtil;
import com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils;
import com.upuphone.ar.fastrecord.phone.utils.ViewClickExtKt;
import com.upuphone.ar.fastrecord.phone.utils.ViewUtil;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import flyme.support.v7.app.AlertDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000201H\u0002J\b\u00105\u001a\u000201H\u0002J\b\u00106\u001a\u000201H\u0002J\b\u00107\u001a\u000201H\u0002J\u0010\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000201H\u0002J\u0010\u0010<\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\u001c\u0010=\u001a\u0002012\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u0002010?H\u0002J\u0010\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0002J\b\u0010C\u001a\u000201H\u0003J\u0010\u0010D\u001a\u0002012\u0006\u0010E\u001a\u00020\bH\u0002J\b\u0010F\u001a\u000201H\u0002J\b\u0010G\u001a\u000201H\u0002J\b\u0010H\u001a\u000201H\u0002J\b\u0010I\u001a\u000201H\u0002J\b\u0010J\u001a\u000201H\u0003J\b\u0010K\u001a\u000201H\u0002J\b\u0010L\u001a\u000201H\u0002J\u0010\u0010M\u001a\u0002012\u0006\u0010N\u001a\u00020\bH\u0002J\b\u0010O\u001a\u000201H\u0003J\b\u0010P\u001a\u000201H\u0002J\b\u0010Q\u001a\u000201H\u0002J\b\u0010R\u001a\u000201H\u0002J\b\u0010S\u001a\u000201H\u0002J\b\u0010T\u001a\u000201H\u0003J\b\u0010U\u001a\u000201H\u0003J\u0010\u0010V\u001a\u0002012\u0006\u0010W\u001a\u00020\bH\u0002J\u0012\u0010X\u001a\u0002012\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0014J\b\u0010[\u001a\u000201H\u0014J\b\u0010\\\u001a\u000201H\u0014J\b\u0010]\u001a\u000201H\u0014J\b\u0010^\u001a\u000201H\u0002J\u0010\u0010_\u001a\u0002012\u0006\u0010`\u001a\u00020\u0006H\u0002J\b\u0010a\u001a\u000201H\u0002J\b\u0010b\u001a\u000201H\u0002J\u0010\u0010c\u001a\u0002012\u0006\u0010d\u001a\u00020\u000eH\u0003J\b\u0010e\u001a\u000201H\u0002J\u0010\u0010f\u001a\u0002012\u0006\u0010`\u001a\u00020\"H\u0002J\u0010\u0010g\u001a\u0002012\u0006\u0010h\u001a\u00020\bH\u0002J(\u0010i\u001a\u0002012\u0016\u0010j\u001a\u0012\u0012\u0004\u0012\u00020l0kj\b\u0012\u0004\u0012\u00020l`m2\u0006\u0010h\u001a\u00020\bH\u0002J\b\u0010n\u001a\u000201H\u0002J\u0010\u0010o\u001a\u0002012\u0006\u0010p\u001a\u00020\u000eH\u0003J\b\u0010q\u001a\u000201H\u0002J\u0010\u0010r\u001a\u0002012\u0006\u00109\u001a\u00020sH\u0003J\b\u0010t\u001a\u000201H\u0002J\b\u0010u\u001a\u000201H\u0002J\u0014\u0010v\u001a\u0002012\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010x\u001a\u000201H\u0002J\b\u0010y\u001a\u000201H\u0002J\b\u0010z\u001a\u000201H\u0002J\u0010\u0010{\u001a\u0002012\u0006\u0010|\u001a\u00020\u000eH\u0002J\b\u0010}\u001a\u000201H\u0002J\b\u0010~\u001a\u000201H\u0002J\b\u0010\u001a\u000201H\u0002J\t\u0010\u0001\u001a\u000201H\u0002J\u0011\u0010\u0001\u001a\u0002012\u0006\u0010|\u001a\u00020\u000eH\u0002J\u0011\u0010\u0001\u001a\u0002012\u0006\u0010W\u001a\u00020\bH\u0002J\t\u0010\u0001\u001a\u000201H\u0002J\u001c\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0011\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0012\u0010\u0001\u001a\u0002012\u0007\u0010\u0001\u001a\u00020\"H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X.¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b/\u0010\u0016\u001a\u0004\b-\u0010.¨\u0006\u0001"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordHistoryDetailActivity;", "Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordBaseActivity;", "()V", "asrCallbackInterface", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordHistoryAsrOperatorManager$AsrCallbackInterface;", "curPlayerPosition", "", "curSpend", "", "dialog", "Lflyme/support/v7/app/AlertDialog;", "handler", "Landroid/os/Handler;", "isFailStatus", "", "isFinishShowAnalysisDialog", "isPageShowing", "layout", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordHistoryDetailActivityBinding;", "getLayout", "()Lcom/upuphone/ar/fastrecord/databinding/FastRecordHistoryDetailActivityBinding;", "layout$delegate", "Lkotlin/Lazy;", "mAnalysisDialog", "Lcom/meizu/common/app/LoadingDialog;", "mLoadingDialog", "mMediaPlayer", "Landroid/media/MediaPlayer;", "mOnGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mPreviousKeyboardHeight", "playbackSpeed", "", "recordId", "", "Ljava/lang/Long;", "showPositionJob", "Lkotlinx/coroutines/Job;", "tagContentValue", "tagPersonValue", "topHeight", "viewAdapter", "Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordDetailHistoryViewAdapter;", "viewModel", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordDetailRecordHistoryViewModel;", "getViewModel", "()Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordDetailRecordHistoryViewModel;", "viewModel$delegate", "checkMergeVoice", "", "entity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "checkShowAsrEmptyState", "clickSpend", "copyValue", "delRecord", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "finishAndHidePlayIndex", "getRecordAsrResult", "getSummaryRequestBean", "callBack", "Lkotlin/Function1;", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/SummaryRequestBean;", "getTypeName", "langType", "globalLayoutListener", "gotoTagEditPage", "contentTag", "hidePlayIndex", "initAiSummaryStateObserver", "initAiTodoStateObserver", "initAsrRequestCallback", "initCommonView", "initContentTag", "initMediaAndShowNormalState", "initPlayerView", "wavPath", "initRecordView", "initRecyclerView", "initTagLiveData", "initTitleClicker", "initTopLayoutHeight", "initView", "initViewModel", "initWavPlayer", "path", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "playAndSetSpeed", "playPosition", "position", "reStartAsr", "resetTagShow", "setAiImageState", "state", "setPlaySpend", "setRecordPlayTime", "shareByType", "type", "shareFilePath", "shareTempFileUirList", "Ljava/util/ArrayList;", "Landroid/net/Uri;", "Lkotlin/collections/ArrayList;", "shareRecord", "showAiAndCopyImage", "isFinishAsr", "showAnalysisDialog", "showAsrDuringProgress", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/AsrDuringProgress;", "showContentTagInfo", "showEmptyAsrState", "showFailAsrState", "code", "showFailTip", "showLoadingState", "showMergeVoiceDialog", "showPersonState", "showSingle", "showPersonTagInfo", "showReAsrState", "showSaveAsrDialog", "showShareLoadingDialog", "showTagState", "startMediaPlayer", "startUpdatePosition", "textViewIsEllipsis", "Landroid/text/Layout;", "textView", "Landroid/widget/TextView;", "updateRecordRecyclerViewItem", "time", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordHistoryDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordHistoryDetailActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordHistoryDetailActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1520:1\n75#2,13:1521\n262#3,2:1534\n262#3,2:1536\n262#3,2:1538\n262#3,2:1540\n262#3,2:1542\n262#3,2:1544\n262#3,2:1546\n262#3,2:1548\n262#3,2:1552\n262#3,2:1554\n262#3,2:1556\n262#3,2:1558\n262#3,2:1560\n262#3,2:1562\n262#3,2:1564\n262#3,2:1566\n262#3,2:1568\n262#3,2:1570\n262#3,2:1572\n262#3,2:1574\n262#3,2:1576\n262#3,2:1578\n262#3,2:1580\n262#3,2:1582\n262#3,2:1584\n262#3,2:1586\n262#3,2:1588\n262#3,2:1590\n262#3,2:1592\n262#3,2:1594\n262#3,2:1596\n262#3,2:1598\n262#3,2:1600\n262#3,2:1602\n262#3,2:1604\n262#3,2:1606\n262#3,2:1608\n262#3,2:1610\n262#3,2:1612\n262#3,2:1614\n262#3,2:1616\n262#3,2:1618\n262#3,2:1621\n262#3,2:1623\n262#3,2:1625\n262#3,2:1627\n262#3,2:1629\n262#3,2:1631\n262#3,2:1633\n262#3,2:1635\n262#3,2:1637\n262#3,2:1639\n260#3:1641\n260#3:1642\n260#3:1643\n260#3:1644\n223#4,2:1550\n1#5:1620\n*S KotlinDebug\n*F\n+ 1 FastRecordHistoryDetailActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordHistoryDetailActivity\n*L\n95#1:1521,13\n150#1:1534,2\n151#1:1536,2\n152#1:1538,2\n288#1:1540,2\n293#1:1542,2\n294#1:1544,2\n295#1:1546,2\n296#1:1548,2\n611#1:1552,2\n612#1:1554,2\n614#1:1556,2\n645#1:1558,2\n646#1:1560,2\n647#1:1562,2\n693#1:1564,2\n694#1:1566,2\n744#1:1568,2\n745#1:1570,2\n748#1:1572,2\n749#1:1574,2\n756#1:1576,2\n757#1:1578,2\n760#1:1580,2\n761#1:1582,2\n770#1:1584,2\n771#1:1586,2\n772#1:1588,2\n773#1:1590,2\n1036#1:1592,2\n1039#1:1594,2\n1042#1:1596,2\n1043#1:1598,2\n1044#1:1600,2\n1045#1:1602,2\n1046#1:1604,2\n1048#1:1606,2\n1049#1:1608,2\n1050#1:1610,2\n1056#1:1612,2\n1057#1:1614,2\n1058#1:1616,2\n1059#1:1618,2\n215#1:1621,2\n231#1:1623,2\n232#1:1625,2\n240#1:1627,2\n242#1:1629,2\n432#1:1631,2\n621#1:1633,2\n628#1:1635,2\n656#1:1637,2\n662#1:1639,2\n725#1:1641\n727#1:1642\n733#1:1643\n735#1:1644\n326#1:1550,2\n*E\n"})
public final class FastRecordHistoryDetailActivity extends FastRecordBaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_STEP = 2;
    @NotNull
    public static final String RECORD_FAIL = "Record_Fail";
    @NotNull
    public static final String RECORD_ID = "Record_Id";
    @NotNull
    public static final String SPEND_HALF = "0.5X";
    @NotNull
    public static final String SPEND_ONE = "1X";
    @NotNull
    public static final String SPEND_ONE_HALF = "1.5X";
    @NotNull
    public static final String SPEND_TWO = "2X";
    @NotNull
    private static final String TAG = "FastRecordHistoryDetailActivity";
    @NotNull
    public static final String TAG_SPLIT = "  ";
    /* access modifiers changed from: private */
    @Nullable
    public FastRecordHistoryAsrOperatorManager.AsrCallbackInterface asrCallbackInterface;
    /* access modifiers changed from: private */
    public int curPlayerPosition;
    @NotNull
    private String curSpend = SPEND_ONE;
    @Nullable
    private AlertDialog dialog;
    @NotNull
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean isFailStatus;
    private boolean isFinishShowAnalysisDialog;
    private boolean isPageShowing;
    @NotNull
    private final Lazy layout$delegate = LazyKt.lazy(new FastRecordHistoryDetailActivity$layout$2(this));
    /* access modifiers changed from: private */
    @Nullable
    public LoadingDialog mAnalysisDialog;
    /* access modifiers changed from: private */
    @Nullable
    public LoadingDialog mLoadingDialog;
    /* access modifiers changed from: private */
    @Nullable
    public MediaPlayer mMediaPlayer;
    @Nullable
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int mPreviousKeyboardHeight = -1;
    private float playbackSpeed = 1.0f;
    /* access modifiers changed from: private */
    @Nullable
    public Long recordId = 0L;
    @Nullable
    private Job showPositionJob;
    /* access modifiers changed from: private */
    @NotNull
    public String tagContentValue = "";
    /* access modifiers changed from: private */
    @NotNull
    public String tagPersonValue = "";
    private int topHeight = -1;
    /* access modifiers changed from: private */
    public FastRecordDetailHistoryViewAdapter viewAdapter;
    @NotNull
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(FastRecordDetailRecordHistoryViewModel.class), new FastRecordHistoryDetailActivity$special$$inlined$viewModels$default$2(this), new FastRecordHistoryDetailActivity$special$$inlined$viewModels$default$1(this), new FastRecordHistoryDetailActivity$special$$inlined$viewModels$default$3((Function0) null, this));

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordHistoryDetailActivity$Companion;", "", "()V", "MAX_STEP", "", "RECORD_FAIL", "", "RECORD_ID", "SPEND_HALF", "SPEND_ONE", "SPEND_ONE_HALF", "SPEND_TWO", "TAG", "TAG_SPLIT", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final void checkMergeVoice(RecordEntity recordEntity) {
        boolean isChangeVoice = recordEntity.isChangeVoice();
        LogExt.logE("checkMergeVoice change state =" + isChangeVoice, TAG);
        if (recordEntity.isChangeVoice()) {
            String curRecordLastWavChannelPath = getViewModel().getCurRecordLastWavChannelPath();
            if (curRecordLastWavChannelPath != null) {
                initWavPlayer(curRecordLastWavChannelPath);
            }
            showMergeVoiceDialog();
            return;
        }
        LogExt.logE("checkMergeVoice entity = " + recordEntity, TAG);
        String curRecordLastWavChannelPath2 = getViewModel().getCurRecordLastWavChannelPath();
        if (curRecordLastWavChannelPath2 != null) {
            initWavPlayer(curRecordLastWavChannelPath2);
        }
        getRecordAsrResult(recordEntity);
        if (!recordEntity.isFinishFileMerge()) {
            LogExt.logE("checkMergeVoice entity.isFinishFileMerge is false", TAG);
            getViewModel().mergeVoice(recordEntity, recordEntity.getType(), true);
            return;
        }
        LogExt.logE("checkMergeVoice entity.isFinishFileMerge is true", TAG);
    }

    /* access modifiers changed from: private */
    public final void checkShowAsrEmptyState() {
        Long l = this.recordId;
        if (l != null) {
            getViewModel().checkAllAsrWordIsEmpty(l.longValue(), new FastRecordHistoryDetailActivity$checkShowAsrEmptyState$1$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void clickSpend() {
        setPlaySpend();
        resetTagShow();
    }

    /* access modifiers changed from: private */
    public final void copyValue() {
        Object systemService = getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter = this.viewAdapter;
        if (fastRecordDetailHistoryViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            fastRecordDetailHistoryViewAdapter = null;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText("Copy", fastRecordDetailHistoryViewAdapter.getAllContentValue()));
        UToast.Companion companion = UToast.f6444a;
        String string = getString(R.string.fast_record_copy_success);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(this, string);
        resetTagShow();
    }

    private final void delRecord() {
        FastRecordDeleteDialog fastRecordDeleteDialog = new FastRecordDeleteDialog(this);
        String string = getString(R.string.fast_record_del_dialog_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        fastRecordDeleteDialog.setTitleText(string);
        FastRecordDeleteDialog.registerButtonClick$default(fastRecordDeleteDialog, new FastRecordHistoryDetailActivity$delRecord$1(this), (Function0) null, 2, (Object) null);
        fastRecordDeleteDialog.show();
    }

    private final void finishAndHidePlayIndex() {
        hidePlayIndex();
        finish();
    }

    /* access modifiers changed from: private */
    public final FastRecordHistoryDetailActivityBinding getLayout() {
        return (FastRecordHistoryDetailActivityBinding) this.layout$delegate.getValue();
    }

    private final void getRecordAsrResult(RecordEntity recordEntity) {
        if (recordEntity.isEmptyRecord()) {
            LogExt.logE("getRecordAsrResult entity.isEmptyRecord is true", TAG);
            showEmptyAsrState();
            return;
        }
        LogExt.logE("getRecordAsrResult getAllRecordVoiceWord", TAG);
        FastRecordDetailRecordHistoryViewModel.getAllRecordVoiceWord$default(getViewModel(), recordEntity.getRecordId(), false, 2, (Object) null);
    }

    private final void getSummaryRequestBean(Function1<? super SummaryRequestBean, Unit> function1) {
        Long l = this.recordId;
        if (l != null) {
            getViewModel().getRecord(l.longValue(), new FastRecordHistoryDetailActivity$getSummaryRequestBean$1$1(this, function1));
        }
    }

    private final String getTypeName(String str) {
        for (FastRecordLanguageBean fastRecordLanguageBean : ViewUtil.INSTANCE.getIntlLangList(this)) {
            if (Intrinsics.areEqual((Object) fastRecordLanguageBean.getLangType(), (Object) str)) {
                return fastRecordLanguageBean.getLangName();
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* access modifiers changed from: private */
    public final FastRecordDetailRecordHistoryViewModel getViewModel() {
        return (FastRecordDetailRecordHistoryViewModel) this.viewModel$delegate.getValue();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void globalLayoutListener() {
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        this.mOnGlobalLayoutListener = new d0(decorView, this);
        getLayout().getRoot().setOnTouchListener(new e0(this));
    }

    /* access modifiers changed from: private */
    public static final void globalLayoutListener$lambda$1(View view, FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        Intrinsics.checkNotNullParameter(view, "$rootView");
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int height = view.getRootView().getHeight();
        int i = height - rect.bottom;
        if (i != fastRecordHistoryDetailActivity.mPreviousKeyboardHeight && fastRecordHistoryDetailActivity.isPageShowing) {
            FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter = null;
            if (((double) i) > ((double) height) * 0.15d) {
                LogExt.logV("input is show", TAG);
                ConstraintLayout b = fastRecordHistoryDetailActivity.getLayout().e.getRoot();
                Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
                b.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = fastRecordHistoryDetailActivity.getLayout().k.i.getLayoutParams();
                layoutParams.height = fastRecordHistoryDetailActivity.getResources().getDimensionPixelSize(R.dimen.speech_recognition_edit_player_height);
                fastRecordHistoryDetailActivity.getLayout().k.i.setLayoutParams(layoutParams);
                fastRecordHistoryDetailActivity.getLayout().k.i.setEditMode(true);
                FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter2 = fastRecordHistoryDetailActivity.viewAdapter;
                if (fastRecordDetailHistoryViewAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                } else {
                    fastRecordDetailHistoryViewAdapter = fastRecordDetailHistoryViewAdapter2;
                }
                fastRecordDetailHistoryViewAdapter.setShowSoftInput(true);
                fastRecordHistoryDetailActivity.mPreviousKeyboardHeight = i;
                fastRecordHistoryDetailActivity.getLayout().i.setPadding(0, 0, 0, i - ViewUtil.INSTANCE.getNavigationBarHeight(fastRecordHistoryDetailActivity));
                View view2 = fastRecordHistoryDetailActivity.getLayout().d;
                Intrinsics.checkNotNullExpressionValue(view2, "ivUpTran");
                view2.setVisibility(8);
                View view3 = fastRecordHistoryDetailActivity.getLayout().c;
                Intrinsics.checkNotNullExpressionValue(view3, "ivBottomTran");
                view3.setVisibility(8);
                return;
            }
            LogExt.logV("input is hide", TAG);
            FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter3 = fastRecordHistoryDetailActivity.viewAdapter;
            if (fastRecordDetailHistoryViewAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                fastRecordDetailHistoryViewAdapter3 = null;
            }
            fastRecordDetailHistoryViewAdapter3.setShowSoftInput(false);
            fastRecordHistoryDetailActivity.mPreviousKeyboardHeight = i;
            fastRecordHistoryDetailActivity.getLayout().i.setPadding(0, 0, 0, 0);
            View view4 = fastRecordHistoryDetailActivity.getLayout().d;
            Intrinsics.checkNotNullExpressionValue(view4, "ivUpTran");
            view4.setVisibility(0);
            FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter4 = fastRecordHistoryDetailActivity.viewAdapter;
            if (fastRecordDetailHistoryViewAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            } else {
                fastRecordDetailHistoryViewAdapter = fastRecordDetailHistoryViewAdapter4;
            }
            if (fastRecordDetailHistoryViewAdapter.hasData()) {
                View view5 = fastRecordHistoryDetailActivity.getLayout().c;
                Intrinsics.checkNotNullExpressionValue(view5, "ivBottomTran");
                view5.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final boolean globalLayoutListener$lambda$2(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        if (motionEvent.getAction() != 0) {
            return false;
        }
        Rect rect = new Rect();
        fastRecordHistoryDetailActivity.getLayout().k.c.f.getGlobalVisibleRect(rect);
        if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            LogExt.logW("resetTagShow llContentContainer when out rect", TAG);
            fastRecordHistoryDetailActivity.resetTagShow();
        }
        Rect rect2 = new Rect();
        fastRecordHistoryDetailActivity.getLayout().k.c.i.getGlobalVisibleRect(rect2);
        if (rect2.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        LogExt.logW("resetTagShow llPersonContainer when out rect", TAG);
        fastRecordHistoryDetailActivity.resetTagShow();
        return false;
    }

    private final void gotoTagEditPage(String str) {
        Intent intent = new Intent(this, FastRecordTagScheduleDialog.class);
        intent.putExtra("RECORD_ID", this.recordId);
        intent.putExtra(FastRecordTagScheduleDialog.TAG_TYPE, str);
        startActivity(intent);
    }

    private final void hidePlayIndex() {
        getLayout().k.i.setIndexHideState(true);
        getLayout().k.i.invalidate();
    }

    private final void initAiSummaryStateObserver() {
        FastRecordAiSummaryOperatorManager.INSTANCE.getRecordAiSummaryFinish().observe(this, new FastRecordHistoryDetailActivity$sam$androidx_lifecycle_Observer$0(new FastRecordHistoryDetailActivity$initAiSummaryStateObserver$1(this)));
    }

    private final void initAiTodoStateObserver() {
        FastRecordAiTodoOperatorManager.INSTANCE.getRecordAiTodoDataChange().observe(this, new FastRecordHistoryDetailActivity$sam$androidx_lifecycle_Observer$0(new FastRecordHistoryDetailActivity$initAiTodoStateObserver$1(this)));
    }

    private final void initAsrRequestCallback() {
        this.asrCallbackInterface = new FastRecordHistoryDetailActivity$initAsrRequestCallback$1(this);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initCommonView() {
        ImageView imageView = getLayout().e.b;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivPlayOrPause");
        ViewClickExtKt.clickJitter$default(imageView, 0, new FastRecordHistoryDetailActivity$initCommonView$1(this), 1, (Object) null);
        TextView textView = getLayout().g.g;
        Intrinsics.checkNotNullExpressionValue(textView, "reAsrBtn");
        ViewClickExtKt.clickJitter$default(textView, 0, new FastRecordHistoryDetailActivity$initCommonView$2(this), 1, (Object) null);
        TextView textView2 = getLayout().f.b;
        Intrinsics.checkNotNullExpressionValue(textView2, "reAsrBtn");
        ViewClickExtKt.clickJitter$default(textView2, 0, new FastRecordHistoryDetailActivity$initCommonView$3(this), 1, (Object) null);
        getLayout().e.getRoot().setOnTouchListener(new f0(this));
        getLayout().e.f.setText(this.curSpend);
        LinearLayout linearLayout = getLayout().e.d;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llSpend");
        ViewClickExtKt.clickJitter$default(linearLayout, 0, new FastRecordHistoryDetailActivity$initCommonView$5(this), 1, (Object) null);
        LinearLayout linearLayout2 = getLayout().e.c;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "llCopy");
        ViewClickExtKt.clickJitter$default(linearLayout2, 0, new FastRecordHistoryDetailActivity$initCommonView$6(this), 1, (Object) null);
        getLayout().e.b.setClickable(false);
        getLayout().e.c.setClickable(false);
        getLayout().g.h.post(new g(this));
    }

    /* access modifiers changed from: private */
    public static final boolean initCommonView$lambda$13(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        fastRecordHistoryDetailActivity.resetTagShow();
        return false;
    }

    /* access modifiers changed from: private */
    public static final void initCommonView$lambda$14(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        fastRecordHistoryDetailActivity.getLayout().g.h.fullScroll(130);
    }

    private final void initContentTag() {
        getLayout().k.c.g.setClickable(false);
        getLayout().k.c.j.setClickable(false);
        getLayout().k.c.j.setOnClickListener(new f(this));
        getLayout().k.c.j.setOnLongClickListener(new q(this));
        getLayout().k.c.g.setOnLongClickListener(new y(this));
        getLayout().k.c.g.setOnClickListener(new z(this));
        getLayout().k.c.b.setOnClickListener(new a0(this));
        getLayout().k.c.d.setOnClickListener(new b0(this));
    }

    /* access modifiers changed from: private */
    public static final void initContentTag$lambda$19(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        fastRecordHistoryDetailActivity.gotoTagEditPage(fastRecordHistoryDetailActivity.getViewModel().getCurRecordType() == 1 ? FastRecordTagScheduleDialog.SCENE_PERSON_TAG : FastRecordTagScheduleDialog.PHONE_PERSON_TAG);
    }

    /* access modifiers changed from: private */
    public static final boolean initContentTag$lambda$20(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        fastRecordHistoryDetailActivity.gotoTagEditPage(fastRecordHistoryDetailActivity.getViewModel().getCurRecordType() == 1 ? FastRecordTagScheduleDialog.SCENE_PERSON_TAG : FastRecordTagScheduleDialog.PHONE_PERSON_TAG);
        return true;
    }

    /* access modifiers changed from: private */
    public static final boolean initContentTag$lambda$21(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        fastRecordHistoryDetailActivity.gotoTagEditPage(FastRecordTagScheduleDialog.CONTENT_TAG);
        return true;
    }

    /* access modifiers changed from: private */
    public static final void initContentTag$lambda$22(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        fastRecordHistoryDetailActivity.gotoTagEditPage(FastRecordTagScheduleDialog.CONTENT_TAG);
    }

    /* access modifiers changed from: private */
    public static final void initContentTag$lambda$23(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        TextView textView = fastRecordHistoryDetailActivity.getLayout().k.c.k;
        Intrinsics.checkNotNullExpressionValue(textView, "tvContentLabelTagMore");
        fastRecordHistoryDetailActivity.showTagState(textView.getVisibility() == 0);
        TextView textView2 = fastRecordHistoryDetailActivity.getLayout().k.c.n;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvPersonLabelTagMore");
        if (textView2.getVisibility() == 0) {
            fastRecordHistoryDetailActivity.showPersonState(true);
        }
    }

    /* access modifiers changed from: private */
    public static final void initContentTag$lambda$24(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        TextView textView = fastRecordHistoryDetailActivity.getLayout().k.c.n;
        Intrinsics.checkNotNullExpressionValue(textView, "tvPersonLabelTagMore");
        fastRecordHistoryDetailActivity.showPersonState(textView.getVisibility() == 0);
        TextView textView2 = fastRecordHistoryDetailActivity.getLayout().k.c.k;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvContentLabelTagMore");
        if (textView2.getVisibility() == 0) {
            fastRecordHistoryDetailActivity.showTagState(true);
        }
    }

    /* access modifiers changed from: private */
    public final void initMediaAndShowNormalState() {
        LogExt.logE("initMediaAndShowNormalState star", TAG);
        String curRecordLastWavChannelPath = getViewModel().getCurRecordLastWavChannelPath();
        if (curRecordLastWavChannelPath != null) {
            initWavPlayer(curRecordLastWavChannelPath);
        }
        FastRecordHistoryAsrOperatorManager fastRecordHistoryAsrOperatorManager = FastRecordHistoryAsrOperatorManager.INSTANCE;
        Long l = this.recordId;
        long j = 0;
        if (fastRecordHistoryAsrOperatorManager.isInWorkingTaskList(l != null ? l.longValue() : 0)) {
            Long l2 = this.recordId;
            LogExt.logE("initMediaAndShowNormalState isInWorkingTaskList recordId = " + l2, TAG);
            showLoadingState();
            Long l3 = this.recordId;
            AsrDuringProgress recordState = fastRecordHistoryAsrOperatorManager.getRecordState(l3 != null ? l3.longValue() : 0);
            if (recordState != null) {
                LogExt.logE("initMediaAndShowNormalState showAsrDuringProgress", TAG);
                showAsrDuringProgress(recordState);
            }
            Long l4 = this.recordId;
            if (l4 != null) {
                j = l4.longValue();
            }
            fastRecordHistoryAsrOperatorManager.addAsrTaskCallback(j, this.asrCallbackInterface);
        } else if (this.isFailStatus) {
            showFailAsrState$default(this, (String) null, 1, (Object) null);
            this.isFailStatus = false;
        } else {
            showReAsrState();
        }
    }

    private final void initPlayerView(String str) {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new FastRecordHistoryDetailActivity$initPlayerView$1(str, this, (Continuation<? super FastRecordHistoryDetailActivity$initPlayerView$1>) null), 3, (Object) null);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initRecordView() {
        getLayout().k.i.setDoOnPlayBarChanged(new FastRecordHistoryDetailActivity$initRecordView$1(this));
        getLayout().k.i.setDoOnPlayBarChangeEnd(new FastRecordHistoryDetailActivity$initRecordView$2(this));
        getLayout().k.i.setDoOnPlayClickPosition(new FastRecordHistoryDetailActivity$initRecordView$3(this));
        getLayout().j.setOnTouchListener(new k(this));
        getLayout().k.i.setDoOnTouchDown(new FastRecordHistoryDetailActivity$initRecordView$5(this));
    }

    /* access modifiers changed from: private */
    public static final boolean initRecordView$lambda$6(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        fastRecordHistoryDetailActivity.resetTagShow();
        return false;
    }

    private final void initRecyclerView() {
        RecyclerView recyclerView = getLayout().j;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recRecord");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter = new FastRecordDetailHistoryViewAdapter();
        this.viewAdapter = fastRecordDetailHistoryViewAdapter;
        fastRecordDetailHistoryViewAdapter.setItemListener(new FastRecordHistoryDetailActivity$initRecyclerView$1(this));
        FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter2 = this.viewAdapter;
        if (fastRecordDetailHistoryViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            fastRecordDetailHistoryViewAdapter2 = null;
        }
        recyclerView.setAdapter(fastRecordDetailHistoryViewAdapter2);
    }

    private final void initTagLiveData() {
        getViewModel().getCurRecordNormalContentTagList().observe(this, new FastRecordHistoryDetailActivity$sam$androidx_lifecycle_Observer$0(new FastRecordHistoryDetailActivity$initTagLiveData$1(this)));
        getViewModel().getCurRecordNormalPersonTagEntityList().observe(this, new FastRecordHistoryDetailActivity$sam$androidx_lifecycle_Observer$0(new FastRecordHistoryDetailActivity$initTagLiveData$2(this)));
    }

    private final void initTitleClicker() {
        getLayout().k.e.getSaveBtn().setText(getString(R.string.fast_record_save));
        getLayout().k.e.getBackImg().setOnClickListener(new r(this));
        getLayout().k.e.getShare().setOnClickListener(new s(this));
        getLayout().k.e.getAiImg().setOnClickListener(new t(this));
        getLayout().k.e.getDelImage().setOnClickListener(new u(this));
        getLayout().k.e.getSaveBtn().setOnClickListener(new v(this));
    }

    /* access modifiers changed from: private */
    public static final void initTitleClicker$lambda$10(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        fastRecordHistoryDetailActivity.delRecord();
        fastRecordHistoryDetailActivity.resetTagShow();
    }

    /* access modifiers changed from: private */
    public static final void initTitleClicker$lambda$12(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        Object systemService = fastRecordHistoryDetailActivity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(fastRecordHistoryDetailActivity.getLayout().getRoot().getWindowToken(), 0);
        FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter = fastRecordHistoryDetailActivity.viewAdapter;
        if (fastRecordDetailHistoryViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            fastRecordDetailHistoryViewAdapter = null;
        }
        fastRecordDetailHistoryViewAdapter.clearEditStateAndSaveData(new FastRecordHistoryDetailActivity$initTitleClicker$5$1(fastRecordHistoryDetailActivity));
        fastRecordHistoryDetailActivity.getViewModel().setPageState(FastRecordDetailRecordHistoryViewModel.PLAY_STATE);
        fastRecordHistoryDetailActivity.resetTagShow();
        ViewGroup.LayoutParams layoutParams = fastRecordHistoryDetailActivity.getLayout().k.i.getLayoutParams();
        layoutParams.height = fastRecordHistoryDetailActivity.getResources().getDimensionPixelSize(R.dimen.speech_recognition_player_height);
        fastRecordHistoryDetailActivity.getLayout().k.i.setLayoutParams(layoutParams);
        fastRecordHistoryDetailActivity.getLayout().k.i.setEditMode(false);
        fastRecordHistoryDetailActivity.handler.postDelayed(new i(fastRecordHistoryDetailActivity), 200);
    }

    /* access modifiers changed from: private */
    public static final void initTitleClicker$lambda$12$lambda$11(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        ConstraintLayout b = fastRecordHistoryDetailActivity.getLayout().e.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        b.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void initTitleClicker$lambda$7(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        if (Intrinsics.areEqual((Object) fastRecordHistoryDetailActivity.getViewModel().getPageState(), (Object) FastRecordDetailRecordHistoryViewModel.PLAY_STATE)) {
            fastRecordHistoryDetailActivity.finishAndHidePlayIndex();
            return;
        }
        FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter = fastRecordHistoryDetailActivity.viewAdapter;
        if (fastRecordDetailHistoryViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            fastRecordDetailHistoryViewAdapter = null;
        }
        if (fastRecordDetailHistoryViewAdapter.checkItemWorkHasChange()) {
            fastRecordHistoryDetailActivity.showSaveAsrDialog();
        } else {
            fastRecordHistoryDetailActivity.finishAndHidePlayIndex();
        }
    }

    /* access modifiers changed from: private */
    public static final void initTitleClicker$lambda$8(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        fastRecordHistoryDetailActivity.shareRecord();
        fastRecordHistoryDetailActivity.resetTagShow();
    }

    /* access modifiers changed from: private */
    public static final void initTitleClicker$lambda$9(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        boolean e = SdkContext.f6675a.c().e();
        Object tag = fastRecordHistoryDetailActivity.getLayout().k.e.getAiImg().getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Boolean");
        boolean booleanValue = ((Boolean) tag).booleanValue();
        LogExt.logE("isIntlVersion = " + e + " tag = " + booleanValue, TAG);
        if (!booleanValue) {
            boolean isCanStartAiAsr = fastRecordHistoryDetailActivity.getViewModel().isCanStartAiAsr();
            LogExt.logE("isIntl = " + e + ",isCanStartAiAsr = " + isCanStartAiAsr, TAG);
            if (e && fastRecordHistoryDetailActivity.getViewModel().isCanStartAiAsr()) {
                UToast.Companion companion = UToast.f6444a;
                String string = fastRecordHistoryDetailActivity.getString(R.string.fr_ai_analysis_support_tip);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                companion.d(fastRecordHistoryDetailActivity, string);
                return;
            }
            return;
        }
        fastRecordHistoryDetailActivity.getSummaryRequestBean(new FastRecordHistoryDetailActivity$initTitleClicker$3$1(fastRecordHistoryDetailActivity));
        fastRecordHistoryDetailActivity.resetTagShow();
    }

    /* access modifiers changed from: private */
    public final void initTopLayoutHeight() {
        int measuredHeight = getLayout().k.getRoot().getMeasuredHeight();
        this.topHeight = measuredHeight;
        int measuredHeight2 = getLayout().k.getRoot().getMeasuredHeight();
        LogExt.logE("initTopLayoutHeight topHeight = " + measuredHeight + ", layout.titleLayout.root measuredHeight = " + measuredHeight2, TAG);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initView() {
        globalLayoutListener();
        boolean z = this.isFailStatus;
        LogExt.logE("initView --->isFailStatus = " + z, TAG);
        initTitleClicker();
        initRecyclerView();
        initRecordView();
        initCommonView();
        resetTagShow();
        initContentTag();
        showReAsrState();
        setAiImageState(false);
    }

    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    private final void initViewModel() {
        showAnalysisDialog();
        initAsrRequestCallback();
        initTagLiveData();
        getViewModel().getCurRecordData().observe(this, new FastRecordHistoryDetailActivity$sam$androidx_lifecycle_Observer$0(new FastRecordHistoryDetailActivity$initViewModel$1(this)));
        getViewModel().getCurRecordVoicePlayState().observe(this, new FastRecordHistoryDetailActivity$sam$androidx_lifecycle_Observer$0(new FastRecordHistoryDetailActivity$initViewModel$2(this)));
        getViewModel().getCurRecordVoiceWordList().observe(this, new FastRecordHistoryDetailActivity$sam$androidx_lifecycle_Observer$0(new FastRecordHistoryDetailActivity$initViewModel$3(this)));
        getViewModel().getCurPageState().observe(this, new FastRecordHistoryDetailActivity$sam$androidx_lifecycle_Observer$0(new FastRecordHistoryDetailActivity$initViewModel$4(this)));
        getViewModel().getCurIsFinishAiSummary().observe(this, new FastRecordHistoryDetailActivity$sam$androidx_lifecycle_Observer$0(new FastRecordHistoryDetailActivity$initViewModel$5(this)));
        FastRecordManager.Companion companion = FastRecordManager.Companion;
        companion.getInstance().appViewModel().getRecordStartRecordDetailIng().observe(this, new FastRecordHistoryDetailActivity$sam$androidx_lifecycle_Observer$0(new FastRecordHistoryDetailActivity$initViewModel$6(this)));
        companion.getInstance().appViewModel().getRecordAsrDuringProgress().observe(this, new FastRecordHistoryDetailActivity$sam$androidx_lifecycle_Observer$0(new FastRecordHistoryDetailActivity$initViewModel$7(this)));
        Long l = this.recordId;
        if (l != null) {
            getViewModel().queryRecordInfo(l.longValue());
        }
        initAiSummaryStateObserver();
        initAiTodoStateObserver();
    }

    private final void initWavPlayer(String str) {
        if (!new File(str).exists()) {
            LogExt.logE("path is no exist", TAG);
            return;
        }
        initPlayerView(str);
        startMediaPlayer(str);
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$39(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        fastRecordHistoryDetailActivity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(fastRecordHistoryDetailActivity.mOnGlobalLayoutListener);
    }

    /* access modifiers changed from: private */
    public final void playAndSetSpeed() {
        Object obj;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            try {
                Result.Companion companion = Result.Companion;
                mediaPlayer.setPlaybackParams(mediaPlayer.getPlaybackParams().setSpeed(this.playbackSpeed));
                obj = Result.m20constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m20constructorimpl(ResultKt.createFailure(th));
            }
            Result.m19boximpl(obj);
        }
    }

    /* access modifiers changed from: private */
    public final void playPosition(int i) {
        if (FastRecordManager.Companion.getInstance().appViewModel().isRecordingDuring()) {
            LogExt.logE("playPosition isRecordingDuring is true return", TAG);
            UToast.f6444a.b(this, R.string.fast_record_recording_can_not_play);
            return;
        }
        FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter = this.viewAdapter;
        if (fastRecordDetailHistoryViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            fastRecordDetailHistoryViewAdapter = null;
        }
        long positionStartTime = fastRecordDetailHistoryViewAdapter.getPositionStartTime(i);
        int i2 = (int) positionStartTime;
        this.curPlayerPosition = i2;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            playAndSetSpeed();
        }
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.seekTo(i2);
        }
        getLayout().k.h.setText(RecordDateUtil.INSTANCE.getDateToString(positionStartTime, "H:mm:ss"));
        getViewModel().updatePlayState(true);
        getLayout().k.i.setCurrentPosition(positionStartTime);
    }

    /* access modifiers changed from: private */
    public final void reStartAsr() {
        showLoadingState();
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordHistoryDetailActivity$reStartAsr$1(this, (Continuation<? super FastRecordHistoryDetailActivity$reStartAsr$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void resetTagShow() {
        LinearLayout linearLayout = getLayout().k.c.j;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llPersonTag");
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = getLayout().k.c.g;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "llContentTag");
        linearLayout2.setVisibility(0);
        getLayout().k.c.d.setImageResource(R.drawable.ic_show_more_tag);
        getLayout().k.c.b.setImageResource(R.drawable.ic_show_more_tag);
        showPersonState(true);
        showTagState(true);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void setAiImageState(boolean z) {
        boolean e = SdkContext.f6675a.c().e();
        LogExt.logE("isIntlVersion = " + e, TAG);
        if (e && !getViewModel().isAiLanguageSupport()) {
            z = false;
        }
        Drawable drawable = z ? getDrawable(R.drawable.ic_fast_record_ai_btn) : getDrawable(R.drawable.ic_fast_record_ai_disable_btn);
        getLayout().k.e.getAiImg().setTag(Boolean.valueOf(z));
        getLayout().k.e.getAiImg().setImageDrawable(drawable);
    }

    private final void setPlaySpend() {
        String str = this.curSpend;
        int hashCode = str.hashCode();
        if (hashCode != 1607) {
            if (hashCode != 1638) {
                if (hashCode != 1475905) {
                    if (hashCode == 1505696 && str.equals(SPEND_ONE_HALF)) {
                        this.curSpend = SPEND_TWO;
                        this.playbackSpeed = 2.0f;
                    }
                } else if (str.equals(SPEND_HALF)) {
                    this.curSpend = SPEND_ONE;
                    this.playbackSpeed = 1.0f;
                }
            } else if (str.equals(SPEND_TWO)) {
                this.curSpend = SPEND_HALF;
                this.playbackSpeed = 0.5f;
            }
        } else if (str.equals(SPEND_ONE)) {
            this.curSpend = SPEND_ONE_HALF;
            this.playbackSpeed = 1.5f;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            float f = this.playbackSpeed;
            LogExt.logE("setSpeed playbackSpeed = " + f, TAG);
            if (mediaPlayer.getPlaybackParams().getSpeed() != this.playbackSpeed && mediaPlayer.isPlaying()) {
                try {
                    Result.Companion companion = Result.Companion;
                    mediaPlayer.setPlaybackParams(mediaPlayer.getPlaybackParams().setSpeed(this.playbackSpeed));
                    Result.m20constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m20constructorimpl(ResultKt.createFailure(th));
                }
            }
        }
        getLayout().e.f.setText(this.curSpend);
    }

    /* access modifiers changed from: private */
    public final void setRecordPlayTime(long j) {
        getLayout().k.h.setText(RecordDateUtil.INSTANCE.getDateToString(j, "H:mm:ss"));
        getLayout().k.i.setCurrentPosition(j);
        if (Intrinsics.areEqual((Object) getViewModel().getPageState(), (Object) FastRecordDetailRecordHistoryViewModel.PLAY_STATE)) {
            updateRecordRecyclerViewItem(j);
        }
    }

    /* access modifiers changed from: private */
    public final void shareByType(String str) {
        RecordEntity value = getViewModel().getCurRecordData().getValue();
        Long l = this.recordId;
        LogExt.logV("shareByType type = " + str + ",value = " + value + ",record = " + l, TAG);
        showShareLoadingDialog();
        getViewModel().getFastRecordShareFilePath(this, this.recordId, str, new FastRecordHistoryDetailActivity$shareByType$1(this, str));
    }

    /* access modifiers changed from: private */
    public final void shareFilePath(ArrayList<Uri> arrayList, String str) {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordHistoryDetailActivity$shareFilePath$1(this, arrayList, str, (Continuation<? super FastRecordHistoryDetailActivity$shareFilePath$1>) null), 3, (Object) null);
    }

    private final void shareRecord() {
        RecordEntity curRecordEntity = getViewModel().getCurRecordEntity();
        if (curRecordEntity != null) {
            LogExt.logE("shareRecord record = " + curRecordEntity, TAG);
            RecordVoiceUtils recordVoiceUtils = RecordVoiceUtils.INSTANCE;
            ArrayList arrayList = new ArrayList();
            arrayList.add(curRecordEntity);
            recordVoiceUtils.checkFastRecordShareType(arrayList, new FastRecordHistoryDetailActivity$shareRecord$1$2(this));
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void showAiAndCopyImage(boolean z) {
        boolean isHasAiData = getViewModel().isHasAiData();
        LogExt.logE("showAiImage isFinishAsr = " + z + ",isHasAiData = " + isHasAiData, TAG);
        setAiImageState(z || getViewModel().isHasAiData());
        int color = z ? getColor(R.color.fast_record_copy_normal_color) : getColor(R.color.fast_record_copy_disable_color);
        getLayout().e.c.setClickable(z);
        getLayout().e.e.setTextColor(color);
    }

    private final void showAnalysisDialog() {
        if (this.isFinishShowAnalysisDialog) {
            LogExt.logE("showAnalysisDialog finish show", TAG);
            return;
        }
        this.isFinishShowAnalysisDialog = true;
        LoadingDialog loadingDialog = this.mAnalysisDialog;
        if (loadingDialog == null) {
            LoadingDialog loadingDialog2 = new LoadingDialog(this);
            loadingDialog2.setMessage((CharSequence) getString(R.string.fast_record_analysis));
            loadingDialog2.setBackgroundDrawableResource(R.drawable.bg_fast_record_loading_alert);
            loadingDialog2.setMessageTextColorResource(R.color.fast_record_color_tl_loading_msg_text);
            loadingDialog2.setCanceledOnTouchOutside(false);
            loadingDialog2.setCancelable(false);
            loadingDialog2.show();
            this.mAnalysisDialog = loadingDialog2;
        } else if (loadingDialog != null) {
            loadingDialog.show();
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void showAsrDuringProgress(AsrDuringProgress asrDuringProgress) {
        boolean isFail = asrDuringProgress.isFail();
        boolean isFinish = asrDuringProgress.isFinish();
        long curAsrTime = asrDuringProgress.getCurAsrTime();
        long totalTime = asrDuringProgress.getTotalTime();
        String name = Thread.currentThread().getName();
        LogExt.logE("event = " + asrDuringProgress + " ,isFail = " + isFail + ",isFinish = " + isFinish + ",curAsrTime = " + curAsrTime + ",totalTime = " + totalTime + ",curThread = " + name, TAG);
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordHistoryDetailActivity$showAsrDuringProgress$1(asrDuringProgress, this, (Continuation<? super FastRecordHistoryDetailActivity$showAsrDuringProgress$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showContentTagInfo() {
        if (isFinishing()) {
            LogExt.logE("showContentTagInfo isFinishing ", TAG);
            return;
        }
        LogExt.logE("showContentTagInfo", TAG);
        getLayout().k.c.g.setClickable(true);
        boolean isEmpty = TextUtils.isEmpty(this.tagContentValue);
        TextView textView = getLayout().k.c.m;
        Intrinsics.checkNotNullExpressionValue(textView, "tvContentLabelTagTip");
        int i = 0;
        textView.setVisibility(isEmpty ? 0 : 8);
        TextView textView2 = getLayout().k.c.l;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvContentLabelTagSingle");
        if (!(!isEmpty)) {
            i = 8;
        }
        textView2.setVisibility(i);
        getLayout().k.c.l.setText(this.tagContentValue);
        TextView textView3 = getLayout().k.c.k;
        Intrinsics.checkNotNullExpressionValue(textView3, "tvContentLabelTagMore");
        textView3.setVisibility(8);
        getLayout().k.c.b.setImageResource(R.drawable.ic_show_more_tag);
        getLayout().k.c.k.setText(this.tagContentValue);
        getLayout().k.c.l.post(new h(this));
    }

    /* access modifiers changed from: private */
    public static final void showContentTagInfo$lambda$17(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        try {
            int i = 8;
            if (TextUtils.isEmpty(fastRecordHistoryDetailActivity.tagContentValue)) {
                ImageView imageView = fastRecordHistoryDetailActivity.getLayout().k.c.b;
                Intrinsics.checkNotNullExpressionValue(imageView, "ivContentShowMore");
                imageView.setVisibility(8);
                return;
            }
            Layout layout = fastRecordHistoryDetailActivity.getLayout().k.c.l.getLayout();
            Intrinsics.checkNotNullExpressionValue(layout, "getLayout(...)");
            TextView textView = fastRecordHistoryDetailActivity.getLayout().k.c.l;
            Intrinsics.checkNotNullExpressionValue(textView, "tvContentLabelTagSingle");
            boolean textViewIsEllipsis = fastRecordHistoryDetailActivity.textViewIsEllipsis(layout, textView);
            ImageView imageView2 = fastRecordHistoryDetailActivity.getLayout().k.c.b;
            Intrinsics.checkNotNullExpressionValue(imageView2, "ivContentShowMore");
            if (textViewIsEllipsis) {
                i = 0;
            }
            imageView2.setVisibility(i);
        } catch (Exception e) {
            String message = e.getMessage();
            LogExt.logE("showContentTagInfo tvContentLabelTag post error = " + message, TAG);
        }
    }

    /* access modifiers changed from: private */
    public final void showEmptyAsrState() {
        if (RecordConstants.INSTANCE.isIntlVersion()) {
            LogExt.logE("showEmptyAsrState is intl new", TAG);
            showFailAsrState$default(this, (String) null, 1, (Object) null);
            TextView textView = getLayout().g.i;
            Intrinsics.checkNotNullExpressionValue(textView, "tvReAsrFailTip");
            textView.setVisibility(8);
            getLayout().g.i.setText(getResources().getString(R.string.fast_record_empty_tip));
            TextView textView2 = getLayout().g.f.d;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvFailTipNumber");
            textView2.setVisibility(8);
            getLayout().g.f.c.setText(getResources().getString(R.string.fr_asr_empyt_intl_tip));
            LinearLayout b = getLayout().g.f.getRoot();
            Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
            b.setVisibility(0);
            LinearLayout b2 = getLayout().g.c.getRoot();
            Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
            b2.setVisibility(8);
            LinearLayout b3 = getLayout().g.e.getRoot();
            Intrinsics.checkNotNullExpressionValue(b3, "getRoot(...)");
            b3.setVisibility(8);
            LinearLayout b4 = getLayout().g.d.getRoot();
            Intrinsics.checkNotNullExpressionValue(b4, "getRoot(...)");
            b4.setVisibility(8);
            LinearLayout b5 = getLayout().g.b.getRoot();
            Intrinsics.checkNotNullExpressionValue(b5, "getRoot(...)");
            b5.setVisibility(8);
            return;
        }
        ScrollView b6 = getLayout().g.getRoot();
        Intrinsics.checkNotNullExpressionValue(b6, "getRoot(...)");
        b6.setVisibility(8);
        LinearLayout b7 = getLayout().f.getRoot();
        Intrinsics.checkNotNullExpressionValue(b7, "getRoot(...)");
        b7.setVisibility(0);
        LinearLayout b8 = getLayout().h.getRoot();
        Intrinsics.checkNotNullExpressionValue(b8, "getRoot(...)");
        b8.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void showFailAsrState(String str) {
        LogExt.logE("showFailAsrState code=" + str, TAG);
        ScrollView b = getLayout().g.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        b.setVisibility(0);
        TextView textView = getLayout().g.i;
        Intrinsics.checkNotNullExpressionValue(textView, "tvReAsrFailTip");
        textView.setVisibility(0);
        LinearLayout b2 = getLayout().h.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        b2.setVisibility(8);
        LinearLayout b3 = getLayout().f.getRoot();
        Intrinsics.checkNotNullExpressionValue(b3, "getRoot(...)");
        b3.setVisibility(8);
        getLayout().g.h.post(new j(this));
        String string = getResources().getString(R.string.fast_record_fail_tip);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (Intrinsics.areEqual((Object) FastRecordHistoryAsrOperator.NETWORK_CHANGE, (Object) str) || !NetworkUtils.f7898a.g()) {
            string = getResources().getString(R.string.fast_record_fail_network_tip);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        getLayout().g.i.setText(string);
        showFailTip();
    }

    public static /* synthetic */ void showFailAsrState$default(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        fastRecordHistoryDetailActivity.showFailAsrState(str);
    }

    /* access modifiers changed from: private */
    public static final void showFailAsrState$lambda$37(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        fastRecordHistoryDetailActivity.getLayout().g.h.fullScroll(130);
    }

    private final void showFailTip() {
        Unit unit;
        LinearLayout b = getLayout().g.f.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        b.setVisibility(8);
        getLayout().g.c.d.setText("1.");
        getLayout().g.e.d.setText("2.");
        getLayout().g.d.d.setText("3.");
        getLayout().g.b.d.setText("4.");
        LinearLayout b2 = getLayout().g.c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        b2.setVisibility(0);
        LinearLayout b3 = getLayout().g.e.getRoot();
        Intrinsics.checkNotNullExpressionValue(b3, "getRoot(...)");
        b3.setVisibility(0);
        LinearLayout b4 = getLayout().g.d.getRoot();
        Intrinsics.checkNotNullExpressionValue(b4, "getRoot(...)");
        b4.setVisibility(0);
        LinearLayout b5 = getLayout().g.b.getRoot();
        Intrinsics.checkNotNullExpressionValue(b5, "getRoot(...)");
        b5.setVisibility(0);
        getLayout().g.c.c.setText(getResources().getString(R.string.fast_record_asr_tip_content_one));
        getLayout().g.e.c.setText(getResources().getString(R.string.fast_record_asr_tip_content_two));
        getLayout().g.d.c.setText(getResources().getString(R.string.fast_record_asr_tip_content_three));
        if (RecordConstants.INSTANCE.isIntlVersion()) {
            LogExt.logE("showFailTip isIntlVersion ", TAG);
            try {
                Result.Companion companion = Result.Companion;
                FastRecordLanguageBean fastRecordLanguageBean = (FastRecordLanguageBean) new Gson().fromJson(RecordDataSaveUtil.INSTANCE.getAiLanguageType(), FastRecordLanguageBean.class);
                if (fastRecordLanguageBean != null) {
                    Intrinsics.checkNotNull(fastRecordLanguageBean);
                    getLayout().g.b.c.setText(getResources().getString(R.string.fast_record_asr_tip_content_for_intl_four, new Object[]{getTypeName(fastRecordLanguageBean.getLangType())}));
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                Result.m20constructorimpl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m20constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            LogExt.logE("showFailTip isChinaVersion ", TAG);
            getLayout().g.b.c.setText(getResources().getString(R.string.fast_record_asr_tip_content_four));
        }
    }

    private final void showLoadingState() {
        ScrollView b = getLayout().g.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        b.setVisibility(8);
        LinearLayout b2 = getLayout().f.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        b2.setVisibility(8);
        LinearLayout b3 = getLayout().h.getRoot();
        Intrinsics.checkNotNullExpressionValue(b3, "getRoot(...)");
        b3.setVisibility(0);
        getLayout().h.c.setText(getString(R.string.fast_record_loading));
        FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter = this.viewAdapter;
        if (fastRecordDetailHistoryViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            fastRecordDetailHistoryViewAdapter = null;
        }
        fastRecordDetailHistoryViewAdapter.setData(new ArrayList());
    }

    private final void showMergeVoiceDialog() {
        if (this.dialog == null) {
            this.dialog = new AlertDialog.Builder(this).setTitle(R.string.fast_record_merge_record_wait_text).setPositiveButton(R.string.fast_record_ok, (DialogInterface.OnClickListener) new m(this)).setNegativeButton(R.string.fast_record_cancel, (DialogInterface.OnClickListener) new n(this)).create();
        }
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog alertDialog2 = this.dialog;
        if (alertDialog2 != null) {
            alertDialog2.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void showMergeVoiceDialog$lambda$33(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        fastRecordHistoryDetailActivity.getViewModel().setChangeVoiceState(false);
        Long l = fastRecordHistoryDetailActivity.recordId;
        if (l != null) {
            fastRecordHistoryDetailActivity.getViewModel().setNoFinishAsr(l.longValue());
        }
        fastRecordHistoryDetailActivity.reStartAsr();
    }

    /* access modifiers changed from: private */
    public static final void showMergeVoiceDialog$lambda$34(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        fastRecordHistoryDetailActivity.getViewModel().setChangeVoiceState(false);
    }

    private final void showPersonState(boolean z) {
        if (z) {
            getLayout().k.c.d.setImageResource(R.drawable.ic_show_more_tag);
            TextView textView = getLayout().k.c.o;
            Intrinsics.checkNotNullExpressionValue(textView, "tvPersonLabelTagSingle");
            textView.setVisibility(0);
            TextView textView2 = getLayout().k.c.n;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvPersonLabelTagMore");
            textView2.setVisibility(8);
            return;
        }
        getLayout().k.c.d.setImageResource(R.drawable.ic_show_single_tag);
        TextView textView3 = getLayout().k.c.o;
        Intrinsics.checkNotNullExpressionValue(textView3, "tvPersonLabelTagSingle");
        textView3.setVisibility(8);
        TextView textView4 = getLayout().k.c.n;
        Intrinsics.checkNotNullExpressionValue(textView4, "tvPersonLabelTagMore");
        textView4.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void showPersonTagInfo() {
        if (isFinishing()) {
            LogExt.logE("showPersonTagInfo isFinishing ", TAG);
            return;
        }
        LogExt.logE("showPersonTagInfo", TAG);
        getLayout().k.c.j.setClickable(true);
        boolean isEmpty = TextUtils.isEmpty(this.tagPersonValue);
        TextView textView = getLayout().k.c.p;
        Intrinsics.checkNotNullExpressionValue(textView, "tvPersonLabelTagTip");
        int i = 0;
        textView.setVisibility(isEmpty ? 0 : 8);
        TextView textView2 = getLayout().k.c.o;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvPersonLabelTagSingle");
        if (!(!isEmpty)) {
            i = 8;
        }
        textView2.setVisibility(i);
        TextView textView3 = getLayout().k.c.n;
        Intrinsics.checkNotNullExpressionValue(textView3, "tvPersonLabelTagMore");
        textView3.setVisibility(8);
        getLayout().k.c.o.setText(this.tagPersonValue);
        getLayout().k.c.d.setImageResource(R.drawable.ic_show_more_tag);
        getLayout().k.c.n.setText(this.tagPersonValue);
        getLayout().k.c.o.post(new l(this));
    }

    /* access modifiers changed from: private */
    public static final void showPersonTagInfo$lambda$18(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        try {
            String str = fastRecordHistoryDetailActivity.tagPersonValue;
            LogExt.logE("showPersonTagInfo tagPersonValue = " + str, TAG);
            int i = 8;
            if (TextUtils.isEmpty(fastRecordHistoryDetailActivity.tagPersonValue)) {
                ImageView imageView = fastRecordHistoryDetailActivity.getLayout().k.c.d;
                Intrinsics.checkNotNullExpressionValue(imageView, "ivPersonShowMore");
                imageView.setVisibility(8);
                return;
            }
            Layout layout = fastRecordHistoryDetailActivity.getLayout().k.c.o.getLayout();
            Intrinsics.checkNotNullExpressionValue(layout, "getLayout(...)");
            TextView textView = fastRecordHistoryDetailActivity.getLayout().k.c.o;
            Intrinsics.checkNotNullExpressionValue(textView, "tvPersonLabelTagSingle");
            boolean textViewIsEllipsis = fastRecordHistoryDetailActivity.textViewIsEllipsis(layout, textView);
            ImageView imageView2 = fastRecordHistoryDetailActivity.getLayout().k.c.d;
            Intrinsics.checkNotNullExpressionValue(imageView2, "ivPersonShowMore");
            if (textViewIsEllipsis) {
                i = 0;
            }
            imageView2.setVisibility(i);
        } catch (Exception e) {
            String message = e.getMessage();
            LogExt.logE("showPersonTagInfo tvContentLabelTag post error = " + message, TAG);
        }
    }

    /* access modifiers changed from: private */
    public final void showReAsrState() {
        LogExt.logE("showReAsrState", TAG);
        TextView textView = getLayout().g.i;
        Intrinsics.checkNotNullExpressionValue(textView, "tvReAsrFailTip");
        textView.setVisibility(8);
        ScrollView b = getLayout().g.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        b.setVisibility(0);
        LinearLayout b2 = getLayout().f.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        b2.setVisibility(8);
        LinearLayout b3 = getLayout().h.getRoot();
        Intrinsics.checkNotNullExpressionValue(b3, "getRoot(...)");
        b3.setVisibility(8);
        FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter = this.viewAdapter;
        if (fastRecordDetailHistoryViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            fastRecordDetailHistoryViewAdapter = null;
        }
        fastRecordDetailHistoryViewAdapter.setData(new ArrayList());
        showFailTip();
    }

    private final void showSaveAsrDialog() {
        new AlertDialog.Builder(this).setTitle(R.string.fast_record_save_asr).setPositiveButton(R.string.fast_record_give_up, (DialogInterface.OnClickListener) new w(this)).setNegativeButton(R.string.fast_cancel, (DialogInterface.OnClickListener) new x()).show();
    }

    /* access modifiers changed from: private */
    public static final void showSaveAsrDialog$lambda$35(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        fastRecordHistoryDetailActivity.getViewModel().setPageState(FastRecordDetailRecordHistoryViewModel.PLAY_STATE);
        FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter = fastRecordHistoryDetailActivity.viewAdapter;
        if (fastRecordDetailHistoryViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            fastRecordDetailHistoryViewAdapter = null;
        }
        fastRecordDetailHistoryViewAdapter.clearEditStateAndNoSaveData();
        fastRecordHistoryDetailActivity.finishAndHidePlayIndex();
    }

    /* access modifiers changed from: private */
    public static final void showSaveAsrDialog$lambda$36(DialogInterface dialogInterface, int i) {
    }

    private final void showShareLoadingDialog() {
        LoadingDialog loadingDialog = this.mLoadingDialog;
        if (loadingDialog == null) {
            LoadingDialog loadingDialog2 = new LoadingDialog(this);
            loadingDialog2.setMessage((CharSequence) getString(R.string.fast_record_share_record_wait_text));
            loadingDialog2.setMessageTextColorResource(R.color.fast_record_color_tl_loading_msg_text);
            loadingDialog2.setBackgroundDrawableResource(R.drawable.bg_fast_record_loading_alert);
            loadingDialog2.show();
            this.mLoadingDialog = loadingDialog2;
        } else if (loadingDialog != null) {
            loadingDialog.show();
        }
    }

    private final void showTagState(boolean z) {
        if (z) {
            getLayout().k.c.b.setImageResource(R.drawable.ic_show_more_tag);
            TextView textView = getLayout().k.c.l;
            Intrinsics.checkNotNullExpressionValue(textView, "tvContentLabelTagSingle");
            textView.setVisibility(0);
            TextView textView2 = getLayout().k.c.k;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvContentLabelTagMore");
            textView2.setVisibility(8);
            return;
        }
        getLayout().k.c.b.setImageResource(R.drawable.ic_show_single_tag);
        TextView textView3 = getLayout().k.c.l;
        Intrinsics.checkNotNullExpressionValue(textView3, "tvContentLabelTagSingle");
        textView3.setVisibility(8);
        TextView textView4 = getLayout().k.c.k;
        Intrinsics.checkNotNullExpressionValue(textView4, "tvContentLabelTagMore");
        textView4.setVisibility(0);
    }

    private final void startMediaPlayer(String str) {
        this.mMediaPlayer = new MediaPlayer();
        Uri fromFile = Uri.fromFile(new File(str));
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setDataSource(this, fromFile);
        }
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.prepareAsync();
        }
        MediaPlayer mediaPlayer3 = this.mMediaPlayer;
        if (mediaPlayer3 != null) {
            mediaPlayer3.setOnPreparedListener(new o(this));
        }
        MediaPlayer mediaPlayer4 = this.mMediaPlayer;
        if (mediaPlayer4 != null) {
            mediaPlayer4.setOnCompletionListener(new p(this));
        }
        startUpdatePosition();
    }

    /* access modifiers changed from: private */
    public static final void startMediaPlayer$lambda$46(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        fastRecordHistoryDetailActivity.getLayout().e.b.setClickable(true);
        MediaPlayer mediaPlayer2 = fastRecordHistoryDetailActivity.mMediaPlayer;
        Integer valueOf = mediaPlayer2 != null ? Integer.valueOf(mediaPlayer2.getDuration()) : null;
        LogExt.logE("startMediaPlayer setOnPreparedListener duration  = " + valueOf, TAG);
        fastRecordHistoryDetailActivity.getViewModel().updatePlayState(false);
    }

    /* access modifiers changed from: private */
    public static final void startMediaPlayer$lambda$47(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        LogExt.logE("startMediaPlayer setOnCompletionListener", TAG);
        fastRecordHistoryDetailActivity.curPlayerPosition = 0;
        MediaPlayer mediaPlayer2 = fastRecordHistoryDetailActivity.mMediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.seekTo(0);
        }
        fastRecordHistoryDetailActivity.setRecordPlayTime((long) fastRecordHistoryDetailActivity.curPlayerPosition);
        fastRecordHistoryDetailActivity.getViewModel().updatePlayState(false);
    }

    /* access modifiers changed from: private */
    public final void startUpdatePosition() {
        if (this.showPositionJob == null) {
            this.showPositionJob = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordHistoryDetailActivity$startUpdatePosition$1(this, (Continuation<? super FastRecordHistoryDetailActivity$startUpdatePosition$1>) null), 3, (Object) null);
        }
    }

    private final boolean textViewIsEllipsis(Layout layout, TextView textView) {
        int lineCount = textView.getLineCount();
        boolean z = false;
        for (int i = 0; i < lineCount; i++) {
            int ellipsisCount = layout.getEllipsisCount(i);
            if (ellipsisCount > 0) {
                LogExt.logI("textViewIsEllipsis is ellipsized on line: " + i + " ellipsisCount:" + ellipsisCount, TAG);
                z = true;
            }
        }
        LogExt.logE("textViewIsEllipsis textView is Single = " + textView.isSingleLine() + " layout width = " + layout.getWidth() + ",result = " + z + ",lines = " + lineCount, TAG);
        return z;
    }

    private final void updateRecordRecyclerViewItem(long j) {
        FastRecordDetailHistoryViewAdapter fastRecordDetailHistoryViewAdapter = this.viewAdapter;
        if (fastRecordDetailHistoryViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            fastRecordDetailHistoryViewAdapter = null;
        }
        fastRecordDetailHistoryViewAdapter.selectRecyclerViewItem(j);
    }

    public boolean dispatchKeyEvent(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if (keyEvent.getKeyCode() == 4) {
            LogExt.logE("KEYCODE_BACK hidePlayIndex", TAG);
            hidePlayIndex();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) getLayout().getRoot());
        this.topHeight = getResources().getDimensionPixelSize(R.dimen.fast_record_history_word_top_space);
        this.recordId = Long.valueOf(getIntent().getLongExtra(RECORD_ID, 0));
        boolean booleanExtra = getIntent().getBooleanExtra(RECORD_FAIL, false);
        this.isFailStatus = booleanExtra;
        Long l = this.recordId;
        LogExt.logE("onCreate ---> recordId = " + l + ",isFailStatus = " + booleanExtra, TAG);
        initView();
        initViewModel();
    }

    public void onDestroy() {
        LoadingDialog loadingDialog;
        super.onDestroy();
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
        }
        this.mMediaPlayer = null;
        Job job = this.showPositionJob;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.showPositionJob = null;
        this.mLoadingDialog = null;
        LoadingDialog loadingDialog2 = this.mAnalysisDialog;
        if (!(loadingDialog2 == null || loadingDialog2 == null || !loadingDialog2.isShowing() || (loadingDialog = this.mAnalysisDialog) == null)) {
            loadingDialog.dismiss();
        }
        this.mAnalysisDialog = null;
        Long l = this.recordId;
        if (l != null) {
            FastRecordHistoryAsrOperatorManager.INSTANCE.removeCallback(l.longValue());
        }
    }

    public void onPause() {
        this.isPageShowing = false;
        super.onPause();
        LogExt.logE("onPause", TAG);
        getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void onResume() {
        super.onResume();
        this.isPageShowing = true;
        Long l = this.recordId;
        if (l != null) {
            long longValue = l.longValue();
            getViewModel().queryRecordNormalTagInfo(longValue);
            getViewModel().getSummaryAndTodoFromLocal(longValue);
        }
        LogExt.logE("onResume", TAG);
        this.handler.postDelayed(new c0(this), 200);
    }
}
