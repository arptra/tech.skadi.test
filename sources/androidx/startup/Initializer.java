package androidx.startup;

import android.content.Context;
import java.util.List;

public interface Initializer<T> {
    Object a(Context context);

    List dependencies();
}
