package com.upuphone.xr.sapp.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nDataStoreUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataStoreUtils.kt\ncom/upuphone/xr/sapp/utils/DataStoreUtils$getData$cache$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,279:1\n53#2:280\n55#2:284\n53#2:285\n55#2:289\n53#2:290\n55#2:294\n50#3:281\n55#3:283\n50#3:286\n55#3:288\n50#3:291\n55#3:293\n107#4:282\n107#4:287\n107#4:292\n*S KotlinDebug\n*F\n+ 1 DataStoreUtils.kt\ncom/upuphone/xr/sapp/utils/DataStoreUtils$getData$cache$1\n*L\n203#1:280\n203#1:284\n213#1:285\n213#1:289\n231#1:290\n231#1:294\n203#1:281\n203#1:283\n213#1:286\n213#1:288\n231#1:291\n231#1:293\n203#1:282\n213#1:287\n231#1:292\n*E\n"})
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.DataStoreUtils$getData$cache$1", f = "DataStoreUtils.kt", i = {0, 0, 1, 2}, l = {205, 215, 221, 233}, m = "invokeSuspend", n = {"$this$runBlocking", "mPreferencesKey", "mPreferencesKey", "data"}, s = {"L$0", "L$1", "L$0", "L$0"})
public final class DataStoreUtils$getData$cache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ boolean $associateUser;
    final /* synthetic */ Object $defaultValue;
    final /* synthetic */ String $key;
    final /* synthetic */ Context $mContext;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ DataStoreUtils this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataStoreUtils$getData$cache$1(Object obj, String str, boolean z, DataStoreUtils dataStoreUtils, Context context, Continuation<? super DataStoreUtils$getData$cache$1> continuation) {
        super(2, continuation);
        this.$defaultValue = obj;
        this.$key = str;
        this.$associateUser = z;
        this.this$0 = dataStoreUtils;
        this.$mContext = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DataStoreUtils$getData$cache$1 dataStoreUtils$getData$cache$1 = new DataStoreUtils$getData$cache$1(this.$defaultValue, this.$key, this.$associateUser, this.this$0, this.$mContext, continuation);
        dataStoreUtils$getData$cache$1.L$0 = obj;
        return dataStoreUtils$getData$cache$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0116 A[SYNTHETIC, Splitter:B:58:0x0116] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0191 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            java.lang.String r2 = "DataStoreUtils"
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L_0x0063
            if (r1 == r6) goto L_0x0045
            if (r1 == r5) goto L_0x002b
            if (r1 == r4) goto L_0x0024
            if (r1 != r3) goto L_0x001c
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x01ae
        L_0x001c:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0024:
            java.lang.Object r13 = r13.L$0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0190
        L_0x002b:
            java.lang.Object r1 = r13.L$4
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r3 = r13.L$3
            android.content.Context r3 = (android.content.Context) r3
            java.lang.Object r5 = r13.L$2
            com.upuphone.xr.sapp.utils.DataStoreUtils r5 = (com.upuphone.xr.sapp.utils.DataStoreUtils) r5
            java.lang.Object r8 = r13.L$1
            java.lang.Object r9 = r13.L$0
            androidx.datastore.preferences.core.Preferences$Key r9 = (androidx.datastore.preferences.core.Preferences.Key) r9
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0042 }
            goto L_0x013b
        L_0x0042:
            r14 = move-exception
            goto L_0x0144
        L_0x0045:
            java.lang.Object r1 = r13.L$5
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r3 = r13.L$4
            android.content.Context r3 = (android.content.Context) r3
            java.lang.Object r8 = r13.L$3
            com.upuphone.xr.sapp.utils.DataStoreUtils r8 = (com.upuphone.xr.sapp.utils.DataStoreUtils) r8
            java.lang.Object r9 = r13.L$2
            java.lang.Object r10 = r13.L$1
            androidx.datastore.preferences.core.Preferences$Key r10 = (androidx.datastore.preferences.core.Preferences.Key) r10
            java.lang.Object r11 = r13.L$0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0060 }
            goto L_0x00e4
        L_0x0060:
            r14 = move-exception
            goto L_0x00eb
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.Object r14 = r13.L$0
            kotlinx.coroutines.CoroutineScope r14 = (kotlinx.coroutines.CoroutineScope) r14
            java.lang.Object r1 = r13.$defaultValue
            boolean r8 = r1 instanceof java.lang.Integer
            if (r8 == 0) goto L_0x0078
            java.lang.String r1 = r13.$key
            androidx.datastore.preferences.core.Preferences$Key r1 = androidx.datastore.preferences.core.PreferencesKeys.d(r1)
        L_0x0076:
            r10 = r1
            goto L_0x00af
        L_0x0078:
            boolean r8 = r1 instanceof java.lang.Long
            if (r8 == 0) goto L_0x0083
            java.lang.String r1 = r13.$key
            androidx.datastore.preferences.core.Preferences$Key r1 = androidx.datastore.preferences.core.PreferencesKeys.e(r1)
            goto L_0x0076
        L_0x0083:
            boolean r8 = r1 instanceof java.lang.Double
            if (r8 == 0) goto L_0x008e
            java.lang.String r1 = r13.$key
            androidx.datastore.preferences.core.Preferences$Key r1 = androidx.datastore.preferences.core.PreferencesKeys.b(r1)
            goto L_0x0076
        L_0x008e:
            boolean r8 = r1 instanceof java.lang.Float
            if (r8 == 0) goto L_0x0099
            java.lang.String r1 = r13.$key
            androidx.datastore.preferences.core.Preferences$Key r1 = androidx.datastore.preferences.core.PreferencesKeys.c(r1)
            goto L_0x0076
        L_0x0099:
            boolean r8 = r1 instanceof java.lang.Boolean
            if (r8 == 0) goto L_0x00a4
            java.lang.String r1 = r13.$key
            androidx.datastore.preferences.core.Preferences$Key r1 = androidx.datastore.preferences.core.PreferencesKeys.a(r1)
            goto L_0x0076
        L_0x00a4:
            boolean r1 = r1 instanceof java.lang.String
            if (r1 == 0) goto L_0x01af
            java.lang.String r1 = r13.$key
            androidx.datastore.preferences.core.Preferences$Key r1 = androidx.datastore.preferences.core.PreferencesKeys.f(r1)
            goto L_0x0076
        L_0x00af:
            boolean r1 = r13.$associateUser
            if (r1 == 0) goto L_0x0192
            com.upuphone.xr.sapp.utils.DataStoreUtils r1 = r13.this$0
            androidx.datastore.core.DataStore r1 = r1.m()
            if (r1 == 0) goto L_0x0192
            java.lang.Object r9 = r13.$defaultValue
            com.upuphone.xr.sapp.utils.DataStoreUtils r8 = r13.this$0
            android.content.Context r3 = r13.$mContext
            java.lang.String r11 = r13.$key
            kotlin.Result$Companion r12 = kotlin.Result.Companion     // Catch:{ all -> 0x00e9 }
            kotlinx.coroutines.flow.Flow r1 = r1.getData()     // Catch:{ all -> 0x00e9 }
            com.upuphone.xr.sapp.utils.DataStoreUtils$getData$cache$1$invokeSuspend$lambda$6$lambda$1$$inlined$map$1 r12 = new com.upuphone.xr.sapp.utils.DataStoreUtils$getData$cache$1$invokeSuspend$lambda$6$lambda$1$$inlined$map$1     // Catch:{ all -> 0x00e9 }
            r12.<init>(r1, r10)     // Catch:{ all -> 0x00e9 }
            r13.L$0 = r14     // Catch:{ all -> 0x00e9 }
            r13.L$1 = r10     // Catch:{ all -> 0x00e9 }
            r13.L$2 = r9     // Catch:{ all -> 0x00e9 }
            r13.L$3 = r8     // Catch:{ all -> 0x00e9 }
            r13.L$4 = r3     // Catch:{ all -> 0x00e9 }
            r13.L$5 = r11     // Catch:{ all -> 0x00e9 }
            r13.label = r6     // Catch:{ all -> 0x00e9 }
            java.lang.Object r14 = kotlinx.coroutines.flow.FlowKt.w(r12, r13)     // Catch:{ all -> 0x00e9 }
            if (r14 != r0) goto L_0x00e3
            return r0
        L_0x00e3:
            r1 = r11
        L_0x00e4:
            java.lang.Object r14 = kotlin.Result.m20constructorimpl(r14)     // Catch:{ all -> 0x0060 }
            goto L_0x00f5
        L_0x00e9:
            r14 = move-exception
            r1 = r11
        L_0x00eb:
            kotlin.Result$Companion r11 = kotlin.Result.Companion
            java.lang.Object r14 = kotlin.ResultKt.createFailure(r14)
            java.lang.Object r14 = kotlin.Result.m20constructorimpl(r14)
        L_0x00f5:
            boolean r11 = kotlin.Result.m26isFailureimpl(r14)
            if (r11 == 0) goto L_0x00fc
            r14 = r7
        L_0x00fc:
            if (r14 == 0) goto L_0x0116
            com.upuphone.star.core.log.ULog$Delegate r13 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "查到用户空间下有值 "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            r13.a(r2, r0)
            return r14
        L_0x0116:
            androidx.datastore.core.DataStore r14 = r8.k(r3)     // Catch:{ all -> 0x0140 }
            kotlinx.coroutines.flow.Flow r14 = r14.getData()     // Catch:{ all -> 0x0140 }
            com.upuphone.xr.sapp.utils.DataStoreUtils$getData$cache$1$invokeSuspend$lambda$6$lambda$4$$inlined$map$1 r11 = new com.upuphone.xr.sapp.utils.DataStoreUtils$getData$cache$1$invokeSuspend$lambda$6$lambda$4$$inlined$map$1     // Catch:{ all -> 0x0140 }
            r11.<init>(r14, r10)     // Catch:{ all -> 0x0140 }
            r13.L$0 = r10     // Catch:{ all -> 0x0140 }
            r13.L$1 = r9     // Catch:{ all -> 0x0140 }
            r13.L$2 = r8     // Catch:{ all -> 0x0140 }
            r13.L$3 = r3     // Catch:{ all -> 0x0140 }
            r13.L$4 = r1     // Catch:{ all -> 0x0140 }
            r13.L$5 = r7     // Catch:{ all -> 0x0140 }
            r13.label = r5     // Catch:{ all -> 0x0140 }
            java.lang.Object r14 = kotlinx.coroutines.flow.FlowKt.w(r11, r13)     // Catch:{ all -> 0x0140 }
            if (r14 != r0) goto L_0x0138
            return r0
        L_0x0138:
            r5 = r8
            r8 = r9
            r9 = r10
        L_0x013b:
            java.lang.Object r14 = kotlin.Result.m20constructorimpl(r14)     // Catch:{ all -> 0x0042 }
            goto L_0x014e
        L_0x0140:
            r14 = move-exception
            r5 = r8
            r8 = r9
            r9 = r10
        L_0x0144:
            kotlin.Result$Companion r10 = kotlin.Result.Companion
            java.lang.Object r14 = kotlin.ResultKt.createFailure(r14)
            java.lang.Object r14 = kotlin.Result.m20constructorimpl(r14)
        L_0x014e:
            boolean r10 = kotlin.Result.m26isFailureimpl(r14)
            if (r10 == 0) goto L_0x0155
            r14 = r7
        L_0x0155:
            if (r14 == 0) goto L_0x0191
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "查到默认空间下有值 "
            r10.append(r11)
            r10.append(r14)
            java.lang.String r10 = r10.toString()
            r8.a(r2, r10)
            r5.p(r1, r14, r6)
            androidx.datastore.core.DataStore r1 = r5.k(r3)
            com.upuphone.xr.sapp.utils.DataStoreUtils$getData$cache$1$1$4$1 r2 = new com.upuphone.xr.sapp.utils.DataStoreUtils$getData$cache$1$1$4$1
            r2.<init>(r9, r7)
            r13.L$0 = r14
            r13.L$1 = r7
            r13.L$2 = r7
            r13.L$3 = r7
            r13.L$4 = r7
            r13.L$5 = r7
            r13.label = r4
            java.lang.Object r13 = androidx.datastore.preferences.core.PreferencesKt.a(r1, r2, r13)
            if (r13 != r0) goto L_0x018f
            return r0
        L_0x018f:
            r13 = r14
        L_0x0190:
            return r13
        L_0x0191:
            return r8
        L_0x0192:
            com.upuphone.xr.sapp.utils.DataStoreUtils r14 = r13.this$0
            android.content.Context r1 = r13.$mContext
            androidx.datastore.core.DataStore r14 = r14.k(r1)
            kotlinx.coroutines.flow.Flow r14 = r14.getData()
            java.lang.Object r1 = r13.$defaultValue
            com.upuphone.xr.sapp.utils.DataStoreUtils$getData$cache$1$invokeSuspend$$inlined$map$1 r2 = new com.upuphone.xr.sapp.utils.DataStoreUtils$getData$cache$1$invokeSuspend$$inlined$map$1
            r2.<init>(r14, r10, r1)
            r13.label = r3
            java.lang.Object r14 = kotlinx.coroutines.flow.FlowKt.w(r2, r13)
            if (r14 != r0) goto L_0x01ae
            return r0
        L_0x01ae:
            return r14
        L_0x01af:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "This type can be get into DataStore"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.DataStoreUtils$getData$cache$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<Object> continuation) {
        return ((DataStoreUtils$getData$cache$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
