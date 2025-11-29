package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.CalendarContract;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.datatrack.FastRecordDataTrackManager;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity;
import com.upuphone.ar.fastrecord.phone.ext.FastRecordAppUtilsKt;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperatorManager;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil;
import com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils;
import com.upuphone.ar.fastrecord.phone.utils.TodoBean;
import com.upuphone.ar.shorthand.phone.utils.RecordGsonUtils;
import com.upuphone.xr.audio.record.ai.bean.AiFeedBackRequest;
import com.upuphone.xr.sapp.context.SdkContext;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.schedule.Event;
import com.xjsd.xr.sapp.asr.SmartExtractionHelper;
import com.xjsd.xr.sapp.asr.dao.SmartExTodo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0003\u0018\u0000 Z2\u00020\u0001:\u0002YZB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020)H\u0002J\"\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\f2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020+0.J(\u0010/\u001a\u00020+2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`32\b\u00104\u001a\u0004\u0018\u00010\u0007J0\u00105\u001a\u0012\u0012\u0004\u0012\u00020\f01j\b\u0012\u0004\u0012\u00020\f`32\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\f01j\b\u0012\u0004\u0012\u00020\f`3H\u0002J\u0006\u00107\u001a\u00020+J\u000e\u00108\u001a\u00020+2\u0006\u00109\u001a\u00020\fJ\u0006\u0010:\u001a\u00020+J\u0006\u0010;\u001a\u00020<J0\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\f01j\b\u0012\u0004\u0012\u00020\f`32\u0016\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\f01j\b\u0012\u0004\u0012\u00020\f`3H\u0002J\u0006\u0010?\u001a\u00020\u0007J\u0012\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\u0007H\u0002J\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\u0016\u0010D\u001a\u00020+2\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0EJ\u0006\u0010F\u001a\u00020\u0007J\u0006\u0010G\u001a\u00020\tJ\u0006\u0010H\u001a\u00020\tJ\b\u0010I\u001a\u00020+H\u0014J\b\u0010J\u001a\u00020)H\u0002J\b\u0010K\u001a\u00020)H\u0002J\u000e\u0010L\u001a\u00020+2\u0006\u0010M\u001a\u00020)J\u0012\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010,\u001a\u00020\fH\u0002J\b\u0010P\u001a\u00020+H\u0002J\u0006\u0010Q\u001a\u00020+J\u000e\u0010R\u001a\u00020+2\u0006\u0010S\u001a\u00020\u0019J\u0006\u0010T\u001a\u00020+J$\u0010U\u001a\u00020+2\u001a\u00106\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u000101j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`3H\u0002J\u0006\u0010V\u001a\u00020+J\u0014\u0010W\u001a\u00020+2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\f0XR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0013R\u001f\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0013R\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0013¨\u0006["}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_mCurFastRecordLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "_mSummaryLockedLiveData", "", "_mTodoEditModeLiveData", "", "_mTodoLiveData", "", "Lcom/upuphone/ar/fastrecord/phone/db/RecordTodoItemEntity;", "_mTodoResult", "", "_mTodoSensitiveLiveData", "curRecordData", "Landroidx/lifecycle/LiveData;", "getCurRecordData", "()Landroidx/lifecycle/LiveData;", "mSmartExtractionHelper", "Lcom/xjsd/xr/sapp/asr/SmartExtractionHelper;", "mTodoResult", "getMTodoResult", "requestBean", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/SummaryRequestBean;", "getRequestBean", "()Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/SummaryRequestBean;", "setRequestBean", "(Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/SummaryRequestBean;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "summaryLockedLiveData", "getSummaryLockedLiveData", "todoEditModeLiveData", "getTodoEditModeLiveData", "todoLiveData", "getTodoLiveData", "todoSensitiveLiveData", "getTodoSensitiveLiveData", "addCalendarId", "", "addEventToCalendar", "", "extnTodo", "callback", "Lkotlin/Function1;", "commandTodoList", "todoBeanList", "Ljava/util/ArrayList;", "Lcom/xjsd/xr/sapp/asr/dao/SmartExTodo$ToDo;", "Lkotlin/collections/ArrayList;", "requestId", "compareTodoForCalendar", "todoList", "deleteAllData", "deleteTodo", "todo", "editModeNotify", "getFeedBackBean", "Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackRequest;", "getNormalTodoData", "toDoList", "getRecordId", "getTodoBean", "Lcom/upuphone/ar/fastrecord/phone/utils/TodoBean;", "message", "getTodoData", "getTodoListFromLocal", "Lkotlin/Function0;", "getTodoShareText", "isAsrLanguageSupport", "isNotEmptyData", "onCleared", "queryCalendarId", "queryOrAddCalendarId", "queryRecordInfo", "recordId", "querySchedule", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel$CalendarEvent;", "reportAiDataTrack", "requestTodoListInfo", "setSummaryRequestBean", "summaryRequestBean", "startAiToDoTask", "todoDataNotify", "updateReportStateSuccess", "updateTodoList", "", "CalendarEvent", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordTodoViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTodoViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,698:1\n1855#2,2:699\n1855#2,2:701\n1864#2,3:704\n1855#2,2:707\n1#3:703\n*S KotlinDebug\n*F\n+ 1 FastRecordTodoViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel\n*L\n176#1:699,2\n640#1:701,2\n673#1:704,3\n684#1:707,2\n*E\n"})
public final class FastRecordTodoViewModel extends ViewModel {
    @NotNull
    private static final String CALENDAR_NAME = "MYVU_Fast_Record_Calendar";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int ON_HOUR_MILLIS = 3600000;
    @NotNull
    private static final String TAG = "TodoViewModel";
    public static final int TO_DO_LOCAL_EMPTY = 3;
    public static final int TO_DO_RESULT_NETWORK_EMPTY = 1;
    public static final int TO_DO_RESULT_NETWORK_FAIL = 2;
    public static final int TO_DO_RESULT_SUCCESS = 0;
    /* access modifiers changed from: private */
    @NotNull
    public static final String[] calendarPermissions = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<RecordEntity> _mCurFastRecordLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<String> _mSummaryLockedLiveData;
    @NotNull
    private MutableLiveData<Boolean> _mTodoEditModeLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<List<RecordTodoItemEntity>> _mTodoLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<Integer> _mTodoResult;
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<String> _mTodoSensitiveLiveData;
    @NotNull
    private final LiveData<RecordEntity> curRecordData;
    @Nullable
    private SmartExtractionHelper mSmartExtractionHelper;
    @NotNull
    private final LiveData<Integer> mTodoResult;
    @Nullable
    private SummaryRequestBean requestBean;
    @NotNull
    private final CoroutineScope scope = CoroutineScopeKt.a(Dispatchers.b());
    @NotNull
    private final LiveData<String> summaryLockedLiveData;
    @NotNull
    private final LiveData<Boolean> todoEditModeLiveData;
    @NotNull
    private final LiveData<List<RecordTodoItemEntity>> todoLiveData;
    @NotNull
    private final LiveData<String> todoSensitiveLiveData;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel$CalendarEvent;", "", "eventId", "", "startTime", "endTime", "(JJJ)V", "getEndTime", "()J", "getEventId", "getStartTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CalendarEvent {
        private final long endTime;
        private final long eventId;
        private final long startTime;

        public CalendarEvent(long j, long j2, long j3) {
            this.eventId = j;
            this.startTime = j2;
            this.endTime = j3;
        }

        public static /* synthetic */ CalendarEvent copy$default(CalendarEvent calendarEvent, long j, long j2, long j3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = calendarEvent.eventId;
            }
            long j4 = j;
            if ((i & 2) != 0) {
                j2 = calendarEvent.startTime;
            }
            long j5 = j2;
            if ((i & 4) != 0) {
                j3 = calendarEvent.endTime;
            }
            return calendarEvent.copy(j4, j5, j3);
        }

