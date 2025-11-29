package com.upuphone.xr.sapp.audio;

import android.media.AudioManager;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/media/AudioManager;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ArAudioFocusManager$audioManager$2 extends Lambda implements Function0<AudioManager> {
    public static final ArAudioFocusManager$audioManager$2 INSTANCE = new ArAudioFocusManager$audioManager$2();

    public ArAudioFocusManager$audioManager$2() {
        super(0);
    }

    @NotNull
    public final AudioManager invoke() {
        Object systemService = GlobalExtKt.f().getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        return (AudioManager) systemService;
    }
}
