package com.upuphone.xr.sapp.adapter;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/adapter/FeedBackFile;", "", "Landroid/net/Uri;", "uri", "", "compressPath", "<init>", "(Landroid/net/Uri;Ljava/lang/String;)V", "a", "Landroid/net/Uri;", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "b", "Ljava/lang/String;", "getCompressPath", "()Ljava/lang/String;", "setCompressPath", "(Ljava/lang/String;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FeedBackFile {

    /* renamed from: a  reason: collision with root package name */
    public Uri f6604a;
    public String b;

    public FeedBackFile(Uri uri, String str) {
        this.f6604a = uri;
        this.b = str;
    }

    public final Uri a() {
        return this.f6604a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedBackFile(Uri uri, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, (i & 2) != 0 ? null : str);
    }
}
