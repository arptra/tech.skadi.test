package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@AnyThread
public class EmojiCompat {
    public static final Object n = new Object();
    public static final Object o = new Object();
    public static volatile EmojiCompat p;

    /* renamed from: a  reason: collision with root package name */
    public final ReadWriteLock f1193a = new ReentrantReadWriteLock();
    public final Set b;
    public volatile int c = 3;
    public final Handler d;
    public final CompatInternal e;
    public final MetadataRepoLoader f;
    public final boolean g;
    public final boolean h;
    public final int[] i;
    public final boolean j;
    public final int k;
    public final int l;
    public final GlyphChecker m;

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface CodepointSequenceMatchResult {
    }

    public static class CompatInternal {

        /* renamed from: a  reason: collision with root package name */
        public final EmojiCompat f1194a;

        public CompatInternal(EmojiCompat emojiCompat) {
            this.f1194a = emojiCompat;
        }

        public void a() {
            this.f1194a.n();
        }

        public CharSequence b(CharSequence charSequence, int i, int i2, int i3, boolean z) {
            return charSequence;
        }

        public void c(EditorInfo editorInfo) {
        }
    }

    @RequiresApi
    public static final class CompatInternal19 extends CompatInternal {
        public volatile EmojiProcessor b;
        public volatile MetadataRepo c;

        public CompatInternal19(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        public void a() {
            try {
                this.f1194a.f.a(new MetadataRepoLoaderCallback() {
                    public void a(Throwable th) {
                        CompatInternal19.this.f1194a.m(th);
                    }

                    public void b(MetadataRepo metadataRepo) {
                        CompatInternal19.this.d(metadataRepo);
                    }
                });
            } catch (Throwable th) {
                this.f1194a.m(th);
            }
        }

        public CharSequence b(CharSequence charSequence, int i, int i2, int i3, boolean z) {
            return this.b.h(charSequence, i, i2, i3, z);
        }

        public void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f1194a.g);
        }

