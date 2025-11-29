package androidx.core.os;

import android.os.LocaleList;
import androidx.annotation.RequiresApi;
import java.util.Locale;

@RequiresApi
final class LocaleListPlatformWrapper implements LocaleListInterface {

    /* renamed from: a  reason: collision with root package name */
    public final LocaleList f778a;

    public LocaleListPlatformWrapper(Object obj) {
        this.f778a = (LocaleList) obj;
    }

    public String a() {
        return this.f778a.toLanguageTags();
    }

    public Object b() {
        return this.f778a;
    }

    public boolean equals(Object obj) {
        return this.f778a.equals(((LocaleListInterface) obj).b());
    }

    public Locale get(int i) {
        return this.f778a.get(i);
    }

    public int hashCode() {
        return this.f778a.hashCode();
    }

    public boolean isEmpty() {
        return this.f778a.isEmpty();
    }

    public int size() {
        return this.f778a.size();
    }

    public String toString() {
        return this.f778a.toString();
    }
}
