package com.upuphone.xr.sapp.monitor.notification;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.honey.account.n8.a;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0019\u001a\u00020\f2\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0017\"\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/NotificationMockActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "", "initView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "title", "Landroid/widget/LinearLayout;", "extraView", "w0", "(Ljava/lang/String;Landroid/widget/LinearLayout;)Landroid/widget/LinearLayout;", "Lkotlin/Function2;", "Landroid/widget/Button;", "Lkotlin/coroutines/Continuation;", "", "function", "s0", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Landroid/widget/Button;", "", "buttons", "v0", "([Landroid/widget/Button;)Landroid/widget/LinearLayout;", "Landroid/content/Intent;", "a", "Landroid/content/Intent;", "intent", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nNotificationMockActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationMockActivity.kt\ncom/upuphone/xr/sapp/monitor/notification/NotificationMockActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,319:1\n256#2,2:320\n13309#3,2:322\n*S KotlinDebug\n*F\n+ 1 NotificationMockActivity.kt\ncom/upuphone/xr/sapp/monitor/notification/NotificationMockActivity\n*L\n281#1:320,2\n314#1:322,2\n*E\n"})
public final class NotificationMockActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    public final Intent f7747a = new Intent(MainApplication.k.f(), NotificationMonitorService.class);

    private final void initView() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mock_root);
        linearLayout.addView(w0("AIR查询通接口", v0(s0("联系人&&归属地", new NotificationMockActivity$initView$1$1((Continuation<? super NotificationMockActivity$initView$1$1>) null)))));
        linearLayout.addView(w0("服务", v0(s0("开启通知服务", new NotificationMockActivity$initView$1$2(linearLayout, this, (Continuation<? super NotificationMockActivity$initView$1$2>) null)), s0("关闭通知服务", new NotificationMockActivity$initView$1$3(linearLayout, this, (Continuation<? super NotificationMockActivity$initView$1$3>) null)), s0("检查服务状态", new NotificationMockActivity$initView$1$4(linearLayout, (Continuation<? super NotificationMockActivity$initView$1$4>) null)))));
        linearLayout.addView(w0("日程", v0(s0("腾讯会议", new NotificationMockActivity$initView$1$5((Continuation<? super NotificationMockActivity$initView$1$5>) null)))));
        linearLayout.addView(w0("美团场景", v0(s0("接单", new NotificationMockActivity$initView$1$6((Continuation<? super NotificationMockActivity$initView$1$6>) null)), s0("骑手接单", new NotificationMockActivity$initView$1$7((Continuation<? super NotificationMockActivity$initView$1$7>) null)))));
        linearLayout.addView(w0("美团场景-2", v0(s0("接单", new NotificationMockActivity$initView$1$8((Continuation<? super NotificationMockActivity$initView$1$8>) null)), s0("骑手接单", new NotificationMockActivity$initView$1$9((Continuation<? super NotificationMockActivity$initView$1$9>) null)))));
        linearLayout.addView(w0("滴滴", v0(s0("司机接单", new NotificationMockActivity$initView$1$10((Continuation<? super NotificationMockActivity$initView$1$10>) null)), s0("即将到达", new NotificationMockActivity$initView$1$11((Continuation<? super NotificationMockActivity$initView$1$11>) null)), s0("司机到达", new NotificationMockActivity$initView$1$12((Continuation<? super NotificationMockActivity$initView$1$12>) null)), s0("行程开始", new NotificationMockActivity$initView$1$13((Continuation<? super NotificationMockActivity$initView$1$13>) null)))));
        linearLayout.addView(w0("滴滴", v0(s0("行程结束", new NotificationMockActivity$initView$1$14((Continuation<? super NotificationMockActivity$initView$1$14>) null)), s0("您已迟到", new NotificationMockActivity$initView$1$15((Continuation<? super NotificationMockActivity$initView$1$15>) null)))));
        linearLayout.addView(w0("打车-百度", v0(s0("已接单", new NotificationMockActivity$initView$1$16((Continuation<? super NotificationMockActivity$initView$1$16>) null)), s0("已经到达", new NotificationMockActivity$initView$1$17((Continuation<? super NotificationMockActivity$initView$1$17>) null)), s0("订单取消", new NotificationMockActivity$initView$1$18((Continuation<? super NotificationMockActivity$initView$1$18>) null)), s0("行程开始", new NotificationMockActivity$initView$1$19((Continuation<? super NotificationMockActivity$initView$1$19>) null)), s0("行程结束", new NotificationMockActivity$initView$1$20((Continuation<? super NotificationMockActivity$initView$1$20>) null)))));
        linearLayout.addView(w0("高德地图", v0(s0("已接单", new NotificationMockActivity$initView$1$21((Continuation<? super NotificationMockActivity$initView$1$21>) null)), s0("即将到达", new NotificationMockActivity$initView$1$22((Continuation<? super NotificationMockActivity$initView$1$22>) null)), s0("司机到达", new NotificationMockActivity$initView$1$23((Continuation<? super NotificationMockActivity$initView$1$23>) null)), s0("行程开始", new NotificationMockActivity$initView$1$24((Continuation<? super NotificationMockActivity$initView$1$24>) null)))));
    }

    public static final void u0(NotificationMockActivity notificationMockActivity, Function2 function2, Button button, View view) {
        Intrinsics.checkNotNullParameter(notificationMockActivity, "this$0");
        Intrinsics.checkNotNullParameter(function2, "$function");
        Intrinsics.checkNotNullParameter(button, "$this_apply");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(notificationMockActivity), (CoroutineContext) null, (CoroutineStart) null, new NotificationMockActivity$getEachBtn$1$1$1(function2, button, view, (Continuation<? super NotificationMockActivity$getEachBtn$1$1$1>) null), 3, (Object) null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_notification_mock);
        initView();
    }

    public final Button s0(String str, Function2 function2) {
        Button button = new Button(this);
        button.setText(str);
        button.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        button.setFocusable(true);
        button.setOnClickListener(new a(this, function2, button));
        return button;
    }

    public final LinearLayout v0(Button... buttonArr) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        for (Button addView : buttonArr) {
            linearLayout.addView(addView);
        }
        return linearLayout;
    }

    public final LinearLayout w0(String str, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setVisibility(8);
        linearLayout2.addView(s0(str, new NotificationMockActivity$getTestView$1$1(linearLayout, (Continuation<? super NotificationMockActivity$getTestView$1$1>) null)));
        linearLayout2.addView(linearLayout);
        return linearLayout2;
    }
}
