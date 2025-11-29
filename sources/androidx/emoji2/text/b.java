package androidx.emoji2.text;

import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import java.util.concurrent.ThreadPoolExecutor;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmojiCompatInitializer.BackgroundDefaultLoader f1217a;
    public final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback b;
    public final /* synthetic */ ThreadPoolExecutor c;

    public /* synthetic */ b(EmojiCompatInitializer.BackgroundDefaultLoader backgroundDefaultLoader, EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
        this.f1217a = backgroundDefaultLoader;
        this.b = metadataRepoLoaderCallback;
        this.c = threadPoolExecutor;
    }

    public final void run() {
        this.f1217a.d(this.b, this.c);
    }
}
