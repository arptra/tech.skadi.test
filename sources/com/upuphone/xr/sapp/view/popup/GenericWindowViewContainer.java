package com.upuphone.xr.sapp.view.popup;

import android.content.Context;
import android.widget.FrameLayout;
import com.upuphone.xr.sapp.view.GenericWindowView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0016\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010!\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/upuphone/xr/sapp/view/popup/GenericWindowViewContainer;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "windowType", "Lcom/upuphone/xr/sapp/view/GenericWindowView$IClickCallback;", "callback", "<init>", "(Landroid/content/Context;ILcom/upuphone/xr/sapp/view/GenericWindowView$IClickCallback;)V", "", "a", "()V", "", "data", "b", "(ILjava/lang/Object;)V", "I", "getWindowType", "()I", "setWindowType", "(I)V", "Lcom/upuphone/xr/sapp/view/GenericWindowView$IClickCallback;", "getCallback", "()Lcom/upuphone/xr/sapp/view/GenericWindowView$IClickCallback;", "setCallback", "(Lcom/upuphone/xr/sapp/view/GenericWindowView$IClickCallback;)V", "c", "Ljava/lang/Object;", "getMExtra", "()Ljava/lang/Object;", "setMExtra", "(Ljava/lang/Object;)V", "mExtra", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public class GenericWindowViewContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f7994a;
    public GenericWindowView.IClickCallback b;
    public Object c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericWindowViewContainer(Context context, int i, GenericWindowView.IClickCallback iClickCallback) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f7994a = i;
        this.b = iClickCallback;
    }

    public final void a() {
        this.b = null;
    }

    public void b(int i, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
    }

    @Nullable
    public final GenericWindowView.IClickCallback getCallback() {
        return this.b;
    }

    @Nullable
    public final Object getMExtra() {
        return this.c;
    }

    public final int getWindowType() {
        return this.f7994a;
    }

    public final void setCallback(@Nullable GenericWindowView.IClickCallback iClickCallback) {
        this.b = iClickCallback;
    }

    public final void setMExtra(@Nullable Object obj) {
        this.c = obj;
    }

    public final void setWindowType(int i) {
        this.f7994a = i;
    }
}
