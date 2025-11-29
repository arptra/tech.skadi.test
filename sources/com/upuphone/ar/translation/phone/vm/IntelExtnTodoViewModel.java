package com.upuphone.ar.translation.phone.vm;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.CalendarContract;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.broadcast.CalendarContentObserver;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.audio.record.ai.bean.AiFeedBackRequest;
import com.upuphone.xr.interconnect.entity.AccountInfo;
import com.upuphone.xr.sapp.context.SdkContext;
import com.xjsd.ai.assistant.protocol.schedule.Event;
import com.xjsd.xr.sapp.asr.utils.AsrExtKt;
import java.io.Closeable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0004\u0001\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u001d\u0010\u0015\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b \u0010!J#\u0010#\u001a\u00020\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u00142\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b#\u0010$J/\u0010)\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\u00162\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0'¢\u0006\u0004\b)\u0010*J\u001d\u0010,\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u0016¢\u0006\u0004\b,\u0010-J\u0015\u0010.\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0007¢\u0006\u0004\b.\u0010\u000eJ\u001f\u00100\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010/\u001a\u00020\u0016¢\u0006\u0004\b0\u0010-J\u0017\u00103\u001a\u00020\t2\b\b\u0001\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\u0015\u00107\u001a\u00020\t2\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u001d\u0010;\u001a\u00020\t2\u0006\u0010:\u001a\u0002092\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u0004\u0018\u00010=2\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b>\u0010?J%\u0010C\u001a\u00020B2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010@\u001a\u0002052\u0006\u0010A\u001a\u000205¢\u0006\u0004\bC\u0010DJ\u001d\u0010E\u001a\u00020\t2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0'¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020\t¢\u0006\u0004\bG\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001c\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010M0L8\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR \u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00140L8\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010OR\u001c\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010S0L8\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010OR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00070L8\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010OR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u0002010L8\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010OR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00160L8\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010OR\u001f\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010M0\\8\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R#\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00140\\8\u0006¢\u0006\f\n\u0004\bb\u0010^\u001a\u0004\bc\u0010`R\u001f\u0010g\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010S0\\8\u0006¢\u0006\f\n\u0004\be\u0010^\u001a\u0004\bf\u0010`R\u001d\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00070\\8\u0006¢\u0006\f\n\u0004\bh\u0010^\u001a\u0004\bi\u0010`R\u001d\u0010m\u001a\b\u0012\u0004\u0012\u0002010\\8\u0006¢\u0006\f\n\u0004\bk\u0010^\u001a\u0004\bl\u0010`R\u001d\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00160\\8\u0006¢\u0006\f\n\u0004\bn\u0010^\u001a\u0004\bo\u0010`R\u0018\u0010s\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010w\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bx\u0010)R\u0016\u0010{\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bz\u0010)R\u001a\u0010\u001a\b\u0012\u0004\u0012\u0002050|8\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010~¨\u0006\u0001"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/IntelExtnTodoViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "", "Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;", "todoList", "", "x", "(Ljava/util/List;)V", "extnTodo", "t", "(Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;)V", "", "queryOrAddCalendarId", "()J", "queryCalendarId", "addCalendarId", "", "Q", "", "w", "()Z", "N", "()V", "onCleared", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "noteBean", "P", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)Z", "K", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "todos", "O", "(Ljava/util/List;Lcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "intelExtnTodo", "isUpdateLocal", "Lkotlin/Function0;", "onLoadTodos", "Z", "(Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;ZLkotlin/jvm/functions/Function0;)V", "isReported", "Y", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;Z)V", "y", "isClearDeleteStatus", "L", "", "stringResId", "V", "(I)V", "", "msg", "W", "(Ljava/lang/String;)V", "Landroidx/fragment/app/FragmentActivity;", "activity", "v", "(Landroidx/fragment/app/FragmentActivity;Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;)V", "Lcom/upuphone/ar/translation/phone/vm/IntelExtnTodoViewModel$CalendarEvent;", "R", "(Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;)Lcom/upuphone/ar/translation/phone/vm/IntelExtnTodoViewModel$CalendarEvent;", "todoText", "requestId", "Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackRequest;", "I", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;Ljava/lang/String;Ljava/lang/String;)Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackRequest;", "S", "(Lkotlin/jvm/functions/Function0;)V", "X", "b", "Landroid/app/Application;", "A", "()Landroid/app/Application;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/xjsd/xr/sapp/asr/dao/SmartExTodo;", "c", "Landroidx/lifecycle/MutableLiveData;", "_mResIntelExtnTodo", "d", "_mIntelExtnTodoList", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "e", "_mResIntelExtnSensitive", "f", "_mScheduleIntelExtnTodo", "g", "_mTodoListRealSize", "h", "_mCalendarUpdated", "Landroidx/lifecycle/LiveData;", "i", "Landroidx/lifecycle/LiveData;", "F", "()Landroidx/lifecycle/LiveData;", "mResIntelExtnTodo", "j", "D", "mIntelExtnTodoList", "k", "E", "mResIntelExtnSensitive", "l", "G", "mScheduleIntelExtnTodo", "m", "H", "mTodoListRealSize", "n", "B", "mCalendarUpdated", "o", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "mNoteBeanByServer", "Lcom/upuphone/ar/translation/phone/broadcast/CalendarContentObserver;", "p", "Lcom/upuphone/ar/translation/phone/broadcast/CalendarContentObserver;", "mCalendarObserver", "q", "mIsCalendarPermissionGranted", "r", "mIsRequestPermissionAddSchedule", "", "s", "[Ljava/lang/String;", "calendarPermissions", "CalendarEvent", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class IntelExtnTodoViewModel extends AndroidViewModel {
    public static final Companion t = new Companion((DefaultConstructorMarker) null);
    public final Application b;
    public final MutableLiveData c;
    public final MutableLiveData d;
    public final MutableLiveData e;
    public final MutableLiveData f;
    public final MutableLiveData g;
    public final MutableLiveData h;
    public final LiveData i;
    public final LiveData j;
    public final LiveData k;
    public final LiveData l;
    public final LiveData m;
    public final LiveData n;
    public NoteBean o;
    public CalendarContentObserver p;
    public boolean q = true;
    public boolean r;
    public final String[] s = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0012\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/IntelExtnTodoViewModel$CalendarEvent;", "", "", "eventId", "startTime", "endTime", "<init>", "(JJJ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "J", "getEventId", "()J", "b", "c", "getEndTime", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class CalendarEvent {

        /* renamed from: a  reason: collision with root package name */
        public final long f6343a;
        public final long b;
        public final long c;

        public CalendarEvent(long j, long j2, long j3) {
            this.f6343a = j;
            this.b = j2;
            this.c = j3;
        }

        public final long a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CalendarEvent)) {
                return false;
            }
            CalendarEvent calendarEvent = (CalendarEvent) obj;
            return this.f6343a == calendarEvent.f6343a && this.b == calendarEvent.b && this.c == calendarEvent.c;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f6343a) * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            long j = this.f6343a;
            long j2 = this.b;
            long j3 = this.c;
            return "CalendarEvent(eventId=" + j + ", startTime=" + j2 + ", endTime=" + j3 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/IntelExtnTodoViewModel$Companion;", "", "()V", "CALENDAR_NAME", "", "ON_HOUR_MILLIS", "", "TAG", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnTodoViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, DDAuthConstant.AUTH_LOGIN_TYPE_APP);
        this.b = application;
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this.d = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        this.e = mutableLiveData3;
        MutableLiveData mutableLiveData4 = new MutableLiveData();
        this.f = mutableLiveData4;
        MutableLiveData mutableLiveData5 = new MutableLiveData();
        this.g = mutableLiveData5;
        MutableLiveData mutableLiveData6 = new MutableLiveData();
        this.h = mutableLiveData6;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.xjsd.xr.sapp.asr.dao.SmartExTodo?>");
        this.i = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.MutableList<com.upuphone.ar.translation.phone.bean.IntelExtnTodo>>");
        this.j = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData3, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.xjsd.xr.sapp.asr.dao.SensitivePayload?>");
        this.k = mutableLiveData3;
        Intrinsics.checkNotNull(mutableLiveData4, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.upuphone.ar.translation.phone.bean.IntelExtnTodo>");
        this.l = mutableLiveData4;
        Intrinsics.checkNotNull(mutableLiveData5, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Int>");
        this.m = mutableLiveData5;
        Intrinsics.checkNotNull(mutableLiveData6, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.n = mutableLiveData6;
    }

    public static /* synthetic */ void M(IntelExtnTodoViewModel intelExtnTodoViewModel, NoteBean noteBean, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        intelExtnTodoViewModel.L(noteBean, z);
    }

    public static /* synthetic */ void U(IntelExtnTodoViewModel intelExtnTodoViewModel, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function0 = IntelExtnTodoViewModel$registerCalendarContentObserver$1.INSTANCE;
        }
        intelExtnTodoViewModel.S(function0);
    }

    public static /* synthetic */ void a0(IntelExtnTodoViewModel intelExtnTodoViewModel, IntelExtnTodo intelExtnTodo, boolean z, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            function0 = IntelExtnTodoViewModel$updateTodo$1.INSTANCE;
        }
        intelExtnTodoViewModel.Z(intelExtnTodo, z, function0);
    }

    private final long addCalendarId() {
        String lastPathSegment;
        AccountInfo accountInfo = TranslatorConstants.getAccountInfo();
        if (accountInfo == null) {
            return -1;
        }
        String str = accountInfo.id;
        Intrinsics.checkNotNullExpressionValue(str, "id");
        String mixSpecialData = AsrExtKt.mixSpecialData(str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Event.ACCOUNT_NAME, mixSpecialData);
        contentValues.put("account_type", "LOCAL");
        contentValues.put("name", mixSpecialData);
        contentValues.put("calendar_displayName", "MYVU_Translator_Calendar");
        contentValues.put("calendar_color", -16776961);
        contentValues.put("calendar_access_level", 700);
        contentValues.put("ownerAccount", mixSpecialData);
        contentValues.put("visible", 1);
        contentValues.put("sync_events", 1);
        contentValues.put("canOrganizerRespond", 0);
        contentValues.put("calendar_timezone", TimeZone.getDefault().getID());
        Uri insert = this.b.getContentResolver().insert(CalendarContract.Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", BooleanUtils.TRUE).appendQueryParameter(Event.ACCOUNT_NAME, mixSpecialData).appendQueryParameter("account_type", "LOCAL").build(), contentValues);
        if (insert == null || (lastPathSegment = insert.getLastPathSegment()) == null) {
            return -1;
        }
        Intrinsics.checkNotNull(lastPathSegment);
        return Long.parseLong(lastPathSegment);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c2, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c3, code lost:
        kotlin.io.CloseableKt.closeFinally(r11, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c6, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long queryCalendarId() {
        /*
            r11 = this;
            android.app.Application r11 = r11.b
            android.content.ContentResolver r0 = r11.getContentResolver()
            android.net.Uri r1 = android.provider.CalendarContract.Calendars.CONTENT_URI
            java.lang.String r6 = "sync_events"
            java.lang.String r7 = "calendar_displayName"
            java.lang.String r2 = "_id"
            java.lang.String r3 = "account_type"
            java.lang.String r4 = "calendar_access_level"
            java.lang.String r5 = "visible"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7}
            r4 = 0
            r5 = 0
            r3 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5)
            if (r11 == 0) goto L_0x00c7
            java.io.Closeable r11 = (java.io.Closeable) r11
            r0 = r11
            android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x00b9 }
        L_0x0027:
            boolean r1 = r0.moveToNext()     // Catch:{ all -> 0x00b9 }
            r2 = 0
            if (r1 == 0) goto L_0x00bb
            java.lang.String r1 = "_id"
            int r1 = r0.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x00b9 }
            long r3 = r0.getLong(r1)     // Catch:{ all -> 0x00b9 }
            java.lang.String r1 = "account_type"
            int r1 = r0.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x00b9 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x00b9 }
            java.lang.String r5 = "calendar_access_level"
            int r5 = r0.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x00b9 }
            int r5 = r0.getInt(r5)     // Catch:{ all -> 0x00b9 }
            java.lang.String r6 = "visible"
            int r6 = r0.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x00b9 }
            int r6 = r0.getInt(r6)     // Catch:{ all -> 0x00b9 }
            java.lang.String r7 = "sync_events"
            int r7 = r0.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x00b9 }
            int r7 = r0.getInt(r7)     // Catch:{ all -> 0x00b9 }
            java.lang.String r8 = "calendar_displayName"
            int r8 = r0.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x00b9 }
            java.lang.String r8 = r0.getString(r8)     // Catch:{ all -> 0x00b9 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b9 }
            r9.<init>()     // Catch:{ all -> 0x00b9 }
            java.lang.String r10 = "queryCalendarId [id:"
            r9.append(r10)     // Catch:{ all -> 0x00b9 }
            r9.append(r3)     // Catch:{ all -> 0x00b9 }
            java.lang.String r10 = ", type="
            r9.append(r10)     // Catch:{ all -> 0x00b9 }
            r9.append(r1)     // Catch:{ all -> 0x00b9 }
            java.lang.String r1 = ", level="
            r9.append(r1)     // Catch:{ all -> 0x00b9 }
            r9.append(r5)     // Catch:{ all -> 0x00b9 }
            java.lang.String r1 = ", visible="
            r9.append(r1)     // Catch:{ all -> 0x00b9 }
            r9.append(r6)     // Catch:{ all -> 0x00b9 }
            java.lang.String r1 = ", sync="
            r9.append(r1)     // Catch:{ all -> 0x00b9 }
            r9.append(r7)     // Catch:{ all -> 0x00b9 }
            java.lang.String r1 = ", name="
            r9.append(r1)     // Catch:{ all -> 0x00b9 }
            r9.append(r8)     // Catch:{ all -> 0x00b9 }
            java.lang.String r1 = "]"
            r9.append(r1)     // Catch:{ all -> 0x00b9 }
            java.lang.String r1 = r9.toString()     // Catch:{ all -> 0x00b9 }
            java.lang.String r7 = "IntelExtnTodoViewModel"
            com.upuphone.ar.translation.ext.LogExt.j(r1, r7)     // Catch:{ all -> 0x00b9 }
            r1 = 500(0x1f4, float:7.0E-43)
            if (r5 < r1) goto L_0x0027
            r1 = 1
            if (r6 != r1) goto L_0x0027
            kotlin.io.CloseableKt.closeFinally(r11, r2)
            return r3
        L_0x00b9:
            r0 = move-exception
            goto L_0x00c1
        L_0x00bb:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00b9 }
            kotlin.io.CloseableKt.closeFinally(r11, r2)
            goto L_0x00c7
        L_0x00c1:
            throw r0     // Catch:{ all -> 0x00c2 }
        L_0x00c2:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r11, r0)
            throw r1
        L_0x00c7:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel.queryCalendarId():long");
    }

    /* access modifiers changed from: private */
    public final long queryOrAddCalendarId() {
        long queryCalendarId = queryCalendarId();
        return queryCalendarId != -1 ? queryCalendarId : addCalendarId();
    }

    public final Application A() {
        return this.b;
    }

    public final LiveData B() {
        return this.n;
    }

    public final LiveData D() {
        return this.j;
    }

    public final LiveData E() {
        return this.k;
    }

    public final LiveData F() {
        return this.i;
    }

    public final LiveData G() {
        return this.l;
    }

    public final LiveData H() {
        return this.m;
    }

    public final AiFeedBackRequest I(NoteBean noteBean, String str, String str2) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        Intrinsics.checkNotNullParameter(str, "todoText");
        Intrinsics.checkNotNullParameter(str2, "requestId");
        String recognizeId = noteBean.getRecognizeId();
        String string = this.b.getString(R.string.tl_to_do);
        return new AiFeedBackRequest(3, recognizeId, string + StringUtils.LF + str, str2);
    }

    public final void K(NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        this.o = noteBean;
        TranslationApp translationApp = TranslationApp.INSTANCE;
        translationApp.getSmartExHelper$ar_translator_intlRelease().h(2, noteBean, new IntelExtnTodoViewModel$getTodoByServer$1(this));
        translationApp.getSmartExHelper$ar_translator_intlRelease().f(this.b, noteBean);
    }

    public final void L(NoteBean noteBean, boolean z) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new IntelExtnTodoViewModel$getTodosByDb$1(noteBean, this, z, (Continuation<? super IntelExtnTodoViewModel$getTodosByDb$1>) null), 2, (Object) null);
    }

    public final void N() {
        int i2;
        List list;
        Cursor query = this.b.getContentResolver().query(CalendarContract.Events.CONTENT_URI, new String[]{"_id", Event.CALENDAR_ID}, (String) null, (String[]) null, (String) null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (query != null) {
            Closeable closeable = query;
            try {
                Cursor cursor = (Cursor) closeable;
                while (cursor.moveToNext()) {
                    long j2 = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
                    long j3 = cursor.getLong(cursor.getColumnIndexOrThrow(Event.CALENDAR_ID));
                    Long valueOf = Long.valueOf(j3);
                    List list2 = (List) linkedHashMap.get(Long.valueOf(j3));
                    if (list2 != null) {
                        list2.add(Long.valueOf(j2));
                    } else {
                        list2 = CollectionsKt.mutableListOf(Long.valueOf(j2));
                    }
                    linkedHashMap.put(valueOf, list2);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(closeable, (Throwable) null);
            } catch (Throwable th) {
                CloseableKt.closeFinally(closeable, th);
                throw th;
            }
        }
        LogExt.j("handleCalendarBaseCallback keys=" + linkedHashMap.keySet(), "IntelExtnTodoViewModel");
        LogExt.j("handleCalendarBaseCallback values=" + linkedHashMap.values(), "IntelExtnTodoViewModel");
        List<IntelExtnTodo> list3 = (List) this.d.getValue();
        int i3 = 0;
        if (list3 != null) {
            i2 = 0;
            for (IntelExtnTodo intelExtnTodo : list3) {
                if (intelExtnTodo.getCalendarId() != 0) {
                    i3++;
                }
                if (intelExtnTodo.getCalendarId() != 0 && linkedHashMap.containsKey(Long.valueOf(intelExtnTodo.getCalendarId())) && (list = (List) linkedHashMap.get(Long.valueOf(intelExtnTodo.getCalendarId()))) != null && list.contains(Long.valueOf(intelExtnTodo.getCalendarEventId()))) {
                    i2++;
                }
            }
        } else {
            i2 = 0;
        }
        LogExt.j("handleCalendarBaseCallback todoEventCount=" + i3 + ", localEventCount=" + i2, "IntelExtnTodoViewModel");
        if (i3 != i2) {
            Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new IntelExtnTodoViewModel$handleCalendarBaseCallback$3(this, (Continuation<? super IntelExtnTodoViewModel$handleCalendarBaseCallback$3>) null), 2, (Object) null);
        }
    }

    public final void O(List list, NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(list, "todos");
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new IntelExtnTodoViewModel$insertTodos$1(list, this, noteBean, (Continuation<? super IntelExtnTodoViewModel$insertTodos$1>) null), 2, (Object) null);
    }

    public final boolean P(NoteBean noteBean) {
        if (noteBean != null) {
            return TranslationApp.INSTANCE.getSmartExHelper$ar_translator_intlRelease().g(2, noteBean);
        }
        return false;
    }

    public final void Q(List list) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new IntelExtnTodoViewModel$notifyTodoList$1(list, this, (Continuation<? super IntelExtnTodoViewModel$notifyTodoList$1>) null), 2, (Object) null);
    }

    public final CalendarEvent R(IntelExtnTodo intelExtnTodo) {
        Throwable th;
        Intrinsics.checkNotNullParameter(intelExtnTodo, "extnTodo");
        long calendarId = intelExtnTodo.getCalendarId();
        long calendarEventId = intelExtnTodo.getCalendarEventId();
        if (calendarId == 0 || calendarEventId == 0) {
            return null;
        }
        Cursor query = this.b.getContentResolver().query(CalendarContract.Events.CONTENT_URI, new String[]{"_id", Event.START_TIME, Event.END_TIME}, "calendar_id = ? AND _id = ?", new String[]{String.valueOf(calendarId), String.valueOf(calendarEventId)}, (String) null);
        if (query != null) {
            Closeable closeable = query;
            try {
                Cursor cursor = (Cursor) closeable;
                while (cursor.moveToNext()) {
                    long j2 = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
                    long j3 = cursor.getLong(cursor.getColumnIndexOrThrow(Event.START_TIME));
                    long j4 = cursor.getLong(cursor.getColumnIndexOrThrow(Event.END_TIME));
                    if (j2 == calendarEventId) {
                        CalendarEvent calendarEvent = new CalendarEvent(j2, j3, j4);
                        CloseableKt.closeFinally(closeable, (Throwable) null);
                        return calendarEvent;
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(closeable, (Throwable) null);
            } catch (Throwable th2) {
                Throwable th3 = th2;
                CloseableKt.closeFinally(closeable, th);
                throw th3;
            }
        }
        return new CalendarEvent(calendarEventId, 0, 0);
    }

    public final void S(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "onLoadTodos");
        CalendarContentObserver calendarContentObserver = this.p;
        LogExt.j("registerCalendarContentObserver observer=" + calendarContentObserver, "IntelExtnTodoViewModel");
        if (!w()) {
            LogExt.j("registerCalendarContentObserver Permission Denial", "IntelExtnTodoViewModel");
            this.q = false;
        } else if (this.p == null) {
            CalendarContentObserver calendarContentObserver2 = new CalendarContentObserver(new Handler(Looper.getMainLooper()));
            this.b.getContentResolver().registerContentObserver(CalendarContract.Events.CONTENT_URI, true, calendarContentObserver2);
            calendarContentObserver2.a(new IntelExtnTodoViewModel$registerCalendarContentObserver$2$1(this), new IntelExtnTodoViewModel$registerCalendarContentObserver$2$2(this));
            this.p = calendarContentObserver2;
            if (!this.q && !this.r) {
                function0.invoke();
            }
            this.q = true;
        }
    }

    public final void V(int i2) {
        UToast.f6444a.b(this.b, i2);
    }

    public final void W(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        UToast.f6444a.d(this.b, str);
    }

    public final void X() {
        CalendarContentObserver calendarContentObserver = this.p;
        LogExt.j("unRegisterCalendarContentObserver observer=" + calendarContentObserver, "IntelExtnTodoViewModel");
        CalendarContentObserver calendarContentObserver2 = this.p;
        if (calendarContentObserver2 != null) {
            this.b.getContentResolver().unregisterContentObserver(calendarContentObserver2);
            calendarContentObserver2.b();
            this.p = null;
        }
    }

    public final void Y(NoteBean noteBean, boolean z) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new IntelExtnTodoViewModel$updateReportedStatus$1(this, noteBean, z, (Continuation<? super IntelExtnTodoViewModel$updateReportedStatus$1>) null), 2, (Object) null);
    }

    public final void Z(IntelExtnTodo intelExtnTodo, boolean z, Function0 function0) {
        Intrinsics.checkNotNullParameter(intelExtnTodo, "intelExtnTodo");
        Intrinsics.checkNotNullParameter(function0, "onLoadTodos");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new IntelExtnTodoViewModel$updateTodo$2(intelExtnTodo, this, function0, z, (Continuation<? super IntelExtnTodoViewModel$updateTodo$2>) null), 2, (Object) null);
    }

    public void onCleared() {
        super.onCleared();
        NoteBean noteBean = this.o;
        if (noteBean != null) {
            TranslationApp.INSTANCE.getSmartExHelper$ar_translator_intlRelease().j(2, noteBean);
        }
        this.q = false;
        this.r = false;
    }

    public final void t(IntelExtnTodo intelExtnTodo) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.b(), (CoroutineStart) null, new IntelExtnTodoViewModel$addEventToCalendar$1(intelExtnTodo, this, (Continuation<? super IntelExtnTodoViewModel$addEventToCalendar$1>) null), 2, (Object) null);
    }

    public final void v(FragmentActivity fragmentActivity, IntelExtnTodo intelExtnTodo) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(intelExtnTodo, "extnTodo");
        if (w()) {
            t(intelExtnTodo);
        } else {
            SdkContext.f6675a.f().c(fragmentActivity, this.s, true, new IntelExtnTodoViewModel$addSchedule$1(this, intelExtnTodo));
        }
    }

    public final boolean w() {
        return SdkContext.f6675a.f().a(this.s);
    }

    public final void x(List list) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.b(), (CoroutineStart) null, new IntelExtnTodoViewModel$compareTodoForCalendar$1(list, this, (Continuation<? super IntelExtnTodoViewModel$compareTodoForCalendar$1>) null), 2, (Object) null);
    }

    public final void y(IntelExtnTodo intelExtnTodo) {
        Intrinsics.checkNotNullParameter(intelExtnTodo, "intelExtnTodo");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new IntelExtnTodoViewModel$deleteTodo$1(intelExtnTodo, this, (Continuation<? super IntelExtnTodoViewModel$deleteTodo$1>) null), 2, (Object) null);
    }
}
