package com.xjmz.myvu.dialog;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.upuphone.star.core.log.ULog;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000 \n2\u00020\u0001:\u0001\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/xjmz/myvu/dialog/GlobalWindowDialog;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "getCustomView", "()Landroid/view/View;", "Landroid/view/KeyEvent;", "event", "", "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class GlobalWindowDialog extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8235a = new Companion((DefaultConstructorMarker) null);
    public static final LinkedList b = new LinkedList();

    @SourceDebugExtension({"SMAP\nGlobalWindowDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlobalWindowDialog.kt\ncom/xjmz/myvu/dialog/GlobalWindowDialog$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,80:1\n1855#2,2:81\n*S KotlinDebug\n*F\n+ 1 GlobalWindowDialog.kt\ncom/xjmz/myvu/dialog/GlobalWindowDialog$Companion\n*L\n17#1:81,2\n*E\n"})
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/xjmz/myvu/dialog/GlobalWindowDialog$Companion;", "", "<init>", "()V", "Landroidx/fragment/app/FragmentActivity;", "activity", "", "a", "(Landroidx/fragment/app/FragmentActivity;)V", "", "TAG", "Ljava/lang/String;", "Ljava/util/LinkedList;", "Landroid/view/View;", "windowStack", "Ljava/util/LinkedList;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentActivity fragmentActivity) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            for (View removeView : GlobalWindowDialog.b) {
                View decorView = fragmentActivity.getWindow().getDecorView();
                Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) decorView).removeView(removeView);
            }
            GlobalWindowDialog.b.clear();
        }

        public Companion() {
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        LinkedList linkedList = b;
        if (!linkedList.isEmpty()) {
            View view = (View) linkedList.getLast();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("GlobalDialog", "dispatchKeyEvent-> remove: " + view);
            ViewParent parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(view);
            linkedList.removeLast();
            return true;
        }
        ULog.f6446a.g("GlobalDialog", "dispatchKeyEvent-> 没有弹窗, 不处理");
        return super.dispatchKeyEvent(keyEvent);
    }

    @NotNull
    public abstract View getCustomView();
}
