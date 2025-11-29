package com.upuphone.ar.transcribe.phone.repo;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.db.AiDao;
import com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity;
import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.xjsd.xr.sapp.asr.SmartExtractionHelper;
import com.xjsd.xr.sapp.asr.dao.SmartExtractionConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\b\u0018\u0000 D2\u00020\u0001:\u0001EB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\fJ\u001d\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\fJ\u001d\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\fJ\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H@¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0012H@¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0012H@¢\u0006\u0004\b\u0019\u0010\u0018J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0012H@¢\u0006\u0004\b\u001a\u0010\u0018J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0011\u001a\u00020\u0010H@¢\u0006\u0004\b\u001d\u0010\u0014J$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u001f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH@¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H@¢\u0006\u0004\b\"\u0010\u0014J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00160\u001f2\u0006\u0010\u0015\u001a\u00020\u001cH@¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b&\u0010'J\u001d\u0010(\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b*\u0010'J\u001d\u0010+\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b+\u0010)J\u0015\u0010,\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b,\u0010-R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002028BX\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b088\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R \u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b088\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010:R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00100>8\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00100>8\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010@¨\u0006F"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/repo/TranscribeAiRepo;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "noteBean", "Lcom/upuphone/ar/transcribe/phone/repo/OnDataLoadListener;", "listener", "", "o", "(Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;Lcom/upuphone/ar/transcribe/phone/repo/OnDataLoadListener;)V", "r", "n", "q", "", "recordId", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;", "p", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bean", "", "A", "(Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "v", "j", "", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;", "s", "beans", "", "B", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "w", "k", "(Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "t", "(Ljava/lang/String;)Z", "y", "(Ljava/lang/String;Lcom/upuphone/ar/transcribe/phone/repo/OnDataLoadListener;)V", "u", "z", "x", "(Ljava/lang/String;)V", "a", "Landroid/content/Context;", "m", "()Landroid/content/Context;", "Lcom/upuphone/ar/transcribe/phone/db/AiDao;", "b", "Lkotlin/Lazy;", "l", "()Lcom/upuphone/ar/transcribe/phone/db/AiDao;", "aiDao", "", "c", "Ljava/util/Map;", "summaryLoadMap", "d", "todoLoadMap", "", "e", "Ljava/util/Set;", "loadingSummary", "f", "loadingTodo", "g", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTranscribeAiRepo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeAiRepo.kt\ncom/upuphone/ar/transcribe/phone/repo/TranscribeAiRepo\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,292:1\n766#2:293\n857#2,2:294\n1855#2,2:296\n*S KotlinDebug\n*F\n+ 1 TranscribeAiRepo.kt\ncom/upuphone/ar/transcribe/phone/repo/TranscribeAiRepo\n*L\n67#1:293\n67#1:294,2\n69#1:296,2\n*E\n"})
public final class TranscribeAiRepo {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public static TranscribeAiRepo h;

