package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.RestrictTo;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;
import org.apache.commons.codec.language.Soundex;

public class TypefaceCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final TypefaceCompatBaseImpl f718a = new TypefaceCompatApi29Impl();
    public static final LruCache b = new LruCache(16);

    @RestrictTo
    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {

        /* renamed from: a  reason: collision with root package name */
        public ResourcesCompat.FontCallback f719a;

        public ResourcesCallbackAdapter(ResourcesCompat.FontCallback fontCallback) {
            this.f719a = fontCallback;
        }

        public void a(int i) {
            ResourcesCompat.FontCallback fontCallback = this.f719a;
            if (fontCallback != null) {
                fontCallback.c(i);
            }
        }

        public void b(Typeface typeface) {
            ResourcesCompat.FontCallback fontCallback = this.f719a;
            if (fontCallback != null) {
                fontCallback.d(typeface);
            }
        }
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        if (context != null) {
            return Typeface.create(typeface, i);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        return f718a.c(context, cancellationSignal, fontInfoArr, i);
    }

    public static Typeface c(Context context, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int i, String str, int i2, int i3, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z) {
        Typeface typeface;
        FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry2 = familyResourceEntry;
        ResourcesCompat.FontCallback fontCallback2 = fontCallback;
        Handler handler2 = handler;
        if (familyResourceEntry2 instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry2;
            Typeface g = g(providerResourceEntry.c());
            if (g != null) {
                if (fontCallback2 != null) {
                    fontCallback2.callbackSuccessAsync(g, handler2);
                }
                return g;
            }
            typeface = FontsContractCompat.c(context, providerResourceEntry.b(), i3, !z ? fontCallback2 == null : providerResourceEntry.a() == 0, z ? providerResourceEntry.d() : -1, ResourcesCompat.FontCallback.getHandler(handler), new ResourcesCallbackAdapter(fontCallback2));
            Resources resources2 = resources;
            int i4 = i3;
        } else {
            Context context2 = context;
            Resources resources3 = resources;
            typeface = f718a.b(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry2, resources, i3);
            if (fontCallback2 != null) {
                if (typeface != null) {
                    fontCallback2.callbackSuccessAsync(typeface, handler2);
                } else {
                    fontCallback2.callbackFailAsync(-3, handler2);
                }
            }
        }
        if (typeface != null) {
            b.put(e(resources, i, str, i2, i3), typeface);
        }
        return typeface;
    }

    public static Typeface d(Context context, Resources resources, int i, String str, int i2, int i3) {
        Typeface e = f718a.e(context, resources, i, str, i3);
        if (e != null) {
            b.put(e(resources, i, str, i2, i3), e);
        }
        return e;
    }

    public static String e(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + Soundex.SILENT_MARKER + str + Soundex.SILENT_MARKER + i2 + Soundex.SILENT_MARKER + i + Soundex.SILENT_MARKER + i3;
    }

    public static Typeface f(Resources resources, int i, String str, int i2, int i3) {
        return (Typeface) b.get(e(resources, i, str, i2, i3));
    }

    public static Typeface g(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
