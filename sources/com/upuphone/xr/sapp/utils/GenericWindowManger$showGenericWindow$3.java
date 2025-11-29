package com.upuphone.xr.sapp.utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.upuphone.xr.sapp.view.SuperGenericWindowView;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nGenericWindowManger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GenericWindowManger.kt\ncom/upuphone/xr/sapp/utils/GenericWindowManger$showGenericWindow$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,662:1\n1855#2,2:663\n*S KotlinDebug\n*F\n+ 1 GenericWindowManger.kt\ncom/upuphone/xr/sapp/utils/GenericWindowManger$showGenericWindow$3\n*L\n602#1:663,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.GenericWindowManger$showGenericWindow$3", f = "GenericWindowManger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GenericWindowManger$showGenericWindow$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ boolean $backKeyDismiss;
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ SuperGenericWindowView.IActionCallback $callback;
    final /* synthetic */ HashMap<Integer, Object> $extras;
    final /* synthetic */ ArrayList<Integer> $notices;
    final /* synthetic */ boolean $touchOutsideDismiss;
    int label;
    final /* synthetic */ GenericWindowManger this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericWindowManger$showGenericWindow$3(ArrayList<Integer> arrayList, Activity activity, SuperGenericWindowView.IActionCallback iActionCallback, boolean z, boolean z2, Bundle bundle, HashMap<Integer, Object> hashMap, GenericWindowManger genericWindowManger, Continuation<? super GenericWindowManger$showGenericWindow$3> continuation) {
        super(2, continuation);
        this.$notices = arrayList;
        this.$activity = activity;
        this.$callback = iActionCallback;
        this.$touchOutsideDismiss = z;
        this.$backKeyDismiss = z2;
        this.$bundle = bundle;
        this.$extras = hashMap;
        this.this$0 = genericWindowManger;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GenericWindowManger$showGenericWindow$3(this.$notices, this.$activity, this.$callback, this.$touchOutsideDismiss, this.$backKeyDismiss, this.$bundle, this.$extras, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            ArrayList<Integer> arrayList2 = this.$notices;
            GenericWindowManger genericWindowManger = this.this$0;
            for (Number intValue : arrayList2) {
                int intValue2 = intValue.intValue();
                if (!genericWindowManger.k(intValue2)) {
                    arrayList.add(Boxing.boxInt(intValue2));
                }
            }
            if (!arrayList.isEmpty()) {
                View decorView = this.$activity.getWindow().getDecorView();
                Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) decorView;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                SuperGenericWindowView superGenericWindowView = new SuperGenericWindowView(this.$notices, this.$callback, this.$touchOutsideDismiss, this.$backKeyDismiss, this.$bundle, this.$activity);
                superGenericWindowView.setFocusable(true);
                superGenericWindowView.setFocusableInTouchMode(true);
                superGenericWindowView.requestFocus();
                superGenericWindowView.requestFocusFromTouch();
                superGenericWindowView.setMExtraList(this.$extras);
                this.this$0.f7886a.add(superGenericWindowView);
                try {
                    viewGroup.addView(superGenericWindowView, layoutParams);
                } catch (Exception unused) {
                    this.this$0.f7886a.remove(superGenericWindowView);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GenericWindowManger$showGenericWindow$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
