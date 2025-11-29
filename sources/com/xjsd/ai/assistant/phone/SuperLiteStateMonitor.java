package com.xjsd.ai.assistant.phone;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH@¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH@¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/xjsd/ai/assistant/phone/SuperLiteStateMonitor;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "f", "(Landroid/content/Context;)V", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "dataStore", "Landroidx/datastore/preferences/core/Preferences$Key;", "key", "Lkotlinx/coroutines/flow/Flow;", "", "c", "(Landroidx/datastore/core/DataStore;Landroidx/datastore/preferences/core/Preferences$Key;)Lkotlinx/coroutines/flow/Flow;", "e", "(Landroidx/datastore/core/DataStore;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSuperLiteStateMonitor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperLiteStateMonitor.kt\ncom/xjsd/ai/assistant/phone/SuperLiteStateMonitor\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,110:1\n53#2:111\n55#2:115\n53#2:116\n55#2:120\n53#2:121\n55#2:125\n50#3:112\n55#3:114\n50#3:117\n55#3:119\n50#3:122\n55#3:124\n106#4:113\n106#4:118\n106#4:123\n*S KotlinDebug\n*F\n+ 1 SuperLiteStateMonitor.kt\ncom/xjsd/ai/assistant/phone/SuperLiteStateMonitor\n*L\n70#1:111\n70#1:115\n84#1:116\n84#1:120\n102#1:121\n102#1:125\n70#1:112\n70#1:114\n84#1:117\n84#1:119\n102#1:122\n102#1:124\n70#1:113\n84#1:118\n102#1:123\n*E\n"})
public final class SuperLiteStateMonitor {

    /* renamed from: a  reason: collision with root package name */
    public static final SuperLiteStateMonitor f8526a = new SuperLiteStateMonitor();

