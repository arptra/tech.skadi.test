package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

@RestrictTo
class TypefaceCompatBaseImpl {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f720a = new ConcurrentHashMap();

    /* renamed from: androidx.core.graphics.TypefaceCompatBaseImpl$3  reason: invalid class name */
    class AnonymousClass3 implements StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry> {
        /* renamed from: c */
        public int a(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.e();
        }

        /* renamed from: d */
        public boolean b(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.f();
        }
    }

    public interface StyleExtractor<T> {
        int a(Object obj);

        boolean b(Object obj);
    }

    public static Object g(Object[] objArr, int i, StyleExtractor styleExtractor) {
        return h(objArr, (i & 1) == 0 ? CmdCode.CODE_WAKEUP_RECORDING : 700, (i & 2) != 0, styleExtractor);
    }

    public static Object h(Object[] objArr, int i, boolean z, StyleExtractor styleExtractor) {
        Object obj = null;
        int i2 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int abs = (Math.abs(styleExtractor.a(obj2) - i) * 2) + (styleExtractor.b(obj2) == z ? 0 : 1);
            if (obj == null || i2 > abs) {
                obj = obj2;
                i2 = abs;
            }
        }
        return obj;
    }

    public static long j(Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (NoSuchFieldException e) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e);
            return 0;
        } catch (IllegalAccessException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0;
        }
    }

    public final void a(Typeface typeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry) {
        long j = j(typeface);
        if (j != 0) {
            this.f720a.put(Long.valueOf(j), fontFamilyFilesResourceEntry);
        }
    }

    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        FontResourcesParserCompat.FontFileResourceEntry f = f(fontFamilyFilesResourceEntry, i);
        if (f == null) {
            return null;
        }
        Typeface d = TypefaceCompat.d(context, resources, f.b(), f.a(), 0, i);
        a(d, fontFamilyFilesResourceEntry);
        return d;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (fontInfoArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(i(fontInfoArr, i).d());
            try {
                Typeface d = d(context, inputStream);
                TypefaceCompatUtil.a(inputStream);
                return d;
            } catch (IOException unused) {
                TypefaceCompatUtil.a(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                TypefaceCompatUtil.a(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            TypefaceCompatUtil.a(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            TypefaceCompatUtil.a(inputStream2);
            throw th;
        }
    }

    public Typeface d(Context context, InputStream inputStream) {
        File e = TypefaceCompatUtil.e(context);
        if (e == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.d(e, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e.getPath());
            e.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i, String str, int i2) {
        File e = TypefaceCompatUtil.e(context);
        if (e == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.c(e, resources, i)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e.getPath());
            e.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e.delete();
        }
    }

    public final FontResourcesParserCompat.FontFileResourceEntry f(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i) {
        return (FontResourcesParserCompat.FontFileResourceEntry) g(fontFamilyFilesResourceEntry.a(), i, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>() {
            /* renamed from: c */
            public int a(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.e();
            }

            /* renamed from: d */
            public boolean b(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.f();
            }
        });
    }

    public FontsContractCompat.FontInfo i(FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        return (FontsContractCompat.FontInfo) g(fontInfoArr, i, new StyleExtractor<FontsContractCompat.FontInfo>() {
            /* renamed from: c */
            public int a(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.e();
            }

            /* renamed from: d */
            public boolean b(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.f();
            }
        });
    }
}
