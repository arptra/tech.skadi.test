package com.upuphone.xr.sapp.glass;

import com.honey.account.constant.AccountConstantKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.entity.BasicGlassInfo;
import com.upuphone.xr.sapp.entity.DeviceCompatConfig;
import com.upuphone.xr.sapp.entity.DeviceCompatInfo;
import com.upuphone.xr.sapp.utils.DateUtil;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nGlassCompatHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassCompatHelper.kt\ncom/upuphone/xr/sapp/glass/GlassCompatHelper$handleCompatInfo$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,275:1\n288#2:276\n289#2:278\n1#3:277\n*S KotlinDebug\n*F\n+ 1 GlassCompatHelper.kt\ncom/upuphone/xr/sapp/glass/GlassCompatHelper$handleCompatInfo$1\n*L\n222#1:276\n222#1:278\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassCompatHelper$handleCompatInfo$1", f = "GlassCompatHelper.kt", i = {}, l = {213}, m = "invokeSuspend", n = {}, s = {})
public final class GlassCompatHelper$handleCompatInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeviceCompatInfo $compatInfo;
    final /* synthetic */ BasicGlassInfo $glassInfo;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassCompatHelper$handleCompatInfo$1(DeviceCompatInfo deviceCompatInfo, BasicGlassInfo basicGlassInfo, Continuation<? super GlassCompatHelper$handleCompatInfo$1> continuation) {
        super(2, continuation);
        this.$compatInfo = deviceCompatInfo;
        this.$glassInfo = basicGlassInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassCompatHelper$handleCompatInfo$1(this.$compatInfo, this.$glassInfo, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String minDeviceVersion;
        String maxDeviceVersion;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.b(500, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (StaticMethodUtilsKt.n(179)) {
            ULog.f6446a.a("GlassCompatHelper", "handleCompatInfo, isWindowShowing=true");
            return Unit.INSTANCE;
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassCompatHelper", "handleCompatInfo: " + this.$compatInfo + ", glassInfo: " + this.$glassInfo);
        String d = GlassInfoExtKt.d(this.$glassInfo.getRomVersion());
        StringBuilder sb = new StringBuilder();
        sb.append("handleCompatInfo, glassRomVersion: ");
        sb.append(d);
        delegate.a("GlassCompatHelper", sb.toString());
        List<DeviceCompatConfig> deviceVersionList = this.$compatInfo.getDeviceVersionList();
        T t = null;
        if (deviceVersionList != null) {
            BasicGlassInfo basicGlassInfo = this.$glassInfo;
            Iterator<T> it = deviceVersionList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                DeviceCompatConfig deviceCompatConfig = (DeviceCompatConfig) next;
                if (Intrinsics.areEqual((Object) deviceCompatConfig.getDeviceType(), (Object) basicGlassInfo.getModel()) && (minDeviceVersion = deviceCompatConfig.getMinDeviceVersion()) != null && GlassInfoExtKt.j(minDeviceVersion, d) <= 0 && (maxDeviceVersion = deviceCompatConfig.getMaxDeviceVersion()) != null && GlassInfoExtKt.j(maxDeviceVersion, d) >= 0) {
                    t = next;
                    break;
                }
            }
            t = (DeviceCompatConfig) t;
        }
        ULog.Delegate delegate2 = ULog.f6446a;
        delegate2.a("GlassCompatHelper", "handleCompatInfo, versionConfig: " + t);
        if (t == null) {
            return Unit.INSTANCE;
        }
        String str = "GlassCompatHelper_" + this.$glassInfo.getSerial() + AccountConstantKt.DEFAULT_SEGMENT + d + "_compatDialogShownDay";
        String str2 = "GlassCompatHelper_" + this.$glassInfo.getSerial() + AccountConstantKt.DEFAULT_SEGMENT + d + "_compatDialogShownCount";
        SdkContext sdkContext = SdkContext.f6675a;
        String str3 = (String) sdkContext.a().d(str, "");
        String a2 = DateUtil.f7876a.a();
        int intValue = !Intrinsics.areEqual((Object) str3, (Object) a2) ? 0 : ((Number) sdkContext.a().d(str2, Boxing.boxInt(0))).intValue();
        delegate2.a("GlassCompatHelper", "handleCompatInfo, today: " + a2 + ", shownDay: " + str3 + ", shownCount: " + intValue);
        Integer popLimit = t.getPopLimit();
        int intValue2 = popLimit != null ? popLimit.intValue() : 3;
        if (intValue >= intValue2) {
            delegate2.a("GlassCompatHelper", "handleCompatInfo, shownCount:(" + intValue + ") reach max popLimit(" + intValue2 + ") at: " + a2);
            return Unit.INSTANCE;
        } else if (!GlassUpdateHelper.b.B0()) {
            delegate2.a("GlassCompatHelper", "handleCompatInfo, glassRomReady=false");
            return Unit.INSTANCE;
        } else {
            Integer upgradeModalStatus = t.getUpgradeModalStatus();
            if (upgradeModalStatus != null && upgradeModalStatus.intValue() == 1) {
                sdkContext.a().c(str, a2);
                sdkContext.a().c(str2, Boxing.boxInt(intValue + 1));
                GlassCompatHelper.i = false;
                CompatibilityManager.INSTANCE.showInCompatDialog(true);
            } else {
                Integer upgradeModalStatus2 = t.getUpgradeModalStatus();
                if (upgradeModalStatus2 != null && upgradeModalStatus2.intValue() == 2) {
                    sdkContext.a().c(str, a2);
                    sdkContext.a().c(str2, Boxing.boxInt(intValue + 1));
                    GlassCompatHelper.i = false;
                    CompatibilityManager.INSTANCE.showInCompatDialog(false);
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassCompatHelper$handleCompatInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
