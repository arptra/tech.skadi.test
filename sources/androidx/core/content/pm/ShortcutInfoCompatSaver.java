package androidx.core.content.pm;

import androidx.annotation.RestrictTo;

@RestrictTo
public abstract class ShortcutInfoCompatSaver<T> {

    @RestrictTo
    public static class NoopImpl extends ShortcutInfoCompatSaver<Void> {
    }
}
