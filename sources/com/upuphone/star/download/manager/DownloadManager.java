package com.upuphone.star.download.manager;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.star.download.manager.db.DownloadDb;
import com.upuphone.star.download.manager.exception.NetworkNotAvailableException;
import com.upuphone.star.download.manager.exception.WifiRequiredException;
import com.upuphone.star.httplib.HttpUtils;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import java.io.File;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import okhttp3.logging.HttpLoggingInterceptor;
import rxhttp.RxHttpPlugins;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJC\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H@¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b!\u0010\"J)\u0010$\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010#\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b&\u0010\"J'\u0010)\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\bR \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020-0,8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R \u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0,8\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00106\u001a\u0002038\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078BX\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lcom/upuphone/star/download/manager/DownloadManager;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "msg", "", "p", "(Ljava/lang/String;)V", "url", "Ljava/io/File;", "file", "", "wifiRequired", "", "retryCount", "", "retryDelay", "Lcom/upuphone/star/download/manager/DownloadListener;", "downloadListener", "Lcom/upuphone/star/download/manager/DownloadTask;", "s", "(Ljava/lang/String;Ljava/io/File;ZIJLcom/upuphone/star/download/manager/DownloadListener;)Lcom/upuphone/star/download/manager/DownloadTask;", "downloadTask", "deleteFile", "j", "(Lcom/upuphone/star/download/manager/DownloadTask;Z)V", "m", "(Lcom/upuphone/star/download/manager/DownloadTask;)Z", "filePath", "Lcom/upuphone/star/download/manager/db/DownloadStatus;", "r", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "w", "(Lcom/upuphone/star/download/manager/DownloadTask;Lcom/upuphone/star/download/manager/DownloadListener;)V", "isFirstTime", "v", "(Lcom/upuphone/star/download/manager/DownloadTask;ZLcom/upuphone/star/download/manager/DownloadListener;)V", "q", "", "exception", "k", "(Lcom/upuphone/star/download/manager/DownloadTask;Lcom/upuphone/star/download/manager/DownloadListener;Ljava/lang/Throwable;)V", "n", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlinx/coroutines/Job;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "runningTasks", "d", "runningTaskCounts", "Lokhttp3/logging/HttpLoggingInterceptor;", "e", "Lokhttp3/logging/HttpLoggingInterceptor;", "httpLoggingInterceptor", "Landroid/content/Context;", "l", "()Landroid/content/Context;", "context", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "lib_download_manager_release"}, k = 1, mv = {1, 9, 0})
public final class DownloadManager implements CoroutineScope {
    public static final DownloadManager b = new DownloadManager();
    public static final ConcurrentHashMap c = new ConcurrentHashMap();
    public static final ConcurrentHashMap d = new ConcurrentHashMap();
    public static final HttpLoggingInterceptor e = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f6459a = CoroutineScopeKt.b();

    static {
        RxHttpPlugins.g(HttpUtils.f6479a.j(AnonymousClass1.INSTANCE));
    }

    /* access modifiers changed from: private */
    public final Context l() {
        return SdkContext.f6675a.c().getContext();
    }

    private final void p(String str) {
        ULog.f6446a.c("DownloadManager", str);
    }

    public static /* synthetic */ DownloadTask t(DownloadManager downloadManager, String str, File file, boolean z, int i, long j, DownloadListener downloadListener, int i2, Object obj) {
        return downloadManager.s(str, file, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? 1000 : j, downloadListener);
    }

    public CoroutineContext getCoroutineContext() {
        return this.f6459a.getCoroutineContext();
    }

    public final void j(DownloadTask downloadTask, boolean z) {
        Intrinsics.checkNotNullParameter(downloadTask, "downloadTask");
        Job job = (Job) c.remove(downloadTask);
        Boolean valueOf = job != null ? Boolean.valueOf(job.isActive()) : null;
        n("cancelDownload, downloadTask: " + downloadTask + ", deleteFile: " + z + ", isRunning: " + valueOf);
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        if (z) {
            try {
                File a2 = downloadTask.a();
                n("cancelDownload, deleteFile in: " + a2);
                downloadTask.a().delete();
            } catch (Exception e2) {
                p("cancelDownload, deleteFile error: " + e2);
            }
        }
    }

