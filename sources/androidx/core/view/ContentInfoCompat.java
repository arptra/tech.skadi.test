package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import com.honey.account.q.a;
import com.honey.account.q.b;
import com.honey.account.q.e;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public final class ContentInfoCompat {

    /* renamed from: a  reason: collision with root package name */
    public final Compat f862a;

    @RequiresApi
    public static final class Api31Impl {
        @DoNotInline
        @NonNull
        public static Pair<ContentInfo, ContentInfo> a(@NonNull ContentInfo contentInfo, @NonNull Predicate<ClipData.Item> predicate) {
            ClipData clip = contentInfo.getClip();
            if (clip.getItemCount() == 1) {
                boolean test = predicate.test(clip.getItemAt(0));
                ContentInfo contentInfo2 = test ? contentInfo : null;
                if (test) {
                    contentInfo = null;
                }
                return Pair.create(contentInfo2, contentInfo);
            }
            Objects.requireNonNull(predicate);
            Pair f = ContentInfoCompat.f(clip, new b(predicate));
            return f.first == null ? Pair.create((Object) null, contentInfo) : f.second == null ? Pair.create(contentInfo, (Object) null) : Pair.create(new ContentInfo.Builder(contentInfo).setClip((ClipData) f.first).build(), new ContentInfo.Builder(contentInfo).setClip((ClipData) f.second).build());
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final BuilderCompat f863a;

        public Builder(ClipData clipData, int i) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f863a = new BuilderCompat31Impl(clipData, i);
            } else {
                this.f863a = new BuilderCompatImpl(clipData, i);
            }
        }

        public ContentInfoCompat a() {
            return this.f863a.build();
        }

        public Builder b(Bundle bundle) {
            this.f863a.setExtras(bundle);
            return this;
        }

        public Builder c(int i) {
            this.f863a.setFlags(i);
            return this;
        }

        public Builder d(Uri uri) {
            this.f863a.a(uri);
            return this;
        }
    }

    public interface BuilderCompat {
        void a(Uri uri);

        ContentInfoCompat build();

        void setExtras(Bundle bundle);

        void setFlags(int i);
    }

    @RequiresApi
    public static final class BuilderCompat31Impl implements BuilderCompat {

        /* renamed from: a  reason: collision with root package name */
        public final ContentInfo.Builder f864a;

        public BuilderCompat31Impl(ClipData clipData, int i) {
            this.f864a = e.a(clipData, i);
        }

        public void a(Uri uri) {
            ContentInfo.Builder unused = this.f864a.setLinkUri(uri);
        }

        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.f864a.build()));
        }

        public void setExtras(Bundle bundle) {
            ContentInfo.Builder unused = this.f864a.setExtras(bundle);
        }

        public void setFlags(int i) {
            ContentInfo.Builder unused = this.f864a.setFlags(i);
        }
    }

    public static final class BuilderCompatImpl implements BuilderCompat {

        /* renamed from: a  reason: collision with root package name */
        public ClipData f865a;
        public int b;
        public int c;
        public Uri d;
        public Bundle e;

        public BuilderCompatImpl(ClipData clipData, int i) {
            this.f865a = clipData;
            this.b = i;
        }

        public void a(Uri uri) {
            this.d = uri;
        }

        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        public void setExtras(Bundle bundle) {
            this.e = bundle;
        }

        public void setFlags(int i) {
            this.c = i;
        }
    }

    public interface Compat {
        ContentInfo a();

        ClipData b();

        int getFlags();

        int getSource();
    }

    @RequiresApi
    public static final class Compat31Impl implements Compat {

        /* renamed from: a  reason: collision with root package name */
        public final ContentInfo f866a;

        public Compat31Impl(ContentInfo contentInfo) {
            this.f866a = a.a(Preconditions.h(contentInfo));
        }

        public ContentInfo a() {
            return this.f866a;
        }

        public ClipData b() {
            return this.f866a.getClip();
        }

        public int getFlags() {
            return this.f866a.getFlags();
        }

        public int getSource() {
            return this.f866a.getSource();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f866a + "}";
        }
    }

    public static final class CompatImpl implements Compat {

        /* renamed from: a  reason: collision with root package name */
        public final ClipData f867a;
        public final int b;
        public final int c;
        public final Uri d;
        public final Bundle e;

        public CompatImpl(BuilderCompatImpl builderCompatImpl) {
            this.f867a = (ClipData) Preconditions.h(builderCompatImpl.f865a);
            this.b = Preconditions.d(builderCompatImpl.b, 0, 5, "source");
            this.c = Preconditions.g(builderCompatImpl.c, 1);
            this.d = builderCompatImpl.d;
            this.e = builderCompatImpl.e;
        }

        public ContentInfo a() {
            return null;
        }

        public ClipData b() {
            return this.f867a;
        }

        public int getFlags() {
            return this.c;
        }

        public int getSource() {
            return this.b;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.f867a.getDescription());
            sb.append(", source=");
            sb.append(ContentInfoCompat.g(this.b));
            sb.append(", flags=");
            sb.append(ContentInfoCompat.b(this.c));
            String str2 = "";
            if (this.d == null) {
                str = str2;
            } else {
                str = ", hasLinkUri(" + this.d.toString().length() + ")";
            }
            sb.append(str);
            if (this.e != null) {
                str2 = ", hasExtras";
            }
            sb.append(str2);
            sb.append("}");
            return sb.toString();
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    public ContentInfoCompat(Compat compat) {
        this.f862a = compat;
    }

    public static ClipData a(ClipDescription clipDescription, List list) {
        ClipData clipData = new ClipData(new ClipDescription(clipDescription), (ClipData.Item) list.get(0));
        for (int i = 1; i < list.size(); i++) {
            clipData.addItem((ClipData.Item) list.get(i));
        }
        return clipData;
    }

    public static String b(int i) {
        return (i & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i);
    }

    public static Pair f(ClipData clipData, androidx.core.util.Predicate predicate) {
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (int i = 0; i < clipData.getItemCount(); i++) {
            ClipData.Item itemAt = clipData.getItemAt(i);
            if (predicate.test(itemAt)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(itemAt);
            } else {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(itemAt);
            }
        }
        return arrayList == null ? Pair.create((Object) null, clipData) : arrayList2 == null ? Pair.create(clipData, (Object) null) : Pair.create(a(clipData.getDescription(), arrayList), a(clipData.getDescription(), arrayList2));
    }

    public static String g(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    public static ContentInfoCompat i(ContentInfo contentInfo) {
        return new ContentInfoCompat(new Compat31Impl(contentInfo));
    }

    public ClipData c() {
        return this.f862a.b();
    }

    public int d() {
        return this.f862a.getFlags();
    }

    public int e() {
        return this.f862a.getSource();
    }

    public ContentInfo h() {
        ContentInfo a2 = this.f862a.a();
        Objects.requireNonNull(a2);
        return a.a(a2);
    }

    public String toString() {
        return this.f862a.toString();
    }
}
