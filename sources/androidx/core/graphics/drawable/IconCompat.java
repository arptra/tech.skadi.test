package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.geetest.sdk.x;
import com.honey.account.constant.AccountConstantKt;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {
    public static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f726a;
    public Object b;
    public byte[] c;
    public Parcelable d;
    public int e;
    public int f;
    public ColorStateList g;
    public PorterDuff.Mode h;
    public String i;
    public String j;

    @RequiresApi
    public static class Api23Impl {
        public static IconCompat a(Object obj) {
            Preconditions.h(obj);
            int d = d(obj);
            if (d == 2) {
                return IconCompat.m((Resources) null, c(obj), b(obj));
            }
            if (d == 4) {
                return IconCompat.i(e(obj));
            }
            if (d == 6) {
                return IconCompat.f(e(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.b = obj;
            return iconCompat;
        }

        public static int b(Object obj) {
            return Api28Impl.a(obj);
        }

        public static String c(Object obj) {
            return Api28Impl.b(obj);
        }

        public static int d(Object obj) {
            return Api28Impl.c(obj);
        }

        @DoNotInline
        @Nullable
        public static Uri e(@NonNull Object obj) {
            return Api28Impl.d(obj);
        }

        @DoNotInline
        public static Drawable f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        @DoNotInline
        public static Icon g(IconCompat iconCompat, Context context) {
            Icon icon;
            switch (iconCompat.f726a) {
                case -1:
                    return (Icon) iconCompat.b;
                case 1:
                    icon = Icon.createWithBitmap((Bitmap) iconCompat.b);
                    break;
                case 2:
                    icon = Icon.createWithResource(iconCompat.p(), iconCompat.e);
                    break;
                case 3:
                    icon = Icon.createWithData((byte[]) iconCompat.b, iconCompat.e, iconCompat.f);
                    break;
                case 4:
                    icon = Icon.createWithContentUri((String) iconCompat.b);
                    break;
                case 5:
                    icon = Api26Impl.b((Bitmap) iconCompat.b);
                    break;
                case 6:
                    if (Build.VERSION.SDK_INT >= 30) {
                        icon = Api30Impl.a(iconCompat.r());
                        break;
                    } else if (context != null) {
                        InputStream s = iconCompat.s(context);
                        if (s != null) {
                            icon = Api26Impl.b(BitmapFactory.decodeStream(s));
                            break;
                        } else {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.r());
                        }
                    } else {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.r());
                    }
                default:
                    throw new IllegalArgumentException("Unknown type");
            }
            ColorStateList colorStateList = iconCompat.g;
            if (colorStateList != null) {
                icon.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.h;
            if (mode != IconCompat.k) {
                icon.setTintMode(mode);
            }
            return icon;
        }
    }

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        public static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        @DoNotInline
        public static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        @DoNotInline
        public static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        @DoNotInline
        public static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        @DoNotInline
        public static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    @RequiresApi
    public static class Api30Impl {
        @DoNotInline
        public static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface IconType {
    }

    @RestrictTo
    public IconCompat() {
        this.f726a = -1;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = k;
        this.i = null;
    }

    public static IconCompat b(Bundle bundle) {
        int i2 = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i2);
        iconCompat.e = bundle.getInt("int1");
        iconCompat.f = bundle.getInt("int2");
        iconCompat.j = bundle.getString("string1");
        if (bundle.containsKey("tint_list")) {
            iconCompat.g = (ColorStateList) bundle.getParcelable("tint_list");
        }
        if (bundle.containsKey("tint_mode")) {
            iconCompat.h = PorterDuff.Mode.valueOf(bundle.getString("tint_mode"));
        }
        switch (i2) {
            case -1:
            case 1:
            case 5:
                iconCompat.b = bundle.getParcelable("obj");
                break;
            case 2:
            case 4:
            case 6:
                iconCompat.b = bundle.getString("obj");
                break;
            case 3:
                iconCompat.b = bundle.getByteArray("obj");
                break;
            default:
                Log.w("IconCompat", "Unknown type " + i2);
                return null;
        }
        return iconCompat;
    }

    public static IconCompat c(Icon icon) {
        return Api23Impl.a(icon);
    }

    public static IconCompat d(Icon icon) {
        if (Api23Impl.d(icon) == 2 && Api23Impl.b(icon) == 0) {
            return null;
        }
        return Api23Impl.a(icon);
    }

    public static Bitmap e(Bitmap bitmap, boolean z) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f2 = (float) min;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate(((float) (-(bitmap.getWidth() - min))) / 2.0f, ((float) (-(bitmap.getHeight() - min))) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    public static IconCompat f(Uri uri) {
        ObjectsCompat.c(uri);
        return g(uri.toString());
    }

    public static IconCompat g(String str) {
        ObjectsCompat.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.b = str;
        return iconCompat;
    }

    public static IconCompat h(Bitmap bitmap) {
        ObjectsCompat.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.b = bitmap;
        return iconCompat;
    }

    public static IconCompat i(Uri uri) {
        ObjectsCompat.c(uri);
        return j(uri.toString());
    }

    public static IconCompat j(String str) {
        ObjectsCompat.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.b = str;
        return iconCompat;
    }

    public static IconCompat k(byte[] bArr, int i2, int i3) {
        ObjectsCompat.c(bArr);
        IconCompat iconCompat = new IconCompat(3);
        iconCompat.b = bArr;
        iconCompat.e = i2;
        iconCompat.f = i3;
        return iconCompat;
    }

    public static IconCompat l(Context context, int i2) {
        ObjectsCompat.c(context);
        return m(context.getResources(), context.getPackageName(), i2);
    }

    public static IconCompat m(Resources resources, String str, int i2) {
        ObjectsCompat.c(str);
        if (i2 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.e = i2;
            if (resources != null) {
                try {
                    iconCompat.b = resources.getResourceName(i2);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.b = str;
            }
            iconCompat.j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public static String y(int i2) {
        switch (i2) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public Bitmap n() {
        int i2 = this.f726a;
        if (i2 == -1) {
            Object obj = this.b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        } else if (i2 == 1) {
            return (Bitmap) this.b;
        } else {
            if (i2 == 5) {
                return e((Bitmap) this.b, true);
            }
            throw new IllegalStateException("called getBitmap() on " + this);
        }
    }

    public int o() {
        int i2 = this.f726a;
        if (i2 == -1) {
            return Api23Impl.b(this.b);
        }
        if (i2 == 2) {
            return this.e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String p() {
        int i2 = this.f726a;
        if (i2 == -1) {
            return Api23Impl.c(this.b);
        }
        if (i2 == 2) {
            String str = this.j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.b).split(AccountConstantKt.CODE_SEPARTOR, -1)[0] : this.j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int q() {
        int i2 = this.f726a;
        return i2 == -1 ? Api23Impl.d(this.b) : i2;
    }

    public Uri r() {
        int i2 = this.f726a;
        if (i2 == -1) {
            return Api23Impl.e(this.b);
        }
        if (i2 == 4 || i2 == 6) {
            return Uri.parse((String) this.b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream s(Context context) {
        Uri r = r();
        String scheme = r.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(r);
            } catch (Exception e2) {
                Log.w("IconCompat", "Unable to load image from URI: " + r, e2);
                return null;
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.b));
            } catch (FileNotFoundException e3) {
                Log.w("IconCompat", "Unable to load image from path: " + r, e3);
                return null;
            }
        }
    }

    public void t() {
        this.h = PorterDuff.Mode.valueOf(this.i);
        switch (this.f726a) {
            case -1:
                Parcelable parcelable = this.d;
                if (parcelable != null) {
                    this.b = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                Parcelable parcelable2 = this.d;
                if (parcelable2 != null) {
                    this.b = parcelable2;
                    return;
                }
                byte[] bArr = this.c;
                this.b = bArr;
                this.f726a = 3;
                this.e = 0;
                this.f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.c, Charset.forName("UTF-16"));
                this.b = str;
                if (this.f726a == 2 && this.j == null) {
                    this.j = str.split(AccountConstantKt.CODE_SEPARTOR, -1)[0];
                    return;
                }
                return;
            case 3:
                this.b = this.c;
                return;
            default:
                return;
        }
    }

    public String toString() {
        if (this.f726a == -1) {
            return String.valueOf(this.b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(y(this.f726a));
        switch (this.f726a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.b).getWidth());
                sb.append(x.f);
                sb.append(((Bitmap) this.b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", new Object[]{Integer.valueOf(o())}));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.e);
                if (this.f != 0) {
                    sb.append(" off=");
                    sb.append(this.f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.b);
                break;
        }
        if (this.g != null) {
            sb.append(" tint=");
            sb.append(this.g);
        }
        if (this.h != k) {
            sb.append(" mode=");
            sb.append(this.h);
        }
        sb.append(")");
        return sb.toString();
    }

    public void u(boolean z) {
        this.i = this.h.name();
        switch (this.f726a) {
            case -1:
                if (!z) {
                    this.d = (Parcelable) this.b;
                    return;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            case 1:
            case 5:
                if (z) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.d = (Parcelable) this.b;
                return;
            case 2:
                this.c = ((String) this.b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.c = (byte[]) this.b;
                return;
            case 4:
            case 6:
                this.c = this.b.toString().getBytes(Charset.forName("UTF-16"));
                return;
            default:
                return;
        }
    }

    public Bundle v() {
        Bundle bundle = new Bundle();
        switch (this.f726a) {
            case -1:
                bundle.putParcelable("obj", (Parcelable) this.b);
                break;
            case 1:
            case 5:
                bundle.putParcelable("obj", (Bitmap) this.b);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.b);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.b);
                break;
            default:
                throw new IllegalArgumentException("Invalid icon");
        }
        bundle.putInt("type", this.f726a);
        bundle.putInt("int1", this.e);
        bundle.putInt("int2", this.f);
        bundle.putString("string1", this.j);
        ColorStateList colorStateList = this.g;
        if (colorStateList != null) {
            bundle.putParcelable("tint_list", colorStateList);
        }
        PorterDuff.Mode mode = this.h;
        if (mode != k) {
            bundle.putString("tint_mode", mode.name());
        }
        return bundle;
    }

    public Icon w() {
        return x((Context) null);
    }

    public Icon x(Context context) {
        return Api23Impl.g(this, context);
    }

    public IconCompat(int i2) {
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = k;
        this.i = null;
        this.f726a = i2;
    }
}
