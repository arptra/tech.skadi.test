package com.upuphone.star.common.phone;

import android.content.Context;
import android.widget.Toast;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/star/common/phone/UToast;", "", "a", "Companion", "phone_release"}, k = 1, mv = {1, 7, 1})
public final class UToast {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6444a = new Companion((DefaultConstructorMarker) null);
    public static WeakReference b;
    public static int c;
    public static String d;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/upuphone/star/common/phone/UToast$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "msg", "", "d", "(Landroid/content/Context;Ljava/lang/String;)V", "", "res", "b", "(Landroid/content/Context;I)V", "duration", "c", "(Landroid/content/Context;II)V", "e", "(Landroid/content/Context;Ljava/lang/String;I)V", "Landroid/widget/Toast;", "a", "(Landroid/content/Context;Ljava/lang/String;I)Landroid/widget/Toast;", "I", "message", "Ljava/lang/String;", "Ljava/lang/ref/WeakReference;", "toastRef", "Ljava/lang/ref/WeakReference;", "phone_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Toast a(Context context, String str, int i) {
            Toast makeText = Toast.makeText(context, str, i);
            Intrinsics.checkNotNullExpressionValue(makeText, "makeText(context, msg, duration)");
            return makeText;
        }

        public final void b(Context context, int i) {
            Intrinsics.checkNotNullParameter(context, "context");
            c(context, i, 0);
        }

        public final void c(Context context, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = context.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(res)");
            e(context, string, i2);
        }

        public final void d(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
            e(context, str, 0);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.widget.Toast} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void e(android.content.Context r3, java.lang.String r4, int r5) {
            /*
                r2 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = "msg"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.ref.WeakReference r0 = com.upuphone.star.common.phone.UToast.b
                r1 = 0
                if (r0 == 0) goto L_0x0018
                java.lang.Object r0 = r0.get()
                android.widget.Toast r0 = (android.widget.Toast) r0
                goto L_0x0019
            L_0x0018:
                r0 = r1
            L_0x0019:
                if (r0 == 0) goto L_0x002b
                java.lang.String r0 = com.upuphone.star.common.phone.UToast.d
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
                if (r0 == 0) goto L_0x002b
                int r0 = com.upuphone.star.common.phone.UToast.c
                if (r0 == r5) goto L_0x0060
            L_0x002b:
                java.lang.ref.WeakReference r0 = com.upuphone.star.common.phone.UToast.b
                if (r0 == 0) goto L_0x0038
                java.lang.Object r0 = r0.get()
                r1 = r0
                android.widget.Toast r1 = (android.widget.Toast) r1
            L_0x0038:
                if (r1 == 0) goto L_0x004b
                java.lang.ref.WeakReference r0 = com.upuphone.star.common.phone.UToast.b
                if (r0 == 0) goto L_0x004b
                java.lang.Object r0 = r0.get()
                android.widget.Toast r0 = (android.widget.Toast) r0
                if (r0 == 0) goto L_0x004b
                r0.cancel()
            L_0x004b:
                android.content.Context r3 = r3.getApplicationContext()
                java.lang.String r0 = "context.applicationContext"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                android.widget.Toast r2 = r2.a(r3, r4, r5)
                java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference
                r3.<init>(r2)
                com.upuphone.star.common.phone.UToast.b = r3
            L_0x0060:
                java.lang.ref.WeakReference r2 = com.upuphone.star.common.phone.UToast.b
                if (r2 == 0) goto L_0x0071
                java.lang.Object r2 = r2.get()
                android.widget.Toast r2 = (android.widget.Toast) r2
                if (r2 == 0) goto L_0x0071
                r2.show()
            L_0x0071:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.star.common.phone.UToast.Companion.e(android.content.Context, java.lang.String, int):void");
        }

        public Companion() {
        }
    }

    public static final void e(Context context, int i, int i2) {
        f6444a.c(context, i, i2);
    }

    public static final void f(Context context, String str) {
        f6444a.d(context, str);
    }

    public static final void g(Context context, String str, int i) {
        f6444a.e(context, str, i);
    }
}
