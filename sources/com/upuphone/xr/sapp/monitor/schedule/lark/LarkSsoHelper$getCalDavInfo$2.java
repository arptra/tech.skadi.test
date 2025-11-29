package com.upuphone.xr.sapp.monitor.schedule.lark;

import android.app.Activity;
import com.meizu.common.app.LoadingDialog;
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

@SourceDebugExtension({"SMAP\nLarkSsoHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LarkSsoHelper.kt\ncom/upuphone/xr/sapp/monitor/schedule/lark/LarkSsoHelper$getCalDavInfo$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,163:1\n288#2,2:164\n*S KotlinDebug\n*F\n+ 1 LarkSsoHelper.kt\ncom/upuphone/xr/sapp/monitor/schedule/lark/LarkSsoHelper$getCalDavInfo$2\n*L\n96#1:164,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.schedule.lark.LarkSsoHelper$getCalDavInfo$2", f = "LarkSsoHelper.kt", i = {}, l = {86, 118, 141}, m = "invokeSuspend", n = {}, s = {})
public final class LarkSsoHelper$getCalDavInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $code;
    final /* synthetic */ Activity $context;
    final /* synthetic */ LoadingDialog $loading;
    int label;
    final /* synthetic */ LarkSsoHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LarkSsoHelper$getCalDavInfo$2(String str, LoadingDialog loadingDialog, Activity activity, LarkSsoHelper larkSsoHelper, Continuation<? super LarkSsoHelper$getCalDavInfo$2> continuation) {
        super(2, continuation);
        this.$code = str;
        this.$loading = loadingDialog;
        this.$context = activity;
        this.this$0 = larkSsoHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LarkSsoHelper$getCalDavInfo$2(this.$code, this.$loading, this.$context, this.this$0, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0027
            if (r2 == r5) goto L_0x0021
            if (r2 == r4) goto L_0x001c
            if (r2 != r3) goto L_0x0014
            goto L_0x001c
        L_0x0014:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r21)
            goto L_0x0161
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r21)
            r2 = r21
            goto L_0x0047
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r21)
            com.upuphone.xr.sapp.monitor.schedule.ScheduleRequestManager r2 = com.upuphone.xr.sapp.monitor.schedule.ScheduleRequestManager.f7781a
            com.upuphone.xr.sapp.monitor.schedule.request.ScheduleApi r2 = r2.c()
            com.upuphone.xr.sapp.monitor.schedule.config.ScheduleConfig r6 = com.upuphone.xr.sapp.monitor.schedule.config.ScheduleConfig.f7785a
            com.upuphone.xr.sapp.monitor.schedule.config.LarkType r6 = r6.a()
            java.lang.String r6 = r6.name()
            java.lang.String r7 = r0.$code
            r0.label = r5
            java.lang.String r8 = "feishu"
            java.lang.Object r2 = r2.getToken(r6, r7, r8, r0)
            if (r2 != r1) goto L_0x0047
            return r1
        L_0x0047:
            com.upuphone.xr.sapp.monitor.schedule.model.BaseResp r2 = (com.upuphone.xr.sapp.monitor.schedule.model.BaseResp) r2
            com.upuphone.star.core.log.ULog$Delegate r6 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.Object r7 = r2.b()
            com.upuphone.xr.sapp.monitor.schedule.model.TokenRespModel r7 = (com.upuphone.xr.sapp.monitor.schedule.model.TokenRespModel) r7
            com.upuphone.xr.sapp.monitor.schedule.model.TokenRespModel$UserFsAccessTokenPO r7 = r7.getUserFsAccessTokenPO()
            r8 = 0
            if (r7 == 0) goto L_0x005d
            java.lang.String r7 = r7.getUserId()
            goto L_0x005e
        L_0x005d:
            r7 = r8
        L_0x005e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "getCalDavInfo "
            r9.append(r10)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            java.lang.String r9 = "Schedule-LarkSsoHelper"
            r6.a(r9, r7)
            java.lang.Object r2 = r2.b()
            com.upuphone.xr.sapp.monitor.schedule.model.TokenRespModel r2 = (com.upuphone.xr.sapp.monitor.schedule.model.TokenRespModel) r2
            com.upuphone.xr.sapp.monitor.schedule.model.TokenRespModel$UserFsAccessTokenPO r2 = r2.getUserFsAccessTokenPO()
            if (r2 == 0) goto L_0x014b
            com.upuphone.xr.sapp.monitor.schedule.ScheduleAccountManager r3 = com.upuphone.xr.sapp.monitor.schedule.ScheduleAccountManager.f7776a
            java.util.List r3 = r3.e()
            java.util.Iterator r3 = r3.iterator()
        L_0x008a:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x00a6
            java.lang.Object r6 = r3.next()
            r7 = r6
            com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel r7 = (com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel) r7
            java.lang.String r7 = r7.c()
            java.lang.String r9 = r2.getUserId()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r9)
            if (r7 == 0) goto L_0x008a
            r8 = r6
        L_0x00a6:
            r12 = r8
            com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel r12 = (com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel) r12
            r3 = 0
            if (r12 != 0) goto L_0x00f3
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r6 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r13 = r6.a()
            java.lang.Integer r15 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            r17 = 4
            r18 = 0
            java.lang.String r14 = "FS_BIND_SIZE"
            r16 = 0
            java.lang.Object r7 = com.upuphone.xr.sapp.utils.DataStoreUtils.i(r13, r14, r15, r16, r17, r18)
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            if (r7 != 0) goto L_0x00cd
            java.lang.String r8 = ""
            goto L_0x00d1
        L_0x00cd:
            java.lang.String r8 = java.lang.String.valueOf(r7)
        L_0x00d1:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "飞书日程"
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.upuphone.xr.sapp.utils.DataStoreUtils r6 = r6.a()
            int r7 = r7 + r5
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            java.lang.String r9 = "FS_BIND_SIZE"
            r6.o(r9, r7)
        L_0x00f1:
            r15 = r8
            goto L_0x00f8
        L_0x00f3:
            java.lang.String r8 = r12.b()
            goto L_0x00f1
        L_0x00f8:
            com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel r10 = new com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel
            java.lang.String r14 = r2.getUserId()
            if (r12 == 0) goto L_0x010a
            java.lang.String r6 = r12.a()
            if (r6 != 0) goto L_0x0107
            goto L_0x010a
        L_0x0107:
            r16 = r6
            goto L_0x010d
        L_0x010a:
            java.lang.String r6 = "#FA5700"
            goto L_0x0107
        L_0x010d:
            if (r12 == 0) goto L_0x0118
            boolean r6 = r12.f()
            if (r6 == 0) goto L_0x0118
            r17 = r5
            goto L_0x011a
        L_0x0118:
            r17 = r3
        L_0x011a:
            com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType r18 = com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType.feishu
            com.upuphone.xr.sapp.monitor.schedule.model.RemoteCalendarModel r3 = new com.upuphone.xr.sapp.monitor.schedule.model.RemoteCalendarModel
            java.lang.String r5 = r2.getAccessToken()
            java.lang.String r6 = r2.getRefreshToken()
            java.lang.String r2 = r2.getUserId()
            r3.<init>(r5, r6, r2)
            r13 = r10
            r19 = r3
            r13.<init>(r14, r15, r16, r17, r18, r19)
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.xr.sapp.monitor.schedule.lark.LarkSsoHelper$getCalDavInfo$2$1 r3 = new com.upuphone.xr.sapp.monitor.schedule.lark.LarkSsoHelper$getCalDavInfo$2$1
            com.meizu.common.app.LoadingDialog r11 = r0.$loading
            android.app.Activity r13 = r0.$context
            r14 = 0
            r9 = r3
            r9.<init>(r10, r11, r12, r13, r14)
            r0.label = r4
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.g(r2, r3, r0)
            if (r0 != r1) goto L_0x0161
            return r1
        L_0x014b:
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.xr.sapp.monitor.schedule.lark.LarkSsoHelper$getCalDavInfo$2$2 r4 = new com.upuphone.xr.sapp.monitor.schedule.lark.LarkSsoHelper$getCalDavInfo$2$2
            com.upuphone.xr.sapp.monitor.schedule.lark.LarkSsoHelper r5 = r0.this$0
            android.app.Activity r6 = r0.$context
            r4.<init>(r5, r6, r8)
            r0.label = r3
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.g(r2, r4, r0)
            if (r0 != r1) goto L_0x0161
            return r1
        L_0x0161:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.schedule.lark.LarkSsoHelper$getCalDavInfo$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LarkSsoHelper$getCalDavInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