        public void d(MetadataRepo metadataRepo) {
            if (metadataRepo == null) {
                this.f1194a.m(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.c = metadataRepo;
            MetadataRepo metadataRepo2 = this.c;
            SpanFactory spanFactory = new SpanFactory();
            GlyphChecker a2 = this.f1194a.m;
            EmojiCompat emojiCompat = this.f1194a;
            this.b = new EmojiProcessor(metadataRepo2, spanFactory, a2, emojiCompat.h, emojiCompat.i);
            this.f1194a.n();
        }
    }

    public static abstract class Config {

        /* renamed from: a  reason: collision with root package name */
        public final MetadataRepoLoader f1196a;
        public boolean b;
        public boolean c;
        public int[] d;
        public Set e;
        public boolean f;
        public int g = -16711936;
        public int h = 0;
        public GlyphChecker i = new DefaultGlyphChecker();

        public Config(MetadataRepoLoader metadataRepoLoader) {
            Preconditions.i(metadataRepoLoader, "metadataLoader cannot be null.");
            this.f1196a = metadataRepoLoader;
        }

        public final MetadataRepoLoader a() {
            return this.f1196a;
        }

        public Config b(int i2) {
            this.h = i2;
            return this;
        }
    }

    public interface GlyphChecker {
        boolean a(CharSequence charSequence, int i, int i2, int i3);
    }

    public static abstract class InitCallback {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    public static class ListenerDispatcher implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final List f1197a;
        public final Throwable b;
        public final int c;

        public ListenerDispatcher(InitCallback initCallback, int i) {
            this(Arrays.asList(new InitCallback[]{(InitCallback) Preconditions.i(initCallback, "initCallback cannot be null")}), i, (Throwable) null);
        }

        public void run() {
            int size = this.f1197a.size();
            int i = 0;
            if (this.c != 1) {
                while (i < size) {
                    ((InitCallback) this.f1197a.get(i)).a(this.b);
                    i++;
                }
                return;
            }
            while (i < size) {
                ((InitCallback) this.f1197a.get(i)).b();
                i++;
            }
        }

        public ListenerDispatcher(Collection collection, int i) {
            this(collection, i, (Throwable) null);
        }

        public ListenerDispatcher(Collection collection, int i, Throwable th) {
            Preconditions.i(collection, "initCallbacks cannot be null");
            this.f1197a = new ArrayList(collection);
            this.c = i;
            this.b = th;
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadStrategy {
    }

    public interface MetadataRepoLoader {
        void a(MetadataRepoLoaderCallback metadataRepoLoaderCallback);
    }

    public static abstract class MetadataRepoLoaderCallback {
        public abstract void a(Throwable th);

        public abstract void b(MetadataRepo metadataRepo);
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ReplaceStrategy {
    }

    @RequiresApi
    @RestrictTo
    public static class SpanFactory {
        public EmojiSpan a(EmojiMetadata emojiMetadata) {
            return new TypefaceEmojiSpan(emojiMetadata);
        }
    }

    public EmojiCompat(Config config) {
        this.g = config.b;
        this.h = config.c;
        this.i = config.d;
        this.j = config.f;
        this.k = config.g;
        this.f = config.f1196a;
        this.l = config.h;
        this.m = config.i;
        this.d = new Handler(Looper.getMainLooper());
        ArraySet arraySet = new ArraySet();
        this.b = arraySet;
        Set set = config.e;
        if (set != null && !set.isEmpty()) {
            arraySet.addAll(config.e);
        }
        this.e = new CompatInternal19(this);
        l();
    }

    public static EmojiCompat b() {
        EmojiCompat emojiCompat;
        synchronized (n) {
            emojiCompat = p;
            Preconditions.k(emojiCompat != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return emojiCompat;
    }

    public static boolean e(InputConnection inputConnection, Editable editable, int i2, int i3, boolean z) {
        return EmojiProcessor.c(inputConnection, editable, i2, i3, z);
    }

    public static boolean f(Editable editable, int i2, KeyEvent keyEvent) {
        return EmojiProcessor.d(editable, i2, keyEvent);
    }

    public static EmojiCompat g(Config config) {
        EmojiCompat emojiCompat = p;
        if (emojiCompat == null) {
            synchronized (n) {
                try {
                    emojiCompat = p;
                    if (emojiCompat == null) {
                        emojiCompat = new EmojiCompat(config);
                        p = emojiCompat;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return emojiCompat;
    }

    public static boolean h() {
        return p != null;
    }

    public int c() {
        return this.k;
    }

    public int d() {
        this.f1193a.readLock().lock();
        try {
            return this.c;
        } finally {
            this.f1193a.readLock().unlock();
        }
    }

    public boolean i() {
        return this.j;
    }

    public final boolean j() {
        return d() == 1;
    }

    public void k() {
        boolean z = true;
        if (this.l != 1) {
            z = false;
        }
        Preconditions.k(z, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (!j()) {
            this.f1193a.writeLock().lock();
            try {
                if (this.c != 0) {
                    this.c = 0;
                    this.f1193a.writeLock().unlock();
                    this.e.a();
                }
            } finally {
                this.f1193a.writeLock().unlock();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public final void l() {
        this.f1193a.writeLock().lock();
        try {
            if (this.l == 0) {
                this.c = 0;
            }
            this.f1193a.writeLock().unlock();
            if (d() == 0) {
                this.e.a();
            }
        } catch (Throwable th) {
            this.f1193a.writeLock().unlock();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public void m(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f1193a.writeLock().lock();
        try {
            this.c = 2;
            arrayList.addAll(this.b);
            this.b.clear();
            this.f1193a.writeLock().unlock();
            this.d.post(new ListenerDispatcher(arrayList, this.c, th));
        } catch (Throwable th2) {
            this.f1193a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public void n() {
        ArrayList arrayList = new ArrayList();
        this.f1193a.writeLock().lock();
        try {
            this.c = 1;
            arrayList.addAll(this.b);
            this.b.clear();
            this.f1193a.writeLock().unlock();
            this.d.post(new ListenerDispatcher((Collection) arrayList, this.c));
        } catch (Throwable th) {
            this.f1193a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence o(CharSequence charSequence) {
        return p(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence p(CharSequence charSequence, int i2, int i3) {
        return q(charSequence, i2, i3, Integer.MAX_VALUE);
    }

    public CharSequence q(CharSequence charSequence, int i2, int i3, int i4) {
        return r(charSequence, i2, i3, i4, 0);
    }

    public CharSequence r(CharSequence charSequence, int i2, int i3, int i4, int i5) {
        boolean z;
        Preconditions.k(j(), "Not initialized yet");
        Preconditions.f(i2, "start cannot be negative");
        Preconditions.f(i3, "end cannot be negative");
        Preconditions.f(i4, "maxEmojiCount cannot be negative");
        boolean z2 = false;
        Preconditions.b(i2 <= i3, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        Preconditions.b(i2 <= charSequence.length(), "start should be < than charSequence length");
        Preconditions.b(i3 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i2 == i3) {
            return charSequence;
        }
        if (i5 != 1) {
            if (i5 != 2) {
                z2 = this.g;
            }
            z = z2;
        } else {
            z = true;
        }
        return this.e.b(charSequence, i2, i3, i4, z);
    }

    public void s(InitCallback initCallback) {
        Preconditions.i(initCallback, "initCallback cannot be null");
        this.f1193a.writeLock().lock();
        try {
            if (this.c != 1) {
                if (this.c != 2) {
                    this.b.add(initCallback);
                }
            }
            this.d.post(new ListenerDispatcher(initCallback, this.c));
        } finally {
            this.f1193a.writeLock().unlock();
        }
    }

    public void t(InitCallback initCallback) {
        Preconditions.i(initCallback, "initCallback cannot be null");
        this.f1193a.writeLock().lock();
        try {
            this.b.remove(initCallback);
        } finally {
            this.f1193a.writeLock().unlock();
        }
    }

    public void u(EditorInfo editorInfo) {
        if (j() && editorInfo != null) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            this.e.c(editorInfo);
        }
    }
}
