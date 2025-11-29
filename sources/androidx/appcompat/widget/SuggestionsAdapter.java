package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    public final SearchView m;
    public final SearchableInfo n;
    public final Context o;
    public final WeakHashMap p;
    public final int q;
    public boolean r = false;
    public int s = 1;
    public ColorStateList t;
    public int u = -1;
    public int v = -1;
    public int w = -1;
    public int x = -1;
    public int y = -1;
    public int z = -1;

    public static final class ChildViewCache {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f360a;
        public final TextView b;
        public final ImageView c;
        public final ImageView d;
        public final ImageView e;

        public ChildViewCache(View view) {
            this.f360a = (TextView) view.findViewById(16908308);
            this.b = (TextView) view.findViewById(16908309);
            this.c = (ImageView) view.findViewById(16908295);
            this.d = (ImageView) view.findViewById(16908296);
            this.e = (ImageView) view.findViewById(R.id.edit_query);
        }
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.m = searchView;
        this.n = searchableInfo;
        this.q = searchView.getSuggestionCommitIconResId();
        this.o = context;
        this.p = weakHashMap;
    }

    public static String k(Cursor cursor, String str) {
        return s(cursor, cursor.getColumnIndex(str));
    }

    public static String s(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    public void a(View view, Context context, Cursor cursor) {
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        int i = this.z;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (childViewCache.f360a != null) {
            v(childViewCache.f360a, s(cursor, this.u));
        }
        if (childViewCache.b != null) {
            String s2 = s(cursor, this.w);
            CharSequence h = s2 != null ? h(s2) : s(cursor, this.v);
            if (TextUtils.isEmpty(h)) {
                TextView textView = childViewCache.f360a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    childViewCache.f360a.setMaxLines(2);
                }
            } else {
                TextView textView2 = childViewCache.f360a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    childViewCache.f360a.setMaxLines(1);
                }
            }
            v(childViewCache.b, h);
        }
        ImageView imageView = childViewCache.c;
        if (imageView != null) {
            u(imageView, p(cursor), 4);
        }
        ImageView imageView2 = childViewCache.d;
        if (imageView2 != null) {
            u(imageView2, q(cursor), 8);
        }
        int i3 = this.s;
        if (i3 == 2 || (i3 == 1 && (i2 & 1) != 0)) {
            childViewCache.e.setVisibility(0);
            childViewCache.e.setTag(childViewCache.f360a.getText());
            childViewCache.e.setOnClickListener(this);
            return;
        }
        childViewCache.e.setVisibility(8);
    }

    public void changeCursor(Cursor cursor) {
        if (this.r) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.u = cursor.getColumnIndex("suggest_text_1");
                this.v = cursor.getColumnIndex("suggest_text_2");
                this.w = cursor.getColumnIndex("suggest_text_2_url");
                this.x = cursor.getColumnIndex("suggest_icon_1");
                this.y = cursor.getColumnIndex("suggest_icon_2");
                this.z = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        String k;
        String k2;
        if (cursor == null) {
            return null;
        }
        String k3 = k(cursor, "suggest_intent_query");
        if (k3 != null) {
            return k3;
        }
        if (this.n.shouldRewriteQueryFromData() && (k2 = k(cursor, "suggest_intent_data")) != null) {
            return k2;
        }
        if (!this.n.shouldRewriteQueryFromText() || (k = k(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return k;
    }

    public View d(Context context, Cursor cursor, ViewGroup viewGroup) {
        View d = super.d(context, cursor, viewGroup);
        d.setTag(new ChildViewCache(d));
        ((ImageView) d.findViewById(R.id.edit_query)).setImageResource(this.q);
        return d;
    }

    public final Drawable g(String str) {
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.p.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View c = c(this.o, getCursor(), viewGroup);
            if (c != null) {
                ((ChildViewCache) c.getTag()).f360a.setText(e.toString());
            }
            return c;
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View d = d(this.o, getCursor(), viewGroup);
            if (d != null) {
                ((ChildViewCache) d.getTag()).f360a.setText(e.toString());
            }
            return d;
        }
    }

    public final CharSequence h(CharSequence charSequence) {
        if (this.t == null) {
            TypedValue typedValue = new TypedValue();
            this.o.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
            this.t = this.o.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan((String) null, 0, 0, this.t, (ColorStateList) null), 0, charSequence.length(), 33);
        return spannableString;
    }

    public boolean hasStableIds() {
        return false;
    }

    public final Drawable i(ComponentName componentName) {
        PackageManager packageManager = this.o.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    public final Drawable j(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.p.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = (Drawable.ConstantState) this.p.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.o.getResources());
        }
        Drawable i = i(componentName);
        if (i != null) {
            constantState = i.getConstantState();
        }
        this.p.put(flattenToShortString, constantState);
        return i;
    }

    public final Drawable l() {
        Drawable j = j(this.n.getSearchActivity());
        return j != null ? j : this.o.getPackageManager().getDefaultActivityIcon();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:8|9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: " + r6);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable m(android.net.Uri r6) {
        /*
            r5 = this;
            java.lang.String r0 = "Error closing icon stream for "
            java.lang.String r1 = "SuggestionsAdapter"
            r2 = 0
            java.lang.String r3 = r6.getScheme()     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r4 = "android.resource"
            boolean r3 = r4.equals(r3)     // Catch:{ FileNotFoundException -> 0x0016 }
            if (r3 == 0) goto L_0x002f
            android.graphics.drawable.Drawable r5 = r5.n(r6)     // Catch:{ NotFoundException -> 0x0018 }
            return r5
        L_0x0016:
            r5 = move-exception
            goto L_0x0087
        L_0x0018:
            java.io.FileNotFoundException r5 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0016 }
            r0.<init>()     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r3 = "Resource does not exist: "
            r0.append(r3)     // Catch:{ FileNotFoundException -> 0x0016 }
            r0.append(r6)     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r0 = r0.toString()     // Catch:{ FileNotFoundException -> 0x0016 }
            r5.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0016 }
            throw r5     // Catch:{ FileNotFoundException -> 0x0016 }
        L_0x002f:
            android.content.Context r5 = r5.o     // Catch:{ FileNotFoundException -> 0x0016 }
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0016 }
            java.io.InputStream r5 = r5.openInputStream(r6)     // Catch:{ FileNotFoundException -> 0x0016 }
            if (r5 == 0) goto L_0x0070
            android.graphics.drawable.Drawable r3 = android.graphics.drawable.Drawable.createFromStream(r5, r2)     // Catch:{ all -> 0x0057 }
            r5.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0056
        L_0x0043:
            r5 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0016 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0016 }
            r4.append(r0)     // Catch:{ FileNotFoundException -> 0x0016 }
            r4.append(r6)     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r0 = r4.toString()     // Catch:{ FileNotFoundException -> 0x0016 }
            android.util.Log.e(r1, r0, r5)     // Catch:{ FileNotFoundException -> 0x0016 }
        L_0x0056:
            return r3
        L_0x0057:
            r3 = move-exception
            r5.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x006f
        L_0x005c:
            r5 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0016 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0016 }
            r4.append(r0)     // Catch:{ FileNotFoundException -> 0x0016 }
            r4.append(r6)     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r0 = r4.toString()     // Catch:{ FileNotFoundException -> 0x0016 }
            android.util.Log.e(r1, r0, r5)     // Catch:{ FileNotFoundException -> 0x0016 }
        L_0x006f:
            throw r3     // Catch:{ FileNotFoundException -> 0x0016 }
        L_0x0070:
            java.io.FileNotFoundException r5 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0016 }
            r0.<init>()     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r3 = "Failed to open "
            r0.append(r3)     // Catch:{ FileNotFoundException -> 0x0016 }
            r0.append(r6)     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r0 = r0.toString()     // Catch:{ FileNotFoundException -> 0x0016 }
            r5.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0016 }
            throw r5     // Catch:{ FileNotFoundException -> 0x0016 }
        L_0x0087:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Icon not found: "
            r0.append(r3)
            r0.append(r6)
            java.lang.String r6 = ", "
            r0.append(r6)
            java.lang.String r5 = r5.getMessage()
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            android.util.Log.w(r1, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SuggestionsAdapter.m(android.net.Uri):android.graphics.drawable.Drawable");
    }

    public Drawable n(Uri uri) {
        int i;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.o.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        i = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (i != 0) {
                        return resourcesForApplication.getDrawable(i);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        x(getCursor());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        x(getCursor());
    }

    public final Drawable o(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.o.getPackageName() + "/" + parseInt;
            Drawable g = g(str2);
            if (g != null) {
                return g;
            }
            Drawable drawable = ContextCompat.getDrawable(this.o, parseInt);
            w(str2, drawable);
            return drawable;
        } catch (NumberFormatException unused) {
            Drawable g2 = g(str);
            if (g2 != null) {
                return g2;
            }
            Drawable m2 = m(Uri.parse(str));
            w(str, m2);
            return m2;
        } catch (Resources.NotFoundException unused2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.m.w((CharSequence) tag);
        }
    }

    public final Drawable p(Cursor cursor) {
        int i = this.x;
        if (i == -1) {
            return null;
        }
        Drawable o2 = o(cursor.getString(i));
        return o2 != null ? o2 : l();
    }

    public final Drawable q(Cursor cursor) {
        int i = this.y;
        if (i == -1) {
            return null;
        }
        return o(cursor.getString(i));
    }

    public Cursor r(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.o.getContentResolver().query(fragment.build(), (String[]) null, suggestSelection, strArr2, (String) null);
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.m.getVisibility() == 0 && this.m.getWindowVisibility() == 0) {
            try {
                Cursor r2 = r(this.n, charSequence2, 50);
                if (r2 != null) {
                    r2.getCount();
                    return r2;
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
        }
        return null;
    }

    public void t(int i) {
        this.s = i;
    }

    public final void u(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final void v(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    public final void w(String str, Drawable drawable) {
        if (drawable != null) {
            this.p.put(str, drawable.getConstantState());
        }
    }

    public final void x(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }
}
