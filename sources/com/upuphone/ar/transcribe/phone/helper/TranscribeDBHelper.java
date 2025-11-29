package com.upuphone.ar.transcribe.phone.helper;

import android.content.Context;
import androidx.sqlite.db.SimpleSQLiteQuery;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.audio.debug.AudioDebugHelper;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
import com.upuphone.ar.transcribe.phone.bean.TempStorageTransResult;
import com.upuphone.ar.transcribe.phone.db.TcbDao;
import com.upuphone.ar.transcribe.phone.db.TcbDb;
import com.upuphone.ar.transcribe.phone.db.entity.MessageEntity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.utils.AccountUtils;
import com.upuphone.ar.transcribe.utils.DateUtils;
import com.upuphone.ar.transcribe.utils.PreferencesUtils;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001pB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u0003J\u001f\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J!\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0$¢\u0006\u0004\b(\u0010)J\u001d\u0010+\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020'2\u0006\u0010*\u001a\u00020\u0004¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u0004\u0018\u00010\u001c2\u0006\u0010-\u001a\u00020'¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\u000e¢\u0006\u0004\b0\u00101J#\u00104\u001a\b\u0012\u0004\u0012\u00020\u001c0$2\u0006\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000e¢\u0006\u0004\b4\u00105J\u001b\u00108\u001a\b\u0012\u0004\u0012\u0002070$2\u0006\u00106\u001a\u00020'¢\u0006\u0004\b8\u00109J\u001b\u0010<\u001a\b\u0012\u0004\u0012\u00020;0$2\u0006\u0010:\u001a\u00020\u0004¢\u0006\u0004\b<\u0010=J\u001b\u0010?\u001a\u00020\b2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002070$¢\u0006\u0004\b?\u0010@J\u001d\u0010C\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u000207¢\u0006\u0004\bC\u0010DJ\u0019\u0010E\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\bG\u0010HJ\r\u0010I\u001a\u00020\b¢\u0006\u0004\bI\u0010\u0003J\u0017\u0010J\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\bJ\u0010\u001fJ\u0017\u0010K\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\bK\u0010\u001fJ\u0017\u0010L\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\bL\u0010\u001fJ!\u0010P\u001a\u00020\b2\u0006\u0010M\u001a\u00020\u00102\b\b\u0002\u0010O\u001a\u00020NH\u0002¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020NH\u0002¢\u0006\u0004\bR\u0010SJ\u001f\u0010U\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010T\u001a\u00020\u0004H\u0002¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\bH\u0002¢\u0006\u0004\bW\u0010\u0003J\u0017\u0010X\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\bX\u0010YJ\u0017\u0010[\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u0004H\u0002¢\u0006\u0004\b[\u0010\\R\u001a\u0010_\u001a\b\u0012\u0004\u0012\u0002070]8\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010^R0\u0010d\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060`j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006`a8\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010eR\u0016\u0010g\u001a\u00020N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010fR\u0016\u0010i\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010hR\u0018\u0010k\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010jR\u0016\u0010l\u001a\u00020N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u0010fR\u0018\u0010o\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u0010n¨\u0006q"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/TranscribeDBHelper;", "", "<init>", "()V", "", "key", "Lcom/upuphone/ar/transcribe/phone/helper/TranscribeDBHelper$RecordChangeListener;", "listener", "", "u", "(Ljava/lang/String;Lcom/upuphone/ar/transcribe/phone/helper/TranscribeDBHelper$RecordChangeListener;)V", "z", "(Ljava/lang/String;)V", "v", "", "finalType", "Lcom/upuphone/ar/transcribe/phone/bean/TempStorageTransResult;", "transResult", "C", "(ILcom/upuphone/ar/transcribe/phone/bean/TempStorageTransResult;)V", "j", "()Lcom/upuphone/ar/transcribe/phone/bean/TempStorageTransResult;", "Landroid/content/Context;", "context", "x", "(Landroid/content/Context;Lcom/upuphone/ar/transcribe/phone/bean/TempStorageTransResult;)V", "n", "(Landroid/content/Context;)V", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "transcribeBean", "d", "(Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;)V", "", "id", "e", "([J)V", "", "beans", "", "", "p", "(Ljava/util/List;)[Ljava/lang/Long;", "title", "E", "(JLjava/lang/String;)I", "recordId", "g", "(J)Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "a", "()I", "size", "offset", "h", "(II)Ljava/util/List;", "transId", "Lcom/upuphone/ar/transcribe/phone/db/entity/MessageEntity;", "i", "(J)Ljava/util/List;", "words", "Lcom/upuphone/ar/transcribe/phone/bean/SearchBean;", "y", "(Ljava/lang/String;)Ljava/util/List;", "messages", "o", "(Ljava/util/List;)V", "trans", "message", "B", "(Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;Lcom/upuphone/ar/transcribe/phone/db/entity/MessageEntity;)V", "D", "(Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;)Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "k", "()Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "l", "r", "s", "t", "result", "", "isEnd", "b", "(Lcom/upuphone/ar/transcribe/phone/bean/TempStorageTransResult;Z)V", "q", "()Z", "rgzId", "w", "(Landroid/content/Context;Ljava/lang/String;)V", "A", "m", "(Lcom/upuphone/ar/transcribe/phone/bean/TempStorageTransResult;)V", "sourceText", "f", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "recordList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "recordChangeListenerMap", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "Z", "mIsSave", "I", "transType", "Lcom/upuphone/ar/transcribe/phone/bean/TempStorageTransResult;", "firstTransResult", "firstTransResultFinal", "Lcom/upuphone/ar/transcribe/phone/db/TcbDao;", "Lcom/upuphone/ar/transcribe/phone/db/TcbDao;", "tcbDao", "RecordChangeListener", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTranscribeDBHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeDBHelper.kt\ncom/upuphone/ar/transcribe/phone/helper/TranscribeDBHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 6 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,551:1\n1#2:552\n215#3,2:553\n215#3,2:555\n215#3,2:557\n1855#4,2:559\n1864#4,3:562\n26#5:561\n37#6,2:565\n*S KotlinDebug\n*F\n+ 1 TranscribeDBHelper.kt\ncom/upuphone/ar/transcribe/phone/helper/TranscribeDBHelper\n*L\n134#1:553,2\n140#1:555,2\n146#1:557,2\n205#1:559,2\n379#1:562,3\n335#1:561\n388#1:565,2\n*E\n"})
public final class TranscribeDBHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final TranscribeDBHelper f6108a = new TranscribeDBHelper();
    public static final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public static final HashMap c = new HashMap();
    public static TranscribeBean d;
    public static boolean e;
    public static int f;
    public static TempStorageTransResult g;
    public static boolean h;
    public static TcbDao i;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/helper/TranscribeDBHelper$RecordChangeListener;", "", "notifyRecordAdd", "", "transcribeBean", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "notifyRecordDelete", "notifyRecordUpdate", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface RecordChangeListener {
        void notifyRecordAdd(TranscribeBean transcribeBean);

        void notifyRecordDelete(TranscribeBean transcribeBean);

        void notifyRecordUpdate(TranscribeBean transcribeBean);
    }

    public static /* synthetic */ void c(TranscribeDBHelper transcribeDBHelper, TempStorageTransResult tempStorageTransResult, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        transcribeDBHelper.b(tempStorageTransResult, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A() {
        /*
            r8 = this;
            com.upuphone.ar.transcribe.phone.db.TcbDao r0 = i
            java.lang.String r1 = "TranscribeDBHelper"
            if (r0 != 0) goto L_0x000c
            java.lang.String r8 = "tcbDao is null"
            com.upuphone.ar.transcribe.ext.LogExt.e(r8, r1)
            return
        L_0x000c:
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r0 = d
            if (r0 != 0) goto L_0x0017
            java.lang.String r8 = "更新翻译记录异常，数据库对象为空"
            com.upuphone.ar.transcribe.ext.LogExt.g(r8, r1)
            return
        L_0x0017:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.getType()
            r2 = 0
            r3 = 0
            r4 = 1
            if (r0 != r4) goto L_0x0039
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r0 = d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.util.concurrent.CopyOnWriteArrayList r5 = b
            java.lang.Object r3 = r5.get(r3)
            com.upuphone.ar.transcribe.phone.db.entity.MessageEntity r3 = (com.upuphone.ar.transcribe.phone.db.entity.MessageEntity) r3
            java.lang.String r3 = r3.getMessage()
            r0.setTitle(r3)
        L_0x0037:
            r3 = r4
            goto L_0x0098
        L_0x0039:
            java.util.concurrent.CopyOnWriteArrayList r0 = b
            int r5 = r0.size()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "list size: "
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.upuphone.ar.transcribe.ext.LogExt.d(r5, r1)
            int r5 = r0.size()
            if (r5 != r4) goto L_0x006c
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r5 = d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            java.lang.Object r0 = r0.get(r3)
            com.upuphone.ar.transcribe.phone.db.entity.MessageEntity r0 = (com.upuphone.ar.transcribe.phone.db.entity.MessageEntity) r0
            java.lang.String r0 = r0.getMessage()
            r5.setTitle(r0)
            goto L_0x0037
        L_0x006c:
            int r5 = r0.size()
            r6 = 2
            if (r5 < r6) goto L_0x0098
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r5 = d
            if (r5 == 0) goto L_0x007c
            java.lang.String r5 = r5.getTitle2()
            goto L_0x007d
        L_0x007c:
            r5 = r2
        L_0x007d:
            if (r5 == 0) goto L_0x0085
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0098
        L_0x0085:
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r3 = d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Object r0 = r0.get(r4)
            com.upuphone.ar.transcribe.phone.db.entity.MessageEntity r0 = (com.upuphone.ar.transcribe.phone.db.entity.MessageEntity) r0
            java.lang.String r0 = r0.getMessage()
            r3.setTitle2(r0)
            goto L_0x0037
        L_0x0098:
            if (r3 == 0) goto L_0x00a6
            com.upuphone.ar.transcribe.phone.db.TcbDao r0 = i
            if (r0 == 0) goto L_0x00a6
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r4 = d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r0.o(r4)
        L_0x00a6:
            com.upuphone.ar.transcribe.phone.db.TcbDao r0 = i
            if (r0 == 0) goto L_0x00bf
            java.util.concurrent.CopyOnWriteArrayList r2 = b
            java.lang.Object r2 = kotlin.collections.CollectionsKt.last(r2)
            java.lang.String r4 = "last(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            com.upuphone.ar.transcribe.phone.db.entity.MessageEntity r2 = (com.upuphone.ar.transcribe.phone.db.entity.MessageEntity) r2
            long r4 = r0.h(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
        L_0x00bf:
            java.util.concurrent.CopyOnWriteArrayList r0 = b
            java.lang.Object r4 = kotlin.collections.CollectionsKt.last(r0)
            com.upuphone.ar.transcribe.phone.db.entity.MessageEntity r4 = (com.upuphone.ar.transcribe.phone.db.entity.MessageEntity) r4
            r4.setId(r2)
            java.lang.Object r0 = kotlin.collections.CollectionsKt.last(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "update messages : "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = ", title changed: "
            r2.append(r0)
            r2.append(r3)
            java.lang.String r0 = r2.toString()
            com.upuphone.ar.transcribe.ext.LogExt.d(r0, r1)
            com.upuphone.ar.transcribe.phone.TranscribeManager$Companion r0 = com.upuphone.ar.transcribe.phone.TranscribeManager.j
            com.upuphone.ar.transcribe.phone.TranscribeManager r0 = r0.a()
            com.upuphone.ar.transcribe.statemachine.machine.TranscribeStateManager r0 = r0.h()
            boolean r0 = r0.i()
            if (r0 == 0) goto L_0x0108
            java.lang.String r0 = "notify if already stopped"
            com.upuphone.ar.transcribe.ext.LogExt.g(r0, r1)
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r0 = d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r8.r(r0)
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.helper.TranscribeDBHelper.A():void");
    }

    public final void B(TranscribeBean transcribeBean, MessageEntity messageEntity) {
        Intrinsics.checkNotNullParameter(transcribeBean, "trans");
        Intrinsics.checkNotNullParameter(messageEntity, "message");
        TcbDao tcbDao = i;
        if (tcbDao != null) {
            tcbDao.o(transcribeBean);
        }
        TcbDao tcbDao2 = i;
        if (tcbDao2 != null) {
            Long id = messageEntity.getId();
            Intrinsics.checkNotNull(id);
            tcbDao2.p(id.longValue(), messageEntity.getMessage());
        } else {
            LogExt.e("tcbDao is null", "TranscribeDBHelper");
        }
        t(transcribeBean);
    }

    public final void C(int i2, TempStorageTransResult tempStorageTransResult) {
        Intrinsics.checkNotNullParameter(tempStorageTransResult, "transResult");
        if (!h) {
            if (i2 == 0) {
                h = true;
            }
            boolean z = h;
            LogExt.g("updateFirstTransResult finalType=" + i2 + ", mFirstTransResultFinal=" + z, "TranscribeDBHelper");
            g = tempStorageTransResult;
        }
    }

    public final TranscribeBean D(TranscribeBean transcribeBean) {
        boolean z = e;
        LogExt.g("updateRecord isSave=" + z + ", noteBean=" + transcribeBean, "TranscribeDBHelper");
        TranscribeBean transcribeBean2 = null;
        if (!e || transcribeBean == null || i == null) {
            return null;
        }
        transcribeBean.setRecordTime(DateUtils.f());
        TcbDao tcbDao = i;
        Long valueOf = tcbDao != null ? Long.valueOf(tcbDao.o(transcribeBean)) : null;
        if (d != null) {
            transcribeBean2 = transcribeBean;
        }
        d = transcribeBean2;
        Long id = transcribeBean.getId();
        TranscribeBean transcribeBean3 = d;
        LogExt.g("updateRecord updateState=" + valueOf + ", id=" + id + ", mNoteBean=" + transcribeBean3, "TranscribeDBHelper");
        r(transcribeBean);
        return transcribeBean;
    }

    public final int E(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TcbDao tcbDao = i;
        if (tcbDao != null) {
            return tcbDao.g(j, str);
        }
        return 0;
    }

    public final int a() {
        TcbDao tcbDao = i;
        if (tcbDao != null) {
            return tcbDao.count();
        }
        LogExt.e("tcbDao is null", "TranscribeDBHelper");
        return 0;
    }

    public final void b(TempStorageTransResult tempStorageTransResult, boolean z) {
        if (tempStorageTransResult.getOwnerType() == 1) {
            AudioDebugHelper.j(tempStorageTransResult.getContent(), "trc_remote_src_phone.txt", z);
        } else {
            AudioDebugHelper.h(tempStorageTransResult.getContent(), "trc_proximal_src_phone.txt", z);
        }
    }

    public final void d(TranscribeBean transcribeBean) {
        if (transcribeBean != null) {
            boolean z = i == null;
            Long id = transcribeBean.getId();
            LogExt.d(z + ", deleteData=$" + id, "TranscribeDBHelper");
            TcbDao tcbDao = i;
            if (tcbDao != null) {
                Long id2 = transcribeBean.getId();
                Intrinsics.checkNotNull(id2);
                tcbDao.c(id2.longValue());
            }
            TitleGenerator j = TranscribeManager.j.a().j();
            if (j != null) {
                j.f(transcribeBean);
            }
            f6108a.s(transcribeBean);
        }
    }

    public final void e(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "id");
        TitleGenerator j = TranscribeManager.j.a().j();
        if (j != null) {
            j.d(jArr);
        }
        TcbDao tcbDao = i;
        if (tcbDao != null) {
            tcbDao.l(jArr);
        }
    }

    public final String f(String str) {
        return new Regex("^[,.:;?!'\"()、，。：；？！‘’“”（）]+").replace((CharSequence) str, "");
    }

    public final TranscribeBean g(long j) {
        TcbDao tcbDao = i;
        if (tcbDao != null) {
            return tcbDao.n(j);
        }
        return null;
    }

    public final List h(int i2, int i3) {
        List f2;
        TcbDao tcbDao = i;
        if (tcbDao != null && (f2 = tcbDao.f(AccountUtils.f6173a.a(), i2, i3)) != null) {
            return f2;
        }
        LogExt.e("tcbDao is null", "TranscribeDBHelper");
        return CollectionsKt.emptyList();
    }

    public final List i(long j) {
        List e2;
        TcbDao tcbDao = i;
        if (tcbDao != null && (e2 = tcbDao.e(j)) != null) {
            return e2;
        }
        LogExt.e("tcbDao is null", "TranscribeDBHelper");
        return CollectionsKt.emptyList();
    }

    public final TempStorageTransResult j() {
        return g;
    }

    public final TranscribeBean k() {
        return d;
    }

    public final void l() {
        LogExt.g("handleMuteTwoSecs", "TranscribeDBHelper");
        CopyOnWriteArrayList copyOnWriteArrayList = b;
        if (copyOnWriteArrayList.isEmpty()) {
            LogExt.g("handleMuteTwoSecs 原文为空不进行换行", "TranscribeDBHelper");
            return;
        }
        MessageEntity messageEntity = (MessageEntity) CollectionsKt.last(copyOnWriteArrayList);
        if (f == 1 && (!StringsKt.isBlank(messageEntity.getMessage()))) {
            if (!messageEntity.getWraped()) {
                String message = messageEntity.getMessage();
                messageEntity.setMessage(message + "\n\n");
            }
            messageEntity.setWraped(true);
        } else if (f == 4) {
            TranscribeBean transcribeBean = d;
            if ((transcribeBean != null ? transcribeBean.getId() : null) != null && (!StringsKt.isBlank(messageEntity.getMessage()))) {
                synchronized (copyOnWriteArrayList) {
                    int owner = messageEntity.getOwner();
                    long f2 = DateUtils.f();
                    TranscribeBean transcribeBean2 = d;
                    Intrinsics.checkNotNull(transcribeBean2);
                    Long id = transcribeBean2.getId();
                    Intrinsics.checkNotNull(id);
                    copyOnWriteArrayList.add(new MessageEntity((Long) null, "", owner, f2, id.longValue(), 1, (DefaultConstructorMarker) null));
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m(com.upuphone.ar.transcribe.phone.bean.TempStorageTransResult r14) {
        /*
            r13 = this;
            java.util.concurrent.CopyOnWriteArrayList r0 = b
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0018
            int r1 = r14.getOwnerType()
            java.lang.Object r2 = kotlin.collections.CollectionsKt.last(r0)
            com.upuphone.ar.transcribe.phone.db.entity.MessageEntity r2 = (com.upuphone.ar.transcribe.phone.db.entity.MessageEntity) r2
            int r2 = r2.getOwner()
            if (r1 == r2) goto L_0x003e
        L_0x0018:
            monitor-enter(r0)
            com.upuphone.ar.transcribe.phone.db.entity.MessageEntity r1 = new com.upuphone.ar.transcribe.phone.db.entity.MessageEntity     // Catch:{ all -> 0x008a }
            java.lang.String r5 = ""
            int r6 = r14.getOwnerType()     // Catch:{ all -> 0x008a }
            long r7 = com.upuphone.ar.transcribe.utils.DateUtils.f()     // Catch:{ all -> 0x008a }
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r2 = d     // Catch:{ all -> 0x008a }
            if (r2 == 0) goto L_0x008c
            java.lang.Long r2 = r2.getId()     // Catch:{ all -> 0x008a }
            if (r2 == 0) goto L_0x008c
            long r9 = r2.longValue()     // Catch:{ all -> 0x008a }
            r11 = 1
            r12 = 0
            r4 = 0
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r9, r11, r12)     // Catch:{ all -> 0x008a }
            r0.add(r1)     // Catch:{ all -> 0x008a }
            monitor-exit(r0)
        L_0x003e:
            java.lang.Object r0 = kotlin.collections.CollectionsKt.last(r0)
            com.upuphone.ar.transcribe.phone.db.entity.MessageEntity r0 = (com.upuphone.ar.transcribe.phone.db.entity.MessageEntity) r0
            java.lang.String r1 = r14.getContent()
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x0063
            java.lang.String r1 = r0.getMessage()
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            if (r1 == 0) goto L_0x0063
            java.lang.String r14 = r14.getContent()
            java.lang.String r13 = r13.f(r14)
            goto L_0x0067
        L_0x0063:
            java.lang.String r13 = r14.getContent()
        L_0x0067:
            boolean r14 = kotlin.text.StringsKt.isBlank(r13)
            r14 = r14 ^ 1
            if (r14 == 0) goto L_0x0089
            java.lang.String r14 = r0.getMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            r0.setMessage(r13)
            r13 = 0
            r0.setWraped(r13)
        L_0x0089:
            return
        L_0x008a:
            r13 = move-exception
            goto L_0x008e
        L_0x008c:
            monitor-exit(r0)
            return
        L_0x008e:
            monitor-exit(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.helper.TranscribeDBHelper.m(com.upuphone.ar.transcribe.phone.bean.TempStorageTransResult):void");
    }

    public final void n(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        i = TcbDb.f6095a.a(context).o();
    }

    public final void o(List list) {
        Intrinsics.checkNotNullParameter(list, "messages");
        TcbDao tcbDao = i;
        if (tcbDao == null || tcbDao.i(list) == null) {
            LogExt.e("tcbDao is null", "TranscribeDBHelper");
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Long[] p(List list) {
        Long[] a2;
        Intrinsics.checkNotNullParameter(list, "beans");
        TcbDao tcbDao = i;
        if (tcbDao != null && (a2 = tcbDao.a(list)) != null) {
            return a2;
        }
        LogExt.e("tcbDao is null", "TranscribeDBHelper");
        return new Long[0];
    }

    public final boolean q() {
        CopyOnWriteArrayList copyOnWriteArrayList = b;
        if (!copyOnWriteArrayList.isEmpty()) {
            return StringsKt.isBlank(((MessageEntity) copyOnWriteArrayList.get(0)).getMessage());
        }
        LogExt.g("isRecordIllegal list is null", "TranscribeDBHelper");
        return true;
    }

    public final void r(TranscribeBean transcribeBean) {
        for (Map.Entry value : c.entrySet()) {
            ((RecordChangeListener) value.getValue()).notifyRecordAdd(transcribeBean);
        }
    }

    public final void s(TranscribeBean transcribeBean) {
        for (Map.Entry value : c.entrySet()) {
            ((RecordChangeListener) value.getValue()).notifyRecordDelete(transcribeBean);
        }
    }

    public final void t(TranscribeBean transcribeBean) {
        for (Map.Entry value : c.entrySet()) {
            ((RecordChangeListener) value.getValue()).notifyRecordUpdate(transcribeBean);
        }
    }

    public final void u(String str, RecordChangeListener recordChangeListener) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(recordChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        c.put(str, recordChangeListener);
    }

    public final void v() {
        LogExt.g("reset: 重置翻译记录存储类各种数据", "TranscribeDBHelper");
        g = null;
        d = null;
        b.clear();
        e = false;
        f = 0;
        h = false;
    }

    public final void w(Context context, String str) {
        String str2;
        Context context2 = context;
        if (i == null) {
            LogExt.e("tcbDao is null", "TranscribeDBHelper");
            return;
        }
        TranscribeBean transcribeBean = new TranscribeBean((Long) null, (String) null, 0, 0, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16383, (DefaultConstructorMarker) null);
        transcribeBean.setRecordTime(DateUtils.f());
        transcribeBean.setXrType(TranscribeConstants.g() ? 1 : 0);
        if (PreferencesUtils.f6190a.i(context2)) {
            NaviLocationInfo e2 = TranscribeConstants.f6027a.e();
            if (e2 != null) {
                String district = e2.getDistrict();
                String street = e2.getStreet();
                String address = e2.getAddress();
                if ((district == null || StringsKt.isBlank(district)) && (street == null || StringsKt.isBlank(street))) {
                    str2 = (address == null || StringsKt.isBlank(address)) ? context2.getString(R.string.tl_unknown) : address;
                } else {
                    str2 = district + street;
                }
                transcribeBean.setSimpleLocation(str2);
                if (address == null || StringsKt.isBlank(address)) {
                    address = context2.getString(R.string.tl_unknown);
                }
                transcribeBean.setFullLocation(address);
                Unit unit = Unit.INSTANCE;
            } else {
                new TranscribeDBHelper$save$1$2(transcribeBean, context2);
            }
        }
        TranscribeManager.Companion companion = TranscribeManager.j;
        transcribeBean.setType(companion.a().l());
        TitleGenerator j = companion.a().j();
        Long l = null;
        transcribeBean.setSuperTitle(j != null ? j.h() : null);
        transcribeBean.setAccount(AccountUtils.f6173a.a());
        transcribeBean.setRecognizeId(str);
        transcribeBean.setLanguage(PreferencesUtils.c(context2, TranscribeConstants.g(), TranscribeConstants.f6027a.m()));
        TcbDao tcbDao = i;
        if (tcbDao != null) {
            l = Long.valueOf(tcbDao.o(transcribeBean));
        }
        transcribeBean.setId(l);
        LogExt.g("save trans bean: " + transcribeBean, "TranscribeDBHelper");
        d = transcribeBean;
    }

    public final void x(Context context, TempStorageTransResult tempStorageTransResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tempStorageTransResult, "transResult");
        LogExt.g("saveFinalResult transResult=" + tempStorageTransResult, "TranscribeDBHelper");
        TranscribeManager.Companion companion = TranscribeManager.j;
        if (companion.a().h().i()) {
            LogExt.g("saveFinalResult Translation is not start", "TranscribeDBHelper");
            if (!tempStorageTransResult.isFirstTemp()) {
                return;
            }
        }
        c(this, tempStorageTransResult, false, 2, (Object) null);
        if (d == null) {
            v();
            f = companion.a().l();
            w(context, tempStorageTransResult.getRecognizeId());
            Unit unit = Unit.INSTANCE;
            e = true;
        }
        m(tempStorageTransResult);
        if (q()) {
            LogExt.g("saveFinalResult 要保存的内容为空，不需要保存", "TranscribeDBHelper");
        } else {
            A();
        }
    }

    public final List y(String str) {
        List sortedWith;
        Intrinsics.checkNotNullParameter(str, "words");
        ArrayList arrayList = new ArrayList();
        List<String> split = new Regex("\\s").split(str, 0);
        StringBuilder sb = new StringBuilder("SELECT transcribe.id, transcribe.recordTime, transcribe.type, transcribe.superTitle, transcribe.simpleLocation, messages.id as messageId, messages.message FROM transcribe INNER JOIN messages ON transcribe.id = messages.transcribeId WHERE (transcribe.account = ? OR transcribe.account IS NULL OR transcribe.account = '') AND");
        arrayList.add(AccountUtils.f6173a.a());
        sb.append(" (");
        int i2 = 0;
        for (T next : split) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str2 = (String) next;
            if (i2 > 0) {
                sb.append(" OR ");
            }
            sb.append("transcribe.superTitle LIKE ? OR messages.message LIKE ?");
            arrayList.add("%" + str2 + "%");
            arrayList.add("%" + str2 + "%");
            i2 = i3;
        }
        sb.append(" )");
        TcbDao tcbDao = i;
        if (tcbDao != null) {
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            List d2 = tcbDao.d(new SimpleSQLiteQuery(sb2, arrayList.toArray(new String[0])));
            if (!(d2 == null || (sortedWith = CollectionsKt.sortedWith(d2, new TranscribeDBHelper$search$$inlined$thenByDescending$2(new TranscribeDBHelper$search$$inlined$thenByDescending$1(new TranscribeDBHelper$search$$inlined$compareByDescending$1(split), split)))) == null)) {
                return sortedWith;
            }
        }
        LogExt.e("tcbDao is null", "TranscribeDBHelper");
        return CollectionsKt.emptyList();
    }

    public final void z(String str) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        c.remove(str);
    }
}
