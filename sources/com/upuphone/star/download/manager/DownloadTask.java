package com.upuphone.star.download.manager;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0015\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u001f\u001a\u0004\b\u0018\u0010\u0011R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u001d\u0010 \u001a\u0004\b\u001b\u0010!¨\u0006\""}, d2 = {"Lcom/upuphone/star/download/manager/DownloadTask;", "", "", "url", "Ljava/io/File;", "file", "", "wifiRequired", "", "retryCount", "", "retryDelay", "<init>", "(Ljava/lang/String;Ljava/io/File;ZIJ)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "d", "b", "Ljava/io/File;", "()Ljava/io/File;", "c", "Z", "e", "()Z", "I", "J", "()J", "lib_download_manager_release"}, k = 1, mv = {1, 9, 0})
public final class DownloadTask {

    /* renamed from: a  reason: collision with root package name */
    public final String f6461a;
    public final File b;
    public final boolean c;
    public final int d;
    public final long e;

    public DownloadTask(String str, File file, boolean z, int i, long j) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(file, "file");
        this.f6461a = str;
        this.b = file;
        this.c = z;
        this.d = i;
        this.e = j;
    }

    public final File a() {
        return this.b;
    }

    public final int b() {
        return this.d;
    }

    public final long c() {
        return this.e;
    }

    public final String d() {
        return this.f6461a;
    }

    public final boolean e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadTask)) {
            return false;
        }
        DownloadTask downloadTask = (DownloadTask) obj;
        return Intrinsics.areEqual((Object) this.f6461a, (Object) downloadTask.f6461a) && Intrinsics.areEqual((Object) this.b, (Object) downloadTask.b) && this.c == downloadTask.c && this.d == downloadTask.d && this.e == downloadTask.e;
    }

    public int hashCode() {
        return (((((((this.f6461a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Long.hashCode(this.e);
    }

    public String toString() {
        String str = this.f6461a;
        File file = this.b;
        boolean z = this.c;
        int i = this.d;
        long j = this.e;
        return "DownloadTask(url=" + str + ", file=" + file + ", wifiRequired=" + z + ", retryCount=" + i + ", retryDelay=" + j + ")";
    }
}
