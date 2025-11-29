package com.upuphone.ar.tici.phone.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.upuphone.ar.tici.phone.data.TiciHistory;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import com.upuphone.ar.tici.phone.utils.DateTimeExtKt;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0017\u001a\u00020\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H@¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u001c\u0010!\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001cR\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R,\u0010)\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00150'0&8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010(R/\u0010.\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00150'0*8\u0006¢\u0006\f\n\u0004\b\u000f\u0010+\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/upuphone/ar/tici/phone/viewmodel/TiciHistoryViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "", "userId", "", "time", "", "k", "(Ljava/lang/String;Ljava/lang/Long;)V", "Lcom/upuphone/ar/tici/phone/data/TiciHistory;", "ticiHistory", "g", "(Lcom/upuphone/ar/tici/phone/data/TiciHistory;)V", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "ticiEntity", "f", "(Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;)V", "", "list", "h", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/time/LocalDate;", "kotlin.jvm.PlatformType", "b", "Ljava/time/LocalDate;", "today", "c", "recentWeek", "d", "recentMonth", "", "e", "Ljava/util/List;", "ticiHistoryList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_ticiHistoryFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/Flow;", "j", "()Lkotlinx/coroutines/flow/Flow;", "ticiHistoryFlow", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTiciHistoryViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciHistoryViewModel.kt\ncom/upuphone/ar/tici/phone/viewmodel/TiciHistoryViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,86:1\n1477#2:87\n1502#2,3:88\n1505#2,3:98\n372#3,7:91\n*S KotlinDebug\n*F\n+ 1 TiciHistoryViewModel.kt\ncom/upuphone/ar/tici/phone/viewmodel/TiciHistoryViewModel\n*L\n68#1:87\n68#1:88,3\n68#1:98,3\n68#1:91,7\n*E\n"})
public final class TiciHistoryViewModel extends AndroidViewModel {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);
    public final LocalDate b;
    public final LocalDate c;
    public final LocalDate d;
    public final List e = new ArrayList();
    public final MutableStateFlow f;
    public final Flow g;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/tici/phone/viewmodel/TiciHistoryViewModel$Companion;", "", "()V", "PAGE_SIZE", "", "TAG", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciHistoryViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, VuiModelType.APPLICATION);
        LocalDate now = LocalDate.now();
        this.b = now;
        this.c = now.minusDays(7);
        this.d = now.minusDays(30);
        MutableStateFlow a2 = StateFlowKt.a(MapsKt.emptyMap());
        this.f = a2;
        this.g = FlowKt.b(a2);
    }

    public static /* synthetic */ void l(TiciHistoryViewModel ticiHistoryViewModel, String str, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        ticiHistoryViewModel.k(str, l);
    }

    public final void f(TiciEntity ticiEntity) {
        Intrinsics.checkNotNullParameter(ticiEntity, "ticiEntity");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciHistoryViewModel$addTiciHistoryAtFirst$1(this, ticiEntity, (Continuation<? super TiciHistoryViewModel$addTiciHistoryAtFirst$1>) null), 3, (Object) null);
    }

    public final void g(TiciHistory ticiHistory) {
        Intrinsics.checkNotNullParameter(ticiHistory, "ticiHistory");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciHistoryViewModel$deleteTiciHistory$1(ticiHistory, this, (Continuation<? super TiciHistoryViewModel$deleteTiciHistory$1>) null), 3, (Object) null);
    }

    public final Object h(List list, Continuation continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : list) {
            long lastModified = ((TiciHistory) next).getLastModified();
            Application c2 = c();
            Intrinsics.checkNotNullExpressionValue(c2, "getApplication(...)");
            LocalDate localDate = this.b;
            Intrinsics.checkNotNullExpressionValue(localDate, "today");
            LocalDate localDate2 = this.c;
            Intrinsics.checkNotNullExpressionValue(localDate2, "recentWeek");
            LocalDate localDate3 = this.d;
            Intrinsics.checkNotNullExpressionValue(localDate3, "recentMonth");
            String a2 = DateTimeExtKt.a(lastModified, c2, localDate, localDate2, localDate3);
            Object obj = linkedHashMap.get(a2);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(a2, obj);
            }
            ((List) obj).add(next);
        }
        Object emit = this.f.emit(linkedHashMap, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    public final Flow j() {
        return this.g;
    }

    public final void k(String str, Long l) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciHistoryViewModel$loadTiciHistory$1(l, str, this, (Continuation<? super TiciHistoryViewModel$loadTiciHistory$1>) null), 3, (Object) null);
    }
}