    /* renamed from: a  reason: collision with root package name */
    public final Context f6122a;
    public final Lazy b;
    public final Map c;
    public final Map d;
    public final Set e;
    public final Set f;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/repo/TranscribeAiRepo$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/upuphone/ar/transcribe/phone/repo/TranscribeAiRepo;", "a", "(Landroid/content/Context;)Lcom/upuphone/ar/transcribe/phone/repo/TranscribeAiRepo;", "", "TAG", "Ljava/lang/String;", "instance", "Lcom/upuphone/ar/transcribe/phone/repo/TranscribeAiRepo;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TranscribeAiRepo a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (TranscribeAiRepo.h == null) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                TranscribeAiRepo.h = new TranscribeAiRepo(applicationContext, (DefaultConstructorMarker) null);
            }
            TranscribeAiRepo b = TranscribeAiRepo.h;
            Intrinsics.checkNotNull(b);
            return b;
        }

        public Companion() {
        }
    }

    public /* synthetic */ TranscribeAiRepo(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public final Object A(AiSummaryEntity aiSummaryEntity, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new TranscribeAiRepo$upsertSummary$2(this, aiSummaryEntity, (Continuation<? super TranscribeAiRepo$upsertSummary$2>) null), continuation);
    }

    public final Object B(List list, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new TranscribeAiRepo$upsertTodo$2(this, list, (Continuation<? super TranscribeAiRepo$upsertTodo$2>) null), continuation);
    }

    public final Object j(AiSummaryEntity aiSummaryEntity, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new TranscribeAiRepo$deleteSummary$2(aiSummaryEntity, this, (Continuation<? super TranscribeAiRepo$deleteSummary$2>) null), continuation);
    }

    public final Object k(AiTodoEntity aiTodoEntity, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new TranscribeAiRepo$deleteTodo$2(aiTodoEntity, this, (Continuation<? super TranscribeAiRepo$deleteTodo$2>) null), continuation);
    }

    public final AiDao l() {
        return (AiDao) this.b.getValue();
    }

    public final Context m() {
        return this.f6122a;
    }

    public final void n(TranscribeBean transcribeBean, OnDataLoadListener onDataLoadListener) {
        String src;
        Intrinsics.checkNotNullParameter(transcribeBean, "noteBean");
        Intrinsics.checkNotNullParameter(onDataLoadListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        AiDao l = l();
        String recognizeId = transcribeBean.getRecognizeId();
        if (recognizeId == null) {
            recognizeId = "";
        }
        AiSummaryEntity i = l.i(recognizeId);
        if (i == null || (src = i.getSrc()) == null || src.length() <= 0) {
            LogExt.d("delete db summary data: " + i, "TranscribeAiRepo");
            if (i != null) {
                l().b(i);
            }
            Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, Dispatchers.b(), (CoroutineStart) null, new TranscribeAiRepo$getSummaryFromCloud$1(this, transcribeBean, onDataLoadListener, (Continuation<? super TranscribeAiRepo$getSummaryFromCloud$1>) null), 2, (Object) null);
            return;
        }
        i.setDeleted(0);
        l().h(i);
        onDataLoadListener.a(i);
    }

    public final void o(TranscribeBean transcribeBean, OnDataLoadListener onDataLoadListener) {
        String recognizeId = transcribeBean.getRecognizeId();
        if (recognizeId == null) {
            recognizeId = "";
        }
        this.c.put(recognizeId, onDataLoadListener);
        if (this.e.contains(recognizeId)) {
            onDataLoadListener.a(Loading.f6121a);
            return;
        }
        LogExt.d("loading summary add id: " + recognizeId, "TranscribeAiRepo");
        this.e.add(recognizeId);
        SmartExtractionHelper smartExtractionHelper = new SmartExtractionHelper("com.upuphone.ar.transcribe");
        smartExtractionHelper.registerCallback(new TranscribeAiRepo$getSummaryFromCloudInternal$1$1(this, recognizeId, transcribeBean));
        smartExtractionHelper.getSummary(new SmartExtractionConfig(recognizeId, 0));
    }

    public final Object p(String str, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new TranscribeAiRepo$getSummaryFromDb$2(this, str, (Continuation<? super TranscribeAiRepo$getSummaryFromDb$2>) null), continuation);
    }

    public final void q(TranscribeBean transcribeBean, OnDataLoadListener onDataLoadListener) {
        Intrinsics.checkNotNullParameter(transcribeBean, "noteBean");
        Intrinsics.checkNotNullParameter(onDataLoadListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        AiDao l = l();
        String recognizeId = transcribeBean.getRecognizeId();
        if (recognizeId == null) {
            recognizeId = "";
        }
        List<AiTodoEntity> d2 = l.d(recognizeId);
        ArrayList arrayList = new ArrayList();
        for (Object next : d2) {
            String src = ((AiTodoEntity) next).getSrc();
            if (src == null || src.length() == 0) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty() || !(!d2.isEmpty())) {
            if (!d2.isEmpty()) {
                l().j(d2);
            }
            Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, Dispatchers.b(), (CoroutineStart) null, new TranscribeAiRepo$getTodoFromCloud$2(this, transcribeBean, onDataLoadListener, (Continuation<? super TranscribeAiRepo$getTodoFromCloud$2>) null), 2, (Object) null);
            return;
        }
        for (AiTodoEntity deleted : d2) {
            deleted.setDeleted(0);
        }
        l().e(d2);
        onDataLoadListener.a(d2);
    }

    public final void r(TranscribeBean transcribeBean, OnDataLoadListener onDataLoadListener) {
        String recognizeId = transcribeBean.getRecognizeId();
        if (recognizeId == null) {
            recognizeId = "";
        }
        this.d.put(recognizeId, onDataLoadListener);
        if (this.f.contains(recognizeId)) {
            onDataLoadListener.a(Loading.f6121a);
            return;
        }
        LogExt.d("loading todo add id: " + recognizeId, "TranscribeAiRepo");
        this.f.add(recognizeId);
        SmartExtractionHelper smartExtractionHelper = new SmartExtractionHelper("com.upuphone.ar.transcribe");
        smartExtractionHelper.registerCallback(new TranscribeAiRepo$getTodoFromCloudInternal$1$1(this, recognizeId, transcribeBean));
        smartExtractionHelper.getTodo(new SmartExtractionConfig(recognizeId, 0));
    }

    public final Object s(String str, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new TranscribeAiRepo$getTodoFromDb$2(this, str, (Continuation<? super TranscribeAiRepo$getTodoFromDb$2>) null), continuation);
    }

    public final boolean t(String str) {
        Intrinsics.checkNotNullParameter(str, "recordId");
        boolean contains = this.e.contains(str);
        LogExt.d("isSummaryInLoading: " + str + ", result: " + contains, "TranscribeAiRepo");
        return contains;
    }

    public final boolean u(String str) {
        Intrinsics.checkNotNullParameter(str, "recordId");
        boolean contains = this.f.contains(str);
        LogExt.d("isTodoInLoading: " + str + ", result: " + contains, "TranscribeAiRepo");
        return contains;
    }

    public final Object v(AiSummaryEntity aiSummaryEntity, Continuation continuation) {
        Object g2 = BuildersKt.g(Dispatchers.b(), new TranscribeAiRepo$markSummaryReport$2(this, aiSummaryEntity, (Continuation<? super TranscribeAiRepo$markSummaryReport$2>) null), continuation);
        return g2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g2 : Unit.INSTANCE;
    }

    public final Object w(String str, Continuation continuation) {
        Object g2 = BuildersKt.g(Dispatchers.b(), new TranscribeAiRepo$markTodoReport$2(this, str, (Continuation<? super TranscribeAiRepo$markTodoReport$2>) null), continuation);
        return g2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g2 : Unit.INSTANCE;
    }

    public final void x(String str) {
        Intrinsics.checkNotNullParameter(str, "recordId");
        LogExt.d("release smart helper: " + str, "TranscribeAiRepo");
        this.c.remove(str);
        this.d.remove(str);
    }

    public final void y(String str, OnDataLoadListener onDataLoadListener) {
        Intrinsics.checkNotNullParameter(str, "recordId");
        Intrinsics.checkNotNullParameter(onDataLoadListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.c.put(str, onDataLoadListener);
    }

    public final void z(String str, OnDataLoadListener onDataLoadListener) {
        Intrinsics.checkNotNullParameter(str, "recordId");
        Intrinsics.checkNotNullParameter(onDataLoadListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d.put(str, onDataLoadListener);
    }

    public TranscribeAiRepo(Context context) {
        this.f6122a = context;
        this.b = LazyKt.lazy(new TranscribeAiRepo$aiDao$2(this));
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashSet();
        this.f = new LinkedHashSet();
    }
}
