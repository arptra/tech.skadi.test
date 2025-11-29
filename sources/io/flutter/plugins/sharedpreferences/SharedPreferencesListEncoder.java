package io.flutter.plugins.sharedpreferences;

import androidx.annotation.NonNull;
import java.util.List;

public interface SharedPreferencesListEncoder {
    @NonNull
    List<String> decode(@NonNull String str);

    @NonNull
    String encode(@NonNull List<String> list);
}