    public final void k(DownloadTask downloadTask, DownloadListener downloadListener, Throwable th) {
        Integer num = (Integer) d.get(downloadTask);
        if (num == null || num.intValue() <= downloadTask.b()) {
            NetworkUtils networkUtils = NetworkUtils.f7898a;
            if (!networkUtils.g()) {
                n("checkShouldRetry, hasNetwork=false, downloadTask: " + downloadTask);
                downloadListener.b(downloadTask, th);
            } else if (!downloadTask.e() || networkUtils.i()) {
                Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new DownloadManager$checkShouldRetry$2(downloadTask, downloadListener, (Continuation<? super DownloadManager$checkShouldRetry$2>) null), 3, (Object) null);
            } else {
                n("checkShouldRetry, hasWifi=false, wifiRequired=true, downloadTask: " + downloadTask);
                downloadListener.b(downloadTask, th);
            }
        } else {
            DownloadManager downloadManager = b;
            downloadManager.n("checkShouldRetry, downloadCount reach max count: " + num);
            downloadListener.b(downloadTask, th);
        }
    }

    public final boolean m(DownloadTask downloadTask) {
        Intrinsics.checkNotNullParameter(downloadTask, "downloadTask");
        Job job = (Job) c.get(downloadTask);
        return job != null && job.isActive();
    }

    public final void n(String str) {
        ULog.f6446a.a("DownloadManager", str);
    }

    public final void q(DownloadTask downloadTask, DownloadListener downloadListener) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new DownloadManager$onDownloadComplete$1(downloadTask, downloadListener, (Continuation<? super DownloadManager$onDownloadComplete$1>) null), 3, (Object) null);
    }

    public final Object r(String str, String str2, Continuation continuation) {
        return DownloadDb.f6469a.b(l()).f().a(str, str2, continuation);
    }

    public final DownloadTask s(String str, File file, boolean z, int i, long j, DownloadListener downloadListener) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(downloadListener, "downloadListener");
        DownloadTask downloadTask = new DownloadTask(str, file, z, i, j);
        b.w(downloadTask, downloadListener);
        return downloadTask;
    }

    public final void v(DownloadTask downloadTask, boolean z, DownloadListener downloadListener) {
        ConcurrentHashMap concurrentHashMap = c;
        Job job = (Job) concurrentHashMap.get(downloadTask);
        if (job == null || !job.isActive()) {
            NetworkUtils networkUtils = NetworkUtils.f7898a;
            if (!networkUtils.g()) {
                n("startDownload, hasNetwork=false, downloadTask: " + downloadTask);
                downloadListener.b(downloadTask, new NetworkNotAvailableException());
            } else if (!downloadTask.e() || networkUtils.i()) {
                if (z) {
                    d.put(downloadTask, 0);
                }
                concurrentHashMap.put(downloadTask, BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new DownloadManager$startDownloadInner$2(downloadTask, downloadListener, (Continuation<? super DownloadManager$startDownloadInner$2>) null), 3, (Object) null));
                n("startDownload: " + downloadTask);
            } else {
                n("startDownload, hasWifi=false, wifiRequired=true, downloadTask: " + downloadTask);
                downloadListener.b(downloadTask, new WifiRequiredException());
            }
        } else {
            DownloadManager downloadManager = b;
            downloadManager.n(downloadTask + " is running, return");
        }
    }

    public final void w(DownloadTask downloadTask, DownloadListener downloadListener) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new DownloadManager$startDownloadWithCheck$1(downloadTask, downloadListener, (Continuation<? super DownloadManager$startDownloadWithCheck$1>) null), 3, (Object) null);
    }
}
