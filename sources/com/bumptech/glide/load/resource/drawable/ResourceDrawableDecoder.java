package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.util.List;

public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {
    public static final Option b = Option.e("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme");

    /* renamed from: a  reason: collision with root package name */
    public final Context f2659a;

    public ResourceDrawableDecoder(Context context) {
        this.f2659a = context.getApplicationContext();
    }

    /* renamed from: c */
    public Resource b(Uri uri, int i, int i2, Options options) {
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            Context d = d(uri, authority);
            int g = g(d, uri);
            Resources.Theme theme = ((String) Preconditions.d(authority)).equals(this.f2659a.getPackageName()) ? (Resources.Theme) options.c(b) : null;
            return NonOwnedDrawableResource.e(theme == null ? DrawableDecoderCompat.b(this.f2659a, d, g) : DrawableDecoderCompat.a(this.f2659a, g, theme));
        }
        throw new IllegalStateException("Package name for " + uri + " is null or empty");
    }

    public final Context d(Uri uri, String str) {
        if (str.equals(this.f2659a.getPackageName())) {
            return this.f2659a;
        }
        try {
            return this.f2659a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (str.contains(this.f2659a.getPackageName())) {
                return this.f2659a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
        }
    }

    public final int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e);
        }
    }

    public final int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    public final int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    /* renamed from: h */
    public boolean a(Uri uri, Options options) {
        String scheme = uri.getScheme();
        return scheme != null && scheme.equals("android.resource");
    }
}
