package com.upuphone.ar.transcribe.phone.vm;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.z4.b;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.repo.AiResponseSensitive;
import com.upuphone.ar.transcribe.phone.repo.AiResponseSummary;
import com.upuphone.ar.transcribe.phone.repo.Loading;
import com.upuphone.ar.transcribe.phone.repo.OnDataLoadListener;
import com.upuphone.ar.transcribe.phone.repo.TranscribeAiRepo;
import com.upuphone.ar.transcribe.phone.vm.SummaryData;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.audio.record.ai.bean.AiFeedBackRequest;
import com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 <2\u00020\u0001:\u0001=B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H@¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H@¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H@¢\u0006\u0004\b\u0017\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH@¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0&8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001f\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R$\u0010;\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/SummaryViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "", "data", "", "q", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "noteBean", "n", "(Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;)V", "Landroid/app/Activity;", "activity", "k", "(Landroid/app/Activity;)V", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;", "summary", "t", "(Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j", "m", "(Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "rcId", "s", "(Ljava/lang/String;)V", "b", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "Lcom/upuphone/ar/transcribe/phone/repo/TranscribeAiRepo;", "c", "Lcom/upuphone/ar/transcribe/phone/repo/TranscribeAiRepo;", "aiRepo", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/upuphone/ar/transcribe/phone/vm/SummaryData;", "d", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_summaryData", "Lcom/upuphone/ar/transcribe/phone/repo/OnDataLoadListener;", "e", "Lcom/upuphone/ar/transcribe/phone/repo/OnDataLoadListener;", "listener", "Lkotlinx/coroutines/flow/Flow;", "f", "Lkotlinx/coroutines/flow/Flow;", "p", "()Lkotlinx/coroutines/flow/Flow;", "summaryData", "g", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;", "l", "()Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;", "setDbData", "(Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;)V", "dbData", "h", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SummaryViewModel extends AndroidViewModel {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);
    public final Application b;
    public final TranscribeAiRepo c;
    public final MutableSharedFlow d;
    public final OnDataLoadListener e = new b(this);
    public final Flow f;
    public AiSummaryEntity g;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/SummaryViewModel$Companion;", "", "()V", "TAG", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SummaryViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, DDAuthConstant.AUTH_LOGIN_TYPE_APP);
        this.b = application;
        this.c = TranscribeAiRepo.g.a(application);
        MutableSharedFlow b2 = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.d = b2;
        Intrinsics.checkNotNull(b2, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<com.upuphone.ar.transcribe.phone.vm.SummaryData?>");
        this.f = b2;
    }

    /* access modifiers changed from: private */
    public final Object q(Object obj, Continuation continuation) {
        Object obj2;
        MutableSharedFlow mutableSharedFlow = this.d;
        if (obj instanceof Loading) {
            obj2 = SummaryData.Loading.f6143a;
        } else if (obj instanceof AiSummaryEntity) {
            AiSummaryEntity aiSummaryEntity = (AiSummaryEntity) obj;
            this.g = aiSummaryEntity;
            obj2 = new SummaryData.DbData(aiSummaryEntity);
        } else {
            obj2 = obj instanceof AiResponseSensitive ? new SummaryData.SensitiveData((AiResponseSensitive) obj) : obj instanceof AiResponseSummary ? new SummaryData.CloudData((AiResponseSummary) obj) : null;
        }
        Object emit = mutableSharedFlow.emit(obj2, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    public static final void r(SummaryViewModel summaryViewModel, Object obj) {
        Intrinsics.checkNotNullParameter(summaryViewModel, "this$0");
        LogExt.g("getSummaryByServer summaryData=" + obj, "SummaryViewModel");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(summaryViewModel), (CoroutineContext) null, (CoroutineStart) null, new SummaryViewModel$listener$1$1(summaryViewModel, obj, (Continuation<? super SummaryViewModel$listener$1$1>) null), 3, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.upuphone.ar.transcribe.phone.vm.SummaryViewModel$deleteSummary$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.upuphone.ar.transcribe.phone.vm.SummaryViewModel$deleteSummary$1 r0 = (com.upuphone.ar.transcribe.phone.vm.SummaryViewModel$deleteSummary$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.transcribe.phone.vm.SummaryViewModel$deleteSummary$1 r0 = new com.upuphone.ar.transcribe.phone.vm.SummaryViewModel$deleteSummary$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            r5 = r4
            com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity r5 = (com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0046
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.upuphone.ar.transcribe.phone.repo.TranscribeAiRepo r4 = r4.c
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.j(r5, r0)
            if (r4 != r1) goto L_0x0046
            return r1
        L_0x0046:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "deleteSummary summary="
            r4.append(r6)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "SummaryViewModel"
            com.upuphone.ar.transcribe.ext.LogExt.g(r4, r5)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.vm.SummaryViewModel.j(com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void k(Activity activity) {
        String str;
        String requestId;
        Intrinsics.checkNotNullParameter(activity, "activity");
        StringBuilder sb = new StringBuilder();
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = this.g != null;
        delegate.c("SummaryViewModel", "getSummaryShareText data is null  " + z);
        AiSummaryEntity aiSummaryEntity = this.g;
        if (aiSummaryEntity != null && !TextUtils.isEmpty(aiSummaryEntity.getSummary())) {
            String string = this.b.getString(R.string.tl_summary);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            sb.append(StringUtils.LF);
            sb.append(string);
            sb.append(AccountConstantKt.CODE_SEPARTOR);
            sb.append(StringUtils.LF);
            sb.append(aiSummaryEntity.getSummary());
            sb.append(StringUtils.LF);
        }
        delegate.c("SummaryViewModel", "getSummaryShareText  sb.toString()=" + sb);
        AiFeedBackManager aiFeedBackManager = AiFeedBackManager.f6560a;
        AiSummaryEntity aiSummaryEntity2 = this.g;
        String str2 = "";
        if (aiSummaryEntity2 == null || (str = aiSummaryEntity2.getRecognizeId()) == null) {
            str = str2;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        AiSummaryEntity aiSummaryEntity3 = this.g;
        if (!(aiSummaryEntity3 == null || (requestId = aiSummaryEntity3.getRequestId()) == null)) {
            str2 = requestId;
        }
        aiFeedBackManager.k(activity, new AiFeedBackRequest(2, str, sb2, str2), new SummaryViewModel$feedback$2(this));
    }

    public final AiSummaryEntity l() {
        return this.g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m(com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.upuphone.ar.transcribe.phone.vm.SummaryViewModel$getSummaryByDb$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.upuphone.ar.transcribe.phone.vm.SummaryViewModel$getSummaryByDb$1 r0 = (com.upuphone.ar.transcribe.phone.vm.SummaryViewModel$getSummaryByDb$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.transcribe.phone.vm.SummaryViewModel$getSummaryByDb$1 r0 = new com.upuphone.ar.transcribe.phone.vm.SummaryViewModel$getSummaryByDb$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r5) goto L_0x003d
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00fa
        L_0x0030:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00b1
        L_0x003d:
            java.lang.Object r7 = r0.L$2
            com.upuphone.ar.transcribe.phone.vm.SummaryViewModel r7 = (com.upuphone.ar.transcribe.phone.vm.SummaryViewModel) r7
            java.lang.Object r8 = r0.L$1
            com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean r8 = (com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean) r8
            java.lang.Object r2 = r0.L$0
            com.upuphone.ar.transcribe.phone.vm.SummaryViewModel r2 = (com.upuphone.ar.transcribe.phone.vm.SummaryViewModel) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0069
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.upuphone.ar.transcribe.phone.repo.TranscribeAiRepo r9 = r7.c
            java.lang.String r2 = r8.getRecognizeId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r7
            r0.label = r5
            java.lang.Object r9 = r9.p(r2, r0)
            if (r9 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r2 = r7
        L_0x0069:
            com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity r9 = (com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity) r9
            r7.g = r9
            com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity r7 = r2.g
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r5 = "getSummaryByDb db data: "
            r9.append(r5)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            java.lang.String r9 = "SummaryViewModel"
            com.upuphone.ar.transcribe.ext.LogExt.g(r7, r9)
            com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity r7 = r2.g
            r5 = 0
            if (r7 == 0) goto L_0x00b4
            java.lang.String r7 = r7.getSummary()
            if (r7 == 0) goto L_0x00b4
            int r7 = r7.length()
            if (r7 <= 0) goto L_0x00b4
            kotlinx.coroutines.flow.MutableSharedFlow r7 = r2.d
            com.upuphone.ar.transcribe.phone.vm.SummaryData$DbData r8 = new com.upuphone.ar.transcribe.phone.vm.SummaryData$DbData
            com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity r9 = r2.g
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            r8.<init>(r9)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r0.label = r4
            java.lang.Object r7 = r7.emit(r8, r0)
            if (r7 != r1) goto L_0x00b1
            return r1
        L_0x00b1:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x00b4:
            com.upuphone.ar.transcribe.phone.repo.TranscribeAiRepo r7 = r2.c
            java.lang.String r4 = r8.getRecognizeId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            boolean r7 = r7.t(r4)
            if (r7 == 0) goto L_0x00fd
            com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity r7 = r2.g
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "getSummaryByDb emit loading: "
            r4.append(r6)
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            com.upuphone.ar.transcribe.ext.LogExt.g(r7, r9)
            com.upuphone.ar.transcribe.phone.repo.TranscribeAiRepo r7 = r2.c
            java.lang.String r8 = r8.getRecognizeId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            com.upuphone.ar.transcribe.phone.repo.OnDataLoadListener r9 = r2.e
            r7.y(r8, r9)
            kotlinx.coroutines.flow.MutableSharedFlow r7 = r2.d
            com.upuphone.ar.transcribe.phone.vm.SummaryData$Loading r8 = com.upuphone.ar.transcribe.phone.vm.SummaryData.Loading.f6143a
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r7 = r7.emit(r8, r0)
            if (r7 != r1) goto L_0x00fa
            return r1
        L_0x00fa:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x00fd:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.vm.SummaryViewModel.m(com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void n(TranscribeBean transcribeBean) {
        Intrinsics.checkNotNullParameter(transcribeBean, "noteBean");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.b(), (CoroutineStart) null, new SummaryViewModel$getSummaryByServer$1(this, transcribeBean, (Continuation<? super SummaryViewModel$getSummaryByServer$1>) null), 2, (Object) null);
    }

    public final Flow p() {
        return this.f;
    }

    public final void s(String str) {
        Intrinsics.checkNotNullParameter(str, "rcId");
        this.c.x(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object t(com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.upuphone.ar.transcribe.phone.vm.SummaryViewModel$updateSummary$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.upuphone.ar.transcribe.phone.vm.SummaryViewModel$updateSummary$1 r0 = (com.upuphone.ar.transcribe.phone.vm.SummaryViewModel$updateSummary$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.transcribe.phone.vm.SummaryViewModel$updateSummary$1 r0 = new com.upuphone.ar.transcribe.phone.vm.SummaryViewModel$updateSummary$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            r5 = r4
            com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity r5 = (com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0046
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.upuphone.ar.transcribe.phone.repo.TranscribeAiRepo r4 = r4.c
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.A(r5, r0)
            if (r4 != r1) goto L_0x0046
            return r1
        L_0x0046:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "updateSummary summary="
            r4.append(r6)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "SummaryViewModel"
            com.upuphone.ar.transcribe.ext.LogExt.g(r4, r5)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.vm.SummaryViewModel.t(com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