    public final Flow c(DataStore dataStore, Preferences.Key key) {
        return new SuperLiteStateMonitor$isKeyExists$$inlined$map$1(FlowKt.g(dataStore.getData(), new SuperLiteStateMonitor$isKeyExists$1((Continuation<? super SuperLiteStateMonitor$isKeyExists$1>) null)), key);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00af A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(androidx.datastore.core.DataStore r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorAssistantPrivacyAgreementState$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorAssistantPrivacyAgreementState$1 r0 = (com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorAssistantPrivacyAgreementState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorAssistantPrivacyAgreementState$1 r0 = new com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorAssistantPrivacyAgreementState$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0051
            if (r2 == r5) goto L_0x0045
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00b0
        L_0x0031:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0039:
            java.lang.Object r8 = r0.L$1
            androidx.datastore.preferences.core.Preferences$Key r8 = (androidx.datastore.preferences.core.Preferences.Key) r8
            java.lang.Object r9 = r0.L$0
            androidx.datastore.core.DataStore r9 = (androidx.datastore.core.DataStore) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x008f
        L_0x0045:
            java.lang.Object r8 = r0.L$1
            androidx.datastore.preferences.core.Preferences$Key r8 = (androidx.datastore.preferences.core.Preferences.Key) r8
            java.lang.Object r9 = r0.L$0
            androidx.datastore.core.DataStore r9 = (androidx.datastore.core.DataStore) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006e
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.String r10 = "privacy_argreement_key_ai_asst"
            androidx.datastore.preferences.core.Preferences$Key r10 = androidx.datastore.preferences.core.PreferencesKeys.a(r10)
            kotlinx.coroutines.flow.Flow r8 = r8.c(r9, r10)
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r5
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.w(r8, r0)
            if (r8 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r7 = r10
            r10 = r8
            r8 = r7
        L_0x006e:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x008f
            java.lang.String r10 = "SuperLiteStateMonitor"
            java.lang.String r2 = "monitorAssistantPrivacyAgreementState: 读取值为空，存入默认值false"
            com.xjsd.ai.assistant.log.ILog.a(r10, r2)
            com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorAssistantPrivacyAgreementState$2 r10 = new com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorAssistantPrivacyAgreementState$2
            r10.<init>(r8, r6)
            r0.L$0 = r9
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r10 = androidx.datastore.preferences.core.PreferencesKt.a(r9, r10, r0)
            if (r10 != r1) goto L_0x008f
            return r1
        L_0x008f:
            kotlinx.coroutines.flow.Flow r9 = r9.getData()
            com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorAssistantPrivacyAgreementState$$inlined$map$1 r10 = new com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorAssistantPrivacyAgreementState$$inlined$map$1
            r10.<init>(r9, r8)
            com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorAssistantPrivacyAgreementState$4 r8 = new com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorAssistantPrivacyAgreementState$4
            r8.<init>(r6)
            kotlinx.coroutines.flow.Flow r8 = kotlinx.coroutines.flow.FlowKt.g(r10, r8)
            com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorAssistantPrivacyAgreementState$5 r9 = com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorAssistantPrivacyAgreementState$5.f8533a
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r8 = r8.collect(r9, r0)
            if (r8 != r1) goto L_0x00b0
            return r1
        L_0x00b0:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.SuperLiteStateMonitor.d(androidx.datastore.core.DataStore, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00af A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(androidx.datastore.core.DataStore r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorNavPrivacyAgreementState$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorNavPrivacyAgreementState$1 r0 = (com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorNavPrivacyAgreementState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorNavPrivacyAgreementState$1 r0 = new com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorNavPrivacyAgreementState$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0051
            if (r2 == r5) goto L_0x0045
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00b0
        L_0x0031:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0039:
            java.lang.Object r8 = r0.L$1
            androidx.datastore.preferences.core.Preferences$Key r8 = (androidx.datastore.preferences.core.Preferences.Key) r8
            java.lang.Object r9 = r0.L$0
            androidx.datastore.core.DataStore r9 = (androidx.datastore.core.DataStore) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x008f
        L_0x0045:
            java.lang.Object r8 = r0.L$1
            androidx.datastore.preferences.core.Preferences$Key r8 = (androidx.datastore.preferences.core.Preferences.Key) r8
            java.lang.Object r9 = r0.L$0
            androidx.datastore.core.DataStore r9 = (androidx.datastore.core.DataStore) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006e
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.String r10 = "privacy_argreement_key_ar_navi"
            androidx.datastore.preferences.core.Preferences$Key r10 = androidx.datastore.preferences.core.PreferencesKeys.a(r10)
            kotlinx.coroutines.flow.Flow r8 = r8.c(r9, r10)
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r5
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.w(r8, r0)
            if (r8 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r7 = r10
            r10 = r8
            r8 = r7
        L_0x006e:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x008f
            java.lang.String r10 = "SuperLiteStateMonitor"
            java.lang.String r2 = "monitorNavPrivacyAgreementState: 读取值为空，存入默认值false"
            com.xjsd.ai.assistant.log.ILog.a(r10, r2)
            com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorNavPrivacyAgreementState$2 r10 = new com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorNavPrivacyAgreementState$2
            r10.<init>(r8, r6)
            r0.L$0 = r9
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r10 = androidx.datastore.preferences.core.PreferencesKt.a(r9, r10, r0)
            if (r10 != r1) goto L_0x008f
            return r1
        L_0x008f:
            kotlinx.coroutines.flow.Flow r9 = r9.getData()
            com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorNavPrivacyAgreementState$$inlined$map$1 r10 = new com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorNavPrivacyAgreementState$$inlined$map$1
            r10.<init>(r9, r8)
            com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorNavPrivacyAgreementState$4 r8 = new com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorNavPrivacyAgreementState$4
            r8.<init>(r6)
            kotlinx.coroutines.flow.Flow r8 = kotlinx.coroutines.flow.FlowKt.g(r10, r8)
            com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorNavPrivacyAgreementState$5 r9 = com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorNavPrivacyAgreementState$5.f8534a
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r8 = r8.collect(r9, r0)
            if (r8 != r1) goto L_0x00b0
            return r1
        L_0x00b0:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.SuperLiteStateMonitor.e(androidx.datastore.core.DataStore, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.b(), (CoroutineContext) null, (CoroutineStart) null, new SuperLiteStateMonitor$start$1((Continuation<? super SuperLiteStateMonitor$start$1>) null), 3, (Object) null);
        Job unused2 = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new SuperLiteStateMonitor$start$2((Continuation<? super SuperLiteStateMonitor$start$2>) null), 3, (Object) null);
    }
}
