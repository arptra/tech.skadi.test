package com.upuphone.xr.sapp.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableKt;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/utils/AppInfoHelper;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "packageName", "", "a", "(Landroid/content/Context;Ljava/lang/String;)[B", "b", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/graphics/Bitmap;", "bitmap", "", "scale", "c", "(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AppInfoHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final AppInfoHelper f7840a = new AppInfoHelper();

    /* JADX INFO: finally extract failed */
    public final byte[] a(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        PackageManager packageManager = context.getPackageManager();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Drawable loadIcon = packageManager.getPackageInfo(str, 0).applicationInfo.loadIcon(packageManager);
            Intrinsics.checkNotNullExpressionValue(loadIcon, "loadIcon(...)");
            c(DrawableKt.b(loadIcon, 0, 0, Bitmap.Config.ARGB_8888, 3, (Object) null), 0.5f).compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
            int length = byteArrayOutputStream.toByteArray().length;
            ILog.e("notification", "图片大小 " + length);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (PackageManager.NameNotFoundException unused) {
            byteArrayOutputStream.close();
            return null;
        } catch (Throwable th) {
            byteArrayOutputStream.close();
            throw th;
        }
    }

    public final String b(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        try {
            Result.Companion companion = Result.Companion;
            PackageManager packageManager = GlobalExtKt.f().getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
            obj = Result.m20constructorimpl(packageManager.getApplicationLabel(packageManager.getPackageInfo(str, 0).applicationInfo).toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m26isFailureimpl(obj)) {
            obj = null;
        }
        String str2 = (String) obj;
        return str2 == null ? "" : str2;
    }

    public final Bitmap c(Bitmap bitmap, float f) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ILog.d("notification", "图标大小：" + width + "/" + height);
        float width2 = 48.0f / ((float) bitmap.getWidth());
        StringBuilder sb = new StringBuilder();
        sb.append("缩放->");
        sb.append(width2);
        System.out.println(sb.toString());
        Matrix matrix = new Matrix();
        matrix.setScale(width2, width2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        return createBitmap;
    }
}