        public final long component1() {
            return this.eventId;
        }

        public final long component2() {
            return this.startTime;
        }

        public final long component3() {
            return this.endTime;
        }

        @NotNull
        public final CalendarEvent copy(long j, long j2, long j3) {
            return new CalendarEvent(j, j2, j3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CalendarEvent)) {
                return false;
            }
            CalendarEvent calendarEvent = (CalendarEvent) obj;
            return this.eventId == calendarEvent.eventId && this.startTime == calendarEvent.startTime && this.endTime == calendarEvent.endTime;
        }

        public final long getEndTime() {
            return this.endTime;
        }

        public final long getEventId() {
            return this.eventId;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public int hashCode() {
            return (((Long.hashCode(this.eventId) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.endTime);
        }

        @NotNull
        public String toString() {
            long j = this.eventId;
            long j2 = this.startTime;
            long j3 = this.endTime;
            return "CalendarEvent(eventId=" + j + ", startTime=" + j2 + ", endTime=" + j3 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel$Companion;", "", "()V", "CALENDAR_NAME", "", "ON_HOUR_MILLIS", "", "TAG", "TO_DO_LOCAL_EMPTY", "TO_DO_RESULT_NETWORK_EMPTY", "TO_DO_RESULT_NETWORK_FAIL", "TO_DO_RESULT_SUCCESS", "calendarPermissions", "", "getCalendarPermissions", "()[Ljava/lang/String;", "[Ljava/lang/String;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String[] getCalendarPermissions() {
            return FastRecordTodoViewModel.calendarPermissions;
        }

        private Companion() {
        }
    }

    public FastRecordTodoViewModel() {
        MutableLiveData<List<RecordTodoItemEntity>> mutableLiveData = new MutableLiveData<>();
        this._mTodoLiveData = mutableLiveData;
        this.todoLiveData = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this._mTodoResult = mutableLiveData2;
        this.mTodoResult = mutableLiveData2;
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        this._mTodoSensitiveLiveData = mutableLiveData3;
        this.todoSensitiveLiveData = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._mTodoEditModeLiveData = mutableLiveData4;
        this.todoEditModeLiveData = mutableLiveData4;
        MutableLiveData<String> mutableLiveData5 = new MutableLiveData<>();
        this._mSummaryLockedLiveData = mutableLiveData5;
        this.summaryLockedLiveData = mutableLiveData5;
        MutableLiveData<RecordEntity> mutableLiveData6 = new MutableLiveData<>();
        this._mCurFastRecordLiveData = mutableLiveData6;
        this.curRecordData = FastRecordAppUtilsKt.asLiveData(mutableLiveData6);
    }

    private final long addCalendarId() {
        String lastPathSegment;
        String accountId = RecordDataSaveUtil.INSTANCE.getAccountId();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Event.ACCOUNT_NAME, accountId);
        contentValues.put("account_type", "LOCAL");
        contentValues.put("name", accountId);
        contentValues.put("calendar_displayName", CALENDAR_NAME);
        contentValues.put("calendar_color", -16776961);
        contentValues.put("calendar_access_level", 700);
        contentValues.put("ownerAccount", accountId);
        contentValues.put("visible", 1);
        contentValues.put("sync_events", 1);
        contentValues.put("canOrganizerRespond", 0);
        contentValues.put("calendar_timezone", TimeZone.getDefault().getID());
        Uri insert = SdkContext.f6675a.c().getContext().getContentResolver().insert(CalendarContract.Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", BooleanUtils.TRUE).appendQueryParameter(Event.ACCOUNT_NAME, accountId).appendQueryParameter("account_type", "LOCAL").build(), contentValues);
        if (insert == null || (lastPathSegment = insert.getLastPathSegment()) == null) {
            return -1;
        }
        return Long.parseLong(lastPathSegment);
    }

    /* access modifiers changed from: private */
    public final ArrayList<RecordTodoItemEntity> compareTodoForCalendar(ArrayList<RecordTodoItemEntity> arrayList) {
        Unit unit;
        int size = arrayList.size();
        LogExt.logE("compareTodoForCalendar size = " + size, TAG);
        ArrayList<RecordTodoItemEntity> arrayList2 = new ArrayList<>();
        for (RecordTodoItemEntity recordTodoItemEntity : arrayList) {
            LogExt.logE("compareTodoForCalendar recordTodoItemEntity = " + recordTodoItemEntity, TAG);
            CalendarEvent querySchedule = querySchedule(recordTodoItemEntity);
            if (querySchedule != null) {
                LogExt.logE("compareTodoForCalendar it = " + querySchedule, TAG);
                if (querySchedule.getStartTime() == 0) {
                    recordTodoItemEntity.setCalendarId(0);
                    recordTodoItemEntity.setCalendarEventId(0);
                    recordTodoItemEntity.setAddSchedule(false);
                } else {
                    recordTodoItemEntity.setAddSchedule(true);
                    LogExt.logE("recordTodoItemEntity.isAddSchedule = true,recordTodoItemEntity = " + recordTodoItemEntity, TAG);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null && recordTodoItemEntity.isAddSchedule() && recordTodoItemEntity.getCalendarId() == 0 && recordTodoItemEntity.getCalendarEventId() == 0) {
                recordTodoItemEntity.setCalendarId(0);
                recordTodoItemEntity.setCalendarEventId(0);
                recordTodoItemEntity.setAddSchedule(false);
            }
            arrayList2.add(recordTodoItemEntity);
        }
        LogExt.logE("compareTodoForCalendar resultTodoList value = " + arrayList2, TAG);
        return arrayList2;
    }

    private final ArrayList<RecordTodoItemEntity> getNormalTodoData(ArrayList<RecordTodoItemEntity> arrayList) {
        ArrayList<RecordTodoItemEntity> arrayList2 = new ArrayList<>();
        for (RecordTodoItemEntity add : arrayList) {
            arrayList2.add(add);
        }
        return arrayList2;
    }

    private final TodoBean getTodoBean(String str) {
        try {
            return (TodoBean) RecordGsonUtils.a(str, TodoBean.class);
        } catch (Exception e) {
            LogExt.logE("getTodoBean::e is: " + e, TAG);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0080, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0083, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long queryCalendarId() {
        /*
            r12 = this;
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r12 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r12 = r12.getInstance()
            android.content.Context r12 = r12.appContext()
            android.content.ContentResolver r0 = r12.getContentResolver()
            android.net.Uri r1 = android.provider.CalendarContract.Calendars.CONTENT_URI
            java.lang.String r12 = "_id"
            java.lang.String r6 = "account_type"
            java.lang.String r7 = "calendar_access_level"
            java.lang.String[] r2 = new java.lang.String[]{r12, r6, r7}
            r4 = 0
            r5 = 0
            r3 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0084
            r1 = r0
            java.io.Closeable r1 = (java.io.Closeable) r1
            r2 = r1
            android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x0076 }
        L_0x0029:
            boolean r3 = r2.moveToNext()     // Catch:{ all -> 0x0076 }
            r4 = 0
            if (r3 == 0) goto L_0x0078
            int r3 = r2.getColumnIndexOrThrow(r12)     // Catch:{ all -> 0x0076 }
            long r8 = r2.getLong(r3)     // Catch:{ all -> 0x0076 }
            int r3 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x0076 }
            int r5 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x0076 }
            int r5 = r0.getInt(r5)     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r10.<init>()     // Catch:{ all -> 0x0076 }
            java.lang.String r11 = "queryCalendarId calendarId="
            r10.append(r11)     // Catch:{ all -> 0x0076 }
            r10.append(r8)     // Catch:{ all -> 0x0076 }
            java.lang.String r11 = ", accountType="
            r10.append(r11)     // Catch:{ all -> 0x0076 }
            r10.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = ", accessLevel="
            r10.append(r3)     // Catch:{ all -> 0x0076 }
            r10.append(r5)     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = r10.toString()     // Catch:{ all -> 0x0076 }
            java.lang.String r10 = "TodoViewModel"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r3, r10)     // Catch:{ all -> 0x0076 }
            r3 = 500(0x1f4, float:7.0E-43)
            if (r5 < r3) goto L_0x0029
            kotlin.io.CloseableKt.closeFinally(r1, r4)
            return r8
        L_0x0076:
            r12 = move-exception
            goto L_0x007e
        L_0x0078:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0076 }
            kotlin.io.CloseableKt.closeFinally(r1, r4)
            goto L_0x0084
        L_0x007e:
            throw r12     // Catch:{ all -> 0x007f }
        L_0x007f:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r12)
            throw r0
        L_0x0084:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel.queryCalendarId():long");
    }

    /* access modifiers changed from: private */
    public final long queryOrAddCalendarId() {
        long queryCalendarId = queryCalendarId();
        return queryCalendarId != -1 ? queryCalendarId : addCalendarId();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007e, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007f, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
        throw r15;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel.CalendarEvent querySchedule(com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r15) {
        /*
            r14 = this;
            long r0 = r15.getCalendarId()
            long r3 = r15.getCalendarEventId()
            r14 = 0
            int r2 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            r5 = 0
            if (r2 == 0) goto L_0x008e
            int r14 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r14 != 0) goto L_0x0015
            goto L_0x008e
        L_0x0015:
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r14 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r14 = r14.getInstance()
            android.content.Context r14 = r14.appContext()
            android.content.ContentResolver r6 = r14.getContentResolver()
            android.net.Uri r7 = android.provider.CalendarContract.Events.CONTENT_URI
            java.lang.String r14 = "_id"
            java.lang.String r15 = "dtstart"
            java.lang.String r2 = "dtend"
            java.lang.String[] r8 = new java.lang.String[]{r14, r15, r2}
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = java.lang.String.valueOf(r3)
            java.lang.String[] r10 = new java.lang.String[]{r0, r1}
            r11 = 0
            java.lang.String r9 = "calendar_id = ? AND _id = ?"
            android.database.Cursor r0 = r6.query(r7, r8, r9, r10, r11)
            if (r0 == 0) goto L_0x0083
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = r0
            android.database.Cursor r1 = (android.database.Cursor) r1     // Catch:{ all -> 0x0075 }
        L_0x0049:
            boolean r6 = r1.moveToNext()     // Catch:{ all -> 0x0075 }
            if (r6 == 0) goto L_0x0077
            int r6 = r1.getColumnIndexOrThrow(r14)     // Catch:{ all -> 0x0075 }
            long r8 = r1.getLong(r6)     // Catch:{ all -> 0x0075 }
            int r6 = r1.getColumnIndexOrThrow(r15)     // Catch:{ all -> 0x0075 }
            long r10 = r1.getLong(r6)     // Catch:{ all -> 0x0075 }
            int r6 = r1.getColumnIndexOrThrow(r2)     // Catch:{ all -> 0x0075 }
            long r12 = r1.getLong(r6)     // Catch:{ all -> 0x0075 }
            int r6 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x0049
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$CalendarEvent r14 = new com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$CalendarEvent     // Catch:{ all -> 0x0075 }
            r7 = r14
            r7.<init>(r8, r10, r12)     // Catch:{ all -> 0x0075 }
            kotlin.io.CloseableKt.closeFinally(r0, r5)
            return r14
        L_0x0075:
            r14 = move-exception
            goto L_0x007d
        L_0x0077:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0075 }
            kotlin.io.CloseableKt.closeFinally(r0, r5)
            goto L_0x0083
        L_0x007d:
            throw r14     // Catch:{ all -> 0x007e }
        L_0x007e:
            r15 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r14)
            throw r15
        L_0x0083:
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$CalendarEvent r14 = new com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$CalendarEvent
            r5 = 0
            r7 = 0
            r2 = r14
            r2.<init>(r3, r5, r7)
            return r14
        L_0x008e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel.querySchedule(com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity):com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$CalendarEvent");
    }

    private final void reportAiDataTrack() {
        RecordEntity value = this._mCurFastRecordLiveData.getValue();
        if (value != null) {
            long originTextSize = value.getOriginTextSize();
            long recordId = value.getRecordId();
            LogExt.logE("reportAiDataTrack record id = " + recordId + ",textLength = " + originTextSize, TAG);
            SummaryRequestBean summaryRequestBean = this.requestBean;
            String recognizeId = summaryRequestBean != null ? summaryRequestBean.getRecognizeId() : null;
            if (recognizeId == null) {
                recognizeId = "";
            } else {
                Intrinsics.checkNotNull(recognizeId);
            }
            FastRecordDataTrackManager.reportAIExtractionDataTrack(originTextSize, recognizeId);
        }
    }

    /* access modifiers changed from: private */
    public final void todoDataNotify(ArrayList<RecordTodoItemEntity> arrayList) {
        if (arrayList != null) {
            for (RecordTodoItemEntity recordTodoItemEntity : arrayList) {
                String content = recordTodoItemEntity.getContent();
                String contentTemp = recordTodoItemEntity.getContentTemp();
                String start_time = recordTodoItemEntity.getStart_time();
                String end_time = recordTodoItemEntity.getEnd_time();
                boolean isAddSchedule = recordTodoItemEntity.isAddSchedule();
                boolean isAddSchedule2 = recordTodoItemEntity.isAddSchedule();
                boolean isEdit = recordTodoItemEntity.isEdit();
                boolean isFinish = recordTodoItemEntity.isFinish();
                LogExt.logE("todoDataNotify item.content:" + content + ",contentTemp =" + contentTemp + ", item.start_time=" + start_time + " ,item.end_time=" + end_time + ",add = " + isAddSchedule + " ,item.isAddSchedule=" + isAddSchedule2 + " ,item.isEdit=" + isEdit + ", item.isFinish=" + isFinish, TAG);
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            LogExt.logE("todoList isNullOrEmpty", TAG);
        }
        this._mTodoLiveData.postValue(arrayList);
    }

    public final void addEventToCalendar(@NotNull RecordTodoItemEntity recordTodoItemEntity, @NotNull Function1<? super RecordTodoItemEntity, Unit> function1) {
        Intrinsics.checkNotNullParameter(recordTodoItemEntity, "extnTodo");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.b(), (CoroutineStart) null, new FastRecordTodoViewModel$addEventToCalendar$1(recordTodoItemEntity, this, function1, (Continuation<? super FastRecordTodoViewModel$addEventToCalendar$1>) null), 2, (Object) null);
    }

    public final void commandTodoList(@NotNull ArrayList<SmartExTodo.ToDo> arrayList, @Nullable String str) {
        Intrinsics.checkNotNullParameter(arrayList, "todoBeanList");
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordTodoViewModel$commandTodoList$1(this, arrayList, str, (Continuation<? super FastRecordTodoViewModel$commandTodoList$1>) null), 3, (Object) null);
    }

    public final void deleteAllData() {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordTodoViewModel$deleteAllData$1(this, (Continuation<? super FastRecordTodoViewModel$deleteAllData$1>) null), 3, (Object) null);
    }

    public final void deleteTodo(@NotNull RecordTodoItemEntity recordTodoItemEntity) {
        Intrinsics.checkNotNullParameter(recordTodoItemEntity, VuiModelType.TODO);
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordTodoViewModel$deleteTodo$1(recordTodoItemEntity, (Continuation<? super FastRecordTodoViewModel$deleteTodo$1>) null), 3, (Object) null);
    }

    public final void editModeNotify() {
        this._mTodoEditModeLiveData.postValue(Boolean.TRUE);
    }

    @NotNull
    public final LiveData<RecordEntity> getCurRecordData() {
        return this.curRecordData;
    }

    @NotNull
    public final AiFeedBackRequest getFeedBackBean() {
        List value = this._mTodoLiveData.getValue();
        return new AiFeedBackRequest(1, getRecordId(), getTodoShareText(), (value == null || value.isEmpty()) ? "" : ((RecordTodoItemEntity) value.get(0)).getRequestId());
    }

    @NotNull
    public final LiveData<Integer> getMTodoResult() {
        return this.mTodoResult;
    }

    @NotNull
    public final String getRecordId() {
        Object obj;
        SummaryRequestBean summaryRequestBean = this.requestBean;
        if (summaryRequestBean == null || (obj = summaryRequestBean.getRecordId()) == null) {
            obj = "";
        }
        return obj.toString();
    }

    @Nullable
    public final SummaryRequestBean getRequestBean() {
        return this.requestBean;
    }

    @NotNull
    public final LiveData<String> getSummaryLockedLiveData() {
        return this.summaryLockedLiveData;
    }

    @Nullable
    public final List<RecordTodoItemEntity> getTodoData() {
        return this._mTodoLiveData.getValue();
    }

    @NotNull
    public final LiveData<Boolean> getTodoEditModeLiveData() {
        return this.todoEditModeLiveData;
    }

    public final void getTodoListFromLocal(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordTodoViewModel$getTodoListFromLocal$1(this, function0, (Continuation<? super FastRecordTodoViewModel$getTodoListFromLocal$1>) null), 3, (Object) null);
    }

    @NotNull
    public final LiveData<List<RecordTodoItemEntity>> getTodoLiveData() {
        return this.todoLiveData;
    }

    @NotNull
    public final LiveData<String> getTodoSensitiveLiveData() {
        return this.todoSensitiveLiveData;
    }

    @NotNull
    public final String getTodoShareText() {
        Collection value;
        if (this._mTodoLiveData.getValue() == null || (value = this._mTodoLiveData.getValue()) == null || value.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String string = FastRecordManager.Companion.getInstance().appContext().getString(R.string.fast_record_summary_dealt_type);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        sb.append(string);
        sb.append(AccountConstantKt.CODE_SEPARTOR);
        sb.append(StringUtils.LF);
        List value2 = this._mTodoLiveData.getValue();
        if (value2 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(value2);
            int i = 0;
            for (T next : getNormalTodoData(arrayList)) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                sb.append(((RecordTodoItemEntity) next).getContentTemp());
                sb.append(StringUtils.LF);
                i = i2;
            }
        }
        LogExt.logE("getTodoShareText  sb.toString()=" + sb, TAG);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final boolean isAsrLanguageSupport() {
        String str;
        RecordEntity value = this._mCurFastRecordLiveData.getValue();
        if (value == null || (str = value.getLanguageType()) == null) {
            str = "";
        }
        return RecordVoiceUtils.INSTANCE.aiLanguageSupport(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = getTodoData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isNotEmptyData() {
        /*
            r1 = this;
            java.util.List r0 = r1.getTodoData()
            if (r0 == 0) goto L_0x0015
            java.util.List r1 = r1.getTodoData()
            if (r1 == 0) goto L_0x0015
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r1 = 1
            goto L_0x0016
        L_0x0015:
            r1 = 0
        L_0x0016:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel.isNotEmptyData():boolean");
    }

    public void onCleared() {
        super.onCleared();
        SmartExtractionHelper smartExtractionHelper = this.mSmartExtractionHelper;
        if (smartExtractionHelper != null) {
            smartExtractionHelper.release();
        }
    }

    public final void queryRecordInfo(long j) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordTodoViewModel$queryRecordInfo$1(j, this, (Continuation<? super FastRecordTodoViewModel$queryRecordInfo$1>) null), 3, (Object) null);
    }

    public final void requestTodoListInfo() {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordTodoViewModel$requestTodoListInfo$1(this, (Continuation<? super FastRecordTodoViewModel$requestTodoListInfo$1>) null), 3, (Object) null);
    }

    public final void setRequestBean(@Nullable SummaryRequestBean summaryRequestBean) {
        this.requestBean = summaryRequestBean;
    }

    public final void setSummaryRequestBean(@NotNull SummaryRequestBean summaryRequestBean) {
        Intrinsics.checkNotNullParameter(summaryRequestBean, "summaryRequestBean");
        this.requestBean = summaryRequestBean;
    }

    public final void startAiToDoTask() {
        SummaryRequestBean summaryRequestBean = this.requestBean;
        LogExt.logE("startTask requestBean = " + summaryRequestBean, TAG);
        reportAiDataTrack();
        SummaryRequestBean summaryRequestBean2 = this.requestBean;
        if (summaryRequestBean2 != null) {
            FastRecordAiTodoOperatorManager.INSTANCE.restart(summaryRequestBean2, new FastRecordTodoViewModel$startAiToDoTask$1$1(summaryRequestBean2, this));
        }
    }

    public final void updateReportStateSuccess() {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordTodoViewModel$updateReportStateSuccess$1(this, (Continuation<? super FastRecordTodoViewModel$updateReportStateSuccess$1>) null), 3, (Object) null);
    }

    public final void updateTodoList(@NotNull List<RecordTodoItemEntity> list) {
        Intrinsics.checkNotNullParameter(list, "todoList");
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordTodoViewModel$updateTodoList$1(list, (Continuation<? super FastRecordTodoViewModel$updateTodoList$1>) null), 3, (Object) null);
    }
}
