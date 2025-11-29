package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class RemoteInput {

    /* renamed from: a  reason: collision with root package name */
    public final String f680a;
    public final CharSequence b;
    public final CharSequence[] c;
    public final boolean d;
    public final int e;
    public final Bundle f;
    public final Set g;

    @RequiresApi
    public static class Api20Impl {
        @DoNotInline
        public static void a(Object obj, Intent intent, Bundle bundle) {
            android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[]) obj, intent, bundle);
        }

        public static android.app.RemoteInput b(RemoteInput remoteInput) {
            RemoteInput.Builder addExtras = new RemoteInput.Builder(remoteInput.i()).setLabel(remoteInput.h()).setChoices(remoteInput.e()).setAllowFreeFormInput(remoteInput.c()).addExtras(remoteInput.g());
            Set<String> d = remoteInput.d();
            if (d != null) {
                for (String d2 : d) {
                    Api26Impl.d(addExtras, d2, true);
                }
            }
            Api29Impl.b(addExtras, remoteInput.f());
            return addExtras.build();
        }

        @DoNotInline
        public static Bundle c(Intent intent) {
            return android.app.RemoteInput.getResultsFromIntent(intent);
        }
    }

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        public static void a(RemoteInput remoteInput, Intent intent, Map<String, Uri> map) {
            android.app.RemoteInput.addDataResultToIntent(RemoteInput.a(remoteInput), intent, map);
        }

        @DoNotInline
        public static Set<String> b(Object obj) {
            return ((android.app.RemoteInput) obj).getAllowedDataTypes();
        }

        @DoNotInline
        public static Map<String, Uri> c(Intent intent, String str) {
            return android.app.RemoteInput.getDataResultsFromIntent(intent, str);
        }

        @DoNotInline
        public static RemoteInput.Builder d(RemoteInput.Builder builder, String str, boolean z) {
            return builder.setAllowDataType(str, z);
        }
    }

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static int a(Intent intent) {
            return android.app.RemoteInput.getResultsSource(intent);
        }

        @DoNotInline
        public static void b(Intent intent, int i) {
            android.app.RemoteInput.setResultsSource(intent, i);
        }
    }

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static int a(Object obj) {
            return ((android.app.RemoteInput) obj).getEditChoicesBeforeSending();
        }

        @DoNotInline
        public static RemoteInput.Builder b(RemoteInput.Builder builder, int i) {
            return builder.setEditChoicesBeforeSending(i);
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final String f681a;
        public final Set b = new HashSet();
        public final Bundle c = new Bundle();
        public CharSequence d;
        public CharSequence[] e;
        public boolean f = true;
        public int g = 0;

        public Builder(String str) {
            if (str != null) {
                this.f681a = str;
                return;
            }
            throw new IllegalArgumentException("Result key can't be null");
        }

        public RemoteInput a() {
            return new RemoteInput(this.f681a, this.d, this.e, this.f, this.g, this.c, this.b);
        }

        public Builder b(String str, boolean z) {
            if (z) {
                this.b.add(str);
            } else {
                this.b.remove(str);
            }
            return this;
        }

        public Builder c(boolean z) {
            this.f = z;
            return this;
        }

        public Builder d(CharSequence[] charSequenceArr) {
            this.e = charSequenceArr;
            return this;
        }

        public Builder e(CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface EditChoicesBeforeSending {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    public RemoteInput(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, int i, Bundle bundle, Set set) {
        this.f680a = str;
        this.b = charSequence;
        this.c = charSequenceArr;
        this.d = z;
        this.e = i;
        this.f = bundle;
        this.g = set;
        if (f() == 2 && !c()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    public static android.app.RemoteInput a(RemoteInput remoteInput) {
        return Api20Impl.b(remoteInput);
    }

    public static android.app.RemoteInput[] b(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            remoteInputArr2[i] = a(remoteInputArr[i]);
        }
        return remoteInputArr2;
    }

    public static Bundle j(Intent intent) {
        return Api20Impl.c(intent);
    }

    public boolean c() {
        return this.d;
    }

    public Set d() {
        return this.g;
    }

    public CharSequence[] e() {
        return this.c;
    }

    public int f() {
        return this.e;
    }

    public Bundle g() {
        return this.f;
    }

    public CharSequence h() {
        return this.b;
    }

    public String i() {
        return this.f680a;
    }

    public boolean k() {
        return !c() && (e() == null || e().length == 0) && d() != null && !d().isEmpty();
    }
}
