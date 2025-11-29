package com.upuphone.xr.sapp.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 )2\u00020\u0001:\u0004*+,-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J=\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u0018\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J?\u0010\u001b\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006."}, d2 = {"Lcom/upuphone/xr/sapp/utils/CustomFrameAnimation;", "", "<init>", "()V", "", "resourceId", "Landroid/widget/ImageView;", "imageView", "", "repeatAnim", "Lcom/upuphone/xr/sapp/utils/CustomFrameAnimation$IAnimState;", "anim", "", "h", "(ILandroid/widget/ImageView;ZLcom/upuphone/xr/sapp/utils/CustomFrameAnimation$IAnimState;)V", "isStop", "p", "(Z)V", "reversed", "j", "(ILandroid/widget/ImageView;ZLcom/upuphone/xr/sapp/utils/CustomFrameAnimation$IAnimState;Z)V", "", "Lcom/upuphone/xr/sapp/utils/CustomFrameAnimation$MyFrame;", "myFrames", "m", "(Ljava/util/List;Landroid/widget/ImageView;ZLcom/upuphone/xr/sapp/utils/CustomFrameAnimation$IAnimState;)V", "currentFrameNumber", "l", "(Ljava/util/List;Landroid/widget/ImageView;IZLcom/upuphone/xr/sapp/utils/CustomFrameAnimation$IAnimState;)V", "i", "()Z", "a", "Z", "mIsStop", "b", "I", "mFrameNumber", "Ljava/util/concurrent/atomic/AtomicInteger;", "c", "Ljava/util/concurrent/atomic/AtomicInteger;", "mResCache", "d", "Companion", "FDrawableHolder", "IAnimState", "MyFrame", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CustomFrameAnimation {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);
    public static Handler e = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public boolean f7863a;
    public int b;
    public final AtomicInteger c = new AtomicInteger();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/utils/CustomFrameAnimation$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/utils/CustomFrameAnimation;", "b", "()Lcom/upuphone/xr/sapp/utils/CustomFrameAnimation;", "Landroid/os/Handler;", "mMainHandle", "Landroid/os/Handler;", "a", "()Landroid/os/Handler;", "setMMainHandle", "(Landroid/os/Handler;)V", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Handler a() {
            return CustomFrameAnimation.e;
        }

        public final CustomFrameAnimation b() {
            return FDrawableHolder.f7864a.a();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/utils/CustomFrameAnimation$FDrawableHolder;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/utils/CustomFrameAnimation;", "b", "Lcom/upuphone/xr/sapp/utils/CustomFrameAnimation;", "a", "()Lcom/upuphone/xr/sapp/utils/CustomFrameAnimation;", "DRAWABLE", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class FDrawableHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final FDrawableHolder f7864a = new FDrawableHolder();
        public static final CustomFrameAnimation b = new CustomFrameAnimation();

        public final CustomFrameAnimation a() {
            return b;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/utils/CustomFrameAnimation$IAnimState;", "", "", "a", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface IAnimState {
        void a();
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\f\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/upuphone/xr/sapp/utils/CustomFrameAnimation$MyFrame;", "", "<init>", "()V", "", "a", "[B", "()[B", "e", "([B)V", "bytes", "", "b", "I", "c", "()I", "g", "(I)V", "duration", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "f", "(Landroid/graphics/drawable/Drawable;)V", "drawable", "", "d", "Z", "()Z", "h", "(Z)V", "isReady", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class MyFrame {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f7865a;
        public int b;
        public Drawable c;
        public boolean d;

        public final byte[] a() {
            return this.f7865a;
        }

        public final Drawable b() {
            return this.c;
        }

        public final int c() {
            return this.b;
        }

        public final boolean d() {
            return this.d;
        }

        public final void e(byte[] bArr) {
            this.f7865a = bArr;
        }

        public final void f(Drawable drawable) {
            this.c = drawable;
        }

        public final void g(int i) {
            this.b = i;
        }

        public final void h(boolean z) {
            this.d = z;
        }
    }

    public static /* synthetic */ void k(CustomFrameAnimation customFrameAnimation, int i, ImageView imageView, boolean z, IAnimState iAnimState, boolean z2, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z2 = false;
        }
        customFrameAnimation.j(i, imageView, z, iAnimState, z2);
    }

    public static final void n(ImageView imageView, MyFrame myFrame) {
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        Intrinsics.checkNotNullParameter(myFrame, "$thisFrame");
        imageView.setImageDrawable(myFrame.b());
    }

    public static final void o(ImageView imageView, MyFrame myFrame, CustomFrameAnimation customFrameAnimation, List list, boolean z, IAnimState iAnimState) {
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        Intrinsics.checkNotNullParameter(myFrame, "$thisFrame");
        Intrinsics.checkNotNullParameter(customFrameAnimation, "this$0");
        Intrinsics.checkNotNullParameter(list, "$myFrames");
        if (!Intrinsics.areEqual((Object) imageView.getDrawable(), (Object) myFrame.b())) {
            return;
        }
        if (customFrameAnimation.b + 1 < list.size()) {
            MyFrame myFrame2 = (MyFrame) list.get(customFrameAnimation.b + 1);
            if (myFrame2.d()) {
                customFrameAnimation.l(list, imageView, customFrameAnimation.b + 1, z, iAnimState);
                return;
            }
            myFrame2.h(true);
        } else if (z) {
            customFrameAnimation.b = -1;
            e.removeCallbacksAndMessages((Object) null);
            customFrameAnimation.l(list, imageView, 0, true, (IAnimState) null);
        } else if (!customFrameAnimation.f7863a && iAnimState != null) {
            iAnimState.a();
        }
    }

    public final void h(int i, ImageView imageView, boolean z, IAnimState iAnimState) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        this.f7863a = false;
        k(this, i, imageView, z, iAnimState, false, 16, (Object) null);
    }

    public final boolean i() {
        return Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper());
    }

    public final void j(int i, ImageView imageView, boolean z, IAnimState iAnimState, boolean z2) {
        if (i == -1 || imageView == null) {
            ULog.f6446a.c("CustomFrameAnimation", "loadFromXml::error by invalid res or imageView is null");
            return;
        }
        Context context = imageView.getContext();
        int integer = context.getResources().getInteger(R.integer.guide_anim_time);
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new CustomFrameAnimation$loadFromXml$1(context, i, integer, this, imageView, z2, z, iAnimState, (Continuation<? super CustomFrameAnimation$loadFromXml$1>) null), 3, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e7, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void l(java.util.List r10, android.widget.ImageView r11, int r12, boolean r13, com.upuphone.xr.sapp.utils.CustomFrameAnimation.IAnimState r14) {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r0 = r9.f7863a     // Catch:{ all -> 0x000a }
            if (r0 == 0) goto L_0x000d
            r11.clearAnimation()     // Catch:{ all -> 0x000a }
            monitor-exit(r9)
            return
        L_0x000a:
            r10 = move-exception
            goto L_0x00e8
        L_0x000d:
            r9.b = r12     // Catch:{ all -> 0x000a }
            int r0 = r10.size()     // Catch:{ all -> 0x000a }
            if (r12 < r0) goto L_0x001d
            int r12 = r10.size()     // Catch:{ all -> 0x000a }
            int r12 = r12 + -1
            r9.b = r12     // Catch:{ all -> 0x000a }
        L_0x001d:
            int r12 = r9.b     // Catch:{ all -> 0x000a }
            java.lang.Object r12 = r10.get(r12)     // Catch:{ all -> 0x000a }
            com.upuphone.xr.sapp.utils.CustomFrameAnimation$MyFrame r12 = (com.upuphone.xr.sapp.utils.CustomFrameAnimation.MyFrame) r12     // Catch:{ all -> 0x000a }
            int r0 = r9.b     // Catch:{ all -> 0x000a }
            r1 = 0
            if (r0 != 0) goto L_0x004b
            android.graphics.drawable.BitmapDrawable r0 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x000a }
            android.content.Context r2 = r11.getContext()     // Catch:{ all -> 0x000a }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ all -> 0x000a }
            byte[] r3 = r12.a()     // Catch:{ all -> 0x000a }
            byte[] r4 = r12.a()     // Catch:{ all -> 0x000a }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ all -> 0x000a }
            int r4 = r4.length     // Catch:{ all -> 0x000a }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r3, r1, r4)     // Catch:{ all -> 0x000a }
            r0.<init>(r2, r1)     // Catch:{ all -> 0x000a }
            r12.f(r0)     // Catch:{ all -> 0x000a }
            goto L_0x0073
        L_0x004b:
            int r0 = r0 + -1
            java.lang.Object r0 = r10.get(r0)     // Catch:{ all -> 0x000a }
            com.upuphone.xr.sapp.utils.CustomFrameAnimation$MyFrame r0 = (com.upuphone.xr.sapp.utils.CustomFrameAnimation.MyFrame) r0     // Catch:{ all -> 0x000a }
            android.graphics.drawable.Drawable r2 = r0.b()     // Catch:{ all -> 0x000a }
            android.graphics.drawable.BitmapDrawable r2 = (android.graphics.drawable.BitmapDrawable) r2     // Catch:{ all -> 0x000a }
            r3 = 0
            if (r2 == 0) goto L_0x0061
            android.graphics.Bitmap r2 = r2.getBitmap()     // Catch:{ all -> 0x000a }
            goto L_0x0062
        L_0x0061:
            r2 = r3
        L_0x0062:
            if (r2 == 0) goto L_0x006d
            boolean r4 = r2.isRecycled()     // Catch:{ all -> 0x000a }
            if (r4 != 0) goto L_0x006d
            r2.recycle()     // Catch:{ all -> 0x000a }
        L_0x006d:
            r0.f(r3)     // Catch:{ all -> 0x000a }
            r0.h(r1)     // Catch:{ all -> 0x000a }
        L_0x0073:
            boolean r0 = r9.i()     // Catch:{ Exception -> 0x0084 }
            if (r0 != 0) goto L_0x0086
            android.os.Handler r0 = e     // Catch:{ Exception -> 0x0084 }
            com.honey.account.w8.d r1 = new com.honey.account.w8.d     // Catch:{ Exception -> 0x0084 }
            r1.<init>(r11, r12)     // Catch:{ Exception -> 0x0084 }
            r0.post(r1)     // Catch:{ Exception -> 0x0084 }
            goto L_0x00aa
        L_0x0084:
            r0 = move-exception
            goto L_0x008e
        L_0x0086:
            android.graphics.drawable.Drawable r0 = r12.b()     // Catch:{ Exception -> 0x0084 }
            r11.setImageDrawable(r0)     // Catch:{ Exception -> 0x0084 }
            goto L_0x00aa
        L_0x008e:
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ all -> 0x000a }
            java.lang.String r2 = "CustomFrameAnimation"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x000a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x000a }
            r3.<init>()     // Catch:{ all -> 0x000a }
            java.lang.String r4 = "showAnimate::set frame error: "
            r3.append(r4)     // Catch:{ all -> 0x000a }
            r3.append(r0)     // Catch:{ all -> 0x000a }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x000a }
            r1.c(r2, r0)     // Catch:{ all -> 0x000a }
        L_0x00aa:
            android.os.Handler r7 = e     // Catch:{ all -> 0x000a }
            com.honey.account.w8.e r8 = new com.honey.account.w8.e     // Catch:{ all -> 0x000a }
            r0 = r8
            r1 = r11
            r2 = r12
            r3 = r9
            r4 = r10
            r5 = r13
            r6 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x000a }
            int r12 = r12.c()     // Catch:{ all -> 0x000a }
            long r0 = (long) r12     // Catch:{ all -> 0x000a }
            r7.postDelayed(r8, r0)     // Catch:{ all -> 0x000a }
            int r12 = r9.b     // Catch:{ all -> 0x000a }
            int r12 = r12 + 1
            int r0 = r10.size()     // Catch:{ all -> 0x000a }
            if (r12 >= r0) goto L_0x00e6
            kotlinx.coroutines.CoroutineDispatcher r12 = kotlinx.coroutines.Dispatchers.b()     // Catch:{ all -> 0x000a }
            kotlinx.coroutines.CoroutineScope r0 = kotlinx.coroutines.CoroutineScopeKt.a(r12)     // Catch:{ all -> 0x000a }
            com.upuphone.xr.sapp.utils.CustomFrameAnimation$showAnimate$4 r12 = new com.upuphone.xr.sapp.utils.CustomFrameAnimation$showAnimate$4     // Catch:{ all -> 0x000a }
            r7 = 0
            r1 = r12
            r2 = r10
            r3 = r9
            r4 = r11
            r5 = r13
            r6 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x000a }
            r4 = 3
            r5 = 0
            r1 = 0
            r2 = 0
            r3 = r12
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.d(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x000a }
        L_0x00e6:
            monitor-exit(r9)
            return
        L_0x00e8:
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.CustomFrameAnimation.l(java.util.List, android.widget.ImageView, int, boolean, com.upuphone.xr.sapp.utils.CustomFrameAnimation$IAnimState):void");
    }

    public final void m(List list, ImageView imageView, boolean z, IAnimState iAnimState) {
        l(list, imageView, 0, z, iAnimState);
    }

    public final void p(boolean z) {
        this.f7863a = z;
    }
}
