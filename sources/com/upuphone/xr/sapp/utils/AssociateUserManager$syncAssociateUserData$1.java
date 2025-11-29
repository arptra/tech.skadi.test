package com.upuphone.xr.sapp.utils;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.AssociateUserManager$syncAssociateUserData$1", f = "AssociateUserManager.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
public final class AssociateUserManager$syncAssociateUserData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AssociateUserManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AssociateUserManager$syncAssociateUserData$1(AssociateUserManager associateUserManager, Continuation<? super AssociateUserManager$syncAssociateUserData$1> continuation) {
        super(2, continuation);
        this.this$0 = associateUserManager;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AssociateUserManager$syncAssociateUserData$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.b(3000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Object obj2 = new JSONObject(DynamicOperateUtil.n(DynamicOperateUtil.f7880a, (String) null, 1, (Object) null)).get("added");
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to("change_dock_items", (String) obj2));
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        ArrayList arrayListOf = CollectionsKt.arrayListOf(hashMapOf, MapsKt.hashMapOf(TuplesKt.to("set_standby_position", DataStoreUtils.j(companion.a(), "set_standby_position", Boxing.boxInt(4), true, (Context) null, 8, (Object) null))), MapsKt.hashMapOf(TuplesKt.to("set_auto_brightness_mode", DataStoreUtils.j(companion.a(), "set_auto_brightness_mode", Boxing.boxBoolean(true), true, (Context) null, 8, (Object) null))), MapsKt.hashMapOf(TuplesKt.to("brightness_model", DataStoreUtils.j(companion.a(), "brightness_model", "sunrise", true, (Context) null, 8, (Object) null))), MapsKt.hashMapOf(TuplesKt.to("set_screen_off_time", DataStoreUtils.j(companion.a(), "set_screen_off_time", Boxing.boxInt(30), true, (Context) null, 8, (Object) null))), MapsKt.hashMapOf(TuplesKt.to("set_zen_mode", DataStoreUtils.j(companion.a(), "set_zen_mode", Boxing.boxBoolean(false), true, (Context) null, 8, (Object) null))), MapsKt.hashMapOf(TuplesKt.to("set_glass_sound_effect_mode", DataStoreUtils.j(companion.a(), "set_glass_sound_effect_mode", Boxing.boxBoolean(true), true, (Context) null, 8, (Object) null))), MapsKt.hashMapOf(TuplesKt.to("set_hear_impairment_mode", DataStoreUtils.j(companion.a(), "hearing_assist_status", Boxing.boxBoolean(false), true, (Context) null, 8, (Object) null))), MapsKt.hashMapOf(TuplesKt.to("set_app_fast_open", DataStoreUtils.j(companion.a(), "set_app_fast_open", "com.upuphone.ar.recorder", true, (Context) null, 8, (Object) null))), MapsKt.hashMapOf(TuplesKt.to("set_music_tp_control_mode", DataStoreUtils.j(companion.a(), "set_music_tp_control_mode", Boxing.boxBoolean(false), true, (Context) null, 8, (Object) null))), MapsKt.hashMapOf(TuplesKt.to("set_font_mode", DataStoreUtils.j(companion.a(), "set_font_mode", Boxing.boxInt(1), true, (Context) null, 8, (Object) null))));
        arrayListOf.add(MapsKt.hashMapOf(TuplesKt.to("set_wear_detection_mode", DataStoreUtils.j(companion.a(), "set_wear_detection_mode", Boxing.boxBoolean(true ^ InterconnectManager.getInstance().getStarryNetDeviceManager().isAir()), true, (Context) null, 8, (Object) null))));
        ControlUtils controlUtils = ControlUtils.f7858a;
        String packageName = GlobalExtKt.f().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        final AssociateUserManager associateUserManager = this.this$0;
        controlUtils.v0(packageName, arrayListOf, new SendMessageListener() {
            public void onFail(@Nullable String str, int i) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.c("AssociateUserManager", "send syncAssociateUserData onFail" + i);
                if (associateUserManager.b < 3) {
                    associateUserManager.f();
                    AssociateUserManager associateUserManager = associateUserManager;
                    associateUserManager.b = associateUserManager.b + 1;
                }
            }

            public void onSuccess(@Nullable String str) {
            }
        });
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AssociateUserManager$syncAssociateUserData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
