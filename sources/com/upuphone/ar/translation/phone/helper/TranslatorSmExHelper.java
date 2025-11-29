package com.upuphone.ar.translation.phone.helper;

import android.content.Context;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.xjsd.xr.sapp.asr.SmartExtractionHelper;
import com.xjsd.xr.sapp.asr.callback.SmartExCallback;
import com.xjsd.xr.sapp.asr.dao.SmartExSummary;
import com.xjsd.xr.sapp.asr.dao.SmartExTodo;
import com.xjsd.xr.sapp.asr.dao.SmartExtractionConfig;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u000212B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010!\u001a\u00020 *\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020 0'8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R \u0010/\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020,0+8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/TranslatorSmExHelper;", "", "<init>", "()V", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "noteBean", "", "e", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "Landroid/content/Context;", "context", "f", "(Landroid/content/Context;Lcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "", "type", "Lcom/xjsd/xr/sapp/asr/callback/SmartExCallback;", "callback", "h", "(ILcom/upuphone/ar/translation/phone/bean/NoteBean;Lcom/xjsd/xr/sapp/asr/callback/SmartExCallback;)V", "j", "(ILcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "", "g", "(ILcom/upuphone/ar/translation/phone/bean/NoteBean;)Z", "Lcom/xjsd/xr/sapp/asr/dao/SmartExSummary;", "resSummary", "k", "(Lcom/xjsd/xr/sapp/asr/dao/SmartExSummary;Lcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "Lcom/xjsd/xr/sapp/asr/dao/SmartExTodo;", "exTodo", "l", "(Landroid/content/Context;Lcom/xjsd/xr/sapp/asr/dao/SmartExTodo;Lcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "", "i", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;I)Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineScope;", "a", "Lkotlinx/coroutines/CoroutineScope;", "mIoScope", "", "b", "Ljava/util/List;", "mTaskIds", "", "Lcom/xjsd/xr/sapp/asr/callback/ISmartExCallback;", "c", "Ljava/util/Map;", "mCallbackMap", "d", "Companion", "TaskType", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranslatorSmExHelper {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineScope f6311a = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    public final List b = new ArrayList();
    public final Map c = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/TranslatorSmExHelper$Companion;", "", "()V", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/TranslatorSmExHelper$TaskType;", "", "<init>", "()V", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface TaskType {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/TranslatorSmExHelper$TaskType$Companion;", "", "<init>", "()V", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ Companion f6312a = new Companion();
        }
    }

    public final void e(NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        String i = i(noteBean, 1);
        LogExt.j("getSummary taskId=" + i, "TranslatorSmExHelper");
        if (this.b.contains(i)) {
            LogExt.j("getSummary 正在提取概要总结，请勿重复提取", "TranslatorSmExHelper");
            return;
        }
        this.b.add(i);
        SmartExtractionHelper smartExtractionHelper = new SmartExtractionHelper(TranslatorConstants.SOCKET_ASR_APP_NAME);
        smartExtractionHelper.registerCallback(new TranslatorSmExHelper$getSummary$helper$1$1(this, i, noteBean));
        smartExtractionHelper.getSummary(new SmartExtractionConfig(noteBean.getRecognizeId(), 1));
    }

    public final void f(Context context, NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        String i = i(noteBean, 2);
        LogExt.j("getTodos taskId=" + i, "TranslatorSmExHelper");
        if (this.b.contains(i)) {
            LogExt.j("getTodos 正在提取待办事项，请勿重复提取", "TranslatorSmExHelper");
            return;
        }
        this.b.add(i);
        SmartExtractionHelper smartExtractionHelper = new SmartExtractionHelper(TranslatorConstants.SOCKET_ASR_APP_NAME);
        smartExtractionHelper.registerCallback(new TranslatorSmExHelper$getTodos$helper$1$1(this, i, context, noteBean));
        smartExtractionHelper.getTodo(new SmartExtractionConfig(noteBean.getRecognizeId(), 1));
    }

    public final boolean g(int i, NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        String i2 = i(noteBean, i);
        LogExt.j("isTaskRunning taskId=" + i2, "TranslatorSmExHelper");
        return this.b.contains(i2);
    }

    public final void h(int i, NoteBean noteBean, SmartExCallback smartExCallback) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        Intrinsics.checkNotNullParameter(smartExCallback, "callback");
        String i2 = i(noteBean, i);
        LogExt.j("registerSmartExCallback taskId=" + i2, "TranslatorSmExHelper");
        if (this.c.containsKey(i2)) {
            LogExt.j("registerSmartExCallback 请勿重复注册回调", "TranslatorSmExHelper");
        } else {
            this.c.put(i2, smartExCallback);
        }
    }

    public final String i(NoteBean noteBean, int i) {
        String recognizeId = noteBean.getRecognizeId();
        return recognizeId + "#" + i;
    }

    public final void j(int i, NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        String i2 = i(noteBean, i);
        LogExt.j("unRegisterSmartExCallback taskId=" + i2, "TranslatorSmExHelper");
        if (!this.c.containsKey(i2)) {
            LogExt.j("unRegisterSmartExCallback 未注册的回调无需释放", "TranslatorSmExHelper");
        } else {
            this.c.remove(i2);
        }
    }

    public final void k(SmartExSummary smartExSummary, NoteBean noteBean) {
        if (smartExSummary.getBaseStatus() == 0) {
            Job unused = BuildersKt__Builders_commonKt.d(this.f6311a, (CoroutineContext) null, (CoroutineStart) null, new TranslatorSmExHelper$writeSummaryToDb$1(smartExSummary, noteBean, (Continuation<? super TranslatorSmExHelper$writeSummaryToDb$1>) null), 3, (Object) null);
        }
    }

    public final void l(Context context, SmartExTodo smartExTodo, NoteBean noteBean) {
        if (smartExTodo.getBaseStatus() == 0) {
            Job unused = BuildersKt__Builders_commonKt.d(this.f6311a, (CoroutineContext) null, (CoroutineStart) null, new TranslatorSmExHelper$writeTodosToDb$1(smartExTodo, context, noteBean, (Continuation<? super TranslatorSmExHelper$writeTodosToDb$1>) null), 3, (Object) null);
        }
    }
}
