package androidx.core.content;

import android.content.ClipData;
import android.content.Intent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.util.Consumer;

public class IntentSanitizer {

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static String a(Intent intent) {
            return intent.getIdentifier();
        }

        @DoNotInline
        public static Intent b(Intent intent, String str) {
            return intent.setIdentifier(str);
        }
    }

    @RequiresApi
    public static class Api31Impl {
        @DoNotInline
        public static void a(int i, ClipData.Item item, Consumer<String> consumer) {
            if (item.getHtmlText() != null || item.getIntent() != null || item.getTextLinks() != null) {
                consumer.accept("ClipData item at position " + i + " contains htmlText, textLinks or intent: " + item);
            }
        }
    }

    public static final class Builder {
    }
}
