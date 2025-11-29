package androidx.core.app;

import android.app.Person;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.IconCompat;
import com.upuphone.runasone.relay.api.IntentKey;
import java.util.Objects;

public class Person {

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f676a;
    public IconCompat b;
    public String c;
    public String d;
    public boolean e;
    public boolean f;

    @RequiresApi
    public static class Api22Impl {
        @DoNotInline
        public static Person a(PersistableBundle persistableBundle) {
            return new Builder().f(persistableBundle.getString("name")).g(persistableBundle.getString("uri")).e(persistableBundle.getString(IntentKey.ACTIVITY.ACTION_KEY)).b(persistableBundle.getBoolean("isBot")).d(persistableBundle.getBoolean("isImportant")).a();
        }

        @DoNotInline
        public static PersistableBundle b(Person person) {
            PersistableBundle persistableBundle = new PersistableBundle();
            CharSequence charSequence = person.f676a;
            persistableBundle.putString("name", charSequence != null ? charSequence.toString() : null);
            persistableBundle.putString("uri", person.c);
            persistableBundle.putString(IntentKey.ACTIVITY.ACTION_KEY, person.d);
            persistableBundle.putBoolean("isBot", person.e);
            persistableBundle.putBoolean("isImportant", person.f);
            return persistableBundle;
        }
    }

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static Person a(android.app.Person person) {
            return new Builder().f(person.getName()).c(person.getIcon() != null ? IconCompat.c(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        @DoNotInline
        public static android.app.Person b(Person person) {
            return new Person.Builder().setName(person.e()).setIcon(person.c() != null ? person.c().w() : null).setUri(person.f()).setKey(person.d()).setBot(person.g()).setImportant(person.h()).build();
        }
    }

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f677a;
        public IconCompat b;
        public String c;
        public String d;
        public boolean e;
        public boolean f;

        public Person a() {
            return new Person(this);
        }

        public Builder b(boolean z) {
            this.e = z;
            return this;
        }

        public Builder c(IconCompat iconCompat) {
            this.b = iconCompat;
            return this;
        }

        public Builder d(boolean z) {
            this.f = z;
            return this;
        }

        public Builder e(String str) {
            this.d = str;
            return this;
        }

        public Builder f(CharSequence charSequence) {
            this.f677a = charSequence;
            return this;
        }

        public Builder g(String str) {
            this.c = str;
            return this;
        }
    }

    public Person(Builder builder) {
        this.f676a = builder.f677a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
    }

    public static Person a(android.app.Person person) {
        return Api28Impl.a(person);
    }

    public static Person b(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("icon");
        return new Builder().f(bundle.getCharSequence("name")).c(bundle2 != null ? IconCompat.b(bundle2) : null).g(bundle.getString("uri")).e(bundle.getString(IntentKey.ACTIVITY.ACTION_KEY)).b(bundle.getBoolean("isBot")).d(bundle.getBoolean("isImportant")).a();
    }

    public IconCompat c() {
        return this.b;
    }

    public String d() {
        return this.d;
    }

    public CharSequence e() {
        return this.f676a;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        String d2 = d();
        String d3 = person.d();
        return (d2 == null && d3 == null) ? Objects.equals(Objects.toString(e()), Objects.toString(person.e())) && Objects.equals(f(), person.f()) && Boolean.valueOf(g()).equals(Boolean.valueOf(person.g())) && Boolean.valueOf(h()).equals(Boolean.valueOf(person.h())) : Objects.equals(d2, d3);
    }

    public String f() {
        return this.c;
    }

    public boolean g() {
        return this.e;
    }

    public boolean h() {
        return this.f;
    }

    public int hashCode() {
        String d2 = d();
        return d2 != null ? d2.hashCode() : Objects.hash(new Object[]{e(), f(), Boolean.valueOf(g()), Boolean.valueOf(h())});
    }

    public android.app.Person i() {
        return Api28Impl.b(this);
    }

    public Bundle j() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f676a);
        IconCompat iconCompat = this.b;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.v() : null);
        bundle.putString("uri", this.c);
        bundle.putString(IntentKey.ACTIVITY.ACTION_KEY, this.d);
        bundle.putBoolean("isBot", this.e);
        bundle.putBoolean("isImportant", this.f);
        return bundle;
    }
}
