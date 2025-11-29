package androidx.emoji2.text;

import android.content.Context;
import androidx.annotation.RequiresApi;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class EmojiCompatInitializer implements Initializer<Boolean> {

    @RequiresApi
    public static class BackgroundDefaultConfig extends EmojiCompat.Config {
        public BackgroundDefaultConfig(Context context) {
            super(new BackgroundDefaultLoader(context));
            b(1);
        }
    }

    @RequiresApi
    public static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {

        /* renamed from: a  reason: collision with root package name */
        public final Context f1199a;

        public BackgroundDefaultLoader(Context context) {
            this.f1199a = context.getApplicationContext();
        }

        public void a(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            ThreadPoolExecutor b = ConcurrencyHelpers.b("EmojiCompatInitializer");
            b.execute(new b(this, metadataRepoLoaderCallback, b));
        }

        /* renamed from: c */
        public void d(final EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, final ThreadPoolExecutor threadPoolExecutor) {
            try {
                FontRequestEmojiCompatConfig a2 = DefaultEmojiCompatConfig.a(this.f1199a);
                if (a2 != null) {
                    a2.c(threadPoolExecutor);
                    a2.a().a(new EmojiCompat.MetadataRepoLoaderCallback() {
                        public void a(Throwable th) {
                            try {
                                metadataRepoLoaderCallback.a(th);
                            } finally {
                                threadPoolExecutor.shutdown();
                            }
                        }

                        public void b(MetadataRepo metadataRepo) {
                            try {
                                metadataRepoLoaderCallback.b(metadataRepo);
                            } finally {
                                threadPoolExecutor.shutdown();
                            }
                        }
                    });
                    return;
                }
                throw new RuntimeException("EmojiCompat font provider not available on this device.");
            } catch (Throwable th) {
                metadataRepoLoaderCallback.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    public static class LoadEmojiCompatRunnable implements Runnable {
        public void run() {
            try {
                TraceCompat.a("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.h()) {
                    EmojiCompat.b().k();
                }
            } finally {
                TraceCompat.b();
            }
        }
    }

    /* renamed from: b */
    public Boolean a(Context context) {
        EmojiCompat.g(new BackgroundDefaultConfig(context));
        c(context);
        return Boolean.TRUE;
    }

    public void c(Context context) {
        final Lifecycle lifecycle = ((LifecycleOwner) AppInitializer.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new DefaultLifecycleObserver() {
            public void onResume(LifecycleOwner lifecycleOwner) {
                EmojiCompatInitializer.this.d();
                lifecycle.d(this);
            }
        });
    }

    public void d() {
        ConcurrencyHelpers.d().postDelayed(new LoadEmojiCompatRunnable(), 500);
    }

    public List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
