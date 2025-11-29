package com.upuphone.ar.transcribe.phone.vm;

import android.app.Activity;
import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.z4.a;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.repo.AiResponseSensitive;
import com.upuphone.ar.transcribe.phone.repo.AiResponseTodo;
import com.upuphone.ar.transcribe.phone.repo.OnDataLoadListener;
import com.upuphone.ar.transcribe.phone.repo.TranscribeAiRepo;
import com.upuphone.ar.transcribe.phone.vm.TodoData;
import com.upuphone.ar.transcribe.utils.AccountUtils;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.AccountInfo;
import com.upuphone.xr.sapp.context.SdkContext;
import com.xjsd.ai.assistant.protocol.schedule.Event;
import com.xjsd.xr.sapp.asr.utils.AsrExtKt;
import java.io.Closeable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Q2\u00020\u0001:\u0002RSB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H@¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0012\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH@¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\fH@¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u0019\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b \u0010!J\u0018\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H@¢\u0006\u0004\b$\u0010%J\u0015\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0018\u0010*\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\fH@¢\u0006\u0004\b*\u0010\u0016J\u0018\u0010+\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\fH@¢\u0006\u0004\b+\u0010\u0016J\u001d\u0010/\u001a\u00020\b2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u000e¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\u00020\b2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b1\u0010)J \u00103\u001a\u00020\b2\u0006\u0010-\u001a\u0002022\u0006\u0010\u0014\u001a\u00020\fH@¢\u0006\u0004\b3\u00104J\u0015\u00106\u001a\u00020\b2\u0006\u00105\u001a\u00020\u000e¢\u0006\u0004\b6\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000e0;8\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020D0C8\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020D0L8\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P¨\u0006T"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/AiTodoViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "", "data", "", "A", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;", "todos", "", "x", "(Ljava/util/List;)Ljava/lang/String;", "todoList", "q", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "todoEntity", "n", "(Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "eventId", "r", "(Ljava/lang/String;)V", "", "queryOrAddCalendarId", "()J", "queryCalendarId", "addCalendarId", "Lcom/upuphone/ar/transcribe/phone/vm/AiTodoViewModel$CalendarEvent;", "E", "(Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;)Lcom/upuphone/ar/transcribe/phone/vm/AiTodoViewModel$CalendarEvent;", "Lcom/upuphone/ar/transcribe/phone/repo/AiResponseTodo;", "todoData", "y", "(Lcom/upuphone/ar/transcribe/phone/repo/AiResponseTodo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "noteBean", "v", "(Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;)V", "G", "s", "Landroid/app/Activity;", "activity", "recordId", "t", "(Landroid/app/Activity;Ljava/lang/String;)V", "D", "Landroidx/fragment/app/FragmentActivity;", "p", "(Landroidx/fragment/app/FragmentActivity;Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recId", "F", "b", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "", "c", "[Ljava/lang/String;", "calendarPermissions", "Lcom/upuphone/ar/transcribe/phone/repo/TranscribeAiRepo;", "d", "Lcom/upuphone/ar/transcribe/phone/repo/TranscribeAiRepo;", "aiRepo", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData;", "e", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_todoData", "Lcom/upuphone/ar/transcribe/phone/repo/OnDataLoadListener;", "f", "Lcom/upuphone/ar/transcribe/phone/repo/OnDataLoadListener;", "listener", "Lkotlinx/coroutines/flow/Flow;", "g", "Lkotlinx/coroutines/flow/Flow;", "w", "()Lkotlinx/coroutines/flow/Flow;", "h", "CalendarEvent", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAiTodoViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiTodoViewModel.kt\ncom/upuphone/ar/transcribe/phone/vm/AiTodoViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,510:1\n1855#2,2:511\n1864#2,3:513\n*S KotlinDebug\n*F\n+ 1 AiTodoViewModel.kt\ncom/upuphone/ar/transcribe/phone/vm/AiTodoViewModel\n*L\n185#1:511,2\n194#1:513,3\n*E\n"})
public final class AiTodoViewModel extends AndroidViewModel {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);
    public final Application b;
    public final String[] c = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
    public final TranscribeAiRepo d;
    public final MutableSharedFlow e;
    public final OnDataLoadListener f;
    public final Flow g;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0012\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/AiTodoViewModel$CalendarEvent;", "", "", "eventId", "startTime", "endTime", "<init>", "(JJJ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "J", "getEventId", "()J", "b", "c", "getEndTime", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class CalendarEvent {

        /* renamed from: a  reason: collision with root package name */
        public final long f6139a;
        public final long b;
        public final long c;

        public CalendarEvent(long j, long j2, long j3) {
            this.f6139a = j;
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
            return this.f6139a == calendarEvent.f6139a && this.b == calendarEvent.b && this.c == calendarEvent.c;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f6139a) * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            long j = this.f6139a;
            long j2 = this.b;
            long j3 = this.c;
            return "CalendarEvent(eventId=" + j + ", startTime=" + j2 + ", endTime=" + j3 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/AiTodoViewModel$Companion;", "", "()V", "CALENDAR_NAME", "", "ON_HOUR_MILLIS", "", "TAG", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiTodoViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, DDAuthConstant.AUTH_LOGIN_TYPE_APP);
        this.b = application;
        this.d = TranscribeAiRepo.g.a(application);
        MutableSharedFlow b2 = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.e = b2;
        this.f = new a(this);
        Intrinsics.checkNotNull(b2, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<com.upuphone.ar.transcribe.phone.vm.TodoData>");
        this.g = b2;
    }

    public static final void B(AiTodoViewModel aiTodoViewModel, Object obj) {
        Intrinsics.checkNotNullParameter(aiTodoViewModel, "this$0");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(aiTodoViewModel), (CoroutineContext) null, (CoroutineStart) null, new AiTodoViewModel$listener$1$1(aiTodoViewModel, obj, (Continuation<? super AiTodoViewModel$listener$1$1>) null), 3, (Object) null);
    }

    public final Object A(Object obj, Continuation continuation) {
        List list;
        Object obj2 = obj;
        Continuation continuation2 = continuation;
        LogExt.g("getTodoByServer: " + obj2, "AiTodoViewModel");
        if (obj2 instanceof List) {
            Collection collection = (Collection) obj2;
            if (!collection.isEmpty()) {
                list = CollectionsKt.toMutableList(collection);
                AiTodoEntity aiTodoEntity = new AiTodoEntity(0, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (Integer) null, false, (String) null, (Integer) null, false, 65535, (DefaultConstructorMarker) null);
                aiTodoEntity.setItemType(1);
                list.add(aiTodoEntity);
            } else {
                list = (List) obj2;
            }
            MutableSharedFlow mutableSharedFlow = this.e;
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity>");
            Object emit = mutableSharedFlow.emit(new TodoData.DbData(list), continuation2);
            return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
        } else if (obj2 instanceof AiResponseSensitive) {
            Object emit2 = this.e.emit(new TodoData.Sensitive((AiResponseSensitive) obj2), continuation2);
            return emit2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit2 : Unit.INSTANCE;
        } else if (obj2 instanceof AiResponseTodo) {
            Object y = y((AiResponseTodo) obj2, continuation2);
            return y == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? y : Unit.INSTANCE;
        } else if (obj2 != null) {
            return Unit.INSTANCE;
        } else {
            Object emit3 = this.e.emit(TodoData.Fail.f6151a, continuation2);
            return emit3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit3 : Unit.INSTANCE;
        }
    }

    public final void D(TranscribeBean transcribeBean) {
        Intrinsics.checkNotNullParameter(transcribeBean, "noteBean");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.b(), (CoroutineStart) null, new AiTodoViewModel$loadTodosByDb$1(this, transcribeBean, (Continuation<? super AiTodoViewModel$loadTodosByDb$1>) null), 2, (Object) null);
    }

    public final CalendarEvent E(AiTodoEntity aiTodoEntity) {
        Throwable th;
        long calendarId = aiTodoEntity.getCalendarId();
        long calendarEventId = aiTodoEntity.getCalendarEventId();
        if (calendarId == 0 || calendarEventId == 0) {
            return null;
        }
        Cursor query = this.b.getContentResolver().query(CalendarContract.Events.CONTENT_URI, new String[]{"_id", Event.START_TIME, Event.END_TIME}, "calendar_id = ? AND _id = ?", new String[]{String.valueOf(calendarId), String.valueOf(calendarEventId)}, (String) null);
        if (query != null) {
            Closeable closeable = query;
            try {
                Cursor cursor = (Cursor) closeable;
                while (cursor.moveToNext()) {
                    long j = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
                    long j2 = cursor.getLong(cursor.getColumnIndexOrThrow(Event.START_TIME));
                    long j3 = cursor.getLong(cursor.getColumnIndexOrThrow(Event.END_TIME));
                    if (j == calendarEventId) {
                        CalendarEvent calendarEvent = new CalendarEvent(j, j2, j3);
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

    public final void F(String str) {
        Intrinsics.checkNotNullParameter(str, "recId");
        this.d.x(str);
    }

    public final Object G(AiTodoEntity aiTodoEntity, Continuation continuation) {
        LogExt.g("updateTodo: " + aiTodoEntity, "AiTodoViewModel");
        Object B = this.d.B(CollectionsKt.arrayListOf(aiTodoEntity), continuation);
        return B == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? B : Unit.INSTANCE;
    }

    public final long addCalendarId() {
        String lastPathSegment;
        AccountInfo b2 = AccountUtils.f6173a.b();
        if (b2 == null) {
            return -1;
        }
        String str = b2.id;
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

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0161 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity r20, kotlin.coroutines.Continuation r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            boolean r3 = r2 instanceof com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel$addEventToCalendar$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel$addEventToCalendar$1 r3 = (com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel$addEventToCalendar$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001e
        L_0x0019:
            com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel$addEventToCalendar$1 r3 = new com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel$addEventToCalendar$1
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r8 = 1
            if (r5 == 0) goto L_0x0048
            if (r5 == r8) goto L_0x003b
            if (r5 != r6) goto L_0x0033
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0162
        L_0x0033:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003b:
            java.lang.Object r0 = r3.L$1
            com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity r0 = (com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity) r0
            java.lang.Object r0 = r3.L$0
            com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel r0 = (com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel) r0
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x014a
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "addEventToCalendar todo="
            r2.append(r5)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r5 = "AiTodoViewModel"
            com.upuphone.ar.transcribe.ext.LogExt.g(r2, r5)
            long r9 = r19.queryOrAddCalendarId()
            java.lang.String r2 = r20.getStartTime()
            java.lang.String r11 = r20.getEndTime()
            kotlin.jvm.internal.Ref$LongRef r12 = new kotlin.jvm.internal.Ref$LongRef
            r12.<init>()
            boolean r13 = kotlin.text.StringsKt.isBlank(r2)
            r13 = r13 ^ r8
            r14 = 3600000(0x36ee80, float:5.044674E-39)
            if (r13 == 0) goto L_0x00a8
            long r15 = com.upuphone.ar.transcribe.utils.DateUtils.b(r2)
            boolean r13 = kotlin.text.StringsKt.isBlank(r11)
            r13 = r13 ^ r8
            if (r13 == 0) goto L_0x008e
            long r17 = com.upuphone.ar.transcribe.utils.DateUtils.b(r11)
        L_0x008b:
            r6 = r17
            goto L_0x009d
        L_0x008e:
            boolean r11 = com.upuphone.ar.transcribe.utils.DateUtils.i(r2)
            if (r11 == 0) goto L_0x0099
            long r17 = com.upuphone.ar.transcribe.utils.DateUtils.a(r2)
            goto L_0x008b
        L_0x0099:
            long r6 = (long) r14
            long r17 = r15 + r6
            goto L_0x008b
        L_0x009d:
            r12.element = r6
            int r6 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x00b0
            long r6 = (long) r14
            long r6 = r6 + r15
            r12.element = r6
            goto L_0x00b0
        L_0x00a8:
            long r15 = com.upuphone.ar.transcribe.utils.DateUtils.g(r8)
            long r6 = (long) r14
            long r6 = r6 + r15
            r12.element = r6
        L_0x00b0:
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "dtstart"
            java.lang.Long r11 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r15)
            r6.put(r7, r11)
            long r11 = r12.element
            java.lang.Long r7 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r11)
            java.lang.String r11 = "dtend"
            r6.put(r11, r7)
            java.lang.String r7 = "title"
            java.lang.String r11 = r20.getContent()
            r6.put(r7, r11)
            java.lang.String r7 = "description"
            java.lang.String r11 = r20.getContent()
            r6.put(r7, r11)
            java.lang.String r7 = "calendar_id"
            java.lang.Long r11 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r9)
            r6.put(r7, r11)
            java.lang.String r7 = "eventTimezone"
            java.lang.String r11 = "UTC"
            r6.put(r7, r11)
            android.app.Application r7 = r0.b
            android.content.ContentResolver r7 = r7.getContentResolver()
            android.net.Uri r11 = android.provider.CalendarContract.Events.CONTENT_URI
            android.net.Uri r6 = r7.insert(r11, r6)
            if (r6 == 0) goto L_0x0165
            java.lang.String r6 = r6.getLastPathSegment()
            if (r6 == 0) goto L_0x0105
            long r6 = java.lang.Long.parseLong(r6)
            goto L_0x0107
        L_0x0105:
            r6 = 0
        L_0x0107:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "addEventToCalendar 成功 "
            r12.append(r13)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            com.upuphone.ar.transcribe.ext.LogExt.g(r12, r5)
            java.lang.String r5 = r11.getAuthority()
            android.os.Bundle r11 = new android.os.Bundle
            r11.<init>()
            java.lang.String r12 = "force"
            r11.putBoolean(r12, r8)
            java.lang.String r12 = "expedited"
            r11.putBoolean(r12, r8)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            r2 = 0
            android.content.ContentResolver.requestSync(r2, r5, r11)
            r1.setCalendarId(r9)
            r1.setCalendarEventId(r6)
            r1.setAddedSchedule(r8)
            r3.L$0 = r0
            r3.L$1 = r1
            r3.label = r8
            java.lang.Object r1 = r0.G(r1, r3)
            if (r1 != r4) goto L_0x014a
            return r4
        L_0x014a:
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel$addEventToCalendar$4 r5 = new com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel$addEventToCalendar$4
            r2 = 0
            r5.<init>(r0, r2)
            r3.L$0 = r2
            r3.L$1 = r2
            r0 = 2
            r3.label = r0
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.g(r1, r5, r3)
            if (r0 != r4) goto L_0x0162
            return r4
        L_0x0162:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0165:
            java.lang.String r0 = "addEventToCalendar 失败"
            com.upuphone.ar.transcribe.ext.LogExt.g(r0, r5)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel.n(com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object p(FragmentActivity fragmentActivity, AiTodoEntity aiTodoEntity, Continuation continuation) {
        SdkContext sdkContext = SdkContext.f6675a;
        if (sdkContext.f().a(this.c)) {
            Object n = n(aiTodoEntity, continuation);
            return n == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? n : Unit.INSTANCE;
        }
        sdkContext.f().d(fragmentActivity, this.c, new HashMap(), new AiTodoViewModel$addSchedule$2(this, aiTodoEntity));
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0188 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object q(java.util.List r36, kotlin.coroutines.Continuation r37) {
        /*
            r35 = this;
            r0 = r37
            boolean r1 = r0 instanceof com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel$compareTodoForCalendar$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel$compareTodoForCalendar$1 r1 = (com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel$compareTodoForCalendar$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.label = r2
            r2 = r35
            goto L_0x001e
        L_0x0017:
            com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel$compareTodoForCalendar$1 r1 = new com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel$compareTodoForCalendar$1
            r2 = r35
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 2
            r6 = 0
            r7 = 1
            if (r4 == 0) goto L_0x0058
            if (r4 == r7) goto L_0x003c
            if (r4 != r5) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0189
        L_0x0034:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003c:
            int r2 = r1.I$1
            int r4 = r1.I$0
            java.lang.Object r8 = r1.L$4
            com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity r8 = (com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity) r8
            java.lang.Object r9 = r1.L$3
            com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity r9 = (com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity) r9
            java.lang.Object r10 = r1.L$2
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r11 = r1.L$1
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r1.L$0
            com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel r12 = (com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel) r12
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00c1
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r4 = r36.iterator()
            r11 = r0
            r10 = r4
            r0 = r6
        L_0x0067:
            boolean r4 = r10.hasNext()
            if (r4 == 0) goto L_0x0109
            java.lang.Object r4 = r10.next()
            int r8 = r0 + 1
            if (r0 >= 0) goto L_0x0078
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0078:
            r9 = r4
            com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity r9 = (com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity) r9
            com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel$CalendarEvent r4 = r2.E(r9)
            if (r4 == 0) goto L_0x00d9
            long r12 = r4.a()
            r14 = 0
            int r4 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r4 != 0) goto L_0x00c8
            java.lang.Class<com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity> r4 = com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity.class
            java.lang.Object r4 = com.upuphone.ar.transcribe.ext.ContextExtKt.c(r9, r4)
            com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity r4 = (com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity) r4
            r4.setItemType(r6)
            r4.setCalendarEventId(r14)
            r4.setCalendarId(r14)
            java.lang.Integer r12 = r9.getReported()
            r4.setReported(r12)
            r1.L$0 = r2
            r1.L$1 = r11
            r1.L$2 = r10
            r1.L$3 = r9
            r1.L$4 = r4
            r1.I$0 = r8
            r1.I$1 = r0
            r1.label = r7
            java.lang.Object r12 = r2.G(r4, r1)
            if (r12 != r3) goto L_0x00ba
            return r3
        L_0x00ba:
            r12 = r2
            r2 = r0
            r34 = r8
            r8 = r4
            r4 = r34
        L_0x00c1:
            r11.add(r8)
            r0 = r2
            r8 = r4
            r2 = r12
            goto L_0x00e6
        L_0x00c8:
            r9.setItemType(r6)
            r9.setAddedSchedule(r7)
            java.lang.Integer r4 = r9.getReported()
            r9.setReported(r4)
            r11.add(r9)
            goto L_0x00e6
        L_0x00d9:
            r9.setItemType(r6)
            java.lang.Integer r4 = r9.getReported()
            r9.setReported(r4)
            r11.add(r9)
        L_0x00e6:
            android.app.Application r4 = r2.b
            int r12 = com.upuphone.ar.transcribe.R.string.tl_to_do_simple
            java.lang.String r4 = r4.getString(r12)
            int r0 = r0 + r7
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r4)
            java.lang.String r4 = " "
            r12.append(r4)
            r12.append(r0)
            java.lang.String r0 = r12.toString()
            r9.setTitle(r0)
            r0 = r8
            goto L_0x0067
        L_0x0109:
            boolean r0 = r11.isEmpty()
            r0 = r0 ^ r7
            if (r0 == 0) goto L_0x014c
            com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity r0 = new com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity
            r12 = r0
            r32 = 65535(0xffff, float:9.1834E-41)
            r33 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r12.<init>(r13, r14, r15, r17, r18, r19, r20, r21, r22, r24, r26, r27, r28, r29, r30, r31, r32, r33)
            java.lang.Object r4 = kotlin.collections.CollectionsKt.first(r11)
            com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity r4 = (com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity) r4
            java.lang.Integer r4 = r4.getReported()
            r0.setReported(r4)
            r0.setItemType(r7)
            r11.add(r0)
        L_0x014c:
            int r0 = r11.size()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "getTodosByDb todoList="
            r4.append(r6)
            r4.append(r0)
            java.lang.String r0 = ", "
            r4.append(r0)
            r4.append(r11)
            java.lang.String r0 = r4.toString()
            java.lang.String r4 = "AiTodoViewModel"
            com.upuphone.ar.transcribe.ext.LogExt.g(r0, r4)
            kotlinx.coroutines.flow.MutableSharedFlow r0 = r2.e
            com.upuphone.ar.transcribe.phone.vm.TodoData$DbData r2 = new com.upuphone.ar.transcribe.phone.vm.TodoData$DbData
            r2.<init>(r11)
            r4 = 0
            r1.L$0 = r4
            r1.L$1 = r4
            r1.L$2 = r4
            r1.L$3 = r4
            r1.L$4 = r4
            r1.label = r5
            java.lang.Object r0 = r0.emit(r2, r1)
            if (r0 != r3) goto L_0x0189
            return r3
        L_0x0189:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel.q(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0077, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0078, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007b, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long queryCalendarId() {
        /*
            r12 = this;
            android.app.Application r12 = r12.b
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
            if (r0 == 0) goto L_0x007c
            r1 = r0
            java.io.Closeable r1 = (java.io.Closeable) r1
            r2 = r1
            android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x006e }
        L_0x0021:
            boolean r3 = r2.moveToNext()     // Catch:{ all -> 0x006e }
            r4 = 0
            if (r3 == 0) goto L_0x0070
            int r3 = r2.getColumnIndexOrThrow(r12)     // Catch:{ all -> 0x006e }
            long r8 = r2.getLong(r3)     // Catch:{ all -> 0x006e }
            int r3 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x006e }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x006e }
            int r5 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x006e }
            int r5 = r0.getInt(r5)     // Catch:{ all -> 0x006e }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
            r10.<init>()     // Catch:{ all -> 0x006e }
            java.lang.String r11 = "queryCalendarId calendarId="
            r10.append(r11)     // Catch:{ all -> 0x006e }
            r10.append(r8)     // Catch:{ all -> 0x006e }
            java.lang.String r11 = ", accountType="
            r10.append(r11)     // Catch:{ all -> 0x006e }
            r10.append(r3)     // Catch:{ all -> 0x006e }
            java.lang.String r3 = ", accessLevel="
            r10.append(r3)     // Catch:{ all -> 0x006e }
            r10.append(r5)     // Catch:{ all -> 0x006e }
            java.lang.String r3 = r10.toString()     // Catch:{ all -> 0x006e }
            java.lang.String r10 = "AiTodoViewModel"
            com.upuphone.ar.transcribe.ext.LogExt.g(r3, r10)     // Catch:{ all -> 0x006e }
            r3 = 500(0x1f4, float:7.0E-43)
            if (r5 < r3) goto L_0x0021
            kotlin.io.CloseableKt.closeFinally(r1, r4)
            return r8
        L_0x006e:
            r12 = move-exception
            goto L_0x0076
        L_0x0070:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x006e }
            kotlin.io.CloseableKt.closeFinally(r1, r4)
            goto L_0x007c
        L_0x0076:
            throw r12     // Catch:{ all -> 0x0077 }
        L_0x0077:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r12)
            throw r0
        L_0x007c:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel.queryCalendarId():long");
    }

    public final long queryOrAddCalendarId() {
        long queryCalendarId = queryCalendarId();
        return queryCalendarId != -1 ? queryCalendarId : addCalendarId();
    }

    public final void r(String str) {
        if (SdkContext.f6675a.f().a(this.c)) {
            this.b.getContentResolver().delete(CalendarContract.Events.CONTENT_URI, "_id=?", new String[]{str});
            return;
        }
        LogExt.d("delete calendar event: " + str + " but has no permission", "AiTodoViewModel");
    }

    public final Object s(AiTodoEntity aiTodoEntity, Continuation continuation) {
        LogExt.g("deleteTodo: " + aiTodoEntity, "AiTodoViewModel");
        if (aiTodoEntity.getCalendarEventId() != 0) {
            r(String.valueOf(aiTodoEntity.getCalendarEventId()));
        }
        aiTodoEntity.setCalendarEventId(0);
        Object k = this.d.k(aiTodoEntity, continuation);
        return k == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? k : Unit.INSTANCE;
    }

    public final void t(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "recordId");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new AiTodoViewModel$feedback$1(this, str, activity, (Continuation<? super AiTodoViewModel$feedback$1>) null), 3, (Object) null);
    }

    public final void v(TranscribeBean transcribeBean) {
        Intrinsics.checkNotNullParameter(transcribeBean, "noteBean");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.b(), (CoroutineStart) null, new AiTodoViewModel$getTodoByServer$1(this, transcribeBean, (Continuation<? super AiTodoViewModel$getTodoByServer$1>) null), 2, (Object) null);
    }

    public final Flow w() {
        return this.g;
    }

    public final String x(List list) {
        StringBuilder sb = new StringBuilder();
        String string = this.b.getString(R.string.tl_to_do);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        sb.append(string);
        sb.append(AccountConstantKt.CODE_SEPARTOR);
        sb.append(StringUtils.LF);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb.append(((AiTodoEntity) it.next()).getContent());
            sb.append(StringUtils.LF);
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("AiTodoViewModel", "getTodoShareText  sb.toString()=" + sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final Object y(AiResponseTodo aiResponseTodo, Continuation continuation) {
        int baseStatus = aiResponseTodo.getBaseStatus();
        if (baseStatus != 0) {
            if (baseStatus == 1) {
                Object emit = this.e.emit(TodoData.Empty.f6150a, continuation);
                return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
            } else if (baseStatus == 2) {
                Object emit2 = this.e.emit(TodoData.Fail.f6151a, continuation);
                return emit2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit2 : Unit.INSTANCE;
            }
        } else if (aiResponseTodo.getTodoList().isEmpty()) {
            Object emit3 = this.e.emit(TodoData.Empty.f6150a, continuation);
            return emit3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit3 : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
